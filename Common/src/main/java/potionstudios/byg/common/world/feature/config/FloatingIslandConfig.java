package potionstudios.byg.common.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloatingIslandConfig implements FeatureConfiguration {

    public static final Codec<FloatingIslandConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> {
        return codecRecorder.group(BlockStateProvider.CODEC.fieldOf("top_block_provider").forGetter((config) -> {
            return config.topBlockProvider;
        }), BlockStateProvider.CODEC.fieldOf("block_provider").forGetter((config) -> {
            return config.blockProvider;
        }), Codec.INT.fieldOf("min_radius").orElse(13).forGetter((config) -> {
            return config.minRadius;
        }), Codec.INT.fieldOf("max_radius").orElse(15).forGetter((config) -> {
            return config.maxRadius;
        }), PlacedFeature.LIST_CODEC.fieldOf("island_features").forGetter(floatingIslandConfig -> {
            return floatingIslandConfig.features;
        })).apply(codecRecorder, FloatingIslandConfig::new);
    });

    private final BlockStateProvider topBlockProvider;
    private final BlockStateProvider blockProvider;
    private final int minRadius;
    private final int maxRadius;
    private final HolderSet<PlacedFeature> features;


    FloatingIslandConfig(BlockStateProvider topBlockProvider, BlockStateProvider blockProvider, int minRadius, int maxRadius, HolderSet<PlacedFeature> features) {
        this.topBlockProvider = topBlockProvider;
        this.blockProvider = blockProvider;
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
        this.features = features;
    }

    public BlockStateProvider getBlockProvider() {
        return this.blockProvider;
    }

    public BlockStateProvider getTopBlockProvider() {
        return this.topBlockProvider;
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

    public HolderSet<PlacedFeature> getPlacedFeatures() {
        return features;
    }

    public static class Builder {
        private BlockStateProvider topBlockProvider = SimpleStateProvider.simple(Blocks.GRASS_BLOCK.defaultBlockState());
        private BlockStateProvider blockProvider = SimpleStateProvider.simple(Blocks.STONE.defaultBlockState());
        private int minRadius = 1;
        private int maxRadius = 3;
        private List<Holder<PlacedFeature>> features = new ArrayList<>();


        public Builder setTopBlock(Block block) {
            if (block != null)
                topBlockProvider = SimpleStateProvider.simple(block.defaultBlockState());
            else
                topBlockProvider = SimpleStateProvider.simple(Blocks.STONE.defaultBlockState());
            return this;
        }

        public Builder setTopBlock(BlockState state) {
            if (state != null)
                topBlockProvider = SimpleStateProvider.simple(state);
            else
                topBlockProvider = SimpleStateProvider.simple(Blocks.STONE.defaultBlockState());
            return this;
        }

        public Builder setTopBlock(BlockStateProvider provider) {
            if (provider != null)
                topBlockProvider = provider;
            else
                topBlockProvider = SimpleStateProvider.simple(Blocks.STONE.defaultBlockState());
            return this;
        }

        public Builder setBlock(Block block) {
            if (block != null)
                blockProvider = SimpleStateProvider.simple(block.defaultBlockState());
            else
                blockProvider = SimpleStateProvider.simple(Blocks.STONE.defaultBlockState());
            return this;
        }

        public Builder setBlock(BlockState state) {
            if (state != null)
                blockProvider = SimpleStateProvider.simple(state);
            else
                blockProvider = SimpleStateProvider.simple(Blocks.STONE.defaultBlockState());
            return this;
        }

        public Builder setBlock(BlockStateProvider provider) {
            if (provider != null)
                blockProvider = provider;
            else
                blockProvider = SimpleStateProvider.simple(Blocks.STONE.defaultBlockState());
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

        public Builder addFeatures(Holder<PlacedFeature>... features) {
            this.features.addAll(Arrays.asList(features));
            return this;
        }

        public Builder copy(FloatingIslandConfig config) {
            this.topBlockProvider = config.topBlockProvider;
            this.blockProvider = config.blockProvider;
            this.minRadius = config.minRadius;
            this.maxRadius = config.maxRadius;
            this.features = config.features.stream().toList();
            return this;
        }

        public FloatingIslandConfig build() {
            return new FloatingIslandConfig(this.topBlockProvider, this.blockProvider, this.minRadius, this.maxRadius, HolderSet.direct(features));
        }
    }
}
