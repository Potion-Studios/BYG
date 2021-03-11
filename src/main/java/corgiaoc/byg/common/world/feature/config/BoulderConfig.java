package corgiaoc.byg.common.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class BoulderConfig implements IFeatureConfig {

    public static final Codec<BoulderConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> {
        return codecRecorder.group(BlockStateProvider.CODEC.fieldOf("block_provider").forGetter((config) -> {
            return config.blockProvider;
        }), Codec.INT.fieldOf("min_stack_height").orElse(15).forGetter((config) -> {
            return config.minHeight;
        }), Codec.INT.fieldOf("max_stack_height").orElse(15).forGetter((config) -> {
            return config.maxHeight;
        }), Codec.INT.fieldOf("min_radius").orElse(11).forGetter((config) -> {
            return config.minRadius;
        }), Codec.INT.fieldOf("max_radius").orElse(15).forGetter((config) -> {
            return config.maxRadius;
        }), Codec.DOUBLE.fieldOf("radius_divisor_per_stack").orElse(1.1).forGetter((config) -> {
            return config.radiusDivisorPerStack;
        }), Codec.BOOL.fieldOf("flatten_top_boulder").orElse(false).forGetter((config) -> {
            return config.flattenTopBoulder;
        })).apply(codecRecorder, BoulderConfig::new);
    });


    private final BlockStateProvider blockProvider;
    private final int minHeight;
    private final int maxHeight;
    private final int minRadius;
    private final int maxRadius;
    private final double radiusDivisorPerStack;
    private final boolean flattenTopBoulder;


    BoulderConfig(BlockStateProvider blockProvider, int minHeight, int maxHeight, int minRadius, int maxRadius, double radiusDivisorPerStack, boolean flattenTopBoulder) {
        this.blockProvider = blockProvider;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
        this.radiusDivisorPerStack = radiusDivisorPerStack;
        this.flattenTopBoulder = flattenTopBoulder;
    }

    public BlockStateProvider getBlockProvider() {
        return this.blockProvider;
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

    public double getRadiusDivisorPerStack() {
        return this.radiusDivisorPerStack;
    }

    public boolean isTopBoulderFlat() {
        return this.flattenTopBoulder;
    }


    public static class Builder {
        private BlockStateProvider blockProvider = new SimpleBlockStateProvider(Blocks.STONE.defaultBlockState());
        private int minStackHeight = 1;
        private int maxStackHeight = 1;
        private int minRadius = 1;
        private int maxRadius = 3;
        private double radiusDivisorPerStack = 1.2;
        private boolean flattenTopBoulder = false;

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

        public Builder setRadiusDivisor(double radiusDivisorPerStack) {
            this.radiusDivisorPerStack = radiusDivisorPerStack;
            return this;
        }

        public Builder flattenTopBoulder() {
            this.flattenTopBoulder = true;
            return this;
        }

        public Builder copy(BoulderConfig config) {
            this.blockProvider = config.blockProvider;
            this.minStackHeight = config.minHeight;
            this.maxStackHeight = config.maxHeight;
            this.minRadius = config.minRadius;
            this.maxRadius = config.maxRadius;
            this.radiusDivisorPerStack = config.radiusDivisorPerStack;
            return this;
        }

        public BoulderConfig build() {
            return new BoulderConfig(this.blockProvider, this.minStackHeight, this.maxStackHeight, this.minRadius, this.maxRadius, this.radiusDivisorPerStack, this.flattenTopBoulder);
        }
    }
}
