package corgiaoc.byg.core.world;

import corgiaoc.byg.common.world.surfacebuilder.*;
import corgiaoc.byg.common.world.surfacebuilder.config.FillSurfaceBuilderConfig;
import corgiaoc.byg.common.world.surfacebuilder.config.PointedSBConfig;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.ArrayList;
import java.util.List;

public class BYGSurfaceBuilders {
    public static List<SurfaceBuilder<?>> surfaceBuilders = new ArrayList<>();

    public static final SurfaceBuilder<SurfaceBuilderConfig> BOREAL = WorldGenRegistrationHelper.createSurfaceBuilder("boreal", new BorealForestSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> BASALT_BARRERA = WorldGenRegistrationHelper.createSurfaceBuilder("basalt_barrera", new BasaltBarreraSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> CONIFEROUS = WorldGenRegistrationHelper.createSurfaceBuilder("coniferous", new ConiferousForestSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> SHATTERED_GLACIER = WorldGenRegistrationHelper.createSurfaceBuilder("shattered_glacier", new ShatteredGlacierSB2(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> MARSHLAND = WorldGenRegistrationHelper.createSurfaceBuilder("marshland", new MarshlandSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> VOLCANIC_FIELDS = WorldGenRegistrationHelper.createSurfaceBuilder("volcanic_wastes", new VolcanicWastes(SurfaceBuilderConfig.CODEC));


    public static final SurfaceBuilder<SurfaceBuilderConfig> GREAT_LAKES = WorldGenRegistrationHelper.createSurfaceBuilder("great_lakes", new GreatLakeSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> GREAT_LAKE_ISLES = WorldGenRegistrationHelper.createSurfaceBuilder("great_lakes_isles", new GreatLakeIsleSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> ERODED_SIERRA = WorldGenRegistrationHelper.createSurfaceBuilder("eroded_sierra", new ErodedSierraSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> SIERRA_VALLEY = WorldGenRegistrationHelper.createSurfaceBuilder("sierra_valley", new SierraValleySB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> GLOWSHROOM_BAYOU = WorldGenRegistrationHelper.createSurfaceBuilder("glowshroom_bayou", new GlowShroomBayouSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> CRAG_GARDENS = WorldGenRegistrationHelper.createSurfaceBuilder("crag_gardens", new CragGardensSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> RED_ROCK_SB = WorldGenRegistrationHelper.createSurfaceBuilder("red_rock", new RedRockSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> RED_ROCK_LOWLANDS = WorldGenRegistrationHelper.createSurfaceBuilder("red_rock_lowlands", new RedRockLowlandsSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> RED_DUNES = WorldGenRegistrationHelper.createSurfaceBuilder("red_dunes", new RedDunesSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> DUNES = WorldGenRegistrationHelper.createSurfaceBuilder("dunes", new DunesSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> DOVER = WorldGenRegistrationHelper.createSurfaceBuilder("dover_mountains", new DoverMountainSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> CANYONS = WorldGenRegistrationHelper.createSurfaceBuilder("canyons", new CanyonSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> CANYON_EDGE = WorldGenRegistrationHelper.createSurfaceBuilder("canyon_edge", new CanyonEdgeSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> MOJAVE = WorldGenRegistrationHelper.createSurfaceBuilder("mojave", new MojaveSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> LUSH_TUNDRA = WorldGenRegistrationHelper.createSurfaceBuilder("lush_tundra", new LushTundraSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> FUNGAL_RAINFOREST = WorldGenRegistrationHelper.createSurfaceBuilder("fungal_rainforest", new FungalRainforestSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> EBONY = WorldGenRegistrationHelper.createSurfaceBuilder("ebony_woods", new EbonyWoodsSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> GLOWING_ANCIENT_FOREST = WorldGenRegistrationHelper.createSurfaceBuilder("glowing_ancient_forest", new GlowingAncientForestSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> EMBUR_BOG = WorldGenRegistrationHelper.createSurfaceBuilder("embur_bog", new EmburBogSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> ROCKY_BLACK_BEACH = WorldGenRegistrationHelper.createSurfaceBuilder("rocky_black_beach", new RockyBlackBeachSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> RAINBOW_BEACH = WorldGenRegistrationHelper.createSurfaceBuilder("rainbow_beach", new RainbowBeachSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> ROCKY_BEACH = WorldGenRegistrationHelper.createSurfaceBuilder("rocky_beach", new RockyBeachSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> WARPED_DESERT = WorldGenRegistrationHelper.createSurfaceBuilder("warped_desert", new WarpedDesertSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> WAILING_GARTH = WorldGenRegistrationHelper.createSurfaceBuilder("wailing_garth", new WailingGarthSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> STONE_FOREST = WorldGenRegistrationHelper.createSurfaceBuilder("stone_forest", new StoneForestSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<PointedSBConfig> POINTED = WorldGenRegistrationHelper.createSurfaceBuilder("pointed_stone_forest", new PointedSB(PointedSBConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> CRIMSON_GARDENS = WorldGenRegistrationHelper.createSurfaceBuilder("crimson_gardens", new CrimsonGardenSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> GLOWSTONE_GARDENS = WorldGenRegistrationHelper.createSurfaceBuilder("glowstone_gardens", new GlowstoneGardensSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> TWILIGHT_VALLEY = WorldGenRegistrationHelper.createSurfaceBuilder("twilight_valley", new TwilightValleySB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> ERODED_LUNA = WorldGenRegistrationHelper.createSurfaceBuilder("eroded_luna", new ErodedLunaSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<FillSurfaceBuilderConfig> FILL = WorldGenRegistrationHelper.createSurfaceBuilder("fill", new FillerSurfaceBuilder(FillSurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> BRIMSTONE_CAVERNS = WorldGenRegistrationHelper.createSurfaceBuilder("brimstone_caverns", new BrimstoneCavernsSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> MAGMA_WASTES = WorldGenRegistrationHelper.createSurfaceBuilder("magma_wastes", new MagmaWastesSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> SUBZERO_HYPOGEAL = WorldGenRegistrationHelper.createSurfaceBuilder("subzero_hypogeal", new SubzeroHypogealSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> WITHERING_WOODS = WorldGenRegistrationHelper.createSurfaceBuilder("withering_woods", new WitheringWoodsSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> QUARTZ_DESERT = WorldGenRegistrationHelper.createSurfaceBuilder("quartz_desert", new QuartzDesertSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> WEEPING_MIRE = WorldGenRegistrationHelper.createSurfaceBuilder("weeping_mire", new WeepingMireSB(SurfaceBuilderConfig.CODEC));

    //End
    public static final SurfaceBuilder<SurfaceBuilderConfig> IVIS_FIELDS = WorldGenRegistrationHelper.createSurfaceBuilder("ivis_fields", new IvisFieldsSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> SHATTERED_DESERT = WorldGenRegistrationHelper.createSurfaceBuilder("shattered_desert", new ShatteredDesertSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> PURPUR_PEAKS = WorldGenRegistrationHelper.createSurfaceBuilder("purpur_peaks", new PurpurPeaksSB(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> ETHEREAL = WorldGenRegistrationHelper.createSurfaceBuilder("ethereal", new FillEtherealStone(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> CRYPTIC = WorldGenRegistrationHelper.createSurfaceBuilder("cryptic", new FillCrypticStone(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderConfig> BULBIS_GARDENS = WorldGenRegistrationHelper.createSurfaceBuilder("bulbis_gardens", new BulbisGardensSB(SurfaceBuilderConfig.CODEC));


    public static void init() {
    }

    public static class Configs {
        public static final SurfaceBuilderConfig BLACK_SAND = new SurfaceBuilderConfig(BYGBlocks.BLACK_SAND.defaultBlockState(), BYGBlocks.BLACK_SAND.defaultBlockState(), BYGBlocks.BLACK_SANDSTONE.defaultBlockState());
        public static final SurfaceBuilderConfig ROCKY_BLACK_SAND = new SurfaceBuilderConfig(BYGBlocks.ROCKY_STONE.defaultBlockState(), BYGBlocks.BLACK_SAND.defaultBlockState(), BYGBlocks.BLACK_SANDSTONE.defaultBlockState());
        public static final SurfaceBuilderConfig ROCKY_BLACK_SAND2 = new SurfaceBuilderConfig(BYGBlocks.BLACK_SAND.defaultBlockState(), BYGBlocks.ROCKY_STONE.defaultBlockState(), BYGBlocks.BLACK_SANDSTONE.defaultBlockState());
        public static final SurfaceBuilderConfig STONE_BLACK_SAND = new SurfaceBuilderConfig(BYGBlocks.BLACK_SAND.defaultBlockState(), Blocks.STONE.defaultBlockState(), BYGBlocks.BLACK_SANDSTONE.defaultBlockState());
        public static final SurfaceBuilderConfig STONE_BLACK_SAND2 = new SurfaceBuilderConfig(Blocks.STONE.defaultBlockState(), BYGBlocks.BLACK_SAND.defaultBlockState(), BYGBlocks.BLACK_SANDSTONE.defaultBlockState());
        public static final SurfaceBuilderConfig BLUE_SAND = new SurfaceBuilderConfig(BYGBlocks.BLUE_SAND.defaultBlockState(), BYGBlocks.BLUE_SAND.defaultBlockState(), BYGBlocks.BLUE_SANDSTONE.defaultBlockState());
        public static final SurfaceBuilderConfig PINK_SAND = new SurfaceBuilderConfig(BYGBlocks.PINK_SAND.defaultBlockState(), BYGBlocks.PINK_SAND.defaultBlockState(), BYGBlocks.PINK_SANDSTONE.defaultBlockState());
        public static final SurfaceBuilderConfig PURPLE_SAND = new SurfaceBuilderConfig(BYGBlocks.PURPLE_SAND.defaultBlockState(), BYGBlocks.PURPLE_SAND.defaultBlockState(), BYGBlocks.PURPLE_SANDSTONE.defaultBlockState());
        public static final SurfaceBuilderConfig WHITE_SAND = new SurfaceBuilderConfig(BYGBlocks.WHITE_SAND.defaultBlockState(), BYGBlocks.WHITE_SAND.defaultBlockState(), BYGBlocks.WHITE_SANDSTONE.defaultBlockState());
        public static final SurfaceBuilderConfig SAND = new SurfaceBuilderConfig(Blocks.SAND.defaultBlockState(), Blocks.SAND.defaultBlockState(), Blocks.SANDSTONE.defaultBlockState());
        public static final SurfaceBuilderConfig ROCKY = new SurfaceBuilderConfig(BYGBlocks.ROCKY_STONE.defaultBlockState(), BYGBlocks.ROCKY_STONE.defaultBlockState(), BYGBlocks.ROCKY_STONE.defaultBlockState());
        public static final SurfaceBuilderConfig STONE = new SurfaceBuilderConfig(Blocks.STONE.defaultBlockState(), Blocks.STONE.defaultBlockState(), Blocks.STONE.defaultBlockState());
        public static final SurfaceBuilderConfig COARSE = new SurfaceBuilderConfig(Blocks.COARSE_DIRT.defaultBlockState(), Blocks.COARSE_DIRT.defaultBlockState(), Blocks.COARSE_DIRT.defaultBlockState());
        public static final SurfaceBuilderConfig GLOWSTONE_GARDENS = new SurfaceBuilderConfig(BYGBlocks.OVERGROWN_NETHERRACK.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState());
        public static final SurfaceBuilderConfig CRIMSON_GARDEN = new SurfaceBuilderConfig(BYGBlocks.OVERGROWN_CRIMSON_BLACKSTONE.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), Blocks.NETHER_WART_BLOCK.defaultBlockState());
        public static final SurfaceBuilderConfig MYCELIUM_NETHERRACK = new SurfaceBuilderConfig(BYGBlocks.MYCELIUM_NETHERRACK.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState());
        public static final SurfaceBuilderConfig WARPED_NYLIUM = new SurfaceBuilderConfig(Blocks.WARPED_NYLIUM.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState());
        public static final SurfaceBuilderConfig END_SAND = new SurfaceBuilderConfig(BYGBlocks.END_SAND.defaultBlockState(), Blocks.END_STONE_BRICKS.defaultBlockState(), Blocks.END_STONE_BRICKS.defaultBlockState());
        public static final SurfaceBuilderConfig WAILING_NYLIUM = new SurfaceBuilderConfig(BYGBlocks.WAILING_NYLIUM.defaultBlockState(), Blocks.SOUL_SOIL.defaultBlockState(), Blocks.SOUL_SOIL.defaultBlockState());

        public static final SurfaceBuilderConfig SAND_CF = new SurfaceBuilderConfig(Blocks.SAND.defaultBlockState(), Blocks.SAND.defaultBlockState(), Blocks.SAND.defaultBlockState());
        public static final SurfaceBuilderConfig REDSAND_CF = new SurfaceBuilderConfig(Blocks.RED_SAND.defaultBlockState(), Blocks.RED_SAND.defaultBlockState(), Blocks.RED_SAND.defaultBlockState());
        public static final SurfaceBuilderConfig WARPEDDESERT = new SurfaceBuilderConfig(BYGBlocks.NYLIUM_SOUL_SAND.defaultBlockState(), BYGBlocks.NYLIUM_SOUL_SAND.defaultBlockState(), BYGBlocks.NYLIUM_SOUL_SAND.defaultBlockState());
        public static final SurfaceBuilderConfig SYTHIANTORRIDS = new SurfaceBuilderConfig(BYGBlocks.SYTHIAN_NYLIUM.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState());
        public static final SurfaceBuilderConfig WARPEDDESERT_SOIL = new SurfaceBuilderConfig(BYGBlocks.NYLIUM_SOUL_SOIL.defaultBlockState(), BYGBlocks.NYLIUM_SOUL_SOIL.defaultBlockState(), BYGBlocks.NYLIUM_SOUL_SOIL.defaultBlockState());
        public static final SurfaceBuilderConfig EMBURNYLIUM = new SurfaceBuilderConfig(BYGBlocks.EMBUR_NYLIUM.defaultBlockState(), BYGBlocks.BLUE_NETHERRACK.defaultBlockState(), BYGBlocks.BLUE_NETHERRACK.defaultBlockState());
        public static final SurfaceBuilderConfig SOULSAND = new SurfaceBuilderConfig(Blocks.SOUL_SAND.defaultBlockState(), Blocks.SOUL_SAND.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState());
        public static final SurfaceBuilderConfig SOUL_SOIL = new SurfaceBuilderConfig(Blocks.SOUL_SOIL.defaultBlockState(), Blocks.SOUL_SOIL.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState());
        public static final SurfaceBuilderConfig MAGMATIC_STONE = new SurfaceBuilderConfig(BYGBlocks.MAGMATIC_STONE.defaultBlockState(), BYGBlocks.MAGMATIC_STONE.defaultBlockState(), BYGBlocks.MAGMATIC_STONE.defaultBlockState());
        public static final SurfaceBuilderConfig MAGMA_BLOCK = new SurfaceBuilderConfig(Blocks.MAGMA_BLOCK.defaultBlockState(), Blocks.MAGMA_BLOCK.defaultBlockState(), Blocks.MAGMA_BLOCK.defaultBlockState());
        public static final SurfaceBuilderConfig BRIMSTONE = new SurfaceBuilderConfig(BYGBlocks.BRIMSTONE.defaultBlockState(), BYGBlocks.BRIMSTONE.defaultBlockState(), BYGBlocks.BRIMSTONE.defaultBlockState());
        public static final SurfaceBuilderConfig FROST_MAGMA = new SurfaceBuilderConfig(BYGBlocks.FROST_MAGMA.defaultBlockState(), BYGBlocks.FROST_MAGMA.defaultBlockState(), BYGBlocks.FROST_MAGMA.defaultBlockState());
        public static final SurfaceBuilderConfig SUBZERO_ASH = new SurfaceBuilderConfig(BYGBlocks.SUBZERO_ASH_BLOCK.defaultBlockState(), BYGBlocks.SUBZERO_ASH_BLOCK.defaultBlockState(), BYGBlocks.SUBZERO_ASH_BLOCK.defaultBlockState());


        public static final SurfaceBuilderConfig PODZOLDOVERMOUNTAIN_CF = new SurfaceBuilderConfig(BYGBlocks.OVERGROWN_DACITE.defaultBlockState(), BYGBlocks.DACITE.defaultBlockState(), BYGBlocks.DACITE.defaultBlockState());
        public static final SurfaceBuilderConfig COARSEDIRTDOVERMOUNTAIN_CF = new SurfaceBuilderConfig(Blocks.COARSE_DIRT.defaultBlockState(), BYGBlocks.DACITE.defaultBlockState(), BYGBlocks.DACITE.defaultBlockState());
        public static final SurfaceBuilderConfig GRASSDOVERMOUNTAIN_CF = new SurfaceBuilderConfig(BYGBlocks.PODZOL_DACITE.defaultBlockState(), BYGBlocks.DACITE.defaultBlockState(), BYGBlocks.DACITE.defaultBlockState());

        public static final SurfaceBuilderConfig AIR_CF = new SurfaceBuilderConfig(Blocks.AIR.defaultBlockState(), Blocks.AIR.defaultBlockState(), Blocks.AIR.defaultBlockState());

        public static final SurfaceBuilderConfig QUAGMIREPEAT_SB = new SurfaceBuilderConfig(BYGBlocks.PEAT.defaultBlockState(), BYGBlocks.MUD_BLOCK.defaultBlockState(), BYGBlocks.MUD_BLOCK.defaultBlockState());
        public static final SurfaceBuilderConfig QUAGMIREMUD_CF = new SurfaceBuilderConfig(BYGBlocks.MUD_BLOCK.defaultBlockState(), BYGBlocks.MUD_BRICKS.defaultBlockState(), BYGBlocks.MUD_BLOCK.defaultBlockState());
        public static final SurfaceBuilderConfig GRASSMOUNTAIN_CF = new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.STONE.defaultBlockState(), Blocks.STONE.defaultBlockState());
        public static final SurfaceBuilderConfig PEATGRASS_CF = new SurfaceBuilderConfig(BYGBlocks.PEAT.defaultBlockState(), Blocks.DIRT.defaultBlockState(), Blocks.DIRT.defaultBlockState());
        public static final SurfaceBuilderConfig MUD_CF = new SurfaceBuilderConfig(BYGBlocks.MUD_BLOCK.defaultBlockState(), BYGBlocks.MUD_BLOCK.defaultBlockState(), BYGBlocks.MUD_BLOCK.defaultBlockState());
        public static final SurfaceBuilderConfig TERRACOTTA_CF = new SurfaceBuilderConfig(Blocks.TERRACOTTA.defaultBlockState(), Blocks.TERRACOTTA.defaultBlockState(), Blocks.TERRACOTTA.defaultBlockState());
        public static final SurfaceBuilderConfig GLOWCELIUM_CF = new SurfaceBuilderConfig(BYGBlocks.GLOWCELIUM.defaultBlockState(), Blocks.DIRT.defaultBlockState(), Blocks.DIRT.defaultBlockState());

        public static final SurfaceBuilderConfig GREEN_CONCRETE_POWDER_CF = new SurfaceBuilderConfig(BYGBlocks.OVERGROWN_STONE.defaultBlockState(), BYGBlocks.MOSSY_STONE.defaultBlockState(), Blocks.STONE.defaultBlockState());

        public static final SurfaceBuilderConfig RED_ROCK_CF = new SurfaceBuilderConfig(BYGBlocks.RED_ROCK.defaultBlockState(), BYGBlocks.RED_ROCK.defaultBlockState(), BYGBlocks.RED_ROCK.defaultBlockState());

        public static final SurfaceBuilderConfig BULBIS_PHYCELIUM_CF = new SurfaceBuilderConfig(BYGBlocks.BULBIS_PHYCELIUM.defaultBlockState(), Blocks.END_STONE.defaultBlockState(), Blocks.END_STONE.defaultBlockState());
        public static final SurfaceBuilderConfig IVIS_CF = new SurfaceBuilderConfig(BYGBlocks.IVIS_PHYLIUM.defaultBlockState(), Blocks.END_STONE.defaultBlockState(), Blocks.END_STONE.defaultBlockState());
        public static final SurfaceBuilderConfig END = new SurfaceBuilderConfig(Blocks.END_STONE.defaultBlockState(), Blocks.END_STONE.defaultBlockState(), Blocks.END_STONE.defaultBlockState());
        public static final SurfaceBuilderConfig MYCELIUM = new SurfaceBuilderConfig(Blocks.MYCELIUM.defaultBlockState(), Blocks.DIRT.defaultBlockState(), Blocks.DIRT.defaultBlockState());
        public static final SurfaceBuilderConfig ETHER = new SurfaceBuilderConfig(BYGBlocks.ETHER_PHYLIUM.defaultBlockState(), BYGBlocks.ETHER_SOIL.defaultBlockState(), BYGBlocks.ETHER_STONE.defaultBlockState());
        public static final SurfaceBuilderConfig NIGHTSHADE = new SurfaceBuilderConfig(BYGBlocks.NIGHTSHADE_PHYLIUM.defaultBlockState(), Blocks.END_STONE.defaultBlockState(), Blocks.END_STONE.defaultBlockState());
        public static final SurfaceBuilderConfig SCULK = new SurfaceBuilderConfig(BYGBlocks.VERMILION_SCULK.defaultBlockState(), BYGBlocks.ETHER_STONE.defaultBlockState(), BYGBlocks.ETHER_STONE.defaultBlockState());
        public static final SurfaceBuilderConfig SHULKREN = new SurfaceBuilderConfig(BYGBlocks.SHULKREN_PHYLIUM.defaultBlockState(), Blocks.END_STONE.defaultBlockState(), Blocks.END_STONE.defaultBlockState());
        public static final SurfaceBuilderConfig CRYPTIC = new SurfaceBuilderConfig(BYGBlocks.CRYPTIC_STONE.defaultBlockState(), BYGBlocks.CRYPTIC_STONE.defaultBlockState(), BYGBlocks.CRYPTIC_STONE.defaultBlockState());
        public static final SurfaceBuilderConfig CRYPTIC_MAGMA = new SurfaceBuilderConfig(BYGBlocks.CRYPTIC_MAGMA_BLOCK.defaultBlockState(), BYGBlocks.CRYPTIC_MAGMA_BLOCK.defaultBlockState(), BYGBlocks.CRYPTIC_MAGMA_BLOCK.defaultBlockState());
        public static final SurfaceBuilderConfig IMPARIUS = new SurfaceBuilderConfig(BYGBlocks.IMPARIUS_PHYLIUM.defaultBlockState(), Blocks.END_STONE.defaultBlockState(), Blocks.END_STONE.defaultBlockState());

        public static final SurfaceBuilderConfig SNOW_CF = new SurfaceBuilderConfig(Blocks.SNOW_BLOCK.defaultBlockState(), Blocks.SNOW_BLOCK.defaultBlockState(), Blocks.SNOW_BLOCK.defaultBlockState());
        public static final SurfaceBuilderConfig PACKED_ICE_CF = new SurfaceBuilderConfig(Blocks.PACKED_ICE.defaultBlockState(), Blocks.PACKED_ICE.defaultBlockState(), Blocks.PACKED_ICE.defaultBlockState());
        public static final SurfaceBuilderConfig BLUE_ICE_CF = new SurfaceBuilderConfig(Blocks.BLUE_ICE.defaultBlockState(), Blocks.BLUE_ICE.defaultBlockState(), Blocks.BLUE_ICE.defaultBlockState());

    }
}
