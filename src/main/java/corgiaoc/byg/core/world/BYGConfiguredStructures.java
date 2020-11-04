package corgiaoc.byg.core.world;

import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public class BYGConfiguredStructures {
    public static StructureFeature<?, ?> VOLCANO_STRUCTURE = WorldGenRegistrationHelper.createConfiguredStructureFeature("volcano", BYGStructures.VOLCANO_STRUCTURE.withConfiguration(new NoFeatureConfig()));

}
