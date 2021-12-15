package potionstudios.byg;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import potionstudios.byg.common.properties.BYGCreativeTab;
import potionstudios.byg.common.world.biome.BYGBiomes;
import potionstudios.byg.core.*;
import potionstudios.byg.core.world.BYGFeatures;
import potionstudios.byg.core.world.BYGMenuTypes;

public class BYGFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        BYG.init(FabricLoader.getInstance().getConfigDir());
        BYGBlocks.bootStrap(registryObjects -> registryObjects.forEach(registryObject -> Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryObject.id()), registryObject.object())));
        BYGCreativeTab.init(FabricItemGroupBuilder.build(new ResourceLocation(BYG.MOD_ID, "byg"), () -> new ItemStack(BYGItems.BYG_LOGO)));
        BYGItems.bootStrap(registryObjects -> registryObjects.forEach(registryObject -> Registry.register(Registry.ITEM, new ResourceLocation(BYG.MOD_ID, registryObject.id()), registryObject.object())));
        BYGEntities.bootStrap(registryObjects -> registryObjects.forEach(registryObject -> Registry.register(Registry.ENTITY_TYPE, new ResourceLocation(BYG.MOD_ID, registryObject.id()), registryObject.object())));
        BYGBlockEntities.bootStrap(registryObjects -> registryObjects.forEach(registryObject -> Registry.register(Registry.BLOCK_ENTITY_TYPE, new ResourceLocation(BYG.MOD_ID, registryObject.id()), registryObject.object())));
        BYGSounds.bootStrap(registryObjects -> registryObjects.forEach(registryObject -> Registry.register(Registry.SOUND_EVENT, new ResourceLocation(BYG.MOD_ID, registryObject.id()), registryObject.object())));
        BYGMenuTypes.bootStrap(registryObjects -> registryObjects.forEach(registryObject -> Registry.register(Registry.MENU, new ResourceLocation(BYG.MOD_ID, registryObject.id()), registryObject.object())));
        BYGFeatures.bootStrap(registryObjects -> registryObjects.forEach(registryObject -> Registry.register(Registry.FEATURE, new ResourceLocation(BYG.MOD_ID, registryObject.id()), registryObject.object())));
        BYGBiomes.bootStrap(registryObjects -> registryObjects.forEach(registryObject -> Registry.register(BuiltinRegistries.BIOME, new ResourceLocation(BYG.MOD_ID, registryObject.id()), registryObject.object())));
        BYG.commonLoad();
        BYG.threadSafeCommonLoad();
        BYG.threadSafeLoadFinish();
    }
}
