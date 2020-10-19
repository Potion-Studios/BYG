package corgiaoc.byg.common.world.surfacebuilder.config;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FillSurfaceBuilderConfig implements ISurfaceBuilderConfig {

    public static final Codec<FillSurfaceBuilderConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> {
        return codecRecorder.group(BlockStateProvider.CODEC.fieldOf("top_material").forGetter((config) -> {
            return config.topMaterial;
        }), BlockStateProvider.CODEC.fieldOf("under_material").forGetter((config) -> {
            return config.underMaterial;
        }), BlockStateProvider.CODEC.fieldOf("filler_material").forGetter((config) -> {
            return config.fillMaterial;
        }), Codec.INT.fieldOf("fill_down_to_y").orElse(63).forGetter((config) -> {
            return config.fillDownToY;
        }), Codec.INT.fieldOf("fill_up_to_y").orElse(0).forGetter((config) -> {
            return config.fillDownToY;
        }), BlockState.CODEC.listOf().fieldOf("replace_list").forGetter((config) -> {
            return config.replaceList.stream().map(Block::getDefaultState).collect(Collectors.toList());
        })).apply(codecRecorder, FillSurfaceBuilderConfig::new);
    });
    private final BlockStateProvider topMaterial;
    private final BlockStateProvider underMaterial;
    private final BlockStateProvider fillMaterial;
    private final int fillDownToY;
    private final int fillUpToY;
    private final Set<Block> replaceList;


    FillSurfaceBuilderConfig(BlockStateProvider topMaterial, BlockStateProvider underMaterial, BlockStateProvider fillMaterial, int fillDownToY, int fillUpToY, List<BlockState> whitelist) {
        this.topMaterial = topMaterial;
        this.underMaterial = underMaterial;
        this.fillMaterial = fillMaterial;
        this.fillDownToY = fillDownToY;
        this.fillUpToY = fillUpToY;
        this.replaceList = whitelist.stream().map(AbstractBlock.AbstractBlockState::getBlock).collect(Collectors.toSet());
    }

    public BlockState getTop() {
        return null;
    }

    public BlockState getUnder() {
        return null;
    }

    public BlockStateProvider getFillMaterial() {
        return this.fillMaterial;
    }

    public BlockStateProvider getTopMaterial() {
        return topMaterial;
    }

    public BlockStateProvider getUnderMaterial() {
        return underMaterial;
    }

    public Set<Block> getReplaceList() {
        return replaceList;
    }

    public int getFillDownToY() {
        return this.fillDownToY;
    }

    public int getFillUpToY() {
        return fillUpToY;
    }

    public static class Builder {
        private BlockStateProvider topMaterial = new SimpleBlockStateProvider(Blocks.GRASS_BLOCK.getDefaultState());
        private BlockStateProvider underMaterial = new SimpleBlockStateProvider(Blocks.DIRT.getDefaultState());
        private BlockStateProvider fillMaterial = new SimpleBlockStateProvider(Blocks.DIRT.getDefaultState());
        private int fillUpToY = 63;
        private int fillDownToY = 0;
        private List<Block> replaceList = ImmutableList.of(Blocks.STONE);


        public FillSurfaceBuilderConfig.Builder setTopBlock(Block block) {
            if (block != null)
                topMaterial = new SimpleBlockStateProvider(block.getDefaultState());
            else
                topMaterial = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
            return this;
        }

        public FillSurfaceBuilderConfig.Builder setTopBlock(BlockState state) {
            if (state != null)
                topMaterial = new SimpleBlockStateProvider(state);
            else
                topMaterial = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
            return this;
        }

        public FillSurfaceBuilderConfig.Builder setTopBlock(BlockStateProvider provider) {
            if (provider != null)
                topMaterial = provider;
            else
                topMaterial = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
            return this;
        }

        public FillSurfaceBuilderConfig.Builder setUnderBlock(Block block) {
            if (block != null)
                underMaterial = new SimpleBlockStateProvider(block.getDefaultState());
            else
                underMaterial = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
            return this;
        }

        public FillSurfaceBuilderConfig.Builder setUnderBlock(BlockState state) {
            if (state != null)
                underMaterial = new SimpleBlockStateProvider(state);
            else
                underMaterial = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
            return this;
        }

        public FillSurfaceBuilderConfig.Builder setUnderBlock(BlockStateProvider provider) {
            if (provider != null)
                underMaterial = provider;
            else
                underMaterial = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
            return this;
        }

        public FillSurfaceBuilderConfig.Builder setFillBlock(Block block) {
            if (block != null)
                fillMaterial = new SimpleBlockStateProvider(block.getDefaultState());
            else
                fillMaterial = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
            return this;
        }

        public FillSurfaceBuilderConfig.Builder setFillBlock(BlockState state) {
            if (state != null)
                fillMaterial = new SimpleBlockStateProvider(state);
            else
                fillMaterial = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
            return this;
        }

        public FillSurfaceBuilderConfig.Builder setFillBlock(BlockStateProvider provider) {
            if (provider != null)
                fillMaterial = provider;
            else
                fillMaterial = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
            return this;
        }

        public FillSurfaceBuilderConfig.Builder setFillDownToY(int fillDownToY) {
            this.fillDownToY = fillDownToY;
            return this;
        }

        public FillSurfaceBuilderConfig.Builder setFillUpToY(int fillUpToY) {
            this.fillUpToY = fillUpToY;
            return this;
        }

        public FillSurfaceBuilderConfig.Builder setReplaceList(ImmutableList<Block> replaceList) {
            this.replaceList = replaceList;
            return this;
        }

        public FillSurfaceBuilderConfig build() {
            return new FillSurfaceBuilderConfig(topMaterial, underMaterial, fillMaterial, fillDownToY, fillUpToY, this.replaceList.stream().map(Block::getDefaultState).collect(Collectors.toList()));
        }
    }
}
