package corgiaoc.byg.common.world.feature.blockplacer;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.placer.BlockPlacer;
import net.minecraft.world.gen.placer.BlockPlacerType;

import java.util.Random;

public class DoubleBlockPlacer extends BlockPlacer {
    public static final Codec<DoubleBlockPlacer> CODEC = Codec.unit(DoubleBlockPlacer::new);

    protected BlockPlacerType<?> getType() {
        return BYGBlockPlacerTypes.DOUBLE_BLOCK;
    }

    public void generate(WorldAccess world, BlockPos pos, BlockState state, Random random) {
        placeAt(world, pos, state, 2);
    }

    public void placeAt(WorldAccess worldIn, BlockPos pos, BlockState state, int flags) {
        worldIn.setBlockState(pos, state.with(Properties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER), flags);
        worldIn.setBlockState(pos.up(), state.with(Properties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), flags);
    }
}
