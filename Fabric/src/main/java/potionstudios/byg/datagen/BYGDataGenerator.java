package potionstudios.byg.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import potionstudios.byg.datagen.providers.BYGModelGenerator;
import potionstudios.byg.datagen.providers.tags.BYGBiomeTagsGenerator;
import potionstudios.byg.datagen.providers.tags.BYGBlockTagsGenerator;
import potionstudios.byg.datagen.providers.tags.BYGEntityTagsGenerator;
import potionstudios.byg.datagen.providers.tags.BYGItemTagsGenerator;

/**
 * Fabric Data Generator Entrypoint for BYG
 * @see DataGeneratorEntrypoint
 * @see FabricDataGenerator
 * @author AwesomeDude091
 * @author Joseph T. McQuigg
 */
public class BYGDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();
        pack.addProvider(BYGModelGenerator::new);
        FabricTagProvider.BlockTagProvider blockTags = pack.addProvider(BYGBlockTagsGenerator::new);
        pack.addProvider((output, completableFuture) -> new BYGItemTagsGenerator(output, completableFuture, blockTags));
        pack.addProvider(BYGBiomeTagsGenerator::new);
        pack.addProvider(BYGEntityTagsGenerator::new);
    }
}
