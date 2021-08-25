package corgiaoc.byg;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import corgiaoc.byg.client.textures.renders.BYGCutoutRenders;
import corgiaoc.byg.common.entity.villager.BYGVillagerType;
import corgiaoc.byg.common.properties.BYGCreativeTab;
import corgiaoc.byg.common.properties.blocks.vanilla.ITreeSpawner;
import corgiaoc.byg.common.properties.vanilla.*;
import corgiaoc.byg.common.world.biome.*;
import corgiaoc.byg.common.world.dimension.end.BYGEndBiomeSource;
import corgiaoc.byg.common.world.dimension.nether.BYGNetherBiomeSource;
import corgiaoc.byg.config.WorldConfig;
import corgiaoc.byg.config.json.biomedata.BiomeDataHolders;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.world.BYGBiomes;
import corgiaoc.byg.entrypoint.EntryPoint;
import corgiaoc.byg.mixin.access.BlockEntityTypeAccess;
import corgiaoc.byg.mixin.access.ItemBlockRenderTypeAccess;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.behavior.WeightedList;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Set;

public class BYG {
    public static final String MOD_ID = "byg";
    public static final Logger LOGGER = LogManager.getLogger();

    public static boolean isClient = false;
    public static boolean isUsingMixin;
    public static String FILE_PATH = "yeet";
    public static Path CONFIG_PATH = null;
    public static EntryPoint entryPoint = null;
    public static WorldConfig worldConfig = null;
    public static final ResourceLocation EMPTY = new ResourceLocation("");

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

    public BYG() {
        File dir = new File(CONFIG_PATH.toString());
        if (!dir.exists())
            dir.mkdir();
    }

    public static void commonLoad() {
        LOGGER.debug("BYG: \"Common Setup\" Event Starting...");
        BYGCreativeTab.init();

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
        Registry.register(Registry.BIOME_SOURCE, new ResourceLocation(MOD_ID, "byg_nether"), BYGNetherBiomeSource.BYGNETHERCODEC);
        Registry.register(Registry.BIOME_SOURCE, new ResourceLocation(MOD_ID, "byg_end"), BYGEndBiomeSource.BYGENDCODEC);
        BYGVillagerType.setVillagerForBYGBiomes();
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        handleOverWorldConfig(gson);
        handleOverWorldSubConfig(gson);

        BlockEntityTypeAccess builderAccess = (BlockEntityTypeAccess)  BlockEntityType.CAMPFIRE;
        Set<Block> validBlocks = new ObjectOpenHashSet<>(builderAccess.getValidBlocks());
        validBlocks.add(BYGBlocks.CRYPTIC_CAMPFIRE);
        validBlocks.add(BYGBlocks.BORIC_CAMPFIRE);
        builderAccess.setValidBlocks(validBlocks);
    }

    public static BiomeDataHolders.EndBiomeDataHolder getEndData(Gson gson, Path biomesConfigPath) {
        BiomeDataHolders.EndBiomeDataHolder endBiomeDataHolder = BYGEndBiome.extractDefaultHolder(BuiltinRegistries.BIOME);

        File biomesConfigFile = biomesConfigPath.toFile();
        try {
            if (!biomesConfigFile.exists()) {
                DataResult<JsonElement> jsonElementDataResult = BiomeDataHolders.EndBiomeDataHolder.CODEC.encodeStart(JsonOps.INSTANCE, endBiomeDataHolder);
                Files.createDirectories(biomesConfigPath.getParent());
                Files.write(biomesConfigPath, gson.toJson(jsonElementDataResult.result().get()).getBytes());
            }
            Optional<Pair<BiomeDataHolders.EndBiomeDataHolder, JsonElement>> result = BiomeDataHolders.EndBiomeDataHolder.CODEC.decode(JsonOps.INSTANCE, new JsonParser().parse(new FileReader(biomesConfigFile))).result();
            if (result.isPresent()) {
                endBiomeDataHolder = result.get().getFirst();
            }

        } catch (IOException e) {
            LOGGER.error("Could not read \"" + biomesConfigPath.toString() + "\"... using internal defaults...");
            e.printStackTrace();
        }

        BYGBiomes.fillBiomeDictionary(endBiomeDataHolder.getEndBiomeData());
        BYGBiomes.fillBiomeDictionary(endBiomeDataHolder.getVoidBiomeData());
        return endBiomeDataHolder;
    }

    public static BiomeDataHolders.WeightedBiomeDataHolder getNetherData(Gson gson, Path biomesConfigPath) {
        BiomeDataHolders.WeightedBiomeDataHolder endWeightedBiomeDataHolder = BYGNetherBiome.extractDefaultHolder(BuiltinRegistries.BIOME);

        File biomesConfigFile = biomesConfigPath.toFile();
        try {
            if (!biomesConfigFile.exists()) {
                DataResult<JsonElement> jsonElementDataResult = BiomeDataHolders.WeightedBiomeDataHolder.CODEC.encodeStart(JsonOps.INSTANCE, endWeightedBiomeDataHolder);
                Files.createDirectories(biomesConfigPath.getParent());
                Files.write(biomesConfigPath, gson.toJson(jsonElementDataResult.result().get()).getBytes());
            }
            Optional<Pair<BiomeDataHolders.WeightedBiomeDataHolder, JsonElement>> result = BiomeDataHolders.WeightedBiomeDataHolder.CODEC.decode(JsonOps.INSTANCE, new JsonParser().parse(new FileReader(biomesConfigFile))).result();
            if (result.isPresent()) {
                endWeightedBiomeDataHolder = result.get().getFirst();
            }

        } catch (IOException e) {
            LOGGER.error("Could not read \"" + biomesConfigPath.toString() + "\"... using internal defaults...");
            e.printStackTrace();
        }

        BYGBiomes.fillBiomeDictionary(endWeightedBiomeDataHolder.getBiomeData());
        return endWeightedBiomeDataHolder;
    }


    public static BiomeDataHolders.EndSubBiomeDataHolder getEndSubBiomeData(Gson gson, Path biomesConfigPath) {
        BiomeDataHolders.EndSubBiomeDataHolder endBiomeDataHolder = BYGEndSubBiome.extractDefaultHolder(BuiltinRegistries.BIOME);

        File biomesConfigFile = biomesConfigPath.toFile();
        try {
            if (!biomesConfigFile.exists()) {
                DataResult<JsonElement> jsonElementDataResult = BiomeDataHolders.EndSubBiomeDataHolder.CODEC.encodeStart(JsonOps.INSTANCE, endBiomeDataHolder);
                Files.createDirectories(biomesConfigPath.getParent());
                Files.write(biomesConfigPath, gson.toJson(jsonElementDataResult.result().get()).getBytes());
            }
            Optional<Pair<BiomeDataHolders.EndSubBiomeDataHolder, JsonElement>> result = BiomeDataHolders.EndSubBiomeDataHolder.CODEC.decode(JsonOps.INSTANCE, new JsonParser().parse(new FileReader(biomesConfigFile))).result();
            if (result.isPresent()) {
                endBiomeDataHolder = result.get().getFirst();
            }

        } catch (IOException e) {
            LOGGER.error("Could not read \"" + biomesConfigPath.toString() + "\"... using internal defaults...");
            e.printStackTrace();
        }

        BYGBiomes.fillBiomeDictionary(endBiomeDataHolder.getEndSubBiomeData());
        BYGBiomes.fillBiomeDictionary(endBiomeDataHolder.getVoidSubBiomeData());
        return endBiomeDataHolder;
    }

    private static void handleOverWorldConfig(Gson gson) {
        BiomeDataHolders.OverworldPrimaryBiomeDataHolder overworldPrimaryBiomeDataHolder = BYGBiome.extractDefaultHolder();
        Path biomesConfigPath = CONFIG_PATH.resolve(BYG.MOD_ID + "-biomes.json");

        File biomesConfigFile = biomesConfigPath.toFile();
        try {
            if (!biomesConfigFile.exists()) {
                DataResult<JsonElement> jsonElementDataResult = BiomeDataHolders.OverworldPrimaryBiomeDataHolder.CODEC.encodeStart(JsonOps.INSTANCE, overworldPrimaryBiomeDataHolder);
                Files.createDirectories(biomesConfigPath.getParent());
                Files.write(biomesConfigPath, gson.toJson(jsonElementDataResult.result().get()).getBytes());
            }
            Optional<Pair<BiomeDataHolders.OverworldPrimaryBiomeDataHolder, JsonElement>> result = BiomeDataHolders.OverworldPrimaryBiomeDataHolder.CODEC.decode(JsonOps.INSTANCE, new JsonParser().parse(new FileReader(biomesConfigFile))).result();
            if (result.isPresent()) {
              overworldPrimaryBiomeDataHolder = result.get().getFirst();
            }

        } catch (IOException e) {
            LOGGER.error("Could not read \"" + biomesConfigPath.toString() + "\"... using internal defaults...");
            e.printStackTrace();
        }
        overworldPrimaryBiomeDataHolder.getBiomeData().forEach(((location, primaryBiomeData) -> {
            ResourceLocation river = primaryBiomeData.getRiver();
            if (!river.equals(EMPTY)) {
                BYGBiome.BIOME_TO_RIVER_LIST.put(location, river);
            }
            ResourceLocation beach = primaryBiomeData.getBeach();
            if (!beach.equals(EMPTY)) {
                BYGBiome.BIOME_TO_BEACH_LIST.put(location, beach);
            }
            ResourceLocation edgeBiome = primaryBiomeData.getEdgeBiome();
            if (!edgeBiome.equals(EMPTY)) {
                BYGBiome.BIOME_TO_EDGE_LIST.put(location, edgeBiome);
            }
            WeightedList<ResourceLocation> subBiomes = primaryBiomeData.getSubBiomes();
            BYGBiome.BIOME_TO_HILLS_LIST.put(location, subBiomes);
        }));
        

        BYGBiomes.handleOverworldEntries(overworldPrimaryBiomeDataHolder);
    }

    private static void handleOverWorldSubConfig(Gson gson) {
        BiomeDataHolders.OverworldSubBiomeDataHolder overworldSubBiomeDataHolder = BYGSubBiome.extractDefaultHolder();
        Path biomesConfigPath = CONFIG_PATH.resolve(BYG.MOD_ID + "-sub-biomes.json");

        File biomesConfigFile = biomesConfigPath.toFile();
        try {
            if (!biomesConfigFile.exists()) {
                DataResult<JsonElement> jsonElementDataResult = BiomeDataHolders.OverworldSubBiomeDataHolder.CODEC.encodeStart(JsonOps.INSTANCE, overworldSubBiomeDataHolder);
                Files.createDirectories(biomesConfigPath.getParent());
                Files.write(biomesConfigPath, gson.toJson(jsonElementDataResult.result().get()).getBytes());
            }
            Optional<Pair<BiomeDataHolders.OverworldSubBiomeDataHolder, JsonElement>> result = BiomeDataHolders.OverworldSubBiomeDataHolder.CODEC.decode(JsonOps.INSTANCE, new JsonParser().parse(new FileReader(biomesConfigFile))).result();
            if (result.isPresent()) {
                overworldSubBiomeDataHolder = result.get().getFirst();
            }

        } catch (IOException e) {
            LOGGER.error("Could not read \"" + biomesConfigPath.toString() + "\"... using internal defaults...");
            e.printStackTrace();
        }

        overworldSubBiomeDataHolder.getBiomeData().forEach(((location, subBiomeData) -> {
            ResourceLocation river = subBiomeData.getRiver();
            if (!river.equals(EMPTY) ) {
                BYGBiome.BIOME_TO_RIVER_LIST.put(location, river);
            }
            ResourceLocation beach = subBiomeData.getBeach();
            if (!beach.equals(EMPTY) ) {
                BYGBiome.BIOME_TO_BEACH_LIST.put(location, beach);
            }
            ResourceLocation edgeBiome = subBiomeData.getEdgeBiome();
            if (!edgeBiome.equals(EMPTY)) {
                BYGBiome.BIOME_TO_EDGE_LIST.put(location, edgeBiome);
            }
        }));

        BYGBiomes.fillBiomeDictionary(overworldSubBiomeDataHolder.getBiomeData());
    }

    public static void clientLoad() {
        isClient = true;
        LOGGER.debug("BYG: \"Client Setup\" Event Starting...");
        BYGCutoutRenders.renderCutOuts(ItemBlockRenderTypeAccess.getTypeByBlock());
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