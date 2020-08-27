package voronoiaoc.byg.common.world.feature.placements;

import com.mojang.serialization.Codec;
import voronoiaoc.byg.common.biomes.BiomeHelper;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.placement.DecorationContext;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.placement.FrequencyWithExtraChanceDecoratorConfiguration;

public class AtOceanFloorWithExtra extends FeatureDecorator<FrequencyWithExtraChanceDecoratorConfiguration> {

    public static final FeatureDecorator<FrequencyWithExtraChanceDecoratorConfiguration> OCEANFLOOR = BiomeHelper.newDecorator("ocean_floor_count_extra", new AtOceanFloorWithExtra(FrequencyWithExtraChanceDecoratorConfiguration.CODEC));

    public AtOceanFloorWithExtra(Codec<FrequencyWithExtraChanceDecoratorConfiguration> config) {
        super(config);
    }

    public Stream<BlockPos> getPositions(DecorationContext decoratorContext, Random random, FrequencyWithExtraChanceDecoratorConfiguration config, BlockPos pos) {
        int i = config.count;
        if (random.nextFloat() < config.extraChance) {
            i += config.extraCount;
        }

        return IntStream.range(0, i).mapToObj((p_227444_3_) -> {
            int j = random.nextInt(16) + pos.getX();
            int k = random.nextInt(16) + pos.getZ();
            int l = decoratorContext.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, j, k);
            return new BlockPos(j, l, k);
        });
    }
}