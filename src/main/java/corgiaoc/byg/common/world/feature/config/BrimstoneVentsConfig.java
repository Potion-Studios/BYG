package corgiaoc.byg.common.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;

public class BrimstoneVentsConfig implements FeatureConfiguration {

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
        private BlockStateProvider blockProvider = new SimpleStateProvider(BYGBlocks.BRIMSTONE.defaultBlockState());
        private BlockStateProvider lavaProvider = new SimpleStateProvider(Blocks.LAVA.defaultBlockState());

        public Builder setBlock(Block block) {
            this.blockProvider = new SimpleStateProvider(block.defaultBlockState());
            return this;
        }

        public Builder setBlock(BlockState state) {
            this.blockProvider = new SimpleStateProvider(state);
            return this;
        }

        public Builder setLavaBlock(Block block) {
            this.lavaProvider = new SimpleStateProvider(block.defaultBlockState());
            return this;
        }

        public Builder setLavaBlock(BlockState state) {
            this.lavaProvider = new SimpleStateProvider(state);
            return this;
        }

        public BrimstoneVentsConfig build() {
            return new BrimstoneVentsConfig(this.blockProvider, this.lavaProvider);
        }
    }
}
