package potionstudios.byg.datagen.providers.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalEntityTypeTags;
import net.minecraft.core.HolderLookup;
import potionstudios.byg.common.entity.BYGEntities;

import java.util.concurrent.CompletableFuture;

/**
 * Fabric Entity Tag Provider for BYG
 * @see FabricTagProvider.EntityTypeTagProvider
 * @see net.minecraft.world.entity.EntityType
 * @see net.minecraft.tags.EntityTypeTags
 * @author Joseph T. McQuigg
 */
public class BYGEntityTagsGenerator extends FabricTagProvider.EntityTypeTagProvider{
    public BYGEntityTagsGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        getOrCreateTagBuilder(ConventionalEntityTypeTags.BOATS)
                .add(BYGEntities.BOAT.get(), BYGEntities.CHEST_BOAT.get());
    }
}
