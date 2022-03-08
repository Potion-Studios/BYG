package potionstudios.byg.mixin.client;

import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import potionstudios.byg.client.textures.renders.BYGParticleTypes;
import potionstudios.byg.common.particles.FallingLeafParticle;
import potionstudios.byg.common.particles.TheriumGlint;

@SuppressWarnings("UnresolvedMixinReference")
@Mixin(ParticleEngine.class)
public class MixinParticleEngine {

    @Shadow
    private <T extends ParticleOptions> void register(ParticleType<? extends T> particle, ParticleEngine.SpriteParticleRegistration<T> provider) {
        throw new Error("Mixin did not apply!");
    }

    @Inject(method = ("registerProviders"), at = @At("RETURN"))
    private void registerBYGProviders(CallbackInfo ci) {
        register(BYGParticleTypes.THERIUM_GLINT, TheriumGlint.Provider::new);
        register(BYGParticleTypes.WITCH_HAZEL_LEAF, FallingLeafParticle.Provider::new);
        register(BYGParticleTypes.CHERRY_BLOSSOM_FALL_WHITE, FallingLeafParticle.Provider::new);
        register(BYGParticleTypes.CHERRY_BLOSSOM_FALL_PINK, FallingLeafParticle.Provider::new);
    }
}
