package voronoiaoc.byg.common.world.feature.features.overworld.trees.util;

import net.minecraft.world.gen.feature.NoFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.aspen.AspenTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.aspen.AspenTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.baobab.BaobabTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.birch.BrownBirchTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.birch.OrangeBirchTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.birch.RedBirchTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.birch.YellowBirchTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.cherry.PinkCherry1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.cherry.PinkCherry2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.cherry.WhiteCherry1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.cherry.WhiteCherry2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.cika.CikaTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.cika.CikaTree3;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.coniferous.ConiferTree6;
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
import voronoiaoc.byg.common.world.feature.features.overworld.trees.redwood.RedwoodTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.redwood.RedwoodTree3;
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
import voronoiaoc.byg.common.world.feature.features.overworld.trees.willow.WillowTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.willow.WillowTree4;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.zelkova.ZelkovaTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.zelkova.ZelkovaTree3;

import javax.annotation.Nullable;
import java.util.Random;

public class BYGSaplingToTree {
    public static class BlueSpruceSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getBigTreeFeature(Random random) {
            return new GiantBlueSpruceTree(NoFeatureConfig.field_236558_a_);
        }

        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return new BlueSpruceTree(NoFeatureConfig.field_236558_a_);
        }
    }

    public static class RedSpruceSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getBigTreeFeature(Random random) {
            return new GiantRedSpruceTree(NoFeatureConfig.field_236558_a_);
        }

        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return new RedSpruceTree(NoFeatureConfig.field_236558_a_);
        }
    }

    public static class BaobabSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getBigTreeFeature(Random random) {
            return new BaobabTree1(NoFeatureConfig.field_236558_a_);
        }

        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return null;
        }
    }

    public static class OrangeSpruceSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getBigTreeFeature(Random random) {
            return new GiantOrangeSpruceTree(NoFeatureConfig.field_236558_a_);
        }

        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return new OrangeSpruceTree(NoFeatureConfig.field_236558_a_);
        }
    }


    public static class YellowSpruceSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getBigTreeFeature(Random random) {
            return new GiantYellowSpruceTree(NoFeatureConfig.field_236558_a_);
        }

        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return new YellowSpruceTree(NoFeatureConfig.field_236558_a_);
        }
    }


    public static class BrownOakSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return new BrownOakTree(NoFeatureConfig.field_236558_a_);
        }
    }

    public static class RainbowEucalyptusSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getBigTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new LargeRainbowEucalyptus(NoFeatureConfig.field_236558_a_) : new LargeRainbowEucalyptus(NoFeatureConfig.field_236558_a_);
        }

        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new RainbowEucalyptusTree(NoFeatureConfig.field_236558_a_) : new RainbowEucalyptusTree(NoFeatureConfig.field_236558_a_);
        }

    }


    public static class OrangeOakSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return new OrangeOakTree(NoFeatureConfig.field_236558_a_);
        }
    }


    public static class RedOakSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return new RedOakTree(NoFeatureConfig.field_236558_a_);
        }
    }


    public static class OrangeBirchSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return new OrangeBirchTree(NoFeatureConfig.field_236558_a_);
        }
    }


    public static class BrownBirchSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return new BrownBirchTree(NoFeatureConfig.field_236558_a_);
        }
    }


    public static class RedBirchSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return new RedBirchTree(NoFeatureConfig.field_236558_a_);
        }
    }


    public static class YellowBirchSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return new YellowBirchTree(NoFeatureConfig.field_236558_a_);
        }
    }

    public static class JacarandaSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(3) == 0 ? new JacarandaTree1(NoFeatureConfig.field_236558_a_) : new JacarandaTree2(NoFeatureConfig.field_236558_a_);
        }
    }

    public static class IndigoJacarandaSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(3) == 0 ? new IndigoJacarandaTree(NoFeatureConfig.field_236558_a_) : new IndigoJacarandaTree2(NoFeatureConfig.field_236558_a_);
        }
    }

    public static class FirSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getBigTreeFeature(Random random) {
            return new ConiferTree8(NoFeatureConfig.field_236558_a_);
        }

        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return new ConiferTree6(NoFeatureConfig.field_236558_a_);
        }
    }

    public static class MahogonySaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new TropicalRainForestTree(NoFeatureConfig.field_236558_a_) : new ShortTropicalRainForestTree(NoFeatureConfig.field_236558_a_);
        }
    }

    public static class SkyrisSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new SkyrisTree(NoFeatureConfig.field_236558_a_) : new SkyrisTree2(NoFeatureConfig.field_236558_a_);
        }
    }

    public static class AspenSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new AspenTree(NoFeatureConfig.field_236558_a_) : new AspenTree2(NoFeatureConfig.field_236558_a_);
        }
    }

    public static class ZelkovaSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new ZelkovaTree(NoFeatureConfig.field_236558_a_) : new ZelkovaTree3(NoFeatureConfig.field_236558_a_);
        }

    }

    public static class PaloVerdeSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new PaloVerdeTree(NoFeatureConfig.field_236558_a_, 0) : new PaloVerdeTree2(NoFeatureConfig.field_236558_a_, 0);
        }

    }

    public static class WillowSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new WillowTree1(NoFeatureConfig.field_236558_a_) : new WillowTree4(NoFeatureConfig.field_236558_a_);
        }

    }

    public static class JoshuaSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new JoshuaTree1(NoFeatureConfig.field_236558_a_) : new JoshuaTree2(NoFeatureConfig.field_236558_a_);
        }

    }

    public static class PineSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getBigTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new LargePineTree2(NoFeatureConfig.field_236558_a_) : new LargePineTree1(NoFeatureConfig.field_236558_a_);
        }

        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new PineTree1(NoFeatureConfig.field_236558_a_) : new PineTree2(NoFeatureConfig.field_236558_a_);
        }

    }

    public static class MapleSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new MapleTree(NoFeatureConfig.field_236558_a_) : new MapleTree(NoFeatureConfig.field_236558_a_);
        }

    }

    public static class RedMapleSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new RedMapleTree1(NoFeatureConfig.field_236558_a_) : new RedMapleTree2(NoFeatureConfig.field_236558_a_);
        }

    }

    public static class SilverMapleSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new SilverMapleTree1(NoFeatureConfig.field_236558_a_) : new SilverMapleTree2(NoFeatureConfig.field_236558_a_);
        }

    }

    public static class BlueEnchantedSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new BlueEnchantedTree1(NoFeatureConfig.field_236558_a_) : new BlueEnchantedTree2(NoFeatureConfig.field_236558_a_);
        }

    }

    public static class GreenEnchantedSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new GreenEnchantedTree1(NoFeatureConfig.field_236558_a_) : new GreenEnchantedTree2(NoFeatureConfig.field_236558_a_);
        }

    }

    public static class PinkCherrySaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getBigTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new PinkCherry1(NoFeatureConfig.field_236558_a_) : new PinkCherry1(NoFeatureConfig.field_236558_a_);
        }

        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new PinkCherry2(NoFeatureConfig.field_236558_a_) : new PinkCherry2(NoFeatureConfig.field_236558_a_);
        }

    }

    public static class WhiteCherrySaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getBigTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new WhiteCherry1(NoFeatureConfig.field_236558_a_) : new WhiteCherry1(NoFeatureConfig.field_236558_a_);
        }

        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new WhiteCherry2(NoFeatureConfig.field_236558_a_) : new WhiteCherry2(NoFeatureConfig.field_236558_a_);
        }

    }

    public static class CypressSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new CypressTree2(NoFeatureConfig.field_236558_a_) : new CypressTree3(NoFeatureConfig.field_236558_a_);
        }

    }

    public static class WitchHazelSaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getBigTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new DeadHazel1(NoFeatureConfig.field_236558_a_) : new DeadHazel2(NoFeatureConfig.field_236558_a_);
        }

        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return null;
        }
    }

    public static class EbonySaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getBigTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new EbonyTree1(NoFeatureConfig.field_236558_a_) : new EbonyTree2(NoFeatureConfig.field_236558_a_);
        }

        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return null;
        }
    }

    public static class HollySaplingToTree extends BYGHugeTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getBigTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new HollyTree3(NoFeatureConfig.field_236558_a_) : new HollyTree3(NoFeatureConfig.field_236558_a_);
        }

        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new HollyTree1(NoFeatureConfig.field_236558_a_) : new HollyTree2(NoFeatureConfig.field_236558_a_);
        }

    }

    public static class MangroveSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new MangroveTree1(NoFeatureConfig.field_236558_a_) : new MangroveTree2(NoFeatureConfig.field_236558_a_);
        }

    }

    public static class OrchardSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new OrchardTree1(NoFeatureConfig.field_236558_a_) : new OrchardTree2(NoFeatureConfig.field_236558_a_);
        }

    }

    public static class CikaSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new CikaTree2(NoFeatureConfig.field_236558_a_) : new CikaTree3(NoFeatureConfig.field_236558_a_);
        }
    }

    public static class RedwoodSaplingToTree extends BYGTree {
        @Nullable
        public BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
            return random.nextInt(2) == 0 ? new RedwoodTree1(NoFeatureConfig.field_236558_a_) : new RedwoodTree3(NoFeatureConfig.field_236558_a_);
        }
    }
}

