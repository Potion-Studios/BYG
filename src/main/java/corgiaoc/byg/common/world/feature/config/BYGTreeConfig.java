package corgiaoc.byg.common.world.feature.config;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BYGTreeConfig implements FeatureConfig {

    public static final Codec<BYGTreeConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> {
        return codecRecorder.group(BlockStateProvider.TYPE_CODEC.fieldOf("trunk_provider").orElse(new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState())).forGetter((config) -> {
            return config.trunkProvider;
        }), BlockStateProvider.TYPE_CODEC.fieldOf("leaves_provider").orElse(new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState())).forGetter((config) -> {
            return config.leavesProvider;
        }), BlockStateProvider.TYPE_CODEC.fieldOf("ground_replacement_provider").orElse(new SimpleBlockStateProvider(Blocks.DIRT.getDefaultState())).forGetter((config) -> {
            return config.groundReplacementProvider;
        }), BlockStateProvider.TYPE_CODEC.fieldOf("disk_provider").orElse(new SimpleBlockStateProvider(Blocks.PODZOL.getDefaultState())).forGetter((config) -> {
            return config.diskProvider;
        }), Codec.INT.fieldOf("min_height").orElse(15).forGetter((config) -> {
            return config.minHeight;
        }), Codec.INT.fieldOf("max_height").orElse(15).forGetter((config) -> {
            return config.maxHeight;
        }), Codec.INT.fieldOf("disk_radius").orElse(0).forGetter((config) -> {
            return config.diskRadius;
        }), BlockState.CODEC.listOf().fieldOf("whitelist").forGetter((config) -> {
            return config.whitelist.stream().map(Block::getDefaultState).collect(Collectors.toList());
        })).apply(codecRecorder, BYGTreeConfig::new);
    });


    private final BlockStateProvider trunkProvider;
    private final BlockStateProvider leavesProvider;
    private final BlockStateProvider groundReplacementProvider;
    private final BlockStateProvider diskProvider;
    private final int minHeight;
    private final int maxHeight;
    private final int diskRadius;
    private final Set<Block> whitelist;
    private boolean forcedPlacement = false;

    BYGTreeConfig(BlockStateProvider trunkProvider, BlockStateProvider leavesProvider, BlockStateProvider groundReplacementProvider, BlockStateProvider diskProvider, int minHeight, int maxHeight, int diskRadius, List<BlockState> whitelist) {
        this.trunkProvider = trunkProvider;
        this.leavesProvider = leavesProvider;
        this.groundReplacementProvider = groundReplacementProvider;
        this.diskProvider = diskProvider;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.diskRadius = diskRadius;
        this.whitelist = whitelist.stream().map(AbstractBlock.AbstractBlockState::getBlock).collect(Collectors.toSet());
    }

    /**
     * Used to generate trees from saplings
     */
    public void forcePlacement() {
        forcedPlacement = true;
    }


    public BlockStateProvider getTrunkProvider() {
        return this.trunkProvider;
    }

    public BlockStateProvider getLeavesProvider() {
        return this.leavesProvider;
    }

    public BlockStateProvider getGroundReplacementProvider() {
        return groundReplacementProvider;
    }

    public BlockStateProvider getDiskProvider() {
        return this.diskProvider;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public int getDiskRadius() {
        return diskRadius;
    }

    public Set<Block> getWhitelist() {
        return whitelist;
    }

    public int getMaxPossibleHeight() {
        int returnValue = this.maxHeight - minHeight;
        if (returnValue <= 0)
            returnValue = 1;

        return returnValue;
    }

    public boolean isPlacementForced() {
        return forcedPlacement;
    }

    public static class Builder {
        private BlockStateProvider trunkProvider = new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState());
        private BlockStateProvider leavesProvider = new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState());
        private BlockStateProvider groundReplacementProvider = new SimpleBlockStateProvider(Blocks.DIRT.getDefaultState());
        private BlockStateProvider diskProvider = new SimpleBlockStateProvider(Blocks.PODZOL.getDefaultState());
        private List<Block> whitelist = ImmutableList.of(Blocks.GRASS_BLOCK);
        private int minHeight = 15;
        private int maxPossibleHeight = 1;
        private int diskRadius = 0;

        public Builder setTrunkBlock(Block block) {
            if (block != null)
                trunkProvider = new SimpleBlockStateProvider(block.getDefaultState());
            else
                trunkProvider = new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState());

            return this;
        }

        public Builder setTrunkBlock(BlockState state) {
            if (state != null)
                trunkProvider = new SimpleBlockStateProvider(state);
            else
                trunkProvider = new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState());

            return this;
        }

        public Builder setLeavesBlock(Block block) {
            if (block != null)
                leavesProvider = new SimpleBlockStateProvider(block.getDefaultState());
            else
                leavesProvider = new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState());

            return this;
        }

        public Builder setLeavesBlock(BlockState state) {
            if (state != null)
                leavesProvider = new SimpleBlockStateProvider(state);
            else
                leavesProvider = new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState());

            return this;
        }

        public Builder setLeavesBlock(BlockStateProvider stateProvider) {
            if (stateProvider != null)
                leavesProvider = stateProvider;
            else
                leavesProvider = new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState());

            return this;
        }



        public Builder setGroundReplacementBlock(Block block) {
            if (block != null)
                groundReplacementProvider = new SimpleBlockStateProvider(block.getDefaultState());
            else
                groundReplacementProvider = new SimpleBlockStateProvider(Blocks.DIRT.getDefaultState());

            return this;
        }

        public Builder setGroundReplacementBlock(BlockState state) {
            if (state != null)
                groundReplacementProvider = new SimpleBlockStateProvider(state);
            else
                groundReplacementProvider = new SimpleBlockStateProvider(Blocks.AIR.getDefaultState());

            return this;
        }

        public Builder setGroundReplacementBlock(BlockStateProvider stateProvider) {
            if (stateProvider != null)
                groundReplacementProvider = stateProvider;
            else
                groundReplacementProvider = new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState());

            return this;
        }


        public Builder setDiskBlock(Block block) {
            if (block != null)
                diskProvider = new SimpleBlockStateProvider(block.getDefaultState());
            else
                diskProvider = new SimpleBlockStateProvider(Blocks.AIR.getDefaultState());

            return this;
        }

        public Builder setDiskBlock(BlockState state) {
            if (state != null)
                diskProvider = new SimpleBlockStateProvider(state);
            else
                diskProvider = new SimpleBlockStateProvider(Blocks.AIR.getDefaultState());

            return this;
        }

        public Builder setDiskBlock(BlockStateProvider stateProvider) {
            if (stateProvider != null)
                diskProvider = stateProvider;
            else
                diskProvider = new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState());

            return this;
        }

        public Builder setMinHeight(int minHeight) {
            this.minHeight = minHeight;
            return this;
        }

        public Builder setMaxHeight(int maxPossibleHeight) {
            if (maxPossibleHeight != 0)
                this.maxPossibleHeight = maxPossibleHeight + 1;
            else
                this.maxPossibleHeight = 1;
            return this;
        }

        public Builder setDiskRadius(int diskRadius) {
            this.diskRadius = Math.abs(diskRadius);
            return this;
        }

        public Builder setWhitelist(ImmutableList<Block> whitelist) {
            this.whitelist = whitelist;
            return this;
        }

        public Builder copy(BYGTreeConfig config) {
            this.trunkProvider = config.trunkProvider;
            this.leavesProvider = config.leavesProvider;
            this.groundReplacementProvider = config.groundReplacementProvider;
            this.diskProvider = config.diskProvider;
            this.maxPossibleHeight = config.maxHeight;
            this.minHeight = config.minHeight;
            this.diskRadius = config.diskRadius;
            this.whitelist = ImmutableList.copyOf(config.whitelist);
            return this;
        }

        public BYGTreeConfig build() {
            return new BYGTreeConfig(this.trunkProvider, this.leavesProvider, this.groundReplacementProvider, this.diskProvider, this.minHeight, this.maxPossibleHeight, this.diskRadius, this.whitelist.stream().map(Block::getDefaultState).collect(Collectors.toList()));
        }
    }
}
