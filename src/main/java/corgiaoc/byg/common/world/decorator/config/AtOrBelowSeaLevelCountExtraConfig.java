package corgiaoc.byg.common.world.decorator.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.DecoratorConfiguration;

public class AtOrBelowSeaLevelCountExtraConfig implements DecoratorConfiguration {
    public static final Codec<AtOrBelowSeaLevelCountExtraConfig> CODEC = RecordCodecBuilder.create((configRecorder) -> {
        return configRecorder.group(Codec.INT.fieldOf("count").forGetter((config) -> {
            return config.count;
        }), Codec.FLOAT.fieldOf("extra_chance").forGetter((config) -> {
            return config.extraChance;
        }), Codec.INT.fieldOf("extra_count").forGetter((config) -> {
            return config.extraCount;
        }), Codec.INT.fieldOf("below_sea_level").forGetter((config) -> {
            return config.belowSeaLevel;
        })).apply(configRecorder, AtOrBelowSeaLevelCountExtraConfig::new);
    });

    public final int count;
    public final float extraChance;
    public final int extraCount;
    public final int belowSeaLevel;

    public AtOrBelowSeaLevelCountExtraConfig(int count, float extraChance, int extraCount, int belowSeaLevel) {
        this.count = count;
        this.extraChance = extraChance;
        this.extraCount = extraCount;
        this.belowSeaLevel = belowSeaLevel;
    }
}
