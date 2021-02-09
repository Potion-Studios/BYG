package corgiaoc.byg.common.properties.blocks.nether.scorched;

import corgiaoc.byg.util.FabricTags;
import net.minecraft.block.*;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class ScorchedPlantBlock extends PlantBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);

    protected ScorchedPlantBlock(Settings builder) {
        super(builder);

    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView worldIn, BlockPos pos, ShapeContext context) {
        Vec3d lvt_5_1_ = state.getModelOffset(worldIn, pos);
        return SHAPE.offset(lvt_5_1_.x, lvt_5_1_.y, lvt_5_1_.z);
    }

    @Override
    protected boolean canPlantOnTop(BlockState state, BlockView worldIn, BlockPos pos) {
        return state.isIn(BlockTags.NYLIUM) || state.isOf(Blocks.MYCELIUM) || state.isOf(Blocks.SOUL_SOIL) || state.isIn(BlockTags.BASE_STONE_NETHER) || state.isIn(FabricTags.END_STONES) || super.canPlantOnTop(state, worldIn, pos);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        return this.canPlantOnTop(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }
}

