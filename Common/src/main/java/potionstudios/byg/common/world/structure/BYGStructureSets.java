package potionstudios.byg.common.world.structure;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;
import potionstudios.byg.BYG;
import potionstudios.byg.registration.RegistrationProvider;

import java.util.List;
import java.util.function.Supplier;

public class BYGStructureSets {

    public static final RegistrationProvider<StructureSet> PROVIDER = RegistrationProvider.get(BuiltinRegistries.STRUCTURE_SETS, BYG.MOD_ID);

    public static final Holder<StructureSet> VILLAGES = register("villages", () -> new StructureSet(List.of(StructureSet.entry(BYGStructureFeatures.VILLAGE_RED_ROCK), StructureSet.entry(BYGStructureFeatures.VILLAGE_RUINS), StructureSet.entry(BYGStructureFeatures.VILLAGE_TROPICAL), StructureSet.entry(BYGStructureFeatures.VILLAGE_SKYRIS)), new RandomSpreadStructurePlacement(34, 8, RandomSpreadType.LINEAR, 437845874)));
    public static final Holder<StructureSet> ARCH = register("arches", () -> new StructureSet(List.of(StructureSet.entry(BYGStructureFeatures.RED_ROCK_ARCH), StructureSet.entry(BYGStructureFeatures.DESTROYED_RED_ROCK_ARCH)), new RandomSpreadStructurePlacement(8, 2, RandomSpreadType.LINEAR, 498548954)));
    public static final Holder<StructureSet> SEA_ARCHES = register("sea_arches", () -> new StructureSet(List.of(StructureSet.entry(BYGStructureFeatures.OVERGROWN_STONE_ARCH, 24), StructureSet.entry(BYGStructureFeatures.STONE_ARCH, 1)), new RandomSpreadStructurePlacement(5, 2, RandomSpreadType.LINEAR, 457854789)));

    private static <T extends StructureSet> Holder<T> register(String id, Supplier<? extends T> set) {
        return PROVIDER.<T>register(id, set).asHolder();
    }

    public static void bootStrap() {
        BYGStructureFeatures.loadClass();
    }
}
