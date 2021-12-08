package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.common.world.feature.overworld.trees.util.TreeSpawner;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class FloweringJacarandaBushBlock extends JacarandaBushBlock implements IGrowable {
    public static final IntegerProperty STAGE = BlockStateProperties.STAGE;
    private final TreeSpawner tree;
    private final int taskRange;

    public FloweringJacarandaBushBlock(Properties properties, TreeSpawner tree, int taskRange) {
        super(properties);
        this.tree = tree;
        this.taskRange = taskRange;
        this.registerDefaultState(this.stateDefinition.any().setValue(STAGE, 0));
    }

    public void grow(ServerWorld world, BlockPos pos, BlockState state, Random rand) {
        if (state.getValue(STAGE) == 0) {
            world.setBlock(pos, state.cycle(STAGE), 4);
        } else {
            if (!net.minecraftforge.event.ForgeEventFactory.saplingGrowTree(world, rand, pos)) return;
            this.tree.spawn(world, world.getChunkSource().getGenerator(), pos, state, rand);
        }
    }

    @Override
    public boolean isValidBonemealTarget(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return (double) worldIn.random.nextFloat() < 0.45D;
    }

    @Override
    public void performBonemeal(ServerWorld world, Random rand, BlockPos pos, BlockState state) {
        this.grow(world, pos, state, rand);
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(STAGE);
    }

}
