package potionstudios.byg.common.world.surfacerules.rulesource;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.RandomSource;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.SurfaceSystem;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import potionstudios.byg.mixin.access.SurfaceRuleContextAccess;
import potionstudios.byg.mixin.access.SurfaceSystemAccess;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static potionstudios.byg.mixin.access.SurfaceSystemAccess.byg_invokeMakeBands;

public final class BandsRuleSource implements SurfaceRules.RuleSource {

    public static final Codec<BandsRuleSource> CODEC = RecordCodecBuilder.create(builder ->
        builder.group(
            BlockState.CODEC.listOf().fieldOf("states").forGetter(bandsRuleSource -> Arrays.asList(bandsRuleSource.bandStates))
        ).apply(builder, BandsRuleSource::new));

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
            "bandStates=" + Arrays.toString(bandStates) + ']';
    }

}
