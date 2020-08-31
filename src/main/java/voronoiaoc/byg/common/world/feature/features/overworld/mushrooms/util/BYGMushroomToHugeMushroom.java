package voronoiaoc.byg.common.world.feature.features.overworld.mushrooms.util;

import voronoiaoc.byg.common.world.feature.features.overworld.mushrooms.*;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;

import javax.annotation.Nullable;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import java.util.Random;

public class BYGMushroomToHugeMushroom {

    public static class BlackPuff extends BYGHugeMushroom {
        @Nullable
        public BYGAbstractTreeFeature<NoneFeatureConfiguration> getHugeMushroomFeature(Random random) {
            return new BlackPuffHuge(NoneFeatureConfiguration.CODEC);
        }
    }

    public static class BlueGlowshroom extends BYGHugeMushroom.Massive {
        @Nullable
        public BYGAbstractTreeFeature<NoneFeatureConfiguration> getHugeMushroomFeature(Random random) {
            return new BlueGlowshroomHuge(NoneFeatureConfiguration.CODEC);
        }

        @Nullable
        @Override
        protected BYGAbstractTreeFeature<NoneFeatureConfiguration> getMassiveMushroomFeature(Random random) {
            return null;
        }
    }

    public static class GreenMushroom extends BYGHugeMushroom {
        @Nullable
        public BYGAbstractTreeFeature<NoneFeatureConfiguration> getHugeMushroomFeature(Random random) {
            return new GreenMushroomHuge(NoneFeatureConfiguration.CODEC);
        }
    }

    public static class PurpleGlowshroom extends BYGHugeMushroom.Massive {
        @Nullable
        public BYGAbstractTreeFeature<NoneFeatureConfiguration> getHugeMushroomFeature(Random random) {
            return new PurpleGlowshroomHuge(NoneFeatureConfiguration.CODEC);
        }

        @Nullable
        @Override
        protected BYGAbstractTreeFeature<NoneFeatureConfiguration> getMassiveMushroomFeature(Random random) {
            return null;
        }
    }


    public static class WeepingMilkCap extends BYGHugeMushroom {
        @Nullable
        public BYGAbstractTreeFeature<NoneFeatureConfiguration> getHugeMushroomFeature(Random random) {
            return new WeepingMilkcapHuge(NoneFeatureConfiguration.CODEC);
        }
    }

    public static class WoodBlewit extends BYGHugeMushroom {
        @Nullable
        public BYGAbstractTreeFeature<NoneFeatureConfiguration> getHugeMushroomFeature(Random random) {
            return new WoodBlewitHuge(NoneFeatureConfiguration.CODEC);
        }
    }

    public static class EmburWart extends BYGHugeMushroom {
        @Nullable
        public BYGAbstractTreeFeature<NoneFeatureConfiguration> getHugeMushroomFeature(Random random) {
            return (random.nextInt(2) == 0) ? new EmburMushroom(NoneFeatureConfiguration.CODEC) : new EmburMushroom2(NoneFeatureConfiguration.CODEC);
        }
    }
}

