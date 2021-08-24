package corgiaoc.byg.client.particle;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.Mth;

import java.util.Locale;

public class BoricFlameParticle extends RisingParticle implements ParticleOptions {
    public BoricFlameParticle(ClientLevel world, double x, double y, double z, double motionX, double motionY, double motionZ) {
        super(world, x, y, z, motionX, motionY, motionZ);
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public void move(double motionX, double motionY, double motionZ) {
        this.setBoundingBox(this.getBoundingBox().move(motionX, motionY, motionZ));
        this.setLocationFromBoundingbox();
    }

    public float getQuadSize(float size) {
        float f = ((float) this.age + size) / (float) this.lifetime;
        return this.quadSize * (1.0F - f * f * 0.5F);
    }

    public int getLightColor(float color) {
        float f = ((float) this.age + color) / (float) this.lifetime;
        f = Mth.clamp(f, 0.0F, 1.0F);
        int i = super.getLightColor(color);
        int j = i & 255;
        int k = i >> 16 & 255;
        j = j + (int) (f * 15.0F * 16.0F);
        if (j > 240) {
            j = 240;
        }

        return j | k << 16;
    }

    @Override
    public ParticleType<?> getType() {
        return null;
    }

    @Override
    public void writeToNetwork(FriendlyByteBuf p_197553_1_) {

    }

    @Override
    public String writeToString() {
        return null;
    }


    public static class Factory implements ParticleProvider<BoricParticleData> {
        private final SpriteSet spriteSet;

        public Factory(SpriteSet spriteIn) {
            this.spriteSet = spriteIn;
        }

        public Particle createParticle(BoricParticleData particle, ClientLevel world, double x, double y, double z, double motionX, double motionY, double motionZ) {
            BoricFlameParticle flameparticle = new BoricFlameParticle(world, x, y, z, motionX, motionY, motionZ);
            flameparticle.pickSprite(spriteSet);
            return flameparticle;
        }
    }

    public static class BoricParticleData implements ParticleOptions {
        public static final BoricParticleData BORIC = new BoricParticleData(0.0F, 1.0F, 0.2F, 1.0F);
        public static final Codec<BoricParticleData> CODEC = RecordCodecBuilder.create((p_239803_0_) -> {
            return p_239803_0_.group(Codec.FLOAT.fieldOf("r").forGetter((p_239807_0_) -> {
                return p_239807_0_.red;
            }), Codec.FLOAT.fieldOf("g").forGetter((p_239806_0_) -> {
                return p_239806_0_.green;
            }), Codec.FLOAT.fieldOf("b").forGetter((p_239805_0_) -> {
                return p_239805_0_.blue;
            }), Codec.FLOAT.fieldOf("scale").forGetter((p_239804_0_) -> {
                return p_239804_0_.alpha;
            })).apply(p_239803_0_, BoricParticleData::new);
        });

        public static final Deserializer<BoricParticleData> DESERIALIZER = new Deserializer<BoricParticleData>() {

            @Override
            public BoricParticleData fromCommand(ParticleType<BoricParticleData> particleTypeIn,
                                                 StringReader reader) throws CommandSyntaxException {
                reader.expect(' ');
                float red = (float) reader.readDouble();
                reader.expect(' ');
                float green = (float) reader.readDouble();
                reader.expect(' ');
                float blue = (float) reader.readDouble();
                reader.expect(' ');
                float alpha = (float) reader.readDouble();
                return new BoricParticleData(red, green, blue, alpha);
            }



            @Override
            public BoricParticleData fromNetwork(ParticleType<BoricParticleData> particleTypeIn, FriendlyByteBuf buffer) {
                return new BoricParticleData(buffer.readFloat(), buffer.readFloat(), buffer.readFloat(),
                        buffer.readFloat());
            }
        };

        private final float red;
        private final float green;
        private final float blue;
        private final float alpha;

        public BoricParticleData(float redIn, float greenIn, float blueIn, float alphaIn) {
            this.red = redIn;
            this.green = greenIn;
            this.blue = blueIn;
            this.alpha = Mth.clamp(alphaIn, 0.01f, 4.0f);
        }

        @Override
        public ParticleType<?> getType() {
            return null;
        }

        @Override
        public void writeToNetwork(FriendlyByteBuf buffer) {
            buffer.writeFloat(this.red);
            buffer.writeFloat(this.green);
            buffer.writeFloat(this.blue);
            buffer.writeFloat(this.alpha);
        }

        @Override
        public String writeToString() {
            return String.format(Locale.ROOT, "%s %.2f %.2f %.2f %.2f", Registry.PARTICLE_TYPE.getKey(this.getType()),
                    this.red, this.green, this.blue, this.alpha);
        }
    }
}