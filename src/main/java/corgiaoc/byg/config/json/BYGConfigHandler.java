package corgiaoc.byg.config.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import corgiaoc.byg.BYG;
import corgiaoc.byg.config.BYGBiomeWorldProperties;
import corgiaoc.byg.config.json.biomedata.BiomeDataHolders;
import corgiaoc.byg.config.json.biomedata.BiomeDataListHolder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class BYGConfigHandler {

    private BYGConfigHandler(){}

    public static void handleAll(Path path) {
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        processAndGet(gson, path.resolve("byg-biomes.json"), BYGBiomeWorldProperties.OVERWORLD_DEFAULTS, BiomeDataHolders.OverworldPrimaryBiomeDataHolder.CODEC);
        processAndGet(gson, path.resolve("byg-sub-biomes.json"), BYGBiomeWorldProperties.OVERWORLD_SUB_DEFAULTS, BiomeDataHolders.OverworldSubBiomeDataHolder.CODEC);
        processAndGet(gson, path.resolve("byg-nether-biomes.json"), BYGBiomeWorldProperties.NETHER_DEFAULTS, BiomeDataHolders.WeightedBiomeDataHolder.CODEC);
        processAndGet(gson, path.resolve("byg-end-biomes.json"), BYGBiomeWorldProperties.END_DEFAULTS, BiomeDataHolders.EndBiomeDataHolder.CODEC);
        createReadMe(path.resolve("README.txt"));
    }

    public static <T extends BiomeDataListHolder<?>> T processAndGet(Gson gson, Path path, T defaultValue, Codec<T> codec) {
        if (!path.toFile().exists()) {
            try {
                Files.createDirectories(path.getParent());
                BufferedWriter writer = Files.newBufferedWriter(path);
                gson.toJson(codec.encodeStart(JsonOps.INSTANCE, defaultValue).getOrThrow(false, IllegalArgumentException::new), writer);
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            JsonParser jsonReader = new JsonParser();
            Optional<Pair<T, JsonElement>> possibleResult = codec.decode(JsonOps.INSTANCE, jsonReader.parse(new BufferedReader(new FileReader(path.toFile())))).result();
            if (possibleResult.isEmpty()) {
                BYG.LOGGER.warn(path.toAbsolutePath() + " could not be read.");
                return defaultValue;
            }
            T first = possibleResult.get().getFirst();
            uploadBiomeDictionary(first);
            return first;
        } catch (FileNotFoundException e) {
            BYG.LOGGER.warn(path.toAbsolutePath() + " was not found." + e);
            uploadBiomeDictionary(defaultValue);
            return defaultValue;
        }
    }

    public static void uploadBiomeDictionary(BiomeDataListHolder<?> result) {
        result.getBiomeDictionary().forEach(resourceKeyPair -> {
            // FORGE: Upload values to biome dictionary
        });
    }

    public static void createReadMe(Path path) {
        File readmeFile = new File(String.valueOf(path));
        String text = "If you need help understanding what the byg-biomes or byg-sub-biomes configs allow you to do, please watch this video: https://youtu.be/iq0q09O7ZYo\n\nIf you need help with datapacking, please watch this: https://youtu.be/TF_p8OeB-hc";
        if (!readmeFile.exists()) {
            try {
                Files.write(path, text.getBytes());
            } catch (IOException e) {
                BYG.LOGGER.error(BYG.MOD_ID + "'s README.txt could not be created");
            }
        }
    }
}