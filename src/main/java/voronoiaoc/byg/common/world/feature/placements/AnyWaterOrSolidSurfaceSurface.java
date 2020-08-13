package voronoiaoc.byg.common.world.feature.placements;

import net.minecraft.util.math.BlockPos;

import voronoiaoc.byg.common.biomes.BiomeHelper;
import voronoiaoc.byg.common.biomes.BiomeTools;import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AnyWaterOrSolidSurfaceSurface extends Decorator<SeaPickleFeatureConfig> {
    public static final Decorator<SeaPickleFeatureConfig> WATER_OR_SOLID_SURFACE = BiomeHelper.newDecorator("any_water_or_solid_surface_decorator", new AnyWaterOrSolidSurfaceSurface(CountConfig.CODEC));

    public AnyWaterOrSolidSurfaceSurface(Codec<CountConfig> config) {
        super(config);
    }

    @Override
    public Stream<BlockPos> getPositions(DecoratorContext ctx, Random random, CountConfig config, BlockPos pos) {
        return IntStream.range(0, config.getCount().getValue(random)).mapToObj((obj) -> {
            int x = random.nextInt(16) + pos.getX();
            int z = random.nextInt(16) + pos.getZ();
            BlockPos.Mutable mutable = new BlockPos.Mutable(x, ctx.world.getHeight(), z);
            while (mutable.getY() > 0 && !ctx.getBlockState(mutable).isSolidBlock(ctx.world, mutable) && ctx.getBlockState(mutable).getFluidState().isEmpty())
                mutable.move(Direction.DOWN);
            return mutable.toImmutable();
        });
    }
}