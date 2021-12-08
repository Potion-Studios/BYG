package corgiaoc.byg.common.world.feature.blockplacer;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.blockplacer.BlockPlacer;
import net.minecraft.world.gen.blockplacer.BlockPlacerType;

import java.util.Random;

public class OnWaterOnlyBlockPlacer extends BlockPlacer {
    public static final Codec<OnWaterOnlyBlockPlacer> CODEC = Codec.unit(OnWaterOnlyBlockPlacer::new);

    protected BlockPlacerType<?> type() {
        return BYGBlockPlacerTypes.WATER_ONLY;
    }

    public void place(IWorld world, BlockPos pos, BlockState state, Random random) {
        placeAt(world, pos, state, 2);
    }

    public void placeAt(IWorld worldIn, BlockPos pos, BlockState state, int flags) {
        if (worldIn.getBlockState(pos.below()).getFluidState().is(FluidTags.WATER)) {
            worldIn.setBlock(pos, state, flags);
        }
    }
}
