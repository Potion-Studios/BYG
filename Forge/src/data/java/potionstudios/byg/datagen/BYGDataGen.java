package potionstudios.byg.datagen;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import potionstudios.byg.BYG;
import potionstudios.byg.datagen.providers.advancements.BYGAdvancementProvider;
import potionstudios.byg.datagen.providers.lang.EnUsLanguageProvider;
import potionstudios.byg.datagen.providers.loot.BYGLootTablesProvider;
import potionstudios.byg.datagen.providers.tag.BYGBiomeTagsProvider;
import potionstudios.byg.datagen.providers.BYGWoodAssetsProvider;
import potionstudios.byg.datagen.providers.tag.BYGBlockTagsProvider;
import potionstudios.byg.datagen.providers.tag.BYGEntityTagsProvider;
import potionstudios.byg.datagen.providers.tag.BYGItemTagsProvider;
import potionstudios.byg.datagen.providers.BYGRecipeProviders;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = BYG.MOD_ID)
public class BYGDataGen {

    @SubscribeEvent
    static void onDatagen(final GatherDataEvent event) {
        final var gen = event.getGenerator();
        final var existingFileHelper = event.getExistingFileHelper();

        if (event.includeServer()) {
            gen.addProvider(new BYGLootTablesProvider(gen));
            final var blockTags = new BYGBlockTagsProvider(gen, existingFileHelper);
            gen.addProvider(blockTags);
            gen.addProvider(new BYGItemTagsProvider(gen, blockTags, existingFileHelper));
            gen.addProvider(new BYGEntityTagsProvider(gen, existingFileHelper));
            gen.addProvider(new BYGBiomeTagsProvider(gen, existingFileHelper));
            gen.addProvider(new BYGRecipeProviders(gen));

            gen.addProvider(new BYGAdvancementProvider(gen, existingFileHelper));
        }
        if (event.includeClient()) {
            gen.addProvider(new BYGWoodAssetsProvider(gen, existingFileHelper));
            gen.addProvider(new EnUsLanguageProvider(gen));
        }
    }

}
