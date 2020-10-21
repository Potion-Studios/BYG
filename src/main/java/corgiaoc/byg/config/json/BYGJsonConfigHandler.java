package corgiaoc.byg.config.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.biome.BYGBiome;

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
            createBYGJson(path);
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

    public static void createBYGJson(Path path) {
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
}
