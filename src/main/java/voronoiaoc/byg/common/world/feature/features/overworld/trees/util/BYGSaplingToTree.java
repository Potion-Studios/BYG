package voronoiaoc.byg.common.world.feature.features.overworld.trees.util;

import net.minecraft.world.gen.feature.NoFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.aspen.AspenTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.aspen.AspenTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.baobab.BaobabTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.willow.WillowTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.birch.BrownBirchTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.birch.OrangeBirchTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.birch.RedBirchTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.birch.YellowBirchTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.coniferous.ConiferTree6;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.coniferous.ConiferTree8;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.enchanted.blue.BlueEnchantedGroveTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.enchanted.green.GreenEnchantedGroveTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.jacaranda.IndigoJacarandaTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.jacaranda.IndigoJacarandaTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.jacaranda.JacarandaTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.jacaranda.JacarandaTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.joshua.JoshuaTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.joshua.JoshuaTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.maple.MapleTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.maple.RedMapleTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.maple.RedMapleTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.maple.SilverMapleTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.oak.BrownOakTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.oak.OrangeOakTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.oak.RedOakTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.palo_verde.PaloVerdeTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.palo_verde.PaloVerdeTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.pine.PineTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.pine.PineTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.pine.PineTreeLarge1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.rainbow_eucalyptus.RainbowEucalyptusTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.skyris.SkyrisTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.skyris.SkyrisTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.taiga.giantspruce.GiantBlueSpruceTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.taiga.giantspruce.GiantOrangeSpruceTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.taiga.giantspruce.GiantRedSpruceTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.taiga.giantspruce.GiantYellowSpruceTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.taiga.spruce.BlueSpruceTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.taiga.spruce.OrangeSpruceTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.taiga.spruce.RedSpruceTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.taiga.spruce.YellowSpruceTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.tropical.ShortTropicalRainForestTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.tropical.TropicalRainForestTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.zelkova.ZelkovaTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.zelkova.ZelkovaTree3;

import javax.annotation.Nullable;
import java.util.Random;

public class BYGSaplingToTree {
    public static class BlueSpruceSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getBigTreeFeature(Random random) {
            return new GiantBlueSpruceTree(NoFeatureConfig::deserialize);
        }

        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return new BlueSpruceTree(NoFeatureConfig::deserialize);
        }
    }

    public static class RedSpruceSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getBigTreeFeature(Random random) {
            return new GiantRedSpruceTree(NoFeatureConfig::deserialize);
        }

        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return new RedSpruceTree(NoFeatureConfig::deserialize);
        }
    }

    public static class BaobabSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getBigTreeFeature(Random random) {
            return new BaobabTree1(NoFeatureConfig::deserialize);
        }

        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return null;
        }
    }

    public static class OrangeSpruceSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getBigTreeFeature(Random random) {
            return new GiantOrangeSpruceTree(NoFeatureConfig::deserialize);
        }

        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return new OrangeSpruceTree(NoFeatureConfig::deserialize);
        }
    }


    public static class YellowSpruceSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getBigTreeFeature(Random random) {
            return new GiantYellowSpruceTree(NoFeatureConfig::deserialize);
        }

        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return new YellowSpruceTree(NoFeatureConfig::deserialize);
        }
    }


    public static class BrownOakSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return new BrownOakTree(NoFeatureConfig::deserialize);
        }
    }

    public static class RainbowEucalyptusSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return new RainbowEucalyptusTree(NoFeatureConfig::deserialize);
        }
    }


    public static class OrangeOakSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return new OrangeOakTree(NoFeatureConfig::deserialize);
        }
    }


    public static class RedOakSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return new RedOakTree(NoFeatureConfig::deserialize);
        }
    }


    public static class OrangeBirchSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return new OrangeBirchTree(NoFeatureConfig::deserialize);
        }
    }


    public static class BrownBirchSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return new BrownBirchTree(NoFeatureConfig::deserialize);
        }
    }


    public static class RedBirchSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return new RedBirchTree(NoFeatureConfig::deserialize);
        }
    }


    public static class YellowBirchSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return new YellowBirchTree(NoFeatureConfig::deserialize);
        }
    }

    public static class JacarandaSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(3) == 0 ? new JacarandaTree1(NoFeatureConfig::deserialize) : new JacarandaTree2(NoFeatureConfig::deserialize);
        }
    }

    public static class IndigoJacarandaSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(3) == 0 ? new IndigoJacarandaTree(NoFeatureConfig::deserialize) : new IndigoJacarandaTree2(NoFeatureConfig::deserialize);
        }
    }

    public static class FirSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getBigTreeFeature(Random random) {
            return new ConiferTree8(NoFeatureConfig::deserialize);
        }

        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return new ConiferTree6(NoFeatureConfig::deserialize);
        }
    }

    public static class MahogonySaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new TropicalRainForestTree(NoFeatureConfig::deserialize) : new ShortTropicalRainForestTree(NoFeatureConfig::deserialize);
        }
    }

    public static class SkyrisSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new SkyrisTree(NoFeatureConfig::deserialize) : new SkyrisTree2(NoFeatureConfig::deserialize);
        }
    }

    public static class AspenSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new AspenTree(NoFeatureConfig::deserialize) : new AspenTree2(NoFeatureConfig::deserialize);
        }
    }

    public static class ZelkovaSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new ZelkovaTree(NoFeatureConfig::deserialize) : new ZelkovaTree3(NoFeatureConfig::deserialize, 0);
        }

    }

    public static class PaloVerdeSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new PaloVerdeTree(NoFeatureConfig::deserialize, 0) : new PaloVerdeTree2(NoFeatureConfig::deserialize, 0);
        }

    }

    public static class WillowSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new WillowTree1(NoFeatureConfig::deserialize) : new WillowTree1(NoFeatureConfig::deserialize);
        }

    }

    public static class JoshuaSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new JoshuaTree1(NoFeatureConfig::deserialize) : new JoshuaTree2(NoFeatureConfig::deserialize);
        }

    }

    public static class PineSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getBigTreeFeature(Random random) {
            return new PineTreeLarge1(NoFeatureConfig::deserialize);
        }

        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new PineTree1(NoFeatureConfig::deserialize) : new PineTree2(NoFeatureConfig::deserialize);
        }

    }

    public static class MapleSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new MapleTree(NoFeatureConfig::deserialize) : new MapleTree(NoFeatureConfig::deserialize);
        }

    }

    public static class RedMapleSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new RedMapleTree1(NoFeatureConfig::deserialize) : new RedMapleTree2(NoFeatureConfig::deserialize);
        }

    }

    public static class SilverMapleSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new SilverMapleTree1(NoFeatureConfig::deserialize) : new SilverMapleTree1(NoFeatureConfig::deserialize);
        }

    }

    public static class BlueEnchantedSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new BlueEnchantedGroveTree(NoFeatureConfig::deserialize) : new BlueEnchantedGroveTree(NoFeatureConfig::deserialize);
        }

    }

    public static class GreenEnchantedSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new GreenEnchantedGroveTree(NoFeatureConfig::deserialize) : new GreenEnchantedGroveTree(NoFeatureConfig::deserialize);
        }

    }
}

