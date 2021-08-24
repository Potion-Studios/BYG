package corgiaoc.byg.common.properties;

import corgiaoc.byg.BYG;
import corgiaoc.byg.core.BYGItems;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class BYGCreativeTab {
    public static final CreativeModeTab CREATIVE_TAB = FabricItemGroupBuilder.build(new ResourceLocation(BYG.MOD_ID, "byg"), () -> new ItemStack(BYGItems.BYG_LOGO));

    public static void init() {
        BYG.LOGGER.debug("BYG: Item Group Created!");
    }
}
