package corgiaoc.byg.common.world.feature.features.overworld.mushrooms.util;

import net.minecraft.world.gen.feature.ConfiguredFeature;
import corgiaoc.byg.common.world.feature.features.config.BYGMushroomFeatureConfig;
import corgiaoc.byg.core.byglists.BYGConfiguredTreeFeatures;

import javax.annotation.Nullable;
import java.util.Random;

public class BYGMushroomToHugeMushroom {

    public static class BlackPuff extends BYGHugeMushroom {
        @Nullable
        public ConfiguredFeature<BYGMushroomFeatureConfig, ?> getHugeMushroomFeature(Random random) {
            return BYGConfiguredTreeFeatures.BLACK_PUFF_HUGE;
        }
    }

    public static class BlueGlowshroom extends BYGHugeMushroom.Massive {
        @Nullable
        public ConfiguredFeature<BYGMushroomFeatureConfig, ?> getHugeMushroomFeature(Random random) {
            return BYGConfiguredTreeFeatures.BLUE_GLOWSHROOM_HUGE;
        }

        @Nullable
        @Override
        protected ConfiguredFeature<BYGMushroomFeatureConfig, ?> getMassiveMushroomFeature(Random random) {
            return null;
        }
    }

    public static class GreenMushroom extends BYGHugeMushroom {
        @Nullable
        public ConfiguredFeature<BYGMushroomFeatureConfig, ?> getHugeMushroomFeature(Random random) {
            return BYGConfiguredTreeFeatures.GREEN_MUSHROOM_HUGE;
        }
    }

    public static class PurpleGlowshroom extends BYGHugeMushroom.Massive {
        @Nullable
        public ConfiguredFeature<BYGMushroomFeatureConfig, ?> getHugeMushroomFeature(Random random) {
            return BYGConfiguredTreeFeatures.PURPLE_GLOWSHROOM_HUGE;
        }

        @Nullable
        @Override
        protected ConfiguredFeature<BYGMushroomFeatureConfig, ?> getMassiveMushroomFeature(Random random) {
            return null;
        }
    }


    public static class WeepingMilkCap extends BYGHugeMushroom {
        @Nullable
        public ConfiguredFeature<BYGMushroomFeatureConfig, ?> getHugeMushroomFeature(Random random) {
            return BYGConfiguredTreeFeatures.WEEPING_MILKCAP_HUGE;
        }
    }

    public static class WoodBlewit extends BYGHugeMushroom {
        @Nullable
        public ConfiguredFeature<BYGMushroomFeatureConfig, ?> getHugeMushroomFeature(Random random) {
            return BYGConfiguredTreeFeatures.WOOD_BLEWIT_HUGE;
        }
    }

    public static class EmburWart extends BYGHugeMushroom {
        @Nullable
        public ConfiguredFeature<BYGMushroomFeatureConfig, ?> getHugeMushroomFeature(Random random) {
            return (random.nextInt(2) == 0) ? BYGConfiguredTreeFeatures.EMBUR_MUSHROOM : BYGConfiguredTreeFeatures.EMBUR_MUSHROOM2;
        }
    }

    public static class SythianFungus extends BYGHugeMushroom {
        @Nullable
        public ConfiguredFeature<BYGMushroomFeatureConfig, ?> getHugeMushroomFeature(Random random) {
            return (random.nextInt(2) == 0) ? BYGConfiguredTreeFeatures.SYTHIAN_FUNGUS_TREE1 : BYGConfiguredTreeFeatures.SYTHIAN_FUNGUS_TREE2;
        }
    }

    public static class SoulShroom extends BYGHugeMushroom {
        @Nullable
        public ConfiguredFeature<BYGMushroomFeatureConfig, ?> getHugeMushroomFeature(Random random) {
            return (random.nextInt(2) == 0) ? BYGConfiguredTreeFeatures.SOUL_SHROOM_TREE1 : BYGConfiguredTreeFeatures.SOUL_SHROOM_TREE2;
        }
    }

    public static class DeathCap extends BYGHugeMushroom {
        @Nullable
        public ConfiguredFeature<BYGMushroomFeatureConfig, ?> getHugeMushroomFeature(Random random) {
            return (random.nextInt(2) == 0) ? BYGConfiguredTreeFeatures.DEATH_CAP_TREE2 : BYGConfiguredTreeFeatures.DEATH_CAP_TREE3;
        }
    }
}

