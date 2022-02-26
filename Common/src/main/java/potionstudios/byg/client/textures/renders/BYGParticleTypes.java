package potionstudios.byg.client.textures.renders;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import potionstudios.byg.mixin.access.SimpleParticleTypeAccess;
import potionstudios.byg.util.RegistryObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BYGParticleTypes {
    public static final List<RegistryObject<ParticleType<?>>> PARTICLES = new ArrayList<>();

    public static final SimpleParticleType THERIUM_GLINT = createSimpleParticle(SimpleParticleTypeAccess.create(false), "therium_glint");

    public static <T extends ParticleType<?>> T createSimpleParticle(T particle, String id) {
        PARTICLES.add(new RegistryObject<>(particle, id));
        return particle;
    }

    public static Collection<RegistryObject<ParticleType<?>>> bootStrap() {
        return PARTICLES;
    }
}
