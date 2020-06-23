package voronoiaoc.byg.common.world.feature.features.overworld.trees;

import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.aspen.AspenTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.aspen.AspenTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.baobab.BaobabTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.bayou.BayouTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.birch.BrownBirchTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.birch.OrangeBirchTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.birch.RedBirchTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.birch.YellowBirchTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.cherry.PinkCherry1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.cherry.PinkCherry2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.cherry.WhiteCherry1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.cherry.WhiteCherry2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.coniferous.ConiferTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.coniferous.ConiferTree6;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.coniferous.ConiferTree7;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.coniferous.ConiferTree8;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.cypress.CypressTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.cypress.CypressTree3;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.deadhazel.DeadHazel1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.deadhazel.DeadHazel2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.ebony.EbonyTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.ebony.EbonyTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.enchanted.blue.BlueEnchantedTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.enchanted.blue.BlueEnchantedTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.enchanted.green.GreenEnchantedTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.enchanted.green.GreenEnchantedTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.holly.HollyTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.holly.HollyTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.holly.HollyTree3;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.jacaranda.IndigoJacarandaTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.jacaranda.IndigoJacarandaTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.jacaranda.JacarandaTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.jacaranda.JacarandaTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.joshua.JoshuaTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.joshua.JoshuaTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.mangrove.MangroveTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.mangrove.MangroveTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.maple.*;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.oak.BrownOakTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.oak.OrangeOakTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.oak.RedOakTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.orchard.OrchardTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.orchard.OrchardTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.palo_verde.PaloVerdeTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.palo_verde.PaloVerdeTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.pine.LargePineTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.pine.LargePineTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.pine.PineTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.pine.PineTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.rainbow_eucalyptus.LargeRainbowEucalyptus;
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
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGHugeTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.willow.WillowTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.willow.WillowTree4;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.zelkova.ZelkovaTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.zelkova.ZelkovaTree3;

import javax.annotation.Nullable;
import java.util.Random;

public class BYGSaplingToTree {
    public static class BlueSpruceSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getBigTreeFeature(Random random) {
            return new GiantBlueSpruceTree(DefaultFeatureConfig.CODEC);
        }

        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return new BlueSpruceTree(DefaultFeatureConfig.CODEC);
        }
    }

    public static class RedSpruceSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getBigTreeFeature(Random random) {
            return new GiantRedSpruceTree(DefaultFeatureConfig.CODEC);
        }

        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return new RedSpruceTree(DefaultFeatureConfig.CODEC);
        }
    }

    public static class BaobabSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getBigTreeFeature(Random random) {
            return new BaobabTree1(DefaultFeatureConfig.CODEC);
        }

        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return null;
        }
    }

    public static class OrangeSpruceSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getBigTreeFeature(Random random) {
            return new GiantOrangeSpruceTree(DefaultFeatureConfig.CODEC);
        }

        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return new OrangeSpruceTree(DefaultFeatureConfig.CODEC);
        }
    }


    public static class YellowSpruceSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getBigTreeFeature(Random random) {
            return new GiantYellowSpruceTree(DefaultFeatureConfig.CODEC);
        }

        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return new YellowSpruceTree(DefaultFeatureConfig.CODEC);
        }
    }


    public static class BrownOakSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return new BrownOakTree(DefaultFeatureConfig.CODEC);
        }
    }

    public static class RainbowEucalyptusSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getBigTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new LargeRainbowEucalyptus(DefaultFeatureConfig.CODEC) : new LargeRainbowEucalyptus(DefaultFeatureConfig.CODEC);
        }

        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new RainbowEucalyptusTree(DefaultFeatureConfig.CODEC) : new RainbowEucalyptusTree(DefaultFeatureConfig.CODEC);
        }

    }


    public static class OrangeOakSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return new OrangeOakTree(DefaultFeatureConfig.CODEC);
        }
    }


    public static class RedOakSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return new RedOakTree(DefaultFeatureConfig.CODEC);
        }
    }


    public static class OrangeBirchSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return new OrangeBirchTree(DefaultFeatureConfig.CODEC);
        }
    }


    public static class BrownBirchSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return new BrownBirchTree(DefaultFeatureConfig.CODEC);
        }
    }


    public static class RedBirchSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return new RedBirchTree(DefaultFeatureConfig.CODEC);
        }
    }


    public static class YellowBirchSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return new YellowBirchTree(DefaultFeatureConfig.CODEC);
        }
    }

    public static class JacarandaSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(3) == 0 ? new JacarandaTree1(DefaultFeatureConfig.CODEC) : new JacarandaTree2(DefaultFeatureConfig.CODEC);
        }
    }

    public static class IndigoJacarandaSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(3) == 0 ? new IndigoJacarandaTree(DefaultFeatureConfig.CODEC) : new IndigoJacarandaTree2(DefaultFeatureConfig.CODEC);
        }
    }

    public static class FirSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getBigTreeFeature(Random random) {
            return new ConiferTree8(DefaultFeatureConfig.CODEC);
        }

        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return new ConiferTree6(DefaultFeatureConfig.CODEC);
        }
    }

    public static class MahogonySaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new TropicalRainForestTree(DefaultFeatureConfig.CODEC) : new ShortTropicalRainForestTree(DefaultFeatureConfig.CODEC);
        }
    }

    public static class SkyrisSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new SkyrisTree(DefaultFeatureConfig.CODEC) : new SkyrisTree2(DefaultFeatureConfig.CODEC);
        }
    }

    public static class AspenSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new AspenTree(DefaultFeatureConfig.CODEC) : new AspenTree2(DefaultFeatureConfig.CODEC);
        }
    }

    public static class ZelkovaSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new ZelkovaTree(DefaultFeatureConfig.CODEC) : new ZelkovaTree3(DefaultFeatureConfig.CODEC);
        }

    }

    public static class PaloVerdeSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new PaloVerdeTree(DefaultFeatureConfig.CODEC, 0) : new PaloVerdeTree2(DefaultFeatureConfig.CODEC, 0);
        }

    }

    public static class WillowSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new WillowTree1(DefaultFeatureConfig.CODEC) : new WillowTree4(DefaultFeatureConfig.CODEC);
        }

    }

    public static class JoshuaSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new JoshuaTree1(DefaultFeatureConfig.CODEC) : new JoshuaTree2(DefaultFeatureConfig.CODEC);
        }

    }

    public static class PineSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getBigTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new LargePineTree2(DefaultFeatureConfig.CODEC) : new LargePineTree1(DefaultFeatureConfig.CODEC);
        }

        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new PineTree1(DefaultFeatureConfig.CODEC) : new PineTree2(DefaultFeatureConfig.CODEC);
        }

    }

    public static class MapleSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new MapleTree(DefaultFeatureConfig.CODEC) : new MapleTree(DefaultFeatureConfig.CODEC);
        }

    }

    public static class RedMapleSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new RedMapleTree1(DefaultFeatureConfig.CODEC) : new RedMapleTree2(DefaultFeatureConfig.CODEC);
        }

    }

    public static class SilverMapleSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new SilverMapleTree1(DefaultFeatureConfig.CODEC) : new SilverMapleTree2(DefaultFeatureConfig.CODEC);
        }

    }

    public static class BlueEnchantedSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new BlueEnchantedTree1(DefaultFeatureConfig.CODEC) : new BlueEnchantedTree2(DefaultFeatureConfig.CODEC);
        }

    }

    public static class GreenEnchantedSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new GreenEnchantedTree1(DefaultFeatureConfig.CODEC) : new GreenEnchantedTree2(DefaultFeatureConfig.CODEC);
        }

    }

    public static class PinkCherrySaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getBigTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new PinkCherry1(DefaultFeatureConfig.CODEC) : new PinkCherry1(DefaultFeatureConfig.CODEC);
        }

        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new PinkCherry2(DefaultFeatureConfig.CODEC) : new PinkCherry2(DefaultFeatureConfig.CODEC);
        }

    }

    public static class WhiteCherrySaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getBigTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new WhiteCherry1(DefaultFeatureConfig.CODEC) : new WhiteCherry1(DefaultFeatureConfig.CODEC);
        }

        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new WhiteCherry2(DefaultFeatureConfig.CODEC) : new WhiteCherry2(DefaultFeatureConfig.CODEC);
        }

    }

    public static class CypressSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new CypressTree2(DefaultFeatureConfig.CODEC) : new CypressTree3(DefaultFeatureConfig.CODEC);
        }

    }

    public static class WitchHazelSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getBigTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new DeadHazel1(DefaultFeatureConfig.CODEC) : new DeadHazel2(DefaultFeatureConfig.CODEC);
        }

        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return null;
        }
    }

    public static class EbonySaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getBigTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new EbonyTree1(DefaultFeatureConfig.CODEC) : new EbonyTree2(DefaultFeatureConfig.CODEC);
        }

        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return null;
        }
    }

    public static class HollySaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getBigTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new HollyTree3(DefaultFeatureConfig.CODEC) : new HollyTree3(DefaultFeatureConfig.CODEC);
        }

        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new HollyTree1(DefaultFeatureConfig.CODEC) : new HollyTree2(DefaultFeatureConfig.CODEC);
        }

    }

    public static class MangroveSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new MangroveTree1(DefaultFeatureConfig.CODEC) : new MangroveTree2(DefaultFeatureConfig.CODEC);
        }

    }

    public static class OrchardSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new OrchardTree1(DefaultFeatureConfig.CODEC) : new OrchardTree2(DefaultFeatureConfig.CODEC);
        }

    }
}


