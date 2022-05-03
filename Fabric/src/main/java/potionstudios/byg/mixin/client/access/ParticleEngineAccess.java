package potionstudios.byg.mixin.client.access;

import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@SuppressWarnings("UnresolvedMixinReference")
@Mixin(ParticleEngine.class)
public interface ParticleEngineAccess {

    @Invoker("register")
    <T extends ParticleOptions> void byg_register(ParticleType<? extends T> particle, ParticleEngine.SpriteParticleRegistration<T> provider);
}
