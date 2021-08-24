package corgiaoc.byg.common.world.surfacebuilder.config;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderConfiguration;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FillSurfaceBuilderConfig implements SurfaceBuilderConfiguration {

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
            return config.replaceList.stream().map(Block::defaultBlockState).collect(Collectors.toList());
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
        this.replaceList = whitelist.stream().map(BlockBehaviour.BlockStateBase::getBlock).collect(Collectors.toSet());
    }

    public BlockState getTopMaterial() {
        return Blocks.AIR.defaultBlockState();
    }

    public BlockState getUnderMaterial() {
        return Blocks.AIR.defaultBlockState();
    }

    public BlockStateProvider getFillMaterial() {
        return this.fillMaterial;
    }

    public BlockStateProvider getTopMaterialProvider() {
        return topMaterial;
    }

    public BlockStateProvider getUnderMaterialProvider() {
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
        private BlockStateProvider topMaterial = new SimpleStateProvider(Blocks.GRASS_BLOCK.defaultBlockState());
        private BlockStateProvider underMaterial = new SimpleStateProvider(Blocks.DIRT.defaultBlockState());
        private BlockStateProvider fillMaterial = new SimpleStateProvider(Blocks.DIRT.defaultBlockState());
        private int fillUpToY = 63;
        private int fillDownToY = 0;
        private List<Block> replaceList = ImmutableList.of(Blocks.STONE);


        public Builder setTopBlock(Block block) {
            if (block != null)
                topMaterial = new SimpleStateProvider(block.defaultBlockState());
            else
                topMaterial = new SimpleStateProvider(Blocks.STONE.defaultBlockState());
            return this;
        }

        public Builder setTopBlock(BlockState state) {
            if (state != null)
                topMaterial = new SimpleStateProvider(state);
            else
                topMaterial = new SimpleStateProvider(Blocks.STONE.defaultBlockState());
            return this;
        }

        public Builder setTopBlock(BlockStateProvider provider) {
            if (provider != null)
                topMaterial = provider;
            else
                topMaterial = new SimpleStateProvider(Blocks.STONE.defaultBlockState());
            return this;
        }

        public Builder setUnderBlock(Block block) {
            if (block != null)
                underMaterial = new SimpleStateProvider(block.defaultBlockState());
            else
                underMaterial = new SimpleStateProvider(Blocks.STONE.defaultBlockState());
            return this;
        }

        public Builder setUnderBlock(BlockState state) {
            if (state != null)
                underMaterial = new SimpleStateProvider(state);
            else
                underMaterial = new SimpleStateProvider(Blocks.STONE.defaultBlockState());
            return this;
        }

        public Builder setUnderBlock(BlockStateProvider provider) {
            if (provider != null)
                underMaterial = provider;
            else
                underMaterial = new SimpleStateProvider(Blocks.STONE.defaultBlockState());
            return this;
        }

        public Builder setFillBlock(Block block) {
            if (block != null)
                fillMaterial = new SimpleStateProvider(block.defaultBlockState());
            else
                fillMaterial = new SimpleStateProvider(Blocks.STONE.defaultBlockState());
            return this;
        }

        public Builder setFillBlock(BlockState state) {
            if (state != null)
                fillMaterial = new SimpleStateProvider(state);
            else
                fillMaterial = new SimpleStateProvider(Blocks.STONE.defaultBlockState());
            return this;
        }

        public Builder setFillBlock(BlockStateProvider provider) {
            if (provider != null)
                fillMaterial = provider;
            else
                fillMaterial = new SimpleStateProvider(Blocks.STONE.defaultBlockState());
            return this;
        }

        public Builder setFillDownToY(int fillDownToY) {
            this.fillDownToY = fillDownToY;
            return this;
        }

        public Builder setFillUpToY(int fillUpToY) {
            this.fillUpToY = fillUpToY;
            return this;
        }

        public Builder setReplaceList(ImmutableList<Block> replaceList) {
            this.replaceList = replaceList;
            return this;
        }

        public FillSurfaceBuilderConfig build() {
            return new FillSurfaceBuilderConfig(topMaterial, underMaterial, fillMaterial, fillDownToY, fillUpToY, this.replaceList.stream().map(Block::defaultBlockState).collect(Collectors.toList()));
        }
    }
}
