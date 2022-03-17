package potionstudios.byg.common.world.feature;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.feature.config.*;
import potionstudios.byg.common.world.feature.gen.*;
import potionstudios.byg.common.world.feature.gen.end.EndLakeFeature;
import potionstudios.byg.common.world.feature.gen.end.islands.*;
import potionstudios.byg.common.world.feature.gen.end.islands.shattered.ShatteredFloatingIslands1;
import potionstudios.byg.common.world.feature.gen.end.islands.shattered.ShatteredFloatingIslands2;
import potionstudios.byg.common.world.feature.gen.end.islands.shattered.ShatteredFloatingIslands3;
import potionstudios.byg.common.world.feature.gen.end.islands.shattered.ShatteredFloatingIslands4;
import potionstudios.byg.common.world.feature.gen.end.purpurpeaks.PurpurPeak;
import potionstudios.byg.common.world.feature.gen.end.trees.bulbis.*;
import potionstudios.byg.common.world.feature.gen.end.trees.ether.*;
import potionstudios.byg.common.world.feature.gen.end.trees.ether.dead.DeadEtherTree1;
import potionstudios.byg.common.world.feature.gen.end.trees.ether.dead.DeadEtherTree2;
import potionstudios.byg.common.world.feature.gen.end.trees.ether.dead.DeadEtherTree3;
import potionstudios.byg.common.world.feature.gen.end.trees.impariusgrove.*;
import potionstudios.byg.common.world.feature.gen.end.trees.impariusgrove.fungus.*;
import potionstudios.byg.common.world.feature.gen.end.trees.nightshade.*;
import potionstudios.byg.common.world.feature.gen.end.trees.shulkren.ShulkrenTree1;
import potionstudios.byg.common.world.feature.gen.end.trees.shulkren.ShulkrenTree2;
import potionstudios.byg.common.world.feature.gen.nether.Chain;
import potionstudios.byg.common.world.feature.gen.nether.ConfigurablePillar;
import potionstudios.byg.common.world.feature.gen.nether.HangingColumn;
import potionstudios.byg.common.world.feature.gen.nether.HangingColumnWithBase;
import potionstudios.byg.common.world.feature.gen.nether.brimstone.BrimstoneVentFeature;
import potionstudios.byg.common.world.feature.gen.nether.quartzdesert.QuartzSpikeFeature;
import potionstudios.byg.common.world.feature.gen.nether.quartzdesert.RawQuartzColumnFeature;
import potionstudios.byg.common.world.feature.gen.nether.spike.SpikeFeature;
import potionstudios.byg.common.world.feature.gen.nether.subzero.SubzeroCrystalFeature;
import potionstudios.byg.common.world.feature.gen.nether.sythiantorrids.SythianStalk;
import potionstudios.byg.common.world.feature.gen.nether.trees.embur.EmburMushroom;
import potionstudios.byg.common.world.feature.gen.nether.trees.embur.EmburMushroom2;
import potionstudios.byg.common.world.feature.gen.nether.trees.embur.EmburMushroom3;
import potionstudios.byg.common.world.feature.gen.nether.trees.embur.EmburMushroom4;
import potionstudios.byg.common.world.feature.gen.nether.trees.lament.*;
import potionstudios.byg.common.world.feature.gen.nether.trees.withering.*;
import potionstudios.byg.common.world.feature.gen.nether.wailinggarth.WailingVine;
import potionstudios.byg.common.world.feature.gen.nether.wailinggarth.pillars.WailingPillar1;
import potionstudios.byg.common.world.feature.gen.nether.warpeddesert.WarpedCoralFeature;
import potionstudios.byg.common.world.feature.gen.overworld.*;
import potionstudios.byg.common.world.feature.gen.overworld.giantflowers.AngelicaGiant;
import potionstudios.byg.common.world.feature.gen.overworld.giantflowers.DandelionGiant;
import potionstudios.byg.common.world.feature.gen.overworld.giantflowers.IrisGiant;
import potionstudios.byg.common.world.feature.gen.overworld.giantflowers.RoseGiant;
import potionstudios.byg.common.world.feature.gen.overworld.giantflowers.util.BYGAbstractGiantFlowerFeature;
import potionstudios.byg.common.world.feature.gen.overworld.mushrooms.*;
import potionstudios.byg.common.world.feature.gen.overworld.mushrooms.util.BYGAbstractMushroomFeature;
import potionstudios.byg.common.world.feature.gen.overworld.pumpkins.LargePumpkin1;
import potionstudios.byg.common.world.feature.gen.overworld.pumpkins.LargePumpkin2;
import potionstudios.byg.common.world.feature.gen.overworld.trees.ancient.AncientTree1;
import potionstudios.byg.common.world.feature.gen.overworld.trees.ancient.AncientTree2;
import potionstudios.byg.common.world.feature.gen.overworld.trees.ancient.AncientTree3;
import potionstudios.byg.common.world.feature.gen.overworld.trees.araucaria.AraucariaTree1;
import potionstudios.byg.common.world.feature.gen.overworld.trees.araucaria.AraucariaTree2;
import potionstudios.byg.common.world.feature.gen.overworld.trees.aspen.AspenTree;
import potionstudios.byg.common.world.feature.gen.overworld.trees.aspen.AspenTree2;
import potionstudios.byg.common.world.feature.gen.overworld.trees.aspen.AspenTree3;
import potionstudios.byg.common.world.feature.gen.overworld.trees.baobab.BaobabTree1;
import potionstudios.byg.common.world.feature.gen.overworld.trees.baobab.BaobabTree2;
import potionstudios.byg.common.world.feature.gen.overworld.trees.baobab.BaobabTree3;
import potionstudios.byg.common.world.feature.gen.overworld.trees.birch.*;
import potionstudios.byg.common.world.feature.gen.overworld.trees.bluff.BluffTree;
import potionstudios.byg.common.world.feature.gen.overworld.trees.bluff.BluffTree2;
import potionstudios.byg.common.world.feature.gen.overworld.trees.bluff.BluffTree3;
import potionstudios.byg.common.world.feature.gen.overworld.trees.boreal.BorealForestTree1;
import potionstudios.byg.common.world.feature.gen.overworld.trees.boreal.BorealForestTree2;
import potionstudios.byg.common.world.feature.gen.overworld.trees.cherry.CherryTree1;
import potionstudios.byg.common.world.feature.gen.overworld.trees.cherry.CherryTree2;
import potionstudios.byg.common.world.feature.gen.overworld.trees.cika.CikaTree1;
import potionstudios.byg.common.world.feature.gen.overworld.trees.cika.CikaTree2;
import potionstudios.byg.common.world.feature.gen.overworld.trees.cika.CikaTree3;
import potionstudios.byg.common.world.feature.gen.overworld.trees.coniferous.*;
import potionstudios.byg.common.world.feature.gen.overworld.trees.cypress.CypressTree1;
import potionstudios.byg.common.world.feature.gen.overworld.trees.cypress.CypressTree2;
import potionstudios.byg.common.world.feature.gen.overworld.trees.cypress.CypressTree3;
import potionstudios.byg.common.world.feature.gen.overworld.trees.deadhazel.DeadHazelTree1;
import potionstudios.byg.common.world.feature.gen.overworld.trees.deadhazel.DeadHazelTree2;
import potionstudios.byg.common.world.feature.gen.overworld.trees.deadhazel.HazelTree1;
import potionstudios.byg.common.world.feature.gen.overworld.trees.deadhazel.HazelTree2;
import potionstudios.byg.common.world.feature.gen.overworld.trees.deciduous.DeciduousTree1;
import potionstudios.byg.common.world.feature.gen.overworld.trees.deciduous.DeciduousTree2;
import potionstudios.byg.common.world.feature.gen.overworld.trees.deciduous.DeciduousTree3;
import potionstudios.byg.common.world.feature.gen.overworld.trees.deciduous.DeciduousTree4;
import potionstudios.byg.common.world.feature.gen.overworld.trees.ebony.EbonyBush1;
import potionstudios.byg.common.world.feature.gen.overworld.trees.ebony.EbonyTree1;
import potionstudios.byg.common.world.feature.gen.overworld.trees.ebony.EbonyTree2;
import potionstudios.byg.common.world.feature.gen.overworld.trees.enchanted.EnchantedGroveTree;
import potionstudios.byg.common.world.feature.gen.overworld.trees.enchanted.EnchantedTree1;
import potionstudios.byg.common.world.feature.gen.overworld.trees.enchanted.EnchantedTree2;
import potionstudios.byg.common.world.feature.gen.overworld.trees.enchanted.EnchantedTree3;
import potionstudios.byg.common.world.feature.gen.overworld.trees.holly.HollyTree1;
import potionstudios.byg.common.world.feature.gen.overworld.trees.holly.HollyTree2;
import potionstudios.byg.common.world.feature.gen.overworld.trees.holly.HollyTree3;
import potionstudios.byg.common.world.feature.gen.overworld.trees.holly.HollyTree4;
import potionstudios.byg.common.world.feature.gen.overworld.trees.jacaranda.JacarandaTree1;
import potionstudios.byg.common.world.feature.gen.overworld.trees.jacaranda.JacarandaTree2;
import potionstudios.byg.common.world.feature.gen.overworld.trees.joshua.JoshuaTree1;
import potionstudios.byg.common.world.feature.gen.overworld.trees.joshua.JoshuaTree2;
import potionstudios.byg.common.world.feature.gen.overworld.trees.mahogany.*;
import potionstudios.byg.common.world.feature.gen.overworld.trees.mangrove.*;
import potionstudios.byg.common.world.feature.gen.overworld.trees.maple.MapleTree1;
import potionstudios.byg.common.world.feature.gen.overworld.trees.maple.MapleTree2;
import potionstudios.byg.common.world.feature.gen.overworld.trees.maple.MapleTree3;
import potionstudios.byg.common.world.feature.gen.overworld.trees.meadow.*;
import potionstudios.byg.common.world.feature.gen.overworld.trees.oak.OakTree1;
import potionstudios.byg.common.world.feature.gen.overworld.trees.oak.OakTree2;
import potionstudios.byg.common.world.feature.gen.overworld.trees.oak.OakTree3;
import potionstudios.byg.common.world.feature.gen.overworld.trees.oak.large.OakTreeLarge1;
import potionstudios.byg.common.world.feature.gen.overworld.trees.oak.large.OakTreeLarge2;
import potionstudios.byg.common.world.feature.gen.overworld.trees.oak.large.OakTreeLarge3;
import potionstudios.byg.common.world.feature.gen.overworld.trees.orchard.OrchardTree1;
import potionstudios.byg.common.world.feature.gen.overworld.trees.orchard.OrchardTree2;
import potionstudios.byg.common.world.feature.gen.overworld.trees.orchard.OrchardTree3;
import potionstudios.byg.common.world.feature.gen.overworld.trees.palm.PalmTree1;
import potionstudios.byg.common.world.feature.gen.overworld.trees.palm.PalmTree2;
import potionstudios.byg.common.world.feature.gen.overworld.trees.palm.PalmTree3;
import potionstudios.byg.common.world.feature.gen.overworld.trees.palm.PalmTree4;
import potionstudios.byg.common.world.feature.gen.overworld.trees.palo_verde.PaloVerdeTree;
import potionstudios.byg.common.world.feature.gen.overworld.trees.palo_verde.PaloVerdeTree2;
import potionstudios.byg.common.world.feature.gen.overworld.trees.pine.*;
import potionstudios.byg.common.world.feature.gen.overworld.trees.rainbow_eucalyptus.LargeRainbowEucalyptus;
import potionstudios.byg.common.world.feature.gen.overworld.trees.rainbow_eucalyptus.RainbowEucalyptusTree;
import potionstudios.byg.common.world.feature.gen.overworld.trees.redwood.RedwoodTree1;
import potionstudios.byg.common.world.feature.gen.overworld.trees.redwood.RedwoodTree2;
import potionstudios.byg.common.world.feature.gen.overworld.trees.redwood.RedwoodTree3;
import potionstudios.byg.common.world.feature.gen.overworld.trees.skyris.*;
import potionstudios.byg.common.world.feature.gen.overworld.trees.spruce.giant.SpruceTreeLarge1;
import potionstudios.byg.common.world.feature.gen.overworld.trees.spruce.medium.SpruceTreeMedium1;
import potionstudios.byg.common.world.feature.gen.overworld.trees.spruce.medium.SpruceTreeMedium2;
import potionstudios.byg.common.world.feature.gen.overworld.trees.spruce.medium.SpruceTreeMedium3;
import potionstudios.byg.common.world.feature.gen.overworld.trees.spruce.medium.SpruceTreeMedium4;
import potionstudios.byg.common.world.feature.gen.overworld.trees.spruce.small.SpruceTree1;
import potionstudios.byg.common.world.feature.gen.overworld.trees.spruce.small.SpruceTree2;
import potionstudios.byg.common.world.feature.gen.overworld.trees.spruce.small.SpruceTree3;
import potionstudios.byg.common.world.feature.gen.overworld.trees.spruce.small.SpruceTree4;
import potionstudios.byg.common.world.feature.gen.overworld.trees.structure.TreeFromStructureNBTConfig;
import potionstudios.byg.common.world.feature.gen.overworld.trees.structure.TreeFromStructureNBTFeature;
import potionstudios.byg.common.world.feature.gen.overworld.trees.util.BYGAbstractTreeFeature;
import potionstudios.byg.common.world.feature.gen.overworld.trees.willow.WillowTree2;
import potionstudios.byg.common.world.feature.gen.overworld.trees.willow.WillowTree3;
import potionstudios.byg.common.world.feature.gen.overworld.trees.willow.WillowTree4;
import potionstudios.byg.common.world.feature.gen.overworld.trees.willow.dead.WillowDeadTree1;
import potionstudios.byg.common.world.feature.gen.overworld.trees.woodlands.WoodlandsTree1;
import potionstudios.byg.common.world.feature.gen.overworld.trees.zelkova.ZelkovaTree1;
import potionstudios.byg.common.world.feature.gen.overworld.trees.zelkova.ZelkovaTree2;
import potionstudios.byg.common.world.feature.gen.overworld.trees.zelkova.ZelkovaTree3;
import potionstudios.byg.common.world.feature.gen.overworld.volcano.VolcanoFeature;
import potionstudios.byg.util.RegistryObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BYGFeatures {

    public static List<RegistryObject<Feature<?>>> FEATURES = new ArrayList<>();
    public static final Feature<GlobalBiomeFeature.Config> GLOBAL = createFeature("global", new GlobalBiomeFeature());

    public static final Feature<NoneFeatureConfiguration> DUMMY_TREE = createFeature("dummy_tree", new SmallPineTree(NoneFeatureConfiguration.CODEC.stable()));
    public static final Feature<NoneFeatureConfiguration> BEEHIVE = createFeature("beehive", new BeeHiveFeature(NoneFeatureConfiguration.CODEC.stable()));
    public static final Feature<NoneFeatureConfiguration> HUH = createFeature("river_feature", new RiverThingy(NoneFeatureConfiguration.CODEC.stable()));
    public static final Feature<SimpleBlockProviderConfig> VOLCANO = createFeature("volcano", new VolcanoFeature(SimpleBlockProviderConfig.CODEC.stable()));
    public static final Feature<SimpleBlockProviderConfig> CRAG_FEATURE = createFeature("crag_feature", new CragFeature(SimpleBlockProviderConfig.CODEC.stable()));
    public static final Feature<SimpleBlockProviderConfig> ARCH = createFeature("arch", new ArchFeature(SimpleBlockProviderConfig.CODEC.stable()));
    public static final Feature<NoneFeatureConfiguration> DUNE_TERRAIN = createFeature("dune_terrain", new DuneFeature(NoneFeatureConfiguration.CODEC.stable()));

    public static final Feature<SimpleBlockProviderConfig> PURPUR_PEAK = createFeature("purpur_peak", new PurpurPeak(SimpleBlockProviderConfig.CODEC.stable()));
    public static final Feature<SimpleBlockProviderConfig> SPIKE = createFeature("spike", new SpikeFeature(SimpleBlockProviderConfig.CODEC.stable()));
    public static final Feature<NoisySphereConfig> NOISY_CAVE_SPHERE = createFeature("noisy_cave_sphere", new NoisyCaveSphere(NoisySphereConfig.CODEC.stable()));
    public static final Boulder BOULDER = createFeature("boulder", new Boulder(NoisySphereConfig.CODEC.stable()));
    public static final Feature<NoisySphereConfig> NOISY_CAVE_SPHERE_WATER = createFeature("noisy_cave_sphere_water", new NoisyCaveSphereWater(NoisySphereConfig.CODEC.stable()));
    public static final Feature<NoisySphereConfig> NOISE_SPHERE = createFeature("sphere", new NoiseSphere(NoisySphereConfig.CODEC.stable()));
    public static final Feature<NoisySphereConfig> NOISE_SPIKE = createFeature("noise_spike", new Spike(NoisySphereConfig.CODEC.stable()));
    public static final Feature<TreeFromStructureNBTConfig> BYG_TREE_FROM_NBT = createFeature("byg_tree_from_nbt", new TreeFromStructureNBTFeature(TreeFromStructureNBTConfig.CODEC.stable()));

    /********************************************************************Features*************************************************************************/
    //DeadSea
    public static final Feature<PointyRockConfig> POINTY_ROCK = createFeature("pointed_rock", new PointyRockFeature(PointyRockConfig.CODEC.stable()));
    public static final Feature<PointyRockConfig> TALL_POINTED_ROCK = createFeature("tall_pointed_rock", new TallPointedRocks(PointyRockConfig.CODEC.stable()));

    //Lakes
    public static final Feature<BlockStateConfiguration> FROSTED_LAKE = createFeature("frosted_lake", new FrostMagmaLakeFeature(BlockStateConfiguration.CODEC.stable()));
    public static final Feature<SimpleBlockProviderConfig> WIDE_LAKE = createFeature("wide_lake", new WideLake(SimpleBlockProviderConfig.CODEC.stable()));
    public static final Feature<NoneFeatureConfiguration> END_LAKE = createFeature("end_lake", new EndLakeFeature());
    public static final Feature<LargeLakeFeatureConfig> LARGE_LAKE = createFeature("overworld_lake", new LargeLakeFeature(LargeLakeFeatureConfig.CODEC));

    //Pumpkins
    public static final Feature<PumpkinConfig> LARGE_PUMPKIN1 = createFeature("pumpkin", new LargePumpkin1(PumpkinConfig.CODEC.stable()));
    public static final Feature<PumpkinConfig> LARGE_PUMPKIN2 = createFeature("pumpkin2", new LargePumpkin2(PumpkinConfig.CODEC.stable()));

    /*********************************************************************Large Flower Features***********************************************************/
    public static final BYGAbstractGiantFlowerFeature<GiantFlowerConfig> GIANT_ANGELICA_FLOWER = createFeature("giant_angelica_flower", new AngelicaGiant(GiantFlowerConfig.CODEC.stable()));
    public static final BYGAbstractGiantFlowerFeature<GiantFlowerConfig> GIANT_DANDELION_FLOWER = createFeature("giant_dandelion_flower", new DandelionGiant(GiantFlowerConfig.CODEC.stable()));
    public static final BYGAbstractGiantFlowerFeature<GiantFlowerConfig> GIANT_IRIS_FLOWER = createFeature("giant_iris_flower", new IrisGiant(GiantFlowerConfig.CODEC.stable()));
    public static final BYGAbstractGiantFlowerFeature<GiantFlowerConfig> GIANT_ROSE_FLOWER = createFeature("giant_rose", new RoseGiant(GiantFlowerConfig.CODEC.stable()));


    /*********************************************************************Large Mushroom Features*********************************************************/
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> GREEN_MUSHROOM_HUGE = createFeature("green_mushroom_huge", new GreenMushroomHuge(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> WOOD_BLEWIT_HUGE = createFeature("wood_blewit_huge", new WoodBlewitHuge(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> WEEPING_MILKCAP_HUGE = createFeature("weeping_milkcap_huge", new WeepingMilkcapHuge(BYGMushroomConfig.CODEC.stable()));

    /*********************************************************************Mini Mushroom Features*********************************************************/
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> MINI_GREEN_MUSHROOM = createFeature("mini_green_mushroom", new MiniGreenMushroom(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> MINI_RED_MUSHROOM = createFeature("mini_red_mushroom", new MiniRedMushroom(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> MINI_BROWN_MUSHROOM = createFeature("mini_brown_mushroom", new MiniBrownMushroom(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> MINI_WEEPING_MILKCAP = createFeature("mini_weeping_milkcap", new MiniWeepingMilkcap(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> MINI_WOOD_BLEWIT = createFeature("mini_wood_blewit", new MiniWoodBlewit(BYGMushroomConfig.CODEC.stable()));

    /********************************************************************End Features********************************************************************/
    //Bulbis
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> BULBIS_BUSH1 = createFeature("bulbis_bush1", new BulbisBush1(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> BULBIS_TREE1 = createFeature("bulbis_tree1", new BulbisTree1(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> BULBIS_TREE2 = createFeature("bulbis_tree2", new BulbisTree2(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> BULBIS_TREE3 = createFeature("bulbis_tree3", new BulbisTree3(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> BULBIS_TREE4 = createFeature("bulbis_tree4", new BulbisTree4(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> BULBIS_TREE5 = createFeature("bulbis_tree5", new BulbisTree5(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> BULBIS_TREE6 = createFeature("bulbis_tree6", new BulbisTree6(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> BULBIS_TREE7 = createFeature("bulbis_tree7", new BulbisTree7(BYGMushroomConfig.CODEC.stable()));

    //Ether
    public static final BYGAbstractTreeFeature<BYGTreeConfig> DEAD_ETHER_TREE1 = createFeature("dead_ether_tree1", new DeadEtherTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> DEAD_ETHER_TREE2 = createFeature("dead_ether_tree2", new DeadEtherTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> DEAD_ETHER_TREE3 = createFeature("dead_ether_tree3", new DeadEtherTree3(BYGTreeConfig.CODEC.stable()));

    public static final BYGAbstractTreeFeature<BYGTreeConfig> ETHER_BUSH1 = createFeature("ether_bush1", new EtherBush1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ETHER_BUSH2 = createFeature("ether_bush2", new EtherBush2(BYGTreeConfig.CODEC.stable()));

    public static final BYGAbstractTreeFeature<BYGTreeConfig> ETHER_TREE1 = createFeature("ether_tree1", new EtherTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ETHER_TREE2 = createFeature("ether_tree2", new EtherTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ETHER_TREE3 = createFeature("ether_tree3", new EtherTree3(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ETHER_TREE4 = createFeature("ether_tree4", new EtherTree4(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ETHER_TREE5 = createFeature("ether_tree5", new EtherTree5(BYGTreeConfig.CODEC.stable()));

    //Nightshade
    public static final BYGAbstractTreeFeature<BYGTreeConfig> NIGHTSHADE_BUSH1 = createFeature("nightshade_bush1", new NightshadeBush1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> NIGHTSHADE_BUSH2 = createFeature("nightshade_bush2", new NightshadeBush2(BYGTreeConfig.CODEC.stable()));

    public static final BYGAbstractTreeFeature<BYGTreeConfig> NIGHTSHADE_TREE1 = createFeature("nightshade_tree1", new NightshadeTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> NIGHTSHADE_TREE2 = createFeature("nightshade_tree2", new NightshadeTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> NIGHTSHADE_TREE3 = createFeature("nightshade_tree3", new NightshadeTree3(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> NIGHTSHADE_TREE4 = createFeature("nightshade_tree4", new NightshadeTree4(BYGTreeConfig.CODEC.stable()));

    //Shulkren
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> SHULKREN_TREE1 = createFeature("shulkren_tree1", new ShulkrenTree1(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> SHULKREN_TREE2 = createFeature("shulkren_tree2", new ShulkrenTree2(BYGMushroomConfig.CODEC.stable()));

    //Imparius
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> IMPARIUS_MUSHROOM1 = createFeature("imparius_mushroom1", new ImpariusMushroom1(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> IMPARIUS_MUSHROOM2 = createFeature("imparius_mushroom2", new ImpariusMushroom2(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> IMPARIUS_MUSHROOM3 = createFeature("imparius_mushroom3", new ImpariusMushroom3(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> IMPARIUS_MUSHROOM4 = createFeature("imparius_mushroom4", new ImpariusMushroom4(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> IMPARIUS_MUSHROOM5 = createFeature("imparius_mushroom5", new ImpariusMushroom5(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> IMPARIUS_MUSHROOM6 = createFeature("imparius_mushroom6", new ImpariusMushroom6(BYGMushroomConfig.CODEC.stable()));

    //Fungal Imparius
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> FUNGAL_IMPARIUS1 = createFeature("fungal_imparius1", new FungalImparius1(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> FUNGAL_IMPARIUS2 = createFeature("fungal_imparius2", new FungalImparius2(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> FUNGAL_IMPARIUS3 = createFeature("fungal_imparius3", new FungalImparius3(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> FUNGAL_IMPARIUS4 = createFeature("fungal_imparius4", new FungalImparius4(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> FUNGAL_IMPARIUS5 = createFeature("fungal_imparius5", new FungalImparius5(BYGMushroomConfig.CODEC.stable()));

    public static final Feature<FloatingIslandConfig> FLOATING_ISLAND1 = createFeature("floating_island1", new FloatingIslands1(FloatingIslandConfig.CODEC.stable()));
    public static final Feature<FloatingIslandConfig> FLOATING_ISLAND2 = createFeature("floating_island2", new FloatingIslands2(FloatingIslandConfig.CODEC.stable()));
    public static final Feature<FloatingIslandConfig> FLOATING_ISLAND3 = createFeature("floating_island3", new FloatingIslands3(FloatingIslandConfig.CODEC.stable()));
    public static final Feature<FloatingIslandConfig> FLOATING_ISLAND4 = createFeature("hollow_floating_island", new FloatingIslands4(FloatingIslandConfig.CODEC.stable()));
    public static final Feature<FloatingIslandConfig> FLOATING_ISLAND5 = createFeature("floating_island5", new FloatingIslands5(FloatingIslandConfig.CODEC.stable()));

    public static final Feature<FloatingIslandConfig> SHATTERED_FLOATING_ISLAND1 = createFeature("shattered_floating_island1", new ShatteredFloatingIslands1(FloatingIslandConfig.CODEC.stable()));
    public static final Feature<FloatingIslandConfig> SHATTERED_FLOATING_ISLAND2 = createFeature("shattered_floating_island2", new ShatteredFloatingIslands2(FloatingIslandConfig.CODEC.stable()));
    public static final Feature<FloatingIslandConfig> SHATTERED_FLOATING_ISLAND3 = createFeature("shattered_floating_island3", new ShatteredFloatingIslands3(FloatingIslandConfig.CODEC.stable()));
    public static final Feature<FloatingIslandConfig> SHATTERED_FLOATING_ISLAND4 = createFeature("shattered_hollow_floating_island", new ShatteredFloatingIslands4(FloatingIslandConfig.CODEC.stable()));


    /********************************************************************Nether Features********************************************************************/

    //SoulShroom
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> SOUL_SHROOM_TREE1 = createFeature("soul_shroom_tree1", new SoulShroomTree1(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> SOUL_SHROOM_TREE2 = createFeature("soul_shroom_tree2", new SoulShroomTree2(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> SOUL_SHROOM_TREE3 = createFeature("soul_shroom_tree3", new SoulShroomTree3(BYGMushroomConfig.CODEC.stable()));

    //DeathCap
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> DEATH_CAP_TREE1 = createFeature("death_cap_tree1", new DeathCapTree1(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> DEATH_CAP_TREE2 = createFeature("death_cap_tree2", new DeathCapTree2(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> DEATH_CAP_TREE3 = createFeature("death_cap_tree3", new DeathCapTree3(BYGMushroomConfig.CODEC.stable()));

    //Lament
    public static final BYGAbstractTreeFeature<BYGTreeConfig> LAMENT_WEEPING_TREE1 = createFeature("lament_weeping_tree1", new LamentWeepingTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> LAMENT_WEEPING_TREE2 = createFeature("lament_weeping_tree2", new LamentWeepingTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> LAMENT_WEEPING_TREE3 = createFeature("lament_weeping_tree3", new LamentWeepingTree3(BYGTreeConfig.CODEC.stable()));

    public static final BYGAbstractTreeFeature<BYGTreeConfig> LAMENT_TWISTY_TREE1 = createFeature("lament_twisty_tree1", new LamentTwistyTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> LAMENT_TWISTY_TREE2 = createFeature("lament_twisty_tree2", new LamentTwistyTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> LAMENT_TWISTY_TREE3 = createFeature("lament_twisty_tree3", new LamentTwistyTree3(BYGTreeConfig.CODEC.stable()));

    //Withering Oak
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> WITHERING_OAK_TREE1 = createFeature("withering_oak_tree1", new WitheringOakTree1(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> WITHERING_OAK_TREE2 = createFeature("withering_oak_tree2", new WitheringOakTree2(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> WITHERING_OAK_TREE3 = createFeature("withering_oak_tree3", new WitheringOakTree3(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> WITHERING_OAK_TREE4 = createFeature("withering_oak_tree4", new WitheringOakTree4(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> WITHERING_OAK_TREE5 = createFeature("withering_oak_tree5", new WitheringOakTree5(BYGMushroomConfig.CODEC.stable()));

    //QuartzDesert
    public static final Feature<HangingColumnWithBaseConfig> HANGING_FEATURE = createFeature("hanging_feature", new HangingColumnWithBase(HangingColumnWithBaseConfig.CODEC.stable()));

    //Sythian
    public static final Feature<ProbabilityFeatureConfiguration> SYTHIAN_STALK = createFeature("sythian_stalk", new SythianStalk(ProbabilityFeatureConfiguration.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> SYTHIAN_FUNGUS_TREE1 = createFeature("sythian_fungus_tree1", new SythianFungusTree1(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> SYTHIAN_FUNGUS_TREE2 = createFeature("sythian_fungus_tree2", new SythianFungusTree2(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> SYTHIAN_FUNGUS_TREE3 = createFeature("sythian_fungus_tree3", new SythianFungusTree3(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> SYTHIAN_FUNGUS_TREE4 = createFeature("sythian_fungus_tree4", new SythianFungusTree4(BYGMushroomConfig.CODEC.stable()));

    //Warped
    public static final Feature<WhitelistedSimpleBlockProviderConfig> HUGE_WARPED_CORAL_PLANT = createFeature("warped_coral_plant", new WarpedCoralFeature(WhitelistedSimpleBlockProviderConfig.CODEC.stable()));
    public static final Feature<SimpleBlockProviderConfig> PILLARS = createFeature("pillar", new ConfigurablePillar(SimpleBlockProviderConfig.CODEC.stable()));

    //Chains
    public static final Feature<ChainConfig> CHAIN = createFeature("chain", new Chain(ChainConfig.CODEC.stable()));

    //Crimson Gardens
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> CRIMSON_FUNGUS_TREE1 = createFeature("crimson_fungus_tree1", new CrimsonFungus1(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> CRIMSON_FUNGUS_TREE2 = createFeature("crimson_fungus_tree2", new CrimsonFungus2(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> WARPED_FUNGUS_TREE1 = createFeature("warped_fungus_tree1", new WarpedFungus1(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> WARPED_FUNGUS_TREE2 = createFeature("warped_fungus_tree2", new WarpedFungus2(BYGMushroomConfig.CODEC.stable()));

    //Wailing
    public static final Feature<NoneFeatureConfiguration> WAILING_VINES = createFeature("wailing_vine", new WailingVine(NoneFeatureConfiguration.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> WAILING_PILLAR1 = createFeature("wailing_pillar1", new WailingPillar1(BYGTreeConfig.CODEC.stable()));

    //Embur
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> EMBUR_MUSHROOM = createFeature("embur_mushroom1", new EmburMushroom(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> EMBUR_MUSHROOM2 = createFeature("embur_mushroom2", new EmburMushroom2(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> EMBUR_MUSHROOM3 = createFeature("embur_mushroom3", new EmburMushroom3(BYGMushroomConfig.CODEC.stable()));
    public static final BYGAbstractMushroomFeature<BYGMushroomConfig> EMBUR_MUSHROOM4 = createFeature("embur_mushroom4", new EmburMushroom4(BYGMushroomConfig.CODEC.stable()));

    public static final Feature<BrimstoneVentsConfig> BRIMSTONE_VENT_FEATURE = createFeature("brimstone_vent", new BrimstoneVentFeature(BrimstoneVentsConfig.CODEC.stable()));

    public static final Feature<HangingColumnConfig> HANGING_COLUMN = createFeature("hanging_column", new HangingColumn(HangingColumnConfig.CODEC.stable()));

    //QuartzDesert
    public static final Feature<ColumnFeatureConfiguration> QUARTZ_COLUMNS = createFeature("quartz_columns", new RawQuartzColumnFeature(ColumnFeatureConfiguration.CODEC.stable()));
    public static final Feature<QuartzSpikeConfig> QUARTZ_SPIKES = createFeature("quartz_spikes", new QuartzSpikeFeature(QuartzSpikeConfig.CODEC.stable()));

    //Subzero
    public static final Feature<NoneFeatureConfiguration> SUBZERO_CRYSTAL = createFeature("subzero_crystal", new SubzeroCrystalFeature(NoneFeatureConfiguration.CODEC.stable()));

    /********************************************************************Structures***********************************************************************/


    /********************************************************************Tree Features********************************************************************/

    //Default
    public static final BYGAbstractTreeFeature<BYGTreeConfig> BASIC_TREE = createFeature("tree", new BasicTree(BYGTreeConfig.CODEC.stable()));

    //Araucaria
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ARAUCARIA_TREE1 = createFeature("araucaria_tree1", new AraucariaTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ARAUCARIA_TREE2 = createFeature("araucaria_tree2", new AraucariaTree2(BYGTreeConfig.CODEC.stable()));

    //Ancient
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ANCIENT_TREE1 = createFeature("ancient_tree1", new AncientTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ANCIENT_TREE2 = createFeature("ancient_tree2", new AncientTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ANCIENT_TREE3 = createFeature("ancient_tree3", new AncientTree3(BYGTreeConfig.CODEC.stable()));

    //Aspen
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ASPEN_TREE1 = createFeature("aspen_tree1", new AspenTree(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ASPEN_TREE2 = createFeature("aspen_tree2", new AspenTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ASPEN_TREE3 = createFeature("aspen_tree3", new AspenTree3(BYGTreeConfig.CODEC.stable()));

    //Baobab
    public static final BYGAbstractTreeFeature<BYGTreeConfig> BAOBAB_TREE1 = createFeature("baobab_tree1", new BaobabTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> BAOBAB_TREE2 = createFeature("baobab_tree2", new BaobabTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> BAOBAB_TREE3 = createFeature("baobab_tree3", new BaobabTree3(BYGTreeConfig.CODEC.stable()));

    //Birch
    public static final BYGAbstractTreeFeature<BYGTreeConfig> BIRCH_TREE1 = createFeature("birch_tree1", new BirchTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> BIRCH_TREE2 = createFeature("birch_tree2", new BirchTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> BIRCH_TREE3 = createFeature("birch_tree3", new BirchTree3(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> BIRCH_TREE4 = createFeature("birch_tree4", new BirchTree4(BYGTreeConfig.CODEC.stable()));

    //Bluff
    public static final BYGAbstractTreeFeature<BYGTreeConfig> BLUFF_TREE1 = createFeature("bluff_tree1", new BluffTree(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> BLUFF_TREE2 = createFeature("bluff_tree2", new BluffTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> BLUFF_TREE3 = createFeature("bluff_tree3", new BluffTree3(BYGTreeConfig.CODEC.stable()));

    //Boreal Trees
    public static final BYGAbstractTreeFeature<BYGTreeConfig> BOREAL_TREE1 = createFeature("boreal_tree1", new BorealForestTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> BOREAL_TREE2 = createFeature("boreal_tree2", new BorealForestTree2(BYGTreeConfig.CODEC.stable()));

    //Cherry
    public static final BYGAbstractTreeFeature<BYGTreeConfig> CHERRY_TREE1 = createFeature("cherry_tree1", new CherryTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> CHERRY_TREE2 = createFeature("cherry_tree2", new CherryTree2(BYGTreeConfig.CODEC.stable()));

    //Cika
    public static final BYGAbstractTreeFeature<BYGTreeConfig> CIKA_TREE1 = createFeature("cika_tree1", new CikaTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> CIKA_TREE2 = createFeature("cika_tree2", new CikaTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> CIKA_TREE3 = createFeature("cika_tree3", new CikaTree3(BYGTreeConfig.CODEC.stable()));

    //Coniferous
    public static final BYGAbstractTreeFeature<BYGTreeConfig> CONIFER_TREE1 = createFeature("conifer_tree1", new ConiferTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> CONIFER_TREE2 = createFeature("conifer_tree2", new ConiferTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> CONIFER_TREE3 = createFeature("conifer_tree3", new ConiferTree3(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> CONIFER_TREE4 = createFeature("conifer_tree4", new ConiferTree4(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> CONIFER_TREE5 = createFeature("conifer_tree5", new ConiferTree5(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> CONIFER_TREE6 = createFeature("conifer_tree6", new ConiferTree6(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> CONIFER_TREE7 = createFeature("conifer_tree7", new ConiferTree7(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> CONIFER_TREE8 = createFeature("conifer_tree8", new ConiferTree8(BYGTreeConfig.CODEC.stable()));

    //Cypress
    public static final BYGAbstractTreeFeature<BYGTreeConfig> CYPRESS_TREE1 = createFeature("cypress_tree1", new CypressTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> CYPRESS_TREE2 = createFeature("cypress_tree2", new CypressTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> CYPRESS_TREE3 = createFeature("cypress_tree3", new CypressTree3(BYGTreeConfig.CODEC.stable()));

    //Dead Hazel
    public static final BYGAbstractTreeFeature<BYGTreeConfig> HAZEL_TREE1 = createFeature("hazel_tree1", new HazelTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> HAZEL_TREE2 = createFeature("hazel_tree2", new HazelTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> DEAD_HAZEL_TREE1 = createFeature("dead_hazel_tree1", new DeadHazelTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> DEAD_HAZEL_TREE2 = createFeature("dead_hazel_tree2", new DeadHazelTree2(BYGTreeConfig.CODEC.stable()));

    //Deciduous
    public static final BYGAbstractTreeFeature<BYGTreeConfig> DECIDUOUS_TREE1 = createFeature("deciduous_tree1", new DeciduousTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> DECIDUOUS_TREE2 = createFeature("deciduous_tree2", new DeciduousTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> DECIDUOUS_TREE3 = createFeature("deciduous_tree3", new DeciduousTree3(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> DECIDUOUS_TREE4 = createFeature("deciduous_tree4", new DeciduousTree4(BYGTreeConfig.CODEC.stable()));

    //Ebony
    public static final BYGAbstractTreeFeature<BYGTreeConfig> EBONY_BUSH1 = createFeature("ebony_bush", new EbonyBush1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> EBONY_TREE1 = createFeature("ebony_tree1", new EbonyTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> EBONY_TREE2 = createFeature("ebony_tree2", new EbonyTree2(BYGTreeConfig.CODEC.stable()));

    //Enchanted Trees
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ENCHANTED_TREE1 = createFeature("enchanted_tree1", new EnchantedTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ENCHANTED_TREE2 = createFeature("enchanted_tree2", new EnchantedTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ENCHANTED_TREE3 = createFeature("enchanted_tree3", new EnchantedTree3(BYGTreeConfig.CODEC.stable()));

    public static final BYGAbstractTreeFeature<BYGTreeConfig> ENCHANTED_GROVE_TREE1 = createFeature("enchanted_grove_tree1", new EnchantedGroveTree(BYGTreeConfig.CODEC.stable()));

    //Holly
    public static final BYGAbstractTreeFeature<BYGTreeConfig> HOLLY_TREE1 = createFeature("holly_tree1", new HollyTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> HOLLY_TREE2 = createFeature("holly_tree2", new HollyTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> HOLLY_TREE3 = createFeature("holly_tree3", new HollyTree3(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> HOLLY_TREE4 = createFeature("holly_tree4", new HollyTree4(BYGTreeConfig.CODEC.stable()));

    //Jacaranda
    public static final BYGAbstractTreeFeature<BYGTreeConfig> JACARANDA_TREE1 = createFeature("jacaranda_tree1", new JacarandaTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> JACARANDA_TREE2 = createFeature("jacaranda_tree2", new JacarandaTree2(BYGTreeConfig.CODEC.stable()));

    //JoshuaTree
    public static final BYGAbstractTreeFeature<BYGTreeConfig> JOSHUA_TREE1 = createFeature("joshua_tree1", new JoshuaTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> JOSHUA_TREE2 = createFeature("joshua_tree2", new JoshuaTree2(BYGTreeConfig.CODEC.stable()));

    //Mangrove
    public static final BYGAbstractTreeFeature<BYGTreeConfig> MANGROVE_TREE1 = createFeature("mangrove_tree1", new MangroveTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> MANGROVE_TREE2 = createFeature("mangrove_tree2", new MangroveTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> MANGROVE_TREE3 = createFeature("mangrove_tree3", new MangroveTree3(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> MANGROVE_TREE4 = createFeature("mangrove_tree4", new MangroveTree4(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> MANGROVE_TREE5 = createFeature("mangrove_tree5", new MangroveTree5(BYGTreeConfig.CODEC.stable()));

    //Maple
    public static final BYGAbstractTreeFeature<BYGTreeConfig> MAPLE_TREE1 = createFeature("maple_tree1", new MapleTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> MAPLE_TREE2 = createFeature("maple_tree2", new MapleTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> MAPLE_TREE3 = createFeature("maple_tree3", new MapleTree3(BYGTreeConfig.CODEC.stable()));

    //Meadow
    public static final BYGAbstractTreeFeature<BYGTreeConfig> MEADOW_TREE1 = createFeature("meadow_tree1", new MeadowTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> MEADOW_TREE2 = createFeature("meadow_tree2", new MeadowTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> MEADOW_TREE3 = createFeature("meadow_tree3", new MeadowTree3(BYGTreeConfig.CODEC.stable()));

    //Oak
    public static final BYGAbstractTreeFeature<BYGTreeConfig> OAK_TREE1 = createFeature("oak_tree1", new OakTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> OAK_TREE2 = createFeature("oak_tree2", new OakTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> OAK_TREE3 = createFeature("oak_tree3", new OakTree3(BYGTreeConfig.CODEC.stable()));

    public static final BYGAbstractTreeFeature<BYGTreeConfig> OAK_TREE_LARGE1 = createFeature("large_oak_tree1", new OakTreeLarge1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> OAK_TREE_LARGE2 = createFeature("large_oak_tree2", new OakTreeLarge2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> OAK_TREE_LARGE3 = createFeature("large_oak_tree3", new OakTreeLarge3(BYGTreeConfig.CODEC.stable()));

    //Orchard
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ORCHARD_TREE1 = createFeature("orchard_tree1", new OrchardTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ORCHARD_TREE2 = createFeature("orchard_tree2", new OrchardTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ORCHARD_TREE3 = createFeature("orchard_tree3", new OrchardTree3(BYGTreeConfig.CODEC.stable()));

    //Palm
    public static final BYGAbstractTreeFeature<BYGTreeConfig> PALM_TREE1 = createFeature("palm_tree1", new PalmTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> PALM_TREE2 = createFeature("palm_tree2", new PalmTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> PALM_TREE3 = createFeature("palm_tree3", new PalmTree3(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> PALM_TREE4 = createFeature("palm_tree4", new PalmTree4(BYGTreeConfig.CODEC.stable()));

    //Pine
    public static final BYGAbstractTreeFeature<BYGTreeConfig> PINE_LARGE_TREE1 = createFeature("large_pine_tree1", new LargePineTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> PINE_LARGE_TREE2 = createFeature("large_pine_tree2", new LargePineTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> PINE_TREE1 = createFeature("pine_tree1", new PineTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> PINE_TREE2 = createFeature("pine_tree2", new PineTree2(BYGTreeConfig.CODEC.stable()));

    //Palo Verde
    public static final BYGAbstractTreeFeature<BYGTreeConfig> PALO_VERDE_TREE1 = createFeature("palo_verde_tree1", new PaloVerdeTree(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> PALO_VERDE_TREE2 = createFeature("palo_verde_tree2", new PaloVerdeTree2(BYGTreeConfig.CODEC.stable()));

    //Rainbow Eucalyptus
    public static final BYGAbstractTreeFeature<BYGTreeConfig> RAINBOW_TREE1 = createFeature("rainbow_eucalyptus_tree", new RainbowEucalyptusTree(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> RAINBOW_LARGE_TREE1 = createFeature("large_rainbow_eucalyptus_tree", new LargeRainbowEucalyptus(BYGTreeConfig.CODEC.stable()));

    //RedWood
    public static final BYGAbstractTreeFeature<BYGTreeConfig> REDWOOD_TREE1 = createFeature("redwood_tree1", new RedwoodTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> REDWOOD_TREE2 = createFeature("redwood_tree2", new RedwoodTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> REDWOOD_TREE3 = createFeature("redwood_tree3", new RedwoodTree3(BYGTreeConfig.CODEC.stable()));

    //Shrubs
    public static final BYGAbstractTreeFeature<BYGTreeConfig> SHRUB1 = createFeature("shrub1", new Shrub1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> SHRUB2 = createFeature("shrub2", new Shrub2(BYGTreeConfig.CODEC.stable()));
    //Skyris
    public static final BYGAbstractTreeFeature<BYGTreeConfig> SKYRIS_TREE1 = createFeature("skyris_tree1", new SkyrisTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> SKYRIS_TREE2 = createFeature("skyris_tree2", new SkyrisTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> SKYRIS_TREE3 = createFeature("skyris_tree3", new SkyrisTree3(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> SKYRIS_TREE4 = createFeature("skyris_tree4", new SkyrisTree4(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> SKYRIS_TREE5 = createFeature("skyris_tree5", new SkyrisTree5(BYGTreeConfig.CODEC.stable()));

    //Spruce
    public static final BYGAbstractTreeFeature<BYGTreeConfig> SPRUCE_TREE_LARGE1 = createFeature("large_spruce_tree1", new SpruceTreeLarge1(BYGTreeConfig.CODEC.stable()));

    public static final BYGAbstractTreeFeature<BYGTreeConfig> SPRUCE_TREE_MEDIUM1 = createFeature("medium_spruce_tree1", new SpruceTreeMedium1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> SPRUCE_TREE_MEDIUM2 = createFeature("medium_spruce_tree2", new SpruceTreeMedium2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> SPRUCE_TREE_MEDIUM3 = createFeature("medium_spruce_tree3", new SpruceTreeMedium3(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> SPRUCE_TREE_MEDIUM4 = createFeature("medium_spruce_tree4", new SpruceTreeMedium4(BYGTreeConfig.CODEC.stable()));

    public static final BYGAbstractTreeFeature<BYGTreeConfig> SPRUCE_TREE1 = createFeature("spruce_tree1", new SpruceTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> SPRUCE_TREE2 = createFeature("spruce_tree2", new SpruceTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> SPRUCE_TREE3 = createFeature("spruce_tree3", new SpruceTree3(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> SPRUCE_TREE4 = createFeature("spruce_tree4", new SpruceTree4(BYGTreeConfig.CODEC.stable()));

    //Mahogany
    public static final BYGAbstractTreeFeature<BYGTreeConfig> MAHOGANY_TREE1 = createFeature("mahogany_tree1", new MahoganyTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> MAHOGANY_TREE2 = createFeature("mahogany_tree2", new MahoganyTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> MAHOGANY_TREE3 = createFeature("mahogany_tree3", new MahoganyTree3(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> MAHOGANY_TREE4 = createFeature("mahogany_tree4", new MahoganyTree4(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> MAHOGANY_TREE5 = createFeature("mahogany_tree5", new MahoganyTree5(BYGTreeConfig.CODEC.stable()));

    //Woodlands
    public static final BYGAbstractTreeFeature<BYGTreeConfig> WOODLANDS_TREE1 = createFeature("woodlands_tree", new WoodlandsTree1(BYGTreeConfig.CODEC.stable()));

    //Willow
    public static final BYGAbstractTreeFeature<BYGTreeConfig> WILLOW_DEAD_TREE1 = createFeature("dead_willow_tree", new WillowDeadTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> WILLOW_TREE1 = createFeature("willow_tree1", new WillowTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> WILLOW_TREE2 = createFeature("willow_tree2", new WillowTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> WILLOW_TREE3 = createFeature("willow_tree3", new WillowTree3(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> WILLOW_TREE4 = createFeature("willow_tree4", new WillowTree4(BYGTreeConfig.CODEC.stable()));

    //Zelkova
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ZELKOVA_TREE1 = createFeature("zelkova_tree1", new ZelkovaTree1(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ZELKOVA_TREE2 = createFeature("zelkova_tree2", new ZelkovaTree2(BYGTreeConfig.CODEC.stable()));
    public static final BYGAbstractTreeFeature<BYGTreeConfig> ZELKOVA_TREE3 = createFeature("zelkova_tree3", new ZelkovaTree3(BYGTreeConfig.CODEC.stable()));

    public static <C extends FeatureConfiguration, F extends Feature<C>> F createFeature(String id, F feature) {
        ResourceLocation bygID = BYG.createLocation(id);
        if (Registry.FEATURE.keySet().contains(bygID))
            throw new IllegalStateException("Feature ID: \"" + bygID.toString() + "\" already exists in the Features registry!");

        BYGFeatures.FEATURES.add(new RegistryObject<>(feature, id));
        return feature;
    }

    public static Collection<RegistryObject<Feature<?>>> bootStrap() {
        return FEATURES;
    }

    static {
        BYG.LOGGER.info("BYG Features class loaded.");
    }
}


