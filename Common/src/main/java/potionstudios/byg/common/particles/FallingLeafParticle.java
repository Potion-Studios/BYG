package potionstudios.byg.common.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;

public class FallingLeafParticle extends TextureSheetParticle {
    protected FallingLeafParticle(ClientLevel world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        super(world, x, y, z - 0.125D, xSpeed, ySpeed, zSpeed);
        this.quadSize *= this.random.nextFloat() * 0.6F + 0.6F;
        this.lifetime = (int) (16.0D / (Math.random() * 0.8D + 0.2D));
        this.hasPhysics = false;
        this.friction = 1.0F;
        this.gravity = 0.0F;
        this.setSize(0.01F, 0.01F);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

//    @Override
//    public void move(double $$0, double $$1, double $$2) {
//        this.setBoundingBox(this.getBoundingBox().move($$0, $$1, $$2));
//        this.setLocationFromBoundingbox();
//    }

//    @Override
//    public void tick() {
//        this.xo = this.x;
//        this.yo = this.y;
//        this.zo = this.z;
//        if (this.lifetime-- <= 0) {
//            this.remove();
//        } else {
//            this.move(this.xd, this.yd, this.zd);
//            this.xd *= 0.99D;
//            this.yd *= 0.99D;
//            this.zd *= 0.99D;
//        }
//    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {

        private final SpriteSet sprite;

        public Provider(SpriteSet sprite) {
            this.sprite = sprite;
        }

        @Nullable
        @Override
        public Particle createParticle(SimpleParticleType var1, ClientLevel world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            FallingLeafParticle leaf = new FallingLeafParticle(world, x, y, z, 0.0D, -0.800000011920929D, 0.0D);
            leaf.lifetime = Mth.randomBetweenInclusive(world.random, 500, 1000);
            leaf.gravity = 0.01F;
            leaf.setColor(1.0f, 1.0f, 1.0f);
            leaf.setSpriteFromAge(this.sprite);
            return leaf;
        }

    }
}
