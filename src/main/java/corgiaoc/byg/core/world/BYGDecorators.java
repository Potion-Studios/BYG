package corgiaoc.byg.core.world;

import corgiaoc.byg.common.world.feature.decorator.AnyWaterOrSolidSurfaceSurface;
import corgiaoc.byg.common.world.feature.decorator.AtOceanFloorWithExtra;
import corgiaoc.byg.common.world.feature.decorator.ObsidianSpikePlacer;
import corgiaoc.byg.common.world.feature.decorator.UnderGroundPlacement;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.world.gen.feature.FeatureSpreadConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;

public class BYGDecorators {

    public static final Placement<FeatureSpreadConfig> ANY_WATER_OR_SOLID_SURFACE = WorldGenRegistrationHelper.createDecorator("water_or_solid_surface", new AnyWaterOrSolidSurfaceSurface(FeatureSpreadConfig.field_242797_a));
    public static final Placement<AtSurfaceWithExtraConfig> OCEAN_FLOOR = WorldGenRegistrationHelper.createDecorator("ocean_floor_count_extra", new AtOceanFloorWithExtra(AtSurfaceWithExtraConfig.field_236973_a_));
    public static final Placement<AtSurfaceWithExtraConfig> OBBY_SPIKE = WorldGenRegistrationHelper.createDecorator("obsidian_spike", new ObsidianSpikePlacer(AtSurfaceWithExtraConfig.field_236973_a_));
    public static final Placement<AtSurfaceWithExtraConfig> UNDERGROUND_COUNT_EXTRA = WorldGenRegistrationHelper.createDecorator("underground_count_extra", new UnderGroundPlacement(AtSurfaceWithExtraConfig.field_236973_a_));

    public static void init() {}
}
