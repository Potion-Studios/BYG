package corgiaoc.byg.core.world;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.collection.DataPool;
import net.minecraft.world.gen.feature.BlockPileFeatureConfig;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

public class SpreadableBlockConfigs {
    private static DataPool.Builder<BlockState> dataPoolBuilder() {
        return DataPool.builder();
    }
    
    public static final BlockPileFeatureConfig EMBUR_ROOTS = new BlockPileFeatureConfig(new WeightedBlockStateProvider(dataPoolBuilder()
            .add(BYGBlocks.EMBUR_ROOTS.getDefaultState(), 50)
            .add(BYGBlocks.EMBUR_SPROUTS.getDefaultState(), 35)
            .add(BYGBlocks.EMBUR_WART.getDefaultState(), 11)));
    public static final BlockPileFeatureConfig MEADOW_CONFIG = new BlockPileFeatureConfig(new WeightedBlockStateProvider(dataPoolBuilder()
            .add(BYGBlocks.CLOVER_PATCH.getDefaultState(), 15)
            .add(Blocks.GRASS.getDefaultState(), 30)
            .add(Blocks.PINK_TULIP.getDefaultState(), 15)
            .add(BYGBlocks.MAGENTA_TULIP.getDefaultState(), 15)
            .add(BYGBlocks.CYAN_TULIP.getDefaultState(), 15)
            .add(BYGBlocks.WHITE_ANEMONE.getDefaultState(), 15)
            .add(BYGBlocks.ROSE.getDefaultState(), 10)));
    public static final BlockPileFeatureConfig SYTHIAN_CONFIG = new BlockPileFeatureConfig(new WeightedBlockStateProvider(dataPoolBuilder()
            .add(BYGBlocks.SYTHIAN_ROOTS.getDefaultState(), 50)
            .add(BYGBlocks.SYTHIAN_SPROUT.getDefaultState(), 50)
            .add(BYGBlocks.SYTHIAN_FUNGUS.getDefaultState(), 11)));
    public static final BlockPileFeatureConfig IVIS_CONFIG = new BlockPileFeatureConfig(new WeightedBlockStateProvider(dataPoolBuilder()
            .add(BYGBlocks.IVIS_ROOTS.getDefaultState(), 50)
            .add(BYGBlocks.IVIS_SPROUT.getDefaultState(), 50)));
    public static final BlockPileFeatureConfig OVERGROWN_BLACKSTONE_CONFIG = new BlockPileFeatureConfig(new WeightedBlockStateProvider(dataPoolBuilder()
            .add(Blocks.CRIMSON_ROOTS.getDefaultState(), 80)
            .add(Blocks.CRIMSON_FUNGUS.getDefaultState(), 15)
            .add(BYGBlocks.CRIMSON_BERRY_BUSH.getDefaultState(), 5)));
    public static final BlockPileFeatureConfig OVERGROWN_NETHERRACK_CONFIG = new BlockPileFeatureConfig(new WeightedBlockStateProvider(dataPoolBuilder()
            .add(Blocks.NETHER_SPROUTS.getDefaultState(), 90)
            .add(BYGBlocks.SOUL_SHROOM.getDefaultState(), 5)
            .add(BYGBlocks.DEATH_CAP.getDefaultState(), 5)));
    public static final BlockPileFeatureConfig MYCELIUM_NETHERRACK_CONFIG = new BlockPileFeatureConfig(new WeightedBlockStateProvider(dataPoolBuilder()
            .add(BYGBlocks.SOUL_SHROOM.getDefaultState(), 50)
            .add(BYGBlocks.DEATH_CAP.getDefaultState(), 50)));
    public static final BlockPileFeatureConfig ETHER_CONFIG = new BlockPileFeatureConfig(new WeightedBlockStateProvider(dataPoolBuilder()
            .add(BYGBlocks.ETHER_GRASS.getDefaultState(), 50)
            .add(BYGBlocks.ETHER_BUSH.getDefaultState(), 45)
            .add(BYGBlocks.THEREAL_BELLFLOWER.getDefaultState(), 5)));
    public static final BlockPileFeatureConfig NIGHTSHADE_CONFIG = new BlockPileFeatureConfig(new WeightedBlockStateProvider(dataPoolBuilder()
            .add(BYGBlocks.NIGHTSHADE_SPROUTS.getDefaultState(), 50)
            .add(BYGBlocks.NIGHTSHADE_SPROUTS.getDefaultState(), 50)));
    public static final BlockPileFeatureConfig VERMILION_SCULK_CONFIG = new BlockPileFeatureConfig(new WeightedBlockStateProvider(dataPoolBuilder()
            .add(BYGBlocks.VERMILION_SCULK_GROWTH.getDefaultState(), 50)
            .add(BYGBlocks.VERMILION_SCULK_GROWTH.getDefaultState(), 45)
            .add(BYGBlocks.VERMILION_SCULK_GROWTH.getDefaultState(), 5)));
    public static final BlockPileFeatureConfig BULBIS_CONFIG = new BlockPileFeatureConfig(new WeightedBlockStateProvider(dataPoolBuilder()
            .add(BYGBlocks.BULBIS_SPROUTS.getDefaultState(), 50)
            .add(BYGBlocks.BULBIS_SPROUTS.getDefaultState(), 45)
            .add(BYGBlocks.BULBIS_SPROUTS.getDefaultState(), 5)));
}
