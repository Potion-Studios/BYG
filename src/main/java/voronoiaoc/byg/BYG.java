package voronoiaoc.byg;


import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import net.minecraft.entity.EntityType;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import voronoiaoc.byg.client.gui.MainMenuBYG;
import voronoiaoc.byg.client.textures.renders.BYGCutoutRenders;
import voronoiaoc.byg.common.biomes.BYGBiomeWeightSystem;
import voronoiaoc.byg.common.entity.boat.BYGBoatDispenseRegister;
import voronoiaoc.byg.common.entity.boat.BYGBoatEntity;
import voronoiaoc.byg.common.entity.boat.BYGBoatRenderer;
import voronoiaoc.byg.common.properties.BYGCreativeTab;
import voronoiaoc.byg.common.properties.vanilla.BYGCompostables;
import voronoiaoc.byg.common.properties.vanilla.BYGFlammables;
import voronoiaoc.byg.common.properties.vanilla.BYGHoeables;
import voronoiaoc.byg.common.properties.vanilla.BYGStrippables;
import voronoiaoc.byg.common.world.dimension.DimensionOverride;
import voronoiaoc.byg.common.world.dimension.end.biome.BYGEndBiomeCatch;
import voronoiaoc.byg.common.world.dimension.nether.biome.BYGNetherBiomeCatch;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatures;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeaturesInVanilla;
import voronoiaoc.byg.config.BYGConfig;
import voronoiaoc.byg.config.BYGWorldConfig;
import voronoiaoc.byg.core.byglists.BYGEntityList;
import voronoiaoc.byg.core.byglists.BYGFeatureList;
import voronoiaoc.byg.server.command.BYGCommand;

import java.util.ArrayList;
import java.util.List;

@Mod("byg")
public class BYG {
    public static final String MOD_ID = "byg";
//    public static final WorldType BYGWORLDTYPE = new BYGWorldType();
    public static boolean isClient = false;
    public static Logger LOGGER = LogManager.getLogger();
    public static boolean isUsingMixin;

    public BYG() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, BYGConfig.COMMON_CONFIG);
        BYGWorldConfig.loadConfig(BYGWorldConfig.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(MOD_ID + "-world-common.toml"));
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::bygCommonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::bygClientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::bygLoadComplete);
        MinecraftForge.EVENT_BUS.register(new SubscribeEvents());
    }

    private void bygCommonSetup(FMLCommonSetupEvent event) {
        LOGGER.debug("BYG: \"Common Setup\" Event Starting...");
        BYGCreativeTab.init();
        BYGEndBiomeCatch.endBiomeConfigCollection();
        BYGNetherBiomeCatch.netherBiomeConfigCollection();
        BYGFeaturesInVanilla.addFeatures();
        BYGBiomeWeightSystem.addBiomesToWeightSystem();
        List<Structure<?>> tempList = new ArrayList<>(Feature.ILLAGER_STRUCTURES);
        tempList.add(BYGFeatureList.BYGVILLAGE);
        Feature.ILLAGER_STRUCTURES = ImmutableList.copyOf(tempList);
        LOGGER.info("BYG: \"Common Setup\" Event Complete!");
    }

    private void bygClientSetup(FMLClientSetupEvent event) {
        isClient = true;
        LOGGER.debug("BYG: \"Client Setup\" Event Starting...");
        BYGCutoutRenders.renderCutOuts();
        MainMenuBYG.mainMenuPanorama();
        DimensionOverride.dimensionOverrideClient();
        RenderingRegistry.registerEntityRenderingHandler((EntityType<? extends BYGBoatEntity>) BYGEntityList.BYGBOAT, BYGBoatRenderer::new);
        LOGGER.info("BYG: \"Client Setup\" Event Complete!");
    }

    private void bygLoadComplete(FMLLoadCompleteEvent event) {
        LOGGER.debug("BYG: \"Load Complete Event\" Starting...");
        BYGCompostables.compostablesBYG();
        BYGHoeables.hoeablesBYG();
        BYGFlammables.flammablesBYG();
        BYGStrippables.strippableLogsBYG();
//        BYGBoatDispenseRegister.dispenseBoatBehavior();
        DimensionOverride.dimensionOverrideServerCommon();
        LOGGER.info("BYG: \"Load Complete\" Event Complete!");
    }


    public static class SubscribeEvents {
        @SubscribeEvent
        public void commandRegisterEvent(FMLServerStartingEvent event) {
            BYG.LOGGER.debug("BYG: \"Server Starting\" Event Starting...");
            BYGCommand.register(event.getCommandDispatcher());
            BYG.LOGGER.info("BYG: \"Server Starting\" Event Complete!");
        }
    }
}