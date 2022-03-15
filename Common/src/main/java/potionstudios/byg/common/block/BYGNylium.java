package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.NyliumBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import potionstudios.byg.mixin.access.NyliumBlockAccess;

import java.util.Random;

public class BYGNylium extends NyliumBlock {

    private final RandomPatchConfiguration featureConfig;
    private final Block dirtBlock;

    public BYGNylium(Properties properties, RandomPatchConfiguration featureConfig, Block dirtBlock) {
        super(properties);
        this.featureConfig = featureConfig;
        this.dirtBlock = dirtBlock;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
        if (!NyliumBlockAccess.byg_invokeCanBeNylium(state, world, pos)) {
            world.setBlockAndUpdate(pos, this.dirtBlock.defaultBlockState());
        }
    }

    @Override
    public boolean isBonemealSuccess(Level $$0, Random $$1, BlockPos $$2, BlockState $$3) {
        return this.featureConfig != null;
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter $$0, BlockPos $$1, BlockState $$2, boolean $$3) {
        return this.featureConfig != null;
    }

    @Override
    public void performBonemeal(ServerLevel world, Random rand, BlockPos pos, BlockState state) {
        BlockState blockstate = world.getBlockState(pos);
        BlockPos blockpos = pos.above();
        if (blockstate.is(this) && this.featureConfig != null) {
            BYGGrassBlock.place(world, rand, blockpos, featureConfig);
        }

        if (rand.nextInt(8) == 0) {

            //TODO: 1.18
//          TwistingVinesFeature.place(world, rand, blockpos, 3, 1, 2);
        }
    }
}
