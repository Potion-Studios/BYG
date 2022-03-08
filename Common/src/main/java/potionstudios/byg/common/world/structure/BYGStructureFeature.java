package potionstudios.byg.common.world.structure;

import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import potionstudios.byg.common.world.structure.arch.ArchConfiguration;
import potionstudios.byg.common.world.structure.arch.ArchStructure;
import potionstudios.byg.mixin.access.StructureFeatureAccess;
import potionstudios.byg.util.RegistryObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BYGStructureFeature {

    public static final List<RegistryObject<StructureFeature<?>>> STRUCTURES = new ArrayList<>();

    public static final StructureFeature<ArchConfiguration> ARCH = register("arch", new ArchStructure(ArchConfiguration.CODEC), GenerationStep.Decoration.RAW_GENERATION);

    private static <F extends StructureFeature<?>> F register(String id, F structure, GenerationStep.Decoration genStep) {
        StructureFeatureAccess.byg_getSTEP().put(structure, genStep);
        STRUCTURES.add(new RegistryObject<>(structure, id));
        return structure;
    }

    public static Collection<RegistryObject<StructureFeature<?>>> bootStrap() {
        return STRUCTURES;
    }
}
