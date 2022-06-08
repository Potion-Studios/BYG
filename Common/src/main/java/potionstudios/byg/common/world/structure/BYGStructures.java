package potionstudios.byg.common.world.structure;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.TagKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantFloat;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSpawnOverride;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.biome.BYGBiomeTags;
import potionstudios.byg.common.world.feature.config.NoisySphereConfig;
import potionstudios.byg.common.world.feature.placement.BYGPlacedFeaturesUtil;
import potionstudios.byg.common.world.structure.arch.ArchConfiguration;
import potionstudios.byg.common.world.structure.arch.ArchStructure;
import potionstudios.byg.common.world.structure.village.pool.RedRockVillagePools;
import potionstudios.byg.common.world.structure.village.pool.RuinsVillagePools;
import potionstudios.byg.common.world.structure.village.pool.SkyrisVillagePools;
import potionstudios.byg.common.world.structure.village.pool.TropicalVillagePools;
import potionstudios.byg.mixin.access.StructuresAccess;
import potionstudios.byg.reg.RegistrationProvider;
import potionstudios.byg.util.blendingfunction.BlendingFunction;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static potionstudios.byg.mixin.access.StructuresAccess.byg_invokeStructure;

public class BYGStructures {

    public static final RegistrationProvider<Structure> PROVIDER = RegistrationProvider.get(BuiltinRegistries.STRUCTURES, BYG.MOD_ID);

    public static final Holder<Structure> VILLAGE_RED_ROCK = register("village_red_rock", () -> new JigsawStructure(byg_invokeStructure(BYGBiomeTags.HAS_VILLAGE_RED_ROCK, TerrainAdjustment.BEARD_THIN), RedRockVillagePools.RED_ROCK_VILLAGE_JIGSAW, 6, ConstantHeight.of(VerticalAnchor.absolute(0)), true, Heightmap.Types.WORLD_SURFACE_WG));
    public static final Holder<Structure> VILLAGE_SKYRIS = register("village_skyris", () -> new JigsawStructure(byg_invokeStructure(BYGBiomeTags.HAS_VILLAGE_SKYRIS, TerrainAdjustment.BEARD_THIN), SkyrisVillagePools.SKYRIS_VILLAGE_POOL, 6, ConstantHeight.of(VerticalAnchor.absolute(0)), true, Heightmap.Types.WORLD_SURFACE_WG));
    public static final Holder<Structure> VILLAGE_RUINS = register("village_ruins", () -> new JigsawStructure(byg_invokeStructure(BYGBiomeTags.HAS_VILLAGE_RUINS, TerrainAdjustment.BEARD_THIN), RuinsVillagePools.RUINS_VILLAGE_POOL, 6, ConstantHeight.of(VerticalAnchor.absolute(0)), true, Heightmap.Types.WORLD_SURFACE_WG));
    public static final Holder<Structure> VILLAGE_TROPICAL = register("village_tropical", () -> new JigsawStructure(byg_invokeStructure(BYGBiomeTags.HAS_VILLAGE_TROPICAL, TerrainAdjustment.BEARD_THIN), TropicalVillagePools.TROPICAL_VILLAGE_POOL, 6, ConstantHeight.of(VerticalAnchor.absolute(0)), true, Heightmap.Types.WORLD_SURFACE_WG));
    public static final Holder<Structure> RED_ROCK_ARCH = register("red_rock_arch", () -> new ArchStructure(byg_invokeStructure(BYGBiomeTags.HAS_RED_ROCK_ARCH, GenerationStep.Decoration.RAW_GENERATION, TerrainAdjustment.NONE), Util.make(new ArchConfiguration.Builder(), builder -> {
        WeightedStateProvider blockProvider = new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(BYGBlocks.RED_ROCK.defaultBlockState(), 4)
                .add(Blocks.TERRACOTTA.defaultBlockState(), 1)
        );
        builder.withSphereConfig(new NoisySphereConfig.Builder()
                .withRadiusSettings(
                        new NoisySphereConfig.RadiusSettings(UniformInt.of(10, 15), UniformInt.of(10, 15), 0, UniformInt.of(10, 15))
                ).withBlockProvider(
                        blockProvider
                ).withNoiseFrequency(0.1F)
                .withTopBlockProvider(
                        blockProvider
                ).build()
        );
        builder.withMatchingBlendingFunctionChance(ConstantFloat.of(0.2F));
        builder.withPercentageDestroyed(ConstantFloat.of(0));
        builder.withBlendingFunctionType(SimpleWeightedRandomList.<BlendingFunction>builder().add(BlendingFunction.EaseOutCubic.INSTANCE, 16).add(BlendingFunction.EaseInOutCirc.INSTANCE, 8).add(BlendingFunction.EaseOutBounce.INSTANCE, 1).build());
    }).build()));

    public static final Holder<Structure> OVERGROWN_STONE_ARCH = register("overgrown_stone_arch", () -> new ArchStructure(byg_invokeStructure(BYGBiomeTags.HAS_OVERGROWN_STONE_ARCH, GenerationStep.Decoration.RAW_GENERATION, TerrainAdjustment.NONE), Util.make(new ArchConfiguration.Builder(), builder -> {
        WeightedStateProvider blockProvider = new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(Blocks.STONE.defaultBlockState(), 6)
                .add(Blocks.MOSSY_COBBLESTONE.defaultBlockState(), 3)
                .add(BYGBlocks.MOSSY_STONE.defaultBlockState(), 3)
                .add(Blocks.ANDESITE.defaultBlockState(), 1)
        );
        builder.withSphereConfig(new NoisySphereConfig.Builder()
                .withRadiusSettings(
                        new NoisySphereConfig.RadiusSettings(UniformInt.of(10, 15), UniformInt.of(10, 15), 0, UniformInt.of(10, 15))
                ).withBlockProvider(
                        blockProvider
                ).withNoiseFrequency(0.1F)
                .withTopBlockProvider(
                        blockProvider
                ).withSpawningFeatures(List.of(
                        BYGPlacedFeaturesUtil.createPlacedFeature("arch_moss_patch_ceiling", CaveFeatures.MOSS_PATCH_CEILING, RarityFilter.onAverageOnceEvery(350), RandomOffsetPlacement.vertical(UniformInt.of(-15, -10))),
                        BYGPlacedFeaturesUtil.createPlacedFeature("arch_moss_patch", CaveFeatures.MOSS_PATCH, RarityFilter.onAverageOnceEvery(350), PlacementUtils.HEIGHTMAP)
                ))
                .build()
        );
        builder.withMatchingBlendingFunctionChance(ConstantFloat.of(0.2F));
        builder.withPercentageDestroyed(ConstantFloat.of(0));
        builder.withLength(UniformInt.of(50, 100));
        builder.withHeight(UniformInt.of(50, 100));
        builder.withBlendingFunctionType(SimpleWeightedRandomList.<BlendingFunction>builder().add(BlendingFunction.EaseOutQuint.INSTANCE, 5).add(BlendingFunction.EaseOutElastic.INSTANCE, 2).add(BlendingFunction.EaseOutBounce.INSTANCE, 5).add(BlendingFunction.EaseOutCubic.INSTANCE, 5).build());
    }).build()));

    public static final Holder<Structure> STONE_ARCH = register("stone_arch", () -> new ArchStructure(byg_invokeStructure(BYGBiomeTags.HAS_STONE_ARCH, GenerationStep.Decoration.RAW_GENERATION, TerrainAdjustment.NONE), Util.make(new ArchConfiguration.Builder(), builder -> {
        WeightedStateProvider blockProvider = new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(Blocks.STONE.defaultBlockState(), 4)
                .add(Blocks.ANDESITE.defaultBlockState(), 1)
        );
        builder.withSphereConfig(new NoisySphereConfig.Builder()
                .withRadiusSettings(
                        new NoisySphereConfig.RadiusSettings(UniformInt.of(10, 15), UniformInt.of(10, 15), 0, UniformInt.of(10, 15))
                ).withBlockProvider(
                        blockProvider
                ).withNoiseFrequency(0.1F)
                .withTopBlockProvider(
                        blockProvider
                ).withSpawningFeatures(List.of(
                ))
                .build()
        );
        builder.withMatchingBlendingFunctionChance(ConstantFloat.of(0.2F));
        builder.withPercentageDestroyed(ConstantFloat.of(0));
        builder.withLength(UniformInt.of(50, 100));
        builder.withHeight(UniformInt.of(50, 100));
        builder.withBlendingFunctionType(SimpleWeightedRandomList.<BlendingFunction>builder().add(BlendingFunction.EaseOutQuint.INSTANCE, 5).add(BlendingFunction.EaseOutElastic.INSTANCE, 2).add(BlendingFunction.EaseOutBounce.INSTANCE, 5).add(BlendingFunction.EaseOutCubic.INSTANCE, 5).build());
    }).build()));

    public static final Holder<Structure> DESTROYED_RED_ROCK_ARCH = register("destroyed_red_rock_arch", () -> new ArchStructure(byg_invokeStructure(BYGBiomeTags.HAS_RED_ROCK_ARCH, GenerationStep.Decoration.RAW_GENERATION, TerrainAdjustment.NONE), Util.make(new ArchConfiguration.Builder(), builder -> {
        WeightedStateProvider blockProvider = new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(BYGBlocks.RED_ROCK.defaultBlockState(), 4)
                .add(Blocks.TERRACOTTA.defaultBlockState(), 1)
        );
        builder.withSphereConfig(new NoisySphereConfig.Builder()
                .withRadiusSettings(
                        new NoisySphereConfig.RadiusSettings(UniformInt.of(10, 15), UniformInt.of(10, 15), 0, UniformInt.of(10, 15))
                ).withBlockProvider(
                        blockProvider
                ).withNoiseFrequency(0.1F)
                .withTopBlockProvider(
                        blockProvider
                ).build()
        );
        builder.withMatchingBlendingFunctionChance(ConstantFloat.of(0.2F));
        builder.withPercentageDestroyed(UniformFloat.of(0.45F, 1.0F));
        builder.withBlendingFunctionType(SimpleWeightedRandomList.<BlendingFunction>builder().add(BlendingFunction.EaseOutCubic.INSTANCE, 16).add(BlendingFunction.EaseInOutCirc.INSTANCE, 8).add(BlendingFunction.EaseOutBounce.INSTANCE, 1).build());
    }).build()));

    private static Holder<Structure> register(String id, Supplier<Structure> structureSupplier) {
        return PROVIDER.register(id, structureSupplier).asHolder();
    }

    private static Structure.StructureSettings structure(TagKey<Biome> tag, TerrainAdjustment adj) {
        return StructuresAccess.structure(tag, Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, adj);
    }

    private static Structure.StructureSettings structure(TagKey<Biome> tag, GenerationStep.Decoration decoration, TerrainAdjustment adj) {
        return StructuresAccess.structure(tag, Map.of(), decoration, adj);
    }

    public static void loadClass() {
    }
}
