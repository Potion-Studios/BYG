package potionstudios.byg;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.biome.Biome;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.common.entity.npc.TradesConfig;
import potionstudios.byg.common.item.BYGCreativeTab;
import potionstudios.byg.common.item.BYGItems;
import potionstudios.byg.common.world.biome.end.BYGEndBiomeSource;
import potionstudios.byg.common.world.biome.nether.BYGNetherBiomeSource;
import potionstudios.byg.core.BYGRegistry;
import potionstudios.byg.network.FabricNetworkHandler;
import potionstudios.byg.network.packet.BYGS2CPacket;
import potionstudios.byg.util.ModLoaderContext;
import potionstudios.byg.world.biome.BYGFabricEndBiomeSource;
import potionstudios.byg.world.biome.BYGFabricNetherBiomeSource;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.Objects;

import static potionstudios.byg.BYG.createLocation;

public class BYGFabric implements ModInitializer {

    private static String firstInitialized = null;

    @Override
    public void onInitialize() {
        initializeBYG("Fabric Mod Initializer");
    }

    public static void initializeBYG(String initializedFrom) {
        Objects.requireNonNull(initializedFrom, "BYG must be told where it was initialized from.");
        if (firstInitialized != null || BYG.INITIALIZED) {
            BYG.LOGGER.debug(String.format("Attempted to Initialize Oh The Biomes You'll Go (BYG) from \"%s\" but BYG already was initialized from \"%s\", this should not be a problem.", initializedFrom, firstInitialized));
            return;
        }
        firstInitialized = initializedFrom;
        BYG.INITIALIZED = true;
        BYG.MODLOADER_DATA = getModLoaderData();

        BYG.init(FabricLoader.getInstance().getConfigDir().resolve(BYG.MOD_ID), "c");

        registryBootStrap();
        BYGRegistry.loadClasses();

        BYG.commonLoad();
        BYG.threadSafeCommonLoad();
        BYG.threadSafeLoadFinish();
        FabricNetworkHandler.init();

        registerVillagerTrades();
        BYG.LOGGER.info(String.format("Oh The Biomes You'll Go (BYG) was initialized from \"%s\"", initializedFrom));
    }

    private static void registerVillagerTrades() {
        TradesConfig tradesConfig = TradesConfig.getConfig();
        if (tradesConfig.enabled()) {
            tradesConfig.tradesByProfession().forEach((villagerProfession, int2ObjectMap) ->
                int2ObjectMap.forEach((level, configListing) ->
                    TradeOfferHelper.registerVillagerOffers(villagerProfession, level, itemListings ->
                        itemListings.addAll(Arrays.asList(configListing))
                    )
                )
            );

            tradesConfig.wanderingTraderTrades().forEach(
                (level, listings) -> TradeOfferHelper.registerWanderingTraderOffers(level, itemListings -> itemListings.addAll(Arrays.asList(listings)))
            );
        } else {
            BYG.LOGGER.warn("Ignoring villager/wandering trader trades added by BYG.");
        }
    }

    private static void registryBootStrap() {
        BYGCreativeTab.init(FabricItemGroupBuilder.build(createLocation(BYG.MOD_ID), () -> new ItemStack(BYGItems.BYG_LOGO.get())));
        Registry.register(Registry.BIOME_SOURCE, BYGEndBiomeSource.LOCATION, BYGFabricEndBiomeSource.CODEC);
        Registry.register(Registry.BIOME_SOURCE, BYGNetherBiomeSource.LOCATION, BYGFabricNetherBiomeSource.CODEC);
        BYG.LOGGER.info("BYG registries bootstrapped");
    }

    @NotNull
    public static ModLoaderContext getModLoaderData() {
        return new ModLoaderContext() {
            @Override
            public Path configPath() {
                return FabricLoader.getInstance().getConfigDir();
            }

            @Override
            public boolean isModLoaded(String isLoaded) {
                return FabricLoader.getInstance().isModLoaded(isLoaded);
            }

            @Override
            public <P extends BYGS2CPacket> void sendToClient(ServerPlayer player, P packet) {
                FabricNetworkHandler.sendToPlayer(player, packet);
            }

            @Override
            public BYGNetherBiomeSource createNetherBiomeSource(Registry<Biome> biomeRegistry, long seed) {
                return new BYGFabricNetherBiomeSource(biomeRegistry, seed);
            }

            @Override
            public BYGEndBiomeSource createEndBiomeSource(Registry<Biome> biomeRegistry, long seed) {
                return new BYGFabricEndBiomeSource(biomeRegistry, seed);
            }
        };
    }
}
