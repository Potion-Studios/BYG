package potionstudios.byg;


import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import potionstudios.byg.common.*;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.entity.villager.BYGVillagerType;
import potionstudios.byg.config.WorldConfig;
import potionstudios.byg.mixin.access.BlockEntityTypeAccess;
import potionstudios.byg.util.BYGUtil;
import potionstudios.byg.util.MLBlockTags;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

public class BYG {
    public static final String MOD_ID = "byg";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final boolean BIOMES = true;
    public static final boolean WARN_EXPERIMENTAL = true;
    public static final int EXPERIMENTAL_WARNING_VERSION = 2;

    public static boolean isClient = false;
    public static boolean isUsingMixin;
    public static String FILE_PATH = "yeet";
    public static Path CONFIG_PATH = null;
    public static String MOD_LOADER_TAG_TARGET = null;
    public static WorldConfig worldConfig = null;
    public static final ResourceKey<Biome> EMPTY = BYGUtil.EMPTY;

    public static Registry<Biome> biomeRegistryAccess = null;

    public static WorldConfig worldConfig(boolean refreshConfig) {
        if (worldConfig == null || refreshConfig) {
            worldConfig = new WorldConfig(CONFIG_PATH.resolve("world.toml"));
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

    public static void init(Path path, String modloaderTagTarget) {
        CONFIG_PATH = path;
        MOD_LOADER_TAG_TARGET = modloaderTagTarget;
        MLBlockTags.bootStrap();
    }

    public static void commonLoad() {
        LOGGER.debug("BYG: \"Common Setup\" Event Starting...");

        try {
            Files.createDirectories(CONFIG_PATH);
            Files.write(CONFIG_PATH.resolve("README.txt"), "For information on how BYG configs work, you can find that here: https://github.com/AOCAWOL/BYG/wiki/Configs".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.info("BYG: \"Common Setup\" Event Complete!");
    }

    public static void threadSafeCommonLoad() {
//        Registry.register(Registry.BIOME_SOURCE, new ResourceLocation(MOD_ID, "byg_nether"), BYGNetherBiomeSource.BYGNETHERCODEC);
//        Registry.register(Registry.BIOME_SOURCE, new ResourceLocation(MOD_ID, "byg_end"), BYGEndBiomeSource.BYGENDCODEC);
        BYGVillagerType.setVillagerForBYGBiomes();
        BlockEntityTypeAccess builderAccess = (BlockEntityTypeAccess) BlockEntityType.CAMPFIRE;
        Set<Block> validBlocks = new ObjectOpenHashSet<>(builderAccess.getValidBlocks());
        validBlocks.add(BYGBlocks.CRYPTIC_CAMPFIRE);
        validBlocks.add(BYGBlocks.BORIC_CAMPFIRE);
        builderAccess.setValidBlocks(validBlocks);
    }

    public static void clientLoad() {
        isClient = true;
        LOGGER.debug("BYG: \"Client Setup\" Event Starting...");
//        EntityRendererRegistry.register(BYGEntities.MAN_O_WAR, ManOWarRenderer::new);
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
        LOGGER.info("BYG: \"Load Complete\" Event Complete!");
    }
}