package voronoiaoc.byg.core.byglists;

import com.google.common.collect.ImmutableList;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.*;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatureConfigs;
import voronoiaoc.byg.common.world.feature.placements.AtOceanFloorWithExtra;

public class BYGConfiguredTreeFeatures {
    /***********************************************************Configured Features********************************************************/
    public static final ConfiguredFeature<?, ?> ACACIA_TREE1 = newConfiguredFeature("acacia_tree1", BYGFeatureList.ACACIA_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ANCIENT_TREE1 = newConfiguredFeature("ancient_tree1", BYGFeatureList.ANCIENT_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ANCIENT_TREE2 = newConfiguredFeature("ancient_tree2", BYGFeatureList.ANCIENT_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ANCIENT_TREE3 = newConfiguredFeature("ancient_tree3", BYGFeatureList.ANCIENT_TREE2.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> ASPEN_SHRUB1 = newConfiguredFeature("aspen_shrub1", BYGFeatureList.ASPEN_SHRUB1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ASPEN_SHRUB2 = newConfiguredFeature("aspen_shrub2", BYGFeatureList.ASPEN_SHRUB2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ASPEN_TREE1 = newConfiguredFeature("aspen_tree1", BYGFeatureList.ASPEN_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ASPEN_TREE2 = newConfiguredFeature("aspen_tree2", BYGFeatureList.ASPEN_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ASPEN_TREE3 = newConfiguredFeature("aspen_tree3", BYGFeatureList.ASPEN_TREE3.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> BAOBAB_TREE1 = newConfiguredFeature("baobab_tree1", BYGFeatureList.BAOBAB_TREE1.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> BIRCH_BROWN_TREE1 = newConfiguredFeature("brown_birch_tree1", BYGFeatureList.BIRCH_BROWN_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> BIRCH_ORANGE_TREE1 = newConfiguredFeature("orange_birch_tree1", BYGFeatureList.BIRCH_ORANGE_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> BIRCH_RED_TREE1 = newConfiguredFeature("red_birch_tree1", BYGFeatureList.BIRCH_RED_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> BIRCH_YELLOW_TREE1 = newConfiguredFeature("yellow_birch_tree1", BYGFeatureList.BIRCH_YELLOW_TREE1.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> BLUFF_TREE1 = newConfiguredFeature("bluff_tree1", BYGFeatureList.BLUFF_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> BLUFF_TREE2 = newConfiguredFeature("bluff_tree2", BYGFeatureList.BLUFF_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> BLUFF_TREE3 = newConfiguredFeature("bluff_tree3", BYGFeatureList.BLUFF_TREE3.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> BOREAL_TREE1 = newConfiguredFeature("boreal_tree1", BYGFeatureList.BOREAL_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> BOREAL_TREE2 = newConfiguredFeature("boreal_tree2", BYGFeatureList.BOREAL_TREE2.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> CHERRY_PINK_TREE1 = newConfiguredFeature("pink_cherry_tree1", BYGFeatureList.CHERRY_PINK_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> CHERRY_PINK_TREE2 = newConfiguredFeature("pink_cherry_tree2", BYGFeatureList.CHERRY_PINK_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> CHERRY_WHITE_TREE1 = newConfiguredFeature("white_cherry_tree1", BYGFeatureList.CHERRY_WHITE_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> CHERRY_WHITE_TREE2 = newConfiguredFeature("white_cherry_tree2", BYGFeatureList.CHERRY_WHITE_TREE2.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> CIKA_TREE1 = newConfiguredFeature("cika_tree1", BYGFeatureList.CIKA_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> CIKA_TREE2 = newConfiguredFeature("cika_tree2", BYGFeatureList.CIKA_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> CIKA_TREE3 = newConfiguredFeature("cika_tree3", BYGFeatureList.CIKA_TREE3.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> CONIFER_TREE1 = newConfiguredFeature("conifer_tree1", BYGFeatureList.CONIFER_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> CONIFER_TREE2 = newConfiguredFeature("conifer_tree2", BYGFeatureList.CONIFER_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> CONIFER_TREE3 = newConfiguredFeature("conifer_tree3", BYGFeatureList.CONIFER_TREE3.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> CONIFER_TREE4 = newConfiguredFeature("conifer_tree4", BYGFeatureList.CONIFER_TREE4.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> CONIFER_TREE5 = newConfiguredFeature("conifer_tree5", BYGFeatureList.CONIFER_TREE5.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> CONIFER_TREE6 = newConfiguredFeature("conifer_tree6", BYGFeatureList.CONIFER_TREE6.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> CONIFER_TREE7 = newConfiguredFeature("conifer_tree7", BYGFeatureList.CONIFER_TREE7.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> CONIFER_TREE8 = newConfiguredFeature("conifer_tree8", BYGFeatureList.CONIFER_TREE8.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> CYPRESS_TREE1 = newConfiguredFeature("cypress_tree1", BYGFeatureList.CYPRESS_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> CYPRESS_TREE2 = newConfiguredFeature("cypress_tree2", BYGFeatureList.CYPRESS_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> CYPRESS_TREE3 = newConfiguredFeature("cypress_tree3", BYGFeatureList.CYPRESS_TREE3.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> DEAD_HAZEL_TREE1 = newConfiguredFeature("dead_hazel_tree1", BYGFeatureList.DEAD_HAZEL_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> DEAD_HAZEL_TREE2 = newConfiguredFeature("dead_hazel_tree2", BYGFeatureList.DEAD_HAZEL_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> DEAD_HAZEL_TREE3 = newConfiguredFeature("dead_hazel_tree3", BYGFeatureList.DEAD_HAZEL_TREE3.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> DEAD_HAZEL_TREE4 = newConfiguredFeature("dead_hazel_tree4", BYGFeatureList.DEAD_HAZEL_TREE4.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> DECIDUOUS_TREE1 = newConfiguredFeature("deciduous_tree1", BYGFeatureList.DECIDUOUS_TREE.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> DECIDUOUS_BROWN_TREE1 = newConfiguredFeature("brown_deciduous_tree1", BYGFeatureList.DECIDUOUS_BROWN_TREE.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> DECIDUOUS_ORANGE_TREE1 = newConfiguredFeature("orange_deciduous_tree1", BYGFeatureList.DECIDUOUS_ORANGE_TREE.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> DECIDUOUS_YELLOW_TREE1 = newConfiguredFeature("yellow_deciduous_tree1", BYGFeatureList.DECIDUOUS_YELLOW_TREE.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> DECIDUOUS_RED_TREE1 = newConfiguredFeature("red_deciduous_tree1", BYGFeatureList.DECIDUOUS_RED_TREE.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> DECIDUOUS_SEASONAL_SHRUB = newConfiguredFeature("seasonal_deciduous_shrub", BYGFeatureList.DECIDUOUS_SEASONAL_SHRUBS.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> EBONY_BUSH1 = newConfiguredFeature("ebony_bush1", BYGFeatureList.EBONY_BUSH1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> EBONY_TREE1 = newConfiguredFeature("ebony_tree1", BYGFeatureList.EBONY_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> EBONY_TREE2 = newConfiguredFeature("ebony_tree2", BYGFeatureList.EBONY_TREE2.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> ENCHANTED_BLUE_TREE1 = newConfiguredFeature("blue_enchanted_tree1", BYGFeatureList.ENCHANTED_BLUE_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ENCHANTED_BLUE_TREE2 = newConfiguredFeature("blue_enchanted_tree2", BYGFeatureList.ENCHANTED_BLUE_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ENCHANTED_BLUE_TREE3 = newConfiguredFeature("blue_enchanted_tree3", BYGFeatureList.ENCHANTED_BLUE_TREE3.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ENCHANTED_GREEN_TREE1 = newConfiguredFeature("green_enchanted_tree1", BYGFeatureList.ENCHANTED_GREEN_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ENCHANTED_GREEN_TREE2 = newConfiguredFeature("green_enchanted_tree2", BYGFeatureList.ENCHANTED_GREEN_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ENCHANTED_GREEN_TREE3 = newConfiguredFeature("green_enchanted_tree3", BYGFeatureList.ENCHANTED_GREEN_TREE3.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> ENCHANTED_BLUE_GROVE_TREE1 = newConfiguredFeature("blue_enchanted_grove_tree1", BYGFeatureList.ENCHANTED_BLUE_GROVE_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ENCHANTED_GREEN_GROVE_TREE1 = newConfiguredFeature("green_enchanted_grove_tree1", BYGFeatureList.ENCHANTED_GREEN_GROVE_TREE1.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> HOLLY_TREE1 = newConfiguredFeature("holly_tree1", BYGFeatureList.HOLLY_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> HOLLY_TREE2 = newConfiguredFeature("holly_tree2", BYGFeatureList.HOLLY_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> HOLLY_TREE3 = newConfiguredFeature("holly_tree3", BYGFeatureList.HOLLY_TREE3.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> HOLLY_TREE4 = newConfiguredFeature("holly_tree4", BYGFeatureList.HOLLY_TREE4.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> JACARANDA_TREE1 = newConfiguredFeature("jacaranda_tree1", BYGFeatureList.JACARANDA_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> JACARANDA_TREE2 = newConfiguredFeature("jacaranda_tree2", BYGFeatureList.JACARANDA_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> INDIGO_JACARANDA_TREE1 = newConfiguredFeature("indigo_jacaranda_tree1", BYGFeatureList.JACARANDA_INDIGO_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> INDIGO_JACARANDA_TREE2 = newConfiguredFeature("indigo_jacaranda_tree2", BYGFeatureList.JACARANDA_INDIGO_TREE2.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> JOSHUA_TREE1 = newConfiguredFeature("joshua_tree1", BYGFeatureList.JOSHUA_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> JOSHUA_TREE2 = newConfiguredFeature("joshua_tree2", BYGFeatureList.JOSHUA_TREE2.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> MANGROVE_TREE1 = newConfiguredFeature("mangrove_tree1", BYGFeatureList.MANGROVE_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> MANGROVE_TREE2 = newConfiguredFeature("mangrove_tree2", BYGFeatureList.MANGROVE_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> MANGROVE_TREE3 = newConfiguredFeature("mangrove_tree3", BYGFeatureList.MANGROVE_TREE3.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> MANGROVE_TREE4 = newConfiguredFeature("mangrove_tree4", BYGFeatureList.MANGROVE_TREE4.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> MANGROVE_TREE5 = newConfiguredFeature("mangrove_tree5", BYGFeatureList.MANGROVE_TREE5.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> MAPLE_RED_TREE1 = newConfiguredFeature("red_maple_tree1", BYGFeatureList.MAPLE_RED_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> MAPLE_RED_TREE2 = newConfiguredFeature("red_maple_tree2", BYGFeatureList.MAPLE_RED_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> MAPLE_SILVER_TREE1 = newConfiguredFeature("silver_maple_tree1", BYGFeatureList.MAPLE_SILVER_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> MAPLE_SILVER_TREE2 = newConfiguredFeature("silver_maple_tree2", BYGFeatureList.MAPLE_SILVER_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> MAPLE_TREE1 = newConfiguredFeature("maple_tree2", BYGFeatureList.MAPLE_TREE.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> MEADOW_TREE1 = newConfiguredFeature("meadow_tree1", BYGFeatureList.MEADOW_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> MEADOW_TREE2 = newConfiguredFeature("meadow_tree2", BYGFeatureList.MEADOW_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> MEADOW_TREE3 = newConfiguredFeature("meadow_tree3", BYGFeatureList.MEADOW_TREE3.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> ORCHARD_TREE1 = newConfiguredFeature("orchard_tree1", BYGFeatureList.ORCHARD_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ORCHARD_TREE2 = newConfiguredFeature("orchard_tree2", BYGFeatureList.ORCHARD_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ORCHARD_TREE3 = newConfiguredFeature("orchard_tree3", BYGFeatureList.ORCHARD_TREE3.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> PALM_TREE1 = newConfiguredFeature("palm_tree1", BYGFeatureList.PALM_TREE1.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> PINE_LARGE_TREE1 = newConfiguredFeature("large_pine_tree1", BYGFeatureList.PINE_LARGE_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> PINE_LARGE_TREE2 = newConfiguredFeature("large_pine_tree2", BYGFeatureList.PINE_LARGE_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> PINE_TREE1 = newConfiguredFeature("pine_tree1", BYGFeatureList.PINE_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> PINE_TREE2 = newConfiguredFeature("pine_tree2", BYGFeatureList.PINE_TREE2.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> PALO_VERDE_TREE1 = newConfiguredFeature("palo_verde_tree1", BYGFeatureList.PALO_VERDE_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> PALO_VERDE_TREE2 = newConfiguredFeature("palo_verde_tree2", BYGFeatureList.PALO_VERDE_TREE2.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> RAINBOW_TREE1 = newConfiguredFeature("rainbow_eucalyptus_tree1", BYGFeatureList.RAINBOW_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> RAINBOW_LARGE_TREE1 = newConfiguredFeature("large_rainbow_eucalyptus_tree1", BYGFeatureList.RAINBOW_LARGE_TREE1.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> REDWOOD_TREE1 = newConfiguredFeature("redwood_tree1", BYGFeatureList.REDWOOD_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> REDWOOD_TREE2 = newConfiguredFeature("redwood_tree2", BYGFeatureList.REDWOOD_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> REDWOOD_TREE3 = newConfiguredFeature("redwood_tree3", BYGFeatureList.REDWOOD_TREE3.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> OAK_BROWN_TREE1 = newConfiguredFeature("brown_oak_tree1", BYGFeatureList.OAK_BROWN_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> OAK_ORANGE_TREE = newConfiguredFeature("orange_oak_tree1", BYGFeatureList.OAK_ORANGE_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> OAK_RED_TREE = newConfiguredFeature("red_oak_tree1", BYGFeatureList.OAK_RED_TREE1.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> SHRUB = newConfiguredFeature("shrub", BYGFeatureList.SHRUB.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> SHRUB_MEADOW = newConfiguredFeature("meadow_shrub1", BYGFeatureList.SHRUB_MEADOW1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> SHRUB_MEADOW2 = newConfiguredFeature("meadow_shrub2", BYGFeatureList.SHRUB_MEADOW2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> SHRUB_PRAIRIE1 = newConfiguredFeature("prairie_shrub1", BYGFeatureList.SHRUB_PRAIRIE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> SHRUB_PRAIRIE2 = newConfiguredFeature("prairie_shrub2", BYGFeatureList.SHRUB_PRAIRIE2.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> SKYRIS_TREE1 = newConfiguredFeature("skyris_tree1", BYGFeatureList.SKYRIS_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> SKYRIS_TREE2 = newConfiguredFeature("skyris_tree2", BYGFeatureList.SKYRIS_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> SKYRIS_TREE3 = newConfiguredFeature("skyris_tree3", BYGFeatureList.SKYRIS_TREE3.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> BLUE_GIANT_SPRUCE_TREE = newConfiguredFeature("blue_giant_spruce_tree", BYGFeatureList.BLUE_GIANT_SPRUCE_TREE.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> BLUE_TALL_SPRUCE_TREE = newConfiguredFeature("blue_tall_spruce_tree", BYGFeatureList.BLUE_TALL_SPRUCE_TREE.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> BLUE_SPRUCE_TREE = newConfiguredFeature("blue_spruce_tree", BYGFeatureList.BLUE_SPRUCE_TREE.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> BLUE_SMALL_SPRUCE_TREE = newConfiguredFeature("blue_small_spruce_tree", BYGFeatureList.BLUE_SMALL_SPRUCE_TREE.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> ORANGE_GIANT_SPRUCE_TREE = newConfiguredFeature("orange_giant_spruce_tree", BYGFeatureList.ORANGE_GIANT_SPRUCE_TREE.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ORANGE_TALL_SPRUCE_TREE = newConfiguredFeature("orange_tall_spruce_tree", BYGFeatureList.ORANGE_TALL_SPRUCE_TREE.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ORANGE_SPRUCE_TREE = newConfiguredFeature("orange_spruce_tree", BYGFeatureList.ORANGE_SPRUCE_TREE.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ORANGE_SMALL_SPRUCE_TREE = newConfiguredFeature("orange_small_spruce_tree", BYGFeatureList.ORANGE_SMALL_SPRUCE_TREE.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> RED_GIANT_SPRUCE_TREE = newConfiguredFeature("red_giant_spruce_tree", BYGFeatureList.RED_GIANT_SPRUCE_TREE.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> RED_TALL_SPRUCE_TREE = newConfiguredFeature("red_tall_spruce_tree", BYGFeatureList.RED_TALL_SPRUCE_TREE.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> RED_SPRUCE_TREE = newConfiguredFeature("red_spruce_tree", BYGFeatureList.RED_SPRUCE_TREE.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> RED_SMALL_SPRUCE_TREE = newConfiguredFeature("red_small_spruce_tree", BYGFeatureList.RED_SMALL_SPRUCE_TREE.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> YELLOW_GIANT_SPRUCE_TREE = newConfiguredFeature("yellow_giant_spruce_tree", BYGFeatureList.YELLOW_GIANT_SPRUCE_TREE.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> YELLOW_TALL_SPRUCE_TREE = newConfiguredFeature("yellow_tall_spruce_tree", BYGFeatureList.YELLOW_TALL_SPRUCE_TREE.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> YELLOW_SPRUCE_TREE = newConfiguredFeature("yellow_spruce_tree", BYGFeatureList.YELLOW_SPRUCE_TREE.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> YELLOW_SMALL_SPRUCE_TREE = newConfiguredFeature("yellow_small_spruce_tree", BYGFeatureList.YELLOW_SMALL_SPRUCE_TREE.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> TROPICAL_TREE1 = newConfiguredFeature("tropical_tree1", BYGFeatureList.TROPICAL_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> TROPICAL_SHORT_TREE1 = newConfiguredFeature("tropical_short_tree1", BYGFeatureList.TROPICAL_SHORT_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> TROPICAL_SHRUB1 = newConfiguredFeature("tropical_shrub1", BYGFeatureList.TROPICAL_SHRUB1.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> WOODLANDS_TREE1 = newConfiguredFeature("woodlands_tree1", BYGFeatureList.WOODLANDS_TREE1.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> WILLOW_DEAD_TREE1 = newConfiguredFeature("dead_willow_tree1", BYGFeatureList.WILLOW_DEAD_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> WILLOW_M_TREE1 = newConfiguredFeature("mutated_willow_tree1", BYGFeatureList.WILLOW_M_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> WILLOW_M_TREE2 = newConfiguredFeature("mutated_willow_tree2", BYGFeatureList.WILLOW_M_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> WILLOW_TREE1 = newConfiguredFeature("willow_tree1", BYGFeatureList.WILLOW_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> WILLOW_TREE2 = newConfiguredFeature("willow_tree2", BYGFeatureList.WILLOW_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> WILLOW_TREE3 = newConfiguredFeature("willow_tree3", BYGFeatureList.WILLOW_TREE3.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> WILLOW_TREE4 = newConfiguredFeature("willow_tree4", BYGFeatureList.WILLOW_TREE4.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> ZELKOVA_TREE1 = newConfiguredFeature("zelkova_tree1", BYGFeatureList.ZELKOVA_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ZELKOVA_TREE2 = newConfiguredFeature("zelkova_tree2", BYGFeatureList.ZELKOVA_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ZELKOVA_TREE3 = newConfiguredFeature("zelkova_tree3", BYGFeatureList.ZELKOVA_TREE3.configure(DecoratedFeatureConfig.DEFAULT));

    //Vanilla Tree Features
    public static final ConfiguredFeature<?, ?> MC_TROPICAL_GROUND_BUSH = newConfiguredFeature("mc_tropical_ground_bush", Feature.TREE.configure(BYGFeatureConfigs.TROPGROUNDBUSH_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_MEGA_TROPICAL_GROUND_TREE = newConfiguredFeature("mc_mega_tropical_jungle_tree", Feature.TREE.configure(BYGFeatureConfigs.MEGATROPJUNGLETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BLUE_PINE_TREE = newConfiguredFeature("mc_blue_pine_tree", Feature.TREE.configure(BYGFeatureConfigs.BLUEPINETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BLUE_SPRUCE_TREE = newConfiguredFeature("mc_blue_spruce_tree", Feature.TREE.configure(BYGFeatureConfigs.BLUESPRUCETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_RED_PINE_TREE = newConfiguredFeature("mc_red_pine_tree", Feature.TREE.configure(BYGFeatureConfigs.REDPINETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_RED_SPRUCE_TREE = newConfiguredFeature("mc_red_spruce_tree", Feature.TREE.configure(BYGFeatureConfigs.REDSPRUCETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_YELLOW_PINE_TREE = newConfiguredFeature("mc_yellow_pine_tree", Feature.TREE.configure(BYGFeatureConfigs.YELLOWPINETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_YELLOW_SPRUCE_TREE = newConfiguredFeature("mc_yellow_spruce_tree", Feature.TREE.configure(BYGFeatureConfigs.YELLOWSPRUCETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_ORANGE_PINE_TREE = newConfiguredFeature("mc_orange_pine_tree", Feature.TREE.configure(BYGFeatureConfigs.ORANGEPINETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_ORANGE_SPRUCE_TREE = newConfiguredFeature("mc_orange_spruce_tree", Feature.TREE.configure(BYGFeatureConfigs.ORANGESPRUCETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BLUE_MEGA_SPRUCE_TREE = newConfiguredFeature("mc_blue_mega_spruce_tree", Feature.TREE.configure(BYGFeatureConfigs.BLUEMEGASPRUCETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BLUE_MEGA_PINE_TREE = newConfiguredFeature("mc_blue_mega_pine_tree", Feature.TREE.configure(BYGFeatureConfigs.BLUEMEGAPINETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_RED_MEGA_SPRUCE_TREE = newConfiguredFeature("mc_red_mega_spruce_tree", Feature.TREE.configure(BYGFeatureConfigs.REDMEGASPRUCETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_RED_MEGA_PINE_TREE = newConfiguredFeature("mc_red_mega_pine_tree", Feature.TREE.configure(BYGFeatureConfigs.REDMEGAPINETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_YELLOW_MEGA_SPRUCE_TREE = newConfiguredFeature("mc_yellow_mega_spruce_tree", Feature.TREE.configure(BYGFeatureConfigs.YELLOWMEGASPRUCETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_YELLOW_MEGA_PINE_TREE = newConfiguredFeature("mc_yellow_mega_pine_tree", Feature.TREE.configure(BYGFeatureConfigs.YELLOWMEGAPINETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_ORANGE_MEGA_SPRUCE_TREE = newConfiguredFeature("mc_orange_mega_spruce_tree", Feature.TREE.configure(BYGFeatureConfigs.ORANGEMEGASPRUCETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_ORANGE_MEGA_PINE_TREE = newConfiguredFeature("mc_orange_mega_pine_tree", Feature.TREE.configure(BYGFeatureConfigs.ORANGEMEGAPINETREE_CONFIG));

    public static final ConfiguredFeature<?, ?> MC_BIRCH_RED_TREE = newConfiguredFeature("mc_red_birch", Feature.TREE.configure(BYGFeatureConfigs.REDBIRCHTREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BIRCH_TALL_RED_TREE = newConfiguredFeature("mc_tall_red_birch", Feature.TREE.configure(BYGFeatureConfigs.TALLREDBIRCHTREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BIRCH_BROWN_TREE = newConfiguredFeature("mc_brown_birch", Feature.TREE.configure(BYGFeatureConfigs.BROWNBIRCHTREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BIRCH_TALL_BROWN_TREE = newConfiguredFeature("mc_tall_brown_birch", Feature.TREE.configure(BYGFeatureConfigs.TALLBROWNBIRCHTREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BIRCH_ORANGE_TREE = newConfiguredFeature("mc_orange_birch", Feature.TREE.configure(BYGFeatureConfigs.ORANGEBIRCHTREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BIRCH_TALL_ORANGE_TREE = newConfiguredFeature("mc_tall_orange_birch", Feature.TREE.configure(BYGFeatureConfigs.TALLORANGEBIRCHTREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BIRCH_YELLOW_TREE = newConfiguredFeature("mc_yellow_birch", Feature.TREE.configure(BYGFeatureConfigs.YELLOWBIRCHTREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BIRCH_TALL_YELLOW_TREE = newConfiguredFeature("mc_tall_yellow_birch", Feature.TREE.configure(BYGFeatureConfigs.TALLYELLOWBIRCHTREE_CONFIG));

    public static final ConfiguredFeature<?, ?> MC_BROWN_OAK_TREE = newConfiguredFeature("mc_brown_oak_tree", Feature.TREE.configure(BYGFeatureConfigs.BROWNOAKTREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_ORANGE_OAK_TREE = newConfiguredFeature("mc_orange_oak_tree", Feature.TREE.configure(BYGFeatureConfigs.ORANGEOAKTREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_RED_OAK_TREE = newConfiguredFeature("mc_red_oak_tree", Feature.TREE.configure(BYGFeatureConfigs.REDOAKTREE_CONFIG));

    public static final ConfiguredFeature<?, ?> MC_DOVER_MEGA_SPRUCE_TREE = newConfiguredFeature("mc_dover_mega_spruce_tree", Feature.TREE.configure(BYGFeatureConfigs.DOVERMEGASPRUCETREE_CONFIG));

    public static final ConfiguredFeature<?, ?> MC_FANCY_RED_OAK_WITH_MORE_BEEHIVES = newConfiguredFeature("mc_fancy_red_oak_with_more_beehives_tree", Feature.TREE.configure(BYGFeatureConfigs.FANCY_RED_OAK_WITH_MORE_BEEHIVES_CONFIG));

    //Mushrooms
    public static final ConfiguredFeature<?, ?> GREEN_MUSHROOM_HUGE  = newConfiguredFeature("huge_green_mushroom", BYGFeatureList.GREEN_MUSHROOM_HUGE.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> WOOD_BLEWIT_HUGE  = newConfiguredFeature("huge_wood_blewit", BYGFeatureList.WOOD_BLEWIT_HUGE.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> WEEPING_MILKCAP_HUGE  = newConfiguredFeature("huge_weeping_milkcap", BYGFeatureList.WEEPING_MILKCAP_HUGE.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> BLACK_PUFF_HUGE  = newConfiguredFeature("huge_black_puff", BYGFeatureList.BLACK_PUFF_HUGE.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> BLUE_GLOWSHROOM_HUGE  = newConfiguredFeature("huge_blue_glowshroom", BYGFeatureList.BLUE_GLOWSHROOM_HUGE.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> PURPLE_GLOWSHROOM_HUGE  = newConfiguredFeature("huge_purple_glowshroom", BYGFeatureList.PURPLE_GLOWSHROOM_HUGE.configure(DecoratedFeatureConfig.DEFAULT));

    //Nether Mushrooms
    public static final ConfiguredFeature<?, ?> EMBUR_MUSHROOM  = newConfiguredFeature("embur_mushroom1", BYGFeatureList.EMBUR_MUSHROOM.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> EMBUR_MUSHROOM2  = newConfiguredFeature("embur_mushroom2", BYGFeatureList.EMBUR_MUSHROOM2.configure(DecoratedFeatureConfig.DEFAULT));

    /***********************************************************Random Selectors***********************************************************/
    public static final ConfiguredFeature<?, ?> RANDOM_ANCIENT_TREE = newConfiguredFeature("rs_ancient_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            ConfiguredFeatures.DARK_OAK.withChance(0.3F),
            ANCIENT_TREE1.withChance(0.20F),
            ANCIENT_TREE2.withChance(0.20F)),
            ANCIENT_TREE3)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(16, 0.4F, 8))));

    public static final ConfiguredFeature<?, ?> RANDOM_BAYOU_TREE = newConfiguredFeature("rs_bayou_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            WILLOW_DEAD_TREE1.withChance(0.1F),
            WILLOW_TREE1.withChance(0.25F),
            WILLOW_TREE2.withChance(0.25F),
            WILLOW_TREE3.withChance(0.25F)),
            WILLOW_TREE4)).decorate(AtOceanFloorWithExtra.OCEANFLOOR.configure(
            new CountExtraDecoratorConfig(8, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_BLUFF_TREE = newConfiguredFeature("rs_bluff_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            PINE_TREE1.withChance(0.05F),
            PINE_TREE2.withChance(0.05F),
            BLUFF_TREE1.withChance(0.3F),
            BLUFF_TREE2.withChance(0.3F),
            BLUFF_TREE3.withChance(0.25F)),
            CONIFER_TREE6)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(22, 0.3F, -10))));

    public static final ConfiguredFeature<?, ?> RANDOM_BOREAL_TREE = newConfiguredFeature("rs_boreal", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            BOREAL_TREE1.withChance(0.5F)),
            BOREAL_TREE2)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(55, 0.5F, -20))));

    public static final ConfiguredFeature<?, ?> RANDOM_BOREAL_SPARSE_TREE = newConfiguredFeature("rs_sparse_boreal", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            BOREAL_TREE1.withChance(0.5F)),
            BOREAL_TREE2)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(0, 0.1F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_BLACK_FOREST_TREE = newConfiguredFeature("rs_black_forest", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            ASPEN_TREE3.withChance(0.2F),
            ASPEN_TREE2.withChance(0.2F),
            CONIFER_TREE6.withChance(0.1F),
            CONIFER_TREE7.withChance(0.1F),
            PINE_LARGE_TREE1.withChance(0.5F),
            PINE_LARGE_TREE2.withChance(0.5F),
            PINE_TREE1.withChance(0.5F)),
            PINE_TREE2)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(45, 0.4F, 5))));

    public static final ConfiguredFeature<?, ?> RANDOM_BLACK_FOREST_SPARSE_TREE = newConfiguredFeature("rs_sparse_black_forest", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            PINE_LARGE_TREE1.withChance(0.45F),
            PINE_LARGE_TREE2.withChance(0.45F),
            PINE_TREE1.withChance(0.4F)),
            PINE_TREE2)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(0, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_CIKA_TREE = newConfiguredFeature("rs_cika_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            CIKA_TREE2.withChance(0.2F),
            CIKA_TREE3.withChance(0.1F)),
            CIKA_TREE1)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(6, 0.4F, 3))));

    public static final ConfiguredFeature<?, ?> RANDOM_CONIFER_TREE = newConfiguredFeature("rs_conifer_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            CONIFER_TREE1.withChance(0.06F),
            CONIFER_TREE2.withChance(0.5F),
            CONIFER_TREE3.withChance(0.04F),
            CONIFER_TREE4.withChance(0.2F),
            CONIFER_TREE5.withChance(0.2F),
            CONIFER_TREE6.withChance(0.2F),
            CONIFER_TREE7.withChance(0.1F)),
            CONIFER_TREE8)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(40, 0.4F, 10))));

    public static final ConfiguredFeature<?, ?> RANDOM_CONIFER_SPARSE_TREE = newConfiguredFeature("rs_sparse_conifer_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            CONIFER_TREE1.withChance(0.06F),
            CONIFER_TREE2.withChance(0.5F),
            CONIFER_TREE3.withChance(0.04F),
            CONIFER_TREE4.withChance(0.2F),
            CONIFER_TREE5.withChance(0.2F),
            CONIFER_TREE6.withChance(0.2F),
            CONIFER_TREE7.withChance(0.1F)),
            CONIFER_TREE8)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(0, 0.2F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_CRAG_GARDEN_TREE = newConfiguredFeature("rs_crag_garden_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            RAINBOW_TREE1.withChance(0.2F),
            RAINBOW_TREE1.withChance(0.2F),
            ConfiguredFeatures.BAMBOO.withChance(0.2F),
            RAINBOW_LARGE_TREE1.withChance(0.1F)),
            ConfiguredFeatures.BAMBOO)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(50, 0.4F, 8))));

    public static final ConfiguredFeature<?, ?> RANDOM_CYPRESS_TREE = newConfiguredFeature("rs_cypress_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            CYPRESS_TREE1.withChance(0.55F),
            CYPRESS_TREE2.withChance(0.1F)),
            CYPRESS_TREE3)).decorate(AtOceanFloorWithExtra.OCEANFLOOR.configure(
            new CountExtraDecoratorConfig(10, 0.4F, 3))));

    public static ConfiguredFeature<?, ?> RANDOM_DECIDUOUS_TREE = newConfiguredFeature("rs_deciduous_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            DECIDUOUS_TREE1.withChance(0.9F)),
            SHRUB)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(24, 0.4F, 4))));

    public static ConfiguredFeature<?, ?> RANDOM_DECIDUOUS_SPARSE_TREE = newConfiguredFeature("rs_sparse_deciduous_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            DECIDUOUS_TREE1.withChance(0.5F)),
            SHRUB)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_DOVER_TREE = newConfiguredFeature("rs_dover_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            MC_DOVER_MEGA_SPRUCE_TREE.withChance(0.2F),
            PINE_TREE1.withChance(0.2F),
            PINE_TREE2.withChance(0.2F),
            ConfiguredFeatures.PINE.withChance(0.2F),
            CONIFER_TREE7.withChance(0.1F)),
            CONIFER_TREE8)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(20, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_EUCALYPTUS_TREE = newConfiguredFeature("rs_eucalyptus_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            RAINBOW_TREE1.withChance(0.1F)),
            RAINBOW_LARGE_TREE1)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(8, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_GIANT_BLUE_TAIGA_TREE = newConfiguredFeature("rs_blue_taiga_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            ConfiguredFeatures.SPRUCE.withChance(0.2F),
            ConfiguredFeatures.PINE.withChance(0.2F),
            ConfiguredFeatures.MEGA_SPRUCE.withChance(0.2F),
            ConfiguredFeatures.MEGA_PINE.withChance(0.2F),
            BLUE_GIANT_SPRUCE_TREE.withChance(0.2F),
            MC_BLUE_MEGA_PINE_TREE.withChance(0.2F),
            MC_BLUE_MEGA_SPRUCE_TREE.withChance(0.1F),
            BLUE_SMALL_SPRUCE_TREE.withChance(0.1F),
            MC_BLUE_PINE_TREE.withChance(0.5F),
            MC_BLUE_SPRUCE_TREE.withChance(0.5F),
            BLUE_TALL_SPRUCE_TREE.withChance(0.5F),
            BLUE_SPRUCE_TREE.withChance(0.5F)),
            PINE_TREE2)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(45, 0.4F, 5))));

    public static final ConfiguredFeature<?, ?> RANDOM_JACARANDA_TREE = newConfiguredFeature("rs_jacaranda", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            JACARANDA_TREE2.withChance(0.3F),
            INDIGO_JACARANDA_TREE2.withChance(0.3F),
            INDIGO_JACARANDA_TREE1.withChance(0.3F)),
            JACARANDA_TREE1)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(45, 0.1F, -15))));

    public static final ConfiguredFeature<?, ?> RANDOM_JACARANDA_SPARSE_TREE = newConfiguredFeature("rs_sparse_jacaranda", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            INDIGO_JACARANDA_TREE1.withChance(0.3F)),
            JACARANDA_TREE2)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(1, 0.5F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_MAPLE_TREE = newConfiguredFeature("rs_maple", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            MAPLE_RED_TREE1.withChance(0.4F),
            MAPLE_RED_TREE2.withChance(0.03F),
            MAPLE_SILVER_TREE1.withChance(0.2F),
            MAPLE_SILVER_TREE2.withChance(0.1F)),
            MAPLE_TREE1)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(5, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_MAPLE_SPARSE_TREE = newConfiguredFeature("rs_sparse_maple", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            MAPLE_TREE1.withChance(0.06F),
            MAPLE_RED_TREE1.withChance(0.5F),
            MAPLE_TREE1.withChance(0.04F),
            MAPLE_SILVER_TREE1.withChance(0.2F),
            MAPLE_SILVER_TREE2.withChance(0.1F)),
            MAPLE_RED_TREE1)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_NORTHERN_FOREST_TREE = newConfiguredFeature("rs_northern_forest_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            MC_DOVER_MEGA_SPRUCE_TREE.withChance(0.2F),
            PINE_TREE1.withChance(0.2F),
            PINE_TREE2.withChance(0.2F),
            ConfiguredFeatures.PINE.withChance(0.2F),
            CONIFER_TREE7.withChance(0.1F)),
            CONIFER_TREE8)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(20, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_PRAIRIE_TREE = newConfiguredFeature("rs_prairie_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            SHRUB_PRAIRIE1.withChance(0.4F),
            SHRUB_PRAIRIE2.withChance(0.4F),
            ConfiguredFeatures.FANCY_OAK_BEES_002.withChance(0.1F)),
            ConfiguredFeatures.FANCY_OAK)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(0, 0.2F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_REDWOOD_TREE = newConfiguredFeature("rs_redwood_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            REDWOOD_TREE1.withChance(0.55F),
            REDWOOD_TREE2.withChance(0.1F)),
            REDWOOD_TREE3)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(8, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_REDWOOD_SPARSE_TREE = newConfiguredFeature("rs_sparse_redwood_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            REDWOOD_TREE1.withChance(0.55F),
            REDWOOD_TREE2.withChance(0.1F)),
            REDWOOD_TREE3)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(0, 0.2F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SEASONAL_DECIDUOUS_TREE = newConfiguredFeature("rs_seasonal_deciduous_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            DECIDUOUS_BROWN_TREE1.withChance(0.06F),
            DECIDUOUS_ORANGE_TREE1.withChance(0.5F),
            DECIDUOUS_RED_TREE1.withChance(0.04F),
            DECIDUOUS_YELLOW_TREE1.withChance(0.2F),
            DECIDUOUS_TREE1.withChance(0.2F),
            DECIDUOUS_SEASONAL_SHRUB.withChance(0.2F),
            SHRUB.withChance(0.1F)),
            DECIDUOUS_RED_TREE1)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(20, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SEASONAL_DECIDUOUS_SPARSE_TREE = newConfiguredFeature("rs_sparse_seasonal_deciduous_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            DECIDUOUS_BROWN_TREE1.withChance(0.06F),
            DECIDUOUS_ORANGE_TREE1.withChance(0.5F),
            DECIDUOUS_RED_TREE1.withChance(0.04F),
            DECIDUOUS_YELLOW_TREE1.withChance(0.2F),
            DECIDUOUS_TREE1.withChance(0.2F),
            DECIDUOUS_SEASONAL_SHRUB.withChance(0.2F),
            SHRUB.withChance(0.1F)),
            DECIDUOUS_RED_TREE1)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SEASONAL_GIANT_TAIGA_MISC_TREE = newConfiguredFeature("rs_seasonal_taiga_misc_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            PINE_LARGE_TREE1.withChance(0.06F),
            PINE_LARGE_TREE2.withChance(0.5F),
            PINE_TREE1.withChance(0.04F),
            PINE_TREE2.withChance(0.2F),
            BOREAL_TREE1.withChance(0.2F),
            ASPEN_TREE1.withChance(0.2F),
            ASPEN_TREE2.withChance(0.1F)),
            ASPEN_TREE3)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(10, 0.4F, 5))));

    public static final ConfiguredFeature<?, ?> RANDOM_SEASONAL_GIANT_TAIGA_TREE = newConfiguredFeature("rs_giant_seasonal_taiga_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            ORANGE_GIANT_SPRUCE_TREE.withChance(0.06F),
            MC_ORANGE_MEGA_PINE_TREE.withChance(0.5F),
            YELLOW_GIANT_SPRUCE_TREE.withChance(0.04F),
            MC_YELLOW_MEGA_PINE_TREE.withChance(0.2F),
            RED_GIANT_SPRUCE_TREE.withChance(0.2F),
            MC_RED_MEGA_PINE_TREE.withChance(0.2F),
            ConfiguredFeatures.MEGA_SPRUCE.withChance(0.1F)),
            ConfiguredFeatures.MEGA_PINE)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(5, 0.4F, 5))));

    public static final ConfiguredFeature<?, ?> RANDOM_SEASONAL_TAIGA_TREE = newConfiguredFeature("rs_seasonal_taiga_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            ORANGE_SMALL_SPRUCE_TREE.withChance(0.06F),
            ORANGE_SPRUCE_TREE.withChance(0.5F),
            ORANGE_TALL_SPRUCE_TREE.withChance(0.04F),
            YELLOW_SMALL_SPRUCE_TREE.withChance(0.2F),
            YELLOW_SPRUCE_TREE.withChance(0.2F),
            YELLOW_TALL_SPRUCE_TREE.withChance(0.2F),
            RED_SMALL_SPRUCE_TREE.withChance(0.2F),
            RED_SPRUCE_TREE.withChance(0.1F)),
            RED_TALL_SPRUCE_TREE)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(10, 0.4F, 5))));

    public static final ConfiguredFeature<?, ?> RANDOM_RAINFOREST_FUNGAL_TREE = newConfiguredFeature("rs_fungal_rainforest_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            TROPICAL_SHORT_TREE1.withChance(0.6F),
            TROPICAL_SHRUB1.withChance(0.1F),
            TROPICAL_TREE1.withChance(0.4F),
            RAINBOW_LARGE_TREE1.withChance(0.1F),
            RAINBOW_TREE1.withChance(0.1F),
            TROPICAL_SHRUB1.withChance(0.1F),
            TROPICAL_SHORT_TREE1.withChance(0.1F)),
            TROPICAL_SHORT_TREE1)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(45, 0.1F, 10))));

    public static final ConfiguredFeature<?, ?> RANDOM_RAINFOREST_SPARSE_TREE = newConfiguredFeature("rs_sparse_rainforest_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            TROPICAL_SHORT_TREE1.withChance(0.6F),
            TROPICAL_SHRUB1.withChance(0.1F),
            TROPICAL_TREE1.withChance(0.4F),
            RAINBOW_LARGE_TREE1.withChance(0.1F),
            RAINBOW_TREE1.withChance(0.1F),
            TROPICAL_SHRUB1.withChance(0.1F),
            TROPICAL_SHORT_TREE1.withChance(0.1F)),
            TROPICAL_SHORT_TREE1)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(0, 0.2F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_RAINFOREST_TREE = newConfiguredFeature("rs_rainforest_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            TROPICAL_SHORT_TREE1.withChance(0.6F),
            TROPICAL_SHRUB1.withChance(0.1F),
            TROPICAL_TREE1.withChance(0.4F),
            RAINBOW_LARGE_TREE1.withChance(0.1F),
            RAINBOW_TREE1.withChance(0.1F),
            TROPICAL_SHRUB1.withChance(0.1F),
            TROPICAL_SHORT_TREE1.withChance(0.1F)),
            TROPICAL_SHORT_TREE1)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(65, 0.1F, 10))));

    public static final ConfiguredFeature<?, ?> RANDOM_SKYRIS_TREE = newConfiguredFeature("rs_skyris_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            SKYRIS_TREE1.withChance(0.2F),
            SKYRIS_TREE2.withChance(0.2F),
            SKYRIS_TREE3.withChance(0.1F)),
            SKYRIS_TREE2)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(15, 0.4F, 4))));

    public static final ConfiguredFeature<?, ?> RANDOM_BAOBAB_TREE = newConfiguredFeature("rs_baobab_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            ConfiguredFeatures.ACACIA.withChance(0.1F)),
            BAOBAB_TREE1)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(5, 0.8F, -1))));

    public static final ConfiguredFeature<?, ?> RANDOM_MEADOW_SHRUB = newConfiguredFeature("rs_meadow_shrub", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            SHRUB_MEADOW.withChance(0.1F)),
            SHRUB_PRAIRIE2)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_MEADOW_TREE = newConfiguredFeature("rs_meadow_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            MEADOW_TREE1.withChance(0.2F),
            MEADOW_TREE2.withChance(0.1F)),
            MEADOW_TREE3)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(3, 0.5F, 4))));

    public static final ConfiguredFeature<?, ?> RANDOM_GROVE_TREE = newConfiguredFeature("rs_grove_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            BOREAL_TREE1.withChance(0.1F)),
            BOREAL_TREE1)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(1, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_ENCHANTED_GROVE_TREE = newConfiguredFeature("rs_enchanted_grove_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            ENCHANTED_BLUE_GROVE_TREE1.withChance(0.1F)),
            ENCHANTED_GREEN_GROVE_TREE1)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(2, 0.4F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_MARSH_TREE = newConfiguredFeature("rs_marsh_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            SHRUB_PRAIRIE2.withChance(0.2F),
            SHRUB_PRAIRIE1.withChance(0.1F)),
            ConfiguredFeatures.SWAMP_TREE)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(3, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_ENCHANTED_TREE = newConfiguredFeature("rs_enchanted_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            ENCHANTED_BLUE_TREE1.withChance(0.2F),
            ENCHANTED_BLUE_TREE2.withChance(0.2F),
            ENCHANTED_BLUE_TREE3.withChance(0.2F),
            ENCHANTED_GREEN_TREE1.withChance(0.2F),
            ENCHANTED_GREEN_TREE2.withChance(0.2F),
            ENCHANTED_GREEN_TREE3.withChance(0.1F)),
            ConfiguredFeatures.SWAMP_TREE)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(25, 0.4F, 5))));

    public static final ConfiguredFeature<?, ?> RANDOM_GLOWSHROOM_BAYOU_TREE = newConfiguredFeature("rs_glowshroom_bayou_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            WILLOW_DEAD_TREE1.withChance(0.2F),
            WILLOW_M_TREE1.withChance(0.2F),
            WILLOW_M_TREE2.withChance(0.2F),
            WILLOW_TREE3.withChance(0.2F),
            WILLOW_TREE4.withChance(0.2F),
            WILLOW_TREE2.withChance(0.1F)),
            WILLOW_TREE1)).decorate(AtOceanFloorWithExtra.OCEANFLOOR.configure(
            new CountExtraDecoratorConfig(8, 0.4F, 3))));

    public static final ConfiguredFeature<?, ?> RANDOM_ASPEN_TREE = newConfiguredFeature("rs_aspen_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            ASPEN_TREE2.withChance(0.50F),
            ASPEN_TREE3.withChance(0.25F)),
            ASPEN_TREE1)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(30, 0.5F, -1))));

    public static final ConfiguredFeature<?, ?> RANDOM_ASPEN_SHRUB = newConfiguredFeature("rs_aspen_shrub", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            ASPEN_SHRUB1.withChance(0.1F)),
            ASPEN_SHRUB2)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(6, 0.8F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_ASPEN_TREE = newConfiguredFeature("rs_sparse_aspen_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            ASPEN_TREE2.withChance(0.2F),
            ASPEN_TREE3.withChance(0.1F)),
            ASPEN_TREE1)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_ZELKOVA_TREE = newConfiguredFeature("rs_zelkova_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            ZELKOVA_TREE2.withChance(0.2F),
            ZELKOVA_TREE3.withChance(0.1F)),
            ZELKOVA_TREE1)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(30, 0.4F, -2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_ZELKOVA_TREE = newConfiguredFeature("rs_sparse_zelkova_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            ZELKOVA_TREE2.withChance(0.2F),
            ZELKOVA_TREE3.withChance(0.1F)),
            ZELKOVA_TREE1)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_PALO_VERDE_TREE = newConfiguredFeature("rs_palo_verde_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            PALO_VERDE_TREE1.withChance(0.1F)),
            PALO_VERDE_TREE2)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(1, 0.4F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_JOSHUA_TREE = newConfiguredFeature("rs_joshua_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            JOSHUA_TREE1.withChance(0.1F)),
            JOSHUA_TREE2)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(1, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SHRUB = newConfiguredFeature("rs_shrub", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            SHRUB_PRAIRIE1.withChance(0.1F)),
            SHRUB_PRAIRIE2)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(0, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SHRUBLAND = newConfiguredFeature("rs_shrubland", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            SHRUB.withChance(0.1F)),
            SHRUB)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(0, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_PALM_TREE = newConfiguredFeature("rs_palm_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            PALM_TREE1.withChance(0.1F)),
            PALM_TREE1)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_CHERRY_TREE = newConfiguredFeature("rs_cherry_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            CHERRY_PINK_TREE1.withChance(0.2F),
            CHERRY_PINK_TREE2.withChance(0.2F),
            CHERRY_WHITE_TREE1.withChance(0.1F)),
            CHERRY_WHITE_TREE2)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(16, 0.4F, 5))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_CHERRY_TREE = newConfiguredFeature("rs_sparse_cherry_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            CHERRY_PINK_TREE1.withChance(0.2F),
            CHERRY_PINK_TREE2.withChance(0.2F),
            CHERRY_WHITE_TREE1.withChance(0.1F)),
            CHERRY_WHITE_TREE2)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(0, 0.1F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_WITCH_HAZEL_TREE = newConfiguredFeature("rs_witch_hazel_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            DEAD_HAZEL_TREE1.withChance(0.2F),
            DEAD_HAZEL_TREE2.withChance(0.2F),
            DEAD_HAZEL_TREE3.withChance(0.1F)),
            DEAD_HAZEL_TREE4)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(18, 0.3F, 4))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_WITCH_HAZEL_TREE = newConfiguredFeature("rs_sparse_witch_hazel_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            DEAD_HAZEL_TREE1.withChance(0.2F),
            DEAD_HAZEL_TREE2.withChance(0.2F),
            DEAD_HAZEL_TREE3.withChance(0.1F)),
            DEAD_HAZEL_TREE4)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(0, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_EBONY_TREE = newConfiguredFeature("rs_ebony_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            EBONY_TREE1.withChance(0.2F),
            EBONY_TREE2.withChance(0.2F),
            EBONY_BUSH1.withChance(0.1F)),
            EBONY_TREE1)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(10, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_HOLLY_TREE = newConfiguredFeature("rs_holly_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            HOLLY_TREE1.withChance(0.2F),
            HOLLY_TREE2.withChance(0.2F),
            HOLLY_TREE3.withChance(0.1F)),
            HOLLY_TREE4)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(40, 0.4F, 8))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_HOLLY_TREE = newConfiguredFeature("rs_sparse_holly_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            HOLLY_TREE1.withChance(0.2F),
            HOLLY_TREE2.withChance(0.2F),
            HOLLY_TREE3.withChance(0.1F)),
            HOLLY_TREE4)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_MANGROVE_TREE = newConfiguredFeature("rs_mangrove_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            MANGROVE_TREE1.withChance(0.2F),
            MANGROVE_TREE2.withChance(0.2F),
            MANGROVE_TREE3.withChance(0.2F),
            MANGROVE_TREE4.withChance(0.1F)),
            MANGROVE_TREE5)).decorate(AtOceanFloorWithExtra.OCEANFLOOR.configure(
            new CountExtraDecoratorConfig(15, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_MANGROVE_SPARSE_TREE = newConfiguredFeature("rs_sparse_mangrove_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            MANGROVE_TREE1.withChance(0.2F),
            MANGROVE_TREE2.withChance(0.2F),
            MANGROVE_TREE3.withChance(0.2F),
            MANGROVE_TREE4.withChance(0.1F)),
            MANGROVE_TREE5)).decorate(AtOceanFloorWithExtra.OCEANFLOOR.configure(
            new CountExtraDecoratorConfig(0, 0.5F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_PINE_TREE = newConfiguredFeature("rs_pine_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            PINE_TREE2.withChance(0.2F),
            PINE_TREE1.withChance(0.2F),
            PINE_LARGE_TREE1.withChance(0.1F)),
            PINE_LARGE_TREE2)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(20, 0.4F, 4))));

    public static final ConfiguredFeature<?, ?> RANDOM_ORCHARD_TREE = newConfiguredFeature("rs_orchard_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            ORCHARD_TREE1.withChance(0.3F),
            ORCHARD_TREE2.withChance(0.3F)),
            ORCHARD_TREE3)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(5, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_WOODLAND_TREE = newConfiguredFeature("rs_woodland_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            WOODLANDS_TREE1.withChance(0.1F)),
            WOODLANDS_TREE1)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(1, 0.4F, 3))));

    public static final ConfiguredFeature<?, ?> RANDOM_RED_OAK_FOREST_TREE = newConfiguredFeature("rs_red_oak_forest_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            ConfiguredFeatures.OAK.withChance(0.1F),
            ConfiguredFeatures.FANCY_OAK.withChance(0.1F),
            ConfiguredFeatures.BIRCH.withChance(0.1F),
            MC_FANCY_RED_OAK_WITH_MORE_BEEHIVES.withChance(0.2F)),
            MC_RED_OAK_TREE)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(8, 0.3F, 5))));


    public static final ConfiguredFeature<?, ?> RANDOM_RED_OAK_FOREST_SPARSE_TREE = newConfiguredFeature("rs_red_oak_forest_sparse_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            ConfiguredFeatures.FANCY_OAK_BEES_0002.withChance(0.06F),
            MC_RED_OAK_TREE.withChance(0.1F)),
            MC_FANCY_RED_OAK_WITH_MORE_BEEHIVES)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SEASONAL_BIRCH_FOREST_TREE = newConfiguredFeature("rs_seasonal_birch_forest_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            BIRCH_BROWN_TREE1.withChance(0.06F),
            MC_BIRCH_BROWN_TREE.withChance(0.06F),
            MC_BIRCH_TALL_BROWN_TREE.withChance(0.06F),
            BIRCH_ORANGE_TREE1.withChance(0.06F),
            MC_BIRCH_ORANGE_TREE.withChance(0.06F),
            MC_BIRCH_TALL_ORANGE_TREE.withChance(0.06F),
            BIRCH_RED_TREE1.withChance(0.06F),
            MC_BIRCH_RED_TREE.withChance(0.06F),
            MC_BIRCH_TALL_RED_TREE.withChance(0.06F),
            BIRCH_YELLOW_TREE1.withChance(0.06F),
            MC_BIRCH_YELLOW_TREE.withChance(0.1F)),
            MC_BIRCH_TALL_YELLOW_TREE)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(20, 0.4F, -8))));

    public static final ConfiguredFeature<?, ?> RANDOM_SEASONAL_FOREST_TREE = newConfiguredFeature("rs_seasonal_forest_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            BIRCH_BROWN_TREE1.withChance(0.06F),
            MC_BIRCH_BROWN_TREE.withChance(0.06F),
            MC_BIRCH_TALL_BROWN_TREE.withChance(0.06F),
            BIRCH_ORANGE_TREE1.withChance(0.06F),
            MC_BIRCH_ORANGE_TREE.withChance(0.06F),
            MC_BIRCH_TALL_ORANGE_TREE.withChance(0.06F),
            BIRCH_RED_TREE1.withChance(0.06F),
            MC_BIRCH_RED_TREE.withChance(0.06F),
            MC_BIRCH_TALL_RED_TREE.withChance(0.06F),
            BIRCH_YELLOW_TREE1.withChance(0.06F),
            MC_BIRCH_YELLOW_TREE.withChance(0.1F)),
            MC_BIRCH_TALL_YELLOW_TREE)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(20, 0.4F, -8))));

    public static final ConfiguredFeature<?, ?> RANDOM_BLUE_TAIGA_TREE = newConfiguredFeature("rs_blue_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            BLUE_SMALL_SPRUCE_TREE.withChance(0.1F),
            BLUE_SPRUCE_TREE.withChance(0.1F),
            BLUE_TALL_SPRUCE_TREE.withChance(0.1F),
            MC_BLUE_SPRUCE_TREE.withChance(0.1F)),
            MC_BLUE_PINE_TREE)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(20, 0.2F, -8))));

    public static final ConfiguredFeature<?, ?> RANDOM_GLOWSHROOM = newConfiguredFeature("rs_huge_glowshroom", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            BLUE_GLOWSHROOM_HUGE.withChance(0.1F)),
            PURPLE_GLOWSHROOM_HUGE)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(25, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_MUSHROOM = newConfiguredFeature("rs_huge_mushroom", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
                GREEN_MUSHROOM_HUGE.withChance(0.4F),
                WOOD_BLEWIT_HUGE.withChance(0.4F),
                WEEPING_MILKCAP_HUGE.withChance(0.4F)),
                BLACK_PUFF_HUGE)).decorate(Decorator.COUNT_EXTRA.configure(
                new CountExtraDecoratorConfig(10, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_EMBUR_MUSHROOM = newConfiguredFeature("rs_embur_mushroom", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            EMBUR_MUSHROOM.withChance(0.4F)),
            EMBUR_MUSHROOM2)).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(10, 0.3F, 2))));

    public static ConfiguredFeature<?, ?> newConfiguredFeature(String registryName, ConfiguredFeature<?, ?> configuredFeature) {
       Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(BYG.MODID, registryName), configuredFeature);
       return configuredFeature;
   }
}
