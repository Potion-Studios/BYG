package corgiaoc.byg.mixin.access;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Biome.class)
public interface BiomeAccess {

    @Invoker("<init>")
    static Biome create(Biome.Climate climate, Biome.Category category, float depth, float scale, BiomeAmbience ambience, BiomeGenerationSettings generationSettings, MobSpawnInfo spawnInfo) {
        throw new Error("Mixin did not apply!");
    }
}
