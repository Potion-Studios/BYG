package potionstudios.byg.mixin.access;

import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(OverworldBiomes.class)
public interface OverworldBiomesAccess {

    @Invoker("globalOverworldGeneration")
    static void byg_invokeGlobalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        throw new Error("Mixin did not apply!");
    }


    @Invoker("baseOceanGeneration")
    static BiomeGenerationSettings.Builder byg_invokeBaseOceanGeneration(HolderGetter<PlacedFeature> placedFeatureHolderGetter, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarverHolderGetter) {
        throw new Error("Mixin did not apply!");
    }
}