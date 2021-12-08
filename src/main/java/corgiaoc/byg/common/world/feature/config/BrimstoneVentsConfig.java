package corgiaoc.byg.common.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class BrimstoneVentsConfig implements IFeatureConfig {

    public static final Codec<BrimstoneVentsConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> {
        return codecRecorder.group(BlockStateProvider.CODEC.fieldOf("block_provider").forGetter((config) -> {
            return config.blockProvider;
        }), BlockStateProvider.CODEC.fieldOf("lava_provider").forGetter((config) -> {
            return config.lavaProvider;
        })).apply(codecRecorder, BrimstoneVentsConfig::new);
    });


    private final BlockStateProvider blockProvider;
    private final BlockStateProvider lavaProvider;

    BrimstoneVentsConfig(BlockStateProvider blockProvider, BlockStateProvider lavaProvider) {
        this.blockProvider = blockProvider;
        this.lavaProvider = lavaProvider;
    }

    public BlockStateProvider getBlockProvider() {
        return this.blockProvider;
    }

    public BlockStateProvider getLavaProvider() {
        return this.lavaProvider;
    }


    public static class Builder {
        private BlockStateProvider blockProvider = new SimpleBlockStateProvider(BYGBlocks.BRIMSTONE.defaultBlockState());
        private BlockStateProvider lavaProvider = new SimpleBlockStateProvider(Blocks.LAVA.defaultBlockState());

        public BrimstoneVentsConfig.Builder setBlock(Block block) {
            this.blockProvider = new SimpleBlockStateProvider(block.defaultBlockState());
            return this;
        }

        public BrimstoneVentsConfig.Builder setBlock(BlockState state) {
            this.blockProvider = new SimpleBlockStateProvider(state);
            return this;
        }

        public BrimstoneVentsConfig.Builder setLavaBlock(Block block) {
            this.lavaProvider = new SimpleBlockStateProvider(block.defaultBlockState());
            return this;
        }

        public BrimstoneVentsConfig.Builder setLavaBlock(BlockState state) {
            this.lavaProvider = new SimpleBlockStateProvider(state);
            return this;
        }

        public BrimstoneVentsConfig build() {
            return new BrimstoneVentsConfig(this.blockProvider, this.lavaProvider);
        }
    }
}
