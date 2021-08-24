package corgiaoc.byg.common.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;

public class PumpkinConfig implements FeatureConfiguration {

    public static final Codec<PumpkinConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> {
        return codecRecorder.group(BlockStateProvider.CODEC.fieldOf("pumpkin_provider").forGetter((config) -> {
            return config.pumpkinProvider;
        }), BlockStateProvider.CODEC.fieldOf("stem_provider").forGetter((config) -> {
            return config.stemProvider;
        }), BlockStateProvider.CODEC.fieldOf("leaves_provider").forGetter((config) -> {
            return config.leavesProvider;
        })).apply(codecRecorder, PumpkinConfig::new);
    });


    private final BlockStateProvider pumpkinProvider;
    private final BlockStateProvider stemProvider;
    private final BlockStateProvider leavesProvider;

    PumpkinConfig(BlockStateProvider pumpkinProvider, BlockStateProvider stemProvider, BlockStateProvider leavesProvider) {
        this.pumpkinProvider = pumpkinProvider;
        this.stemProvider = stemProvider;
        this.leavesProvider = leavesProvider;
    }

    public BlockStateProvider getPumpkinProvider() {
        return this.pumpkinProvider;
    }

    public BlockStateProvider getStemProvider() {
        return this.stemProvider;
    }

    public BlockStateProvider getLeavesProvider() {
        return leavesProvider;
    }

    public static class Builder {
        private BlockStateProvider pumpkinProvider = new SimpleStateProvider(Blocks.PUMPKIN.defaultBlockState());
        private BlockStateProvider stemProvider = new SimpleStateProvider(Blocks.OAK_LOG.defaultBlockState());
        private BlockStateProvider leavesProvider = new SimpleStateProvider(Blocks.OAK_LEAVES.defaultBlockState());

        public Builder setPumpkinBlock(Block block) {
            this.pumpkinProvider = new SimpleStateProvider(block.defaultBlockState());
            return this;
        }

        public Builder setPumpkinBlock(BlockState state) {
            this.pumpkinProvider = new SimpleStateProvider(state);
            return this;
        }

        public Builder setStemBlock(Block block) {
            this.stemProvider = new SimpleStateProvider(block.defaultBlockState());
            return this;
        }

        public Builder setStemBlock(BlockState state) {
            this.stemProvider = new SimpleStateProvider(state);
            return this;
        }

        public Builder setLeavesBlock(Block block) {
            this.leavesProvider = new SimpleStateProvider(block.defaultBlockState());
            return this;
        }

        public Builder setLeavesBlock(BlockState state) {
            this.leavesProvider = new SimpleStateProvider(state);
            return this;
        }

        public PumpkinConfig build() {
            return new PumpkinConfig(this.pumpkinProvider, this.stemProvider, this.leavesProvider);
        }
    }
}
