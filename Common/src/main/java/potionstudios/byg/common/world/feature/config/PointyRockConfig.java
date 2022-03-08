package potionstudios.byg.common.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import potionstudios.byg.common.world.math.noise.fastnoise.FastNoise;

public class PointyRockConfig implements FeatureConfiguration {

    public static final Codec<PointyRockConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> {
        return codecRecorder.group(BlockStateProvider.CODEC.fieldOf("block_provider").forGetter((config) -> {
            return config.blockProvider;
        }), Codec.INT.fieldOf("seed").orElse(0).forGetter((config) -> {
            return config.seed;
        }), Codec.DOUBLE.fieldOf("height_multiplier").orElse(1.0).forGetter((config) -> {
            return config.heightMultiplier;
        }), PlacedFeature.LIST_CODEC.fieldOf("post_features").forGetter((config) -> {
            return config.placedFeatureHolderSet;
        })).apply(codecRecorder, PointyRockConfig::new);
    });


    private final BlockStateProvider blockProvider;
    private final int seed;
    private final double heightMultiplier;
    private final HolderSet<PlacedFeature> placedFeatureHolderSet;


    PointyRockConfig(BlockStateProvider blockProvider, int seed, double heightMultiplier, HolderSet<PlacedFeature> placedFeatureHolderSet) {
        this.blockProvider = blockProvider;
        this.seed = seed;
        this.heightMultiplier = heightMultiplier;
        this.placedFeatureHolderSet = placedFeatureHolderSet;
    }

    public BlockStateProvider getBlockProvider() {
        return this.blockProvider;
    }

    public int getSeed() {
        return this.seed;
    }

    public double getHeightMultiplier() {
        return this.heightMultiplier;
    }

    private FastNoise noiseGen = null;

    public void setUpNoise(long worldSeed) {
        if (noiseGen == null) {
            noiseGen = new FastNoise((int) (worldSeed + seed));
            noiseGen.SetFractalType(FastNoise.FractalType.RigidMulti);
            noiseGen.SetNoiseType(FastNoise.NoiseType.SimplexFractal);
            noiseGen.SetGradientPerturbAmp(5);
            noiseGen.SetFractalOctaves(1);
            noiseGen.SetFractalGain(0.3f);
            noiseGen.SetFrequency(0.02f);
        }
    }

    public FastNoise getNoiseGen() {
        if (noiseGen == null)
            throw new NullPointerException("Initialize the noiseGen variable with \"setupNoise\" in your feature!");
        else
            return this.noiseGen;
    }

    public HolderSet<PlacedFeature> getPlacedFeatureHolderSet() {
        return placedFeatureHolderSet;
    }

    public static class Builder {
        private BlockStateProvider blockProvider = SimpleStateProvider.simple(Blocks.STONE.defaultBlockState());
        private int seed = 65;
        private double heightMultiplier = 1.0;
        private HolderSet<PlacedFeature> features = HolderSet.direct();

        public Builder setBlock(Block block) {
            this.blockProvider = SimpleStateProvider.simple(block.defaultBlockState());
            return this;
        }

        public Builder setBlock(BlockState state) {
            this.blockProvider = SimpleStateProvider.simple(state);
            return this;
        }


        public Builder setBlock(BlockStateProvider blockProvider) {
            this.blockProvider = blockProvider;
            return this;
        }

        public Builder setSeed(int seed) {
            this.seed = seed;
            return this;
        }

        public Builder setHeightMultiplier(double heightMultiplier) {
            this.heightMultiplier = heightMultiplier;
            return this;
        }
        public Builder setPostFeatures(HolderSet<PlacedFeature> features) {
            this.features = features;
            return this;
        }

        public PointyRockConfig build() {
            return new PointyRockConfig(this.blockProvider, this.seed, this.heightMultiplier, this.features);
        }
    }
}
