package corgiaoc.byg.core.world;

import corgiaoc.byg.common.world.feature.config.*;
import corgiaoc.byg.common.world.feature.end.islands.*;
import corgiaoc.byg.common.world.feature.end.islands.shattered.ShatteredFloatingIslands1;
import corgiaoc.byg.common.world.feature.end.islands.shattered.ShatteredFloatingIslands2;
import corgiaoc.byg.common.world.feature.end.islands.shattered.ShatteredFloatingIslands3;
import corgiaoc.byg.common.world.feature.end.islands.shattered.ShatteredFloatingIslands4;
import corgiaoc.byg.common.world.feature.end.purpurpeaks.PurpurPeak;
import corgiaoc.byg.common.world.feature.end.trees.bulbis.BulbisTree1;
import corgiaoc.byg.common.world.feature.end.trees.bulbis.BulbisTree2;
import corgiaoc.byg.common.world.feature.end.trees.bulbis.BulbisTree3;
import corgiaoc.byg.common.world.feature.end.trees.bulbis.BulbisTree4;
import corgiaoc.byg.common.world.feature.end.trees.ether.EtherTree1;
import corgiaoc.byg.common.world.feature.end.trees.ether.EtherTree2;
import corgiaoc.byg.common.world.feature.end.trees.ether.EtherTree3;
import corgiaoc.byg.common.world.feature.end.trees.nightshade.NightshadeTree1;
import corgiaoc.byg.common.world.feature.end.trees.nightshade.NightshadeTree2;
import corgiaoc.byg.common.world.feature.end.trees.shulkren.ShulkrenTree1;
import corgiaoc.byg.common.world.feature.end.trees.shulkren.ShulkrenTree2;
import corgiaoc.byg.common.world.feature.nether.Chain;
import corgiaoc.byg.common.world.feature.nether.ConfigurablePillar;
import corgiaoc.byg.common.world.feature.nether.HangingColumn;
import corgiaoc.byg.common.world.feature.nether.HangingColumnWithBase;
import corgiaoc.byg.common.world.feature.nether.quartzdesert.RawQuartzColumnFeature;
import corgiaoc.byg.common.world.feature.nether.sythiantorrids.SythianStalk;
import corgiaoc.byg.common.world.feature.nether.trees.lament.*;
import corgiaoc.byg.common.world.feature.nether.trees.withering.WitheringOakTree1;
import corgiaoc.byg.common.world.feature.nether.trees.withering.WitheringOakTree2;
import corgiaoc.byg.common.world.feature.nether.trees.withering.WitheringOakTree3;
import corgiaoc.byg.common.world.feature.nether.trees.withering.WitheringOakTree4;
import corgiaoc.byg.common.world.feature.nether.wailinggarth.WailingVine;
import corgiaoc.byg.common.world.feature.nether.warpeddesert.WarpedCoralFeature;
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
import corgiaoc.byg.common.world.feature.overworld.trees.ancient.AncientTree1;
import corgiaoc.byg.common.world.feature.overworld.trees.ancient.AncientTree2;
import corgiaoc.byg.common.world.feature.overworld.trees.ancient.AncientTree3;
import corgiaoc.byg.common.world.feature.overworld.trees.araucaria.AraucariaTree1;
import corgiaoc.byg.common.world.feature.overworld.trees.araucaria.AraucariaTree2;
import corgiaoc.byg.common.world.feature.overworld.trees.aspen.AspenTree;
import corgiaoc.byg.common.world.feature.overworld.trees.aspen.AspenTree2;
import corgiaoc.byg.common.world.feature.overworld.trees.aspen.AspenTree3;
import corgiaoc.byg.common.world.feature.overworld.trees.baobab.BaobabTree1;
import corgiaoc.byg.common.world.feature.overworld.trees.baobab.BaobabTree2;
import corgiaoc.byg.common.world.feature.overworld.trees.baobab.BaobabTree3;
import corgiaoc.byg.common.world.feature.overworld.trees.birch.*;
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
import corgiaoc.byg.common.world.feature.overworld.trees.oak.OakTree1;
import corgiaoc.byg.common.world.feature.overworld.trees.oak.OakTree2;
import corgiaoc.byg.common.world.feature.overworld.trees.oak.OakTree3;
import corgiaoc.byg.common.world.feature.overworld.trees.oak.large.OakTreeLarge1;
import corgiaoc.byg.common.world.feature.overworld.trees.oak.large.OakTreeLarge2;
import corgiaoc.byg.common.world.feature.overworld.trees.oak.large.OakTreeLarge3;
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
import corgiaoc.byg.common.world.feature.overworld.volcano.VolcanoFeature;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.world.gen.feature.*;


public class BYGFeatures {

    public static final Feature<NoFeatureConfig> DUMMY_TREE = WorldGenRegistrationHelper.createFeature("dummy_tree", new SmallPineTree(NoFeatureConfig.field_236558_a_.stable()));
    public static final Feature<NoFeatureConfig> BEEHIVE = WorldGenRegistrationHelper.createFeature("beehive", new BeeHiveFeature(NoFeatureConfig.field_236558_a_.stable()));
    public static final Feature<NoFeatureConfig> HUH = WorldGenRegistrationHelper.createFeature("river_feature", new RiverThingy(NoFeatureConfig.field_236558_a_.stable()));
    public static final Feature<SimpleBlockProviderConfig> VOLCANO = WorldGenRegistrationHelper.createFeature("volcano", new VolcanoFeature(SimpleBlockProviderConfig.CODEC.stable()));
    public static final Feature<BoulderConfig> STACKABLE_BOULDERS = WorldGenRegistrationHelper.createFeature("stacked_boulder", new StackableBoulders(BoulderConfig.CODEC.stable()));
    public static final Feature<SimpleBlockProviderConfig> ARCH = WorldGenRegistrationHelper.createFeature("arch", new ArchFeature(SimpleBlockProviderConfig.CODEC.stable()));
    public static final Feature<SimpleBlockProviderConfig> PURPUR_PEAK = WorldGenRegistrationHelper.createFeature("purpur_peak", new PurpurPeak(SimpleBlockProviderConfig.CODEC.stable()));

    /********************************************************************Features*************************************************************************/
    //DeadSea
    public static final Feature<PointyRockConfig> POINTY_ROCK = WorldGenRegistrationHelper.createFeature("pointed_rock", new PointyRockFeature(PointyRockConfig.CODEC.stable()));
    public static final Feature<PointyRockConfig> TALL_POINTED_ROCK = WorldGenRegistrationHelper.createFeature("tall_pointed_rock", new TallPointedRocks(PointyRockConfig.CODEC.stable()));

    public static final Feature<Simple2BlockProviderConfig> ICE_SNOW = WorldGenRegistrationHelper.createFeature("ice_and_snow", new ConfigurableIceAndSnow(Simple2BlockProviderConfig.CODEC.stable()));

    //Lakes
    public static final Feature<BlockStateFeatureConfig> FROSTED_LAKE = WorldGenRegistrationHelper.createFeature("frosted_lake", new FrostMagmaLakeFeature(BlockStateFeatureConfig.field_236455_a_.stable()));
    public static final Feature<SimpleBlockProviderConfig> WIDE_LAKE = WorldGenRegistrationHelper.createFeature("wide_lake", new WideLake(SimpleBlockProviderConfig.CODEC.stable()));

    //Pumpkins
    public static final Feature<PumpkinConfig> LARGE_PUMPKIN1 = WorldGenRegistrationHelper.createFeature("pumpkin", new LargePumpkin1(PumpkinConfig.CODEC.stable()));
    public static final Feature<PumpkinConfig> LARGE_PUMPKIN2 = WorldGenRegistrationHelper.createFeature("pumpkin2", new LargePumpkin2(PumpkinConfig.CODEC.stable()));

    /*********************************************************************Large Flower Features***********************************************************/
    public static final BYGAbstractGiantFlowerFeature<GiantFlowerConfig> GIANT_ANGELICA_FLOWER = WorldGenRegistrationHelper.createFeature("giant_angelica_flower", new AngelicaGiant(GiantFlowerConfig.CODEC.stable()));
    public static final BYGAbstractGiantFlowerFeature<GiantFlowerConfig> GIANT_DANDELION_FLOWER = WorldGenRegistrationHelper.createFeature("giant_dandelion_flower", new DandelionGiant(GiantFlowerConfig.CODEC.stable()));
    public static final BYGAbstractGiantFlowerFeature<GiantFlowerConfig> GIANT_IRIS_FLOWER = WorldGenRegistrationHelper.createFeature("giant_iris_flower", new IrisGiant(GiantFlowerConfig.CODEC.stable()));
    public static final BYGAbstractGiantFlowerFeature<GiantFlowerConfig> GIANT_ROSE_FLOWER = WorldGenRegistrationHelper.createFeature("giant_rose", new RoseGiant(GiantFlowerConfig.CODEC.stable()));


    /*********************************************************************Large Mushroom Features*********************************************************/
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> GREEN_MUSHROOM_HUGE = WorldGenRegistrationHelper.createFeature("green_mushroom_huge", new GreenMushroomHuge(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> WOOD_BLEWIT_HUGE = WorldGenRegistrationHelper.createFeature("wood_blewit_huge", new WoodBlewitHuge(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> WEEPING_MILKCAP_HUGE = WorldGenRegistrationHelper.createFeature("weeping_milkcap_huge", new WeepingMilkcapHuge(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> BLACK_PUFF_HUGE = WorldGenRegistrationHelper.createFeature("black_puff_huge", new BlackPuffHuge(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> BLUE_GLOWSHROOM_HUGE = WorldGenRegistrationHelper.createFeature("blue_glowshroom_huge", new BlueGlowshroomHuge(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> PURPLE_GLOWSHROOM_HUGE = WorldGenRegistrationHelper.createFeature("purple_glowshroom_huge", new PurpleGlowshroomHuge(BYGMushroomConfig.CODEC.stable()));

    /*********************************************************************Mini Mushroom Features*********************************************************/
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> MINI_GREEN_MUSHROOM = WorldGenRegistrationHelper.createFeature("mini_green_mushroom", new MiniGreenMushroom(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> MINI_RED_MUSHROOM = WorldGenRegistrationHelper.createFeature("mini_red_mushroom", new MiniRedMushroom(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> MINI_BROWN_MUSHROOM = WorldGenRegistrationHelper.createFeature("mini_brown_mushroom", new MiniBrownMushroom(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> MINI_WEEPING_MILKCAP = WorldGenRegistrationHelper.createFeature("mini_weeping_milkcap", new MiniWeepingMilkcap(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> MINI_BLACK_PUFF = WorldGenRegistrationHelper.createFeature("mini_black_puff", new MiniBlackPuff(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> MINI_WOOD_BLEWIT = WorldGenRegistrationHelper.createFeature("mini_wood_blewit", new MiniWoodBlewit(BYGMushroomConfig.CODEC.stable()));

    /********************************************************************End Features********************************************************************/
    //Bulbis
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> BULBIS_TREE1 = WorldGenRegistrationHelper.createFeature("bulbis_tree1", new BulbisTree1(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> BULBIS_TREE2 = WorldGenRegistrationHelper.createFeature("bulbis_tree2", new BulbisTree2(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> BULBIS_TREE3 = WorldGenRegistrationHelper.createFeature("bulbis_tree3", new BulbisTree3(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> BULBIS_TREE4 = WorldGenRegistrationHelper.createFeature("bulbis_tree4", new BulbisTree4(BYGMushroomConfig.CODEC.stable()));

    //Ether
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ETHER_TREE1 = WorldGenRegistrationHelper.createFeature("ether_tree1", new EtherTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ETHER_TREE2 = WorldGenRegistrationHelper.createFeature("ether_tree2", new EtherTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ETHER_TREE3 = WorldGenRegistrationHelper.createFeature("ether_tree3", new EtherTree3(BYGTreeConfig.CODEC.stable()));

    //Nightshade
    public static final BYGAbstractTreeFeature<BYGTreeConfig> NIGHTSHADE_TREE1 = WorldGenRegistrationHelper.createFeature("nightshade_tree1", new NightshadeTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> NIGHTSHADE_TREE2 = WorldGenRegistrationHelper.createFeature("nightshade_tree2", new NightshadeTree2(BYGTreeConfig.CODEC.stable()));

    //Shulkren
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> SHULKREN_TREE1 = WorldGenRegistrationHelper.createFeature("shulkren_tree1", new ShulkrenTree1(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> SHULKREN_TREE2 = WorldGenRegistrationHelper.createFeature("shulkren_tree2", new ShulkrenTree2(BYGMushroomConfig.CODEC.stable()));


    public static final Feature<FloatingIslandConfig> FLOATING_ISLAND1 = WorldGenRegistrationHelper.createFeature("floating_island1", new FloatingIslands1(FloatingIslandConfig.CODEC.stable()));
    public static final Feature<FloatingIslandConfig> FLOATING_ISLAND2 = WorldGenRegistrationHelper.createFeature("floating_island2", new FloatingIslands2(FloatingIslandConfig.CODEC.stable()));
    public static final Feature<FloatingIslandConfig> FLOATING_ISLAND3 = WorldGenRegistrationHelper.createFeature("floating_island3", new FloatingIslands3(FloatingIslandConfig.CODEC.stable()));
    public static final Feature<FloatingIslandConfig> FLOATING_ISLAND4 = WorldGenRegistrationHelper.createFeature("hollow_floating_island", new FloatingIslands4(FloatingIslandConfig.CODEC.stable()));
    public static final Feature<FloatingIslandConfig> FLOATING_ISLAND5 = WorldGenRegistrationHelper.createFeature("floating_island5", new FloatingIslands5(FloatingIslandConfig.CODEC.stable()));

    public static final Feature<FloatingIslandConfig> SHATTERED_FLOATING_ISLAND1 = WorldGenRegistrationHelper.createFeature("shattered_floating_island1", new ShatteredFloatingIslands1(FloatingIslandConfig.CODEC.stable()));
    public static final Feature<FloatingIslandConfig> SHATTERED_FLOATING_ISLAND2 = WorldGenRegistrationHelper.createFeature("shattered_floating_island2", new ShatteredFloatingIslands2(FloatingIslandConfig.CODEC.stable()));
    public static final Feature<FloatingIslandConfig> SHATTERED_FLOATING_ISLAND3 = WorldGenRegistrationHelper.createFeature("shattered_floating_island3", new ShatteredFloatingIslands3(FloatingIslandConfig.CODEC.stable()));
    public static final Feature<FloatingIslandConfig> SHATTERED_FLOATING_ISLAND4 = WorldGenRegistrationHelper.createFeature("shattered_hollow_floating_island", new ShatteredFloatingIslands4(FloatingIslandConfig.CODEC.stable()));


    /********************************************************************Nether Features********************************************************************/

    //SoulShroom
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> SOUL_SHROOM_TREE1 = WorldGenRegistrationHelper.createFeature("soul_shroom_tree1", new SoulShroomTree1(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> SOUL_SHROOM_TREE2 = WorldGenRegistrationHelper.createFeature("soul_shroom_tree2", new SoulShroomTree2(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> SOUL_SHROOM_TREE3 = WorldGenRegistrationHelper.createFeature("soul_shroom_tree3", new SoulShroomTree3(BYGMushroomConfig.CODEC.stable()));

    //DeathCap
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> DEATH_CAP_TREE1 = WorldGenRegistrationHelper.createFeature("death_cap_tree1", new DeathCapTree1(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> DEATH_CAP_TREE2 = WorldGenRegistrationHelper.createFeature("death_cap_tree2", new DeathCapTree2(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> DEATH_CAP_TREE3 = WorldGenRegistrationHelper.createFeature("death_cap_tree3", new DeathCapTree3(BYGMushroomConfig.CODEC.stable()));

    //Lament
    public static final BYGAbstractTreeFeature<BYGTreeConfig> LAMENT_WEEPING_TREE1 = WorldGenRegistrationHelper.createFeature("lament_weeping_tree1", new LamentWeepingTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> LAMENT_WEEPING_TREE2 = WorldGenRegistrationHelper.createFeature("lament_weeping_tree2", new LamentWeepingTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> LAMENT_WEEPING_TREE3 = WorldGenRegistrationHelper.createFeature("lament_weeping_tree3", new LamentWeepingTree3(BYGTreeConfig.CODEC.stable()));

    public static final BYGAbstractTreeFeature<BYGTreeConfig> LAMENT_TWISTY_TREE1 = WorldGenRegistrationHelper.createFeature("lament_twisty_tree1", new LamentTwistyTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> LAMENT_TWISTY_TREE2 = WorldGenRegistrationHelper.createFeature("lament_twisty_tree2", new LamentTwistyTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> LAMENT_TWISTY_TREE3 = WorldGenRegistrationHelper.createFeature("lament_twisty_tree3", new LamentTwistyTree3(BYGTreeConfig.CODEC.stable()));

    //Withering Oak
    public static final BYGAbstractTreeFeature<BYGTreeConfig> WITHERING_OAK_TREE1 = WorldGenRegistrationHelper.createFeature("withering_oak_tree1", new WitheringOakTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> WITHERING_OAK_TREE2 = WorldGenRegistrationHelper.createFeature("withering_oak_tree2", new WitheringOakTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> WITHERING_OAK_TREE3 = WorldGenRegistrationHelper.createFeature("withering_oak_tree3", new WitheringOakTree3(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> WITHERING_OAK_TREE4 = WorldGenRegistrationHelper.createFeature("withering_oak_tree4", new WitheringOakTree4(BYGTreeConfig.CODEC.stable()));

    //QuartzDesert
    public static final Feature<HangingColumnWithBaseConfig> HANGING_FEATURE = WorldGenRegistrationHelper.createFeature("hanging_feature", new HangingColumnWithBase(HangingColumnWithBaseConfig.CODEC.stable()));

    //Sythian
    public static final Feature<ProbabilityConfig> SYTHIAN_STALK = WorldGenRegistrationHelper.createFeature("sythian_stalk", new SythianStalk(ProbabilityConfig.field_236576_b_.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> SYTHIAN_FUNGUS_TREE1 = WorldGenRegistrationHelper.createFeature("sythian_fungus_tree1", new SythianFungusTree1(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> SYTHIAN_FUNGUS_TREE2 = WorldGenRegistrationHelper.createFeature("sythian_fungus_tree2", new SythianFungusTree2(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> SYTHIAN_FUNGUS_TREE3 = WorldGenRegistrationHelper.createFeature("sythian_fungus_tree3", new SythianFungusTree3(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> SYTHIAN_FUNGUS_TREE4 = WorldGenRegistrationHelper.createFeature("sythian_fungus_tree4", new SythianFungusTree4(BYGMushroomConfig.CODEC.stable()));

    //Warped
    public static final Feature<WhitelistedSimpleBlockProviderConfig> HUGE_WARPED_CORAL_PLANT = WorldGenRegistrationHelper.createFeature("warped_coral_plant", new WarpedCoralFeature(WhitelistedSimpleBlockProviderConfig.CODEC.stable()));
    public static final Feature<SimpleBlockProviderConfig> PILLARS = WorldGenRegistrationHelper.createFeature("pillar", new ConfigurablePillar(SimpleBlockProviderConfig.CODEC.stable()));

    //Chains
    public static final Feature<ChainConfig> CHAIN = WorldGenRegistrationHelper.createFeature("chain", new Chain(ChainConfig.CODEC.stable()));

    //Crimson Gardens
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> CRIMSON_FUNGUS_TREE1 = WorldGenRegistrationHelper.createFeature("crimson_fungus_tree1", new CrimsonFungus1(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> CRIMSON_FUNGUS_TREE2 = WorldGenRegistrationHelper.createFeature("crimson_fungus_tree2", new CrimsonFungus2(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> WARPED_FUNGUS_TREE1 = WorldGenRegistrationHelper.createFeature("warped_fungus_tree1", new WarpedFungus1(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> WARPED_FUNGUS_TREE2 = WorldGenRegistrationHelper.createFeature("warped_fungus_tree2", new WarpedFungus2(BYGMushroomConfig.CODEC.stable()));

    //Wailing
    public static final Feature<NoFeatureConfig> WAILING_VINES = WorldGenRegistrationHelper.createFeature("wailing_vine", new WailingVine(NoFeatureConfig.field_236558_a_.stable()));

    //Embur
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> EMBUR_MUSHROOM = WorldGenRegistrationHelper.createFeature("embur_mushroom1", new EmburMushroom(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> EMBUR_MUSHROOM2 = WorldGenRegistrationHelper.createFeature("embur_mushroom2", new EmburMushroom2(BYGMushroomConfig.CODEC.stable()));
    public static final Feature<HangingColumnConfig> HANGING_COLUMN = WorldGenRegistrationHelper.createFeature("hanging_column", new HangingColumn(HangingColumnConfig.CODEC.stable()));

    //QuartzDesert
    public static final Feature<ColumnConfig> QUARTZ_COLUMNS = WorldGenRegistrationHelper.createFeature("quartz_columns", new RawQuartzColumnFeature(ColumnConfig.CODEC.stable()));


    /********************************************************************Structures***********************************************************************/


    /********************************************************************Tree Features********************************************************************/

    //Default
    public static final BYGAbstractTreeFeature<BYGTreeConfig> BASIC_TREE = WorldGenRegistrationHelper.createFeature("tree", new BasicTree(BYGTreeConfig.CODEC.stable()));

    //Araucaria
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ARAUCARIA_TREE1 = WorldGenRegistrationHelper.createFeature("araucaria_tree1", new AraucariaTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ARAUCARIA_TREE2 = WorldGenRegistrationHelper.createFeature("araucaria_tree2", new AraucariaTree2(BYGTreeConfig.CODEC.stable()));

    //Ancient
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ANCIENT_TREE1 = WorldGenRegistrationHelper.createFeature("ancient_tree1", new AncientTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ANCIENT_TREE2 = WorldGenRegistrationHelper.createFeature("ancient_tree2", new AncientTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ANCIENT_TREE3 = WorldGenRegistrationHelper.createFeature("ancient_tree3", new AncientTree3(BYGTreeConfig.CODEC.stable()));

    //Aspen
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ASPEN_TREE1 = WorldGenRegistrationHelper.createFeature("aspen_tree1", new AspenTree(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ASPEN_TREE2 = WorldGenRegistrationHelper.createFeature("aspen_tree2", new AspenTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ASPEN_TREE3 = WorldGenRegistrationHelper.createFeature("aspen_tree3", new AspenTree3(BYGTreeConfig.CODEC.stable()));

    //Baobab
    public static final BYGAbstractTreeFeature<BYGTreeConfig> BAOBAB_TREE1 = WorldGenRegistrationHelper.createFeature("baobab_tree1", new BaobabTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> BAOBAB_TREE2 = WorldGenRegistrationHelper.createFeature("baobab_tree2", new BaobabTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> BAOBAB_TREE3 = WorldGenRegistrationHelper.createFeature("baobab_tree3", new BaobabTree3(BYGTreeConfig.CODEC.stable()));

    //Birch
    public static final BYGAbstractTreeFeature<BYGTreeConfig> BIRCH_TREE1 = WorldGenRegistrationHelper.createFeature("birch_tree1", new BirchTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> BIRCH_TREE2 = WorldGenRegistrationHelper.createFeature("birch_tree2", new BirchTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> BIRCH_TREE3 = WorldGenRegistrationHelper.createFeature("birch_tree3", new BirchTree3(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> BIRCH_TREE4 = WorldGenRegistrationHelper.createFeature("birch_tree4", new BirchTree4(BYGTreeConfig.CODEC.stable()));

    //Bluff
    public static final BYGAbstractTreeFeature<BYGTreeConfig> BLUFF_TREE1 = WorldGenRegistrationHelper.createFeature("bluff_tree1", new BluffTree(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> BLUFF_TREE2 = WorldGenRegistrationHelper.createFeature("bluff_tree2", new BluffTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> BLUFF_TREE3 = WorldGenRegistrationHelper.createFeature("bluff_tree3", new BluffTree3(BYGTreeConfig.CODEC.stable()));

    //Boreal Trees
    public static final BYGAbstractTreeFeature<BYGTreeConfig> BOREAL_TREE1 = WorldGenRegistrationHelper.createFeature("boreal_tree1", new BorealForestTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> BOREAL_TREE2 = WorldGenRegistrationHelper.createFeature("boreal_tree2", new BorealForestTree2(BYGTreeConfig.CODEC.stable()));

    //Cherry
    public static final BYGAbstractTreeFeature<BYGTreeConfig> CHERRY_TREE1 = WorldGenRegistrationHelper.createFeature("cherry_tree1", new CherryTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> CHERRY_TREE2 = WorldGenRegistrationHelper.createFeature("cherry_tree2", new CherryTree2(BYGTreeConfig.CODEC.stable()));

    //Cika
    public static final BYGAbstractTreeFeature<BYGTreeConfig> CIKA_TREE1 = WorldGenRegistrationHelper.createFeature("cika_tree1", new CikaTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> CIKA_TREE2 = WorldGenRegistrationHelper.createFeature("cika_tree2", new CikaTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> CIKA_TREE3 = WorldGenRegistrationHelper.createFeature("cika_tree3", new CikaTree3(BYGTreeConfig.CODEC.stable()));

    //Coniferous
    public static final BYGAbstractTreeFeature<BYGTreeConfig> CONIFER_TREE1 = WorldGenRegistrationHelper.createFeature("conifer_tree1", new ConiferTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> CONIFER_TREE2 = WorldGenRegistrationHelper.createFeature("conifer_tree2", new ConiferTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> CONIFER_TREE3 = WorldGenRegistrationHelper.createFeature("conifer_tree3", new ConiferTree3(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> CONIFER_TREE4 = WorldGenRegistrationHelper.createFeature("conifer_tree4", new ConiferTree4(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> CONIFER_TREE5 = WorldGenRegistrationHelper.createFeature("conifer_tree5", new ConiferTree5(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> CONIFER_TREE6 = WorldGenRegistrationHelper.createFeature("conifer_tree6", new ConiferTree6(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> CONIFER_TREE7 = WorldGenRegistrationHelper.createFeature("conifer_tree7", new ConiferTree7(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> CONIFER_TREE8 = WorldGenRegistrationHelper.createFeature("conifer_tree8", new ConiferTree8(BYGTreeConfig.CODEC.stable()));

    //Cypress
    public static final BYGAbstractTreeFeature<BYGTreeConfig> CYPRESS_TREE1 = WorldGenRegistrationHelper.createFeature("cypress_tree1", new CypressTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> CYPRESS_TREE2 = WorldGenRegistrationHelper.createFeature("cypress_tree2", new CypressTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> CYPRESS_TREE3 = WorldGenRegistrationHelper.createFeature("cypress_tree3", new CypressTree3(BYGTreeConfig.CODEC.stable()));

    //Dead Hazel
    public static final BYGAbstractTreeFeature<BYGTreeConfig> DEAD_HAZEL_TREE1 = WorldGenRegistrationHelper.createFeature("dead_hazel_tree1", new DeadHazel1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> DEAD_HAZEL_TREE2 = WorldGenRegistrationHelper.createFeature("dead_hazel_tree2", new DeadHazel2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> DEAD_HAZEL_TREE3 = WorldGenRegistrationHelper.createFeature("dead_hazel_tree3", new DeadHazel3(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> DEAD_HAZEL_TREE4 = WorldGenRegistrationHelper.createFeature("dead_hazel_tree4", new DeadHazel4(BYGTreeConfig.CODEC.stable()));

    //Deciduous
    public static final BYGAbstractTreeFeature<BYGTreeConfig> DECIDUOUS_TREE1 = WorldGenRegistrationHelper.createFeature("deciduous_tree1", new DeciduousTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> DECIDUOUS_TREE2 = WorldGenRegistrationHelper.createFeature("deciduous_tree2", new DeciduousTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> DECIDUOUS_TREE3 = WorldGenRegistrationHelper.createFeature("deciduous_tree3", new DeciduousTree3(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> DECIDUOUS_TREE4 = WorldGenRegistrationHelper.createFeature("deciduous_tree4", new DeciduousTree4(BYGTreeConfig.CODEC.stable()));

    //Ebony
    public static final BYGAbstractTreeFeature<BYGTreeConfig> EBONY_BUSH1 = WorldGenRegistrationHelper.createFeature("ebony_bush", new EbonyBush1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> EBONY_TREE1 = WorldGenRegistrationHelper.createFeature("ebony_tree1", new EbonyTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> EBONY_TREE2 = WorldGenRegistrationHelper.createFeature("ebony_tree2", new EbonyTree2(BYGTreeConfig.CODEC.stable()));

    //Enchanted Trees
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ENCHANTED_TREE1 = WorldGenRegistrationHelper.createFeature("enchanted_tree1", new EnchantedTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ENCHANTED_TREE2 = WorldGenRegistrationHelper.createFeature("enchanted_tree2", new EnchantedTree3(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ENCHANTED_TREE3 = WorldGenRegistrationHelper.createFeature("enchanted_tree3", new EnchantedTree2(BYGTreeConfig.CODEC.stable()));

    public static final BYGAbstractTreeFeature<BYGTreeConfig> ENCHANTED_GROVE_TREE1 = WorldGenRegistrationHelper.createFeature("enchanted_grove_tree1", new EnchantedGroveTree(BYGTreeConfig.CODEC.stable()));

    //Holly
    public static final BYGAbstractTreeFeature<BYGTreeConfig> HOLLY_TREE1 = WorldGenRegistrationHelper.createFeature("holly_tree1", new HollyTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> HOLLY_TREE2 = WorldGenRegistrationHelper.createFeature("holly_tree2", new HollyTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> HOLLY_TREE3 = WorldGenRegistrationHelper.createFeature("holly_tree3", new HollyTree3(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> HOLLY_TREE4 = WorldGenRegistrationHelper.createFeature("holly_tree4", new HollyTree4(BYGTreeConfig.CODEC.stable()));

    //Jacaranda
    public static final BYGAbstractTreeFeature<BYGTreeConfig> JACARANDA_TREE1 = WorldGenRegistrationHelper.createFeature("jacaranda_tree1", new JacarandaTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> JACARANDA_TREE2 = WorldGenRegistrationHelper.createFeature("jacaranda_tree2", new JacarandaTree2(BYGTreeConfig.CODEC.stable()));

    //JoshuaTree
    public static final BYGAbstractTreeFeature<BYGTreeConfig> JOSHUA_TREE1 = WorldGenRegistrationHelper.createFeature("joshua_tree1", new JoshuaTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> JOSHUA_TREE2 = WorldGenRegistrationHelper.createFeature("joshua_tree2", new JoshuaTree2(BYGTreeConfig.CODEC.stable()));

    //Mangrove
    public static final BYGAbstractTreeFeature<BYGTreeConfig> MANGROVE_TREE1 = WorldGenRegistrationHelper.createFeature("mangrove_tree1", new MangroveTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> MANGROVE_TREE2 = WorldGenRegistrationHelper.createFeature("mangrove_tree2", new MangroveTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> MANGROVE_TREE3 = WorldGenRegistrationHelper.createFeature("mangrove_tree3", new MangroveTree3(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> MANGROVE_TREE4 = WorldGenRegistrationHelper.createFeature("mangrove_tree4", new MangroveTree4(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> MANGROVE_TREE5 = WorldGenRegistrationHelper.createFeature("mangrove_tree5", new MangroveTree5(BYGTreeConfig.CODEC.stable()));

    //Maple
    public static final BYGAbstractTreeFeature<BYGTreeConfig> MAPLE_TREE1 = WorldGenRegistrationHelper.createFeature("maple_tree1", new MapleTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> MAPLE_TREE2 = WorldGenRegistrationHelper.createFeature("maple_tree2", new MapleTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> MAPLE_TREE3 = WorldGenRegistrationHelper.createFeature("maple_tree3", new MapleTree3(BYGTreeConfig.CODEC.stable()));

    //Meadow
    public static final BYGAbstractTreeFeature<BYGTreeConfig> MEADOW_TREE1 = WorldGenRegistrationHelper.createFeature("meadow_tree1", new MeadowTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> MEADOW_TREE2 = WorldGenRegistrationHelper.createFeature("meadow_tree2", new MeadowTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> MEADOW_TREE3 = WorldGenRegistrationHelper.createFeature("meadow_tree3", new MeadowTree3(BYGTreeConfig.CODEC.stable()));

    //Oak
    public static final BYGAbstractTreeFeature<BYGTreeConfig> OAK_TREE1 = WorldGenRegistrationHelper.createFeature("oak_tree1", new OakTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> OAK_TREE2 = WorldGenRegistrationHelper.createFeature("oak_tree2", new OakTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> OAK_TREE3 = WorldGenRegistrationHelper.createFeature("oak_tree3", new OakTree3(BYGTreeConfig.CODEC.stable()));

    public static final BYGAbstractTreeFeature<BYGTreeConfig> OAK_TREE_LARGE1 = WorldGenRegistrationHelper.createFeature("large_oak_tree1", new OakTreeLarge1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> OAK_TREE_LARGE2 = WorldGenRegistrationHelper.createFeature("large_oak_tree2", new OakTreeLarge2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> OAK_TREE_LARGE3 = WorldGenRegistrationHelper.createFeature("large_oak_tree3", new OakTreeLarge3(BYGTreeConfig.CODEC.stable()));

    //Orchard
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ORCHARD_TREE1 = WorldGenRegistrationHelper.createFeature("orchard_tree1", new OrchardTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ORCHARD_TREE2 = WorldGenRegistrationHelper.createFeature("orchard_tree2", new OrchardTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ORCHARD_TREE3 = WorldGenRegistrationHelper.createFeature("orchard_tree3", new OrchardTree3(BYGTreeConfig.CODEC.stable()));

    //Palm
    public static final BYGAbstractTreeFeature<BYGTreeConfig> PALM_TREE1 = WorldGenRegistrationHelper.createFeature("palm_tree1", new PalmTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> PALM_TREE2 = WorldGenRegistrationHelper.createFeature("palm_tree2", new PalmTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> PALM_TREE3 = WorldGenRegistrationHelper.createFeature("palm_tree3", new PalmTree3(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> PALM_TREE4 = WorldGenRegistrationHelper.createFeature("palm_tree4", new PalmTree4(BYGTreeConfig.CODEC.stable()));

    //Pine
    public static final BYGAbstractTreeFeature<BYGTreeConfig> PINE_LARGE_TREE1 = WorldGenRegistrationHelper.createFeature("large_pine_tree1", new LargePineTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> PINE_LARGE_TREE2 = WorldGenRegistrationHelper.createFeature("large_pine_tree2", new LargePineTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> PINE_TREE1 = WorldGenRegistrationHelper.createFeature("pine_tree1", new PineTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> PINE_TREE2 = WorldGenRegistrationHelper.createFeature("pine_tree2", new PineTree2(BYGTreeConfig.CODEC.stable()));

    //Palo Verde
    public static final BYGAbstractTreeFeature<BYGTreeConfig> PALO_VERDE_TREE1 = WorldGenRegistrationHelper.createFeature("palo_verde_tree1", new PaloVerdeTree(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> PALO_VERDE_TREE2 = WorldGenRegistrationHelper.createFeature("palo_verde_tree2", new PaloVerdeTree2(BYGTreeConfig.CODEC.stable()));

    //Rainbow Eucalyptus
    public static final BYGAbstractTreeFeature<BYGTreeConfig> RAINBOW_TREE1 = WorldGenRegistrationHelper.createFeature("rainbow_eucalyptus_tree", new RainbowEucalyptusTree(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> RAINBOW_LARGE_TREE1 = WorldGenRegistrationHelper.createFeature("large_rainbow_eucalyptus_tree", new LargeRainbowEucalyptus(BYGTreeConfig.CODEC.stable()));

    //RedWood
    public static final BYGAbstractTreeFeature<BYGTreeConfig> REDWOOD_TREE1 = WorldGenRegistrationHelper.createFeature("redwood_tree1", new RedwoodTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> REDWOOD_TREE2 = WorldGenRegistrationHelper.createFeature("redwood_tree2", new RedwoodTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> REDWOOD_TREE3 = WorldGenRegistrationHelper.createFeature("redwood_tree3", new RedwoodTree3(BYGTreeConfig.CODEC.stable()));

    //Shrubs
    public static final BYGAbstractTreeFeature<BYGTreeConfig> SHRUB1 = WorldGenRegistrationHelper.createFeature("shrub1", new Shrub1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> SHRUB2 = WorldGenRegistrationHelper.createFeature("shrub2", new Shrub2(BYGTreeConfig.CODEC.stable()));
    //Skyris
    public static final BYGAbstractTreeFeature<BYGTreeConfig> SKYRIS_TREE1 = WorldGenRegistrationHelper.createFeature("skyris_tree1", new SkyrisTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> SKYRIS_TREE2 = WorldGenRegistrationHelper.createFeature("skyris_tree2", new SkyrisTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> SKYRIS_TREE3 = WorldGenRegistrationHelper.createFeature("skyris_tree3", new SkyrisTree3(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> SKYRIS_TREE4 = WorldGenRegistrationHelper.createFeature("skyris_tree4", new SkyrisTree4(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> SKYRIS_TREE5 = WorldGenRegistrationHelper.createFeature("skyris_tree5", new SkyrisTree5(BYGTreeConfig.CODEC.stable()));

    //Spruce
    public static final BYGAbstractTreeFeature<BYGTreeConfig> SPRUCE_TREE_LARGE1 = WorldGenRegistrationHelper.createFeature("large_spruce_tree1", new SpruceTreeLarge1(BYGTreeConfig.CODEC.stable()));

    public static final BYGAbstractTreeFeature<BYGTreeConfig> SPRUCE_TREE_MEDIUM1 = WorldGenRegistrationHelper.createFeature("medium_spruce_tree1", new SpruceTreeMedium1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> SPRUCE_TREE_MEDIUM2 = WorldGenRegistrationHelper.createFeature("medium_spruce_tree2", new SpruceTreeMedium2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> SPRUCE_TREE_MEDIUM3 = WorldGenRegistrationHelper.createFeature("medium_spruce_tree3", new SpruceTreeMedium3(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> SPRUCE_TREE_MEDIUM4 = WorldGenRegistrationHelper.createFeature("medium_spruce_tree4", new SpruceTreeMedium4(BYGTreeConfig.CODEC.stable()));

    public static final BYGAbstractTreeFeature<BYGTreeConfig> SPRUCE_TREE1 = WorldGenRegistrationHelper.createFeature("spruce_tree1", new SpruceTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> SPRUCE_TREE2 = WorldGenRegistrationHelper.createFeature("spruce_tree2", new SpruceTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> SPRUCE_TREE3 = WorldGenRegistrationHelper.createFeature("spruce_tree3", new SpruceTree3(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> SPRUCE_TREE4 = WorldGenRegistrationHelper.createFeature("spruce_tree4", new SpruceTree4(BYGTreeConfig.CODEC.stable()));

    //Mahogany
    public static final BYGAbstractTreeFeature<BYGTreeConfig> MAHOGANY_TREE1 = WorldGenRegistrationHelper.createFeature("mahogany_tree1", new MahoganyTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> MAHOGANY_TREE2 = WorldGenRegistrationHelper.createFeature("mahogany_tree2", new MahoganyTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> MAHOGANY_TREE3 = WorldGenRegistrationHelper.createFeature("mahogany_tree3", new MahoganyTree3(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> MAHOGANY_TREE4 = WorldGenRegistrationHelper.createFeature("mahogany_tree4", new MahoganyTree4(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> MAHOGANY_TREE5 = WorldGenRegistrationHelper.createFeature("mahogany_tree5", new MahoganyTree5(BYGTreeConfig.CODEC.stable()));

    //Woodlands
    public static final BYGAbstractTreeFeature<BYGTreeConfig> WOODLANDS_TREE1 = WorldGenRegistrationHelper.createFeature("woodlands_tree", new WoodlandsTree1(BYGTreeConfig.CODEC.stable()));

    //Willow
    public static final BYGAbstractTreeFeature<BYGTreeConfig> WILLOW_DEAD_TREE1 = WorldGenRegistrationHelper.createFeature("dead_willow_tree", new WillowDeadTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> WILLOW_M_TREE1 = WorldGenRegistrationHelper.createFeature("mutated_willow_tree1", new WillowTreeM1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> WILLOW_M_TREE2 = WorldGenRegistrationHelper.createFeature("mutated_willow_tree2", new WillowTreeM2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> WILLOW_TREE1 = WorldGenRegistrationHelper.createFeature("willow_tree1", new WillowTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> WILLOW_TREE2 = WorldGenRegistrationHelper.createFeature("willow_tree2", new WillowTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> WILLOW_TREE3 = WorldGenRegistrationHelper.createFeature("willow_tree3", new WillowTree3(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> WILLOW_TREE4 = WorldGenRegistrationHelper.createFeature("willow_tree4", new WillowTree4(BYGTreeConfig.CODEC.stable()));

    //Zelkova
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ZELKOVA_TREE1 = WorldGenRegistrationHelper.createFeature("zelkova_tree1", new ZelkovaTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ZELKOVA_TREE2 = WorldGenRegistrationHelper.createFeature("zelkova_tree2", new ZelkovaTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ZELKOVA_TREE3 = WorldGenRegistrationHelper.createFeature("zelkova_tree3", new ZelkovaTree3(BYGTreeConfig.CODEC.stable()));

    public static void init() {
    }
}


