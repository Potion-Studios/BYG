package potionstudios.byg;


import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import potionstudios.byg.client.textures.renders.BYGCutoutRenders;
import potionstudios.byg.common.*;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.block.vanilla.ITreeSpawner;
import potionstudios.byg.common.entity.villager.BYGVillagerType;
import potionstudios.byg.common.world.biome.BYGBiomes;
import potionstudios.byg.config.WorldConfig;
import potionstudios.byg.config.json.BYGConfigHandler;
import potionstudios.byg.mixin.access.BlockEntityTypeAccess;
import potionstudios.byg.mixin.access.ItemBlockRenderTypeAccess;
import potionstudios.byg.util.BiomeKeyUtil;

import java.nio.file.Path;
import java.util.Set;

public class BYG {
    public static final String MOD_ID = "byg";
    public static final Logger LOGGER = LogManager.getLogger();

    public static boolean isClient = false;
    public static boolean isUsingMixin;
    public static String FILE_PATH = "yeet";
    public static Path CONFIG_PATH = null;
    public static WorldConfig worldConfig = null;
    public static final ResourceKey<Biome> EMPTY = BiomeKeyUtil.EMPTY;

    public static Registry<Biome> biomeRegistryAccess = null;

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

    public static void init(Path path) {
        CONFIG_PATH = path;
    }

    public static void commonLoad() {
        LOGGER.debug("BYG: \"Common Setup\" Event Starting...");

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
//        Registry.register(Registry.BIOME_SOURCE, new ResourceLocation(MOD_ID, "byg_nether"), BYGNetherBiomeSource.BYGNETHERCODEC);
//        Registry.register(Registry.BIOME_SOURCE, new ResourceLocation(MOD_ID, "byg_end"), BYGEndBiomeSource.BYGENDCODEC);
        BYGVillagerType.setVillagerForBYGBiomes();
        BlockEntityTypeAccess builderAccess = (BlockEntityTypeAccess) BlockEntityType.CAMPFIRE;
        Set<Block> validBlocks = new ObjectOpenHashSet<>(builderAccess.getValidBlocks());
        validBlocks.add(BYGBlocks.CRYPTIC_CAMPFIRE);
        validBlocks.add(BYGBlocks.BORIC_CAMPFIRE);
        builderAccess.setValidBlocks(validBlocks);
        BYGBiomes.handleOverworldEntries();
        BYGConfigHandler.fillBiomeDictionary(CONFIG_PATH);
    }

    public static void clientLoad() {
        isClient = true;
        LOGGER.debug("BYG: \"Client Setup\" Event Starting...");
        BYGCutoutRenders.renderCutOuts(ItemBlockRenderTypeAccess.getTypeByBlock());
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