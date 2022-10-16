package potionstudios.byg.datagen.providers.tag;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.StructureTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.structure.BYGStructureTags;
import potionstudios.byg.common.world.structure.BYGStructures;

public class BYGStructureTagsProvider extends StructureTagsProvider {
    public BYGStructureTagsProvider(DataGenerator gen, ExistingFileHelper existingFileHelper) {
        super(gen, BYG.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(BYGStructureTags.ON_ANCIENT_SEQUOIA_EXPLORER_MAPS).add(BYGStructures.ANCIENT_SEQUOIA.unwrapKey().orElseThrow());
    }
}
