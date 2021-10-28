package corgiaoc.byg.core.world;

import corgiaoc.byg.common.world.structure.village.villagepools.AdobeVillagePools;
import corgiaoc.byg.common.world.structure.village.villagepools.EndRuins;
import corgiaoc.byg.common.world.structure.village.villagepools.RuinsVillagePools;
import corgiaoc.byg.common.world.structure.village.villagepools.SkyrisVillagePools;
import corgiaoc.byg.common.world.structure.village.villagepools.TropicalVillagePools;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.VillageConfig;

public class BYGConfiguredStructures {
    public static final StructureFeature<VillageConfig, ? extends Structure<VillageConfig>> END_RUINS = register("ruins_end", Structure.VILLAGE.configured(new VillageConfig(() -> {
        return EndRuins.START;
    }, 6)));

    public static final StructureFeature<VillageConfig, ? extends Structure<VillageConfig>> VILLAGE_SKYRIS = register("village_skyris", BYGStructures.SKYRIS_VILLAGE.configured(new VillageConfig(() -> {
        return SkyrisVillagePools.SkyrisVillageJigsaw;
    }, 6)));

    public static final StructureFeature<VillageConfig, ? extends Structure<VillageConfig>> VILLAGE_RUINS = register("village_ruins", BYGStructures.RUINS_VILLAGE.configured(new VillageConfig(() -> {
        return RuinsVillagePools.RuinsVillageJigsaw;
    }, 6)));

    public static final StructureFeature<VillageConfig, ? extends Structure<VillageConfig>> VILLAGE_ADOBE = register("village_adobe", BYGStructures.ADOBE_VILLAGE.configured(new VillageConfig(() -> {
        return AdobeVillagePools.ADOBE_VILLAGE_JIGSAW;
    }, 6)));

    public static final StructureFeature<VillageConfig, ? extends Structure<VillageConfig>> VILLAGE_TROPICAL = register("village_tropical", BYGStructures.TROPICAL_VILLAGE.configured(new VillageConfig(() -> {
        return TropicalVillagePools.TropicalVillageJigsaw;
    }, 6)));

    private static <FC extends IFeatureConfig, F extends Structure<FC>> StructureFeature<FC, F> register(String name, StructureFeature<FC, F> structure) {
        return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, name, structure);
    }
}
