package potionstudios.byg.config.json;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.Util;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.BYGBiomes;
import potionstudios.byg.util.CodecUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public record BiomeDictionaryConfig(Map<ResourceKey<Biome>, List<String>> biomeDictionary) {
    public static final BiomeDictionaryConfig DEFAULT = new BiomeDictionaryConfig(Util.make(new Object2ObjectOpenHashMap<>(), map -> {
        map.put(BYGBiomes.ALLIUM_FIELDS, List.of("PLAINS", "RARE", "LUSH", "OVERWORLD"));
        map.put(BYGBiomes.AMARANTH_FIELDS, List.of("PLAINS", "RARE", "LUSH", "OVERWORLD"));
        map.put(BYGBiomes.ARAUCARIA_SAVANNA, List.of("SAVANNA", "OVERWORLD"));
        map.put(BYGBiomes.ARAUCARIA_SAVANNA, List.of("SAVANNA", "OVERWORLD"));
        map.put(BYGBiomes.ASPEN_FOREST, List.of("FOREST", "OVERWORLD"));
        map.put(BYGBiomes.AUTUMNAL_VALLEY, List.of("PLAINS", "DRY", "OVERWORLD"));
        map.put(BYGBiomes.BAOBAB_SAVANNA, List.of("SAVANNA", "SPARSE", "DRY", "OVERWORLD"));
        map.put(BYGBiomes.BAYOU, List.of("SWAMP", "FOREST", "WET", "OVERWORLD"));
        map.put(BYGBiomes.BOREALIS_GROVE, List.of("FOREST", "OVERWORLD"));
    }));

    public static BiomeDictionaryConfig INSTANCE = null;

    public static final Codec<BiomeDictionaryConfig> CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(Codec.unboundedMap(CodecUtil.BIOME_CODEC, Codec.STRING.listOf()).fieldOf("dictionary").forGetter(overworldBiomeConfig -> overworldBiomeConfig.biomeDictionary)
        ).apply(builder, BiomeDictionaryConfig::new);
    });


    public static BiomeDictionaryConfig getConfig(boolean serialize) {
        if (INSTANCE == null || serialize) {
            INSTANCE = readConfig();
        }

        return INSTANCE;
    }

    private static BiomeDictionaryConfig readConfig() {
        final Path path = BYG.CONFIG_PATH.resolve(BYG.MOD_ID + "-biome-dictionary.json");

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
