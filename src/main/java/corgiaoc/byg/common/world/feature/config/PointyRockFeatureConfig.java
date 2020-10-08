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
        }), Codec.INT.fieldOf("seed").orElse(0).forGetter((config) -> {
            return config.seed;
        }), Codec.DOUBLE.fieldOf("height_multiplier").orElse(1.0).forGetter((config) -> {
            return config.heightMultiplier;
        })).apply(codecRecorder, PointyRockFeatureConfig::new);
    });


    private final BlockStateProvider blockProvider;
    private final int seed;
    private final double heightMultiplier;

    PointyRockFeatureConfig(BlockStateProvider blockProvider, int seed, double heightMultiplier) {
        this.blockProvider = blockProvider;
        this.seed = seed;
        this.heightMultiplier = heightMultiplier;
    }

    public BlockStateProvider getBlockProvider() {
        return this.blockProvider;
    }

    public int getSeed() {
        return this.seed;
    }

    public double getHeightMultiplier() {
        return this.heightMultiplier;
    }


    public static class Builder {
        private BlockStateProvider blockProvider = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
        private int seed = 65;
        private double heightMultiplier = 0.5;

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

        public Builder setSeed(int seed) {
            this.seed = seed;
            return this;
        }

        public Builder setHeightMultiplier(double heightMultiplier) {
            this.heightMultiplier = heightMultiplier;
            return this;
        }

        public PointyRockFeatureConfig build() {
            return new PointyRockFeatureConfig(this.blockProvider, this.seed, this.heightMultiplier);
        }
    }
}
