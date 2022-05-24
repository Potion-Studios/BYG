package potionstudios.byg.datagen;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import potionstudios.byg.BYG;
import potionstudios.byg.datagen.providers.BYGWoodAssetsProvider;
import potionstudios.byg.datagen.providers.BYGBlockTagsProvider;
import potionstudios.byg.datagen.providers.BYGItemTagsProvider;
import potionstudios.byg.datagen.providers.BYGRecipeProviders;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = BYG.MOD_ID)
public class BYGDataGen {

    @SubscribeEvent
    static void onDatagen(final GatherDataEvent event) {
        final var gen = event.getGenerator();
        final var existingFileHelper = event.getExistingFileHelper();

        if (event.includeServer()) {
            final var blockTags = new BYGBlockTagsProvider(gen, existingFileHelper);
            gen.addProvider(blockTags);
            gen.addProvider(new BYGItemTagsProvider(gen, blockTags, existingFileHelper));
            gen.addProvider(new BYGRecipeProviders(gen));
        }
        if (event.includeClient()) {
            gen.addProvider(new BYGWoodAssetsProvider(gen, existingFileHelper));
        }
    }

}
