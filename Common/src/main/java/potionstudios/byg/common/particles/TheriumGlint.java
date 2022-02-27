package potionstudios.byg.common.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.Nullable;

public class TheriumGlint extends TextureSheetParticle {


    protected TheriumGlint(ClientLevel world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        super(world, x, y, z, xSpeed, ySpeed, zSpeed);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age-- <= 0) {
            this.remove();
        }else{
            this.move(this.xd, this.yd, this.zd);
            this.xd *= 1.0;
        }
    }

    public static class Provider implements ParticleProvider<SimpleParticleType>{

        private final SpriteSet sprite;

        public Provider(SpriteSet sprite){
            this.sprite = sprite;
        }
        @Nullable
        @Override
        public Particle createParticle(SimpleParticleType var1, ClientLevel world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            TheriumGlint glint = new TheriumGlint(world, x, y, z, xSpeed, ySpeed, zSpeed);
            glint.setColor(1.0f, 1.0f, 1.0f);
            glint.setSpriteFromAge(this.sprite);
            return glint;
        }
    }
}
