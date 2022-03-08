package potionstudios.byg.common.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

import java.util.ArrayList;
import java.util.List;

public record NoisySphereConfig(BlockStateProvider blockProvider, BlockStateProvider topBlockProvider,
                                IntProvider stackHeight, RadiusSettings radiusSettings, double radiusDivisorPerStack,
                                float noiseFrequency, int fluidStartY, FluidState fluidState, double noise2DChance,
                                RadiusMatcher radiusMatcher, boolean checkSquareDistance, boolean useScaledNoiseHeight,
                                boolean pointed, boolean verfiesHeight, IntProvider belowSurfaceDepth,
                                HolderSet<PlacedFeature> spawningFeatures) implements FeatureConfiguration {

    public static final Codec<NoisySphereConfig> CODEC = RecordCodecBuilder.create(
        codecRecorder -> codecRecorder.group(
            BlockStateProvider.CODEC.fieldOf("block_provider").forGetter(config -> config.blockProvider),
            BlockStateProvider.CODEC.fieldOf("top_block_provider").forGetter(config -> config.topBlockProvider),
            IntProvider.CODEC.fieldOf("stackHeight").forGetter(config -> config.stackHeight),
            RadiusSettings.CODEC.fieldOf("radius_settings").forGetter(config -> config.radiusSettings),
            Codec.DOUBLE.fieldOf("radius_divisor_per_stack").orElse(1.0).forGetter(config -> config.radiusDivisorPerStack),
            Codec.FLOAT.fieldOf("noise_frequency").orElse(1.0F).forGetter(config -> config.noiseFrequency),
            Codec.INT.fieldOf("fluid_start_y").orElse(12).forGetter(config -> config.fluidStartY),
            FluidState.CODEC.fieldOf("fluidState").orElse(Fluids.EMPTY.defaultFluidState()).forGetter(config -> config.fluidState),
            Codec.DOUBLE.fieldOf("2d_noise_chance").orElse(0.25D).forGetter(config -> config.noise2DChance),
            RadiusMatcher.CODEC.fieldOf("radius_matcher").orElse(RadiusMatcher.NONE).forGetter(config -> config.radiusMatcher),
            Codec.BOOL.fieldOf("squared_distance_check").orElse(true).forGetter(config -> config.checkSquareDistance),
            Codec.BOOL.fieldOf("use_scaled_noise_height").orElse(false).forGetter(config -> config.useScaledNoiseHeight),
            Codec.BOOL.fieldOf("verifies_height").orElse(true).forGetter(config -> config.verfiesHeight),
            Codec.BOOL.fieldOf("pointed").orElse(false).forGetter(config -> config.pointed),
            IntProvider.CODEC.fieldOf("belowSurfaceDepth").forGetter(config -> config.belowSurfaceDepth),
            PlacedFeature.LIST_CODEC.fieldOf("edge_features").forGetter(noisySphereConfig -> noisySphereConfig.spawningFeatures)
        ).apply(codecRecorder, NoisySphereConfig::new));

    public record RadiusSettings(IntProvider xRadius, IntProvider yRadius, int upperHalfAdditional,
                                 IntProvider zRadius) {
        public static Codec<RadiusSettings> CODEC = RecordCodecBuilder.create(builder ->
            builder.group(
                IntProvider.CODEC.fieldOf("x_radius").forGetter(config -> config.xRadius),
                IntProvider.CODEC.fieldOf("y_radius").forGetter(config -> config.yRadius),
                Codec.INT.fieldOf("upper_half_additional").orElse(0).forGetter(config -> config.upperHalfAdditional),
                IntProvider.CODEC.fieldOf("z_radius").forGetter(config -> config.zRadius)
            ).apply(builder, RadiusSettings::new));
    }


    public static final class Builder {
        public static final BlockStateProvider DEFAULT = SimpleStateProvider.simple(Blocks.STONE);

        private BlockStateProvider blockProvider = DEFAULT;
        private BlockStateProvider topBlockProvider = DEFAULT;
        private IntProvider stackHeight = ConstantInt.of(1);
        private RadiusSettings radiusSettings = new RadiusSettings(UniformInt.of(1, 3), UniformInt.of(1, 3), 0, UniformInt.of(1, 3));
        private double radiusDivisorPerStack = 1;
        private float noiseFrequency = 0.04F;
        private int fluidStartY = Integer.MIN_VALUE;
        private FluidState fluidState = Fluids.EMPTY.defaultFluidState();
        private double noise2DChance = 0.25D;
        private RadiusMatcher radiusMatcher = RadiusMatcher.NONE;
        private boolean checkSquareDistance = true;
        private boolean useScaledNoiseHeight = true;
        private boolean pointed = false;
        private boolean verifiesHeight = false;
        private IntProvider belowSurfaceDepth = ConstantInt.of(Integer.MAX_VALUE);
        private List<Holder<PlacedFeature>> spawningFeatures = new ArrayList<>();

        public Builder() {
        }

        public Builder withBlockProvider(BlockStateProvider blockProvider) {
            this.blockProvider = blockProvider;
            return this;
        }

        public Builder withTopBlockProvider(BlockStateProvider topBlockProvider) {
            this.topBlockProvider = topBlockProvider;
            return this;
        }

        public Builder withStackHeight(IntProvider stackHeight) {
            this.stackHeight = stackHeight;
            return this;
        }

        public Builder withRadiusSettings(RadiusSettings radiusSettings) {
            this.radiusSettings = radiusSettings;
            return this;
        }

        public Builder withRadiusDivisorPerStack(double radiusDivisorPerStack) {
            this.radiusDivisorPerStack = radiusDivisorPerStack;
            return this;
        }

        public Builder withNoiseFrequency(float noiseFrequency) {
            this.noiseFrequency = noiseFrequency;
            return this;
        }

        public Builder withFluidStartY(int fluidStartY) {
            this.fluidStartY = fluidStartY;
            return this;
        }

        public Builder withFluidState(FluidState fluidState) {
            this.fluidState = fluidState;
            return this;
        }

        public Builder withNoise2DChance(double noise2DChance) {
            this.noise2DChance = noise2DChance;
            return this;
        }

        public Builder withRadiusMatcher(RadiusMatcher radiusMatcher) {
            this.radiusMatcher = radiusMatcher;
            return this;
        }

        public Builder withCheckSquareDistance(boolean checkSquareDistance) {
            this.checkSquareDistance = checkSquareDistance;
            return this;
        }

        public Builder withScaledHeight(boolean useScaledNoiseHeight) {
            this.useScaledNoiseHeight = useScaledNoiseHeight;
            return this;
        }

        public Builder withPointed(boolean pointed) {
            this.pointed = pointed;
            return this;
        }

        public Builder withVerifiesHeight(boolean verifiesHeight) {
            this.verifiesHeight = verifiesHeight;
            return this;
        }

        public Builder withBelowSurfaceDepth(IntProvider belowSurfaceDepth) {
            this.belowSurfaceDepth = belowSurfaceDepth;
            return this;
        }

        public Builder withSpawningFeatures(List<Holder<PlacedFeature>> spawningFeatures) {
            this.spawningFeatures = spawningFeatures;
            return this;
        }


        public Builder copy(NoisySphereConfig copy) {
            this.blockProvider = copy.blockProvider;
            this.topBlockProvider = copy.topBlockProvider;
            this.stackHeight = copy.stackHeight;
            this.radiusSettings = copy.radiusSettings;
            this.radiusDivisorPerStack = copy.radiusDivisorPerStack;
            this.noiseFrequency = copy.noiseFrequency;
            this.fluidStartY = copy.fluidStartY;
            this.fluidState = copy.fluidState;
            this.noise2DChance = copy.noise2DChance;
            this.radiusMatcher = copy.radiusMatcher;
            this.checkSquareDistance = copy.checkSquareDistance;
            this.useScaledNoiseHeight = copy.useScaledNoiseHeight;
            this.belowSurfaceDepth = copy.belowSurfaceDepth;
            this.pointed = copy.pointed;
            this.verifiesHeight = copy.verfiesHeight;
            this.spawningFeatures = copy.spawningFeatures.stream().toList();
            return this;
        }

        public NoisySphereConfig build() {
            return new NoisySphereConfig(blockProvider, topBlockProvider, stackHeight, radiusSettings, radiusDivisorPerStack, noiseFrequency, fluidStartY, fluidState, noise2DChance, radiusMatcher, checkSquareDistance, useScaledNoiseHeight, pointed, verifiesHeight, belowSurfaceDepth, HolderSet.direct(spawningFeatures));
        }
    }
}