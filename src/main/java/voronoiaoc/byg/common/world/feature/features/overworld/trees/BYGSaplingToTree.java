package voronoiaoc.byg.common.world.feature.features.overworld.trees;

import voronoiaoc.byg.common.world.feature.config.BYGTreeFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGHugeTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGTree;
import voronoiaoc.byg.core.byglists.BYGFeatureList;

import javax.annotation.Nullable;
import java.util.Random;

public class BYGSaplingToTree {
    public static class BlueSpruceSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getBigTreeFeature(Random random) {
            return BYGFeatureList.SPRUCE_BLUE_TREE_LARGE1;
        }

        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return BYGFeatureList.SPRUCE_BLUE_TREE1;
        }
    }

    public static class RedSpruceSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getBigTreeFeature(Random random) {
            return BYGFeatureList.SPRUCE_RED_TREE_LARGE1;
        }

        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return BYGFeatureList.SPRUCE_RED_TREE1;
        }
    }

    public static class BaobabSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getBigTreeFeature(Random random) {
            return BYGFeatureList.BAOBAB_TREE1;
        }

        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return null;
        }
    }

    public static class OrangeSpruceSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getBigTreeFeature(Random random) {
            return BYGFeatureList.SPRUCE_ORANGE_TREE_LARGE1;
        }

        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return BYGFeatureList.SPRUCE_ORANGE_TREE1;
        }
    }


    public static class YellowSpruceSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getBigTreeFeature(Random random) {
            return BYGFeatureList.SPRUCE_YELLOW_TREE_LARGE1;
        }

        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return BYGFeatureList.SPRUCE_YELLOW_TREE1;
        }
    }


    public static class BrownOakSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return BYGFeatureList.OAK_BROWN_TREE1;
        }
    }

    public static class RainbowEucalyptusSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getBigTreeFeature(Random random) {
            return BYGFeatureList.RAINBOW_LARGE_TREE1;
        }

        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return BYGFeatureList.RAINBOW_TREE1;
        }

    }


    public static class OrangeOakSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return BYGFeatureList.OAK_ORANGE_TREE1;
        }
    }


    public static class RedOakSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return BYGFeatureList.OAK_RED_TREE1;
        }
    }


    public static class OrangeBirchSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return BYGFeatureList.BIRCH_ORANGE_TREE1;
        }
    }


    public static class BrownBirchSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return BYGFeatureList.BASIC_TREE;
        }
    }


    public static class RedBirchSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return BYGFeatureList.BIRCH_RED_TREE1;
        }
    }


    public static class YellowBirchSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return BYGFeatureList.BIRCH_YELLOW_TREE1;
        }
    }

    public static class JacarandaSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(3) == 0 ? BYGFeatureList.JACARANDA_TREE1 : BYGFeatureList.JACARANDA_TREE2;
        }
    }

    public static class IndigoJacarandaSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(3) == 0 ? BYGFeatureList.JACARANDA_INDIGO_TREE1 : BYGFeatureList.JACARANDA_INDIGO_TREE2;
        }
    }

    public static class FirSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getBigTreeFeature(Random random) {
            return BYGFeatureList.CONIFER_TREE3;
        }

        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(3) == 0 ? BYGFeatureList.CONIFER_TREE2 : BYGFeatureList.CONIFER_TREE5;
        }
    }

    public static class MahogonySaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGFeatureList.MAHOGANY_TREE1 : BYGFeatureList.MAHOGANY_TREE3;
        }
    }

    public static class SkyrisSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGFeatureList.SKYRIS_TREE1 : BYGFeatureList.SKYRIS_TREE2;
        }
    }

    public static class AspenSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGFeatureList.ASPEN_TREE1 : BYGFeatureList.ASPEN_TREE2;
        }
    }

    public static class ZelkovaSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGFeatureList.ZELKOVA_TREE1 : BYGFeatureList.ZELKOVA_TREE2;
        }

    }

    public static class PaloVerdeSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGFeatureList.PALO_VERDE_TREE1 : BYGFeatureList.PALO_VERDE_TREE2;
        }

    }

    public static class WillowSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGFeatureList.WILLOW_TREE1 : BYGFeatureList.WILLOW_TREE2;
        }

    }

    public static class JoshuaSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGFeatureList.JOSHUA_TREE1 : BYGFeatureList.JOSHUA_TREE2;
        }

    }

    public static class PineSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getBigTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGFeatureList.PINE_TREE2 : BYGFeatureList.PINE_LARGE_TREE1;
        }

        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGFeatureList.PINE_TREE1 : BYGFeatureList.PINE_TREE2;
        }

    }

    public static class MapleSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return BYGFeatureList.MAPLE_TREE;
        }

    }

    public static class RedMapleSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGFeatureList.MAPLE_RED_TREE1 : BYGFeatureList.MAPLE_RED_TREE2;
        }

    }

    public static class SilverMapleSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGFeatureList.MAPLE_SILVER_TREE1 : BYGFeatureList.MAPLE_SILVER_TREE2;
        }

    }

    public static class BlueEnchantedSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGFeatureList.ENCHANTED_BLUE_TREE1 : BYGFeatureList.ENCHANTED_BLUE_TREE2;
        }

    }

    public static class GreenEnchantedSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGFeatureList.ENCHANTED_GREEN_TREE1 : BYGFeatureList.ENCHANTED_GREEN_TREE2;
        }

    }

    public static class PinkCherrySaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getBigTreeFeature(Random random) {
            return BYGFeatureList.CHERRY_TREE1;
        }

        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return BYGFeatureList.CHERRY_TREE2;
        }

    }

    public static class WhiteCherrySaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getBigTreeFeature(Random random) {
            return BYGFeatureList.CHERRY_WHITE_TREE1;
        }

        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return BYGFeatureList.CHERRY_WHITE_TREE2;
        }

    }

    public static class CypressSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGFeatureList.CYPRESS_TREE2 : BYGFeatureList.CYPRESS_TREE3;
        }

    }

    public static class WitchHazelSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getBigTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGFeatureList.DEAD_HAZEL_TREE1 : BYGFeatureList.DEAD_HAZEL_TREE2;
        }

        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return null;
        }
    }

    public static class EbonySaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getBigTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGFeatureList.EBONY_TREE1 : BYGFeatureList.EBONY_TREE2;
        }

        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return null;
        }
    }

    public static class HollySaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getBigTreeFeature(Random random) {
            return BYGFeatureList.HOLLY_TREE3;
        }

        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGFeatureList.HOLLY_TREE1 : BYGFeatureList.HOLLY_TREE2;
        }

    }

    public static class MangroveSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGFeatureList.MANGROVE_TREE1 : BYGFeatureList.MANGROVE_TREE2;
        }

    }

    public static class OrchardSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGFeatureList.ORCHARD_TREE1 : BYGFeatureList.ORCHARD_TREE2;
        }
    }

    public static class CikaSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGFeatureList.CIKA_TREE2 : BYGFeatureList.CIKA_TREE1;
        }

    }

    public static class RedwoodSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<BYGTreeFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGFeatureList.REDWOOD_TREE1 : BYGFeatureList.REDWOOD_TREE2;
        }

    }
}


