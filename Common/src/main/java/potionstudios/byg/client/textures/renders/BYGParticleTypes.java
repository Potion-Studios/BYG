package potionstudios.byg.client.textures.renders;

import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import potionstudios.byg.BYG;
import potionstudios.byg.mixin.access.SimpleParticleTypeAccess;
import potionstudios.byg.reg.RegistrationProvider;
import potionstudios.byg.reg.RegistryObject;

import java.util.function.Supplier;

public class BYGParticleTypes {

    public static final RegistrationProvider<ParticleType<?>> PROVIDER = RegistrationProvider.get(Registry.PARTICLE_TYPE_REGISTRY, BYG.MOD_ID);

    public static final RegistryObject<SimpleParticleType> THERIUM_GLINT = createSimpleParticle(() -> SimpleParticleTypeAccess.byg_create(true), "therium_glint");
    public static final RegistryObject<SimpleParticleType> WITCH_HAZEL_LEAVES = createSimpleParticle(() -> SimpleParticleTypeAccess.byg_create(true), "witch_hazel_leaves");
    public static final RegistryObject<SimpleParticleType> PINK_CHERRY_BLOSSOM_LEAVES = createSimpleParticle(() -> SimpleParticleTypeAccess.byg_create(false), "pink_cherry_blossom_leaves");
    public static final RegistryObject<SimpleParticleType> WHITE_CHERRY_BLOSSOM_LEAVES = createSimpleParticle(() -> SimpleParticleTypeAccess.byg_create(false), "white_cherry_blossom_leaves");
    public static final RegistryObject<SimpleParticleType> RED_MAPLE_LEAVES = createSimpleParticle(() -> SimpleParticleTypeAccess.byg_create(false), "red_maple_leaves");
    public static final RegistryObject<SimpleParticleType> SILVER_MAPLE_LEAVES = createSimpleParticle(() -> SimpleParticleTypeAccess.byg_create(false), "silver_maple_leaves");

    public static <T extends ParticleType<?>> RegistryObject<T> createSimpleParticle(Supplier<T> particle, String id) {
        return PROVIDER.register(id, particle);
    }

    public static void loadClass() {}
}
