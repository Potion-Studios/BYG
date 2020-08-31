package voronoiaoc.byg.common.world.feature.placements;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.feature.configurations.CountConfiguration;
import net.minecraft.world.level.levelgen.placement.DecorationContext;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import voronoiaoc.byg.common.biomes.BiomeHelper;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AnyWaterOrSolidSurfaceSurface extends FeatureDecorator<CountConfiguration> {
    public static final FeatureDecorator<CountConfiguration> WATER_OR_SOLID_SURFACE = BiomeHelper.newDecorator("any_water_or_solid_surface_decorator", new AnyWaterOrSolidSurfaceSurface(CountConfiguration.CODEC));

    public AnyWaterOrSolidSurfaceSurface(Codec<CountConfiguration> config) {
        super(config);
    }

    @Override
    public Stream<BlockPos> getPositions(DecorationContext ctx, Random random, CountConfiguration config, BlockPos pos) {
        return IntStream.range(0, config.count().sample(random)).mapToObj((obj) -> {
            int x = random.nextInt(16) + pos.getX();
            int z = random.nextInt(16) + pos.getZ();
            BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos(x, ctx.level.getMaxBuildHeight(), z);
            while (mutable.getY() > 0 && !ctx.getBlockState(mutable).isRedstoneConductor(ctx.level, mutable) && ctx.getBlockState(mutable).getFluidState().isEmpty())
                mutable.move(Direction.DOWN);
            return mutable.immutable();
        });
    }
}