package corgiaoc.byg;


import corgiaoc.byg.client.textures.renders.BYGCutoutRenders;
import corgiaoc.byg.common.entity.boat.BYGBoatRenderer;
import corgiaoc.byg.common.entity.villager.BYGVillagerType;
import corgiaoc.byg.common.properties.BYGCreativeTab;
import corgiaoc.byg.common.properties.blocks.vanilla.ITreeSpawner;
import corgiaoc.byg.common.properties.vanilla.*;
import corgiaoc.byg.common.world.dimension.end.BYGEndBiomeSource;
import corgiaoc.byg.common.world.dimension.nether.BYGNetherBiomeSource;
import corgiaoc.byg.config.WorldConfig;
import corgiaoc.byg.config.json.BYGJsonConfigHandler;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.BYGEntities;
import corgiaoc.byg.core.world.BYGBiomes;
import corgiaoc.byg.entrypoint.EntryPoint;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.nio.file.Path;

public class BYG {
    public static final String MOD_ID = "byg";
    public static boolean isClient = false;
    public static Logger LOGGER = LogManager.getLogger();
    public static boolean isUsingMixin;
    public static String FILE_PATH = "yeet";

    public static Path CONFIG_PATH = null;

    public static EntryPoint entryPoint = null;

    public static WorldConfig worldConfig = null;

    public static WorldConfig worldConfig(boolean refreshConfig) {
        if (worldConfig == null || refreshConfig) {
            worldConfig = new WorldConfig(CONFIG_PATH.resolve("byg-world.toml"));
        }
        return worldConfig;
    }

    public static WorldConfig worldConfig() {
        return worldConfig(false);
    }

    public static boolean ENABLE_OVERWORLD_TREES = true;
    public static boolean ENABLE_CACTI = true;
    public static boolean ENABLE_NYLIUM_FUNGI = true;
    public static boolean ENABLE_NETHER_MUSHROOMS = true;

    public BYG() {
        File dir = new File(CONFIG_PATH.toString());
        if (!dir.exists())
            dir.mkdir();
    }

    public static void commonLoad() {
        LOGGER.debug("BYG: \"Common Setup\" Event Starting...");
        BYGCreativeTab.init();
        BYGJsonConfigHandler.handleOverWorldConfig(CONFIG_PATH);

        for (Block block : Registry.BLOCK) {
            if (block instanceof ITreeSpawner) {
                if (ITreeSpawner.VANILLA_SAPLING_BYG_TREE_SPAWNERS.containsKey(block)) {
                    ((ITreeSpawner) block).setTreeSpawner(ITreeSpawner.VANILLA_SAPLING_BYG_TREE_SPAWNERS.get(block));
                }
            }
        }
        LOGGER.info("BYG: \"Common Setup\" Event Complete!");
    }

    public static void threadSafeCommonLoad() {
        Registry.register(Registry.BIOME_SOURCE, new ResourceLocation(MOD_ID, "bygnether"), BYGNetherBiomeSource.BYGNETHERCODEC);
        Registry.register(Registry.BIOME_SOURCE, new ResourceLocation(MOD_ID, "bygend"), BYGEndBiomeSource.BYGENDCODEC);
        BYGVillagerType.setVillagerForBYGBiomes();
        BYGBiomes.addBiomeEntries();
        BYGBiomes.fillBiomeDictionary();
    }

    public static void clientLoad() {
        isClient = true;
        LOGGER.debug("BYG: \"Client Setup\" Event Starting...");
        BYGCutoutRenders.renderCutOuts();
        RenderingRegistry.registerEntityRenderingHandler(BYGEntities.BOAT, BYGBoatRenderer::new);
        LOGGER.info("BYG: \"Client Setup\" Event Complete!");
    }

    public static void threadSafeLoadFinish() {
        LOGGER.debug("BYG: \"Load Complete Event\" Starting...");
        BYGCompostables.compostablesBYG();
        BYGHoeables.hoeablesBYG();
        BYGFlammables.flammablesBYG();
        BYGStrippables.strippableLogsBYG();
        BYGCarvableBlocks.addCarverBlocks();
        BYGPaths.addBYGPaths();
        cleanMemory();
        LOGGER.info("BYG: \"Load Complete\" Event Complete!");
    }

    //Minimize BYG's ram footprint.
    private static void cleanMemory() {
        BYG.LOGGER.debug("Cleaning memory...");
        BYGBlocks.flowerPotBlocks = null;
        FILE_PATH = null;
        BYG.LOGGER.debug("Cleaned memory!");
    }
}