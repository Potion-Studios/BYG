package potionstudios.byg;


import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraft.world.level.material.Material;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import potionstudios.byg.common.*;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.entity.ai.village.poi.BYGPoiTypes;
import potionstudios.byg.common.entity.villager.BYGVillagerType;
import potionstudios.byg.common.world.biome.end.EndBiomesConfig;
import potionstudios.byg.common.world.biome.nether.NetherBiomesConfig;
import potionstudios.byg.common.world.structure.BYGStructureFeature;
import potionstudios.byg.common.world.structure.WithGenerationStep;
import potionstudios.byg.config.SettingsConfig;
import potionstudios.byg.data.BYGDataProviders;
import potionstudios.byg.mixin.access.*;
import potionstudios.byg.registration.RegistryObject;
import potionstudios.byg.util.CommonSetupLoad;
import potionstudios.byg.util.ModPlatform;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Set;

public class BYG {

    public static final String MOD_ID = "byg";
    public static final Logger LOGGER = LogManager.getLogger();
    public static boolean INITIALIZED;

    public static void commonLoad() {
        LOGGER.debug("BYG: \"Common Setup\" Event Starting...");
        handleConfigs();

        for (WorldCarver<?> worldCarver : Registry.CARVER) {
            WorldCarverAccess carverAccess = (WorldCarverAccess) worldCarver;
            carverAccess.setReplaceableBlocks(new ImmutableSet.Builder<Block>().addAll(BYGCarvableBlocks.addCarverBlocks().get())
                    .addAll(carverAccess.byg_getReplaceableBlocks()).build());
        }
        LOGGER.info("BYG: \"Common Setup\" Event Complete!");

        PoiTypeAccess.byg_invokeRegisterBlockStates(BYGPoiTypes.FORAGER.get());

        BYGStructureFeature.PROVIDER.getEntries()
            .stream()
            .map(RegistryObject::get)
            .filter(WithGenerationStep.class::isInstance)
            .forEach(f -> StructureFeatureAccess.byg_getSTEP().put(f, ((WithGenerationStep) f).getDecoration()));
    }

    private static void handleConfigs() {
        CommonSetupLoad.ENTRIES.forEach(c -> c.get().load());
        try {
            Path configPath = ModPlatform.INSTANCE.configPath();
            Files.createDirectories(configPath);
            Files.write(configPath.resolve("README.txt"), "For information on how BYG configs work, you can find that here: https://github.com/AOCAWOL/BYG/wiki/Configs".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        EndBiomesConfig.getConfig(true);
        NetherBiomesConfig.getConfig(true);
        SettingsConfig.getConfig(true);
    }

    public static void threadSafeCommonLoad() {
        if (BYGConstants.GENERATE_DATA) {
            BYGDataProviders.generateProviders();
        }
        BYGVillagerType.setVillagerForBYGBiomes();
        BlockEntityTypeAccess builderAccess = (BlockEntityTypeAccess) BlockEntityType.CAMPFIRE;
        Set<Block> validBlocks = new ObjectOpenHashSet<>(builderAccess.byg_getValidBlocks());
        validBlocks.add(BYGBlocks.CRYPTIC_CAMPFIRE.get());
        validBlocks.add(BYGBlocks.BORIC_CAMPFIRE.get());
        builderAccess.byg_setValidBlocks(validBlocks);
        DeltaFeatureAccess.byg_setCANNOT_REPLACE(
            new ImmutableList.Builder<Block>()
                .addAll(DeltaFeatureAccess.byg_getCANNOT_REPLACE())
                .add(BYGBlocks.EMBUR_GEL_BLOCK.get())
                .add(BYGBlocks.EMBUR_GEL_BRANCH.get())
                .add(BYGBlocks.EMBUR_GEL_VINES.get())
                .addAll(Util.make(new ArrayList<>(), list -> {
                    for (Block block : Registry.BLOCK) {
                        Material material = block.defaultBlockState().getMaterial();
                        if (material == Material.PLANT || material == Material.BAMBOO ||
                            material == Material.BAMBOO_SAPLING || material == Material.REPLACEABLE_PLANT ||
                            material == Material.REPLACEABLE_FIREPROOF_PLANT || material == Material.REPLACEABLE_WATER_PLANT ||
                            material == Material.LEAVES || material == Material.WOOD || material == Material.GRASS) {
                            list.add(block);
                        }
                    }
                }))
                .build()
        );
    }

    public static void threadSafeLoadFinish() {
        LOGGER.debug("BYG: \"Load Complete Event\" Starting...");
        BYGCompostables.compostablesBYG();
        BYGHoeables.tillablesBYG();
        BYGFlammables.flammablesBYG();
        BYGStrippables.strippableLogsBYG();
        BYGCarvableBlocks.addCarverBlocks();
        BYGFlattenables.addFlattenables();
        LOGGER.info("BYG: \"Load Complete\" Event Complete!");
    }

    public static ResourceLocation createLocation(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}