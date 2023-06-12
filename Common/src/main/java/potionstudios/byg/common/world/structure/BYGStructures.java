package potionstudios.byg.common.world.structure;

import corgitaco.corgilib.math.blendingfunction.BlendingFunction;
import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;
import net.minecraft.Util;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantFloat;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.biome.BYGBiomeTags;
import potionstudios.byg.common.world.feature.config.NoisySphereConfig;
import potionstudios.byg.common.world.feature.features.BYGStructurePlacedFeatures;
import potionstudios.byg.common.world.structure.arch.ArchConfiguration;
import potionstudios.byg.common.world.structure.arch.ArchStructure;
import potionstudios.byg.common.world.structure.village.pool.*;
import potionstudios.byg.common.world.structure.volcano.VolcanoStructure;
import potionstudios.byg.mixin.access.StructuresAccess;

import java.util.List;
import java.util.Map;


public class BYGStructures {

    public static final Map<ResourceKey<Structure>, StructureFactory> STRUCTURE_FACTORIES = new Reference2ObjectOpenHashMap<>();

    public static final ResourceKey<Structure> PUMPKIN_PATCH = register("pumpkin_patch", (structureFactoryBootstapContext) -> new JigsawStructure(structure(structureFactoryBootstapContext.lookup(Registries.BIOME).getOrThrow(BYGBiomeTags.HAS_PUMPKIN_PATCH), TerrainAdjustment.BEARD_THIN), structureFactoryBootstapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(PumpkinPatchPools.PUMPKIN_PATCH_VILLAGE_TOWN_CENTERS), 6, ConstantHeight.of(VerticalAnchor.absolute(0)), true, Heightmap.Types.WORLD_SURFACE_WG));
    public static final ResourceKey<Structure> VILLAGE_SALEM = register("village_salem", (structureFactoryBootstapContext) -> new JigsawStructure(structure(structureFactoryBootstapContext.lookup(Registries.BIOME).getOrThrow(BYGBiomeTags.HAS_VILLAGE_SALEM), TerrainAdjustment.BEARD_THIN), structureFactoryBootstapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(SalemVillagePools.SALEM_VILLAGE_TOWN_CENTERS), 6, ConstantHeight.of(VerticalAnchor.absolute(0)), true, Heightmap.Types.WORLD_SURFACE_WG));
    public static final ResourceKey<Structure> VILLAGE_RED_ROCK = register("village_red_rock", (structureFactoryBootstapContext) -> new JigsawStructure(structure(structureFactoryBootstapContext.lookup(Registries.BIOME).getOrThrow(BYGBiomeTags.HAS_VILLAGE_RED_ROCK), TerrainAdjustment.BEARD_THIN), structureFactoryBootstapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(RedRockVillagePools.RED_ROCK_VILLAGE_TOWN_CENTERS), 6, ConstantHeight.of(VerticalAnchor.absolute(0)), true, Heightmap.Types.WORLD_SURFACE_WG));
    public static final ResourceKey<Structure> VILLAGE_SKYRIS = register("village_skyris", (structureFactoryBootstapContext) -> new JigsawStructure(structure(structureFactoryBootstapContext.lookup(Registries.BIOME).getOrThrow(BYGBiomeTags.HAS_VILLAGE_SKYRIS), TerrainAdjustment.BEARD_THIN), structureFactoryBootstapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(SkyrisVillagePools.SKYRIS_VILLAGE_TOWN_CENTERS), 6, ConstantHeight.of(VerticalAnchor.absolute(0)), true, Heightmap.Types.WORLD_SURFACE_WG));
    public static final ResourceKey<Structure> VILLAGE_RUINS = register("village_ruins", (structureFactoryBootstapContext) -> new JigsawStructure(structure(structureFactoryBootstapContext.lookup(Registries.BIOME).getOrThrow(BYGBiomeTags.HAS_VILLAGE_RUINS), TerrainAdjustment.BEARD_THIN), structureFactoryBootstapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(RuinsVillagePools.RUINS_VILLAGE_TOWN_CENTERS), 6, ConstantHeight.of(VerticalAnchor.absolute(0)), true, Heightmap.Types.WORLD_SURFACE_WG));
    public static final ResourceKey<Structure> VILLAGE_TROPICAL = register("village_tropical", (structureFactoryBootstapContext) -> new JigsawStructure(structure(structureFactoryBootstapContext.lookup(Registries.BIOME).getOrThrow(BYGBiomeTags.HAS_VILLAGE_TROPICAL), TerrainAdjustment.BEARD_THIN), structureFactoryBootstapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(TropicalVillagePools.TROPICAL_VILLAGE_TOWN_CENTERS), 6, ConstantHeight.of(VerticalAnchor.absolute(0)), true, Heightmap.Types.WORLD_SURFACE_WG));
    public static final ResourceKey<Structure> RED_ROCK_ARCH = register("red_rock_arch", (structureFactoryBootstapContext) -> new ArchStructure(structure(structureFactoryBootstapContext.lookup(Registries.BIOME).getOrThrow(BYGBiomeTags.HAS_RED_ROCK_ARCH), GenerationStep.Decoration.RAW_GENERATION, TerrainAdjustment.NONE), Util.make(new ArchConfiguration.Builder(), builder -> {
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

    public static final ResourceKey<Structure> OVERGROWN_STONE_ARCH = register("overgrown_stone_arch", (structureFactoryBootstapContext) -> {
        HolderGetter<PlacedFeature> lookup = structureFactoryBootstapContext.lookup(Registries.PLACED_FEATURE);

        return new ArchStructure(structure(structureFactoryBootstapContext.lookup(Registries.BIOME).getOrThrow(BYGBiomeTags.HAS_OVERGROWN_STONE_ARCH), GenerationStep.Decoration.RAW_GENERATION, TerrainAdjustment.NONE), Util.make(new ArchConfiguration.Builder(), builder -> {
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
                    ).withSpawningFeatures(List.of(lookup.getOrThrow(BYGStructurePlacedFeatures.ARCH_MOSS_PATCH), lookup.getOrThrow(BYGStructurePlacedFeatures.ARCH_MOSS_PATCH_CEILING)))
                    .build()
            );
            builder.withMatchingBlendingFunctionChance(ConstantFloat.of(0.2F));
            builder.withPercentageDestroyed(ConstantFloat.of(0));
            builder.withLength(UniformInt.of(50, 100));
            builder.withHeight(UniformInt.of(50, 100));
            builder.withBlendingFunctionType(SimpleWeightedRandomList.<BlendingFunction>builder().add(BlendingFunction.EaseOutQuint.INSTANCE, 5).add(BlendingFunction.EaseOutElastic.INSTANCE, 2).add(BlendingFunction.EaseOutBounce.INSTANCE, 5).add(BlendingFunction.EaseOutCubic.INSTANCE, 5).build());
        }).build());
    });

    public static final ResourceKey<Structure> STONE_ARCH = register("stone_arch", (structureFactoryBootstapContext) -> new ArchStructure(structure(structureFactoryBootstapContext.lookup(Registries.BIOME).getOrThrow(BYGBiomeTags.HAS_STONE_ARCH), GenerationStep.Decoration.RAW_GENERATION, TerrainAdjustment.NONE), Util.make(new ArchConfiguration.Builder(), builder -> {
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

    public static final ResourceKey<Structure> DESTROYED_RED_ROCK_ARCH = register("destroyed_red_rock_arch", (structureFactoryBootstapContext) -> new ArchStructure(structure(structureFactoryBootstapContext.lookup(Registries.BIOME).getOrThrow(BYGBiomeTags.HAS_RED_ROCK_ARCH), GenerationStep.Decoration.RAW_GENERATION, TerrainAdjustment.NONE), Util.make(new ArchConfiguration.Builder(), builder -> {
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

    public static final ResourceKey<Structure> VOLCANO = register("volcano", (structureFactoryBootstapContext) -> new VolcanoStructure(structure(structureFactoryBootstapContext.lookup(Registries.BIOME).getOrThrow(BiomeTags.IS_OCEAN), GenerationStep.Decoration.RAW_GENERATION, TerrainAdjustment.NONE)));
    public static final ResourceKey<Structure> ANCIENT_SEQUOIA = register("ancient_sequoia", (structureFactoryBootstapContext) -> new AncientSequoiaTreeStructure(structure(structureFactoryBootstapContext.lookup(Registries.BIOME).getOrThrow(BYGBiomeTags.HAS_ANCIENT_SEQUOIA), GenerationStep.Decoration.VEGETAL_DECORATION, TerrainAdjustment.NONE), new AncientSequoiaTreeStructure.Config(BYG.createLocation("features/trees/ancient/ancient_sequoia"), true)));

    private static ResourceKey<Structure> register(String id, StructureFactory factory) {
        ResourceKey<Structure> structureSetResourceKey = ResourceKey.create(Registries.STRUCTURE, BYG.createLocation(id));
        STRUCTURE_FACTORIES.put(structureSetResourceKey, factory);
        return structureSetResourceKey;
    }

    private static Structure.StructureSettings structure(HolderSet<Biome> tag, TerrainAdjustment adj) {
        return StructuresAccess.structure(tag, Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, adj);
    }

    private static Structure.StructureSettings structure(HolderSet<Biome> tag, GenerationStep.Decoration decoration, TerrainAdjustment adj) {
        return StructuresAccess.structure(tag, Map.of(), decoration, adj);
    }

    public static void loadClass() {
    }

    @FunctionalInterface
    public interface StructureFactory {
        Structure generate(BootstapContext<Structure> structureFactoryBootstapContext);
    }
}
