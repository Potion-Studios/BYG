package voronoiaoc.byg.core.byglists;

import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import voronoiaoc.byg.common.world.carver.VolcanicCarver;
import voronoiaoc.byg.common.world.feature.features.end.obsidianspires.ObsidianSpike;
import voronoiaoc.byg.common.world.feature.features.nether.glowstonegardens.*;
import voronoiaoc.byg.common.world.feature.features.nether.sythiantorrids.SythianRoots;
import voronoiaoc.byg.common.world.feature.features.nether.sythiantorrids.SythianSprout;
import voronoiaoc.byg.common.world.feature.features.nether.sythiantorrids.SythianStalk;
import voronoiaoc.byg.common.world.feature.features.nether.warpeddesert.WarpedBush;
import voronoiaoc.byg.common.world.feature.features.nether.warpeddesert.WarpedCoral;
import voronoiaoc.byg.common.world.feature.features.nether.warpeddesert.WarpedCoralFan;
import voronoiaoc.byg.common.world.feature.features.nether.warpeddesert.WarpedCoralFeature;
import voronoiaoc.byg.common.world.feature.features.overworld.*;
import voronoiaoc.byg.common.world.feature.features.overworld.deadsea.DeadSeaSpikes;
import voronoiaoc.byg.common.world.feature.features.overworld.deadsea.TallDeadSeaSpikes;
import voronoiaoc.byg.common.world.feature.features.overworld.mushrooms.HugeBlackPuff;
import voronoiaoc.byg.common.world.feature.features.overworld.structure.DoverQuarry1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.acacia.AcaciaTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.acacia.AcaciaTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.aspen.*;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.baobab.BaobabTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.birch.BrownBirchTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.birch.OrangeBirchTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.birch.RedBirchTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.birch.YellowBirchTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.bluff.BluffTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.bluff.BluffTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.bluff.BluffTree3;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.boreal.BorealForestTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.boreal.BorealForestTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.coniferous.*;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.cypress.CypressTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.cypress.CypressTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.cypress.CypressTree3;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.dead.DeadTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.deciduous.*;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.enchanted.blue.BlueEnchantedGroveTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.enchanted.green.GreenEnchantedGroveTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.jacaranda.IndigoJacarandaTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.jacaranda.IndigoJacarandaTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.jacaranda.JacarandaTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.jacaranda.JacarandaTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.joshua.JoshuaTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.joshua.JoshuaTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.maple.MapleTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.maple.RedMapleTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.maple.SilverMapleTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.meadow.MeadowShrub;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.meadow.MeadowShrub2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.mushrooms.*;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.oak.BrownOakTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.oak.OrangeOakTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.oak.RedOakTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.palm.PalmTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.palo_verde.PaloVerdeTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.palo_verde.PaloVerdeTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.pine.*;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.prairie.PrairieShrub;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.prairie.PrairieShrub2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.pumpkins.PumpkinPatch1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.pumpkins.PumpkinPatch2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.pumpkins.PumpkinPatch3;
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
import voronoiaoc.byg.common.world.feature.features.overworld.trees.willow.BayouTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.willow.BayouTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.willow.BayouTree3;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.zelkova.ZelkovaTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.zelkova.ZelkovaTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.zelkova.ZelkovaTree3;
import voronoiaoc.byg.common.world.structure.fortress.skyrishighlands.SkyrisFortressStructure;
import voronoiaoc.byg.common.world.structure.misc.reddesert.BYGFossilFeature;
import voronoiaoc.byg.common.world.structure.village.BYGVillageStructure;

public class BYGFeatureList {
    //Seasonal Oaks
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BROWNOAK_TREE = new BrownOakTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ORANGEOAK_TREE = new OrangeOakTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> REDOAK_TREE = new RedOakTree(NoFeatureConfig::deserialize, false, 0);

    //Seasonal Birch
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BROWNBIRCH_TREE = new BrownBirchTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ORANGEBIRCH_TREE = new OrangeBirchTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> REDBIRCH_TREE = new RedBirchTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> YELLOWBIRCH_TREE = new YellowBirchTree(NoFeatureConfig::deserialize, false, 0);

    //Cypress
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CYPRESS_TREE1 = new CypressTree1(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CYPRESS_TREE2 = new CypressTree2(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CYPRESS_TREE3 = new CypressTree3(NoFeatureConfig::deserialize);

    //Seasonal Deciduous and Deciduous
    public static final BYGAbstractTreeFeature<NoFeatureConfig> DECIDUOUS_TREE = new DeciduousTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BROWNDECIDUOUS_TREE = new BrownDeciduousTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ORANGEDECIDUOUS_TREE = new OrangeDeciduousTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> YELLOWDECIDUOUS_TREE = new YellowDeciduousTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> REDDECIDUOUS_TREE = new RedDeciduousTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SEASONAL_SHRUBS = new ColorfulDeciduousShrubs(NoFeatureConfig::deserialize, false, 0);


    //Seasonal TaigaTrees
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BLUEGIANTSPUCE_TREE = new GiantBlueSpruceTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> TALLBLUESPRUCE_TREE = new TallBlueSpruceTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BLUESPRUCE_TREE = new BlueSpruceTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SMALLBLUESPRUCE_TREE = new SmallBlueTaigaTree(NoFeatureConfig::deserialize, false, 0);

    public static final BYGAbstractTreeFeature<NoFeatureConfig> GIANTORANGESPRUCE_TREE = new GiantOrangeSpruceTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> TALLORANGESPRUCE_TREE = new TallOrangeSpruceTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ORANGESPRUCE_TREE = new OrangeSpruceTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SMALLORANGESPRUCE_TREE = new SmallOrangeSpruceTree(NoFeatureConfig::deserialize, false, 0);

    public static final BYGAbstractTreeFeature<NoFeatureConfig> GIANTREDSPRUCE_TREE = new GiantRedSpruceTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> TALLREDSPRUCE_TREE = new TallRedSpruceTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> REDSPRUCE_TREE = new RedSpruceTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SMALLREDSPRUCE_TREE = new SmallRedSpruceTree(NoFeatureConfig::deserialize, false, 0);

    public static final BYGAbstractTreeFeature<NoFeatureConfig> GIANTYELLOWSPRUCE_TREE = new GiantYellowSpruceTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> TALLYELLOWSPRUCE_TREE = new TallYellowSpruceTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> YELLOWSPRUCE_TREE = new YellowSpruceTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SMALLYELLOWSPRUCE_TREE = new SmallYellowTaigaTree(NoFeatureConfig::deserialize, false, 0);

    //Boreal Trees
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BOREAL_TREE = new BorealForestTree1(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BOREAL_TREE2 = new BorealForestTree2(NoFeatureConfig::deserialize, false, 0);

    //Enchanted Grove Trees
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BLUE_ENCHANTED_GROVE_TREE = new BlueEnchantedGroveTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> GREEN_ENCHANTED_GROVE_TREE = new GreenEnchantedGroveTree(NoFeatureConfig::deserialize, false, 0);


    //Tropical Trees
    public static final BYGAbstractTreeFeature<NoFeatureConfig> TROPICALRAINFOREST_TREE = new TropicalRainForestTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SHORTTROPICALRAINFOREST_TREE = new ShortTropicalRainForestTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> TROPJUNGLE_SHRUB = new BYGTropShrub(NoFeatureConfig::deserialize, false, 0);

    //Shrub
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SHRUB = new BYGShrub(NoFeatureConfig::deserialize, false, 0);

    //Coniferous Trees
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SMALLCONIFEROUS_TREE = new SmallFirTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> TALLCONIFEROUS_TREE = new TallFirTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> WIDECONIFEROUS_TREE = new WideFirTree(NoFeatureConfig::deserialize, false, 0);

    public static final BYGAbstractTreeFeature<NoFeatureConfig> DEAD_TREE = new DeadTree(NoFeatureConfig::deserialize, false, 0);

    //Jacaranda Tree
    public static final BYGAbstractTreeFeature<NoFeatureConfig> JACARANDA_TREE = new JacarandaTree1(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> JACARANDA_TREE2 = new JacarandaTree2(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> INDIGOJACARANDA_TREE = new IndigoJacarandaTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> INDIGOJACARANDA_TREE2 = new IndigoJacarandaTree2(NoFeatureConfig::deserialize, false, 0);

    //Skyris Tree
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SKYRIS_TREE1 = new SkyrisTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SKYRIS_TREE2 = new SkyrisTree2(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SKYRIS_TREE3 = new SkyrisTree3(NoFeatureConfig::deserialize, false, 0);

    //Bluff Trees
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BLUFF_TREE1 = new BluffTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BLUFF_TREE2 = new BluffTree2(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BLUFF_TREE3 = new BluffTree3(NoFeatureConfig::deserialize, false, 0);

    //Rainbow Tree
    public static final BYGAbstractTreeFeature<NoFeatureConfig> RAINBOW_TREE1 = new RainbowEucalyptusTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> RAINBOW_TREE2 = new RainbowEucalyptusTree(NoFeatureConfig::deserialize, false, 0);

    //Baobab Tree
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BAOBAB_TREE1 = new BaobabTree1(NoFeatureConfig::deserialize, false, 0);

    //MeadowShrubs
    public static final BYGAbstractTreeFeature<NoFeatureConfig> MEADOW_SHRUB1 = new MeadowShrub(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> MEADOW_SHRUB2 = new MeadowShrub2(NoFeatureConfig::deserialize, false, 0);


    //MeadowShrubs
    public static final BYGAbstractTreeFeature<NoFeatureConfig> PRAIRIE_SHRUB1 = new PrairieShrub(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> PRAIRIE_SHRUB2 = new PrairieShrub2(NoFeatureConfig::deserialize, false, 0);

    //RedWood
    public static final BYGAbstractTreeFeature<NoFeatureConfig> REDWOOD_TREE1 = new RedwoodTree1(NoFeatureConfig::deserialize, false, 0);

    //WarpedDesert
    public static final Feature<NoFeatureConfig> WARPED_BUSH = new WarpedBush(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> WARPED_CORAL = new WarpedCoral(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> WARPED_CORALPLANT = new WarpedCoralFeature(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> WARPED_CORALFAN = new WarpedCoralFan(NoFeatureConfig::deserialize);

    //DeadSea
    public static final Feature<NoFeatureConfig> DEADSEASPIKES = new DeadSeaSpikes(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> TALLDEADSEASPIKES = new TallDeadSeaSpikes(NoFeatureConfig::deserialize);

    //Stone Forest
//    public static final Feature<NoFeatureConfig> STONEPILLAR = new StonePillars(NoFeatureConfig::deserialize);

    //IvisFields
    public static final Feature<NoFeatureConfig> OBBYSPIKES = new ObsidianSpike(NoFeatureConfig::deserialize);

    //SythianTorrids
    public static final Feature<NoFeatureConfig> SYTHIAN_ROOTS = new SythianRoots(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> SYTHIAN_SPROUT = new SythianSprout(NoFeatureConfig::deserialize);
    public static final Feature<ProbabilityConfig> SYTHIAN_STALK = new SythianStalk(ProbabilityConfig::deserialize);

    //GlowstoneGardens
    public static final Feature<NoFeatureConfig> WEED_GRASS = new WeedGrass(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> WOOD_BLEWIT = new WoodBlewitMushroom(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> BLACK_PUFF = new BlackPuffMushroom(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> GREEN_MUSHROOM = new GreenMushroom(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> WEEPING_MILKCAP = new WeepingMilkCapMushroom(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> NETHER_BRISTLE = new NetherBristle(NoFeatureConfig::deserialize);

    public static final Feature<NoFeatureConfig> WEEPING_ROOTS = new WeepingRoots(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> WEEPING_ROOTS_PLANT = new WeepingRootsPlant(NoFeatureConfig::deserialize);

    //Misc
    public static final Feature<BlockStateFeatureConfig> FROST_LAKE = new FrostMagmaLakeFeature(BlockStateFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> BYGFOSSIL = new BYGFossilFeature(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> LAKE_WIDE_SHALLOW = new LakeWideShallow(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> LAVA_LAKE_WIDE_SHALLOW = new LavaLakeWideShallow(NoFeatureConfig::deserialize);

    //Structures
    public static final Structure<VillageConfig> BYGVILLAGE = new BYGVillageStructure(VillageConfig::deserialize);
    public static final Structure<NoFeatureConfig> SKYRISFORTRESS = new SkyrisFortressStructure(NoFeatureConfig::deserialize);

    //Bayou
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BAYOU_TREE1 = new BayouTree1(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> BAYOU_TREE2 = new BayouTree2(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> BAYOU_TREE3 = new BayouTree3(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> HEIGHTCHECKEDCACTUS = new CanyonCactus(NoFeatureConfig::deserialize);

    public static final Feature<NoFeatureConfig> DOVERQUARRY = new DoverQuarry1(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> BLACKICESNOW = new BlackIceAndSnowFeature(NoFeatureConfig::deserialize);

    //Vines
    public static final Feature<NoFeatureConfig> VINES = new VinePlacer(NoFeatureConfig::deserialize);

    //Aspen
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ASPEN_TREE1 = new AspenTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ASPEN_TREE2 = new AspenTree2(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ASPEN_TREE3 = new AspenTree3(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ASPEN_SHRUB1 = new AspenShrub(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ASPEN_SHRUB2 = new AspenShrub2(NoFeatureConfig::deserialize, false, 0);

    //Zelkova
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ZELKOVA_TREE1 = new ZelkovaTree(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ZELKOVA_TREE2 = new ZelkovaTree2(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ZELKOVA_TREE3 = new ZelkovaTree3(NoFeatureConfig::deserialize, 0);

    //PaloVerde
    public static final BYGAbstractTreeFeature<NoFeatureConfig> PALO_VERDE_TREE1 = new PaloVerdeTree(NoFeatureConfig::deserialize,  0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> PALO_VERDE_TREE2 = new PaloVerdeTree2(NoFeatureConfig::deserialize,  0);

    //JoshuaTree
    public static final BYGAbstractTreeFeature<NoFeatureConfig> JOSHUA_TREE1 = new JoshuaTree1(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> JOSHUA_TREE2 = new JoshuaTree2(NoFeatureConfig::deserialize, false, 0);

    public static final Feature<NoFeatureConfig> BLACKPUFF = new HugeBlackPuff(NoFeatureConfig::deserialize);

    //PalmTree
    public static final BYGAbstractTreeFeature<NoFeatureConfig> PALM_TREE1 = new PalmTree1(NoFeatureConfig::deserialize, false, 0);

    //PumpkinPatches
    public static final BYGAbstractTreeFeature<NoFeatureConfig> PUMPKIN_PATCH1 = new PumpkinPatch1(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> PUMPKIN_PATCH2 = new PumpkinPatch2(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> PUMPKIN_PATCH3 = new PumpkinPatch3(NoFeatureConfig::deserialize, false, 0);

    //PineTree
    public static final BYGAbstractTreeFeature<NoFeatureConfig> PINE_TREE1 = new PineTree1(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> PINE_TREE2 = new PineTree2(NoFeatureConfig::deserialize, false, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> PINE_TREE_LARGE1 = new PineTreeLarge1(NoFeatureConfig::deserialize, false, 0);

    //Carver
    public static final WorldCarver<ProbabilityConfig> VOLCANIC_CARVER = new VolcanicCarver(ProbabilityConfig::deserialize, 256);

    public static final Feature<NoFeatureConfig> LARGE_PINE_TREE1 = new LargePineTree1(NoFeatureConfig::deserialize);

    public static final Feature<NoFeatureConfig> DUMMY_TREE = new SmallPineTree(NoFeatureConfig::deserialize);

    //Maple
    public static final Feature<NoFeatureConfig> MAPLE_TREE = new MapleTree(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> RED_MAPLE_TREE = new RedMapleTree(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> SILVER_MAPLE_TREE = new SilverMapleTree(NoFeatureConfig::deserialize);

    //Mushrooms
    public static final Feature<NoFeatureConfig> GREEN_MUSHROOM_HUGE = new GreenMushroomHuge(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> WOOD_BLEWIT_HUGE = new WoodBlewitHuge(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> WEEPING_MILKCAP_HUGE = new WeepingMilkcapHuge(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> BLACK_PUFF_HUGE = new BlackPuffHuge(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> BLUE_GLOWSHROOM_HUGE = new BlueGlowshroomHuge(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> PURPLE_GLOWSHROOM_HUGE = new PurpleGlowshroomHuge(NoFeatureConfig::deserialize);

    public static final BYGAbstractTreeFeature<NoFeatureConfig> ACACIA_TREE1 = new AcaciaTree1(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ACACIA_TREE2 = new AcaciaTree2(NoFeatureConfig::deserialize);

    public static final BYGAbstractTreeFeature<NoFeatureConfig> CONIFER_TREE1 = new ConiferTree1(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CONIFER_TREE2 = new ConiferTree2(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CONIFER_TREE3 = new ConiferTree3(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CONIFER_TREE4 = new ConiferTree4(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CONIFER_TREE5 = new ConiferTree5(NoFeatureConfig::deserialize);


}


