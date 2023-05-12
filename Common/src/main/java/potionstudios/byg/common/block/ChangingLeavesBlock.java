package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class ChangingLeavesBlock extends BYGLeavesBlock implements BonemealableBlock {
    private final Supplier<LeavesBlock> next;
    private final float chance;

    public ChangingLeavesBlock(Properties properties, Supplier<LeavesBlock> next, float chance, Supplier<ParticleOptions> particleTypes) {
        super(properties, particleTypes);
        this.next = next;
        this.chance = chance;
    }

    @Override
    public boolean isRandomlyTicking(BlockState blockState) {
        return !blockState.getValue(PERSISTENT);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel serverLevel, BlockPos pos, RandomSource randomSource) {
        super.randomTick(state, serverLevel, pos, randomSource);

        if (randomSource.nextFloat() < chance) {
            placeNext(state, serverLevel, pos);
        }
    }

    private void placeNext(BlockState state, Level level, BlockPos pos) {
        level.setBlock(pos, next.get().defaultBlockState().setValue(DISTANCE, state.getValue(DISTANCE)).setValue(PERSISTENT, state.getValue(PERSISTENT)), 2);
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState, boolean b) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        return randomSource.nextFloat() < 0.5F;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        placeNext(blockState, level, blockPos);
    }
}
