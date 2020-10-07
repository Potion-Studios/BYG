package corgiaoc.byg.core.world;

import corgiaoc.byg.common.world.feature.overworld.RiverThingy;
import corgiaoc.byg.common.world.feature.config.*;
import corgiaoc.byg.common.world.feature.end.obsidianspires.ObsidianSpike;
import corgiaoc.byg.common.world.feature.nether.LargeChain;
import corgiaoc.byg.common.world.feature.nether.brimstonecaverns.BrimstonePillars;
import corgiaoc.byg.common.world.feature.nether.crimsongardens.CrimsonBerryBush;
import corgiaoc.byg.common.world.feature.nether.crimsongardens.TallCrimsonRoots;
import corgiaoc.byg.common.world.feature.nether.crimsongardens.WeepingVineFeatureBlackstone;
import corgiaoc.byg.common.world.feature.nether.emburbog.*;
import corgiaoc.byg.common.world.feature.nether.glowstonegardens.*;
import corgiaoc.byg.common.world.feature.nether.magmawastes.MagmaPillars;
import corgiaoc.byg.common.world.feature.nether.quartzdesert.HangingBoneFeature;
import corgiaoc.byg.common.world.feature.nether.quartzdesert.QuartzCrystals;
import corgiaoc.byg.common.world.feature.nether.quartzdesert.RawQuartzColumnFeature;
import corgiaoc.byg.common.world.feature.nether.soulsandvalley.SoulShroomSporeFeature;
import corgiaoc.byg.common.world.feature.nether.subzerohypo.FrostMagmaPillars;
import corgiaoc.byg.common.world.feature.nether.sythiantorrids.*;
import corgiaoc.byg.common.world.feature.nether.trees.lament.*;
import corgiaoc.byg.common.world.feature.nether.trees.withering.WitheringOakTree1;
import corgiaoc.byg.common.world.feature.nether.trees.withering.WitheringOakTree2;
import corgiaoc.byg.common.world.feature.nether.trees.withering.WitheringOakTree3;
import corgiaoc.byg.common.world.feature.nether.trees.withering.WitheringOakTree4;
import corgiaoc.byg.common.world.feature.nether.wailinggarth.ScorchedBush;
import corgiaoc.byg.common.world.feature.nether.wailinggarth.ScorchedGrass;
import corgiaoc.byg.common.world.feature.nether.wailinggarth.WailingGrass;
import corgiaoc.byg.common.world.feature.nether.wailinggarth.WailingVine;
import corgiaoc.byg.common.world.feature.nether.warpeddesert.*;
import corgiaoc.byg.common.world.feature.nether.weepingmire.LamentSprouts;
import corgiaoc.byg.common.world.feature.nether.weepingmire.LamentVineFeature;
import corgiaoc.byg.common.world.feature.overworld.*;
import corgiaoc.byg.common.world.feature.overworld.giantflowers.AngelicaGiant;
import corgiaoc.byg.common.world.feature.overworld.giantflowers.DandelionGiant;
import corgiaoc.byg.common.world.feature.overworld.giantflowers.IrisGiant;
import corgiaoc.byg.common.world.feature.overworld.giantflowers.RoseGiant;
import corgiaoc.byg.common.world.feature.overworld.giantflowers.util.BYGAbstractGiantFlowerFeature;
import corgiaoc.byg.common.world.feature.overworld.mushrooms.*;
import corgiaoc.byg.common.world.feature.overworld.mushrooms.util.BYGAbstractMushroomFeature;
import corgiaoc.byg.common.world.feature.overworld.pumpkins.LargePumpkin1;
import corgiaoc.byg.common.world.feature.overworld.pumpkins.LargePumpkin2;
import corgiaoc.byg.common.world.feature.overworld.trees.acacia.AcaciaTree1;
import corgiaoc.byg.common.world.feature.overworld.trees.ancient.AncientTree1;
import corgiaoc.byg.common.world.feature.overworld.trees.ancient.AncientTree2;
import corgiaoc.byg.common.world.feature.overworld.trees.ancient.AncientTree3;
import corgiaoc.byg.common.world.feature.overworld.trees.araucaria.AraucariaTree1;
import corgiaoc.byg.common.world.feature.overworld.trees.araucaria.AraucariaTree2;
import corgiaoc.byg.common.world.feature.overworld.trees.aspen.*;
import corgiaoc.byg.common.world.feature.overworld.trees.baobab.BaobabTree1;
import corgiaoc.byg.common.world.feature.overworld.trees.birch.BasicTree;
import corgiaoc.byg.common.world.feature.overworld.trees.bluff.BluffTree;
import corgiaoc.byg.common.world.feature.overworld.trees.bluff.BluffTree2;
import corgiaoc.byg.common.world.feature.overworld.trees.bluff.BluffTree3;
import corgiaoc.byg.common.world.feature.overworld.trees.boreal.BorealForestTree1;
import corgiaoc.byg.common.world.feature.overworld.trees.boreal.BorealForestTree2;
import corgiaoc.byg.common.world.feature.overworld.trees.cherry.CherryTree1;
import corgiaoc.byg.common.world.feature.overworld.trees.cherry.CherryTree2;
import corgiaoc.byg.common.world.feature.overworld.trees.cika.CikaTree1;
import corgiaoc.byg.common.world.feature.overworld.trees.cika.CikaTree2;
import corgiaoc.byg.common.world.feature.overworld.trees.cika.CikaTree3;
import corgiaoc.byg.common.world.feature.overworld.trees.coniferous.*;
import corgiaoc.byg.common.world.feature.overworld.trees.cypress.CypressTree1;
import corgiaoc.byg.common.world.feature.overworld.trees.cypress.CypressTree2;
import corgiaoc.byg.common.world.feature.overworld.trees.cypress.CypressTree3;
import corgiaoc.byg.common.world.feature.overworld.trees.deadhazel.DeadHazel1;
import corgiaoc.byg.common.world.feature.overworld.trees.deadhazel.DeadHazel2;
import corgiaoc.byg.common.world.feature.overworld.trees.deadhazel.DeadHazel3;
import corgiaoc.byg.common.world.feature.overworld.trees.deadhazel.DeadHazel4;
import corgiaoc.byg.common.world.feature.overworld.trees.deciduous.DeciduousTree1;
import corgiaoc.byg.common.world.feature.overworld.trees.deciduous.DeciduousTree2;
import corgiaoc.byg.common.world.feature.overworld.trees.deciduous.DeciduousTree3;
import corgiaoc.byg.common.world.feature.overworld.trees.deciduous.DeciduousTree4;
import corgiaoc.byg.common.world.feature.overworld.trees.ebony.EbonyBush1;
import corgiaoc.byg.common.world.feature.overworld.trees.ebony.EbonyTree1;
import corgiaoc.byg.common.world.feature.overworld.trees.ebony.EbonyTree2;
import corgiaoc.byg.common.world.feature.overworld.trees.enchanted.EnchantedGroveTree;
import corgiaoc.byg.common.world.feature.overworld.trees.enchanted.EnchantedTree1;
import corgiaoc.byg.common.world.feature.overworld.trees.enchanted.EnchantedTree2;
import corgiaoc.byg.common.world.feature.overworld.trees.enchanted.EnchantedTree3;
import corgiaoc.byg.common.world.feature.overworld.trees.holly.HollyTree1;
import corgiaoc.byg.common.world.feature.overworld.trees.holly.HollyTree2;
import corgiaoc.byg.common.world.feature.overworld.trees.holly.HollyTree3;
import corgiaoc.byg.common.world.feature.overworld.trees.holly.HollyTree4;
import corgiaoc.byg.common.world.feature.overworld.trees.jacaranda.JacarandaTree1;
import corgiaoc.byg.common.world.feature.overworld.trees.jacaranda.JacarandaTree2;
import corgiaoc.byg.common.world.feature.overworld.trees.joshua.JoshuaTree1;
import corgiaoc.byg.common.world.feature.overworld.trees.joshua.JoshuaTree2;
import corgiaoc.byg.common.world.feature.overworld.trees.mahogany.*;
import corgiaoc.byg.common.world.feature.overworld.trees.mangrove.*;
import corgiaoc.byg.common.world.feature.overworld.trees.maple.MapleTree1;
import corgiaoc.byg.common.world.feature.overworld.trees.maple.MapleTree2;
import corgiaoc.byg.common.world.feature.overworld.trees.maple.MapleTree3;
import corgiaoc.byg.common.world.feature.overworld.trees.meadow.*;
import corgiaoc.byg.common.world.feature.overworld.trees.orchard.OrchardTree1;
import corgiaoc.byg.common.world.feature.overworld.trees.orchard.OrchardTree2;
import corgiaoc.byg.common.world.feature.overworld.trees.orchard.OrchardTree3;
import corgiaoc.byg.common.world.feature.overworld.trees.palm.PalmTree1;
import corgiaoc.byg.common.world.feature.overworld.trees.palm.PalmTree2;
import corgiaoc.byg.common.world.feature.overworld.trees.palm.PalmTree3;
import corgiaoc.byg.common.world.feature.overworld.trees.palm.PalmTree4;
import corgiaoc.byg.common.world.feature.overworld.trees.palo_verde.PaloVerdeTree;
import corgiaoc.byg.common.world.feature.overworld.trees.palo_verde.PaloVerdeTree2;
import corgiaoc.byg.common.world.feature.overworld.trees.pine.*;
import corgiaoc.byg.common.world.feature.overworld.trees.rainbow_eucalyptus.LargeRainbowEucalyptus;
import corgiaoc.byg.common.world.feature.overworld.trees.rainbow_eucalyptus.RainbowEucalyptusTree;
import corgiaoc.byg.common.world.feature.overworld.trees.redwood.RedwoodTree1;
import corgiaoc.byg.common.world.feature.overworld.trees.redwood.RedwoodTree2;
import corgiaoc.byg.common.world.feature.overworld.trees.redwood.RedwoodTree3;
import corgiaoc.byg.common.world.feature.overworld.trees.skyris.*;
import corgiaoc.byg.common.world.feature.overworld.trees.spruce.giant.SpruceTreeLarge1;
import corgiaoc.byg.common.world.feature.overworld.trees.spruce.medium.SpruceTreeMedium1;
import corgiaoc.byg.common.world.feature.overworld.trees.spruce.medium.SpruceTreeMedium2;
import corgiaoc.byg.common.world.feature.overworld.trees.spruce.medium.SpruceTreeMedium3;
import corgiaoc.byg.common.world.feature.overworld.trees.spruce.medium.SpruceTreeMedium4;
import corgiaoc.byg.common.world.feature.overworld.trees.spruce.small.SpruceTree1;
import corgiaoc.byg.common.world.feature.overworld.trees.spruce.small.SpruceTree2;
import corgiaoc.byg.common.world.feature.overworld.trees.spruce.small.SpruceTree3;
import corgiaoc.byg.common.world.feature.overworld.trees.spruce.small.SpruceTree4;
import corgiaoc.byg.common.world.feature.overworld.trees.tropical.ShortTropicalRainForestTree;
import corgiaoc.byg.common.world.feature.overworld.trees.tropical.TropicalShrub;
import corgiaoc.byg.common.world.feature.overworld.trees.util.BYGAbstractTreeFeature;
import corgiaoc.byg.common.world.feature.overworld.trees.willow.WillowTree1;
import corgiaoc.byg.common.world.feature.overworld.trees.willow.WillowTree2;
import corgiaoc.byg.common.world.feature.overworld.trees.willow.WillowTree3;
import corgiaoc.byg.common.world.feature.overworld.trees.willow.WillowTree4;
import corgiaoc.byg.common.world.feature.overworld.trees.willow.dead.WillowDeadTree1;
import corgiaoc.byg.common.world.feature.overworld.trees.willow.mutated.WillowTreeM1;
import corgiaoc.byg.common.world.feature.overworld.trees.willow.mutated.WillowTreeM2;
import corgiaoc.byg.common.world.feature.overworld.trees.woodlands.WoodlandsTree1;
import corgiaoc.byg.common.world.feature.overworld.trees.zelkova.ZelkovaTree1;
import corgiaoc.byg.common.world.feature.overworld.trees.zelkova.ZelkovaTree2;
import corgiaoc.byg.common.world.feature.overworld.trees.zelkova.ZelkovaTree3;
import corgiaoc.byg.common.world.feature.overworld.volcano.NoiseVolcano;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.world.gen.feature.*;


public class BYGFeatures {

    public static final Feature<NoFeatureConfig> DUMMY_TREE = WorldGenRegistrationHelper.createFeature("dummy_tree", new SmallPineTree(NoFeatureConfig.field_236558_a_));

    public static final Feature<NoFeatureConfig> HUH = WorldGenRegistrationHelper.createFeature("river_feature", new RiverThingy(NoFeatureConfig.field_236558_a_));
    public static final Feature<NoFeatureConfig> VOLCANO = WorldGenRegistrationHelper.createFeature("noise_volcano", new NoiseVolcano(NoFeatureConfig.field_236558_a_));
    public static final Feature<BYGBoulderFeatureConfig> STACKABLE_BOULDERS = WorldGenRegistrationHelper.createFeature("stacked_boulder", new StackableBoulders(BYGBoulderFeatureConfig.CODEC));

    /********************************************************************Features*************************************************************************/
    //DeadSea
    public static final Feature<PointyRockFeatureConfig> POINTY_ROCK = WorldGenRegistrationHelper.createFeature("point_rock", new PointyRockFeature(PointyRockFeatureConfig.CODEC));

    public static final Feature<NoFeatureConfig> OBBYSPIKES = WorldGenRegistrationHelper.createFeature("obsidian_spike", new ObsidianSpike(NoFeatureConfig.field_236558_a_));

    public static final Feature<NoFeatureConfig> CACTUS = WorldGenRegistrationHelper.createFeature("canyon_cactus", new CanyonCactus(NoFeatureConfig.field_236558_a_));
    public static final Feature<NoFeatureConfig> BLACK_ICE_SNOW = WorldGenRegistrationHelper.createFeature("black_ice_and_snow", new BlackIceAndSnowFeature(NoFeatureConfig.field_236558_a_));

    //Lakes
    public static final Feature<BlockStateFeatureConfig> FROSTED_LAKE = WorldGenRegistrationHelper.createFeature("frosted_lake", new FrostMagmaLakeFeature(BlockStateFeatureConfig.field_236455_a_));
    public static final Feature<NoFeatureConfig> LAKE_WIDE_SHALLOW = WorldGenRegistrationHelper.createFeature("lake_wide_shallow", new LakeWideShallow(NoFeatureConfig.field_236558_a_));
    public static final Feature<NoFeatureConfig> LAKE_LAVA_WIDE_SHALLOW = WorldGenRegistrationHelper.createFeature("lava_lake_wide_shallow", new LavaLakeWideShallow(NoFeatureConfig.field_236558_a_));
    //Vines
    public static final Feature<NoFeatureConfig> VINES = WorldGenRegistrationHelper.createFeature("vines", new VinePlacer(NoFeatureConfig.field_236558_a_));

    //Pumpkins
    public static final Feature<BYGPumpkinFeatureConfig> LARGE_PUMPKIN1 = WorldGenRegistrationHelper.createFeature("pumpkin", new LargePumpkin1(BYGPumpkinFeatureConfig.CODEC));
    public static final Feature<BYGPumpkinFeatureConfig> LARGE_PUMPKIN2 = WorldGenRegistrationHelper.createFeature("pumpkin2", new LargePumpkin2(BYGPumpkinFeatureConfig.CODEC));

    /*********************************************************************Large Flower Features***********************************************************/
    public static final BYGAbstractGiantFlowerFeature<BYGGiantFlowerFeatureConfig> GIANT_ANGELICA_FLOWER = WorldGenRegistrationHelper.createFeature("giant_angelica_flower", new AngelicaGiant(BYGGiantFlowerFeatureConfig.CODEC));
    public static final BYGAbstractGiantFlowerFeature<BYGGiantFlowerFeatureConfig> GIANT_DANDELION_FLOWER = WorldGenRegistrationHelper.createFeature("giant_dandelion_flower", new DandelionGiant(BYGGiantFlowerFeatureConfig.CODEC));
    public static final BYGAbstractGiantFlowerFeature<BYGGiantFlowerFeatureConfig> GIANT_IRIS_FLOWER = WorldGenRegistrationHelper.createFeature("giant_iris_flower", new IrisGiant(BYGGiantFlowerFeatureConfig.CODEC));
    public static final BYGAbstractGiantFlowerFeature<BYGGiantFlowerFeatureConfig> GIANT_ROSE_FLOWER = WorldGenRegistrationHelper.createFeature("giant_rose", new RoseGiant(BYGGiantFlowerFeatureConfig.CODEC));


    /*********************************************************************Large Mushroom Features*********************************************************/
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> GREEN_MUSHROOM_HUGE = WorldGenRegistrationHelper.createFeature("green_mushroom_huge", new GreenMushroomHuge(BYGMushroomFeatureConfig.CODEC));
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> WOOD_BLEWIT_HUGE = WorldGenRegistrationHelper.createFeature("wood_blewit_huge", new WoodBlewitHuge(BYGMushroomFeatureConfig.CODEC));
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> WEEPING_MILKCAP_HUGE = WorldGenRegistrationHelper.createFeature("weeping_milkcap_huge", new WeepingMilkcapHuge(BYGMushroomFeatureConfig.CODEC));
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> BLACK_PUFF_HUGE = WorldGenRegistrationHelper.createFeature("black_puff_huge", new BlackPuffHuge(BYGMushroomFeatureConfig.CODEC));
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> BLUE_GLOWSHROOM_HUGE = WorldGenRegistrationHelper.createFeature("blue_glowshroom_huge", new BlueGlowshroomHuge(BYGMushroomFeatureConfig.CODEC));
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> PURPLE_GLOWSHROOM_HUGE = WorldGenRegistrationHelper.createFeature("purple_glowshroom_huge", new PurpleGlowshroomHuge(BYGMushroomFeatureConfig.CODEC));

    /*********************************************************************Mini Mushroom Features*********************************************************/
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> MINI_GREEN_MUSHROOM = WorldGenRegistrationHelper.createFeature("mini_green_mushroom", new MiniGreenMushroom(BYGMushroomFeatureConfig.CODEC));
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> MINI_RED_MUSHROOM = WorldGenRegistrationHelper.createFeature("mini_red_mushroom", new MiniRedMushroom(BYGMushroomFeatureConfig.CODEC));
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> MINI_BROWN_MUSHROOM = WorldGenRegistrationHelper.createFeature("mini_brown_mushroom", new MiniBrownMushroom(BYGMushroomFeatureConfig.CODEC));
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> MINI_WEEPING_MILKCAP = WorldGenRegistrationHelper.createFeature("mini_weeping_milkcap", new MiniWeepingMilkcap(BYGMushroomFeatureConfig.CODEC));
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> MINI_BLACK_PUFF = WorldGenRegistrationHelper.createFeature("mini_black_puff", new MiniBlackPuff(BYGMushroomFeatureConfig.CODEC));
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> MINI_WOOD_BLEWIT = WorldGenRegistrationHelper.createFeature("mini_wood_blewit", new MiniWoodBlewit(BYGMushroomFeatureConfig.CODEC));

    /********************************************************************Nether Features********************************************************************/

    public static final Feature<NoFeatureConfig> BLACK_PUFF = WorldGenRegistrationHelper.createFeature("black_puff", new BlackPuffMushroom(NoFeatureConfig.field_236558_a_));
    public static final Feature<NoFeatureConfig> GREEN_MUSHROOM = WorldGenRegistrationHelper.createFeature("green_mushroom", new GreenMushroom(NoFeatureConfig.field_236558_a_));
    public static final Feature<NoFeatureConfig> NETHER_BRISTLE = WorldGenRegistrationHelper.createFeature("nether_bristle", new NetherBristle(NoFeatureConfig.field_236558_a_));

    //SoulShroom
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> SOUL_SHROOM_TREE1 = WorldGenRegistrationHelper.createFeature("soul_shroom_tree1", new SoulShroomTree1(BYGMushroomFeatureConfig.CODEC));
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> SOUL_SHROOM_TREE2 = WorldGenRegistrationHelper.createFeature("soul_shroom_tree2", new SoulShroomTree2(BYGMushroomFeatureConfig.CODEC));
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> SOUL_SHROOM_TREE3 = WorldGenRegistrationHelper.createFeature("soul_shroom_tree3", new SoulShroomTree3(BYGMushroomFeatureConfig.CODEC));
    public static final Feature<NoFeatureConfig> SOUL_SHROOM_SPORES_HANGING = WorldGenRegistrationHelper.createFeature("hanging_soul_shroom_spore_feature", new SoulShroomSporeFeature(NoFeatureConfig.field_236558_a_));

    //DeathCap
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> DEATH_CAP_TREE1 = WorldGenRegistrationHelper.createFeature("death_cap_tree1", new DeathCapTree1(BYGMushroomFeatureConfig.CODEC));
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> DEATH_CAP_TREE2 = WorldGenRegistrationHelper.createFeature("death_cap_tree2", new DeathCapTree2(BYGMushroomFeatureConfig.CODEC));
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> DEATH_CAP_TREE3 = WorldGenRegistrationHelper.createFeature("death_cap_tree3", new DeathCapTree3(BYGMushroomFeatureConfig.CODEC));

    //Lament
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> LAMENT_WEEPING_TREE1 = WorldGenRegistrationHelper.createFeature("lament_weeping_tree1", new LamentWeepingTree1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> LAMENT_WEEPING_TREE2 = WorldGenRegistrationHelper.createFeature("lament_weeping_tree2", new LamentWeepingTree2(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> LAMENT_WEEPING_TREE3 = WorldGenRegistrationHelper.createFeature("lament_weeping_tree3", new LamentWeepingTree3(BYGTreeFeatureConfig.CODEC));

    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> LAMENT_TWISTY_TREE1 = WorldGenRegistrationHelper.createFeature("lament_twisty_tree1", new LamentTwistyTree1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> LAMENT_TWISTY_TREE2 = WorldGenRegistrationHelper.createFeature("lament_twisty_tree2", new LamentTwistyTree2(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> LAMENT_TWISTY_TREE3 = WorldGenRegistrationHelper.createFeature("lament_twisty_tree3", new LamentTwistyTree3(BYGTreeFeatureConfig.CODEC));

    //Withering Oak
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> WITHERING_OAK_TREE1 = WorldGenRegistrationHelper.createFeature("withering_oak_tree1", new WitheringOakTree1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> WITHERING_OAK_TREE2 = WorldGenRegistrationHelper.createFeature("withering_oak_tree2", new WitheringOakTree2(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> WITHERING_OAK_TREE3 = WorldGenRegistrationHelper.createFeature("withering_oak_tree3", new WitheringOakTree3(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> WITHERING_OAK_TREE4 = WorldGenRegistrationHelper.createFeature("withering_oak_tree4", new WitheringOakTree4(BYGTreeFeatureConfig.CODEC));

    //QuartzDesert
    public static final Feature<NoFeatureConfig> HANGING_BONE_FEATURE = WorldGenRegistrationHelper.createFeature("hanging_bone_feature", new HangingBoneFeature(NoFeatureConfig.field_236558_a_));

    //Sythian
    public static final Feature<NoFeatureConfig> SYTHIAN_SPROUT = WorldGenRegistrationHelper.createFeature("sythian_sprout", new SythianSprout(NoFeatureConfig.field_236558_a_));
    public static final Feature<ProbabilityConfig> SYTHIAN_STALK = WorldGenRegistrationHelper.createFeature("sythian_stalk", new SythianStalk(ProbabilityConfig.field_236576_b_));
    public static final Feature<NoFeatureConfig> SYTHIAN_ROOTS = WorldGenRegistrationHelper.createFeature("sythian_roots", new SythianRoots(NoFeatureConfig.field_236558_a_));
    public static final Feature<NoFeatureConfig> SYTHIAN_FUNGUS = WorldGenRegistrationHelper.createFeature("sythian_fungus", new SythianFungus(NoFeatureConfig.field_236558_a_));
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> SYTHIAN_FUNGUS_TREE1 = WorldGenRegistrationHelper.createFeature("sythian_fungus_tree1", new SythianFungusTree1(BYGMushroomFeatureConfig.CODEC));
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> SYTHIAN_FUNGUS_TREE2 = WorldGenRegistrationHelper.createFeature("sythian_fungus_tree2", new SythianFungusTree2(BYGMushroomFeatureConfig.CODEC));
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> SYTHIAN_FUNGUS_TREE3 = WorldGenRegistrationHelper.createFeature("sythian_fungus_tree3", new SythianFungusTree3(BYGMushroomFeatureConfig.CODEC));
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> SYTHIAN_FUNGUS_TREE4 = WorldGenRegistrationHelper.createFeature("sythian_fungus_tree4", new SythianFungusTree4(BYGMushroomFeatureConfig.CODEC));
    public static final Feature<NoFeatureConfig> SYTHIAN_HANGING_ROOTS = WorldGenRegistrationHelper.createFeature("hanging_sythian_roots", new HangingSythianRootsFeature(NoFeatureConfig.field_236558_a_));
    public static final Feature<NoFeatureConfig> MOSSY_NETHERRACK_PILLARS = WorldGenRegistrationHelper.createFeature("mossy_netherrack_pillars", new MossyNetherrackPillars(NoFeatureConfig.field_236558_a_));
    public static final Feature<NoFeatureConfig> SYTHIAN_FUNGUS_PILLARS = WorldGenRegistrationHelper.createFeature("sythian_fungus_pillars", new SythianFungusPillars(NoFeatureConfig.field_236558_a_));

    //Warped
    public static final Feature<NoFeatureConfig> WARPED_BUSH = WorldGenRegistrationHelper.createFeature("warped_bush", new WarpedBush(NoFeatureConfig.field_236558_a_));
    public static final Feature<NoFeatureConfig> WARPED_CORAL = WorldGenRegistrationHelper.createFeature("warped_coral", new WarpedCoral(NoFeatureConfig.field_236558_a_));
    public static final Feature<NoFeatureConfig> HUGE_WARPED_CORAL_PLANT = WorldGenRegistrationHelper.createFeature("warped_coral_plant", new WarpedCoralFeature(NoFeatureConfig.field_236558_a_));
    public static final Feature<NoFeatureConfig> WARPED_CORAL_FAN = WorldGenRegistrationHelper.createFeature("warped_coral_fan", new WarpedCoralFan(NoFeatureConfig.field_236558_a_));
    public static final Feature<NoFeatureConfig> SOUL_SOIL_PILLARS = WorldGenRegistrationHelper.createFeature("soul_soil_pillars", new SoulSoilPillars(NoFeatureConfig.field_236558_a_));

    //Chains
    public static final Feature<NoFeatureConfig> CHAINS = WorldGenRegistrationHelper.createFeature("chains", new LargeChain(NoFeatureConfig.field_236558_a_));

    //Crimson Gardens
    public static final Feature<NoFeatureConfig> TALL_CRIMSON_ROOTS = WorldGenRegistrationHelper.createFeature("tall_crimson_roots", new TallCrimsonRoots(NoFeatureConfig.field_236558_a_));
    public static final Feature<NoFeatureConfig> CRIMSON_BERRY_BUSH = WorldGenRegistrationHelper.createFeature("crimson_berry_bush", new CrimsonBerryBush(NoFeatureConfig.field_236558_a_));
    public static final Feature<NoFeatureConfig> WEEPING_VINE_BLACKSTONE = WorldGenRegistrationHelper.createFeature("weeping_vine_blackstone", new WeepingVineFeatureBlackstone(NoFeatureConfig.field_236558_a_));
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> CRIMSON_FUNGUS_TREE1 = WorldGenRegistrationHelper.createFeature("crimson_fungus_tree1", new CrimsonFungus1(BYGMushroomFeatureConfig.CODEC));
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> CRIMSON_FUNGUS_TREE2 = WorldGenRegistrationHelper.createFeature("crimson_fungus_tree2", new CrimsonFungus2(BYGMushroomFeatureConfig.CODEC));
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> WARPED_FUNGUS_TREE1 = WorldGenRegistrationHelper.createFeature("warped_fungus_tree1", new WarpedFungus1(BYGMushroomFeatureConfig.CODEC));
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> WARPED_FUNGUS_TREE2 = WorldGenRegistrationHelper.createFeature("warped_fungus_tree2", new WarpedFungus2(BYGMushroomFeatureConfig.CODEC));

    //Whaling
    public static final Feature<NoFeatureConfig> WAILING_VINES = WorldGenRegistrationHelper.createFeature("wailing_vine", new WailingVine(NoFeatureConfig.field_236558_a_));
    public static final Feature<NoFeatureConfig> WAILING_GRASS = WorldGenRegistrationHelper.createFeature("wailing_grass", new WailingGrass(NoFeatureConfig.field_236558_a_));
    public static final Feature<NoFeatureConfig> SCORCHED_GRASS = WorldGenRegistrationHelper.createFeature("scorched_grass", new ScorchedGrass(NoFeatureConfig.field_236558_a_));
    public static final Feature<NoFeatureConfig> SCORCHED_BUSH = WorldGenRegistrationHelper.createFeature("scorched_bush", new ScorchedBush(NoFeatureConfig.field_236558_a_));

    public static final Feature<NoFeatureConfig> WOOD_BLEWIT = WorldGenRegistrationHelper.createFeature("wood_blewit", new WoodBlewitMushroom(NoFeatureConfig.field_236558_a_));

    public static final Feature<NoFeatureConfig> WEED_GRASS = WorldGenRegistrationHelper.createFeature("weed_grass", new WeedGrass(NoFeatureConfig.field_236558_a_));

    public static final Feature<NoFeatureConfig> WEEPING_MILKCAP = WorldGenRegistrationHelper.createFeature("weeping_milkcap", new WeepingMilkCapMushroom(NoFeatureConfig.field_236558_a_));

    //Weeping Roots
    public static final Feature<NoFeatureConfig> WEEPING_ROOTS = WorldGenRegistrationHelper.createFeature("weeping_roots", new WeepingRoots(NoFeatureConfig.field_236558_a_));
    public static final Feature<NoFeatureConfig> WEEPING_ROOTS_PLANT = WorldGenRegistrationHelper.createFeature("weeping_roots_plant", new WeepingRootsPlant(NoFeatureConfig.field_236558_a_));
    public static final Feature<NoFeatureConfig> WEEPING_ROOTS_FEATURE = WorldGenRegistrationHelper.createFeature("weeping_roots_feature", new WeepingRootsFeature(NoFeatureConfig.field_236558_a_));

    //Embur
    public static final Feature<NoFeatureConfig> EMBURLAKE = WorldGenRegistrationHelper.createFeature("embur_lake", new EmburBogLake(NoFeatureConfig.field_236558_a_));
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> EMBUR_MUSHROOM = WorldGenRegistrationHelper.createFeature("embur_mushroom1", new EmburMushroom(BYGMushroomFeatureConfig.CODEC));
    public static final BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> EMBUR_MUSHROOM2 = WorldGenRegistrationHelper.createFeature("embur_mushroom2", new EmburMushroom2(BYGMushroomFeatureConfig.CODEC));
    public static final Feature<NoFeatureConfig> EMBUR_GEL_VINES = WorldGenRegistrationHelper.createFeature("embur_gel_vines", new EmburGelVines(NoFeatureConfig.field_236558_a_));
    public static final Feature<NoFeatureConfig> EMBUR_ROOTS = WorldGenRegistrationHelper.createFeature("embur_roots", new EmburRoots(NoFeatureConfig.field_236558_a_));
    public static final Feature<NoFeatureConfig> TALL_EMBUR_ROOTS = WorldGenRegistrationHelper.createFeature("tall_embur_roots", new TallEmburRoots(NoFeatureConfig.field_236558_a_));
    public static final Feature<NoFeatureConfig> EMBUR_WART = WorldGenRegistrationHelper.createFeature("embur_wart", new EmburWart(NoFeatureConfig.field_236558_a_));
    public static final Feature<NoFeatureConfig> EMBUR_SPROUTS = WorldGenRegistrationHelper.createFeature("embur_sprouts", new EmburSprouts(NoFeatureConfig.field_236558_a_));
    public static final Feature<NoFeatureConfig> EMBUR_LILY = WorldGenRegistrationHelper.createFeature("embur_lily", new EmburLily(NoFeatureConfig.field_236558_a_));

    //Subzero Hypogeal
    public static final Feature<NoFeatureConfig> FROST_MAGMA_PILLARS = WorldGenRegistrationHelper.createFeature("frost_magma_pillars", new FrostMagmaPillars(NoFeatureConfig.field_236558_a_));

    //MagmaWastes
    public static final Feature<NoFeatureConfig> MAGMA_PILLARS = WorldGenRegistrationHelper.createFeature("magma_pillars", new MagmaPillars(NoFeatureConfig.field_236558_a_));

    //BrimstoneCaverns
    public static final Feature<NoFeatureConfig> BRIMSTONE_PILLARS = WorldGenRegistrationHelper.createFeature("brimstone_pillars", new BrimstonePillars(NoFeatureConfig.field_236558_a_));

    //QuartzDesert
    public static final Feature<ColumnConfig> QUARTZ_COLUMNS = WorldGenRegistrationHelper.createFeature("quartz_columns", new RawQuartzColumnFeature(ColumnConfig.CODEC));
    public static final Feature<NoFeatureConfig> QUARTZ_CRYSTAL = WorldGenRegistrationHelper.createFeature("quartz_crystal", new QuartzCrystals(NoFeatureConfig.field_236558_a_));

    //WeepingMire
    public static final Feature<NoFeatureConfig> LAMENT_SPROUTS = WorldGenRegistrationHelper.createFeature("lament_sprouts", new LamentSprouts(NoFeatureConfig.field_236558_a_));
    public static final Feature<NoFeatureConfig> LAMENT_VINE_FEATURE = WorldGenRegistrationHelper.createFeature("lament_vine_feature", new LamentVineFeature(NoFeatureConfig.field_236558_a_));


    /********************************************************************Structures***********************************************************************/


    /********************************************************************Tree Features********************************************************************/
    //Araucaria
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ARAUCARIA_TREE1 = WorldGenRegistrationHelper.createFeature("araucaria_tree1", new AraucariaTree1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ARAUCARIA_TREE2 = WorldGenRegistrationHelper.createFeature("araucaria_tree2", new AraucariaTree2(BYGTreeFeatureConfig.CODEC));

    //Acacia
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ACACIA_TREE1 = WorldGenRegistrationHelper.createFeature("acacia_tree1", new AcaciaTree1(BYGTreeFeatureConfig.CODEC));

    //Ancient
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ANCIENT_TREE1 = WorldGenRegistrationHelper.createFeature("ancient_tree1", new AncientTree1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ANCIENT_TREE2 = WorldGenRegistrationHelper.createFeature("ancient_tree2", new AncientTree2(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ANCIENT_TREE3 = WorldGenRegistrationHelper.createFeature("ancient_tree3", new AncientTree3(BYGTreeFeatureConfig.CODEC));

    //Aspen
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ASPEN_SHRUB1 = WorldGenRegistrationHelper.createFeature("aspen_shrub1", new AspenShrub(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ASPEN_SHRUB2 = WorldGenRegistrationHelper.createFeature("aspen_shrub2", new AspenShrub2(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ASPEN_TREE1 = WorldGenRegistrationHelper.createFeature("aspen_tree1", new AspenTree(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ASPEN_TREE2 = WorldGenRegistrationHelper.createFeature("aspen_tree2", new AspenTree2(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ASPEN_TREE3 = WorldGenRegistrationHelper.createFeature("aspen_tree3", new AspenTree3(BYGTreeFeatureConfig.CODEC));

    //Baobab Tree
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> BAOBAB_TREE1 = WorldGenRegistrationHelper.createFeature("baobab_tree1", new BaobabTree1(BYGTreeFeatureConfig.CODEC));

    //Birch
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> BASIC_TREE = WorldGenRegistrationHelper.createFeature("tree", new BasicTree(BYGTreeFeatureConfig.CODEC));


    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> BLUFF_TREE1 = WorldGenRegistrationHelper.createFeature("bluff_tree1", new BluffTree(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> BLUFF_TREE2 = WorldGenRegistrationHelper.createFeature("bluff_tree2", new BluffTree2(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> BLUFF_TREE3 = WorldGenRegistrationHelper.createFeature("bluff_tree3", new BluffTree3(BYGTreeFeatureConfig.CODEC));

    //Boreal Trees
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> BOREAL_TREE1 = WorldGenRegistrationHelper.createFeature("boreal_tree1", new BorealForestTree1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> BOREAL_TREE2 = WorldGenRegistrationHelper.createFeature("boreal_tree2", new BorealForestTree2(BYGTreeFeatureConfig.CODEC));

    //Cherry
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> CHERRY_TREE1 = WorldGenRegistrationHelper.createFeature("cherry_tree1", new CherryTree1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> CHERRY_TREE2 = WorldGenRegistrationHelper.createFeature("cherry_tree2", new CherryTree2(BYGTreeFeatureConfig.CODEC));

    //Cika
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> CIKA_TREE1 = WorldGenRegistrationHelper.createFeature("cika_tree1", new CikaTree1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> CIKA_TREE2 = WorldGenRegistrationHelper.createFeature("cika_tree2", new CikaTree2(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> CIKA_TREE3 = WorldGenRegistrationHelper.createFeature("cika_tree3", new CikaTree3(BYGTreeFeatureConfig.CODEC));

    //Coniferous
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> CONIFER_TREE1 = WorldGenRegistrationHelper.createFeature("conifer_tree1", new ConiferTree1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> CONIFER_TREE2 = WorldGenRegistrationHelper.createFeature("conifer_tree2", new ConiferTree2(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> CONIFER_TREE3 = WorldGenRegistrationHelper.createFeature("conifer_tree3", new ConiferTree3(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> CONIFER_TREE4 = WorldGenRegistrationHelper.createFeature("conifer_tree4", new ConiferTree4(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> CONIFER_TREE5 = WorldGenRegistrationHelper.createFeature("conifer_tree5", new ConiferTree5(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> CONIFER_TREE6 = WorldGenRegistrationHelper.createFeature("conifer_tree6", new ConiferTree6(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> CONIFER_TREE7 = WorldGenRegistrationHelper.createFeature("conifer_tree7", new ConiferTree7(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> CONIFER_TREE8 = WorldGenRegistrationHelper.createFeature("conifer_tree8", new ConiferTree8(BYGTreeFeatureConfig.CODEC));

    //Cypress
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> CYPRESS_TREE1 = WorldGenRegistrationHelper.createFeature("cypress_tree1", new CypressTree1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> CYPRESS_TREE2 = WorldGenRegistrationHelper.createFeature("cypress_tree2", new CypressTree2(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> CYPRESS_TREE3 = WorldGenRegistrationHelper.createFeature("cypress_tree3", new CypressTree3(BYGTreeFeatureConfig.CODEC));

    //Dead Hazel
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> DEAD_HAZEL_TREE1 = WorldGenRegistrationHelper.createFeature("dead_hazel_tree1", new DeadHazel1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> DEAD_HAZEL_TREE2 = WorldGenRegistrationHelper.createFeature("dead_hazel_tree2", new DeadHazel2(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> DEAD_HAZEL_TREE3 = WorldGenRegistrationHelper.createFeature("dead_hazel_tree3", new DeadHazel3(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> DEAD_HAZEL_TREE4 = WorldGenRegistrationHelper.createFeature("dead_hazel_tree4", new DeadHazel4(BYGTreeFeatureConfig.CODEC));

    //Deciduous
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> DECIDUOUS_TREE1 = WorldGenRegistrationHelper.createFeature("deciduous_tree1", new DeciduousTree1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> DECIDUOUS_TREE2 = WorldGenRegistrationHelper.createFeature("deciduous_tree2", new DeciduousTree2(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> DECIDUOUS_TREE3 = WorldGenRegistrationHelper.createFeature("deciduous_tree3", new DeciduousTree3(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> DECIDUOUS_TREE4 = WorldGenRegistrationHelper.createFeature("deciduous_tree4", new DeciduousTree4(BYGTreeFeatureConfig.CODEC));

    //Ebony
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> EBONY_BUSH1 = WorldGenRegistrationHelper.createFeature("ebony_bush", new EbonyBush1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> EBONY_TREE1 = WorldGenRegistrationHelper.createFeature("ebony_tree1", new EbonyTree1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> EBONY_TREE2 = WorldGenRegistrationHelper.createFeature("ebony_tree2", new EbonyTree2(BYGTreeFeatureConfig.CODEC));

    //Enchanted Trees
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ENCHANTED_TREE1 = WorldGenRegistrationHelper.createFeature("enchanted_tree1", new EnchantedTree1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ENCHANTED_TREE2 = WorldGenRegistrationHelper.createFeature("enchanted_tree2", new EnchantedTree3(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ENCHANTED_TREE3 = WorldGenRegistrationHelper.createFeature("enchanted_tree3", new EnchantedTree2(BYGTreeFeatureConfig.CODEC));

    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ENCHANTED_GROVE_TREE1 = WorldGenRegistrationHelper.createFeature("enchanted_grove_tree1", new EnchantedGroveTree(BYGTreeFeatureConfig.CODEC));

    //Holly
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> HOLLY_TREE1 = WorldGenRegistrationHelper.createFeature("holly_tree1", new HollyTree1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> HOLLY_TREE2 = WorldGenRegistrationHelper.createFeature("holly_tree2", new HollyTree2(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> HOLLY_TREE3 = WorldGenRegistrationHelper.createFeature("holly_tree3", new HollyTree3(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> HOLLY_TREE4 = WorldGenRegistrationHelper.createFeature("holly_tree4", new HollyTree4(BYGTreeFeatureConfig.CODEC));

    //Jacaranda
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> JACARANDA_TREE1 = WorldGenRegistrationHelper.createFeature("jacaranda_tree1", new JacarandaTree1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> JACARANDA_TREE2 = WorldGenRegistrationHelper.createFeature("jacaranda_tree2", new JacarandaTree2(BYGTreeFeatureConfig.CODEC));

    //JoshuaTree
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> JOSHUA_TREE1 = WorldGenRegistrationHelper.createFeature("joshua_tree1", new JoshuaTree1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> JOSHUA_TREE2 = WorldGenRegistrationHelper.createFeature("joshua_tree2", new JoshuaTree2(BYGTreeFeatureConfig.CODEC));

    //Mangrove
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> MANGROVE_TREE1 = WorldGenRegistrationHelper.createFeature("mangrove_tree1", new MangroveTree1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> MANGROVE_TREE2 = WorldGenRegistrationHelper.createFeature("mangrove_tree2", new MangroveTree2(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> MANGROVE_TREE3 = WorldGenRegistrationHelper.createFeature("mangrove_tree3", new MangroveTree3(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> MANGROVE_TREE4 = WorldGenRegistrationHelper.createFeature("mangrove_tree4", new MangroveTree4(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> MANGROVE_TREE5 = WorldGenRegistrationHelper.createFeature("mangrove_tree5", new MangroveTree5(BYGTreeFeatureConfig.CODEC));

    //Maple
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> MAPLE_TREE1 = WorldGenRegistrationHelper.createFeature("maple_tree1", new MapleTree1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> MAPLE_TREE2 = WorldGenRegistrationHelper.createFeature("maple_tree2", new MapleTree2(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> MAPLE_TREE3 = WorldGenRegistrationHelper.createFeature("maple_tree3", new MapleTree3(BYGTreeFeatureConfig.CODEC));

    //Meadow
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> MEADOW_TREE1 = WorldGenRegistrationHelper.createFeature("meadow_tree1", new MeadowTree1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> MEADOW_TREE2 = WorldGenRegistrationHelper.createFeature("meadow_tree2", new MeadowTree2(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> MEADOW_TREE3 = WorldGenRegistrationHelper.createFeature("meadow_tree3", new MeadowTree3(BYGTreeFeatureConfig.CODEC));

    //Orchard
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ORCHARD_TREE1 = WorldGenRegistrationHelper.createFeature("orchard_tree1", new OrchardTree1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ORCHARD_TREE2 = WorldGenRegistrationHelper.createFeature("orchard_tree2", new OrchardTree2(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ORCHARD_TREE3 = WorldGenRegistrationHelper.createFeature("orchard_tree3", new OrchardTree3(BYGTreeFeatureConfig.CODEC));

    //Palm
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> PALM_TREE1 = WorldGenRegistrationHelper.createFeature("palm_tree1", new PalmTree1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> PALM_TREE2 = WorldGenRegistrationHelper.createFeature("palm_tree2", new PalmTree2(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> PALM_TREE3 = WorldGenRegistrationHelper.createFeature("palm_tree3", new PalmTree3(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> PALM_TREE4 = WorldGenRegistrationHelper.createFeature("palm_tree4", new PalmTree4(BYGTreeFeatureConfig.CODEC));

    //Pine
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> PINE_LARGE_TREE1 = WorldGenRegistrationHelper.createFeature("large_pine_tree1", new LargePineTree1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> PINE_LARGE_TREE2 = WorldGenRegistrationHelper.createFeature("large_pine_tree2", new LargePineTree2(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> PINE_TREE1 = WorldGenRegistrationHelper.createFeature("pine_tree1", new PineTree1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> PINE_TREE2 = WorldGenRegistrationHelper.createFeature("pine_tree2", new PineTree2(BYGTreeFeatureConfig.CODEC));

    //Palo Verde
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> PALO_VERDE_TREE1 = WorldGenRegistrationHelper.createFeature("palo_verde_tree1", new PaloVerdeTree(BYGTreeFeatureConfig.CODEC, 0));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> PALO_VERDE_TREE2 = WorldGenRegistrationHelper.createFeature("palo_verde_tree2", new PaloVerdeTree2(BYGTreeFeatureConfig.CODEC, 0));

    //Rainbow Eucalyptus
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> RAINBOW_TREE1 = WorldGenRegistrationHelper.createFeature("rainbow_eucalyptus_tree", new RainbowEucalyptusTree(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> RAINBOW_LARGE_TREE1 = WorldGenRegistrationHelper.createFeature("large_rainbow_eucalyptus_tree", new LargeRainbowEucalyptus(BYGTreeFeatureConfig.CODEC));

    //RedWood
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> REDWOOD_TREE1 = WorldGenRegistrationHelper.createFeature("redwood_tree1", new RedwoodTree1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> REDWOOD_TREE2 = WorldGenRegistrationHelper.createFeature("redwood_tree2", new RedwoodTree2(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> REDWOOD_TREE3 = WorldGenRegistrationHelper.createFeature("redwood_tree3", new RedwoodTree3(BYGTreeFeatureConfig.CODEC));

    //Shrubs
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> SHRUB1 = WorldGenRegistrationHelper.createFeature("shrub1", new Shrub1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> SHRUB2 = WorldGenRegistrationHelper.createFeature("shrub2", new Shrub2(BYGTreeFeatureConfig.CODEC));
    //Skyris
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> SKYRIS_TREE1 = WorldGenRegistrationHelper.createFeature("skyris_tree1", new SkyrisTree1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> SKYRIS_TREE2 = WorldGenRegistrationHelper.createFeature("skyris_tree2", new SkyrisTree2(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> SKYRIS_TREE3 = WorldGenRegistrationHelper.createFeature("skyris_tree3", new SkyrisTree3(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> SKYRIS_TREE4 = WorldGenRegistrationHelper.createFeature("skyris_tree4", new SkyrisTree4(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> SKYRIS_TREE5 = WorldGenRegistrationHelper.createFeature("skyris_tree5", new SkyrisTree5(BYGTreeFeatureConfig.CODEC));

    //Spruce
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> SPRUCE_TREE_LARGE1 = WorldGenRegistrationHelper.createFeature("large_spruce_tree1", new SpruceTreeLarge1(BYGTreeFeatureConfig.CODEC));

    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> SPRUCE_TREE_MEDIUM1 = WorldGenRegistrationHelper.createFeature("medium_spruce_tree1", new SpruceTreeMedium1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> SPRUCE_TREE_MEDIUM2 = WorldGenRegistrationHelper.createFeature("medium_spruce_tree2", new SpruceTreeMedium2(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> SPRUCE_TREE_MEDIUM3 = WorldGenRegistrationHelper.createFeature("medium_spruce_tree3", new SpruceTreeMedium3(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> SPRUCE_TREE_MEDIUM4 = WorldGenRegistrationHelper.createFeature("medium_spruce_tree4", new SpruceTreeMedium4(BYGTreeFeatureConfig.CODEC));

    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> SPRUCE_TREE1 = WorldGenRegistrationHelper.createFeature("spruce_tree1", new SpruceTree1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> SPRUCE_TREE2 = WorldGenRegistrationHelper.createFeature("spruce_tree2", new SpruceTree2(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> SPRUCE_TREE3 = WorldGenRegistrationHelper.createFeature("spruce_tree3", new SpruceTree3(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> SPRUCE_TREE4 = WorldGenRegistrationHelper.createFeature("spruce_tree4", new SpruceTree4(BYGTreeFeatureConfig.CODEC));

    //Tropical
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> TROPICAL_SHORT_TREE1 = WorldGenRegistrationHelper.createFeature("short_tropical_tree", new ShortTropicalRainForestTree(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> TROPICAL_SHRUB1 = WorldGenRegistrationHelper.createFeature("tropical_shrub", new TropicalShrub(BYGTreeFeatureConfig.CODEC));

    //Mahogany
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> MAHOGANY_TREE1 = WorldGenRegistrationHelper.createFeature("mahogany_tree1", new MahoganyTree1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> MAHOGANY_TREE2 = WorldGenRegistrationHelper.createFeature("mahogany_tree2", new MahoganyTree2(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> MAHOGANY_TREE3 = WorldGenRegistrationHelper.createFeature("mahogany_tree3", new MahoganyTree3(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> MAHOGANY_TREE4 = WorldGenRegistrationHelper.createFeature("mahogany_tree4", new MahoganyTree4(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> MAHOGANY_TREE5 = WorldGenRegistrationHelper.createFeature("mahogany_tree5", new MahoganyTree5(BYGTreeFeatureConfig.CODEC));

    //Woodlands
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> WOODLANDS_TREE1 = WorldGenRegistrationHelper.createFeature("woodlands_tree", new WoodlandsTree1(BYGTreeFeatureConfig.CODEC));

    //Willow
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> WILLOW_DEAD_TREE1 = WorldGenRegistrationHelper.createFeature("dead_willow_tree", new WillowDeadTree1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> WILLOW_M_TREE1 = WorldGenRegistrationHelper.createFeature("mutated_willow_tree1", new WillowTreeM1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> WILLOW_M_TREE2 = WorldGenRegistrationHelper.createFeature("mutated_willow_tree2", new WillowTreeM2(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> WILLOW_TREE1 = WorldGenRegistrationHelper.createFeature("willow_tree1", new WillowTree1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> WILLOW_TREE2 = WorldGenRegistrationHelper.createFeature("willow_tree2", new WillowTree2(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> WILLOW_TREE3 = WorldGenRegistrationHelper.createFeature("willow_tree3", new WillowTree3(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> WILLOW_TREE4 = WorldGenRegistrationHelper.createFeature("willow_tree4", new WillowTree4(BYGTreeFeatureConfig.CODEC));

    //Zelkova
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ZELKOVA_TREE1 = WorldGenRegistrationHelper.createFeature("zelkova_tree1", new ZelkovaTree1(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ZELKOVA_TREE2 = WorldGenRegistrationHelper.createFeature("zelkova_tree2", new ZelkovaTree2(BYGTreeFeatureConfig.CODEC));
    public static final BYGAbstractTreeFeature<BYGTreeFeatureConfig> ZELKOVA_TREE3 = WorldGenRegistrationHelper.createFeature("zelkova_tree3", new ZelkovaTree3(BYGTreeFeatureConfig.CODEC));

    public static void init() {
    }
}


