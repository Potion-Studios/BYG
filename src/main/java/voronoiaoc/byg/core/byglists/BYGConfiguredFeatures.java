package voronoiaoc.byg.core.byglists;

import com.google.common.collect.ImmutableList;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DecoratedFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.RandomFeatureConfig;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatureConfigs;

public class BYGConfiguredFeatures {
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
    public static final ConfiguredFeature<?, ?> DECIDUOUS_RED_TREE1 = newConfiguredFeature("orange_deciduous_tree1", BYGFeatureList.DECIDUOUS_RED_TREE.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> DECIDUOUS_SEASONAL_SHRUB = newConfiguredFeature("seasonal_deciduous_shrub", BYGFeatureList.DECIDUOUS_SEASONAL_SHRUBS.configure(DecoratedFeatureConfig.DEFAULT));

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
    public static final ConfiguredFeature<?, ?> MC_RED_SPRUCE_TREE = newConfiguredFeature("mc_red_pine_tree", Feature.TREE.configure(BYGFeatureConfigs.REDSPRUCETREE_CONFIG));
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
    public static final ConfiguredFeature<?, ?> MC_ORANGE_MEGA_PINE_TREE = newConfiguredFeature("mc_orange_mega_spruce_tree", Feature.TREE.configure(BYGFeatureConfigs.ORANGEMEGAPINETREE_CONFIG));


    /***********************************************************Random Selectors***********************************************************/
    public static final ConfiguredFeature<?, ?> RANDOM_JACARANDA_TREE = newConfiguredFeature("rs_jacaranda", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            JACARANDA_TREE2.withChance(0.3F),
            INDIGO_JACARANDA_TREE2.withChance(0.3F),
            INDIGO_JACARANDA_TREE1.withChance(0.3F)),
            JACARANDA_TREE1)).method_30374(Decorator.COUNT_EXTRA.configure(
            new CountExtraChanceDecoratorConfig(45, 0.1F, -15))));

//    public static final ConfiguredFeature<?, ?> RANDOM_BLUE_TAIGA_TREE = newConfiguredFeature("rs_blue_taiga", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
//           BYGFeatureList.BLUE_SMALL_SPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.1F),
//           Feature.TREE.configure(BYGFeatureConfigs.BLUEPINETREE_CONFIG).withChance(0.1F),
//           Feature.TREE.configure(BYGFeatureConfigs.BLUESPRUCETREE_CONFIG).withChance(0.1F),
//           Feature.TREE.configure(ConfiguredFeatures.PINE.config).withChance(0.5F),
//           Feature.TREE.configure(ConfiguredFeatures.SPRUCE.config).withChance(0.5F),
//           BYGFeatureList.BLUE_TALL_SPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.1F)),
//           BYGFeatureList.BLUE_SPRUCE_TREE.configure(FeatureConfig.DEFAULT))).method_30374(Decorator.COUNT_EXTRA.configure(
//           new CountExtraChanceDecoratorConfig(20, 0.1F, -8))));

    public static final ConfiguredFeature<?, ?> RANDOM_BOREAL_TREE = newConfiguredFeature("rs_boreal", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            BOREAL_TREE1.withChance(0.5F)),
            BOREAL_TREE2)).method_30374(Decorator.COUNT_EXTRA.configure(
            new CountExtraChanceDecoratorConfig(55, 0.5F, -20))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_BOREAL_TREE = newConfiguredFeature("rs_sparse_boreal", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            BOREAL_TREE1.withChance(0.5F)),
            BOREAL_TREE2)).method_30374(Decorator.COUNT_EXTRA.configure(
            new CountExtraChanceDecoratorConfig(0, 0.1F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_BLACK_FOREST_TREE = newConfiguredFeature("rs_black_forest", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            ASPEN_TREE3.withChance(0.2F),
            ASPEN_TREE2.withChance(0.2F),
            CONIFER_TREE7.withChance(0.1F),
            CONIFER_TREE6.withChance(0.1F),
            PINE_LARGE_TREE1.withChance(0.5F),
            PINE_LARGE_TREE2.withChance(0.5F),
            PINE_TREE1.withChance(0.5F)),
            PINE_TREE2)).method_30374(Decorator.COUNT_EXTRA.configure(
            new CountExtraChanceDecoratorConfig(45, 0.4F, 5))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_BLACK_FOREST_TREE = newConfiguredFeature("rs_sparse_black_forest", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            PINE_LARGE_TREE1.withChance(0.45F),
            PINE_LARGE_TREE2.withChance(0.45F),
            PINE_TREE1.withChance(0.4F)),
            PINE_TREE2)).method_30374(Decorator.COUNT_EXTRA.configure(
            new CountExtraChanceDecoratorConfig(0, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_MAPLE_TREE = newConfiguredFeature("rs_maple", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            MAPLE_RED_TREE1.withChance(0.4F),
            MAPLE_RED_TREE2.withChance(0.03F),
            MAPLE_SILVER_TREE1.withChance(0.2F),
            MAPLE_SILVER_TREE2.withChance(0.1F)),
            MAPLE_TREE1)).method_30374(Decorator.COUNT_EXTRA.configure(
            new CountExtraChanceDecoratorConfig(5, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_MAPLE_TREE = newConfiguredFeature("rs_sparse_maple", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            MAPLE_TREE1.withChance(0.06F),
            MAPLE_RED_TREE1.withChance(0.5F),
            MAPLE_TREE1.withChance(0.04F),
            MAPLE_SILVER_TREE1.withChance(0.2F),
            MAPLE_SILVER_TREE2.withChance(0.1F)),
            MAPLE_RED_TREE1)).method_30374(Decorator.COUNT_EXTRA.configure(
            new CountExtraChanceDecoratorConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_JACARANDA_TREE = newConfiguredFeature("rs_sparse_jacaranda", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            INDIGO_JACARANDA_TREE1.withChance(0.3F)),
            JACARANDA_TREE2)).method_30374(Decorator.COUNT_EXTRA.configure(
            new CountExtraChanceDecoratorConfig(1, 0.5F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_REDWOOD_TREE = newConfiguredFeature("rs_redwood_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            REDWOOD_TREE1.withChance(0.55F),
            REDWOOD_TREE2.withChance(0.1F)),
            REDWOOD_TREE3)).method_30374(Decorator.COUNT_EXTRA.configure(
            new CountExtraChanceDecoratorConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_CONIFER_TREE = newConfiguredFeature("rs_conifer_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            CONIFER_TREE1.withChance(0.06F),
            CONIFER_TREE2.withChance(0.5F),
            CONIFER_TREE3.withChance(0.04F),
            CONIFER_TREE4.withChance(0.2F),
            CONIFER_TREE5.withChance(0.2F),
            CONIFER_TREE6.withChance(0.2F),
            CONIFER_TREE7.withChance(0.1F)),
            CONIFER_TREE8)).method_30374(Decorator.COUNT_EXTRA.configure(
            new CountExtraChanceDecoratorConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_CYPRESS_TREE = newConfiguredFeature("rs_cypress_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            CYPRESS_TREE1.withChance(0.55F),
            CYPRESS_TREE2.withChance(0.1F)),
            CYPRESS_TREE3)).method_30374(Decorator.COUNT_EXTRA.configure(
            new CountExtraChanceDecoratorConfig(0, 0.4F, 2))));

    public static ConfiguredFeature<?, ?> RANDOM_DECIDUOUS_TREE = newConfiguredFeature("rs_deciduous_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            DECIDUOUS_TREE1.withChance(0.9F)),
            SHRUB)).method_30374(Decorator.COUNT_EXTRA.configure(
            new CountExtraChanceDecoratorConfig(0, 0.4F, 2))));

    public static ConfiguredFeature<?, ?> RANDOM_SPARSE_DECIDUOUS_TREE = newConfiguredFeature("rs_sparse_deciduous_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            DECIDUOUS_TREE1.withChance(0.9F)),
            SHRUB)).method_30374(Decorator.COUNT_EXTRA.configure(
            new CountExtraChanceDecoratorConfig(0, 0.4F, 2))));

    public static ConfiguredFeature<?, ?> newConfiguredFeature(String registryName, ConfiguredFeature<?, ?> configuredFeature) {
       Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(BYG.MODID, registryName), configuredFeature);
       return configuredFeature;
   }
}
