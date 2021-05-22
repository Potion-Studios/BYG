package corgiaoc.byg.common.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class FloatingIslandConfig implements IFeatureConfig {

    public static final Codec<FloatingIslandConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> {
        return codecRecorder.group(BlockStateProvider.CODEC.fieldOf("top_block_provider").forGetter((config) -> {
            return config.topBlockProvider;
        }), BlockStateProvider.CODEC.fieldOf("block_provider").forGetter((config) -> {
            return config.blockProvider;
        }), Codec.INT.fieldOf("min_radius").orElse(13).forGetter((config) -> {
            return config.minRadius;
        }), Codec.INT.fieldOf("max_radius").orElse(15).forGetter((config) -> {
            return config.maxRadius;
        })).apply(codecRecorder, FloatingIslandConfig::new);
    });

    private final BlockStateProvider topBlockProvider;
    private final BlockStateProvider blockProvider;
    private final int minRadius;
    private final int maxRadius;


    FloatingIslandConfig(BlockStateProvider topBlockProvider, BlockStateProvider blockProvider, int minRadius, int maxRadius) {
        this.topBlockProvider = topBlockProvider;
        this.blockProvider = blockProvider;
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
    }

    public BlockStateProvider getBlockProvider() {
        return this.blockProvider;
    }

    public BlockStateProvider getTopBlockProvider() {
        return this.topBlockProvider;
    }

    public int getMinRadius() {
        return Math.abs(minRadius);
    }

    public int getMaxRadius() {
        return Math.abs(maxRadius);
    }

    public int getMaxPossibleRadius() {
        int returnValue = this.maxRadius - minRadius;
        if (returnValue <= 0)
            returnValue = 1;

        return Math.abs(returnValue);
    }

    public static class Builder {
        private BlockStateProvider topBlockProvider = new SimpleBlockStateProvider(Blocks.GRASS_BLOCK.defaultBlockState());
        private BlockStateProvider blockProvider = new SimpleBlockStateProvider(Blocks.STONE.defaultBlockState());
        private int minRadius = 1;
        private int maxRadius = 3;

        public Builder setTopBlock(Block block) {
            if (block != null)
                topBlockProvider = new SimpleBlockStateProvider(block.defaultBlockState());
            else
                topBlockProvider = new SimpleBlockStateProvider(Blocks.STONE.defaultBlockState());
            return this;
        }

        public Builder setTopBlock(BlockState state) {
            if (state != null)
                topBlockProvider = new SimpleBlockStateProvider(state);
            else
                topBlockProvider = new SimpleBlockStateProvider(Blocks.STONE.defaultBlockState());
            return this;
        }

        public Builder setTopBlock(BlockStateProvider provider) {
            if (provider != null)
                topBlockProvider = provider;
            else
                topBlockProvider = new SimpleBlockStateProvider(Blocks.STONE.defaultBlockState());
            return this;
        }

        public Builder setBlock(Block block) {
            if (block != null)
                blockProvider = new SimpleBlockStateProvider(block.defaultBlockState());
            else
                blockProvider = new SimpleBlockStateProvider(Blocks.STONE.defaultBlockState());
            return this;
        }

        public Builder setBlock(BlockState state) {
            if (state != null)
                blockProvider = new SimpleBlockStateProvider(state);
            else
                blockProvider = new SimpleBlockStateProvider(Blocks.STONE.defaultBlockState());
            return this;
        }

        public Builder setBlock(BlockStateProvider provider) {
            if (provider != null)
                blockProvider = provider;
            else
                blockProvider = new SimpleBlockStateProvider(Blocks.STONE.defaultBlockState());
            return this;
        }

        public Builder setMinRadius(int minRadius) {
            if (minRadius <= 0)
                this.minRadius = 1;
            else
                this.minRadius = minRadius;
            return this;
        }

        public Builder setMaxRadius(int maxRadius) {
            if (maxRadius <= 0)
                this.maxRadius = minRadius + 1;
            else
                this.maxRadius = maxRadius;
            return this;
        }

        public Builder copy(FloatingIslandConfig config) {
            this.topBlockProvider = config.topBlockProvider;
            this.blockProvider = config.blockProvider;
            this.minRadius = config.minRadius;
            this.maxRadius = config.maxRadius;
            return this;
        }

        public FloatingIslandConfig build() {
            return new FloatingIslandConfig(this.topBlockProvider, this.blockProvider, this.minRadius, this.maxRadius);
        }
    }
}
