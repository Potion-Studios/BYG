package potionstudios.byg.common.block.nether.embur;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.common.block.BYGBlocks;

public class EmburPlantBlock extends BushBlock implements BonemealableBlock {
    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);

    protected EmburPlantBlock(Properties builder) {
        super(builder);

    }

    /**
     * Whether this IGrowable can grow
     */
    public boolean isValidBonemealTarget(@NotNull LevelReader worldIn, @NotNull BlockPos pos, @NotNull BlockState state, boolean isClient) {
        return true;
    }

    public boolean isBonemealSuccess(@NotNull Level worldIn, @NotNull RandomSource rand, @NotNull BlockPos pos, @NotNull BlockState state) {
        return true;
    }


    public void performBonemeal(@NotNull ServerLevel worldIn, @NotNull RandomSource rand, @NotNull BlockPos pos, @NotNull BlockState state) {
        DoublePlantBlock doubleplantblock = BYGBlocks.TALL_EMBUR_ROOTS.get();
        if (doubleplantblock.defaultBlockState().canSurvive(worldIn, pos) && worldIn.isEmptyBlock(pos.above())) {
            DoublePlantBlock.placeAt(worldIn, doubleplantblock.defaultBlockState(), pos, Block.UPDATE_CLIENTS);
        }

    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter reader, @NotNull BlockPos pos, @NotNull CollisionContext ctx) {
        Vec3 vector = state.getOffset(reader, pos);
        return SHAPE.move(vector.x, vector.y, vector.z);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, @NotNull BlockGetter worldIn, @NotNull BlockPos pos) {
        return state.is(BlockTags.NYLIUM) || state.is(Blocks.MYCELIUM) || state.is(Blocks.SOUL_SOIL) || super.mayPlaceOn(state, worldIn, pos);
    }

    @Override
    public boolean canSurvive(@NotNull BlockState state, @NotNull LevelReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.below();
        return this.mayPlaceOn(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }

}

