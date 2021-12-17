package potionstudios.byg.common.world.structure;

import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import potionstudios.byg.common.world.structure.village.pool.AdobeVillagePools;
import potionstudios.byg.common.world.structure.village.pool.RuinsVillagePools;
import potionstudios.byg.common.world.structure.village.pool.SkyrisVillagePools;
import potionstudios.byg.common.world.structure.village.pool.TropicalVillagePools;

public class BYGConfiguredStructures {

    public static final ConfiguredStructureFeature<JigsawConfiguration, ? extends StructureFeature<JigsawConfiguration>> VILLAGE_SKYRIS = register("village_skyris", StructureFeature.VILLAGE.configured(new JigsawConfiguration(() -> {
        return SkyrisVillagePools.SKYRIS_VILLAGE_POOL;
    }, 6)));

    public static final ConfiguredStructureFeature<JigsawConfiguration, ? extends StructureFeature<JigsawConfiguration>> VILLAGE_RUINS = register("village_ruins", StructureFeature.VILLAGE.configured(new JigsawConfiguration(() -> {
        return RuinsVillagePools.RuinsVillageJigsaw;
    }, 6)));

    public static final ConfiguredStructureFeature<JigsawConfiguration, ? extends StructureFeature<JigsawConfiguration>> VILLAGE_ADOBE = register("village_adobe", StructureFeature.VILLAGE.configured(new JigsawConfiguration(() -> {
        return AdobeVillagePools.ADOBE_VILLAGE_JIGSAW;
    }, 6)));

    public static final ConfiguredStructureFeature<JigsawConfiguration, ? extends StructureFeature<JigsawConfiguration>> VILLAGE_TROPICAL = register("village_tropical", StructureFeature.VILLAGE.configured(new JigsawConfiguration(() -> {
        return TropicalVillagePools.TropicalVillageJigsaw;
    }, 6)));

    private static <FC extends FeatureConfiguration, F extends StructureFeature<FC>> ConfiguredStructureFeature<FC, F> register(String name, ConfiguredStructureFeature<FC, F> structure) {
        return BuiltinRegistries.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, name, structure);
    }
}
