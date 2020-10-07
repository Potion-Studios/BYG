package corgiaoc.byg.common.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class PointyRockFeatureConfig implements IFeatureConfig {

    public static final Codec<PointyRockFeatureConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> {
        return codecRecorder.group(BlockStateProvider.CODEC.fieldOf("block_provider").forGetter((config) -> {
            return config.blockProvider;
        }), Codec.INT.fieldOf("rock_height").forGetter((config) -> {
            return config.height;
        })).apply(codecRecorder, PointyRockFeatureConfig::new);
    });


    private final BlockStateProvider blockProvider;
    private final int height;

    PointyRockFeatureConfig(BlockStateProvider blockProvider, int height) {
        this.blockProvider = blockProvider;
        this.height = height;
    }

    public BlockStateProvider getBlockProvider() {
        return this.blockProvider;
    }

    public int getHeight() {
        return this.height;
    }


    public static class Builder {
        private BlockStateProvider blockProvider = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
        private int rockHeight = 65;

        public Builder setBlock(Block block) {
            this.blockProvider = new SimpleBlockStateProvider(block.getDefaultState());
            return this;
        }

        public Builder setBlock(BlockState state) {
            this.blockProvider = new SimpleBlockStateProvider(state);
            return this;
        }


        public Builder setBlock(BlockStateProvider blockProvider) {
            this.blockProvider = blockProvider;
            return this;
        }

        public Builder setRockHeight(int rockHeight) {
            this.rockHeight = rockHeight;
            return this;
        }

        public PointyRockFeatureConfig build() {
            return new PointyRockFeatureConfig(this.blockProvider, rockHeight);
        }
    }
}
