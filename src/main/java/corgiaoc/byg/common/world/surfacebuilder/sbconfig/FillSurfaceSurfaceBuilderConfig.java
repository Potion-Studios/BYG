package corgiaoc.byg.common.world.surfacebuilder.sbconfig;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;

public class FillSurfaceSurfaceBuilderConfig implements ISurfaceBuilderConfig {

    public static final Codec<FillSurfaceSurfaceBuilderConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> {
        return codecRecorder.group(BlockState.CODEC.fieldOf("top_material").forGetter((config) -> {
            return config.topMaterial;
        }), BlockState.CODEC.fieldOf("under_material").forGetter((config) -> {
            return config.underMaterial;
        }), BlockState.CODEC.fieldOf("world_filler_block").forGetter((config) -> {
            return config.fillerBlock;
        }), Codec.INT.fieldOf("fill_to_y").orElse(63).forGetter((config) -> {
            return config.fillToY;
        })).apply(codecRecorder, FillSurfaceSurfaceBuilderConfig::new);
    });
    private final BlockState topMaterial;
    private final BlockState underMaterial;
    private final BlockState fillerBlock;
    private final int fillToY;

    public FillSurfaceSurfaceBuilderConfig(BlockState topMaterial, BlockState underMaterial, BlockState fillerBlock, int fillToY) {
        this.topMaterial = topMaterial;
        this.underMaterial = underMaterial;
        this.fillerBlock = fillerBlock;
        this.fillToY = fillToY;
    }

    public BlockState getTop() {
        return this.topMaterial;
    }

    public BlockState getUnder() {
        return this.underMaterial;
    }

    public BlockState getFillerBlock() {
        return this.fillerBlock;
    }

    public int getFillToY() {
        return this.fillToY;
    }
}
