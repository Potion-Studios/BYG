package potionstudios.byg.common.block.end;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.common.block.BYGBlocks;

public class TallEtherGrassBlock extends DoublePlantBlock {
    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);

    public TallEtherGrassBlock(Properties builder) {
        super(builder);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, @NotNull BlockGetter worldIn, @NotNull BlockPos pos) {
        return state.is(BYGBlocks.ETHER_PHYLIUM.get()) || state.is(BYGBlocks.ETHER_SOIL.get()) || super.mayPlaceOn(state, worldIn, pos);
    }
}

