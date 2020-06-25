package voronoiaoc.byg;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import voronoiaoc.byg.common.entity.boat.BYGBoatEntity;
import voronoiaoc.byg.common.properties.vanilla.BYGCompostables;
import voronoiaoc.byg.common.properties.vanilla.BYGFlammables;
import voronoiaoc.byg.common.properties.vanilla.BYGHoeables;
import voronoiaoc.byg.common.properties.vanilla.BYGStrippables;
import voronoiaoc.byg.core.registries.BYGBiomeRegistry;
import voronoiaoc.byg.core.registries.BYGBlockRegistry;
import voronoiaoc.byg.core.registries.BYGItemRegistry;

public class BYG implements ModInitializer {
    public static final String MODID = "byg";
    public static Logger LOGGER = LogManager.getLogger();
    public static final ItemGroup BYG_TAB = FabricItemGroupBuilder.build(new Identifier("byg", "byg"), () -> new ItemStack(Blocks.GRASS));

    public static final EntityType<BYGBoatEntity> BYGBOAT = EntityType.Builder.<BYGBoatEntity>create(BYGBoatEntity::new, SpawnGroup.MISC).setDimensions(1.375F, 0.5625F).build(BYG.MODID + ":boat");


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

        Registry.register(Registry.ENTITY_TYPE, new Identifier(MODID, "byg_boat"), BYGBOAT);
        LOGGER.info("Initialized BYG!");

    }
}
