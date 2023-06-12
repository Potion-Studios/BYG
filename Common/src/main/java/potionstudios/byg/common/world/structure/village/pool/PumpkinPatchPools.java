package potionstudios.byg.common.world.structure.village.pool;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.data.worldgen.ProcessorLists;
import net.minecraft.data.worldgen.placement.VillagePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

public class PumpkinPatchPools {
    public static final ResourceKey<StructureTemplatePool> PUMPKIN_PATCH_VILLAGE_TOWN_CENTERS = StructureTemplatePoolFactory.register("village/pumpkin_patch/town_centers", context -> {
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        HolderGetter<StructureProcessorList> processorListHolderGetter = context.lookup(Registries.PROCESSOR_LIST);
        Holder<StructureTemplatePool> emptyPool = templatePoolHolderGetter.getOrThrow(Pools.EMPTY);

        return new StructureTemplatePool(
                emptyPool,
                ImmutableList.of(
                        Pair.of(StructurePoolElement.legacy("byg:village/pumpkin_patch/town_centers/pumpkin_patch_meeting_point_1", processorListHolderGetter.getOrThrow(ProcessorLists.MOSSIFY_10_PERCENT)), 35),
                        Pair.of(StructurePoolElement.legacy("byg:village/pumpkin_patch/town_centers/pumpkin_patch_meeting_point_2", processorListHolderGetter.getOrThrow(ProcessorLists.MOSSIFY_10_PERCENT)), 35),
                        Pair.of(StructurePoolElement.legacy("byg:village/pumpkin_patch/town_centers/pumpkin_patch_meeting_point_3", processorListHolderGetter.getOrThrow(ProcessorLists.MOSSIFY_10_PERCENT)), 35)), StructureTemplatePool.Projection.RIGID);
    });


    public static final ResourceKey<StructureTemplatePool> PUMPKIN_PATCH_VILLAGE_TERMINATORS = StructureTemplatePoolFactory.register("village/pumpkin_patch/terminators", context -> {
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> emptyPool = templatePoolHolderGetter.getOrThrow(Pools.EMPTY);

        return new StructureTemplatePool(
                emptyPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/pumpkin_patch/terminators/pumpkin_patch_terminator_1"), 1),
                        Pair.of(StructurePoolElement.legacy("byg:village/pumpkin_patch/terminators/pumpkin_patch_terminator_2"), 1)), StructureTemplatePool.Projection.TERRAIN_MATCHING);
    });

    public static final ResourceKey<StructureTemplatePool> PUMPKIN_PATCH_VILLAGE_STREETS = StructureTemplatePoolFactory.register("village/pumpkin_patch/streets", context -> {
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> terminatorPool = templatePoolHolderGetter.getOrThrow(PUMPKIN_PATCH_VILLAGE_TERMINATORS);

        return new StructureTemplatePool(
                terminatorPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/pumpkin_patch/streets/pumpkin_patch_corner_1"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/pumpkin_patch/streets/pumpkin_patch_corner_2"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/pumpkin_patch/streets/pumpkin_patch_straight_1"), 4),
                        Pair.of(StructurePoolElement.legacy("byg:village/pumpkin_patch/streets/pumpkin_patch_straight_2"), 4),
                        Pair.of(StructurePoolElement.legacy("byg:village/pumpkin_patch/streets/pumpkin_patch_straight_3"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/pumpkin_patch/streets/pumpkin_patch_crossroad_1"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/pumpkin_patch/streets/pumpkin_patch_crossroad_2"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/pumpkin_patch/streets/pumpkin_patch_crossroad_3"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/pumpkin_patch/streets/pumpkin_patch_square_1"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/pumpkin_patch/streets/pumpkin_patch_square_2"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/pumpkin_patch/streets/pumpkin_patch_turn_1"), 3)), StructureTemplatePool.Projection.TERRAIN_MATCHING);
    });

    public static final ResourceKey<StructureTemplatePool> PUMPKIN_PATCH_VILLAGE_HOUSES = StructureTemplatePoolFactory.register("village/pumpkin_patch/houses", context -> {
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        HolderGetter<StructureProcessorList> processorListHolderGetter = context.lookup(Registries.PROCESSOR_LIST);
        Holder<StructureTemplatePool> terminatorPool = templatePoolHolderGetter.getOrThrow(PUMPKIN_PATCH_VILLAGE_TERMINATORS);

        return new StructureTemplatePool(
                terminatorPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/pumpkin_patch/houses/pumpkin_patch_small_house_1"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/pumpkin_patch/houses/pumpkin_patch_small_house_2"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/pumpkin_patch/houses/pumpkin_patch_small_house_3"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/pumpkin_patch/houses/pumpkin_patch_small_house_4"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/pumpkin_patch/houses/pumpkin_patch_medium_house_1"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/pumpkin_patch/houses/pumpkin_patch_medium_house_2"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/pumpkin_patch/houses/pumpkin_patch_medium_house_3"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/pumpkin_patch/houses/pumpkin_patch_small_farm_1", processorListHolderGetter.getOrThrow(ProcessorLists.FARM_TAIGA)), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/pumpkin_patch/houses/pumpkin_patch_small_farm_2", processorListHolderGetter.getOrThrow(ProcessorLists.FARM_TAIGA)), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/pumpkin_patch/houses/pumpkin_patch_small_farm_3", processorListHolderGetter.getOrThrow(ProcessorLists.FARM_TAIGA)), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/pumpkin_patch/houses/pumpkin_patch_small_farm_4", processorListHolderGetter.getOrThrow(ProcessorLists.FARM_TAIGA)), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/pumpkin_patch/houses/pumpkin_patch_small_farm_5", processorListHolderGetter.getOrThrow(ProcessorLists.FARM_TAIGA)), 2),
                        Pair.of(StructurePoolElement.empty(), 10)), StructureTemplatePool.Projection.RIGID);
    });

    public static final ResourceKey<StructureTemplatePool> PUMPKIN_PATCH_VILLAGE_DECOR = StructureTemplatePoolFactory.register("village/pumpkin_patch/decor", context -> {
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        HolderGetter<PlacedFeature> placedFeatureHolderGetter = context.lookup(Registries.PLACED_FEATURE);

        Holder<StructureTemplatePool> emptyPool = templatePoolHolderGetter.getOrThrow(Pools.EMPTY);

        return new StructureTemplatePool(
                emptyPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/pumpkin_patch/pumpkin_patch_lamp_1"), 10),
                        Pair.of(StructurePoolElement.feature(placedFeatureHolderGetter.getOrThrow(VillagePlacements.PILE_PUMPKIN_VILLAGE)), 2),
                        Pair.of(StructurePoolElement.empty(), 6)), StructureTemplatePool.Projection.RIGID);
    });

    public static final ResourceKey<StructureTemplatePool> PUMPKIN_PATCH_VILLAGE_WARDS = StructureTemplatePoolFactory.register("village/pumpkin_patch/wards", context -> {
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> emptyPool = templatePoolHolderGetter.getOrThrow(Pools.EMPTY);

        return new StructureTemplatePool(
                emptyPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/pumpkin_patch/wards/pumpkin_ward"), 5),
                        Pair.of(StructurePoolElement.legacy("byg:village/pumpkin_patch/wards/pumpkin_ward"), 5)), StructureTemplatePool.Projection.RIGID);
    });
}