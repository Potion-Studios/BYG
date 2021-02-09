package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.common.world.feature.overworld.trees.util.TreeSpawner;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.*;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.Tags;

import java.util.Random;

public class BYGSapling extends BushBlock implements IGrowable {
    public static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
    public static final IntegerProperty STAGE = BlockStateProperties.STAGE_0_1;
    private final TreeSpawner tree;
    private final int taskRange;

    public BYGSapling(Properties properties, TreeSpawner tree, int taskRange) {
        super(properties);
        this.tree = tree;
        this.taskRange = taskRange;
        this.setDefaultState(this.stateContainer.getBaseState().with(STAGE, 0));
    }

    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        Block block = state.getBlock();
        if (this == BYGBlocks.PALM_SAPLING) {
            if (state.getBlock().isIn(Tags.Blocks.SAND))
                return true;
        }
        return state.isIn(Tags.Blocks.DIRT);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        super.tick(state, worldIn, pos, rand);
        if (!worldIn.isAreaLoaded(pos, 1))
            return;
        if (worldIn.getLight(pos.up()) >= 9 && rand.nextInt(7) == 0) {
            this.grow(worldIn, pos, state, rand);
        }

    }

    public void grow(ServerWorld world, BlockPos pos, BlockState state, Random rand) {
        if (state.get(STAGE) == 0) {
            world.setBlockState(pos, state.func_235896_a_(STAGE), 4);
        } else {
            if (!net.minecraftforge.event.ForgeEventFactory.saplingGrowTree(world, rand, pos)) return;
            this.tree.spawn(world, world.getChunkProvider().getChunkGenerator(), pos, state, rand);
        }
    }

    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return (double) worldIn.rand.nextFloat() < 0.45D;
    }

    @Override
    public void grow(ServerWorld world, Random rand, BlockPos pos, BlockState state) {
        this.grow(world, pos, state, rand);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(STAGE);
    }
}