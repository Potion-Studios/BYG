package voronoiaoc.byg.core.byglists;

import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import voronoiaoc.byg.common.world.surfacebuilders.*;

public class BYGSBList {
    public static final SurfaceBuilder<SurfaceBuilderConfig> BOREAL_SB = new BorealForestSB(SurfaceBuilderConfig::deserialize);
    public static final SurfaceBuilder<SurfaceBuilderConfig> CONIFEROUS_SB = new ConiferousForestSB(SurfaceBuilderConfig::deserialize);
    public static final SurfaceBuilder<SurfaceBuilderConfig> SHATTEREDGLACIER_SB2 = new ShatteredGlacierSB2(SurfaceBuilderConfig::deserialize);
    public static final SurfaceBuilder<SurfaceBuilderConfig> MARSHLAND_SB = new MarshlandSB(SurfaceBuilderConfig::deserialize);
    public static final SurfaceBuilder<SurfaceBuilderConfig> GREAT_LAKES_SB = new GreatLakeSB(SurfaceBuilderConfig::deserialize);
    public static final SurfaceBuilder<SurfaceBuilderConfig> GREAT_LAKE_ISLE_SB = new GreatLakeIsleSB(SurfaceBuilderConfig::deserialize);
    public static final SurfaceBuilder<SurfaceBuilderConfig> LUSH_TUNDRA_SB = new LushTundraSB(SurfaceBuilderConfig::deserialize);
    public static final SurfaceBuilder<SurfaceBuilderConfig> ERODED_SIERRA_SB = new ErodedSierraSB(SurfaceBuilderConfig::deserialize);
    public static final SurfaceBuilder<SurfaceBuilderConfig> SIERRA_VALLEY_SB = new SierraValleySB(SurfaceBuilderConfig::deserialize);
    public static final SurfaceBuilder<SurfaceBuilderConfig> GLOWSHROOM_BAYOU_SB = new GlowShroomBayouSB(SurfaceBuilderConfig::deserialize);
    public static final SurfaceBuilder<SurfaceBuilderConfig> SLUICE_SB = new CragGardensSB(SurfaceBuilderConfig::deserialize);
    public static final SurfaceBuilder<SurfaceBuilderConfig> RED_ROCK_SB = new RedRockSB(SurfaceBuilderConfig::deserialize);
    public static final SurfaceBuilder<SurfaceBuilderConfig> RED_ROCKLOWLAND_SB = new RedRockLowlandsSB(SurfaceBuilderConfig::deserialize);
    public static final SurfaceBuilder<SurfaceBuilderConfig> REDDUNES_SB = new RedDunesSB(SurfaceBuilderConfig::deserialize);
    public static final SurfaceBuilder<SurfaceBuilderConfig> DUNES_SB = new DunesSB(SurfaceBuilderConfig::deserialize);
    public static final SurfaceBuilder<SurfaceBuilderConfig> DOVER_SB = new DoverMountainSB(SurfaceBuilderConfig::deserialize);
    public static final SurfaceBuilder<SurfaceBuilderConfig> QUAGMIRE_SB = new QuagmireSB(SurfaceBuilderConfig::deserialize);
    public static final SurfaceBuilder<SurfaceBuilderConfig> CANYONS = new CanyonSB(SurfaceBuilderConfig::deserialize);
    public static final SurfaceBuilder<SurfaceBuilderConfig> MOJAVE = new MojaveSB(SurfaceBuilderConfig::deserialize);
    public static final SurfaceBuilder<SurfaceBuilderConfig> SUB = new SubterraneanCave(SurfaceBuilderConfig::deserialize);
    public static final SurfaceBuilder<SurfaceBuilderConfig> VOLCANO = new VolcanoSB(SurfaceBuilderConfig::deserialize);
    public static final SurfaceBuilder<SurfaceBuilderConfig> EBONY_SB = new EbonyWoodsSB(SurfaceBuilderConfig::deserialize);
    public static final SurfaceBuilder<SurfaceBuilderConfig> FUNGAL_RAINFOREST_SB = new FungalRainforestSB(SurfaceBuilderConfig::deserialize);
    public static final SurfaceBuilder<SurfaceBuilderConfig> GLOWING_ANCIENT_FOREST_SB = new GlowingAncientForestSB(SurfaceBuilderConfig::deserialize);

    //Beaches
    public static final SurfaceBuilder<SurfaceBuilderConfig> ROCKYBLACKBEACH_SB = new RockyBlackBeachSB(SurfaceBuilderConfig::deserialize);
    public static final SurfaceBuilder<SurfaceBuilderConfig> RAINBOWBEACH_SB = new RainbowBeachSB(SurfaceBuilderConfig::deserialize);
    public static final SurfaceBuilder<SurfaceBuilderConfig> ROCKYBEACH_SB = new RockyBeachSB(SurfaceBuilderConfig::deserialize);

    //Nether
    public static final SurfaceBuilder<SurfaceBuilderConfig> WARPEDDESERT_SB = new WarpedDesertSB(SurfaceBuilderConfig::deserialize);
    public static final SurfaceBuilder<SurfaceBuilderConfig> EMBURBOG = new EmburBogSB(SurfaceBuilderConfig::deserialize);

    //End
    public static final SurfaceBuilder<SurfaceBuilderConfig> IVISFIELDS_SB = new IvisFieldsSB(SurfaceBuilderConfig::deserialize);

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
        public static final SurfaceBuilderConfig MYCELIUM = new SurfaceBuilderConfig(Blocks.MYCELIUM.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState());


        public static final SurfaceBuilderConfig SAND_CF = new SurfaceBuilderConfig(Blocks.SAND.getDefaultState(), Blocks.SAND.getDefaultState(), Blocks.SAND.getDefaultState());
        public static final SurfaceBuilderConfig REDSAND_CF = new SurfaceBuilderConfig(Blocks.RED_SAND.getDefaultState(), Blocks.RED_SAND.getDefaultState(), Blocks.RED_SAND.getDefaultState());
        public static final SurfaceBuilderConfig WARPEDDESERT = new SurfaceBuilderConfig(BYGBlockList.NYLIUM_SOUL_SAND.getDefaultState(), BYGBlockList.NYLIUM_SOUL_SAND.getDefaultState(), BYGBlockList.NYLIUM_SOUL_SAND.getDefaultState());
        public static final SurfaceBuilderConfig WARPEDDESERT_SOIL = new SurfaceBuilderConfig(BYGBlockList.NYLIUM_SOUL_SOIL.getDefaultState(), BYGBlockList.NYLIUM_SOUL_SOIL.getDefaultState(), BYGBlockList.NYLIUM_SOUL_SOIL.getDefaultState());
        public static final SurfaceBuilderConfig SYTHIANTORRIDS = new SurfaceBuilderConfig(BYGBlockList.SYTHIAN_NYLIUM.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), Blocks.NETHERRACK.getDefaultState());
        public static final SurfaceBuilderConfig GLOWSTONEGARDENS = new SurfaceBuilderConfig(BYGBlockList.OVERGROWN_NETHERRACK.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), Blocks.NETHERRACK.getDefaultState());
        public static final SurfaceBuilderConfig EMBURNYLIUM = new SurfaceBuilderConfig(BYGBlockList.EMBUR_NYLIUM.getDefaultState(), BYGBlockList.BLUE_NETHERRACK.getDefaultState(), BYGBlockList.BLUE_NETHERRACK.getDefaultState());

        public static final SurfaceBuilderConfig PODZOLDOVERMOUNTAIN_CF = new SurfaceBuilderConfig(BYGBlockList.OVERGROWN_DACITE.getDefaultState(), BYGBlockList.DACITE.getDefaultState(), BYGBlockList.DACITE.getDefaultState());
        public static final SurfaceBuilderConfig COARSEDIRTDOVERMOUNTAIN_CF = new SurfaceBuilderConfig(Blocks.COARSE_DIRT.getDefaultState(), BYGBlockList.DACITE.getDefaultState(), BYGBlockList.DACITE.getDefaultState());
        public static final SurfaceBuilderConfig GRASSDOVERMOUNTAIN_CF = new SurfaceBuilderConfig(BYGBlockList.PODZOL_DACITE.getDefaultState(), BYGBlockList.DACITE.getDefaultState(), BYGBlockList.DACITE.getDefaultState());

        public static final SurfaceBuilderConfig AIR_CF = new SurfaceBuilderConfig(Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState());

        public static final SurfaceBuilderConfig QUAGMIREPEAT_SB = new SurfaceBuilderConfig(BYGBlockList.PEAT.getDefaultState(), BYGBlockList.MUD_BLOCK.getDefaultState(), BYGBlockList.MUD_BLOCK.getDefaultState());
        public static final SurfaceBuilderConfig QUAGMIREMUD_CF = new SurfaceBuilderConfig(BYGBlockList.MUD_BLOCK.getDefaultState(), BYGBlockList.MUD_BRICKS.getDefaultState(), BYGBlockList.MUD_BLOCK.getDefaultState());
        public static final SurfaceBuilderConfig GRASSMOUNTAIN_CF = new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.STONE.getDefaultState(), Blocks.STONE.getDefaultState());
        public static final SurfaceBuilderConfig PEATGRASS_CF = new SurfaceBuilderConfig(BYGBlockList.PEAT.getDefaultState(), BYGBlockList.PEAT.getDefaultState(), BYGBlockList.PEAT.getDefaultState());
        public static final SurfaceBuilderConfig MUD_CF = new SurfaceBuilderConfig(BYGBlockList.MUD_BLOCK.getDefaultState(), BYGBlockList.MUD_BLOCK.getDefaultState(), BYGBlockList.MUD_BLOCK.getDefaultState());
        public static final SurfaceBuilderConfig TERRACOTTA_CF = new SurfaceBuilderConfig(Blocks.TERRACOTTA.getDefaultState(), Blocks.TERRACOTTA.getDefaultState(), Blocks.TERRACOTTA.getDefaultState());
        public static final SurfaceBuilderConfig GLOWCELIUM_CF = new SurfaceBuilderConfig(BYGBlockList.GLOWCELIUM.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState());

        public static final SurfaceBuilderConfig GREEN_CONCRETE_POWDER_CF = new SurfaceBuilderConfig(BYGBlockList.OVERGROWN_STONE.getDefaultState(), BYGBlockList.MOSSY_STONE.getDefaultState(), Blocks.STONE.getDefaultState());

        public static final SurfaceBuilderConfig RED_ROCK_CF = new SurfaceBuilderConfig(BYGBlockList.RED_ROCK.getDefaultState(), BYGBlockList.RED_ROCK.getDefaultState(), BYGBlockList.RED_ROCK.getDefaultState());

        public static final SurfaceBuilderConfig IVIS_CF = new SurfaceBuilderConfig(BYGBlockList.IVIS_PHYLIUM.getDefaultState(), Blocks.END_STONE.getDefaultState(), Blocks.END_STONE.getDefaultState());
        public static final SurfaceBuilderConfig END = new SurfaceBuilderConfig(Blocks.END_STONE.getDefaultState(), Blocks.END_STONE.getDefaultState(), Blocks.END_STONE.getDefaultState());
    }
}
