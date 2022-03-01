package potionstudios.byg.common.world.biome.end;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.LayersBiomeData;
import potionstudios.byg.util.BYGUtil;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Supplier;

public record EndBiomesConfig(boolean useBYGEndBiomeSourceInNewWorlds, boolean warnBYGEndBiomeSourceNotUsedInNewWorlds,
                              boolean useUpdatingConfig, LayersBiomeData islandLayers,
                              LayersBiomeData voidLayers, LayersBiomeData skyLayers,
                              int skyLayerStartY) {
    public static final Supplier<Path> CONFIG_PATH = () -> BYG.CONFIG_PATH.resolve(BYG.MOD_ID + "-end-biomes.json");

    public static final Codec<EndBiomesConfig> CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(
            Codec.BOOL.fieldOf("useBYGNetherBiomeSourceInNewWorlds").forGetter(overworldBiomeConfig -> overworldBiomeConfig.useBYGEndBiomeSourceInNewWorlds),
            Codec.BOOL.optionalFieldOf("useConfigDataInExistingWorlds", true).forGetter(overworldBiomeConfig -> overworldBiomeConfig.useUpdatingConfig),
            Codec.BOOL.fieldOf("warnBYGNetherBiomeSourceNotUsedInNewWorlds").forGetter(overworldBiomeConfig -> overworldBiomeConfig.warnBYGEndBiomeSourceNotUsedInNewWorlds),
            LayersBiomeData.CODEC.fieldOf("islandLayerData").forGetter(overworldBiomeConfig -> overworldBiomeConfig.islandLayers),
            LayersBiomeData.CODEC.fieldOf("voidLayerData").forGetter(overworldBiomeConfig -> overworldBiomeConfig.voidLayers),
            LayersBiomeData.CODEC.fieldOf("skyLayerData").forGetter(overworldBiomeConfig -> overworldBiomeConfig.skyLayers),
            Codec.INT.fieldOf("skyLayerStartY").forGetter(overworldBiomeConfig -> overworldBiomeConfig.skyLayerStartY)
        ).apply(builder, EndBiomesConfig::new);
    });
    public static EndBiomesConfig INSTANCE = null;

    public static final EndBiomesConfig DEFAULT = new EndBiomesConfig(true, true, true, LayersBiomeData.DEFAULT_END_ISLANDS, LayersBiomeData.DEFAULT_END_VOID, LayersBiomeData.DEFAULT_SKY, 180);


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
            return CODEC.decode(JsonOps.INSTANCE, new JsonParser().parse(new FileReader(path.toFile()))).result().orElseThrow(() -> BYGUtil.configFileFailureException(path)).getFirst();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}