package corgiaoc.byg.common.world.surfacebuilder.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderConfiguration;

public class PointedSBConfig implements SurfaceBuilderConfiguration {

    public static final Codec<PointedSBConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> {
        return codecRecorder.group(BlockState.CODEC.fieldOf("top_material").forGetter((config) -> {
            return config.topMaterial;
        }), BlockState.CODEC.fieldOf("under_material").forGetter((config) -> {
            return config.underMaterial;
        }), BlockStateProvider.CODEC.fieldOf("spike_provider").orElse(new SimpleStateProvider(Blocks.PODZOL.defaultBlockState())).forGetter((config) -> {
            return config.spikeProvider;
        }), BlockStateProvider.CODEC.fieldOf("spike_top_provider").orElse(new SimpleStateProvider(Blocks.PODZOL.defaultBlockState())).forGetter((config) -> {
            return config.spikeTopBlockProvider;
        }), Codec.INT.fieldOf("spike_height").orElse(150).forGetter((config) -> {
            return config.spikeHeight;
        })).apply(codecRecorder, PointedSBConfig::new);
    });

    private final BlockState topMaterial;
    private final BlockState underMaterial;
    private final BlockStateProvider spikeProvider;
    private final BlockStateProvider spikeTopBlockProvider;
    private final int spikeHeight;

    public PointedSBConfig(BlockState topMaterial, BlockState underMaterial, BlockStateProvider spikeProvider, BlockStateProvider spikeTopBlockProvider, int spikeHeight) {
        this.topMaterial = topMaterial;
        this.underMaterial = underMaterial;
        this.spikeProvider = spikeProvider;
        this.spikeTopBlockProvider = spikeTopBlockProvider;
        this.spikeHeight = spikeHeight;
    }

    public BlockState getTopMaterial() {
        return topMaterial;
    }

    public BlockState getUnderMaterial() {
        return this.underMaterial;
    }

    public BlockStateProvider getSpikeProvider() {
        return this.spikeProvider;
    }

    public BlockStateProvider getSpikeTopBlockProvider() {
        return this.spikeTopBlockProvider;
    }

    public int getSpikeHeight() {
        return this.spikeHeight;
    }
}
