//package voronoiaoc.byg.client.particle;
//
//import net.minecraft.client.particle.*;
//import net.minecraft.particles.BasicParticleType;
//import net.minecraft.world.World;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//
//public class NyliumParticle extends SpriteTexturedParticle {
//    private final double coordX;
//    private final double coordY;
//    private final double coordZ;
//
//    private NyliumParticle(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn) {
//        super(worldIn, xCoordIn, yCoordIn, zCoordIn);
//        this.motionX = xSpeedIn;
//        this.motionY = ySpeedIn;
//        this.motionZ = zSpeedIn;
//        this.coordX = xCoordIn;
//        this.coordY = yCoordIn;
//        this.coordZ = zCoordIn;
//        this.prevPosX = xCoordIn + xSpeedIn;
//        this.prevPosY = yCoordIn + ySpeedIn;
//        this.prevPosZ = zCoordIn + zSpeedIn;
//        this.posX = this.prevPosX;
//        this.posY = this.prevPosY;
//        this.posZ = this.prevPosZ;
//        this.particleScale = 0.2F * (this.rand.nextFloat() * 0.5F + 0.2F);
//        float f = this.rand.nextFloat() * 0.6F + 0.4F;
//        this.particleRed = 0.9F * f;
//        this.particleGreen = 0.9F * f;
//        this.particleBlue = f;
//        this.canCollide = false;
//        //Age is essentially how far it travels.
//        this.maxAge = 280;
//        //Gravity.
//        this.particleGravity = 0;
//        //Amplifies the scale of the particle
//        this.multiplyParticleScaleBy(3.0F);
//        this.setSize(0.25F, 0.25F);
//    }
//
//    public IParticleRenderType getRenderType() {
//        return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
//    }
//
//    public void move(double x, double y, double z) {
//        this.setBoundingBox(this.getBoundingBox().offset(x, y, z));
//        this.resetPositionToBB();
//    }
//
//    public int getBrightnessForRender(float partialTick) {
//        int i = super.getBrightnessForRender(partialTick);
//        float age = (float) this.age / (float) this.maxAge;
//        age = age * age;
//        age = age * age;
//        int j = i & 255;
//        int k = i >> 16 & 255;
//        k = k + (int) (age * 15.0F * 16.0F);
//        if (k > 240) {
//            k = 240;
//        }
//
//        return j | k << 16;
//    }
//
//    public void tick() {
//        this.prevPosX = this.posX;
//        this.prevPosY = this.posY;
//        this.prevPosZ = this.posZ;
//        if (this.age++ < this.maxAge && !(this.particleAlpha <= 0.0F)) {
//            this.motionX += this.rand.nextFloat() / 5000.0F;
//            this.motionY -= this.particleGravity;
//            this.motionZ += this.rand.nextFloat() / 5000.0F;
//            this.move(this.motionX, this.motionY, this.motionZ);
//            if (this.age >= this.maxAge - 60 && this.particleAlpha > 0.01F) {
//                this.particleAlpha -= 0.015F;
//            }
//
//        } else {
//            this.setExpired();
//        }
//    }
//
//    @OnlyIn(Dist.CLIENT)
//    public static class Factory implements IParticleFactory<BasicParticleType> {
//        private final IAnimatedSprite spriteSet;
//
//        public Factory(IAnimatedSprite sheet) {
//            this.spriteSet = sheet;
//        }
//
//        public Particle makeParticle(BasicParticleType typeIn, World worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
//            NyliumParticle enchantmenttableparticle = new NyliumParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
//            enchantmenttableparticle.selectSpriteRandomly(this.spriteSet);
//            return enchantmenttableparticle;
//        }
//    }
//}