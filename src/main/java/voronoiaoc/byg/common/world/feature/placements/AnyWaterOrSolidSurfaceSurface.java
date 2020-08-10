package voronoiaoc.byg.common.world.feature.placements;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.CountConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorContext;
import voronoiaoc.byg.common.biomes.BiomeHelper;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AnyWaterOrSolidSurfaceSurface extends Decorator<CountConfig> {
    public static final Decorator<CountConfig> WATER_OR_SOLID_SURFACE = BiomeHelper.newDecorator("any_water_or_solid_surface_decorator", new AnyWaterOrSolidSurfaceSurface(CountConfig.CODEC));

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