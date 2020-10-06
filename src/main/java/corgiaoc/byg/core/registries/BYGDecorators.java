package corgiaoc.byg.core.registries;

import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.biome.BiomeUtil;
import corgiaoc.byg.common.world.feature.decorator.AnyWaterOrSolidSurfaceSurface;
import net.minecraft.world.gen.feature.FeatureSpreadConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BYG.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BYGDecorators {

    public static void init() {}

    public static final Placement<FeatureSpreadConfig> WATER_OR_SOLID_SURFACE = BiomeUtil.newDecorator("any_water_or_solid_surface_decorator", new AnyWaterOrSolidSurfaceSurface(FeatureSpreadConfig.field_242797_a));

}
