package potionstudios.byg.common.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class NoisySphereConfig implements FeatureConfiguration {

    public static final Codec<NoisySphereConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> {
        return codecRecorder.group(BlockStateProvider.CODEC.fieldOf("block_provider").forGetter((config) -> {
            return config.blockProvider;
        }), BlockStateProvider.CODEC.fieldOf("top_block_provider").forGetter((config) -> {
            return config.topBlockProvider;
        }), Codec.INT.fieldOf("min_stack_height").orElse(1).forGetter((config) -> {
            return config.minHeight;
        }), Codec.INT.fieldOf("max_stack_height").orElse(1).forGetter((config) -> {
            return config.maxHeight;
        }), RadiusSettings.CODEC.fieldOf("radius_settings").forGetter(config -> {
            return config.radiusSettings;
        }), Codec.DOUBLE.fieldOf("radius_divisor_per_stack").orElse(1.0).forGetter((config) -> {
            return config.radiusDivisorPerStack;
        }), Codec.FLOAT.fieldOf("noise_frequency").orElse(1.0F).forGetter((config) -> {
            return config.noiseFrequency;
        }), Codec.INT.fieldOf("fluid_start_y").orElse(12).forGetter((config) -> {
            return config.fluidStartY;
        }), Codec.DOUBLE.fieldOf("2d_noise_chance").orElse(0.25D).forGetter((config) -> {
            return config.noise2DChance;
        }), RadiusMatcher.CODEC.fieldOf("radius_matcher").orElse(RadiusMatcher.NONE).forGetter((config) -> {
            return config.radiusMatcher;
        }), Codec.BOOL.fieldOf("squared_distance_check").orElse(true).forGetter((config) -> {
            return config.squaredDistanceCheck;
        }), PlacedFeature.LIST_CODEC.fieldOf("edge_features").forGetter(noisySphereConfig -> noisySphereConfig.spawningFeatures)
        ).apply(codecRecorder, NoisySphereConfig::new);
    });


    private final BlockStateProvider blockProvider;
    private final BlockStateProvider topBlockProvider;
    private final int minHeight;
    private final int maxHeight;
    private final int minXRadius;
    private final int maxXRadius;
    private final int minYRadius;
    private final int maxYRadius;
    private final int positiveYRadiusAddition;
    private final int minZRadius;
    private final int maxZRadius;
    private final double radiusDivisorPerStack;
    private final float noiseFrequency;
    private final int fluidStartY;
    private final double noise2DChance;
    private final RadiusMatcher radiusMatcher;
    private final RadiusSettings radiusSettings;
    private final boolean squaredDistanceCheck;
    private final List<Supplier<PlacedFeature>> spawningFeatures;

    NoisySphereConfig(BlockStateProvider blockProvider, BlockStateProvider topBlockProvider, int minHeight, int maxHeight, int minXRadius, int maxXRadius, int minYRadius, int maxYRadius, int positiveYRadiusAddition, int minZRadius, int maxZRadius, double radiusDivisorPerStack, float noiseFrequency, int fluidStartY, double noise2DChance, RadiusMatcher radiusMatcher, boolean squaredDistanceCheck, List<Supplier<PlacedFeature>> spawningFeatures) {
        this(blockProvider, topBlockProvider, minHeight, maxHeight, new RadiusSettings(minXRadius, maxXRadius, minYRadius, maxYRadius, positiveYRadiusAddition, minZRadius, maxZRadius), radiusDivisorPerStack, noiseFrequency, fluidStartY, noise2DChance, radiusMatcher, squaredDistanceCheck, spawningFeatures);
    }

    NoisySphereConfig(BlockStateProvider blockProvider, BlockStateProvider topBlockProvider, int minHeight, int maxHeight, RadiusSettings radiusSettings, double radiusDivisorPerStack, float noiseFrequency, int fluidStartY, double noise2DChance, RadiusMatcher radiusMatcher, boolean squaredDistanceCheck, List<Supplier<PlacedFeature>> spawningFeatures) {
        this.blockProvider = blockProvider;
        this.topBlockProvider = topBlockProvider;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.minXRadius = radiusSettings.minXRadius;
        this.maxXRadius = radiusSettings.maxXRadius;
        this.minYRadius = radiusSettings.minYRadius;
        this.maxYRadius = radiusSettings.maxYRadius;
        this.positiveYRadiusAddition = radiusSettings.positiveYRadiusAddition;
        this.minZRadius = radiusSettings.minZRadius;
        this.maxZRadius = radiusSettings.maxZRadius;
        this.radiusDivisorPerStack = radiusDivisorPerStack;
        this.noiseFrequency = noiseFrequency;
        this.fluidStartY = fluidStartY;
        this.noise2DChance = noise2DChance;
        this.radiusMatcher = radiusMatcher;
        this.squaredDistanceCheck = squaredDistanceCheck;
        this.radiusSettings = radiusSettings;
        this.spawningFeatures = spawningFeatures;
    }

    public BlockStateProvider getBlockProvider() {
        return this.blockProvider;
    }

    public BlockStateProvider getTopBlockProvider() {
        return topBlockProvider;
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

        return returnValue + 1;
    }

    public int getMinXRadius() {
        return Math.abs(minXRadius);
    }

    public int getMaxXRadius() {
        return Math.abs(maxXRadius);
    }

    public int getMinYRadius() {
        return minYRadius;
    }

    public int getMaxYRadius() {
        return maxYRadius;
    }

    public int getMinZRadius() {
        return minZRadius;
    }

    public int getMaxZRadius() {
        return maxZRadius;
    }

    public int getMaxPossibleXRadius() {
        int returnValue = this.maxXRadius - minXRadius;
        if (returnValue <= 0)
            returnValue = 1;

        return Math.abs(returnValue);
    }

    public int getMaxPossibleYRadius() {
        int returnValue = this.maxYRadius - minYRadius;
        if (returnValue <= 0)
            returnValue = 1;

        return Math.abs(returnValue);
    }

    public int getMaxPossibleZRadius() {
        int returnValue = this.maxZRadius - minZRadius;
        if (returnValue <= 0)
            returnValue = 1;

        return Math.abs(returnValue);
    }

    public int getRandomStackHeight(Random rand) {
        return rand.nextInt(Math.max(1, maxHeight - minHeight)) + minHeight;
    }

    public int getRandomXRadius(Random rand) {
        return rand.nextInt(Math.max(1, maxXRadius - minXRadius)) + minXRadius;
    }

    public int getRandomYRadius(Random rand) {
        return rand.nextInt(Math.max(1, maxYRadius - minYRadius)) + minYRadius;
    }

    public int getRandomZRadius(Random rand) {
        return rand.nextInt(Math.max(1, maxZRadius - minZRadius)) + minZRadius;
    }

    public RadiusMatcher getRadiusMatcher() {
        return radiusMatcher;
    }

    public double getRadiusDivisorPerStack() {
        return this.radiusDivisorPerStack;
    }

    public float getNoiseFrequency() {
        return noiseFrequency;
    }

    public int getFluidStartY() {
        return fluidStartY;
    }

    public int getPositiveYRadiusAddition() {
        return positiveYRadiusAddition;
    }

    public double getNoise2DChance() {
        return noise2DChance;
    }

    public boolean isSquaredDistanceChecked() {
        return squaredDistanceCheck;
    }

    public List<Supplier<PlacedFeature>> getSpawningFeatures() {
        return spawningFeatures;
    }

    public record RadiusSettings(int minXRadius, int maxXRadius, int minYRadius, int maxYRadius,
                                 int positiveYRadiusAddition, int minZRadius, int maxZRadius) {
        public static Codec<RadiusSettings> CODEC = RecordCodecBuilder.create(builder -> {
            return builder.group(Codec.INT.fieldOf("min_x_radius").orElse(11).forGetter((config) -> {
                return config.minXRadius;
            }), Codec.INT.fieldOf("max_x_radius").orElse(15).forGetter((config) -> {
                return config.maxXRadius;
            }), Codec.INT.fieldOf("min_y_radius").orElse(15).forGetter((config) -> {
                return config.minYRadius;
            }), Codec.INT.fieldOf("max_y_radius").orElse(15).forGetter((config) -> {
                return config.maxYRadius;
            }), Codec.INT.fieldOf("positive_y_radius_addition").orElse(0).forGetter((config) -> {
                return config.positiveYRadiusAddition;
            }), Codec.INT.fieldOf("min_z_radius").orElse(15).forGetter((config) -> {
                return config.minZRadius;
            }), Codec.INT.fieldOf("max_z_radius").orElse(15).forGetter((config) -> {
                return config.maxZRadius;
            })).apply(builder, RadiusSettings::new);
        });
    }

    public static class Builder {
        private BlockStateProvider blockProvider = SimpleStateProvider.simple(Blocks.STONE.defaultBlockState());
        private BlockStateProvider topBlockProvider = SimpleStateProvider.simple(Blocks.STONE.defaultBlockState());
        private int minStackHeight = 1;
        private int maxStackHeight = 1;
        private int minXRadius = 1;
        private int maxXRadius = 3;
        private int minYRadius = minXRadius;
        private int maxYRadius = maxXRadius;
        private int positiveYRadiusAddition = 0;
        private int minZRadius = minXRadius;
        private int maxZRadius = maxXRadius;
        private double radiusDivisorPerStack = 1.0;
        private float noiseFrequency = 0.09F;
        private int fluidStartY = 25;
        private double noise2DChance = 0.25D;
        private RadiusMatcher radiusMatcher = RadiusMatcher.ALL;
        private boolean squaredDistanceCheck = true;
        private final List<Supplier<PlacedFeature>> spawningFeatures = new ArrayList<>();

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

        public Builder setMinStackHeight(int minStackHeight) {
            if (minStackHeight <= 0)
                this.minStackHeight = 1;
            else
                this.minStackHeight = minStackHeight;
            return this;
        }

        public Builder setMaxStackHeight(int maxPossibleHeight) {
            if (maxPossibleHeight <= 0)
                this.maxStackHeight = minStackHeight + 1;
            else
                this.maxStackHeight = maxPossibleHeight;
            return this;
        }

        public Builder setMinXRadius(int minXRadius) {
            if (minXRadius <= 0)
                this.minXRadius = 1;
            else
                this.minXRadius = minXRadius;
            return this;
        }

        public Builder setMaxXRadius(int maxXRadius) {
            if (maxXRadius <= 0)
                this.maxXRadius = minXRadius + 1;
            else
                this.maxXRadius = maxXRadius;
            return this;
        }

        public Builder setMinYRadius(int minYRadius) {
            this.minYRadius = minYRadius;
            return this;
        }

        public Builder setMaxYRadius(int maxYRadius) {
            this.maxYRadius = maxYRadius;
            return this;
        }

        public Builder setMinZRadius(int minZRadius) {
            this.minZRadius = minZRadius;
            return this;
        }

        public Builder setMaxZRadius(int maxZRadius) {
            this.maxZRadius = maxZRadius;
            return this;
        }

        public Builder setRadiusDivisor(double radiusDivisorPerStack) {
            this.radiusDivisorPerStack = radiusDivisorPerStack;
            return this;
        }

        public Builder setNoiseFrequency(float noiseFrequency) {
            this.noiseFrequency = noiseFrequency;
            return this;
        }

        public Builder setFluidStartY(int fluidStartY) {
            this.fluidStartY = fluidStartY;
            return this;
        }

        public Builder setPositiveYRadiusAddition(int positiveYRadiusAddition) {
            this.positiveYRadiusAddition = positiveYRadiusAddition;
            return this;
        }

        public Builder setNoise2DChance(double noise2DChance) {
            this.noise2DChance = noise2DChance;
            return this;
        }

        public Builder setRadiusMatcher(RadiusMatcher radiusMatcher) {
            this.radiusMatcher = radiusMatcher;
            return this;
        }

        public Builder setSquaredDistanceCheck(boolean squaredDistanceCheck) {
            this.squaredDistanceCheck = squaredDistanceCheck;
            return this;
        }
        
        public Builder addSpawningFeature(Supplier<PlacedFeature>... features) {
            this.spawningFeatures.addAll(List.of(features));
            return this;
        }

        public Builder copy(NoisySphereConfig config) {
            this.blockProvider = config.blockProvider;
            this.topBlockProvider = config.topBlockProvider;
            this.minStackHeight = config.minHeight;
            this.maxStackHeight = config.maxHeight;
            this.minXRadius = config.minXRadius;
            this.maxXRadius = config.maxXRadius;
            this.minYRadius = config.minYRadius;
            this.maxYRadius = config.maxYRadius;
            this.positiveYRadiusAddition = config.positiveYRadiusAddition;
            this.minZRadius = config.minZRadius;
            this.maxZRadius = config.maxZRadius;
            this.radiusDivisorPerStack = config.radiusDivisorPerStack;
            this.noiseFrequency = config.noiseFrequency;
            this.noise2DChance = config.noise2DChance;
            this.radiusMatcher = config.radiusMatcher;
            this.squaredDistanceCheck = config.squaredDistanceCheck;
            this.spawningFeatures.addAll(config.spawningFeatures);
            return this;
        }

        public NoisySphereConfig build() {
            return new NoisySphereConfig(this.blockProvider, this.topBlockProvider, this.minStackHeight, this.maxStackHeight, this.minXRadius / 2, this.maxXRadius / 2, minYRadius / 2, maxYRadius / 2, this.positiveYRadiusAddition, minZRadius / 2, maxZRadius / 2, this.radiusDivisorPerStack, this.noiseFrequency, this.fluidStartY, this.noise2DChance, this.radiusMatcher, this.squaredDistanceCheck, this.spawningFeatures);
        }
    }
}