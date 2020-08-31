package voronoiaoc.byg.common.world.feature.placements;

import com.mojang.serialization.Codec;
import voronoiaoc.byg.common.biomes.BiomeHelper;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.placement.DecorationContext;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.placement.FrequencyWithExtraChanceDecoratorConfiguration;

public class ObsidianSpikePlacer extends FeatureDecorator<FrequencyWithExtraChanceDecoratorConfiguration> {
    public static final FeatureDecorator<FrequencyWithExtraChanceDecoratorConfiguration> OBBY_SPIKE = BiomeHelper.newDecorator( "obsidian_spike_placer" ,new ObsidianSpikePlacer(FrequencyWithExtraChanceDecoratorConfiguration.CODEC));

    public ObsidianSpikePlacer(Codec<FrequencyWithExtraChanceDecoratorConfiguration> config) {
        super(config);
    }

    public Stream<BlockPos> getPositions(DecorationContext decoratorContext, Random random, FrequencyWithExtraChanceDecoratorConfiguration config, BlockPos pos) {
        int i = random.nextInt(config.count);
        return IntStream.range(0, i).mapToObj((idx) -> {
            int j = random.nextInt(16) + pos.getX();
            int k = random.nextInt(16) + pos.getZ();
            int l = random.nextInt(75) + 54;
            return new BlockPos(j, l, k);
        });
    }
}