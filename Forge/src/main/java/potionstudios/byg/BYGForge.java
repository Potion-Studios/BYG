package potionstudios.byg;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import potionstudios.byg.client.BYGClient;
import potionstudios.byg.client.BYGForgeClient;
import potionstudios.byg.client.textures.renders.BYGCutoutRenders;
import potionstudios.byg.common.item.BYGCreativeTab;
import potionstudios.byg.common.item.BYGItems;
import potionstudios.byg.common.world.biome.end.BYGEndBiomeSource;
import potionstudios.byg.common.world.biome.nether.BYGNetherBiomeSource;
import potionstudios.byg.common.world.surfacerules.SurfaceRulesConfig;
import potionstudios.byg.config.SettingsConfig;
import potionstudios.byg.config.json.BiomeDictionaryConfig;
import potionstudios.byg.config.json.OverworldBiomeConfig;
import potionstudios.byg.core.BYGRegistry;
import potionstudios.byg.network.ForgeNetworkHandler;
import potionstudios.byg.world.biome.BYGForgeEndBiomeSource;
import potionstudios.byg.world.biome.BYGForgeNetherBiomeSource;
import potionstudios.byg.world.biome.BYGTerraBlenderRegion;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

import java.util.Map;

@Mod(BYG.MOD_ID)
public class BYGForge {

    public BYGForge() {
        BYG.INITIALIZED = true;
        final var modBus = FMLJavaModLoadingContext.get().getModEventBus();
        BYGCreativeTab.init(new CreativeModeTab("byg.byg") {
            @Override
            public ItemStack makeIcon() {
                return new ItemStack(BYGItems.BYG_LOGO.get());
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

        BYGRegistry.loadClasses();

        modBus.addListener(this::commonLoad);
        modBus.addListener(this::loadFinish);
        modBus.addListener(this::clientLoad);
    }

    private void commonLoad(FMLCommonSetupEvent event) {
        BYG.commonLoad();
        event.enqueueWork(BYG::threadSafeCommonLoad);
        event.enqueueWork(ForgeNetworkHandler::init);
        event.enqueueWork(this::registerTerraBlender);
        BiomeDictionaryConfig.getConfig(true).biomeDictionary().forEach((biomeResourceKey, dictionary) -> {
            BiomeDictionary.addTypes(biomeResourceKey, dictionary.stream().map(BiomeDictionary.Type::getType).toArray(BiomeDictionary.Type[]::new));
        });
        Registry.register(Registry.BIOME_SOURCE, BYGEndBiomeSource.LOCATION, BYGForgeEndBiomeSource.CODEC);
        Registry.register(Registry.BIOME_SOURCE, BYGNetherBiomeSource.LOCATION, BYGForgeNetherBiomeSource.CODEC);
    }

    private void registerTerraBlender() {
        try {
            OverworldBiomeConfig config = OverworldBiomeConfig.getConfig(true);
            if (config.generateOverworld() && SettingsConfig.getConfig().useBYGWorldGen()) {
                Map<ResourceKey<LevelStem>, SurfaceRules.RuleSource> surfaceRulesConfig = SurfaceRulesConfig.getConfig(true);
                if (surfaceRulesConfig.containsKey(LevelStem.OVERWORLD) && surfaceRulesConfig.get(LevelStem.OVERWORLD) != null) {
                    SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, BYG.MOD_ID, surfaceRulesConfig.get(LevelStem.OVERWORLD));
                } else {
                    throw new IllegalStateException(String.format("Surface rules for \"%s\" are required to load. Fix the config file found at: \"%s\"", LevelStem.OVERWORLD.location().toString(), SurfaceRulesConfig.CONFIG_PATHS.get().get(LevelStem.OVERWORLD)));
                }
                config.values().forEach(biomeProviderData -> Regions.register(new BYGTerraBlenderRegion(biomeProviderData.value())));
            } else {
                BYG.LOGGER.info("BYG overworld biomes disabled.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private void loadFinish(FMLLoadCompleteEvent event) {
        event.enqueueWork(BYG::threadSafeLoadFinish);
    }

    private void clientLoad(FMLClientSetupEvent event) {
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            BYGClient.load();
            BYGCutoutRenders.renderCutOuts(blockRenderTypeMap -> blockRenderTypeMap.forEach(ItemBlockRenderTypes::setRenderLayer));
            BYGForgeClient.client();
            event.enqueueWork(BYGClient::threadSafeLoad);
        });
    }
}