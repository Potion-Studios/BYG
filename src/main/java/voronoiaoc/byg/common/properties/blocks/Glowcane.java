package voronoiaoc.byg.common.properties.blocks;

import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Glowcane extends Block {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_15;
    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);

    protected Glowcane(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(0)));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    public void animateTick(BlockState state, Level world, BlockPos pos, Random rand) {
        if (world.isEmptyBlock(pos.above())) {
            int i;
            for (i = 1; world.getBlockState(pos.below(i)).is(this); ++i) {
            }

            if (i < 3) {
                int j = state.getValue(AGE);
                if (j == 15) {
                    world.setBlockAndUpdate(pos.above(), this.defaultBlockState());
                    world.setBlock(pos, state.setValue(AGE, 0), 4);
                } else {
                    world.setBlock(pos, state.setValue(AGE, j + 1), 4);
                }
            }
        }

    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction direction, BlockState newState, LevelAccessor worldIn, BlockPos pos, BlockPos posFrom) {
        if (!stateIn.canSurvive(worldIn, pos)) {
            worldIn.getBlockTicks().scheduleTick(pos, this, 1);
        }

        return super.updateShape(stateIn, direction, newState, worldIn, pos, posFrom);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        BlockState soil = worldIn.getBlockState(pos.below());
        if (soil.getBlock() == BYGBlockList.GLOWCELIUM)
            return true;
        Block block = worldIn.getBlockState(pos.below()).getBlock();
        if (block == this) {
            return true;
        } else {
            if (block == BYGBlockList.GLOWCELIUM) {

            }

            return false;
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}