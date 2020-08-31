package voronoiaoc.byg.core.byglists;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.common.world.surfacebuilders.*;

public class BYGSBList {
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> BOREAL_SB = newSurfaceBuilder("boreal", new BorealForestSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> CONIFEROUS_SB = newSurfaceBuilder("coniferous", new ConiferousForestSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> SHATTEREDGLACIER_SB2 = newSurfaceBuilder("shattered_glacier", new ShatteredGlacierSB2(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> MARSHLAND_SB = newSurfaceBuilder("marshland", new MarshlandSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> GREAT_LAKES_SB = newSurfaceBuilder("great_lakes", new GreatLakeSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> GREAT_LAKE_ISLE_SB = newSurfaceBuilder("great_lakes_isles", new GreatLakeIsleSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> ERODED_SIERRA_SB = newSurfaceBuilder("eroded_sierra", new ErodedSierraSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> SIERRA_VALLEY_SB = newSurfaceBuilder("sierra_valley", new SierraValleySB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> GLOWSHROOM_BAYOU_SB = newSurfaceBuilder("glowshroom_bayou", new GlowShroomBayouSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> CRAG_GARDENS = newSurfaceBuilder("crag_gardens", new CragGardens(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> RED_ROCK_SB = newSurfaceBuilder("red_rock", new RedRockSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> RED_ROCKLOWLAND_SB = newSurfaceBuilder("red_rock_lowlands", new RedRockLowlandsSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> REDDUNES_SB = newSurfaceBuilder("red_dunes", new RedDunesSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> DUNES_SB = newSurfaceBuilder("dunes", new DunesSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> DOVER_SB = newSurfaceBuilder("dover_mountains", new DoverMountainSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> QUAGMIRE_SB = newSurfaceBuilder("quagmire", new QuagmireSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> CANYONS = newSurfaceBuilder("canyons", new CanyonSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> MOJAVE = newSurfaceBuilder("mojave", new MojaveSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> LUSH_TUNDRA_SB = newSurfaceBuilder("lush_tundra", new LushTundraSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> FUNGAL_RAINFOREST_SB = newSurfaceBuilder("fungal_rainforest", new FungalRainforestSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> EBONY_SB = newSurfaceBuilder("ebony_woods", new EbonyWoodsSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> GLOWING_ANCIENT_FOREST_SB = newSurfaceBuilder("glowing_ancient_forest", new GlowingAncientForestSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> EMBURBOG = newSurfaceBuilder("embur_bog", new EmburBogSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> ROCKYBLACKBEACH_SB = newSurfaceBuilder("rocky_black_beach", new RockyBlackBeachSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> RAINBOWBEACH_SB = newSurfaceBuilder("rainbow_beach", new RainbowBeachSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> ROCKYBEACH_SB = newSurfaceBuilder("rocky_beach", new RockyBeachSB(SurfaceBuilderBaseConfiguration.CODEC));
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> WARPEDDESERT_SB = newSurfaceBuilder("warped_desert", new WarpedDesertSB(SurfaceBuilderBaseConfiguration.CODEC));

    //End
    public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> IVISFIELDS_SB = newSurfaceBuilder("ivis_fields", new IvisFieldsSB(SurfaceBuilderBaseConfiguration.CODEC));

    public static SurfaceBuilder<SurfaceBuilderBaseConfiguration> newSurfaceBuilder(String id, SurfaceBuilder<SurfaceBuilderBaseConfiguration> surfaceBuilder) {
        Registry.register(Registry.SURFACE_BUILDER, new ResourceLocation(BYG.MODID, id), surfaceBuilder);
        return surfaceBuilder;
    }

    public static class BYGSBConfigList {
        public static final SurfaceBuilderBaseConfiguration BLACKSAND = new SurfaceBuilderBaseConfiguration(BYGBlockList.BLACK_SAND.defaultBlockState(), BYGBlockList.BLACK_SAND.defaultBlockState(), BYGBlockList.BLACK_SAND.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration ROCKYBLACKSAND = new SurfaceBuilderBaseConfiguration(BYGBlockList.ROCKY_STONE.defaultBlockState(), BYGBlockList.BLACK_SAND.defaultBlockState(), BYGBlockList.BLACK_SAND.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration ROCKYBLACKSAND2 = new SurfaceBuilderBaseConfiguration(BYGBlockList.BLACK_SAND.defaultBlockState(), BYGBlockList.ROCKY_STONE.defaultBlockState(), BYGBlockList.BLACK_SAND.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration STONEBLACKSAND = new SurfaceBuilderBaseConfiguration(BYGBlockList.BLACK_SAND.defaultBlockState(), Blocks.STONE.defaultBlockState(), BYGBlockList.BLACK_SAND.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration STONEBLACKSAND2 = new SurfaceBuilderBaseConfiguration(Blocks.STONE.defaultBlockState(), BYGBlockList.BLACK_SAND.defaultBlockState(), BYGBlockList.BLACK_SAND.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration BLUESAND_SB = new SurfaceBuilderBaseConfiguration(BYGBlockList.BLUE_SAND.defaultBlockState(), BYGBlockList.BLUE_SAND.defaultBlockState(), BYGBlockList.BLUE_SAND.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration PINKSAND_SB = new SurfaceBuilderBaseConfiguration(BYGBlockList.PINK_SAND.defaultBlockState(), BYGBlockList.PINK_SAND.defaultBlockState(), BYGBlockList.PINK_SAND.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration PURPLESAND_SB = new SurfaceBuilderBaseConfiguration(BYGBlockList.PURPLE_SAND.defaultBlockState(), BYGBlockList.PURPLE_SAND.defaultBlockState(), BYGBlockList.PURPLE_SAND.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration WHITESAND = new SurfaceBuilderBaseConfiguration(BYGBlockList.WHITE_SAND.defaultBlockState(), BYGBlockList.WHITE_SAND.defaultBlockState(), BYGBlockList.WHITE_SAND.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration ROCKYSAND = new SurfaceBuilderBaseConfiguration(BYGBlockList.ROCKY_STONE.defaultBlockState(), Blocks.SAND.defaultBlockState(), Blocks.SAND.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration ROCKYSAND2 = new SurfaceBuilderBaseConfiguration(Blocks.SAND.defaultBlockState(), BYGBlockList.ROCKY_STONE.defaultBlockState(), Blocks.SAND.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration ROCKYSAND3 = new SurfaceBuilderBaseConfiguration(Blocks.SAND.defaultBlockState(), BYGBlockList.ROCKY_STONE.defaultBlockState(), BYGBlockList.ROCKY_STONE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration STONESAND = new SurfaceBuilderBaseConfiguration(Blocks.STONE.defaultBlockState(), Blocks.SAND.defaultBlockState(), Blocks.SAND.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration STONESAND2 = new SurfaceBuilderBaseConfiguration(Blocks.SAND.defaultBlockState(), Blocks.STONE.defaultBlockState(), Blocks.SAND.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration STONESAND3 = new SurfaceBuilderBaseConfiguration(Blocks.SAND.defaultBlockState(), Blocks.STONE.defaultBlockState(), Blocks.STONE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration SAND = new SurfaceBuilderBaseConfiguration(Blocks.SAND.defaultBlockState(), Blocks.SAND.defaultBlockState(), Blocks.SAND.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration ROCKY = new SurfaceBuilderBaseConfiguration(BYGBlockList.ROCKY_STONE.defaultBlockState(), BYGBlockList.ROCKY_STONE.defaultBlockState(), BYGBlockList.ROCKY_STONE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration STONE = new SurfaceBuilderBaseConfiguration(Blocks.STONE.defaultBlockState(), Blocks.STONE.defaultBlockState(), Blocks.STONE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration COARSE = new SurfaceBuilderBaseConfiguration(Blocks.COARSE_DIRT.defaultBlockState(), Blocks.COARSE_DIRT.defaultBlockState(), Blocks.COARSE_DIRT.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration GLOWSTONEGARDENS = new SurfaceBuilderBaseConfiguration(BYGBlockList.OVERGROWN_NETHERRACK.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState());


        public static final SurfaceBuilderBaseConfiguration SAND_CF = new SurfaceBuilderBaseConfiguration(Blocks.SAND.defaultBlockState(), Blocks.SAND.defaultBlockState(), Blocks.SAND.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration REDSAND_CF = new SurfaceBuilderBaseConfiguration(Blocks.RED_SAND.defaultBlockState(), Blocks.RED_SAND.defaultBlockState(), Blocks.RED_SAND.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration WARPEDDESERT = new SurfaceBuilderBaseConfiguration(BYGBlockList.NYLIUM_SOUL_SAND.defaultBlockState(), BYGBlockList.NYLIUM_SOUL_SAND.defaultBlockState(), BYGBlockList.NYLIUM_SOUL_SAND.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration SYTHIANTORRIDS = new SurfaceBuilderBaseConfiguration(BYGBlockList.SYTHIAN_NYLIUM.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration WARPEDDESERT_SOIL = new SurfaceBuilderBaseConfiguration(BYGBlockList.NYLIUM_SOUL_SOIL.defaultBlockState(), BYGBlockList.NYLIUM_SOUL_SOIL.defaultBlockState(), BYGBlockList.NYLIUM_SOUL_SOIL.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration EMBURNYLIUM = new SurfaceBuilderBaseConfiguration(BYGBlockList.EMBUR_NYLIUM.defaultBlockState(), BYGBlockList.BLUE_NETHERRACK.defaultBlockState(), BYGBlockList.BLUE_NETHERRACK.defaultBlockState());


        public static final SurfaceBuilderBaseConfiguration PODZOLDOVERMOUNTAIN_CF = new SurfaceBuilderBaseConfiguration(BYGBlockList.OVERGROWN_DACITE.defaultBlockState(), BYGBlockList.DACITE.defaultBlockState(), BYGBlockList.DACITE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration COARSEDIRTDOVERMOUNTAIN_CF = new SurfaceBuilderBaseConfiguration(Blocks.COARSE_DIRT.defaultBlockState(), BYGBlockList.DACITE.defaultBlockState(), BYGBlockList.DACITE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration GRASSDOVERMOUNTAIN_CF = new SurfaceBuilderBaseConfiguration(BYGBlockList.PODZOL_DACITE.defaultBlockState(), BYGBlockList.DACITE.defaultBlockState(), BYGBlockList.DACITE.defaultBlockState());

        public static final SurfaceBuilderBaseConfiguration AIR_CF = new SurfaceBuilderBaseConfiguration(Blocks.AIR.defaultBlockState(), Blocks.AIR.defaultBlockState(), Blocks.AIR.defaultBlockState());

        public static final SurfaceBuilderBaseConfiguration QUAGMIREPEAT_SB = new SurfaceBuilderBaseConfiguration(BYGBlockList.PEAT.defaultBlockState(), BYGBlockList.MUD_BLOCK.defaultBlockState(), BYGBlockList.MUD_BLOCK.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration QUAGMIREMUD_CF = new SurfaceBuilderBaseConfiguration(BYGBlockList.MUD_BLOCK.defaultBlockState(), BYGBlockList.MUD_BRICKS.defaultBlockState(), BYGBlockList.MUD_BLOCK.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration GRASSMOUNTAIN_CF = new SurfaceBuilderBaseConfiguration(Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.STONE.defaultBlockState(), Blocks.STONE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration PEATGRASS_CF = new SurfaceBuilderBaseConfiguration(BYGBlockList.PEAT.defaultBlockState(), Blocks.DIRT.defaultBlockState(), Blocks.DIRT.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration MUD_CF = new SurfaceBuilderBaseConfiguration(BYGBlockList.MUD_BLOCK.defaultBlockState(), BYGBlockList.MUD_BLOCK.defaultBlockState(), BYGBlockList.MUD_BLOCK.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration TERRACOTTA_CF = new SurfaceBuilderBaseConfiguration(Blocks.TERRACOTTA.defaultBlockState(), Blocks.TERRACOTTA.defaultBlockState(), Blocks.TERRACOTTA.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration GLOWCELIUM_CF = new SurfaceBuilderBaseConfiguration(BYGBlockList.GLOWCELIUM.defaultBlockState(), Blocks.DIRT.defaultBlockState(), Blocks.DIRT.defaultBlockState());

        public static final SurfaceBuilderBaseConfiguration GREEN_CONCRETE_POWDER_CF = new SurfaceBuilderBaseConfiguration(BYGBlockList.OVERGROWN_STONE.defaultBlockState(), BYGBlockList.MOSSY_STONE.defaultBlockState(), Blocks.STONE.defaultBlockState());

        public static final SurfaceBuilderBaseConfiguration RED_ROCK_CF = new SurfaceBuilderBaseConfiguration(BYGBlockList.RED_ROCK.defaultBlockState(), BYGBlockList.RED_ROCK.defaultBlockState(), BYGBlockList.RED_ROCK.defaultBlockState());

        public static final SurfaceBuilderBaseConfiguration IVIS_CF = new SurfaceBuilderBaseConfiguration(BYGBlockList.IVIS_PHYLIUM.defaultBlockState(), Blocks.END_STONE.defaultBlockState(), Blocks.END_STONE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration END = new SurfaceBuilderBaseConfiguration(Blocks.END_STONE.defaultBlockState(), Blocks.END_STONE.defaultBlockState(), Blocks.END_STONE.defaultBlockState());
        public static final SurfaceBuilderBaseConfiguration MYCELIUM = new SurfaceBuilderBaseConfiguration(Blocks.MYCELIUM.defaultBlockState(), Blocks.DIRT.defaultBlockState(), Blocks.DIRT.defaultBlockState());

    }
}
