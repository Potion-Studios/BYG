package potionstudios.byg.datagen.providers.tag;

import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import potionstudios.byg.BYG;
import potionstudios.byg.common.BYGTags;
import potionstudios.byg.common.entity.BYGEntities;
import potionstudios.byg.datagen.util.DatagenUtils;

public class BYGEntityTagsProvider extends EntityTypeTagsProvider {
    public BYGEntityTagsProvider(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, BYG.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        final var boatTag = BYGTags.BOATS.byg(BYGTags.RegistryType.ENTITY_TYPES);
        tag(boatTag).add(BYGEntities.BOAT.get());
        tag(boatTag).add(BYGEntities.CHEST_BOAT.get());

        for (BYGTags tag : BYGTags.values()) {
            DatagenUtils.addBYGTag(this::tag, tag, Registry.ENTITY_TYPE_REGISTRY);
        }

        DatagenUtils.sortTagsAlphabeticallyAndRemoveDuplicateTagEntries(this.builders);
    }
}
