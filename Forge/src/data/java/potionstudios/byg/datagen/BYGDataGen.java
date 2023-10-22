package potionstudios.byg.datagen;

import com.google.common.collect.Sets;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.resources.ResourceKey;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DataPackRegistriesHooks;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.BYGDamageTypes;
import potionstudios.byg.common.world.biome.BYGBiomes;
import potionstudios.byg.common.world.feature.features.BYGFeaturesUtil;
import potionstudios.byg.common.world.feature.placement.BYGPlacedFeaturesUtil;
import potionstudios.byg.common.world.preset.BYGWorldPresets;
import potionstudios.byg.common.world.structure.BYGStructureSets;
import potionstudios.byg.common.world.structure.BYGStructures;
import potionstudios.byg.common.world.structure.village.pool.StructureTemplatePoolFactory;
import potionstudios.byg.datagen.providers.BYGRecipeProviders;
import potionstudios.byg.datagen.providers.BYGWoodAssetsProvider;
import potionstudios.byg.datagen.providers.advancements.BYGAdvancementProvider;
import potionstudios.byg.datagen.providers.lang.EnUsLanguageProvider;
import potionstudios.byg.datagen.providers.loot.BYGLootTablesProvider;
import potionstudios.byg.datagen.providers.tag.*;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = BYG.MOD_ID)
public class BYGDataGen {


    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, pContext -> {
                BYGFeaturesUtil.CONFIGURED_FEATURES_FACTORIES.forEach((biomeResourceKey, factory) -> {
                    pContext.register(biomeResourceKey, factory.generate(pContext));
                });
            })
            .add(Registries.PLACED_FEATURE, pContext -> {
                BYGPlacedFeaturesUtil.PLACED_FEATURE_FACTORIES.forEach((resourceKey, factory) -> {
                    pContext.register(resourceKey, factory.generate(pContext.lookup(Registries.CONFIGURED_FEATURE)));
                });
            })
            .add(Registries.BIOME, pContext -> {
                BYGBiomes.BIOME_FACTORIES.forEach((resourceKey, factory) -> {
                    pContext.register(resourceKey, factory.generate(pContext.lookup(Registries.PLACED_FEATURE), pContext.lookup(Registries.CONFIGURED_CARVER)));

                });
            }).add(Registries.STRUCTURE, pContext -> {
                BYGStructures.STRUCTURE_FACTORIES.forEach((resourceKey, factory) -> {
                    pContext.register(resourceKey, factory.generate(pContext));

                });
            }).add(Registries.STRUCTURE_SET, pContext -> {
                BYGStructureSets.STRUCTURE_SET_FACTORIES.forEach((resourceKey, factory) -> {
                    pContext.register(resourceKey, factory.generate(pContext.lookup(Registries.STRUCTURE)));

                });
            }).add(Registries.TEMPLATE_POOL, pContext -> {
                StructureTemplatePoolFactory.STRUCTURE_TEMPLATE_POOL_FACTORIES.forEach((resourceKey, factory) -> {
                    pContext.register(resourceKey, factory.generate(pContext));

                });
            }).add(Registries.WORLD_PRESET, pContext -> {
                BYGWorldPresets.WORLD_PRESET_FACTORIES.forEach((resourceKey, factory) -> {
                    pContext.register(resourceKey, factory.generate(pContext));

                });
            }).add(Registries.DAMAGE_TYPE, pContext -> {
                BYGDamageTypes.DAMAGE_TYPE_FACTORIES.forEach((resourceKey, factory) -> {
                    pContext.register(resourceKey, factory.generate(pContext));

                });
            });

    @SubscribeEvent
    static void onDatagen(final GatherDataEvent event) {
        final var gen = event.getGenerator();
        final var existingFileHelper = event.getExistingFileHelper();

        // Server:
        gen.addProvider(event.includeServer(), new BYGLootTablesProvider(gen));
        CompletableFuture<HolderLookup.Provider> completablefuture = event.getLookupProvider().thenApply(BYGDataGen::createLookup);
//
        final var blockTags = new BYGBlockTagsProvider(completablefuture, gen , existingFileHelper);
        gen.addProvider(event.includeServer(), blockTags);
        gen.addProvider(event.includeServer(), new BYGItemTagsProvider(gen, completablefuture, blockTags.contentsGetter(), existingFileHelper));
        gen.addProvider(event.includeServer(), new BYGEntityTagsProvider(gen, completablefuture, existingFileHelper));
        gen.addProvider(event.includeServer(), new BYGBiomeTagsProvider(gen, completablefuture, existingFileHelper));
        gen.addProvider(event.includeServer(), new BYGPoiTypeTagsProvider(gen, completablefuture, existingFileHelper));
        gen.addProvider(event.includeServer(), new BYGStructureTagsProvider(gen, completablefuture, existingFileHelper));

        gen.addProvider(event.includeServer(), new BYGRecipeProviders(gen));

        gen.addProvider(event.includeServer(), new ForgeAdvancementProvider(gen.getPackOutput(), completablefuture,  existingFileHelper, List.of(new BYGAdvancementProvider())));

         //Client:
        BYGWoodAssetsProvider bygWoodAssetsProvider = new BYGWoodAssetsProvider(gen, existingFileHelper);
        gen.addProvider(event.includeServer(), bygWoodAssetsProvider);
        gen.addProvider(event.includeServer(), bygWoodAssetsProvider.getItemProvider());
        gen.addProvider(event.includeClient(), new EnUsLanguageProvider(gen));
        gen.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(gen.getPackOutput(), event.getLookupProvider(), BUILDER, Set.of(BYG.MOD_ID)));

//        StructureTemplateUtil.removeBlocks(existingFileHelper);
    }

    private static HolderLookup.Provider createLookup(final HolderLookup.Provider vanillaLookupProvider) {
        final var registryAccess = RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY);

        @SuppressWarnings("UnstableApiUsage")
        final var allKeys = DataPackRegistriesHooks.getDataPackRegistries()
                .stream()
                .map(RegistryDataLoader.RegistryData::key)
                .collect(Collectors.toSet());

        final var modKeys = Set.copyOf(BUILDER.getEntryKeys());

        final var missingKeys = Sets.difference(allKeys, modKeys);

        missingKeys.forEach(key -> BUILDER.add(
                ResourceKey.create(ResourceKey.createRegistryKey(key.registry()), key.location()),
                context -> {
                }
        ));

        return BUILDER.buildPatch(registryAccess, vanillaLookupProvider);
    }

}
