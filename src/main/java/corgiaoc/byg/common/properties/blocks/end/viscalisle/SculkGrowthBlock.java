package corgiaoc.byg.common.properties.blocks.end.viscalisle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class SculkGrowthBlock extends BushBlock {
    protected static final VoxelShape LEAF_PILE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 1.5D, 15.0D);

    public SculkGrowthBlock(Properties builder) {
        super(builder);
    }

    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos blockPos, CollisionContext context) {
        return LEAF_PILE;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, Random random) {
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
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
        return facing == Direction.DOWN && !stateIn.canSurvive(worldIn, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.below();
        return canSupportRigidBlock(worldIn, blockpos) || canSupportCenter(worldIn, blockpos, Direction.UP);
    }

    @Environment(EnvType.CLIENT)
    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, Random rand) {
        super.animateTick(stateIn, worldIn, pos, rand);
        if (rand.nextInt(10) == 0) {
            worldIn.addParticle(ParticleTypes.MYCELIUM, (double)pos.getX() + rand.nextDouble(), (double)pos.getY() + 1.1D, (double)pos.getZ() + rand.nextDouble(), 0.0D, 0.0D, 0.0D);
        }

    }
}
