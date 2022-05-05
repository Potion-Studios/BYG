package potionstudios.byg.client.textures.renders;

import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import potionstudios.byg.BYG;
import potionstudios.byg.mixin.access.SimpleParticleTypeAccess;
import potionstudios.byg.registration.RegistrationProvider;
import potionstudios.byg.registration.RegistryObject;

import java.util.function.Supplier;

public class BYGParticleTypes {

    public static final RegistrationProvider<ParticleType<?>> PROVIDER = RegistrationProvider.get(Registry.PARTICLE_TYPE_REGISTRY, BYG.MOD_ID);

    public static final RegistryObject<SimpleParticleType> THERIUM_GLINT = createSimpleParticle(() -> SimpleParticleTypeAccess.byg_create(false), "therium_glint");
    public static final RegistryObject<SimpleParticleType> WITCH_HAZEL_LEAF = createSimpleParticle(() -> SimpleParticleTypeAccess.byg_create(false), "witch_hazel_leaf");
    public static final RegistryObject<SimpleParticleType> CHERRY_BLOSSOM_FALL_WHITE = createSimpleParticle(() -> SimpleParticleTypeAccess.byg_create(false), "cherry_blossom_fall_white");
    public static final RegistryObject<SimpleParticleType> CHERRY_BLOSSOM_FALL_PINK = createSimpleParticle(() -> SimpleParticleTypeAccess.byg_create(false), "cherry_blossom_fall_pink");

    public static <T extends ParticleType<?>> RegistryObject<T> createSimpleParticle(Supplier<T> particle, String id) {
        return PROVIDER.register(id, particle);
    }

    public static void loadClass() {}
}
