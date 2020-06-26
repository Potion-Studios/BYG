package voronoiaoc.byg;


import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import voronoiaoc.byg.client.gui.MainMenuBYG;
import voronoiaoc.byg.client.textures.renders.BYGCutoutRenders;
import voronoiaoc.byg.common.biomes.BYGBiomeWeightSystem;
import voronoiaoc.byg.common.entity.boat.BYGBoatRenderer;
import voronoiaoc.byg.common.properties.BYGCreativeTab;
import voronoiaoc.byg.common.properties.vanilla.BYGCompostables;
import voronoiaoc.byg.common.properties.vanilla.BYGFlammables;
import voronoiaoc.byg.common.properties.vanilla.BYGHoeables;
import voronoiaoc.byg.common.properties.vanilla.BYGStrippables;
import voronoiaoc.byg.common.world.dimension.end.biome.BYGEndBiomeCatch;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeaturesInVanilla;
import voronoiaoc.byg.config.BYGConfig;
import voronoiaoc.byg.config.BYGWorldConfig;
import voronoiaoc.byg.config.biomeweight.ConfigWeightManager;
import voronoiaoc.byg.core.byglists.BYGEntityList;

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
        ConfigWeightManager.loadConfig(ConfigWeightManager.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(BYG.MOD_ID + "-weights-common.toml"));
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::bygCommonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::bygClientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::bygLoadComplete);
    }

    private void bygCommonSetup(FMLCommonSetupEvent event) {
        LOGGER.debug("BYG: \"Common Setup\" Event Starting...");
        BYGCreativeTab.init();
        BYGEndBiomeCatch.endBiomeConfigCollection();
//        BYGNetherBiomeCatch.netherBiomeConfigCollection();
        BYGFeaturesInVanilla.addFeatures();
        BYGBiomeWeightSystem.addBiomesToWeightSystem();
//        List<Structure<?>> tempList = new ArrayList<>(Feature.ILLAGER_STRUCTURES);
//        tempList.add(BYGFeatureList.BYGVILLAGE);
//        Feature.ILLAGER_STRUCTURES = ImmutableList.copyOf(tempList);
        LOGGER.info("BYG: \"Common Setup\" Event Complete!");
    }

    private void bygClientSetup(FMLClientSetupEvent event) {
        isClient = true;
        LOGGER.debug("BYG: \"Client Setup\" Event Starting...");
        BYGCutoutRenders.renderCutOuts();
        MainMenuBYG.mainMenuPanorama();
//        DimensionOverride.dimensionOverrideClient();
        RenderingRegistry.registerEntityRenderingHandler(BYGEntityList.BYGBOAT, BYGBoatRenderer::new);
        LOGGER.info("BYG: \"Client Setup\" Event Complete!");
    }

    private void bygLoadComplete(FMLLoadCompleteEvent event) {
        LOGGER.debug("BYG: \"Load Complete Event\" Starting...");
        BYGCompostables.compostablesBYG();
        BYGHoeables.hoeablesBYG();
        BYGFlammables.flammablesBYG();
        BYGStrippables.strippableLogsBYG();
//        BYGBoatDispenseRegister.dispenseBoatBehavior();
//        DimensionOverride.dimensionOverrideServerCommon();
        LOGGER.info("BYG: \"Load Complete\" Event Complete!");
    }
}