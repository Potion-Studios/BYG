package potionstudios.byg.common.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.Random;

public record LargeLakeFeatureConfig(int minRadius, int maxRadius, int minDepth, int maxDepth,
                                     BlockStateProvider lakeFloorStateProvider,
                                     BlockStateProvider borderStateProvider) implements FeatureConfiguration {

    public static final Codec<LargeLakeFeatureConfig> CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(
                Codec.INT.fieldOf("minRadius").forGetter(largeLakeFeatureConfig -> largeLakeFeatureConfig.minRadius),
                Codec.INT.fieldOf("maxRadius").forGetter(largeLakeFeatureConfig -> largeLakeFeatureConfig.maxRadius),
                Codec.INT.fieldOf("minDepth").forGetter(largeLakeFeatureConfig -> largeLakeFeatureConfig.minDepth),
                Codec.INT.fieldOf("maxDepth").forGetter(largeLakeFeatureConfig -> largeLakeFeatureConfig.maxDepth),
                BlockStateProvider.CODEC.fieldOf("lakeFloorStateProvider").forGetter(largeLakeFeatureConfig -> largeLakeFeatureConfig.lakeFloorStateProvider),
                BlockStateProvider.CODEC.fieldOf("borderStateProvider").forGetter(largeLakeFeatureConfig -> largeLakeFeatureConfig.borderStateProvider)
        ).apply(builder, LargeLakeFeatureConfig::new);
    });

    public int getRandomRadius(Random random) {
        return random.nextInt(Math.max(1, this.maxRadius - this.minRadius)) + this.minRadius;
    }

    public int getRandomDepth(Random random) {
        return random.nextInt(Math.max(1, this.maxDepth - this.minDepth)) + this.minRadius;
    }
}
