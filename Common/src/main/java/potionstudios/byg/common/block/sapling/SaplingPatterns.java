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

public record SaplingPatterns(Map<ResourceLocation, List<Entry>> saplingPatterns) {
    public static final int MAX_PATTERN_SIZE = 5;

    public static final SaplingPatterns DEFAULT = new SaplingPatterns(Util.make(new HashMap<>(), map -> {
        map.put(BYG.createLocation("araucaria_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder().add(BYG.createLocation("araucaria_tree1"), 1).add(BYG.createLocation("araucaria_tree2"), 1).build())
        ));
        map.put(BYG.createLocation("aspen_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder().add(BYG.createLocation("aspen_tree1"), 1).add(BYG.createLocation("aspen_tree2"), 1).add(BYG.createLocation("aspen_tree3"), 1).build())
        ));
        map.put(BYG.createLocation("baobab_sapling"), List.of(
            new Entry(List.of(
                    "xxx",
                    "xxx",
                    "xxx"), SimpleWeightedRandomList.<ResourceLocation>builder().add(BYG.createLocation("baobab_tree1"), 1).add(BYG.createLocation("baobab_tree2"), 1).build())
        ));
        map.put(BYG.createLocation("blue_enchanted_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder().add(BYG.createLocation("blue_enchanted_tree1"), 1).add(BYG.createLocation("blue_enchanted_tree2"), 1).build())
        ));
        map.put(BYG.createLocation("blue_spruce_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(BYG.createLocation("spruce_blue_tree1"), 1)
                        .add(BYG.createLocation("spruce_blue_tree2"), 1)
                        .add(BYG.createLocation("spruce_blue_tree3"), 1)
                        .add(BYG.createLocation("spruce_blue_tree4"), 1)
                        .build()),
                new Entry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(BYG.createLocation("spruce_blue_tree_medium1"), 1)
                        .add(BYG.createLocation("spruce_blue_tree_medium2"), 1)
                        .add(BYG.createLocation("spruce_blue_tree_medium3"), 1)
                        .add(BYG.createLocation("spruce_blue_tree_medium4"), 1)
                        .build()),
                new Entry(List.of(
                        "xxx",
                        "xxx",
                        "xxx"), SimpleWeightedRandomList.single(BYG.createLocation("spruce_blue_tree_large1")))
        ));
        map.put(BYG.createLocation("brown_birch_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(BYG.createLocation("brown_birch_tree1"), 1)
                        .add(BYG.createLocation("brown_birch_tree2"), 1)
                        .add(BYG.createLocation("brown_birch_tree3"), 1)
                        .add(BYG.createLocation("brown_birch_tree4"), 1)
                        .build())
        ));
        map.put(BYG.createLocation("brown_oak_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(BYG.createLocation("deciduous_brown_tree1"), 1)
                        .add(BYG.createLocation("deciduous_brown_tree2"), 1)
                        .add(BYG.createLocation("deciduous_brown_tree3"), 1)
                        .add(BYG.createLocation("deciduous_brown_tree4"), 1)
                        .add(BYG.createLocation("brown_oak_tree1"), 1)
                        .add(BYG.createLocation("brown_oak_tree2"), 1)
                        .add(BYG.createLocation("brown_oak_tree3"), 1)
                        .build()),
                new Entry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(BYG.createLocation("large_brown_oak_tree1"), 1)
                        .add(BYG.createLocation("large_brown_oak_tree2"), 1)
                        .add(BYG.createLocation("large_brown_oak_tree3"), 1)
                        .build())
        ));
        map.put(BYG.createLocation("brown_zelkova_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(BYG.createLocation("zelkova_brown_tree1"), 1)
                        .add(BYG.createLocation("zelkova_brown_tree2"), 1)
                        .add(BYG.createLocation("zelkova_brown_tree3"), 1)
                        .build())
        ));
        map.put(BYG.createLocation("cika_sapling"), List.of(
                new Entry(List.of(
                        " x ",
                        "xxx",
                        " x "), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(BYG.createLocation("cika_tree1"), 1)
                        .add(BYG.createLocation("cika_tree2"), 1)
                        .add(BYG.createLocation("cika_tree3"), 1)
                        .build())
        ));
        map.put(BYG.createLocation("cypress_sapling"), List.of(
                new Entry(List.of(
                        "  x  ",
                        "  x  ",
                        "xxxxx",
                        "  x  ",
                        "  x  "), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(BYG.createLocation("cypress_tree1"), 1)
                        .add(BYG.createLocation("cypress_tree2"), 1)
                        .add(BYG.createLocation("cypress_tree3"), 1)
                        .build())
        ));
        map.put(BYG.createLocation("ebony_sapling"), List.of(
                new Entry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(BYG.createLocation("ebony_bush1"), 1)
                        .add(BYG.createLocation("ebony_tree1"), 1)
                        .add(BYG.createLocation("ebony_tree2"), 1)
                        .build())
        ));
        map.put(BYG.createLocation("fir_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(BYG.createLocation("conifer_tree1"), 1)
                        .add(BYG.createLocation("conifer_tree2"), 1)
                        .add(BYG.createLocation("conifer_tree3"), 1)
                        .add(BYG.createLocation("conifer_tree4"), 1)
                        .add(BYG.createLocation("conifer_tree5"), 1)
                        .add(BYG.createLocation("conifer_tree6"), 1)
                        .add(BYG.createLocation("conifer_tree7"), 1)
                        .build()),
                new Entry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(BYG.createLocation("conifer_tree8"), 1)
                        .build())

        ));
        map.put(BYG.createLocation("green_enchanted_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(BYG.createLocation("green_enchanted_tree1"), 1)
                        .add(BYG.createLocation("green_enchanted_tree2"), 1)
                        .add(BYG.createLocation("green_enchanted_tree3"), 1)
                        .build())
        ));
        map.put(BYG.createLocation("holly_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(BYG.createLocation("holly_tree1"), 1)
                        .add(BYG.createLocation("holly_tree2"), 1)
                        .add(BYG.createLocation("holly_tree4"), 1)
                        .build()),
                new Entry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(BYG.createLocation("holly_tree3"), 1)
                        .build())
        ));
        map.put(BYG.createLocation("jacaranda_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(BYG.createLocation("jacaranda_tree1"), 1)
                        .add(BYG.createLocation("jacaranda_tree2"), 1)
                        .build())
        ));
        map.put(BYG.createLocation("indigo_jacaranda_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(BYG.createLocation("indigo_jacaranda_tree1"), 1)
                        .add(BYG.createLocation("indigo_jacaranda_tree2"), 1)
                        .build())
        ));

        map.put(BYG.createLocation("joshua_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(BYG.createLocation("joshua_tree1"), 1)
                        .add(BYG.createLocation("joshua_tree2"), 1)
                        .build())
        ));
        map.put(BYG.createLocation("mahogany_sapling"), List.of(
                new Entry(List.of("x"), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(BYG.createLocation("mahogany_tree1"), 1)
                        .add(BYG.createLocation("mahogany_tree2"), 1)
                        .add(BYG.createLocation("mahogany_tree3"), 1)
                        .add(BYG.createLocation("mahogany_tree4"), 1)
                        .build()),
                new Entry(List.of(
                        "  x  ",
                        "     ",
                        "x   x",
                        "     ",
                        "  x  "), SimpleWeightedRandomList.<ResourceLocation>builder()
                        .add(BYG.createLocation("mahogany_tree5"), 1)
                        .build())
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
