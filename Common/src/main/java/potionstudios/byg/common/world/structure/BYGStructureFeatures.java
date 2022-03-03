package potionstudios.byg.common.world.structure;

import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.BYGBiomeTags;
import potionstudios.byg.common.world.structure.village.pool.AdobeVillagePools;
import potionstudios.byg.common.world.structure.village.pool.RuinsVillagePools;
import potionstudios.byg.common.world.structure.village.pool.SkyrisVillagePools;
import potionstudios.byg.common.world.structure.village.pool.TropicalVillagePools;

public class BYGStructureFeatures {

    public static final Holder<ConfiguredStructureFeature<?, ?>> VILLAGE_ADOBE = register("village_adobe", StructureFeature.VILLAGE.configured(new JigsawConfiguration(AdobeVillagePools.ADOBE_VILLAGE_JIGSAW, 6), BYGBiomeTags.HAS_VILLAGE_ADOBE, true));
    public static final Holder<ConfiguredStructureFeature<?, ?>> VILLAGE_SKYRIS = register("village_skyris", StructureFeature.VILLAGE.configured(new JigsawConfiguration(SkyrisVillagePools.SKYRIS_VILLAGE_POOL, 6), BYGBiomeTags.HAS_VILLAGE_SKYRIS, true));
    public static final Holder<ConfiguredStructureFeature<?, ?>> VILLAGE_RUINS = register("village_ruins", StructureFeature.VILLAGE.configured(new JigsawConfiguration(RuinsVillagePools.RUINS_VILLAGE_POOL, 6), BYGBiomeTags.HAS_VILLAGE_RUINS, true));
    public static final Holder<ConfiguredStructureFeature<?, ?>> VILLAGE_TROPICAL = register("village_tropical", StructureFeature.VILLAGE.configured(new JigsawConfiguration(TropicalVillagePools.TROPICAL_VILLAGE_POOL, 6), BYGBiomeTags.HAS_VILLAGE_TROPICAL, true));

    private static <FC extends FeatureConfiguration, F extends StructureFeature<FC>> Holder<ConfiguredStructureFeature<?, ?>> register(String id, ConfiguredStructureFeature<FC, F> configuredStructureFeature) {
        return BuiltinRegistries.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, BYG.createLocation(id), configuredStructureFeature);
    }
}
