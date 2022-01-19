package potionstudios.byg.config.json;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.BYGOverworldBiomeBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public record OverworldBiomeConfig(List<BYGOverworldBiomeBuilder.BiomeProviderData> values) {
    public static final OverworldBiomeConfig DEFAULT = new OverworldBiomeConfig(BYGOverworldBiomeBuilder.OVERWORLD_DEFAULTS);

    public static OverworldBiomeConfig INSTANCE = null;

    public static final Codec<OverworldBiomeConfig> CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(BYGOverworldBiomeBuilder.BiomeProviderData.CODEC.listOf().fieldOf("providers").forGetter(overworldBiomeConfig -> overworldBiomeConfig.values)
        ).apply(builder, OverworldBiomeConfig::new);
    });


    public static OverworldBiomeConfig getConfig(boolean serialize) {
        if (INSTANCE == null || serialize) {
            INSTANCE = readConfig();
        }

        return INSTANCE;
    }

    public static void setConfigInstance(OverworldBiomeConfig config) {
        INSTANCE = config;
    }

    private static OverworldBiomeConfig readConfig() {
        final Path path = BYG.CONFIG_PATH.resolve("overworld-biomes.json");

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
        } catch (Exception e) {
            String error = String.format("An error occurred when parsing \"%s\".\n%s", path.toString(), e.toString());
            BYG.LOGGER.error(error);
            throw new IllegalStateException(error);
        }
    }
}
