package corgiaoc.byg.core.world;

import corgiaoc.byg.common.world.surfacebuilder.*;
import corgiaoc.byg.common.world.surfacebuilder.config.FillSurfaceBuilderConfig;
import corgiaoc.byg.common.world.surfacebuilder.config.PointedSBConfig;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import java.util.ArrayList;
import java.util.List;

public class BYGSurfaceBuilders {
    public static List<SurfaceBuilder<?>> surfaceBuilders = new ArrayList<>();

    public static final SurfaceBuilder<TernarySurfaceConfig> BOREAL = WorldGenRegistrationHelper.createSurfaceBuilder("boreal", new BorealForestSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> BASALT_BARRERA = WorldGenRegistrationHelper.createSurfaceBuilder("basalt_barrera", new BasaltBarreraSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> CONIFEROUS = WorldGenRegistrationHelper.createSurfaceBuilder("coniferous", new ConiferousForestSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> SHATTERED_GLACIER = WorldGenRegistrationHelper.createSurfaceBuilder("shattered_glacier", new ShatteredGlacierSB2(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> MARSHLAND = WorldGenRegistrationHelper.createSurfaceBuilder("marshland", new MarshlandSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> VOLCANIC_FIELDS = WorldGenRegistrationHelper.createSurfaceBuilder("volcanic_wastes", new VolcanicWastes(TernarySurfaceConfig.CODEC));


    public static final SurfaceBuilder<TernarySurfaceConfig> GREAT_LAKES = WorldGenRegistrationHelper.createSurfaceBuilder("great_lakes", new GreatLakeSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> GREAT_LAKE_ISLES = WorldGenRegistrationHelper.createSurfaceBuilder("great_lakes_isles", new GreatLakeIsleSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> ERODED_SIERRA = WorldGenRegistrationHelper.createSurfaceBuilder("eroded_sierra", new ErodedSierraSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> SIERRA_VALLEY = WorldGenRegistrationHelper.createSurfaceBuilder("sierra_valley", new SierraValleySB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> GLOWSHROOM_BAYOU = WorldGenRegistrationHelper.createSurfaceBuilder("glowshroom_bayou", new GlowShroomBayouSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> CRAG_GARDENS = WorldGenRegistrationHelper.createSurfaceBuilder("crag_gardens", new CragGardensSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> RED_ROCK_SB = WorldGenRegistrationHelper.createSurfaceBuilder("red_rock", new RedRockSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> RED_ROCK_LOWLANDS = WorldGenRegistrationHelper.createSurfaceBuilder("red_rock_lowlands", new RedRockLowlandsSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> RED_DUNES = WorldGenRegistrationHelper.createSurfaceBuilder("red_dunes", new RedDunesSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> DUNES = WorldGenRegistrationHelper.createSurfaceBuilder("dunes", new DunesSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> DOVER = WorldGenRegistrationHelper.createSurfaceBuilder("dover_mountains", new DoverMountainSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> CANYONS = WorldGenRegistrationHelper.createSurfaceBuilder("canyons", new CanyonSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> CANYON_EDGE = WorldGenRegistrationHelper.createSurfaceBuilder("canyon_edge", new CanyonEdgeSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> MOJAVE = WorldGenRegistrationHelper.createSurfaceBuilder("mojave", new MojaveSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> LUSH_TUNDRA = WorldGenRegistrationHelper.createSurfaceBuilder("lush_tundra", new LushTundraSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> FUNGAL_RAINFOREST = WorldGenRegistrationHelper.createSurfaceBuilder("fungal_rainforest", new FungalRainforestSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> EBONY = WorldGenRegistrationHelper.createSurfaceBuilder("ebony_woods", new EbonyWoodsSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> GLOWING_ANCIENT_FOREST = WorldGenRegistrationHelper.createSurfaceBuilder("glowing_ancient_forest", new GlowingAncientForestSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> EMBUR_BOG = WorldGenRegistrationHelper.createSurfaceBuilder("embur_bog", new EmburBogSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> ROCKY_BLACK_BEACH = WorldGenRegistrationHelper.createSurfaceBuilder("rocky_black_beach", new RockyBlackBeachSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> RAINBOW_BEACH = WorldGenRegistrationHelper.createSurfaceBuilder("rainbow_beach", new RainbowBeachSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> ROCKY_BEACH = WorldGenRegistrationHelper.createSurfaceBuilder("rocky_beach", new RockyBeachSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> WARPED_DESERT = WorldGenRegistrationHelper.createSurfaceBuilder("warped_desert", new WarpedDesertSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> WAILING_GARTH = WorldGenRegistrationHelper.createSurfaceBuilder("wailing_garth", new WailingGarthSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> STONE_FOREST = WorldGenRegistrationHelper.createSurfaceBuilder("stone_forest", new StoneForestSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<PointedSBConfig> POINTED = WorldGenRegistrationHelper.createSurfaceBuilder("pointed_stone_forest", new PointedSB(PointedSBConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> CRIMSON_GARDENS = WorldGenRegistrationHelper.createSurfaceBuilder("crimson_gardens", new CrimsonGardenSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> GLOWSTONE_GARDENS = WorldGenRegistrationHelper.createSurfaceBuilder("glowstone_gardens", new GlowstoneGardensSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> TWILIGHT_VALLEY = WorldGenRegistrationHelper.createSurfaceBuilder("twilight_valley", new TwilightValleySB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> ERODED_LUNA = WorldGenRegistrationHelper.createSurfaceBuilder("eroded_luna", new ErodedLunaSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<FillSurfaceBuilderConfig> FILL = WorldGenRegistrationHelper.createSurfaceBuilder("fill", new FillerSurfaceBuilder(FillSurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> BRIMSTONE_CAVERNS = WorldGenRegistrationHelper.createSurfaceBuilder("brimstone_caverns", new BrimstoneCavernsSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> MAGMA_WASTES = WorldGenRegistrationHelper.createSurfaceBuilder("magma_wastes", new MagmaWastesSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> SUBZERO_HYPOGEAL = WorldGenRegistrationHelper.createSurfaceBuilder("subzero_hypogeal", new SubzeroHypogealSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> WITHERING_WOODS = WorldGenRegistrationHelper.createSurfaceBuilder("withering_woods", new WitheringWoodsSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> QUARTZ_DESERT = WorldGenRegistrationHelper.createSurfaceBuilder("quartz_desert", new QuartzDesertSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> WEEPING_MIRE = WorldGenRegistrationHelper.createSurfaceBuilder("weeping_mire", new WeepingMireSB(TernarySurfaceConfig.CODEC));

    //End
    public static final SurfaceBuilder<TernarySurfaceConfig> IVIS_FIELDS = WorldGenRegistrationHelper.createSurfaceBuilder("ivis_fields", new IvisFieldsSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> SHATTERED_DESERT = WorldGenRegistrationHelper.createSurfaceBuilder("shattered_desert", new ShatteredDesertSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> PURPUR_PEAKS = WorldGenRegistrationHelper.createSurfaceBuilder("purpur_peaks", new PurpurPeaksSB(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> ETHEREAL = WorldGenRegistrationHelper.createSurfaceBuilder("ethereal", new FillEtherealStone(TernarySurfaceConfig.CODEC));
    public static final SurfaceBuilder<TernarySurfaceConfig> CRYPTIC = WorldGenRegistrationHelper.createSurfaceBuilder("cryptic", new FillCrypticStone(TernarySurfaceConfig.CODEC));


    public static void init() {
    }

    public static class Configs {
        public static final TernarySurfaceConfig BLACK_SAND = new TernarySurfaceConfig(BYGBlocks.BLACK_SAND.getDefaultState(), BYGBlocks.BLACK_SAND.getDefaultState(), BYGBlocks.BLACK_SANDSTONE.getDefaultState());
        public static final TernarySurfaceConfig ROCKY_BLACK_SAND = new TernarySurfaceConfig(BYGBlocks.ROCKY_STONE.getDefaultState(), BYGBlocks.BLACK_SAND.getDefaultState(), BYGBlocks.BLACK_SANDSTONE.getDefaultState());
        public static final TernarySurfaceConfig ROCKY_BLACK_SAND2 = new TernarySurfaceConfig(BYGBlocks.BLACK_SAND.getDefaultState(), BYGBlocks.ROCKY_STONE.getDefaultState(), BYGBlocks.BLACK_SANDSTONE.getDefaultState());
        public static final TernarySurfaceConfig STONE_BLACK_SAND = new TernarySurfaceConfig(BYGBlocks.BLACK_SAND.getDefaultState(), Blocks.STONE.getDefaultState(), BYGBlocks.BLACK_SANDSTONE.getDefaultState());
        public static final TernarySurfaceConfig STONE_BLACK_SAND2 = new TernarySurfaceConfig(Blocks.STONE.getDefaultState(), BYGBlocks.BLACK_SAND.getDefaultState(), BYGBlocks.BLACK_SANDSTONE.getDefaultState());
        public static final TernarySurfaceConfig BLUE_SAND = new TernarySurfaceConfig(BYGBlocks.BLUE_SAND.getDefaultState(), BYGBlocks.BLUE_SAND.getDefaultState(), BYGBlocks.BLUE_SANDSTONE.getDefaultState());
        public static final TernarySurfaceConfig PINK_SAND = new TernarySurfaceConfig(BYGBlocks.PINK_SAND.getDefaultState(), BYGBlocks.PINK_SAND.getDefaultState(), BYGBlocks.PINK_SANDSTONE.getDefaultState());
        public static final TernarySurfaceConfig PURPLE_SAND = new TernarySurfaceConfig(BYGBlocks.PURPLE_SAND.getDefaultState(), BYGBlocks.PURPLE_SAND.getDefaultState(), BYGBlocks.PURPLE_SANDSTONE.getDefaultState());
        public static final TernarySurfaceConfig WHITE_SAND = new TernarySurfaceConfig(BYGBlocks.WHITE_SAND.getDefaultState(), BYGBlocks.WHITE_SAND.getDefaultState(), BYGBlocks.WHITE_SANDSTONE.getDefaultState());
        public static final TernarySurfaceConfig SAND = new TernarySurfaceConfig(Blocks.SAND.getDefaultState(), Blocks.SAND.getDefaultState(), Blocks.SANDSTONE.getDefaultState());
        public static final TernarySurfaceConfig ROCKY = new TernarySurfaceConfig(BYGBlocks.ROCKY_STONE.getDefaultState(), BYGBlocks.ROCKY_STONE.getDefaultState(), BYGBlocks.ROCKY_STONE.getDefaultState());
        public static final TernarySurfaceConfig STONE = new TernarySurfaceConfig(Blocks.STONE.getDefaultState(), Blocks.STONE.getDefaultState(), Blocks.STONE.getDefaultState());
        public static final TernarySurfaceConfig COARSE = new TernarySurfaceConfig(Blocks.COARSE_DIRT.getDefaultState(), Blocks.COARSE_DIRT.getDefaultState(), Blocks.COARSE_DIRT.getDefaultState());
        public static final TernarySurfaceConfig GLOWSTONE_GARDENS = new TernarySurfaceConfig(BYGBlocks.OVERGROWN_NETHERRACK.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), Blocks.NETHERRACK.getDefaultState());
        public static final TernarySurfaceConfig CRIMSON_GARDEN = new TernarySurfaceConfig(BYGBlocks.OVERGROWN_CRIMSON_BLACKSTONE.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), Blocks.NETHER_WART_BLOCK.getDefaultState());
        public static final TernarySurfaceConfig MYCELIUM_NETHERRACK = new TernarySurfaceConfig(BYGBlocks.MYCELIUM_NETHERRACK.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), Blocks.NETHERRACK.getDefaultState());
        public static final TernarySurfaceConfig WARPED_NYLIUM = new TernarySurfaceConfig(Blocks.WARPED_NYLIUM.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), Blocks.NETHERRACK.getDefaultState());

        public static final TernarySurfaceConfig SAND_CF = new TernarySurfaceConfig(Blocks.SAND.getDefaultState(), Blocks.SAND.getDefaultState(), Blocks.SAND.getDefaultState());
        public static final TernarySurfaceConfig REDSAND_CF = new TernarySurfaceConfig(Blocks.RED_SAND.getDefaultState(), Blocks.RED_SAND.getDefaultState(), Blocks.RED_SAND.getDefaultState());
        public static final TernarySurfaceConfig WARPEDDESERT = new TernarySurfaceConfig(BYGBlocks.NYLIUM_SOUL_SAND.getDefaultState(), BYGBlocks.NYLIUM_SOUL_SAND.getDefaultState(), BYGBlocks.NYLIUM_SOUL_SAND.getDefaultState());
        public static final TernarySurfaceConfig SYTHIANTORRIDS = new TernarySurfaceConfig(BYGBlocks.SYTHIAN_NYLIUM.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), Blocks.NETHERRACK.getDefaultState());
        public static final TernarySurfaceConfig WARPEDDESERT_SOIL = new TernarySurfaceConfig(BYGBlocks.NYLIUM_SOUL_SOIL.getDefaultState(), BYGBlocks.NYLIUM_SOUL_SOIL.getDefaultState(), BYGBlocks.NYLIUM_SOUL_SOIL.getDefaultState());
        public static final TernarySurfaceConfig EMBURNYLIUM = new TernarySurfaceConfig(BYGBlocks.EMBUR_NYLIUM.getDefaultState(), BYGBlocks.BLUE_NETHERRACK.getDefaultState(), BYGBlocks.BLUE_NETHERRACK.getDefaultState());
        public static final TernarySurfaceConfig SOULSAND = new TernarySurfaceConfig(Blocks.SOUL_SAND.getDefaultState(), Blocks.SOUL_SAND.getDefaultState(), Blocks.NETHERRACK.getDefaultState());
        public static final TernarySurfaceConfig SOUL_SOIL = new TernarySurfaceConfig(Blocks.SOUL_SOIL.getDefaultState(), Blocks.SOUL_SOIL.getDefaultState(), Blocks.NETHERRACK.getDefaultState());
        public static final TernarySurfaceConfig MAGMATIC_STONE = new TernarySurfaceConfig(BYGBlocks.MAGMATIC_STONE.getDefaultState(), BYGBlocks.MAGMATIC_STONE.getDefaultState(), BYGBlocks.MAGMATIC_STONE.getDefaultState());
        public static final TernarySurfaceConfig MAGMA_BLOCK = new TernarySurfaceConfig(Blocks.MAGMA_BLOCK.getDefaultState(), Blocks.MAGMA_BLOCK.getDefaultState(), Blocks.MAGMA_BLOCK.getDefaultState());
        public static final TernarySurfaceConfig BRIMSTONE = new TernarySurfaceConfig(BYGBlocks.BRIMSTONE.getDefaultState(), BYGBlocks.BRIMSTONE.getDefaultState(), BYGBlocks.BRIMSTONE.getDefaultState());
        public static final TernarySurfaceConfig FROST_MAGMA = new TernarySurfaceConfig(BYGBlocks.FROST_MAGMA.getDefaultState(), BYGBlocks.FROST_MAGMA.getDefaultState(), BYGBlocks.FROST_MAGMA.getDefaultState());
        public static final TernarySurfaceConfig SUBZERO_ASH = new TernarySurfaceConfig(BYGBlocks.SUBZERO_ASH_BLOCK.getDefaultState(), BYGBlocks.SUBZERO_ASH_BLOCK.getDefaultState(), BYGBlocks.SUBZERO_ASH_BLOCK.getDefaultState());


        public static final TernarySurfaceConfig PODZOLDOVERMOUNTAIN_CF = new TernarySurfaceConfig(BYGBlocks.OVERGROWN_DACITE.getDefaultState(), BYGBlocks.DACITE.getDefaultState(), BYGBlocks.DACITE.getDefaultState());
        public static final TernarySurfaceConfig COARSEDIRTDOVERMOUNTAIN_CF = new TernarySurfaceConfig(Blocks.COARSE_DIRT.getDefaultState(), BYGBlocks.DACITE.getDefaultState(), BYGBlocks.DACITE.getDefaultState());
        public static final TernarySurfaceConfig GRASSDOVERMOUNTAIN_CF = new TernarySurfaceConfig(BYGBlocks.PODZOL_DACITE.getDefaultState(), BYGBlocks.DACITE.getDefaultState(), BYGBlocks.DACITE.getDefaultState());

        public static final TernarySurfaceConfig AIR_CF = new TernarySurfaceConfig(Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState());

        public static final TernarySurfaceConfig QUAGMIREPEAT_SB = new TernarySurfaceConfig(BYGBlocks.PEAT.getDefaultState(), BYGBlocks.MUD_BLOCK.getDefaultState(), BYGBlocks.MUD_BLOCK.getDefaultState());
        public static final TernarySurfaceConfig QUAGMIREMUD_CF = new TernarySurfaceConfig(BYGBlocks.MUD_BLOCK.getDefaultState(), BYGBlocks.MUD_BRICKS.getDefaultState(), BYGBlocks.MUD_BLOCK.getDefaultState());
        public static final TernarySurfaceConfig GRASSMOUNTAIN_CF = new TernarySurfaceConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.STONE.getDefaultState(), Blocks.STONE.getDefaultState());
        public static final TernarySurfaceConfig PEATGRASS_CF = new TernarySurfaceConfig(BYGBlocks.PEAT.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState());
        public static final TernarySurfaceConfig MUD_CF = new TernarySurfaceConfig(BYGBlocks.MUD_BLOCK.getDefaultState(), BYGBlocks.MUD_BLOCK.getDefaultState(), BYGBlocks.MUD_BLOCK.getDefaultState());
        public static final TernarySurfaceConfig TERRACOTTA_CF = new TernarySurfaceConfig(Blocks.TERRACOTTA.getDefaultState(), Blocks.TERRACOTTA.getDefaultState(), Blocks.TERRACOTTA.getDefaultState());
        public static final TernarySurfaceConfig GLOWCELIUM_CF = new TernarySurfaceConfig(BYGBlocks.GLOWCELIUM.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState());

        public static final TernarySurfaceConfig GREEN_CONCRETE_POWDER_CF = new TernarySurfaceConfig(BYGBlocks.OVERGROWN_STONE.getDefaultState(), BYGBlocks.MOSSY_STONE.getDefaultState(), Blocks.STONE.getDefaultState());

        public static final TernarySurfaceConfig RED_ROCK_CF = new TernarySurfaceConfig(BYGBlocks.RED_ROCK.getDefaultState(), BYGBlocks.RED_ROCK.getDefaultState(), BYGBlocks.RED_ROCK.getDefaultState());

        public static final TernarySurfaceConfig IVIS_CF = new TernarySurfaceConfig(BYGBlocks.IVIS_PHYLIUM.getDefaultState(), Blocks.END_STONE.getDefaultState(), Blocks.END_STONE.getDefaultState());
        public static final TernarySurfaceConfig END = new TernarySurfaceConfig(Blocks.END_STONE.getDefaultState(), Blocks.END_STONE.getDefaultState(), Blocks.END_STONE.getDefaultState());
        public static final TernarySurfaceConfig MYCELIUM = new TernarySurfaceConfig(Blocks.MYCELIUM.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState());
        public static final TernarySurfaceConfig ETHER = new TernarySurfaceConfig(BYGBlocks.ETHER_PHYLIUM.getDefaultState(), BYGBlocks.ETHER_SOIL.getDefaultState(), BYGBlocks.ETHER_STONE.getDefaultState());
        public static final TernarySurfaceConfig NIGHTSHADE = new TernarySurfaceConfig(BYGBlocks.NIGHTSHADE_PHYLIUM.getDefaultState(), Blocks.END_STONE.getDefaultState(), Blocks.END_STONE.getDefaultState());
        public static final TernarySurfaceConfig SCULK = new TernarySurfaceConfig(BYGBlocks.VERMILION_SCULK.getDefaultState(), BYGBlocks.ETHER_STONE.getDefaultState(), BYGBlocks.ETHER_STONE.getDefaultState());
        public static final TernarySurfaceConfig SHULKREN = new TernarySurfaceConfig(BYGBlocks.SHULKREN_PHYLIUM.getDefaultState(), Blocks.END_STONE.getDefaultState(), Blocks.END_STONE.getDefaultState());
        public static final TernarySurfaceConfig CRYPTIC = new TernarySurfaceConfig(BYGBlocks.CRYPTIC_STONE.getDefaultState(), BYGBlocks.CRYPTIC_STONE.getDefaultState(), BYGBlocks.CRYPTIC_STONE.getDefaultState());
        public static final TernarySurfaceConfig CRYPTIC_MAGMA = new TernarySurfaceConfig(BYGBlocks.CRYPTIC_MAGMA_BLOCK.getDefaultState(), BYGBlocks.CRYPTIC_MAGMA_BLOCK.getDefaultState(), BYGBlocks.CRYPTIC_MAGMA_BLOCK.getDefaultState());

        public static final TernarySurfaceConfig SNOW_CF = new TernarySurfaceConfig(Blocks.SNOW_BLOCK.getDefaultState(), Blocks.SNOW_BLOCK.getDefaultState(), Blocks.SNOW_BLOCK.getDefaultState());
        public static final TernarySurfaceConfig PACKED_ICE_CF = new TernarySurfaceConfig(Blocks.PACKED_ICE.getDefaultState(), Blocks.PACKED_ICE.getDefaultState(), Blocks.PACKED_ICE.getDefaultState());
        public static final TernarySurfaceConfig BLUE_ICE_CF = new TernarySurfaceConfig(Blocks.BLUE_ICE.getDefaultState(), Blocks.BLUE_ICE.getDefaultState(), Blocks.BLUE_ICE.getDefaultState());

    }
}
