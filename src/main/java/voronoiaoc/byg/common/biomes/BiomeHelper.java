package voronoiaoc.byg.common.biomes;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.levelgen.feature.configurations.DecoratorConfiguration;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import voronoiaoc.byg.BYG;

public class BiomeHelper {

    public static int calcSkyColor(float f) {
        float g = f / 3.0F;
        g = Mth.clamp(g, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - g * 0.05F, 0.5F + g * 0.1F, 1.0F);
    }

    public static ConfiguredSurfaceBuilder<?> newConfiguredSurfaceBuilder(String id, ConfiguredSurfaceBuilder<?> configuredSurfaceBuilder) {
        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(BYG.MODID, id), configuredSurfaceBuilder);
        return configuredSurfaceBuilder;
    }

    public static <T extends DecoratorConfiguration, G extends FeatureDecorator<T>> G newDecorator(String id, G decorator) {
        Registry.register(Registry.DECORATOR, new ResourceLocation(BYG.MODID, id), decorator);
        return decorator;
    }
}
