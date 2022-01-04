package potionstudios.byg;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.IForgeRegistryEntry;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.blockentity.BYGBlockEntities;
import potionstudios.byg.common.container.BYGMenuTypes;
import potionstudios.byg.common.entity.BYGEntities;
import potionstudios.byg.common.item.BYGCreativeTab;
import potionstudios.byg.common.item.BYGItems;
import potionstudios.byg.common.sound.BYGSounds;
import potionstudios.byg.common.world.biome.BYGBiomes;
import potionstudios.byg.common.world.feature.BYGFeatures;
import potionstudios.byg.util.RegistryObject;

import java.util.Collection;

@Mod(BYG.MOD_ID)

public class BYGForge {

    public BYGForge() {
        BYG.init(FMLPaths.CONFIGDIR.get());
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
        BYGBlocks.bootStrap(registryObjects -> register(Block.class, eventBus, registryObjects));
        BYGItems.bootStrap(registryObjects -> register(Item.class, eventBus, registryObjects));
        BYGEntities.bootStrap(registryObjects -> register(EntityType.class, eventBus, registryObjects));
        BYGBlockEntities.bootStrap(registryObjects -> register(BlockEntityType.class, eventBus, registryObjects));
        BYGSounds.bootStrap(registryObjects -> register(SoundEvent.class, eventBus, registryObjects));
        BYGMenuTypes.bootStrap(registryObjects -> register(MenuType.class, eventBus, registryObjects));
        BYGFeatures.bootStrap(registryObjects -> register(Feature.class, eventBus, registryObjects));
        BYGBiomes.bootStrap(registryObjects -> register(Biome.class, eventBus, registryObjects));
    }

    @SuppressWarnings("rawtypes")
    private <T extends IForgeRegistryEntry<T>> void register(Class clazz, IEventBus eventBus, Collection<RegistryObject<T>> registryObjects) {
        registryObjects.forEach(blockRegistryObject -> blockRegistryObject.object().setRegistryName(new ResourceLocation(BYG.MOD_ID, blockRegistryObject.id())));
        eventBus.addGenericListener(clazz, (RegistryEvent.Register<T> event) -> {
            for (RegistryObject<T> registryObject : registryObjects) {
                event.getRegistry().register(registryObject.object());
            }
        });
    }

    private void commonLoad(FMLCommonSetupEvent event) {
        BYG.commonLoad();
        event.enqueueWork(BYG::threadSafeCommonLoad);
    }

    private void loadFinish(FMLLoadCompleteEvent event) {
        event.enqueueWork(BYG::threadSafeLoadFinish);
    }

    private void clientLoad(FMLClientSetupEvent event) {
        BYG.clientLoad();
    }
}