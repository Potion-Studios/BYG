package potionstudios.byg.datagen.providers.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

/**
 * Fabric Block Tag Provider for BYG
 * @see FabricTagProvider.BlockTagProvider
 * @see net.minecraft.world.level.block.Block
 * @see net.minecraft.tags.BlockTags
 * @author Joseph T. McQuigg
 */
public class BYGBlockTagsGenerator extends FabricTagProvider.BlockTagProvider {

	public BYGBlockTagsGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void addTags(HolderLookup.Provider arg) {

	}
}
