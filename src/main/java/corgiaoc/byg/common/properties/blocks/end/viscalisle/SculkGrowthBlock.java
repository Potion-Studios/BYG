package corgiaoc.byg.common.properties.blocks.end.viscalisle;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class SculkGrowthBlock extends BushBlock {
    protected static final VoxelShape LEAF_PILE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 1.5D, 15.0D);

    public SculkGrowthBlock(Properties builder) {
        super(builder);
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos blockPos, ISelectionContext context) {
        return LEAF_PILE;
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
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        return facing == Direction.DOWN && !stateIn.canSurvive(worldIn, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.below();
        return canSupportRigidBlock(worldIn, blockpos) || canSupportCenter(worldIn, blockpos, Direction.UP);
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        super.animateTick(stateIn, worldIn, pos, rand);
        if (rand.nextInt(10) == 0) {
            worldIn.addParticle(ParticleTypes.MYCELIUM, (double)pos.getX() + rand.nextDouble(), (double)pos.getY() + 1.1D, (double)pos.getZ() + rand.nextDouble(), 0.0D, 0.0D, 0.0D);
        }

    }
}
