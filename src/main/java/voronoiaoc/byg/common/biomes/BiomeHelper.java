package voronoiaoc.byg.common.biomes;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import voronoiaoc.byg.BYG;

public class BiomeHelper {

    public static int calcSkyColor(float f) {
        float g = f / 3.0F;
        g = MathHelper.clamp(g, -1.0F, 1.0F);
        return MathHelper.hsvToRgb(0.62222224F - g * 0.05F, 0.5F + g * 0.1F, 1.0F);
    }

    public static ConfiguredSurfaceBuilder<?> newConfiguredSurfaceBuilder(String id, ConfiguredSurfaceBuilder<?> configuredSurfaceBuilder) {
        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier(BYG.MODID, id), configuredSurfaceBuilder);
        return configuredSurfaceBuilder;
    }

    public static Decorator<?> newDecorator(String id, Decorator<?> decorator) {
        Registry.register(Registry.DECORATOR, new Identifier(BYG.MODID, id), decorator);
        return decorator;
    }
}
