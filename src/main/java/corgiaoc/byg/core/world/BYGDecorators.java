package corgiaoc.byg.core.world;

import corgiaoc.byg.common.world.biome.BiomeUtil;
import corgiaoc.byg.common.world.feature.decorator.AnyWaterOrSolidSurfaceSurface;
import net.minecraft.world.gen.feature.FeatureSpreadConfig;
import net.minecraft.world.gen.placement.Placement;

public class BYGDecorators {

    public static void init() {}

    public static final Placement<FeatureSpreadConfig> WATER_OR_SOLID_SURFACE = BiomeUtil.newDecorator("any_water_or_solid_surface_decorator", new AnyWaterOrSolidSurfaceSurface(FeatureSpreadConfig.field_242797_a));

}
