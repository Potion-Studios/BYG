package voronoiaoc.byg.core.byglists;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.common.world.carver.VolcanicCarver;
import voronoiaoc.byg.common.world.feature.features.RiverThingy;
import voronoiaoc.byg.common.world.feature.features.end.obsidianspires.ObsidianSpike;
import voronoiaoc.byg.common.world.feature.features.nether.LargeChain;
import voronoiaoc.byg.common.world.feature.features.nether.crimsongardens.CrimsonBerryBush;
import voronoiaoc.byg.common.world.feature.features.nether.crimsongardens.TallCrimsonRoots;
import voronoiaoc.byg.common.world.feature.features.nether.crimsongardens.WeepingVineFeatureBlackstone;
import voronoiaoc.byg.common.world.feature.features.nether.emburbog.*;
import voronoiaoc.byg.common.world.feature.features.nether.glowstonegardens.*;
import voronoiaoc.byg.common.world.feature.features.nether.sythiantorrids.SythianRoots;
import voronoiaoc.byg.common.world.feature.features.nether.sythiantorrids.SythianSprout;
import voronoiaoc.byg.common.world.feature.features.nether.sythiantorrids.SythianStalk;
import voronoiaoc.byg.common.world.feature.features.nether.wailinggarth.ScorchedBush;
import voronoiaoc.byg.common.world.feature.features.nether.wailinggarth.ScorchedGrass;
import voronoiaoc.byg.common.world.feature.features.nether.wailinggarth.WailingVine;
import voronoiaoc.byg.common.world.feature.features.nether.wailinggarth.WhalingGrass;
import voronoiaoc.byg.common.world.feature.features.nether.warpeddesert.*;
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
import voronoiaoc.byg.common.world.feature.features.overworld.volcano.SmallVolcanoFeature;


public class BYGFeatureList {

    public static final Feature<NoFeatureConfig> DUMMY_TREE = new SmallPineTree(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> HUH = new RiverThingy(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> VOLCANO = new SmallVolcanoFeature(NoFeatureConfig.field_236558_a_, 2375866);
    public static final Feature<NoFeatureConfig> VOLCANO2 = new SmallVolcanoFeature(NoFeatureConfig.field_236558_a_, 929445895);

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

    /*********************************************************************Mini Mushroom Features*********************************************************/
    public static final Feature<NoFeatureConfig> MINI_GREEN_MUSHROOM = new MiniGreenMushroom(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> MINI_RED_MUSHROOM = new MiniRedMushroom(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> MINI_BROWN_MUSHROOM = new MiniBrownMushroom(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> MINI_WEEPING_MILKCAP = new MiniWeepingMilkcap(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> MINI_BLACK_PUFF = new MiniBlackPuff(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> MINI_WOOD_BLEWIT = new MiniWoodBlewit(NoFeatureConfig.field_236558_a_);

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
    public static final Feature<NoFeatureConfig> HUGE_WARPED_CORAL_PLANT = new WarpedCoralFeature(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> WARPED_CORAL_FAN = new WarpedCoralFan(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> SOUL_SOIL_PILLARS = new SoulSoilPillars(NoFeatureConfig.field_236558_a_);

    //Chains
    public static final Feature<NoFeatureConfig> CHAINS = new LargeChain(NoFeatureConfig.field_236558_a_);

    //CrimsonGardens
    public static final Feature<NoFeatureConfig> TALL_CRIMSON_ROOTS = new TallCrimsonRoots(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> CRIMSON_BERRY_BUSH = new CrimsonBerryBush(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> WEEPING_VINE_BLACKSTONE = new WeepingVineFeatureBlackstone(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> CRIMSON_FUNGUS_TREE1 = new CrimsonFungus1(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> CRIMSON_FUNGUS_TREE2 = new CrimsonFungus2(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> WARPED_FUNGUS_TREE1 = new WarpedFungus1(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> WARPED_FUNGUS_TREE2 = new WarpedFungus2(NoFeatureConfig.field_236558_a_);

    //Whaling
    public static final Feature<NoFeatureConfig> WAILING_VINES = new WailingVine(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> WAILING_GRASS = new WhalingGrass(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> SCORCHED_GRASS = new ScorchedGrass(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> SCORCHED_BUSH = new ScorchedBush(NoFeatureConfig.field_236558_a_);

    public static final Feature<NoFeatureConfig> WOOD_BLEWIT = new WoodBlewitMushroom(NoFeatureConfig.field_236558_a_);

    public static final Feature<NoFeatureConfig> WEED_GRASS = new WeedGrass(NoFeatureConfig.field_236558_a_);

    public static final Feature<NoFeatureConfig> WEEPING_MILKCAP = new WeepingMilkCapMushroom(NoFeatureConfig.field_236558_a_);

    //Weeping Roots
    public static final Feature<NoFeatureConfig> WEEPING_ROOTS = new WeepingRoots(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> WEEPING_ROOTS_PLANT = new WeepingRootsPlant(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> WEEPING_ROOTS_FEATURE = new WeepingRootsFeature(NoFeatureConfig.field_236558_a_);

    //Embur
    public static final Feature<NoFeatureConfig> EMBURLAKE = new EmburBogLake(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> EMBUR_MUSHROOM = new EmburMushroom(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> EMBUR_MUSHROOM2 = new EmburMushroom2(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> EMBUR_GEL_VINES = new EmburGelVines(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> EMBUR_ROOTS = new EmburRoots(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> TALL_EMBUR_ROOTS = new TallEmburRoots(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> EMBUR_WART = new EmburWart(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> EMBUR_LILY = new EmburLily(NoFeatureConfig.field_236558_a_);


    /********************************************************************Structures***********************************************************************/
//    public static final //StructureFeature<StructurePoolFeatureConfig> BYGVILLAGE = new BYGVillage//StructureFeature(StructurePoolFeatureConfig.field_236558_a_);
//    public static final //StructureFeature<NoFeatureConfig> SKYRISFORTRESS = new SkyrisFortressStructure(NoFeatureConfig.field_236558_a_);
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
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BOREAL_TREE1 = new BorealForestTree1(NoFeatureConfig.field_236558_a_);
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
    public static final BYGAbstractTreeFeature<NoFeatureConfig> JACARANDA_TREE1 = new JacarandaTree1(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> JACARANDA_TREE2 = new JacarandaTree2(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> JACARANDA_INDIGO_TREE1 = new IndigoJacarandaTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> JACARANDA_INDIGO_TREE2 = new IndigoJacarandaTree2(NoFeatureConfig.field_236558_a_);

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
    public static final BYGAbstractTreeFeature<NoFeatureConfig> MAPLE_RED_TREE1 = new RedMapleTree1(NoFeatureConfig.field_236558_a_);
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
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BLUE_GIANT_SPRUCE_TREE = new GiantBlueSpruceTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BLUE_TALL_SPRUCE_TREE = new TallBlueSpruceTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BLUE_SPRUCE_TREE = new BlueSpruceTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BLUE_SMALL_SPRUCE_TREE = new SmallBlueTaigaTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ORANGE_GIANT_SPRUCE_TREE = new GiantOrangeSpruceTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ORANGE_TALL_SPRUCE_TREE = new TallOrangeSpruceTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ORANGE_SPRUCE_TREE = new OrangeSpruceTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ORANGE_SMALL_SPRUCE_TREE = new SmallOrangeSpruceTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> RED_GIANT_SPRUCE_TREE = new GiantRedSpruceTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> RED_TALL_SPRUCE_TREE = new TallRedSpruceTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> RED_SPRUCE_TREE = new RedSpruceTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> RED_SMALL_SPRUCE_TREE = new SmallRedSpruceTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> YELLOW_GIANT_SPRUCE_TREE = new GiantYellowSpruceTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> YELLOW_TALL_SPRUCE_TREE = new TallYellowSpruceTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> YELLOW_SPRUCE_TREE = new YellowSpruceTree(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> YELLOW_SMALL_SPRUCE_TREE = new SmallYellowTaigaTree(NoFeatureConfig.field_236558_a_);

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


    public static class RegisterFeatures {
        public static void registerBYGFeatures() {
            registerFeature(DUMMY_TREE, "dummy_tree");
            registerFeature(DEADSEASPIKES, "dead_sea_spike");
            registerFeature(TALLDEADSEASPIKES, "dead_sea_spike_tall");
            registerFeature(OBBYSPIKES, "obsidian_spike");
            registerFeature(CACTUS, "canyon_cactus");
            registerFeature(CHAINS, "chains");
            registerFeature(BLACKICESNOW, "black_ice_and_snow");
            registerFeature(LAKE_FROST, "frosted_lake");
            registerFeature(LAKE_WIDE_SHALLOW, "lake_wide_shallow");
            registerFeature(LAKE_LAVA_WIDE_SHALLOW, "lava_lake_wide_shallow");
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
            registerFeature(MINI_BLACK_PUFF, "mini_black_puff");
            registerFeature(MINI_BROWN_MUSHROOM, "mini_brown_mushroom");
            registerFeature(MINI_GREEN_MUSHROOM, "mini_green_mushroom");
            registerFeature(MINI_RED_MUSHROOM, "mini_red_mushroom");
            registerFeature(MINI_WEEPING_MILKCAP, "mini_weeping_milkcap");
            registerFeature(MINI_WOOD_BLEWIT, "mini_wood_blewit");
            registerFeature(BLACK_PUFF, "black_puff");
            registerFeature(GREEN_MUSHROOM, "green_mushroom");
            registerFeature(NETHER_BRISTLE, "nether_bristle");
            registerFeature(TALL_CRIMSON_ROOTS, "tall_crimson_roots");
            registerFeature(CRIMSON_BERRY_BUSH, "crimson_berry_bush");
            registerFeature(WARPED_FUNGUS_TREE1, "warped_fungus_tree1");
            registerFeature(WARPED_FUNGUS_TREE2, "warped_fungus_tree2");
            registerFeature(CRIMSON_FUNGUS_TREE1, "crimson_fungus_tree1");
            registerFeature(CRIMSON_FUNGUS_TREE2, "crimson_fungus_tree2");
            registerFeature(SYTHIAN_SPROUT, "sythian_sprout");
            registerFeature(SYTHIAN_STALK, "sythian_stalk");
            registerFeature(SYTHIAN_ROOTS, "sythian_roots");
            registerFeature(WARPED_BUSH, "warped_bush");
            registerFeature(WARPED_CORAL, "warped_coral");
            registerFeature(HUGE_WARPED_CORAL_PLANT, "warped_coral_plant");
            registerFeature(WARPED_CORAL_FAN, "warped_coral_fan");
            registerFeature(SOUL_SOIL_PILLARS, "soul_soil_pillars");
            registerFeature(WOOD_BLEWIT, "wood_blewit");
            registerFeature(WEED_GRASS, "weed_grass");
            registerFeature(WEEPING_MILKCAP, "weeping_milk_cap");
            registerFeature(WEEPING_ROOTS, "weeping_roots");
            registerFeature(WEEPING_ROOTS_PLANT, "weeping_roots_plant");
            registerFeature(WEEPING_ROOTS_FEATURE, "weeping_roots_feature");
            registerFeature(WEEPING_VINE_BLACKSTONE, "weeping_vine_blackstone");
            registerFeature(EMBURLAKE, "embur_lake");
            registerFeature(EMBUR_MUSHROOM, "embur_mushroom");
            registerFeature(EMBUR_MUSHROOM2, "embur_mushroom2");
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
            registerFeature(JACARANDA_TREE1, "jacaranda_tree1");
            registerFeature(JACARANDA_TREE2, "jacaranda_tree2");
            registerFeature(JACARANDA_INDIGO_TREE1, "indigo_jacaranda_tree1");
            registerFeature(JACARANDA_INDIGO_TREE2, "indigo_jacaranda_tree2");
            registerFeature(JOSHUA_TREE1, "joshua_tree1");
            registerFeature(JOSHUA_TREE2, "joshua_tree2");
            registerFeature(MANGROVE_TREE1, "mangrove_tree1");
            registerFeature(MANGROVE_TREE2, "mangrove_tree2");
            registerFeature(MANGROVE_TREE3, "mangrove_tree3");
            registerFeature(MANGROVE_TREE4, "mangrove_tree4");
            registerFeature(MANGROVE_TREE5, "mangrove_tree5");
            registerFeature(MAPLE_RED_TREE1, "red_maple_tree1");
            registerFeature(MAPLE_RED_TREE2, "red_maple_tree2");
            registerFeature(MAPLE_SILVER_TREE1, "silver_maple_tree1");
            registerFeature(MAPLE_SILVER_TREE2, "silver_maple_tree2");
            registerFeature(MAPLE_TREE, "maple_tree1");
            registerFeature(MEADOW_TREE1, "meadow_tree1");
            registerFeature(MEADOW_TREE2, "meadow_tree2");
            registerFeature(MEADOW_TREE3, "meadow_tree3");
            registerFeature(ORCHARD_TREE1, "orchard_tree1");
            registerFeature(ORCHARD_TREE2, "orchard_tree2");
            registerFeature(ORCHARD_TREE3, "orchard_tree3");
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
            registerFeature(SCORCHED_BUSH, "scorched_bush");
            registerFeature(SCORCHED_GRASS, "scorched_grass");
            registerFeature(SHRUB, "shrub1");
            registerFeature(SHRUB_MEADOW1, "meadow_shrub1");
            registerFeature(SHRUB_MEADOW2, "meadow_shrub2");
            registerFeature(SHRUB_PRAIRIE1, "prairie_shrub1");
            registerFeature(SHRUB_PRAIRIE2, "prairie_shrub2");
            registerFeature(SKYRIS_TREE1, "skyris_tree1");
            registerFeature(SKYRIS_TREE2, "skyris_tree2");
            registerFeature(SKYRIS_TREE3, "skyris_tree3");
            registerFeature(BLUE_GIANT_SPRUCE_TREE, "giant_blue_spruce_tree1");
            registerFeature(BLUE_TALL_SPRUCE_TREE, "tall_blue_spruce_tree1");
            registerFeature(BLUE_SPRUCE_TREE, "blue_spruce_tree1");
            registerFeature(BLUE_SMALL_SPRUCE_TREE, "small_blue_spruce_tree1");
            registerFeature(ORANGE_GIANT_SPRUCE_TREE, "giant_orange_spruce_tree1");
            registerFeature(ORANGE_TALL_SPRUCE_TREE, "tall_orange_spruce_tree1");
            registerFeature(ORANGE_SPRUCE_TREE, "orange_spruce_tree1");
            registerFeature(ORANGE_SMALL_SPRUCE_TREE, "small_orange_spruce_tree1");
            registerFeature(RED_GIANT_SPRUCE_TREE, "giant_red_spruce_tree1");
            registerFeature(RED_TALL_SPRUCE_TREE, "tall_red_spruce_tree1");
            registerFeature(RED_SPRUCE_TREE, "red_spruce_tree1");
            registerFeature(RED_SMALL_SPRUCE_TREE, "small_red_spruce_tree1");
            registerFeature(YELLOW_GIANT_SPRUCE_TREE, "giant_yellow_spruce_tree1");
            registerFeature(YELLOW_TALL_SPRUCE_TREE, "tall_yellow_spruce_tree1");
            registerFeature(YELLOW_SPRUCE_TREE, "yellow_spruce_tree1");
            registerFeature(YELLOW_SMALL_SPRUCE_TREE, "small_yellow_spruce_tree1");
            registerFeature(TROPICAL_TREE1, "tropical_tree1");
            registerFeature(TROPICAL_SHORT_TREE1, "tropical_short_tree1");
            registerFeature(TROPICAL_SHRUB1, "tropical_shrub1");
            registerFeature(WAILING_GRASS, "wailing_grass");
            registerFeature(WAILING_VINES, "wailing_vines");
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
            registerFeature(HUH, "huh");
            registerFeature(VOLCANO, "volcano");
            registerFeature(VOLCANO2, "volcano2");
        }

        public static void registerFeature(Feature<?> feature, String registryName) {
            Registry.register(Registry.FEATURE, new ResourceLocation(BYG.MOD_ID, registryName), feature);
        }
    }
}


