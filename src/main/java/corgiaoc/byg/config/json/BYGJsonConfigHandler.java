package corgiaoc.byg.config.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.biome.BYGBiome;
import corgiaoc.byg.common.world.biome.BYGSubBiome;
import corgiaoc.byg.config.json.biomedata.BiomeDataListHolder;
import corgiaoc.byg.config.json.biomedata.BiomeDataListHolderSerializer;
import corgiaoc.byg.config.json.subbiomedata.SubBiomeDataListHolder;
import corgiaoc.byg.config.json.subbiomedata.SubBiomeDataListHolderSerializer;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

public class BYGJsonConfigHandler {

    public static void handleBYGBiomesJSONConfig(Path path) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(BiomeDataListHolder.class, new BiomeDataListHolderSerializer());
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.disableHtmlEscaping();
        Gson gson = gsonBuilder.create();

        final File CONFIG_FILE = new File(String.valueOf(path));

        if (!CONFIG_FILE.exists()) {
            BiomeDataListHolder.createDefaults();
            createBYGBiomesJson(path);
        }
        try (Reader reader = new FileReader(path.toString())) {
            BiomeDataListHolder biomeDataListHolder = gson.fromJson(reader, BiomeDataListHolder.class);
            if (biomeDataListHolder != null)
                BYGBiome.biomeData = biomeDataListHolder.getBiomeData();
            else
                BYG.LOGGER.error(BYG.MOD_ID + "-biomes.json could not be read");

        } catch (IOException e) {
            BYG.LOGGER.error(BYG.MOD_ID + "-biomes.json could not be read");
        }
    }

    public static void createBYGBiomesJson(Path path) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(BiomeDataListHolder.class, new BiomeDataListHolderSerializer());
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.disableHtmlEscaping();
        Gson gson = gsonBuilder.create();

        String jsonString = gson.toJson(new BiomeDataListHolder(BYGBiome.biomeData));

        try {
            Files.write(path, jsonString.getBytes());
        } catch (IOException e) {
            BYG.LOGGER.error(BYG.MOD_ID + "-biomes.json could not be created");
        }
    }


    public static void handleBYGSubBiomesJSONConfig(Path path) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(SubBiomeDataListHolder.class, new SubBiomeDataListHolderSerializer());
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.disableHtmlEscaping();
        Gson gson = gsonBuilder.create();

        final File CONFIG_FILE = new File(String.valueOf(path));

        if (!CONFIG_FILE.exists()) {
            SubBiomeDataListHolder.createDefaults();
            createBYGSubBiomesJson(path);
        }
        try (Reader reader = new FileReader(path.toString())) {
            SubBiomeDataListHolder biomeDataListHolder = gson.fromJson(reader, SubBiomeDataListHolder.class);
            if (biomeDataListHolder != null)
                BYGSubBiome.subBiomeData = biomeDataListHolder.getSubBiomeData();
            else
                BYG.LOGGER.error(BYG.MOD_ID + "-sub-biomes.json could not be read");

        } catch (IOException e) {
            BYG.LOGGER.error(BYG.MOD_ID + "-sub-biomes.json could not be read");
        }
    }

    public static void createBYGSubBiomesJson(Path path) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(SubBiomeDataListHolder.class, new SubBiomeDataListHolderSerializer());
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.disableHtmlEscaping();
        Gson gson = gsonBuilder.create();

        String jsonString = gson.toJson(new SubBiomeDataListHolder(BYGSubBiome.subBiomeData));

        try {
            Files.write(path, jsonString.getBytes());
        } catch (IOException e) {
            BYG.LOGGER.error(BYG.MOD_ID + "-sub-biomes.json could not be created");
        }
    }


    public static void createReadMe(Path path) {
        final File README_FILE = new File(String.valueOf(path));
        String text = "If you need help understanding what the byg-biomes or byg-sub-biomes configs allow you to do, please watch this video: https://youtu.be/iq0q09O7ZYo";
        if (!README_FILE.exists()) {
            try {
                Files.write(path, text.getBytes());
            } catch (IOException e) {
                BYG.LOGGER.error(BYG.MOD_ID + "'s README.txt could not be created");
            }
        }
    }
}