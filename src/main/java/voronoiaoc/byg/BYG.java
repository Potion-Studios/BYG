package voronoiaoc.byg;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.entity.BoatEntityRenderer;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import voronoiaoc.byg.common.entity.boat.BYGBoatEntity;
import voronoiaoc.byg.common.properties.vanilla.BYGCompostables;
import voronoiaoc.byg.common.properties.vanilla.BYGFlammables;
import voronoiaoc.byg.common.properties.vanilla.BYGHoeables;
import voronoiaoc.byg.common.properties.vanilla.BYGStrippables;
import voronoiaoc.byg.core.byglists.BYGEntityList;
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
        //Registries
        BYGBlockRegistry.registerBlocks();
        BYGItemRegistry.registerItems();
        BYGBiomeRegistry.registerBiomes();

        //Misc
        BYGBiomeRegistry.addBeachesCategorically();

        //Block Settings
        BYGFlammables.flammablesBYG();
        BYGHoeables.effectiveBlocksBYG();
        BYGHoeables.tillablesBYG();
        BYGStrippables.strippableLogsBYG();
        BYGCompostables.compostablesBYG();

        //Misc
        BYGBiomeRegistry.addBeachesCategorically();
        EntityRendererRegistry.INSTANCE.register((EntityType<? extends BYGBoatEntity>) BYGEntityList.BYGBOAT, (entityRenderDispatcher, context) -> new BoatEntityRenderer(entityRenderDispatcher));

        LOGGER.info("Initialized BYG!");

    }
}
