package potionstudios.byg.common.world.feature.gen.overworld.trees;

import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import potionstudios.byg.common.world.feature.config.BYGTreeConfig;
import potionstudios.byg.common.world.feature.gen.overworld.trees.util.TreeSpawner;

import javax.annotation.Nullable;

public class TreeSpawners {


    public static final TreeSpawner SHRUB = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(RandomSource random) {
            return null; // random.nextInt(3) == 0 ? BYGConfiguredFeatures.SHRUB_MEADOW : BYGConfiguredFeatures.SHRUB_PRAIRIE2;
        }
    };

    public static final TreeSpawner JACARANDA = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(RandomSource random) {
            return null; // random.nextInt(3) == 0 ? BYGConfiguredFeatures.JACARANDA_TREE1 : BYGConfiguredFeatures.JACARANDA_TREE2;
        }
    };

    public static final TreeSpawner INDIGO_JACARANDA = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(RandomSource random) {
            return null; // random.nextInt(3) == 0 ? BYGConfiguredFeatures.INDIGO_JACARANDA_TREE1 : BYGConfiguredFeatures.INDIGO_JACARANDA_TREE2;
        }
    };

    public static final TreeSpawner FIRECRACKER = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(RandomSource random) {
            return null; // random.nextInt(2) == 0 ? BYGConfiguredFeatures.FIRECRACKER_SHRUB : BYGConfiguredFeatures.FIRECRACKER_SHRUB2;
        }
    };

}


