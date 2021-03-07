package corgiaoc.byg.common.properties.blocks.end.shattereddesert;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

import net.minecraft.block.AbstractBlock.Properties;

public class OddityCactusBlock extends Block {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_0_15;
    protected static final VoxelShape COLLISION_SHAPE = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 15.0D);
    protected static final VoxelShape OUTLINE_SHAPE = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public OddityCactusBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(0)));
    }

    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent growing cactus from loading unloaded chunks with block update
        if (!state.isValidPosition(worldIn, pos)) {
            worldIn.destroyBlock(pos, true);
        }

    }

    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        BlockPos blockpos = pos.up();
        if (worldIn.isAirBlock(blockpos)) {
            int i;
            for(i = 1; worldIn.getBlockState(pos.down(i)).isIn(this); ++i) {
            }

            if (i < 3) {
                int j = state.get(AGE);
                if(net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, blockpos, state, true)) {
                    if (j == 15) {
                        worldIn.setBlockState(blockpos, this.getDefaultState());
                        BlockState blockstate = state.with(AGE, Integer.valueOf(0));
                        worldIn.setBlockState(pos, blockstate, 4);
                        blockstate.neighborChanged(worldIn, blockpos, this, pos, false);
                    } else {
                        worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(j + 1)), 4);
                    }
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
                }
            }
        }
    }

    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return COLLISION_SHAPE;
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return OUTLINE_SHAPE;
    }

    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (!stateIn.isValidPosition(worldIn, currentPos)) {
            worldIn.getPendingBlockTicks().scheduleTick(currentPos, this, 1);
        }

        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            BlockState blockstate = worldIn.getBlockState(pos.offset(direction));
            Material material = blockstate.getMaterial();
            if (material.isSolid() || worldIn.getFluidState(pos.offset(direction)).isTagged(FluidTags.LAVA)) {
                return false;
            }
        }

        return worldIn.getBlockState(pos.down()).getBlock() == Blocks.END_STONE || worldIn.getBlockState(pos.down()).getBlock() == Blocks.END_STONE_BRICKS || worldIn.getBlockState(pos.down()).getBlock() == BYGBlocks.END_SAND || worldIn.getBlockState(pos.down()).getBlock() == BYGBlocks.ODDITY_CACTUS && !worldIn.getBlockState(pos.up()).getMaterial().isLiquid();
    }

    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn instanceof LivingEntity && entityIn.getType() != EntityType.ENDERMITE && entityIn.getType() != EntityType.ENDERMAN)
            entityIn.setMotionMultiplier(state, new Vector3d(0.8F, 0.75D, 0.8F));
            entityIn.attackEntityFrom(DamageSource.CACTUS, 2.0F);
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        return false;
    }


}


