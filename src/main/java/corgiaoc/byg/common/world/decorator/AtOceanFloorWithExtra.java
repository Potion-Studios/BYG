package corgiaoc.byg.common.world.decorator;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.placement.DecorationContext;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.placement.FrequencyWithExtraChanceDecoratorConfiguration;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AtOceanFloorWithExtra extends FeatureDecorator<FrequencyWithExtraChanceDecoratorConfiguration> {

    public AtOceanFloorWithExtra(Codec<FrequencyWithExtraChanceDecoratorConfiguration> config) {
        super(config);
    }

    public Stream<BlockPos> getPositions(DecorationContext decoratorContext, Random random, FrequencyWithExtraChanceDecoratorConfiguration config, BlockPos pos) {
        int i = config.count;
        if (random.nextFloat() < config.extraChance) {
            i += config.extraCount;
        }

        return IntStream.range(0, i).mapToObj((streamedInt) -> {
            int x = random.nextInt(16) + pos.getX();
            int z = random.nextInt(16) + pos.getZ();
            int y = decoratorContext.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, x, z);
            return new BlockPos(x, y, z);
        });
    }
}