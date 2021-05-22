package corgiaoc.byg.common.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.feature.IFeatureConfig;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WhitelistedSimpleBlockProviderConfig implements IFeatureConfig {

    public static final Codec<WhitelistedSimpleBlockProviderConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> {
        return codecRecorder.group(BlockStateProvider.CODEC.fieldOf("block_provider").forGetter((config) -> {
            return config.blockProvider;
        }), BlockState.CODEC.listOf().fieldOf("whitelist").forGetter((config) -> {
            return config.whitelist.stream().map(Block::defaultBlockState).collect(Collectors.toList());
        })).apply(codecRecorder, WhitelistedSimpleBlockProviderConfig::new);
    });

    private final BlockStateProvider blockProvider;
    private final Set<Block> whitelist;


    public WhitelistedSimpleBlockProviderConfig(BlockStateProvider blockProvider, List<BlockState> whitelist) {
        this.blockProvider = blockProvider;
        this.whitelist = whitelist.stream().map(AbstractBlock.AbstractBlockState::getBlock).collect(Collectors.toSet());

    }

    public BlockStateProvider getBlockProvider() {
        return blockProvider;
    }

    public Set<Block> getWhitelist() {
        return whitelist;
    }
}
