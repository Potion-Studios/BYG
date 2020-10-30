package corgiaoc.byg.common.properties.blocks.nether;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.Tags;

import net.minecraft.block.AbstractBlock.Properties;

public class DoubleNetherPlantBlock extends DoublePlantBlock {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);

    protected DoubleNetherPlantBlock(Properties builder) {
        super(builder);

    }

    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.isIn(BlockTags.NYLIUM) || state.isIn(Blocks.MYCELIUM) || state.isIn(Blocks.SOUL_SOIL) || state.isIn(Tags.Blocks.END_STONES) || super.isValidGround(state, worldIn, pos);
    }
}

