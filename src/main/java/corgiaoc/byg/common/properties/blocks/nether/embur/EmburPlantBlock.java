package corgiaoc.byg.common.properties.blocks.nether.embur;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import java.util.Random;

public class EmburPlantBlock extends PlantBlock implements Fertilizable {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);

    protected EmburPlantBlock(Settings builder) {
        super(builder);

    }

    /**
     * Whether this IGrowable can grow
     */
    public boolean isFertilizable(BlockView worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    public boolean canGrow(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        TallPlantBlock doubleplantblock = (TallPlantBlock) (this == BYGBlocks.EMBUR_ROOTS ? BYGBlocks.TALL_EMBUR_ROOTS : BYGBlocks.TALL_EMBUR_ROOTS);
        if (doubleplantblock.getDefaultState().canPlaceAt(worldIn, pos) && worldIn.isAir(pos.up())) {
            doubleplantblock.placeAt(worldIn, pos, 2);
        }

    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView reader, BlockPos pos, ShapeContext ctx) {
        Vec3d vector = state.getModelOffset(reader, pos);
        return SHAPE.offset(vector.x, vector.y, vector.z);
    }

    @Override
    protected boolean canPlantOnTop(BlockState state, BlockView worldIn, BlockPos pos) {
        return state.isIn(BlockTags.NYLIUM) || state.isOf(Blocks.MYCELIUM) || state.isOf(Blocks.SOUL_SOIL) || super.canPlantOnTop(state, worldIn, pos);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        return this.canPlantOnTop(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }

}

