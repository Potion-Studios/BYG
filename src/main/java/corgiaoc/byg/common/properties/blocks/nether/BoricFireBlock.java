package corgiaoc.byg.common.properties.blocks.nether;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class BoricFireBlock extends BaseFireBlock {

    protected BoricFireBlock(Properties properties) {
        super(properties, 3.5F);
    }

    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
        return this.canSurvive(stateIn, worldIn, currentPos) ? this.defaultBlockState() : Blocks.AIR.defaultBlockState();
    }

    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        return shouldLightBoricFire(worldIn.getBlockState(pos.below()).getBlock());
    }

    public static boolean shouldLightBoricFire(Block block) {
        return block == BYGBlocks.BRIMSTONE;
    }

    protected boolean canBurn(BlockState state) {
        return true;
    }
}
