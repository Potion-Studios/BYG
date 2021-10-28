package corgiaoc.byg.entrypoint;

import com.mojang.serialization.Codec;
import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.BYGWorldTypeThatIsntAWorldtype;
import corgiaoc.byg.common.world.feature.blockplacer.BYGBlockPlacerTypes;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.BYGEntities;
import corgiaoc.byg.core.BYGItems;
import corgiaoc.byg.core.BYGSounds;
import corgiaoc.byg.core.BYGTileEntities;
import corgiaoc.byg.core.world.BYGBiomes;
import corgiaoc.byg.core.world.BYGContainerTypes;
import corgiaoc.byg.core.world.BYGDecorators;
import corgiaoc.byg.core.world.BYGFeatures;
import corgiaoc.byg.core.world.BYGStructures;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import corgiaoc.byg.data.providers.BYGBlockTagsProvider;
import corgiaoc.byg.mixin.access.DimensionStructuresSettingsAccess;
import corgiaoc.byg.mixin.access.FillerBlockTypeAccess;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.tags.BlockTags;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.blockplacer.BlockPlacerType;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.template.TagMatchRuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.world.ForgeWorldType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.network.NetworkHooks;

import java.lang.reflect.Method;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


@Mod("byg")
@Mod.EventBusSubscriber(modid = BYG.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ForgeEntryPoint implements EntryPoint {

    public ForgeEntryPoint() {
//        NetherConfig.loadConfig(NetherConfig.COMMON_CONFIG, configDirectory().resolve(BYG.MOD_ID + "-nether.toml"));
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadComplete);
        BYG.entryPoint = this;
        BYG.CONFIG_PATH = configDirectory();
        MinecraftForge.EVENT_BUS.addListener(this::addDimensionalSpacing);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        BYG.commonLoad();
        event.enqueueWork(BYG::threadSafeCommonLoad);
    }


    private void clientSetup(FMLClientSetupEvent event) {
        BYG.clientLoad();
    }

    private void loadComplete(FMLLoadCompleteEvent event) {
        event.enqueueWork(BYG::threadSafeLoadFinish);
    }

    @Override
    public Path configDirectory() {
        return FMLPaths.CONFIGDIR.get().resolve(BYG.MOD_ID);
    }

    @Override
    public IPacket<?> getEntitySpawnPacket(Entity entity) {
        return NetworkHooks.getEntitySpawningPacket(entity);
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        BYG.LOGGER.debug("BYG: Registering blocks...");
        BYGBlocks.blocksList.forEach(block -> event.getRegistry().register(block));
        BYGBlocks.flowerPotBlocks.forEach(block -> event.getRegistry().register(block));
        BYG.LOGGER.info("BYG: Blocks registered!");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        BYG.LOGGER.debug("BYG: Registering items...");
        BYGItems.itemsList.forEach(item -> event.getRegistry().register(item));
        BYG.LOGGER.info("BYG: Items registered!");
    }

    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
        BYG.LOGGER.debug("BYG: Registering entities...");
        BYGEntities.entities.forEach(entityType -> event.getRegistry().register(entityType));
        BYG.LOGGER.info("BYG: Entities registered!");
    }

    @SubscribeEvent
    public static void registerTileEntities(RegistryEvent.Register<TileEntityType<?>> event) {
        BYG.LOGGER.debug("BYG: Registering block entities...");
        BYGTileEntities.BLOCK_ENTITIES.forEach(entityType -> event.getRegistry().register(entityType));
        BYG.LOGGER.info("BYG: Block Entities registered!");
    }

    @SubscribeEvent
    public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
        BYG.LOGGER.debug("BYG: Registering sounds...");
        BYGSounds.SOUNDS.forEach(soundEvent -> event.getRegistry().register(soundEvent));
        BYG.LOGGER.info("BYG: Sounds registered!");
    }

    @SubscribeEvent
    public static void registerContainers(RegistryEvent.Register<ContainerType<?>> event) {
        BYG.LOGGER.debug("BYG: Registering block entities...");
        BYGEntities.init();
        BYGContainerTypes.CONTAINER_TYPES.forEach(containerType -> event.getRegistry().register(containerType));
        BYG.LOGGER.info("BYG: Block Entities registered!");
    }

    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event) {
        BYG.LOGGER.debug("BYG: Registering biomes...");
        BYGBiomes.init();
        BYGBiomes.biomeList.sort(Comparator.comparingInt(BYGBiomes.PreserveBiomeOrder::getOrderPosition));
        BYGBiomes.biomeList.forEach(preserveBiomeOrder -> event.getRegistry().register(preserveBiomeOrder.getBiome()));
        BYGBiomes.CANYON_KEY = BYGBiomes.CANYON.getKey();
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
        BYGStructures.structures.forEach(structure -> event.getRegistry().register(structure));
        BYG.LOGGER.info("BYG: Structures registered!");
    }

    @SubscribeEvent
    public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
        BYG.LOGGER.debug("BYG: Registering features...");
        FillerBlockTypeAccess.setNetherFillerType(new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER));
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
        event.getRegistry().register(new BYGWorldTypeThatIsntAWorldtype().setRegistryName(new ResourceLocation(BYG.MOD_ID, "world")));
    }

    @SubscribeEvent
    public static void data(GatherDataEvent event) {
        event.getGenerator().addProvider(new BYGBlockTagsProvider(event.getGenerator(), event.getExistingFileHelper()));
    }

    private static Method GETCODEC_METHOD;
    @SuppressWarnings("unchecked cast")
    public void addDimensionalSpacing(final WorldEvent.Load event) {
        if(event.getWorld() instanceof ServerWorld){
            ServerWorld serverWorld = (ServerWorld)event.getWorld();

            /*
             * Skip Terraforged's chunk generator as they are a special case of a mod locking down their chunkgenerator.
             * They will handle your structure spacing for your if you add to WorldGenRegistries.NOISE_GENERATOR_SETTINGS in your structure's registration.
             * This here is done with reflection as this tutorial is not about setting up and using Mixins.
             * If you are using mixins, you can call the codec method with an invoker mixin instead of using reflection.
             */
            try {
                if(GETCODEC_METHOD == null) GETCODEC_METHOD = ObfuscationReflectionHelper.findMethod(ChunkGenerator.class, "func_230347_a_");
                ResourceLocation cgRL = Registry.CHUNK_GENERATOR.getKey((Codec<? extends ChunkGenerator>) GETCODEC_METHOD.invoke(serverWorld.getChunkSource().generator));
                if(cgRL != null && cgRL.getNamespace().equals("terraforged")) return;
            }
            catch(Exception e){
                BYG.LOGGER.error("Was unable to check if " + serverWorld.dimension().location() + " is using Terraforged's ChunkGenerator.");
            }

            /*
             * Prevent spawning our structure in Vanilla's superflat world as
             * people seem to want their superflat worlds free of modded structures.
             * Also that vanilla superflat is really tricky and buggy to work with in my experience.
             */
            if(serverWorld.getChunkSource().getGenerator() instanceof FlatChunkGenerator &&
                    serverWorld.dimension().equals(World.OVERWORLD)){
                return;
            }

            /*
             * putIfAbsent so people can override the spacing with dimension datapacks themselves if they wish to customize spacing more precisely per dimension.
             */
            Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkSource().generator.getSettings().structureConfig());
            for(Structure<?> structure : BYGStructures.structures) {
                tempMap.putIfAbsent(structure, DimensionStructuresSettings.DEFAULTS.get(structure));
            }
            ((DimensionStructuresSettingsAccess)serverWorld.getChunkSource().generator.getSettings()).setStructureConfig(tempMap);
        }
    }
}