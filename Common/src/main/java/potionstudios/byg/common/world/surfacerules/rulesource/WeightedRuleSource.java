package potionstudios.byg.common.world.surfacerules.rulesource;

import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.levelgen.PositionalRandomFactory;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.SurfaceSystem;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.mixin.access.SurfaceRuleContextAccess;
import potionstudios.byg.util.SeedGetter;

import java.util.Objects;

public final class WeightedRuleSource implements SurfaceRules.RuleSource {
    public static KeyDispatchDataCodec<WeightedRuleSource> CODEC = KeyDispatchDataCodec.of(RecordCodecBuilder.mapCodec(builder ->
            builder.group(
                    SimpleWeightedRandomList.wrappedCodec(SurfaceRules.RuleSource.CODEC).fieldOf("provider").forGetter(WeightedRuleSource::ruleSources)
            ).apply(builder, WeightedRuleSource::new)));

    private final SimpleWeightedRandomList<SurfaceRules.RuleSource> ruleSources;

    public WeightedRuleSource(SimpleWeightedRandomList<SurfaceRules.RuleSource> ruleSources) {
        this.ruleSources = ruleSources;
        if (ruleSources.isEmpty()) {
            throw new IllegalStateException("Weighted Rule Source must contain at least 1 value!");
        }
    }

    @Override
    public @NotNull KeyDispatchDataCodec<? extends SurfaceRules.RuleSource> codec() {
        return CODEC;
    }

    @Override
    public SurfaceRules.SurfaceRule apply(SurfaceRules.Context context) {
        SurfaceSystem surfaceSystem = ((SurfaceRuleContextAccess) (Object) context).byg_getSystem();
        PositionalRandomFactory random = ((SeedGetter) surfaceSystem).getRandom();
        SurfaceRules.SurfaceRule[][] rules = new SurfaceRules.SurfaceRule[16][16];

        for (int x = 0; x < rules.length; x++) {
            for (int z = 0; z < rules[x].length; z++) {
                SurfaceRules.SurfaceRule apply = this.ruleSources.getRandomValue(random.at(x, 0, z)).get().apply(context);
                rules[x][z] = apply;
            }
        }
        return (x, y, z) -> rules[x & 15][z & 15].tryApply(x, y, z);
    }

    public SimpleWeightedRandomList<SurfaceRules.RuleSource> ruleSources() {
        return ruleSources;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (WeightedRuleSource) obj;
        return Objects.equals(this.ruleSources, that.ruleSources);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ruleSources);
    }

    @Override
    public String toString() {
        return "StateProviderRule[" +
                "ruleSources=" + ruleSources + ']';
    }
}
