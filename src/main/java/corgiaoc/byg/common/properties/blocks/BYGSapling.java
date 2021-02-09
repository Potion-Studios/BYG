package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.common.world.feature.overworld.trees.util.TreeSpawner;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.util.FabricTags;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

public class BYGSapling extends PlantBlock implements Fertilizable {
    public static final VoxelShape SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
    public static final IntProperty STAGE = Properties.STAGE;
    private final TreeSpawner tree;
    private final int taskRange;

    public BYGSapling(Settings properties, TreeSpawner tree, int taskRange) {
        super(properties);
        this.tree = tree;
        this.taskRange = taskRange;
        this.setDefaultState(this.stateManager.getDefaultState().with(STAGE, 0));
    }

    @Override
    protected boolean canPlantOnTop(BlockState state, BlockView worldIn, BlockPos pos) {
        Block block = state.getBlock();

        if (this == BYGBlocks.PALM_SAPLING) {
            if (state.getBlock().isIn(FabricTags.SAND))
                return true;
        }
        return block == Blocks.GRASS_BLOCK || state.isIn(FabricTags.DIRT) || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL || block == Blocks.FARMLAND || block == BYGBlocks.OVERGROWN_STONE || block == BYGBlocks.MEADOW_GRASSBLOCK || block == BYGBlocks.MEADOW_DIRT;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView worldIn, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        super.scheduledTick(state, worldIn, pos, rand);
        if (worldIn.getLightLevel(pos.up()) >= 9 && rand.nextInt(7) == 0) {
            this.grow(worldIn, pos, state, rand);
        }

    }

    public void grow(ServerWorld world, BlockPos pos, BlockState state, Random rand) {
        if (state.get(STAGE) == 0) {
            world.setBlockState(pos, state.cycle(STAGE), 4);
        } else {
            this.tree.spawn(world, world.getChunkManager().getChunkGenerator(), pos, state, rand);
        }
    }

    @Override
    public boolean isFertilizable(BlockView worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canGrow(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return (double) worldIn.random.nextFloat() < 0.45D;
    }

    @Override
    public void grow(ServerWorld world, Random rand, BlockPos pos, BlockState state) {
        this.grow(world, pos, state, rand);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(STAGE);
    }
}