package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import potionstudios.byg.mixin.access.SpreadableSnowyDirtBlockAccess;

import java.util.Random;

public class BYGGrassBlock extends GrassBlock implements BonemealableBlock {

    private final Block dirtBlock;

    public BYGGrassBlock(Properties properties, Block dirtBlock) {
        super(properties);
        this.dirtBlock = dirtBlock;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
        if (!SpreadableSnowyDirtBlockAccess.byg_invokeCanBeGrass(state, world, pos)) {
            world.setBlockAndUpdate(pos, this.dirtBlock.defaultBlockState());
            return;
        }
        if (world.getMaxLocalRawBrightness(pos.above()) >= 9) {
            BlockState blockstate = this.defaultBlockState();

            for (int i = 0; i < 4; ++i) {
                BlockPos blockpos = pos.offset(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                if (world.getBlockState(blockpos).is(this.dirtBlock) && SpreadableSnowyDirtBlockAccess.byg_invokeCanPropagate(blockstate, world, blockpos)) {
                    world.setBlockAndUpdate(blockpos, blockstate.setValue(SNOWY, world.getBlockState(blockpos.above()).is(Blocks.SNOW)));
                }
            }
        }
    }
}
