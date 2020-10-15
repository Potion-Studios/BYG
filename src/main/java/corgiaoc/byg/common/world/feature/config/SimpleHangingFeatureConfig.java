package corgiaoc.byg.common.world.feature.config;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.IFeatureConfig;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SimpleHangingFeatureConfig implements IFeatureConfig {

    public static final Codec<SimpleHangingFeatureConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> {
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
            return config.whitelist.stream().map(Block::getDefaultState).collect(Collectors.toList());
        })).apply(codecRecorder, SimpleHangingFeatureConfig::new);
    });

    private final BlockStateProvider baseBlockProvider;
    private final BlockStateProvider blockProvider;
    private final BlockStateProvider endBlockProvider;
    private final int minLength;
    private final int maxLength;
    private final Set<Block> whitelist;


    SimpleHangingFeatureConfig(BlockStateProvider baseBlockProvider, BlockStateProvider blockProvider, BlockStateProvider endBlockProvider, int minLength, int maxLength, List<BlockState> whitelist) {
        this.baseBlockProvider = baseBlockProvider;
        this.blockProvider = blockProvider;
        this.endBlockProvider = endBlockProvider;
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.whitelist = whitelist.stream().map(AbstractBlock.AbstractBlockState::getBlock).collect(Collectors.toSet());

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

    public Set<Block> getWhitelist() {
        return whitelist;
    }

    public static class Builder {
        private BlockStateProvider baseBlockProvider = new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState());
        private BlockStateProvider blockProvider = new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState());
        private BlockStateProvider endBlockProvider = new SimpleBlockStateProvider(Blocks.AIR.getDefaultState());;
        private List<Block> whitelist = ImmutableList.of(Blocks.GRASS_BLOCK);
        private int minLength = 1;
        private int maxLength = 9;

        public SimpleHangingFeatureConfig.Builder setBaseBlock(Block block) {
            if (block != null)
                baseBlockProvider = new SimpleBlockStateProvider(block.getDefaultState());
            else
                baseBlockProvider = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
            return this;
        }

        public SimpleHangingFeatureConfig.Builder setBaseBlock(BlockState state) {
            if (state != null)
                baseBlockProvider = new SimpleBlockStateProvider(state);
            else
                baseBlockProvider = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
            return this;
        }

        public SimpleHangingFeatureConfig.Builder setBaseBlock(BlockStateProvider provider) {
            if (provider != null)
                baseBlockProvider = provider;
            else
                baseBlockProvider = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
            return this;
        }

        public SimpleHangingFeatureConfig.Builder setBlock(Block block) {
            if (block != null)
                blockProvider = new SimpleBlockStateProvider(block.getDefaultState());
            else
                blockProvider = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
            return this;
        }

        public SimpleHangingFeatureConfig.Builder setBlock(BlockState state) {
            if (state != null)
                blockProvider = new SimpleBlockStateProvider(state);
            else
                blockProvider = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
            return this;
        }

        public SimpleHangingFeatureConfig.Builder setBlock(BlockStateProvider provider) {
            if (provider != null)
                blockProvider = provider;
            else
                blockProvider = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
            return this;
        }

        public SimpleHangingFeatureConfig.Builder setEndBlock(Block block) {
            if (block != null)
                endBlockProvider = new SimpleBlockStateProvider(block.getDefaultState());
            else
                endBlockProvider = blockProvider;
            return this;
        }

        public SimpleHangingFeatureConfig.Builder setEndBlock(BlockState state) {
            if (state != null)
                endBlockProvider = new SimpleBlockStateProvider(state);
            else
                endBlockProvider = blockProvider;
            return this;
        }

        public SimpleHangingFeatureConfig.Builder setEndBlock(BlockStateProvider provider) {
            if (provider != null)
                endBlockProvider = provider;
            else
                endBlockProvider = blockProvider;
            return this;
        }

        public SimpleHangingFeatureConfig.Builder setMinLength(int minLength) {
            this.minLength = minLength;
            return this;
        }

        public SimpleHangingFeatureConfig.Builder setMaxLength(int maxPossibleHeight) {
            if (maxPossibleHeight != 0)
                this.maxLength = maxPossibleHeight + 1;
            else
                this.maxLength = 1;
            return this;
        }

        public SimpleHangingFeatureConfig.Builder setWhitelist(ImmutableList<Block> whitelist) {
            this.whitelist = whitelist;
            return this;
        }

        public SimpleHangingFeatureConfig.Builder copy(SimpleHangingFeatureConfig config) {
            this.baseBlockProvider = config.baseBlockProvider;
            this.blockProvider = config.blockProvider;
            this.endBlockProvider = config.endBlockProvider;
            this.minLength = config.minLength;
            this.maxLength = config.maxLength;
            this.whitelist = ImmutableList.copyOf(config.whitelist);
            return this;
        }

        public SimpleHangingFeatureConfig build() {
            return new SimpleHangingFeatureConfig(baseBlockProvider, blockProvider, endBlockProvider, minLength, maxLength, this.whitelist.stream().map(Block::getDefaultState).collect(Collectors.toList()));
        }
    }
}
