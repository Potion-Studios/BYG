package potionstudios.byg;


import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraft.world.level.material.Material;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import potionstudios.byg.client.BiomepediaClientData;
import potionstudios.byg.common.*;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.entity.villager.BYGVillagerType;
import potionstudios.byg.common.world.biome.end.EndBiomesConfig;
import potionstudios.byg.common.world.biome.nether.NetherBiomesConfig;
import potionstudios.byg.config.BYGConfig;
import potionstudios.byg.config.WorldConfig;
import potionstudios.byg.data.BYGDataProviders;
import potionstudios.byg.mixin.access.BlockEntityTypeAccess;
import potionstudios.byg.mixin.access.DeltaFeatureAccess;
import potionstudios.byg.mixin.access.WorldCarverAccess;
import potionstudios.byg.util.CommonSetupLoad;
import potionstudios.byg.util.LangFileGenerator;
import potionstudios.byg.util.MLBlockTags;
import potionstudios.byg.util.ModLoaderContext;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Set;

public class BYG {
    public static final String MOD_ID = "byg";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final boolean BIOMES = true;
    public static final boolean WARN_EXPERIMENTAL = false;
    public static final int EXPERIMENTAL_WARNING_VERSION = 5;
    public static final boolean DEV_ENVIRONMENT = Boolean.parseBoolean(System.getProperty("bygDev", "false"));
    public static final boolean GENERATE_DATA = Boolean.parseBoolean(System.getProperty("bygGenerateData", "false"));
    public static boolean ENABLE_OVERWORLD_TREES = true;
    public static boolean ENABLE_CACTI = true;
    public static boolean ENABLE_NYLIUM_FUNGI = true;
    public static boolean ENABLE_NETHER_MUSHROOMS = true;
    public static Path CONFIG_PATH = null;
    public static String MOD_LOADER_TAG_TARGET = null;
    public static ModLoaderContext MODLOADER_DATA = null;
    public static final SurfaceRules.RuleSource EMPTY = SurfaceRules.ifTrue(SurfaceRules.isBiome(ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("empty", "empty"))), SurfaceRules.state(Blocks.DIRT.defaultBlockState()));

    public static void init(Path path, String modloaderTagTarget) {
        CONFIG_PATH = path;
        MOD_LOADER_TAG_TARGET = modloaderTagTarget;
        MLBlockTags.bootStrap();
    }

    public static void commonLoad() {
        LOGGER.debug("BYG: \"Common Setup\" Event Starting...");
        handleConfigs();

        for (WorldCarver<?> worldCarver : Registry.CARVER) {
            WorldCarverAccess carverAccess = (WorldCarverAccess) worldCarver;
            carverAccess.setReplaceableBlocks(new ImmutableSet.Builder<Block>().addAll(BYGCarvableBlocks.addCarverBlocks()).addAll(carverAccess.byg_getReplaceableBlocks()).build());
        }
        LOGGER.info("BYG: \"Common Setup\" Event Complete!");
    }

    private static void handleConfigs() {
        CommonSetupLoad.ENTRIES.forEach(CommonSetupLoad::load);
        try {
            Files.createDirectories(CONFIG_PATH);
            Files.write(CONFIG_PATH.resolve("README.txt"), "For information on how BYG configs work, you can find that here: https://github.com/AOCAWOL/BYG/wiki/Configs".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        EndBiomesConfig.getConfig(true);
        NetherBiomesConfig.getConfig(true);
        BYGConfig.getConfig(true);
        WorldConfig.worldConfig(true);
    }

    public static void threadSafeCommonLoad() {
        if (GENERATE_DATA) {
            BYGDataProviders.generateProviders();
        }
        BYGVillagerType.setVillagerForBYGBiomes();
        BlockEntityTypeAccess builderAccess = (BlockEntityTypeAccess) BlockEntityType.CAMPFIRE;
        Set<Block> validBlocks = new ObjectOpenHashSet<>(builderAccess.byg_getValidBlocks());
        validBlocks.add(BYGBlocks.CRYPTIC_CAMPFIRE);
        validBlocks.add(BYGBlocks.BORIC_CAMPFIRE);
        builderAccess.byg_setValidBlocks(validBlocks);
        DeltaFeatureAccess.byg_setCANNOT_REPLACE(
            new ImmutableList.Builder<Block>()
                .addAll(DeltaFeatureAccess.byg_getCANNOT_REPLACE())
                .add(BYGBlocks.EMBUR_GEL_BLOCK)
                .add(BYGBlocks.EMBUR_GEL_BRANCH)
                .add(BYGBlocks.EMBUR_GEL_VINES)
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

    public static void clientLoad() {
        LOGGER.debug("BYG: \"Client Setup\" Event Starting...");
        BiomepediaClientData.getConfig(true);
        if (GENERATE_DATA) {
            LangFileGenerator.createLangFile(Paths.get("generated/en_us.json"));
        }

//        EntityRendererRegistry.register(BYGEntities.MAN_O_WAR, ManOWarRenderer::new);
        LOGGER.info("BYG: \"Client Setup\" Event Complete!");
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