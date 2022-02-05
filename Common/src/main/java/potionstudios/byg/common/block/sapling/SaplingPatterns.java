package potionstudios.byg.common.block.sapling;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import potionstudios.byg.BYG;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static potionstudios.byg.BYG.createLocation;

public record SaplingPatterns(Map<ResourceLocation, List<Entry>> saplingPatterns) {
    public static final int MAX_PATTERN_SIZE = 5;

    public static final SaplingPatterns DEFAULT = new SaplingPatterns(Util.make(new HashMap<>(), map -> {
        map.put(createLocation("araucaria_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder().add(createLocation("araucaria_tree1"), 1).add(createLocation("araucaria_tree2"), 1).build())
        ));
        map.put(createLocation("aspen_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder().add(createLocation("aspen_tree1"), 1).add(createLocation("aspen_tree2"), 1).add(createLocation("aspen_tree3"), 1).build())
        ));
        map.put(createLocation("baobab_sapling"), List.of(
            new Entry(List.of(
                    "xxx",
                    "xxx",
                    "xxx"), SimpleWeightedRandomList.<ResourceLocation>builder().add(createLocation("baobab_tree1"), 1).add(createLocation("baobab_tree2"), 1).build())
        ));
        map.put(createLocation("blue_enchanted_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder().add(createLocation("blue_enchanted_tree1"), 1).add(createLocation("blue_enchanted_tree2"), 1).build())
        ));
        map.put(createLocation("blue_spruce_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("spruce_blue_tree1"), 1)
                        .add(createLocation("spruce_blue_tree2"), 1)
                        .add(createLocation("spruce_blue_tree3"), 1)
                        .add(createLocation("spruce_blue_tree4"), 1)
                        .build()),
                new Entry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("spruce_blue_tree_medium1"), 1)
                        .add(createLocation("spruce_blue_tree_medium2"), 1)
                        .add(createLocation("spruce_blue_tree_medium3"), 1)
                        .add(createLocation("spruce_blue_tree_medium4"), 1)
                        .build()),
                new Entry(List.of(
                        "xxx",
                        "xxx",
                        "xxx"), SimpleWeightedRandomList.single(createLocation("spruce_blue_tree_large1")))
        ));
        map.put(createLocation("brown_birch_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("brown_birch_tree1"), 1)
                        .add(createLocation("brown_birch_tree2"), 1)
                        .add(createLocation("brown_birch_tree3"), 1)
                        .add(createLocation("brown_birch_tree4"), 1)
                        .build())
        ));
        map.put(createLocation("brown_oak_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("deciduous_brown_tree1"), 1)
                        .add(createLocation("deciduous_brown_tree2"), 1)
                        .add(createLocation("deciduous_brown_tree3"), 1)
                        .add(createLocation("deciduous_brown_tree4"), 1)
                        .add(createLocation("brown_oak_tree1"), 1)
                        .add(createLocation("brown_oak_tree2"), 1)
                        .add(createLocation("brown_oak_tree3"), 1)
                        .build()),
                new Entry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("large_brown_oak_tree1"), 1)
                        .add(createLocation("large_brown_oak_tree2"), 1)
                        .add(createLocation("large_brown_oak_tree3"), 1)
                        .build())
        ));
        map.put(createLocation("brown_zelkova_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("zelkova_brown_tree1"), 1)
                        .add(createLocation("zelkova_brown_tree2"), 1)
                        .add(createLocation("zelkova_brown_tree3"), 1)
                        .build())
        ));
        map.put(createLocation("cika_sapling"), List.of(
                new Entry(List.of(
                        " x ",
                        "xxx",
                        " x "), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("cika_tree1"), 1)
                        .add(createLocation("cika_tree2"), 1)
                        .add(createLocation("cika_tree3"), 1)
                        .build())
        ));
        map.put(createLocation("cypress_sapling"), List.of(
                new Entry(List.of(
                        "  x  ",
                        "  x  ",
                        "xxxxx",
                        "  x  ",
                        "  x  "), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("cypress_tree1"), 1)
                        .add(createLocation("cypress_tree2"), 1)
                        .add(createLocation("cypress_tree3"), 1)
                        .build())
        ));
        map.put(createLocation("ebony_sapling"), List.of(
                new Entry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("ebony_bush1"), 1)
                        .add(createLocation("ebony_tree1"), 1)
                        .add(createLocation("ebony_tree2"), 1)
                        .build())
        ));
        map.put(createLocation("fir_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("conifer_tree1"), 1)
                        .add(createLocation("conifer_tree2"), 1)
                        .add(createLocation("conifer_tree3"), 1)
                        .add(createLocation("conifer_tree4"), 1)
                        .add(createLocation("conifer_tree5"), 1)
                        .add(createLocation("conifer_tree6"), 1)
                        .add(createLocation("conifer_tree7"), 1)
                        .build()),
                new Entry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("conifer_tree8"), 1)
                        .build())

        ));
        map.put(createLocation("green_enchanted_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("green_enchanted_tree1"), 1)
                        .add(createLocation("green_enchanted_tree2"), 1)
                        .add(createLocation("green_enchanted_tree3"), 1)
                        .build())
        ));
        map.put(createLocation("holly_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("holly_tree1"), 1)
                        .add(createLocation("holly_tree2"), 1)
                        .add(createLocation("holly_tree4"), 1)
                        .build()),
                new Entry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("holly_tree3"), 1)
                        .build())
        ));
        map.put(createLocation("jacaranda_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("jacaranda_tree1"), 1)
                        .add(createLocation("jacaranda_tree2"), 1)
                        .build())
        ));
        map.put(createLocation("indigo_jacaranda_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("indigo_jacaranda_tree1"), 1)
                        .add(createLocation("indigo_jacaranda_tree2"), 1)
                        .build())
        ));
        map.put(createLocation("joshua_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("joshua_tree1"), 1)
                        .add(createLocation("joshua_tree2"), 1)
                        .build())
        ));
        map.put(createLocation("mahogany_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("mahogany_tree1"), 1)
                        .add(createLocation("mahogany_tree2"), 1)
                        .add(createLocation("mahogany_tree3"), 1)
                        .add(createLocation("mahogany_tree4"), 1)
                        .build())
        ));
        map.put(createLocation("maple_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>single(createLocation("maple_tree1")))
        ));
        map.put(createLocation("orange_birch_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("orange_birch_tree1"), 1)
                        .add(createLocation("orange_birch_tree2"), 1)
                        .add(createLocation("orange_birch_tree3"), 1)
                        .add(createLocation("orange_birch_tree4"), 1)
                        .build())
        ));
        map.put(createLocation("orange_oak_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("deciduous_orange_tree1"), 1)
                        .add(createLocation("deciduous_orange_tree2"), 1)
                        .add(createLocation("deciduous_orange_tree3"), 1)
                        .add(createLocation("deciduous_orange_tree4"), 1)
                        .add(createLocation("orange_oak_tree1"), 1)
                        .add(createLocation("orange_oak_tree2"), 1)
                        .add(createLocation("orange_oak_tree3"), 1)
                        .build()),
                new Entry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("large_orange_oak_tree1"), 1)
                        .add(createLocation("large_orange_oak_tree2"), 1)
                        .add(createLocation("large_orange_oak_tree3"), 1)
                        .build())
        ));
        map.put(createLocation("orange_spruce_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("spruce_orange_tree1"), 1)
                        .add(createLocation("spruce_orange_tree2"), 1)
                        .add(createLocation("spruce_orange_tree3"), 1)
                        .add(createLocation("spruce_orange_tree4"), 1)
                        .build()),
                new Entry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("spruce_orange_tree_medium1"), 1)
                        .add(createLocation("spruce_orange_tree_medium2"), 1)
                        .add(createLocation("spruce_orange_tree_medium3"), 1)
                        .add(createLocation("spruce_orange_tree_medium4"), 1)
                        .build()),
                new Entry(List.of(
                        "xxx",
                        "xxx",
                        "xxx"), SimpleWeightedRandomList.single(createLocation("spruce_orange_tree_large1")))
        ));
        map.put(createLocation("orchard_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("orchard_tree1"), 1)
                        .add(createLocation("orchard_tree3"), 1)
                        .build()),
                new Entry(List.of(
                        "xxx",
                        "xxx",
                        "xxx"), SimpleWeightedRandomList.single(createLocation("orchard_tree2")))
        ));
        map.put(createLocation("palo_verde_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("palo_verde_tree1"), 1)
                        .add(createLocation("palo_verde_tree2"), 1)
                        .build())
        ));
        map.put(createLocation("palo_verde_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("palo_verde_tree1"), 1)
                        .add(createLocation("palo_verde_tree2"), 1)
                        .build())
        ));
        map.put(createLocation("pine_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("pine_tree1"), 1)
                        .add(createLocation("pine_tree2"), 1)
                        .build())
        ));
        map.put(createLocation("pink_cherry_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>single(createLocation("pink_cherry_tree2"))),
                new Entry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<ResourceLocation>single(createLocation("pink_cherry_tree1")))
        ));
        map.put(createLocation("rainbow_eucalyptus_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>single(createLocation("rainbow_eucalyptus_tree1"))),
                new Entry(List.of(
                        " x ",
                        "xxx",
                        " x "), SimpleWeightedRandomList.<ResourceLocation>single(createLocation("large_rainbow_eucalyptus_tree1")))
        ));
        map.put(createLocation("red_birch_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("red_birch_tree1"), 1)
                        .add(createLocation("red_birch_tree2"), 1)
                        .add(createLocation("red_birch_tree3"), 1)
                        .add(createLocation("red_birch_tree4"), 1)
                        .build())
        ));
        map.put(createLocation("red_maple_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("red_maple_tree1"), 1)
                        .add(createLocation("red_maple_tree2"), 1)
                        .build())
        ));
        map.put(createLocation("red_oak_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("deciduous_red_tree1"), 1)
                        .add(createLocation("deciduous_red_tree2"), 1)
                        .add(createLocation("deciduous_red_tree3"), 1)
                        .add(createLocation("deciduous_red_tree4"), 1)
                        .add(createLocation("red_oak_tree1"), 1)
                        .add(createLocation("red_oak_tree2"), 1)
                        .add(createLocation("red_oak_tree3"), 1)
                        .build()),
                new Entry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("large_red_oak_tree1"), 1)
                        .add(createLocation("large_red_oak_tree2"), 1)
                        .add(createLocation("large_red_oak_tree3"), 1)
                        .build())
        ));
        map.put(createLocation("red_spruce_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("spruce_red_tree1"), 1)
                        .add(createLocation("spruce_red_tree2"), 1)
                        .add(createLocation("spruce_red_tree3"), 1)
                        .add(createLocation("spruce_red_tree4"), 1)
                        .build()),
                new Entry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(createLocation("spruce_red_tree_medium1"), 1)
                        .add(createLocation("spruce_red_tree_medium2"), 1)
                        .add(createLocation("spruce_red_tree_medium3"), 1)
                        .add(createLocation("spruce_red_tree_medium4"), 1)
                        .build()),
                new Entry(List.of(
                        "xxx",
                        "xxx",
                        "xxx"), SimpleWeightedRandomList.single(createLocation("spruce_red_tree_large1")))
        ));
        map.put(createLocation("redwood_sapling"), List.of(
                new Entry(List.of(
                        " x ",
                        "xxx",
                        " x "), SimpleWeightedRandomList.single(createLocation("redwood_tree3"))),
                new Entry(List.of(
                        "xxx",
                        "xxx",
                        "xxx"
                ), SimpleWeightedRandomList.single(createLocation("redwood_tree1"))),
                new Entry(List.of(
                        "  x  ",
                        " xxx ",
                        "xxxxx",
                        " xxx ",
                        "  x  "
                ), SimpleWeightedRandomList.single(createLocation("redwood_tree2")))
        ));
    }));

    public static SaplingPatterns INSTANCE = null;

    public static final Codec<SaplingPatterns> CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(
                Codec.unboundedMap(ResourceLocation.CODEC, Entry.CODEC.listOf()).fieldOf("sapling_patterns").forGetter(saplingPatterns -> saplingPatterns.saplingPatterns)
        ).apply(builder, SaplingPatterns::new);
    });


    public static SaplingPatterns getConfig() {
        return getConfig(false);
    }

    public static SaplingPatterns getConfig(boolean serialize) {
        if (INSTANCE == null || serialize) {
            INSTANCE = readConfig();
        }

        return INSTANCE;
    }

    private static SaplingPatterns readConfig() {
        final Path path = BYG.CONFIG_PATH.resolve(BYG.MOD_ID + "-sapling-patterns.json");

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

    public record Entry(List<String> pattern, SimpleWeightedRandomList<ResourceLocation> spawners) {
        public static final Codec<Entry> CODEC = RecordCodecBuilder.create(builder -> {
            return builder.group(
                    Codec.STRING.listOf().fieldOf("pattern").forGetter(entry -> entry.pattern),
                    SimpleWeightedRandomList.wrappedCodec(ResourceLocation.CODEC).fieldOf("spawners").forGetter(overworldBiomeConfig -> overworldBiomeConfig.spawners)
            ).apply(builder, Entry::new);
        });
    }
}
