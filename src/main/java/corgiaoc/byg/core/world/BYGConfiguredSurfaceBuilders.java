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
}
