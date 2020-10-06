package corgiaoc.byg.common.world.feature.features.overworld.trees;

import net.minecraft.world.gen.feature.ConfiguredFeature;
import corgiaoc.byg.common.world.feature.featureconfig.BYGTreeFeatureConfig;
import corgiaoc.byg.common.world.feature.features.overworld.trees.util.BYGHugeTree;
import corgiaoc.byg.common.world.feature.features.overworld.trees.util.BYGTree;
import corgiaoc.byg.core.byglists.BYGConfiguredTreeFeatures;

import javax.annotation.Nullable;
import java.util.Random;

public class BYGSaplingToTree {
    public static class BlueSpruceSaplingToTree extends BYGHugeTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredTreeFeatures.SPRUCE_BLUE_TREE_LARGE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredTreeFeatures.SPRUCE_BLUE_TREE1;
        }
    }

    public static class RedSpruceSaplingToTree extends BYGHugeTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredTreeFeatures.SPRUCE_RED_TREE_LARGE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredTreeFeatures.SPRUCE_RED_TREE1;
        }
    }

    public static class BaobabSaplingToTree extends BYGHugeTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredTreeFeatures.BAOBAB_TREE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return null;
        }
    }

    public static class OrangeSpruceSaplingToTree extends BYGHugeTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredTreeFeatures.SPRUCE_ORANGE_TREE_LARGE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredTreeFeatures.SPRUCE_ORANGE_TREE1;
        }
    }


    public static class YellowSpruceSaplingToTree extends BYGHugeTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredTreeFeatures.SPRUCE_YELLOW_TREE_LARGE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredTreeFeatures.SPRUCE_YELLOW_TREE1;
        }
    }


    public static class BrownOakSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredTreeFeatures.OAK_BROWN_TREE1;
        }
    }

    public static class RainbowEucalyptusSaplingToTree extends BYGHugeTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredTreeFeatures.RAINBOW_LARGE_TREE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredTreeFeatures.RAINBOW_TREE1;
        }

    }


    public static class OrangeOakSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredTreeFeatures.OAK_ORANGE_TREE;
        }
    }


    public static class RedOakSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredTreeFeatures.OAK_RED_TREE;
        }
    }


    public static class OrangeBirchSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredTreeFeatures.BIRCH_ORANGE_TREE1;
        }
    }


    public static class BrownBirchSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredTreeFeatures.BIRCH_BROWN_TREE1;
        }
    }


    public static class RedBirchSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredTreeFeatures.BIRCH_RED_TREE1;
        }
    }


    public static class YellowBirchSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredTreeFeatures.BIRCH_YELLOW_TREE1;
        }
    }

    public static class JacarandaSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(3) == 0 ? BYGConfiguredTreeFeatures.JACARANDA_TREE1 : BYGConfiguredTreeFeatures.JACARANDA_TREE2;
        }
    }

    public static class IndigoJacarandaSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(3) == 0 ? BYGConfiguredTreeFeatures.INDIGO_JACARANDA_TREE1 : BYGConfiguredTreeFeatures.INDIGO_JACARANDA_TREE2;
        }
    }

    public static class FirSaplingToTree extends BYGHugeTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredTreeFeatures.CONIFER_TREE3;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(3) == 0 ? BYGConfiguredTreeFeatures.CONIFER_TREE2 : BYGConfiguredTreeFeatures.CONIFER_TREE5;
        }
    }

    public static class MahogonySaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredTreeFeatures.MAHOGANY_TREE1 : BYGConfiguredTreeFeatures.MAHOGANY_TREE3;
        }
    }

    public static class SkyrisSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredTreeFeatures.SKYRIS_TREE1 : BYGConfiguredTreeFeatures.SKYRIS_TREE2;
        }
    }

    public static class AraucariaSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredTreeFeatures.ARAUCARIA_TREE1 : BYGConfiguredTreeFeatures.ARAUCARIA_TREE2;
        }
    }

    public static class AspenSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredTreeFeatures.ASPEN_TREE1 : BYGConfiguredTreeFeatures.ASPEN_TREE2;
        }
    }

    public static class ZelkovaSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredTreeFeatures.ZELKOVA_TREE1 : BYGConfiguredTreeFeatures.ZELKOVA_TREE2;
        }

    }

    public static class BrownZelkovaSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredTreeFeatures.ZELKOVA_BROWN_TREE1 : BYGConfiguredTreeFeatures.ZELKOVA_BROWN_TREE3;
        }

    }

    public static class PaloVerdeSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredTreeFeatures.PALO_VERDE_TREE1 : BYGConfiguredTreeFeatures.PALO_VERDE_TREE2;
        }

    }

    public static class WillowSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredTreeFeatures.WILLOW_TREE1 : BYGConfiguredTreeFeatures.WILLOW_TREE2;
        }

    }

    public static class JoshuaSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredTreeFeatures.JOSHUA_TREE1 : BYGConfiguredTreeFeatures.JOSHUA_TREE2;
        }

    }

    public static class PineSaplingToTree extends BYGHugeTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getBigTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredTreeFeatures.PINE_TREE2 : BYGConfiguredTreeFeatures.PINE_LARGE_TREE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredTreeFeatures.PINE_TREE1 : BYGConfiguredTreeFeatures.PINE_TREE2;
        }

    }

    public static class LamentSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredTreeFeatures.LAMENT_TWISTY_TREE1 : BYGConfiguredTreeFeatures.LAMENT_WEEPING_TREE2;
        }

    }

    public static class WitheringOakSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredTreeFeatures.WITHERING_OAK_TREE1 : BYGConfiguredTreeFeatures.WITHERING_OAK_TREE4;
        }

    }

    public static class MapleSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredTreeFeatures.MAPLE_TREE1;
        }

    }

    public static class RedMapleSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredTreeFeatures.MAPLE_RED_TREE1 : BYGConfiguredTreeFeatures.MAPLE_RED_TREE2;
        }

    }

    public static class SilverMapleSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredTreeFeatures.MAPLE_SILVER_TREE1 : BYGConfiguredTreeFeatures.MAPLE_SILVER_TREE2;
        }

    }

    public static class BlueEnchantedSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredTreeFeatures.ENCHANTED_BLUE_TREE1 : BYGConfiguredTreeFeatures.ENCHANTED_BLUE_TREE2;
        }

    }

    public static class GreenEnchantedSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredTreeFeatures.ENCHANTED_GREEN_TREE1 : BYGConfiguredTreeFeatures.ENCHANTED_GREEN_TREE2;
        }

    }

    public static class PinkCherrySaplingToTree extends BYGHugeTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredTreeFeatures.CHERRY_PINK_TREE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredTreeFeatures.CHERRY_PINK_TREE2;
        }

    }

    public static class WhiteCherrySaplingToTree extends BYGHugeTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredTreeFeatures.CHERRY_WHITE_TREE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredTreeFeatures.CHERRY_WHITE_TREE2;
        }

    }

    public static class CypressSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredTreeFeatures.CYPRESS_TREE2 : BYGConfiguredTreeFeatures.CYPRESS_TREE3;
        }

    }

    public static class WitchHazelSaplingToTree extends BYGHugeTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getBigTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredTreeFeatures.DEAD_HAZEL_TREE1 : BYGConfiguredTreeFeatures.DEAD_HAZEL_TREE2;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return null;
        }
    }

    public static class EbonySaplingToTree extends BYGHugeTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getBigTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredTreeFeatures.EBONY_TREE1 : BYGConfiguredTreeFeatures.EBONY_TREE2;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return null;
        }
    }

    public static class HollySaplingToTree extends BYGHugeTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredTreeFeatures.HOLLY_TREE3;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredTreeFeatures.HOLLY_TREE1 : BYGConfiguredTreeFeatures.HOLLY_TREE2;
        }

    }

    public static class PalmSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredTreeFeatures.PALM_TREE1 : BYGConfiguredTreeFeatures.PALM_TREE2;
        }

    }

    public static class MangroveSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredTreeFeatures.MANGROVE_TREE1 : BYGConfiguredTreeFeatures.MANGROVE_TREE2;
        }

    }

    public static class OrchardSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredTreeFeatures.ORCHARD_TREE1 : BYGConfiguredTreeFeatures.ORCHARD_TREE2;
        }
    }

    public static class CikaSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredTreeFeatures.CIKA_TREE2 : BYGConfiguredTreeFeatures.CIKA_TREE1;
        }

    }

    public static class RedwoodSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredTreeFeatures.REDWOOD_TREE1 : BYGConfiguredTreeFeatures.REDWOOD_TREE2;
        }

    }
}


