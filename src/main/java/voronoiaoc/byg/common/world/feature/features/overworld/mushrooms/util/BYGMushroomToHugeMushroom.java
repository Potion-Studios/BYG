package voronoiaoc.byg.common.world.feature.features.overworld.mushrooms.util;

import net.minecraft.world.gen.feature.NoFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.mushrooms.*;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class BYGMushroomToHugeMushroom {

    public static class BlackPuff extends BYGHugeMushroom {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getHugeMushroomFeature(Random random) {
            return new BlackPuffHuge(NoFeatureConfig.field_236558_a_);
        }
    }

    public static class BlueGlowshroom extends BYGHugeMushroom.Massive {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getHugeMushroomFeature(Random random) {
            return new BlueGlowshroomHuge(NoFeatureConfig.field_236558_a_);
        }

        @Nullable
        @Override
        protected BYGAbstractTreeFeature<NoFeatureConfig> getMassiveMushroomFeature(Random random) {
            return null;
        }
    }

    public static class GreenMushroom extends BYGHugeMushroom {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getHugeMushroomFeature(Random random) {
            return new GreenMushroomHuge(NoFeatureConfig.field_236558_a_);
        }
    }

    public static class PurpleGlowshroom extends BYGHugeMushroom.Massive {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getHugeMushroomFeature(Random random) {
            return new PurpleGlowshroomHuge(NoFeatureConfig.field_236558_a_);
        }

        @Nullable
        @Override
        protected BYGAbstractTreeFeature<NoFeatureConfig> getMassiveMushroomFeature(Random random) {
            return null;
        }
    }


    public static class WeepingMilkCap extends BYGHugeMushroom {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getHugeMushroomFeature(Random random) {
            return new WeepingMilkcapHuge(NoFeatureConfig.field_236558_a_);
        }
    }

    public static class WoodBlewit extends BYGHugeMushroom {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getHugeMushroomFeature(Random random) {
            return new WoodBlewitHuge(NoFeatureConfig.field_236558_a_);
        }
    }
}

