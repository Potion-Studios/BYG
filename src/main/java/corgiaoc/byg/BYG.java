package corgiaoc.byg;


import corgiaoc.byg.common.properties.vanilla.*;
import corgiaoc.byg.common.world.dimension.end.BYGEndBiomeProvider;
import corgiaoc.byg.common.world.dimension.nether.BYGNetherBiomeProvider;
import corgiaoc.byg.config.autoconfig.BYGWorldConfig;
import corgiaoc.byg.config.json.BYGJsonConfigHandler;
import corgiaoc.byg.config.json.biomedata.BiomeDataListHolder;
import corgiaoc.byg.config.json.subbiomedata.SubBiomeDataListHolder;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.BYGEntities;
import corgiaoc.byg.core.BYGItems;
import corgiaoc.byg.core.world.BYGBiomes;
import corgiaoc.byg.core.world.BYGDecorators;
import corgiaoc.byg.core.world.BYGFeatures;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import corgiaoc.byg.server.command.GenDataCommand;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.nio.file.Path;
import java.util.Comparator;

public class BYG implements ModInitializer {
    public static final String MOD_ID = "byg";
    public static boolean isClient = false;
    public static Logger LOGGER = LogManager.getLogger();
    public static boolean isUsingMixin;
    public static String FILE_PATH = "yeet";
    public static final ItemGroup BYG_TAB = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "byg"), () -> new ItemStack(BYGItems.BYG_LOGO));

    public static final Path CONFIG_PATH = new File(String.valueOf(FabricLoader.getInstance().getConfigDirectory().toPath().resolve(MOD_ID))).toPath();

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
        commonSetup();
        loadComplete();
        registerCommand();
    }

    private void commonSetup() {
        LOGGER.debug("BYG: \"Common Setup\" Event Starting...");
        Registry.register(Registry.BIOME_SOURCE, new Identifier(MOD_ID, "byg_nether"), BYGNetherBiomeProvider.BYGNETHERCODEC);
        Registry.register(Registry.BIOME_SOURCE, new Identifier(MOD_ID, "byg_end"), BYGEndBiomeProvider.BYGENDCODEC);
        BYGJsonConfigHandler.handleBYGBiomesJSONConfig(CONFIG_PATH.resolve(MOD_ID + "-biomes.json"));
        BYGJsonConfigHandler.handleBYGSubBiomesJSONConfig(CONFIG_PATH.resolve(MOD_ID + "-sub-biomes.json"));
        BYGJsonConfigHandler.createReadMe(CONFIG_PATH.resolve("README.txt"));
        BYGBiomes.addBiomeEntries();
        BiomeDataListHolder.fillBiomeLists();
        SubBiomeDataListHolder.fillBiomeLists();
        LOGGER.info("BYG: \"Common Setup\" Event Complete!");
    }

    private void loadComplete() {
        LOGGER.debug("BYG: \"Load Complete Event\" Starting...");
        BYGCompostables.compostablesBYG();
        BYGHoeables.hoeablesBYG();
        BYGFlammables.flammablesBYG();
        BYGStrippables.strippableLogsBYG();
        BYGCarvableBlocks.addCarverBlocks();
        cleanMemory();
        LOGGER.info("BYG: \"Load Complete\" Event Complete!");
    }

    //Minimize BYG's ram footprint.
    private static void cleanMemory() {
        BYG.LOGGER.debug("Cleaning memory...");
//        BYGBlocks.flowerPotBlocks = null;
        FILE_PATH = null;
        BYG.LOGGER.debug("Cleaned memory!");
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
            BYGBiomes.biomeList.sort(Comparator.comparingInt(BYGBiomes.PreserveBiomeOrder::getOrderPosition));
            //We Do this to try our best to prevent shuffling biome IDs.
            BYGBiomes.biomeList.forEach(preserveBiomeOrder -> Registry.register(BuiltinRegistries.BIOME, new Identifier(MOD_ID, preserveBiomeOrder.getId()), preserveBiomeOrder.getBiome()));
            BYGBiomes.addBiomeNumericalIDs();
            BYG.LOGGER.info("BYG: Biomes registered!");
        }


        public static void registerDecorators() {
            BYG.LOGGER.debug("BYG: Registering decorators...");
            BYGDecorators.init();
            BYG.LOGGER.info("BYG: Decorators registered!");
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
    }

    public void registerCommand() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            LOGGER.debug("BYG: \"Server Starting\" Event Starting...");
            GenDataCommand.dataGenCommand(dispatcher);
            LOGGER.info("BYG: \"Server Starting\" Event Complete!");
        });
    }
}