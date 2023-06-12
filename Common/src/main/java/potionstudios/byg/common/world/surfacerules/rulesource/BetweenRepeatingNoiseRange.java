package potionstudios.byg.common.world.surfacerules.rulesource;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import potionstudios.byg.common.world.feature.stateproviders.BetweenNoiseThresholdProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class BetweenRepeatingNoiseRange implements SurfaceRules.RuleSource {

    public static final KeyDispatchDataCodec<BetweenRepeatingNoiseRange> CODEC = KeyDispatchDataCodec.of(RecordCodecBuilder.mapCodec(builder ->
        builder.group(
            ResourceKey.codec(Registries.NOISE).fieldOf("noise").forGetter(betweenRepeatingNoiseRange -> betweenRepeatingNoiseRange.noiseParametersResourceKey),
            Codec.FLOAT.fieldOf("size_per_repetition").forGetter(betweenRepeatingNoiseRange -> betweenRepeatingNoiseRange.size),
            Codec.FLOAT.fieldOf("repeat_from_noise").forGetter(betweenRepeatingNoiseRange -> betweenRepeatingNoiseRange.min),
            Codec.FLOAT.fieldOf("repeat_to_noise").forGetter(betweenRepeatingNoiseRange -> betweenRepeatingNoiseRange.max),
            SurfaceRules.RuleSource.CODEC.listOf().fieldOf("rule_sources").forGetter(betweenRepeatingNoiseRange -> Arrays.asList(betweenRepeatingNoiseRange.ruleSources))
        ).apply(builder, BetweenRepeatingNoiseRange::new))
    );

    private final ResourceKey<NormalNoise.NoiseParameters> noiseParametersResourceKey;
    private final float size;
    private final float min;
    private final float max;
    private final SurfaceRules.RuleSource[] ruleSources;
    private final SurfaceRules.RuleSource rule;

    public BetweenRepeatingNoiseRange(ResourceKey<NormalNoise.NoiseParameters> noiseParametersResourceKey, float size, float min, float max, List<SurfaceRules.RuleSource> ruleSources) {
        this(noiseParametersResourceKey, size, min, max, ruleSources.toArray(SurfaceRules.RuleSource[]::new));
    }

    public BetweenRepeatingNoiseRange(ResourceKey<NormalNoise.NoiseParameters> noiseParametersResourceKey, float size, float min, float max, SurfaceRules.RuleSource... ruleSources) {
        this.noiseParametersResourceKey = noiseParametersResourceKey;
        this.size = size;
        this.min = min;
        this.max = max;
        this.ruleSources = ruleSources;
        this.rule = createNoiseConditions(noiseParametersResourceKey, BetweenNoiseThresholdProvider.createThresholds(size, min, max), ruleSources);
    }

    private static SurfaceRules.RuleSource createNoiseConditions(ResourceKey<NormalNoise.NoiseParameters> parametersResourceKey, List<FloatProvider> ranges, SurfaceRules.RuleSource... source) {
        List<SurfaceRules.RuleSource> sources = new ArrayList<>();
        int index = 0;
        for (FloatProvider range : ranges) {
            SurfaceRules.RuleSource ruleSource = source[index % source.length];
            sources.add(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(parametersResourceKey, range.getMinValue(), range.getMaxValue()), ruleSource));
            index++;
        }
        return SurfaceRules.sequence(sources.toArray(SurfaceRules.RuleSource[]::new));
    }

    @Override
    public KeyDispatchDataCodec<? extends SurfaceRules.RuleSource> codec() {
        return CODEC;
    }

    @Override
    public SurfaceRules.SurfaceRule apply(SurfaceRules.Context context) {
        return rule.apply(context);
    }
}
