package potionstudios.byg.common.world.structure;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.structure.arch.ArchConfiguration;
import potionstudios.byg.common.world.structure.arch.ArchStructure;
import potionstudios.byg.reg.RegistrationProvider;
import potionstudios.byg.reg.RegistryObject;

import java.util.function.Supplier;

public class BYGStructureFeature {

    public static final RegistrationProvider<StructureFeature<?>> PROVIDER = RegistrationProvider.get(Registry.STRUCTURE_FEATURE_REGISTRY, BYG.MOD_ID);

    public static final RegistryObject<StructureFeature<ArchConfiguration>> ARCH = register("arch", () -> new ArchStructure(ArchConfiguration.CODEC));

    private static <F extends StructureFeature<?>> RegistryObject<F> register(String id, Supplier<? extends F> structure) {
        return PROVIDER.register(id, structure);
    }

    public static void loadClass() {}
}
