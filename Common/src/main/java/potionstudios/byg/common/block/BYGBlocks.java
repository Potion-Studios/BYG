package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.NetherFeatures;
import net.minecraft.tags.TagKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import potionstudios.byg.BYG;
import potionstudios.byg.BYGConstants;
import potionstudios.byg.client.textures.BYGMaterials;
import potionstudios.byg.common.block.end.*;
import potionstudios.byg.common.block.end.bulbisgardens.TallBulbisBlock;
import potionstudios.byg.common.block.end.impariusgrove.FungalImpariusFilamentBlock;
import potionstudios.byg.common.block.end.impariusgrove.ImpariusVineBlock;
import potionstudios.byg.common.block.end.impariusgrove.ImpariusVinePlantBlock;
import potionstudios.byg.common.block.end.impariusgrove.TreeBranchBlock;
import potionstudios.byg.common.block.end.nightshade.NightshadeBerryBushBlock;
import potionstudios.byg.common.block.end.shattereddesert.OddityCactusBlock;
import potionstudios.byg.common.block.end.shulkrenforest.ShulkrenVineBlock;
import potionstudios.byg.common.block.end.shulkrenforest.ShulkrenVinePlantBlock;
import potionstudios.byg.common.block.end.therium.BuddingTheriumCrystalBlock;
import potionstudios.byg.common.block.end.viscalisle.SculkGrowthBlock;
import potionstudios.byg.common.block.nether.BoricFireBlock;
import potionstudios.byg.common.block.nether.CrystalBlock;
import potionstudios.byg.common.block.nether.HypogealImperiumBlock;
import potionstudios.byg.common.block.nether.crimson.CrimsonBerryBushBlock;
import potionstudios.byg.common.block.nether.embur.EmburVineBlock;
import potionstudios.byg.common.block.nether.embur.EmburVinePlantBlock;
import potionstudios.byg.common.block.nether.subzerohypogeal.BuddingSubzeroCrystalBlock;
import potionstudios.byg.common.block.nether.wailing.WailingBulbBlossomBlock;
import potionstudios.byg.common.block.nether.wailing.WailingPlantBlock;
import potionstudios.byg.common.block.nether.warped.WarpedCactusBlock;
import potionstudios.byg.common.block.sapling.BYGSaplingBlock;
import potionstudios.byg.common.entity.BYGEntityTags;
import potionstudios.byg.common.world.feature.features.end.BYGEndFeatures;
import potionstudios.byg.common.world.feature.features.end.BYGEndVegetationFeatures;
import potionstudios.byg.common.world.feature.features.nether.BYGNetherVegetationFeatures;
import potionstudios.byg.common.world.feature.gen.overworld.trees.TreeSpawners;
import potionstudios.byg.common.world.feature.gen.overworld.trees.util.TreeSpawner;
import potionstudios.byg.mixin.access.*;
import potionstudios.byg.reg.BlockRegistryObject;
import potionstudios.byg.reg.RegistrationProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

@SuppressWarnings("ALL")
public class BYGBlocks {
    public static final RegistrationProvider<Block> PROVIDER = RegistrationProvider.get(Registry.BLOCK_REGISTRY, BYG.MOD_ID);

    public static final List<BlockRegistryObject<Block>> FLOWER_POT_BLOCKS = new ArrayList<>();
    public static final List<BlockRegistryObject<Block>> SIGN_BLOCKS = new ArrayList<>();

    public static final BlockRegistryObject<Block> FORAGERS_TABLE = createBlock(() -> new Block(BlockBehaviour.Properties.copy(Blocks.FLETCHING_TABLE)), "foragers_table");


    public static final BlockRegistryObject<Block> PEAT = createDirt("peat");
    public static final BlockRegistryObject<Block> LUSH_DIRT = createDirt("lush_dirt");
    public static final BlockRegistryObject<Block> LUSH_FARMLAND = createLushFarmland("lush_farmland");

    public static final BlockRegistryObject<Block> ETHER_SOIL = createDirt("ether_soil");

    public static final BlockRegistryObject<Block> ARAUCARIA_SAPLING = createSapling(BYGBlockTags.GROUND_ARAUCARIA_SAPLING, "araucaria_sapling");
    public static final BlockRegistryObject<Block> BLUE_SPRUCE_SAPLING = createSapling(BYGBlockTags.GROUND_BLUE_SPRUCE_SAPLING, "blue_spruce_sapling");
    public static final BlockRegistryObject<Block> BROWN_BIRCH_SAPLING = createSapling(BYGBlockTags.GROUND_BROWN_BIRCH_SAPLING, "brown_birch_sapling");
    public static final BlockRegistryObject<Block> BROWN_OAK_SAPLING = createSapling(BYGBlockTags.GROUND_BROWN_OAK_SAPLING, "brown_oak_sapling");
    public static final BlockRegistryObject<Block> BROWN_ZELKOVA_SAPLING = createSapling(BYGBlockTags.GROUND_BROWN_ZELKOVA_SAPLING, "brown_zelkova_sapling");
    public static final BlockRegistryObject<Block> FLOWERING_JACARANDA_BUSH = createFloweringJacarandaBush(1, TreeSpawners.JACARANDA, "flowering_jacaranda_bush");
    public static final BlockRegistryObject<Block> FLOWERING_INDIGO_JACARANDA_BUSH = createFloweringIndigoJacarandaBush(1, TreeSpawners.INDIGO_JACARANDA, "flowering_indigo_jacaranda_bush");
    public static final BlockRegistryObject<Block> INDIGO_JACARANDA_SAPLING = createSapling(BYGBlockTags.GROUND_INDIGO_JACARANDA_SAPLING, "indigo_jacaranda_sapling");
    public static final BlockRegistryObject<Block> JOSHUA_SAPLING = createSapling(BYGBlockTags.GROUND_JOSHUA_SAPLING, "joshua_sapling");
    public static final BlockRegistryObject<Block> ORANGE_BIRCH_SAPLING = createSapling(BYGBlockTags.GROUND_ORANGE_BIRCH_SAPLING, "orange_birch_sapling");
    public static final BlockRegistryObject<Block> ORANGE_OAK_SAPLING = createSapling(BYGBlockTags.GROUND_ORANGE_OAK_SAPLING, "orange_oak_sapling");
    public static final BlockRegistryObject<Block> ORANGE_SPRUCE_SAPLING = createSapling(BYGBlockTags.GROUND_ORANGE_SPRUCE_SAPLING, "orange_spruce_sapling");
    public static final BlockRegistryObject<Block> ORCHARD_SAPLING = createSapling(BYGBlockTags.GROUND_ORCHARD_SAPLING, "orchard_sapling");
    public static final BlockRegistryObject<Block> PALO_VERDE_SAPLING = createSapling(BYGBlockTags.GROUND_PALO_VERDE_SAPLING, "palo_verde_sapling");
    public static final BlockRegistryObject<Block> PINK_CHERRY_SAPLING = createSapling(BYGBlockTags.GROUND_PINK_CHERRY_SAPLING, "pink_cherry_sapling");
    public static final BlockRegistryObject<Block> RED_BIRCH_SAPLING = createSapling(BYGBlockTags.GROUND_RED_BIRCH_SAPLING, "red_birch_sapling");
    public static final BlockRegistryObject<Block> RED_MAPLE_SAPLING = createSapling(BYGBlockTags.GROUND_RED_MAPLE_SAPLING, "red_maple_sapling");
    public static final BlockRegistryObject<Block> RED_OAK_SAPLING = createSapling(BYGBlockTags.GROUND_RED_OAK_SAPLING, "red_oak_sapling");
    public static final BlockRegistryObject<Block> RED_SPRUCE_SAPLING = createSapling(BYGBlockTags.GROUND_RED_SPRUCE_SAPLING, "red_spruce_sapling");
    public static final BlockRegistryObject<Block> SILVER_MAPLE_SAPLING = createSapling(BYGBlockTags.GROUND_SILVER_MAPLE_SAPLING, "silver_maple_sapling");
    public static final BlockRegistryObject<Block> WHITE_CHERRY_SAPLING = createSapling(BYGBlockTags.GROUND_WHITE_CHERRY_SAPLING, "white_cherry_sapling");
    public static final BlockRegistryObject<Block> YELLOW_BIRCH_SAPLING = createSapling(BYGBlockTags.GROUND_YELLOW_BIRCH_SAPLING, "yellow_birch_sapling");
    public static final BlockRegistryObject<Block> YELLOW_SPRUCE_SAPLING = createSapling(BYGBlockTags.GROUND_YELLOW_SPRUCE_SAPLING, "yellow_spruce_sapling");
    public static final BlockRegistryObject<Block> WITHERING_OAK_SAPLING = createFungus(BYGBlockTags.GROUND_WITHERING_OAK_SAPLING, "withering_oak_sapling");

    public static final BlockRegistryObject<Block> JACARANDA_BUSH = createJacarandaBush("jacaranda_bush");
    public static final BlockRegistryObject<Block> INDIGO_JACARANDA_BUSH = createIndigoJacarandaBush("indigo_jacaranda_bush");
    public static final BlockRegistryObject<Block> SHRUB = createShrub(TreeSpawners.SHRUB, "shrub");

    public static final BlockRegistryObject<Block> WITCH_HAZEL_BRANCH = createTreeBranchBlock(MaterialColor.COLOR_ORANGE, "witch_hazel_branch");
    public static final BlockRegistryObject<Block> WITCH_HAZEL_BLOSSOM = createWitchHazelBlossomBlock(MaterialColor.COLOR_YELLOW, "witch_hazel_blossom");

    public static final BlockRegistryObject<Block> ARAUCARIA_LEAVES = createLeaves(MaterialColor.COLOR_GREEN, "araucaria_leaves");
    public static final BlockRegistryObject<Block> FLOWERING_BAOBAB_LEAVES = createChangingLeaves(MaterialColor.COLOR_GREEN, () -> (LeavesBlock) BYGBlocks.RIPE_BAOBAB_LEAVES.get(), 0.02F, "flowering_baobab_leaves");
    public static final BlockRegistryObject<Block> RIPE_BAOBAB_LEAVES = createFruitLeaves(MaterialColor.COLOR_GREEN, () -> BYGBlocks.BAOBAB_FRUIT_BLOCK.defaultBlockState().setValue(AppleFruitBlock.AGE, 0), "ripe_baobab_leaves", 0.04F);
    public static final BlockRegistryObject<Block> BLUE_SPRUCE_LEAVES = createLeaves(MaterialColor.COLOR_LIGHT_BLUE, "blue_spruce_leaves");
    public static final BlockRegistryObject<Block> BLOOMING_WITCH_HAZEL_LEAVES = createLeaves(MaterialColor.COLOR_ORANGE, "blooming_witch_hazel_leaves");
    public static final BlockRegistryObject<Block> BROWN_BIRCH_LEAVES = createLeaves(MaterialColor.COLOR_BROWN, "brown_birch_leaves");
    public static final BlockRegistryObject<Block> BROWN_OAK_LEAVES = createLeaves(MaterialColor.COLOR_BROWN, "brown_oak_leaves");
    public static final BlockRegistryObject<Block> BROWN_ZELKOVA_LEAVES = createLeaves(MaterialColor.COLOR_BROWN, "brown_zelkova_leaves");
    public static final BlockRegistryObject<Block> FLOWERING_ORCHARD_LEAVES = createChangingLeaves(MaterialColor.COLOR_GREEN, () -> (LeavesBlock) BYGBlocks.RIPE_ORCHARD_LEAVES.get(), 0.02F, "flowering_orchard_leaves");
    public static final BlockRegistryObject<Block> FLOWERING_PALO_VERDE_LEAVES = createFloweringPaloVerdeLeaves(MaterialColor.COLOR_YELLOW, "flowering_palo_verde_leaves");
    public static final BlockRegistryObject<Block> HOLLY_BERRY_LEAVES = createLeaves(MaterialColor.TERRACOTTA_GREEN, "holly_berry_leaves");
    public static final BlockRegistryObject<Block> INDIGO_JACARANDA_LEAVES = createLeaves(MaterialColor.TERRACOTTA_BLUE, "indigo_jacaranda_leaves");
    public static final BlockRegistryObject<Block> FLOWERING_JACARANDA_LEAVES = createLeaves(MaterialColor.TERRACOTTA_PURPLE, "flowering_jacaranda_leaves");
    public static final BlockRegistryObject<Block> FLOWERING_INDIGO_JACARANDA_LEAVES = createLeaves(MaterialColor.TERRACOTTA_BLUE, "flowering_indigo_jacaranda_leaves");
    public static final BlockRegistryObject<Block> JOSHUA_LEAVES = createLeaves(MaterialColor.COLOR_GREEN, "joshua_leaves");
    public static final BlockRegistryObject<Block> FLOWERING_JOSHUA_LEAVES = createChangingLeaves(MaterialColor.COLOR_GREEN, () -> (LeavesBlock) BYGBlocks.RIPE_JOSHUA_LEAVES.get(), 0.02F, "flowering_joshua_leaves");
    public static final BlockRegistryObject<Block> RIPE_JOSHUA_LEAVES = createFruitLeaves(MaterialColor.COLOR_GREEN, () -> BYGBlocks.JOSHUA_FRUIT_BLOCK.defaultBlockState().setValue(AppleFruitBlock.AGE, 0), "ripe_joshua_leaves", 0.04F);
    public static final BlockRegistryObject<Block> ORANGE_BIRCH_LEAVES = createLeaves(MaterialColor.COLOR_ORANGE, "orange_birch_leaves");
    public static final BlockRegistryObject<Block> ORANGE_OAK_LEAVES = createLeaves(MaterialColor.COLOR_ORANGE, "orange_oak_leaves");
    public static final BlockRegistryObject<Block> ORANGE_SPRUCE_LEAVES = createLeaves(MaterialColor.COLOR_ORANGE, "orange_spruce_leaves");
    public static final BlockRegistryObject<Block> ORCHARD_LEAVES = createLeaves(MaterialColor.COLOR_GREEN, "orchard_leaves");
    public static final BlockRegistryObject<Block> PALO_VERDE_LEAVES = createLeaves(MaterialColor.COLOR_GREEN, "palo_verde_leaves");
    public static final BlockRegistryObject<Block> PINK_CHERRY_LEAVES = createLeaves(MaterialColor.COLOR_PINK, "pink_cherry_leaves");
    public static final BlockRegistryObject<Block> RED_BIRCH_LEAVES = createLeaves(MaterialColor.COLOR_RED, "red_birch_leaves");
    public static final BlockRegistryObject<Block> RED_MAPLE_LEAVES = createLeaves(MaterialColor.COLOR_RED, "red_maple_leaves");
    public static final BlockRegistryObject<Block> RED_OAK_LEAVES = createLeaves(MaterialColor.COLOR_RED, "red_oak_leaves");
    public static final BlockRegistryObject<Block> RED_SPRUCE_LEAVES = createLeaves(MaterialColor.COLOR_RED, "red_spruce_leaves");
    public static final BlockRegistryObject<Block> RIPE_ORCHARD_LEAVES = createFruitLeaves(MaterialColor.COLOR_GREEN, () -> BYGBlocks.APPLE_FRUIT_BLOCK.defaultBlockState().setValue(AppleFruitBlock.AGE, 0), "ripe_orchard_leaves", 0.04F);
    public static final BlockRegistryObject<Block> SILVER_MAPLE_LEAVES = createLeaves(MaterialColor.COLOR_LIGHT_GRAY, "silver_maple_leaves");
    public static final BlockRegistryObject<Block> FLOWERING_SKYRIS_LEAVES = createChangingLeaves(MaterialColor.COLOR_PINK, () -> (LeavesBlock) BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.get(), 0.02F, "flowering_skyris_leaves");
    public static final BlockRegistryObject<Block> SKYRIS_LEAVES_GREEN_APPLE = createFruitLeaves(MaterialColor.COLOR_PINK, () -> BYGBlocks.GREEN_APPLE_FRUIT_BLOCK.defaultBlockState().setValue(AppleFruitBlock.AGE, 0), "green_apple_skyris_leaves", 0.04F);
    public static final BlockRegistryObject<Block> WHITE_CHERRY_LEAVES = createLeaves(MaterialColor.COLOR_LIGHT_GRAY, "white_cherry_leaves");
    public static final BlockRegistryObject<Block> YELLOW_BIRCH_LEAVES = createLeaves(MaterialColor.COLOR_YELLOW, "yellow_birch_leaves");
    public static final BlockRegistryObject<Block> YELLOW_SPRUCE_LEAVES = createLeaves(MaterialColor.COLOR_YELLOW, "yellow_spruce_leaves");
    public static final BlockRegistryObject<Block> WITHERING_OAK_LEAVES = createLeaves(MaterialColor.COLOR_GRAY, "withering_oak_leaves");
    public static final BlockRegistryObject<Block> FLOWERING_NIGHTSHADE_LEAVES = createGlowingLeaves(MaterialColor.COLOR_ORANGE, 15, "flowering_nightshade_leaves");
    public static final BlockRegistryObject<Block> FIRECRACKER_LEAVES = createFirecrackerLeavesBlock(MaterialColor.COLOR_GREEN, "firecracker_leaves");

    public static final BlockRegistryObject<Block> GREEN_MUSHROOM_BLOCK = createBlock(BYGBlockProperties.BlockHugeMushroom::new, "green_mushroom_block");
    public static final BlockRegistryObject<Block> MILKCAP_MUSHROOM_BLOCK = createBlock(BYGBlockProperties.BlockHugeMushroom::new, "weeping_milkcap_mushroom_block");
    public static final BlockRegistryObject<Block> BLEWIT_MUSHROOM_BLOCK = createBlock(BYGBlockProperties.BlockHugeMushroom::new, "wood_blewit_mushroom_block");
    public static final BlockRegistryObject<Block> WHITE_MUSHROOM_STEM = createBlock(BYGBlockProperties.BlockHugeMushroom::new, "white_mushroom_stem");
    public static final BlockRegistryObject<Block> BROWN_MUSHROOM_STEM = createBlock(BYGBlockProperties.BlockHugeMushroom::new, "brown_mushroom_stem");
    public static final BlockRegistryObject<Block> SOUL_SHROOM_STEM = createBlock(BYGBlockProperties.BlockHugeNetherMushroomStem::new, "soul_shroom_stem");
    public static final BlockRegistryObject<Block> SOUL_SHROOM_BLOCK = createBlock(BYGBlockProperties.BlockHugeNetherMushroom::new, "soul_shroom_block");
    public static final BlockRegistryObject<Block> DEATH_CAP_MUSHROOM_BLOCK = createBlock(BYGBlockProperties.BlockHugeNetherMushroom::new, "death_cap_mushroom_block");
    public static final BlockRegistryObject<Block> BULBIS_SHELL = createBlock(BYGBlockProperties.BulbisShell::new, "bulbis_shell");
    public static final BlockRegistryObject<Block> PURPLE_BULBIS_SHELL = createBlock(BYGBlockProperties.BulbisShell::new, "purple_bulbis_shell");

    public static final BlockRegistryObject<Block> CATTAIL_SPROUT = createCattailSproutBlock("cattail_sprout");
    public static final BlockRegistryObject<Block> CATTAIL = createCattailPlantBlock("cattail");
    public static final BlockRegistryObject<Block> CATTAIL_THATCH = createBlock(BYGBlockProperties.BYGThatch::new, "cattail_thatch");
    public static final BlockRegistryObject<Block> CATTAIL_THATCH_CARPET = createBlock(BYGBlockProperties.ThatchCarpet::new, "cattail_thatch_carpet");
    public static final BlockRegistryObject<Block> CATTAIL_THATCH_STAIRS = createBlock(BYGBlockProperties.ThatchStairs::new, "cattail_thatch_stairs");
    public static final BlockRegistryObject<Block> CATTAIL_THATCH_SLAB = createBlock(BYGBlockProperties.ThatchSlab::new, "cattail_thatch_slab");
    public static final BlockRegistryObject<Block> HORSEWEED = createFlower("horseweed", BYGBlockTags.GROUND_HORSEWEED);
    public static final BlockRegistryObject<Block> ALOE_VERA = createAloeVeraPlantBlock("aloe_vera");
    public static final BlockRegistryObject<Block> BLOOMING_ALOE_VERA = createBloomingAloeVeraPlantBlock("blooming_aloe_vera");
    public static final BlockRegistryObject<Block> MINI_CACTUS = createDesertPlant("mini_cactus", BYGBlockTags.GROUND_MINI_CACTUS);
    public static final BlockRegistryObject<Block> PRICKLY_PEAR_CACTUS = createDesertPlant("prickly_pear_cactus", BYGBlockTags.GROUND_PRICKLY_PEAR_CACTUS);
    public static final BlockRegistryObject<Block> WINTER_SUCCULENT = createFlower("winter_succulent", BYGBlockTags.GROUND_WINTER_SUCCULENT);
    public static final BlockRegistryObject<BYGDoublePlantBlock> TALL_PRAIRIE_GRASS = createBlock(() -> new BYGDoublePlantBlock(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS), BYGBlockTags.GROUND_TALL_PRAIRIE_GRASS), "tall_prairie_grass");
    public static final BlockRegistryObject<Block> POISON_IVY = createBlock(BYGBlockProperties.BYGPoisonIvy::new, "poison_ivy");
    public static final BlockRegistryObject<BYGBlockProperties.BYGSkyrisVine> SKYRIS_VINE = createBlock(BYGBlockProperties.BYGSkyrisVine::new, "skyris_vine");
    public static final BlockRegistryObject<Block> BLUEBERRY_BUSH = createBlueBerryBush("blueberry_bush");
    public static final BlockRegistryObject<Block> TINY_LILYPADS = createWaterLilyBlock(MaterialColor.TERRACOTTA_GREEN, "tiny_lilypads");
    public static final BlockRegistryObject<Block> FLOWERING_TINY_LILY_PADS = createWaterLilyBlock(MaterialColor.COLOR_PINK, "flowering_tiny_lily_pads");
    public static final BlockRegistryObject<Block> WATER_SILK = createWaterSilkBlock(MaterialColor.TERRACOTTA_LIGHT_GREEN, "water_silk");
    public static final BlockRegistryObject<Block> WEEPING_ROOTS = createBlock(BYGBlockProperties.BYGHangingVine::new, "weeping_roots");
    public static final BlockRegistryObject<Block> WEEPING_ROOTS_PLANT = createBlock(BYGBlockProperties.BYGHangingVinePlant::new, "weeping_roots_plant");
    public static final BlockRegistryObject<Block> BEACH_GRASS = createBlock(() -> new BYGBonemealActionBlock(BlockBehaviour.Properties.copy(Blocks.GRASS), BYGBlockTags.GROUND_BEACH_GRASS, BYGBonemealActionBlock.BonemealAction.growDoublePlant(() -> BYGBlocks.TALL_BEACH_GRASS.get())), "beach_grass");
    public static final BlockRegistryObject<BYGDoublePlantBlock> TALL_BEACH_GRASS = createBlock(() -> new BYGDoublePlantBlock(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS), BYGBlockTags.GROUND_TALL_BEACH_GRASS), "tall_beach_grass");
    public static final BlockRegistryObject<Block> LEAF_PILE = createBlock(() -> new FlatVegetationBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).noCollission().instabreak().sound(SoundType.GRASS)), "leaf_pile");
    public static final BlockRegistryObject<Block> CLOVER_PATCH = createBlock(() -> new FlatVegetationBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).noCollission().instabreak().sound(SoundType.GRASS), BYGBlockTags.GROUND_CLOVER_PATCH), "clover_patch");
    public static final BlockRegistryObject<Block> FLOWER_PATCH = createBlock(() -> new FlatVegetationBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).noCollission().instabreak().sound(SoundType.GRASS), BYGBlockTags.GROUND_FLOWER_PATCH), "flower_patch");
    public static final BlockRegistryObject<Block> BAOBAB_FRUIT_BLOCK = createBaobabFruitBlock("baobab_fruit_block");
    public static final BlockRegistryObject<Block> APPLE_FRUIT_BLOCK = createAppleFruitBlock("apple_fruit_block");
    public static final BlockRegistryObject<Block> GREEN_APPLE_FRUIT_BLOCK = createGreenAppleFruitBlock("green_apple_fruit_block");
    public static final BlockRegistryObject<Block> JOSHUA_FRUIT_BLOCK = createJoshuaFruitBlock("joshua_fruit_block");

    public static final BlockRegistryObject<Block> ETHER_BULB = createEtherBulbBlock("ether_bulbs_block");

    public static final BlockRegistryObject<Block> ANTHRACITE_BLOCK = createBlock(BYGBlockProperties.AnthraciteOre::new, "anthracite_block");
    public static final BlockRegistryObject<Block> ANTHRACITE_ORE = createBlock(BYGBlockProperties.AnthraciteOre::new, "anthracite_ore");

    public static final BlockRegistryObject<Block> NETHER_BRISTLE = createDoubleDamagePlantBlock("nether_bristle", BYGBlockTags.GROUND_NETHER_BRISTLE);

    public static final BlockRegistryObject<Block> CRIMSON_BERRY_BUSH = createCrimsonBerryBush("crimson_berry_bush");
    public static final BlockRegistryObject<Block> TALL_CRIMSON_ROOTS = createBlock(BYGBlockProperties.BYGDoubleNetherPlant::new, "tall_crimson_roots");
    public static final BlockRegistryObject<Block> BRIMSTONE = createNetherStone(MaterialColor.TERRACOTTA_YELLOW, "brimstone");
    public static final BlockRegistryObject<Block> YELLOW_NETHER_BRICKS = createBlock(() -> new BYGBlockProperties.BygNetherBricks(MaterialColor.TERRACOTTA_YELLOW), "yellow_nether_bricks");
    public static final BlockRegistryObject<Block> YELLOW_NETHER_BRICK_STAIRS = createBlock(() -> StairBlockAccess.byg_create(YELLOW_NETHER_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(YELLOW_NETHER_BRICKS.get())), "yellow_nether_brick_stairs");
    public static final BlockRegistryObject<Block> YELLOW_NETHER_BRICK_SLAB = createBlock(() -> new SlabBlock(BlockBehaviour.Properties.copy(YELLOW_NETHER_BRICKS.get())), "yellow_nether_brick_slab");
    public static final BlockRegistryObject<Block> YELLOW_NETHER_BRICK_WALL = createBlock(() -> new WallBlock(BlockBehaviour.Properties.copy(YELLOW_NETHER_BRICKS.get())), "yellow_nether_brick_wall");
    public static final BlockRegistryObject<Block> BORIC_CAMPFIRE = createCampfireBlock(3, "boric_campfire");
    public static final BlockRegistryObject<Block> BORIC_FIRE = createBoricFireBlock(MaterialColor.COLOR_GREEN, "boric_fire");
    public static final BlockRegistryObject<Block> BORIC_LANTERN = createLanternBlock(MaterialColor.COLOR_GREEN, "boric_lantern");

    public static final BlockRegistryObject<Block> HANGING_BONE = createBlock(BYGBlockProperties.HangingBones::new, "hanging_bones");
    public static final BlockRegistryObject<Block> QUARTZ_CRYSTAL = createDullCrystal("quartz_crystal", BYGEntityTags.NOT_HURT_BY_QUARTZ_CRYSTALS);
    public static final BlockRegistryObject<Block> QUARTZITE_SAND = createBlock(BYGBlockProperties.BYGQuartziteSand::new, "quartzite_sand");
    public static final BlockRegistryObject<Block> RAW_QUARTZ_BLOCK = createBlock(BYGBlockProperties.BYGStone::new, "raw_quartz_block");
    public static final BlockRegistryObject<Block> BLUE_NETHER_QUARTZ_ORE = createNetherOre(SoundType.NETHER_ORE, MaterialColor.TERRACOTTA_BLUE, "blue_nether_quartz_ore", UniformInt.of(2, 5));
    public static final BlockRegistryObject<Block> BLUE_NETHER_GOLD_ORE = createNetherOre(SoundType.NETHER_GOLD_ORE, MaterialColor.TERRACOTTA_BLUE, "blue_nether_gold_ore", UniformInt.of(0, 1));
    public static final BlockRegistryObject<Block> BRIMSTONE_NETHER_QUARTZ_ORE = createNetherOre(SoundType.NETHER_ORE, MaterialColor.TERRACOTTA_YELLOW, "brimstone_nether_quartz_ore", UniformInt.of(2, 5));
    public static final BlockRegistryObject<Block> BRIMSTONE_NETHER_GOLD_ORE = createNetherOre(SoundType.NETHER_GOLD_ORE, MaterialColor.TERRACOTTA_YELLOW, "brimstone_nether_gold_ore", UniformInt.of(0, 1));

    public static final BlockRegistryObject<Block> WAILING_BELL_BLOSSOM = createWailingBellBlossom("wailing_bell_blossom");
    public static final BlockRegistryObject<Block> WAILING_VINES = createWailingVine("wailing_vine");
    public static final BlockRegistryObject<Block> WAILING_GRASS = createWailingPlant("wailing_grass");
    public static final BlockRegistryObject<Block> MAGMATIC_STONE = createBlock(BYGBlockProperties.BYGNetherrack::new, "magmatic_stone");
    public static final BlockRegistryObject<Block> SCORCHED_BUSH = createBlock(BYGBlockProperties.ScorchedPlant::new, "scorched_bush");
    public static final BlockRegistryObject<Block> SCORCHED_GRASS = createBlock(BYGBlockProperties.ScorchedPlant::new, "scorched_grass");

    public static final BlockRegistryObject<Block> WARPED_CACTUS = createWarpedCactus("warped_cactus");
    public static final BlockRegistryObject<Block> WARPED_BUSH = createBlock(BYGBlockProperties.BYGWarpedBush::new, "warped_bush");
    public static final BlockRegistryObject<Block> WARPED_CORAL_BLOCK = createBlock(BYGBlockProperties.BYGWarpedCoralBlock::new, "warped_coral_block");
    public static final BlockRegistryObject<Block> WARPED_CORAL = createBlock(BYGBlockProperties.BYGWarpedCoral::new, "warped_coral");
    public static final BlockRegistryObject<Block> WARPED_CORAL_FAN = createBlock(BYGBlockProperties.BYGWarpedCoral::new, "warped_coral_fan");
    public static final BlockRegistryObject<Block> WARPED_CORAL_WALL_FAN = createBlock(BYGBlockProperties.BYGWarpedWallFanCoral::new, "warped_coral_wall_fan");
    public static final BlockRegistryObject<Block> WARPED_SOUL_SAND = createBlock(BYGBlockProperties.BYGNyliumSoulSand::new, "warped_soul_sand");
    public static final BlockRegistryObject<Block> WARPED_SOUL_SOIL = createBlock(BYGBlockProperties.BYGNyliumSoulSoil::new, "warped_soul_soil");

    public static final BlockRegistryObject<Block> SYTHIAN_ROOTS = createBlock(BYGBlockProperties.SythianPlant::new, "sythian_roots");
    public static final BlockRegistryObject<Block> SYTHIAN_SPROUT = createBlock(BYGBlockProperties.SythianPlant::new, "sythian_sprout");
    public static final BlockRegistryObject<Block> SYTHIAN_STALK_BLOCK = createBlock(BYGBlockProperties.SythianStalk::new, "sythian_stalk_block");
    public static final BlockRegistryObject<Block> SYTHIAN_SCAFFOLDING = createScaffoldingBlock(15, MaterialColor.COLOR_YELLOW, "sythian_scaffolding");
    public static final BlockRegistryObject<Block> SYTHIAN_SAPLING = createBlock(BYGBlockProperties.SythianSapling::new, "sythian_sapling");
    
    public static final BlockRegistryObject<Block> HANGING_SYTHIAN_ROOTS = createBlock(BYGBlockProperties.BYGSythianHangingRoots::new, "hanging_sythian_roots");
    public static final BlockRegistryObject<Block> HANGING_SYTHIAN_ROOTS_PLANT = createBlock(BYGBlockProperties.BYGSythianHangingRootsPlant::new, "hanging_sythian_roots_plant");

    public static final BlockRegistryObject<Block> EMBUR_LILY = createBlock(BYGBlockProperties.BYGEmburLily::new, "embur_lily");
    public static final BlockRegistryObject<Block> EMBUR_GEL_BLOCK = createEmburGelBlock("embur_gel_block");
    public static final BlockRegistryObject<Block> EMBUR_GEL_VINES = createEmburGelVine("embur_gel_vines");
    public static final BlockRegistryObject<Block> EMBUR_GEL_VINES_PLANT = createEmburGelVinePlant("embur_gel_vines_plant");
    public static final BlockRegistryObject<Block> EMBUR_GEL_BRANCH = createEmburGelBranch("embur_gel_branch");

    public static final BlockRegistryObject<Block> EMBUR_SPROUTS = createBlock(() -> new NetherSproutsBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT, MaterialColor.COLOR_CYAN).noCollission().instabreak().sound(SoundType.NETHER_SPROUTS)), "embur_sprouts");
    public static final BlockRegistryObject<Block> EMBUR_ROOTS = createBlock(BYGBlockProperties.BYGEmburPlant::new, "embur_roots");
    public static final BlockRegistryObject<DoublePlantBlock> TALL_EMBUR_ROOTS = createBlock(BYGBlockProperties.BYGDoubleNetherPlant::new, "tall_embur_roots");

    public static final BlockRegistryObject<Block> BLUE_NETHERRACK = createNetherStone(MaterialColor.TERRACOTTA_BLUE, "blue_netherrack");
    public static final BlockRegistryObject<Block> BLUE_NETHER_BRICKS = createBlock(() -> new BYGBlockProperties.BygNetherBricks(MaterialColor.TERRACOTTA_BLUE), "blue_nether_bricks");
    public static final BlockRegistryObject<Block> BLUE_NETHER_BRICK_STAIRS = createBlock(() -> StairBlockAccess.byg_create(BLUE_NETHER_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(BLUE_NETHER_BRICKS.get())), "blue_nether_brick_stairs");
    public static final BlockRegistryObject<Block> BLUE_NETHER_BRICK_SLAB = createBlock(() -> new SlabBlock(BlockBehaviour.Properties.copy(BLUE_NETHER_BRICKS.get())), "blue_nether_brick_slab");
    public static final BlockRegistryObject<Block> BLUE_NETHER_BRICK_WALL = createBlock(() -> new WallBlock(BlockBehaviour.Properties.copy(BLUE_NETHER_BRICKS.get())), "blue_nether_brick_wall");

    public static final BlockRegistryObject<Block> BULBIS_SPROUTS = createIvisBulbisPlant("bulbis_sprouts");
    public static final BlockRegistryObject<Block> IVIS_ROOTS = createIvisBulbisPlant("ivis_roots");
    public static final BlockRegistryObject<Block> IVIS_SPROUT = createIvisBulbisPlant("ivis_sprout");
    public static final BlockRegistryObject<Block> ENDER_LILY = createBlock(BYGBlockProperties.BYGEnderLily::new, "ender_lily");

    public static final BlockRegistryObject<Block> ETHER_FOLIAGE = createBlock(() -> new FlatVegetationBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).noCollission().instabreak().sound(SoundType.GRASS)), "ether_foliage");
    public static final BlockRegistryObject<DoublePlantBlock> TALL_ETHER_GRASS = createTallEtherPlant("tall_ether_grass");
    public static final BlockRegistryObject<Block> ETHER_GRASS = createEtherPlant("ether_grass");
    public static final BlockRegistryObject<Block> ETHER_BUSH = createEtherPlant("ether_bush");
    public static final BlockRegistryObject<Block> THEREAL_BELLFLOWER = createEtherPlant("thereal_bellflower");
    public static final BlockRegistryObject<Block> NIGHTSHADE_SPROUTS = createNightshadePlant("nightshade_sprouts");
    public static final BlockRegistryObject<Block> NIGHTSHADE_ROOTS = createTallNightshadePlant("nightshade_roots");
    public static final BlockRegistryObject<Block> NIGHTSHADE_BERRY_BUSH = createNightshadeBerryBush("nightshade_berry_bush");

    public static final BlockRegistryObject<Block> PURPUR_STONE = createBlock(BYGBlockProperties.BYGStone::new, "purpur_stone");
    public static final BlockRegistryObject<Block> PURPUR_STONE_SLAB = createStoneSlab("purpur_stone_slab");
    public static final BlockRegistryObject<Block> PURPUR_STONE_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "purpur_stone_stairs");
    public static final BlockRegistryObject<Block> PURPUR_STONE_WALL = createStoneWall("purpur_stone_wall");
    public static final BlockRegistryObject<Block> ETHER_STONE = createEtherStone("ether_stone");
    public static final BlockRegistryObject<Block> ETHER_STONE_SLAB = createStoneSlab("ether_stone_slab");
    public static final BlockRegistryObject<Block> ETHER_STONE_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "ether_stone_stairs");
    public static final BlockRegistryObject<Block> ETHER_STONE_WALL = createStoneWall("ether_stone_wall");

    public static final BlockRegistryObject<Block> COBBLED_ETHER_STONE = createEtherStone("cobbled_ether_stone");
    public static final BlockRegistryObject<Block> COBBLED_ETHER_STONE_SLAB = createStoneSlab("cobbled_ether_stone_slab");
    public static final BlockRegistryObject<Block> COBBLED_ETHER_STONE_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "cobbled_ether_stone_stairs");
    public static final BlockRegistryObject<Block> COBBLED_ETHER_STONE_WALL = createStoneWall("cobbled_ether_stone_wall");

    public static final BlockRegistryObject<Block> CARVED_ETHER_STONE = createEtherStone("carved_ether_stone");
    public static final BlockRegistryObject<Block> CARVED_ETHER_STONE_SLAB = createStoneSlab("carved_ether_stone_slab");
    public static final BlockRegistryObject<Block> CARVED_ETHER_STONE_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "carved_ether_stone_stairs");
    public static final BlockRegistryObject<Block> CARVED_ETHER_STONE_WALL = createStoneWall("carved_ether_stone_wall");

    public static final BlockRegistryObject<Block> ODDITY_CACTUS = createOddityCactus("oddity_cactus");
    public static final BlockRegistryObject<Block> ODDITY_BUSH = createOddityDesertPlant("oddity_bush");
    public static final BlockRegistryObject<Block> END_SAND = createSand(MaterialColor.SAND, 16053687, "end_sand");

    public static final BlockRegistryObject<Block> VERMILION_SCULK_TENDRILS = createSculkPlant("vermilion_sculk_tendrils");
    public static final BlockRegistryObject<Block> VERMILION_SCULK_GROWTH = createSculkGrowth("vermilion_sculk_growth");


    public static final BlockRegistryObject<Block> THERIUM_CRYSTAL_BLOCK = createCrystalBlock(MaterialColor.COLOR_YELLOW,"therium_crystal_block");
    public static final BlockRegistryObject<Block> BUDDING_THERIUM_CRYSTAL = createTheriumBuddingCrystalBlock(MaterialColor.COLOR_YELLOW,"budding_therium_crystal");
    public static final BlockRegistryObject<Block> THERIUM_CRYSTAL_CLUSTER = createCrystalClusterBlock(5, 7, 3,MaterialColor.COLOR_YELLOW, "therium_crystal_cluster");
    public static final BlockRegistryObject<Block> LARGE_THERIUM_CRYSTAL_BUD = createCrystalClusterBlock(4, 5, 3,MaterialColor.COLOR_YELLOW, "large_therium_crystal_bud");
    public static final BlockRegistryObject<Block> MEDIUM_THERIUM_CRYSTAL_BUD = createCrystalClusterBlock(2, 4, 3,MaterialColor.COLOR_YELLOW, "medium_therium_crystal_bud");
    public static final BlockRegistryObject<Block> SMALL_THERIUM_CRYSTAL_BUD = createCrystalClusterBlock(1, 3, 4,MaterialColor.COLOR_YELLOW, "small_therium_crystal_bud");

    public static final BlockRegistryObject<Block> THERIUM_LANTERN = createLanternBlock(MaterialColor.COLOR_CYAN, "therium_lantern");
    public static final BlockRegistryObject<Block> THERIUM_LAMP = createBlock(() -> new Block(BlockBehaviour.Properties.copy(Blocks.SEA_LANTERN)), "therium_lamp");
    public static final BlockRegistryObject<Block> CHISELED_THERIUM = createChiseledTherium("chiseled_therium");
    public static final BlockRegistryObject<Block> CHISELED_THERIUM_STAIRS = createChiseledTheriumStairs("chiseled_therium_stairs");
    public static final BlockRegistryObject<Block> CHISELED_THERIUM_SLAB = createChiseledTheriumSlab("chiseled_therium_slab");
    public static final BlockRegistryObject<Block> CHISELED_THERIUM_WALL = createChiseledTheriumWall("chiseled_therium_wall");
    public static final BlockRegistryObject<Block> SHINY_CHISELED_THERIUM = createShinyChiseledTherium("shiny_chiseled_therium");
    public static final BlockRegistryObject<Block> SHINY_CHISELED_THERIUM_STAIRS = createShinyChiseledTheriumStairs("shiny_chiseled_therium_stairs");
    public static final BlockRegistryObject<Block> SHINY_CHISELED_THERIUM_SLAB = createShinyChiseledTheriumSlab("shiny_chiseled_therium_slab");
    public static final BlockRegistryObject<Block> SHINY_CHISELED_THERIUM_WALL = createShinyChiseledTheriumWall("shiny_chiseled_therium_wall");
    public static final BlockRegistryObject<Block> THERIUM_GLASS = createTheriumGlass("therium_glass");
    public static final BlockRegistryObject<Block> THERIUM_GLASS_PANE = createTheriumGlassPane("therium_glass_pane");

    public static final BlockRegistryObject<Block> CRYPTIC_END_ROD = createEndRodBlock(MaterialColor.COLOR_RED, "cryptic_end_rod");
    public static final BlockRegistryObject<Block> CRYPTIC_CAMPFIRE = createCampfireBlock(4, "cryptic_campfire");
    public static final BlockRegistryObject<Block> CRYPTIC_LANTERN = createCrypticLanternBlock(MaterialColor.COLOR_RED, "cryptic_lantern");
    public static final BlockRegistryObject<Block> CRYPTIC_FIRE = createCrypticFireBlock(MaterialColor.COLOR_RED, "cryptic_fire");
    public static final BlockRegistryObject<Block> CRYPTIC_MAGMA_BLOCK = createBlock(BYGBlockProperties.BYGMagma::new, "cryptic_magma_block");
    public static final BlockRegistryObject<Block> CRYPTIC_STONE = createBlock(BYGBlockProperties.BYGStone::new, "cryptic_stone");
    public static final BlockRegistryObject<Block> CRYPTIC_STONE_SLAB = createStoneSlab("cryptic_stone_slab");
    public static final BlockRegistryObject<Block> CRYPTIC_STONE_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "cryptic_stone_stairs");
    public static final BlockRegistryObject<Block> CRYPTIC_STONE_WALL = createStoneWall("cryptic_stone_wall");
    public static final BlockRegistryObject<Block> CRYPTIC_VENT = createVent("cryptic_vent");
    public static final BlockRegistryObject<Block> TALL_CRYPTIC_VENT = createTallVent("tall_cryptic_vent");
    public static final BlockRegistryObject<Block> CRYPTIC_REDSTONE_ORE = createBlock(() -> new RedStoneOreBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.NETHER_GOLD_ORE).strength(0.4F, 0.4F).lightLevel(litBlockEmission(13)).requiresCorrectToolForDrops()), "cryptic_redstone_ore");
    public static final BlockRegistryObject<Block> CRYPTIC_BRAMBLE = createStoneEndPlant("cryptic_bramble");

    public static final BlockRegistryObject<Block> IMPARIUS_MUSHROOM_BLOCK = createImpariusMushroom("imparius_mushroom_block");
    public static final BlockRegistryObject<Block> IMPARIUS_MUSHROOM_BRANCH = createGlowingTreeBranchBlock(MaterialColor.COLOR_CYAN, "imparius_mushroom_branch");
    public static final BlockRegistryObject<Block> FUNGAL_IMPARIUS_BLOCK = createFungalImparius("fungal_imparius_block");
    public static final BlockRegistryObject<Block> CHISELED_FUNGAL_IMPARIUS = createFungalImparius("chiseled_fungal_imparius");
    public static final BlockRegistryObject<Block> CHISELED_FUNGAL_IMPARIUS_SLAB = createChiseledFungalImpariusSlab("chiseled_fungal_imparius_slab");
    public static final BlockRegistryObject<Block> CHISELED_FUNGAL_IMPARIUS_STAIRS = createChiseledFungalImpariusStairs("chiseled_fungal_imparius_stairs");
    public static final BlockRegistryObject<Block> CHISELED_FUNGAL_IMPARIUS_WALL = createChiseledFungalImpariusWall("chiseled_fungal_imparius_wall");
    public static final BlockRegistryObject<Block> FUNGAL_IMPARIUS_FILAMENT_BLOCK = createFungalImpariusFilamentBlock("fungal_imparius_filament_block");
    public static final BlockRegistryObject<Block> FUNGAL_IMPARIUS_FILAMENT = createFungalImpariusFilament("fungal_imparius_filament");
    public static final BlockRegistryObject<Block> IMPARIUS_VINE = createImpariusVine("imparius_vine");
    public static final BlockRegistryObject<Block> IMPARIUS_VINE_PLANT = createImpariusVinePlant("imparius_vine_plant");
    public static final BlockRegistryObject<Block> IMPARIUS_BUSH = createImpariusPlant("imparius_bush");

    public static final BlockRegistryObject<Block> SHULKREN_MOSS_BLANKET = createSculkGrowth("shulkren_moss_blanket");
    public static final BlockRegistryObject<Block> SHULKREN_WART_BLOCK = createBlock(BYGBlockProperties.BYGWartBlock::new, "shulkren_wart_block");
    public static final BlockRegistryObject<Block> SHULKREN_VINE = createShulkrenVine("shulkren_vine");
    public static final BlockRegistryObject<Block> SHULKREN_VINE_PLANT = createShulkrenVinePlant("shulkren_vine_plant");
    public static final BlockRegistryObject<Block> PURPLE_SHROOMLIGHT = createShroomlight("purple_shroomlight");

    public static final BlockRegistryObject<Block> GLOWSTONE_LAMP = createBlock(() -> new Block(BlockBehaviour.Properties.copy(Blocks.SEA_LANTERN)), "glowstone_lamp");
    public static final BlockRegistryObject<Block> PERVADED_NETHERRACK = createBlock(BYGBlockProperties.BYGPervadedNetherrack::new, "pervaded_netherrack");
    public static final BlockRegistryObject<Block> GLOWSTONE_LANTERN = createLanternBlock(MaterialColor.TERRACOTTA_PURPLE, "glowstone_lantern");
    public static final BlockRegistryObject<Block> PACKED_BLACK_ICE = createBlock(() -> new Block(BlockBehaviour.Properties.copy(Blocks.PACKED_ICE)), "packed_black_ice");
    public static final BlockRegistryObject<Block> BLACK_ICE = createBlock(() -> new IceBlock(BlockBehaviour.Properties.copy(Blocks.ICE)), "black_ice");
    public static final BlockRegistryObject<Block> FROST_MAGMA = createBlock(BYGBlockProperties.BYGFrostMagma::new, "frost_magma");
    public static final BlockRegistryObject<Block> SUBZERO_ASH = createBlock(BYGBlockProperties.BYGSubzeroAsh::new, "subzero_ash");
    public static final BlockRegistryObject<Block> SUBZERO_ASH_BLOCK = createBlock(BYGBlockProperties.BYGSubzeroAshBlock::new, "subzero_ash_block");
    public static final BlockRegistryObject<Block> SUBZERO_CRYSTAL_BLOCK = createCrystalBlock(MaterialColor.COLOR_LIGHT_BLUE,"subzero_crystal_block");
    public static final BlockRegistryObject<Block> BUDDING_SUBZERO_CRYSTAL = createSubzeroBuddingCrystalBlock(MaterialColor.COLOR_LIGHT_BLUE, "budding_subzero_crystal");
    public static final BlockRegistryObject<Block> SUBZERO_CRYSTAL_CLUSTER = createCrystalClusterBlock(5, 7, 3,MaterialColor.COLOR_LIGHT_BLUE ,"subzero_crystal_cluster");
    public static final BlockRegistryObject<Block> LARGE_SUBZERO_CRYSTAL_BUD = createCrystalClusterBlock(4, 5, 3,MaterialColor.COLOR_LIGHT_BLUE ,"large_subzero_crystal_bud");
    public static final BlockRegistryObject<Block> MEDIUM_SUBZERO_CRYSTAL_BUD = createCrystalClusterBlock(2, 4, 3,MaterialColor.COLOR_LIGHT_BLUE ,"medium_subzero_crystal_bud");
    public static final BlockRegistryObject<Block> SMALL_SUBZERO_CRYSTAL_BUD = createCrystalClusterBlock(1, 3, 4,MaterialColor.COLOR_LIGHT_BLUE ,"small_subzero_crystal_bud");
    public static final BlockRegistryObject<Block> LAMENT_SPROUTS = createBlock(BYGBlockProperties.BYGLamentPlant::new, "lament_sprouts");
    public static final BlockRegistryObject<Block> LAMENT_VINE = createBlock(BYGBlockProperties.BYGLamentVine::new, "lament_vine");
    public static final BlockRegistryObject<Block> LAMENT_VINE_PLANT = createBlock(BYGBlockProperties.BYGLamentVinePlant::new, "lament_vine_plant");

    public static final BlockRegistryObject<Block> PINK_CHERRY_FOLIAGE = createBlock(() -> new FlatVegetationBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).noCollission().instabreak().sound(SoundType.GRASS)), "pink_cherry_foliage");
    public static final BlockRegistryObject<Block> WHITE_CHERRY_FOLIAGE = createBlock(() -> new FlatVegetationBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).noCollission().instabreak().sound(SoundType.GRASS)), "white_cherry_foliage");

    public static final BlockRegistryObject<Block> POLLEN_BLOCK = createBlock(BYGBlockProperties.BYGPollen::new, "pollen_block");

    public static final BlockRegistryObject<Block> CRACKED_RED_SAND = createSand(MaterialColor.COLOR_ORANGE, 11098145, "cracked_red_sand");

    public static final BlockRegistryObject<Block> BLACK_SAND = createSand(MaterialColor.TERRACOTTA_BLACK, 5197647, "black_sand");
    public static final BlockRegistryObject<Block> BLACK_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "black_sandstone");
    public static final BlockRegistryObject<Block> BLACK_CHISELED_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "black_chiseled_sandstone");
    public static final BlockRegistryObject<Block> BLACK_CUT_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "black_cut_sandstone");
    public static final BlockRegistryObject<Block> BLACK_SMOOTH_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "black_smooth_sandstone");

    public static final BlockRegistryObject<Block> WHITE_SAND = createSand(MaterialColor.TERRACOTTA_WHITE, 15395562, "white_sand");
    public static final BlockRegistryObject<Block> WHITE_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "white_sandstone");
    public static final BlockRegistryObject<Block> WHITE_CHISELED_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "white_chiseled_sandstone");
    public static final BlockRegistryObject<Block> WHITE_CUT_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "white_cut_sandstone");
    public static final BlockRegistryObject<Block> WHITE_SMOOTH_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "white_smooth_sandstone");

    public static final BlockRegistryObject<Block> BLUE_SAND = createSand(MaterialColor.TERRACOTTA_WHITE, 13559021, "blue_sand");
    public static final BlockRegistryObject<Block> BLUE_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "blue_sandstone");
    public static final BlockRegistryObject<Block> BLUE_CHISELED_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "blue_chiseled_sandstone");
    public static final BlockRegistryObject<Block> BLUE_CUT_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "blue_cut_sandstone");
    public static final BlockRegistryObject<Block> BLUE_SMOOTH_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "blue_smooth_sandstone");

    public static final BlockRegistryObject<Block> PURPLE_SAND = createSand(MaterialColor.TERRACOTTA_PURPLE, 12887002, "purple_sand");
    public static final BlockRegistryObject<Block> PURPLE_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "purple_sandstone");
    public static final BlockRegistryObject<Block> PURPLE_CHISELED_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "purple_chiseled_sandstone");
    public static final BlockRegistryObject<Block> PURPLE_CUT_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "purple_cut_sandstone");
    public static final BlockRegistryObject<Block> PURPLE_SMOOTH_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "purple_smooth_sandstone");

    public static final BlockRegistryObject<Block> PINK_SAND = createSand(MaterialColor.COLOR_PINK, 15585004, "pink_sand");
    public static final BlockRegistryObject<Block> PINK_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "pink_sandstone");
    public static final BlockRegistryObject<Block> PINK_CHISELED_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "pink_chiseled_sandstone");
    public static final BlockRegistryObject<Block> PINK_CUT_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "pink_cut_sandstone");
    public static final BlockRegistryObject<Block> PINK_SMOOTH_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "pink_smooth_sandstone");

    public static final BlockRegistryObject<Block> WINDSWEPT_SAND = createSand(MaterialColor.TERRACOTTA_PINK, 15585004, "windswept_sand");
    public static final BlockRegistryObject<Block> WINDSWEPT_SANDSTONE = createSandstone(MaterialColor.TERRACOTTA_PINK, "windswept_sandstone");
    public static final BlockRegistryObject<Block> WINDSWEPT_SANDSTONE_SLAB = createSandstoneSlab(MaterialColor.TERRACOTTA_PINK, "windswept_sandstone_slab");
    public static final BlockRegistryObject<Block> WINDSWEPT_SANDSTONE_STAIRS = createSandstoneStairs(MaterialColor.TERRACOTTA_PINK, "windswept_sandstone_stairs");
    public static final BlockRegistryObject<Block> WINDSWEPT_SANDSTONE_WALL = createSandstoneWall(MaterialColor.TERRACOTTA_PINK, "windswept_sandstone_wall");

    public static final BlockRegistryObject<Block> CHISELED_WINDSWEPT_SANDSTONE = createSandstone(MaterialColor.TERRACOTTA_PINK, "chiseled_windswept_sandstone");
    public static final BlockRegistryObject<Block> CHISELED_WINDSWEPT_SANDSTONE_SLAB = createSandstoneSlab(MaterialColor.TERRACOTTA_PINK, "chiseled_windswept_sandstone_slab");
    public static final BlockRegistryObject<Block> CHISELED_WINDSWEPT_SANDSTONE_STAIRS = createSandstoneStairs(MaterialColor.TERRACOTTA_PINK, "chiseled_windswept_sandstone_stairs");
    public static final BlockRegistryObject<Block> CHISELED_WINDSWEPT_SANDSTONE_WALL = createSandstoneWall(MaterialColor.TERRACOTTA_PINK, "chiseled_windswept_sandstone_wall");

    public static final BlockRegistryObject<Block> CUT_WINDSWEPT_SANDSTONE = createSandstone(MaterialColor.TERRACOTTA_PINK, "cut_windswept_sandstone");
    public static final BlockRegistryObject<Block> CUT_WINDSWEPT_SANDSTONE_SLAB = createSandstoneSlab(MaterialColor.TERRACOTTA_PINK, "cut_windswept_sandstone_slab");
    public static final BlockRegistryObject<Block> CUT_WINDSWEPT_SANDSTONE_STAIRS = createSandstoneStairs(MaterialColor.TERRACOTTA_PINK, "cut_windswept_sandstone_stairs");
    public static final BlockRegistryObject<Block> CUT_WINDSWEPT_SANDSTONE_WALL = createSandstoneWall(MaterialColor.TERRACOTTA_PINK, "cut_windswept_sandstone_wall");

    public static final BlockRegistryObject<Block> SMOOTH_WINDSWEPT_SANDSTONE = createSandstone(MaterialColor.TERRACOTTA_PINK, "smooth_windswept_sandstone");
    public static final BlockRegistryObject<Block> SMOOTH_WINDSWEPT_SANDSTONE_SLAB = createSandstoneSlab(MaterialColor.TERRACOTTA_PINK, "smooth_windswept_sandstone_slab");
    public static final BlockRegistryObject<Block> SMOOTH_WINDSWEPT_SANDSTONE_STAIRS = createSandstoneStairs(MaterialColor.TERRACOTTA_PINK, "smooth_windswept_sandstone_stairs");
    public static final BlockRegistryObject<Block> SMOOTH_WINDSWEPT_SANDSTONE_WALL = createSandstoneWall(MaterialColor.TERRACOTTA_PINK, "smooth_windswept_sandstone_wall");

    public static final BlockRegistryObject<Block> WINDSWEPT_SANDSTONE_PILLAR = createSandstonePillar(MaterialColor.TERRACOTTA_PINK, "windswept_sandstone_pillar");


    public static final BlockRegistryObject<Block> PALO_VERDE_LOG = createLog("palo_verde_log");
    public static final BlockRegistryObject<Block> WITHERING_OAK_LOG = createLog("withering_oak_log");
    public static final BlockRegistryObject<Block> IMBUED_NIGHTSHADE_LOG = createLog("imbued_nightshade_log");
    public static final BlockRegistryObject<Block> FUNGAL_IMPARIUS_STEM = createBlock(BYGBlockProperties.BYGNetherLog::new, "fungal_imparius_stem");
    public static final BlockRegistryObject<Block> IMBUED_BLUE_ENCHANTED_LOG = createLog("imbued_blue_enchanted_log");
    public static final BlockRegistryObject<Block> IMBUED_GREEN_ENCHANTED_LOG = createLog("imbued_green_enchanted_log");


    public static final BlockRegistryObject<Block> PALO_VERDE_WOOD = createWood("palo_verde_wood");
    public static final BlockRegistryObject<Block> WITHERING_OAK_WOOD = createWood("withering_oak_wood");
    public static final BlockRegistryObject<Block> FUNGAL_IMPARIUS_HYPHAE = createBlock(BYGBlockProperties.BYGNetherWood::new, "fungal_imparius_hyphae");

    public static final BlockRegistryObject<Block> WHITE_PUFFBALL = createWhitePuffBlock(SoundType.FUNGUS, MaterialColor.TERRACOTTA_WHITE, "white_puffball");
    public static final BlockRegistryObject<Block> WEEPING_MILKCAP = createMushroom(BYGBlockTags.GROUND_WEEPING_MILK_CAP, "weeping_milkcap");
    public static final BlockRegistryObject<Block> WOOD_BLEWIT = createMushroom(BYGBlockTags.GROUND_WOOD_BLEWIT, "wood_blewit");
    public static final BlockRegistryObject<Block> GREEN_MUSHROOM = createMushroom(BYGBlockTags.GROUND_GREEN_MUSHROOM, "green_mushroom");

    public static final BlockRegistryObject<Block> SOUL_SHROOM = createFungus(BYGBlockTags.GROUND_SOUL_SHROOM, "soul_shroom");
    public static final BlockRegistryObject<Block> DEATH_CAP = createFungus(BYGBlockTags.GROUND_DEATH_CAP, "death_cap");

    public static final BlockRegistryObject<Block> PURPLE_BULBIS_ODDITY = createMushroom(BYGBlockTags.GROUND_PURPLE_BULBIS_ODDITY, "purple_bulbis_oddity");
    public static final BlockRegistryObject<Block> SHULKREN_FUNGUS = createMushroom(BYGBlockTags.GROUND_SHULKREN_FUNGUS, "shulkren_fungus");
    public static final BlockRegistryObject<Block> FUNGAL_IMPARIUS = createMushroom(BYGBlockTags.GROUND_FUNGAL_IMPARIUS, "fungal_imparius");

    public static final BlockRegistryObject<Block> BULBIS_ANOMALY = createTallBulbis("bulbis_anomaly");
    public static final BlockRegistryObject<Block> PURPLE_BULBIS_ANOMALY = createTallBulbis("purple_bulbis_anomaly");

    public static final BlockRegistryObject<Block> SOUL_SHROOM_SPORE = createBlock(BYGBlockProperties.BYGSoulShroomSpore::new, "soul_shroom_spore");
    public static final BlockRegistryObject<Block> SOUL_SHROOM_SPORE_END = createBlock(BYGBlockProperties.BYGSoulShroomSporeEnd::new, "soul_shroom_spore_end");

    public static final BlockRegistryObject<Block> RAW_PENDORITE_BLOCK = createRawPendoriteBlock("raw_pendorite_block");
    public static final BlockRegistryObject<Block> PENDORITE_ORE = createPendoriteOre("pendorite_ore");
    public static final BlockRegistryObject<Block> AMETRINE_ORE = createAmetrineOre("ametrine_ore");
    public static final BlockRegistryObject<Block> PENDORITE_BLOCK = createPendoriteBlock("pendorite_block");
    public static final BlockRegistryObject<Block> AMETRINE_BLOCK = createAmetrineBlock("ametrine_block");
    public static final BlockRegistryObject<Block> BUDDING_AMETRINE_ORE = createBuddingAmetrineOre("budding_ametrine_ore");
    public static final BlockRegistryObject<Block> AMETRINE_CLUSTER = createAmetrineCluster("ametrine_cluster");
    public static final BlockRegistryObject<Block> DACITE = createDacite("dacite");
    public static final BlockRegistryObject<Block> DACITE_SLAB = createStoneSlab("dacite_slab");
    public static final BlockRegistryObject<Block> DACITE_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "dacite_stairs");
    public static final BlockRegistryObject<Block> DACITE_WALL = createStoneWall("dacite_wall");
    public static final BlockRegistryObject<Block> DACITE_BRICKS = createBlock(BYGBlockProperties.BYGStone::new, "dacite_bricks");
    public static final BlockRegistryObject<Block> DACITE_BRICK_SLAB = createStoneSlab("dacite_brick_slab");
    public static final BlockRegistryObject<Block> DACITE_BRICK_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "dacite_brick_stairs");
    public static final BlockRegistryObject<Block> DACITE_BRICK_WALL = createStoneWall("dacite_brick_wall");
    public static final BlockRegistryObject<Block> DACITE_COBBLESTONE = createBlock(BYGBlockProperties.BYGStone::new, "dacite_cobblestone");
    public static final BlockRegistryObject<Block> DACITE_COBBLESTONE_SLAB = createStoneSlab("dacite_cobblestone_slab");
    public static final BlockRegistryObject<Block> DACITE_COBBLESTONE_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "dacite_cobblestone_stairs");
    public static final BlockRegistryObject<Block> DACITE_COBBLESTONE_WALL = createStoneWall("dacite_cobblestone_wall");
    public static final BlockRegistryObject<Block> DACITE_PILLAR = createBlock(BYGBlockProperties.BYGPillar::new, "dacite_pillar");
    public static final BlockRegistryObject<Block> DACITE_TILE = createBlock(BYGBlockProperties.BYGStone::new, "dacite_tile");
    public static final BlockRegistryObject<Block> DACITE_TILE_SLAB = createStoneSlab("dacite_tile_slab");
    public static final BlockRegistryObject<Block> DACITE_TILE_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "dacite_tile_stairs");
    public static final BlockRegistryObject<Block> DACITE_TILE_WALL = createStoneWall("dacite_tile_wall");

    public static final BlockRegistryObject<Block> RED_ROCK = createRedRock("red_rock");
    public static final BlockRegistryObject<Block> RED_ROCK_SLAB = createStoneSlab("red_rock_slab");
    public static final BlockRegistryObject<Block> RED_ROCK_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "red_rock_stairs");
    public static final BlockRegistryObject<Block> RED_ROCK_WALL = createStoneWall("red_rock_wall");
    public static final BlockRegistryObject<Block> RED_ROCK_BRICKS = createBlock(BYGBlockProperties.BYGStone::new, "red_rock_bricks");
    public static final BlockRegistryObject<Block> RED_ROCK_BRICK_SLAB = createStoneSlab("red_rock_brick_slab");
    public static final BlockRegistryObject<Block> RED_ROCK_BRICK_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "red_rock_brick_stairs");
    public static final BlockRegistryObject<Block> RED_ROCK_BRICK_WALL = createStoneWall("red_rock_brick_wall");
    public static final BlockRegistryObject<Block> CRACKED_RED_ROCK_BRICKS = createBlock(BYGBlockProperties.BYGStone::new, "cracked_red_rock_bricks");
    public static final BlockRegistryObject<Block> CRACKED_RED_ROCK_BRICK_SLAB = createStoneSlab("cracked_red_rock_brick_slab");
    public static final BlockRegistryObject<Block> CRACKED_RED_ROCK_BRICK_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "cracked_red_rock_brick_stairs");
    public static final BlockRegistryObject<Block> CRACKED_RED_ROCK_BRICK_WALL = createStoneWall("cracked_red_rock_brick_wall");
    public static final BlockRegistryObject<Block> CHISELED_RED_ROCK_BRICKS = createBlock(BYGBlockProperties.BYGStone::new, "chiseled_red_rock_bricks");
    public static final BlockRegistryObject<Block> CHISELED_RED_ROCK_BRICK_SLAB = createStoneSlab("chiseled_red_rock_brick_slab");
    public static final BlockRegistryObject<Block> CHISELED_RED_ROCK_BRICK_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "chiseled_red_rock_brick_stairs");
    public static final BlockRegistryObject<Block> CHISELED_RED_ROCK_BRICK_WALL = createStoneWall("chiseled_red_rock_brick_wall");
    public static final BlockRegistryObject<Block> MOSSY_RED_ROCK_BRICKS = createBlock(BYGBlockProperties.BYGStone::new, "mossy_red_rock_bricks");
    public static final BlockRegistryObject<Block> MOSSY_RED_ROCK_BRICK_SLAB = createStoneSlab("mossy_red_rock_brick_slab");
    public static final BlockRegistryObject<Block> MOSSY_RED_ROCK_BRICK_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "mossy_red_rock_brick_stairs");
    public static final BlockRegistryObject<Block> MOSSY_RED_ROCK_BRICK_WALL = createStoneWall("mossy_red_rock_brick_wall");

    public static final BlockRegistryObject<Block> MOSSY_STONE = createMossyStone("mossy_stone");
    public static final BlockRegistryObject<Block> MOSSY_STONE_SLAB = createStoneSlab("mossy_stone_slab");
    public static final BlockRegistryObject<Block> MOSSY_STONE_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "mossy_stone_stairs");
    public static final BlockRegistryObject<Block> MOSSY_STONE_WALL = createStoneWall("mossy_stone_wall");

    public static final BlockRegistryObject<Block> ROCKY_STONE = createRockyStone("rocky_stone");
    public static final BlockRegistryObject<Block> ROCKY_SLAB = createStoneSlab("rocky_stone_slab");
    public static final BlockRegistryObject<Block> ROCKY_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "rocky_stone_stairs");
    public static final BlockRegistryObject<Block> ROCKY_WALL = createStoneWall("rocky_stone_wall");

    public static final BlockRegistryObject<Block> TRAVERTINE = createTravertine("travertine");
    public static final BlockRegistryObject<Block> TRAVERTINE_SLAB = createTravertineSlab("travertine_slab");
    public static final BlockRegistryObject<Block> TRAVERTINE_STAIRS = createTravertineStairs("travertine_stairs");
    public static final BlockRegistryObject<Block> TRAVERTINE_WALL = createTravertineWall("travertine_wall");
    public static final BlockRegistryObject<Block> POLISHED_TRAVERTINE = createTravertine("polished_travertine");
    public static final BlockRegistryObject<Block> POLISHED_TRAVERTINE_SLAB = createTravertineSlab("polished_travertine_slab");
    public static final BlockRegistryObject<Block> POLISHED_TRAVERTINE_STAIRS = createTravertineStairs("polished_travertine_stairs");
    public static final BlockRegistryObject<Block> POLISHED_TRAVERTINE_WALL = createTravertineWall("polished_travertine_wall");
    public static final BlockRegistryObject<Block> CHISELED_TRAVERTINE = createTravertine("chiseled_travertine");
    public static final BlockRegistryObject<Block> CHISELED_TRAVERTINE_SLAB = createTravertineSlab("chiseled_travertine_slab");
    public static final BlockRegistryObject<Block> CHISELED_TRAVERTINE_STAIRS = createTravertineStairs("chiseled_travertine_stairs");
    public static final BlockRegistryObject<Block> CHISELED_TRAVERTINE_WALL = createTravertineWall("chiseled_travertine_wall");

    public static final BlockRegistryObject<Block> SCORIA_STONE = createScoria("scoria_stone");
    public static final BlockRegistryObject<Block> SCORIA_SLAB = createScoriaStoneSlab("scoria_stone_slab");
    public static final BlockRegistryObject<Block> SCORIA_STAIRS = createScoriaStoneStairs("scoria_stone_stairs");
    public static final BlockRegistryObject<Block> SCORIA_WALL = createScoriaStoneWall("scoria_stone_wall");
    public static final BlockRegistryObject<Block> SCORIA_COBBLESTONE = createScoria("scoria_cobblestone");
    public static final BlockRegistryObject<Block> SCORIA_COBBLESTONE_SLAB = createScoriaStoneSlab("scoria_cobblestone_slab");
    public static final BlockRegistryObject<Block> SCORIA_COBBLESTONE_STAIRS = createScoriaStoneStairs("scoria_cobblestone_stairs");
    public static final BlockRegistryObject<Block> SCORIA_COBBLESTONE_WALL = createScoriaStoneWall("scoria_cobblestone_wall");
    public static final BlockRegistryObject<Block> SCORIA_PILLAR = createScoriaStonePillar("scoria_pillar");
    public static final BlockRegistryObject<Block> SCORIA_STONEBRICKS = createScoria("scoria_stonebricks");
    public static final BlockRegistryObject<Block> SCORIA_STONEBRICK_SLAB = createScoriaStoneSlab("scoria_stonebrick_slab");
    public static final BlockRegistryObject<Block> SCORIA_STONEBRICK_STAIRS = createScoriaStoneStairs("scoria_stonebrick_stairs");
    public static final BlockRegistryObject<Block> SCORIA_STONEBRICK_WALL = createScoriaStoneWall("scoria_stonebrick_wall");
    public static final BlockRegistryObject<Block> CRACKED_SCORIA_STONE_BRICKS = createScoria("cracked_scoria_stone_bricks");
    public static final BlockRegistryObject<Block> EMERALDITE_ORE = createEmeralditeOre("emeraldite_ore");

    public static final BlockRegistryObject<Block> DUSTED_POLISHED_BLACKSTONE_BRICKS = createDustedPolishedBlackstoneBricks("dusted_polished_blackstone_bricks");
    public static final BlockRegistryObject<Block> ARISIAN_BLOOM_BRANCH = createArisianBloomBranch("arisian_bloom_branch");

    public static final BlockRegistryObject<Block> SOAPSTONE = createSoapstone("soapstone");
    public static final BlockRegistryObject<Block> SOAPSTONE_SLAB = createStoneSlab("soapstone_slab");
    public static final BlockRegistryObject<Block> SOAPSTONE_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "soapstone_stairs");
    public static final BlockRegistryObject<Block> SOAPSTONE_WALL = createStoneWall("soapstone_wall");
    public static final BlockRegistryObject<Block> POLISHED_SOAPSTONE = createBlock(BYGBlockProperties.BYGStone::new, "polished_soapstone");
    public static final BlockRegistryObject<Block> POLISHED_SOAPSTONE_SLAB = createStoneSlab("polished_soapstone_slab");
    public static final BlockRegistryObject<Block> POLISHED_SOAPSTONE_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "polished_soapstone_stairs");
    public static final BlockRegistryObject<Block> POLISHED_SOAPSTONE_WALL = createStoneWall("polished_soapstone_wall");
    public static final BlockRegistryObject<Block> SOAPSTONE_BRICKS = createBlock(BYGBlockProperties.BYGStone::new, "soapstone_bricks");
    public static final BlockRegistryObject<Block> SOAPSTONE_BRICK_SLAB = createStoneSlab("soapstone_brick_slab");
    public static final BlockRegistryObject<Block> SOAPSTONE_BRICK_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "soapstone_brick_stairs");
    public static final BlockRegistryObject<Block> SOAPSTONE_BRICK_WALL = createStoneWall("soapstone_brick_wall");
    public static final BlockRegistryObject<Block> SOAPSTONE_PILLAR = createBlock(BYGBlockProperties.BYGPillar::new, "soapstone_pillar");
    public static final BlockRegistryObject<Block> SOAPSTONE_TILE = createBlock(BYGBlockProperties.BYGStone::new, "soapstone_tile");
    public static final BlockRegistryObject<Block> SOAPSTONE_TILE_SLAB = createStoneSlab("soapstone_tile_slab");
    public static final BlockRegistryObject<Block> SOAPSTONE_TILE_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "soapstone_tile_stairs");
    public static final BlockRegistryObject<Block> SOAPSTONE_TILE_WALL = createStoneWall("soapstone_tile_wall");

    public static final BlockRegistryObject<Block> STRIPPED_PALO_VERDE_LOG = createStrippedLog("stripped_palo_verde_log");

    public static final BlockRegistryObject<Block> STRIPPED_PALO_VERDE_WOOD = createWood("stripped_palo_verde_wood");

    public static final BlockRegistryObject<Block> TALL_ALLIUM = createTallFlower(MaterialColor.COLOR_PURPLE, "tall_allium", BYGBlockTags.GROUND_TALL_ALLIUM);
    public static final BlockRegistryObject<Block> TALL_PINK_ALLIUM = createTallFlower(MaterialColor.COLOR_PINK, "tall_pink_allium", BYGBlockTags.GROUND_TALL_PINK_ALLIUM);
    public static final BlockRegistryObject<Block> ALLIUM_FLOWER_BUSH = createFlower("allium_flower_bush", BYGBlockTags.GROUND_ALLIUM_FLOWER_BUSH, false);
    public static final BlockRegistryObject<Block> AMARANTH = createFlower("amaranth", BYGBlockTags.GROUND_AMARANTH, false);
    public static final BlockRegistryObject<Block> ALPINE_BELLFLOWER = createFlower("alpine_bellflower", BYGBlockTags.GROUND_ALPINE_BELLFLOWER);
    public static final BlockRegistryObject<Block> ANGELICA = createFlower("angelica", BYGBlockTags.GROUND_ANGELICA);
    public static final BlockRegistryObject<Block> BARREL_CACTUS = createBarrelCactus("barrel_cactus");
    public static final BlockRegistryObject<Block> FLOWERING_BARREL_CACTUS = createBarrelCactus("flowering_barrel_cactus");
    public static final BlockRegistryObject<Block> CARVED_BARREL_CACTUS = createCarvedBarrelCactus("carved_barrel_cactus");
    public static final BlockRegistryObject<Block> WATER_BARREL_CACTUS = createWaterBarrelCactus("water_barrel_cactus");
    public static final BlockRegistryObject<Block> HONEY_BARREL_CACTUS = createHoneyBarrelCactus("honey_barrel_cactus");
    public static final BlockRegistryObject<Block> BEGONIA = createFlower("begonia", BYGBlockTags.GROUND_BEGONIA);
    public static final BlockRegistryObject<Block> BISTORT = createFlower("bistort", BYGBlockTags.GROUND_BISTORT);
    public static final BlockRegistryObject<Block> BLUE_ROSE_BUSH = createTallFlower(MaterialColor.COLOR_BLUE,"blue_rose_bush", BYGBlockTags.GROUND_BLUE_ROSE_BUSH);
    public static final BlockRegistryObject<Block> BLUE_SAGE = createFlower("blue_sage", BYGBlockTags.GROUND_BLUE_SAGE);
    public static final BlockRegistryObject<Block> CALIFORNIA_POPPY = createFlower("california_poppy", BYGBlockTags.GROUND_CALIFORNIA_POPPY);
    public static final BlockRegistryObject<Block> CROCUS = createFlower("crocus", BYGBlockTags.GROUND_CROCUS);
    public static final BlockRegistryObject<Block> BLACK_ROSE = createFlower("black_rose", BYGBlockTags.GROUND_BLACK_ROSE);
    public static final BlockRegistryObject<Block> CYAN_AMARANTH = createFlower("cyan_amaranth", BYGBlockTags.GROUND_CYAN_AMARANTH, false);
    public static final BlockRegistryObject<Block> CYAN_ROSE = createFlower("cyan_rose", BYGBlockTags.GROUND_ALPINE_BELLFLOWER);
    public static final BlockRegistryObject<Block> CYAN_TULIP = createFlower("cyan_tulip", BYGBlockTags.GROUND_ALPINE_BELLFLOWER);
    public static final BlockRegistryObject<Block> DAFFODIL = createFlower("daffodil", BYGBlockTags.GROUND_ALPINE_BELLFLOWER);
    public static final BlockRegistryObject<Block> DELPHINIUM = createTallFlower(MaterialColor.TERRACOTTA_BLUE,"delphinium", BYGBlockTags.GROUND_DELPHINIUM);
    public static final BlockRegistryObject<Block> FAIRY_SLIPPER = createBlock(() -> new BYGFlowerBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).strength(0.0f).noCollission().noOcclusion().lightLevel((state) -> 8), BYGBlockTags.GROUND_FAIRY_SLIPPER), "fairy_slipper");
    public static final BlockRegistryObject<Block> FIRECRACKER_FLOWER_BUSH = createShrub(TreeSpawners.FIRECRACKER, "firecracker_flower_bush");
    public static final BlockRegistryObject<Block> FOXGLOVE = createTallFlower(MaterialColor.COLOR_ORANGE,"foxglove", BYGBlockTags.GROUND_FOXGLOVE);
    public static final BlockRegistryObject<Block> GOLDEN_SPINED_CACTUS = createDesertPlant("golden_spined_cactus", BYGBlockTags.GROUND_GOLDEN_SPINED_CACTUS);
    public static final BlockRegistryObject<Block> GREEN_TULIP = createFlower("green_tulip", BYGBlockTags.GROUND_GREEN_TULIP);
    public static final BlockRegistryObject<Block> GUZMANIA = createFlower("guzmania", BYGBlockTags.GROUND_GUZMANIA);
    public static final BlockRegistryObject<Block> INCAN_LILY = createFlower("incan_lily", BYGBlockTags.GROUND_INCAN_LILY);
    public static final BlockRegistryObject<Block> IRIS = createFlower("iris", BYGBlockTags.GROUND_IRIS);
    public static final BlockRegistryObject<Block> JAPANESE_ORCHID = createTallFlower(MaterialColor.COLOR_PINK,"japanese_orchid", BYGBlockTags.GROUND_JAPANESE_ORCHID);
    public static final BlockRegistryObject<Block> KOVAN_FLOWER = createFlower("kovan_flower", BYGBlockTags.GROUND_KOVAN_FLOWER);
    public static final BlockRegistryObject<Block> LAZARUS_BELLFLOWER = createFlower("lazarus_bellflower", BYGBlockTags.GROUND_LAZARUS_BELLFLOWER);
    public static final BlockRegistryObject<Block> LOLLIPOP_FLOWER = createFlower("lollipop_flower", BYGBlockTags.GROUND_LOLLIPOP_FLOWER);
    public static final BlockRegistryObject<Block> MAGENTA_AMARANTH = createFlower("magenta_amaranth", BYGBlockTags.GROUND_MAGENTA_AMARANTH, false);
    public static final BlockRegistryObject<Block> MAGENTA_TULIP = createFlower("magenta_tulip", BYGBlockTags.GROUND_MAGENTA_TULIP);
    public static final BlockRegistryObject<Block> ORANGE_AMARANTH = createFlower("orange_amaranth", BYGBlockTags.GROUND_ORANGE_AMARANTH, false);
    public static final BlockRegistryObject<Block> ORANGE_DAISY = createFlower("orange_daisy", BYGBlockTags.GROUND_ORANGE_DAISY);
    public static final BlockRegistryObject<Block> ORSIRIA_ROSE = createFlower("osiria_rose", BYGBlockTags.GROUND_ORSIRIA_ROSE);
    public static final BlockRegistryObject<Block> PEACH_LEATHER_FLOWER = createFlower("peach_leather_flower", BYGBlockTags.GROUND_PEACH_LEATHER_FLOWER);
    public static final BlockRegistryObject<Block> PINK_ALLIUM = createFlower("pink_allium", BYGBlockTags.GROUND_PINK_ALLIUM);
    public static final BlockRegistryObject<Block> PINK_ALLIUM_FLOWER_BUSH = createFlower("pink_allium_flower_bush", BYGBlockTags.GROUND_PINK_ALLIUM_BUSH, false);
    public static final BlockRegistryObject<Block> PINK_ANEMONE = createFlower("pink_anemone", BYGBlockTags.GROUND_PINK_ANEMONE);
    public static final BlockRegistryObject<Block> PINK_DAFFODIL = createFlower("pink_daffodil", BYGBlockTags.GROUND_PINK_DAFFODIL);
    public static final BlockRegistryObject<Block> PRAIRIE_GRASS = createBlock(() -> new BYGBonemealActionBlock(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS), BYGBlockTags.GROUND_PRAIRIE_GRASS, BYGBonemealActionBlock.BonemealAction.growDoublePlant(() -> BYGBlocks.TALL_PRAIRIE_GRASS.get())), "prairie_grass");
    public static final BlockRegistryObject<Block> PROTEA_FLOWER = createFlower("protea_flower", BYGBlockTags.GROUND_PROTEA_FLOWER);
    public static final BlockRegistryObject<Block> PURPLE_AMARANTH = createFlower("purple_amaranth", BYGBlockTags.GROUND_PURPLE_AMARANTH, false);
    public static final BlockRegistryObject<Block> PURPLE_SAGE = createFlower("purple_sage", BYGBlockTags.GROUND_PURPLE_SAGE);
    public static final BlockRegistryObject<Block> PURPLE_TULIP = createFlower("purple_tulip", BYGBlockTags.GROUND_PURPLE_TULIP);
    public static final BlockRegistryObject<Block> RICHEA = createFlower("richea", BYGBlockTags.GROUND_RICHEA);
    public static final BlockRegistryObject<Block> ROSE = createFlower("rose", BYGBlockTags.GROUND_ROSE);
    public static final BlockRegistryObject<Block> SNOWDROPS = createPottedBlock(BYGBlockProperties.BYGSnowyPlant::new, "snowdrops");
    public static final BlockRegistryObject<Block> SILVER_VASE_FLOWER = createFlower("silver_vase_flower", BYGBlockTags.GROUND_SILVER_VASE_FLOWER);
    public static final BlockRegistryObject<Block> TORCH_GINGER = createFlower("torch_ginger", BYGBlockTags.GROUND_TORCH_GINGER);
    public static final BlockRegistryObject<Block> VIOLET_LEATHER_FLOWER = createFlower("violet_leather_flower", BYGBlockTags.GROUND_VIOLET_LEATHER_FLOWER);
    public static final BlockRegistryObject<Block> WHITE_ANEMONE = createFlower("white_anemone", BYGBlockTags.GROUND_WHITE_ANEMONE);
    public static final BlockRegistryObject<Block> WHITE_SAGE = createFlower("white_sage", BYGBlockTags.GROUND_WHITE_SAGE);
    public static final BlockRegistryObject<Block> WINTER_CYCLAMEN = createPottedBlock(BYGBlockProperties.BYGSnowyPlant::new, "winter_cyclamen");
    public static final BlockRegistryObject<Block> WINTER_ROSE = createPottedBlock(BYGBlockProperties.BYGSnowyPlant::new, "winter_rose");
    public static final BlockRegistryObject<Block> WINTER_SCILLA = createPottedBlock(BYGBlockProperties.BYGSnowyPlant::new, "winter_scilla");
    public static final BlockRegistryObject<Block> YELLOW_DAFFODIL = createFlower("yellow_daffodil", BYGBlockTags.GROUND_YELLOW_DAFFODIL);
    public static final BlockRegistryObject<Block> YELLOW_TULIP = createFlower("yellow_tulip", BYGBlockTags.GROUND_YELLOW_TULIP);
    public static final BlockRegistryObject<Block> HYDRANGEA_BUSH = createHydrangeaBush("hydrangea_bush", BYGBlockTags.GROUND_HYDRANGEA_BUSH);
    public static final BlockRegistryObject<Block> HYDRANGEA_HEDGE = createHydrangeaHedge("hydrangea_hedge", BYGBlockTags.GROUND_HYDRANGEA_BUSH);
    public static final BlockRegistryObject<Block> PODZOL_DACITE = createBlock(() -> SnowyDirtBlockAccess.byg_create(BlockBehaviour.Properties.copy(BYGBlocks.DACITE.get())), "podzol_dacite");
    public static final BlockRegistryObject<Block> OVERGROWN_DACITE = createStoneSpreadable(DACITE, MaterialColor.COLOR_GREEN, "overgrown_dacite");
    public static final BlockRegistryObject<Block> OVERGROWN_STONE = createStoneSpreadable(() -> Blocks.STONE, MaterialColor.COLOR_GREEN, "overgrown_stone");
    public static final BlockRegistryObject<Block> OVERGROWN_CRIMSON_BLACKSTONE = createNetherStoneSpreadable(Blocks.BLACKSTONE, MaterialColor.COLOR_RED, () -> NetherFeatures.CRIMSON_FOREST_VEGETATION_BONEMEAL.value(), "overgrown_crimson_blackstone");
    public static final BlockRegistryObject<Block> MYCELIUM_NETHERRACK = createNetherSpreadable(() -> Blocks.NETHERRACK, MaterialColor.COLOR_GRAY, () -> BYGNetherVegetationFeatures.WAILING_VEGETATION.value(), "mycelium_netherrack");
    public static final BlockRegistryObject<Block> OVERGROWN_NETHERRACK = createNetherSpreadable(() -> Blocks.NETHERRACK, MaterialColor.COLOR_GREEN, () -> NetherFeatures.TWISTING_VINES_BONEMEAL.value(), "overgrown_netherrack");
    public static final BlockRegistryObject<Block> IVIS_PHYLIUM = createEndStoneSpreadable(() -> Blocks.END_STONE, MaterialColor.COLOR_PURPLE, () -> BYGEndVegetationFeatures.IVIS_PLANTS.value(), "ivis_phylium");
    public static final BlockRegistryObject<Block> EMBUR_NYLIUM = createNetherSpreadable(BLUE_NETHERRACK, MaterialColor.COLOR_ORANGE, () -> BYGNetherVegetationFeatures.EMBUR_BOG_VEGETATION.value(), "embur_nylium");
    public static final BlockRegistryObject<Block> SYTHIAN_NYLIUM = createNetherSpreadable(() -> Blocks.NETHERRACK, MaterialColor.COLOR_YELLOW, () -> BYGNetherVegetationFeatures.SYTHIAN_VEGETATION.value(), "sythian_nylium");
    public static final BlockRegistryObject<Block> WAILING_NYLIUM = createNetherSpreadable(() -> Blocks.SOUL_SOIL, MaterialColor.COLOR_PURPLE, () -> BYGNetherVegetationFeatures.WAILING_VEGETATION.value(), "wailing_nylium");
    public static final BlockRegistryObject<Block> LUSH_GRASS_BLOCK = createDirtSpreadable(LUSH_DIRT, MaterialColor.COLOR_GREEN, "lush_grass_block");
    public static final BlockRegistryObject<Block> NIGHTSHADE_PHYLIUM = createEndStoneSpreadable(() -> Blocks.END_STONE, MaterialColor.COLOR_BLUE, () -> BYGEndVegetationFeatures.NIGHTSHADE_PLANTS.value(), "nightshade_phylium");
    public static final BlockRegistryObject<Block> ETHER_PHYLIUM = createEndDirtSpreadable(BYGBlocks.ETHER_SOIL, MaterialColor.COLOR_MAGENTA, () -> BYGEndVegetationFeatures.ETHER_PLANTS.value(), "ether_phylium");
    public static final BlockRegistryObject<Block> VERMILION_SCULK = createEndStoneSpreadable(BYGBlocks.ETHER_STONE, MaterialColor.COLOR_RED, () -> BYGEndFeatures.ISLAND_SCULK_PLANTS.value().feature().value(), "vermilion_sculk");
    public static final BlockRegistryObject<Block> SHULKREN_PHYLIUM = createEndStoneSpreadable(() -> Blocks.END_STONE, MaterialColor.COLOR_LIGHT_GREEN, () -> BYGEndVegetationFeatures.SHULKREN_PLANTS.value(), "shulkren_phylium");
    public static final BlockRegistryObject<DirtPathBlock> LUSH_GRASS_PATH = createBlock(() -> DirtPathBlockAccess.byg_create(BlockBehaviour.Properties.of(Material.DIRT).strength(0.65F).sound(SoundType.GRASS).isViewBlocking((state, reader, pos) -> true).isSuffocating((state, reader, pos) -> true)), "lush_grass_path");
    public static final BlockRegistryObject<Block> BULBIS_PHYCELIUM = createEndStoneSpreadable(() -> Blocks.END_STONE, MaterialColor.TERRACOTTA_WHITE, () -> BYGEndVegetationFeatures.BULBIS_ANOMALIES.value(), "bulbis_phycelium");
    public static final BlockRegistryObject<Block> IMPARIUS_PHYLIUM = createEndStoneSpreadable(() -> Blocks.END_STONE, MaterialColor.COLOR_CYAN, () -> BYGEndVegetationFeatures.IMPARIUS_PLANTS.value(), "imparius_phylium");

    public static final BlockRegistryObject<Block> HYPOGEAL_IMPERIUM = createHypogealBlock("hypogeal_imperium");
//    public static final BlockRO<Block> BORIC_TORCH = createBlock(new BoricTorchBlock(AbstractBlock.Properties.of(Material.WOOD).instabreak().lightLevel((state) -> 14), BoricFlameParticle.BoricParticleData.BORIC), "boric_torch");

    private static BlockRegistryObject<Block> createWaterLilyBlock(MaterialColor materialColor, String id) {
        return createBlock(() -> WaterlilyBlockAccess.byg_create(BlockBehaviour.Properties.copy(Blocks.LILY_PAD).color(materialColor)), id);
    }

    private static BlockRegistryObject<Block> createWaterSilkBlock(MaterialColor materialColor, String id) {
        return createBlock(() -> new WaterSilkBlock(BlockBehaviour.Properties.copy(Blocks.LILY_PAD).color(materialColor)), id);
    }

    private static BlockRegistryObject<Block> createScaffoldingBlock(int light, MaterialColor materialColor, String id) {
        return createBlock(() -> BYGBlockFactory.INSTANCE.createScaffolding(BlockBehaviour.Properties.copy(Blocks.SCAFFOLDING).lightLevel(state -> light).color(materialColor)), id);
    }

    private static BlockRegistryObject<Block> createChiseledFungalImpariusSlab(String id) {
        return createBlock(() -> new SlabBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.WARPED_WART_BLOCK).sound(SoundType.HONEY_BLOCK).strength(2.0f)), id);
    }

    private static BlockRegistryObject<Block> createChiseledFungalImpariusStairs(String id) {
        return createBlock(() -> StairBlockAccess.byg_create(Blocks.COBBLESTONE.defaultBlockState(), BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.WARPED_WART_BLOCK).sound(SoundType.HONEY_BLOCK).strength(2.0f)), id);
    }

    private static BlockRegistryObject<Block> createChiseledFungalImpariusWall(String id) {
        return createBlock(() -> new WallBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.WARPED_WART_BLOCK).sound(SoundType.HONEY_BLOCK).strength(2.0f)), id);
    }

    private static BlockRegistryObject<Block> createCrystalClusterBlock(int light, int i, int j, MaterialColor materialColor, String id) {
        return createBlock(() -> new AmethystClusterBlock(i, j, BlockBehaviour.Properties.of(BYGMaterials.SUBZERO_CRYSTAL).sound(SoundType.GLASS).color(materialColor).strength(1.5f).requiresCorrectToolForDrops().noOcclusion().lightLevel((state) -> light)), id);
    }

    private static BlockRegistryObject<Block> createHypogealBlock(String id) {
        return createBlock(() -> new HypogealImperiumBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.GLASS).strength(1.5f).requiresCorrectToolForDrops().lightLevel(litBlockEmission(13))), id);
    }

    private static BlockRegistryObject<Block> createSubzeroBuddingCrystalBlock(MaterialColor materialColor,String id) {
        return createBlock(() -> new BuddingSubzeroCrystalBlock(BlockBehaviour.Properties.of(Material.STONE).color(materialColor).sound(SoundType.GLASS).lightLevel((state) -> 8).noLootTable().randomTicks().requiresCorrectToolForDrops().strength(1.5f, 1.5f)), id);
    }

    private static BlockRegistryObject<Block> createTheriumBuddingCrystalBlock(MaterialColor materialColor,String id) {
        return createBlock(() -> new BuddingTheriumCrystalBlock(BlockBehaviour.Properties.of(Material.STONE).color(materialColor).sound(SoundType.GLASS).lightLevel((state) -> 8).noLootTable().randomTicks().requiresCorrectToolForDrops().strength(1.5f, 1.5f)), id);
    }

    private static BlockRegistryObject<Block> createCrystalBlock(MaterialColor materialColor, String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.STONE).color(materialColor).sound(SoundType.GLASS).lightLevel((state) -> 8).strength(1.5f, 1.5f).requiresCorrectToolForDrops()), id);
    }

    private static BlockRegistryObject<Block> createTravertineSlab(String id) {
        return createBlock(() -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).sound(SoundType.STONE).strength(2.0f, 6.0f).requiresCorrectToolForDrops()), id);
    }

    private static BlockRegistryObject<Block> createTravertineStairs(String id) {
        return createBlock(() -> StairBlockAccess.byg_create(Blocks.COBBLESTONE.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).sound(SoundType.STONE).strength(2.0f, 6.0f).requiresCorrectToolForDrops()), id);
    }

    private static BlockRegistryObject<Block> createTravertineWall(String id) {
        return createBlock(() -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).sound(SoundType.STONE).strength(2.0f, 6.0f).requiresCorrectToolForDrops()), id);
    }

    private static BlockRegistryObject<Block> createScoriaStoneSlab(String id) {
        return createBlock(() -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_RED).sound(SoundType.STONE).strength(2.0f, 6.0f).requiresCorrectToolForDrops()), id);
    }

    private static BlockRegistryObject<Block> createScoriaStoneStairs(String id) {
        return createBlock(() -> StairBlockAccess.byg_create(Blocks.COBBLESTONE.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_RED).sound(SoundType.STONE).strength(2.0f, 6.0f).requiresCorrectToolForDrops()), id);
    }

    private static BlockRegistryObject<Block> createScoriaStoneWall(String id) {
        return createBlock(() -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_RED).sound(SoundType.STONE).strength(2.0f, 6.0f).requiresCorrectToolForDrops()), id);
    }

    private static BlockRegistryObject<Block> createScoriaStonePillar(String id) {
        return createBlock(() -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_RED).sound(SoundType.STONE).strength(1.5f, 6.0f).requiresCorrectToolForDrops()), id);
    }

    private static BlockRegistryObject<Block> createWailingBellBlossom(String id) {
        return createBlock(() -> new WailingBulbBlossomBlock(BlockBehaviour.Properties.of(Material.CLAY, MaterialColor.COLOR_PURPLE).sound(SoundType.SHROOMLIGHT).noOcclusion().lightLevel((state) -> 14)), id);
    }

    private static BlockRegistryObject<Block> createWailingVine(String id) {
        return createBlock(() -> new VineBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_PURPLE).sound(SoundType.TWISTING_VINES).instabreak().randomTicks().noCollission()), id);
    }

    private static BlockRegistryObject<Block> createWailingPlant(String id) {
        return createBlock(() -> new WailingPlantBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_PURPLE).sound(SoundType.ROOTS).instabreak().noCollission()), id);
    }

    private static BlockRegistryObject<Block> createEmburGelBlock(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.CLAY, MaterialColor.TERRACOTTA_YELLOW).sound(SoundType.HONEY_BLOCK).noOcclusion().speedFactor(1.3f)), id);
    }

    private static BlockRegistryObject<Block> createEmburGelVine(String id) {
        return createBlock(() -> new EmburVineBlock(BlockBehaviour.Properties.of(Material.LEAVES, MaterialColor.TERRACOTTA_YELLOW).instabreak().randomTicks().sound(SoundType.HONEY_BLOCK).noCollission()), id);
    }

    private static BlockRegistryObject<Block> createEmburGelVinePlant(String id) {
        return createBlock(() -> new EmburVinePlantBlock(BlockBehaviour.Properties.of(Material.LEAVES, MaterialColor.TERRACOTTA_YELLOW).instabreak().randomTicks().sound(SoundType.HONEY_BLOCK).noCollission()), id);
    }

    private static BlockRegistryObject<Block> createEmburGelBranch(String id) {
        return createBlock(() -> new TreeBranchBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.TERRACOTTA_YELLOW).instabreak().sound(SoundType.HONEY_BLOCK).noOcclusion().noCollission().lightLevel((state) -> 10)), id);
    }

    private static BlockRegistryObject<Block> createArisianBloomBranch(String id) {
        return createBlock(() -> new TreeBranchBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_PURPLE).instabreak().sound(SoundType.GRASS).noOcclusion().noCollission().lightLevel((state) -> 10)), id);
    }

    private static BlockRegistryObject<Block> createTheriumGlass(String id) {
        return createBlock(() -> new GlassBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_CYAN).sound(SoundType.GLASS).lightLevel((state) -> 12).noOcclusion().isValidSpawn(BYGBlocks::neverAllowSpawn).isRedstoneConductor(BYGBlocks::isntSolid).isSuffocating(BYGBlocks::isntSolid).isViewBlocking(BYGBlocks::isntSolid).strength(0.4f, 8.0f)), id);
    }

    private static BlockRegistryObject<Block> createTheriumGlassPane(String id) {
        return createBlock(() -> IronBarsBlockAccess.byg_create(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_CYAN).sound(SoundType.GLASS).lightLevel((state) -> 12).noOcclusion().strength(0.4f, 8.0f)), id);
    }

    private static BlockRegistryObject<Block> createChiseledTherium(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_CYAN).requiresCorrectToolForDrops().sound(SoundType.GLASS).strength(1.5f, 9.0f)), id);
    }

    private static BlockRegistryObject<Block> createChiseledTheriumStairs(String id) {
        return createBlock(() -> StairBlockAccess.byg_create(Blocks.PRISMARINE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.PRISMARINE).requiresCorrectToolForDrops().sound(SoundType.GLASS).strength(1.5f, 9.0f)), id);
    }

    private static BlockRegistryObject<Block> createChiseledTheriumSlab(String id) {
        return createBlock(() -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_CYAN).requiresCorrectToolForDrops().sound(SoundType.GLASS).strength(1.5f, 9.0f)), id);
    }

    private static BlockRegistryObject<Block> createChiseledTheriumWall(String id) {
        return createBlock(() -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_CYAN).requiresCorrectToolForDrops().sound(SoundType.GLASS).strength(1.5f, 9.0f)), id);
    }

    private static BlockRegistryObject<Block> createShinyChiseledTherium(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_CYAN).requiresCorrectToolForDrops().sound(SoundType.GLASS).lightLevel((state) -> 12).strength(1.5f, 9.0f)), id);
    }

    private static BlockRegistryObject<Block> createShinyChiseledTheriumStairs(String id) {
        return createBlock(() -> StairBlockAccess.byg_create(Blocks.PRISMARINE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.PRISMARINE).requiresCorrectToolForDrops().sound(SoundType.GLASS).lightLevel((state) -> 12).strength(1.5f, 9.0f)), id);
    }

    private static BlockRegistryObject<Block> createShinyChiseledTheriumSlab(String id) {
        return createBlock(() -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_CYAN).requiresCorrectToolForDrops().sound(SoundType.GLASS).lightLevel((state) -> 12).strength(1.5f, 9.0f)), id);
    }

    private static BlockRegistryObject<Block> createShinyChiseledTheriumWall(String id) {
        return createBlock(() -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_CYAN).requiresCorrectToolForDrops().sound(SoundType.GLASS).lightLevel((state) -> 12).strength(1.5f, 9.0f)), id);
    }

    static BlockRegistryObject<Block> createFence(String id) {
        return createBlock(() -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0f, 3.0f)), id);
    }

    static BlockRegistryObject<Block> createFenceGate(String id) {
        return createBlock(() -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0f, 3.0f)), id);
    }

    private static BlockRegistryObject<Block> createSand(MaterialColor color, int dustColor, String id) {
        return createBlock(() -> new SandBlock(dustColor, BlockBehaviour.Properties.of(Material.SAND, color).sound(SoundType.SAND).strength(0.2f)), id);
    }

    private static BlockRegistryObject<Block> createSandstone(MaterialColor color, String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.STONE, color).requiresCorrectToolForDrops().strength(0.8F).sound(SoundType.STONE)), id);
    }

    private static BlockRegistryObject<Block> createSandstoneSlab(MaterialColor color, String id) {
        return createBlock(() -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, color).requiresCorrectToolForDrops().strength(0.8F).sound(SoundType.STONE)), id);
    }

    private static BlockRegistryObject<Block> createSandstoneWall(MaterialColor color, String id) {
        return createBlock(() -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE, color).requiresCorrectToolForDrops().strength(0.8F).sound(SoundType.STONE)), id);
    }

    private static BlockRegistryObject<Block> createSandstoneStairs(MaterialColor color, String id) {
        return createBlock(() -> StairBlockAccess.byg_create(BYGBlocks.WINDSWEPT_SANDSTONE.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE, color).requiresCorrectToolForDrops().strength(0.8F).sound(SoundType.STONE)), id);
    }

    private static BlockRegistryObject<Block> createSandstonePillar(MaterialColor color, String id) {
        return createBlock(() -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE, color).requiresCorrectToolForDrops().strength(0.8F).sound(SoundType.STONE)), id);
    }

    static BlockRegistryObject<Block> createWoodSlab(String id) {
        return createBlock(() -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0f, 3.0f)), id);
    }

    private static BlockRegistryObject<Block> createStoneSlab(String id) {
        return createBlock(() -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(2.0f, 6.0f).requiresCorrectToolForDrops()), id);
    }

    private static BlockRegistryObject<Block> createStoneWall(String id) {
        return createBlock(() -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(2.0f, 6.0f).requiresCorrectToolForDrops()), id);
    }

    static BlockRegistryObject<Block> createWoodPressurePlate(String id) {
        return createBlock(() -> PressurePlateBlockAccess.byg_create(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).noCollission().strength(0.5F)), id);
    }

    static BlockRegistryObject<Block> createWoodStairs(String id) {
        return createBlock(() -> StairBlockAccess.byg_create(Registry.BLOCK.get(BYG.createLocation(id.replace("_stairs", "planks"))).defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2.0f, 3.0f)), id);
    }

    static BlockRegistryObject<Block> createTrapDoor(String id) {
        return createBlock(() -> TrapDoorBlockAccess.byg_create(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(2.0f, 3.0f).noOcclusion()), id);
    }

    static BlockRegistryObject<Block> createCraftingTable(String id) {
        return createBlock(() -> new BYGCraftingTableBlock(BlockBehaviour.Properties.copy(Blocks.CRAFTING_TABLE)), id);
    }

    static BlockRegistryObject<Block> createWoodButton(String id) {
        return createBlock(() -> WoodButtonBlockAccess.byg_create(BlockBehaviour.Properties.of(Material.DECORATION).sound(SoundType.WOOD).noCollission().strength(0.5F)), id);
    }

    static BlockRegistryObject<Block> createBookshelf(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(2.0f, 3.0f)), id);
    }

    static BlockRegistryObject<Block> createDoor(String id) {
        return createBlock(() -> DoorBlockAccess.byg_create(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(2.0f, 3.0f).noOcclusion()), id);
    }

    static BlockRegistryObject<Block> createPlanks(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(2.0f, 3.0f)), id);
    }

    static BlockRegistryObject<Block> createWood(String id) {
        return createBlock(() -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0f)), id);
    }

    static BlockRegistryObject<Block> createStrippedLog(String id) {
        return createBlock(() -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(2.0f)), id);
    }

    static BlockRegistryObject<Block> createLog(String id) {
        return createBlock(() -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0f)), id);
    }

    private static BlockRegistryObject<Block> createSoapstone(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLACK).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.5f, 6.0f)), id);
    }

    private static BlockRegistryObject<Block> createTravertine(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5f, 6.0f)), id);
    }

    private static BlockRegistryObject<Block> createNetherStone(MaterialColor color, String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.STONE, color).requiresCorrectToolForDrops().sound(SoundType.NETHERRACK).strength(0.4f, 0.4f)), id);
    }

    private static BlockRegistryObject<Block> createDoubleDamagePlantBlock(String id, TagKey<Block> groundTag) {
        return createBlock(() -> new DoubleDamagePlantBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.TWISTING_VINES).strength(0.0f).noCollission().noOcclusion(), groundTag), id);
    }

    private static BlockRegistryObject<Block> createBoricFireBlock(MaterialColor color, String id) {
        return createBlock(() -> new BoricFireBlock(BlockBehaviour.Properties.of(Material.FIRE, color).sound(SoundType.WOOL).noCollission().instabreak().lightLevel((state) -> 14)), id);
    }

    private static BlockRegistryObject<Block> createDesertPlant(String id, TagKey<Block> groundTag) {
        return createPottedBlock(() -> new DesertPlant(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).strength(0.0f).noCollission().noOcclusion(), groundTag), id);
    }

    private static BlockRegistryObject<Block> createCrypticFireBlock(MaterialColor color, String id) {
        return createBlock(() -> new CrypticFireBlock(BlockBehaviour.Properties.of(Material.FIRE, color).sound(SoundType.WOOL).noCollission().instabreak().lightLevel((state) -> 14)), id);
    }

    private static BlockRegistryObject<Block> createDustedPolishedBlackstoneBricks(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BRICKS).requiresCorrectToolForDrops().strength(1.5f, 6.0f)), id);
    }

    private static BlockRegistryObject<Block> createScoria(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_RED).sound(SoundType.STONE).strength(1.5f, 6.0f).requiresCorrectToolForDrops()), id);
    }

    private static BlockRegistryObject<Block> createDacite(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_WHITE).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5f, 6.0f)), id);
    }

    private static BlockRegistryObject<Block> createEtherStone(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_CYAN).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5f, 6.0f)), id);
    }

    private static BlockRegistryObject<Block> createRockyStone(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5f, 6.0f)), id);
    }

    private static BlockRegistryObject<Block> createMossyStone(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_GREEN).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5f, 6.0f)), id);
    }

    private static BlockRegistryObject<Block> createRedRock(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_ORANGE).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5f, 6.0f)), id);
    }

    private static BlockRegistryObject<Block> createAmetrineOre(String id) {
        return createBlock(() -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_PINK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5f, 6.0f), UniformInt.of(3, 9)), id);
    }

    private static BlockRegistryObject<Block> createBuddingAmetrineOre(String id) {
        return createBlock(() -> new BuddingAmetrineBlock(BlockBehaviour.Properties.copy(Blocks.BUDDING_AMETHYST).requiresCorrectToolForDrops().sound(SoundType.STONE).randomTicks()), id);
    }

    private static BlockRegistryObject<Block> createAmetrineBlock(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_PINK).isSuffocating(BYGBlocks::isntSolid).isViewBlocking(BYGBlocks::isntSolid).noOcclusion().requiresCorrectToolForDrops().sound(SoundType.GLASS).strength(1.5f, 6.0f)), id);
    }

    private static BlockRegistryObject<Block> createCampfireBlock(int type, String id) {
        return createBlock(() -> new CampfireBlock(true, type, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD).noOcclusion().lightLevel(litBlockEmission(14))), id);
    }


    private static BlockRegistryObject<Block> createPendoriteOre(String id) {
        return createBlock(() -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_PURPLE).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5f, 6.0f)), id);
    }

    private static BlockRegistryObject<Block> createPendoriteBlock(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL, MaterialColor.TERRACOTTA_PURPLE).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5f, 6.0f)), id);
    }

    private static BlockRegistryObject<Block> createRawPendoriteBlock(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL, MaterialColor.TERRACOTTA_PURPLE).requiresCorrectToolForDrops().sound(SoundType.ANCIENT_DEBRIS).strength(1.5f, 6.0f)), id);
    }

    private static BlockRegistryObject<Block> createEmeralditeOre(String id) {
        return createBlock(() -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GREEN).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5f, 6.0f), UniformInt.of(4, 7)), id);
    }

    private static BlockRegistryObject<Block> createNetherOre(SoundType sound, MaterialColor color, String id, UniformInt xpRange) {
        return createBlock(() -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, color).requiresCorrectToolForDrops().sound(sound).strength(3.0f, 3.0f), xpRange), id);
    }

    private static BlockRegistryObject<Block> createBarrelCactus(String id) {
        return createBlock(() -> new AbstractBarrelCactusBlock(BlockBehaviour.Properties.of(Material.CACTUS, MaterialColor.COLOR_GREEN).sound(SoundType.WOOL).strength(0.4f).noOcclusion()), id);
    }

    private static BlockRegistryObject<Block> createCarvedBarrelCactus(String id) {
        return createBlock(() -> new CarvedBarrelCactusBlock(BlockBehaviour.Properties.of(Material.CACTUS, MaterialColor.COLOR_GREEN).sound(SoundType.WOOL).strength(0.4f).noOcclusion()), id);
    }

    private static BlockRegistryObject<Block> createWaterBarrelCactus(String id) {
        return createBlock(() -> new WaterBarrelCactusBlock(BlockBehaviour.Properties.of(Material.CACTUS, MaterialColor.COLOR_GREEN).sound(SoundType.WOOL).strength(0.4f)), id);
    }

    private static BlockRegistryObject<Block> createHoneyBarrelCactus(String id) {
        return createBlock(() -> new HoneyBarrelCactusBlock(BlockBehaviour.Properties.of(Material.CACTUS, MaterialColor.COLOR_GREEN).sound(SoundType.WOOL).strength(0.4f)), id);
    }

    private static BlockRegistryObject<Block> createLanternBlock(MaterialColor color, String id) {
        return createBlock(() -> new LanternBlock(BlockBehaviour.Properties.of(Material.METAL, color).noOcclusion().requiresCorrectToolForDrops().sound(SoundType.LANTERN).strength(3.5f).lightLevel((state) -> 15)), id);
    }

    private static BlockRegistryObject<Block> createCrypticLanternBlock(MaterialColor color, String id) {
        return createBlock(() -> new CrypticLanternBlock(BlockBehaviour.Properties.of(Material.METAL, color).noOcclusion().requiresCorrectToolForDrops().sound(SoundType.LANTERN).strength(3.5f).lightLevel((state) -> 15)), id);
    }

    private static BlockRegistryObject<Block> createEndRodBlock(MaterialColor color, String id) {
        return createBlock(() -> new CrypticEndRodBlock(BlockBehaviour.Properties.of(Material.DECORATION, color).sound(SoundType.CANDLE).instabreak().noOcclusion().lightLevel((state) -> 14)), id);
    }

    private static BlockRegistryObject<Block> createCattailSproutBlock(String id) {
        return createBlock(() -> new CattailSproutBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_GREEN).sound(SoundType.WET_GRASS).strength(0.0f).randomTicks().noCollission().noOcclusion()), id);
    }

    private static BlockRegistryObject<Block> createCattailPlantBlock(String id) {
        return createBlock(() -> new CattailPlantBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_GREEN).sound(SoundType.WET_GRASS).strength(0.0f).noCollission().noOcclusion()), id);
    }

    private static BlockRegistryObject<Block> createAloeVeraPlantBlock(String id) {
        return createBlock(() -> new AloeVeraBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_GREEN).sound(SoundType.WET_GRASS).strength(0.0f).randomTicks().noCollission().noOcclusion()), id);
    }

    private static BlockRegistryObject<Block> createBloomingAloeVeraPlantBlock(String id) {
        return createBlock(() -> new BloomingAloeVeraBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_GREEN).sound(SoundType.WET_GRASS).strength(0.0f).noCollission().noOcclusion()), id);
    }

    private static BlockRegistryObject<Block> createWhitePuffBlock(SoundType sound, MaterialColor color, String id) {
        return createPottedBlock(() -> new WhitePuffballBlock(BlockBehaviour.Properties.of(Material.PLANT, color).sound(sound).noOcclusion().noCollission().strength(0.0f).randomTicks()), id);
    }

    static BlockRegistryObject<Block> createMushroom(TagKey<Block> blockTagKey, String id) {
        return createPottedBlock(() -> new BYGMushroomBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM), blockTagKey), id);
    }

    static BlockRegistryObject<Block> createFungus(TagKey<Block> blockTagKey, String id) {
        return createPottedBlock(() -> new BYGFungusBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_FUNGUS), blockTagKey), id);
    }

    private static BlockRegistryObject<Block> createHydrangeaBush(String id, TagKey<Block> groundTag) {
        return createPottedBlock(() -> new HydrangeaBushBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.SWEET_BERRY_BUSH).strength(0.0f).noCollission().noOcclusion(), groundTag), id);
    }

    private static BlockRegistryObject<Block> createHydrangeaHedge(String id, TagKey<Block> groundTag) {
        return createBlock(() -> new HydrangeaHedgeBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.AZALEA).instabreak().noOcclusion(), groundTag), id);
    }

    private static BlockRegistryObject<Block> createFlower(String id, TagKey<Block> groundTag) {
        return createFlower(id, groundTag, true);
    }

    private static BlockRegistryObject<Block> createFlower(String id, TagKey<Block> groundTag, boolean potted) {
        Supplier<Block> block = () -> new BYGFlowerBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).strength(0.0f).noCollission().noOcclusion(), groundTag);

        if (potted) {
            return createPottedBlock(block, id);
        } else {
            return createBlock(block, id);
        }
    }

    private static BlockRegistryObject<Block> createTallFlower(MaterialColor color, String id, TagKey<Block> groundTag) {
        return createBlock(() -> new BYGTallFlowerBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT, color).sound(SoundType.GRASS).strength(0.0f).noCollission().noOcclusion(), groundTag), id);
    }

    private static BlockRegistryObject<Block> createStoneEndPlant(String id) {
        return createBlock(() -> new StoneEndPlantBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).strength(0.0f).noCollission().randomTicks().noOcclusion()), id);
    }

    private static BlockRegistryObject<Block> createTallBulbis(String id) {
        return createBlock(() -> new TallBulbisBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).sound(SoundType.SHROOMLIGHT).strength(0.0f).noCollission().noOcclusion()), id);
    }

    private static BlockRegistryObject<Block> createVent(String id) {
        return createBlock(() -> new VentBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(2.0f, 6.0f).requiresCorrectToolForDrops()), id);
    }

    private static BlockRegistryObject<Block> createTallVent(String id) {
        return createBlock(() -> new TallVentBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(2.0f, 6.0f).requiresCorrectToolForDrops()), id);
    }

    private static BlockRegistryObject<Block> createAmetrineCluster(String id) {
        return createBlock(() -> new AmethystClusterBlock(7, 3, BlockBehaviour.Properties.of(BYGMaterials.AMETRINE).sound(SoundType.GLASS).strength(1.5f).randomTicks().requiresCorrectToolForDrops().noCollission().lightLevel((state) -> 6)), id);
    }

    private static BlockRegistryObject<Block> createDullCrystal(String id, TagKey<EntityType<?>> noInjury) {
        return createBlock(() -> new CrystalBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(0.1f).noOcclusion().noCollission().requiresCorrectToolForDrops(), noInjury), id);
    }

    private static BlockRegistryObject<Block> createSculkGrowth(String id) {
        return createBlock(() -> new SculkGrowthBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT).sound(SoundType.TWISTING_VINES).instabreak().randomTicks().noOcclusion().noCollission()), id);
    }

    private static BlockRegistryObject<Block> createIvisBulbisPlant(String id) {
        return createBlock(() -> new IvisPlantBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT).sound(SoundType.TWISTING_VINES).instabreak().noOcclusion().noCollission()), id);
    }

    private static BlockRegistryObject<Block> createEtherPlant(String id) {
        return createBlock(() -> new EtherPlantBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT).sound(SoundType.GRASS).instabreak().noOcclusion().noCollission()), id);
    }

    private static BlockRegistryObject<DoublePlantBlock> createTallEtherPlant(String id) {
        return createBlock(() -> new TallEtherGrassBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).sound(SoundType.GRASS).instabreak().noOcclusion().noCollission()), id);
    }

    private static BlockRegistryObject<Block> createNightshadePlant(String id) {
        return createBlock(() -> new NightshadePlantBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT).sound(SoundType.TWISTING_VINES).instabreak().noOcclusion().noCollission()), id);
    }

    private static BlockRegistryObject<Block> createTallNightshadePlant(String id) {
        return createBlock(() -> new TallNightshadePlantBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).sound(SoundType.ROOTS).instabreak().noOcclusion().noCollission()), id);
    }

    private static BlockRegistryObject<Block> createSculkPlant(String id) {
        return createBlock(() -> new SculkPlantBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT).sound(SoundType.TWISTING_VINES).instabreak().noOcclusion().noCollission()), id);
    }

    private static BlockRegistryObject<Block> createImpariusPlant(String id) {
        return createBlock(() -> new ImpariusPlantBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT).sound(SoundType.TWISTING_VINES).instabreak().noOcclusion().noCollission()), id);
    }

    private static BlockRegistryObject<Block> createOddityDesertPlant(String id) {
        return createBlock(() -> new DesertOddityPlantBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT).sound(SoundType.TWISTING_VINES).instabreak().noOcclusion().noCollission()), id);
    }

    private static BlockRegistryObject<Block> createWarpedCactus(String id) {
        return createBlock(() -> new WarpedCactusBlock(BlockBehaviour.Properties.of(Material.CACTUS).sound(SoundType.WOOL).strength(0.2f).randomTicks().noOcclusion().lightLevel((state) -> 8)), id);
    }

    private static BlockRegistryObject<Block> createOddityCactus(String id) {
        return createBlock(() -> new OddityCactusBlock(BlockBehaviour.Properties.of(Material.CACTUS).sound(SoundType.WOOL).strength(0.2f).randomTicks().noOcclusion().lightLevel((state) -> 8)), id);
    }

    private static BlockRegistryObject<Block> createCrimsonBerryBush(String id) {
        return createBlock(() -> new CrimsonBerryBushBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.SWEET_BERRY_BUSH).randomTicks().instabreak().noCollission()), id);
    }

    private static BlockRegistryObject<Block> createBlueBerryBush(String id) {
        return createBlock(() -> new BlueBerryBush(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.SWEET_BERRY_BUSH).randomTicks().instabreak().noCollission()), id);
    }

    private static BlockRegistryObject<Block> createBaobabFruitBlock(String id) {
        return createBlock(() -> new BaobabFruitBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.SWEET_BERRY_BUSH).randomTicks().instabreak().noCollission()), id);
    }

    private static BlockRegistryObject<Block> createAppleFruitBlock(String id) {
        return createBlock(() -> new AppleFruitBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.SWEET_BERRY_BUSH).randomTicks().instabreak().noCollission()), id);
    }

    private static BlockRegistryObject<Block> createGreenAppleFruitBlock(String id) {
        return createBlock(() -> new GreenAppleFruitBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.SWEET_BERRY_BUSH).randomTicks().instabreak().noCollission()), id);
    }

    private static BlockRegistryObject<Block> createJoshuaFruitBlock(String id) {
        return createBlock(() -> new JoshuaFruitBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.SWEET_BERRY_BUSH).randomTicks().instabreak().noCollission()), id);
    }

    private static BlockRegistryObject<Block> createEtherBulbBlock(String id) {
        return createBlock(() -> new EtherBulbsBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.SWEET_BERRY_BUSH).randomTicks().instabreak().lightLevel((state) -> state.getValue(EtherBulbsBlock.AGE) >= 2 ? 15 : 4).noCollission()), id);
    }

    private static BlockRegistryObject<Block> createNightshadeBerryBush(String id) {
        return createNightshadeBerryBush(5, id);
    }

    private static BlockRegistryObject<Block> createNightshadeBerryBush(int lightLevel, String id) {
        return createBlock(() -> new NightshadeBerryBushBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.SWEET_BERRY_BUSH).lightLevel((state) -> lightLevel).randomTicks().instabreak().noCollission()), id);
    }

    static BlockRegistryObject<Block> createSapling(TagKey<Block> groundTag, String id) {
        final Supplier<Block> createBlock = () -> new BYGSaplingBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).strength(0.0f).noCollission().randomTicks(), groundTag);
        final var blockRo = createPottedBlock(createBlock, id);
        return blockRo;
    }

    private static BlockRegistryObject<Block> createShrub(TreeSpawner tree, String id) {
        return createPottedBlock(() -> new ShrubBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).sound(SoundType.SWEET_BERRY_BUSH).noOcclusion().noCollission(), tree), id);
    }

    private static BlockRegistryObject<Block> createJacarandaBush(String id) {
        return createPottedBlock(() -> new JacarandaBushBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_PURPLE).sound(SoundType.SWEET_BERRY_BUSH).noOcclusion()), id);
    }

    private static BlockRegistryObject<Block> createFloweringJacarandaBush(int taskRange, TreeSpawner tree, String id) {
        return createPottedBlock(() -> new FloweringJacarandaBushBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_PURPLE).sound(SoundType.SWEET_BERRY_BUSH).noOcclusion(), tree, taskRange), id);
    }

    private static BlockRegistryObject<Block> createIndigoJacarandaBush(String id) {
        return createPottedBlock(() -> new IndigoJacarandaBushBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_BLUE).sound(SoundType.SWEET_BERRY_BUSH).noOcclusion()), id);
    }

    private static BlockRegistryObject<Block> createFloweringIndigoJacarandaBush(int taskRange, TreeSpawner tree, String id) {
        return createPottedBlock(() -> new FloweringJacarandaBushBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_BLUE).sound(SoundType.SWEET_BERRY_BUSH).noOcclusion(), tree, taskRange), id);
    }

    public static BlockRegistryObject<Block> createPottedBlock(Supplier<Block> blockForPot, String id) {
        final var b = createBlock(blockForPot, id);
        final BlockRegistryObject<Block> potted = createBlock(() -> BYGBlockFactory.INSTANCE.createPottedBlock(b, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), "potted_" + id);
        FLOWER_POT_BLOCKS.add(potted);
        return b;
    }

    private static BlockRegistryObject<Block> createShroomlight(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_PURPLE).strength(1.0F).sound(SoundType.SHROOMLIGHT).lightLevel((state) -> 14)), id);
    }

    private static BlockRegistryObject<Block> createImpariusVine(String id) {
        return createBlock(() -> new ImpariusVineBlock(BlockBehaviour.Properties.of(Material.LEAVES).instabreak().randomTicks().sound(SoundType.WEEPING_VINES).noCollission()), id);
    }

    private static BlockRegistryObject<Block> createImpariusVinePlant(String id) {
        return createBlock(() -> new ImpariusVinePlantBlock(BlockBehaviour.Properties.of(Material.LEAVES).instabreak().randomTicks().sound(SoundType.WEEPING_VINES).noCollission()), id);
    }

    private static BlockRegistryObject<Block> createImpariusMushroom(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_CYAN).strength(0.2F).sound(SoundType.TWISTING_VINES).speedFactor(0.5F).jumpFactor(0.5F)), id);
    }

    private static BlockRegistryObject<Block> createTreeBranchBlock(MaterialColor color, String id) {
        return createBlock(() -> new TreeBranchBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT, color).instabreak().sound(SoundType.WOOD).noOcclusion().noCollission()), id);
    }

    private static BlockRegistryObject<Block> createGlowingTreeBranchBlock(MaterialColor color, String id) {
        return createBlock(() -> new TreeBranchBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT, color).instabreak().sound(SoundType.TWISTING_VINES).noOcclusion().noCollission().lightLevel((state) -> 10)), id);
    }

    private static BlockRegistryObject<Block> createWitchHazelBlossomBlock(MaterialColor color, String id) {
        return createBlock(() -> new WitchHazelBlossomBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT, color).instabreak().sound(SoundType.TWISTING_VINES).noOcclusion().noCollission().lightLevel((state) -> 10)), id);
    }

    private static BlockRegistryObject<Block> createFungalImpariusFilamentBlock(String id) {
        return createBlock(() -> new SlimeBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_LIGHT_BLUE).strength(0.2F).sound(SoundType.HONEY_BLOCK).speedFactor(0.5F).jumpFactor(2.5F).lightLevel((state) -> 15)), id);
    }

    private static BlockRegistryObject<Block> createFungalImpariusFilament(String id) {
        return createBlock(() -> new FungalImpariusFilamentBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_LIGHT_BLUE).instabreak().sound(SoundType.HONEY_BLOCK).noOcclusion().noCollission().lightLevel((state) -> 10)), id);
    }

    private static BlockRegistryObject<Block> createFungalImparius(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.WARPED_WART_BLOCK).strength(0.2F).sound(SoundType.HONEY_BLOCK)), id);
    }

    private static BlockRegistryObject<Block> createShulkrenVine(String id) {
        return createBlock(() -> new ShulkrenVineBlock(BlockBehaviour.Properties.of(Material.LEAVES).instabreak().randomTicks().sound(SoundType.WEEPING_VINES).noCollission()), id);
    }

    private static BlockRegistryObject<Block> createShulkrenVinePlant(String id) {
        return createBlock(() -> new ShulkrenVinePlantBlock(BlockBehaviour.Properties.of(Material.LEAVES).instabreak().randomTicks().sound(SoundType.WEEPING_VINES).noCollission()), id);
    }

    static BlockRegistryObject<Block> createLeaves(MaterialColor color, String id) {
        return createBlock(() -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, color).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isViewBlocking((state, world, pos) -> false).isSuffocating((state, world, pos) -> false)), id);
    }

    static BlockRegistryObject<Block> createChangingLeaves(MaterialColor color, Supplier<LeavesBlock> next, float chance, String id) {
        return createBlock(() -> new ChangingLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, color).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isViewBlocking((state, world, pos) -> false).isSuffocating((state, world, pos) -> false), next, chance), id);
    }

    static BlockRegistryObject<Block> createGlowingLeaves(MaterialColor color, int lightLevel, String id) {
        return createBlock(() -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, color).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isViewBlocking((state, world, pos) -> false).isSuffocating((state, world, pos) -> false).lightLevel((state) -> lightLevel)), id);
    }

    static BlockRegistryObject<Block> createFruitLeaves(MaterialColor color, Supplier<BlockState> fruit, String id, float tickSpawnChance) {
        return createBlock(() -> new HangingFruitLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, color).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isViewBlocking((state, world, pos) -> false).isSuffocating((state, world, pos) -> false), fruit, tickSpawnChance), id);
    }

    private static BlockRegistryObject<Block> createFirecrackerLeavesBlock(MaterialColor color, String id) {
        return createBlock(() -> new FirecrackerLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, color).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isViewBlocking((state, world, pos) -> false).isSuffocating((state, world, pos) -> false)), id);
    }

    private static BlockRegistryObject<Block> createFloweringPaloVerdeLeaves(MaterialColor color, String id) {
        return createBlock(() -> new FloweringPaloVerdeLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, color).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isViewBlocking((state, world, pos) -> false).isSuffocating((state, world, pos) -> false)), id);
    }

    private static BlockRegistryObject<Block> createPetal(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.GRASS).sound(SoundType.GRASS).strength(0.2f).noOcclusion()), id);
    }

    private static BlockRegistryObject<Block> createDirt(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.DIRT).sound(SoundType.GRAVEL).strength(0.2f).randomTicks()), id);
    }

    private static BlockRegistryObject<Block> createLushFarmland(String id) {
        return createBlock(() -> new LushFarmBlock(BlockBehaviour.Properties.copy(Blocks.FARMLAND).strength(0.2f)), id);
    }

    private static BlockRegistryObject<Block> createDirtSpreadable(Supplier<? extends Block> blockToSpreadToo, MaterialColor color, String id) {
        return createBlock(() -> new BYGGrassBlock(BlockBehaviour.Properties.of(Material.DIRT, color).sound(SoundType.GRASS).strength(0.4f).randomTicks(), blockToSpreadToo.get()), id);
    }

    private static BlockRegistryObject<Block> createStoneSpreadable(Supplier<? extends Block> blockToSpreadToo, MaterialColor color, String id) {
        return createBlock(() -> new BYGGrassBlock(BlockBehaviour.Properties.of(Material.STONE, color).sound(SoundType.STONE).strength(1.5f, 6.0f).randomTicks().requiresCorrectToolForDrops(), blockToSpreadToo.get()), id);
    }

    private static BlockRegistryObject<Block> createEndStoneSpreadable(Supplier<? extends Block> blockToSpreadToo, MaterialColor color, Supplier<ConfiguredFeature<?, ?>> feature, String id) {
        return createBlock(() -> new BYGNylium(BlockBehaviour.Properties.of(Material.STONE, color).sound(SoundType.STONE).strength(0.4f).randomTicks().requiresCorrectToolForDrops(), feature, blockToSpreadToo.get()), id);
    }

    private static BlockRegistryObject<Block> createEndDirtSpreadable(Supplier<? extends Block> blockToSpreadToo, MaterialColor color, Supplier<ConfiguredFeature<?, ?>> feature, String id) {
        return createBlock(() -> new BYGNylium(BlockBehaviour.Properties.of(Material.STONE, color).sound(SoundType.NYLIUM).strength(0.4f).randomTicks().requiresCorrectToolForDrops(), feature, blockToSpreadToo.get()), id);
    }

    private static BlockRegistryObject<Block> createNetherSpreadable(Supplier<? extends Block> blockToSpreadToo, MaterialColor color, Supplier<ConfiguredFeature<?, ?>> feature, String id) {
        return createBlock(() -> new BYGNylium(BlockBehaviour.Properties.of(Material.STONE, color).sound(SoundType.NYLIUM).strength(0.4F).randomTicks().requiresCorrectToolForDrops(), feature, blockToSpreadToo.get()), id);
    }

    private static BlockRegistryObject<Block> createNetherStoneSpreadable(Block blockToSpreadToo, MaterialColor color, Supplier<ConfiguredFeature<?, ?>> feature, String id) {
        return createBlock(() -> new BYGNylium(BlockBehaviour.Properties.of(Material.STONE, color).sound(SoundType.NYLIUM).strength(0.4f).randomTicks().requiresCorrectToolForDrops(), feature, blockToSpreadToo), id);
    }

    static BlockRegistryObject<Block> createSign(String id, WoodType type, BlockRegistryObject<Block> color) {
        return createSign(id, type, () -> color.get().defaultMaterialColor());
    }

    private static BlockRegistryObject<Block> createSign(String id, WoodType type, Supplier<? extends MaterialColor> color) {
        BlockRegistryObject<Block> signBlock = BYGConstants.SIGNS ? createBlock(() -> new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).color(color.get()), type), id) : null;
        if (signBlock != null) {
            SIGN_BLOCKS.add(signBlock);
        }
        return signBlock;
    }

    static BlockRegistryObject<Block> createWallSign(String id, WoodType type, BlockRegistryObject<Block> color) {
        return createWallSign(id, type, () -> color.get().defaultMaterialColor());
    }

    private static BlockRegistryObject<Block> createWallSign(String id, WoodType type, Supplier<? extends MaterialColor> color) {
        BlockRegistryObject<Block> signBlock = BYGConstants.SIGNS ? createBlock(() -> new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).color(color.get()), type), id) : null;
        if (signBlock != null) {
            SIGN_BLOCKS.add(signBlock);
        }
        return signBlock;
    }

    public static <B extends Block> BlockRegistryObject<B> createBlock(Supplier<? extends B> block, String id) {
        final var ro = PROVIDER.<B>register(id, block);
        return BlockRegistryObject.wrap(ro);
    }

    private static Boolean neverAllowSpawn(BlockState state, BlockGetter reader, BlockPos pos, EntityType<?> entity) {
        return false;
    }

    private static boolean isntSolid(BlockState state, BlockGetter reader, BlockPos pos) {
        return false;
    }

    private static ToIntFunction<BlockState> litBlockEmission(int light) {
        return (state) -> {
            return state.getValue(BlockStateProperties.LIT) ? light : 0;
        };
    }

    public static void loadClass() {
    }
}
