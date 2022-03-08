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

    public static final SimpleParticleType THERIUM_GLINT = createSimpleParticle(SimpleParticleTypeAccess.byg_create(false), "therium_glint");
    public static final SimpleParticleType WITCH_HAZEL_LEAF = createSimpleParticle(SimpleParticleTypeAccess.byg_create(false), "witch_hazel_leaf");
    public static final SimpleParticleType CHERRY_BLOSSOM_FALL_WHITE = createSimpleParticle(SimpleParticleTypeAccess.byg_create(false), "cherry_blossom_fall_white");
    public static final SimpleParticleType CHERRY_BLOSSOM_FALL_PINK = createSimpleParticle(SimpleParticleTypeAccess.byg_create(false), "cherry_blossom_fall_pink");

    public static <T extends ParticleType<?>> T createSimpleParticle(T particle, String id) {
        PARTICLES.add(new RegistryObject<>(particle, id));
        return particle;
    }

    public static Collection<RegistryObject<ParticleType<?>>> bootStrap() {
        return PARTICLES;
    }
}
