package corgiaoc.byg.common.world.feature.overworld.trees;

import corgiaoc.byg.common.world.feature.config.BYGTreeConfig;
import corgiaoc.byg.common.world.feature.overworld.trees.util.BYGHugeTree;
import corgiaoc.byg.common.world.feature.overworld.trees.util.BYGTree;
import corgiaoc.byg.core.world.BYGConfiguredFeatures;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class BYGSaplingToTree {
    public static class BlueSpruceSaplingToTree extends BYGHugeTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredFeatures.SPRUCE_BLUE_TREE_LARGE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.SPRUCE_BLUE_TREE1;
        }
    }

    public static class RedSpruceSaplingToTree extends BYGHugeTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredFeatures.SPRUCE_RED_TREE_LARGE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.SPRUCE_RED_TREE1;
        }
    }

    public static class BaobabSaplingToTree extends BYGHugeTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredFeatures.BAOBAB_TREE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return null;
        }
    }

    public static class OrangeSpruceSaplingToTree extends BYGHugeTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredFeatures.SPRUCE_ORANGE_TREE_LARGE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.SPRUCE_ORANGE_TREE1;
        }
    }


    public static class YellowSpruceSaplingToTree extends BYGHugeTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredFeatures.SPRUCE_YELLOW_TREE_LARGE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.SPRUCE_YELLOW_TREE1;
        }
    }


    public static class BrownOakSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.OAK_BROWN_TREE1;
        }
    }

    public static class RainbowEucalyptusSaplingToTree extends BYGHugeTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredFeatures.RAINBOW_LARGE_TREE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.RAINBOW_TREE1;
        }

    }


    public static class OrangeOakSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.OAK_ORANGE_TREE;
        }
    }


    public static class RedOakSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.OAK_RED_TREE;
        }
    }


    public static class OrangeBirchSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.BIRCH_ORANGE_TREE1;
        }
    }


    public static class BrownBirchSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.BIRCH_BROWN_TREE1;
        }
    }


    public static class RedBirchSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.BIRCH_RED_TREE1;
        }
    }


    public static class YellowBirchSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.BIRCH_YELLOW_TREE1;
        }
    }

    public static class JacarandaSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(3) == 0 ? BYGConfiguredFeatures.JACARANDA_TREE1 : BYGConfiguredFeatures.JACARANDA_TREE2;
        }
    }

    public static class IndigoJacarandaSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(3) == 0 ? BYGConfiguredFeatures.INDIGO_JACARANDA_TREE1 : BYGConfiguredFeatures.INDIGO_JACARANDA_TREE2;
        }
    }

    public static class FirSaplingToTree extends BYGHugeTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredFeatures.CONIFER_TREE3;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(3) == 0 ? BYGConfiguredFeatures.CONIFER_TREE2 : BYGConfiguredFeatures.CONIFER_TREE5;
        }
    }

    public static class MahogonySaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.MAHOGANY_TREE1 : BYGConfiguredFeatures.MAHOGANY_TREE3;
        }
    }

    public static class SkyrisSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.SKYRIS_TREE1 : BYGConfiguredFeatures.SKYRIS_TREE2;
        }
    }

    public static class AraucariaSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.ARAUCARIA_TREE1 : BYGConfiguredFeatures.ARAUCARIA_TREE2;
        }
    }

    public static class AspenSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.ASPEN_TREE1 : BYGConfiguredFeatures.ASPEN_TREE2;
        }
    }

    public static class ZelkovaSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.ZELKOVA_TREE1 : BYGConfiguredFeatures.ZELKOVA_TREE2;
        }

    }

    public static class BrownZelkovaSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.ZELKOVA_BROWN_TREE1 : BYGConfiguredFeatures.ZELKOVA_BROWN_TREE3;
        }

    }

    public static class PaloVerdeSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.PALO_VERDE_TREE1 : BYGConfiguredFeatures.PALO_VERDE_TREE2;
        }

    }

    public static class WillowSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.WILLOW_TREE1 : BYGConfiguredFeatures.WILLOW_TREE2;
        }

    }

    public static class JoshuaSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.JOSHUA_TREE1 : BYGConfiguredFeatures.JOSHUA_TREE2;
        }

    }

    public static class PineSaplingToTree extends BYGHugeTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.PINE_TREE2 : BYGConfiguredFeatures.PINE_LARGE_TREE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.PINE_TREE1 : BYGConfiguredFeatures.PINE_TREE2;
        }

    }

    public static class LamentSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.LAMENT_TWISTY_TREE1 : BYGConfiguredFeatures.LAMENT_WEEPING_TREE2;
        }

    }

    public static class WitheringOakSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.WITHERING_OAK_TREE1 : BYGConfiguredFeatures.WITHERING_OAK_TREE4;
        }

    }

    public static class NightshadeSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.NIGHTSHADE_TREE1 : BYGConfiguredFeatures.NIGHTSHADE_TREE2;
        }

    }

    public static class EtherSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.ETHER_TREE2 : BYGConfiguredFeatures.ETHER_TREE3;
        }

    }

    public static class MapleSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.MAPLE_TREE1;
        }

    }

    public static class RedMapleSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.MAPLE_RED_TREE1 : BYGConfiguredFeatures.MAPLE_RED_TREE2;
        }

    }

    public static class SilverMapleSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.MAPLE_SILVER_TREE1 : BYGConfiguredFeatures.MAPLE_SILVER_TREE2;
        }

    }

    public static class BlueEnchantedSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.ENCHANTED_BLUE_TREE1 : BYGConfiguredFeatures.ENCHANTED_BLUE_TREE2;
        }

    }

    public static class GreenEnchantedSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.ENCHANTED_GREEN_TREE1 : BYGConfiguredFeatures.ENCHANTED_GREEN_TREE2;
        }

    }

    public static class PinkCherrySaplingToTree extends BYGHugeTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredFeatures.CHERRY_PINK_TREE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.CHERRY_PINK_TREE2;
        }

    }

    public static class WhiteCherrySaplingToTree extends BYGHugeTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredFeatures.CHERRY_WHITE_TREE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.CHERRY_WHITE_TREE2;
        }

    }

    public static class CypressSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.CYPRESS_TREE2 : BYGConfiguredFeatures.CYPRESS_TREE3;
        }

    }

    public static class WitchHazelSaplingToTree extends BYGHugeTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.DEAD_HAZEL_TREE1 : BYGConfiguredFeatures.DEAD_HAZEL_TREE2;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return null;
        }
    }

    public static class EbonySaplingToTree extends BYGHugeTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.EBONY_TREE1 : BYGConfiguredFeatures.EBONY_TREE2;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return null;
        }
    }

    public static class HollySaplingToTree extends BYGHugeTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredFeatures.HOLLY_TREE3;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.HOLLY_TREE1 : BYGConfiguredFeatures.HOLLY_TREE2;
        }

    }

    public static class PalmSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.PALM_TREE1 : BYGConfiguredFeatures.PALM_TREE2;
        }

    }

    public static class MangroveSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.MANGROVE_TREE1 : BYGConfiguredFeatures.MANGROVE_TREE2;
        }

    }

    public static class OrchardSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.ORCHARD_TREE1 : BYGConfiguredFeatures.ORCHARD_TREE2;
        }
    }

    public static class CikaSaplingToTree extends BYGTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.CIKA_TREE2 : BYGConfiguredFeatures.CIKA_TREE1;
        }

    }

    public static class RedwoodSaplingToTree extends BYGHugeTree {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return null;
        }


        @Nullable
        @Override
        protected ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredFeatures.REDWOOD_TREE1;
        }
    }
}


