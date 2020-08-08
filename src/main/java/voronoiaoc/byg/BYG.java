package voronoiaoc.byg;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import voronoiaoc.byg.common.properties.vanilla.BYGCompostables;
import voronoiaoc.byg.common.properties.vanilla.BYGFlammables;
import voronoiaoc.byg.common.properties.vanilla.BYGHoeables;
import voronoiaoc.byg.common.properties.vanilla.BYGStrippables;
import voronoiaoc.byg.common.world.dimension.end.BYGEndBiomeProvider;
import voronoiaoc.byg.common.world.dimension.nether.BYGNetherBiomeProvider;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeaturesInVanilla;
import voronoiaoc.byg.core.byglists.BYGFeatureList;
import voronoiaoc.byg.core.byglists.BYGItemList;
import voronoiaoc.byg.core.registries.BYGBiomeRegistry;
import voronoiaoc.byg.core.registries.BYGBlockRegistry;
import voronoiaoc.byg.core.registries.BYGEntityRegistry;
import voronoiaoc.byg.core.registries.BYGItemRegistry;
import voronoiaoc.byg.data.BYGDataGenerator;

import java.io.IOException;

public class BYG implements ModInitializer {
    public static final String MODID = "byg";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final ItemGroup BYG_TAB = FabricItemGroupBuilder.build(new Identifier(MODID, "byg"), () -> new ItemStack(BYGItemList.BYG_LOGO));
    static int idx = 0;

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing BYG...");
        //Registries
        BYGBlockRegistry.registerBlocks();
        BYGItemRegistry.registerItems();
        BYGFeatureList.RegisterFeatures.registerBYGFeatures();
        BYGBiomeRegistry.registerSubBiomes();
        BYGBiomeRegistry.registerBiomes();
        BYGBiomeRegistry.registerNetherBiomes();
        BYGBiomeRegistry.registerEndBiomes();
        BYGBiomeRegistry.addBiomeNumericalIDs();

        BYGEntityRegistry.registerEntities();

        //Misc
        BYGBiomeRegistry.addBeachesCategorically();
        BYGFeaturesInVanilla.addFeatures();

        BYGBiomeRegistry.addBYGBiomesToVanillaOverworld();

        //Block Settings
        BYGFlammables.flammablesBYG();
        BYGHoeables.effectiveBlocksBYG();
        BYGHoeables.tillablesBYG();
        BYGStrippables.strippableLogsBYG();
        BYGCompostables.compostablesBYG();
        Registry.register(Registry.BIOME_SOURCE, new Identifier(MODID, "byg_nether"), BYGNetherBiomeProvider.BYGNETHERCODEC);
        Registry.register(Registry.BIOME_SOURCE, new Identifier(MODID, "byg_end"), BYGEndBiomeProvider.BYGENDCODEC);

//        BYGBiomeRegistry.biomeList.forEach(biome -> {
//            idx++;
//            System.out.println(idx + ". " + BuiltinRegistries.BIOME.getId(biome).toString().replace("_", "").replace("byg:", ""));
//
//        });

        try {
            BYGDataGenerator.dataGenBiome("D:\\Coding\\BiomeJson");
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.info("Initialized BYG!");
    }
}
