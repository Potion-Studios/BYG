package potionstudios.byg.mixin.common.world;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import potionstudios.byg.BYG;
import potionstudios.byg.config.biome.BiomeSourceGenerationWorldProperties;

import java.util.Optional;
import java.util.function.Supplier;

@Mixin(MultiNoiseBiomeSource.class)
public class MixinMultiNoiseBiomeSource {


    @Mutable
    @Shadow
    @Final
    private Climate.ParameterList<Supplier<Biome>> parameters;

    @Inject(method = "<init>(Lnet/minecraft/world/level/biome/Climate$ParameterList;Ljava/util/Optional;)V", at = @At("RETURN"))
    private void forceAddBiomes(Climate.ParameterList<Supplier<Biome>> climateParameters, Optional<MultiNoiseBiomeSource.PresetInstance> optional, CallbackInfo ci) {
        if (BYG.biomeRegistryAccess != null) {
            this.parameters = BiomeSourceGenerationWorldProperties.INSTANCE.createWeightedPointParameterList(climateParameters);
        }
    }
}
