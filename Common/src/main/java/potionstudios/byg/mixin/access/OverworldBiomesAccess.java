package potionstudios.byg.mixin.access;

import net.minecraft.data.worldgen.biome.OverworldBiomes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(OverworldBiomes.class)
public interface OverworldBiomesAccess {

    @Invoker
    static void invokeGlobalOverworldGeneration(net.minecraft.world.level.biome.BiomeGenerationSettings.Builder builder) {
        throw new Error("Mixin did not apply!");
    }
}
