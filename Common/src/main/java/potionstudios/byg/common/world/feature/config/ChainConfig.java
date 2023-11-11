package potionstudios.byg.common.world.feature.config;

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

public class ChainConfig implements FeatureConfiguration {

    public static final Codec<ChainConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> codecRecorder.group(BlockStateProvider.CODEC.fieldOf("x_axis_block_provider").forGetter((config) -> config.xAxisBlockProvider), BlockStateProvider.CODEC.fieldOf("z_axis_block_provider").forGetter((config) -> config.zAxisBlockProvider), Codec.INT.fieldOf("min_length").forGetter((config) -> config.minLength), Codec.INT.fieldOf("max_length").forGetter((config) -> config.maxLength), BlockState.CODEC.listOf().fieldOf("whitelist").forGetter((config) -> config.whitelist.stream().map(Block::defaultBlockState).collect(Collectors.toList()))).apply(codecRecorder, ChainConfig::new));

    private final BlockStateProvider xAxisBlockProvider;
    private final BlockStateProvider zAxisBlockProvider;
    private final int minLength;
    private final int maxLength;
    private final Set<Block> whitelist;


    ChainConfig(BlockStateProvider baseBlockProvider, BlockStateProvider blockProvider, int minLength, int maxLength, List<BlockState> whitelist) {
        this.xAxisBlockProvider = baseBlockProvider;
        this.zAxisBlockProvider = blockProvider;
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.whitelist = whitelist.stream().map(BlockBehaviour.BlockStateBase::getBlock).collect(Collectors.toSet());
    }

    public BlockStateProvider getXAxisBlockProvider() {
        return xAxisBlockProvider;
    }

    public BlockStateProvider getzAxisBlockProvider() {
        return zAxisBlockProvider;
    }

    public int getMinLength() {
        return minLength;
    }

    public int getMaxLength() {
        return maxLength;
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
        private BlockStateProvider xAxisBlockProvider = SimpleStateProvider.simple(Blocks.COBBLESTONE.defaultBlockState());
        private BlockStateProvider zAxisBlockProvider = SimpleStateProvider.simple(Blocks.COBBLESTONE.defaultBlockState());
        private List<Block> whitelist = ImmutableList.of(Blocks.GRASS_BLOCK);
        private int minLength = 1;
        private int maxLength = 9;

        public Builder setXAxisBlock(Block block) {
            if (block != null)
                xAxisBlockProvider = SimpleStateProvider.simple(block.defaultBlockState());
            else
                xAxisBlockProvider = SimpleStateProvider.simple(Blocks.STONE.defaultBlockState());
            return this;
        }

        public Builder setXAxisBlock(BlockState state) {
            if (state != null)
                xAxisBlockProvider = SimpleStateProvider.simple(state);
            else
                xAxisBlockProvider = SimpleStateProvider.simple(Blocks.STONE.defaultBlockState());
            return this;
        }

        public Builder setXAxisBlock(BlockStateProvider provider) {
            if (provider != null)
                xAxisBlockProvider = provider;
            else
                xAxisBlockProvider = SimpleStateProvider.simple(Blocks.STONE.defaultBlockState());
            return this;
        }

        public Builder setZAxisBlock(Block block) {
            if (block != null)
                zAxisBlockProvider = SimpleStateProvider.simple(block.defaultBlockState());
            else
                zAxisBlockProvider = SimpleStateProvider.simple(Blocks.STONE.defaultBlockState());
            return this;
        }

        public Builder setZAxisBlock(BlockState state) {
            if (state != null)
                zAxisBlockProvider = SimpleStateProvider.simple(state);
            else
                zAxisBlockProvider = SimpleStateProvider.simple(Blocks.STONE.defaultBlockState());
            return this;
        }

        public Builder setZAxisBlock(BlockStateProvider provider) {
            if (provider != null)
                zAxisBlockProvider = provider;
            else
                zAxisBlockProvider = SimpleStateProvider.simple(Blocks.STONE.defaultBlockState());
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

        public Builder copy(ChainConfig config) {
            this.xAxisBlockProvider = config.xAxisBlockProvider;
            this.zAxisBlockProvider = config.zAxisBlockProvider;
            this.minLength = config.minLength;
            this.maxLength = config.maxLength;
            this.whitelist = ImmutableList.copyOf(config.whitelist);
            return this;
        }

        public ChainConfig build() {
            return new ChainConfig(xAxisBlockProvider, zAxisBlockProvider, minLength, maxLength, this.whitelist.stream().map(Block::defaultBlockState).collect(Collectors.toList()));
        }
    }
}
