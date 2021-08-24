package corgiaoc.byg.common.world.feature.config;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BYGTreeConfig implements FeatureConfiguration {

    public static final Codec<BYGTreeConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> {
        return codecRecorder.group(BlockStateProvider.CODEC.fieldOf("trunk_provider").orElse(new SimpleStateProvider(Blocks.OAK_LOG.defaultBlockState())).forGetter((config) -> {
            return config.trunkProvider;
        }), BlockStateProvider.CODEC.fieldOf("leaves_provider").orElse(new SimpleStateProvider(Blocks.OAK_LEAVES.defaultBlockState())).forGetter((config) -> {
            return config.leavesProvider;
        }), BlockStateProvider.CODEC.fieldOf("ground_replacement_provider").orElse(new SimpleStateProvider(Blocks.DIRT.defaultBlockState())).forGetter((config) -> {
            return config.groundReplacementProvider;//TODO: Remove Ground Replacement Provider
        }), BlockStateProvider.CODEC.fieldOf("disk_provider").orElse(new SimpleStateProvider(Blocks.PODZOL.defaultBlockState())).forGetter((config) -> {
            return config.diskProvider;
        }), Codec.INT.fieldOf("min_height").orElse(15).forGetter((config) -> {
            return config.minHeight;
        }), Codec.INT.fieldOf("max_height").orElse(15).forGetter((config) -> {
            return config.maxHeight;
        }), Codec.INT.fieldOf("disk_radius").orElse(0).forGetter((config) -> {
            return config.diskRadius;
        }), BlockState.CODEC.listOf().fieldOf("whitelist").forGetter((config) -> {
            return config.whitelist.stream().map(Block::defaultBlockState).collect(Collectors.toList());
        })).apply(codecRecorder, BYGTreeConfig::new);
    });


    private final BlockStateProvider trunkProvider;
    private final BlockStateProvider leavesProvider;
    @Deprecated
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
        this.whitelist = whitelist.stream().map(BlockBehaviour.BlockStateBase::getBlock).collect(Collectors.toSet());
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

    @Deprecated
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

    private Rotation rotation = Rotation.NONE;
    private Mirror mirror = Mirror.NONE;

    public void setRotationAndMirror(Rotation rotation, Mirror mirror) {
        this.rotation = rotation;
        this.mirror = mirror;
    }

    public Rotation getRotation() {
        return rotation;
    }

    public Mirror getMirror() {
        return mirror;
    }


    public static class Builder {
        private BlockStateProvider trunkProvider = new SimpleStateProvider(Blocks.OAK_LOG.defaultBlockState());
        private BlockStateProvider leavesProvider = new SimpleStateProvider(Blocks.OAK_LEAVES.defaultBlockState());
        @Deprecated
        private BlockStateProvider groundReplacementProvider = new SimpleStateProvider(Blocks.DIRT.defaultBlockState());
        private BlockStateProvider diskProvider = new SimpleStateProvider(Blocks.PODZOL.defaultBlockState());
        private List<Block> whitelist = ImmutableList.of(Blocks.GRASS_BLOCK);
        private int minHeight = 15;
        private int maxPossibleHeight = 1;
        private int diskRadius = 0;

        public Builder setTrunkBlock(Block block) {
            if (block != null)
                trunkProvider = new SimpleStateProvider(block.defaultBlockState());
            else
                trunkProvider = new SimpleStateProvider(Blocks.OAK_LOG.defaultBlockState());

            return this;
        }

        public Builder setTrunkBlock(BlockState state) {
            if (state != null)
                trunkProvider = new SimpleStateProvider(state);
            else
                trunkProvider = new SimpleStateProvider(Blocks.OAK_LOG.defaultBlockState());

            return this;
        }

        public Builder setTrunkBlock(BlockStateProvider stateProvider) {
            if (stateProvider != null)
                trunkProvider = stateProvider;
            else
                trunkProvider = new SimpleStateProvider(Blocks.OAK_LOG.defaultBlockState());

            return this;
        }

        public Builder setLeavesBlock(Block block) {
            if (block != null)
                leavesProvider = new SimpleStateProvider(block.defaultBlockState());
            else
                leavesProvider = new SimpleStateProvider(Blocks.OAK_LEAVES.defaultBlockState());

            return this;
        }

        public Builder setLeavesBlock(BlockState state) {
            if (state != null)
                leavesProvider = new SimpleStateProvider(state);
            else
                leavesProvider = new SimpleStateProvider(Blocks.OAK_LEAVES.defaultBlockState());

            return this;
        }

        public Builder setLeavesBlock(BlockStateProvider stateProvider) {
            if (stateProvider != null)
                leavesProvider = stateProvider;
            else
                leavesProvider = new SimpleStateProvider(Blocks.OAK_LEAVES.defaultBlockState());

            return this;
        }

        @Deprecated
        public Builder setGroundReplacementBlock(Block block) {
            if (block != null)
                groundReplacementProvider = new SimpleStateProvider(block.defaultBlockState());
            else
                groundReplacementProvider = new SimpleStateProvider(Blocks.DIRT.defaultBlockState());

            return this;
        }

        @Deprecated
        public Builder setGroundReplacementBlock(BlockState state) {
            if (state != null)
                groundReplacementProvider = new SimpleStateProvider(state);
            else
                groundReplacementProvider = new SimpleStateProvider(Blocks.AIR.defaultBlockState());

            return this;
        }

        @Deprecated
        public Builder setGroundReplacementBlock(BlockStateProvider stateProvider) {
            if (stateProvider != null)
                groundReplacementProvider = stateProvider;
            else
                groundReplacementProvider = new SimpleStateProvider(Blocks.OAK_LEAVES.defaultBlockState());

            return this;
        }


        public Builder setDiskBlock(Block block) {
            if (block != null)
                diskProvider = new SimpleStateProvider(block.defaultBlockState());
            else
                diskProvider = new SimpleStateProvider(Blocks.AIR.defaultBlockState());

            return this;
        }

        public Builder setDiskBlock(BlockState state) {
            if (state != null)
                diskProvider = new SimpleStateProvider(state);
            else
                diskProvider = new SimpleStateProvider(Blocks.AIR.defaultBlockState());

            return this;
        }

        public Builder setDiskBlock(BlockStateProvider stateProvider) {
            if (stateProvider != null)
                diskProvider = stateProvider;
            else
                diskProvider = new SimpleStateProvider(Blocks.OAK_LEAVES.defaultBlockState());

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
            return new BYGTreeConfig(this.trunkProvider, this.leavesProvider, this.groundReplacementProvider, this.diskProvider, this.minHeight, this.maxPossibleHeight, this.diskRadius, this.whitelist.stream().map(Block::defaultBlockState).collect(Collectors.toList()));
        }
    }
}
