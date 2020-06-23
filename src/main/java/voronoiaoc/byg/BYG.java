package voronoiaoc.byg;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import voronoiaoc.byg.core.registries.BYGBiomeRegistry;
import voronoiaoc.byg.core.registries.BYGBlockRegistry;
import voronoiaoc.byg.core.registries.BYGItemRegistry;

public class BYG implements ModInitializer {
    public static final String MODID = "byg";
    public static Logger LOGGER = LogManager.getLogger();
    public static final ItemGroup BYG_TAB = FabricItemGroupBuilder.build(new Identifier("byg", "byg"), () -> new ItemStack(Blocks.GRASS));

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing BYG...");
        BYGBlockRegistry.registerBlocks();
        BYGItemRegistry.registerItems();
        BYGBiomeRegistry.registerBiomes();
        LOGGER.info("Initialized BYG!");

    }
}
