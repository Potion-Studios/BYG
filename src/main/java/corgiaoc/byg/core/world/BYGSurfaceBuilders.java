package corgiaoc.byg.core.world;

import corgiaoc.byg.common.world.surfacebuilder.*;
import corgiaoc.byg.common.world.surfacebuilder.config.FillSurfaceBuilderConfig;
import corgiaoc.byg.common.world.surfacebuilder.config.PointedSBConfig;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

import java.util.ArrayList;
import java.util.List;

public class BYGSurfaceBuilders {
    public static List<SurfaceBuilder<?>> surfaceBuilders = new ArrayList<>();

    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> BOREAL = WorldGenRegistrationHelper.createSurfaceBuilder("boreal", new BorealForestSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> BASALT_BARRERA = WorldGenRegistrationHelper.createSurfaceBuilder("basalt_barrera", new BasaltBarreraSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> CONIFEROUS = WorldGenRegistrationHelper.createSurfaceBuilder("coniferous", new ConiferousForestSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> SHATTERED_GLACIER = WorldGenRegistrationHelper.createSurfaceBuilder("shattered_glacier", new ShatteredGlacierSB2(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> MARSHLAND = WorldGenRegistrationHelper.createSurfaceBuilder("marshland", new MarshlandSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> VOLCANIC_FIELDS = WorldGenRegistrationHelper.createSurfaceBuilder("volcanic_wastes", new VolcanicWastes(SurfaceBuilderBaseConfiguration.CODEC));


    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> GREAT_LAKES = WorldGenRegistrationHelper.createSurfaceBuilder("great_lakes", new GreatLakeSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> GREAT_LAKE_ISLES = WorldGenRegistrationHelper.createSurfaceBuilder("great_lakes_isles", new GreatLakeIsleSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> ERODED_SIERRA = WorldGenRegistrationHelper.createSurfaceBuilder("eroded_sierra", new ErodedSierraSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> SIERRA_VALLEY = WorldGenRegistrationHelper.createSurfaceBuilder("sierra_valley", new SierraValleySB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> GLOWSHROOM_BAYOU = WorldGenRegistrationHelper.createSurfaceBuilder("glowshroom_bayou", new GlowShroomBayouSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> CRAG_GARDENS = WorldGenRegistrationHelper.createSurfaceBuilder("crag_gardens", new CragGardensSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> RED_ROCK_SB = WorldGenRegistrationHelper.createSurfaceBuilder("red_rock", new RedRockSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> RED_ROCK_LOWLANDS = WorldGenRegistrationHelper.createSurfaceBuilder("red_rock_lowlands", new RedRockLowlandsSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> RED_DUNES = WorldGenRegistrationHelper.createSurfaceBuilder("red_dunes", new RedDunesSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> DUNES = WorldGenRegistrationHelper.createSurfaceBuilder("dunes", new DunesSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> DOVER = WorldGenRegistrationHelper.createSurfaceBuilder("dover_mountains", new DoverMountainSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> CANYONS = WorldGenRegistrationHelper.createSurfaceBuilder("canyons", new CanyonSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> CANYON_EDGE = WorldGenRegistrationHelper.createSurfaceBuilder("canyon_edge", new CanyonEdgeSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> MOJAVE = WorldGenRegistrationHelper.createSurfaceBuilder("mojave", new MojaveSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> LUSH_TUNDRA = WorldGenRegistrationHelper.createSurfaceBuilder("lush_tundra", new LushTundraSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> FUNGAL_RAINFOREST = WorldGenRegistrationHelper.createSurfaceBuilder("fungal_rainforest", new FungalRainforestSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> EBONY = WorldGenRegistrationHelper.createSurfaceBuilder("ebony_woods", new EbonyWoodsSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> GLOWING_ANCIENT_FOREST = WorldGenRegistrationHelper.createSurfaceBuilder("glowing_ancient_forest", new GlowingAncientForestSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> EMBUR_BOG = WorldGenRegistrationHelper.createSurfaceBuilder("embur_bog", new EmburBogSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> ROCKY_BLACK_BEACH = WorldGenRegistrationHelper.createSurfaceBuilder("rocky_black_beach", new RockyBlackBeachSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> RAINBOW_BEACH = WorldGenRegistrationHelper.createSurfaceBuilder("rainbow_beach", new RainbowBeachSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> ROCKY_BEACH = WorldGenRegistrationHelper.createSurfaceBuilder("rocky_beach", new RockyBeachSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> WARPED_DESERT = WorldGenRegistrationHelper.createSurfaceBuilder("warped_desert", new WarpedDesertSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> WAILING_GARTH = WorldGenRegistrationHelper.createSurfaceBuilder("wailing_garth", new WailingGarthSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> STONE_FOREST = WorldGenRegistrationHelper.createSurfaceBuilder("stone_forest", new StoneForestSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<PointedSBConfig> POINTED = WorldGenRegistrationHelper.createSurfaceBuilder("pointed_stone_forest", new PointedSB(PointedSBConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> CRIMSON_GARDENS = WorldGenRegistrationHelper.createSurfaceBuilder("crimson_gardens", new CrimsonGardenSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> GLOWSTONE_GARDENS = WorldGenRegistrationHelper.createSurfaceBuilder("glowstone_gardens", new GlowstoneGardensSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> TWILIGHT_VALLEY = WorldGenRegistrationHelper.createSurfaceBuilder("twilight_valley", new TwilightValleySB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> ERODED_LUNA = WorldGenRegistrationHelper.createSurfaceBuilder("eroded_luna", new ErodedLunaSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<FillSurfaceBuilderConfig> FILL = WorldGenRegistrationHelper.createSurfaceBuilder("fill", new FillerSurfaceBuilder(FillSurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> BRIMSTONE_CAVERNS = WorldGenRegistrationHelper.createSurfaceBuilder("brimstone_caverns", new BrimstoneCavernsSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> MAGMA_WASTES = WorldGenRegistrationHelper.createSurfaceBuilder("magma_wastes", new MagmaWastesSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> SUBZERO_HYPOGEAL = WorldGenRegistrationHelper.createSurfaceBuilder("subzero_hypogeal", new SubzeroHypogealSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> WITHERING_WOODS = WorldGenRegistrationHelper.createSurfaceBuilder("withering_woods", new WitheringWoodsSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> QUARTZ_DESERT = WorldGenRegistrationHelper.createSurfaceBuilder("quartz_desert", new QuartzDesertSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> WEEPING_MIRE = WorldGenRegistrationHelper.createSurfaceBuilder("weeping_mire", new WeepingMireSB(SurfaceBuilderBaseConfiguration.CODEC));

    //End
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> IVIS_FIELDS = WorldGenRegistrationHelper.createSurfaceBuilder("ivis_fields", new IvisFieldsSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> SHATTERED_DESERT = WorldGenRegistrationHelper.createSurfaceBuilder("shattered_desert", new ShatteredDesertSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> PURPUR_PEAKS = WorldGenRegistrationHelper.createSurfaceBuilder("purpur_peaks", new PurpurPeaksSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> ETHEREAL = WorldGenRegistrationHelper.createSurfaceBuilder("ethereal", new FillEtherealStone(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> CRYPTIC = WorldGenRegistrationHelper.createSurfaceBuilder("cryptic", new FillCrypticStone(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> BULBIS_GARDENS = WorldGenRegistrationHelper.createSurfaceBuilder("bulbis_gardens", new BulbisGardensSB(SurfaceBuilderBaseConfiguration.CODEC));


    public static void init() {
    }

    public static class Configs {
        public static final SurfaceBuilderBaseConfiguration BLACK_SAND = new SurfaceBuilderBaseConfiguration(BYGBlocks.BLACK_SAND.defaultBlockState(), BYGBlocks.BLACK_SAND.defaultBlockState(), BYGBlocks.BLACK_SANDSTONE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration ROCKY_BLACK_SAND = new SurfaceBuilderBaseConfiguration(BYGBlocks.ROCKY_STONE.defaultBlockState(), BYGBlocks.BLACK_SAND.defaultBlockState(), BYGBlocks.BLACK_SANDSTONE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration ROCKY_BLACK_SAND2 = new SurfaceBuilderBaseConfiguration(BYGBlocks.BLACK_SAND.defaultBlockState(), BYGBlocks.ROCKY_STONE.defaultBlockState(), BYGBlocks.BLACK_SANDSTONE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration STONE_BLACK_SAND = new SurfaceBuilderBaseConfiguration(BYGBlocks.BLACK_SAND.defaultBlockState(), Blocks.STONE.defaultBlockState(), BYGBlocks.BLACK_SANDSTONE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration STONE_BLACK_SAND2 = new SurfaceBuilderBaseConfiguration(Blocks.STONE.defaultBlockState(), BYGBlocks.BLACK_SAND.defaultBlockState(), BYGBlocks.BLACK_SANDSTONE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration BLUE_SAND = new SurfaceBuilderBaseConfiguration(BYGBlocks.BLUE_SAND.defaultBlockState(), BYGBlocks.BLUE_SAND.defaultBlockState(), BYGBlocks.BLUE_SANDSTONE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration PINK_SAND = new SurfaceBuilderBaseConfiguration(BYGBlocks.PINK_SAND.defaultBlockState(), BYGBlocks.PINK_SAND.defaultBlockState(), BYGBlocks.PINK_SANDSTONE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration PURPLE_SAND = new SurfaceBuilderBaseConfiguration(BYGBlocks.PURPLE_SAND.defaultBlockState(), BYGBlocks.PURPLE_SAND.defaultBlockState(), BYGBlocks.PURPLE_SANDSTONE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration WHITE_SAND = new SurfaceBuilderBaseConfiguration(BYGBlocks.WHITE_SAND.defaultBlockState(), BYGBlocks.WHITE_SAND.defaultBlockState(), BYGBlocks.WHITE_SANDSTONE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration SAND = new SurfaceBuilderBaseConfiguration(Blocks.SAND.defaultBlockState(), Blocks.SAND.defaultBlockState(), Blocks.SANDSTONE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration ROCKY = new SurfaceBuilderBaseConfiguration(BYGBlocks.ROCKY_STONE.defaultBlockState(), BYGBlocks.ROCKY_STONE.defaultBlockState(), BYGBlocks.ROCKY_STONE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration STONE = new SurfaceBuilderBaseConfiguration(Blocks.STONE.defaultBlockState(), Blocks.STONE.defaultBlockState(), Blocks.STONE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration COARSE = new SurfaceBuilderBaseConfiguration(Blocks.COARSE_DIRT.defaultBlockState(), Blocks.COARSE_DIRT.defaultBlockState(), Blocks.COARSE_DIRT.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration GLOWSTONE_GARDENS = new SurfaceBuilderBaseConfiguration(BYGBlocks.OVERGROWN_NETHERRACK.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration CRIMSON_GARDEN = new SurfaceBuilderBaseConfiguration(BYGBlocks.OVERGROWN_CRIMSON_BLACKSTONE.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), Blocks.NETHER_WART_BLOCK.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration MYCELIUM_NETHERRACK = new SurfaceBuilderBaseConfiguration(BYGBlocks.MYCELIUM_NETHERRACK.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration WARPED_NYLIUM = new SurfaceBuilderBaseConfiguration(Blocks.WARPED_NYLIUM.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration END_SAND = new SurfaceBuilderBaseConfiguration(BYGBlocks.END_SAND.defaultBlockState(), Blocks.END_STONE_BRICKS.defaultBlockState(), Blocks.END_STONE_BRICKS.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration WAILING_NYLIUM = new SurfaceBuilderBaseConfiguration(BYGBlocks.WAILING_NYLIUM.defaultBlockState(), Blocks.SOUL_SOIL.defaultBlockState(), Blocks.SOUL_SOIL.defaultBlockState());

        public static final SurfaceBuilderBaseConfiguration SAND_CF = new SurfaceBuilderBaseConfiguration(Blocks.SAND.defaultBlockState(), Blocks.SAND.defaultBlockState(), Blocks.SAND.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration REDSAND_CF = new SurfaceBuilderBaseConfiguration(Blocks.RED_SAND.defaultBlockState(), Blocks.RED_SAND.defaultBlockState(), Blocks.RED_SAND.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration WARPEDDESERT = new SurfaceBuilderBaseConfiguration(BYGBlocks.NYLIUM_SOUL_SAND.defaultBlockState(), BYGBlocks.NYLIUM_SOUL_SAND.defaultBlockState(), BYGBlocks.NYLIUM_SOUL_SAND.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration SYTHIANTORRIDS = new SurfaceBuilderBaseConfiguration(BYGBlocks.SYTHIAN_NYLIUM.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration WARPEDDESERT_SOIL = new SurfaceBuilderBaseConfiguration(BYGBlocks.NYLIUM_SOUL_SOIL.defaultBlockState(), BYGBlocks.NYLIUM_SOUL_SOIL.defaultBlockState(), BYGBlocks.NYLIUM_SOUL_SOIL.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration EMBURNYLIUM = new SurfaceBuilderBaseConfiguration(BYGBlocks.EMBUR_NYLIUM.defaultBlockState(), BYGBlocks.BLUE_NETHERRACK.defaultBlockState(), BYGBlocks.BLUE_NETHERRACK.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration SOULSAND = new SurfaceBuilderBaseConfiguration(Blocks.SOUL_SAND.defaultBlockState(), Blocks.SOUL_SAND.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration SOUL_SOIL = new SurfaceBuilderBaseConfiguration(Blocks.SOUL_SOIL.defaultBlockState(), Blocks.SOUL_SOIL.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration MAGMATIC_STONE = new SurfaceBuilderBaseConfiguration(BYGBlocks.MAGMATIC_STONE.defaultBlockState(), BYGBlocks.MAGMATIC_STONE.defaultBlockState(), BYGBlocks.MAGMATIC_STONE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration MAGMA_BLOCK = new SurfaceBuilderBaseConfiguration(Blocks.MAGMA_BLOCK.defaultBlockState(), Blocks.MAGMA_BLOCK.defaultBlockState(), Blocks.MAGMA_BLOCK.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration BRIMSTONE = new SurfaceBuilderBaseConfiguration(BYGBlocks.BRIMSTONE.defaultBlockState(), BYGBlocks.BRIMSTONE.defaultBlockState(), BYGBlocks.BRIMSTONE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration FROST_MAGMA = new SurfaceBuilderBaseConfiguration(BYGBlocks.FROST_MAGMA.defaultBlockState(), BYGBlocks.FROST_MAGMA.defaultBlockState(), BYGBlocks.FROST_MAGMA.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration SUBZERO_ASH = new SurfaceBuilderBaseConfiguration(BYGBlocks.SUBZERO_ASH_BLOCK.defaultBlockState(), BYGBlocks.SUBZERO_ASH_BLOCK.defaultBlockState(), BYGBlocks.SUBZERO_ASH_BLOCK.defaultBlockState());


        public static final SurfaceBuilderBaseConfiguration PODZOLDOVERMOUNTAIN_CF = new SurfaceBuilderBaseConfiguration(BYGBlocks.OVERGROWN_DACITE.defaultBlockState(), BYGBlocks.DACITE.defaultBlockState(), BYGBlocks.DACITE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration COARSEDIRTDOVERMOUNTAIN_CF = new SurfaceBuilderBaseConfiguration(Blocks.COARSE_DIRT.defaultBlockState(), BYGBlocks.DACITE.defaultBlockState(), BYGBlocks.DACITE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration GRASSDOVERMOUNTAIN_CF = new SurfaceBuilderBaseConfiguration(BYGBlocks.PODZOL_DACITE.defaultBlockState(), BYGBlocks.DACITE.defaultBlockState(), BYGBlocks.DACITE.defaultBlockState());

        public static final SurfaceBuilderBaseConfiguration AIR_CF = new SurfaceBuilderBaseConfiguration(Blocks.AIR.defaultBlockState(), Blocks.AIR.defaultBlockState(), Blocks.AIR.defaultBlockState());

        public static final SurfaceBuilderBaseConfiguration QUAGMIREPEAT_SB = new SurfaceBuilderBaseConfiguration(BYGBlocks.PEAT.defaultBlockState(), BYGBlocks.MUD_BLOCK.defaultBlockState(), BYGBlocks.MUD_BLOCK.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration QUAGMIREMUD_CF = new SurfaceBuilderBaseConfiguration(BYGBlocks.MUD_BLOCK.defaultBlockState(), BYGBlocks.MUD_BRICKS.defaultBlockState(), BYGBlocks.MUD_BLOCK.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration GRASSMOUNTAIN_CF = new SurfaceBuilderBaseConfiguration(Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.STONE.defaultBlockState(), Blocks.STONE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration PEATGRASS_CF = new SurfaceBuilderBaseConfiguration(BYGBlocks.PEAT.defaultBlockState(), Blocks.DIRT.defaultBlockState(), Blocks.DIRT.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration MUD_CF = new SurfaceBuilderBaseConfiguration(BYGBlocks.MUD_BLOCK.defaultBlockState(), BYGBlocks.MUD_BLOCK.defaultBlockState(), BYGBlocks.MUD_BLOCK.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration TERRACOTTA_CF = new SurfaceBuilderBaseConfiguration(Blocks.TERRACOTTA.defaultBlockState(), Blocks.TERRACOTTA.defaultBlockState(), Blocks.TERRACOTTA.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration GLOWCELIUM_CF = new SurfaceBuilderBaseConfiguration(BYGBlocks.GLOWCELIUM.defaultBlockState(), Blocks.DIRT.defaultBlockState(), Blocks.DIRT.defaultBlockState());

        public static final SurfaceBuilderBaseConfiguration GREEN_CONCRETE_POWDER_CF = new SurfaceBuilderBaseConfiguration(BYGBlocks.OVERGROWN_STONE.defaultBlockState(), BYGBlocks.MOSSY_STONE.defaultBlockState(), Blocks.STONE.defaultBlockState());

        public static final SurfaceBuilderBaseConfiguration RED_ROCK_CF = new SurfaceBuilderBaseConfiguration(BYGBlocks.RED_ROCK.defaultBlockState(), BYGBlocks.RED_ROCK.defaultBlockState(), BYGBlocks.RED_ROCK.defaultBlockState());

        public static final SurfaceBuilderBaseConfiguration BULBIS_PHYCELIUM_CF = new SurfaceBuilderBaseConfiguration(BYGBlocks.BULBIS_PHYCELIUM.defaultBlockState(), Blocks.END_STONE.defaultBlockState(), Blocks.END_STONE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration IVIS_CF = new SurfaceBuilderBaseConfiguration(BYGBlocks.IVIS_PHYLIUM.defaultBlockState(), Blocks.END_STONE.defaultBlockState(), Blocks.END_STONE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration END = new SurfaceBuilderBaseConfiguration(Blocks.END_STONE.defaultBlockState(), Blocks.END_STONE.defaultBlockState(), Blocks.END_STONE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration MYCELIUM = new SurfaceBuilderBaseConfiguration(Blocks.MYCELIUM.defaultBlockState(), Blocks.DIRT.defaultBlockState(), Blocks.DIRT.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration ETHER = new SurfaceBuilderBaseConfiguration(BYGBlocks.ETHER_PHYLIUM.defaultBlockState(), BYGBlocks.ETHER_SOIL.defaultBlockState(), BYGBlocks.ETHER_STONE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration NIGHTSHADE = new SurfaceBuilderBaseConfiguration(BYGBlocks.NIGHTSHADE_PHYLIUM.defaultBlockState(), Blocks.END_STONE.defaultBlockState(), Blocks.END_STONE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration SCULK = new SurfaceBuilderBaseConfiguration(BYGBlocks.VERMILION_SCULK.defaultBlockState(), BYGBlocks.ETHER_STONE.defaultBlockState(), BYGBlocks.ETHER_STONE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration SHULKREN = new SurfaceBuilderBaseConfiguration(BYGBlocks.SHULKREN_PHYLIUM.defaultBlockState(), Blocks.END_STONE.defaultBlockState(), Blocks.END_STONE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration CRYPTIC = new SurfaceBuilderBaseConfiguration(BYGBlocks.CRYPTIC_STONE.defaultBlockState(), BYGBlocks.CRYPTIC_STONE.defaultBlockState(), BYGBlocks.CRYPTIC_STONE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration CRYPTIC_MAGMA = new SurfaceBuilderBaseConfiguration(BYGBlocks.CRYPTIC_MAGMA_BLOCK.defaultBlockState(), BYGBlocks.CRYPTIC_MAGMA_BLOCK.defaultBlockState(), BYGBlocks.CRYPTIC_MAGMA_BLOCK.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration IMPARIUS = new SurfaceBuilderBaseConfiguration(BYGBlocks.IMPARIUS_PHYLIUM.defaultBlockState(), Blocks.END_STONE.defaultBlockState(), Blocks.END_STONE.defaultBlockState());

        public static final SurfaceBuilderBaseConfiguration SNOW_CF = new SurfaceBuilderBaseConfiguration(Blocks.SNOW_BLOCK.defaultBlockState(), Blocks.SNOW_BLOCK.defaultBlockState(), Blocks.SNOW_BLOCK.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration PACKED_ICE_CF = new SurfaceBuilderBaseConfiguration(Blocks.PACKED_ICE.defaultBlockState(), Blocks.PACKED_ICE.defaultBlockState(), Blocks.PACKED_ICE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration BLUE_ICE_CF = new SurfaceBuilderBaseConfiguration(Blocks.BLUE_ICE.defaultBlockState(), Blocks.BLUE_ICE.defaultBlockState(), Blocks.BLUE_ICE.defaultBlockState());

    }
}
