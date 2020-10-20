package corgiaoc.byg;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import corgiaoc.byg.client.textures.renders.BYGCutoutRenders;
import corgiaoc.byg.common.entity.boat.BYGBoatRenderer;
import corgiaoc.byg.common.properties.BYGCreativeTab;
import corgiaoc.byg.common.properties.vanilla.BYGCompostables;
import corgiaoc.byg.common.properties.vanilla.BYGFlammables;
import corgiaoc.byg.common.properties.vanilla.BYGHoeables;
import corgiaoc.byg.common.properties.vanilla.BYGStrippables;
import corgiaoc.byg.common.world.biome.BYGBiome;
import corgiaoc.byg.common.world.dimension.end.BYGEndBiomeProvider;
import corgiaoc.byg.common.world.dimension.nether.BYGNetherBiomeProvider;
import corgiaoc.byg.config.BYGWorldConfig;
import corgiaoc.byg.config.biomeweight.ConfigWeightManager;
import corgiaoc.byg.config.json.BiomeDataListHolder;
import corgiaoc.byg.config.json.BiomeDataListHolderSerializer;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.BYGEntities;
import corgiaoc.byg.core.BYGItems;
import corgiaoc.byg.core.world.BYGBiomes;
import corgiaoc.byg.core.world.BYGDecorators;
import corgiaoc.byg.core.world.BYGFeatures;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import corgiaoc.byg.server.command.GenDataCommand;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

@Mod("byg")
public class BYG {
    public static final String MOD_ID = "byg";
    public static boolean isClient = false;
    public static Logger LOGGER = LogManager.getLogger();
    public static boolean isUsingMixin;
    public static String FILE_PATH = "yeet";

    public static final Path CONFIG_PATH = new File(String.valueOf(FMLPaths.CONFIGDIR.get().resolve(MOD_ID))).toPath();

    public BYG() {
        File dir = new File(CONFIG_PATH.toString());
        if (!dir.exists())
            dir.mkdir();

        BYGWorldConfig.loadConfig(BYGWorldConfig.COMMON_CONFIG, CONFIG_PATH.resolve(MOD_ID + "-world.toml"));
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadComplete);
        MinecraftForge.EVENT_BUS.register(new ForgeEvents());
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.debug("BYG: \"Common Setup\" Event Starting...");
        ConfigWeightManager.buildConfig();
        BYGCreativeTab.init();
        Registry.register(Registry.BIOME_PROVIDER_CODEC, new ResourceLocation(MOD_ID, "bygnether"), BYGNetherBiomeProvider.BYGNETHERCODEC);
        Registry.register(Registry.BIOME_PROVIDER_CODEC, new ResourceLocation(MOD_ID, "bygend"), BYGEndBiomeProvider.BYGENDCODEC);
        LOGGER.info("BYG: \"Common Setup\" Event Complete!");
        BiomeDataListHolder.fillBiomeLists();
        BYGBiomes.addBiomeEntries();
        BYGBiomes.fillBiomeDictionary();
        handleJSONConfig(CONFIG_PATH.resolve(MOD_ID + "-biomes.json"));
    }


    public static void handleJSONConfig(Path path) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(BiomeDataListHolder.class, new BiomeDataListHolderSerializer());
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.disableHtmlEscaping();
        Gson gson = gsonBuilder.create();

        final File CONFIG_FILE = new File(String.valueOf(path));

        if (!CONFIG_FILE.exists()) {
            BiomeDataListHolder.createDefaults();
            createBYGJson(path);
        }
        try (Reader reader = new FileReader(path.toString())) {
            BiomeDataListHolder biomeDataListHolder = gson.fromJson(reader, BiomeDataListHolder.class);
            if (biomeDataListHolder != null)
                BYGBiome.biomeData = biomeDataListHolder.getBiomeData();
            else
                LOGGER.error(BYG.MOD_ID + "-biomes.json could not be read");

        } catch (IOException e) {
            LOGGER.error(BYG.MOD_ID + "-biomes.json could not be read");
        }
    }

    public static void createBYGJson(Path path) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(BiomeDataListHolder.class, new BiomeDataListHolderSerializer());
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.disableHtmlEscaping();
        Gson gson = gsonBuilder.create();

        String jsonString = gson.toJson(new BiomeDataListHolder(BYGBiome.biomeData));

        try {
            Files.write(path, jsonString.getBytes());
        } catch (IOException e) {
            LOGGER.error(BYG.MOD_ID + "-biomes.json could not be created");
        }
    }

    private void clientSetup(FMLClientSetupEvent event) {
        isClient = true;
        LOGGER.debug("BYG: \"Client Setup\" Event Starting...");
        BYGCutoutRenders.renderCutOuts();
        RenderingRegistry.registerEntityRenderingHandler(BYGEntities.BOAT, BYGBoatRenderer::new);
        LOGGER.info("BYG: \"Client Setup\" Event Complete!");
    }

    private void loadComplete(FMLLoadCompleteEvent event) {
        LOGGER.debug("BYG: \"Load Complete Event\" Starting...");
        BYGCompostables.compostablesBYG();
        BYGHoeables.hoeablesBYG();
        BYGFlammables.flammablesBYG();
        BYGStrippables.strippableLogsBYG();
        cleanMemory();
        LOGGER.info("BYG: \"Load Complete\" Event Complete!");
    }

    //Minimize BYG's ram footprint.
    private static void cleanMemory() {
        BYG.LOGGER.debug("Cleaning memory...");
        BYGBlocks.flowerPotBlocks = null;
        FILE_PATH = null;
        BYG.LOGGER.debug("Cleaned memory!");
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class BYGRegistries {
        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            BYG.LOGGER.debug("BYG: Registering blocks...");
            BYGBlocks.init();
            BYG.LOGGER.info("BYG: Blocks registered!");
        }

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            BYG.LOGGER.debug("BYG: Registering items...");
            BYGItems.init();
            BYG.LOGGER.info("BYG: Items registered!");
        }

        @SubscribeEvent
        public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
            BYG.LOGGER.debug("BYG: Registering entities...");
            BYGEntities.init();
            BYG.LOGGER.info("BYG: Entities registered!");
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class BYGWorldGenRegistries {
        @SubscribeEvent
        public static void registerBiomes(RegistryEvent.Register<Biome> event) {
            BYG.LOGGER.debug("BYG: Registering biomes...");
            BYGBiomes.init();
            BYG.LOGGER.info("BYG: Biomes registered!");
        }

        @SubscribeEvent
        public static void registerDecorators(RegistryEvent.Register<Placement<?>> event) {
            BYG.LOGGER.debug("BYG: Registering decorators...");
            BYGDecorators.init();
            BYG.LOGGER.info("BYG: Decorators registered!");
        }

        @SubscribeEvent
        public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
            BYG.LOGGER.debug("BYG: Registering features...");
            BYGFeatures.init();
            BYG.LOGGER.info("BYG: Features registered!");
        }

        @SubscribeEvent
        public static void registerSurfaceBuilders(RegistryEvent.Register<SurfaceBuilder<?>> event) {
            BYG.LOGGER.debug("BYG: Registering surface builders...");
            BYGSurfaceBuilders.init();
            BYG.LOGGER.info("BYG: Surface builders Registered!");
        }
    }

    public static class ForgeEvents {
        @SubscribeEvent
        public void commandRegisterEvent(FMLServerStartingEvent event) {
            LOGGER.debug("BYG: \"Server Starting\" Event Starting...");
            GenDataCommand.dataGenCommand(event.getServer().getCommandManager().getDispatcher());
            LOGGER.info("BYG: \"Server Starting\" Event Complete!");
        }
    }
}