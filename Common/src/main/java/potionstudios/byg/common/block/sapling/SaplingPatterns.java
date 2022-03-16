package potionstudios.byg.common.block.sapling;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
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
import java.util.Objects;

import static potionstudios.byg.BYG.createLocation;

public record SaplingPatterns(boolean logSaplingGrowth, Map<ResourceLocation, List<PatternEntry>> saplingPatterns) {
    public static final int MAX_PATTERN_SIZE = 5;

    public static final SaplingPatterns DEFAULT = new SaplingPatterns(false, Util.make(new HashMap<>(), map -> {
        map.put(createLocation("araucaria_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder().add(new FeatureSpawner(createLocation("araucaria_tree1")), 1).add(new FeatureSpawner(createLocation("araucaria_tree2")), 1).build())
        ));
        map.put(createLocation("aspen_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder().add(new FeatureSpawner(createLocation("aspen_tree1")), 1).add(new FeatureSpawner(createLocation("aspen_tree2")), 1).add(new FeatureSpawner(createLocation("aspen_tree3")), 1).build())
        ));
        map.put(createLocation("baobab_sapling"), List.of(
            new PatternEntry(List.of(
                    "xxx",
                    "xxx",
                    "xxx"), SimpleWeightedRandomList.<FeatureSpawner>builder().add(new FeatureSpawner(createLocation("baobab_tree1")), 1).add(new FeatureSpawner(createLocation("baobab_tree2")), 1).build())
        ));
        map.put(createLocation("blue_enchanted_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder().add(new FeatureSpawner(createLocation("blue_enchanted_tree1")), 1).add(new FeatureSpawner(createLocation("blue_enchanted_tree2")), 1).build())
        ));
        map.put(createLocation("blue_spruce_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("spruce_blue_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_blue_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_blue_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_blue_tree4")), 1)
                        .build()),
                new PatternEntry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("spruce_blue_tree_medium1")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_blue_tree_medium2")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_blue_tree_medium3")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_blue_tree_medium4")), 1)
                        .build()),
                new PatternEntry(List.of(
                        "xxx",
                        "xxx",
                        "xxx"), SimpleWeightedRandomList.single(new FeatureSpawner(createLocation("spruce_blue_tree_large1"))))
        ));
        map.put(createLocation("brown_birch_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("brown_birch_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("brown_birch_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("brown_birch_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("brown_birch_tree4")), 1)
                        .build())
        ));
        map.put(createLocation("brown_oak_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("deciduous_brown_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("deciduous_brown_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("deciduous_brown_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("deciduous_brown_tree4")), 1)
                        .add(new FeatureSpawner(createLocation("brown_oak_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("brown_oak_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("brown_oak_tree3")), 1)
                        .build()),
                new PatternEntry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("large_brown_oak_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("large_brown_oak_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("large_brown_oak_tree3")), 1)
                        .build())
        ));
        map.put(createLocation("brown_zelkova_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("zelkova_brown_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("zelkova_brown_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("zelkova_brown_tree3")), 1)
                        .build())
        ));
        map.put(createLocation("cika_sapling"), List.of(
                new PatternEntry(List.of(
                        " x ",
                        "xxx",
                        " x "), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("cika_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("cika_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("cika_tree3")), 1)
                        .build())
        ));
        map.put(createLocation("cypress_sapling"), List.of(
                new PatternEntry(List.of(
                        "  x  ",
                        "  x  ",
                        "xxxxx",
                        "  x  ",
                        "  x  "), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("cypress_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("cypress_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("cypress_tree3")), 1)
                        .build())
        ));
        map.put(createLocation("ebony_sapling"), List.of(
                new PatternEntry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("ebony_bush1")), 1)
                        .add(new FeatureSpawner(createLocation("ebony_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("ebony_tree2")), 1)
                        .build())
        ));
        map.put(createLocation("fir_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("conifer_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("conifer_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("conifer_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("conifer_tree4")), 1)
                        .add(new FeatureSpawner(createLocation("conifer_tree5")), 1)
                        .add(new FeatureSpawner(createLocation("conifer_tree6")), 1)
                        .add(new FeatureSpawner(createLocation("conifer_tree7")), 1)
                        .build()),
                new PatternEntry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("conifer_tree8")), 1)
                        .build())

        ));
        map.put(createLocation("green_enchanted_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("green_enchanted_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("green_enchanted_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("green_enchanted_tree3")), 1)
                        .build())
        ));
        map.put(createLocation("holly_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("holly_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("holly_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("holly_tree4")), 1)
                        .build()),
                new PatternEntry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("holly_tree3")), 1)
                        .build())
        ));
        map.put(createLocation("jacaranda_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("jacaranda_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("jacaranda_tree2")), 1)
                        .build())
        ));
        map.put(createLocation("indigo_jacaranda_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("indigo_jacaranda_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("indigo_jacaranda_tree2")), 1)
                        .build())
        ));
        map.put(createLocation("joshua_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("joshua_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("joshua_tree2")), 1)
                        .build())
        ));
        map.put(createLocation("mahogany_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("mahogany_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("mahogany_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("mahogany_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("mahogany_tree4")), 1)
                        .build())
        ));
        map.put(createLocation("maple_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>single(new FeatureSpawner(createLocation("maple_tree1"))))
        ));
        map.put(createLocation("orange_birch_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("orange_birch_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("orange_birch_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("orange_birch_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("orange_birch_tree4")), 1)
                        .build())
        ));
        map.put(createLocation("orange_oak_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("deciduous_orange_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("deciduous_orange_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("deciduous_orange_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("deciduous_orange_tree4")), 1)
                        .add(new FeatureSpawner(createLocation("orange_oak_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("orange_oak_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("orange_oak_tree3")), 1)
                        .build()),
                new PatternEntry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("large_orange_oak_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("large_orange_oak_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("large_orange_oak_tree3")), 1)
                        .build())
        ));
        map.put(createLocation("orange_spruce_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("spruce_orange_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_orange_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_orange_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_orange_tree4")), 1)
                        .build()),
                new PatternEntry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("spruce_orange_tree_medium1")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_orange_tree_medium2")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_orange_tree_medium3")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_orange_tree_medium4")), 1)
                        .build()),
                new PatternEntry(List.of(
                        "xxx",
                        "xxx",
                        "xxx"), SimpleWeightedRandomList.single(new FeatureSpawner(createLocation("spruce_orange_tree_large1"))))
        ));
        map.put(createLocation("orchard_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("orchard_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("orchard_tree3")), 1)
                        .build()),
                new PatternEntry(List.of(
                        "xxx",
                        "xxx",
                        "xxx"), SimpleWeightedRandomList.single(new FeatureSpawner(createLocation("orchard_tree2"))))
        ));
        map.put(createLocation("palo_verde_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("palo_verde_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("palo_verde_tree2")), 1)
                        .build())
        ));
        map.put(createLocation("palo_verde_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("palo_verde_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("palo_verde_tree2")), 1)
                        .build())
        ));
        map.put(createLocation("pine_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("pine_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("pine_tree2")), 1)
                        .build())
        ));
        map.put(createLocation("pink_cherry_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>single(new FeatureSpawner(createLocation("pink_cherry_tree2")))),
                new PatternEntry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<FeatureSpawner>single(new FeatureSpawner(createLocation("pink_cherry_tree1"))))
        ));
        map.put(createLocation("rainbow_eucalyptus_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>single(new FeatureSpawner(createLocation("rainbow_eucalyptus_tree1")))),
                new PatternEntry(List.of(
                        " x ",
                        "xxx",
                        " x "), SimpleWeightedRandomList.<FeatureSpawner>single(new FeatureSpawner(createLocation("large_rainbow_eucalyptus_tree1"))))
        ));
        map.put(createLocation("red_birch_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("red_birch_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("red_birch_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("red_birch_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("red_birch_tree4")), 1)
                        .build())
        ));
        map.put(createLocation("red_maple_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("red_maple_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("red_maple_tree2")), 1)
                        .build())
        ));
        map.put(createLocation("red_oak_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("deciduous_red_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("deciduous_red_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("deciduous_red_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("deciduous_red_tree4")), 1)
                        .add(new FeatureSpawner(createLocation("red_oak_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("red_oak_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("red_oak_tree3")), 1)
                        .build()),
                new PatternEntry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("large_red_oak_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("large_red_oak_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("large_red_oak_tree3")), 1)
                        .build())
        ));
        map.put(createLocation("red_spruce_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("spruce_red_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_red_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_red_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_red_tree4")), 1)
                        .build()),
                new PatternEntry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("spruce_red_tree_medium1")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_red_tree_medium2")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_red_tree_medium3")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_red_tree_medium4")), 1)
                        .build()),
                new PatternEntry(List.of(
                        "xxx",
                        "xxx",
                        "xxx"), SimpleWeightedRandomList.single(new FeatureSpawner(createLocation("spruce_red_tree_large1"))))
        ));
        map.put(createLocation("redwood_sapling"), List.of(
                new PatternEntry(List.of(
                        " x ",
                        "xxx",
                        " x "), SimpleWeightedRandomList.single(new FeatureSpawner(createLocation("redwood_tree3")))),
                new PatternEntry(List.of(
                        "xxx",
                        "xxx",
                        "xxx"
                ), SimpleWeightedRandomList.single(new FeatureSpawner(createLocation("redwood_tree1")))),
                new PatternEntry(List.of(
                        "  x  ",
                        " xxx ",
                        "xxxxx",
                        " xxx ",
                        "  x  "
                ), SimpleWeightedRandomList.single(new FeatureSpawner(createLocation("redwood_tree2"))))
        ));
        map.put(createLocation("silver_maple_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("silver_maple_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("silver_maple_tree2")), 1)
                        .build())
        ));
        map.put(createLocation("skyris_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("skyris_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("skyris_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("skyris_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("skyris_tree4")), 1)
                        .add(new FeatureSpawner(createLocation("skyris_tree5")), 1)
                        .build())
        ));
        map.put(createLocation("white_cherry_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>single(new FeatureSpawner(createLocation("white_cherry_tree2")))),
                new PatternEntry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<FeatureSpawner>single(new FeatureSpawner(createLocation("white_cherry_tree1"))))
        ));
        map.put(createLocation("willow_sapling"), List.of(
                new PatternEntry(List.of(
                        "  x  ",
                        "     ",
                        "x   x",
                        "     ",
                        "  x  "), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("willow_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("willow_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("willow_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("willow_tree4")), 1)
                        .build())
        ));
        map.put(createLocation("witch_hazel_sapling"), List.of(
                new PatternEntry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("hazel_tree1")), 4)
                        .add(new FeatureSpawner(createLocation("hazel_tree2")), 4)
                        .add(new FeatureSpawner(createLocation("dead_hazel_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("dead_hazel_tree2")), 1)
                        .build())
        ));
        map.put(createLocation("yellow_birch_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("yellow_birch_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("yellow_birch_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("yellow_birch_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("yellow_birch_tree4")), 1)
                        .build())
        ));
        map.put(createLocation("yellow_spruce_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("spruce_yellow_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_yellow_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_yellow_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_yellow_tree4")), 1)
                        .build()),
                new PatternEntry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("spruce_yellow_tree_medium1")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_yellow_tree_medium2")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_yellow_tree_medium3")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_yellow_tree_medium4")), 1)
                        .build()),
                new PatternEntry(List.of(
                        "xxx",
                        "xxx",
                        "xxx"), SimpleWeightedRandomList.single(new FeatureSpawner(createLocation("spruce_yellow_tree_large1"))))
        ));
        map.put(createLocation("zelkova_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("zelkova_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("zelkova_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("zelkova_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("zelkova_brown_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("zelkova_brown_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("zelkova_brown_tree3")), 1)
                        .build())
        ));
        map.put(createLocation("palm_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("palm_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("palm_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("palm_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("palm_tree4")), 1)
                        .build())
        ));
        map.put(createLocation("lament_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("lament_twisty_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("lament_twisty_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("lament_twisty_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("lament_weeping_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("lament_weeping_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("lament_weeping_tree3")), 1)
                        .build())
        ));
        map.put(createLocation("withering_oak_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("withering_oak_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("withering_oak_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("withering_oak_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("withering_oak_tree4")), 1)
                        .add(new FeatureSpawner(createLocation("withering_oak_tree5")), 1)
                        .build())
        ));
        map.put(createLocation("ether_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("ether_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("ether_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("ether_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("ether_tree4")), 1)
                        .add(new FeatureSpawner(createLocation("ether_tree5")), 1)
                        .build())
        ));
        map.put(createLocation("nightshade_sapling"), List.of(
                new PatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("nightshade_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("nightshade_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("nightshade_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("nightshade_tree4")), 1)
                        .build())
        ));
    }));

    public static SaplingPatterns INSTANCE = null;

    public static final Codec<SaplingPatterns> CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(
                Codec.BOOL.optionalFieldOf("logSaplingGrowth", false).forGetter(saplingPatterns -> saplingPatterns.logSaplingGrowth),
                Codec.unboundedMap(ResourceLocation.CODEC, PatternEntry.CODEC.listOf()).fieldOf("sapling_patterns").forGetter(saplingPatterns -> saplingPatterns.saplingPatterns)
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

    public static void setInstance(SaplingPatterns instance) {
        SaplingPatterns.INSTANCE = instance;
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

    public record PatternEntry(List<String> pattern, SimpleWeightedRandomList<FeatureSpawner> spawners) {
        public static final Codec<PatternEntry> CODEC = RecordCodecBuilder.create(builder -> {
            return builder.group(
                    Codec.STRING.listOf().fieldOf("pattern").forGetter(patternEntry -> patternEntry.pattern),
                    SimpleWeightedRandomList.wrappedCodec(FeatureSpawner.CODEC).fieldOf("spawners").forGetter(overworldBiomeConfig -> overworldBiomeConfig.spawners)
            ).apply(builder, PatternEntry::new);
        });
    }

    public static final class FeatureSpawner {
        public static final Codec<FeatureSpawner> CODEC = RecordCodecBuilder.create(builder -> {
            return builder.group(
                    ResourceLocation.CODEC.fieldOf("featureID").forGetter(featureSpawner -> featureSpawner.spawnerID),
                    BlockPos.CODEC.optionalFieldOf("spawnOffset", BlockPos.ZERO).forGetter(featureSpawner -> featureSpawner.spawnOffset)
            ).apply(builder, FeatureSpawner::new);
        });

        private final ResourceLocation spawnerID;
        private final BlockPos spawnOffset;

        public FeatureSpawner(ResourceLocation spawnerID) {
            this(spawnerID, BlockPos.ZERO);
        }

        public FeatureSpawner(ResourceLocation spawnerID, BlockPos spawnOffset) {
            this.spawnerID = spawnerID;
            this.spawnOffset = spawnOffset;
        }

        public ResourceLocation spawnerID() {
            return spawnerID;
        }

        public BlockPos spawnOffset() {
            return spawnOffset;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (FeatureSpawner) obj;
            return Objects.equals(this.spawnerID, that.spawnerID) &&
                    Objects.equals(this.spawnOffset, that.spawnOffset);
        }

        @Override
        public int hashCode() {
            return Objects.hash(spawnerID, spawnOffset);
        }

        @Override
        public String toString() {
            return "Spawner[" +
                    "spawnerID=" + spawnerID + ", " +
                    "spawnOffset=" + spawnOffset + ']';
        }


    }
}
