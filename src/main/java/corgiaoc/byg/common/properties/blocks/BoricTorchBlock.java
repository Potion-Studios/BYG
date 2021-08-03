package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.client.particle.BoricFlameParticle;
import net.minecraft.block.TorchBlock;
import net.minecraft.particles.IParticleData;

public class BoricTorchBlock extends TorchBlock {
    public BoricTorchBlock(Properties properties, IParticleData data) {
        super(properties, BoricFlameParticle.BoricParticleData.BORIC);
    }
}
