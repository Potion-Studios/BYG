package potionstudios.byg.common.world.biome.nether;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.LayersBiomeData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Supplier;

public record NetherBiomesConfig(boolean useBYGNetherBiomeSourceInNewWorlds, boolean warnBYGEndBiomeSourceNotUsedInNewWorlds,
                                 boolean useUpdatingConfig, LayersBiomeData upperLayer,
                                 LayersBiomeData middleLayer, LayersBiomeData bottomLayer) {
    public static final Supplier<Path> CONFIG_PATH = () -> BYG.CONFIG_PATH.resolve(BYG.MOD_ID + "-nether-biomes.json");

    public static final Codec<NetherBiomesConfig> CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(
            Codec.BOOL.fieldOf("useBYGNetherBiomeSourceInNewWorlds").forGetter(overworldBiomeConfig -> overworldBiomeConfig.useBYGNetherBiomeSourceInNewWorlds),
            Codec.BOOL.optionalFieldOf("useConfigDataInExistingWorlds", true).forGetter(overworldBiomeConfig -> overworldBiomeConfig.useUpdatingConfig),
            Codec.BOOL.fieldOf("warnBYGEndBiomeSourceNotUsedInNewWorlds").forGetter(overworldBiomeConfig -> overworldBiomeConfig.warnBYGEndBiomeSourceNotUsedInNewWorlds),
            LayersBiomeData.CODEC.fieldOf("upperLayer").forGetter(overworldBiomeConfig -> overworldBiomeConfig.upperLayer),
            LayersBiomeData.CODEC.fieldOf("middleLayer").forGetter(overworldBiomeConfig -> overworldBiomeConfig.middleLayer),
            LayersBiomeData.CODEC.fieldOf("bottomLayer").forGetter(overworldBiomeConfig -> overworldBiomeConfig.bottomLayer)
        ).apply(builder, NetherBiomesConfig::new);
    });
    public static NetherBiomesConfig INSTANCE = null;

    public static final NetherBiomesConfig DEFAULT = new NetherBiomesConfig(true, true, true, LayersBiomeData.DEFAULT_NETHER_UPPER, LayersBiomeData.DEFAULT_NETHER_MIDDLE, LayersBiomeData.DEFAULT_NETHER_LOWER);


    public static NetherBiomesConfig getConfig() {
        return getConfig(false);
    }

    public static NetherBiomesConfig getConfig(boolean serialize) {
        if (INSTANCE == null || serialize) {
            INSTANCE = readConfig();
        }

        return INSTANCE;
    }

    private static NetherBiomesConfig readConfig() {
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
