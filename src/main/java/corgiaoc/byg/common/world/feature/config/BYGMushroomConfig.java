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
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;

public class BYGMushroomConfig implements FeatureConfiguration {

    public static final Codec<BYGMushroomConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> {
        return codecRecorder.group(BlockStateProvider.CODEC.fieldOf("stem_provider").forGetter((config) -> {
            return config.stemProvider;
        }), BlockStateProvider.CODEC.fieldOf("mushroom_provider").forGetter((config) -> {
            return config.mushroomProvider;
        }), BlockStateProvider.CODEC.fieldOf("mushroom2_provider").forGetter((config) -> {
            return config.mushroomProvider;
        }), BlockStateProvider.CODEC.fieldOf("mushroom3_provider").forGetter((config) -> {
            return config.mushroomProvider;
        }), BlockStateProvider.CODEC.fieldOf("pollen_provider").forGetter((config) -> {
            return config.pollenProvider;
        }), Codec.INT.fieldOf("min_height").orElse(15).forGetter((config) -> {
            return config.minHeight;
        }), Codec.INT.fieldOf("max_height").orElse(1).forGetter((config) -> {
            return config.maxPossibleHeight;
        })).apply(codecRecorder, BYGMushroomConfig::new);
    });


    private final BlockStateProvider stemProvider;
    private final BlockStateProvider mushroomProvider;
    private final BlockStateProvider mushroom2Provider;
    private final BlockStateProvider mushroom3Provider;
    private final BlockStateProvider pollenProvider;
    private final int minHeight;
    private final int maxPossibleHeight;

    private boolean forcedPlacement = false;


    BYGMushroomConfig(BlockStateProvider stemProvider, BlockStateProvider mushroomProvider, BlockStateProvider mushroom2Provider, BlockStateProvider mushroom3Provider, BlockStateProvider pollenProvider, int minHeight, int maxPossibleHeight) {
        this.stemProvider = stemProvider;
        this.mushroomProvider = mushroomProvider;
        this.mushroom2Provider = mushroom2Provider;
        this.mushroom3Provider = mushroom3Provider;
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

    public BlockStateProvider getMushroomProvider() {
        return this.mushroomProvider;
    }

    public BlockStateProvider getMushroom2Provider() {
        return this.mushroom2Provider;
    }

    public BlockStateProvider getMushroom3Provider() {
        return this.mushroom3Provider;
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
        private BlockStateProvider stemProvider = new SimpleStateProvider(Blocks.OAK_LOG.defaultBlockState());
        private BlockStateProvider mushroomProvider = new SimpleStateProvider(Blocks.OAK_LEAVES.defaultBlockState());
        private BlockStateProvider mushroom2Provider = this.mushroomProvider;
        private BlockStateProvider mushroom3Provider = this.mushroomProvider;
        private BlockStateProvider pollenProvider = new SimpleStateProvider(BYGBlocks.POLLEN_BLOCK.defaultBlockState());
        private int minHeight = 15;
        private int maxPossibleHeight = 1;

        public Builder setStemBlock(Block block) {
            if (block != null)
                stemProvider = new SimpleStateProvider(block.defaultBlockState());
            else
                stemProvider = new SimpleStateProvider(Blocks.OAK_LOG.defaultBlockState());

            return this;
        }

        public Builder setStemBlock(BlockState state) {
            if (state != null)
                stemProvider = new SimpleStateProvider(state);
            else
                stemProvider = new SimpleStateProvider(Blocks.OAK_LOG.defaultBlockState());

            return this;
        }

        public Builder setMushroomBlock(Block block) {
            if (block != null)
                mushroomProvider = new SimpleStateProvider(block.defaultBlockState());
            else
                mushroomProvider = new SimpleStateProvider(Blocks.OAK_LEAVES.defaultBlockState());

            return this;
        }

        public Builder setMushroomBlock(BlockState state) {
            if (state != null)
                mushroomProvider = new SimpleStateProvider(state);
            else
                mushroomProvider = new SimpleStateProvider(Blocks.OAK_LEAVES.defaultBlockState());

            return this;
        }

        public Builder setMushroomBlock(WeightedStateProvider statesList) {
            if (statesList != null)
                mushroomProvider = statesList;
            else
                mushroomProvider = new SimpleStateProvider(Blocks.OAK_LEAVES.defaultBlockState());

            return this;
        }

        public Builder setMushroom2Block(Block block) {
            if (block != null)
                mushroom2Provider = new SimpleStateProvider(block.defaultBlockState());
            else
                mushroom2Provider = this.mushroomProvider;

            return this;
        }

        public Builder setMushroom2Block(BlockState state) {
            if (state != null)
                mushroom2Provider = new SimpleStateProvider(state);
            else
                mushroom2Provider = this.mushroomProvider;

            return this;
        }

        public Builder setMushroom3Block(Block block) {
            if (block != null)
                mushroom3Provider = new SimpleStateProvider(block.defaultBlockState());
            else
                mushroom3Provider = this.mushroomProvider;

            return this;
        }

        public Builder setMushroom3Block(BlockState state) {
            if (state != null)
                mushroom3Provider = new SimpleStateProvider(state);
            else
                mushroom3Provider = this.mushroomProvider;

            return this;
        }

        public Builder setPollenBlock(Block block) {
            if (block != null)
                mushroom3Provider = new SimpleStateProvider(block.defaultBlockState());
            else
                mushroom3Provider = this.mushroomProvider;
            return this;
        }

        public Builder setPollenBlock(BlockState state) {
            if (state != null)
                mushroom3Provider = new SimpleStateProvider(state);
            else
                mushroom3Provider = this.mushroomProvider;
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

        public Builder copy(BYGMushroomConfig config) {
            this.maxPossibleHeight = config.maxPossibleHeight;
            this.minHeight = config.minHeight;
            this.stemProvider = config.stemProvider;
            this.mushroomProvider = config.mushroomProvider;
            this.mushroom2Provider = config.mushroom2Provider;
            this.mushroom3Provider = config.mushroom3Provider;
            this.pollenProvider = config.pollenProvider;
            return this;
        }

        public BYGMushroomConfig build() {
            return new BYGMushroomConfig(this.stemProvider, this.mushroomProvider, this.mushroom2Provider, this.mushroom3Provider, this.pollenProvider, this.minHeight, this.maxPossibleHeight);
        }
    }
}
