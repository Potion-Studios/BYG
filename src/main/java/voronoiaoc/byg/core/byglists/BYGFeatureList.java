package voronoiaoc.byg.core.byglists;

import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.SingleStateFeatureConfig;
import voronoiaoc.byg.common.world.feature.biomefeatures.FrostMagmaLakeFeature;
import voronoiaoc.byg.common.world.feature.biomefeatures.LakeWideShallow;
import voronoiaoc.byg.common.world.feature.features.end.obsidianspires.ObsidianSpike;
import voronoiaoc.byg.common.world.feature.features.nether.sythiantorrids.SythianRoots;
import voronoiaoc.byg.common.world.feature.features.nether.sythiantorrids.SythianSprout;
import voronoiaoc.byg.common.world.feature.features.nether.sythiantorrids.SythianStalk;
import voronoiaoc.byg.common.world.feature.features.nether.warpeddesert.WarpedBush;
import voronoiaoc.byg.common.world.feature.features.nether.warpeddesert.WarpedCoral;
import voronoiaoc.byg.common.world.feature.features.nether.warpeddesert.WarpedCoralFan;
import voronoiaoc.byg.common.world.feature.features.nether.warpeddesert.WarpedCoralFeature;
import voronoiaoc.byg.common.world.feature.features.overworld.BlackIceAndSnowFeature;
import voronoiaoc.byg.common.world.feature.features.overworld.CanyonCactus;
import voronoiaoc.byg.common.world.feature.features.overworld.VinePlacer;
import voronoiaoc.byg.common.world.feature.features.overworld.deadsea.DeadSeaSpikes;
import voronoiaoc.byg.common.world.feature.features.overworld.deadsea.TallDeadSeaSpikes;
import voronoiaoc.byg.common.world.feature.features.overworld.mushrooms.HugeBlackPuff;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.aspen.*;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.baobab.BaobabTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.bayou.BayouTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.bayou.BayouTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.bayou.BayouTree3;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.birch.BrownBirchTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.birch.OrangeBirchTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.birch.RedBirchTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.birch.YellowBirchTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.bluff.BluffTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.bluff.BluffTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.bluff.BluffTree3;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.boreal.BorealForestTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.boreal.BorealForestTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.coniferous.SmallFirTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.coniferous.TallFirTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.coniferous.WideFirTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.deciduous.*;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.jacaranda.IndigoJacarandaTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.jacaranda.IndigoJacarandaTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.jacaranda.JacarandaTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.jacaranda.JacarandaTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.joshua.JoshuaTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.joshua.JoshuaTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.meadow.MeadowShrub;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.meadow.MeadowShrub2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.oak.BrownOakTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.oak.OrangeOakTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.oak.RedOakTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.palm.PalmTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.palo_verde.PaloVerdeTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.palo_verde.PaloVerdeTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.prairie.PrairieShrub;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.prairie.PrairieShrub2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.rainbow_eucalyptus.RainbowEucalyptusTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.redwood.RedwoodTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.skyris.SkyrisTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.skyris.SkyrisTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.skyris.SkyrisTree3;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.taiga.giantspruce.GiantBlueSpruceTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.taiga.giantspruce.GiantOrangeSpruceTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.taiga.giantspruce.GiantRedSpruceTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.taiga.giantspruce.GiantYellowSpruceTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.taiga.smallspruce.SmallBlueTaigaTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.taiga.smallspruce.SmallOrangeSpruceTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.taiga.smallspruce.SmallRedSpruceTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.taiga.smallspruce.SmallYellowTaigaTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.taiga.spruce.BlueSpruceTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.taiga.spruce.OrangeSpruceTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.taiga.spruce.RedSpruceTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.taiga.spruce.YellowSpruceTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.taiga.tallspruce.TallBlueSpruceTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.taiga.tallspruce.TallOrangeSpruceTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.taiga.tallspruce.TallRedSpruceTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.taiga.tallspruce.TallYellowSpruceTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.tropical.BYGTropShrub;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.tropical.ShortTropicalRainForestTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.tropical.TropicalRainForestTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.zelkova.ZelkovaTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.zelkova.ZelkovaTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.zelkova.ZelkovaTree3;

public class BYGFeatureList {
    //Seasonal Oaks
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> BROWNOAK_TREE = new BrownOakTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ORANGEOAK_TREE = new OrangeOakTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> REDOAK_TREE = new RedOakTree(DefaultFeatureConfig.CODEC);

    //Seasonal Birch
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> BROWNBIRCH_TREE = new BrownBirchTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ORANGEBIRCH_TREE = new OrangeBirchTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> REDBIRCH_TREE = new RedBirchTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> YELLOWBIRCH_TREE = new YellowBirchTree(DefaultFeatureConfig.CODEC);

    //Cypress
//    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> HUGECYPRESS_TREE = new HugeCypressTree(DefaultFeatureConfig.CODEC);

    //Seasonal Deciduous and Deciduous
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> DECIDUOUS_TREE = new DeciduousTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> BROWNDECIDUOUS_TREE = new BrownDeciduousTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ORANGEDECIDUOUS_TREE = new OrangeDeciduousTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> YELLOWDECIDUOUS_TREE = new YellowDeciduousTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> REDDECIDUOUS_TREE = new RedDeciduousTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> SEASONAL_SHRUBS = new ColorfulDeciduousShrubs(DefaultFeatureConfig.CODEC);


    //Seasonal TaigaTrees
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> BLUEGIANTSPUCE_TREE = new GiantBlueSpruceTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> TALLBLUESPRUCE_TREE = new TallBlueSpruceTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> BLUESPRUCE_TREE = new BlueSpruceTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> SMALLBLUESPRUCE_TREE = new SmallBlueTaigaTree(DefaultFeatureConfig.CODEC);

    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> GIANTORANGESPRUCE_TREE = new GiantOrangeSpruceTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> TALLORANGESPRUCE_TREE = new TallOrangeSpruceTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ORANGESPRUCE_TREE = new OrangeSpruceTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> SMALLORANGESPRUCE_TREE = new SmallOrangeSpruceTree(DefaultFeatureConfig.CODEC);

    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> GIANTREDSPRUCE_TREE = new GiantRedSpruceTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> TALLREDSPRUCE_TREE = new TallRedSpruceTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> REDSPRUCE_TREE = new RedSpruceTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> SMALLREDSPRUCE_TREE = new SmallRedSpruceTree(DefaultFeatureConfig.CODEC);

    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> GIANTYELLOWSPRUCE_TREE = new GiantYellowSpruceTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> TALLYELLOWSPRUCE_TREE = new TallYellowSpruceTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> YELLOWSPRUCE_TREE = new YellowSpruceTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> SMALLYELLOWSPRUCE_TREE = new SmallYellowTaigaTree(DefaultFeatureConfig.CODEC);

    //Boreal Trees
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> BOREAL_TREE = new BorealForestTree1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> BOREAL_TREE2 = new BorealForestTree2(DefaultFeatureConfig.CODEC);

    //Tropical Trees
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> TROPICALRAINFOREST_TREE = new TropicalRainForestTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> SHORTTROPICALRAINFOREST_TREE = new ShortTropicalRainForestTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> TROPJUNGLE_SHRUB = new BYGTropShrub(DefaultFeatureConfig.CODEC);

    //Shrub
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> SHRUB = new BYGShrub(DefaultFeatureConfig.CODEC);

    //Coniferous Trees
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> SMALLCONIFEROUS_TREE = new SmallFirTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> TALLCONIFEROUS_TREE = new TallFirTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> WIDECONIFEROUS_TREE = new WideFirTree(DefaultFeatureConfig.CODEC);

//    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> DEAD_TREE = new DeadTree(DefaultFeatureConfig.CODEC);

    //Jacaranda Tree
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> JACARANDA_TREE = new JacarandaTree1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> JACARANDA_TREE2 = new JacarandaTree2(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> INDIGOJACARANDA_TREE = new IndigoJacarandaTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> INDIGOJACARANDA_TREE2 = new IndigoJacarandaTree2(DefaultFeatureConfig.CODEC);

    //Palm Tree
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> PALM_TREE1 = new PalmTree1(DefaultFeatureConfig.CODEC);

    //Skyris Tree
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> SKYRIS_TREE1 = new SkyrisTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> SKYRIS_TREE2 = new SkyrisTree2(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> SKYRIS_TREE3 = new SkyrisTree3(DefaultFeatureConfig.CODEC);

    //Bluff Trees
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> BLUFF_TREE1 = new BluffTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> BLUFF_TREE2 = new BluffTree2(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> BLUFF_TREE3 = new BluffTree3(DefaultFeatureConfig.CODEC);

    //Rainbow Tree
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> RAINBOW_TREE1 = new RainbowEucalyptusTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> RAINBOW_TREE2 = new RainbowEucalyptusTree(DefaultFeatureConfig.CODEC);

    //Baobab Tree
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> BAOBAB_TREE1 = new BaobabTree1(DefaultFeatureConfig.CODEC);

    //MeadowShrubs
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> MEADOW_SHRUB1 = new MeadowShrub(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> MEADOW_SHRUB2 = new MeadowShrub2(DefaultFeatureConfig.CODEC);


    //MeadowShrubs
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> PRAIRIE_SHRUB1 = new PrairieShrub(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> PRAIRIE_SHRUB2 = new PrairieShrub2(DefaultFeatureConfig.CODEC);

    //RedWood
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> REDWOOD_TREE1 = new RedwoodTree1(DefaultFeatureConfig.CODEC);

    //WarpedDesert
    public static final Feature<DefaultFeatureConfig> WARPED_BUSH = new WarpedBush(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> WARPED_CORAL = new WarpedCoral(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> WARPED_CORALPLANT = new WarpedCoralFeature(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> WARPED_CORALFAN = new WarpedCoralFan(DefaultFeatureConfig.CODEC);

    //DeadSea
    public static final Feature<DefaultFeatureConfig> DEADSEASPIKES = new DeadSeaSpikes(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> TALLDEADSEASPIKES = new TallDeadSeaSpikes(DefaultFeatureConfig.CODEC);

    //Stone Forest
//    public static final Feature<DefaultFeatureConfig> STONEPILLAR = new StonePillars(DefaultFeatureConfig.CODEC);

    //IvisFields
    public static final Feature<DefaultFeatureConfig> OBBYSPIKES = new ObsidianSpike(DefaultFeatureConfig.CODEC);

    //SythianTorrids
    public static final Feature<DefaultFeatureConfig> SYTHIAN_ROOTS = new SythianRoots(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> SYTHIAN_SPROUT = new SythianSprout(DefaultFeatureConfig.CODEC);
    public static final Feature<ProbabilityConfig> SYTHIAN_STALK = new SythianStalk(ProbabilityConfig.CODEC);

    //Misc
    public static final Feature<SingleStateFeatureConfig> FROST_LAKE = new FrostMagmaLakeFeature(SingleStateFeatureConfig.CODEC);
//    public static final Feature<DefaultFeatureConfig> BYGFOSSIL = new BYGFossilFeature(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> LAKE_WIDE_SHALLOW = new LakeWideShallow(DefaultFeatureConfig.CODEC);

    //Structures
//    public static final Structure<VillageConfig> BYGVILLAGE = new BYGVillageStructure(VillageConfig::deserialize);
//    public static final Structure<DefaultFeatureConfig> SKYRISFORTRESS = new SkyrisFortressStructure(DefaultFeatureConfig.CODEC);

    //Bayou
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> BAYOU_TREE1 = new BayouTree1(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> BAYOU_TREE2 = new BayouTree2(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> BAYOU_TREE3 = new BayouTree3(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> HEIGHTCHECKEDCACTUS = new CanyonCactus(DefaultFeatureConfig.CODEC);

//    public static final Feature<DefaultFeatureConfig> DOVERQUARRY = new DoverQuarry1(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> BLACKICESNOW = new BlackIceAndSnowFeature(DefaultFeatureConfig.CODEC);

    //Vines
    public static final Feature<DefaultFeatureConfig> VINES = new VinePlacer(DefaultFeatureConfig.CODEC);

    //Aspen
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ASPEN_TREE1 = new AspenTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ASPEN_TREE2 = new AspenTree2(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ASPEN_TREE3 = new AspenTree3(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ASPEN_SHRUB1 = new AspenShrub(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ASPEN_SHRUB2 = new AspenShrub2(DefaultFeatureConfig.CODEC);

    //Zelkova
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ZELKOVA_TREE1 = new ZelkovaTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ZELKOVA_TREE2 = new ZelkovaTree2(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ZELKOVA_TREE3 = new ZelkovaTree3(DefaultFeatureConfig.CODEC);

    //PaloVerde
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> PALO_VERDE_TREE1 = new PaloVerdeTree(DefaultFeatureConfig.CODEC,  0);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> PALO_VERDE_TREE2 = new PaloVerdeTree2(DefaultFeatureConfig.CODEC,  0);

    //JoshuaTree
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> JOSHUA_TREE1 = new JoshuaTree1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> JOSHUA_TREE2 = new JoshuaTree2(DefaultFeatureConfig.CODEC);

    public static final Feature<DefaultFeatureConfig> BLACKPUFF = new HugeBlackPuff(DefaultFeatureConfig.CODEC);

}


