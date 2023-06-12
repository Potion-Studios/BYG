package potionstudios.byg.common.world.structure;

import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;
import potionstudios.byg.BYG;

import java.util.List;
import java.util.Map;

public class BYGStructureSets {
    public static final Map<ResourceKey<StructureSet>, StructureSetFactory> STRUCTURE_SET_FACTORIES = new Reference2ObjectOpenHashMap<>();
    
    public static final ResourceKey<StructureSet> VILLAGES = register("villages", (structureHolderGetter) -> new StructureSet(List.of(StructureSet.entry(structureHolderGetter.getOrThrow(BYGStructures.VILLAGE_RED_ROCK)), StructureSet.entry(structureHolderGetter.getOrThrow(BYGStructures.VILLAGE_RUINS)), StructureSet.entry(structureHolderGetter.getOrThrow(BYGStructures.VILLAGE_SALEM)), StructureSet.entry(structureHolderGetter.getOrThrow(BYGStructures.PUMPKIN_PATCH)), StructureSet.entry(structureHolderGetter.getOrThrow(BYGStructures.VILLAGE_TROPICAL)), StructureSet.entry(structureHolderGetter.getOrThrow(BYGStructures.VILLAGE_SKYRIS))), new RandomSpreadStructurePlacement(34, 8, RandomSpreadType.LINEAR, 437845874)));
    public static final ResourceKey<StructureSet> ARCH = register("arches", (structureHolderGetter) -> new StructureSet(List.of(StructureSet.entry(structureHolderGetter.getOrThrow(BYGStructures.RED_ROCK_ARCH)), StructureSet.entry(structureHolderGetter.getOrThrow(BYGStructures.DESTROYED_RED_ROCK_ARCH))), new RandomSpreadStructurePlacement(8, 2, RandomSpreadType.LINEAR, 498548954)));
    public static final ResourceKey<StructureSet> SEA_ARCHES = register("sea_arches", (structureHolderGetter) -> new StructureSet(List.of(StructureSet.entry(structureHolderGetter.getOrThrow(BYGStructures.OVERGROWN_STONE_ARCH), 24), StructureSet.entry(structureHolderGetter.getOrThrow(BYGStructures.STONE_ARCH), 1)), new RandomSpreadStructurePlacement(5, 2, RandomSpreadType.LINEAR, 457854789)));
    //    public static final Holder<StructureSet> VOLCANOES = register("volcanoes", () -> new StructureSet(List.of(StructureSet.entry(BYGStructures.VOLCANO)), new RandomSpreadStructurePlacement(15, 6, RandomSpreadType.LINEAR, 98778678)));
    public static final ResourceKey<StructureSet> ANCIENT_SEQUOIA = register("ancient_sequoia", (structureHolderGetter) -> new StructureSet(List.of(StructureSet.entry(structureHolderGetter.getOrThrow(BYGStructures.ANCIENT_SEQUOIA))), new RandomSpreadStructurePlacement(80, 20, RandomSpreadType.TRIANGULAR, 983248973)));

    private static ResourceKey<StructureSet> register(String id, StructureSetFactory factory) {
        ResourceKey<StructureSet> structureSetResourceKey = ResourceKey.create(Registries.STRUCTURE_SET, BYG.createLocation(id));
        STRUCTURE_SET_FACTORIES.put(structureSetResourceKey, factory);
        return structureSetResourceKey;
    }

    public static void bootStrap() {
        BYGStructures.loadClass();
    }

    @FunctionalInterface
    public interface StructureSetFactory {

        StructureSet generate(HolderGetter<Structure> placedFeatureHolderGetter);
    }
}
