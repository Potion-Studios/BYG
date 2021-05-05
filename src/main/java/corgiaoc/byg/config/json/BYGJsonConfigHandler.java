package corgiaoc.byg.config.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.biome.BYGBiome;
import corgiaoc.byg.common.world.biome.BYGEndBiome;
import corgiaoc.byg.common.world.biome.BYGEndSubBiome;
import corgiaoc.byg.common.world.biome.BYGSubBiome;
import corgiaoc.byg.config.json.biomedata.BiomeDataListHolder;
import corgiaoc.byg.config.json.biomedata.BiomeDataListHolderSerializer;
import corgiaoc.byg.config.json.endbiomedata.EndBiomeDataListHolder;
import corgiaoc.byg.config.json.endbiomedata.EndBiomeDataListHolderSerializer;
import corgiaoc.byg.config.json.endbiomedata.sub.EndSubBiomeDataListHolder;
import corgiaoc.byg.config.json.endbiomedata.sub.EndSubBiomeDataListHolderSerializer;
import corgiaoc.byg.config.json.subbiomedata.SubBiomeDataListHolder;
import corgiaoc.byg.config.json.subbiomedata.SubBiomeDataListHolderSerializer;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

public class BYGJsonConfigHandler {

    public static void handleEndBiomeJsonConfigs(Path path, Registry<Biome> biomeRegistry) {
        File dir = new File(path.toString());
        if (!dir.exists())
            dir.mkdirs();

        try {
            createReadMe(path.resolve("README.txt"));
        } catch (Exception e) {
            BYG.LOGGER.info("config/byg README.txt failed to load!");
        }

        try {
            handleBYGEndBiomesJSONConfig(path.resolve(BYG.MOD_ID + "-end-biomes.json"), biomeRegistry);
        } catch (IllegalStateException e) {
            throw new IllegalStateException("byg-end-biomes.json failed to load. To quickly fix this error, delete this file and let it reset.");
        }

        try {
            handleBYGEndSubBiomesJSONConfig(path.resolve(BYG.MOD_ID + "-end-sub-biomes.json"), biomeRegistry);
        } catch (IllegalStateException e) {
            throw new IllegalStateException("byg-end-sub-biomes.json failed to load. To quickly fix this error, delete this file and let it reset.");
        }

        EndBiomeDataListHolder.fillBiomeLists();
        EndSubBiomeDataListHolder.fillBiomeLists();
    }


    //TODO: Handle per world load and allow datapack values.
    public static void handleOverWorldConfig(Path path) {
        File dir = new File(path.toString());
        if (!dir.exists())
            dir.mkdirs();

        try {
            handleBYGSubBiomesJSONConfig(path.resolve(BYG.MOD_ID + "-sub-biomes.json"));
        } catch (IllegalStateException e) {
            throw new IllegalStateException("byg-sub-biomes.json failed to load. To quickly fix this error, delete this file and let it reset.");
        }

        try {
            handleBYGBiomesJSONConfig(path.resolve(BYG.MOD_ID + "-biomes.json"));
        } catch (IllegalStateException e) {
            throw new IllegalStateException("byg-biomes.json failed to load. To quickly fix this error, delete this file and let it reset.");
        }

        BiomeDataListHolder.fillBiomeLists();
        SubBiomeDataListHolder.fillBiomeLists();
    }


    public static void handleBYGEndSubBiomesJSONConfig(Path path, Registry<Biome> biomeRegistry) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(EndSubBiomeDataListHolder.class, new EndSubBiomeDataListHolderSerializer(biomeRegistry));
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.disableHtmlEscaping();
        Gson gson = gsonBuilder.create();

        final File CONFIG_FILE = new File(String.valueOf(path));

        if (!CONFIG_FILE.exists()) {
            EndSubBiomeDataListHolder.createDefaults();
            createBYGEndSubBiomesJson(path, biomeRegistry);
        }
        try (Reader reader = new FileReader(path.toString())) {
            EndSubBiomeDataListHolder biomeDataListHolder = gson.fromJson(reader, EndSubBiomeDataListHolder.class);
            if (biomeDataListHolder != null) {
                BYGEndSubBiome.endSubBiomeData = biomeDataListHolder.getEndSubBiomeData();
                BYGEndSubBiome.voidSubBiomeData = biomeDataListHolder.getVoidSubBiomeData();
            } else
                BYG.LOGGER.error(BYG.MOD_ID + "-biomes.json could not be read");

        } catch (IOException e) {
            BYG.LOGGER.error(BYG.MOD_ID + "-biomes.json could not be read");
        }
    }

    public static void createBYGEndSubBiomesJson(Path path, Registry<Biome> biomeRegistry) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(EndSubBiomeDataListHolder.class, new EndSubBiomeDataListHolderSerializer(biomeRegistry));
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.disableHtmlEscaping();
        Gson gson = gsonBuilder.create();

        String jsonString = gson.toJson(new EndSubBiomeDataListHolder(BYGEndSubBiome.endSubBiomeData, BYGEndSubBiome.voidSubBiomeData));

        try {
            Files.write(path, jsonString.getBytes());
        } catch (IOException e) {
            BYG.LOGGER.error(BYG.MOD_ID + "-biomes.json could not be created");
        }
    }


    public static void handleBYGEndBiomesJSONConfig(Path path, Registry<Biome> biomeRegistry) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(EndBiomeDataListHolder.class, new EndBiomeDataListHolderSerializer(biomeRegistry));
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.disableHtmlEscaping();
        Gson gson = gsonBuilder.create();

        final File CONFIG_FILE = new File(String.valueOf(path));

        if (!CONFIG_FILE.exists()) {
            EndBiomeDataListHolder.createDefaults(biomeRegistry);
            createBYGEndBiomesJson(path, biomeRegistry);
        }
        try (Reader reader = new FileReader(path.toString())) {
            EndBiomeDataListHolder biomeDataListHolder = gson.fromJson(reader, EndBiomeDataListHolder.class);
            if (biomeDataListHolder != null) {
                BYGEndBiome.endBiomeData = biomeDataListHolder.getEndBiomeData();
                BYGEndBiome.voidBiomeData = biomeDataListHolder.getVoidBiomeData();
            } else
                BYG.LOGGER.error(BYG.MOD_ID + "-biomes.json could not be read");

        } catch (IOException e) {
            BYG.LOGGER.error(BYG.MOD_ID + "-biomes.json could not be read");
        }
    }

    public static void createBYGEndBiomesJson(Path path, Registry<Biome> biomeRegistry) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(EndBiomeDataListHolder.class, new EndBiomeDataListHolderSerializer(biomeRegistry));
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.disableHtmlEscaping();
        Gson gson = gsonBuilder.create();

        String jsonString = gson.toJson(new EndBiomeDataListHolder(BYGEndBiome.endBiomeData, BYGEndBiome.voidBiomeData));

        try {
            Files.write(path, jsonString.getBytes());
        } catch (IOException e) {
            BYG.LOGGER.error(BYG.MOD_ID + "-biomes.json could not be created");
        }
    }

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
        String text = "If you need help understanding what the byg-biomes or byg-sub-biomes configs allow you to do, please watch this video: https://youtu.be/iq0q09O7ZYo\n\nIf you need help with datapacking, please watch this: https://youtu.be/TF_p8OeB-hc";
        if (!README_FILE.exists()) {
            try {
                Files.write(path, text.getBytes());
            } catch (IOException e) {
                BYG.LOGGER.error(BYG.MOD_ID + "'s README.txt could not be created");
            }
        }
    }
}