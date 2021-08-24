package corgiaoc.byg.common.world.feature.overworld.trees;

import corgiaoc.byg.common.world.feature.config.BYGTreeConfig;
import corgiaoc.byg.common.world.feature.overworld.trees.util.HugeTreeSpawner;
import corgiaoc.byg.common.world.feature.overworld.trees.util.TreeSpawner;
import corgiaoc.byg.core.world.BYGConfiguredFeatures;
import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.Random;

public class TreeSpawners {

    public static final TreeSpawner BLUE_SPRUCE = new HugeTreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredFeatures.SPRUCE_BLUE_TREE_LARGE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.SPRUCE_BLUE_TREE1;
        }
    };

    public static final TreeSpawner RED_SPRUCE = new HugeTreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredFeatures.SPRUCE_RED_TREE_LARGE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.SPRUCE_RED_TREE1;
        }
    };

    public static final TreeSpawner SPRUCE = new HugeTreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredFeatures.SPRUCE_TREE_LARGE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.SPRUCE_TREE1 : BYGConfiguredFeatures.SPRUCE_TREE2;
        }
    };

    public static final TreeSpawner BAOBAB = new HugeTreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredFeatures.BAOBAB_TREE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return null;
        }
    };

    public static final TreeSpawner ORANGE_SPRUCE = new HugeTreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredFeatures.SPRUCE_ORANGE_TREE_LARGE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.SPRUCE_ORANGE_TREE1;
        }
    };


    public static final TreeSpawner YELLOW_SPRUCE = new HugeTreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredFeatures.SPRUCE_YELLOW_TREE_LARGE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.SPRUCE_YELLOW_TREE1;
        }
    };


    public static final TreeSpawner BROWN_OAK = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.BROWN_OAK_TREE1;
        }
    };

    public static final TreeSpawner RAINBOW_EUCALYPTUS = new HugeTreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredFeatures.RAINBOW_LARGE_TREE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.RAINBOW_TREE1;
        }
    };

    public static final TreeSpawner OAK = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.OAK_TREE1 : BYGConfiguredFeatures.OAK_TREE2;
        }
    };

    public static final TreeSpawner ORANGE_OAK = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.ORANGE_OAK_TREE2;
        }
    };


    public static final TreeSpawner RED_OAK = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.RED_OAK_TREE3;
        }
    };


    public static final TreeSpawner ORANGE_BIRCH = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.BIRCH_ORANGE_TREE1;
        }
    };


    public static final TreeSpawner BROWN_BIRCH = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.BIRCH_BROWN_TREE1;
        }
    };

    public static final TreeSpawner BIRCH = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.BIRCH_TREE1 : BYGConfiguredFeatures.BIRCH_TREE2;
        }
    };


    public static final TreeSpawner RED_BIRCH = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.BIRCH_RED_TREE1;
        }
    };


    public static final TreeSpawner YELLOW_BIRCH = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.BIRCH_YELLOW_TREE1;
        }
    };

    public static final TreeSpawner JACARANDA = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(3) == 0 ? BYGConfiguredFeatures.JACARANDA_TREE1 : BYGConfiguredFeatures.JACARANDA_TREE2;
        }
    };

    public static final TreeSpawner INDIGO_JACARANDA = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(3) == 0 ? BYGConfiguredFeatures.INDIGO_JACARANDA_TREE1 : BYGConfiguredFeatures.INDIGO_JACARANDA_TREE2;
        }
    };

    public static final TreeSpawner FIR = new HugeTreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredFeatures.CONIFER_TREE8;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(3) == 0 ? BYGConfiguredFeatures.CONIFER_TREE2 : BYGConfiguredFeatures.CONIFER_TREE5;
        }
    };

    public static final TreeSpawner MAHOGONY = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.MAHOGANY_TREE1 : BYGConfiguredFeatures.MAHOGANY_TREE3;
        }
    };

    public static final TreeSpawner SKYRIS = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.SKYRIS_TREE1 : BYGConfiguredFeatures.SKYRIS_TREE2;
        }
    };

    public static final TreeSpawner ARAUCARIA = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.ARAUCARIA_TREE1 : BYGConfiguredFeatures.ARAUCARIA_TREE2;
        }
    };

    public static final TreeSpawner ASPEN = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.ASPEN_TREE1 : BYGConfiguredFeatures.ASPEN_TREE2;
        }
    };

    public static final TreeSpawner ZELKOVA = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.ZELKOVA_TREE1 : BYGConfiguredFeatures.ZELKOVA_TREE2;
        }
    };

    public static final TreeSpawner BROWN_ZELKOVA = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.ZELKOVA_BROWN_TREE1 : BYGConfiguredFeatures.ZELKOVA_BROWN_TREE3;
        }
    };

    public static final TreeSpawner PALO_VERDE = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.PALO_VERDE_TREE1 : BYGConfiguredFeatures.PALO_VERDE_TREE2;
        }
    };

    public static final TreeSpawner WILLOW = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.WILLOW_TREE1 : BYGConfiguredFeatures.WILLOW_TREE2;
        }
    };

    public static final TreeSpawner JOSHUA = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.JOSHUA_TREE1 : BYGConfiguredFeatures.JOSHUA_TREE2;
        }
    };

    public static final TreeSpawner PINE = new HugeTreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.PINE_TREE2 : BYGConfiguredFeatures.PINE_LARGE_TREE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.PINE_TREE1 : BYGConfiguredFeatures.PINE_TREE2;
        }
    };

    public static final TreeSpawner LAMENT = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.LAMENT_TWISTY_TREE1 : BYGConfiguredFeatures.LAMENT_WEEPING_TREE2;
        }
    };

    public static final TreeSpawner NIGHTSHADE = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.NIGHTSHADE_TREE1 : BYGConfiguredFeatures.NIGHTSHADE_TREE2;
        }
    };

    public static final TreeSpawner ETHER = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.ETHER_TREE2 : BYGConfiguredFeatures.ETHER_TREE3;
        }
    };

    public static final TreeSpawner MAPLE = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.MAPLE_TREE1;
        }
    };

    public static final TreeSpawner RED_MAPLE = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.MAPLE_RED_TREE1 : BYGConfiguredFeatures.MAPLE_RED_TREE2;
        }
    };

    public static final TreeSpawner SILVER_MAPLE = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.MAPLE_SILVER_TREE1 : BYGConfiguredFeatures.MAPLE_SILVER_TREE2;
        }
    };

    public static final TreeSpawner BLUE_ENCHANTED = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.ENCHANTED_BLUE_TREE1 : BYGConfiguredFeatures.ENCHANTED_BLUE_TREE2;
        }
    };

    public static final TreeSpawner GREEN_ENCHANTED = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.ENCHANTED_GREEN_TREE1 : BYGConfiguredFeatures.ENCHANTED_GREEN_TREE2;
        }
    };

    public static final TreeSpawner PINK_CHERRY = new HugeTreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredFeatures.CHERRY_PINK_TREE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.CHERRY_PINK_TREE2;
        }
    };

    public static final TreeSpawner WHITE_CHERRY = new HugeTreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredFeatures.CHERRY_WHITE_TREE1;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return BYGConfiguredFeatures.CHERRY_WHITE_TREE2;
        }
    };

    public static final TreeSpawner CYPRESS = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.CYPRESS_TREE2 : BYGConfiguredFeatures.CYPRESS_TREE3;
        }
    };

    public static final TreeSpawner WITCH_HAZEL = new HugeTreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.DEAD_HAZEL_TREE1 : BYGConfiguredFeatures.DEAD_HAZEL_TREE2;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return null;
        }
    };

    public static final TreeSpawner EBONY = new HugeTreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.EBONY_TREE1 : BYGConfiguredFeatures.EBONY_TREE2;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return null;
        }
    };

    public static final TreeSpawner HOLLY = new HugeTreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random) {
            return BYGConfiguredFeatures.HOLLY_TREE3;
        }

        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.HOLLY_TREE1 : BYGConfiguredFeatures.HOLLY_TREE2;
        }
    };

    public static final TreeSpawner PALM = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.PALM_TREE1 : BYGConfiguredFeatures.PALM_TREE2;
        }
    };

    public static final TreeSpawner MANGROVE = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.MANGROVE_TREE1 : BYGConfiguredFeatures.MANGROVE_TREE2;
        }
    };

    public static final TreeSpawner ORCHARD = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.ORCHARD_TREE1 : BYGConfiguredFeatures.ORCHARD_TREE2;
        }
    };

    public static final TreeSpawner CIKA = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.CIKA_TREE2 : BYGConfiguredFeatures.CIKA_TREE1;
        }
    };

    public static final TreeSpawner REDWOOD = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? BYGConfiguredFeatures.REDWOOD_TREE1 : BYGConfiguredFeatures.REDWOOD_TREE2;
        }
    };
}


