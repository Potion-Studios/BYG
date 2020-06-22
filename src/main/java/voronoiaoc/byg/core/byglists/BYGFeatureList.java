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
import voronoiaoc.byg.common.world.feature.features.overworld.giantflowers.AngelicaGiant;
import voronoiaoc.byg.common.world.feature.features.overworld.giantflowers.DandelionGiant;
import voronoiaoc.byg.common.world.feature.features.overworld.giantflowers.IrisGiant;
import voronoiaoc.byg.common.world.feature.features.overworld.giantflowers.RoseGiant;
import voronoiaoc.byg.common.world.feature.features.overworld.mushrooms.*;
import voronoiaoc.byg.common.world.feature.features.overworld.structure.DoverQuarry1;
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
import voronoiaoc.byg.common.world.feature.features.overworld.trees.dead.DeadTree;
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
import voronoiaoc.byg.common.world.structure.fortress.skyrishighlands.SkyrisFortressStructure;
import voronoiaoc.byg.common.world.structure.village.BYGVillageStructure;

public class BYGFeatureList {

    public static final Feature<NoFeatureConfig> DUMMY_TREE = new SmallPineTree(NoFeatureConfig::deserialize);

    /********************************************************************Features*************************************************************************/
    //DeadSea
    public static final Feature<NoFeatureConfig> DEADSEASPIKES = new DeadSeaSpikes(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> TALLDEADSEASPIKES = new TallDeadSeaSpikes(NoFeatureConfig::deserialize);

    public static final Feature<NoFeatureConfig> OBBYSPIKES = new ObsidianSpike(NoFeatureConfig::deserialize);

    public static final Feature<NoFeatureConfig> CACTUS = new CanyonCactus(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> BLACKICESNOW = new BlackIceAndSnowFeature(NoFeatureConfig::deserialize);

    //Lakes
    public static final Feature<BlockStateFeatureConfig> LAKE_FROST = new FrostMagmaLakeFeature(BlockStateFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> LAKE_WIDE_SHALLOW = new LakeWideShallow(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> LAKE_LAVA_WIDE_SHALLOW = new LavaLakeWideShallow(NoFeatureConfig::deserialize);
    //Vines
    public static final Feature<NoFeatureConfig> VINES = new VinePlacer(NoFeatureConfig::deserialize);

    //Pumpkins
    public static final BYGAbstractTreeFeature<NoFeatureConfig> PUMPKIN_PATCH1 = new PumpkinPatch1(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> PUMPKIN_PATCH2 = new PumpkinPatch2(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> PUMPKIN_PATCH3 = new PumpkinPatch3(NoFeatureConfig::deserialize);

    /********************************************************************Carvers**************************************************************************/
    public static final WorldCarver<ProbabilityConfig> VOLCANIC_CARVER = new VolcanicCarver(ProbabilityConfig::deserialize, 256);



    /*********************************************************************Large Flower Features***********************************************************/
    public static final BYGAbstractTreeFeature<NoFeatureConfig> GIANT_ANGELICA_FLOWER = new AngelicaGiant(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> GIANT_DANDELION_FLOWER = new DandelionGiant(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> GIANT_IRIS_FLOWER = new IrisGiant(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> GIANT_ROSE_FLOWER = new RoseGiant(NoFeatureConfig::deserialize);



    /*********************************************************************Large Mushroom Features*********************************************************/
    public static final Feature<NoFeatureConfig> GREEN_MUSHROOM_HUGE = new GreenMushroomHuge(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> WOOD_BLEWIT_HUGE = new WoodBlewitHuge(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> WEEPING_MILKCAP_HUGE = new WeepingMilkcapHuge(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> BLACK_PUFF_HUGE = new BlackPuffHuge(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> BLUE_GLOWSHROOM_HUGE = new BlueGlowshroomHuge(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> PURPLE_GLOWSHROOM_HUGE = new PurpleGlowshroomHuge(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> BLACKPUFF = new HugeBlackPuff(NoFeatureConfig::deserialize);



    /********************************************************************Nether Features********************************************************************/

    public static final Feature<NoFeatureConfig> BLACK_PUFF = new BlackPuffMushroom(NoFeatureConfig::deserialize);

    public static final Feature<NoFeatureConfig> GREEN_MUSHROOM = new GreenMushroom(NoFeatureConfig::deserialize);

    public static final Feature<NoFeatureConfig> NETHER_BRISTLE = new NetherBristle(NoFeatureConfig::deserialize);

    //Sythian
    public static final Feature<NoFeatureConfig> SYTHIAN_SPROUT = new SythianSprout(NoFeatureConfig::deserialize);
    public static final Feature<ProbabilityConfig> SYTHIAN_STALK = new SythianStalk(ProbabilityConfig::deserialize);
    public static final Feature<NoFeatureConfig> SYTHIAN_ROOTS = new SythianRoots(NoFeatureConfig::deserialize);

    //Warped
    public static final Feature<NoFeatureConfig> WARPED_BUSH = new WarpedBush(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> WARPED_CORAL = new WarpedCoral(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> WARPED_CORALPLANT = new WarpedCoralFeature(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> WARPED_CORALFAN = new WarpedCoralFan(NoFeatureConfig::deserialize);


    public static final Feature<NoFeatureConfig> WOOD_BLEWIT = new WoodBlewitMushroom(NoFeatureConfig::deserialize);

    public static final Feature<NoFeatureConfig> WEED_GRASS = new WeedGrass(NoFeatureConfig::deserialize);

    public static final Feature<NoFeatureConfig> WEEPING_MILKCAP = new WeepingMilkCapMushroom(NoFeatureConfig::deserialize);

    //Weeping Roots
    public static final Feature<NoFeatureConfig> WEEPING_ROOTS = new WeepingRoots(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> WEEPING_ROOTS_PLANT = new WeepingRootsPlant(NoFeatureConfig::deserialize);



    /********************************************************************Structures***********************************************************************/
    public static final Structure<VillageConfig> BYGVILLAGE = new BYGVillageStructure(VillageConfig::deserialize);
    public static final Structure<NoFeatureConfig> SKYRISFORTRESS = new SkyrisFortressStructure(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> DOVERQUARRY = new DoverQuarry1(NoFeatureConfig::deserialize);



    /********************************************************************Tree Features********************************************************************/
    //Acacia
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ACACIA_TREE1 = new AcaciaTree1(NoFeatureConfig::deserialize);
//    public static final BYGAbstractTreeFeature<NoFeatureConfig> ACACIA_TREE2 = new AcaciaTree2(NoFeatureConfig::deserialize);

    //Aspen
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ASPEN_SHRUB1 = new AspenShrub(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ASPEN_SHRUB2 = new AspenShrub2(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ASPEN_TREE1 = new AspenTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ASPEN_TREE2 = new AspenTree2(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ASPEN_TREE3 = new AspenTree3(NoFeatureConfig::deserialize);
//    public static final BYGAbstractTreeFeature<NoFeatureConfig> ASPEN_TREE4 = new AspenTree4(NoFeatureConfig::deserialize);

    //Baobab Tree
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BAOBAB_TREE1 = new BaobabTree1(NoFeatureConfig::deserialize);

    //Birch
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BIRCH_BROWN_TREE1 = new BrownBirchTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BIRCH_ORANGE_TREE1 = new OrangeBirchTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BIRCH_RED_TREE1 = new RedBirchTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BIRCH_YELLOW_TREE1 = new YellowBirchTree(NoFeatureConfig::deserialize);

    //Bluff Trees
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BLUFF_TREE1 = new BluffTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BLUFF_TREE2 = new BluffTree2(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BLUFF_TREE3 = new BluffTree3(NoFeatureConfig::deserialize);

    //Boreal Trees
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BOREAL_TREE = new BorealForestTree1(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BOREAL_TREE2 = new BorealForestTree2(NoFeatureConfig::deserialize);

    //Cherry
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CHERRY_PINK_TREE1 = new PinkCherry1(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CHERRY_PINK_TREE2 = new PinkCherry2(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CHERRY_WHITE_TREE1 = new WhiteCherry1(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CHERRY_WHITE_TREE2 = new WhiteCherry2(NoFeatureConfig::deserialize);

    //Coniferous
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CONIFER_TREE1 = new ConiferTree1(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CONIFER_TREE2 = new ConiferTree2(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CONIFER_TREE3 = new ConiferTree3(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CONIFER_TREE4 = new ConiferTree4(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CONIFER_TREE5 = new ConiferTree5(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CONIFER_TREE6 = new ConiferTree6(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CONIFER_TREE7 = new ConiferTree7(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CONIFER_TREE8 = new ConiferTree8(NoFeatureConfig::deserialize);

    //Cypress
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CYPRESS_TREE1 = new CypressTree1(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CYPRESS_TREE2 = new CypressTree2(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> CYPRESS_TREE3 = new CypressTree3(NoFeatureConfig::deserialize);

    //Dead
    public static final BYGAbstractTreeFeature<NoFeatureConfig> DEAD_TREE = new DeadTree(NoFeatureConfig::deserialize);

    //Dead Hazel
    public static final BYGAbstractTreeFeature<NoFeatureConfig> DEAD_HAZEL_TREE1 = new DeadHazel1(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> DEAD_HAZEL_TREE2 = new DeadHazel2(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> DEAD_HAZEL_TREE3 = new DeadHazel3(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> DEAD_HAZEL_TREE4 = new DeadHazel4(NoFeatureConfig::deserialize);

    //Deciduous
    public static final BYGAbstractTreeFeature<NoFeatureConfig> DECIDUOUS_TREE = new DeciduousTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> DECIDUOUS_BROWN_TREE = new BrownDeciduousTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> DECIDUOUS_ORANGE_TREE = new OrangeDeciduousTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> DECIDUOUS_YELLOW_TREE = new YellowDeciduousTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> DECIDUOUS_RED_TREE = new RedDeciduousTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> DECIDUOUS_SEASONAL_SHRUBS = new SeasonalDeciduousShrubs(NoFeatureConfig::deserialize);

    //Ebony
    public static final BYGAbstractTreeFeature<NoFeatureConfig> EBONY_BUSH1 = new EbonyBush1(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> EBONY_TREE1 = new EbonyTree1(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> EBONY_TREE2 = new EbonyTree2(NoFeatureConfig::deserialize);

    //Enchanted Trees
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ENCHANTED_BLUE_TREE1 = new BlueEnchantedTree1(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ENCHANTED_BLUE_TREE2 = new BlueEnchantedTree2(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ENCHANTED_BLUE_TREE3 = new BlueEnchantedTree3(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ENCHANTED_GREEN_TREE1 = new GreenEnchantedTree1(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ENCHANTED_GREEN_TREE2 = new GreenEnchantedTree2(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ENCHANTED_GREEN_TREE3 = new GreenEnchantedTree3(NoFeatureConfig::deserialize);

    public static final BYGAbstractTreeFeature<NoFeatureConfig> ENCHANTED_GREEN_GROVE_TREE1 = new GreenEnchantedGroveTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ENCHANTED_BLUE_GROVE_TREE1 = new BlueEnchantedGroveTree(NoFeatureConfig::deserialize);

    //Holly
    public static final BYGAbstractTreeFeature<NoFeatureConfig> HOLLY_TREE1 = new HollyTree1(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> HOLLY_TREE2 = new HollyTree2(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> HOLLY_TREE3 = new HollyTree3(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> HOLLY_TREE4 = new HollyTree4(NoFeatureConfig::deserialize);

    //Jacaranda
    public static final BYGAbstractTreeFeature<NoFeatureConfig> JACARANDA_TREE = new JacarandaTree1(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> JACARANDA_TREE2 = new JacarandaTree2(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> INDIGOJACARANDA_TREE = new IndigoJacarandaTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> INDIGOJACARANDA_TREE2 = new IndigoJacarandaTree2(NoFeatureConfig::deserialize);

    //JoshuaTree
    public static final BYGAbstractTreeFeature<NoFeatureConfig> JOSHUA_TREE1 = new JoshuaTree1(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> JOSHUA_TREE2 = new JoshuaTree2(NoFeatureConfig::deserialize);

    //Mangrove
    public static final BYGAbstractTreeFeature<NoFeatureConfig> MANGROVE_TREE1 = new MangroveTree1(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> MANGROVE_TREE2 = new MangroveTree2(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> MANGROVE_TREE3 = new MangroveTree3(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> MANGROVE_TREE4 = new MangroveTree4(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> MANGROVE_TREE5 = new MangroveTree5(NoFeatureConfig::deserialize);

    //Maple
    public static final BYGAbstractTreeFeature<NoFeatureConfig> MAPLE_RED_TREE = new RedMapleTree1(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> MAPLE_RED_TREE2 = new RedMapleTree2(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> MAPLE_SILVER_TREE1 = new SilverMapleTree1(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> MAPLE_SILVER_TREE2 = new SilverMapleTree2(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> MAPLE_TREE = new MapleTree(NoFeatureConfig::deserialize);

    //Meadow
    public static final BYGAbstractTreeFeature<NoFeatureConfig> MEADOW_TREE1 = new MeadowTree1(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> MEADOW_TREE2 = new MeadowTree2(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> MEADOW_TREE3 = new MeadowTree3(NoFeatureConfig::deserialize);

    //Orchard
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ORCHARD_TREE1 = new OrchardTree1(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ORCHARD_TREE2 = new OrchardTree2(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ORCHARD_TREE3 = new OrchardTree3(NoFeatureConfig::deserialize);

    //Palm
    public static final BYGAbstractTreeFeature<NoFeatureConfig> PALM_TREE1 = new PalmTree1(NoFeatureConfig::deserialize);

    //Pine
    public static final BYGAbstractTreeFeature<NoFeatureConfig> PINE_LARGE_TREE1 = new LargePineTree1(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> PINE_LARGE_TREE2 = new LargePineTree2(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> PINE_TREE1 = new PineTree1(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> PINE_TREE2 = new PineTree2(NoFeatureConfig::deserialize);

    //Palo Verde
    public static final BYGAbstractTreeFeature<NoFeatureConfig> PALO_VERDE_TREE1 = new PaloVerdeTree(NoFeatureConfig::deserialize,  0);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> PALO_VERDE_TREE2 = new PaloVerdeTree2(NoFeatureConfig::deserialize,  0);

    //Rainbow Eucalyptus
    public static final BYGAbstractTreeFeature<NoFeatureConfig> RAINBOW_TREE1 = new RainbowEucalyptusTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> RAINBOW_LARGE_TREE1 = new LargeRainbowEucalyptus(NoFeatureConfig::deserialize);

    //RedWood
    public static final BYGAbstractTreeFeature<NoFeatureConfig> REDWOOD_TREE1 = new EbonyTree1(NoFeatureConfig::deserialize);

    //Seasonal Oaks
    public static final BYGAbstractTreeFeature<NoFeatureConfig> OAK_BROWN_TREE1 = new BrownOakTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> OAK_ORANGE_TREE1 = new OrangeOakTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> OAK_RED_TREE1 = new RedOakTree(NoFeatureConfig::deserialize);

    //Shrubs
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SHRUB = new BYGShrub(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SHRUB_MEADOW1 = new MeadowShrub(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SHRUB_MEADOW2 = new MeadowShrub2(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SHRUB_PRAIRIE1 = new PrairieShrub(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SHRUB_PRAIRIE2 = new PrairieShrub2(NoFeatureConfig::deserialize);

    //Skyris
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SKYRIS_TREE1 = new SkyrisTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SKYRIS_TREE2 = new SkyrisTree2(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SKYRIS_TREE3 = new SkyrisTree3(NoFeatureConfig::deserialize);

    //Spruce
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BLUEGIANTSPUCE_TREE = new GiantBlueSpruceTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> TALLBLUESPRUCE_TREE = new TallBlueSpruceTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> BLUESPRUCE_TREE = new BlueSpruceTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SMALLBLUESPRUCE_TREE = new SmallBlueTaigaTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> GIANTORANGESPRUCE_TREE = new GiantOrangeSpruceTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> TALLORANGESPRUCE_TREE = new TallOrangeSpruceTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ORANGESPRUCE_TREE = new OrangeSpruceTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SMALLORANGESPRUCE_TREE = new SmallOrangeSpruceTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> GIANTREDSPRUCE_TREE = new GiantRedSpruceTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> TALLREDSPRUCE_TREE = new TallRedSpruceTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> REDSPRUCE_TREE = new RedSpruceTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SMALLREDSPRUCE_TREE = new SmallRedSpruceTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> GIANTYELLOWSPRUCE_TREE = new GiantYellowSpruceTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> TALLYELLOWSPRUCE_TREE = new TallYellowSpruceTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> YELLOWSPRUCE_TREE = new YellowSpruceTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> SMALLYELLOWSPRUCE_TREE = new SmallYellowTaigaTree(NoFeatureConfig::deserialize);

    //Tropical
    public static final BYGAbstractTreeFeature<NoFeatureConfig> TROPICAL_TREE1 = new TropicalRainForestTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> TROPICAL_SHORT_TREE1 = new ShortTropicalRainForestTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> TROPICAL_SHRUB1 = new TropicalShrub(NoFeatureConfig::deserialize);

    //Woodlands
    public static final BYGAbstractTreeFeature<NoFeatureConfig> WOODLANDS_TREE1 = new WoodlandsTree1(NoFeatureConfig::deserialize);

    //Willow
    public static final BYGAbstractTreeFeature<NoFeatureConfig> WILLOW_DEAD_TREE1 = new WillowDeadTree1(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> WILLOW_M_TREE1 = new WillowTreeM1(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> WILLOW_M_TREE2 = new WillowTreeM2(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> WILLOW_TREE1 = new WillowTree1(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> WILLOW_TREE2 = new WillowTree2(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> WILLOW_TREE3 = new WillowTree3(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> WILLOW_TREE4 = new WillowTree4(NoFeatureConfig::deserialize);

    //Zelkova
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ZELKOVA_TREE1 = new ZelkovaTree(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ZELKOVA_TREE2 = new ZelkovaTree2(NoFeatureConfig::deserialize);
    public static final BYGAbstractTreeFeature<NoFeatureConfig> ZELKOVA_TREE3 = new ZelkovaTree3(NoFeatureConfig::deserialize, 0);
}


