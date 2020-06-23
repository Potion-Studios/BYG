package voronoiaoc.byg.core.byglists;

import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.carver.Carver;
import net.minecraft.world.gen.feature.*;
import voronoiaoc.byg.common.world.carver.VolcanicCarver;
import voronoiaoc.byg.common.world.feature.biomefeatures.FrostMagmaLakeFeature;
import voronoiaoc.byg.common.world.feature.biomefeatures.LakeWideShallow;
import voronoiaoc.byg.common.world.feature.features.end.obsidianspires.ObsidianSpike;
import voronoiaoc.byg.common.world.feature.features.nether.glowstonegardens.*;
import voronoiaoc.byg.common.world.feature.features.nether.sythiantorrids.SythianRoots;
import voronoiaoc.byg.common.world.feature.features.nether.sythiantorrids.SythianSprout;
import voronoiaoc.byg.common.world.feature.features.nether.sythiantorrids.SythianStalk;
import voronoiaoc.byg.common.world.feature.features.nether.warpeddesert.WarpedBush;
import voronoiaoc.byg.common.world.feature.features.nether.warpeddesert.WarpedCoral;
import voronoiaoc.byg.common.world.feature.features.nether.warpeddesert.WarpedCoralFan;
import voronoiaoc.byg.common.world.feature.features.nether.warpeddesert.WarpedCoralFeature;
import voronoiaoc.byg.common.world.feature.features.overworld.BlackIceAndSnowFeature;
import voronoiaoc.byg.common.world.feature.features.overworld.CanyonCactus;
import voronoiaoc.byg.common.world.feature.features.overworld.LavaLakeWideShallow;
import voronoiaoc.byg.common.world.feature.features.overworld.VinePlacer;
import voronoiaoc.byg.common.world.feature.features.overworld.deadsea.DeadSeaSpikes;
import voronoiaoc.byg.common.world.feature.features.overworld.deadsea.TallDeadSeaSpikes;
import voronoiaoc.byg.common.world.feature.features.overworld.giantflowers.AngelicaGiant;
import voronoiaoc.byg.common.world.feature.features.overworld.giantflowers.DandelionGiant;
import voronoiaoc.byg.common.world.feature.features.overworld.giantflowers.IrisGiant;
import voronoiaoc.byg.common.world.feature.features.overworld.giantflowers.RoseGiant;
import voronoiaoc.byg.common.world.feature.features.overworld.mushrooms.*;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.acacia.AcaciaTree1;
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
import voronoiaoc.byg.common.world.feature.features.overworld.trees.cherry.PinkCherry1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.cherry.PinkCherry2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.cherry.WhiteCherry1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.cherry.WhiteCherry2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.coniferous.*;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.cypress.CypressTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.cypress.CypressTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.cypress.CypressTree3;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.deadhazel.DeadHazel1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.deadhazel.DeadHazel2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.deadhazel.DeadHazel3;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.deadhazel.DeadHazel4;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.deciduous.*;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.ebony.EbonyBush1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.ebony.EbonyTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.ebony.EbonyTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.enchanted.blue.BlueEnchantedGroveTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.enchanted.blue.BlueEnchantedTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.enchanted.blue.BlueEnchantedTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.enchanted.blue.BlueEnchantedTree3;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.enchanted.green.GreenEnchantedGroveTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.enchanted.green.GreenEnchantedTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.enchanted.green.GreenEnchantedTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.enchanted.green.GreenEnchantedTree3;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.holly.HollyTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.holly.HollyTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.holly.HollyTree3;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.holly.HollyTree4;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.jacaranda.IndigoJacarandaTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.jacaranda.IndigoJacarandaTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.jacaranda.JacarandaTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.jacaranda.JacarandaTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.joshua.JoshuaTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.joshua.JoshuaTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.mangrove.*;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.maple.*;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.meadow.*;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.oak.BrownOakTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.oak.OrangeOakTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.oak.RedOakTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.orchard.OrchardTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.orchard.OrchardTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.orchard.OrchardTree3;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.palm.PalmTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.palo_verde.PaloVerdeTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.palo_verde.PaloVerdeTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.pine.*;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.prairie.PrairieShrub;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.prairie.PrairieShrub2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.pumpkins.PumpkinPatch1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.pumpkins.PumpkinPatch2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.pumpkins.PumpkinPatch3;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.rainbow_eucalyptus.LargeRainbowEucalyptus;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.rainbow_eucalyptus.RainbowEucalyptusTree;
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
import voronoiaoc.byg.common.world.feature.features.overworld.trees.tropical.ShortTropicalRainForestTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.tropical.TropicalRainForestTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.tropical.TropicalShrub;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.willow.WillowTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.willow.WillowTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.willow.WillowTree3;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.willow.WillowTree4;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.willow.dead.WillowDeadTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.willow.mutated.WillowTreeM1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.willow.mutated.WillowTreeM2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.woodlands.WoodlandsTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.zelkova.ZelkovaTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.zelkova.ZelkovaTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.zelkova.ZelkovaTree3;
import voronoiaoc.byg.common.world.structure.village.BYGVillageStructureFeature;


public class BYGFeatureList {

    public static final Feature<DefaultFeatureConfig> DUMMY_TREE = new SmallPineTree(DefaultFeatureConfig.CODEC);

    /********************************************************************Features*************************************************************************/
    //DeadSea
    public static final Feature<DefaultFeatureConfig> DEADSEASPIKES = new DeadSeaSpikes(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> TALLDEADSEASPIKES = new TallDeadSeaSpikes(DefaultFeatureConfig.CODEC);

    public static final Feature<DefaultFeatureConfig> OBBYSPIKES = new ObsidianSpike(DefaultFeatureConfig.CODEC);

    public static final Feature<DefaultFeatureConfig> CACTUS = new CanyonCactus(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> BLACKICESNOW = new BlackIceAndSnowFeature(DefaultFeatureConfig.CODEC);

    //Lakes
    public static final Feature<SingleStateFeatureConfig> LAKE_FROST = new FrostMagmaLakeFeature(SingleStateFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> LAKE_WIDE_SHALLOW = new LakeWideShallow(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> LAKE_LAVA_WIDE_SHALLOW = new LavaLakeWideShallow(DefaultFeatureConfig.CODEC);
    //Vines
    public static final Feature<DefaultFeatureConfig> VINES = new VinePlacer(DefaultFeatureConfig.CODEC);

    //Pumpkins
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> PUMPKIN_PATCH1 = new PumpkinPatch1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> PUMPKIN_PATCH2 = new PumpkinPatch2(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> PUMPKIN_PATCH3 = new PumpkinPatch3(DefaultFeatureConfig.CODEC);

    /********************************************************************Carvers**************************************************************************/
    public static final Carver<ProbabilityConfig> VOLCANIC_CARVER = new VolcanicCarver(ProbabilityConfig.CODEC, 256);


    /*********************************************************************Large Flower Features***********************************************************/
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> GIANT_ANGELICA_FLOWER = new AngelicaGiant(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> GIANT_DANDELION_FLOWER = new DandelionGiant(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> GIANT_IRIS_FLOWER = new IrisGiant(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> GIANT_ROSE_FLOWER = new RoseGiant(DefaultFeatureConfig.CODEC);


    /*********************************************************************Large Mushroom Features*********************************************************/
    public static final Feature<DefaultFeatureConfig> GREEN_MUSHROOM_HUGE = new GreenMushroomHuge(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> WOOD_BLEWIT_HUGE = new WoodBlewitHuge(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> WEEPING_MILKCAP_HUGE = new WeepingMilkcapHuge(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> BLACK_PUFF_HUGE = new BlackPuffHuge(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> BLUE_GLOWSHROOM_HUGE = new BlueGlowshroomHuge(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> PURPLE_GLOWSHROOM_HUGE = new PurpleGlowshroomHuge(DefaultFeatureConfig.CODEC);


    /********************************************************************Nether Features********************************************************************/

    public static final Feature<DefaultFeatureConfig> BLACK_PUFF = new BlackPuffMushroom(DefaultFeatureConfig.CODEC);

    public static final Feature<DefaultFeatureConfig> GREEN_MUSHROOM = new GreenMushroom(DefaultFeatureConfig.CODEC);

    public static final Feature<DefaultFeatureConfig> NETHER_BRISTLE = new NetherBristle(DefaultFeatureConfig.CODEC);

    //Sythian
    public static final Feature<DefaultFeatureConfig> SYTHIAN_SPROUT = new SythianSprout(DefaultFeatureConfig.CODEC);
    public static final Feature<ProbabilityConfig> SYTHIAN_STALK = new SythianStalk(ProbabilityConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> SYTHIAN_ROOTS = new SythianRoots(DefaultFeatureConfig.CODEC);

    //Warped
    public static final Feature<DefaultFeatureConfig> WARPED_BUSH = new WarpedBush(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> WARPED_CORAL = new WarpedCoral(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> WARPED_CORALPLANT = new WarpedCoralFeature(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> WARPED_CORALFAN = new WarpedCoralFan(DefaultFeatureConfig.CODEC);


    public static final Feature<DefaultFeatureConfig> WOOD_BLEWIT = new WoodBlewitMushroom(DefaultFeatureConfig.CODEC);

    public static final Feature<DefaultFeatureConfig> WEED_GRASS = new WeedGrass(DefaultFeatureConfig.CODEC);

    public static final Feature<DefaultFeatureConfig> WEEPING_MILKCAP = new WeepingMilkCapMushroom(DefaultFeatureConfig.CODEC);

    //Weeping Roots
    public static final Feature<DefaultFeatureConfig> WEEPING_ROOTS = new WeepingRoots(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> WEEPING_ROOTS_PLANT = new WeepingRootsPlant(DefaultFeatureConfig.CODEC);


    /********************************************************************Structures***********************************************************************/
    public static final StructureFeature<StructurePoolFeatureConfig> BYGVILLAGE = new BYGVillageStructureFeature(StructurePoolFeatureConfig.CODEC);
//    public static final StructureFeature<DefaultFeatureConfig> SKYRISFORTRESS = new SkyrisFortressStructure(DefaultFeatureConfig.CODEC);
//    public static final Feature<DefaultFeatureConfig> DOVERQUARRY = new DoverQuarry1(DefaultFeatureConfig.CODEC);


    /********************************************************************Tree Features********************************************************************/
    //Acacia
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ACACIA_TREE1 = new AcaciaTree1(DefaultFeatureConfig.CODEC);
//    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ACACIA_TREE2 = new AcaciaTree2(DefaultFeatureConfig.CODEC);

    //Aspen
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ASPEN_SHRUB1 = new AspenShrub(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ASPEN_SHRUB2 = new AspenShrub2(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ASPEN_TREE1 = new AspenTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ASPEN_TREE2 = new AspenTree2(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ASPEN_TREE3 = new AspenTree3(DefaultFeatureConfig.CODEC);
//    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ASPEN_TREE4 = new AspenTree4(DefaultFeatureConfig.CODEC);

    //Baobab Tree
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> BAOBAB_TREE1 = new BaobabTree1(DefaultFeatureConfig.CODEC);

    //Birch
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> BIRCH_BROWN_TREE1 = new BrownBirchTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> BIRCH_ORANGE_TREE1 = new OrangeBirchTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> BIRCH_RED_TREE1 = new RedBirchTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> BIRCH_YELLOW_TREE1 = new YellowBirchTree(DefaultFeatureConfig.CODEC);

    //Bluff Trees
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> BLUFF_TREE1 = new BluffTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> BLUFF_TREE2 = new BluffTree2(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> BLUFF_TREE3 = new BluffTree3(DefaultFeatureConfig.CODEC);

    //Boreal Trees
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> BOREAL_TREE = new BorealForestTree1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> BOREAL_TREE2 = new BorealForestTree2(DefaultFeatureConfig.CODEC);

    //Cherry
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> CHERRY_PINK_TREE1 = new PinkCherry1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> CHERRY_PINK_TREE2 = new PinkCherry2(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> CHERRY_WHITE_TREE1 = new WhiteCherry1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> CHERRY_WHITE_TREE2 = new WhiteCherry2(DefaultFeatureConfig.CODEC);

    //Coniferous
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> CONIFER_TREE1 = new ConiferTree1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> CONIFER_TREE2 = new ConiferTree2(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> CONIFER_TREE3 = new ConiferTree3(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> CONIFER_TREE4 = new ConiferTree4(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> CONIFER_TREE5 = new ConiferTree5(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> CONIFER_TREE6 = new ConiferTree6(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> CONIFER_TREE7 = new ConiferTree7(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> CONIFER_TREE8 = new ConiferTree8(DefaultFeatureConfig.CODEC);

    //Cypress
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> CYPRESS_TREE1 = new CypressTree1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> CYPRESS_TREE2 = new CypressTree2(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> CYPRESS_TREE3 = new CypressTree3(DefaultFeatureConfig.CODEC);

    //Dead
//    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> DEAD_TREE = new DeadTree(DefaultFeatureConfig.CODEC);

    //Dead Hazel
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> DEAD_HAZEL_TREE1 = new DeadHazel1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> DEAD_HAZEL_TREE2 = new DeadHazel2(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> DEAD_HAZEL_TREE3 = new DeadHazel3(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> DEAD_HAZEL_TREE4 = new DeadHazel4(DefaultFeatureConfig.CODEC);

    //Deciduous
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> DECIDUOUS_TREE = new DeciduousTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> DECIDUOUS_BROWN_TREE = new BrownDeciduousTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> DECIDUOUS_ORANGE_TREE = new OrangeDeciduousTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> DECIDUOUS_YELLOW_TREE = new YellowDeciduousTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> DECIDUOUS_RED_TREE = new RedDeciduousTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> DECIDUOUS_SEASONAL_SHRUBS = new SeasonalDeciduousShrubs(DefaultFeatureConfig.CODEC);

    //Ebony
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> EBONY_BUSH1 = new EbonyBush1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> EBONY_TREE1 = new EbonyTree1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> EBONY_TREE2 = new EbonyTree2(DefaultFeatureConfig.CODEC);

    //Enchanted Trees
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ENCHANTED_BLUE_TREE1 = new BlueEnchantedTree1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ENCHANTED_BLUE_TREE2 = new BlueEnchantedTree2(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ENCHANTED_BLUE_TREE3 = new BlueEnchantedTree3(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ENCHANTED_GREEN_TREE1 = new GreenEnchantedTree1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ENCHANTED_GREEN_TREE2 = new GreenEnchantedTree2(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ENCHANTED_GREEN_TREE3 = new GreenEnchantedTree3(DefaultFeatureConfig.CODEC);

    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ENCHANTED_GREEN_GROVE_TREE1 = new GreenEnchantedGroveTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ENCHANTED_BLUE_GROVE_TREE1 = new BlueEnchantedGroveTree(DefaultFeatureConfig.CODEC);

    //Holly
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> HOLLY_TREE1 = new HollyTree1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> HOLLY_TREE2 = new HollyTree2(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> HOLLY_TREE3 = new HollyTree3(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> HOLLY_TREE4 = new HollyTree4(DefaultFeatureConfig.CODEC);

    //Jacaranda
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> JACARANDA_TREE = new JacarandaTree1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> JACARANDA_TREE2 = new JacarandaTree2(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> INDIGOJACARANDA_TREE = new IndigoJacarandaTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> INDIGOJACARANDA_TREE2 = new IndigoJacarandaTree2(DefaultFeatureConfig.CODEC);

    //JoshuaTree
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> JOSHUA_TREE1 = new JoshuaTree1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> JOSHUA_TREE2 = new JoshuaTree2(DefaultFeatureConfig.CODEC);

    //Mangrove
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> MANGROVE_TREE1 = new MangroveTree1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> MANGROVE_TREE2 = new MangroveTree2(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> MANGROVE_TREE3 = new MangroveTree3(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> MANGROVE_TREE4 = new MangroveTree4(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> MANGROVE_TREE5 = new MangroveTree5(DefaultFeatureConfig.CODEC);

    //Maple
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> MAPLE_RED_TREE = new RedMapleTree1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> MAPLE_RED_TREE2 = new RedMapleTree2(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> MAPLE_SILVER_TREE1 = new SilverMapleTree1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> MAPLE_SILVER_TREE2 = new SilverMapleTree2(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> MAPLE_TREE = new MapleTree(DefaultFeatureConfig.CODEC);

    //Meadow
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> MEADOW_TREE1 = new MeadowTree1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> MEADOW_TREE2 = new MeadowTree2(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> MEADOW_TREE3 = new MeadowTree3(DefaultFeatureConfig.CODEC);

    //Orchard
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ORCHARD_TREE1 = new OrchardTree1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ORCHARD_TREE2 = new OrchardTree2(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ORCHARD_TREE3 = new OrchardTree3(DefaultFeatureConfig.CODEC);

    //Palm
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> PALM_TREE1 = new PalmTree1(DefaultFeatureConfig.CODEC);

    //Pine
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> PINE_LARGE_TREE1 = new LargePineTree1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> PINE_LARGE_TREE2 = new LargePineTree2(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> PINE_TREE1 = new PineTree1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> PINE_TREE2 = new PineTree2(DefaultFeatureConfig.CODEC);

    //Palo Verde
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> PALO_VERDE_TREE1 = new PaloVerdeTree(DefaultFeatureConfig.CODEC, 0);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> PALO_VERDE_TREE2 = new PaloVerdeTree2(DefaultFeatureConfig.CODEC, 0);

    //Rainbow Eucalyptus
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> RAINBOW_TREE1 = new RainbowEucalyptusTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> RAINBOW_LARGE_TREE1 = new LargeRainbowEucalyptus(DefaultFeatureConfig.CODEC);

    //RedWood
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> REDWOOD_TREE1 = new EbonyTree1(DefaultFeatureConfig.CODEC);

    //Seasonal Oaks
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> OAK_BROWN_TREE1 = new BrownOakTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> OAK_ORANGE_TREE1 = new OrangeOakTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> OAK_RED_TREE1 = new RedOakTree(DefaultFeatureConfig.CODEC);

    //Shrubs
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> SHRUB = new BYGShrub(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> SHRUB_MEADOW1 = new MeadowShrub(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> SHRUB_MEADOW2 = new MeadowShrub2(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> SHRUB_PRAIRIE1 = new PrairieShrub(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> SHRUB_PRAIRIE2 = new PrairieShrub2(DefaultFeatureConfig.CODEC);

    //Skyris
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> SKYRIS_TREE1 = new SkyrisTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> SKYRIS_TREE2 = new SkyrisTree2(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> SKYRIS_TREE3 = new SkyrisTree3(DefaultFeatureConfig.CODEC);

    //Spruce
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

    //Tropical
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> TROPICAL_TREE1 = new TropicalRainForestTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> TROPICAL_SHORT_TREE1 = new ShortTropicalRainForestTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> TROPICAL_SHRUB1 = new TropicalShrub(DefaultFeatureConfig.CODEC);

    //Woodlands
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> WOODLANDS_TREE1 = new WoodlandsTree1(DefaultFeatureConfig.CODEC);

    //Willow
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> WILLOW_DEAD_TREE1 = new WillowDeadTree1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> WILLOW_M_TREE1 = new WillowTreeM1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> WILLOW_M_TREE2 = new WillowTreeM2(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> WILLOW_TREE1 = new WillowTree1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> WILLOW_TREE2 = new WillowTree2(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> WILLOW_TREE3 = new WillowTree3(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> WILLOW_TREE4 = new WillowTree4(DefaultFeatureConfig.CODEC);

    //Zelkova
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ZELKOVA_TREE1 = new ZelkovaTree(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ZELKOVA_TREE2 = new ZelkovaTree2(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ZELKOVA_TREE3 = new ZelkovaTree3(DefaultFeatureConfig.CODEC);
}


