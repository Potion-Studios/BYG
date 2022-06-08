package potionstudios.byg.common.world.structure;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.structure.arch.ArchStructure;
import potionstudios.byg.reg.RegistrationProvider;
import potionstudios.byg.reg.RegistryObject;

import java.util.function.Supplier;

public class BYGStructureTypes {

    public static final RegistrationProvider PROVIDER = RegistrationProvider.get(Registry.STRUCTURE_TYPES, BYG.MOD_ID);

    public static final RegistryObject<StructureType<ArchStructure>> ARCH = register("arch", () -> ArchStructure.CODEC);

    private static <S extends Structure> RegistryObject<StructureType<S>> register(String id, Supplier<? extends Codec<S>> codec) {
        return PROVIDER.register(id, codec);
    }

    public static void loadClass() {
    }
}
