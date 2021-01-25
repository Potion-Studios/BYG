package corgiaoc.byg;


import corgiaoc.byg.client.textures.renders.BYGCutoutRenders;
import corgiaoc.byg.common.entity.boat.BYGBoatRenderer;
import corgiaoc.byg.common.entity.villager.BYGVillagerType;
import corgiaoc.byg.common.properties.BYGCreativeTab;
import corgiaoc.byg.common.properties.vanilla.*;
import corgiaoc.byg.common.world.BYGWorldTypeThatIsntAWorldtype;
import corgiaoc.byg.common.world.dimension.end.BYGEndBiomeProvider;
import corgiaoc.byg.common.world.dimension.nether.BYGNetherBiomeProvider;
import corgiaoc.byg.common.world.feature.blockplacer.BYGBlockPlacerTypes;
import corgiaoc.byg.config.BYGWorldConfig;
import corgiaoc.byg.config.json.BYGJsonConfigHandler;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.BYGEntities;
import corgiaoc.byg.core.BYGItems;
import corgiaoc.byg.core.world.*;
import corgiaoc.byg.server.command.GenDataCommand;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.blockplacer.BlockPlacerType;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.template.TagMatchRuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.world.ForgeWorldType;
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
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.nio.file.Path;
import java.util.Comparator;

@Mod("byg")
public class BYG {
    public static final String MOD_ID = "byg";
    public static boolean isClient = false;
    public static Logger LOGGER = LogManager.getLogger();
    public static boolean isUsingMixin;
    public static String FILE_PATH = "yeet";

    public static final Path CONFIG_PATH = new File(String.valueOf(FMLPaths.CONFIGDIR.get().resolve(MOD_ID))).toPath();

    public static Registry<Biome> EARLY_BIOME_REGISTRY_ACCESS = null;

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
        BYGCreativeTab.init();
        BYGJsonConfigHandler.handleOverWorldConfig(CONFIG_PATH);
        event.enqueueWork(() -> {
            Registry.register(Registry.BIOME_PROVIDER_CODEC, new ResourceLocation(MOD_ID, "bygnether"), BYGNetherBiomeProvider.BYGNETHERCODEC);
            Registry.register(Registry.BIOME_PROVIDER_CODEC, new ResourceLocation(MOD_ID, "bygend"), BYGEndBiomeProvider.BYGENDCODEC);
            BYGVillagerType.setVillagerForBYGBiomes();
            BYGBiomes.addBiomeEntries();
            BYGBiomes.fillBiomeDictionary();
        });

        LOGGER.info("BYG: \"Common Setup\" Event Complete!");
    }

    private void clientSetup(FMLClientSetupEvent event) {
        isClient = true;
        LOGGER.debug("BYG: \"Client Setup\" Event Starting...");
        BYGCutoutRenders.renderCutOuts();
        RenderingRegistry.registerEntityRenderingHandler(BYGEntities.BOAT, BYGBoatRenderer::new);
        LOGGER.info("BYG: \"Client Setup\" Event Complete!");
    }

    private void loadComplete(FMLLoadCompleteEvent event) {
        event.enqueueWork(() -> {
            LOGGER.debug("BYG: \"Load Complete Event\" Starting...");
            BYGCompostables.compostablesBYG();
            BYGHoeables.hoeablesBYG();
            BYGFlammables.flammablesBYG();
            BYGStrippables.strippableLogsBYG();
            BYGCarvableBlocks.addCarverBlocks();
            BYGPaths.addBYGPaths();
            cleanMemory();
            LOGGER.info("BYG: \"Load Complete\" Event Complete!");
        });
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
            BYGBlocks.blocksList.forEach(block -> event.getRegistry().register(block));
            BYGBlocks.flowerPotBlocks.forEach(block -> event.getRegistry().register(block));
            BYG.LOGGER.info("BYG: Blocks registered!");
        }

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            BYG.LOGGER.debug("BYG: Registering items...");
            BYGItems.init();
            BYGItems.itemsList.forEach(item -> event.getRegistry().register(item));
            BYG.LOGGER.info("BYG: Items registered!");
        }

        @SubscribeEvent
        public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
            BYG.LOGGER.debug("BYG: Registering entities...");
            BYGEntities.init();
            BYGEntities.entities.forEach(entityType -> event.getRegistry().register(entityType));
            BYG.LOGGER.info("BYG: Entities registered!");
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class BYGWorldGenRegistries {

        @SubscribeEvent
        public static void registerBiomes(RegistryEvent.Register<Biome> event) {
            BYG.LOGGER.debug("BYG: Registering biomes...");
            BYGBiomes.init();
            BYGBiomes.biomeList.sort(Comparator.comparingInt(BYGBiomes.PreserveBiomeOrder::getOrderPosition));
            BYGBiomes.biomeList.forEach(preserveBiomeOrder -> event.getRegistry().register(preserveBiomeOrder.getBiome()));
            BYG.LOGGER.info("BYG: Biomes registered!");
        }

        @SubscribeEvent
        public static void registerDecorators(RegistryEvent.Register<Placement<?>> event) {
            BYG.LOGGER.debug("BYG: Registering decorators...");
            BYGDecorators.init();
            BYGDecorators.decorators.forEach(decorator -> event.getRegistry().register(decorator));
            BYG.LOGGER.info("BYG: Decorators registered!");
        }

        @SubscribeEvent
        public static void registerStructures(RegistryEvent.Register<Structure<?>> event) {
            BYG.LOGGER.debug("BYG: Registering structures...");
            BYGStructures.init();
//            BYGStructures.structures.forEach(structure -> event.getRegistry().register(structure));
//            Structure.STRUCTURE_DECORATION_STAGE_MAP.forEach(((structure, decoration) -> System.out.println(Registry.STRUCTURE_FEATURE.getKey(structure).toString())));
            BYG.LOGGER.info("BYG: Structures registered!");
        }

        @SubscribeEvent
        public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
            BYG.LOGGER.debug("BYG: Registering features...");
            OreFeatureConfig.FillerBlockType.NETHERRACK = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
            BYGFeatures.init();
            BYGFeatures.features.forEach(feature -> event.getRegistry().register(feature));
            BYG.LOGGER.info("BYG: Features registered!");
        }

        @SubscribeEvent
        public static void registerSurfaceBuilders(RegistryEvent.Register<SurfaceBuilder<?>> event) {
            BYG.LOGGER.debug("BYG: Registering surface builders...");
            BYGSurfaceBuilders.init();
            BYGSurfaceBuilders.surfaceBuilders.forEach(surfaceBuilder -> event.getRegistry().register(surfaceBuilder));
            BYG.LOGGER.info("BYG: Surface builders Registered!");
        }


        @SubscribeEvent
        public static void registerBlockPlacerType(RegistryEvent.Register<BlockPlacerType<?>> event) {
            BYG.LOGGER.debug("BYG: Registering block placer types...");
            BYGBlockPlacerTypes.init();
            BYGBlockPlacerTypes.types.forEach(type -> event.getRegistry().register(type));
            BYG.LOGGER.info("BYG: Registering block placer types!");
        }

        //Only for terraforged usage and not player's.
        @SubscribeEvent
        public static void registerWorldtype(RegistryEvent.Register<ForgeWorldType> event) {
            event.getRegistry().register(new BYGWorldTypeThatIsntAWorldtype().setRegistryName(new ResourceLocation(MOD_ID, "world")));
        }
    }

    public static class ForgeEvents {
        @SubscribeEvent
        public void commandRegisterEvent(FMLServerStartingEvent event) {
            LOGGER.debug("BYG: \"Server Starting\" Event Starting...");
            GenDataCommand.dataGenCommand(event.getServer().getCommandManager().getDispatcher());
            LOGGER.info("BYG: \"Server Starting\" Event Complete!");
        }

//        @SubscribeEvent
//        public void addDimensionalSpacing(final WorldEvent.Load event) {
//            LOGGER.debug("BYG: \"World Load\" Event Starting...");
//            if(event.getWorld() instanceof ServerWorld){
//                ServerWorld serverWorld = (ServerWorld)event.getWorld();
//
//                // Prevent spawning our structure in Vanilla's superflat world as
//                // people seem to want their superflat worlds free of modded structures.
//                // Also that vanilla superflat is really tricky and buggy to work with in my experience.
//                if(serverWorld.getChunkProvider().getChunkGenerator() instanceof FlatChunkGenerator &&
//                        serverWorld.getDimensionKey().equals(World.OVERWORLD)){
//                    return;
//                }
//
//                Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkProvider().generator.func_235957_b_().func_236195_a_());
//                tempMap.put(BYGStructures.VOLCANO_STRUCTURE, DimensionStructuresSettings.field_236191_b_.get(BYGStructures.VOLCANO_STRUCTURE));
//                serverWorld.getChunkProvider().generator.func_235957_b_().field_236193_d_ = tempMap;
//            }
//            LOGGER.info("BYG: \"World Load\" Event Complete!");
//        }
    }
}