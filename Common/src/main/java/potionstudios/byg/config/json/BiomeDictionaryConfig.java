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
import potionstudios.byg.util.codec.CodecUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static potionstudios.byg.common.world.biome.BYGBiomes.*;

@Deprecated
public record BiomeDictionaryConfig(Map<ResourceKey<Biome>, List<String>> biomeDictionary) {
    public static final BiomeDictionaryConfig DEFAULT = new BiomeDictionaryConfig(Util.make(new Object2ObjectOpenHashMap<>(), map -> {
        map.put(ALLIUM_FIELDS, List.of("PLAINS", "RARE", "LUSH", "OVERWORLD"));
        map.put(AMARANTH_FIELDS, List.of("PLAINS", "RARE", "LUSH", "OVERWORLD"));
        map.put(FORGOTTEN_FOREST, List.of("FOREST", "MAGICAL", "RARE", "OVERWORLD"));
        map.put(ARAUCARIA_SAVANNA, List.of("FOREST", "OVERWORLD"));
        map.put(ASPEN_FOREST, List.of("FOREST", "OVERWORLD"));
        map.put(AUTUMNAL_VALLEY, List.of("PLAINS", "DRY", "OVERWORLD"));
        map.put(BAOBAB_SAVANNA, List.of("SAVANNA", "SPARSE", "DRY", "OVERWORLD"));
        map.put(BAYOU, List.of("SWAMP", "FOREST", "WET", "OVERWORLD"));
        map.put(FROSTED_TAIGA, List.of("FOREST", "SNOWY", "CONIFEROUS", "OVERWORLD"));
        map.put(CANADIAN_SHIELD, List.of("MOUNTAIN", "CONIFEROUS", "COLD", "OVERWORLD"));
        map.put(BOREALIS_GROVE, List.of("FOREST", "OVERWORLD"));
        map.put(CHERRY_BLOSSOM_FOREST, List.of("FOREST", "OVERWORLD"));
        map.put(CIKA_WOODS, List.of("FOREST", "COLD", "CONIFEROUS", "OVERWORLD"));
        map.put(CONIFEROUS_FOREST, List.of("FOREST", "COLD", "CONIFEROUS", "OVERWORLD"));
        map.put(CRAG_GARDENS, List.of("JUNGLE", "WET", "PLATEAU", "RARE", "MAGICAL", "OVERWORLD"));
        map.put(CYPRESS_SWAMPLANDS, List.of("SWAMP", "OVERWORLD"));
        map.put(LUSH_STACKS, List.of("OCEAN", "WASTELAND", "SPOOKY", "OVERWORLD"));
//        map.put(DECIDUOUS_FOREST, List.of("FOREST", "OVERWORLD"));
        map.put(DACITE_RIDGES, List.of("MOUNTAIN", "COLD", "CONIFEROUS", "OVERWORLD"));
        map.put(WINDSWEPT_DUNES, List.of("DRY", "HOT", "SANDY", "OVERWORLD"));
        map.put(EBONY_WOODS, List.of("FOREST", "DENSE", "OVERWORLD"));
        map.put(FORGOTTEN_FOREST, List.of("FOREST", "RARE", "MAGICAL", "OVERWORLD"));
//        map.put(GREAT_LAKES, List.of("FOREST", "WATER", "CONIFEROUS", "OVERWORLD"));
        map.put(GROVE, List.of("PLAINS", "LUSH", "OVERWORLD"));
        map.put(GUIANA_SHIELD, List.of("JUNGLE", "HOT", "DENSE", "FOREST", "MOUNTAIN", "OVERWORLD"));
        map.put(JACARANDA_FOREST, List.of("FOREST", "OVERWORLD"));
//        map.put(LUSH_TUNDRA, List.of("PLAINS", "COLD", "LUSH", "OVERWORLD"));
//        map.put(MANGROVE_MARSHES, List.of("SWAMP", "FOREST", "WET", "DENSE", "OVERWORLD"));
        map.put(MAPLE_TAIGA, List.of("FOREST", "COLD", "OVERWORLD"));
        map.put(COCONINO_MEADOW, List.of("PLAINS", "LUSH", "COLD", "OVERWORLD"));
        map.put(MOJAVE_DESERT, List.of("DRY", "HOT", "SANDY", "OVERWORLD"));
        map.put(ORCHARD, List.of("PLAINS", "LUSH", "FOREST", "OVERWORLD"));
        map.put(PRAIRIE, List.of("PLAINS", "DRY", "OVERWORLD"));
//        map.put(RED_DESERT, List.of("DRY", "HOT", "SANDY", "OVERWORLD"));
        map.put(RED_OAK_FOREST, List.of("FOREST", "OVERWORLD"));
        map.put(RED_ROCK_VALLEY, List.of("DRY", "HOT", "MOUNTAIN", "OVERWORLD"));
        map.put(REDWOOD_THICKET, List.of("FOREST", "DENSE", "RARE", "OVERWORLD"));
        map.put(ROSE_FIELDS, List.of("OVERWORLD", "PLAINS", "RARE", "LUSH"));
        map.put(AUTUMNAL_FOREST, List.of("FOREST", "COLD", "OVERWORLD"));
        map.put(AUTUMNAL_TAIGA, List.of("FOREST", "COLD", "CONIFEROUS", "OVERWORLD"));
        map.put(SHATTERED_GLACIER, List.of("SNOWY", "OVERWORLD", "RARE"));
        map.put(FIRECRACKER_SHRUBLAND, List.of("PLAINS", "DRY", "SPARSE", "OVERWORLD"));
        map.put(SIERRA_BADLANDS, List.of("DRY", "HOT", "PLAINS", "OVERWORLD"));
        map.put(SKYRIS_VALE, List.of("MAGICAL", "FOREST", "LUSH", "RARE", "OVERWORLD"));
        map.put(FROSTED_CONIFEROUS_FOREST, List.of("FOREST", "SNOWY", "CONIFEROUS", "OVERWORLD"));
        map.put(FRAGMENT_FOREST, List.of("OVERWORLD", "DENSE", "PLATEAU"));
        map.put(BLACK_FOREST, List.of("OVERWORLD", "DENSE", "PLATEAU"));
        map.put(TWILIGHT_MEADOW, List.of("COLD", "WASTELAND", "MAGICAL", "OVERWORLD"));
        map.put(WEEPING_WITCH_FOREST, List.of("FOREST", "COLD", "MAGICAL", "RARE", "SPOOKY", "OVERWORLD"));
        map.put(TEMPERATE_RAINFOREST, List.of("FOREST", "DENSE", "MAGICAL", "OVERWORLD"));
        map.put(ZELKOVA_FOREST, List.of("CONIFEROUS", "COLD", "FOREST", "OVERWORLD"));
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
