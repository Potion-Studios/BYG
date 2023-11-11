package potionstudios.byg.datagen.providers.tag;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.StructureTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.structure.BYGStructureTags;
import potionstudios.byg.common.world.structure.BYGStructures;

import java.util.concurrent.CompletableFuture;

public class BYGStructureTagsProvider extends StructureTagsProvider {
    public BYGStructureTagsProvider(DataGenerator gen, CompletableFuture<HolderLookup.Provider> pLookupProvider, ExistingFileHelper existingFileHelper) {
        super(gen.getPackOutput(), pLookupProvider, BYG.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        this.tag(BYGStructureTags.ON_ANCIENT_SEQUOIA_EXPLORER_MAPS).add(BYGStructures.ANCIENT_SEQUOIA);
    }
}
