package potionstudios.byg.common.world.structure.arch;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.*;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import potionstudios.byg.common.world.feature.config.NoisySphereConfig;
import potionstudios.byg.util.blendingfunction.BlendingFunction;

public record ArchConfiguration(IntProvider height, IntProvider length, IntProvider width,
                                SimpleWeightedRandomList<BlendingFunction> blendingFunction,
                                FloatProvider matchingBlendingFunctionChance,
                                FloatProvider percentageDestroyed,
                                NoisySphereConfig sphereConfig,
                                TagKey<Biome> biomeEnforcement) implements FeatureConfiguration {
    public static final TagKey<Biome> EMPTY = TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("empty", "empty"));

    public static final Codec<ArchConfiguration> CODEC = RecordCodecBuilder.create(builder ->
        builder.group(IntProvider.CODEC.fieldOf("height").forGetter(archConfiguration -> archConfiguration.height),
            IntProvider.POSITIVE_CODEC.fieldOf("length").forGetter(archConfiguration -> archConfiguration.length),
            IntProvider.POSITIVE_CODEC.fieldOf("width").forGetter(archConfiguration -> archConfiguration.width),
            SimpleWeightedRandomList.wrappedCodec(BlendingFunction.CODEC).fieldOf("blending_functions").forGetter(archConfiguration -> archConfiguration.blendingFunction),
            FloatProvider.CODEC.fieldOf("matching_blending_function_chance").forGetter(archConfiguration -> archConfiguration.matchingBlendingFunctionChance),
            FloatProvider.CODEC.fieldOf("percentage_destroyed").forGetter(archConfiguration -> archConfiguration.percentageDestroyed),
            NoisySphereConfig.CODEC.fieldOf("generation").forGetter(archConfiguration -> archConfiguration.sphereConfig),
            TagKey.codec(Registry.BIOME_REGISTRY).fieldOf("allowed_biomes").orElse(EMPTY).forGetter(archConfiguration -> archConfiguration.biomeEnforcement)
        ).apply(builder, ArchConfiguration::new));


    public static final class Builder {
        private IntProvider height = UniformInt.of(35, 90);
        private IntProvider length = UniformInt.of(50, 250);
        private IntProvider width = UniformInt.of(1, 10);
        private NoisySphereConfig sphereConfig = new NoisySphereConfig.Builder().build();
        private SimpleWeightedRandomList<BlendingFunction> blendingFunction = SimpleWeightedRandomList.single(BlendingFunction.EaseOutCubic.INSTANCE);
        private FloatProvider matchingBlendingFunctionChance = ConstantFloat.of(0.5F);
        private FloatProvider percentageDestroyed = UniformFloat.of(0.45F, 0.75F);
        private TagKey<Biome> biomeEnforcement = EMPTY;

        public Builder() {
        }

        public Builder withHeight(IntProvider height) {
            this.height = height;
            return this;
        }

        public Builder withLength(IntProvider length) {
            this.length = length;
            return this;
        }

        public Builder withWidth(IntProvider width) {
            this.width = width;
            return this;
        }

        public Builder withSphereConfig(NoisySphereConfig sphereConfig) {
            this.sphereConfig = sphereConfig;
            return this;
        }

        public Builder withBiomeEnforcement(TagKey<Biome> biomeEnforcement) {
            this.biomeEnforcement = biomeEnforcement;
            return this;
        }

        public Builder withBlendingFunctionType(SimpleWeightedRandomList<BlendingFunction> blendingFunction) {
            this.blendingFunction = blendingFunction;
            return this;
        }

        public Builder withMatchingBlendingFunctionChance(FloatProvider matchingBlendingFunctionChance) {
            this.matchingBlendingFunctionChance = matchingBlendingFunctionChance;
            return this;
        }

        public Builder withPercentageDestroyed(FloatProvider percentageDestroyed) {
            this.percentageDestroyed = percentageDestroyed;
            return this;
        }

        public ArchConfiguration build() {
            return new ArchConfiguration(this.height, this.length, this.width, this.blendingFunction, this.matchingBlendingFunctionChance, this.percentageDestroyed, this.sphereConfig, this.biomeEnforcement);
        }
    }
}
