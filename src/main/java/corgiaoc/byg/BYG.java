package corgiaoc.byg;


import corgiaoc.byg.common.entity.villager.BYGVillagerType;
import corgiaoc.byg.common.properties.BYGCreativeTab;
import corgiaoc.byg.common.properties.vanilla.*;
import corgiaoc.byg.common.world.dimension.end.BYGEndBiomeProvider;
import corgiaoc.byg.common.world.dimension.nether.BYGNetherBiomeProvider;
import corgiaoc.byg.common.world.feature.blockplacer.BYGBlockPlacerTypes;
import corgiaoc.byg.config.autoconfig.BYGWorldConfig;
import corgiaoc.byg.config.json.BYGJsonConfigHandler;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.BYGEntities;
import corgiaoc.byg.core.BYGItems;
import corgiaoc.byg.core.world.*;
import corgiaoc.byg.server.command.GenDataCommand;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.nio.file.Path;

public class BYG implements ModInitializer {
    public static final String MOD_ID = "byg";
    public static boolean isClient = false;
    public static Logger LOGGER = LogManager.getLogger();
    public static boolean isUsingMixin;
    public static String FILE_PATH = "yeet";

    public static final Path CONFIG_PATH = new File(String.valueOf(FabricLoader.getInstance().getConfigDirectory().toPath().resolve(MOD_ID))).toPath();
    public static Registry<Biome> EARLY_BIOME_REGISTRY_ACCESS = null;
    public static BYGWorldConfig DIMENSIONS_CONFIG;

    @Override
    public void onInitialize() {
        File dir = new File(CONFIG_PATH.toString());
        if (!dir.exists())
            dir.mkdir();

        AutoConfig.register(BYGWorldConfig.class, JanksonConfigSerializer::new);
        DIMENSIONS_CONFIG = AutoConfig.getConfigHolder(BYGWorldConfig.class).getConfig();
        BYGRegistries.registerBlocks();
        BYGRegistries.registerItems();
        BYGRegistries.registerEntities();

        BYGWorldGenRegistries.registerBiomes();
        BYGWorldGenRegistries.registerDecorators();
        BYGWorldGenRegistries.registerFeatures();
        BYGWorldGenRegistries.registerSurfaceBuilders();
        BYGWorldGenRegistries.registerBlockPlacerType();
        commonSetup();
        loadComplete();
        registerCommand();
    }

    //Minimize BYG's ram footprint.
    private static void cleanMemory() {
        BYG.LOGGER.debug("Cleaning memory...");
        BYGBlocks.flowerPotBlocks = null;
        FILE_PATH = null;
        BYG.LOGGER.debug("Cleaned memory!");
    }

    private void commonSetup() {
        LOGGER.debug("BYG: \"Common Setup\" Event Starting...");
        BYGCreativeTab.init();
        BYGJsonConfigHandler.handleOverWorldConfig(CONFIG_PATH);
        Registry.register(Registry.BIOME_SOURCE, new Identifier(MOD_ID, "byg_nether"), BYGNetherBiomeProvider.BYGNETHERCODEC);
        Registry.register(Registry.BIOME_SOURCE, new Identifier(MOD_ID, "byg_end"), BYGEndBiomeProvider.BYGENDCODEC);
        BYGVillagerType.setVillagerForBYGBiomes();
        BYGBiomes.addBiomeEntries();
        LOGGER.info("BYG: \"Common Setup\" Event Complete!");
    }

    private void loadComplete() {
        LOGGER.debug("BYG: \"Load Complete Event\" Starting...");
        BYGCompostables.compostablesBYG();
        BYGHoeables.hoeablesBYG();
        BYGFlammables.flammablesBYG();
        BYGStrippables.strippableLogsBYG();
        BYGCarvableBlocks.addCarverBlocks();
        BYGPaths.addBYGPaths();
//        cleanMemory();
        LOGGER.info("BYG: \"Load Complete\" Event Complete!");
    }

    public static class BYGRegistries {
        public static void registerBlocks() {
            BYG.LOGGER.debug("BYG: Registering blocks...");
            BYGBlocks.init();
            BYG.LOGGER.info("BYG: Blocks registered!");
        }

        public static void registerItems() {
            BYG.LOGGER.debug("BYG: Registering items...");
            BYGItems.init();
            BYG.LOGGER.info("BYG: Items registered!");
        }

        public static void registerEntities() {
            BYG.LOGGER.debug("BYG: Registering entities...");
            BYGEntities.init();
            BYG.LOGGER.info("BYG: Entities registered!");
        }
    }

    public static class BYGWorldGenRegistries {

        public static void registerBiomes() {
            BYG.LOGGER.debug("BYG: Registering biomes...");
            BYGBiomes.init();
            BYG.LOGGER.info("BYG: Biomes registered!");
        }

        public static void registerDecorators() {
            BYG.LOGGER.debug("BYG: Registering decorators...");
            BYGDecorators.init();
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
            OreFeatureConfig.Rules.NETHERRACK = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
            BYGFeatures.init();
            BYG.LOGGER.info("BYG: Features registered!");
        }

        public static void registerSurfaceBuilders() {
            BYG.LOGGER.debug("BYG: Registering surface builders...");
            BYGSurfaceBuilders.init();
            BYG.LOGGER.info("BYG: Surface builders Registered!");
        }


        public static void registerBlockPlacerType() {
            BYG.LOGGER.debug("BYG: Registering block placer types...");
            BYGBlockPlacerTypes.init();
            BYG.LOGGER.info("BYG: Registering block placer types!");
        }
    }

    public void registerCommand() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            LOGGER.debug("BYG: \"Server Starting\" Event Starting...");
            GenDataCommand.dataGenCommand(dispatcher);
            LOGGER.info("BYG: \"Server Starting\" Event Complete!");
        });
    }
}