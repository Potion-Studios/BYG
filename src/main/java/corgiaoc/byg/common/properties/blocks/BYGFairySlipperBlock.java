package corgiaoc.byg.common.properties.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.potion.Effect;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.Tags;

import net.minecraft.block.AbstractBlock.OffsetType;
import net.minecraft.block.AbstractBlock.Properties;

public class BYGFairySlipperBlock extends BushBlock {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);

    public BYGFairySlipperBlock(Properties properties) {
        super(properties);
    }

    public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
        Vector3d Vector3d = state.getOffset(reader, pos);
        return SHAPE.withOffset(Vector3d.x, Vector3d.y, Vector3d.z);
    }

    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.getBlock().isIn(BlockTags.LOGS) || state.getBlock().isIn(Tags.Blocks.DIRT);
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos posDown = pos.down();
        return this.isValidGround(worldIn.getBlockState(posDown), worldIn, posDown);
    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

}