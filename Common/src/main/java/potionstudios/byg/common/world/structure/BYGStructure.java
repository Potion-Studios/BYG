package potionstudios.byg.common.world.structure;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.structure.arch.ArchConfiguration;
import potionstudios.byg.common.world.structure.arch.ArchStructure;
import potionstudios.byg.mixin.access.StructureFeatureAccess;

public class BYGStructure {

    public static final StructureFeature<ArchConfiguration> ARCH = register("arch", new ArchStructure(ArchConfiguration.CODEC), GenerationStep.Decoration.RAW_GENERATION);


    private static <F extends StructureFeature<?>> F register(String id, F structure, GenerationStep.Decoration genStep) {
        StructureFeatureAccess.byg_getSTEP().put(structure, genStep);
        return Registry.register(Registry.STRUCTURE_FEATURE, BYG.createLocation(id), structure);
    }
}
