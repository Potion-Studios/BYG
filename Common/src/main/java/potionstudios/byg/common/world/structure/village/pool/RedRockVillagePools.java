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

public class RedRockVillagePools {
    public static final ResourceKey<StructureTemplatePool> RED_ROCK_VILLAGE_TOWN_CENTERS = StructureTemplatePoolFactory.register("village/red_rock/town_centers", context -> {
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        HolderGetter<StructureProcessorList> processorListHolderGetter = context.lookup(Registries.PROCESSOR_LIST);
        Holder<StructureTemplatePool> emptyPool = templatePoolHolderGetter.getOrThrow(Pools.EMPTY);

        return new StructureTemplatePool(
                emptyPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/red_rock/town_centers/red_rock_meeting_point_1", processorListHolderGetter.getOrThrow(ProcessorLists.MOSSIFY_10_PERCENT)), 35),
                        Pair.of(StructurePoolElement.legacy("byg:village/red_rock/town_centers/red_rock_meeting_point_2", processorListHolderGetter.getOrThrow(ProcessorLists.MOSSIFY_10_PERCENT)), 35),
                        Pair.of(StructurePoolElement.legacy("byg:village/red_rock/town_centers/red_rock_meeting_point_3", processorListHolderGetter.getOrThrow(ProcessorLists.MOSSIFY_10_PERCENT)), 35)), StructureTemplatePool.Projection.RIGID);
    });

    public static final ResourceKey<StructureTemplatePool> RED_ROCK_VILLAGE_TERMINATORS = StructureTemplatePoolFactory.register("village/red_rock/terminators", context -> {
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> emptyPool = templatePoolHolderGetter.getOrThrow(Pools.EMPTY);

        return new StructureTemplatePool(emptyPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/red_rock/terminators/red_rock_terminator_01"), 1),
                        Pair.of(StructurePoolElement.legacy("byg:village/red_rock/terminators/red_rock_terminator_02"), 1)), StructureTemplatePool.Projection.TERRAIN_MATCHING);
    });

    public static final ResourceKey<StructureTemplatePool> RED_ROCK_VILLAGE_STREETS = StructureTemplatePoolFactory.register("village/red_rock/streets", context -> {
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> terminatorPool = templatePoolHolderGetter.getOrThrow(RED_ROCK_VILLAGE_TERMINATORS);

        return new StructureTemplatePool(
                terminatorPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/red_rock/streets/red_rock_corner_01"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/red_rock/streets/red_rock_corner_02"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/red_rock/streets/red_rock_straight_01"), 4),
                        Pair.of(StructurePoolElement.legacy("byg:village/red_rock/streets/red_rock_straight_02"), 4),
                        Pair.of(StructurePoolElement.legacy("byg:village/red_rock/streets/red_rock_straight_03"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/red_rock/streets/red_rock_crossroad_01"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/red_rock/streets/red_rock_crossroad_02"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/red_rock/streets/red_rock_crossroad_03"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/red_rock/streets/red_rock_square_01"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/red_rock/streets/red_rock_square_02"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/red_rock/streets/red_rock_turn_01"), 3)), StructureTemplatePool.Projection.TERRAIN_MATCHING);
    });

    public static final ResourceKey<StructureTemplatePool> RED_ROCK_VILLAGE_HOUSES = StructureTemplatePoolFactory.register("village/tropical/houses", context -> {
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        HolderGetter<StructureProcessorList> processorListHolderGetter = context.lookup(Registries.PROCESSOR_LIST);
        Holder<StructureTemplatePool> terminatorPool = templatePoolHolderGetter.getOrThrow(RED_ROCK_VILLAGE_TERMINATORS);

        return new StructureTemplatePool(
                terminatorPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/red_rock/houses/red_rock_small_house_1"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/red_rock/houses/red_rock_small_house_2"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/red_rock/houses/red_rock_small_house_3"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/red_rock/houses/red_rock_small_house_4"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/red_rock/houses/red_rock_small_house_5"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/red_rock/houses/red_rock_medium_house_1"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/red_rock/houses/red_rock_medium_house_2"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/red_rock/houses/red_rock_large_house_1"), 4),
                        Pair.of(StructurePoolElement.legacy("byg:village/red_rock/houses/red_rock_shepherd_house_1"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/red_rock/houses/red_rock_mason_1"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/red_rock/houses/red_rock_cleric"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/red_rock/houses/red_rock_market_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/red_rock/houses/red_rock_market_2"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/red_rock/houses/red_rock_farm_large_1", processorListHolderGetter.getOrThrow(ProcessorLists.FARM_DESERT)), 4),
                        Pair.of(StructurePoolElement.legacy("byg:village/red_rock/houses/red_rock_farm_small_1", processorListHolderGetter.getOrThrow(ProcessorLists.FARM_DESERT)), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/red_rock/houses/red_rock_farm_small_2", processorListHolderGetter.getOrThrow(ProcessorLists.FARM_DESERT)), 3),
                        Pair.of(StructurePoolElement.empty(), 10)), StructureTemplatePool.Projection.RIGID);
    });

    public static final ResourceKey<StructureTemplatePool> RED_ROCK_VILLAGE_DECOR = StructureTemplatePoolFactory.register("village/red_rock/decor", context -> {
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        HolderGetter<PlacedFeature> placedFeatureHolderGetter = context.lookup(Registries.PLACED_FEATURE);

        Holder<StructureTemplatePool> emptyPool = templatePoolHolderGetter.getOrThrow(Pools.EMPTY);

        return new StructureTemplatePool(
                emptyPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/red_rock/red_rock_lamp_1"), 10),
                        Pair.of(StructurePoolElement.feature(placedFeatureHolderGetter.getOrThrow(VillagePlacements.PILE_HAY_VILLAGE)), 2),
                        Pair.of(StructurePoolElement.empty(), 6)), StructureTemplatePool.Projection.RIGID);
    });

    public static final ResourceKey<StructureTemplatePool> RED_ROCK_VILLAGE_VILLAGERS = StructureTemplatePoolFactory.register("village/red_rock/villagers", context -> {
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> emptyPool = templatePoolHolderGetter.getOrThrow(Pools.EMPTY);

        return new StructureTemplatePool(
                emptyPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/red_rock/villagers/baby"), 1),
                        Pair.of(StructurePoolElement.legacy("byg:village/red_rock/villagers/baby"), 1),
                        Pair.of(StructurePoolElement.legacy("byg:village/red_rock/villagers/unemployed"), 10)), StructureTemplatePool.Projection.RIGID);
    });
}
