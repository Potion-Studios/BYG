package corgiaoc.byg.mixin.access;

import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.StructureFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;
import java.util.function.Supplier;

@Mixin(BiomeGenerationSettings.class)
public interface BiomeGenerationSettingsAccess {

    @Accessor
    List<List<Supplier<ConfiguredFeature<?, ?>>>> getFeatures();

    @Accessor
    void setFeatures(List<List<Supplier<ConfiguredFeature<?, ?>>>> features);

    @Accessor
    List<Supplier<StructureFeature<?, ?>>> getStructureStarts();


    @Accessor
    void setStructureStarts(List<Supplier<StructureFeature<?, ?>>> structureStarts);
}
