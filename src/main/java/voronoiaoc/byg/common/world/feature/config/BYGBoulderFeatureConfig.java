package voronoiaoc.byg.common.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class BYGBoulderFeatureConfig implements IFeatureConfig {

    public static final Codec<BYGBoulderFeatureConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> {
        return codecRecorder.group(BlockStateProvider.CODEC.fieldOf("block_provider").forGetter((config) -> {
            return config.blockProvider;
        }), Codec.INT.fieldOf("min_stack_height").orElse(15).forGetter((config) -> {
            return config.minHeight;
        }), Codec.INT.fieldOf("max_stack_height").orElse(15).forGetter((config) -> {
            return config.maxHeight;
        }), Codec.INT.fieldOf("min_radius").orElse(15).forGetter((config) -> {
            return config.minRadius;
        }),Codec.INT.fieldOf("max_radius").orElse(1).forGetter((config) -> {
            return config.maxRadius;
        })).apply(codecRecorder, BYGBoulderFeatureConfig::new);
    });


    private final BlockStateProvider blockProvider;
    private final int minHeight;
    private final int maxHeight;
    private final int minRadius;
    private final int maxRadius;


    BYGBoulderFeatureConfig(BlockStateProvider blockProvider, int minHeight, int maxHeight, int minRadius, int maxRadius) {
        this.blockProvider = blockProvider;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
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

        return Math.abs(returnValue);
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
        private BlockStateProvider blockProvider = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
        private int minStackHeight = 15;
        private int maxStackHeight = 1;
        private int minRadius = 1;
        private int maxRadius = 3;

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

        public Builder setMinStackHeight(int minStackHeight) {
            if (minStackHeight <= 0)
                this.minStackHeight = 1;
            else
                this.minStackHeight = minStackHeight;
            return this;
        }

        public Builder setMaxHeight(int maxPossibleHeight) {
            if (maxPossibleHeight <= 0)
                this.maxStackHeight = maxPossibleHeight + 1;
            else
                this.maxStackHeight = 1;
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
                this.maxRadius = maxRadius + 1;
            else
                this.maxRadius = 1;
            return this;
        }


        public Builder copy(BYGBoulderFeatureConfig config) {
            this.blockProvider = config.blockProvider;
            this.minStackHeight = config.minHeight;
            this.maxStackHeight = config.maxHeight;
            this.minRadius = config.minRadius;
            this.maxRadius = config.maxRadius;
            return this;
        }

        public BYGBoulderFeatureConfig build() {
            return new BYGBoulderFeatureConfig(this.blockProvider, this.minStackHeight, this.maxStackHeight, this.minRadius, this.maxRadius);
        }
    }
}
