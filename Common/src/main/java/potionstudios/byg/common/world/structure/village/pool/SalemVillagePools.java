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

public class SalemVillagePools {
    public static final ResourceKey<StructureTemplatePool> SALEM_VILLAGE_TOWN_CENTERS = StructureTemplatePoolFactory.register("village/salem/town_centers", context -> {

        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        HolderGetter<StructureProcessorList> processorListHolderGetter = context.lookup(Registries.PROCESSOR_LIST);
        Holder<StructureTemplatePool> emptyPool = templatePoolHolderGetter.getOrThrow(Pools.EMPTY);
        return new StructureTemplatePool(emptyPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/salem/town_centers/salem_meeting_point_1", processorListHolderGetter.getOrThrow(ProcessorLists.MOSSIFY_10_PERCENT)), 35),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/town_centers/salem_meeting_point_2", processorListHolderGetter.getOrThrow(ProcessorLists.MOSSIFY_10_PERCENT)), 35)), StructureTemplatePool.Projection.RIGID);
    });

    public static final ResourceKey<StructureTemplatePool> SALEM_VILLAGE_TERMINATORS = StructureTemplatePoolFactory.register("village/salem/terminators", context -> {
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> emptyPool = templatePoolHolderGetter.getOrThrow(Pools.EMPTY);

        return new StructureTemplatePool(
                emptyPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/salem/terminators/salem_terminator_1"), 1),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/terminators/salem_terminator_2"), 1)), StructureTemplatePool.Projection.TERRAIN_MATCHING);
    });

    public static final ResourceKey<StructureTemplatePool> SALEM_VILLAGE_STREETS = StructureTemplatePoolFactory.register("village/salem/streets", context -> {
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> terminatorPool = templatePoolHolderGetter.getOrThrow(SALEM_VILLAGE_TERMINATORS);

        return new StructureTemplatePool(
                terminatorPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/salem/streets/salem_corner_1"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/streets/salem_corner_2"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/streets/salem_straight_1"), 4),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/streets/salem_straight_2"), 4),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/streets/salem_straight_3"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/streets/salem_crossroad_1"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/streets/salem_crossroad_2"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/streets/salem_crossroad_3"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/streets/salem_square_1"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/streets/salem_square_2"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/streets/salem_turn_1"), 3)), StructureTemplatePool.Projection.TERRAIN_MATCHING);
    });

    public static final ResourceKey<StructureTemplatePool> SALEM_VILLAGE_HOUSES = StructureTemplatePoolFactory.register("village/salem/houses", context -> {
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        HolderGetter<StructureProcessorList> processorListHolderGetter = context.lookup(Registries.PROCESSOR_LIST);
        Holder<StructureTemplatePool> terminatorPool = templatePoolHolderGetter.getOrThrow(SALEM_VILLAGE_TERMINATORS);

        return new StructureTemplatePool(
                terminatorPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/salem/houses/salem_small_house_1"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/houses/salem_small_house_2"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/houses/salem_small_house_3"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/houses/salem_medium_house_1"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/houses/salem_medium_house_2"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/houses/salem_medium_house_3"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/houses/salem_medium_house_4"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/houses/salem_large_house_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/houses/salem_shepherd_house_1"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/houses/salem_mason_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/houses/salem_temple"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/houses/salem_weaponsmith_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/houses/salem_toolsmith_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/houses/salem_tannery_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/houses/salem_fisher_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/houses/salem_fletcher_house_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/houses/salem_forager_1"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/houses/salem_cartographer_house_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/houses/salem_butcher_shop_1"), 3),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/houses/salem_armorsmith_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/houses/salem_toolsmith_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/houses/salem_animal_pen_1"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/houses/salem_animal_pen_2"), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/houses/salem_small_farm_1", processorListHolderGetter.getOrThrow(ProcessorLists.FARM_TAIGA)), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/houses/salem_small_farm_2", processorListHolderGetter.getOrThrow(ProcessorLists.FARM_TAIGA)), 2),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/houses/salem_large_farm_1", processorListHolderGetter.getOrThrow(ProcessorLists.FARM_TAIGA)), 3),
                        Pair.of(StructurePoolElement.empty(), 10)), StructureTemplatePool.Projection.RIGID);
    });

    public static final ResourceKey<StructureTemplatePool> SALEM_VILLAGE_DECOR = StructureTemplatePoolFactory.register("village/salem/decor", context -> {
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        HolderGetter<PlacedFeature> placedFeatureHolderGetter = context.lookup(Registries.PLACED_FEATURE);

        Holder<StructureTemplatePool> emptyPool = templatePoolHolderGetter.getOrThrow(Pools.EMPTY);

        return new StructureTemplatePool(
                emptyPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/salem/salem_lamp_1"), 10),
                        Pair.of(StructurePoolElement.feature(placedFeatureHolderGetter.getOrThrow(VillagePlacements.PILE_HAY_VILLAGE)), 2),
                        Pair.of(StructurePoolElement.empty(), 6)), StructureTemplatePool.Projection.RIGID);
    });

    public static final ResourceKey<StructureTemplatePool> SALEM_VILLAGE_VILLAGERS = StructureTemplatePoolFactory.register("village/salem/villagers", context -> {
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> emptyPool = templatePoolHolderGetter.getOrThrow(Pools.EMPTY);

        return new StructureTemplatePool(
                emptyPool,
                ImmutableList.of(Pair.of(StructurePoolElement.legacy("byg:village/salem/villagers/baby"), 1),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/villagers/baby"), 1),
                        Pair.of(StructurePoolElement.legacy("byg:village/salem/villagers/unemployed"), 10)), StructureTemplatePool.Projection.RIGID);
    });
}
