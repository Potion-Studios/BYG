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

public class TropicalVillagePools {


    public static final ResourceKey<StructureTemplatePool> TROPICAL_VILLAGE_TOWN_CENTERS = StructureTemplatePoolFactory.register("village/tropical/town_centers", context -> {
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        HolderGetter<StructureProcessorList> processorListHolderGetter = context.lookup(Registries.PROCESSOR_LIST);
        Holder<StructureTemplatePool> emptyPool = templatePoolHolderGetter.getOrThrow(Pools.EMPTY);

        return new StructureTemplatePool(
                emptyPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/tropical/town_centers/tropical_meeting_point_1", processorListHolderGetter.getOrThrow(ProcessorLists.MOSSIFY_10_PERCENT)), 90),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/town_centers/tropical_meeting_point_2", processorListHolderGetter.getOrThrow(ProcessorLists.MOSSIFY_10_PERCENT)), 10)), StructureTemplatePool.Projection.RIGID);
    });

    public static final ResourceKey<StructureTemplatePool> TROPICAL_VILLAGE_TERMINATORS = StructureTemplatePoolFactory.register("village/tropical/terminators", context -> {
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> emptyPool = templatePoolHolderGetter.getOrThrow(Pools.EMPTY);

        return new StructureTemplatePool(emptyPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/tropical/terminators/tropical_terminator_01"), 1),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/terminators/tropical_terminator_02"), 1)), StructureTemplatePool.Projection.TERRAIN_MATCHING);
    });

    public static final ResourceKey<StructureTemplatePool> TROPICAL_VILLAGE_STREETS = StructureTemplatePoolFactory.register("village/tropical/streets", context -> {
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> terminatorPool = templatePoolHolderGetter.getOrThrow(TROPICAL_VILLAGE_TERMINATORS);

        return new StructureTemplatePool(
                terminatorPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/tropical/streets/tropical_corner_01"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/streets/tropical_corner_02"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/streets/tropical_straight_01"), 4),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/streets/tropical_straight_02"), 4),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/streets/tropical_straight_03"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/streets/tropical_crossroad_01"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/streets/tropical_crossroad_02"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/streets/tropical_crossroad_03"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/streets/tropical_square_01"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/streets/tropical_square_02"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/streets/tropical_turn_01"), 3)), StructureTemplatePool.Projection.TERRAIN_MATCHING);
    });

    public static final ResourceKey<StructureTemplatePool> TROPICAL_VILLAGE_HOUSES = StructureTemplatePoolFactory.register("village/tropical/houses", context -> {
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        HolderGetter<StructureProcessorList> processorListHolderGetter = context.lookup(Registries.PROCESSOR_LIST);
        Holder<StructureTemplatePool> terminatorPool = templatePoolHolderGetter.getOrThrow(TROPICAL_VILLAGE_TERMINATORS);

        return new StructureTemplatePool(
                terminatorPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/tropical/houses/tropical_small_house_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/houses/tropical_small_house_2"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/houses/tropical_small_house_3"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/houses/tropical_small_house_4"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/houses/tropical_small_house_5"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/houses/tropical_small_house_6"), 1),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/houses/tropical_medium_house_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/houses/tropical_butcher_shop_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/houses/tropical_tool_smith_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/houses/tropical_fletcher_house_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/houses/tropical_shepherd_house_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/houses/tropical_armorer_1"), 1),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/houses/tropical_fisher_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/houses/tropical_tannery_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/houses/tropical_cartographer_house_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/houses/tropical_library_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/houses/tropical_mason_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/houses/tropical_weaponsmith_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/houses/tropical_weaponsmith_2"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/houses/tropical_temple_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/houses/tropical_temple_2"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/houses/tropical_large_farm_1", processorListHolderGetter.getOrThrow(ProcessorLists.FARM_DESERT)), 11),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/houses/tropical_farm_1", processorListHolderGetter.getOrThrow(ProcessorLists.FARM_DESERT)), 4),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/houses/tropical_farm_2", processorListHolderGetter.getOrThrow(ProcessorLists.FARM_DESERT)), 4),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/houses/tropical_animal_pen_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/houses/tropical_animal_pen_2"), 2),
                        Pair.of(StructurePoolElement.empty(), 10)), StructureTemplatePool.Projection.RIGID);
    });



    public static final ResourceKey<StructureTemplatePool> TROPICAL_VILLAGE_DECOR = StructureTemplatePoolFactory.register("village/tropical/decor", context -> {
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        HolderGetter<PlacedFeature> placedFeatureHolderGetter = context.lookup(Registries.PLACED_FEATURE);

        Holder<StructureTemplatePool> emptyPool = templatePoolHolderGetter.getOrThrow(Pools.EMPTY);

        return new StructureTemplatePool(
                emptyPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/tropical/tropical_lamp_1"), 10),
                        Pair.of(StructurePoolElement.feature(placedFeatureHolderGetter.getOrThrow(VillagePlacements.PILE_MELON_VILLAGE)), 4),
                        Pair.of(StructurePoolElement.feature(placedFeatureHolderGetter.getOrThrow(BYGVillagePlacements.BAMBOO_LIGHT)), 4),
                        Pair.of(StructurePoolElement.empty(), 6)), StructureTemplatePool.Projection.RIGID);
    });

    public static final ResourceKey<StructureTemplatePool> TROPICAL_VILLAGE_VILLAGERS = StructureTemplatePoolFactory.register("village/tropical/villagers", context -> {
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> emptyPool = templatePoolHolderGetter.getOrThrow(Pools.EMPTY);

        return new StructureTemplatePool(
                emptyPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/tropical/villagers/baby"), 1),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/villagers/baby"), 1),
                        Pair.of(StructurePoolElement.legacy("byg:village/tropical/villagers/unemployed"), 10)), StructureTemplatePool.Projection.RIGID);
    });
}
