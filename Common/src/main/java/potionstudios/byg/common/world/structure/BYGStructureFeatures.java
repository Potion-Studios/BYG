package potionstudios.byg.common.world.structure;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantFloat;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.biome.BYGBiomeTags;
import potionstudios.byg.common.world.feature.config.NoisySphereConfig;
import potionstudios.byg.common.world.structure.arch.ArchConfiguration;
import potionstudios.byg.common.world.structure.village.pool.AdobeVillagePools;
import potionstudios.byg.common.world.structure.village.pool.RuinsVillagePools;
import potionstudios.byg.common.world.structure.village.pool.SkyrisVillagePools;
import potionstudios.byg.common.world.structure.village.pool.TropicalVillagePools;
import potionstudios.byg.util.blendingfunction.BlendingFunction;

public class BYGStructureFeatures {

    public static final Holder<ConfiguredStructureFeature<?, ?>> VILLAGE_ADOBE = register("village_adobe", StructureFeature.VILLAGE.configured(new JigsawConfiguration(AdobeVillagePools.ADOBE_VILLAGE_JIGSAW, 6), BYGBiomeTags.HAS_VILLAGE_ADOBE, true));
    public static final Holder<ConfiguredStructureFeature<?, ?>> VILLAGE_SKYRIS = register("village_skyris", StructureFeature.VILLAGE.configured(new JigsawConfiguration(SkyrisVillagePools.SKYRIS_VILLAGE_POOL, 6), BYGBiomeTags.HAS_VILLAGE_SKYRIS, true));
    public static final Holder<ConfiguredStructureFeature<?, ?>> VILLAGE_RUINS = register("village_ruins", StructureFeature.VILLAGE.configured(new JigsawConfiguration(RuinsVillagePools.RUINS_VILLAGE_POOL, 6), BYGBiomeTags.HAS_VILLAGE_RUINS, true));
    public static final Holder<ConfiguredStructureFeature<?, ?>> VILLAGE_TROPICAL = register("village_tropical", StructureFeature.VILLAGE.configured(new JigsawConfiguration(TropicalVillagePools.TROPICAL_VILLAGE_POOL, 6), BYGBiomeTags.HAS_VILLAGE_TROPICAL, true));
    public static final Holder<ConfiguredStructureFeature<?, ?>> ARCH = register("red_rock_arch", BYGStructure.ARCH.configured(Util.make(new ArchConfiguration.Builder(), builder -> {
        WeightedStateProvider blockProvider = new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
            .add(BYGBlocks.RED_ROCK.defaultBlockState(), 4)
            .add(Blocks.TERRACOTTA.defaultBlockState(), 1)
        );
        builder.withSphereConfig(new NoisySphereConfig.Builder()
            .withRadiusSettings(
                new NoisySphereConfig.RadiusSettings(UniformInt.of(10, 15), UniformInt.of(10, 15), 0, UniformInt.of(10, 15))
            ).withBlockProvider(
                blockProvider
            ).withNoiseFrequency(0.02F)
            .withTopBlockProvider(
                blockProvider
            ).build()
        );
        builder.withMatchingBlendingFunctionChance(ConstantFloat.of(0.2F));
        builder.withBlendingFunctionType(SimpleWeightedRandomList.<BlendingFunction>builder().add(BlendingFunction.EaseOutCubic.INSTANCE, 16).add(BlendingFunction.EaseInOutCirc.INSTANCE, 8).add(BlendingFunction.EaseOutBounce.INSTANCE, 1).build());
    }).build(), BYGBiomeTags.HAS_RED_ROCK_ARCH, true));

    private static <FC extends FeatureConfiguration, F extends StructureFeature<FC>> Holder<ConfiguredStructureFeature<?, ?>> register(String id, ConfiguredStructureFeature<FC, F> configuredStructureFeature) {
        return BuiltinRegistries.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, BYG.createLocation(id), configuredStructureFeature);
    }
}