package potionstudios.byg.common.world.structure;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import potionstudios.byg.BYG;

public class BYGStructureTags {

    public static final TagKey<Structure> ON_ANCIENT_SEQUOIA_EXPLORER_MAPS = create("on_ancient_sequoia_explorer_maps");

    private static TagKey<Structure> create(String path) {
        return TagKey.create(Registries.STRUCTURE, BYG.createLocation(path));
    }

    public static void loadClass() {
    }
}
