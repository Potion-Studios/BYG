package corgiaoc.byg.common.world.decorator;

import com.mojang.serialization.Codec;
import corgiaoc.byg.mixin.access.WorldDecoratingHelperAccess;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.feature.FeatureSpreadConfig;
import net.minecraft.world.gen.feature.WorldDecoratingHelper;
import net.minecraft.world.gen.placement.Placement;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AnyWaterOrSolidSurface extends Placement<FeatureSpreadConfig> {

    public AnyWaterOrSolidSurface(Codec<FeatureSpreadConfig> config) {
        super(config);
    }

    @Override
    public Stream<BlockPos> getPositions(WorldDecoratingHelper ctx, Random random, FeatureSpreadConfig config, BlockPos pos) {
        return IntStream.range(0, config.count().sample(random)).mapToObj((obj) -> {
            int x = random.nextInt(16) + pos.getX();
            int z = random.nextInt(16) + pos.getZ();
            ISeedReader level = ((WorldDecoratingHelperAccess) ctx).getLevel();
            BlockPos.Mutable mutable = new BlockPos.Mutable(x, level.getMaxBuildHeight(), z);
            while (mutable.getY() > 0 && !ctx.getBlockState(mutable).isSolidRender(level, mutable) && ctx.getBlockState(mutable).getFluidState().isEmpty())
                mutable.move(Direction.DOWN);
            return mutable.immutable();
        });
    }
}