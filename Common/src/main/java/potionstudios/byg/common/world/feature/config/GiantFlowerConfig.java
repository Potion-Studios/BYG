package potionstudios.byg.common.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import potionstudios.byg.common.block.BYGBlocks;

public class GiantFlowerConfig implements FeatureConfiguration {

    public static final Codec<GiantFlowerConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> {
        return codecRecorder.group(BlockStateProvider.CODEC.fieldOf("stem_provider").forGetter((config) -> {
            return config.stemProvider;
        }), BlockStateProvider.CODEC.fieldOf("petal_provider").forGetter((config) -> {
            return config.petalProvider;
        }), BlockStateProvider.CODEC.fieldOf("petal2_provider").forGetter((config) -> {
            return config.petalProvider;
        }), BlockStateProvider.CODEC.fieldOf("petal3_provider").forGetter((config) -> {
            return config.petalProvider;
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
    private final int minHeight;
    private final int maxPossibleHeight;

    private boolean forcedPlacement = false;


    GiantFlowerConfig(BlockStateProvider stemProvider, BlockStateProvider petalProvider, BlockStateProvider petal2Provider, BlockStateProvider petal3Provider, int minHeight, int maxPossibleHeight) {
        this.stemProvider = stemProvider;
        this.petalProvider = petalProvider;
        this.petal2Provider = petal2Provider;
        this.petal3Provider = petal3Provider;
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
        private BlockStateProvider stemProvider = SimpleStateProvider.simple(Blocks.OAK_LOG.defaultBlockState());
        private BlockStateProvider petalProvider = SimpleStateProvider.simple(Blocks.OAK_LEAVES.defaultBlockState());
        private BlockStateProvider petal2Provider = this.petalProvider;
        private BlockStateProvider petal3Provider = this.petalProvider;
        private int minHeight = 15;
        private int maxPossibleHeight = 1;

        public Builder setStemBlock(Block block) {
            if (block != null)
                stemProvider = SimpleStateProvider.simple(block.defaultBlockState());
            else
                stemProvider = SimpleStateProvider.simple(Blocks.OAK_LOG.defaultBlockState());

            return this;
        }

        public Builder setStemBlock(BlockState state) {
            if (state != null)
                stemProvider = SimpleStateProvider.simple(state);
            else
                stemProvider = SimpleStateProvider.simple(Blocks.OAK_LOG.defaultBlockState());

            return this;
        }

        public Builder setPetalBlock(Block block) {
            if (block != null)
                petalProvider = SimpleStateProvider.simple(block.defaultBlockState());
            else
                petalProvider = SimpleStateProvider.simple(Blocks.OAK_LEAVES.defaultBlockState());

            return this;
        }

        public Builder setPetalBlock(BlockState state) {
            if (state != null)
                petalProvider = SimpleStateProvider.simple(state);
            else
                petalProvider = SimpleStateProvider.simple(Blocks.OAK_LEAVES.defaultBlockState());

            return this;
        }

        public Builder setPetalBlock(WeightedStateProvider statesList) {
            if (statesList != null)
                petalProvider = statesList;
            else
                petalProvider = SimpleStateProvider.simple(Blocks.OAK_LEAVES.defaultBlockState());

            return this;
        }

        public Builder setPetal2Block(Block block) {
            if (block != null)
                petal2Provider = SimpleStateProvider.simple(block.defaultBlockState());
            else
                petal2Provider = this.petalProvider;

            return this;
        }

        public Builder setPetal2Block(BlockState state) {
            if (state != null)
                petal2Provider = SimpleStateProvider.simple(state);
            else
                petal2Provider = this.petalProvider;

            return this;
        }

        public Builder setPetal3Block(Block block) {
            if (block != null)
                petal3Provider = SimpleStateProvider.simple(block.defaultBlockState());
            else
                petal3Provider = this.petalProvider;

            return this;
        }

        public Builder setPetal3Block(BlockState state) {
            if (state != null)
                petal3Provider = SimpleStateProvider.simple(state);
            else
                petal3Provider = this.petalProvider;

            return this;
        }

        public Builder setPollenBlock(Block block) {
            if (block != null)
                petal3Provider = SimpleStateProvider.simple(block.defaultBlockState());
            else
                petal3Provider = this.petalProvider;
            return this;
        }

        public Builder setPollenBlock(BlockState state) {
            if (state != null)
                petal3Provider = SimpleStateProvider.simple(state);
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
            return this;
        }

        public GiantFlowerConfig build() {
            return new GiantFlowerConfig(this.stemProvider, this.petalProvider, this.petal2Provider, this.petal3Provider, this.minHeight, this.maxPossibleHeight);
        }
    }
}
