package potionstudios.byg.common.world.surfacerules;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.RandomSource;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.SurfaceSystem;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import potionstudios.byg.BYG;
import potionstudios.byg.mixin.access.SurfaceRuleContextAccess;
import potionstudios.byg.mixin.access.SurfaceSystemAccess;
import potionstudios.byg.util.ChunkRandom;
import potionstudios.byg.util.SeedGetter;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static potionstudios.byg.BYG.createLocation;
import static potionstudios.byg.mixin.access.SurfaceSystemAccess.byg_invokeMakeBands;

public class BYGRuleSources {

    public static WeightedRuleSource weightedRuleSource(SimpleWeightedRandomList<SurfaceRules.RuleSource> ruleSource) {
        return new WeightedRuleSource(ruleSource);
    }

    public static BandsRuleSource bands(BlockState... bandStates) {
        return new BandsRuleSource(bandStates);
    }

    public static final class WeightedRuleSource implements SurfaceRules.RuleSource {
        public static Codec<WeightedRuleSource> CODEC = RecordCodecBuilder.create(builder -> {
            return builder.group(
                    SimpleWeightedRandomList.wrappedCodec(SurfaceRules.RuleSource.CODEC).fieldOf("provider").forGetter(WeightedRuleSource::ruleSources)
            ).apply(builder, WeightedRuleSource::new);
        });
        private final SimpleWeightedRandomList<SurfaceRules.RuleSource> ruleSources;

        public WeightedRuleSource(SimpleWeightedRandomList<SurfaceRules.RuleSource> ruleSources) {
            this.ruleSources = ruleSources;
            if (ruleSources.isEmpty()) {
                throw new IllegalStateException("Weighted Rule Source must contain at least 1 value!");
            }
        }

        @Override
        public Codec<? extends SurfaceRules.RuleSource> codec() {
            return CODEC;
        }

        @Override
        public SurfaceRules.SurfaceRule apply(SurfaceRules.Context context) {
            SurfaceSystem surfaceSystem = ((SurfaceRuleContextAccess) (Object) context).byg_getSystem();
            ChunkAccess chunkAccess = ((SurfaceRuleContextAccess) (Object) context).byg_getChunk();
            Random random = ((ChunkRandom) chunkAccess).getRandom(((SeedGetter) surfaceSystem).getLong());
            SurfaceRules.SurfaceRule[][] rules = new SurfaceRules.SurfaceRule[16][16];

            for (int x = 0; x < rules.length; x++) {
                for (int z = 0; z < rules[x].length; z++) {
                    SurfaceRules.SurfaceRule apply = this.ruleSources.getRandomValue(random).get().apply(context);
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

    public static final class BandsRuleSource implements SurfaceRules.RuleSource {

        public static final Codec<BandsRuleSource> CODEC = RecordCodecBuilder.create(builder -> {
            return builder.group(
                    BlockState.CODEC.listOf().fieldOf("states").forGetter(bandsRuleSource -> Arrays.asList(bandsRuleSource.bandStates))
            ).apply(builder, BandsRuleSource::new);
        });

        private final BlockState[] bandStates;
        @Nullable
        private BlockState[] generatedBands = null;

        public BandsRuleSource(List<BlockState> bandStates) {
            this(bandStates.toArray(BlockState[]::new));
        }

        public BandsRuleSource(BlockState[] bandStates) {
            this.bandStates = new BlockState[8];
            for (int i = 0; i < this.bandStates.length; i++) {
                this.bandStates[i] = bandStates[Math.min(i, bandStates.length - 1)];
            }
        }

        @Override
        public Codec<? extends SurfaceRules.RuleSource> codec() {
            return CODEC;
        }

        @Override
        public SurfaceRules.SurfaceRule apply(SurfaceRules.Context context) {
            SurfaceSystem system = ((SurfaceRuleContextAccess) (Object) context).byg_getSystem();
            if (generatedBands == null) {
                generatedBands = this.generateBands(((SurfaceSystemAccess) system).byg_getRandomFactory().fromHashOf(new ResourceLocation("clay_bands")));
            }

            return (x, y, z) -> getBand(x, y, z, generatedBands, ((SurfaceSystemAccess) system).byg_getClayBandsOffsetNoise());
        }

        private static BlockState getBand(int x, int y, int z, BlockState[] bands, NormalNoise offsetNoise) {
            int noiseVal = (int) Math.round(offsetNoise.getValue(x, 0.0D, z) * 4.0D);
            return bands[(y + noiseVal + bands.length) % bands.length];
        }

        private BlockState[] generateBands(RandomSource p_189965_) {
            BlockState[] ablockstate = new BlockState[192];
            Arrays.fill(ablockstate, this.bandStates[0]);

            for (int k = 0; k < ablockstate.length; ++k) {
                k += p_189965_.nextInt(5) + 1;
                if (k < ablockstate.length) {
                    ablockstate[k] = this.bandStates[1];
                }
            }

            byg_invokeMakeBands(p_189965_, ablockstate, 1, this.bandStates[2]);
            byg_invokeMakeBands(p_189965_, ablockstate, 2, this.bandStates[3]);
            byg_invokeMakeBands(p_189965_, ablockstate, 1, this.bandStates[4]);
            int l = p_189965_.nextIntBetweenInclusive(9, 15);
            int i = 0;

            for (int j = 0; i < l && j < ablockstate.length; j += p_189965_.nextInt(16) + 4) {
                ablockstate[j] = this.bandStates[5];
                BlockState state6 = this.bandStates[6];
                if (j - 1 > 0 && p_189965_.nextBoolean()) {
                    ablockstate[j - 1] = state6;
                }

                if (j + 1 < ablockstate.length && p_189965_.nextBoolean()) {
                    ablockstate[j + 1] = state6;
                }

                ++i;
            }

            return ablockstate;
        }

        public BlockState[] bandStates() {
            return bandStates;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (BandsRuleSource) obj;
            return Objects.equals(this.bandStates, that.bandStates);
        }

        @Override
        public int hashCode() {
            return Objects.hash(bandStates);
        }

        @Override
        public String toString() {
            return "ShatteredGlacierIceBands[" +
                    "bandStates=" + bandStates + ']';
        }

    }

    public static void bootStrap() {
    }

    static {
        Registry.register(Registry.RULE, createLocation("state_provider"), WeightedRuleSource.CODEC);
        Registry.register(Registry.RULE, createLocation("bands"), BandsRuleSource.CODEC);

        BYG.LOGGER.info("BYG Rule Sources class loaded.");

    }
}
