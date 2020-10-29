package corgiaoc.byg.common.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class SimpleBlockProviderConfig implements FeatureConfig {

    public static final Codec<SimpleBlockProviderConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> {
        return codecRecorder.group(BlockStateProvider.TYPE_CODEC.fieldOf("block_provider").forGetter((config) -> {
            return config.blockProvider;
        })).apply(codecRecorder, SimpleBlockProviderConfig::new);
    });

    private final BlockStateProvider blockProvider;


    public SimpleBlockProviderConfig(BlockStateProvider blockProvider) {
        this.blockProvider = blockProvider;
    }

    public BlockStateProvider getBlockProvider() {
        return blockProvider;
    }
}
