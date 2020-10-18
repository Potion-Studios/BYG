package corgiaoc.byg.common.world.feature.overworld.mushrooms.util;

import corgiaoc.byg.common.world.feature.config.BYGMushroomConfig;
import corgiaoc.byg.core.world.BYGConfiguredFeatures;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class BYGMushroomToHugeMushroom {

    public static class BlackPuff extends BYGHugeMushroom {
        @Nullable
        public ConfiguredFeature<BYGMushroomConfig, ?> getHugeMushroomFeature(Random random) {
            return BYGConfiguredFeatures.BLACK_PUFF_HUGE;
        }
    }

    public static class BlueGlowshroom extends BYGHugeMushroom.Massive {
        @Nullable
        public ConfiguredFeature<BYGMushroomConfig, ?> getHugeMushroomFeature(Random random) {
            return BYGConfiguredFeatures.BLUE_GLOWSHROOM_HUGE;
        }

        @Nullable
        @Override
        protected ConfiguredFeature<BYGMushroomConfig, ?> getMassiveMushroomFeature(Random random) {
            return null;
        }
    }

    public static class GreenMushroom extends BYGHugeMushroom {
        @Nullable
        public ConfiguredFeature<BYGMushroomConfig, ?> getHugeMushroomFeature(Random random) {
            return BYGConfiguredFeatures.GREEN_MUSHROOM_HUGE;
        }
    }

    public static class PurpleGlowshroom extends BYGHugeMushroom.Massive {
        @Nullable
        public ConfiguredFeature<BYGMushroomConfig, ?> getHugeMushroomFeature(Random random) {
            return BYGConfiguredFeatures.PURPLE_GLOWSHROOM_HUGE;
        }

        @Nullable
        @Override
        protected ConfiguredFeature<BYGMushroomConfig, ?> getMassiveMushroomFeature(Random random) {
            return null;
        }
    }


    public static class WeepingMilkCap extends BYGHugeMushroom {
        @Nullable
        public ConfiguredFeature<BYGMushroomConfig, ?> getHugeMushroomFeature(Random random) {
            return BYGConfiguredFeatures.WEEPING_MILKCAP_HUGE;
        }
    }

    public static class WoodBlewit extends BYGHugeMushroom {
        @Nullable
        public ConfiguredFeature<BYGMushroomConfig, ?> getHugeMushroomFeature(Random random) {
            return BYGConfiguredFeatures.WOOD_BLEWIT_HUGE;
        }
    }

    public static class EmburWart extends BYGHugeMushroom {
        @Nullable
        public ConfiguredFeature<BYGMushroomConfig, ?> getHugeMushroomFeature(Random random) {
            return (random.nextInt(2) == 0) ? BYGConfiguredFeatures.EMBUR_MUSHROOM : BYGConfiguredFeatures.EMBUR_MUSHROOM2;
        }
    }

    public static class SythianFungus extends BYGHugeMushroom {
        @Nullable
        public ConfiguredFeature<BYGMushroomConfig, ?> getHugeMushroomFeature(Random random) {
            return (random.nextInt(2) == 0) ? BYGConfiguredFeatures.SYTHIAN_FUNGUS_TREE1 : BYGConfiguredFeatures.SYTHIAN_FUNGUS_TREE2;
        }
    }

    public static class SoulShroom extends BYGHugeMushroom {
        @Nullable
        public ConfiguredFeature<BYGMushroomConfig, ?> getHugeMushroomFeature(Random random) {
            return (random.nextInt(2) == 0) ? BYGConfiguredFeatures.SOUL_SHROOM_TREE1 : BYGConfiguredFeatures.SOUL_SHROOM_TREE2;
        }
    }

    public static class DeathCap extends BYGHugeMushroom {
        @Nullable
        public ConfiguredFeature<BYGMushroomConfig, ?> getHugeMushroomFeature(Random random) {
            return (random.nextInt(2) == 0) ? BYGConfiguredFeatures.DEATH_CAP_TREE2 : BYGConfiguredFeatures.DEATH_CAP_TREE3;
        }
    }

    public static class Bulbis extends BYGHugeMushroom {
        @Nullable
        public ConfiguredFeature<BYGMushroomConfig, ?> getHugeMushroomFeature(Random random) {
            return (random.nextInt(2) == 0) ? BYGConfiguredFeatures.BULBIS_TREE2 : BYGConfiguredFeatures.BULBIS_TREE4;
        }
    }

    public static class PurpleBulbis extends BYGHugeMushroom {
        @Nullable
        public ConfiguredFeature<BYGMushroomConfig, ?> getHugeMushroomFeature(Random random) {
            return (random.nextInt(2) == 0) ? BYGConfiguredFeatures.PURPLE_BULBIS_TREE2 : BYGConfiguredFeatures.PURPLE_BULBIS_TREE3;
        }
    }
}

