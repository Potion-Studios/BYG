package potionstudios.byg;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import potionstudios.byg.client.textures.renders.BYGCutoutRenders;
import potionstudios.byg.client.textures.renders.BYGParticleTypes;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.blockentity.BYGBlockEntities;
import potionstudios.byg.common.container.BYGMenuTypes;
import potionstudios.byg.common.entity.BYGEntities;
import potionstudios.byg.common.item.BYGCreativeTab;
import potionstudios.byg.common.item.BYGItems;
import potionstudios.byg.common.sound.BYGSounds;
import potionstudios.byg.common.world.biome.BYGBiomes;
import potionstudios.byg.common.world.biome.end.BYGEndBiomeSource;
import potionstudios.byg.common.world.biome.nether.BYGNetherBiomeSource;
import potionstudios.byg.common.world.feature.BYGFeatures;
import potionstudios.byg.common.world.feature.stateproviders.BYGStateProviders;
import potionstudios.byg.common.world.structure.BYGStructureFeature;
import potionstudios.byg.config.json.BiomeDictionaryConfig;
import potionstudios.byg.config.json.OverworldBiomeConfig;
import potionstudios.byg.util.ModLoaderContext;
import potionstudios.byg.util.RegistryObject;
import potionstudios.byg.world.biome.BYGForgeEndBiomeSource;
import potionstudios.byg.world.biome.BYGForgeNetherBiomeSource;
import potionstudios.byg.world.biome.BYGRegion;
import terrablender.api.Regions;

import java.nio.file.Path;
import java.util.Collection;
import java.util.function.Supplier;

@Mod(BYG.MOD_ID)
public class BYGForge {

    public BYGForge() {
        BYG.MODLOADER_DATA = new ModLoaderContext() {
            @Override
            public Path configPath() {
                return FMLPaths.CONFIGDIR.get();
            }

            @Override
            public Supplier<SurfaceRules.RuleSource> netherRuleSource() {
                return () -> SurfaceRules.ifTrue(SurfaceRules.isBiome(ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("empty", "empty"))), SurfaceRules.state(Blocks.AIR.defaultBlockState()));
            }
        };
        BYG.init(FMLPaths.CONFIGDIR.get().resolve(BYG.MOD_ID), "forge");
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BYGCreativeTab.init(new CreativeModeTab("byg.byg") {
            @Override
            public ItemStack makeIcon() {
                return new ItemStack(BYGItems.BYG_LOGO);
            }

            @Override
            public boolean hasSearchBar() {
                return true;
            }

            @Override
            public boolean canScroll() {
                return true;
            }

            @Override
            public ResourceLocation getBackgroundImage() {
                return new ResourceLocation("minecraft", "textures/gui/container/creative_inventory/tab_item_search.png");
            }
        });
        bootStrap(eventBus);

        eventBus.addListener(this::commonLoad);
        eventBus.addListener(this::loadFinish);
        eventBus.addListener(this::clientLoad);
    }

    private void bootStrap(IEventBus eventBus) {
        register(Block.class, eventBus, () -> BYGBlocks.bootStrap());
        register(Item.class, eventBus, () -> BYGItems.bootStrap());
        register(EntityType.class, eventBus, () -> BYGEntities.bootStrap());
        register(BlockEntityType.class, eventBus, () -> BYGBlockEntities.bootStrap());
        register(SoundEvent.class, eventBus, () -> BYGSounds.bootStrap());
        register(MenuType.class, eventBus, () -> BYGMenuTypes.bootStrap());
        register(Feature.class, eventBus, () -> BYGFeatures.bootStrap());
        register(Biome.class, eventBus, () -> BYGBiomes.bootStrap());
        register(BlockStateProviderType.class, eventBus, () -> BYGStateProviders.bootStrap());
        register(ParticleType.class, eventBus, () -> BYGParticleTypes.bootStrap());
        register(StructureFeature.class, eventBus, () -> BYGStructureFeature.bootStrap());
    }

    @SuppressWarnings("rawtypes")
    private <T extends IForgeRegistryEntry<T>> void register(Class clazz, IEventBus eventBus, Supplier<Collection<RegistryObject<T>>> registryObjectsSupplier) {
        eventBus.addGenericListener(clazz, (RegistryEvent.Register<T> event) -> {
            Collection<RegistryObject<T>> registryObjects = registryObjectsSupplier.get();
            IForgeRegistry<T> registry = event.getRegistry();
            for (RegistryObject<T> registryObject : registryObjects) {
                registryObject.object().setRegistryName(BYG.createLocation(registryObject.id()));
                registry.register(registryObject.object());
            }
            BYG.LOGGER.info("BYG registered: " + registry.getRegistryName());
        });
    }

    private void commonLoad(FMLCommonSetupEvent event) {
        BYG.commonLoad();
        event.enqueueWork(BYG::threadSafeCommonLoad);
        event.enqueueWork(() -> {
            OverworldBiomeConfig config = OverworldBiomeConfig.getConfig(true);
            if (config.generateOverworld()) {
                config.values().forEach(biomeProviderData -> {
                    Regions.register(new BYGRegion(biomeProviderData.overworldWeight(), biomeProviderData.oceans(), biomeProviderData.middleBiomes(), biomeProviderData.middleBiomesVariant(), biomeProviderData.plateauBiomes(), biomeProviderData.plateauBiomesVariant(), biomeProviderData.shatteredBiomes(), biomeProviderData.swapper()));
                });
            } else {
                BYG.LOGGER.info("BYG overworld biomes disabled.");
            }
        });
        BiomeDictionaryConfig.getConfig(true).biomeDictionary().forEach((biomeResourceKey, dictionary) -> {
            BiomeDictionary.addTypes(biomeResourceKey, dictionary.stream().map(BiomeDictionary.Type::getType).toArray(BiomeDictionary.Type[]::new));
        });
        Registry.register(Registry.BIOME_SOURCE, BYGEndBiomeSource.LOCATION, BYGForgeEndBiomeSource.CODEC);
        Registry.register(Registry.BIOME_SOURCE, BYGNetherBiomeSource.LOCATION, BYGForgeNetherBiomeSource.CODEC);
    }

    private void loadFinish(FMLLoadCompleteEvent event) {
        event.enqueueWork(BYG::threadSafeLoadFinish);
    }

    private void clientLoad(FMLClientSetupEvent event) {
        BYG.clientLoad();
        BYGCutoutRenders.renderCutOuts(blockRenderTypeMap -> blockRenderTypeMap.forEach(ItemBlockRenderTypes::setRenderLayer));
    }
}