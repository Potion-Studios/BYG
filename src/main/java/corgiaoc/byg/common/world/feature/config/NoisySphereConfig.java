package corgiaoc.byg.common.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.IFeatureConfig;

import java.util.Random;

public class NoisySphereConfig implements IFeatureConfig {

    public static final Codec<NoisySphereConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> {
        return codecRecorder.group(BlockStateProvider.CODEC.fieldOf("block_provider").forGetter((config) -> {
            return config.blockProvider;
        }), BlockStateProvider.CODEC.fieldOf("top_block_provider").forGetter((config) -> {
            return config.topBlockProvider;
        }), Codec.INT.fieldOf("min_stack_height").orElse(1).forGetter((config) -> {
            return config.minHeight;
        }), Codec.INT.fieldOf("max_stack_height").orElse(1).forGetter((config) -> {
            return config.maxHeight;
        }), Codec.INT.fieldOf("min_x_radius").orElse(11).forGetter((config) -> {
            return config.minXRadius;
        }), Codec.INT.fieldOf("max_x_radius").orElse(15).forGetter((config) -> {
            return config.maxXRadius;
        }), Codec.INT.fieldOf("min_y_radius").orElse(15).forGetter((config) -> {
            return config.minYRadius;
        }), Codec.INT.fieldOf("max_y_radius").orElse(15).forGetter((config) -> {
            return config.maxYRadius;
        }), Codec.INT.fieldOf("min_z_radius").orElse(15).forGetter((config) -> {
            return config.minZRadius;
        }), Codec.INT.fieldOf("max_z_radius").orElse(15).forGetter((config) -> {
            return config.maxZRadius;
        }), Codec.DOUBLE.fieldOf("radius_divisor_per_stack").orElse(1.0).forGetter((config) -> {
            return config.radiusDivisorPerStack;
        }), Codec.DOUBLE.fieldOf("noise_frequency").orElse(1.0).forGetter((config) -> {
            return config.radiusDivisorPerStack;
        })).apply(codecRecorder, NoisySphereConfig::new);
    });


    private final BlockStateProvider blockProvider;
    private final BlockStateProvider topBlockProvider;
    private final int minHeight;
    private final int maxHeight;
    private final int minXRadius;
    private final int maxXRadius;
    private final int minYRadius;
    private final int maxYRadius;
    private final int minZRadius;
    private final int maxZRadius;
    private final double radiusDivisorPerStack;
    private final double noiseFrequency;

    NoisySphereConfig(BlockStateProvider blockProvider, BlockStateProvider topBlockProvider, int minHeight, int maxHeight, int minXRadius, int maxXRadius, int minYRadius, int maxYRadius, int minZRadius, int maxZRadius, double radiusDivisorPerStack, double noiseFrequency) {
        this.blockProvider = blockProvider;
        this.topBlockProvider = topBlockProvider;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.minXRadius = minXRadius;
        this.maxXRadius = maxXRadius;
        this.minYRadius = minYRadius;
        this.maxYRadius = maxYRadius;
        this.minZRadius = minZRadius;
        this.maxZRadius = maxZRadius;
        this.radiusDivisorPerStack = radiusDivisorPerStack;
        this.noiseFrequency = noiseFrequency;
    }

    public BlockStateProvider getBlockProvider() {
        return this.blockProvider;
    }

    public BlockStateProvider getTopBlockProvider() {
        return topBlockProvider;
    }

    public int getMinHeight() {
        return Math.abs(minHeight);
    }

    public int getMaxHeight() {
        return Math.abs(maxHeight);
    }

    public int getMaxPossibleHeight() {
        int returnValue = this.maxHeight - minHeight;
        if (returnValue <= 0)
            returnValue = 1;

        return returnValue + 1;
    }

    public int getMinXRadius() {
        return Math.abs(minXRadius);
    }

    public int getMaxXRadius() {
        return Math.abs(maxXRadius);
    }

    public int getMinYRadius() {
        return minYRadius;
    }

    public int getMaxYRadius() {
        return maxYRadius;
    }

    public int getMinZRadius() {
        return minZRadius;
    }

    public int getMaxZRadius() {
        return maxZRadius;
    }

    public int getMaxPossibleXRadius() {
        int returnValue = this.maxXRadius - minXRadius;
        if (returnValue <= 0)
            returnValue = 1;

        return Math.abs(returnValue);
    }

    public int getMaxPossibleYRadius() {
        int returnValue = this.maxYRadius - minYRadius;
        if (returnValue <= 0)
            returnValue = 1;

        return Math.abs(returnValue);
    }

    public int getMaxPossibleZRadius() {
        int returnValue = this.maxZRadius - minZRadius;
        if (returnValue <= 0)
            returnValue = 1;

        return Math.abs(returnValue);
    }

    public int getRandomXRadius(Random rand) {
        return rand.nextInt(maxXRadius) + minXRadius;
    }

    public int getRandomYRadius(Random rand) {
        return rand.nextInt(maxYRadius) + minYRadius;
    }

    public int getRandomZRadius(Random rand) {
        return rand.nextInt(maxZRadius) + minZRadius;
    }

    public double getRadiusDivisorPerStack() {
        return this.radiusDivisorPerStack;
    }

    public double getNoiseFrequency() {
        return noiseFrequency;
    }

    public static class Builder {
        private BlockStateProvider blockProvider = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
        private BlockStateProvider topBlockProvider = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
        private int minStackHeight = 1;
        private int maxStackHeight = 1;
        private int minXRadius = 1;
        private int maxXRadius = 3;
        private int minYRadius = minXRadius;
        private int maxYRadius = maxXRadius;
        private int minZRadius = minXRadius;
        private int maxZRadius = maxXRadius;
        private double radiusDivisorPerStack = 1.0;
        private double noiseFrequency = 0.045;

        public Builder setBlock(Block block) {
            if (block != null)
                blockProvider = new SimpleBlockStateProvider(block.getDefaultState());
            else
                blockProvider = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
            return this;
        }

        public Builder setBlock(BlockState state) {
            if (state != null)
                blockProvider = new SimpleBlockStateProvider(state);
            else
                blockProvider = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
            return this;
        }

        public Builder setBlock(BlockStateProvider provider) {
            if (provider != null)
                blockProvider = provider;
            else
                blockProvider = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
            return this;
        }

        public Builder setTopBlock(Block block) {
            if (block != null)
                topBlockProvider = new SimpleBlockStateProvider(block.getDefaultState());
            else
                topBlockProvider = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
            return this;
        }

        public Builder setTopBlock(BlockState state) {
            if (state != null)
                topBlockProvider = new SimpleBlockStateProvider(state);
            else
                topBlockProvider = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
            return this;
        }

        public Builder setTopBlock(BlockStateProvider provider) {
            if (provider != null)
                topBlockProvider = provider;
            else
                topBlockProvider = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
            return this;
        }

        public Builder setMinStackHeight(int minStackHeight) {
            if (minStackHeight <= 0)
                this.minStackHeight = 1;
            else
                this.minStackHeight = minStackHeight;
            return this;
        }

        public Builder setMaxHeight(int maxPossibleHeight) {
            if (maxPossibleHeight <= 0)
                this.maxStackHeight = minStackHeight + 1;
            else
                this.maxStackHeight = maxPossibleHeight;
            return this;
        }

        public Builder setMinXRadius(int minXRadius) {
            if (minXRadius <= 0)
                this.minXRadius = 1;
            else
                this.minXRadius = minXRadius;
            return this;
        }

        public Builder setMaxXRadius(int maxXRadius) {
            if (maxXRadius <= 0)
                this.maxXRadius = minXRadius + 1;
            else
                this.maxXRadius = maxXRadius;
            return this;
        }

        public Builder setMinYRadius(int minYRadius) {
            this.minYRadius = minYRadius;
            return this;
        }

        public Builder setMaxYRadius(int maxYRadius) {
            this.maxYRadius = maxYRadius;
            return this;
        }

        public Builder setMinZRadius(int minZRadius) {
            this.minZRadius = minZRadius;
            return this;
        }

        public Builder setMaxZRadius(int maxZRadius) {
            this.maxZRadius = maxZRadius;
            return this;
        }

        public Builder setRadiusDivisor(double radiusDivisorPerStack) {
            this.radiusDivisorPerStack = radiusDivisorPerStack;
            return this;
        }

        public Builder setNoiseFrequency(double noiseFrequency) {
            this.noiseFrequency = noiseFrequency;
            return this;
        }

        public Builder copy(NoisySphereConfig config) {
            this.blockProvider = config.blockProvider;
            this.topBlockProvider = config.topBlockProvider;
            this.minStackHeight = config.minHeight;
            this.maxStackHeight = config.maxHeight;
            this.minXRadius = config.minXRadius;
            this.maxXRadius = config.maxXRadius;
            this.minYRadius = config.minYRadius;
            this.maxYRadius = config.maxYRadius;
            this.minZRadius = config.minZRadius;
            this.maxZRadius = config.maxZRadius;
            this.radiusDivisorPerStack = config.radiusDivisorPerStack;
            this.noiseFrequency = config.noiseFrequency;
            return this;
        }

        public NoisySphereConfig build() {
            return new NoisySphereConfig(this.blockProvider, this.topBlockProvider, this.minStackHeight, this.maxStackHeight, this.minXRadius / 2, this.maxXRadius / 2, minYRadius / 2, maxYRadius / 2, minZRadius / 2, maxZRadius / 2, this.radiusDivisorPerStack, this.noiseFrequency);
        }
    }
}