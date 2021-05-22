package corgiaoc.byg.common.world.feature.blockplacer;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.blockplacer.BlockPlacer;
import net.minecraft.world.gen.blockplacer.BlockPlacerType;

import java.util.Random;

public class DoubleBlockPlacer extends BlockPlacer {
    public static final Codec<DoubleBlockPlacer> CODEC = Codec.unit(DoubleBlockPlacer::new);

    protected BlockPlacerType<?> type() {
        return BYGBlockPlacerTypes.DOUBLE_BLOCK;
    }

    public void place(IWorld world, BlockPos pos, BlockState state, Random random) {
        placeAt(world, pos, state, 2);
    }

    public void placeAt(IWorld worldIn, BlockPos pos, BlockState state, int flags) {
        if (state.hasProperty(BlockStateProperties.DOUBLE_BLOCK_HALF)) {
            worldIn.setBlock(pos, state.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER), flags);
            worldIn.setBlock(pos.above(), state.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), flags);
        } else {
            worldIn.setBlock(pos, state, flags);
        }
    }
}
