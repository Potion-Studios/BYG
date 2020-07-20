package voronoiaoc.byg.core.byglists;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import voronoiaoc.byg.BYG;

public class BYGConfiguredFeature {



    
    public static ConfiguredFeature<?, ?> newConfiguredFeature(String registryName, ConfiguredFeature<?, ?> configuredFeature) {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(BYG.MODID, registryName), configuredFeature);
        return configuredFeature;
    }
}
