package potionstudios.byg.mixin.access;

import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(BiomeGenerationSettings.class)
public interface BiomeGenerationSettingsAccess {

    @Mutable
    @Accessor("features")
    void byg_setFeatures(List<HolderSet<PlacedFeature>> features);
}