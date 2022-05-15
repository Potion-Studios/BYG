package potionstudios.byg;


import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.Util;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraft.world.level.material.Material;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import potionstudios.byg.common.*;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.block.sapling.SaplingPatterns;
import potionstudios.byg.common.entity.ai.village.poi.BYGPoiTypes;
import potionstudios.byg.common.entity.npc.TradesConfig;
import potionstudios.byg.common.entity.villager.BYGVillagerType;
import potionstudios.byg.common.item.BYGItems;
import potionstudios.byg.common.world.biome.end.EndBiomesConfig;
import potionstudios.byg.common.world.biome.nether.NetherBiomesConfig;
import potionstudios.byg.common.world.structure.BYGStructureFeature;
import potionstudios.byg.common.world.structure.WithGenerationStep;
import potionstudios.byg.common.world.surfacerules.SurfaceRulesConfig;
import potionstudios.byg.config.ConfigVersionTracker;
import potionstudios.byg.config.SettingsConfig;
import potionstudios.byg.config.json.BiomeDictionaryConfig;
import potionstudios.byg.config.json.OverworldBiomeConfig;
import potionstudios.byg.data.BYGDataProviders;
import potionstudios.byg.mixin.access.*;
import potionstudios.byg.reg.RegistryObject;
import potionstudios.byg.server.command.ReloadConfigsCommand;
import potionstudios.byg.server.command.UpdateConfigsCommand;
import potionstudios.byg.server.command.WorldGenExportCommand;
import potionstudios.byg.util.CommonSetupLoad;
import potionstudios.byg.util.FileUtils;
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

    public static void loadFuels(final FuelConsumer consumer) {
        consumer.add(BYGItems.LIGNITE_BLOCK.get(), 14000);
        consumer.add(BYGItems.LIGNITE.get(), 1400);
        consumer.add(BYGItems.ANTHRACITE_BLOCK.get(), 20000);
        consumer.add(BYGItems.ANTHRACITE.get(), 2400);
        consumer.add(BYGItems.PEAT.get(), 1200);
    }

    @FunctionalInterface
    public interface FuelConsumer {
        void add(Item item, int value);
    }

    public static void attachCommands(final CommandDispatcher<CommandSourceStack> dispatcher, final Commands.CommandSelection environmentType) {
        WorldGenExportCommand.worldGenExportCommand(dispatcher);
        LiteralArgumentBuilder<CommandSourceStack> bygCommands = Commands.literal(BYG.MOD_ID).requires(commandSource -> commandSource.hasPermission(3));
        bygCommands.then(ReloadConfigsCommand.register());
        bygCommands.then(UpdateConfigsCommand.register());
        dispatcher.register(bygCommands);
    }

    private static void handleConfigs() {
        CommonSetupLoad.ENTRIES.forEach(c -> c.get().load());
        makeREADME();
        EndBiomesConfig.getConfig();
        NetherBiomesConfig.getConfig();
        SettingsConfig.getConfig();
    }

    private static void makeREADME() {
        try {
            Path configPath = ModPlatform.INSTANCE.configPath();
            Files.createDirectories(configPath);
            Files.write(configPath.resolve("README.txt"), "For information on how BYG configs work, you can find that here: https://github.com/AOCAWOL/BYG/wiki/Configs".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        loadAllConfigs(false, false);
        FileUtils.backUpDirectory(ModPlatform.INSTANCE.configPath(), "last_working_configs_backup");
        LOGGER.info("BYG: \"Load Complete\" Event Complete!");
    }

    public static void loadAllConfigs(boolean serialize, boolean recreate) {
        EndBiomesConfig.getConfig(serialize, recreate, null);
        NetherBiomesConfig.getConfig(serialize, recreate, null);
        OverworldBiomeConfig.getConfig(serialize, recreate);
        BiomeDictionaryConfig.getConfig(serialize, recreate);
        SurfaceRulesConfig.getConfig(serialize, recreate);
        SaplingPatterns.getConfig(serialize, recreate);
        TradesConfig.getConfig(serialize, recreate);
        SettingsConfig.getConfig(serialize, recreate);
        makeREADME();
    }

    public static ResourceLocation createLocation(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    static {
        ConfigVersionTracker.getConfig(new ConfigVersionTracker(ModPlatform.INSTANCE.configPath().toFile().exists() ? 0 : BYGConstants.CONFIG_VERSION), false);
    }
}