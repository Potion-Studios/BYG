package potionstudios.byg;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagLoader;
import net.minecraft.world.item.ItemStack;
import potionstudios.byg.common.BYGFuels;
import potionstudios.byg.common.entity.npc.TradesConfig;
import potionstudios.byg.common.item.BYGCreativeTab;
import potionstudios.byg.common.item.BYGItems;
import potionstudios.byg.common.world.biome.end.BYGEndBiomeSource;
import potionstudios.byg.common.world.biome.nether.BYGNetherBiomeSource;
import potionstudios.byg.core.BYGRegistry;
import potionstudios.byg.network.FabricNetworkHandler;
import potionstudios.byg.world.biome.BYGFabricEndBiomeSource;
import potionstudios.byg.world.biome.BYGFabricNetherBiomeSource;

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

        registryBootStrap();
        BYGRegistry.loadClasses();

        BYG.commonLoad();
        BYG.threadSafeCommonLoad();
        BYG.threadSafeLoadFinish();
        FabricNetworkHandler.init();

        BYGFuels.loadFuels(FuelRegistry.INSTANCE::add);

        CommandRegistrationCallback.EVENT.register((dispatcher, commandBuildContext, commandSelection) -> BYG.attachCommands(dispatcher, commandSelection));

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
}
