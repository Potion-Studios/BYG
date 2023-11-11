package potionstudios.byg.datagen.providers.tag;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import potionstudios.byg.BYG;
import potionstudios.byg.common.BYGTags;
import potionstudios.byg.common.entity.BYGEntities;
import potionstudios.byg.datagen.util.DatagenUtils;

import java.util.concurrent.CompletableFuture;

public class BYGEntityTagsProvider extends EntityTypeTagsProvider {
    public BYGEntityTagsProvider(DataGenerator pGenerator, CompletableFuture<HolderLookup.Provider> pLookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator.getPackOutput(), pLookupProvider, BYG.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        final var boatTag = BYGTags.BOATS.byg(BYGTags.RegistryType.ENTITY_TYPES);
        tag(boatTag).add(BYGEntities.BOAT.get());
        tag(boatTag).add(BYGEntities.CHEST_BOAT.get());

        for (BYGTags tag : BYGTags.values()) {
            DatagenUtils.addBYGTag(this::tag, tag, Registries.ENTITY_TYPE);
        }

        DatagenUtils.sortTagsAlphabeticallyAndRemoveDuplicateTagEntries(this.builders);
    }
}
