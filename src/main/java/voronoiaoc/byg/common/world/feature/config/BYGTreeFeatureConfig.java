package voronoiaoc.byg.common.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class BYGTreeFeatureConfig implements IFeatureConfig {

    public static final Codec<BYGTreeFeatureConfig> CODEC = RecordCodecBuilder.create((p_236683_0_) -> {
        return p_236683_0_.group(BlockStateProvider.field_236796_a_.fieldOf("trunk_provider").forGetter((p_236693_0_) -> {
            return p_236693_0_.trunkProvider;
        }), BlockStateProvider.field_236796_a_.fieldOf("leaves_provider").forGetter((p_236692_0_) -> {
            return p_236692_0_.leavesProvider;
        }), Codec.INT.fieldOf("min_height").orElse(15).forGetter((p_236687_0_) -> {
            return p_236687_0_.minHeight;
        }), Codec.INT.fieldOf("max_possible_height").orElse(1).forGetter((p_236686_0_) -> {
            return p_236686_0_.maxPossibleHeight;
        })).apply(p_236683_0_, BYGTreeFeatureConfig::new);
    });


    private final BlockStateProvider trunkProvider;
    private final BlockStateProvider leavesProvider;
    private final int minHeight;
    private final int maxPossibleHeight;

    private boolean forcedPlacement = false;


    BYGTreeFeatureConfig(BlockStateProvider trunkProvider, BlockStateProvider leavesProvider, int minHeight, int maxPossibleHeight) {
        this.trunkProvider = trunkProvider;
        this.leavesProvider = leavesProvider;
        this.minHeight = minHeight;
        this.maxPossibleHeight = maxPossibleHeight;
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

    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxPossibleHeight() {
        int returnValue = this.maxPossibleHeight - minHeight;
        if (returnValue == 0)
            returnValue = 1;

        return returnValue;
    }

    public boolean isPlacementForced() {
        return forcedPlacement;
    }


    public static class Builder {
        private BlockStateProvider trunkProvider = new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState());
        private BlockStateProvider leavesProvider = new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState());
        private int minHeight = 15;
        private int maxPossibleHeight = 1;

        public Builder setTrunkBlock(Block block) {
            if (block != null)
                trunkProvider = new SimpleBlockStateProvider(block.getDefaultState());
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

        public BYGTreeFeatureConfig build() {
            return new BYGTreeFeatureConfig(this.trunkProvider, this.leavesProvider, this.minHeight, this.maxPossibleHeight);
        }
    }
}
