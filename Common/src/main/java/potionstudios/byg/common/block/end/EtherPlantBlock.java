package potionstudios.byg.common.block.end;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import potionstudios.byg.common.block.BYGBlocks;

import java.util.Random;
import java.util.function.Supplier;

public class EtherPlantBlock extends BushBlock implements BonemealableBlock{
    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);
    @Nullable
    private final Supplier<DoublePlantBlock> tallPlant;

    public EtherPlantBlock(Properties builder, @Nullable Supplier<DoublePlantBlock> tallPlant) {
        super(builder);
        this.tallPlant = tallPlant;
    }

    public @NotNull OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter reader, @NotNull BlockPos map, @NotNull CollisionContext ctx) {
        Vec3 Vector3d = state.getOffset(reader, map);
        return SHAPE.move(Vector3d.x, Vector3d.y, Vector3d.z);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, @NotNull BlockGetter worldIn, @NotNull BlockPos pos) {
        return state.is(BYGBlocks.ETHER_PHYLIUM.get()) || state.is(BYGBlocks.ETHER_SOIL.get()) || super.mayPlaceOn(state, worldIn, pos);
    }

    @Override
    public boolean canSurvive(@NotNull BlockState state, @NotNull LevelReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.below();
        return this.mayPlaceOn(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }

    @Override
    public boolean isValidBonemealTarget(@NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull BlockState blockState, boolean bl) {
        return tallPlant != null && blockGetter.getBlockState(blockPos.above()).isAir();
    }

    @Override
    public boolean isBonemealSuccess(@NotNull Level level, @NotNull Random random, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return tallPlant != null && level.random.nextFloat() < 0.45F;
    }

    public void performBonemeal(@NotNull ServerLevel world, @NotNull Random random, @NotNull BlockPos pos, @NotNull BlockState blockState) {
        if (tallPlant == null)
            return;
        DoublePlantBlock doubleplantblock = tallPlant.get();
        if (doubleplantblock.defaultBlockState().canSurvive(world, pos) && world.isEmptyBlock(pos.above())) {
            DoublePlantBlock.placeAt(world, doubleplantblock.defaultBlockState(), pos, Block.UPDATE_CLIENTS);
        }
    }

}