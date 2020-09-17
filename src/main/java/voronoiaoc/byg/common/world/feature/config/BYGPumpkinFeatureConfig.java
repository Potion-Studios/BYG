package voronoiaoc.byg.common.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class BYGPumpkinFeatureConfig implements IFeatureConfig {

    public static final Codec<BYGPumpkinFeatureConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> {
        return codecRecorder.group(BlockStateProvider.CODEC.fieldOf("pumpkin_provider").forGetter((config) -> {
            return config.pumpkinProvider;
        }), BlockStateProvider.CODEC.fieldOf("stem_provider").forGetter((config) -> {
            return config.stemProvider;
        })).apply(codecRecorder, BYGPumpkinFeatureConfig::new);
    });


    private final BlockStateProvider pumpkinProvider;
    private final BlockStateProvider stemProvider;

    BYGPumpkinFeatureConfig(BlockStateProvider pumpkinProvider, BlockStateProvider stemProvider) {
        this.pumpkinProvider = pumpkinProvider;
        this.stemProvider = stemProvider;
    }

    public BlockStateProvider getPumpkinProvider() {
        return this.pumpkinProvider;
    }

    public BlockStateProvider getStemProvider() {
        return this.stemProvider;
    }



    public static class Builder {
        private BlockStateProvider pumpkinProvider = new SimpleBlockStateProvider(Blocks.PUMPKIN.getDefaultState());
        private BlockStateProvider stemProvider = new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState());

        public Builder setPumpkinBlock(Block block) {
            this.pumpkinProvider = new SimpleBlockStateProvider(block.getDefaultState());
            return this;
        }

        public Builder setPumpkinBlock(BlockState state) {
            this.pumpkinProvider = new SimpleBlockStateProvider(state);
            return this;
        }

        public Builder setStemBlock(Block block) {
            this.stemProvider = new SimpleBlockStateProvider(block.getDefaultState());
            return this;
        }

        public Builder setStemBlock(BlockState state) {
            this.stemProvider = new SimpleBlockStateProvider(state);
            return this;
        }

        public BYGPumpkinFeatureConfig build() {
            return new BYGPumpkinFeatureConfig(this.pumpkinProvider, this.stemProvider);
        }
    }
}
