package corgiaoc.byg.common.properties.blocks.end;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class StoneEndPlantBlock extends BushBlock {
    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);

    public StoneEndPlantBlock(Properties builder) {
        super(builder);

    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos map, ISelectionContext ctx) {
        Vector3d Vector3d = state.getOffset(reader, map);
        return SHAPE.move(Vector3d.x, Vector3d.y, Vector3d.z);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (random.nextInt(25) == 0) {
            int i = 5;
            int j = 4;

            for(BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-4, -1, -4), pos.offset(4, 1, 4))) {
                if (worldIn.getBlockState(blockpos).is(this)) {
                    --i;
                    if (i <= 0) {
                        return;
                    }
                }
            }

            BlockPos blockpos1 = pos.offset(random.nextInt(3) - 1, random.nextInt(2) - random.nextInt(2), random.nextInt(3) - 1);

            for(int k = 0; k < 4; ++k) {
                if (worldIn.isEmptyBlock(blockpos1) && state.canSurvive(worldIn, blockpos1)) {
                    pos = blockpos1;
                }

                blockpos1 = pos.offset(random.nextInt(3) - 1, random.nextInt(2) - random.nextInt(2), random.nextInt(3) - 1);
            }

            if (worldIn.isEmptyBlock(blockpos1) && state.canSurvive(worldIn, blockpos1)) {
                worldIn.setBlock(blockpos1, state, 2);
            }
        }

    }

    @Override
    protected boolean mayPlaceOn(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.is(BYGBlocks.CRYPTIC_MAGMA_BLOCK) || state.is(BYGBlocks.CRYPTIC_STONE) || state.is(BYGBlocks.CRYPTIC_REDSTONE_ORE) || super.mayPlaceOn(state, worldIn, pos);
    }

    @Override
    public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.below();
        return this.mayPlaceOn(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }
}

