package potionstudios.byg.mixin.access;

import net.minecraft.core.particles.SimpleParticleType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(SimpleParticleType.class)
public interface SimpleParticleTypeAccess {

    @Invoker("<init>")
    static SimpleParticleType byg_create(boolean glow) {
        throw new Error("Mixin did not apply!");
    }
}
