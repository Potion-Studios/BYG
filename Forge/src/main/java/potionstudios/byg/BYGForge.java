package potionstudios.byg;

import corgitaco.corgilib.serialization.jankson.JanksonUtil;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import potionstudios.byg.client.BYGClient;
import potionstudios.byg.client.BYGForgeClient;
import potionstudios.byg.client.textures.renders.BYGRenderTypes;
import potionstudios.byg.common.BYGCompostables;
import potionstudios.byg.common.BYGFuels;
import potionstudios.byg.common.BYGStrippables;
import potionstudios.byg.common.entity.manowar.ManOWar;
import potionstudios.byg.common.entity.pumpkinwarden.PumpkinWarden;
import potionstudios.byg.common.world.biome.BYGTerraBlenderRegion;
import potionstudios.byg.common.world.surfacerules.SurfaceRulesConfig;
import potionstudios.byg.config.SettingsConfig;
import potionstudios.byg.config.json.OverworldBiomeConfig;
import potionstudios.byg.core.BYGRegistry;
import potionstudios.byg.mixin.access.AxeItemAccess;
import potionstudios.byg.network.ForgeNetworkHandler;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

import java.util.IdentityHashMap;
import java.util.Map;

import static potionstudios.byg.common.entity.BYGEntities.MAN_O_WAR;
import static potionstudios.byg.common.entity.BYGEntities.PUMPKIN_WARDEN;

@Mod(BYG.MOD_ID)
public class BYGForge {

    public BYGForge() {
        BYG.INITIALIZED = true;
        final var modBus = FMLJavaModLoadingContext.get().getModEventBus();
//        BYGCreativeTab.init(new CreativeModeTab("byg.byg") {
//            @Override
//            public @NotNull ItemStack makeIcon() {
//                return new ItemStack(BYGItems.BYG_LOGO.get());
//            }
//
//            @Override
//            public boolean hasSearchBar() {
//                return true;
//            }
//
//            @Override
//            public boolean canScroll() {
//                return true;
//            }
//
//            @Override
//            public @NotNull ResourceLocation getBackgroundImage() {
//                return new ResourceLocation("minecraft", "textures/gui/container/creative_inventory/tab_item_search.png");
//            }
//        });

        BYGRegistry.loadClasses();
        modBus.addListener(this::createTestEntityAttributes);
        modBus.addListener(this::commonLoad);
        modBus.addListener(this::loadFinish);
        modBus.addListener(this::clientLoad);
    }

    public void createTestEntityAttributes(final EntityAttributeCreationEvent event) {
        event.put(MAN_O_WAR.get(), ManOWar.createAttributes().build());
        event.put(PUMPKIN_WARDEN.get(), PumpkinWarden.createAttributes().build());
    }

    private void commonLoad(FMLCommonSetupEvent event) {
        BYG.commonLoad();
        event.enqueueWork(BYG::threadSafeCommonLoad);
        event.enqueueWork(ForgeNetworkHandler::init);
        event.enqueueWork(this::registerTerraBlender);

        BYGFuels.loadFuels(BYGForgeBusEventsHandler.BURN_TIMES::put);
        Map<Block, Block> strippables = new IdentityHashMap<>(AxeItemAccess.byg_getStrippables());
        BYGStrippables.strippableLogsBYG(strippables::put);
        AxeItemAccess.byg_setStripables(strippables);
    }

    private void registerTerraBlender() {
        try {
            OverworldBiomeConfig config = OverworldBiomeConfig.getConfig();
            if (config.generateOverworld() && SettingsConfig.getConfig().useBYGWorldGen()) {
                Map<ResourceKey<LevelStem>, SurfaceRules.RuleSource> surfaceRulesConfig = SurfaceRulesConfig.getConfig();
                if (surfaceRulesConfig.containsKey(LevelStem.OVERWORLD) && surfaceRulesConfig.get(LevelStem.OVERWORLD) != null) {
                    SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, BYG.MOD_ID, surfaceRulesConfig.get(LevelStem.OVERWORLD));
                } else {
                    throw new IllegalStateException(String.format("Surface rules for \"%s\" are required to load. Fix the config file found at: \"%s\"", LevelStem.OVERWORLD.location(), SurfaceRulesConfig.CONFIG_PATHS.get().get(LevelStem.OVERWORLD)));
                }
                config.values().forEach(biomeProviderData -> Regions.register(new BYGTerraBlenderRegion(biomeProviderData.value(), config.globalSwapper())));
            } else {
                BYG.logInfo("BYG overworld biomes disabled.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private void loadFinish(FMLLoadCompleteEvent event) {
        event.enqueueWork(BYG::threadSafeLoadFinish);
        event.enqueueWork(() -> ComposterBlock.COMPOSTABLES.putAll(BYGCompostables.COMPOSTABLES.get()));
        // Because Forge's enqueueWork eats exceptions, we need to cache it ourselves and throw it after the fact.
        // TODO: Remove this ugly workaround once forge fixes this issue.
        if (JanksonUtil.thrown != null) {
            throw JanksonUtil.thrown;
        }
    }

    private void clientLoad(FMLClientSetupEvent event) {
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            BYGClient.load();
            BYGRenderTypes.renderTypes(blockRenderTypeMap -> blockRenderTypeMap.forEach(ItemBlockRenderTypes::setRenderLayer));
            BYGForgeClient.client();
            event.enqueueWork(BYGClient::threadSafeLoad);
        });
    }
}