package corgiaoc.byg.common.world.feature.overworld.trees;

import corgiaoc.byg.common.world.feature.config.BYGTreeConfig;
import corgiaoc.byg.common.world.feature.overworld.trees.util.TreeSpawner;
import corgiaoc.byg.core.world.BYGConfiguredFeatures;
import net.minecraft.util.WeightedList;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;

public class TreeSpawners {
    public static class BlueSpruce extends TreeSpawner {

        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> weightedList = new WeightedList<>();
            weightedList.func_226313_a_(BYGConfiguredFeatures.SPRUCE_BLUE_TREE1, 1);
            weightedList.func_226313_a_(BYGConfiguredFeatures.SPRUCE_BLUE_TREE2, 1);
            weightedList.func_226313_a_(BYGConfiguredFeatures.SPRUCE_BLUE_TREE3, 1);
            weightedList.func_226313_a_(BYGConfiguredFeatures.SPRUCE_BLUE_TREE4, 1);
            weightedList.func_226313_a_(BYGConfiguredFeatures.SPRUCE_BLUE_TREE_MEDIUM1, 1);
            weightedList.func_226313_a_(BYGConfiguredFeatures.SPRUCE_BLUE_TREE_MEDIUM2, 1);
            weightedList.func_226313_a_(BYGConfiguredFeatures.SPRUCE_BLUE_TREE_MEDIUM3, 1);
            weightedList.func_226313_a_(BYGConfiguredFeatures.SPRUCE_BLUE_TREE_MEDIUM4, 1);
            weightedList.func_226313_a_(BYGConfiguredFeatures.SPRUCE_BLUE_TREE_LARGE1, 1);
            return weightedList;
        }
    }

    public static class RedSpruce extends TreeSpawner {

        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> weightedList = new WeightedList<>();
            weightedList.func_226313_a_(BYGConfiguredFeatures.SPRUCE_RED_TREE1, 1);
            weightedList.func_226313_a_(BYGConfiguredFeatures.SPRUCE_RED_TREE2, 1);
            weightedList.func_226313_a_(BYGConfiguredFeatures.SPRUCE_RED_TREE3, 1);
            weightedList.func_226313_a_(BYGConfiguredFeatures.SPRUCE_RED_TREE4, 1);
            weightedList.func_226313_a_(BYGConfiguredFeatures.SPRUCE_RED_TREE_MEDIUM1, 1);
            weightedList.func_226313_a_(BYGConfiguredFeatures.SPRUCE_RED_TREE_MEDIUM2, 1);
            weightedList.func_226313_a_(BYGConfiguredFeatures.SPRUCE_RED_TREE_MEDIUM3, 1);
            weightedList.func_226313_a_(BYGConfiguredFeatures.SPRUCE_RED_TREE_MEDIUM4, 1);
            weightedList.func_226313_a_(BYGConfiguredFeatures.SPRUCE_RED_TREE_LARGE1, 1);
            return weightedList;
        }
    }

    public static class Baobab extends TreeSpawner {
        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class OrangeSpruce extends TreeSpawner {

        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }


    public static class YellowSpruce extends TreeSpawner {

        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class BrownOak extends TreeSpawner {

        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class RainbowEucalyptus extends TreeSpawner {

        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }


    public static class OrangeOak extends TreeSpawner {

        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }


    public static class RedOak extends TreeSpawner {

        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }


    public static class OrangeBirch extends TreeSpawner {

        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }


    public static class BrownBirch extends TreeSpawner {

        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class RedBirch extends TreeSpawner {

        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class YellowBirch extends TreeSpawner {

        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class Jacaranda extends TreeSpawner {

        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class IndigoJacaranda extends TreeSpawner {

        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class Fir extends TreeSpawner {

        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class Mahogony extends TreeSpawner {

        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class Skyris extends TreeSpawner {

        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class Araucaria extends TreeSpawner {

        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class Aspen extends TreeSpawner {

        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class Zelkova extends TreeSpawner {


        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class BrownZelkova extends TreeSpawner {

        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class PaloVerde extends TreeSpawner {

        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class Willow extends TreeSpawner {


        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class Joshua extends TreeSpawner {

        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class Pine extends TreeSpawner {

        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class Lament extends TreeSpawner {


        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class WitheringOak extends TreeSpawner {


        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class Nightshade extends TreeSpawner {


        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class Ether extends TreeSpawner {


        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class Maple extends TreeSpawner {


        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class RedMaple extends TreeSpawner {


        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class SilverMaple extends TreeSpawner {


        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class BlueEnchanted extends TreeSpawner {

        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class GreenEnchanted extends TreeSpawner {

        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class PinkCherry extends TreeSpawner {


        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class WhiteCherry extends TreeSpawner {

        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class Cypress extends TreeSpawner {

        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class WitchHazel extends TreeSpawner {
        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class Ebony extends TreeSpawner {
        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class Holly extends TreeSpawner {
        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class Palm extends TreeSpawner {

        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class Mangrove extends TreeSpawner {


        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class Orchard extends TreeSpawner {

        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class Cika extends TreeSpawner {

        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }

    public static class Redwood extends TreeSpawner {
        @Nullable
        @Override
        protected WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList() {
            return null;
        }
    }
}


