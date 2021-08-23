package corgiaoc.byg.core;

import corgiaoc.byg.BYG;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BYGParticles {

    private static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, BYG.MOD_ID);

    public static BasicParticleType NYLIUM_SOUL_SAND_AMBIENCE = new BasicParticleType(true);
//    public static RegistryObject<ParticleType<BoricFlameParticle.BoricParticleData>> BORIC_FLAME = PARTICLE_TYPES.register("boric_flame", () -> new ParticleType<BoricFlameParticle.BoricParticleData>(true, BoricFlameParticle.BoricParticleData.DESERIALIZER) {

}


