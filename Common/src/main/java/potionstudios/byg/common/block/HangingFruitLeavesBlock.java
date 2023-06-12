package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class HangingFruitLeavesBlock extends BYGLeavesBlock implements BonemealableBlock {
    private final Supplier<BlockState> fruitBlock;
    private final float tickSpawnChance;

    public HangingFruitLeavesBlock(Properties properties, Supplier<BlockState> fruitBlock, Supplier<ParticleOptions> particleType, float tickSpawnChance) {
        super(properties, particleType);
        this.fruitBlock = fruitBlock;
        this.tickSpawnChance = tickSpawnChance;
    }

    @Override
    public boolean isRandomlyTicking(BlockState $$0) {
        return !$$0.getValue(PERSISTENT);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource randomSource) {
        super.randomTick(state, level, pos, randomSource);
        BlockPos fruitPos = pos.below();

        if (randomSource.nextFloat() < this.tickSpawnChance && level.getBlockState(fruitPos).isAir()) {
            placeFruit(level, fruitPos);
        }
    }

    private void placeFruit(Level level, BlockPos pos) {
        level.setBlock(pos, fruitBlock.get(), 2);
    }


    @Override
    public boolean isValidBonemealTarget(LevelReader blockGetter, BlockPos blockPos, BlockState blockState, boolean b) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        return randomSource.nextFloat() < 0.5F && level.getBlockState(blockPos.below()).isAir();
    }

    @Override
    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        placeFruit(serverLevel, blockPos.below());
    }
}
