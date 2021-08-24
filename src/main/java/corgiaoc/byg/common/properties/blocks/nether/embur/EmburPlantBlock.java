package corgiaoc.byg.common.properties.blocks.nether.embur;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class EmburPlantBlock extends BushBlock implements BonemealableBlock {
    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);

    protected EmburPlantBlock(Properties builder) {
        super(builder);

    }

    /**
     * Whether this IGrowable can grow
     */
    public boolean isValidBonemealTarget(BlockGetter worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    public boolean isBonemealSuccess(Level worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    public void performBonemeal(ServerLevel worldIn, Random rand, BlockPos pos, BlockState state) {
        DoublePlantBlock doubleplantblock = (DoublePlantBlock) (this == BYGBlocks.EMBUR_ROOTS ? BYGBlocks.TALL_EMBUR_ROOTS : BYGBlocks.TALL_EMBUR_ROOTS);
        if (doubleplantblock.defaultBlockState().canSurvive(worldIn, pos) && worldIn.isEmptyBlock(pos.above())) {
            doubleplantblock.placeAt(worldIn, pos, 2);
        }

    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext ctx) {
        Vec3 vector = state.getOffset(reader, pos);
        return SHAPE.move(vector.x, vector.y, vector.z);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return state.is(BlockTags.NYLIUM) || state.is(Blocks.MYCELIUM) || state.is(Blocks.SOUL_SOIL) || super.mayPlaceOn(state, worldIn, pos);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.below();
        return this.mayPlaceOn(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }

}

