package voronoiaoc.byg.common.properties.blocks.nether;

import net.minecraft.block.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

public class BoricFireBlock extends AbstractFireBlock {

    protected BoricFireBlock(AbstractBlock.Properties properties)  {
        super(properties, 3.5F);
    }

    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        return this.isValidPosition(stateIn, worldIn, currentPos) ? this.getDefaultState() : Blocks.AIR.getDefaultState();
    }

    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return shouldLightSoulFire(worldIn.getBlockState(pos.down()).getBlock());
    }

    public static boolean shouldLightSoulFire(Block block) {
        return block.isIn(BlockTags.SOUL_FIRE_BASE_BLOCKS);
    }

    protected boolean canBurn(BlockState state) {
        return true;
    }
}
