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

public class HangingColumnConfig implements FeatureConfiguration {

    public static final Codec<HangingColumnConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> {
        return codecRecorder.group(BlockStateProvider.CODEC.fieldOf("block_provider").forGetter((config) -> {
            return config.blockProvider;
        }), Codec.INT.fieldOf("min_length").forGetter((config) -> {
            return config.minLength;
        }), Codec.INT.fieldOf("max_length").forGetter((config) -> {
            return config.maxLength;
        }), BlockState.CODEC.listOf().fieldOf("whitelist").forGetter((config) -> {
            return config.whitelist.stream().map(Block::defaultBlockState).collect(Collectors.toList());
        })).apply(codecRecorder, HangingColumnConfig::new);
    });

    private final BlockStateProvider blockProvider;
    private final int minLength;
    private final int maxLength;
    private final Set<Block> whitelist;


    HangingColumnConfig(BlockStateProvider blockProvider, int minLength, int maxLength, List<BlockState> whitelist) {
        this.blockProvider = blockProvider;
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.whitelist = whitelist.stream().map(BlockBehaviour.BlockStateBase::getBlock).collect(Collectors.toSet());
    }

    public BlockStateProvider getBlockProvider() {
        return blockProvider;
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
        private BlockStateProvider blockProvider = new SimpleStateProvider(Blocks.OAK_LEAVES.defaultBlockState());
        private List<Block> whitelist = ImmutableList.of(Blocks.GRASS_BLOCK);
        private int minLength = 1;
        private int maxLength = 9;

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

        public Builder copy(HangingColumnConfig config) {
            this.blockProvider = config.blockProvider;
            this.minLength = config.minLength;
            this.maxLength = config.maxLength;
            this.whitelist = ImmutableList.copyOf(config.whitelist);
            return this;
        }

        public HangingColumnConfig build() {
            return new HangingColumnConfig(blockProvider, minLength, maxLength, this.whitelist.stream().map(Block::defaultBlockState).collect(Collectors.toList()));
        }
    }
}
