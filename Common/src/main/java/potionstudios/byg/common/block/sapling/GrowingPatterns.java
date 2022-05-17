package potionstudios.byg.common.block.sapling;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.feature.features.end.BYGEndVegetationFeatures;
import potionstudios.byg.common.world.feature.features.nether.BYGNetherVegetationFeatures;
import potionstudios.byg.common.world.feature.features.overworld.BYGOverworldVegetationFeatures;
import potionstudios.byg.util.ModPlatform;

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

public record GrowingPatterns(boolean logGrowth, Map<ResourceLocation, List<GrowingPatternEntry>> patternsForBlock) {
    public static final int MAX_PATTERN_SIZE = 5;

    public static final GrowingPatterns DEFAULT = new GrowingPatterns(false, Util.make(new HashMap<>(), map -> {
        map.put(createLocation("araucaria_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder().add(new FeatureSpawner(createLocation("araucaria_tree1")), 1).add(new FeatureSpawner(createLocation("araucaria_tree2")), 1).build())
        ));
        map.put(createLocation("aspen_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder().add(new FeatureSpawner(createLocation("aspen_tree1")), 1).add(new FeatureSpawner(createLocation("aspen_tree2")), 1).add(new FeatureSpawner(createLocation("aspen_tree3")), 1).build())
        ));
        map.put(createLocation("baobab_sapling"), List.of(
                new GrowingPatternEntry(List.of(
                        "xxx",
                        "xxx",
                        "xxx"), SimpleWeightedRandomList.<FeatureSpawner>builder().add(new FeatureSpawner(createLocation("baobab_tree1")), 1).add(new FeatureSpawner(createLocation("baobab_tree2")), 1).build())
        ));
        map.put(createLocation("blue_enchanted_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder().add(new FeatureSpawner(createLocation("blue_enchanted_tree1")), 1).add(new FeatureSpawner(createLocation("blue_enchanted_tree2")), 1).build())
        ));
        map.put(createLocation("blue_spruce_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("spruce_blue_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_blue_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_blue_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_blue_tree4")), 1)
                        .build()),
                new GrowingPatternEntry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("spruce_blue_tree_medium1")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_blue_tree_medium2")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_blue_tree_medium3")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_blue_tree_medium4")), 1)
                        .build()),
                new GrowingPatternEntry(List.of(
                        "xxx",
                        "xxx",
                        "xxx"), SimpleWeightedRandomList.single(new FeatureSpawner(createLocation("spruce_blue_tree_large1"))))
        ));
        map.put(createLocation("brown_birch_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("brown_birch_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("brown_birch_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("brown_birch_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("brown_birch_tree4")), 1)
                        .build())
        ));
        map.put(createLocation("brown_oak_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("deciduous_brown_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("deciduous_brown_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("deciduous_brown_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("deciduous_brown_tree4")), 1)
                        .add(new FeatureSpawner(createLocation("brown_oak_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("brown_oak_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("brown_oak_tree3")), 1)
                        .build()),
                new GrowingPatternEntry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("large_brown_oak_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("large_brown_oak_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("large_brown_oak_tree3")), 1)
                        .build())
        ));
        map.put(createLocation("brown_zelkova_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("zelkova_brown_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("zelkova_brown_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("zelkova_brown_tree3")), 1)
                        .build())
        ));
        map.put(createLocation("cika_sapling"), List.of(
                new GrowingPatternEntry(List.of(
                        " x ",
                        "xxx",
                        " x "), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("cika_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("cika_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("cika_tree3")), 1)
                        .build())
        ));
        map.put(createLocation("cypress_sapling"), List.of(
                new GrowingPatternEntry(List.of(
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
                new GrowingPatternEntry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("ebony_bush1")), 1)
                        .add(new FeatureSpawner(createLocation("ebony_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("ebony_tree2")), 1)
                        .build())
        ));
        map.put(createLocation("fir_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("conifer_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("conifer_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("conifer_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("conifer_tree4")), 1)
                        .add(new FeatureSpawner(createLocation("conifer_tree5")), 1)
                        .add(new FeatureSpawner(createLocation("conifer_tree6")), 1)
                        .add(new FeatureSpawner(createLocation("conifer_tree7")), 1)
                        .build()),
                new GrowingPatternEntry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("conifer_tree8")), 1)
                        .build())

        ));
        map.put(createLocation("green_enchanted_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("green_enchanted_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("green_enchanted_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("green_enchanted_tree3")), 1)
                        .build())
        ));
        map.put(createLocation("holly_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("holly_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("holly_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("holly_tree4")), 1)
                        .build()),
                new GrowingPatternEntry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("holly_tree3")), 1)
                        .build())
        ));
        map.put(createLocation("jacaranda_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("jacaranda_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("jacaranda_tree2")), 1)
                        .build())
        ));
        map.put(createLocation("indigo_jacaranda_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("indigo_jacaranda_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("indigo_jacaranda_tree2")), 1)
                        .build())
        ));
        map.put(createLocation("joshua_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("joshua_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("joshua_tree2")), 1)
                        .build())
        ));
        map.put(createLocation("mahogany_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("mahogany_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("mahogany_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("mahogany_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("mahogany_tree4")), 1)
                        .build())
        ));
        map.put(createLocation("mangrove_sapling"), List.of(
                new GrowingPatternEntry(List.of(
                        "  x  ",
                        "x   x",
                        "  x  "), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("mangrove_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("mangrove_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("mangrove_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("mangrove_tree4")), 1)
                        .add(new FeatureSpawner(createLocation("mangrove_tree5")), 1)
                        .build())
        ));

        map.put(createLocation("maple_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>single(new FeatureSpawner(createLocation("maple_tree1"))))
        ));
        map.put(createLocation("orange_birch_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("orange_birch_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("orange_birch_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("orange_birch_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("orange_birch_tree4")), 1)
                        .build())
        ));
        map.put(createLocation("orange_oak_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("deciduous_orange_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("deciduous_orange_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("deciduous_orange_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("deciduous_orange_tree4")), 1)
                        .add(new FeatureSpawner(createLocation("orange_oak_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("orange_oak_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("orange_oak_tree3")), 1)
                        .build()),
                new GrowingPatternEntry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("large_orange_oak_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("large_orange_oak_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("large_orange_oak_tree3")), 1)
                        .build())
        ));
        map.put(createLocation("orange_spruce_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("spruce_orange_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_orange_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_orange_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_orange_tree4")), 1)
                        .build()),
                new GrowingPatternEntry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("spruce_orange_tree_medium1")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_orange_tree_medium2")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_orange_tree_medium3")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_orange_tree_medium4")), 1)
                        .build()),
                new GrowingPatternEntry(List.of(
                        "xxx",
                        "xxx",
                        "xxx"), SimpleWeightedRandomList.single(new FeatureSpawner(createLocation("spruce_orange_tree_large1"))))
        ));
        map.put(createLocation("orchard_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("orchard_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("orchard_tree3")), 1)
                        .build()),
                new GrowingPatternEntry(List.of(
                        "xxx",
                        "xxx",
                        "xxx"), SimpleWeightedRandomList.single(new FeatureSpawner(createLocation("orchard_tree2"))))
        ));
        map.put(createLocation("palo_verde_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("palo_verde_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("palo_verde_tree2")), 1)
                        .build())
        ));
        map.put(createLocation("palo_verde_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("palo_verde_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("palo_verde_tree2")), 1)
                        .build())
        ));
        map.put(createLocation("pine_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("pine_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("pine_tree2")), 1)
                        .build())
        ));
        map.put(createLocation("pink_cherry_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>single(new FeatureSpawner(createLocation("pink_cherry_tree2")))),
                new GrowingPatternEntry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<FeatureSpawner>single(new FeatureSpawner(createLocation("pink_cherry_tree1"))))
        ));
        map.put(createLocation("rainbow_eucalyptus_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>single(new FeatureSpawner(createLocation("rainbow_eucalyptus_tree1")))),
                new GrowingPatternEntry(List.of(
                        " x ",
                        "xxx",
                        " x "), SimpleWeightedRandomList.<FeatureSpawner>single(new FeatureSpawner(createLocation("large_rainbow_eucalyptus_tree1"))))
        ));
        map.put(createLocation("red_birch_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("red_birch_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("red_birch_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("red_birch_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("red_birch_tree4")), 1)
                        .build())
        ));
        map.put(createLocation("red_maple_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("red_maple_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("red_maple_tree2")), 1)
                        .build())
        ));
        map.put(createLocation("red_oak_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("deciduous_red_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("deciduous_red_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("deciduous_red_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("deciduous_red_tree4")), 1)
                        .add(new FeatureSpawner(createLocation("red_oak_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("red_oak_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("red_oak_tree3")), 1)
                        .build()),
                new GrowingPatternEntry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("large_red_oak_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("large_red_oak_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("large_red_oak_tree3")), 1)
                        .build())
        ));
        map.put(createLocation("red_spruce_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("spruce_red_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_red_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_red_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_red_tree4")), 1)
                        .build()),
                new GrowingPatternEntry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("spruce_red_tree_medium1")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_red_tree_medium2")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_red_tree_medium3")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_red_tree_medium4")), 1)
                        .build()),
                new GrowingPatternEntry(List.of(
                        "xxx",
                        "xxx",
                        "xxx"), SimpleWeightedRandomList.single(new FeatureSpawner(createLocation("spruce_red_tree_large1"))))
        ));
        map.put(createLocation("redwood_sapling"), List.of(
                new GrowingPatternEntry(List.of(
                        " x ",
                        "xxx",
                        " x "), SimpleWeightedRandomList.single(new FeatureSpawner(createLocation("redwood_tree3")))),
                new GrowingPatternEntry(List.of(
                        "xxx",
                        "xxx",
                        "xxx"
                ), SimpleWeightedRandomList.single(new FeatureSpawner(createLocation("redwood_tree1")))),
                new GrowingPatternEntry(List.of(
                        "  x  ",
                        " xxx ",
                        "xxxxx",
                        " xxx ",
                        "  x  "
                ), SimpleWeightedRandomList.single(new FeatureSpawner(createLocation("redwood_tree2"))))
        ));
        map.put(createLocation("silver_maple_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("silver_maple_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("silver_maple_tree2")), 1)
                        .build())
        ));
        map.put(createLocation("skyris_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("skyris_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("skyris_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("skyris_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("skyris_tree4")), 1)
                        .add(new FeatureSpawner(createLocation("skyris_tree5")), 1)
                        .build())
        ));
        map.put(createLocation("white_cherry_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>single(new FeatureSpawner(createLocation("white_cherry_tree2")))),
                new GrowingPatternEntry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<FeatureSpawner>single(new FeatureSpawner(createLocation("white_cherry_tree1"))))
        ));
        map.put(createLocation("willow_sapling"), List.of(
                new GrowingPatternEntry(List.of(
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
                new GrowingPatternEntry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("hazel_tree1")), 4)
                        .add(new FeatureSpawner(createLocation("hazel_tree2")), 4)
                        .add(new FeatureSpawner(createLocation("dead_hazel_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("dead_hazel_tree2")), 1)
                        .build())
        ));
        map.put(createLocation("yellow_birch_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("yellow_birch_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("yellow_birch_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("yellow_birch_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("yellow_birch_tree4")), 1)
                        .build())
        ));
        map.put(createLocation("yellow_spruce_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("spruce_yellow_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_yellow_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_yellow_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_yellow_tree4")), 1)
                        .build()),
                new GrowingPatternEntry(List.of(
                        "xx",
                        "xx"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("spruce_yellow_tree_medium1")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_yellow_tree_medium2")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_yellow_tree_medium3")), 1)
                        .add(new FeatureSpawner(createLocation("spruce_yellow_tree_medium4")), 1)
                        .build()),
                new GrowingPatternEntry(List.of(
                        "xxx",
                        "xxx",
                        "xxx"), SimpleWeightedRandomList.single(new FeatureSpawner(createLocation("spruce_yellow_tree_large1"))))
        ));
        map.put(createLocation("zelkova_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("zelkova_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("zelkova_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("zelkova_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("zelkova_brown_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("zelkova_brown_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("zelkova_brown_tree3")), 1)
                        .build())
        ));
        map.put(createLocation("palm_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("palm_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("palm_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("palm_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("palm_tree4")), 1)
                        .build())
        ));
        map.put(createLocation("lament_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("lament_twisty_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("lament_twisty_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("lament_twisty_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("lament_weeping_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("lament_weeping_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("lament_weeping_tree3")), 1)
                        .build())
        ));
        map.put(createLocation("withering_oak_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("withering_oak_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("withering_oak_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("withering_oak_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("withering_oak_tree4")), 1)
                        .add(new FeatureSpawner(createLocation("withering_oak_tree5")), 1)
                        .build())
        ));
        map.put(createLocation("ether_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("ether_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("ether_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("ether_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("ether_tree4")), 1)
                        .add(new FeatureSpawner(createLocation("ether_tree5")), 1)
                        .build())
        ));
        map.put(createLocation("nightshade_sapling"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(createLocation("nightshade_tree1")), 1)
                        .add(new FeatureSpawner(createLocation("nightshade_tree2")), 1)
                        .add(new FeatureSpawner(createLocation("nightshade_tree3")), 1)
                        .add(new FeatureSpawner(createLocation("nightshade_tree4")), 1)
                        .build())
        ));
        map.put(createLocation("embur_wart"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(BYGNetherVegetationFeatures.EMBUR_MUSHROOM), 1)
                        .add(new FeatureSpawner(BYGNetherVegetationFeatures.EMBUR_MUSHROOM2), 1)
                        .add(new FeatureSpawner(BYGNetherVegetationFeatures.EMBUR_MUSHROOM3), 1)
                        .add(new FeatureSpawner(BYGNetherVegetationFeatures.EMBUR_MUSHROOM4), 1)
                        .build())
        ));

        map.put(createLocation("weeping_milkcap"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(BYGOverworldVegetationFeatures.WEEPING_MILKCAP_HUGE), 1)
                        .build())
        ));

        map.put(createLocation("wood_blewit"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(BYGOverworldVegetationFeatures.WOOD_BLEWIT_HUGE), 1)
                        .build())
        ));

        map.put(createLocation("green_mushroom"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(BYGOverworldVegetationFeatures.GREEN_MUSHROOM_HUGE), 1)
                        .build())
        ));

        map.put(createLocation("sythian_fungus"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(BYGNetherVegetationFeatures.SYTHIAN_FUNGUS_TREE1), 1)
                        .add(new FeatureSpawner(BYGNetherVegetationFeatures.SYTHIAN_FUNGUS_TREE2), 1)
                        .add(new FeatureSpawner(BYGNetherVegetationFeatures.SYTHIAN_FUNGUS_TREE3), 1)
                        .add(new FeatureSpawner(BYGNetherVegetationFeatures.SYTHIAN_FUNGUS_TREE4), 1)
                        .build())
        ));

        map.put(createLocation("soul_shroom"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(BYGNetherVegetationFeatures.SOUL_SHROOM_TREE1), 1)
                        .add(new FeatureSpawner(BYGNetherVegetationFeatures.SOUL_SHROOM_TREE2), 1)
                        .add(new FeatureSpawner(BYGNetherVegetationFeatures.SOUL_SHROOM_TREE3), 1)
                        .build())
        ));

        map.put(createLocation("death_cap"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(BYGNetherVegetationFeatures.DEATH_CAP_TREE1), 1)
                        .add(new FeatureSpawner(BYGNetherVegetationFeatures.DEATH_CAP_TREE2), 1)
                        .add(new FeatureSpawner(BYGNetherVegetationFeatures.DEATH_CAP_TREE3), 1)
                        .build())
        ));

        map.put(createLocation("bulbis_oddity"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(BYGEndVegetationFeatures.BULBIS_TREE1), 1)
                        .add(new FeatureSpawner(BYGEndVegetationFeatures.BULBIS_TREE2), 1)
                        .add(new FeatureSpawner(BYGEndVegetationFeatures.BULBIS_TREE3), 1)
                        .add(new FeatureSpawner(BYGEndVegetationFeatures.BULBIS_TREE4), 1)
                        .add(new FeatureSpawner(BYGEndVegetationFeatures.BULBIS_TREE5), 1)
                        .add(new FeatureSpawner(BYGEndVegetationFeatures.BULBIS_TREE6), 1)
                        .add(new FeatureSpawner(BYGEndVegetationFeatures.BULBIS_TREE7), 1)
                        .build())
        ));

        map.put(createLocation("purple_bulbis_oddity"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(BYGEndVegetationFeatures.PURPLE_BULBIS_TREE1), 1)
                        .add(new FeatureSpawner(BYGEndVegetationFeatures.PURPLE_BULBIS_TREE2), 1)
                        .add(new FeatureSpawner(BYGEndVegetationFeatures.PURPLE_BULBIS_TREE3), 1)
                        .add(new FeatureSpawner(BYGEndVegetationFeatures.PURPLE_BULBIS_TREE4), 1)
                        .add(new FeatureSpawner(BYGEndVegetationFeatures.PURPLE_BULBIS_TREE5), 1)
                        .add(new FeatureSpawner(BYGEndVegetationFeatures.PURPLE_BULBIS_TREE6), 1)
                        .add(new FeatureSpawner(BYGEndVegetationFeatures.PURPLE_BULBIS_TREE7), 1)
                        .build())
        ));

        map.put(createLocation("shulkren_fungus"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(BYGEndVegetationFeatures.SHULKREN_TREE1), 1)
                        .add(new FeatureSpawner(BYGEndVegetationFeatures.SHULKREN_TREE2), 1)
                        .build())
        ));
        map.put(createLocation("imparius_mushroom"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(BYGEndVegetationFeatures.IMPARIUS_MUSHROOM1), 1)
                        .add(new FeatureSpawner(BYGEndVegetationFeatures.IMPARIUS_MUSHROOM2), 1)
                        .add(new FeatureSpawner(BYGEndVegetationFeatures.IMPARIUS_MUSHROOM3), 1)
                        .add(new FeatureSpawner(BYGEndVegetationFeatures.IMPARIUS_MUSHROOM4), 1)
                        .add(new FeatureSpawner(BYGEndVegetationFeatures.IMPARIUS_MUSHROOM5), 1)
                        .add(new FeatureSpawner(BYGEndVegetationFeatures.IMPARIUS_MUSHROOM6), 1)
                        .build())
        ));
        map.put(createLocation("fungal_imparius"), List.of(
                new GrowingPatternEntry(List.of("x"), SimpleWeightedRandomList.<FeatureSpawner>builder()
                        .add(new FeatureSpawner(BYGEndVegetationFeatures.FUNGAL_IMPARIUS1), 1)
                        .add(new FeatureSpawner(BYGEndVegetationFeatures.FUNGAL_IMPARIUS2), 1)
                        .add(new FeatureSpawner(BYGEndVegetationFeatures.FUNGAL_IMPARIUS3), 1)
                        .add(new FeatureSpawner(BYGEndVegetationFeatures.FUNGAL_IMPARIUS4), 1)
                        .add(new FeatureSpawner(BYGEndVegetationFeatures.FUNGAL_IMPARIUS5), 1)
                        .build())
        ));
    }));

    public static GrowingPatterns INSTANCE = null;

    public static final Codec<GrowingPatterns> CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(
                Codec.BOOL.optionalFieldOf("logGrowth", false).forGetter(saplingPatterns -> saplingPatterns.logGrowth),
                Codec.unboundedMap(ResourceLocation.CODEC, GrowingPatternEntry.CODEC.listOf()).fieldOf("sapling_patterns").forGetter(saplingPatterns -> saplingPatterns.patternsForBlock)
        ).apply(builder, GrowingPatterns::new);
    });


    public static GrowingPatterns getConfig() {
        return getConfig(false, false);
    }

    public static GrowingPatterns getConfig(boolean serialize, boolean recreate) {
        if (INSTANCE == null || serialize || recreate) {
            INSTANCE = readConfig(recreate);
        }
        return INSTANCE;
    }

    public static void setInstance(GrowingPatterns instance) {
        GrowingPatterns.INSTANCE = instance;
    }

    private static GrowingPatterns readConfig(boolean recreate) {
        final Path path = ModPlatform.INSTANCE.configPath().resolve(BYG.MOD_ID + "-sapling-patterns.json");

        if (!path.toFile().exists() || recreate) {
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

    public record GrowingPatternEntry(List<String> pattern, SimpleWeightedRandomList<FeatureSpawner> spawners) {
        public static final Codec<GrowingPatternEntry> CODEC = RecordCodecBuilder.create(builder -> {
            return builder.group(
                    Codec.STRING.listOf().fieldOf("pattern").forGetter(growingPatternEntry -> growingPatternEntry.pattern),
                    SimpleWeightedRandomList.wrappedCodec(FeatureSpawner.CODEC).fieldOf("spawners").forGetter(overworldBiomeConfig -> overworldBiomeConfig.spawners)
            ).apply(builder, GrowingPatternEntry::new);
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

        public FeatureSpawner(Holder<?> spawnerID) {
            this(spawnerID.unwrapKey().orElseThrow());
        }

        public FeatureSpawner(ResourceKey<?> spawnerID) {
            this(spawnerID.location(), BlockPos.ZERO);
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
