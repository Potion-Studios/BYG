package corgiaoc.byg.common.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class GiantFlowerConfig implements IFeatureConfig {

    public static final Codec<GiantFlowerConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> {
        return codecRecorder.group(BlockStateProvider.CODEC.fieldOf("stem_provider").forGetter((config) -> {
            return config.stemProvider;
        }), BlockStateProvider.CODEC.fieldOf("petal_provider").forGetter((config) -> {
            return config.petalProvider;
        }), BlockStateProvider.CODEC.fieldOf("petal2_provider").forGetter((config) -> {
            return config.petalProvider;
        }), BlockStateProvider.CODEC.fieldOf("petal3_provider").forGetter((config) -> {
            return config.petalProvider;
        }), BlockStateProvider.CODEC.fieldOf("pollen_provider").forGetter((config) -> {
            return config.pollenProvider;
        }), Codec.INT.fieldOf("min_height").orElse(15).forGetter((config) -> {
            return config.minHeight;
        }), Codec.INT.fieldOf("max_height").orElse(1).forGetter((config) -> {
            return config.maxPossibleHeight;
        })).apply(codecRecorder, GiantFlowerConfig::new);
    });


    private final BlockStateProvider stemProvider;
    private final BlockStateProvider petalProvider;
    private final BlockStateProvider petal2Provider;
    private final BlockStateProvider petal3Provider;
    private final BlockStateProvider pollenProvider;
    private final int minHeight;
    private final int maxPossibleHeight;

    private boolean forcedPlacement = false;


    GiantFlowerConfig(BlockStateProvider stemProvider, BlockStateProvider petalProvider, BlockStateProvider petal2Provider, BlockStateProvider petal3Provider, BlockStateProvider pollenProvider, int minHeight, int maxPossibleHeight) {
        this.stemProvider = stemProvider;
        this.petalProvider = petalProvider;
        this.petal2Provider = petal2Provider;
        this.petal3Provider = petal3Provider;
        this.pollenProvider = pollenProvider;
        this.minHeight = minHeight;
        this.maxPossibleHeight = maxPossibleHeight;
    }

    /**
     * Used to generate giant flowers from flowers.
     */
    public void forcePlacement() {
        forcedPlacement = true;
    }


    public BlockStateProvider getStemProvider() {
        return this.stemProvider;
    }

    public BlockStateProvider getPetalProvider() {
        return this.petalProvider;
    }

    public BlockStateProvider getPetal2Provider() {
        return this.petal2Provider;
    }

    public BlockStateProvider getPetal3Provider() {
        return this.petal3Provider;
    }

    public BlockStateProvider getPollenProvider() {
        return this.pollenProvider;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxPossibleHeight() {
        int returnValue = this.maxPossibleHeight - minHeight;
        if (returnValue <= 0)
            returnValue = 1;

        return returnValue;
    }

    public boolean isPlacementForced() {
        return forcedPlacement;
    }


    public static class Builder {
        private BlockStateProvider stemProvider = new SimpleBlockStateProvider(Blocks.OAK_LOG.defaultBlockState());
        private BlockStateProvider petalProvider = new SimpleBlockStateProvider(Blocks.OAK_LEAVES.defaultBlockState());
        private BlockStateProvider petal2Provider = this.petalProvider;
        private BlockStateProvider petal3Provider = this.petalProvider;
        private BlockStateProvider pollenProvider = new SimpleBlockStateProvider(BYGBlocks.POLLEN_BLOCK.defaultBlockState());
        private int minHeight = 15;
        private int maxPossibleHeight = 1;

        public Builder setStemBlock(Block block) {
            if (block != null)
                stemProvider = new SimpleBlockStateProvider(block.defaultBlockState());
            else
                stemProvider = new SimpleBlockStateProvider(Blocks.OAK_LOG.defaultBlockState());

            return this;
        }

        public Builder setStemBlock(BlockState state) {
            if (state != null)
                stemProvider = new SimpleBlockStateProvider(state);
            else
                stemProvider = new SimpleBlockStateProvider(Blocks.OAK_LOG.defaultBlockState());

            return this;
        }

        public Builder setPetalBlock(Block block) {
            if (block != null)
                petalProvider = new SimpleBlockStateProvider(block.defaultBlockState());
            else
                petalProvider = new SimpleBlockStateProvider(Blocks.OAK_LEAVES.defaultBlockState());

            return this;
        }

        public Builder setPetalBlock(BlockState state) {
            if (state != null)
                petalProvider = new SimpleBlockStateProvider(state);
            else
                petalProvider = new SimpleBlockStateProvider(Blocks.OAK_LEAVES.defaultBlockState());

            return this;
        }

        public Builder setPetalBlock(WeightedBlockStateProvider statesList) {
            if (statesList != null)
                petalProvider = statesList;
            else
                petalProvider = new SimpleBlockStateProvider(Blocks.OAK_LEAVES.defaultBlockState());

            return this;
        }

        public Builder setPetal2Block(Block block) {
            if (block != null)
                petal2Provider = new SimpleBlockStateProvider(block.defaultBlockState());
            else
                petal2Provider = this.petalProvider;

            return this;
        }

        public Builder setPetal2Block(BlockState state) {
            if (state != null)
                petal2Provider = new SimpleBlockStateProvider(state);
            else
                petal2Provider = this.petalProvider;

            return this;
        }

        public Builder setPetal3Block(Block block) {
            if (block != null)
                petal3Provider = new SimpleBlockStateProvider(block.defaultBlockState());
            else
                petal3Provider = this.petalProvider;

            return this;
        }

        public Builder setPetal3Block(BlockState state) {
            if (state != null)
                petal3Provider = new SimpleBlockStateProvider(state);
            else
                petal3Provider = this.petalProvider;

            return this;
        }

        public Builder setPollenBlock(Block block) {
            if (block != null)
                petal3Provider = new SimpleBlockStateProvider(block.defaultBlockState());
            else
                petal3Provider = this.petalProvider;
            return this;
        }

        public Builder setPollenBlock(BlockState state) {
            if (state != null)
                petal3Provider = new SimpleBlockStateProvider(state);
            else
                petal3Provider = this.petalProvider;
            return this;
        }

        public Builder setMinHeight(int minHeight) {
            this.minHeight = minHeight;
            return this;
        }

        public Builder setMaxHeight(int maxPossibleHeight) {
            if (maxPossibleHeight != 0)
                this.maxPossibleHeight = maxPossibleHeight + 1;
            else
                this.maxPossibleHeight = 1;
            return this;
        }

        public Builder copy(GiantFlowerConfig config) {
            this.maxPossibleHeight = config.maxPossibleHeight;
            this.minHeight = config.minHeight;
            this.stemProvider = config.stemProvider;
            this.petalProvider = config.petalProvider;
            this.petal2Provider = config.petal2Provider;
            this.petal3Provider = config.petal3Provider;
            this.pollenProvider = config.pollenProvider;
            return this;
        }

        public GiantFlowerConfig build() {
            return new GiantFlowerConfig(this.stemProvider, this.petalProvider, this.petal2Provider, this.petal3Provider, this.pollenProvider, this.minHeight, this.maxPossibleHeight);
        }
    }
}
