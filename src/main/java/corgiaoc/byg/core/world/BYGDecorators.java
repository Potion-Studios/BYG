package corgiaoc.byg.core.world;

import corgiaoc.byg.common.world.decorator.*;
import corgiaoc.byg.common.world.decorator.config.AtOrBelowSeaLevelCountExtraConfig;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.world.level.levelgen.feature.configurations.CountConfiguration;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.placement.FrequencyWithExtraChanceDecoratorConfiguration;

import java.util.ArrayList;
import java.util.List;

public class BYGDecorators {
    public static List<FeatureDecorator<?>> decorators = new ArrayList<>();

    public static final FeatureDecorator<CountConfiguration> ANY_WATER_OR_SOLID_SURFACE = WorldGenRegistrationHelper.createDecorator("water_or_solid_surface", new AnyWaterOrSolidSurface(CountConfiguration.CODEC));
    public static final FeatureDecorator<FrequencyWithExtraChanceDecoratorConfiguration> OCEAN_FLOOR_COUNT_EXTRA = WorldGenRegistrationHelper.createDecorator("ocean_floor_count_extra", new AtOceanFloorWithExtra(FrequencyWithExtraChanceDecoratorConfiguration.CODEC));
    public static final FeatureDecorator<FrequencyWithExtraChanceDecoratorConfiguration> UNDERGROUND_COUNT_EXTRA = WorldGenRegistrationHelper.createDecorator("underground_count_extra", new UndergroundCountExtra(FrequencyWithExtraChanceDecoratorConfiguration.CODEC));
    public static final FeatureDecorator<AtOrBelowSeaLevelCountExtraConfig> AT_OR_BELOW_SEA_LEVEL = WorldGenRegistrationHelper.createDecorator("at_or_below_sea_level_count_extra", new AtOrBelowSeaLevelCountExtra(AtOrBelowSeaLevelCountExtraConfig.CODEC));
    public static final FeatureDecorator<FrequencyWithExtraChanceDecoratorConfiguration> MOTION_BLOCKING_NO_LEAVES_COUNT_EXTRA = WorldGenRegistrationHelper.createDecorator("motion_blocking_no_leaves_count_extra", new MotionBlockingNoLeavesCountExtra(FrequencyWithExtraChanceDecoratorConfiguration.CODEC));

    public static final FeatureDecorator<FrequencyWithExtraChanceDecoratorConfiguration> ISLAND = WorldGenRegistrationHelper.createDecorator("floating_island", new FloatingIsland(FrequencyWithExtraChanceDecoratorConfiguration.CODEC));

    public static void init() {
    }
}
