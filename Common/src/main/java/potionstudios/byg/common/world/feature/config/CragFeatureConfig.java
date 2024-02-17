package potionstudios.byg.common.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.material.Fluid;

public record CragFeatureConfig(
        BlockStateProvider topBlockProvider,
        BlockStateProvider mainBlockProvider,
        Fluid fluid
) implements FeatureConfiguration {

    public static final Codec<CragFeatureConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> codecRecorder.group(
            BlockStateProvider.CODEC.fieldOf("top_block_provider").forGetter((config) -> config.topBlockProvider),
            BlockStateProvider.CODEC.fieldOf("main_block_provider").forGetter((config) -> config.mainBlockProvider),
            BuiltInRegistries.FLUID.byNameCodec().fieldOf("fluid").forGetter((config) -> config.fluid)
    ).apply(codecRecorder, CragFeatureConfig::new));

}
