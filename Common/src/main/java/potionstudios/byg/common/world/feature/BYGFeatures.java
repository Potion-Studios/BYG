package potionstudios.byg.common.world.feature;

import net.minecraft.core.registries.Registries;
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
import potionstudios.byg.common.world.feature.gen.overworld.mushrooms.*;
import potionstudios.byg.common.world.feature.gen.overworld.mushrooms.util.BYGAbstractMushroomFeature;
import potionstudios.byg.common.world.feature.gen.overworld.pumpkins.LargePumpkin1;
import potionstudios.byg.common.world.feature.gen.overworld.pumpkins.LargePumpkin2;
import potionstudios.byg.common.world.feature.gen.overworld.trees.util.BYGAbstractTreeFeature;
import potionstudios.byg.common.world.feature.gen.overworld.volcano.VolcanoFeature;
import potionstudios.byg.reg.RegistrationProvider;
import potionstudios.byg.reg.RegistryObject;

import java.util.function.Supplier;

public class BYGFeatures {
    private static final RegistrationProvider<Feature<?>> PROVIDER = RegistrationProvider.get(Registries.FEATURE, BYG.MOD_ID);

    public static final RegistryObject<Feature<GlobalBiomeFeature.Config>> GLOBAL = createFeature("global", GlobalBiomeFeature::new);

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> BEEHIVE = createFeature("beehive", () -> new BeeHiveFeature(NoneFeatureConfiguration.CODEC.stable()));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> HUH = createFeature("river_feature", () -> new RiverThingy(NoneFeatureConfiguration.CODEC.stable()));
    public static final RegistryObject<Feature<SimpleBlockProviderConfig>> VOLCANO = createFeature("volcano", () -> new VolcanoFeature(SimpleBlockProviderConfig.CODEC.stable()));
    public static final RegistryObject<Feature<CragFeatureConfig>> CRAG_FEATURE = createFeature("crag_feature", () -> new CragFeature(CragFeatureConfig.CODEC.stable()));
    public static final RegistryObject<Feature<SimpleBlockProviderConfig>> ARCH = createFeature("arch", () -> new ArchFeature(SimpleBlockProviderConfig.CODEC.stable()));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> DUNE_TERRAIN = createFeature("dune_terrain", () -> new DuneFeature(NoneFeatureConfiguration.CODEC.stable()));

    public static final RegistryObject<Feature<SimpleBlockProviderConfig>> PURPUR_PEAK = createFeature("purpur_peak", () -> new PurpurPeak(SimpleBlockProviderConfig.CODEC.stable()));
    public static final RegistryObject<Feature<SimpleBlockProviderConfig>> SPIKE = createFeature("spike", () -> new SpikeFeature(SimpleBlockProviderConfig.CODEC.stable()));
    public static final RegistryObject<Feature<NoisySphereConfig>> NOISY_CAVE_SPHERE = createFeature("noisy_cave_sphere", () -> new NoisyCaveSphere(NoisySphereConfig.CODEC.stable()));
    public static final RegistryObject<Boulder> BOULDER = createFeature("boulder", () -> new Boulder(NoisySphereConfig.CODEC.stable()));
    public static final RegistryObject<Feature<NoisySphereConfig>> NOISY_CAVE_SPHERE_WATER = createFeature("noisy_cave_sphere_water", () -> new NoisyCaveSphereWater(NoisySphereConfig.CODEC.stable()));
    public static final RegistryObject<Feature<NoisySphereConfig>> NOISE_SPHERE = createFeature("sphere", () -> new NoiseSphere(NoisySphereConfig.CODEC.stable()));
    public static final RegistryObject<Feature<NoisySphereConfig>> NOISE_SPIKE = createFeature("noise_spike", () -> new Spike(NoisySphereConfig.CODEC.stable()));

    /********************************************************************Features*************************************************************************/
    //DeadSea
    public static final RegistryObject<Feature<PointyRockConfig>> POINTY_ROCK = createFeature("pointed_rock", () -> new PointyRockFeature(PointyRockConfig.CODEC.stable()));
    public static final RegistryObject<Feature<PointyRockConfig>> TALL_POINTED_ROCK = createFeature("tall_pointed_rock", () -> new TallPointedRocks(PointyRockConfig.CODEC.stable()));

    //Lakes
    public static final RegistryObject<Feature<BlockStateConfiguration>> FROSTED_LAKE = createFeature("frosted_lake", () -> new FrostMagmaLakeFeature(BlockStateConfiguration.CODEC.stable()));
    public static final RegistryObject<Feature<SimpleBlockProviderConfig>> WIDE_LAKE = createFeature("wide_lake", () -> new WideLake(SimpleBlockProviderConfig.CODEC.stable()));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> END_LAKE = createFeature("end_lake", EndLakeFeature::new);
    public static final RegistryObject<Feature<LargeLakeFeatureConfig>> LARGE_LAKE = createFeature("overworld_lake", () -> new LargeLakeFeature(LargeLakeFeatureConfig.CODEC));

    //Pumpkins
    public static final RegistryObject<Feature<PumpkinConfig>> LARGE_PUMPKIN1 = createFeature("pumpkin", () -> new LargePumpkin1(PumpkinConfig.CODEC.stable()));
    public static final RegistryObject<Feature<PumpkinConfig>> LARGE_PUMPKIN2 = createFeature("pumpkin2", () -> new LargePumpkin2(PumpkinConfig.CODEC.stable()));


    /*********************************************************************Large Mushroom Features*********************************************************/
    public static final RegistryObject<BYGAbstractMushroomFeature<BYGMushroomConfig>> GREEN_MUSHROOM_HUGE = createFeature("green_mushroom_huge", () -> new GreenMushroomHuge(BYGMushroomConfig.CODEC.stable()));
    public static final RegistryObject<BYGAbstractMushroomFeature<BYGMushroomConfig>> WOOD_BLEWIT_HUGE = createFeature("wood_blewit_huge", () -> new WoodBlewitHuge(BYGMushroomConfig.CODEC.stable()));
    public static final RegistryObject<BYGAbstractMushroomFeature<BYGMushroomConfig>> WEEPING_MILKCAP_HUGE = createFeature("weeping_milkcap_huge", () -> new WeepingMilkcapHuge(BYGMushroomConfig.CODEC.stable()));

    /*********************************************************************Mini Mushroom Features*********************************************************/
    public static final RegistryObject<BYGAbstractMushroomFeature<BYGMushroomConfig>> MINI_GREEN_MUSHROOM = createFeature("mini_green_mushroom", () -> new MiniGreenMushroom(BYGMushroomConfig.CODEC.stable()));
    public static final RegistryObject<BYGAbstractMushroomFeature<BYGMushroomConfig>> MINI_RED_MUSHROOM = createFeature("mini_red_mushroom", () -> new MiniRedMushroom(BYGMushroomConfig.CODEC.stable()));
    public static final RegistryObject<BYGAbstractMushroomFeature<BYGMushroomConfig>> MINI_BROWN_MUSHROOM = createFeature("mini_brown_mushroom", () -> new MiniBrownMushroom(BYGMushroomConfig.CODEC.stable()));
    public static final RegistryObject<BYGAbstractMushroomFeature<BYGMushroomConfig>> MINI_WEEPING_MILKCAP = createFeature("mini_weeping_milkcap", () -> new MiniWeepingMilkcap(BYGMushroomConfig.CODEC.stable()));
    public static final RegistryObject<BYGAbstractMushroomFeature<BYGMushroomConfig>> MINI_WOOD_BLEWIT = createFeature("mini_wood_blewit", () -> new MiniWoodBlewit(BYGMushroomConfig.CODEC.stable()));

    /********************************************************************End Features********************************************************************/

    public static final RegistryObject<Feature<FloatingIslandConfig>> FLOATING_ISLAND1 = createFeature("floating_island1", () -> new FloatingIslands1(FloatingIslandConfig.CODEC.stable()));
    public static final RegistryObject<Feature<FloatingIslandConfig>> FLOATING_ISLAND2 = createFeature("floating_island2", () -> new FloatingIslands2(FloatingIslandConfig.CODEC.stable()));
    public static final RegistryObject<Feature<FloatingIslandConfig>> FLOATING_ISLAND3 = createFeature("floating_island3", () -> new FloatingIslands3(FloatingIslandConfig.CODEC.stable()));
    public static final RegistryObject<Feature<FloatingIslandConfig>> FLOATING_ISLAND4 = createFeature("hollow_floating_island", () -> new FloatingIslands4(FloatingIslandConfig.CODEC.stable()));
    public static final RegistryObject<Feature<FloatingIslandConfig>> FLOATING_ISLAND5 = createFeature("floating_island5", () -> new FloatingIslands5(FloatingIslandConfig.CODEC.stable()));

    public static final RegistryObject<Feature<FloatingIslandConfig>> SHATTERED_FLOATING_ISLAND1 = createFeature("shattered_floating_island1", () -> new ShatteredFloatingIslands1(FloatingIslandConfig.CODEC.stable()));
    public static final RegistryObject<Feature<FloatingIslandConfig>> SHATTERED_FLOATING_ISLAND2 = createFeature("shattered_floating_island2", () -> new ShatteredFloatingIslands2(FloatingIslandConfig.CODEC.stable()));
    public static final RegistryObject<Feature<FloatingIslandConfig>> SHATTERED_FLOATING_ISLAND3 = createFeature("shattered_floating_island3", () -> new ShatteredFloatingIslands3(FloatingIslandConfig.CODEC.stable()));
    public static final RegistryObject<Feature<FloatingIslandConfig>> SHATTERED_FLOATING_ISLAND4 = createFeature("shattered_hollow_floating_island", () -> new ShatteredFloatingIslands4(FloatingIslandConfig.CODEC.stable()));


    /********************************************************************Nether Features********************************************************************/

    //SoulShroom
    public static final RegistryObject<BYGAbstractMushroomFeature<BYGMushroomConfig>> SOUL_SHROOM_TREE1 = createFeature("soul_shroom_tree1", () -> new SoulShroomTree1(BYGMushroomConfig.CODEC.stable()));
    public static final RegistryObject<BYGAbstractMushroomFeature<BYGMushroomConfig>> SOUL_SHROOM_TREE2 = createFeature("soul_shroom_tree2", () -> new SoulShroomTree2(BYGMushroomConfig.CODEC.stable()));
    public static final RegistryObject<BYGAbstractMushroomFeature<BYGMushroomConfig>> SOUL_SHROOM_TREE3 = createFeature("soul_shroom_tree3", () -> new SoulShroomTree3(BYGMushroomConfig.CODEC.stable()));

    //DeathCap
    public static final RegistryObject<BYGAbstractMushroomFeature<BYGMushroomConfig>> DEATH_CAP_TREE1 = createFeature("death_cap_tree1", () -> new DeathCapTree1(BYGMushroomConfig.CODEC.stable()));
    public static final RegistryObject<BYGAbstractMushroomFeature<BYGMushroomConfig>> DEATH_CAP_TREE2 = createFeature("death_cap_tree2", () -> new DeathCapTree2(BYGMushroomConfig.CODEC.stable()));
    public static final RegistryObject<BYGAbstractMushroomFeature<BYGMushroomConfig>> DEATH_CAP_TREE3 = createFeature("death_cap_tree3", () -> new DeathCapTree3(BYGMushroomConfig.CODEC.stable()));

    //Lament
    public static final RegistryObject<BYGAbstractTreeFeature<BYGTreeConfig>> LAMENT_WEEPING_TREE1 = createFeature("lament_weeping_tree1", () -> new LamentWeepingTree1(BYGTreeConfig.CODEC.stable()));
    public static final RegistryObject<BYGAbstractTreeFeature<BYGTreeConfig>> LAMENT_WEEPING_TREE2 = createFeature("lament_weeping_tree2", () -> new LamentWeepingTree2(BYGTreeConfig.CODEC.stable()));
    public static final RegistryObject<BYGAbstractTreeFeature<BYGTreeConfig>> LAMENT_WEEPING_TREE3 = createFeature("lament_weeping_tree3", () -> new LamentWeepingTree3(BYGTreeConfig.CODEC.stable()));

    public static final RegistryObject<BYGAbstractTreeFeature<BYGTreeConfig>> LAMENT_TWISTY_TREE1 = createFeature("lament_twisty_tree1", () -> new LamentTwistyTree1(BYGTreeConfig.CODEC.stable()));
    public static final RegistryObject<BYGAbstractTreeFeature<BYGTreeConfig>> LAMENT_TWISTY_TREE2 = createFeature("lament_twisty_tree2", () -> new LamentTwistyTree2(BYGTreeConfig.CODEC.stable()));
    public static final RegistryObject<BYGAbstractTreeFeature<BYGTreeConfig>> LAMENT_TWISTY_TREE3 = createFeature("lament_twisty_tree3", () -> new LamentTwistyTree3(BYGTreeConfig.CODEC.stable()));

    //Withering Oak
    public static final RegistryObject<BYGAbstractMushroomFeature<BYGMushroomConfig>> WITHERING_OAK_TREE1 = createFeature("withering_oak_tree1", () -> new WitheringOakTree1(BYGMushroomConfig.CODEC.stable()));
    public static final RegistryObject<BYGAbstractMushroomFeature<BYGMushroomConfig>> WITHERING_OAK_TREE2 = createFeature("withering_oak_tree2", () -> new WitheringOakTree2(BYGMushroomConfig.CODEC.stable()));
    public static final RegistryObject<BYGAbstractMushroomFeature<BYGMushroomConfig>> WITHERING_OAK_TREE3 = createFeature("withering_oak_tree3", () -> new WitheringOakTree3(BYGMushroomConfig.CODEC.stable()));
    public static final RegistryObject<BYGAbstractMushroomFeature<BYGMushroomConfig>> WITHERING_OAK_TREE4 = createFeature("withering_oak_tree4", () -> new WitheringOakTree4(BYGMushroomConfig.CODEC.stable()));
    public static final RegistryObject<BYGAbstractMushroomFeature<BYGMushroomConfig>> WITHERING_OAK_TREE5 = createFeature("withering_oak_tree5", () -> new WitheringOakTree5(BYGMushroomConfig.CODEC.stable()));

    //QuartzDesert
    public static final RegistryObject<Feature<HangingColumnWithBaseConfig>> HANGING_FEATURE = createFeature("hanging_feature", () -> new HangingColumnWithBase(HangingColumnWithBaseConfig.CODEC.stable()));

    //Sythian
    public static final RegistryObject<Feature<ProbabilityFeatureConfiguration>> SYTHIAN_STALK = createFeature("sythian_stalk", () -> new SythianStalk(ProbabilityFeatureConfiguration.CODEC.stable()));
    public static final RegistryObject<BYGAbstractMushroomFeature<BYGMushroomConfig>> SYTHIAN_FUNGUS_TREE1 = createFeature("sythian_fungus_tree1", () -> new SythianFungusTree1(BYGMushroomConfig.CODEC.stable()));
    public static final RegistryObject<BYGAbstractMushroomFeature<BYGMushroomConfig>> SYTHIAN_FUNGUS_TREE2 = createFeature("sythian_fungus_tree2", () -> new SythianFungusTree2(BYGMushroomConfig.CODEC.stable()));
    public static final RegistryObject<BYGAbstractMushroomFeature<BYGMushroomConfig>> SYTHIAN_FUNGUS_TREE3 = createFeature("sythian_fungus_tree3", () -> new SythianFungusTree3(BYGMushroomConfig.CODEC.stable()));
    public static final RegistryObject<BYGAbstractMushroomFeature<BYGMushroomConfig>> SYTHIAN_FUNGUS_TREE4 = createFeature("sythian_fungus_tree4", () -> new SythianFungusTree4(BYGMushroomConfig.CODEC.stable()));

    //Warped
    public static final RegistryObject<Feature<WhitelistedSimpleBlockProviderConfig>> HUGE_WARPED_CORAL_PLANT = createFeature("warped_coral_plant", () -> new WarpedCoralFeature(WhitelistedSimpleBlockProviderConfig.CODEC.stable()));
    public static final RegistryObject<Feature<SimpleBlockProviderConfig>> PILLARS = createFeature("pillar", () -> new ConfigurablePillar(SimpleBlockProviderConfig.CODEC.stable()));

    //Chains
    public static final RegistryObject<Feature<ChainConfig>> CHAIN = createFeature("chain", () -> new Chain(ChainConfig.CODEC.stable()));

    //Crimson Gardens
    public static final RegistryObject<BYGAbstractMushroomFeature<BYGMushroomConfig>> CRIMSON_FUNGUS_TREE1 = createFeature("crimson_fungus_tree1", () -> new CrimsonFungus1(BYGMushroomConfig.CODEC.stable()));
    public static final RegistryObject<BYGAbstractMushroomFeature<BYGMushroomConfig>> CRIMSON_FUNGUS_TREE2 = createFeature("crimson_fungus_tree2", () -> new CrimsonFungus2(BYGMushroomConfig.CODEC.stable()));
    public static final RegistryObject<BYGAbstractMushroomFeature<BYGMushroomConfig>> WARPED_FUNGUS_TREE1 = createFeature("warped_fungus_tree1", () -> new WarpedFungus1(BYGMushroomConfig.CODEC.stable()));
    public static final RegistryObject<BYGAbstractMushroomFeature<BYGMushroomConfig>> WARPED_FUNGUS_TREE2 = createFeature("warped_fungus_tree2", () -> new WarpedFungus2(BYGMushroomConfig.CODEC.stable()));

    //Wailing
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> WAILING_VINES = createFeature("wailing_vine", () -> new WailingVine(NoneFeatureConfiguration.CODEC.stable()));
    public static final RegistryObject<BYGAbstractTreeFeature<BYGTreeConfig>> WAILING_PILLAR1 = createFeature("wailing_pillar1", () -> new WailingPillar1(BYGTreeConfig.CODEC.stable()));

    //Embur
    public static final RegistryObject<BYGAbstractMushroomFeature<BYGMushroomConfig>> EMBUR_MUSHROOM = createFeature("embur_mushroom1", () -> new EmburMushroom(BYGMushroomConfig.CODEC.stable()));
    public static final RegistryObject<BYGAbstractMushroomFeature<BYGMushroomConfig>> EMBUR_MUSHROOM2 = createFeature("embur_mushroom2", () -> new EmburMushroom2(BYGMushroomConfig.CODEC.stable()));
    public static final RegistryObject<BYGAbstractMushroomFeature<BYGMushroomConfig>> EMBUR_MUSHROOM3 = createFeature("embur_mushroom3", () -> new EmburMushroom3(BYGMushroomConfig.CODEC.stable()));
    public static final RegistryObject<BYGAbstractMushroomFeature<BYGMushroomConfig>> EMBUR_MUSHROOM4 = createFeature("embur_mushroom4", () -> new EmburMushroom4(BYGMushroomConfig.CODEC.stable()));

    public static final RegistryObject<Feature<BrimstoneVentsConfig>> BRIMSTONE_VENT_FEATURE = createFeature("brimstone_vent", () -> new BrimstoneVentFeature(BrimstoneVentsConfig.CODEC.stable()));

    public static final RegistryObject<Feature<HangingColumnConfig>> HANGING_COLUMN = createFeature("hanging_column", () -> new HangingColumn(HangingColumnConfig.CODEC.stable()));

    //QuartzDesert
    public static final RegistryObject<Feature<ColumnFeatureConfiguration>> QUARTZ_COLUMNS = createFeature("quartz_columns", () -> new RawQuartzColumnFeature(ColumnFeatureConfiguration.CODEC.stable()));
    public static final RegistryObject<Feature<QuartzSpikeConfig>> QUARTZ_SPIKES = createFeature("quartz_spikes", () -> new QuartzSpikeFeature(QuartzSpikeConfig.CODEC.stable()));

    //Subzero
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> SUBZERO_CRYSTAL = createFeature("subzero_crystal", () -> new SubzeroCrystalFeature(NoneFeatureConfiguration.CODEC.stable()));


    public static <C extends FeatureConfiguration, F extends Feature<C>> RegistryObject<F> createFeature(String id, Supplier<? extends F> feature) {
        return PROVIDER.register(id, feature);
    }

    public static void loadClass() {
    }
}