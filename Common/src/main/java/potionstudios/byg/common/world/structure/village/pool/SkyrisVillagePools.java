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

public class SkyrisVillagePools {
    public static final ResourceKey<StructureTemplatePool> SKYRIS_VILLAGE_TOWN_CENTERS = StructureTemplatePoolFactory.register("village/skyris/town_centers", context -> {

        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        HolderGetter<StructureProcessorList> processorListHolderGetter = context.lookup(Registries.PROCESSOR_LIST);
        Holder<StructureTemplatePool> emptyPool = templatePoolHolderGetter.getOrThrow(Pools.EMPTY);
        return new StructureTemplatePool(emptyPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/skyris/town_centers/skyris_meeting_point_1", processorListHolderGetter.getOrThrow(ProcessorLists.MOSSIFY_10_PERCENT)), 25),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/town_centers/skyris_meeting_point_2", processorListHolderGetter.getOrThrow(ProcessorLists.MOSSIFY_10_PERCENT)), 25),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/town_centers/skyris_meeting_point_3", processorListHolderGetter.getOrThrow(ProcessorLists.MOSSIFY_10_PERCENT)), 25),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/town_centers/skyris_meeting_point_4", processorListHolderGetter.getOrThrow(ProcessorLists.MOSSIFY_10_PERCENT)), 25)), StructureTemplatePool.Projection.RIGID);
    });

    public static final ResourceKey<StructureTemplatePool> SKYRIS_VILLAGE_TERMINATORS = StructureTemplatePoolFactory.register("village/skyris/terminators", context -> {

        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> emptyPool = templatePoolHolderGetter.getOrThrow(Pools.EMPTY);
        return new StructureTemplatePool(
                emptyPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/skyris/terminators/s_terminator_01"), 1),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/terminators/s_terminator_02"), 1)), StructureTemplatePool.Projection.TERRAIN_MATCHING);
    });


    public static final ResourceKey<StructureTemplatePool> SKYRIS_VILLAGE_STREETS = StructureTemplatePoolFactory.register("village/skyris/streets", context -> {

        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> terminatorPool = templatePoolHolderGetter.getOrThrow(SKYRIS_VILLAGE_TERMINATORS);
        return new StructureTemplatePool(
                terminatorPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/skyris/streets/skyris_corner_01"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/streets/skyris_corner_02"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/streets/skyris_straight_01"), 4),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/streets/skyris_straight_02"), 4),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/streets/skyris_straight_03"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/streets/skyris_crossroad_01"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/streets/skyris_crossroad_02"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/streets/skyris_crossroad_03"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/streets/skyris_square_01"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/streets/skyris_square_02"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/streets/skyris_turn_01"), 3)), StructureTemplatePool.Projection.TERRAIN_MATCHING);
    });

    public static final ResourceKey<StructureTemplatePool> SKYRIS_VILLAGE_HOUSES = StructureTemplatePoolFactory.register("village/skyris/houses", context -> {
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        HolderGetter<StructureProcessorList> processorListHolderGetter = context.lookup(Registries.PROCESSOR_LIST);


        Holder<StructureTemplatePool> terminatorPool = templatePoolHolderGetter.getOrThrow(SKYRIS_VILLAGE_TERMINATORS);
        return new StructureTemplatePool(
                terminatorPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/skyris/houses/skyris_small_house_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/houses/skyris_small_house_2"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/houses/skyris_small_house_3"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/houses/skyris_small_house_4"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/houses/skyris_small_house_5"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/houses/skyris_small_house_6"), 1),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/houses/skyris_medium_house_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/houses/skyris_tool_smith_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/houses/skyris_butcher_shop_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/houses/skyris_fletcher_house_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/houses/skyris_forager_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/houses/skyris_butcher_shop_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/houses/skyris_armorer_1"), 1),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/houses/skyris_fisher_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/houses/skyris_cartographer_house_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/houses/skyris_library_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/houses/skyris_mason_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/houses/skyris_weaponsmith_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/houses/skyris_temple_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/houses/skyris_large_farm_1", processorListHolderGetter.getOrThrow(ProcessorLists.FARM_DESERT)), 11),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/houses/skyris_animal_pen_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/houses/skyris_animal_pen_2"), 2),
                        Pair.of(StructurePoolElement.empty(), 7)), StructureTemplatePool.Projection.RIGID);
    });

    public static final ResourceKey<StructureTemplatePool> SKYRIS_VILLAGE_DECOR = StructureTemplatePoolFactory.register("village/skyris/decor", context -> {
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        HolderGetter<PlacedFeature> placedFeatureHolderGetter = context.lookup(Registries.PLACED_FEATURE);


        Holder<StructureTemplatePool> emptyPool = templatePoolHolderGetter.getOrThrow(Pools.EMPTY);
        return new StructureTemplatePool(
                emptyPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/skyris/skyris_lamp_1"), 10),
                        Pair.of(StructurePoolElement.feature(placedFeatureHolderGetter.getOrThrow(VillagePlacements.PATCH_BERRY_BUSH_VILLAGE)), 4),
                        Pair.of(StructurePoolElement.feature(placedFeatureHolderGetter.getOrThrow(VillagePlacements.PILE_HAY_VILLAGE)), 4),
                        Pair.of(StructurePoolElement.empty(), 6)), StructureTemplatePool.Projection.RIGID);
    });

    public static final ResourceKey<StructureTemplatePool> SKYRIS_VILLAGE_VILLAGERS = StructureTemplatePoolFactory.register("village/skyris/villagers", context -> {
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);

        Holder<StructureTemplatePool> emptyPool = templatePoolHolderGetter.getOrThrow(Pools.EMPTY);
        return new StructureTemplatePool(
                emptyPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/skyris/villagers/baby"), 1),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/villagers/baby"), 1),
                        Pair.of(StructurePoolElement.legacy("byg:village/skyris/villagers/unemployed"), 10)), StructureTemplatePool.Projection.RIGID);
    });
}
