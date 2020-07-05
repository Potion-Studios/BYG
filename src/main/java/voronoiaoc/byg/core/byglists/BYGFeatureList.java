package voronoiaoc.byg.core.byglists;

import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import voronoiaoc.byg.common.world.carver.VolcanicCarver;
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

    public static final Feature<NoFeatureConfig> DUMMY_TREE = new SmallPineTree(NoFeatureConfig.field_236558_a_);

    /********************************************************************Features*************************************************************************/
    //DeadSea
    public static final Feature<NoFeatureConfig> DEADSEASPIKES = new DeadSeaSpikes(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> TALLDEADSEASPIKES = new TallDeadSeaSpikes(NoFeatureConfig.field_236558_a_);

    public static final Feature<NoFeatureConfig> OBBYSPIKES = new ObsidianSpike(NoFeatureConfig.field_236558_a_);

    public static final Feature<NoFeatureConfig> CACTUS = new CanyonCactus(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> BLACKICESNOW = new BlackIceAndSnowFeature(NoFeatureConfig.field_236558_a_);

    //Lakes
    public static final Feature<BlockStateFeatureConfig> LAKE_FROST = new FrostMagmaLakeFeature(BlockStateFeatureConfig.field_236455_a_);
    public static final Feature<NoFeatureConfig> LAKE_WIDE_SHALLOW = new LakeWideShallow(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> LAKE_LAVA_WIDE_SHALLOW = new LavaLakeWideShallow(NoFeatureConfig.field_236558_a_);
    //Vines
    public static final Feature<NoFeatureConfig> VINES = new VinePlacer(NoFeatureConfig.field_236558_a_);

    //Pumpkins
    public static final BYGAbstractTreeFeature<NoFeatureConfig> PUMPKIN_PATCH1 = new PumpkinPatch1(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> PUMPKIN_PATCH2 = new PumpkinPatch2(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> PUMPKIN_PATCH3 = new PumpkinPatch3(NoFeatureConfig.field_236558_a_);

    /********************************************************************Carvers**************************************************************************/
    public static final WorldCarver<ProbabilityConfig> VOLCANIC_CARVER = new VolcanicCarver(ProbabilityConfig.field_236576_b_, 256);


    /*********************************************************************Large Flower Features***********************************************************/
    public static final BYGAbstractTreeFeature<NoFeatureConfig> GIANT_ANGELICA_FLOWER = new AngelicaGiant(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> GIANT_DANDELION_FLOWER = new DandelionGiant(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> GIANT_IRIS_FLOWER = new IrisGiant(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> GIANT_ROSE_FLOWER = new RoseGiant(NoFeatureConfig.field_236558_a_);


    /*********************************************************************Large Mushroom Features*********************************************************/
    public static final Feature<NoFeatureConfig> GREEN_MUSHROOM_HUGE = new GreenMushroomHuge(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> WOOD_BLEWIT_HUGE = new WoodBlewitHuge(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> WEEPING_MILKCAP_HUGE = new WeepingMilkcapHuge(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> BLACK_PUFF_HUGE = new BlackPuffHuge(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> BLUE_GLOWSHROOM_HUGE = new BlueGlowshroomHuge(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> PURPLE_GLOWSHROOM_HUGE = new PurpleGlowshroomHuge(NoFeatureConfig.field_236558_a_);


    /********************************************************************Nether Features********************************************************************/

    public static final Feature<NoFeatureConfig> BLACK_PUFF = new BlackPuffMushroom(NoFeatureConfig.field_236558_a_);

    public static final Feature<NoFeatureConfig> GREEN_MUSHROOM = new GreenMushroom(NoFeatureConfig.field_236558_a_);

    public static final Feature<NoFeatureConfig> NETHER_BRISTLE = new NetherBristle(NoFeatureConfig.field_236558_a_);

    //Sythian
    public static final Feature<NoFeatureConfig> SYTHIAN_SPROUT = new SythianSprout(NoFeatureConfig.field_236558_a_);
    public static final Feature<ProbabilityConfig> SYTHIAN_STALK = new SythianStalk(ProbabilityConfig.field_236576_b_);
    public static final Feature<NoFeatureConfig> SYTHIAN_ROOTS = new SythianRoots(NoFeatureConfig.field_236558_a_);

    //Warped
    public static final Feature<NoFeatureConfig> WARPED_BUSH = new WarpedBush(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> WARPED_CORAL = new WarpedCoral(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> WARPED_CORALPLANT = new WarpedCoralFeature(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> WARPED_CORALFAN = new WarpedCoralFan(NoFeatureConfig.field_236558_a_);


    public static final Feature<NoFeatureConfig> WOOD_BLEWIT = new WoodBlewitMushroom(NoFeatureConfig.field_236558_a_);

    public static final Feature<NoFeatureConfig> WEED_GRASS = new WeedGrass(NoFeatureConfig.field_236558_a_);

    public static final Feature<NoFeatureConfig> WEEPING_MILKCAP = new WeepingMilkCapMushroom(NoFeatureConfig.field_236558_a_);

    //Weeping Roots
    public static final Feature<NoFeatureConfig> WEEPING_ROOTS = new WeepingRoots(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> WEEPING_ROOTS_PLANT = new WeepingRootsPlant(NoFeatureConfig.field_236558_a_);

    //Embur
    public static final Feature<NoFeatureConfig> EMBURLAKE = new EmburBogLake(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> EMBURMUSHROOM = new EmburMushroom(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> EMBURMUSHROOM2 = new EmburMushroom2(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> EMBUR_GEL_VINES = new EmburGelVines(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> EMBUR_ROOTS = new EmburRoots(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> TALL_EMBUR_ROOTS = new TallEmburRoots(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> EMBUR_WART = new EmburWart(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> EMBUR_LILY = new EmburLily(NoFeatureConfig.field_236558_a_);


    /********************************************************************Structures***********************************************************************/
//    public static final StructureFeature<VillageConfig> BYGVILLAGE = new BYGVillagePieces(VillageConfig.field_236533_a_);
//    public static final StructureFeature<NoFeatureConfig> SKYRISFORTRESS = new SkyrisFortressStructure(NoFeatureConfig.field_236558_a_);
//    public static final Feature<NoFeatureConfig> DOVERQUARRY = new DoverQuarry1(NoFeatureConfig.field_236558_a_);


    /********************************************************************Tree Features********************************************************************/
    //Acacia
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ACACIA_TREE1 = new AcaciaTree1(NoFeatureConfig.field_236558_a_);
//    public static final BYGAbstractTreeFeature<NoFeatureConfig> ACACIA_TREE2 = new AcaciaTree2(NoFeatureConfig.field_236558_a_);

    //Ancient
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ANCIENT_TREE1 = new AncientTree1(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ANCIENT_TREE2 = new AncientTree2(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ANCIENT_TREE3 = new AncientTree3(NoFeatureConfig.field_236558_a_);

    //Aspen
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ASPEN_SHRUB1 = new AspenShrub(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ASPEN_SHRUB2 = new AspenShrub2(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ASPEN_TREE1 = new AspenTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ASPEN_TREE2 = new AspenTree2(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ASPEN_TREE3 = new AspenTree3(NoFeatureConfig.field_236558_a_);
//    public static final BYGAbstractTreeFeature<NoFeatureConfig> ASPEN_TREE4 = new AspenTree4(NoFeatureConfig.field_236558_a_);

    //Baobab Tree
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BAOBAB_TREE1 = new BaobabTree1(NoFeatureConfig.field_236558_a_);

    //Birch
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BIRCH_BROWN_TREE1 = new BrownBirchTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BIRCH_ORANGE_TREE1 = new OrangeBirchTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BIRCH_RED_TREE1 = new RedBirchTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BIRCH_YELLOW_TREE1 = new YellowBirchTree(NoFeatureConfig.field_236558_a_);

    //Bluff Trees
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BLUFF_TREE1 = new BluffTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BLUFF_TREE2 = new BluffTree2(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BLUFF_TREE3 = new BluffTree3(NoFeatureConfig.field_236558_a_);

    //Boreal Trees
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BOREAL_TREE = new BorealForestTree1(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BOREAL_TREE2 = new BorealForestTree2(NoFeatureConfig.field_236558_a_);

    //Cherry
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CHERRY_PINK_TREE1 = new PinkCherry1(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CHERRY_PINK_TREE2 = new PinkCherry2(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CHERRY_WHITE_TREE1 = new WhiteCherry1(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CHERRY_WHITE_TREE2 = new WhiteCherry2(NoFeatureConfig.field_236558_a_);

    //Cika
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CIKA_TREE1 = new CikaTree1(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CIKA_TREE2 = new CikaTree2(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CIKA_TREE3 = new CikaTree3(NoFeatureConfig.field_236558_a_);

    //Coniferous
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CONIFER_TREE1 = new ConiferTree1(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CONIFER_TREE2 = new ConiferTree2(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CONIFER_TREE3 = new ConiferTree3(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CONIFER_TREE4 = new ConiferTree4(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CONIFER_TREE5 = new ConiferTree5(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CONIFER_TREE6 = new ConiferTree6(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CONIFER_TREE7 = new ConiferTree7(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CONIFER_TREE8 = new ConiferTree8(NoFeatureConfig.field_236558_a_);

    //Cypress
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CYPRESS_TREE1 = new CypressTree1(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CYPRESS_TREE2 = new CypressTree2(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CYPRESS_TREE3 = new CypressTree3(NoFeatureConfig.field_236558_a_);

    //Dead
//    public static final BYGAbstractTreeFeature<NoFeatureConfig> DEAD_TREE = new DeadTree(NoFeatureConfig.field_236558_a_);

    //Dead Hazel
    public static final BYGAbstractTreeFeature<NoFeatureConfig> DEAD_HAZEL_TREE1 = new DeadHazel1(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> DEAD_HAZEL_TREE2 = new DeadHazel2(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> DEAD_HAZEL_TREE3 = new DeadHazel3(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> DEAD_HAZEL_TREE4 = new DeadHazel4(NoFeatureConfig.field_236558_a_);

    //Deciduous
    public static final BYGAbstractTreeFeature<NoFeatureConfig> DECIDUOUS_TREE = new DeciduousTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> DECIDUOUS_BROWN_TREE = new BrownDeciduousTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> DECIDUOUS_ORANGE_TREE = new OrangeDeciduousTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> DECIDUOUS_YELLOW_TREE = new YellowDeciduousTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> DECIDUOUS_RED_TREE = new RedDeciduousTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> DECIDUOUS_SEASONAL_SHRUBS = new SeasonalDeciduousShrubs(NoFeatureConfig.field_236558_a_);

    //Ebony
    public static final BYGAbstractTreeFeature<NoFeatureConfig> EBONY_BUSH1 = new EbonyBush1(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> EBONY_TREE1 = new EbonyTree1(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> EBONY_TREE2 = new EbonyTree2(NoFeatureConfig.field_236558_a_);

    //Enchanted Trees
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ENCHANTED_BLUE_TREE1 = new BlueEnchantedTree1(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ENCHANTED_BLUE_TREE2 = new BlueEnchantedTree2(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ENCHANTED_BLUE_TREE3 = new BlueEnchantedTree3(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ENCHANTED_GREEN_TREE1 = new GreenEnchantedTree1(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ENCHANTED_GREEN_TREE2 = new GreenEnchantedTree2(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ENCHANTED_GREEN_TREE3 = new GreenEnchantedTree3(NoFeatureConfig.field_236558_a_);

    public static final BYGAbstractTreeFeature<NoFeatureConfig> ENCHANTED_GREEN_GROVE_TREE1 = new GreenEnchantedGroveTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ENCHANTED_BLUE_GROVE_TREE1 = new BlueEnchantedGroveTree(NoFeatureConfig.field_236558_a_);

    //Holly
    public static final BYGAbstractTreeFeature<NoFeatureConfig> HOLLY_TREE1 = new HollyTree1(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> HOLLY_TREE2 = new HollyTree2(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> HOLLY_TREE3 = new HollyTree3(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> HOLLY_TREE4 = new HollyTree4(NoFeatureConfig.field_236558_a_);

    //Jacaranda
    public static final BYGAbstractTreeFeature<NoFeatureConfig> JACARANDA_TREE = new JacarandaTree1(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> JACARANDA_TREE2 = new JacarandaTree2(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> INDIGOJACARANDA_TREE = new IndigoJacarandaTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> INDIGOJACARANDA_TREE2 = new IndigoJacarandaTree2(NoFeatureConfig.field_236558_a_);

    //JoshuaTree
    public static final BYGAbstractTreeFeature<NoFeatureConfig> JOSHUA_TREE1 = new JoshuaTree1(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> JOSHUA_TREE2 = new JoshuaTree2(NoFeatureConfig.field_236558_a_);

    //Mangrove
    public static final BYGAbstractTreeFeature<NoFeatureConfig> MANGROVE_TREE1 = new MangroveTree1(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> MANGROVE_TREE2 = new MangroveTree2(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> MANGROVE_TREE3 = new MangroveTree3(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> MANGROVE_TREE4 = new MangroveTree4(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> MANGROVE_TREE5 = new MangroveTree5(NoFeatureConfig.field_236558_a_);

    //Maple
    public static final BYGAbstractTreeFeature<NoFeatureConfig> MAPLE_RED_TREE = new RedMapleTree1(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> MAPLE_RED_TREE2 = new RedMapleTree2(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> MAPLE_SILVER_TREE1 = new SilverMapleTree1(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> MAPLE_SILVER_TREE2 = new SilverMapleTree2(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> MAPLE_TREE = new MapleTree(NoFeatureConfig.field_236558_a_);

    //Meadow
    public static final BYGAbstractTreeFeature<NoFeatureConfig> MEADOW_TREE1 = new MeadowTree1(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> MEADOW_TREE2 = new MeadowTree2(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> MEADOW_TREE3 = new MeadowTree3(NoFeatureConfig.field_236558_a_);

    //Orchard
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ORCHARD_TREE1 = new OrchardTree1(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ORCHARD_TREE2 = new OrchardTree2(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ORCHARD_TREE3 = new OrchardTree3(NoFeatureConfig.field_236558_a_);

    //Palm
    public static final BYGAbstractTreeFeature<NoFeatureConfig> PALM_TREE1 = new PalmTree1(NoFeatureConfig.field_236558_a_);

    //Pine
    public static final BYGAbstractTreeFeature<NoFeatureConfig> PINE_LARGE_TREE1 = new LargePineTree1(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> PINE_LARGE_TREE2 = new LargePineTree2(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> PINE_TREE1 = new PineTree1(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> PINE_TREE2 = new PineTree2(NoFeatureConfig.field_236558_a_);

    //Palo Verde
    public static final BYGAbstractTreeFeature<NoFeatureConfig> PALO_VERDE_TREE1 = new PaloVerdeTree(NoFeatureConfig.field_236558_a_, 0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> PALO_VERDE_TREE2 = new PaloVerdeTree2(NoFeatureConfig.field_236558_a_, 0);

    //Rainbow Eucalyptus
    public static final BYGAbstractTreeFeature<NoFeatureConfig> RAINBOW_TREE1 = new RainbowEucalyptusTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> RAINBOW_LARGE_TREE1 = new LargeRainbowEucalyptus(NoFeatureConfig.field_236558_a_);

    //RedWood
    public static final BYGAbstractTreeFeature<NoFeatureConfig> REDWOOD_TREE1 = new RedwoodTree1(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> REDWOOD_TREE2 = new RedwoodTree2(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> REDWOOD_TREE3 = new RedwoodTree3(NoFeatureConfig.field_236558_a_);
    //Seasonal Oaks
    public static final BYGAbstractTreeFeature<NoFeatureConfig> OAK_BROWN_TREE1 = new BrownOakTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> OAK_ORANGE_TREE1 = new OrangeOakTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> OAK_RED_TREE1 = new RedOakTree(NoFeatureConfig.field_236558_a_);

    //Shrubs
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SHRUB = new BYGShrub(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SHRUB_MEADOW1 = new MeadowShrub(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SHRUB_MEADOW2 = new MeadowShrub2(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SHRUB_PRAIRIE1 = new PrairieShrub(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SHRUB_PRAIRIE2 = new PrairieShrub2(NoFeatureConfig.field_236558_a_);

    //Skyris
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SKYRIS_TREE1 = new SkyrisTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SKYRIS_TREE2 = new SkyrisTree2(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SKYRIS_TREE3 = new SkyrisTree3(NoFeatureConfig.field_236558_a_);

    //Spruce
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BLUEGIANTSPUCE_TREE = new GiantBlueSpruceTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> TALLBLUESPRUCE_TREE = new TallBlueSpruceTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BLUESPRUCE_TREE = new BlueSpruceTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SMALLBLUESPRUCE_TREE = new SmallBlueTaigaTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> GIANTORANGESPRUCE_TREE = new GiantOrangeSpruceTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> TALLORANGESPRUCE_TREE = new TallOrangeSpruceTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ORANGESPRUCE_TREE = new OrangeSpruceTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SMALLORANGESPRUCE_TREE = new SmallOrangeSpruceTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> GIANTREDSPRUCE_TREE = new GiantRedSpruceTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> TALLREDSPRUCE_TREE = new TallRedSpruceTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> REDSPRUCE_TREE = new RedSpruceTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SMALLREDSPRUCE_TREE = new SmallRedSpruceTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> GIANTYELLOWSPRUCE_TREE = new GiantYellowSpruceTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> TALLYELLOWSPRUCE_TREE = new TallYellowSpruceTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> YELLOWSPRUCE_TREE = new YellowSpruceTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SMALLYELLOWSPRUCE_TREE = new SmallYellowTaigaTree(NoFeatureConfig.field_236558_a_);

    //Tropical
    public static final BYGAbstractTreeFeature<NoFeatureConfig> TROPICAL_TREE1 = new TropicalRainForestTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> TROPICAL_SHORT_TREE1 = new ShortTropicalRainForestTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> TROPICAL_SHRUB1 = new TropicalShrub(NoFeatureConfig.field_236558_a_);

    //Woodlands
    public static final BYGAbstractTreeFeature<NoFeatureConfig> WOODLANDS_TREE1 = new WoodlandsTree1(NoFeatureConfig.field_236558_a_);

    //Willow
    public static final BYGAbstractTreeFeature<NoFeatureConfig> WILLOW_DEAD_TREE1 = new WillowDeadTree1(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> WILLOW_M_TREE1 = new WillowTreeM1(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> WILLOW_M_TREE2 = new WillowTreeM2(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> WILLOW_TREE1 = new WillowTree1(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> WILLOW_TREE2 = new WillowTree2(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> WILLOW_TREE3 = new WillowTree3(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> WILLOW_TREE4 = new WillowTree4(NoFeatureConfig.field_236558_a_);

    //Zelkova
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ZELKOVA_TREE1 = new ZelkovaTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ZELKOVA_TREE2 = new ZelkovaTree2(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ZELKOVA_TREE3 = new ZelkovaTree3(NoFeatureConfig.field_236558_a_);
}


