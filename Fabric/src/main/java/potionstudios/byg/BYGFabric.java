package potionstudios.byg;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
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
import potionstudios.byg.util.ModLoaderContext;
import potionstudios.byg.world.biome.BYGFabricEndBiomeSource;
import potionstudios.byg.world.biome.BYGFabricNetherBiomeSource;

import java.nio.file.Path;
import java.util.function.Supplier;

import static potionstudios.byg.BYG.createLocation;

public class BYGFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        BYG.MODLOADER_DATA = new ModLoaderContext() {
            @Override
            public Path configPath() {
                return FabricLoader.getInstance().getConfigDir();
            }

            @Override
            public Supplier<SurfaceRules.RuleSource> netherRuleSource() {
                return () -> SurfaceRules.ifTrue(SurfaceRules.isBiome(ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("empty", "empty"))), SurfaceRules.state(Blocks.AIR.defaultBlockState()));
            }
        };

        BYG.init(FabricLoader.getInstance().getConfigDir().resolve(BYG.MOD_ID), "c");
        BYGBlocks.bootStrap(registryObjects -> registryObjects.forEach(registryObject -> Registry.register(Registry.BLOCK, createLocation(registryObject.id()), registryObject.object())));
        BYGCreativeTab.init(FabricItemGroupBuilder.build(createLocation(BYG.MOD_ID), () -> new ItemStack(BYGItems.BYG_LOGO)));
        BYGItems.bootStrap(registryObjects -> registryObjects.forEach(registryObject -> Registry.register(Registry.ITEM, createLocation(registryObject.id()), registryObject.object())));
        BYGEntities.bootStrap(registryObjects -> registryObjects.forEach(registryObject -> Registry.register(Registry.ENTITY_TYPE, createLocation(registryObject.id()), registryObject.object())));
        BYGBlockEntities.bootStrap(registryObjects -> registryObjects.forEach(registryObject -> Registry.register(Registry.BLOCK_ENTITY_TYPE, createLocation(registryObject.id()), registryObject.object())));
        BYGSounds.bootStrap(registryObjects -> registryObjects.forEach(registryObject -> Registry.register(Registry.SOUND_EVENT, createLocation(registryObject.id()), registryObject.object())));
        BYGMenuTypes.bootStrap(registryObjects -> registryObjects.forEach(registryObject -> Registry.register(Registry.MENU, createLocation(registryObject.id()), registryObject.object())));
        BYGFeatures.bootStrap(registryObjects -> registryObjects.forEach(registryObject -> Registry.register(Registry.FEATURE, createLocation(registryObject.id()), registryObject.object())));
        BYGBiomes.bootStrap(registryObjects -> registryObjects.forEach(registryObject -> Registry.register(BuiltinRegistries.BIOME, createLocation(registryObject.id()), registryObject.object())));
        BYGStateProviders.bootStrap().forEach(registryObject -> Registry.register(Registry.BLOCKSTATE_PROVIDER_TYPES, createLocation(registryObject.id()), registryObject.object()));
        BYGParticleTypes.bootStrap().forEach(registryObject -> Registry.register(Registry.PARTICLE_TYPE, createLocation(registryObject.id()), registryObject.object()));
        BYG.commonLoad();
        BYG.threadSafeCommonLoad();
        BYG.threadSafeLoadFinish();
        Registry.register(Registry.BIOME_SOURCE, BYGEndBiomeSource.LOCATION, BYGFabricEndBiomeSource.CODEC);
        Registry.register(Registry.BIOME_SOURCE, BYGNetherBiomeSource.LOCATION, BYGFabricNetherBiomeSource.CODEC);
    }
}
