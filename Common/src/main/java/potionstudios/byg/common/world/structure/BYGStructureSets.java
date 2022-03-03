package potionstudios.byg.common.world.structure;

import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;
import potionstudios.byg.BYG;

import java.util.List;

public class BYGStructureSets {

    public static final Holder<StructureSet> VILLAGES = register("villages", new StructureSet(List.of(StructureSet.entry(BYGStructureFeatures.VILLAGE_ADOBE), StructureSet.entry(BYGStructureFeatures.VILLAGE_RUINS), StructureSet.entry(BYGStructureFeatures.VILLAGE_TROPICAL), StructureSet.entry(BYGStructureFeatures.VILLAGE_SKYRIS)), new RandomSpreadStructurePlacement(34, 8, RandomSpreadType.LINEAR, 10387312)));


    private static Holder<StructureSet> register(String id, StructureSet set) {
        return BuiltinRegistries.register(BuiltinRegistries.STRUCTURE_SETS, BYG.createLocation(id), set);
    }

    public static void bootStrap() {
    }

    static {
        BYG.LOGGER.info("BYG Structure Sets class loaded.");
    }
}
