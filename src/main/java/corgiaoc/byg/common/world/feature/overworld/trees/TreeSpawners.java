package corgiaoc.byg.common.world.feature.overworld.trees;

import corgiaoc.byg.common.world.feature.config.BYGTreeConfig;
import corgiaoc.byg.common.world.feature.overworld.trees.util.HugeTreeSpawner;
import corgiaoc.byg.common.world.feature.overworld.trees.util.TreeSpawner;
import corgiaoc.byg.core.world.BYGConfiguredFeatures;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class TreeSpawners {
    public static class BlueSpruce extends HugeTreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredFeatures.SPRUCE_BLUE_TREE_LARGE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.SPRUCE_BLUE_TREE1;
        }
    }

    public static class RedSpruce extends HugeTreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredFeatures.SPRUCE_RED_TREE_LARGE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.SPRUCE_RED_TREE1;
        }
    }

    public static class Baobab extends HugeTreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredFeatures.BAOBAB_TREE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return null;
        }
    }

    public static class OrangeSpruce extends HugeTreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredFeatures.SPRUCE_ORANGE_TREE_LARGE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.SPRUCE_ORANGE_TREE1;
        }
    }


    public static class YellowSpruce extends HugeTreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredFeatures.SPRUCE_YELLOW_TREE_LARGE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.SPRUCE_YELLOW_TREE1;
        }
    }


    public static class BrownOak extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.BROWN_OAK_TREE1;
        }
    }

    public static class RainbowEucalyptus extends HugeTreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredFeatures.RAINBOW_LARGE_TREE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.RAINBOW_TREE1;
        }

    }


    public static class OrangeOak extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.ORANGE_OAK_TREE2;
        }
    }


    public static class RedOak extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.RED_OAK_TREE3;
        }
    }


    public static class OrangeBirch extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.BIRCH_ORANGE_TREE1;
        }
    }


    public static class BrownBirch extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.BIRCH_BROWN_TREE1;
        }
    }


    public static class RedBirch extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.BIRCH_RED_TREE1;
        }
    }


    public static class YellowBirch extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.BIRCH_YELLOW_TREE1;
        }
    }

    public static class Jacaranda extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(3) == 0 ? BYGConfiguredFeatures.JACARANDA_TREE1 : BYGConfiguredFeatures.JACARANDA_TREE2;
        }
    }

    public static class IndigoJacaranda extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(3) == 0 ? BYGConfiguredFeatures.INDIGO_JACARANDA_TREE1 : BYGConfiguredFeatures.INDIGO_JACARANDA_TREE2;
        }
    }

    public static class Fir extends HugeTreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredFeatures.CONIFER_TREE8;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(3) == 0 ? BYGConfiguredFeatures.CONIFER_TREE2 : BYGConfiguredFeatures.CONIFER_TREE5;
        }
    }

    public static class Mahogony extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.MAHOGANY_TREE1 : BYGConfiguredFeatures.MAHOGANY_TREE3;
        }
    }

    public static class Skyris extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.SKYRIS_TREE1 : BYGConfiguredFeatures.SKYRIS_TREE2;
        }
    }

    public static class Araucaria extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.ARAUCARIA_TREE1 : BYGConfiguredFeatures.ARAUCARIA_TREE2;
        }
    }

    public static class Aspen extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.ASPEN_TREE1 : BYGConfiguredFeatures.ASPEN_TREE2;
        }
    }

    public static class Zelkova extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.ZELKOVA_TREE1 : BYGConfiguredFeatures.ZELKOVA_TREE2;
        }

    }

    public static class BrownZelkova extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.ZELKOVA_BROWN_TREE1 : BYGConfiguredFeatures.ZELKOVA_BROWN_TREE3;
        }

    }

    public static class PaloVerde extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.PALO_VERDE_TREE1 : BYGConfiguredFeatures.PALO_VERDE_TREE2;
        }

    }

    public static class Willow extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.WILLOW_TREE1 : BYGConfiguredFeatures.WILLOW_TREE2;
        }

    }

    public static class Joshua extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.JOSHUA_TREE1 : BYGConfiguredFeatures.JOSHUA_TREE2;
        }

    }

    public static class Pine extends HugeTreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.PINE_TREE2 : BYGConfiguredFeatures.PINE_LARGE_TREE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.PINE_TREE1 : BYGConfiguredFeatures.PINE_TREE2;
        }

    }

    public static class Lament extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.LAMENT_TWISTY_TREE1 : BYGConfiguredFeatures.LAMENT_WEEPING_TREE2;
        }

    }

    public static class WitheringOak extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.WITHERING_OAK_TREE1 : BYGConfiguredFeatures.WITHERING_OAK_TREE4;
        }

    }

    public static class Nightshade extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.NIGHTSHADE_TREE1 : BYGConfiguredFeatures.NIGHTSHADE_TREE2;
        }

    }

    public static class Ether extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.ETHER_TREE2 : BYGConfiguredFeatures.ETHER_TREE3;
        }

    }

    public static class Maple extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.MAPLE_TREE1;
        }

    }

    public static class RedMaple extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.MAPLE_RED_TREE1 : BYGConfiguredFeatures.MAPLE_RED_TREE2;
        }

    }

    public static class SilverMaple extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.MAPLE_SILVER_TREE1 : BYGConfiguredFeatures.MAPLE_SILVER_TREE2;
        }

    }

    public static class BlueEnchanted extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.ENCHANTED_BLUE_TREE1 : BYGConfiguredFeatures.ENCHANTED_BLUE_TREE2;
        }

    }

    public static class GreenEnchanted extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.ENCHANTED_GREEN_TREE1 : BYGConfiguredFeatures.ENCHANTED_GREEN_TREE2;
        }

    }

    public static class PinkCherry extends HugeTreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredFeatures.CHERRY_PINK_TREE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.CHERRY_PINK_TREE2;
        }

    }

    public static class WhiteCherry extends HugeTreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredFeatures.CHERRY_WHITE_TREE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.CHERRY_WHITE_TREE2;
        }

    }

    public static class Cypress extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.CYPRESS_TREE2 : BYGConfiguredFeatures.CYPRESS_TREE3;
        }

    }

    public static class WitchHazel extends HugeTreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.DEAD_HAZEL_TREE1 : BYGConfiguredFeatures.DEAD_HAZEL_TREE2;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return null;
        }
    }

    public static class Ebony extends HugeTreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.EBONY_TREE1 : BYGConfiguredFeatures.EBONY_TREE2;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return null;
        }
    }

    public static class Holly extends HugeTreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredFeatures.HOLLY_TREE3;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.HOLLY_TREE1 : BYGConfiguredFeatures.HOLLY_TREE2;
        }

    }

    public static class Palm extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.PALM_TREE1 : BYGConfiguredFeatures.PALM_TREE2;
        }

    }

    public static class Mangrove extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.MANGROVE_TREE1 : BYGConfiguredFeatures.MANGROVE_TREE2;
        }

    }

    public static class Orchard extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.ORCHARD_TREE1 : BYGConfiguredFeatures.ORCHARD_TREE2;
        }
    }

    public static class Cika extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.CIKA_TREE2 : BYGConfiguredFeatures.CIKA_TREE1;
        }

    }

    public static class Redwood extends TreeSpawner {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.REDWOOD_TREE1 : BYGConfiguredFeatures.REDWOOD_TREE2;
        }

    }
}


