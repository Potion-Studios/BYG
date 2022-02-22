package potionstudios.byg.common.world.feature.features.nether;

import com.google.common.collect.ImmutableList;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.feature.BYGFeatures;
import potionstudios.byg.common.world.feature.config.BYGMushroomConfig;
import potionstudios.byg.common.world.feature.config.BYGTreeConfig;

import static potionstudios.byg.common.world.feature.features.BYGFeaturesUtil.createConfiguredFeature;

public class BYGNetherVegetationFeatures {

    //Nether Mushrooms
    public static final ConfiguredFeature<BYGMushroomConfig, ?> EMBUR_MUSHROOM = createConfiguredFeature("embur_mushroom1",
        BYGFeatures.EMBUR_MUSHROOM.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.EMBUR_PEDU)
                .setMushroomBlock(BYGBlocks.EMBUR_GEL_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> EMBUR_MUSHROOM2 = createConfiguredFeature("embur_mushroom2",
        BYGFeatures.EMBUR_MUSHROOM2.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.EMBUR_PEDU)
                .setMushroomBlock(BYGBlocks.EMBUR_GEL_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> EMBUR_MUSHROOM3 = createConfiguredFeature("embur_mushroom3",
        BYGFeatures.EMBUR_MUSHROOM3.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.EMBUR_PEDU)
                .setMushroomBlock(BYGBlocks.EMBUR_GEL_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> EMBUR_MUSHROOM4 = createConfiguredFeature("embur_mushroom4",
        BYGFeatures.EMBUR_MUSHROOM4.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.EMBUR_PEDU)
                .setMushroomBlock(BYGBlocks.EMBUR_GEL_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> CRIMSON_FUNGUS1 = createConfiguredFeature("crimson_fungus1",
        BYGFeatures.CRIMSON_FUNGUS_TREE1.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(Blocks.CRIMSON_STEM)
                .setMushroomBlock(Blocks.NETHER_WART_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> CRIMSON_FUNGUS2 = createConfiguredFeature("crimson_fungus2",
        BYGFeatures.CRIMSON_FUNGUS_TREE2.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(Blocks.CRIMSON_STEM)
                .setMushroomBlock(Blocks.NETHER_WART_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> WARPED_FUNGUS1 = createConfiguredFeature("warped_fungus1",
        BYGFeatures.WARPED_FUNGUS_TREE1.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(Blocks.WARPED_STEM)
                .setMushroomBlock(Blocks.WARPED_WART_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> WARPED_FUNGUS2 = createConfiguredFeature("warped_fungus2",
        BYGFeatures.WARPED_FUNGUS_TREE2.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(Blocks.WARPED_STEM)
                .setMushroomBlock(Blocks.WARPED_WART_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> SYTHIAN_FUNGUS_TREE1 = createConfiguredFeature("sythian_fungus_tree1",
        BYGFeatures.SYTHIAN_FUNGUS_TREE1.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.SYTHIAN_STEM)
                .setMushroomBlock(BYGBlocks.SYTHIAN_WART_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> SYTHIAN_FUNGUS_TREE2 = createConfiguredFeature("sythian_fungus_tree2",
        BYGFeatures.SYTHIAN_FUNGUS_TREE2.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.SYTHIAN_STEM)
                .setMushroomBlock(BYGBlocks.SYTHIAN_WART_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> SYTHIAN_FUNGUS_TREE3 = createConfiguredFeature("sythian_fungus_tree3",
        BYGFeatures.SYTHIAN_FUNGUS_TREE3.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.SYTHIAN_STEM)
                .setMushroomBlock(BYGBlocks.SYTHIAN_WART_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> SYTHIAN_FUNGUS_TREE4 = createConfiguredFeature("sythian_fungus_tree4",
        BYGFeatures.SYTHIAN_FUNGUS_TREE4.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.SYTHIAN_STEM)
                .setMushroomBlock(BYGBlocks.SYTHIAN_WART_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> SOUL_SHROOM_TREE1 = createConfiguredFeature("soul_shroom_tree1",
        BYGFeatures.SOUL_SHROOM_TREE1.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.SOUL_SHROOM_STEM)
                .setMushroomBlock(BYGBlocks.SOUL_SHROOM_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> SOUL_SHROOM_TREE2 = createConfiguredFeature("soul_shroom_tree2",
        BYGFeatures.SOUL_SHROOM_TREE2.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.SOUL_SHROOM_STEM)
                .setMushroomBlock(BYGBlocks.SOUL_SHROOM_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> SOUL_SHROOM_TREE3 = createConfiguredFeature("soul_shroom_tree3",
        BYGFeatures.SOUL_SHROOM_TREE3.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.SOUL_SHROOM_STEM)
                .setMushroomBlock(BYGBlocks.SOUL_SHROOM_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> DEATH_CAP_TREE1 = createConfiguredFeature("death_cap_tree1",
        BYGFeatures.DEATH_CAP_TREE1.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(Blocks.MUSHROOM_STEM)
                .setMushroomBlock(BYGBlocks.DEATH_CAP_MUSHROOM_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> DEATH_CAP_TREE2 = createConfiguredFeature("death_cap_tree2",
        BYGFeatures.DEATH_CAP_TREE2.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(Blocks.MUSHROOM_STEM)
                .setMushroomBlock(BYGBlocks.DEATH_CAP_MUSHROOM_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> DEATH_CAP_TREE3 = createConfiguredFeature("death_cap_tree3",
        BYGFeatures.DEATH_CAP_TREE3.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(Blocks.MUSHROOM_STEM)
                .setMushroomBlock(BYGBlocks.DEATH_CAP_MUSHROOM_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    //Nether Trees
    public static final ConfiguredFeature<BYGTreeConfig, ?> LAMENT_TWISTY_TREE1 = createConfiguredFeature("lament_twisty_tree1",
        BYGFeatures.LAMENT_TWISTY_TREE1.configured(
            new BYGTreeConfig.Builder()
                .setTrunkBlock(BYGBlocks.LAMENT_LOG)
                .setLeavesBlock(BYGBlocks.LAMENT_LEAVES)
                .setMaxHeight(30)
                .setMinHeight(22)
                .build()
        ));
    public static final ConfiguredFeature<BYGTreeConfig, ?> LAMENT_TWISTY_TREE2 = createConfiguredFeature("lament_twisty_tree2",
        BYGFeatures.LAMENT_TWISTY_TREE2.configured(
            new BYGTreeConfig.Builder()
                .setTrunkBlock(BYGBlocks.LAMENT_LOG)
                .setLeavesBlock(BYGBlocks.LAMENT_LEAVES)
                .setMaxHeight(30)
                .setMinHeight(22)
                .build()
        ));
    public static final ConfiguredFeature<BYGTreeConfig, ?> LAMENT_TWISTY_TREE3 = createConfiguredFeature("lament_twisty_tree3",
        BYGFeatures.LAMENT_TWISTY_TREE3.configured(
            new BYGTreeConfig.Builder()
                .setTrunkBlock(BYGBlocks.LAMENT_LOG)
                .setLeavesBlock(BYGBlocks.LAMENT_LEAVES)
                .setMaxHeight(30)
                .setMinHeight(22)
                .build()
        ));
    public static final ConfiguredFeature<BYGTreeConfig, ?> LAMENT_WEEPING_TREE1 = createConfiguredFeature("lament_weeping_tree1",
        BYGFeatures.LAMENT_WEEPING_TREE1.configured(
            new BYGTreeConfig.Builder()
                .setTrunkBlock(BYGBlocks.LAMENT_LOG)
                .setLeavesBlock(BYGBlocks.LAMENT_LEAVES)
                .setMaxHeight(30)
                .setMinHeight(22)
                .setWhitelist(ImmutableList.of(Blocks.LAVA))
                .build()
        ));
    public static final ConfiguredFeature<BYGTreeConfig, ?> LAMENT_WEEPING_TREE2 = createConfiguredFeature("lament_weeping_tree2",
        BYGFeatures.LAMENT_WEEPING_TREE2.configured(
            new BYGTreeConfig.Builder()
                .setTrunkBlock(BYGBlocks.LAMENT_LOG)
                .setLeavesBlock(BYGBlocks.LAMENT_LEAVES)
                .setMaxHeight(30)
                .setMinHeight(22)
                .setWhitelist(ImmutableList.of(Blocks.LAVA))
                .build()
        ));
    public static final ConfiguredFeature<BYGTreeConfig, ?> LAMENT_WEEPING_TREE3 = createConfiguredFeature("lament_weeping_tree3",
        BYGFeatures.LAMENT_WEEPING_TREE3.configured(
            new BYGTreeConfig.Builder()
                .setTrunkBlock(BYGBlocks.LAMENT_LOG)
                .setLeavesBlock(BYGBlocks.LAMENT_LEAVES)
                .setMaxHeight(30)
                .setMinHeight(22)
                .setWhitelist(ImmutableList.of(Blocks.LAVA))
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> WITHERING_OAK_TREE1 = createConfiguredFeature("withering_oak_tree1",
        BYGFeatures.WITHERING_OAK_TREE1.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.WITHERING_OAK_LOG)
                .setMushroomBlock(BYGBlocks.WITHERING_OAK_LEAVES)
                .setMaxHeight(30)
                .setMinHeight(22)
                .build()
        ));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> WITHERING_OAK_TREE2 = createConfiguredFeature("withering_oak_tree2",
        BYGFeatures.WITHERING_OAK_TREE2.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.WITHERING_OAK_LOG)
                .setMushroomBlock(BYGBlocks.WITHERING_OAK_LEAVES)
                .setMaxHeight(30)
                .setMinHeight(22)
                .build()
        ));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> WITHERING_OAK_TREE3 = createConfiguredFeature("withering_oak_tree3",
        BYGFeatures.WITHERING_OAK_TREE3.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.WITHERING_OAK_LOG)
                .setMushroomBlock(BYGBlocks.WITHERING_OAK_LEAVES)
                .setMaxHeight(30)
                .setMinHeight(22)
                .build()
        ));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> WITHERING_OAK_TREE4 = createConfiguredFeature("withering_oak_tree4",
        BYGFeatures.WITHERING_OAK_TREE4.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.WITHERING_OAK_LOG)
                .setMushroomBlock(BYGBlocks.WITHERING_OAK_LEAVES)
                .setMaxHeight(30)
                .setMinHeight(22)
                .build()
        ));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> WITHERING_OAK_TREE5 = createConfiguredFeature("withering_oak_tree5",
        BYGFeatures.WITHERING_OAK_TREE5.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.WITHERING_OAK_LOG)
                .setMushroomBlock(BYGBlocks.WITHERING_OAK_LEAVES)
                .setMaxHeight(30)
                .setMinHeight(22)
                .build()
        ));

    //Nether Features
    public static final ConfiguredFeature<BYGTreeConfig, ?> WAILING_PILLAR1 = createConfiguredFeature("wailing_pillar1",
        BYGFeatures.WAILING_PILLAR1.configured(
            new BYGTreeConfig.Builder()
                .setTrunkBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(Blocks.BASALT.defaultBlockState(), 8)
                    .add(Blocks.POLISHED_BASALT.defaultBlockState(), 2))
                ).
                setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(Blocks.POLISHED_BLACKSTONE_BRICKS.defaultBlockState(), 4)
                    .add(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS.defaultBlockState(), 3)
                    .add(Blocks.BLACKSTONE.defaultBlockState(), 2)
                    .add(BYGBlocks.DUSTED_POLISHED_BLACKSTONE_BRICKS.defaultBlockState(), 3))
                )
                .setMaxHeight(30)
                .setMinHeight(22)
                .build()
        ));
}