package voronoiaoc.byg.core.byglists;

import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.common.world.surfacebuilders.*;

public class BYGSBList {
    public static final SurfaceBuilder<SurfaceBuilderConfig> BOREAL_SB = newSurfaceBuilder("boreal", new BorealForestSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> CONIFEROUS_SB = newSurfaceBuilder("coniferous", new ConiferousForestSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> SHATTEREDGLACIER_SB2 = newSurfaceBuilder("shattered_glacier", new ShatteredGlacierSB2(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> MARSHLAND_SB = newSurfaceBuilder("marshland", new MarshlandSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> GREAT_LAKES_SB = newSurfaceBuilder("great_lakes", new GreatLakeSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> GREAT_LAKE_ISLE_SB = newSurfaceBuilder("great_lakes_isles", new GreatLakeIsleSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> ERODED_SIERRA_SB = newSurfaceBuilder("eroded_sierra", new ErodedSierraSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> SIERRA_VALLEY_SB = newSurfaceBuilder("sierra_valley", new SierraValleySB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> GLOWSHROOM_BAYOU_SB = newSurfaceBuilder("glowshroom_bayou", new GlowShroomBayouSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> CRAG_GARDENS = newSurfaceBuilder("crag_gardens", new CragGardensSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> RED_ROCK_SB = newSurfaceBuilder("red_rock", new RedRockSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> RED_ROCKLOWLAND_SB = newSurfaceBuilder("red_rock_lowlands", new RedRockLowlandsSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> REDDUNES_SB = newSurfaceBuilder("red_dunes", new RedDunesSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> DUNES_SB = newSurfaceBuilder("dunes", new DunesSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> DOVER_SB = newSurfaceBuilder("dover_mountains", new DoverMountainSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> QUAGMIRE_SB = newSurfaceBuilder("quagmire", new QuagmireSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> CANYONS = newSurfaceBuilder("canyons", new CanyonSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> MOJAVE = newSurfaceBuilder("mojave", new MojaveSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> LUSH_TUNDRA_SB = newSurfaceBuilder("lush_tundra", new LushTundraSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> FUNGAL_RAINFOREST_SB = newSurfaceBuilder("fungal_rainforest", new FungalRainforestSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> EBONY_SB = newSurfaceBuilder("ebony_woods", new EbonyWoodsSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> GLOWING_ANCIENT_FOREST_SB = newSurfaceBuilder("glowing_ancient_forest", new GlowingAncientForestSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> EMBURBOG = newSurfaceBuilder("embur_bog", new EmburBogSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> ROCKYBLACKBEACH_SB = newSurfaceBuilder("rocky_black_beach", new RockyBlackBeachSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> RAINBOWBEACH_SB = newSurfaceBuilder("rainbow_beach", new RainbowBeachSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> ROCKYBEACH_SB = newSurfaceBuilder("rocky_beach", new RockyBeachSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> WARPEDDESERT_SB = newSurfaceBuilder("warped_desert", new WarpedDesertSB(SurfaceBuilderConfig.field_237203_a_));

    //End
    public static final SurfaceBuilder<SurfaceBuilderConfig> IVISFIELDS_SB = newSurfaceBuilder("ivis_fields", new IvisFieldsSB(SurfaceBuilderConfig.field_237203_a_));

    public static SurfaceBuilder<SurfaceBuilderConfig> newSurfaceBuilder(String id, SurfaceBuilder<SurfaceBuilderConfig> surfaceBuilder) {
        Registry.register(Registry.SURFACE_BUILDER, new ResourceLocation(BYG.MOD_ID, id), surfaceBuilder);
        return surfaceBuilder;
    }

    public static class BYGSBConfigList {
        public static final SurfaceBuilderConfig BLACKSAND = new SurfaceBuilderConfig(BYGBlockList.BLACK_SAND.getDefaultState(), BYGBlockList.BLACK_SAND.getDefaultState(), BYGBlockList.BLACK_SAND.getDefaultState());
        public static final SurfaceBuilderConfig ROCKYBLACKSAND = new SurfaceBuilderConfig(BYGBlockList.ROCKY_STONE.getDefaultState(), BYGBlockList.BLACK_SAND.getDefaultState(), BYGBlockList.BLACK_SAND.getDefaultState());
        public static final SurfaceBuilderConfig ROCKYBLACKSAND2 = new SurfaceBuilderConfig(BYGBlockList.BLACK_SAND.getDefaultState(), BYGBlockList.ROCKY_STONE.getDefaultState(), BYGBlockList.BLACK_SAND.getDefaultState());
        public static final SurfaceBuilderConfig STONEBLACKSAND = new SurfaceBuilderConfig(BYGBlockList.BLACK_SAND.getDefaultState(), Blocks.STONE.getDefaultState(), BYGBlockList.BLACK_SAND.getDefaultState());
        public static final SurfaceBuilderConfig STONEBLACKSAND2 = new SurfaceBuilderConfig(Blocks.STONE.getDefaultState(), BYGBlockList.BLACK_SAND.getDefaultState(), BYGBlockList.BLACK_SAND.getDefaultState());
        public static final SurfaceBuilderConfig BLUESAND_SB = new SurfaceBuilderConfig(BYGBlockList.BLUE_SAND.getDefaultState(), BYGBlockList.BLUE_SAND.getDefaultState(), BYGBlockList.BLUE_SAND.getDefaultState());
        public static final SurfaceBuilderConfig PINKSAND_SB = new SurfaceBuilderConfig(BYGBlockList.PINK_SAND.getDefaultState(), BYGBlockList.PINK_SAND.getDefaultState(), BYGBlockList.PINK_SAND.getDefaultState());
        public static final SurfaceBuilderConfig PURPLESAND_SB = new SurfaceBuilderConfig(BYGBlockList.PURPLE_SAND.getDefaultState(), BYGBlockList.PURPLE_SAND.getDefaultState(), BYGBlockList.PURPLE_SAND.getDefaultState());
        public static final SurfaceBuilderConfig WHITESAND = new SurfaceBuilderConfig(BYGBlockList.WHITE_SAND.getDefaultState(), BYGBlockList.WHITE_SAND.getDefaultState(), BYGBlockList.WHITE_SAND.getDefaultState());
        public static final SurfaceBuilderConfig ROCKYSAND = new SurfaceBuilderConfig(BYGBlockList.ROCKY_STONE.getDefaultState(), Blocks.SAND.getDefaultState(), Blocks.SAND.getDefaultState());
        public static final SurfaceBuilderConfig ROCKYSAND2 = new SurfaceBuilderConfig(Blocks.SAND.getDefaultState(), BYGBlockList.ROCKY_STONE.getDefaultState(), Blocks.SAND.getDefaultState());
        public static final SurfaceBuilderConfig ROCKYSAND3 = new SurfaceBuilderConfig(Blocks.SAND.getDefaultState(), BYGBlockList.ROCKY_STONE.getDefaultState(), BYGBlockList.ROCKY_STONE.getDefaultState());
        public static final SurfaceBuilderConfig STONESAND = new SurfaceBuilderConfig(Blocks.STONE.getDefaultState(), Blocks.SAND.getDefaultState(), Blocks.SAND.getDefaultState());
        public static final SurfaceBuilderConfig STONESAND2 = new SurfaceBuilderConfig(Blocks.SAND.getDefaultState(), Blocks.STONE.getDefaultState(), Blocks.SAND.getDefaultState());
        public static final SurfaceBuilderConfig STONESAND3 = new SurfaceBuilderConfig(Blocks.SAND.getDefaultState(), Blocks.STONE.getDefaultState(), Blocks.STONE.getDefaultState());
        public static final SurfaceBuilderConfig SAND = new SurfaceBuilderConfig(Blocks.SAND.getDefaultState(), Blocks.SAND.getDefaultState(), Blocks.SAND.getDefaultState());
        public static final SurfaceBuilderConfig ROCKY = new SurfaceBuilderConfig(BYGBlockList.ROCKY_STONE.getDefaultState(), BYGBlockList.ROCKY_STONE.getDefaultState(), BYGBlockList.ROCKY_STONE.getDefaultState());
        public static final SurfaceBuilderConfig STONE = new SurfaceBuilderConfig(Blocks.STONE.getDefaultState(), Blocks.STONE.getDefaultState(), Blocks.STONE.getDefaultState());
        public static final SurfaceBuilderConfig COARSE = new SurfaceBuilderConfig(Blocks.COARSE_DIRT.getDefaultState(), Blocks.COARSE_DIRT.getDefaultState(), Blocks.COARSE_DIRT.getDefaultState());
        public static final SurfaceBuilderConfig GLOWSTONEGARDENS = new SurfaceBuilderConfig(BYGBlockList.OVERGROWN_NETHERRACK.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), Blocks.NETHERRACK.getDefaultState());


        public static final SurfaceBuilderConfig SAND_CF = new SurfaceBuilderConfig(Blocks.SAND.getDefaultState(), Blocks.SAND.getDefaultState(), Blocks.SAND.getDefaultState());
        public static final SurfaceBuilderConfig REDSAND_CF = new SurfaceBuilderConfig(Blocks.RED_SAND.getDefaultState(), Blocks.RED_SAND.getDefaultState(), Blocks.RED_SAND.getDefaultState());
        public static final SurfaceBuilderConfig WARPEDDESERT = new SurfaceBuilderConfig(BYGBlockList.NYLIUM_SOUL_SAND.getDefaultState(), BYGBlockList.NYLIUM_SOUL_SAND.getDefaultState(), BYGBlockList.NYLIUM_SOUL_SAND.getDefaultState());
        public static final SurfaceBuilderConfig SYTHIANTORRIDS = new SurfaceBuilderConfig(BYGBlockList.SYTHIAN_NYLIUM.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), Blocks.NETHERRACK.getDefaultState());
        public static final SurfaceBuilderConfig WARPEDDESERT_SOIL = new SurfaceBuilderConfig(BYGBlockList.NYLIUM_SOUL_SOIL.getDefaultState(), BYGBlockList.NYLIUM_SOUL_SOIL.getDefaultState(), BYGBlockList.NYLIUM_SOUL_SOIL.getDefaultState());
        public static final SurfaceBuilderConfig EMBURNYLIUM = new SurfaceBuilderConfig(BYGBlockList.EMBUR_NYLIUM.getDefaultState(), BYGBlockList.BLUE_NETHERRACK.getDefaultState(), BYGBlockList.BLUE_NETHERRACK.getDefaultState());


        public static final SurfaceBuilderConfig PODZOLDOVERMOUNTAIN_CF = new SurfaceBuilderConfig(BYGBlockList.OVERGROWN_DACITE.getDefaultState(), BYGBlockList.DACITE.getDefaultState(), BYGBlockList.DACITE.getDefaultState());
        public static final SurfaceBuilderConfig COARSEDIRTDOVERMOUNTAIN_CF = new SurfaceBuilderConfig(Blocks.COARSE_DIRT.getDefaultState(), BYGBlockList.DACITE.getDefaultState(), BYGBlockList.DACITE.getDefaultState());
        public static final SurfaceBuilderConfig GRASSDOVERMOUNTAIN_CF = new SurfaceBuilderConfig(BYGBlockList.PODZOL_DACITE.getDefaultState(), BYGBlockList.DACITE.getDefaultState(), BYGBlockList.DACITE.getDefaultState());

        public static final SurfaceBuilderConfig AIR_CF = new SurfaceBuilderConfig(Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState());

        public static final SurfaceBuilderConfig QUAGMIREPEAT_SB = new SurfaceBuilderConfig(BYGBlockList.PEAT.getDefaultState(), BYGBlockList.MUD_BLOCK.getDefaultState(), BYGBlockList.MUD_BLOCK.getDefaultState());
        public static final SurfaceBuilderConfig QUAGMIREMUD_CF = new SurfaceBuilderConfig(BYGBlockList.MUD_BLOCK.getDefaultState(), BYGBlockList.MUD_BRICKS.getDefaultState(), BYGBlockList.MUD_BLOCK.getDefaultState());
        public static final SurfaceBuilderConfig GRASSMOUNTAIN_CF = new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.STONE.getDefaultState(), Blocks.STONE.getDefaultState());
        public static final SurfaceBuilderConfig PEATGRASS_CF = new SurfaceBuilderConfig(BYGBlockList.PEAT.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState());
        public static final SurfaceBuilderConfig MUD_CF = new SurfaceBuilderConfig(BYGBlockList.MUD_BLOCK.getDefaultState(), BYGBlockList.MUD_BLOCK.getDefaultState(), BYGBlockList.MUD_BLOCK.getDefaultState());
        public static final SurfaceBuilderConfig TERRACOTTA_CF = new SurfaceBuilderConfig(Blocks.TERRACOTTA.getDefaultState(), Blocks.TERRACOTTA.getDefaultState(), Blocks.TERRACOTTA.getDefaultState());
        public static final SurfaceBuilderConfig GLOWCELIUM_CF = new SurfaceBuilderConfig(BYGBlockList.GLOWCELIUM.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState());

        public static final SurfaceBuilderConfig GREEN_CONCRETE_POWDER_CF = new SurfaceBuilderConfig(BYGBlockList.OVERGROWN_STONE.getDefaultState(), BYGBlockList.MOSSY_STONE.getDefaultState(), Blocks.STONE.getDefaultState());

        public static final SurfaceBuilderConfig RED_ROCK_CF = new SurfaceBuilderConfig(BYGBlockList.RED_ROCK.getDefaultState(), BYGBlockList.RED_ROCK.getDefaultState(), BYGBlockList.RED_ROCK.getDefaultState());

        public static final SurfaceBuilderConfig IVIS_CF = new SurfaceBuilderConfig(BYGBlockList.IVIS_PHYLIUM.getDefaultState(), Blocks.END_STONE.getDefaultState(), Blocks.END_STONE.getDefaultState());
        public static final SurfaceBuilderConfig END = new SurfaceBuilderConfig(Blocks.END_STONE.getDefaultState(), Blocks.END_STONE.getDefaultState(), Blocks.END_STONE.getDefaultState());
        public static final SurfaceBuilderConfig MYCELIUM = new SurfaceBuilderConfig(Blocks.MYCELIUM.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState());

    }
}
