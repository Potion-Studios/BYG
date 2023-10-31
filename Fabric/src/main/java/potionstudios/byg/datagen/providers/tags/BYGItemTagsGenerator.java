package potionstudios.byg.datagen.providers.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

/**
 * Fabric Item Tag Provider for BYG
 * @see FabricTagProvider.ItemTagProvider
 * @see net.minecraft.world.item.Item
 * @see net.minecraft.tags.ItemTags
 * @author Joseph T. McQuigg
 */
public class BYGItemTagsGenerator extends FabricTagProvider.ItemTagProvider {

	public BYGItemTagsGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture, @Nullable BlockTagProvider blockTagProvider) {
		super(output, completableFuture, blockTagProvider);
	}

	@Override
	protected void addTags(HolderLookup.Provider arg) {

	}
}
