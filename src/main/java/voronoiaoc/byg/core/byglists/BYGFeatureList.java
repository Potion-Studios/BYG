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
import voronoiaoc.byg.common.world.feature.featureconfig.*;
import voronoiaoc.byg.common.world.feature.features.RiverThingy;
import voronoiaoc.byg.common.world.feature.features.end.obsidianspires.ObsidianSpike;
import voronoiaoc.byg.common.world.feature.features.nether.LargeChain;
import voronoiaoc.byg.common.world.feature.features.nether.brimstonecaverns.BrimstonePillars;
import voronoiaoc.byg.common.world.feature.features.nether.crimsongardens.CrimsonBerryBush;
import voronoiaoc.byg.common.world.feature.features.nether.crimsongardens.TallCrimsonRoots;
import voronoiaoc.byg.common.world.feature.features.nether.crimsongardens.WeepingVineFeatureBlackstone;
import voronoiaoc.byg.common.world.feature.features.nether.emburbog.*;
import voronoiaoc.byg.common.world.feature.features.nether.glowstonegardens.*;
import voronoiaoc.byg.common.world.feature.features.nether.magmawastes.MagmaPillars;
import voronoiaoc.byg.common.world.feature.features.nether.soulsandvalley.SoulShroomSporeFeature;
import voronoiaoc.byg.common.world.feature.features.nether.subzerohypo.FrostMagmaPillars;
import voronoiaoc.byg.common.world.feature.features.nether.sythiantorrids.*;
import voronoiaoc.byg.common.world.feature.features.nether.trees.lament.*;
import voronoiaoc.byg.common.world.feature.features.nether.trees.withering.WitheringOakTree1;
import voronoiaoc.byg.common.world.feature.features.nether.trees.withering.WitheringOakTree2;
import voronoiaoc.byg.common.world.feature.features.nether.trees.withering.WitheringOakTree3;
import voronoiaoc.byg.common.world.feature.features.nether.trees.withering.WitheringOakTree4;
import voronoiaoc.byg.common.world.feature.features.nether.wailinggarth.ScorchedBush;
import voronoiaoc.byg.common.world.feature.features.nether.wailinggarth.ScorchedGrass;
import voronoiaoc.byg.common.world.feature.features.nether.wailinggarth.WailingVine;
import voronoiaoc.byg.common.world.feature.features.nether.wailinggarth.WhalingGrass;
import voronoiaoc.byg.common.world.feature.features.nether.warpeddesert.*;
import voronoiaoc.byg.common.world.feature.features.overworld.*;
import voronoiaoc.byg.common.world.feature.features.overworld.giantflowers.AngelicaGiant;
import voronoiaoc.byg.common.world.feature.features.overworld.giantflowers.DandelionGiant;
import voronoiaoc.byg.common.world.feature.features.overworld.giantflowers.IrisGiant;
import voronoiaoc.byg.common.world.feature.features.overworld.giantflowers.RoseGiant;
import voronoiaoc.byg.common.world.feature.features.overworld.giantflowers.util.BYGAbstractGiantFlowerFeature;
import voronoiaoc.byg.common.world.feature.features.overworld.mushrooms.*;
import voronoiaoc.byg.common.world.feature.features.overworld.mushrooms.util.BYGAbstractMushroomFeature;
import voronoiaoc.byg.common.world.feature.features.overworld.pumpkins.LargePumpkin1;
import voronoiaoc.byg.common.world.feature.features.overworld.pumpkins.LargePumpkin2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.acacia.AcaciaTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.ancient.AncientTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.ancient.AncientTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.ancient.AncientTree3;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.araucaria.AraucariaTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.araucaria.AraucariaTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.aspen.*;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.baobab.BaobabTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.birch.BasicTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.bluff.BluffTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.bluff.BluffTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.bluff.BluffTree3;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.boreal.BorealForestTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.boreal.BorealForestTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.cherry.CherryTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.cherry.CherryTree2;
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
import voronoiaoc.byg.common.world.feature.features.overworld.trees.deciduous.DeciduousTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.deciduous.DeciduousTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.deciduous.DeciduousTree3;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.deciduous.DeciduousTree4;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.ebony.EbonyBush1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.ebony.EbonyTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.ebony.EbonyTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.enchanted.EnchantedGroveTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.enchanted.EnchantedTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.enchanted.EnchantedTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.enchanted.EnchantedTree3;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.holly.HollyTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.holly.HollyTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.holly.HollyTree3;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.holly.HollyTree4;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.jacaranda.JacarandaTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.jacaranda.JacarandaTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.joshua.JoshuaTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.joshua.JoshuaTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.mahogany.*;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.mangrove.*;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.maple.MapleTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.maple.MapleTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.maple.MapleTree3;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.meadow.*;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.orchard.OrchardTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.orchard.OrchardTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.orchard.OrchardTree3;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.palm.PalmTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.palm.PalmTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.palm.PalmTree3;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.palm.PalmTree4;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.palo_verde.PaloVerdeTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.palo_verde.PaloVerdeTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.pine.*;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.rainbow_eucalyptus.LargeRainbowEucalyptus;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.rainbow_eucalyptus.RainbowEucalyptusTree;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.redwood.RedwoodTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.redwood.RedwoodTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.redwood.RedwoodTree3;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.skyris.*;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.spruce.giant.SpruceTreeLarge1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.spruce.medium.SpruceTreeMedium1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.spruce.medium.SpruceTreeMedium2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.spruce.medium.SpruceTreeMedium3;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.spruce.medium.SpruceTreeMedium4;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.spruce.small.SpruceTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.spruce.small.SpruceTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.spruce.small.SpruceTree3;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.spruce.small.SpruceTree4;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.tropical.ShortTropicalRainForestTree;
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
import voronoiaoc.byg.common.world.feature.features.overworld.trees.zelkova.ZelkovaTree1;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.zelkova.ZelkovaTree2;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.zelkova.ZelkovaTree3;
import voronoiaoc.byg.common.world.feature.features.overworld.volcano.SmallVolcanoFeature;


public class BYGFeatureList {

    public static final Feature<NoFeatureConfig> DUMMY_TREE = new SmallPineTree(NoFeatureConfig.field_236558_a_);

    public static final Feature<NoFeatureConfig> HUH = new RiverThingy(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> VOLCANO = new SmallVolcanoFeature(NoFeatureConfig.field_236558_a_, 2375866);
    public static final Feature<NoFeatureConfig> VOLCANO2 = new SmallVolcanoFeature(NoFeatureConfig.field_236558_a_, 929445895);
    public static final Feature<BYGBoulderFeatureConfig> STACKABLE_BOULDERS = new StackableBoulders(BYGBoulderFeatureConfig.CODEC);

    /********************************************************************Features*************************************************************************/
    //DeadSea
    public static final Feature<PointyRockFeatureConfig> POINTY_ROCK = new PointyRockFeature(PointyRockFeatureConfig.CODEC);

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
    public static final Feature<BYGPumpkinFeatureConfig> LARGE_PUMPKIN1 = new LargePumpkin1(BYGPumpkinFeatureConfig.CODEC);
    public static final Feature<BYGPumpkinFeatureConfig> LARGE_PUMPKIN2 = new LargePumpkin2(BYGPumpkinFeatureConfig.CODEC);

    /********************************************************************Carvers**************************************************************************/
    public static final WorldCarver<ProbabilityConfig> VOLCANIC_CARVER = new VolcanicCarver(ProbabilityConfig.field_236576_b_, 256);


    /*********************************************************************Large Flower Features***********************************************************/
    public static final BYGAbstractGiantFlowerFeature<BYGGiantFlowerFeatureConfig> GIANT_ANGELICA_FLOWER = new AngelicaGiant(BYGGiantFlowerFeatureConfig.CODEC);
    public static final BYGAbstractGiantFlowerFeature<BYGGiantFlowerFeatureConfig> GIANT_DANDELION_FLOWER = new DandelionGiant(BYGGiantFlowerFeatureConfig.CODEC);
    public static final BYGAbstractGiantFlowerFeature<BYGGiantFlowerFeatureConfig> GIANT_IRIS_FLOWER = new IrisGiant(BYGGiantFlowerFeatureConfig.CODEC);
    public static final BYGAbstractGiantFlowerFeature<BYGGiantFlowerFeatureConfig> GIANT_ROSE_FLOWER = new RoseGiant(BYGGiantFlowerFeatureConfig.CODEC);


    /*********************************************************************Large Mushroom Features*********************************************************/
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> GREEN_MUSHROOM_HUGE = new GreenMushroomHuge(BYGMushroomFeatureConfig.CODEC);
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> WOOD_BLEWIT_HUGE = new WoodBlewitHuge(BYGMushroomFeatureConfig.CODEC);
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> WEEPING_MILKCAP_HUGE = new WeepingMilkcapHuge(BYGMushroomFeatureConfig.CODEC);
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> BLACK_PUFF_HUGE = new BlackPuffHuge(BYGMushroomFeatureConfig.CODEC);
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> BLUE_GLOWSHROOM_HUGE = new BlueGlowshroomHuge(BYGMushroomFeatureConfig.CODEC);
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> PURPLE_GLOWSHROOM_HUGE = new PurpleGlowshroomHuge(BYGMushroomFeatureConfig.CODEC);

    /*********************************************************************Mini Mushroom Features*********************************************************/
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> MINI_GREEN_MUSHROOM = new MiniGreenMushroom(BYGMushroomFeatureConfig.CODEC);
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> MINI_RED_MUSHROOM = new MiniRedMushroom(BYGMushroomFeatureConfig.CODEC);
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> MINI_BROWN_MUSHROOM = new MiniBrownMushroom(BYGMushroomFeatureConfig.CODEC);
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> MINI_WEEPING_MILKCAP = new MiniWeepingMilkcap(BYGMushroomFeatureConfig.CODEC);
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> MINI_BLACK_PUFF = new MiniBlackPuff(BYGMushroomFeatureConfig.CODEC);
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> MINI_WOOD_BLEWIT = new MiniWoodBlewit(BYGMushroomFeatureConfig.CODEC);

    /********************************************************************Nether Features********************************************************************/

    public static final Feature<NoFeatureConfig> BLACK_PUFF = new BlackPuffMushroom(NoFeatureConfig.field_236558_a_);

    public static final Feature<NoFeatureConfig> GREEN_MUSHROOM = new GreenMushroom(NoFeatureConfig.field_236558_a_);

    public static final Feature<NoFeatureConfig> NETHER_BRISTLE = new NetherBristle(NoFeatureConfig.field_236558_a_);

    //SoulShroom
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> SOUL_SHROOM_TREE1 = new SoulShroomTree1(BYGMushroomFeatureConfig.CODEC);
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> SOUL_SHROOM_TREE2 = new SoulShroomTree2(BYGMushroomFeatureConfig.CODEC);
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> SOUL_SHROOM_TREE3 = new SoulShroomTree3(BYGMushroomFeatureConfig.CODEC);
    public static final Feature<NoFeatureConfig> SOUL_SHROOM_SPORES_HANGING = new SoulShroomSporeFeature(NoFeatureConfig.field_236558_a_);

    //DeathCap
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> DEATH_CAP_TREE1 = new DeathCapTree1(BYGMushroomFeatureConfig.CODEC);
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> DEATH_CAP_TREE2 = new DeathCapTree2(BYGMushroomFeatureConfig.CODEC);
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> DEATH_CAP_TREE3 = new DeathCapTree3(BYGMushroomFeatureConfig.CODEC);

    //Lament
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> LAMENT_WEEPING_TREE1 = new LamentWeepingTree1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> LAMENT_WEEPING_TREE2 = new LamentWeepingTree2(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> LAMENT_WEEPING_TREE3 = new LamentWeepingTree3(BYGTreeFeatureConfig.CODEC);

    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> LAMENT_TWISTY_TREE1 = new LamentTwistyTree1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> LAMENT_TWISTY_TREE2 = new LamentTwistyTree2(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> LAMENT_TWISTY_TREE3 = new LamentTwistyTree3(BYGTreeFeatureConfig.CODEC);

    //Withering Oak
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> WITHERING_OAK_TREE1 = new WitheringOakTree1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> WITHERING_OAK_TREE2 = new WitheringOakTree2(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> WITHERING_OAK_TREE3 = new WitheringOakTree3(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> WITHERING_OAK_TREE4 = new WitheringOakTree4(BYGTreeFeatureConfig.CODEC);

    //Sythian
    public static final Feature<NoFeatureConfig> SYTHIAN_SPROUT = new SythianSprout(NoFeatureConfig.field_236558_a_);
    public static final Feature<ProbabilityConfig> SYTHIAN_STALK = new SythianStalk(ProbabilityConfig.field_236576_b_);
    public static final Feature<NoFeatureConfig> SYTHIAN_ROOTS = new SythianRoots(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> SYTHIAN_FUNGUS = new SythianFungus(NoFeatureConfig.field_236558_a_);
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> SYTHIAN_FUNGUS_TREE1 = new SythianFungusTree1(BYGMushroomFeatureConfig.CODEC);
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> SYTHIAN_FUNGUS_TREE2 = new SythianFungusTree2(BYGMushroomFeatureConfig.CODEC);
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> SYTHIAN_FUNGUS_TREE3 = new SythianFungusTree3(BYGMushroomFeatureConfig.CODEC);
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> SYTHIAN_FUNGUS_TREE4 = new SythianFungusTree4(BYGMushroomFeatureConfig.CODEC);
    public static final Feature<NoFeatureConfig> SYTHIAN_HANGING_ROOTS = new HangingSythianRootsFeature(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> MOSSY_NETHERRACK_PILLARS = new MossyNetherrackPillars(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> SYTHIAN_FUNGUS_PILLARS = new SythianFungusPillars(NoFeatureConfig.field_236558_a_);

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
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> CRIMSON_FUNGUS_TREE1 = new CrimsonFungus1(BYGMushroomFeatureConfig.CODEC);
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> CRIMSON_FUNGUS_TREE2 = new CrimsonFungus2(BYGMushroomFeatureConfig.CODEC);
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> WARPED_FUNGUS_TREE1 = new WarpedFungus1(BYGMushroomFeatureConfig.CODEC);
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> WARPED_FUNGUS_TREE2 = new WarpedFungus2(BYGMushroomFeatureConfig.CODEC);

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
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> EMBUR_MUSHROOM = new EmburMushroom(BYGMushroomFeatureConfig.CODEC);
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> EMBUR_MUSHROOM2 = new EmburMushroom2(BYGMushroomFeatureConfig.CODEC);
    public static final Feature<NoFeatureConfig> EMBUR_GEL_VINES = new EmburGelVines(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> EMBUR_ROOTS = new EmburRoots(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> TALL_EMBUR_ROOTS = new TallEmburRoots(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> EMBUR_WART = new EmburWart(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> EMBUR_SPROUTS = new EmburSprouts(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> EMBUR_LILY = new EmburLily(NoFeatureConfig.field_236558_a_);

    //Subzero Hypogeal
    public static final Feature<NoFeatureConfig> FROST_MAGMA_PILLARS = new FrostMagmaPillars(NoFeatureConfig.field_236558_a_);

    //MagmaWastes
    public static final Feature<NoFeatureConfig> MAGMA_PILLARS = new MagmaPillars(NoFeatureConfig.field_236558_a_);

    //BrimstoneCaverns
    public static final Feature<NoFeatureConfig> BRIMSTONE_PILLARS = new BrimstonePillars(NoFeatureConfig.field_236558_a_);


    /********************************************************************Structures***********************************************************************/
//    public static final //StructureFeature<StructurePoolFeatureConfig> BYGVILLAGE = new BYGVillage//StructureFeature(StructurePoolFeatureConfig.field_236558_a_);
//    public static final //StructureFeature<NoFeatureConfig> SKYRISFORTRESS = new SkyrisFortressStructure(BYGTreeFeatureConfig.CODEC);
//    public static final Feature<NoFeatureConfig> DOVERQUARRY = new DoverQuarry1(BYGTreeFeatureConfig.CODEC);


    /********************************************************************Tree Features********************************************************************/
   //Araucaria
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ARAUCARIA_TREE1 = new AraucariaTree1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ARAUCARIA_TREE2 = new AraucariaTree2(BYGTreeFeatureConfig.CODEC);

    //Acacia
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ACACIA_TREE1 = new AcaciaTree1(BYGTreeFeatureConfig.CODEC);
//    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ACACIA_TREE2 = new AcaciaTree2(BYGTreeFeatureConfig.CODEC);

    //Ancient
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ANCIENT_TREE1 = new AncientTree1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ANCIENT_TREE2 = new AncientTree2(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ANCIENT_TREE3 = new AncientTree3(BYGTreeFeatureConfig.CODEC);

    //Aspen
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ASPEN_SHRUB1 = new AspenShrub(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ASPEN_SHRUB2 = new AspenShrub2(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ASPEN_TREE1 = new AspenTree(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ASPEN_TREE2 = new AspenTree2(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ASPEN_TREE3 = new AspenTree3(BYGTreeFeatureConfig.CODEC);
//    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ASPEN_TREE4 = new AspenTree4(BYGTreeFeatureConfig.CODEC);

    //Baobab Tree
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> BAOBAB_TREE1 = new BaobabTree1(BYGTreeFeatureConfig.CODEC);

    //Birch
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> BASIC_TREE = new BasicTree(BYGTreeFeatureConfig.CODEC);


    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> BLUFF_TREE1 = new BluffTree(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> BLUFF_TREE2 = new BluffTree2(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> BLUFF_TREE3 = new BluffTree3(BYGTreeFeatureConfig.CODEC);

    //Boreal Trees
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> BOREAL_TREE1 = new BorealForestTree1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> BOREAL_TREE2 = new BorealForestTree2(BYGTreeFeatureConfig.CODEC);

    //Cherry
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> CHERRY_TREE1 = new CherryTree1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> CHERRY_TREE2 = new CherryTree2(BYGTreeFeatureConfig.CODEC);

    //Cika
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> CIKA_TREE1 = new CikaTree1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> CIKA_TREE2 = new CikaTree2(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> CIKA_TREE3 = new CikaTree3(BYGTreeFeatureConfig.CODEC);

    //Coniferous
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> CONIFER_TREE1 = new ConiferTree1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> CONIFER_TREE2 = new ConiferTree2(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> CONIFER_TREE3 = new ConiferTree3(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> CONIFER_TREE4 = new ConiferTree4(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> CONIFER_TREE5 = new ConiferTree5(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> CONIFER_TREE6 = new ConiferTree6(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> CONIFER_TREE7 = new ConiferTree7(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> CONIFER_TREE8 = new ConiferTree8(BYGTreeFeatureConfig.CODEC);

    //Cypress
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> CYPRESS_TREE1 = new CypressTree1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> CYPRESS_TREE2 = new CypressTree2(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> CYPRESS_TREE3 = new CypressTree3(BYGTreeFeatureConfig.CODEC);

    //Dead
//    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> DEAD_TREE = new DeadTree(BYGTreeFeatureConfig.CODEC);

    //Dead Hazel
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> DEAD_HAZEL_TREE1 = new DeadHazel1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> DEAD_HAZEL_TREE2 = new DeadHazel2(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> DEAD_HAZEL_TREE3 = new DeadHazel3(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> DEAD_HAZEL_TREE4 = new DeadHazel4(BYGTreeFeatureConfig.CODEC);

    //Deciduous
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> DECIDUOUS_TREE1 = new DeciduousTree1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> DECIDUOUS_TREE2 = new DeciduousTree2(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> DECIDUOUS_TREE3 = new DeciduousTree3(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> DECIDUOUS_TREE4 = new DeciduousTree4(BYGTreeFeatureConfig.CODEC);

    //Ebony
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> EBONY_BUSH1 = new EbonyBush1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> EBONY_TREE1 = new EbonyTree1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> EBONY_TREE2 = new EbonyTree2(BYGTreeFeatureConfig.CODEC);

    //Enchanted Trees
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ENCHANTED_TREE1 = new EnchantedTree1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ENCHANTED_TREE2 = new EnchantedTree3(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ENCHANTED_TREE3 = new EnchantedTree2(BYGTreeFeatureConfig.CODEC);

    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ENCHANTED_GROVE_TREE1 = new EnchantedGroveTree(BYGTreeFeatureConfig.CODEC);

    //Holly
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> HOLLY_TREE1 = new HollyTree1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> HOLLY_TREE2 = new HollyTree2(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> HOLLY_TREE3 = new HollyTree3(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> HOLLY_TREE4 = new HollyTree4(BYGTreeFeatureConfig.CODEC);

    //Jacaranda
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> JACARANDA_TREE1 = new JacarandaTree1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> JACARANDA_TREE2 = new JacarandaTree2(BYGTreeFeatureConfig.CODEC);

    //JoshuaTree
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> JOSHUA_TREE1 = new JoshuaTree1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> JOSHUA_TREE2 = new JoshuaTree2(BYGTreeFeatureConfig.CODEC);

    //Mangrove
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> MANGROVE_TREE1 = new MangroveTree1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> MANGROVE_TREE2 = new MangroveTree2(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> MANGROVE_TREE3 = new MangroveTree3(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> MANGROVE_TREE4 = new MangroveTree4(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> MANGROVE_TREE5 = new MangroveTree5(BYGTreeFeatureConfig.CODEC);

    //Maple
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> MAPLE_TREE1 = new MapleTree1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> MAPLE_TREE2 = new MapleTree2(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> MAPLE_TREE3 = new MapleTree3(BYGTreeFeatureConfig.CODEC);

    //Meadow
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> MEADOW_TREE1 = new MeadowTree1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> MEADOW_TREE2 = new MeadowTree2(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> MEADOW_TREE3 = new MeadowTree3(BYGTreeFeatureConfig.CODEC);

    //Orchard
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ORCHARD_TREE1 = new OrchardTree1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ORCHARD_TREE2 = new OrchardTree2(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ORCHARD_TREE3 = new OrchardTree3(BYGTreeFeatureConfig.CODEC);

    //Palm
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> PALM_TREE1 = new PalmTree1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> PALM_TREE2 = new PalmTree2(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> PALM_TREE3 = new PalmTree3(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> PALM_TREE4 = new PalmTree4(BYGTreeFeatureConfig.CODEC);

    //Pine
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> PINE_LARGE_TREE1 = new LargePineTree1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> PINE_LARGE_TREE2 = new LargePineTree2(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> PINE_TREE1 = new PineTree1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> PINE_TREE2 = new PineTree2(BYGTreeFeatureConfig.CODEC);

    //Palo Verde
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> PALO_VERDE_TREE1 = new PaloVerdeTree(BYGTreeFeatureConfig.CODEC, 0);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> PALO_VERDE_TREE2 = new PaloVerdeTree2(BYGTreeFeatureConfig.CODEC, 0);

    //Rainbow Eucalyptus
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> RAINBOW_TREE1 = new RainbowEucalyptusTree(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> RAINBOW_LARGE_TREE1 = new LargeRainbowEucalyptus(BYGTreeFeatureConfig.CODEC);

    //RedWood
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> REDWOOD_TREE1 = new RedwoodTree1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> REDWOOD_TREE2 = new RedwoodTree2(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> REDWOOD_TREE3 = new RedwoodTree3(BYGTreeFeatureConfig.CODEC);

    //Shrubs
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> SHRUB1 = new Shrub1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> SHRUB2 = new Shrub2(BYGTreeFeatureConfig.CODEC);
    //Skyris
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> SKYRIS_TREE1 = new SkyrisTree1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> SKYRIS_TREE2 = new SkyrisTree2(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> SKYRIS_TREE3 = new SkyrisTree3(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> SKYRIS_TREE4 = new SkyrisTree4(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> SKYRIS_TREE5 = new SkyrisTree5(BYGTreeFeatureConfig.CODEC);

    //Spruce
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> SPRUCE_TREE_LARGE1 = new SpruceTreeLarge1(BYGTreeFeatureConfig.CODEC);

    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> SPRUCE_TREE_MEDIUM1 = new SpruceTreeMedium1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> SPRUCE_TREE_MEDIUM2 = new SpruceTreeMedium2(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> SPRUCE_TREE_MEDIUM3 = new SpruceTreeMedium3(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> SPRUCE_TREE_MEDIUM4 = new SpruceTreeMedium4(BYGTreeFeatureConfig.CODEC);

    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> SPRUCE_TREE1 = new SpruceTree1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> SPRUCE_TREE2 = new SpruceTree2(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> SPRUCE_TREE3 = new SpruceTree3(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> SPRUCE_TREE4 = new SpruceTree4(BYGTreeFeatureConfig.CODEC);

    //Tropical
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> TROPICAL_SHORT_TREE1 = new ShortTropicalRainForestTree(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> TROPICAL_SHRUB1 = new TropicalShrub(BYGTreeFeatureConfig.CODEC);

    //Mahogany
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> MAHOGANY_TREE1 = new MahoganyTree1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> MAHOGANY_TREE2 = new MahoganyTree2(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> MAHOGANY_TREE3 = new MahoganyTree3(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> MAHOGANY_TREE4 = new MahoganyTree4(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> MAHOGANY_TREE5 = new MahoganyTree5(BYGTreeFeatureConfig.CODEC);

    //Woodlands
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> WOODLANDS_TREE1 = new WoodlandsTree1(BYGTreeFeatureConfig.CODEC);

    //Willow
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> WILLOW_DEAD_TREE1 = new WillowDeadTree1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> WILLOW_M_TREE1 = new WillowTreeM1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> WILLOW_M_TREE2 = new WillowTreeM2(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> WILLOW_TREE1 = new WillowTree1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> WILLOW_TREE2 = new WillowTree2(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> WILLOW_TREE3 = new WillowTree3(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> WILLOW_TREE4 = new WillowTree4(BYGTreeFeatureConfig.CODEC);

    //Zelkova
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ZELKOVA_TREE1 = new ZelkovaTree1(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ZELKOVA_TREE2 = new ZelkovaTree2(BYGTreeFeatureConfig.CODEC);
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ZELKOVA_TREE3 = new ZelkovaTree3(BYGTreeFeatureConfig.CODEC);


    public static class RegisterFeatures {
        public static void registerBYGFeatures() {
            registerFeature(DUMMY_TREE, "dummy_tree");
            registerFeature(POINTY_ROCK, "dead_sea_spike");
            registerFeature(STACKABLE_BOULDERS, "stacked_boulder");
            registerFeature(OBBYSPIKES, "obsidian_spike");
            registerFeature(CACTUS, "canyon_cactus");
            registerFeature(CHAINS, "chains");
            registerFeature(BLACKICESNOW, "black_ice_and_snow");
            registerFeature(LAKE_FROST, "frosted_lake");
            registerFeature(LAKE_WIDE_SHALLOW, "lake_wide_shallow");
            registerFeature(LAKE_LAVA_WIDE_SHALLOW, "lava_lake_wide_shallow");
            registerFeature(VINES, "vines");
            registerFeature(LARGE_PUMPKIN1, "pumpkin");
            registerFeature(LARGE_PUMPKIN2, "pumpkin2");
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
            registerFeature(SOUL_SHROOM_SPORES_HANGING, "hanging_soul_shroom_spore_feature");
            registerFeature(SOUL_SHROOM_TREE1, "soul_shroom_tree1");
            registerFeature(SOUL_SHROOM_TREE2, "soul_shroom_tree2");
            registerFeature(SOUL_SHROOM_TREE3, "soul_shroom_tree3");
            registerFeature(DEATH_CAP_TREE1, "death_cap_tree1");
            registerFeature(DEATH_CAP_TREE2, "death_cap_tree2");
            registerFeature(DEATH_CAP_TREE3, "death_cap_tree3");
            registerFeature(LAMENT_TWISTY_TREE1, "lament_twisty_tree1");
            registerFeature(LAMENT_TWISTY_TREE2, "lament_twisty_tree2");
            registerFeature(LAMENT_TWISTY_TREE3, "lament_twisty_tree3");
            registerFeature(LAMENT_WEEPING_TREE1, "lament_weeping_tree1");
            registerFeature(LAMENT_WEEPING_TREE2, "lament_weeping_tree2");
            registerFeature(LAMENT_WEEPING_TREE3, "lament_weeping_tree3");
            registerFeature(WITHERING_OAK_TREE1, "withering_oak_tree1");
            registerFeature(WITHERING_OAK_TREE2, "withering_oak_tree2");
            registerFeature(WITHERING_OAK_TREE3, "withering_oak_tree3");
            registerFeature(WITHERING_OAK_TREE4, "withering_oak_tree4");
            registerFeature(SYTHIAN_SPROUT, "sythian_sprout");
            registerFeature(SYTHIAN_STALK, "sythian_stalk");
            registerFeature(SYTHIAN_ROOTS, "sythian_roots");
            registerFeature(SYTHIAN_FUNGUS, "sythian_fungus");
            registerFeature(SYTHIAN_FUNGUS_TREE1, "sythian_fungus_tree1");
            registerFeature(SYTHIAN_FUNGUS_TREE2, "sythian_fungus_tree2");
            registerFeature(SYTHIAN_FUNGUS_TREE3, "sythian_fungus_tree3");
            registerFeature(SYTHIAN_FUNGUS_TREE4, "sythian_fungus_tree4");
            registerFeature(SYTHIAN_FUNGUS_PILLARS, "sythian_fungus_pillars");
            registerFeature(SYTHIAN_HANGING_ROOTS, "hanging_sythian_roots_feature");
            registerFeature(MOSSY_NETHERRACK_PILLARS, "mossy_netherrack_pillars");
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
            registerFeature(EMBUR_SPROUTS, "embur_sprouts");
            registerFeature(EMBUR_WART, "embur_wart");
            registerFeature(EMBUR_LILY, "embur_lily");
            registerFeature(FROST_MAGMA_PILLARS, "frost_magma_pillars");
            registerFeature(MAGMA_PILLARS, "magma_pillars");
            registerFeature(BRIMSTONE_PILLARS, "brimstone_pillars");
            registerFeature(ARAUCARIA_TREE1, "araucaria_tree1");
            registerFeature(ARAUCARIA_TREE2, "araucaria_tree2");
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
            registerFeature(BASIC_TREE, "brown_birch_tree1");
            registerFeature(BLUFF_TREE1, "bluff_tree1");
            registerFeature(BLUFF_TREE2, "bluff_tree2");
            registerFeature(BLUFF_TREE3, "bluff_tree3");
            registerFeature(BOREAL_TREE1, "boreal_tree1");
            registerFeature(BOREAL_TREE2, "boreal_tree2");
            registerFeature(CHERRY_TREE1, "pink_cherry_tree1");
            registerFeature(CHERRY_TREE2, "pink_cherry_tree2");
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
            registerFeature(DECIDUOUS_TREE1, "deciduous_tree1");
            registerFeature(DECIDUOUS_TREE2, "deciduous_tree2");
            registerFeature(DECIDUOUS_TREE3, "deciduous_tree3");
            registerFeature(DECIDUOUS_TREE4, "deciduous_tree4");
            registerFeature(EBONY_BUSH1, "ebony_bush1");
            registerFeature(EBONY_TREE1, "ebony_tree1");
            registerFeature(EBONY_TREE2, "ebony_tree2");
            registerFeature(ENCHANTED_TREE1, "blue_enchanted_tree1");
            registerFeature(ENCHANTED_TREE2, "blue_enchanted_tree2");
            registerFeature(ENCHANTED_TREE3, "blue_enchanted_tree3");
            registerFeature(ENCHANTED_GROVE_TREE1, "blue_enchanted_grove_tree1");
            registerFeature(HOLLY_TREE1, "holly_tree1");
            registerFeature(HOLLY_TREE2, "holly_tree2");
            registerFeature(HOLLY_TREE3, "holly_tree3");
            registerFeature(HOLLY_TREE4, "holly_tree4");
            registerFeature(JACARANDA_TREE1, "jacaranda_tree1");
            registerFeature(JACARANDA_TREE2, "jacaranda_tree2");
            registerFeature(JOSHUA_TREE1, "joshua_tree1");
            registerFeature(JOSHUA_TREE2, "joshua_tree2");
            registerFeature(MANGROVE_TREE1, "mangrove_tree1");
            registerFeature(MANGROVE_TREE2, "mangrove_tree2");
            registerFeature(MANGROVE_TREE3, "mangrove_tree3");
            registerFeature(MANGROVE_TREE4, "mangrove_tree4");
            registerFeature(MANGROVE_TREE5, "mangrove_tree5");
            registerFeature(MAPLE_TREE2, "red_maple_tree1");
            registerFeature(MAPLE_TREE3, "red_maple_tree2");
            registerFeature(MAPLE_TREE1, "maple_tree1");
            registerFeature(MEADOW_TREE1, "meadow_tree1");
            registerFeature(MEADOW_TREE2, "meadow_tree2");
            registerFeature(MEADOW_TREE3, "meadow_tree3");
            registerFeature(ORCHARD_TREE1, "orchard_tree1");
            registerFeature(ORCHARD_TREE2, "orchard_tree2");
            registerFeature(ORCHARD_TREE3, "orchard_tree3");
            registerFeature(PALM_TREE1, "palm_tree1");
            registerFeature(PALM_TREE2, "palm_tree2");
            registerFeature(PALM_TREE3, "palm_tree3");
            registerFeature(PALM_TREE4, "palm_tree4");
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
            registerFeature(SCORCHED_BUSH, "scorched_bush");
            registerFeature(SCORCHED_GRASS, "scorched_grass");
            registerFeature(SHRUB1, "meadow_shrub1");
            registerFeature(SHRUB2, "meadow_shrub2");
            registerFeature(SKYRIS_TREE1, "skyris_tree1");
            registerFeature(SKYRIS_TREE2, "skyris_tree2");
            registerFeature(SKYRIS_TREE3, "skyris_tree3");
            registerFeature(SKYRIS_TREE4, "skyris_tree4");
            registerFeature(SKYRIS_TREE5, "skyris_tree5");
            registerFeature(SPRUCE_TREE1, "spruce_tree1");
            registerFeature(SPRUCE_TREE2, "spruce_tree2");
            registerFeature(SPRUCE_TREE3, "spruce_tree3");
            registerFeature(SPRUCE_TREE4, "spruce_tree4");
            registerFeature(SPRUCE_TREE_MEDIUM1, "spruce_tree_medium1");
            registerFeature(SPRUCE_TREE_MEDIUM2, "spruce_tree_medium2");
            registerFeature(SPRUCE_TREE_MEDIUM3, "spruce_tree_medium3");
            registerFeature(SPRUCE_TREE_MEDIUM4, "spruce_tree_medium4");
            registerFeature(SPRUCE_TREE_LARGE1, "spruce_tree_large1");
            registerFeature(TROPICAL_SHORT_TREE1, "tropical_short_tree1");
            registerFeature(TROPICAL_SHRUB1, "tropical_shrub1");
            registerFeature(MAHOGANY_TREE1, "mahogany_tree1");
            registerFeature(MAHOGANY_TREE2, "mahogany_tree2");
            registerFeature(MAHOGANY_TREE3, "mahogany_tree3");
            registerFeature(MAHOGANY_TREE4, "mahogany_tree4");
            registerFeature(MAHOGANY_TREE5, "mahogany_tree5");
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


