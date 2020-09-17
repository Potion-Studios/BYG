package voronoiaoc.byg.common.world.feature.features.overworld.mushrooms.util;

import voronoiaoc.byg.common.world.feature.config.BYGMushroomFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.mushrooms.*;

import javax.annotation.Nullable;
import java.util.Random;

public class BYGMushroomToHugeMushroom {

    public static class BlackPuff extends BYGHugeMushroom {
        @Nullable
        public BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> getHugeMushroomFeature(Random random) {
            return new BlackPuffHuge(BYGMushroomFeatureConfig.field_236558_a_);
        }
    }

    public static class BlueGlowshroom extends BYGHugeMushroom.Massive {
        @Nullable
        public BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> getHugeMushroomFeature(Random random) {
            return new BlueGlowshroomHuge(BYGMushroomFeatureConfig.field_236558_a_);
        }

        @Nullable
        @Override
        protected BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> getMassiveMushroomFeature(Random random) {
            return null;
        }
    }

    public static class GreenMushroom extends BYGHugeMushroom {
        @Nullable
        public BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> getHugeMushroomFeature(Random random) {
            return new GreenMushroomHuge(BYGMushroomFeatureConfig.field_236558_a_);
        }
    }

    public static class PurpleGlowshroom extends BYGHugeMushroom.Massive {
        @Nullable
        public BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> getHugeMushroomFeature(Random random) {
            return new PurpleGlowshroomHuge(BYGMushroomFeatureConfig.field_236558_a_);
        }

        @Nullable
        @Override
        protected BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> getMassiveMushroomFeature(Random random) {
            return null;
        }
    }


    public static class WeepingMilkCap extends BYGHugeMushroom {
        @Nullable
        public BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> getHugeMushroomFeature(Random random) {
            return new WeepingMilkcapHuge(BYGMushroomFeatureConfig.field_236558_a_);
        }
    }

    public static class WoodBlewit extends BYGHugeMushroom {
        @Nullable
        public BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> getHugeMushroomFeature(Random random) {
            return new WoodBlewitHuge(BYGMushroomFeatureConfig.field_236558_a_);
        }
    }

    public static class EmburWart extends BYGHugeMushroom {
        @Nullable
        public BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> getHugeMushroomFeature(Random random) {
            return (random.nextInt(2) == 0) ? new EmburMushroom(BYGMushroomFeatureConfig.field_236558_a_) : new EmburMushroom2(BYGMushroomFeatureConfig.field_236558_a_);
        }
    }

    public static class SythianFungus extends BYGHugeMushroom {
        @Nullable
        public BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> getHugeMushroomFeature(Random random) {
            return (random.nextInt(2) == 0) ? new SythianFungusTree1(BYGMushroomFeatureConfig.field_236558_a_) : new SythianFungusTree3(BYGMushroomFeatureConfig.field_236558_a_);
        }
    }

    public static class SoulShroom extends BYGHugeMushroom {
        @Nullable
        public BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> getHugeMushroomFeature(Random random) {
            return (random.nextInt(2) == 0) ? new SoulShroomTree1(BYGMushroomFeatureConfig.field_236558_a_) : new SoulShroomTree3(BYGMushroomFeatureConfig.field_236558_a_);
        }
    }

    public static class DeathCap extends BYGHugeMushroom {
        @Nullable
        public BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> getHugeMushroomFeature(Random random) {
            return (random.nextInt(2) == 0) ? new DeathCapTree2(BYGMushroomFeatureConfig.field_236558_a_) : new DeathCapTree3(BYGMushroomFeatureConfig.field_236558_a_);
        }
    }
}

