package potionstudios.byg.common.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class Simple2BlockProviderConfig implements FeatureConfiguration {

    public static final Codec<Simple2BlockProviderConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> codecRecorder.group(BlockStateProvider.CODEC.fieldOf("block_provider").forGetter((config) -> config.blockProvider), BlockStateProvider.CODEC.fieldOf("block_provider2").forGetter((config) -> config.blockProvider)).apply(codecRecorder, Simple2BlockProviderConfig::new));

    private final BlockStateProvider blockProvider;
    private final BlockStateProvider blockProvider2;


    public Simple2BlockProviderConfig(BlockStateProvider blockProvider, BlockStateProvider blockProvider2) {
        this.blockProvider = blockProvider;
        this.blockProvider2 = blockProvider2;
    }

    public BlockStateProvider getBlockProvider() {
        return blockProvider;
    }

    public BlockStateProvider getBlockProvider2() {
        return blockProvider2;
    }

}
