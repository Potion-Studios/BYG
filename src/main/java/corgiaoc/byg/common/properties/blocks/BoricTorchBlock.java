package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.client.particle.BoricFlameParticle;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.level.block.TorchBlock;

public class BoricTorchBlock extends TorchBlock {
    public BoricTorchBlock(Properties properties, ParticleOptions data) {
        super(properties, BoricFlameParticle.BoricParticleData.BORIC);
    }
}
