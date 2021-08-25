package corgiaoc.byg.entrypoint;

import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.feature.blockplacer.BYGBlockPlacerTypes;
import corgiaoc.byg.core.*;
import corgiaoc.byg.core.world.*;
import corgiaoc.byg.mixin.access.FillerBlockTypeAccess;
import corgiaoc.byg.util.MLBlockTags;
import corgiaoc.byg.util.NetworkUtil;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.protocol.Packet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.blockplacers.BlockPlacerType;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Set;


public class FabricEntryPoint implements EntryPoint, ModInitializer {
    public static ResourceLocation SPAWN_PACKET_ID = new ResourceLocation(BYG.MOD_ID, "custom_spawn_packet");
    public FabricEntryPoint() {
        BYG.entryPoint = this;
        BYG.CONFIG_PATH = configDirectory();
    }


    @Override
    public void onInitialize() {
        bootStrap();
        commonSetup();
        loadComplete();
        Tag.Named<Block> dirt = MLBlockTags.DIRT;
    }

    private static void commonSetup() {
        BYG.commonLoad();
        BYG.threadSafeCommonLoad();
    }

    private void loadComplete() {
        BYG.threadSafeLoadFinish();
    }

    @Override
    public Path configDirectory() {
        return FabricLoader.getInstance().getConfigDir().resolve(BYG.MOD_ID);
    }

    @Override
    public Packet<?> getEntitySpawnPacket(Entity entity) {
        return NetworkUtil.getEntitySpawnPacket(entity);
    }

    public static void bootStrap() {
        registerBlocks();
        registerItems();
        registerEntities();
        registerTileEntities();
        registerSounds();
        registerContainers();
        registerBiomes();
        registerDecorators();
        registerStructures();
        registerFeatures();
        registerSurfaceBuilders();
        registerBlockPlacerType();
    }


    public static void registerBlocks() {
        BYG.LOGGER.debug("BYG: Registering blocks...");
        List<Block> blocksList = BYGBlocks.blocksList;
        List<Block> flowerPotBlocks = BYGBlocks.flowerPotBlocks;
        BYG.LOGGER.info("BYG: Blocks registered!");
    }

    public static void registerItems() {
        BYG.LOGGER.debug("BYG: Registering items...");
        List<Item> itemsList = BYGItems.itemsList;
        BYG.LOGGER.info("BYG: Items registered!");
    }

    public static void registerEntities() {
        BYG.LOGGER.debug("BYG: Registering entities...");
        Set<EntityType<?>> entities = BYGEntities.entities;
        BYG.LOGGER.info("BYG: Entities registered!");
    }

    public static void registerTileEntities() {
        BYG.LOGGER.debug("BYG: Registering block entities...");
        List<BlockEntityType<?>> blockEntities = BYGTileEntities.BLOCK_ENTITIES;
        BYG.LOGGER.info("BYG: Block Entities registered!");
    }

    public static void registerSounds() {
        BYG.LOGGER.debug("BYG: Registering sounds...");
        List<SoundEvent> sounds = BYGSounds.SOUNDS;
        BYG.LOGGER.info("BYG: Sounds registered!");
    }

    public static void registerContainers() {
        BYG.LOGGER.debug("BYG: Registering block entities...");
        BYGEntities.init();
        List<MenuType<?>> containerTypes = BYGContainerTypes.CONTAINER_TYPES;
        BYG.LOGGER.info("BYG: Block Entities registered!");
    }

    public static void registerBiomes() {
        BYG.LOGGER.debug("BYG: Registering biomes...");
        BYGBiomes.init();
        BYGBiomes.biomeList.sort(Comparator.comparingInt(BYGBiomes.PreserveBiomeOrder::getOrderPosition));
        BYGBiomes.CANYON_KEY = BYGBiomes.CANYON.getKey();
        BYG.LOGGER.info("BYG: Biomes registered!");
    }

    public static void registerDecorators() {
        BYG.LOGGER.debug("BYG: Registering decorators...");
        BYGDecorators.init();
        List<FeatureDecorator<?>> decorators = BYGDecorators.decorators;
        BYG.LOGGER.info("BYG: Decorators registered!");
    }

    public static void registerStructures() {
        BYG.LOGGER.debug("BYG: Registering structures...");
        BYGStructures.init();
//            BYGStructures.structures.forEach(structure -> event.getRegistry().register(structure));
//            Structure.STRUCTURE_DECORATION_STAGE_MAP.forEach(((structure, decoration) -> System.out.println(Registry.STRUCTURE_FEATURE.getKey(structure).toString())));
        BYG.LOGGER.info("BYG: Structures registered!");
    }

    public static void registerFeatures() {
        BYG.LOGGER.debug("BYG: Registering features...");
        FillerBlockTypeAccess.setNetherFillerType(new TagMatchTest(BlockTags.BASE_STONE_NETHER));
        BYGFeatures.init();
        List<Feature<?>> features = BYGFeatures.features;
        BYG.LOGGER.info("BYG: Features registered!");
    }

    public static void registerSurfaceBuilders() {
        BYG.LOGGER.debug("BYG: Registering surface builders...");
        BYGSurfaceBuilders.init();
        List<SurfaceBuilder<?>> surfaceBuilders = BYGSurfaceBuilders.surfaceBuilders;
        BYG.LOGGER.info("BYG: Surface builders Registered!");
    }

    public static void registerBlockPlacerType() {
        BYG.LOGGER.debug("BYG: Registering block placer types...");
        BYGBlockPlacerTypes.init();
        List<BlockPlacerType<?>> types = BYGBlockPlacerTypes.types;
        BYG.LOGGER.info("BYG: Registering block placer types!");
    }
}