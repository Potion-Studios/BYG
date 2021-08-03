package corgiaoc.byg.core;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgiaoc.byg.BYG;
import corgiaoc.byg.client.particle.BoricFlameParticle;
import net.minecraft.block.Block;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BYGParticles {

    private static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, BYG.MOD_ID);

    public static BasicParticleType NYLIUM_SOUL_SAND_AMBIENCE = new BasicParticleType(true);
//    public static RegistryObject<ParticleType<BoricFlameParticle.BoricParticleData>> BORIC_FLAME = PARTICLE_TYPES.register("boric_flame", () -> new ParticleType<BoricFlameParticle.BoricParticleData>(true, BoricFlameParticle.BoricParticleData.DESERIALIZER) {

}


