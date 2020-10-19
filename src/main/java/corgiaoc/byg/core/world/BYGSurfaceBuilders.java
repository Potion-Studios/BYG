package corgiaoc.byg.core.world;

import corgiaoc.byg.common.world.biome.overworld.IceburgOcean;
import corgiaoc.byg.common.world.surfacebuilder.*;
import corgiaoc.byg.common.world.surfacebuilder.config.FillSurfaceBuilderConfig;
import corgiaoc.byg.common.world.surfacebuilder.config.PointedSBConfig;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class BYGSurfaceBuilders {
    public static final SurfaceBuilder<SurfaceBuilderConfig> BOREAL = WorldGenRegistrationHelper.createSurfaceBuilder("boreal", new BorealForestSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> BASALT_BARRERA = WorldGenRegistrationHelper.createSurfaceBuilder("basalt_barrera", new BasaltBarreraSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> CONIFEROUS = WorldGenRegistrationHelper.createSurfaceBuilder("coniferous", new ConiferousForestSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> SHATTERED_GLACIER = WorldGenRegistrationHelper.createSurfaceBuilder("shattered_glacier", new ShatteredGlacierSB2(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> MARSHLAND = WorldGenRegistrationHelper.createSurfaceBuilder("marshland", new MarshlandSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> GREAT_LAKES = WorldGenRegistrationHelper.createSurfaceBuilder("great_lakes", new GreatLakeSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> GREAT_LAKE_ISLES = WorldGenRegistrationHelper.createSurfaceBuilder("great_lakes_isles", new GreatLakeIsleSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> ERODED_SIERRA = WorldGenRegistrationHelper.createSurfaceBuilder("eroded_sierra", new ErodedSierraSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> SIERRA_VALLEY = WorldGenRegistrationHelper.createSurfaceBuilder("sierra_valley", new SierraValleySB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> GLOWSHROOM_BAYOU = WorldGenRegistrationHelper.createSurfaceBuilder("glowshroom_bayou", new GlowShroomBayouSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> CRAG_GARDENS = WorldGenRegistrationHelper.createSurfaceBuilder("crag_gardens", new CragGardensSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> RED_ROCK_SB = WorldGenRegistrationHelper.createSurfaceBuilder("red_rock", new RedRockSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> RED_ROCK_LOWLANDS = WorldGenRegistrationHelper.createSurfaceBuilder("red_rock_lowlands", new RedRockLowlandsSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> RED_DUNES = WorldGenRegistrationHelper.createSurfaceBuilder("red_dunes", new RedDunesSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> DUNES = WorldGenRegistrationHelper.createSurfaceBuilder("dunes", new DunesSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> ETHEREAL = WorldGenRegistrationHelper.createSurfaceBuilder("ethereal", new FillEtherealStone(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> DOVER = WorldGenRegistrationHelper.createSurfaceBuilder("dover_mountains", new DoverMountainSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> QUAGMIRE = WorldGenRegistrationHelper.createSurfaceBuilder("quagmire", new QuagmireSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> CANYONS = WorldGenRegistrationHelper.createSurfaceBuilder("canyons", new CanyonSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> CANYON_EDGE = WorldGenRegistrationHelper.createSurfaceBuilder("canyon_edge", new CanyonEdgeSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> MOJAVE = WorldGenRegistrationHelper.createSurfaceBuilder("mojave", new MojaveSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> LUSH_TUNDRA = WorldGenRegistrationHelper.createSurfaceBuilder("lush_tundra", new LushTundraSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> FUNGAL_RAINFOREST = WorldGenRegistrationHelper.createSurfaceBuilder("fungal_rainforest", new FungalRainforestSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> EBONY = WorldGenRegistrationHelper.createSurfaceBuilder("ebony_woods", new EbonyWoodsSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> GLOWING_ANCIENT_FOREST = WorldGenRegistrationHelper.createSurfaceBuilder("glowing_ancient_forest", new GlowingAncientForestSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> EMBUR_BOG = WorldGenRegistrationHelper.createSurfaceBuilder("embur_bog", new EmburBogSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> ROCKY_BLACK_BEACH = WorldGenRegistrationHelper.createSurfaceBuilder("rocky_black_beach", new RockyBlackBeachSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> RAINBOW_BEACH = WorldGenRegistrationHelper.createSurfaceBuilder("rainbow_beach", new RainbowBeachSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> ROCKY_BEACH = WorldGenRegistrationHelper.createSurfaceBuilder("rocky_beach", new RockyBeachSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> WARPED_DESERT = WorldGenRegistrationHelper.createSurfaceBuilder("warped_desert", new WarpedDesertSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> WAILING_GARTH = WorldGenRegistrationHelper.createSurfaceBuilder("wailing_garth", new WailingGarthSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> STONE_FOREST = WorldGenRegistrationHelper.createSurfaceBuilder("stone_forest", new StoneForestSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<PointedSBConfig> POINTED = WorldGenRegistrationHelper.createSurfaceBuilder("pointed_stone_forest", new PointedSB(PointedSBConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> CRIMSON_GARDENS = WorldGenRegistrationHelper.createSurfaceBuilder("crimson_gardens", new CrimsonGardenSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> GLOWSTONE_GARDENS = WorldGenRegistrationHelper.createSurfaceBuilder("glowstone_gardens", new GlowstoneGardensSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> TWILIGHT_VALLEY = WorldGenRegistrationHelper.createSurfaceBuilder("twilight_valley", new TwilightValleySB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> ERODED_LUNA = WorldGenRegistrationHelper.createSurfaceBuilder("eroded_luna", new ErodedLunaSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<FillSurfaceBuilderConfig> FILL = WorldGenRegistrationHelper.createSurfaceBuilder("fill", new FillerSurfaceBuilder(FillSurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> BRIMSTONE_CAVERNS = WorldGenRegistrationHelper.createSurfaceBuilder("brimstone_caverns", new BrimstoneCavernsSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> MAGMA_WASTES = WorldGenRegistrationHelper.createSurfaceBuilder("magma_wastes", new MagmaWastesSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> SUBZERO_HYPOGEAL = WorldGenRegistrationHelper.createSurfaceBuilder("subzero_hypogeal", new SubzeroHypogealSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> WITHERING_WOODS = WorldGenRegistrationHelper.createSurfaceBuilder("withering_woods", new WitheringWoodsSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> QUARTZ_DESERT = WorldGenRegistrationHelper.createSurfaceBuilder("quartz_desert", new QuartzDesertSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> WEEPING_MIRE = WorldGenRegistrationHelper.createSurfaceBuilder("weeping_mire", new WeepingMireSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> ICEBURG_OCEAN = WorldGenRegistrationHelper.createSurfaceBuilder("iceburg_ocean", new IceburgOceanSB(SurfaceBuilderConfig.field_237203_a_));

    //End
    public static final SurfaceBuilder<SurfaceBuilderConfig> IVIS_FIELDS = WorldGenRegistrationHelper.createSurfaceBuilder("ivis_fields", new IvisFieldsSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> SHATTERED_DESERT = WorldGenRegistrationHelper.createSurfaceBuilder("shattered_desert", new ShatteredDesertSB(SurfaceBuilderConfig.field_237203_a_));


    public static void init() {
    }

    public static class Configs {
        public static final SurfaceBuilderConfig ICE = new SurfaceBuilderConfig(Blocks.ICE.getDefaultState(), Blocks.ICE.getDefaultState(), Blocks.ICE.getDefaultState());
        public static final SurfaceBuilderConfig SANDSTONE = new SurfaceBuilderConfig(Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState());
        public static final SurfaceBuilderConfig WATER = new SurfaceBuilderConfig(Blocks.WATER.getDefaultState(), Blocks.WATER.getDefaultState(), Blocks.WATER.getDefaultState());
        public static final SurfaceBuilderConfig BLACK_SAND = new SurfaceBuilderConfig(BYGBlocks.BLACK_SAND.getDefaultState(), BYGBlocks.BLACK_SAND.getDefaultState(), BYGBlocks.BLACK_SANDSTONE.getDefaultState());
        public static final SurfaceBuilderConfig ROCKY_BLACK_SAND = new SurfaceBuilderConfig(BYGBlocks.ROCKY_STONE.getDefaultState(), BYGBlocks.BLACK_SAND.getDefaultState(), BYGBlocks.BLACK_SANDSTONE.getDefaultState());
        public static final SurfaceBuilderConfig ROCKY_BLACK_SAND2 = new SurfaceBuilderConfig(BYGBlocks.BLACK_SAND.getDefaultState(), BYGBlocks.ROCKY_STONE.getDefaultState(), BYGBlocks.BLACK_SANDSTONE.getDefaultState());
        public static final SurfaceBuilderConfig STONE_BLACK_SAND = new SurfaceBuilderConfig(BYGBlocks.BLACK_SAND.getDefaultState(), Blocks.STONE.getDefaultState(), BYGBlocks.BLACK_SANDSTONE.getDefaultState());
        public static final SurfaceBuilderConfig STONE_BLACK_SAND2 = new SurfaceBuilderConfig(Blocks.STONE.getDefaultState(), BYGBlocks.BLACK_SAND.getDefaultState(), BYGBlocks.BLACK_SANDSTONE.getDefaultState());
        public static final SurfaceBuilderConfig BLUE_SAND = new SurfaceBuilderConfig(BYGBlocks.BLUE_SAND.getDefaultState(), BYGBlocks.BLUE_SAND.getDefaultState(), BYGBlocks.BLUE_SANDSTONE.getDefaultState());
        public static final SurfaceBuilderConfig PINK_SAND = new SurfaceBuilderConfig(BYGBlocks.PINK_SAND.getDefaultState(), BYGBlocks.PINK_SAND.getDefaultState(), BYGBlocks.PINK_SANDSTONE.getDefaultState());
        public static final SurfaceBuilderConfig PURPLE_SAND = new SurfaceBuilderConfig(BYGBlocks.PURPLE_SAND.getDefaultState(), BYGBlocks.PURPLE_SAND.getDefaultState(), BYGBlocks.PURPLE_SANDSTONE.getDefaultState());
        public static final SurfaceBuilderConfig WHITE_SAND = new SurfaceBuilderConfig(BYGBlocks.WHITE_SAND.getDefaultState(), BYGBlocks.WHITE_SAND.getDefaultState(), BYGBlocks.WHITE_SANDSTONE.getDefaultState());
        public static final SurfaceBuilderConfig SAND = new SurfaceBuilderConfig(Blocks.SAND.getDefaultState(), Blocks.SAND.getDefaultState(), Blocks.SANDSTONE.getDefaultState());
        public static final SurfaceBuilderConfig ROCKY = new SurfaceBuilderConfig(BYGBlocks.ROCKY_STONE.getDefaultState(), BYGBlocks.ROCKY_STONE.getDefaultState(), BYGBlocks.ROCKY_STONE.getDefaultState());
        public static final SurfaceBuilderConfig STONE = new SurfaceBuilderConfig(Blocks.STONE.getDefaultState(), Blocks.STONE.getDefaultState(), Blocks.STONE.getDefaultState());
        public static final SurfaceBuilderConfig COARSE = new SurfaceBuilderConfig(Blocks.COARSE_DIRT.getDefaultState(), Blocks.COARSE_DIRT.getDefaultState(), Blocks.COARSE_DIRT.getDefaultState());
        public static final SurfaceBuilderConfig GLOWSTONE_GARDENS = new SurfaceBuilderConfig(BYGBlocks.OVERGROWN_NETHERRACK.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), Blocks.NETHERRACK.getDefaultState());
        public static final SurfaceBuilderConfig CRIMSON_GARDEN = new SurfaceBuilderConfig(BYGBlocks.OVERGROWN_CRIMSON_BLACKSTONE.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), Blocks.NETHER_WART_BLOCK.getDefaultState());
        public static final SurfaceBuilderConfig MYCELIUM_NETHERRACK = new SurfaceBuilderConfig(BYGBlocks.MYCELIUM_NETHERRACK.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), Blocks.NETHERRACK.getDefaultState());
        public static final SurfaceBuilderConfig WARPED_NYLIUM = new SurfaceBuilderConfig(Blocks.WARPED_NYLIUM.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), Blocks.NETHERRACK.getDefaultState());

        public static final SurfaceBuilderConfig SAND_CF = new SurfaceBuilderConfig(Blocks.SAND.getDefaultState(), Blocks.SAND.getDefaultState(), Blocks.SAND.getDefaultState());
        public static final SurfaceBuilderConfig REDSAND_CF = new SurfaceBuilderConfig(Blocks.RED_SAND.getDefaultState(), Blocks.RED_SAND.getDefaultState(), Blocks.RED_SAND.getDefaultState());
        public static final SurfaceBuilderConfig WARPEDDESERT = new SurfaceBuilderConfig(BYGBlocks.NYLIUM_SOUL_SAND.getDefaultState(), BYGBlocks.NYLIUM_SOUL_SAND.getDefaultState(), BYGBlocks.NYLIUM_SOUL_SAND.getDefaultState());
        public static final SurfaceBuilderConfig SYTHIANTORRIDS = new SurfaceBuilderConfig(BYGBlocks.SYTHIAN_NYLIUM.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), Blocks.NETHERRACK.getDefaultState());
        public static final SurfaceBuilderConfig WARPEDDESERT_SOIL = new SurfaceBuilderConfig(BYGBlocks.NYLIUM_SOUL_SOIL.getDefaultState(), BYGBlocks.NYLIUM_SOUL_SOIL.getDefaultState(), BYGBlocks.NYLIUM_SOUL_SOIL.getDefaultState());
        public static final SurfaceBuilderConfig EMBURNYLIUM = new SurfaceBuilderConfig(BYGBlocks.EMBUR_NYLIUM.getDefaultState(), BYGBlocks.BLUE_NETHERRACK.getDefaultState(), BYGBlocks.BLUE_NETHERRACK.getDefaultState());
        public static final SurfaceBuilderConfig SOULSAND = new SurfaceBuilderConfig(Blocks.SOUL_SAND.getDefaultState(), Blocks.SOUL_SAND.getDefaultState(), Blocks.NETHERRACK.getDefaultState());
        public static final SurfaceBuilderConfig SOUL_SOIL = new SurfaceBuilderConfig(Blocks.SOUL_SOIL.getDefaultState(), Blocks.SOUL_SOIL.getDefaultState(), Blocks.NETHERRACK.getDefaultState());
        public static final SurfaceBuilderConfig MAGMATIC_STONE = new SurfaceBuilderConfig(BYGBlocks.MAGMATIC_STONE.getDefaultState(), BYGBlocks.MAGMATIC_STONE.getDefaultState(), BYGBlocks.MAGMATIC_STONE.getDefaultState());
        public static final SurfaceBuilderConfig MAGMA_BLOCK = new SurfaceBuilderConfig(Blocks.MAGMA_BLOCK.getDefaultState(), Blocks.MAGMA_BLOCK.getDefaultState(), Blocks.MAGMA_BLOCK.getDefaultState());
        public static final SurfaceBuilderConfig BRIMSTONE = new SurfaceBuilderConfig(BYGBlocks.BRIMSTONE.getDefaultState(), BYGBlocks.BRIMSTONE.getDefaultState(), BYGBlocks.BRIMSTONE.getDefaultState());
        public static final SurfaceBuilderConfig FROST_MAGMA = new SurfaceBuilderConfig(BYGBlocks.FROST_MAGMA.getDefaultState(), BYGBlocks.FROST_MAGMA.getDefaultState(), BYGBlocks.FROST_MAGMA.getDefaultState());
        public static final SurfaceBuilderConfig SUBZERO_ASH = new SurfaceBuilderConfig(BYGBlocks.SUBZERO_ASH_BLOCK.getDefaultState(), BYGBlocks.SUBZERO_ASH_BLOCK.getDefaultState(), BYGBlocks.SUBZERO_ASH_BLOCK.getDefaultState());


        public static final SurfaceBuilderConfig PODZOLDOVERMOUNTAIN_CF = new SurfaceBuilderConfig(BYGBlocks.OVERGROWN_DACITE.getDefaultState(), BYGBlocks.DACITE.getDefaultState(), BYGBlocks.DACITE.getDefaultState());
        public static final SurfaceBuilderConfig COARSEDIRTDOVERMOUNTAIN_CF = new SurfaceBuilderConfig(Blocks.COARSE_DIRT.getDefaultState(), BYGBlocks.DACITE.getDefaultState(), BYGBlocks.DACITE.getDefaultState());
        public static final SurfaceBuilderConfig GRASSDOVERMOUNTAIN_CF = new SurfaceBuilderConfig(BYGBlocks.PODZOL_DACITE.getDefaultState(), BYGBlocks.DACITE.getDefaultState(), BYGBlocks.DACITE.getDefaultState());

        public static final SurfaceBuilderConfig AIR_CF = new SurfaceBuilderConfig(Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState());

        public static final SurfaceBuilderConfig QUAGMIREPEAT_SB = new SurfaceBuilderConfig(BYGBlocks.PEAT.getDefaultState(), BYGBlocks.MUD_BLOCK.getDefaultState(), BYGBlocks.MUD_BLOCK.getDefaultState());
        public static final SurfaceBuilderConfig QUAGMIREMUD_CF = new SurfaceBuilderConfig(BYGBlocks.MUD_BLOCK.getDefaultState(), BYGBlocks.MUD_BRICKS.getDefaultState(), BYGBlocks.MUD_BLOCK.getDefaultState());
        public static final SurfaceBuilderConfig GRASSMOUNTAIN_CF = new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.STONE.getDefaultState(), Blocks.STONE.getDefaultState());
        public static final SurfaceBuilderConfig PEATGRASS_CF = new SurfaceBuilderConfig(BYGBlocks.PEAT.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState());
        public static final SurfaceBuilderConfig MUD_CF = new SurfaceBuilderConfig(BYGBlocks.MUD_BLOCK.getDefaultState(), BYGBlocks.MUD_BLOCK.getDefaultState(), BYGBlocks.MUD_BLOCK.getDefaultState());
        public static final SurfaceBuilderConfig TERRACOTTA_CF = new SurfaceBuilderConfig(Blocks.TERRACOTTA.getDefaultState(), Blocks.TERRACOTTA.getDefaultState(), Blocks.TERRACOTTA.getDefaultState());
        public static final SurfaceBuilderConfig GLOWCELIUM_CF = new SurfaceBuilderConfig(BYGBlocks.GLOWCELIUM.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState());

        public static final SurfaceBuilderConfig GREEN_CONCRETE_POWDER_CF = new SurfaceBuilderConfig(BYGBlocks.OVERGROWN_STONE.getDefaultState(), BYGBlocks.MOSSY_STONE.getDefaultState(), Blocks.STONE.getDefaultState());

        public static final SurfaceBuilderConfig RED_ROCK_CF = new SurfaceBuilderConfig(BYGBlocks.RED_ROCK.getDefaultState(), BYGBlocks.RED_ROCK.getDefaultState(), BYGBlocks.RED_ROCK.getDefaultState());

        public static final SurfaceBuilderConfig IVIS_CF = new SurfaceBuilderConfig(BYGBlocks.IVIS_PHYLIUM.getDefaultState(), Blocks.END_STONE.getDefaultState(), Blocks.END_STONE.getDefaultState());
        public static final SurfaceBuilderConfig END = new SurfaceBuilderConfig(Blocks.END_STONE.getDefaultState(), Blocks.END_STONE.getDefaultState(), Blocks.END_STONE.getDefaultState());
        public static final SurfaceBuilderConfig MYCELIUM = new SurfaceBuilderConfig(Blocks.MYCELIUM.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState());
        public static final SurfaceBuilderConfig ETHER = new SurfaceBuilderConfig(BYGBlocks.ETHER_PHYLIUM.getDefaultState(), BYGBlocks.ETHER_SOIL.getDefaultState(), BYGBlocks.ETHER_STONE.getDefaultState());
        public static final SurfaceBuilderConfig NIGHTSHADE = new SurfaceBuilderConfig(BYGBlocks.NIGHTSHADE_PHYLIUM.getDefaultState(), Blocks.END_STONE.getDefaultState(), Blocks.END_STONE.getDefaultState());
        public static final SurfaceBuilderConfig SCULK = new SurfaceBuilderConfig(BYGBlocks.VERMILION_SCULK.getDefaultState(), BYGBlocks.ETHER_STONE.getDefaultState(), BYGBlocks.ETHER_STONE.getDefaultState());


        public static final SurfaceBuilderConfig SNOW_CF = new SurfaceBuilderConfig(Blocks.SNOW_BLOCK.getDefaultState(), Blocks.SNOW_BLOCK.getDefaultState(), Blocks.SNOW_BLOCK.getDefaultState());
        public static final SurfaceBuilderConfig PACKED_ICE_CF = new SurfaceBuilderConfig(Blocks.PACKED_ICE.getDefaultState(), Blocks.PACKED_ICE.getDefaultState(), Blocks.PACKED_ICE.getDefaultState());
        public static final SurfaceBuilderConfig BLUE_ICE_CF = new SurfaceBuilderConfig(Blocks.BLUE_ICE.getDefaultState(), Blocks.BLUE_ICE.getDefaultState(), Blocks.BLUE_ICE.getDefaultState());

    }
}
