package corgiaoc.byg.mixin.access;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Biome.class)
public interface BiomeAccess {

    @Invoker("<init>")
    static Biome create(Biome.ClimateSettings climate, Biome.BiomeCategory category, float depth, float scale, BiomeSpecialEffects ambience, BiomeGenerationSettings generationSettings, MobSpawnSettings spawnInfo) {
        throw new Error("Mixin did not apply!");
    }
}
