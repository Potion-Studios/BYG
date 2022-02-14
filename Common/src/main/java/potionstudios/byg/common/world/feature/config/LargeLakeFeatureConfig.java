package potionstudios.byg.common.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record LargeLakeFeatureConfig(double minRadius, double maxRadius, double minDepth, double maxDepth,
                                     BlockStateProvider lakeFloorStateProvider,
                                     BlockStateProvider borderStateProvider) implements FeatureConfiguration {

    public static final Codec<LargeLakeFeatureConfig> CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(
                Codec.DOUBLE.fieldOf("minRadius").forGetter(largeLakeFeatureConfig -> largeLakeFeatureConfig.minRadius),
                Codec.DOUBLE.fieldOf("maxRadius").forGetter(largeLakeFeatureConfig -> largeLakeFeatureConfig.maxRadius),
                Codec.DOUBLE.fieldOf("minDepth").forGetter(largeLakeFeatureConfig -> largeLakeFeatureConfig.minDepth),
                Codec.DOUBLE.fieldOf("maxDepth").forGetter(largeLakeFeatureConfig -> largeLakeFeatureConfig.maxDepth),
                BlockStateProvider.CODEC.fieldOf("lakeFloorStateProvider").forGetter(largeLakeFeatureConfig -> largeLakeFeatureConfig.lakeFloorStateProvider),
                BlockStateProvider.CODEC.fieldOf("borderStateProvider").forGetter(largeLakeFeatureConfig -> largeLakeFeatureConfig.borderStateProvider)
        ).apply(builder, LargeLakeFeatureConfig::new);
    });


}
