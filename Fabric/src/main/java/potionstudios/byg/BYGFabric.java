package potionstudios.byg;

import corgitaco.corgilib.CorgiLibFabric;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import potionstudios.byg.common.BYGCompostables;
import potionstudios.byg.common.BYGFuels;
import potionstudios.byg.common.BYGStrippables;
import potionstudios.byg.common.block.BYGScaffoldingBlock;
import potionstudios.byg.common.entity.BYGEntities;
import potionstudios.byg.common.entity.manowar.ManOWar;
import potionstudios.byg.common.entity.npc.TradesConfig;
import potionstudios.byg.common.entity.pumpkinwarden.PumpkinWarden;
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
import java.util.Optional;

import static potionstudios.byg.BYG.createLocation;

public class BYGFabric implements ModInitializer {

    private static String firstInitialized = null;

    @Override
    public void onInitialize() {
        initializeBYG("BYG Fabric Mod Initializer");
    }

    public static void initializeBYG(String initializedFrom) {
        CorgiLibFabric.initializeCorgiLib(initializedFrom);
        Objects.requireNonNull(initializedFrom, "BYG must be told where it was initialized from.");
        if (firstInitialized != null || BYG.INITIALIZED) {
            BYG.LOGGER.debug(String.format("Attempted to Initialize Oh The Biomes You'll Go (BYG) from \"%s\" but BYG already was initialized from \"%s\", this should not be a problem.", initializedFrom, firstInitialized));
            return;
        }
        firstInitialized = initializedFrom;
        BYG.INITIALIZED = true;

        registryBootStrap();
        BYGRegistry.loadClasses();

        registerRenderers();

        BYGFuels.loadFuels(FuelRegistry.INSTANCE::add);

        CommandRegistrationCallback.EVENT.register((dispatcher, commandBuildContext, commandSelection) -> BYG.attachCommands(dispatcher, commandSelection));
        FabricNetworkHandler.init();

        BYG.LOGGER.info(String.format("Oh The Biomes You'll Go (BYG) was initialized from \"%s\"", initializedFrom));
    }

    public static void registerRenderers() {
        FabricDefaultAttributeRegistry.register(BYGEntities.MAN_O_WAR.get(), ManOWar.createAttributes());
        FabricDefaultAttributeRegistry.register(BYGEntities.PUMPKIN_WARDEN.get(), PumpkinWarden.createAttributes());
    }

    public static void afterRegistriesFreeze() {
        BYG.commonLoad();
        BYG.blockToInstanceOfReplacement(Blocks.SCAFFOLDING, BYGScaffoldingBlock.class);
        BYG.threadSafeCommonLoad();
        BYG.threadSafeLoadFinish();
        BYGCompostables.COMPOSTABLES.get().forEach(CompostingChanceRegistry.INSTANCE::add);

        registerVillagerTrades();
        BYGStrippables.strippableLogsBYG(StrippableBlockRegistry::register);
        BYG.LOGGER.info("\"Oh The Biomes You'll Go\" after registries freeze event complete!");
    }

    private static void registerVillagerTrades() {
        TradesConfig tradesConfig = TradesConfig.getConfig();
        if (tradesConfig.enabled()) {
            tradesConfig.tradesByProfession().forEach((professionKey, int2ObjectMap) -> {
                        Optional<VillagerProfession> profession = Registry.VILLAGER_PROFESSION.getOptional(professionKey);
                        if (profession.isPresent()) {
                            int2ObjectMap.forEach((level, configListing) ->
                                    TradeOfferHelper.registerVillagerOffers(profession.get(), level, itemListings ->
                                            itemListings.addAll(Arrays.asList(configListing))
                                    )
                            );
                        } else {
                            BYG.LOGGER.warn("\"%s\" is not a registered villager profession, skipping trade entry...".formatted(professionKey.toString()));
                        }
                    }
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
