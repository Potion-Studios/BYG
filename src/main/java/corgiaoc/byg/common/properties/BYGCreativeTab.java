package corgiaoc.byg.common.properties;

import corgiaoc.byg.BYG;
import corgiaoc.byg.core.BYGItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class BYGCreativeTab {
    public static ItemGroup creativeTab = new ItemGroup("byg") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(BYGItems.BYG_LOGO);
        }

        @Override
        public boolean hasSearchBar() {
            return true;
        }

        @Override
        public boolean canScroll() {
            return true;
        }

        @Override
        public ResourceLocation getBackgroundImage() {
            return new ResourceLocation("minecraft", "textures/gui/container/creative_inventory/tab_item_search.png");
        }
    };

    public static void init() {
        BYG.LOGGER.debug("BYG: Item Group Created!");
    }
}
