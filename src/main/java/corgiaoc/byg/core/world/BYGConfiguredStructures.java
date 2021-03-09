package corgiaoc.byg.core.world;

import corgiaoc.byg.common.world.structure.village.villagepools.EndRuins;
import corgiaoc.byg.common.world.structure.village.villagepools.RuinsVillagePools;
import corgiaoc.byg.common.world.structure.village.villagepools.SkyrisVillagePools;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.VillageConfig;

public class BYGConfiguredStructures {
    public static final StructureFeature<VillageConfig, ? extends Structure<VillageConfig>> END_RUINS = register("ruins_end", Structure.VILLAGE.withConfiguration(new VillageConfig(() -> {
        return EndRuins.field_244193_a;
    }, 6)));

    public static final StructureFeature<VillageConfig, ? extends Structure<VillageConfig>> VILLAGE_SKYRIS = register("village_skyris", Structure.VILLAGE.withConfiguration(new VillageConfig(() -> {
        return SkyrisVillagePools.codec;
    }, 6)));

    public static final StructureFeature<VillageConfig, ? extends Structure<VillageConfig>> VILLAGE_RUINS = register("village_ruins", Structure.VILLAGE.withConfiguration(new VillageConfig(() -> {
        return RuinsVillagePools.codec2;
    }, 6)));

    private static <FC extends IFeatureConfig, F extends Structure<FC>> StructureFeature<FC, F> register(String name, StructureFeature<FC, F> structure) {
        return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, name, structure);
    }
}
