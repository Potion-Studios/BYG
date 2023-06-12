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
import potionstudios.byg.common.world.feature.placement.BYGVillagePlacements;

public class RuinsVillagePools {
    public static final ResourceKey<StructureTemplatePool> RUINS_VILLAGE_TOWN_CENTERS = StructureTemplatePoolFactory.register("village/ruins/town_centers", context -> {
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        HolderGetter<StructureProcessorList> processorListHolderGetter = context.lookup(Registries.PROCESSOR_LIST);
        Holder<StructureTemplatePool> emptyPool = templatePoolHolderGetter.getOrThrow(Pools.EMPTY);

        return new StructureTemplatePool(
                emptyPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/ruins/town_centers/ruins_meeting_point_1", processorListHolderGetter.getOrThrow(ProcessorLists.MOSSIFY_10_PERCENT)), 30),
                        Pair.of(StructurePoolElement.legacy("byg:village/ruins/town_centers/ruins_meeting_point_2", processorListHolderGetter.getOrThrow(ProcessorLists.MOSSIFY_10_PERCENT)), 30),
                        Pair.of(StructurePoolElement.legacy("byg:village/ruins/town_centers/ruins_meeting_point_3", processorListHolderGetter.getOrThrow(ProcessorLists.MOSSIFY_10_PERCENT)), 30),
                        Pair.of(StructurePoolElement.legacy("byg:village/ruins/town_centers/ruins_meeting_point_4", processorListHolderGetter.getOrThrow(ProcessorLists.MOSSIFY_10_PERCENT)), 10)), StructureTemplatePool.Projection.RIGID);
    });

    public static final ResourceKey<StructureTemplatePool> RUINS_VILLAGE_TERMINATORS = StructureTemplatePoolFactory.register("village/ruins/terminators", context -> {
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> emptyPool = templatePoolHolderGetter.getOrThrow(Pools.EMPTY);

        return new StructureTemplatePool(
                emptyPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/ruins/terminators/s_terminator_01"), 1),
                        Pair.of(StructurePoolElement.legacy("byg:village/ruins/terminators/s_terminator_02"), 1)), StructureTemplatePool.Projection.TERRAIN_MATCHING);
    });

    public static final ResourceKey<StructureTemplatePool> RUINS_VILLAGE_STREETS = StructureTemplatePoolFactory.register("village/ruins/streets", context -> {
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> terminatorPool = templatePoolHolderGetter.getOrThrow(RUINS_VILLAGE_TERMINATORS);

        return new StructureTemplatePool(terminatorPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/ruins/streets/ruins_corner_01"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/ruins/streets/ruins_corner_02"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/ruins/streets/ruins_straight_01"), 4),
                        Pair.of(StructurePoolElement.legacy("byg:village/ruins/streets/ruins_straight_02"), 4),
                        Pair.of(StructurePoolElement.legacy("byg:village/ruins/streets/ruins_straight_03"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/ruins/streets/ruins_crossroad_01"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/ruins/streets/ruins_crossroad_02"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/ruins/streets/ruins_crossroad_03"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/ruins/streets/ruins_crossroad_04"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/ruins/streets/ruins_square_01"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/ruins/streets/ruins_square_02"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/ruins/streets/ruins_turn_01"), 3)), StructureTemplatePool.Projection.TERRAIN_MATCHING);
    });

    public static final ResourceKey<StructureTemplatePool> RUINS_VILLAGE_HOUSES = StructureTemplatePoolFactory.register("village/ruins/houses", context -> {
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> terminatorPool = templatePoolHolderGetter.getOrThrow(RUINS_VILLAGE_TERMINATORS);

        return new StructureTemplatePool(
                terminatorPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/ruins/houses/ruins_small_house_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/ruins/houses/ruins_small_house_2"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/ruins/houses/ruins_small_house_3"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/ruins/houses/ruins_small_house_4"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/ruins/houses/ruins_small_house_5"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/ruins/houses/ruins_small_house_6"), 1),
                        Pair.of(StructurePoolElement.legacy("byg:village/ruins/houses/ruins_small_house_7"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/ruins/houses/ruins_small_house_8"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/ruins/houses/ruins_medium_house_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/ruins/houses/ruins_medium_house_2"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/ruins/houses/ruins_medium_house_3"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/ruins/houses/ruins_medium_house_4"), 2),
                        Pair.of(StructurePoolElement.empty(), 10)), StructureTemplatePool.Projection.RIGID);
    });

    public static final ResourceKey<StructureTemplatePool> RUINS_VILLAGE_DECOR = StructureTemplatePoolFactory.register("village/ruins/decor", context -> {
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        HolderGetter<PlacedFeature> placedFeatureHolderGetter = context.lookup(Registries.PLACED_FEATURE);

        Holder<StructureTemplatePool> emptyPool = templatePoolHolderGetter.getOrThrow(Pools.EMPTY);

        return new StructureTemplatePool(
                emptyPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/ruins/ruins_lamp_1"), 10),
                        Pair.of(StructurePoolElement.feature(placedFeatureHolderGetter.getOrThrow(VillagePlacements.PATCH_BERRY_BUSH_VILLAGE)), 4),
                        Pair.of(StructurePoolElement.feature(placedFeatureHolderGetter.getOrThrow(BYGVillagePlacements.RED_MUSHROOM_NORMAL)), 4),
                        Pair.of(StructurePoolElement.empty(), 6)), StructureTemplatePool.Projection.RIGID);
    });

    public static final ResourceKey<StructureTemplatePool> RUINS_VILLAGE_VILLAGERS = StructureTemplatePoolFactory.register("village/ruins/villagers", context -> {
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> emptyPool = templatePoolHolderGetter.getOrThrow(Pools.EMPTY);

        return new StructureTemplatePool(
                emptyPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/ruins/villagers/baby"), 1),
                        Pair.of(StructurePoolElement.legacy("byg:village/ruins/villagers/baby"), 1),
                        Pair.of(StructurePoolElement.legacy("byg:village/ruins/villagers/unemployed"), 10)), StructureTemplatePool.Projection.RIGID);
    });
}
