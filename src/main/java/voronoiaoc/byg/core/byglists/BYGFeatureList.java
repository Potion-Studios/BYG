package voronoiaoc.byg.core.byglists;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.carver.Carver;
import net.minecraft.world.gen.feature.*;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.common.world.carver.VolcanicCarver;
import voronoiaoc.byg.common.world.feature.biomefeatures.FrostMagmaLakeFeature;
import voronoiaoc.byg.common.world.feature.features.end.obsidianspires.ObsidianSpike;
import voronoiaoc.byg.common.world.feature.features.nether.emburbog.*;
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
import voronoiaoc.byg.common.world.feature.features.overworld.giantflowers.AngelicaGiant;
import voronoiaoc.byg.common.world.feature.features.overworld.giantflowers.DandelionGiant;
import voronoiaoc.byg.common.world.feature.features.overworld.giantflowers.IrisGiant;
import voronoiaoc.byg.common.world.feature.features.overworld.giantflowers.RoseGiant;
import voronoiaoc.byg.common.world.feature.features.overworld.mushrooms.*;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.acacia.AcaciaTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.ancient.AncientTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.ancient.AncientTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.ancient.AncientTree3;
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
import voronoiaoc.byg.common.world.feature.features.overworld.trees.cika.CikaTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.cika.CikaTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.cika.CikaTree3;
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
import voronoiaoc.byg.common.world.feature.features.overworld.trees.redwood.RedwoodTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.redwood.RedwoodTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.redwood.RedwoodTree3;
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

    //Embur
    public static final Feature<DefaultFeatureConfig> EMBURLAKE = new EmburBogLake(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> EMBURMUSHROOM = new EmburMushroom(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> EMBURMUSHROOM2 = new EmburMushroom2(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> EMBUR_GEL_VINES = new EmburGelVines(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> EMBUR_ROOTS = new EmburRoots(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> TALL_EMBUR_ROOTS = new TallEmburRoots(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> EMBUR_WART = new EmburWart(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> EMBUR_LILY = new EmburLily(DefaultFeatureConfig.CODEC);


    /********************************************************************Structures***********************************************************************/
//    public static final //StructureFeature<StructurePoolFeatureConfig> BYGVILLAGE = new BYGVillage//StructureFeature(StructurePoolFeatureConfig.CODEC);
//    public static final //StructureFeature<DefaultFeatureConfig> SKYRISFORTRESS = new SkyrisFortressStructure(DefaultFeatureConfig.CODEC);
//    public static final Feature<DefaultFeatureConfig> DOVERQUARRY = new DoverQuarry1(DefaultFeatureConfig.CODEC);


    /********************************************************************Tree Features********************************************************************/
    //Acacia
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ACACIA_TREE1 = new AcaciaTree1(DefaultFeatureConfig.CODEC);
//    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ACACIA_TREE2 = new AcaciaTree2(DefaultFeatureConfig.CODEC);

    //Ancient
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ANCIENT_TREE1 = new AncientTree1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ANCIENT_TREE2 = new AncientTree2(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> ANCIENT_TREE3 = new AncientTree3(DefaultFeatureConfig.CODEC);

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
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> BOREAL_TREE1 = new BorealForestTree1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> BOREAL_TREE2 = new BorealForestTree2(DefaultFeatureConfig.CODEC);

    //Cherry
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> CHERRY_PINK_TREE1 = new PinkCherry1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> CHERRY_PINK_TREE2 = new PinkCherry2(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> CHERRY_WHITE_TREE1 = new WhiteCherry1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> CHERRY_WHITE_TREE2 = new WhiteCherry2(DefaultFeatureConfig.CODEC);

    //Cika
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> CIKA_TREE1 = new CikaTree1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> CIKA_TREE2 = new CikaTree2(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> CIKA_TREE3 = new CikaTree3(DefaultFeatureConfig.CODEC);

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
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> REDWOOD_TREE1 = new RedwoodTree1(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> REDWOOD_TREE2 = new RedwoodTree2(DefaultFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<DefaultFeatureConfig> REDWOOD_TREE3 = new RedwoodTree3(DefaultFeatureConfig.CODEC);
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


    public static class RegisterFeatures {
        public static void registerBYGFeatures() {
            registerFeature(DUMMY_TREE, "dummy_tree");
            registerFeature(DEADSEASPIKES, "dead_sea_spike");
            registerFeature(TALLDEADSEASPIKES, "dead_sea_spike_takk");
            registerFeature(OBBYSPIKES, "obsidian_spike");
            registerFeature(CACTUS, "canyon_cactus");
            registerFeature(BLACKICESNOW, "black_ice_and_snow");
            registerFeature(LAKE_FROST, "frosted_lake");
            registerFeature(LAKE_WIDE_SHALLOW, "lake_wide_shallow");
            registerFeature(LAKE_WIDE_SHALLOW, "lava_lake_wide_shallow");
            registerFeature(VINES, "vines");
            registerFeature(PUMPKIN_PATCH1, "pumpkin");
            registerFeature(PUMPKIN_PATCH2, "pumpkin2");
            registerFeature(PUMPKIN_PATCH3, "pumpkin3");
            registerFeature(GIANT_ANGELICA_FLOWER, "giant_angelica_flower");
            registerFeature(GIANT_DANDELION_FLOWER, "giant_dandelion_flower");
            registerFeature(GIANT_IRIS_FLOWER, "giant_iris_flower");
            registerFeature(GIANT_ROSE_FLOWER, "giant_rose");
            registerFeature(GREEN_MUSHROOM_HUGE, "green_mushroom_huge");
            registerFeature(WOOD_BLEWIT_HUGE, "wood_blewit_huge");
            registerFeature(WEEPING_MILKCAP_HUGE, "weeping_milkcap_huge");
            registerFeature(BLACK_PUFF_HUGE, "black_puff_huge");
            registerFeature(BLUE_GLOWSHROOM_HUGE, "blue_glowshroom_huge");
            registerFeature(PURPLE_GLOWSHROOM_HUGE, "purple_glowshroom_huge");
            registerFeature(BLACK_PUFF, "black_puff");
            registerFeature(GREEN_MUSHROOM, "green_mushroom");
            registerFeature(NETHER_BRISTLE, "nether_bristle");
            registerFeature(SYTHIAN_SPROUT, "sythian_sprout");
            registerFeature(SYTHIAN_STALK, "sythian_stalk");
            registerFeature(SYTHIAN_ROOTS, "sythian_roots");
            registerFeature(WARPED_BUSH, "warped_bush");
            registerFeature(WARPED_CORAL, "warped_coral");
            registerFeature(WARPED_CORALPLANT, "warped_coral_plant");
            registerFeature(WARPED_CORALFAN, "warped_coral_fan");
            registerFeature(WOOD_BLEWIT, "wood_blewit");
            registerFeature(WEED_GRASS, "weed_grass");
            registerFeature(WEEPING_MILKCAP, "weeping_milk_cap");
            registerFeature(WEEPING_ROOTS, "weeping_roots");
            registerFeature(WEEPING_ROOTS_PLANT, "weeping_roots_plant");
            registerFeature(EMBURLAKE, "embur_lake");
            registerFeature(EMBURMUSHROOM, "embur_mushroom");
            registerFeature(EMBURMUSHROOM2, "embur_mushroom2");
            registerFeature(EMBUR_GEL_VINES, "embur_gel_vines");
            registerFeature(EMBUR_ROOTS, "embur_roots");
            registerFeature(TALL_EMBUR_ROOTS, "tall_embur_roots");
            registerFeature(EMBUR_WART, "embur_wart");
            registerFeature(EMBUR_LILY, "embur_lily");
            registerFeature(ACACIA_TREE1, "acacia_tree1");
            registerFeature(ANCIENT_TREE1, "ancient_tree1");
            registerFeature(ANCIENT_TREE2, "ancient_tree2");
            registerFeature(ANCIENT_TREE3, "ancient_tree3");
            registerFeature(ASPEN_SHRUB1, "aspen_shrub1");
            registerFeature(ASPEN_SHRUB2, "aspen_shrub2");
            registerFeature(ASPEN_TREE1, "aspen_tree1");
            registerFeature(ASPEN_TREE2, "aspen_tree2");
            registerFeature(ASPEN_TREE3, "aspen_tree3");
            registerFeature(BAOBAB_TREE1, "baobab_tree1");
            registerFeature(BIRCH_BROWN_TREE1, "brown_birch_tree1");
            registerFeature(BIRCH_ORANGE_TREE1, "orange_birch_tree1");
            registerFeature(BIRCH_RED_TREE1, "red_birch_tree1");
            registerFeature(BIRCH_YELLOW_TREE1, "yellow_birch_tree1");
            registerFeature(BLUFF_TREE1, "bluff_tree1");
            registerFeature(BLUFF_TREE2, "bluff_tree2");
            registerFeature(BLUFF_TREE3, "bluff_tree3");
            registerFeature(BOREAL_TREE1, "boreal_tree1");
            registerFeature(BOREAL_TREE2, "boreal_tree2");
            registerFeature(CHERRY_PINK_TREE1, "pink_cherry_tree1");
            registerFeature(CHERRY_PINK_TREE2, "pink_cherry_tree2");
            registerFeature(CHERRY_WHITE_TREE1, "white_cherry_tree1");
            registerFeature(CHERRY_WHITE_TREE2, "white_cherry_tree2");
            registerFeature(CIKA_TREE1, "cika_tree1");
            registerFeature(CIKA_TREE2, "cika_tree2");
            registerFeature(CIKA_TREE3, "cika_tree3");
            registerFeature(CONIFER_TREE1, "conifer_tree1");
            registerFeature(CONIFER_TREE2, "conifer_tree2");
            registerFeature(CONIFER_TREE3, "conifer_tree3");
            registerFeature(CONIFER_TREE4, "conifer_tree4");
            registerFeature(CONIFER_TREE5, "conifer_tree5");
            registerFeature(CONIFER_TREE6, "conifer_tree6");
            registerFeature(CONIFER_TREE7, "conifer_tree7");
            registerFeature(CONIFER_TREE8, "conifer_tree8");
            registerFeature(CYPRESS_TREE1, "cypress_tree1");
            registerFeature(CYPRESS_TREE2, "cypress_tree2");
            registerFeature(CYPRESS_TREE3, "cypress_tree3");
            registerFeature(DEAD_HAZEL_TREE1, "dead_hazel_tree1");
            registerFeature(DEAD_HAZEL_TREE2, "dead_hazel_tree2");
            registerFeature(DEAD_HAZEL_TREE3, "dead_hazel_tree3");
            registerFeature(DEAD_HAZEL_TREE4, "dead_hazel_tree4");
            registerFeature(DECIDUOUS_TREE, "deciduous_tree");
            registerFeature(DECIDUOUS_BROWN_TREE, "brown_deciduous_tree");
            registerFeature(DECIDUOUS_ORANGE_TREE, "orange_deciduous_tree");
            registerFeature(DECIDUOUS_YELLOW_TREE, "yellow_deciduous_tree");
            registerFeature(DECIDUOUS_RED_TREE, "red_deciduous_tree");
            registerFeature(DECIDUOUS_SEASONAL_SHRUBS, "deciduous_seasonal_shrubs");
            registerFeature(EBONY_BUSH1, "ebony_bush1");
            registerFeature(EBONY_TREE1, "ebony_tree1");
            registerFeature(EBONY_TREE2, "ebony_tree2");
            registerFeature(ENCHANTED_BLUE_TREE1, "blue_enchanted_tree1");
            registerFeature(ENCHANTED_BLUE_TREE2, "blue_enchanted_tree2");
            registerFeature(ENCHANTED_BLUE_TREE3, "blue_enchanted_tree3");
            registerFeature(ENCHANTED_GREEN_TREE1, "green_enchanted_tree1");
            registerFeature(ENCHANTED_GREEN_TREE2, "green_enchanted_tree2");
            registerFeature(ENCHANTED_GREEN_TREE3, "green_enchanted_tree3");
            registerFeature(ENCHANTED_GREEN_GROVE_TREE1, "green_enchanted_grove_tree1");
            registerFeature(ENCHANTED_BLUE_GROVE_TREE1, "blue_enchanted_grove_tree1");
            registerFeature(HOLLY_TREE1, "holly_tree1");
            registerFeature(HOLLY_TREE2, "holly_tree2");
            registerFeature(HOLLY_TREE3, "holly_tree3");
            registerFeature(HOLLY_TREE4, "holly_tree4");
            registerFeature(JACARANDA_TREE, "jacaranda_tree1");
            registerFeature(JACARANDA_TREE2, "jacaranda_tree2");
            registerFeature(INDIGOJACARANDA_TREE, "indigo_jacaranda_tree1");
            registerFeature(INDIGOJACARANDA_TREE2, "indigo_jacaranda_tree2");
            registerFeature(JOSHUA_TREE1, "joshua_tree1");
            registerFeature(JOSHUA_TREE2, "joshua_tree2");
            registerFeature(MANGROVE_TREE1, "mangrove_tree1");
            registerFeature(MANGROVE_TREE2, "mangrove_tree2");
            registerFeature(MANGROVE_TREE3, "mangrove_tree3");
            registerFeature(MANGROVE_TREE4, "mangrove_tree4");
            registerFeature(MANGROVE_TREE5, "mangrove_tree5");
            registerFeature(MAPLE_RED_TREE, "red_maple_tree1");
            registerFeature(MAPLE_RED_TREE2, "red_maple_tree2");
            registerFeature(MAPLE_SILVER_TREE1, "silver_maple_tree1");
            registerFeature(MAPLE_SILVER_TREE2, "silver_maple_tree2");
            registerFeature(MAPLE_TREE, "maple_tree1");
            registerFeature(MEADOW_TREE1, "meadow_tree1");
            registerFeature(MEADOW_TREE2, "meadow_tree2");
            registerFeature(MEADOW_TREE3, "meadow_tree3");
            registerFeature(ORCHARD_TREE1, "orchard_tree1");
            registerFeature(ORCHARD_TREE2, "orchard_tree2");
            registerFeature(ORCHARD_TREE1, "orchard_tree3");
            registerFeature(PALM_TREE1, "palm_tree3");
            registerFeature(PINE_LARGE_TREE1, "large_pine_tree1");
            registerFeature(PINE_LARGE_TREE2, "large_pine_tree2");
            registerFeature(PINE_TREE1, "pine_tree1");
            registerFeature(PINE_TREE2, "pine_tree2");
            registerFeature(PALO_VERDE_TREE1, "palo_verde_tree1");
            registerFeature(PALO_VERDE_TREE2, "palo_verde_tree2");
            registerFeature(RAINBOW_LARGE_TREE1, "large_rainbow_eucalyptus_tree1");
            registerFeature(RAINBOW_TREE1, "rainbow_eucalyptus_tree1");
            registerFeature(REDWOOD_TREE1, "redwood_tree1");
            registerFeature(REDWOOD_TREE2, "redwood_tree2");
            registerFeature(REDWOOD_TREE3, "redwood_tree3");
            registerFeature(OAK_BROWN_TREE1, "brown_oak_tree1");
            registerFeature(OAK_ORANGE_TREE1, "orange_oak_tree1");
            registerFeature(OAK_RED_TREE1, "red_oak_tree1");
            registerFeature(SHRUB, "shrub1");
            registerFeature(SHRUB_MEADOW1, "meadow_shrub1");
            registerFeature(SHRUB_MEADOW2, "meadow_shrub2");
            registerFeature(SHRUB_PRAIRIE1, "prairie_shrub1");
            registerFeature(SHRUB_PRAIRIE2, "prairie_shrub2");
            registerFeature(SKYRIS_TREE1, "skyris_tree1");
            registerFeature(SKYRIS_TREE2, "skyris_tree2");
            registerFeature(SKYRIS_TREE3, "skyris_tree3");
            registerFeature(BLUEGIANTSPUCE_TREE, "giant_blue_spruce_tree1");
            registerFeature(TALLBLUESPRUCE_TREE, "tall_blue_spruce_tree1");
            registerFeature(BLUESPRUCE_TREE, "blue_spruce_tree1");
            registerFeature(SMALLBLUESPRUCE_TREE, "small_blue_spruce_tree1");
            registerFeature(GIANTORANGESPRUCE_TREE, "giant_orange_spruce_tree1");
            registerFeature(TALLORANGESPRUCE_TREE, "tall_orange_spruce_tree1");
            registerFeature(ORANGESPRUCE_TREE, "orange_spruce_tree1");
            registerFeature(SMALLORANGESPRUCE_TREE, "small_orange_spruce_tree1");
            registerFeature(GIANTREDSPRUCE_TREE, "giant_red_spruce_tree1");
            registerFeature(TALLREDSPRUCE_TREE, "tall_red_spruce_tree1");
            registerFeature(REDSPRUCE_TREE, "red_spruce_tree1");
            registerFeature(SMALLREDSPRUCE_TREE, "small_red_spruce_tree1");
            registerFeature(GIANTYELLOWSPRUCE_TREE, "giant_yellow_spruce_tree1");
            registerFeature(TALLYELLOWSPRUCE_TREE, "tall_yellow_spruce_tree1");
            registerFeature(YELLOWSPRUCE_TREE, "yellow_spruce_tree1");
            registerFeature(SMALLYELLOWSPRUCE_TREE, "small_yellow_spruce_tree1");
            registerFeature(TROPICAL_TREE1, "tropical_tree1");
            registerFeature(TROPICAL_SHORT_TREE1, "tropical_short_tree1");
            registerFeature(TROPICAL_SHRUB1, "tropical_shrub1");
            registerFeature(WOODLANDS_TREE1, "woodlands_tree1");
            registerFeature(WILLOW_DEAD_TREE1, "dead_willow_tree1");
            registerFeature(WILLOW_M_TREE1, "mutated_willow_tree1");
            registerFeature(WILLOW_M_TREE2, "mutated_willow_tree2");
            registerFeature(WILLOW_TREE1, "willow_tree1");
            registerFeature(WILLOW_TREE2, "willow_tree2");
            registerFeature(WILLOW_TREE3, "willow_tree3");
            registerFeature(WILLOW_TREE4, "willow_tree4");
            registerFeature(ZELKOVA_TREE1, "zelkova_tree1");
            registerFeature(ZELKOVA_TREE2, "zelkova_tree2");
            registerFeature(ZELKOVA_TREE3, "zelkova_tree3");
        }

        public static void registerFeature(Feature<?> feature, String registryName) {
            Registry.register(Registry.FEATURE, new Identifier(BYG.MODID, registryName), feature);
        }
    }
}


