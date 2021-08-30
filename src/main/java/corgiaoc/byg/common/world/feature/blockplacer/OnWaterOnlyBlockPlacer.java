package corgiaoc.byg.common.world.feature.blockplacer;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.blockplacers.BlockPlacer;
import net.minecraft.world.level.levelgen.feature.blockplacers.BlockPlacerType;

import java.util.Random;

public class OnWaterOnlyBlockPlacer extends BlockPlacer {
    public static final Codec<OnWaterOnlyBlockPlacer> CODEC = Codec.unit(OnWaterOnlyBlockPlacer::new);

    protected BlockPlacerType<?> type() {
        return BYGBlockPlacerTypes.WATER_ONLY;
    }

    public void place(LevelAccessor world, BlockPos pos, BlockState state, Random random) {
        placeAt(world, pos, state, 2);
    }

    public void placeAt(LevelAccessor worldIn, BlockPos pos, BlockState state, int flags) {
        if (worldIn.getBlockState(pos.below()).getFluidState().is(FluidTags.WATER)) {
            worldIn.setBlock(pos, state, flags);
        }
    }
}
