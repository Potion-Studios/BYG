package corgiaoc.byg.core.world;

import corgiaoc.byg.common.world.decorator.*;
import corgiaoc.byg.common.world.decorator.config.AtOrBelowSeaLevelCountExtraConfig;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.world.gen.feature.FeatureSpreadConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;

import java.util.HashSet;
import java.util.Set;

public class BYGDecorators {
    public static Set<Placement<?>> decorators = new HashSet<>();

    public static final Placement<FeatureSpreadConfig> ANY_WATER_OR_SOLID_SURFACE = WorldGenRegistrationHelper.createDecorator("water_or_solid_surface", new AnyWaterOrSolidSurface(FeatureSpreadConfig.field_242797_a));
    public static final Placement<AtSurfaceWithExtraConfig> OCEAN_FLOOR_COUNT_EXTRA = WorldGenRegistrationHelper.createDecorator("ocean_floor_count_extra", new AtOceanFloorWithExtra(AtSurfaceWithExtraConfig.field_236973_a_));
    public static final Placement<AtSurfaceWithExtraConfig> UNDERGROUND_COUNT_EXTRA = WorldGenRegistrationHelper.createDecorator("underground_count_extra", new UndergroundCountExtra(AtSurfaceWithExtraConfig.field_236973_a_));
    public static final Placement<AtOrBelowSeaLevelCountExtraConfig> AT_OR_BELOW_SEA_LEVEL = WorldGenRegistrationHelper.createDecorator("at_or_below_sea_level_count_extra", new AtOrBelowSeaLevelCountExtra(AtOrBelowSeaLevelCountExtraConfig.CODEC));
    public static final Placement<AtSurfaceWithExtraConfig> MOTION_BLOCKING_NO_LEAVES_COUNT_EXTRA = WorldGenRegistrationHelper.createDecorator("motion_blocking_no_leaves_count_extra", new MotionBlockingNoLeavesCountExtra(AtSurfaceWithExtraConfig.field_236973_a_));

    public static final Placement<AtSurfaceWithExtraConfig> ISLAND = WorldGenRegistrationHelper.createDecorator("floating_island", new FloatingIsland(AtSurfaceWithExtraConfig.field_236973_a_));

    public static void init() {
    }
}
