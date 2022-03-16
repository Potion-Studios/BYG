package potionstudios.byg;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.levelgen.SurfaceRules;
import org.jetbrains.annotations.NotNull;
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
import potionstudios.byg.network.FabricNetworkHandler;
import potionstudios.byg.network.packet.BYGS2CPacket;
import potionstudios.byg.util.ModLoaderContext;
import potionstudios.byg.util.RegistryObject;
import potionstudios.byg.world.biome.BYGFabricEndBiomeSource;
import potionstudios.byg.world.biome.BYGFabricNetherBiomeSource;
import terrablender.api.SurfaceRuleManager;

import java.nio.file.Path;
import java.util.Collection;
import java.util.function.Supplier;

import static potionstudios.byg.BYG.createLocation;

public class BYGFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        BYG.MODLOADER_DATA = getModLoaderData();

        BYG.init(FabricLoader.getInstance().getConfigDir().resolve(BYG.MOD_ID), "c");
        registryBootStrap();

        BYG.commonLoad();
        BYG.threadSafeCommonLoad();
        BYG.threadSafeLoadFinish();
        FabricNetworkHandler.init();
    }

    private void registryBootStrap() {
        register(Registry.BLOCK, BYGBlocks.bootStrap());
        BYGCreativeTab.init(FabricItemGroupBuilder.build(createLocation(BYG.MOD_ID), () -> new ItemStack(BYGItems.BYG_LOGO)));
        register(Registry.ITEM, BYGItems.bootStrap());
        register(Registry.ENTITY_TYPE, BYGEntities.bootStrap());
        register(Registry.BLOCK_ENTITY_TYPE, BYGBlockEntities.bootStrap());
        register(Registry.SOUND_EVENT, BYGSounds.bootStrap());
        register(Registry.MENU, BYGMenuTypes.bootStrap());
        register(Registry.FEATURE, BYGFeatures.bootStrap());
        register(BuiltinRegistries.BIOME, BYGBiomes.bootStrap());
        register(Registry.BLOCKSTATE_PROVIDER_TYPES, BYGStateProviders.bootStrap());
        register(Registry.PARTICLE_TYPE, BYGParticleTypes.bootStrap());
        register(Registry.STRUCTURE_FEATURE, BYGStructureFeature.bootStrap());
        Registry.register(Registry.BIOME_SOURCE, BYGEndBiomeSource.LOCATION, BYGFabricEndBiomeSource.CODEC);
        Registry.register(Registry.BIOME_SOURCE, BYGNetherBiomeSource.LOCATION, BYGFabricNetherBiomeSource.CODEC);
        BYG.LOGGER.info("BYG registries bootstrapped");
    }

    public static <T> void register(Registry<T> registry, Collection<RegistryObject<T>> objects) {
        for (RegistryObject<T> object : objects) {
            Registry.register(registry, createLocation(object.id()), object.object());
        }
        BYG.LOGGER.info("BYG registered: " + registry.toString());
    }

    @NotNull
    public static ModLoaderContext getModLoaderData() {
        return new ModLoaderContext() {
            @Override
            public Path configPath() {
                return FabricLoader.getInstance().getConfigDir();
            }

            @Override
            public Supplier<SurfaceRules.RuleSource> netherRuleSource() {
                return () -> SurfaceRuleManager.getNamespacedRules(SurfaceRuleManager.RuleCategory.NETHER, BYG.EMPTY);
            }

            @Override
            public boolean isModLoaded(String isLoaded) {
                return FabricLoader.getInstance().isModLoaded(isLoaded);
            }

            @Override
            public <P extends BYGS2CPacket> void sendToClient(ServerPlayer player, P packet) {
                FabricNetworkHandler.sendToPlayer(player, packet);
            }
        };
    }
}
