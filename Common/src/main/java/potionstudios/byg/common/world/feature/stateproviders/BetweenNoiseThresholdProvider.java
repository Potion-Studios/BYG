package potionstudios.byg.common.world.feature.stateproviders;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;
import net.minecraft.world.level.levelgen.feature.stateproviders.NoiseBasedStateProvider;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BetweenNoiseThresholdProvider extends NoiseBasedStateProvider {

    public static final Codec<BetweenNoiseThresholdProvider> CODEC = RecordCodecBuilder.create((builder) -> {
        return noiseCodec(builder).and(
                builder.group(
                        FloatProvider.CODEC.listOf().fieldOf("thresholds").forGetter((stateProvider) -> stateProvider.thresholds),
                        BlockStateProvider.CODEC.fieldOf("within_noise_state_provider").forGetter((stateProvider) -> stateProvider.withinNoiseStateProvider),
                        BlockStateProvider.CODEC.fieldOf("outside_noise_state_provider").forGetter((stateProvider) -> stateProvider.outsideNoiseStateProvider),
                        Codec.BOOL.fieldOf("use_3d_noise").forGetter(stateprovider -> stateprovider.use3D)
                )
        ).apply(builder, BetweenNoiseThresholdProvider::new);
    });

    private final List<FloatProvider> thresholds;
    private final BlockStateProvider withinNoiseStateProvider;
    private final BlockStateProvider outsideNoiseStateProvider;
    private final boolean use3D;

    public BetweenNoiseThresholdProvider(long seed, NormalNoise.NoiseParameters noiseParameters, float scale, List<FloatProvider> thresholds, BlockStateProvider withinNoiseStateProvider, BlockStateProvider outsideNoiseStateProvider, boolean use3D) {
        super(seed, noiseParameters, scale);
        this.thresholds = thresholds;
        this.withinNoiseStateProvider = withinNoiseStateProvider;
        this.outsideNoiseStateProvider = outsideNoiseStateProvider;
        this.use3D = use3D;
    }


    @Override
    public BlockState getState(Random random, BlockPos pos) {
        double noiseValue = this.use3D ? getNoiseValue2D(pos, 4) : this.getNoiseValue(pos, this.scale);
//        BYG.LOGGER.info(noiseValue);

        for (FloatProvider threshold : this.thresholds) {
            if (noiseValue >= threshold.getMinValue() && noiseValue <= threshold.getMaxValue()) {
                return this.withinNoiseStateProvider.getState(random, pos);
            }
        }
        return this.outsideNoiseStateProvider.getState(random, pos);
    }

    protected double getNoiseValue2D(BlockPos $$0, double $$1) {
        return this.noise.getValue((double) $$0.getX() * $$1, 0, (double) $$0.getZ() * $$1);
    }

    @Override
    protected BlockStateProviderType<?> type() {
        return BYGStateProviders.BETWEEN_NOISE_THRESHOLD_PROVIDER;
    }

    public static List<FloatProvider> createThresholds(float size, float min, float max) {
        ArrayList<FloatProvider> thresholds = new ArrayList<>();
        for (float start = min; start <= max; start += (size * 2)) {
            thresholds.add(UniformFloat.of(start, start + size));
        }
        return thresholds;
    }
}
