package corgiaoc.byg.common.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class BYGTreeFeatureConfig implements IFeatureConfig {

    public static final Codec<BYGTreeFeatureConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> {
        return codecRecorder.group(BlockStateProvider.CODEC.fieldOf("trunk_provider").orElse(new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState())).forGetter((config) -> {
            return config.trunkProvider;
        }), BlockStateProvider.CODEC.fieldOf("leaves_provider").orElse(new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState())).forGetter((config) -> {
            return config.leavesProvider;
        }), BlockStateProvider.CODEC.fieldOf("disk_provider").orElse(new SimpleBlockStateProvider(Blocks.PODZOL.getDefaultState())).forGetter((config) -> {
            return config.diskProvider;
        }), Codec.INT.fieldOf("min_height").orElse(15).forGetter((config) -> {
            return config.minHeight;
        }), Codec.INT.fieldOf("max_height").orElse(15).forGetter((config) -> {
            return config.maxHeight;
        }), Codec.INT.fieldOf("disk_radius").orElse(0).forGetter((config) -> {
            return config.diskRadius;
        })).apply(codecRecorder, BYGTreeFeatureConfig::new);
    });


    private final BlockStateProvider trunkProvider;
    private final BlockStateProvider leavesProvider;
    private final BlockStateProvider diskProvider;
    private final int minHeight;
    private final int maxHeight;
    private final int diskRadius;

    private boolean forcedPlacement = false;


    BYGTreeFeatureConfig(BlockStateProvider trunkProvider, BlockStateProvider leavesProvider, BlockStateProvider diskProvider, int minHeight, int maxHeight, int diskRadius) {
        this.trunkProvider = trunkProvider;
        this.leavesProvider = leavesProvider;
        this.diskProvider = diskProvider;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.diskRadius = diskRadius;
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
        private BlockStateProvider diskProvider = new SimpleBlockStateProvider(Blocks.PODZOL.getDefaultState());
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

        public Builder setLeavesBlock(BlockStateProvider statesList) {
            if (statesList != null)
                leavesProvider = statesList;
            else
                leavesProvider = new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState());

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

        public Builder copy(BYGTreeFeatureConfig config) {
            this.maxPossibleHeight = config.maxHeight;
            this.minHeight = config.minHeight;
            this.trunkProvider = config.trunkProvider;
            this.leavesProvider = config.leavesProvider;
            this.diskRadius = config.diskRadius;
            return this;
        }

        public BYGTreeFeatureConfig build() {
            return new BYGTreeFeatureConfig(this.trunkProvider, this.leavesProvider, this.diskProvider, this.minHeight, this.maxPossibleHeight, this.diskRadius);
        }
    }
}
