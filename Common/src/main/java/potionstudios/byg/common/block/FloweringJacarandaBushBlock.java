package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.common.world.feature.gen.overworld.trees.util.TreeSpawner;

public class FloweringJacarandaBushBlock extends JacarandaBushBlock implements BonemealableBlock {
    public static final IntegerProperty STAGE = BlockStateProperties.STAGE;
    private final TreeSpawner tree;

    public FloweringJacarandaBushBlock(Properties properties, TreeSpawner tree, int taskRange) {
        super(properties);
        this.tree = tree;
        this.registerDefaultState(this.stateDefinition.any().setValue(STAGE, 0));
    }

    public void grow(ServerLevel world, BlockPos pos, BlockState state, RandomSource rand) {
        if (state.getValue(STAGE) == 0) {
            world.setBlock(pos, state.cycle(STAGE), 4);
        } else {
            this.tree.spawn(world, world.getChunkSource().getGenerator(), pos, state, rand);
        }
    }

	@Override
    public boolean isBonemealSuccess(Level worldIn, @NotNull RandomSource rand, @NotNull BlockPos pos, @NotNull BlockState state) {
        return (double) worldIn.random.nextFloat() < 0.45D;
    }

    @Override
    public void performBonemeal(@NotNull ServerLevel world, @NotNull RandomSource rand, @NotNull BlockPos pos, @NotNull BlockState state) {
        this.grow(world, pos, state, rand);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(STAGE);
    }

}
