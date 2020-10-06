package corgiaoc.byg.common.world.feature.placements;

import com.mojang.serialization.Codec;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.FeatureSpreadConfig;
import net.minecraft.world.gen.feature.WorldDecoratingHelper;
import net.minecraft.world.gen.placement.Placement;
import corgiaoc.byg.common.world.biome.BiomeHelper;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AnyWaterOrSolidSurfaceSurface extends Placement<FeatureSpreadConfig> {
    public static final Placement<FeatureSpreadConfig> WATER_OR_SOLID_SURFACE = BiomeHelper.newDecorator("any_water_or_solid_surface_decorator", new AnyWaterOrSolidSurfaceSurface(FeatureSpreadConfig.field_242797_a));

    public AnyWaterOrSolidSurfaceSurface(Codec<FeatureSpreadConfig> config) {
        super(config);
    }

    @Override
    public Stream<BlockPos> func_241857_a(WorldDecoratingHelper ctx, Random random, FeatureSpreadConfig config, BlockPos pos) {
        return IntStream.range(0, config.func_242799_a().func_242259_a(random)).mapToObj((obj) -> {
            int x = random.nextInt(16) + pos.getX();
            int z = random.nextInt(16) + pos.getZ();
            BlockPos.Mutable mutable = new BlockPos.Mutable(x, ctx.field_242889_a.getHeight(), z);
            while (mutable.getY() > 0 && !ctx.func_242894_a(mutable).isOpaqueCube(ctx.field_242889_a, mutable) && ctx.func_242894_a(mutable).getFluidState().isEmpty())
                mutable.move(Direction.DOWN);
            return mutable.toImmutable();
        });
    }
}