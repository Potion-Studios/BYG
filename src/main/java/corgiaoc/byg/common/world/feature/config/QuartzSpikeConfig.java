package corgiaoc.byg.common.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class QuartzSpikeConfig implements IFeatureConfig {

    public static final Codec<QuartzSpikeConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> {
        return codecRecorder.group(BlockStateProvider.CODEC.fieldOf("block_provider").forGetter((config) -> {
            return config.blockProvider;
        })).apply(codecRecorder, QuartzSpikeConfig::new);
    });


    private final BlockStateProvider blockProvider;

    public QuartzSpikeConfig(BlockStateProvider blockProvider) {
        this.blockProvider = blockProvider;
    }

    public BlockStateProvider getBlockProvider() {
        return this.blockProvider;
    }


    public static class Builder {
        private BlockStateProvider blockProvider = new SimpleBlockStateProvider(Blocks.SMOOTH_QUARTZ.defaultBlockState());

        public QuartzSpikeConfig.Builder setBlock(Block block) {
            this.blockProvider = new SimpleBlockStateProvider(block.defaultBlockState());
            return this;
        }

        public QuartzSpikeConfig.Builder setBlock(BlockState state) {
            this.blockProvider = new SimpleBlockStateProvider(state);
            return this;
        }


        public QuartzSpikeConfig build() {
            return new QuartzSpikeConfig(this.blockProvider);
        }
    }
}
