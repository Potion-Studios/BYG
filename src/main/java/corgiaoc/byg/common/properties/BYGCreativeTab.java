package corgiaoc.byg.common.properties;

import corgiaoc.byg.BYG;
import corgiaoc.byg.core.BYGItems;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class BYGCreativeTab {
    public static final ItemGroup creativeTab = FabricItemGroupBuilder.build(new Identifier(BYG.MOD_ID, "byg"), () -> new ItemStack(BYGItems.BYG_LOGO));

    public static void init() {
        BYG.LOGGER.debug("BYG: Item Group Created!");
    }
}
