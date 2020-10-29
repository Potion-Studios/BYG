package corgiaoc.byg.core.world;

import corgiaoc.byg.common.world.decorator.*;
import corgiaoc.byg.common.world.decorator.config.AtOrBelowSeaLevelCountExtraConfig;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.world.gen.CountConfig;
import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;

import java.util.ArrayList;
import java.util.List;

public class BYGDecorators {
    public static List<Decorator<?>> decorators = new ArrayList<>();

    public static final Decorator<CountConfig> ANY_WATER_OR_SOLID_SURFACE = WorldGenRegistrationHelper.createDecorator("water_or_solid_surface", new AnyWaterOrSolidSurface(CountConfig.CODEC));
    public static final Decorator<CountExtraDecoratorConfig> OCEAN_FLOOR_COUNT_EXTRA = WorldGenRegistrationHelper.createDecorator("ocean_floor_count_extra", new AtOceanFloorWithExtra(CountExtraDecoratorConfig.CODEC));
    public static final Decorator<CountExtraDecoratorConfig> UNDERGROUND_COUNT_EXTRA = WorldGenRegistrationHelper.createDecorator("underground_count_extra", new UndergroundCountExtra(CountExtraDecoratorConfig.CODEC));
    public static final Decorator<AtOrBelowSeaLevelCountExtraConfig> AT_OR_BELOW_SEA_LEVEL = WorldGenRegistrationHelper.createDecorator("at_or_below_sea_level_count_extra", new AtOrBelowSeaLevelCountExtra(AtOrBelowSeaLevelCountExtraConfig.CODEC));
    public static final Decorator<CountExtraDecoratorConfig> MOTION_BLOCKING_NO_LEAVES_COUNT_EXTRA = WorldGenRegistrationHelper.createDecorator("motion_blocking_no_leaves_count_extra", new MotionBlockingNoLeavesCountExtra(CountExtraDecoratorConfig.CODEC));

    public static final Decorator<CountExtraDecoratorConfig> ISLAND = WorldGenRegistrationHelper.createDecorator("floating_island", new FloatingIsland(CountExtraDecoratorConfig.CODEC));

    public static void init() {
    }
}
