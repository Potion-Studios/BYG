package voronoiaoc.byg.common.properties.blocks.embur;

import net.minecraft.block.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.server.ServerWorld;
import voronoiaoc.byg.common.properties.BYGBlockProperties;
import voronoiaoc.byg.core.byglists.BYGBlockList;

public class DoubleNetherPlantBlock extends DoublePlantBlock {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);

    protected DoubleNetherPlantBlock(Properties builder) {
        super(builder);

    }
    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.isIn(BlockTags.NYLIUM) || state.isIn(Blocks.MYCELIUM) || state.isIn(Blocks.SOUL_SOIL) || super.isValidGround(state, worldIn, pos);
    }
}

