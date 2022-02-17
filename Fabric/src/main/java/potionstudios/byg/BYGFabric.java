package potionstudios.byg;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.item.ItemStack;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.blockentity.BYGBlockEntities;
import potionstudios.byg.common.container.BYGMenuTypes;
import potionstudios.byg.common.entity.BYGEntities;
import potionstudios.byg.common.item.BYGCreativeTab;
import potionstudios.byg.common.item.BYGItems;
import potionstudios.byg.common.sound.BYGSounds;
import potionstudios.byg.common.world.biome.BYGBiomes;
import potionstudios.byg.common.world.feature.BYGFeatures;
import potionstudios.byg.util.ModLoaderContext;

import java.nio.file.Path;

public class BYGFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        BYG.MODLOADER_DATA = new ModLoaderContext() {
            @Override
            public Path configPath() {
                return FabricLoader.getInstance().getConfigDir();
            }
        };

        BYG.init(FabricLoader.getInstance().getConfigDir().resolve(BYG.MOD_ID), "c");
        BYGBlocks.bootStrap(registryObjects -> registryObjects.forEach(registryObject -> Registry.register(Registry.BLOCK, BYG.createLocation(registryObject.id()), registryObject.object())));
        BYGCreativeTab.init(FabricItemGroupBuilder.build(BYG.createLocation(BYG.MOD_ID), () -> new ItemStack(BYGItems.BYG_LOGO)));
        BYGItems.bootStrap(registryObjects -> registryObjects.forEach(registryObject -> Registry.register(Registry.ITEM, BYG.createLocation(registryObject.id()), registryObject.object())));
        BYGEntities.bootStrap(registryObjects -> registryObjects.forEach(registryObject -> Registry.register(Registry.ENTITY_TYPE, BYG.createLocation(registryObject.id()), registryObject.object())));
        BYGBlockEntities.bootStrap(registryObjects -> registryObjects.forEach(registryObject -> Registry.register(Registry.BLOCK_ENTITY_TYPE, BYG.createLocation(registryObject.id()), registryObject.object())));
        BYGSounds.bootStrap(registryObjects -> registryObjects.forEach(registryObject -> Registry.register(Registry.SOUND_EVENT, BYG.createLocation(registryObject.id()), registryObject.object())));
        BYGMenuTypes.bootStrap(registryObjects -> registryObjects.forEach(registryObject -> Registry.register(Registry.MENU, BYG.createLocation(registryObject.id()), registryObject.object())));
        BYGFeatures.bootStrap(registryObjects -> registryObjects.forEach(registryObject -> Registry.register(Registry.FEATURE, BYG.createLocation(registryObject.id()), registryObject.object())));
        BYGBiomes.bootStrap(registryObjects -> registryObjects.forEach(registryObject -> Registry.register(BuiltinRegistries.BIOME, BYG.createLocation(registryObject.id()), registryObject.object())));
        BYG.commonLoad();
        BYG.threadSafeCommonLoad();
        BYG.threadSafeLoadFinish();
    }
}
