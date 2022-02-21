package potionstudios.byg.common.world.feature.gen.overworld.mushrooms.util;

import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import potionstudios.byg.common.world.feature.config.BYGMushroomConfig;

import javax.annotation.Nullable;
import java.util.Random;

public class BYGMushroomToHugeMushroom {

    public static class GreenMushroom extends BYGHugeMushroom {
        @Nullable
        public ConfiguredFeature<BYGMushroomConfig, ?> getHugeMushroomFeature(Random random) {
            return null; // BYGConfiguredFeatures.GREEN_MUSHROOM_HUGE;
        }
    }

    public static class WeepingMilkCap extends BYGHugeMushroom {
        @Nullable
        public ConfiguredFeature<BYGMushroomConfig, ?> getHugeMushroomFeature(Random random) {
            return null; // BYGConfiguredFeatures.WEEPING_MILKCAP_HUGE;
        }
    }

    public static class WoodBlewit extends BYGHugeMushroom {
        @Nullable
        public ConfiguredFeature<BYGMushroomConfig, ?> getHugeMushroomFeature(Random random) {
            return null; // BYGConfiguredFeatures.WOOD_BLEWIT_HUGE;
        }
    }

    public static class EmburWart extends BYGHugeMushroom {
        @Nullable
        public ConfiguredFeature<BYGMushroomConfig, ?> getHugeMushroomFeature(Random random) {
            return null; // (random.nextInt(2) == 0) ? BYGConfiguredFeatures.EMBUR_MUSHROOM2 : BYGConfiguredFeatures.EMBUR_MUSHROOM3;
        }
    }

    public static class SythianFungus extends BYGHugeMushroom {
        @Nullable
        public ConfiguredFeature<BYGMushroomConfig, ?> getHugeMushroomFeature(Random random) {
            return null; // (random.nextInt(2) == 0) ? BYGConfiguredFeatures.SYTHIAN_FUNGUS_TREE1 : BYGConfiguredFeatures.SYTHIAN_FUNGUS_TREE2;
        }
    }

    public static class ShulkrenFungus extends BYGHugeMushroom {
        @Nullable
        public ConfiguredFeature<BYGMushroomConfig, ?> getHugeMushroomFeature(Random random) {
            return null; // (random.nextInt(2) == 0) ? BYGConfiguredFeatures.SHULKREN_TREE1 : BYGConfiguredFeatures.SHULKREN_TREE2;
        }
    }

    public static class FungalImparius extends BYGHugeMushroom {
        @Nullable
        public ConfiguredFeature<BYGMushroomConfig, ?> getHugeMushroomFeature(Random random) {
            return null; // (random.nextInt(2) == 0) ? BYGConfiguredFeatures.FUNGAL_IMPARIUS5 : BYGConfiguredFeatures.FUNGAL_IMPARIUS3;
        }
    }

    public static class ImpariusMushroom extends BYGHugeMushroom {
        @Nullable
        public ConfiguredFeature<BYGMushroomConfig, ?> getHugeMushroomFeature(Random random) {
            return null; // (random.nextInt(2) == 0) ? BYGConfiguredFeatures.IMPARIUS_MUSHROOM6 : BYGConfiguredFeatures.IMPARIUS_MUSHROOM4;
        }
    }

    public static class SoulShroom extends BYGHugeMushroom {
        @Nullable
        public ConfiguredFeature<BYGMushroomConfig, ?> getHugeMushroomFeature(Random random) {
            return null; // (random.nextInt(2) == 0) ? BYGConfiguredFeatures.SOUL_SHROOM_TREE1 : BYGConfiguredFeatures.SOUL_SHROOM_TREE2;
        }
    }

    public static class WitheringOak extends BYGHugeMushroom {
        @Nullable
        public ConfiguredFeature<BYGMushroomConfig, ?> getHugeMushroomFeature(Random random) {
            return null; // (random.nextInt(2) == 0) ? BYGConfiguredFeatures.WITHERING_OAK_TREE3 : BYGConfiguredFeatures.WITHERING_OAK_TREE4;
        }
    }

    public static class DeathCap extends BYGHugeMushroom {
        @Nullable
        public ConfiguredFeature<BYGMushroomConfig, ?> getHugeMushroomFeature(Random random) {
            return null; // (random.nextInt(2) == 0) ? BYGConfiguredFeatures.DEATH_CAP_TREE2 : BYGConfiguredFeatures.DEATH_CAP_TREE3;
        }
    }

    public static class Bulbis extends BYGHugeMushroom {
        @Nullable
        public ConfiguredFeature<BYGMushroomConfig, ?> getHugeMushroomFeature(Random random) {
            return null; // (random.nextInt(2) == 0) ? BYGConfiguredFeatures.BULBIS_TREE2 : BYGConfiguredFeatures.BULBIS_TREE4;
        }
    }

    public static class PurpleBulbis extends BYGHugeMushroom {
        @Nullable
        public ConfiguredFeature<BYGMushroomConfig, ?> getHugeMushroomFeature(Random random) {
            return null; // (random.nextInt(2) == 0) ? BYGConfiguredFeatures.PURPLE_BULBIS_TREE2 : BYGConfiguredFeatures.PURPLE_BULBIS_TREE3;
        }
    }
}

