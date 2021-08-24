package corgiaoc.byg.common.world.feature.config;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HangingColumnWithBaseConfig implements FeatureConfiguration {

    public static final Codec<HangingColumnWithBaseConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> {
        return codecRecorder.group(BlockStateProvider.CODEC.fieldOf("base_block_provider").forGetter((config) -> {
            return config.baseBlockProvider;
        }), BlockStateProvider.CODEC.fieldOf("block_provider").forGetter((config) -> {
            return config.blockProvider;
        }), BlockStateProvider.CODEC.fieldOf("end_block_provider").forGetter((config) -> {
            return config.endBlockProvider;
        }), Codec.INT.fieldOf("min_length").forGetter((config) -> {
            return config.minLength;
        }), Codec.INT.fieldOf("max_length").forGetter((config) -> {
            return config.maxLength;
        }), BlockState.CODEC.listOf().fieldOf("whitelist").forGetter((config) -> {
            return config.whitelist.stream().map(Block::defaultBlockState).collect(Collectors.toList());
        })).apply(codecRecorder, HangingColumnWithBaseConfig::new);
    });

    private final BlockStateProvider baseBlockProvider;
    private final BlockStateProvider blockProvider;
    private final BlockStateProvider endBlockProvider;
    private final int minLength;
    private final int maxLength;
    private final Set<Block> whitelist;


    HangingColumnWithBaseConfig(BlockStateProvider baseBlockProvider, BlockStateProvider blockProvider, BlockStateProvider endBlockProvider, int minLength, int maxLength, List<BlockState> whitelist) {
        this.baseBlockProvider = baseBlockProvider;
        this.blockProvider = blockProvider;
        this.endBlockProvider = endBlockProvider;
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.whitelist = whitelist.stream().map(BlockBehaviour.BlockStateBase::getBlock).collect(Collectors.toSet());

    }

    public BlockStateProvider getBaseBlockProvider() {
        return baseBlockProvider;
    }

    public BlockStateProvider getBlockProvider() {
        return blockProvider;
    }

    public BlockStateProvider getEndBlockProvider() {
        return endBlockProvider;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public int getMinLength() {
        return minLength;
    }

    public int getMaxPossibleLength() {
        int returnValue = this.minLength - maxLength;
        if (returnValue <= 0)
            returnValue = 1;

        return returnValue;
    }

    public Set<Block> getWhitelist() {
        return whitelist;
    }

    public static class Builder {
        private BlockStateProvider baseBlockProvider = new SimpleStateProvider(Blocks.OAK_LOG.defaultBlockState());
        private BlockStateProvider blockProvider = new SimpleStateProvider(Blocks.OAK_LEAVES.defaultBlockState());
        private BlockStateProvider endBlockProvider = new SimpleStateProvider(Blocks.AIR.defaultBlockState());;
        private List<Block> whitelist = ImmutableList.of(Blocks.GRASS_BLOCK);
        private int minLength = 1;
        private int maxLength = 9;

        public Builder setBaseBlock(Block block) {
            if (block != null)
                baseBlockProvider = new SimpleStateProvider(block.defaultBlockState());
            else
                baseBlockProvider = new SimpleStateProvider(Blocks.STONE.defaultBlockState());
            return this;
        }

        public Builder setBaseBlock(BlockState state) {
            if (state != null)
                baseBlockProvider = new SimpleStateProvider(state);
            else
                baseBlockProvider = new SimpleStateProvider(Blocks.STONE.defaultBlockState());
            return this;
        }

        public Builder setBaseBlock(BlockStateProvider provider) {
            if (provider != null)
                baseBlockProvider = provider;
            else
                baseBlockProvider = new SimpleStateProvider(Blocks.STONE.defaultBlockState());
            return this;
        }

        public Builder setBlock(Block block) {
            if (block != null)
                blockProvider = new SimpleStateProvider(block.defaultBlockState());
            else
                blockProvider = new SimpleStateProvider(Blocks.STONE.defaultBlockState());
            return this;
        }

        public Builder setBlock(BlockState state) {
            if (state != null)
                blockProvider = new SimpleStateProvider(state);
            else
                blockProvider = new SimpleStateProvider(Blocks.STONE.defaultBlockState());
            return this;
        }

        public Builder setBlock(BlockStateProvider provider) {
            if (provider != null)
                blockProvider = provider;
            else
                blockProvider = new SimpleStateProvider(Blocks.STONE.defaultBlockState());
            return this;
        }

        public Builder setEndBlock(Block block) {
            if (block != null)
                endBlockProvider = new SimpleStateProvider(block.defaultBlockState());
            else
                endBlockProvider = blockProvider;
            return this;
        }

        public Builder setEndBlock(BlockState state) {
            if (state != null)
                endBlockProvider = new SimpleStateProvider(state);
            else
                endBlockProvider = blockProvider;
            return this;
        }

        public Builder setEndBlock(BlockStateProvider provider) {
            if (provider != null)
                endBlockProvider = provider;
            else
                endBlockProvider = blockProvider;
            return this;
        }

        public Builder setMinLength(int minLength) {
            this.minLength = minLength;
            return this;
        }

        public Builder setMaxLength(int maxPossibleHeight) {
            if (maxPossibleHeight != 0)
                this.maxLength = maxPossibleHeight + 1;
            else
                this.maxLength = 1;
            return this;
        }

        public Builder setWhitelist(ImmutableList<Block> whitelist) {
            this.whitelist = whitelist;
            return this;
        }

        public Builder copy(HangingColumnWithBaseConfig config) {
            this.baseBlockProvider = config.baseBlockProvider;
            this.blockProvider = config.blockProvider;
            this.endBlockProvider = config.endBlockProvider;
            this.minLength = config.minLength;
            this.maxLength = config.maxLength;
            this.whitelist = ImmutableList.copyOf(config.whitelist);
            return this;
        }

        public HangingColumnWithBaseConfig build() {
            return new HangingColumnWithBaseConfig(baseBlockProvider, blockProvider, endBlockProvider, minLength, maxLength, this.whitelist.stream().map(Block::defaultBlockState).collect(Collectors.toList()));
        }
    }
}
