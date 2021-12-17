package potionstudios.byg.common.block;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.level.block.TorchBlock;
import potionstudios.byg.client.particle.BoricFlameParticle;

public class BoricTorchBlock extends TorchBlock {
    public BoricTorchBlock(Properties properties, ParticleOptions data) {
        super(properties, BoricFlameParticle.BoricParticleData.BORIC);
    }
}
