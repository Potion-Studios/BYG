package corgiaoc.byg.mixin.access;

import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
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
    List<Supplier<ConfiguredStructureFeature<?, ?>>> getStructureStarts();


    @Accessor
    void setStructureStarts(List<Supplier<ConfiguredStructureFeature<?, ?>>> structureStarts);
}
