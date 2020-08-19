package voronoiaoc.byg.common.world.feature.placements;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorContext;
import voronoiaoc.byg.common.biomes.BiomeHelper;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ObsidianSpikePlacer extends Decorator<CountExtraDecoratorConfig> {
    public static final Decorator<CountExtraDecoratorConfig> OBBY_SPIKE = BiomeHelper.newDecorator( "obsidian_spike_placer" ,new ObsidianSpikePlacer(CountExtraDecoratorConfig.CODEC));

    public ObsidianSpikePlacer(Codec<CountExtraDecoratorConfig> config) {
        super(config);
    }

    public Stream<BlockPos> getPositions(DecoratorContext decoratorContext, Random random, CountExtraDecoratorConfig config, BlockPos pos) {
        int i = random.nextInt(config.count);
        return IntStream.range(0, i).mapToObj((idx) -> {
            int j = random.nextInt(16) + pos.getX();
            int k = random.nextInt(16) + pos.getZ();
            int l = random.nextInt(75) + 54;
            return new BlockPos(j, l, k);
        });
    }
}