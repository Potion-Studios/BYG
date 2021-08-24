package corgiaoc.byg.mixin.access;

import net.minecraft.world.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Biome.ClimateSettings.class)
public interface BiomeClimateSettingsAccess {

    @Invoker("<init>")
    static Biome.ClimateSettings create(Biome.Precipitation precipitation, float temperature, Biome.TemperatureModifier temperatureModifier, float humidity) {
        throw new Error("Mixin did not apply!");
    }
}
