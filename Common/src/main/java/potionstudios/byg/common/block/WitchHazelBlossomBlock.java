package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SporeBlossomBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.client.textures.renders.BYGParticleTypes;

import java.util.Random;

public class WitchHazelBlossomBlock extends SporeBlossomBlock {
    public WitchHazelBlossomBlock(Properties blockState) {
        super(blockState);
    }

    @Override
    public void animateTick(BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Random random) {
        int $$4 = blockPos.getX();
        int $$5 = blockPos.getY();
        int $$6 = blockPos.getZ();
        double $$7 = (double)$$4 + random.nextDouble();
        double $$8 = (double)$$5 + 0.7D;
        double $$9 = (double)$$6 + random.nextDouble();
        level.addParticle(BYGParticleTypes.WITCH_HAZEL_LEAF, $$7, $$8, $$9, 0.0D, 0.0D, 0.0D);
        BlockPos.MutableBlockPos level0 = new BlockPos.MutableBlockPos();

        for(int level1 = 0; level1 < 14; ++level1) {
            level0.set($$4 + Mth.nextInt(random, -10, 10), $$5 - random.nextInt(10), $$6 + Mth.nextInt(random, -10, 10));
            BlockState level2 = level.getBlockState(level0);
            if (!level2.isCollisionShapeFullBlock(level, level0)) {
                level.addParticle(BYGParticleTypes.WITCH_HAZEL_LEAF, (double)level0.getX() + random.nextDouble(), (double)level0.getY() + random.nextDouble(), (double)level0.getZ() + random.nextDouble(), 0.0D, 0.0D, 0.0D);
            }
        }

    }
}
