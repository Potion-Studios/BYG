package potionstudios.byg.common.world.biome;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import potionstudios.byg.BYG;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Supplier;

public record EndBiomesConfig(boolean useBYGEndBiomeSourceInNewWorlds, boolean warnBYGEndBiomeSourceNotUsedInNewWorlds, boolean useUpdatingConfig, BYGEndBiomeSource.LayersBiomeData islandLayers, BYGEndBiomeSource.LayersBiomeData voidLayers) {
    public static final Supplier<Path> CONFIG_PATH = () -> BYG.CONFIG_PATH.resolve(BYG.MOD_ID + "-end-biomes.json");

    public static final Codec<EndBiomesConfig> CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(
                Codec.BOOL.fieldOf("useBYGEndBiomeSourceInNewWorlds").forGetter(overworldBiomeConfig -> overworldBiomeConfig.useBYGEndBiomeSourceInNewWorlds),
                Codec.BOOL.optionalFieldOf("useConfigDataInExistingWorlds", true).forGetter(overworldBiomeConfig -> overworldBiomeConfig.useUpdatingConfig),
                Codec.BOOL.fieldOf("warnBYGEndBiomeSourceNotUsedInNewWorlds").forGetter(overworldBiomeConfig -> overworldBiomeConfig.warnBYGEndBiomeSourceNotUsedInNewWorlds),
                BYGEndBiomeSource.LayersBiomeData.CODEC.fieldOf("islandLayerData").forGetter(overworldBiomeConfig -> overworldBiomeConfig.islandLayers),
                BYGEndBiomeSource.LayersBiomeData.CODEC.fieldOf("voidLayerData").forGetter(overworldBiomeConfig -> overworldBiomeConfig.voidLayers)
        ).apply(builder, EndBiomesConfig::new);
    });
    public static EndBiomesConfig INSTANCE = null;

    public static final EndBiomesConfig DEFAULT = new EndBiomesConfig(true, true, true, BYGEndBiomeSource.LayersBiomeData.DEFAULT_END_ISLANDS, BYGEndBiomeSource.LayersBiomeData.DEFAULT_END_VOID);


    public static EndBiomesConfig getConfig() {
        return getConfig(false);
    }

    public static EndBiomesConfig getConfig(boolean serialize) {
        if (INSTANCE == null || serialize) {
            INSTANCE = readConfig();
        }

        return INSTANCE;
    }

    private static EndBiomesConfig readConfig() {
        final Path path = CONFIG_PATH.get();

        if (!path.toFile().exists()) {
            JsonElement jsonElement = CODEC.encodeStart(JsonOps.INSTANCE, DEFAULT).result().get();

            try {
                Files.createDirectories(path.getParent());
                Files.write(path, new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create().toJson(jsonElement).getBytes());
            } catch (IOException e) {
                BYG.LOGGER.error(e.toString());
            }
        }
        BYG.LOGGER.info(String.format("\"%s\" was read.", path.toString()));

        try {
            return CODEC.decode(JsonOps.INSTANCE, new JsonParser().parse(new FileReader(path.toFile()))).result().orElseThrow(RuntimeException::new).getFirst();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return DEFAULT;
    }

}
