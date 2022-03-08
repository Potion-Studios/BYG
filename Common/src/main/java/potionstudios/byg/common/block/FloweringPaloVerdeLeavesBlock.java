package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class FloweringPaloVerdeLeavesBlock extends LeavesBlock {
    public FloweringPaloVerdeLeavesBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void animateTick(BlockState $$0, @NotNull Level $$1, @NotNull BlockPos $$2, @NotNull Random $$3) {
        int $$4 = $$2.getX();
        int $$5 = $$2.getY();
        int $$6 = $$2.getZ();
        double $$7 = (double)$$4 + 0.2D;
        double $$8 = (double)$$5 + 0.2D;
        double $$9 = (double)$$6 + 0.2D;
        $$1.addParticle(ParticleTypes.SPORE_BLOSSOM_AIR, $$7, $$8, $$9, 0.0D, 0.0D, 0.0D);
    }

}
