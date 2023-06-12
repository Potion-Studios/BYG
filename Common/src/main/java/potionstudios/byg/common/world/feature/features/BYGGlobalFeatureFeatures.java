package potionstudios.byg.common.world.feature.features;

import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import potionstudios.byg.common.block.BYGBlocks;

import static potionstudios.byg.common.world.feature.features.BYGFeaturesUtil.createConfiguredFeature;

public class BYGGlobalFeatureFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SOAPSTONE = createConfiguredFeature("ore_soapstone", () -> Feature.ORE, () -> new OreConfiguration(new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD), BYGBlocks.SOAPSTONE.defaultBlockState(), 64));

    public static void loadClass() {
    }

}