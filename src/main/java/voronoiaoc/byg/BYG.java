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
import voronoiaoc.byg.core.byglists.BYGItemList;
import voronoiaoc.byg.core.registries.BYGBiomeRegistry;
import voronoiaoc.byg.core.registries.BYGBlockRegistry;
import voronoiaoc.byg.core.registries.BYGItemRegistry;

public class BYG implements ModInitializer {
    public static final String MODID = "byg";
    public static Logger LOGGER = LogManager.getLogger();
    public static final ItemGroup BYG_TAB = FabricItemGroupBuilder.build(new Identifier(MODID,"byg"), () -> new ItemStack(BYGItemList.BYG_LOGO));
    static int idx = 0;

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing BYG...");
        //Registries
        BYGBlockRegistry.registerBlocks();
        BYGItemRegistry.registerItems();
        BYGBiomeRegistry.registerSubBiomes();
//        BYGBiomeRegistry.registerBiomes();

        //Misc
        BYGBiomeRegistry.addBeachesCategorically();

        //Block Settings
        BYGFlammables.flammablesBYG();
        BYGHoeables.effectiveBlocksBYG();
        BYGHoeables.tillablesBYG();
        BYGStrippables.strippableLogsBYG();
        BYGCompostables.compostablesBYG();

        BYGBiomeRegistry.biomeList.forEach(biome -> {
            idx++;
            System.out.println(idx + ". " + Registry.BIOME.getId(biome).toString() + " ID #: " + Registry.BIOME.getRawId(biome));

        });
        LOGGER.info("Initialized BYG!");
    }
}
