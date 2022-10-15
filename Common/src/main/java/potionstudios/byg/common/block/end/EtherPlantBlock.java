package potionstudios.byg.common.block.end;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
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
import potionstudios.byg.common.block.BYGBlocks;

public class EtherPlantBlock extends BushBlock implements BonemealableBlock{
    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);

    public EtherPlantBlock(Properties builder) {
        super(builder);

    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos map, CollisionContext ctx) {
        Vec3 Vector3d = state.getOffset(reader, map);
        return SHAPE.move(Vector3d.x, Vector3d.y, Vector3d.z);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return state.is(BYGBlocks.ETHER_PHYLIUM.get()) || state.is(BYGBlocks.ETHER_SOIL.get()) || super.mayPlaceOn(state, worldIn, pos);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.below();
        return this.mayPlaceOn(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState, boolean bl) {
        return blockGetter.getBlockState(blockPos.above()).isAir();
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos blockPos, BlockState blockState) {
        return (double)level.random.nextFloat() < 0.45D;
    }

    public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState blockState) {
        DoublePlantBlock doubleplantblock = BYGBlocks.TALL_ETHER_GRASS.get();
        if (doubleplantblock.defaultBlockState().canSurvive(world, pos) && world.isEmptyBlock(pos.above())) {
            DoublePlantBlock.placeAt(world, blockState, pos, 2);
        }
    }


}

