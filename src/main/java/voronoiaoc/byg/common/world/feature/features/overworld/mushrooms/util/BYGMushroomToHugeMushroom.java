package voronoiaoc.byg.common.world.feature.features.overworld.mushrooms.util;

import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.mushrooms.*;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class BYGMushroomToHugeMushroom {

    public static class BlackPuff extends BYGHugeMushroom {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getHugeMushroomFeature(Random random) {
            return new BlackPuffHuge(DefaultFeatureConfig.CODEC);
        }
    }

    public static class BlueGlowshroom extends BYGHugeMushroom.Massive {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getHugeMushroomFeature(Random random) {
            return new BlueGlowshroomHuge(DefaultFeatureConfig.CODEC);
        }

        @Nullable
        @Override
        protected BYGAbstractTreeFeature<DefaultFeatureConfig> getMassiveMushroomFeature(Random random) {
            return null;
        }
    }

    public static class GreenMushroom extends BYGHugeMushroom {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getHugeMushroomFeature(Random random) {
            return new GreenMushroomHuge(DefaultFeatureConfig.CODEC);
        }
    }

    public static class PurpleGlowshroom extends BYGHugeMushroom.Massive {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getHugeMushroomFeature(Random random) {
            return new PurpleGlowshroomHuge(DefaultFeatureConfig.CODEC);
        }

        @Nullable
        @Override
        protected BYGAbstractTreeFeature<DefaultFeatureConfig> getMassiveMushroomFeature(Random random) {
            return null;
        }
    }


    public static class WeepingMilkCap extends BYGHugeMushroom {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getHugeMushroomFeature(Random random) {
            return new WeepingMilkcapHuge(DefaultFeatureConfig.CODEC);
        }
    }

    public static class WoodBlewit extends BYGHugeMushroom {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getHugeMushroomFeature(Random random) {
            return new WoodBlewitHuge(DefaultFeatureConfig.CODEC);
        }
    }

    public static class EmburWart extends BYGHugeMushroom {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getHugeMushroomFeature(Random random) {
            return (random.nextInt(2) == 0) ? new EmburMushroom(DefaultFeatureConfig.CODEC) : new EmburMushroom2(DefaultFeatureConfig.CODEC);
        }
    }
}

