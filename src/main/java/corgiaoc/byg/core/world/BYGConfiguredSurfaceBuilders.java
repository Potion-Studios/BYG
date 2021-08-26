package corgiaoc.byg.core.world;

import corgiaoc.byg.common.world.surfacebuilder.config.FillSurfaceBuilderConfig;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

public class BYGConfiguredSurfaceBuilders {

    public static final ConfiguredSurfaceBuilder<?> BLACK_SAND = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("black_sand", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, BYGSurfaceBuilders.Configs.BLACK_SAND));
    public static final ConfiguredSurfaceBuilder<?> BOREAL_FOREST = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("boreal_forest", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.BOREAL, SurfaceBuilder.CONFIG_GRASS));
    public static final ConfiguredSurfaceBuilder<?> CRAG_GARDENS = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("crag_gardens", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.CRAG_GARDENS, BYGSurfaceBuilders.Configs.GREEN_CONCRETE_POWDER_CF));
    public static final ConfiguredSurfaceBuilder<?> MARSHLAND = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("marshland", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.MARSHLAND, new SurfaceBuilderBaseConfiguration(Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(), BYGBlocks.MUD_BLOCK.defaultBlockState())));
    public static final ConfiguredSurfaceBuilder<?> MEADOW = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("meadow", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, new SurfaceBuilderBaseConfiguration(BYGBlocks.MEADOW_GRASSBLOCK.defaultBlockState(), BYGBlocks.MEADOW_DIRT.defaultBlockState(), BYGBlocks.MEADOW_DIRT.defaultBlockState())));
    public static final ConfiguredSurfaceBuilder<?> OVERGROWN_STONE = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("overgrown_stone", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, new SurfaceBuilderBaseConfiguration(BYGBlocks.OVERGROWN_STONE.defaultBlockState(), Blocks.STONE.defaultBlockState(), Blocks.STONE.defaultBlockState())));
    public static final ConfiguredSurfaceBuilder<?> PEAT_GRASS = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("peat_grass", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.CONIFEROUS, BYGSurfaceBuilders.Configs.PEATGRASS_CF));
    public static final ConfiguredSurfaceBuilder<?> FILL_SAND = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("fill_sand", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.FILL, new FillSurfaceBuilderConfig.Builder().setFillBlock(Blocks.SAND).setTopBlock(Blocks.SAND).setUnderBlock(Blocks.SAND).setFillDownToY(63).build()));
    public static final ConfiguredSurfaceBuilder<?> FILL_DACITE_PODZOL = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("fill_dacite", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.FILL, new FillSurfaceBuilderConfig.Builder().setFillBlock(Blocks.SAND).setTopBlock(BYGBlocks.PODZOL_DACITE).setUnderBlock(BYGBlocks.DACITE).setFillDownToY(63).build()));

    //nether
    public static final ConfiguredSurfaceBuilder<?> BRIMSTONE_CAVERNS = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("brimstone_caverns", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.BRIMSTONE_CAVERNS, BYGSurfaceBuilders.Configs.BRIMSTONE));
    public static final ConfiguredSurfaceBuilder<?> CRIMSON_GARDENS = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("crimson_gardens", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.CRIMSON_GARDENS, BYGSurfaceBuilders.Configs.CRIMSON_GARDEN));
    public static final ConfiguredSurfaceBuilder<?> EMBUR_BOG = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("embur_bog", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.EMBUR_BOG, BYGSurfaceBuilders.Configs.EMBURNYLIUM));
    public static final ConfiguredSurfaceBuilder<?> GLOWSTONE_GARDENS = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("glowstone_gardens", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.GLOWSTONE_GARDENS, BYGSurfaceBuilders.Configs.GLOWSTONE_GARDENS));
    public static final ConfiguredSurfaceBuilder<?> QUARTZ_DESERT = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("quartz_desert", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.QUARTZ_DESERT, BYGSurfaceBuilders.Configs.WARPEDDESERT));
    public static final ConfiguredSurfaceBuilder<?> SUBZERO_HYPOGEAL = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("subzero_hypogeal", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.SUBZERO_HYPOGEAL, BYGSurfaceBuilders.Configs.FROST_MAGMA));
    public static final ConfiguredSurfaceBuilder<?> SYTHIAN_TORRIDS = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("sythian_torrids", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, BYGSurfaceBuilders.Configs.SYTHIANTORRIDS));
    public static final ConfiguredSurfaceBuilder<?> WARPED_DESERT = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("warped_desert", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.WARPED_DESERT, BYGSurfaceBuilders.Configs.WARPEDDESERT));
    public static final ConfiguredSurfaceBuilder<?> WAILING_GARTH = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("wailing_garth", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.WAILING_GARTH, BYGSurfaceBuilders.Configs.SOULSAND));
    public static final ConfiguredSurfaceBuilder<?> WITHERING_WOODS = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("withering_woods", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.WITHERING_WOODS, BYGSurfaceBuilders.Configs.MAGMATIC_STONE));
    public static final ConfiguredSurfaceBuilder<?> WEEPING_MIRE = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("weeping_mire", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.WEEPING_MIRE, BYGSurfaceBuilders.Configs.SOULSAND));

    //end
    public static final ConfiguredSurfaceBuilder<?> BULBIS_GARDENS = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("bulbis_gardens", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.BULBIS_GARDENS, BYGSurfaceBuilders.Configs.BULBIS_PHYCELIUM_CF));
    public static final ConfiguredSurfaceBuilder<?> BULBIS_GARDENS_EDGE = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("bulbis_gardens_edge", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.BULBIS_GARDENS, BYGSurfaceBuilders.Configs.BULBIS_PHYCELIUM_CF));
    public static final ConfiguredSurfaceBuilder<?> CRYPTIC_WASTES = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("cryptic_wastes", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.CRYPTIC, BYGSurfaceBuilders.Configs.CRYPTIC));
    public static final ConfiguredSurfaceBuilder<?> ETHEREAL_ISLANDS = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("ethereal_islands", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.ETHEREAL, BYGSurfaceBuilders.Configs.ETHER));
    public static final ConfiguredSurfaceBuilder<?> ETHEREAL_CLEARING = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("ethereal_clearing", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.ETHEREAL, BYGSurfaceBuilders.Configs.ETHER));
    public static final ConfiguredSurfaceBuilder<?> ETHEREAL_FOREST = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("ethereal_forest", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.ETHEREAL, BYGSurfaceBuilders.Configs.ETHER));
    public static final ConfiguredSurfaceBuilder<?> IMPARIUS_GROVE = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("imparius_grove", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, BYGSurfaceBuilders.Configs.IMPARIUS));
    public static final ConfiguredSurfaceBuilder<?> IMPARIUS_CLEARING = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("imparius_clearing", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, BYGSurfaceBuilders.Configs.IMPARIUS));
    public static final ConfiguredSurfaceBuilder<?> IVIS_FIELDS = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("ivis_fields", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.IVIS_FIELDS, BYGSurfaceBuilders.Configs.END));
    public static final ConfiguredSurfaceBuilder<?> NIGHTSHADE_FOREST = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("nightshade_forest", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, BYGSurfaceBuilders.Configs.NIGHTSHADE));
    public static final ConfiguredSurfaceBuilder<?> PURPUR_PEAKS = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("purpur_peaks", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.PURPUR_PEAKS, BYGSurfaceBuilders.Configs.END));
    public static final ConfiguredSurfaceBuilder<?> SHATTERED_DESERT = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("shattered_desert", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.SHATTERED_DESERT, BYGSurfaceBuilders.Configs.END));
    public static final ConfiguredSurfaceBuilder<?> SHATTERED_DESERT_ISLES = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("shattered_desert_isles", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.SHATTERED_DESERT, BYGSurfaceBuilders.Configs.END));
    public static final ConfiguredSurfaceBuilder<?> SHULKREN_FOREST = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("shulkren_forest", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, BYGSurfaceBuilders.Configs.SHULKREN));
    public static final ConfiguredSurfaceBuilder<?> VISCALISLES = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("shattered_viscal_isles", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.ETHEREAL, BYGSurfaceBuilders.Configs.SCULK));
    public static final ConfiguredSurfaceBuilder<?> SHATTERED_VISCAL_ISLES = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("viscal_isles", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.ETHEREAL, BYGSurfaceBuilders.Configs.SCULK));

}
