package voronoiaoc.byg.common.world.feature.placements;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorContext;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AtOceanFloorWithExtra extends Decorator<CountExtraChanceDecoratorConfig> {

    public static final Decorator<CountExtraChanceDecoratorConfig> OCEANFLOOR = new AtOceanFloorWithExtra(CountExtraChanceDecoratorConfig.CODEC);

    public AtOceanFloorWithExtra(Codec<CountExtraChanceDecoratorConfig> config) {
        super(config);
    }

    public Stream<BlockPos> getPositions(DecoratorContext decoratorContext, Random random, CountExtraChanceDecoratorConfig config, BlockPos pos) {
        int i = config.count;
        if (random.nextFloat() < config.extraChance) {
            i += config.extraCount;
        }

        return IntStream.range(0, i).mapToObj((p_227444_3_) -> {
            int j = random.nextInt(16) + pos.getX();
            int k = random.nextInt(16) + pos.getZ();
            int l = decoratorContext.getTopY(Heightmap.Type.OCEAN_FLOOR_WG, j, k);
            return new BlockPos(j, l, k);
        });
    }
}