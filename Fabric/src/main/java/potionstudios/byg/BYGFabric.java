package potionstudios.byg;

import corgitaco.corgilib.CorgiLibFabric;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.Item;
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
import potionstudios.byg.common.item.BYGItems;
import potionstudios.byg.core.BYGRegistry;
import potionstudios.byg.entry.BYGTerraBlenderEntry;
import potionstudios.byg.network.FabricNetworkHandler;
import potionstudios.byg.reg.RegistryObject;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

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
            BYG.logDebug(String.format("Attempted to Initialize Oh The Biomes You'll Go (BYG) from \"%s\" but BYG already was initialized from \"%s\", this should not be a problem.", initializedFrom, firstInitialized));
            return;
        }
        FabricItemGroup.builder(BYG.createLocation(BYG.MOD_ID)).title(Component.translatable("itemGroup.byg.byg")).icon(() -> new ItemStack(BYGItems.BYG_LOGO.get())).displayItems((pEnabledFeatures, pOutput, pDisplayOperatorCreativeTab) -> {
            for (RegistryObject<Item> entry : BYGItems.PROVIDER.getEntries()) {
                Item pItem = entry.get();

                if (pItem != BYGItems.BYG_LOGO.get()) {
                    pOutput.accept(pItem);
                }
            }
        }).build();
        firstInitialized = initializedFrom;
        BYG.INITIALIZED = true;

        registryBootStrap();
        BYGRegistry.loadClasses();

        registerEntityAttributes();

        BYGFuels.loadFuels(FuelRegistry.INSTANCE::add);

        CommandRegistrationCallback.EVENT.register((dispatcher, commandBuildContext, commandSelection) -> BYG.attachCommands(dispatcher, commandSelection));
        FabricNetworkHandler.init();

        BYG.logInfo(String.format("Oh The Biomes You'll Go (BYG) was initialized from \"%s\"", initializedFrom));
    }

    public static void registerEntityAttributes() {
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
        BYGTerraBlenderEntry.readOverworldSurfaceRules();
        BYG.logInfo("\"Oh The Biomes You'll Go\" after registries freeze event complete!");
    }

    private static void registerVillagerTrades() {
        TradesConfig tradesConfig = TradesConfig.getConfig();
        if (tradesConfig.enabled()) {
            tradesConfig.tradesByProfession().forEach((professionKey, int2ObjectMap) -> {
                        Optional<VillagerProfession> profession = BuiltInRegistries.VILLAGER_PROFESSION.getOptional(professionKey);
                        if (profession.isPresent()) {
                            int2ObjectMap.forEach((level, configListing) ->
                                    TradeOfferHelper.registerVillagerOffers(profession.get(), level, itemListings ->
                                            itemListings.addAll(Arrays.asList(configListing))
                                    )
                            );
                        } else {
                            BYG.logWarning("\"%s\" is not a registered villager profession, skipping trade entry...".formatted(professionKey.toString()));
                        }
                    }
            );

            tradesConfig.wanderingTraderTrades().forEach(
                    (level, listings) -> TradeOfferHelper.registerWanderingTraderOffers(level, itemListings -> itemListings.addAll(Arrays.asList(listings)))
            );
        } else {
            BYG.logWarning("Ignoring villager/wandering trader trades added by BYG.");
        }
    }

    private static void registryBootStrap() {
//        BYGCreativeTab.init(FabricItemGroupBuilder.build(createLocation(BYG.MOD_ID), () -> new ItemStack(BYGItems.BYG_LOGO.get())));

        BYG.logInfo("BYG registries bootstrapped");
    }
}
