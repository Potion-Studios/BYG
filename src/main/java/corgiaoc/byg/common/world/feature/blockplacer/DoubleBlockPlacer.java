package corgiaoc.byg.common.world.feature.blockplacer;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.feature.blockplacers.BlockPlacer;
import net.minecraft.world.level.levelgen.feature.blockplacers.BlockPlacerType;

import java.util.Random;

public class DoubleBlockPlacer extends BlockPlacer {
    public static final Codec<DoubleBlockPlacer> CODEC = Codec.unit(DoubleBlockPlacer::new);

    protected BlockPlacerType<?> type() {
        return BYGBlockPlacerTypes.DOUBLE_BLOCK;
    }

    public void place(LevelAccessor world, BlockPos pos, BlockState state, Random random) {
        placeAt(world, pos, state, 2);
    }

    public void placeAt(LevelAccessor worldIn, BlockPos pos, BlockState state, int flags) {
        if (state.hasProperty(BlockStateProperties.DOUBLE_BLOCK_HALF)) {
            worldIn.setBlock(pos, state.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER), flags);
            worldIn.setBlock(pos.above(), state.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), flags);
        } else {
            worldIn.setBlock(pos, state, flags);
        }
    }
}
