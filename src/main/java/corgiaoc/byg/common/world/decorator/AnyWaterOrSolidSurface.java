package corgiaoc.byg.common.world.decorator;

import com.mojang.serialization.Codec;
import corgiaoc.byg.mixin.access.WorldDecoratingHelperAccess;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.configurations.CountConfiguration;
import net.minecraft.world.level.levelgen.placement.DecorationContext;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AnyWaterOrSolidSurface extends FeatureDecorator<CountConfiguration> {

    public AnyWaterOrSolidSurface(Codec<CountConfiguration> config) {
        super(config);
    }

    @Override
    public Stream<BlockPos> getPositions(DecorationContext ctx, Random random, CountConfiguration config, BlockPos pos) {
        return IntStream.range(0, config.count().sample(random)).mapToObj((obj) -> {
            int x = random.nextInt(16) + pos.getX();
            int z = random.nextInt(16) + pos.getZ();
            WorldGenLevel level = ((WorldDecoratingHelperAccess) ctx).getLevel();
            BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos(x, level.getMaxBuildHeight(), z);
            while (mutable.getY() > 0 && !ctx.getBlockState(mutable).isSolidRender(level, mutable) && ctx.getBlockState(mutable).getFluidState().isEmpty())
                mutable.move(Direction.DOWN);
            return mutable.immutable();
        });
    }
}