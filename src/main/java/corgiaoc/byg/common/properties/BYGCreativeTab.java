package corgiaoc.byg.common.properties;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import corgiaoc.byg.BYG;
import corgiaoc.byg.core.byglists.BYGItemList;

public class BYGCreativeTab {
    public static ItemGroup creativeTab = new ItemGroup("byg") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(BYGItemList.BYG_LOGO);
        }

        @Override
        public boolean hasSearchBar() {
            return true;
        }

        @Override
        public boolean hasScrollbar() {
            return true;
        }
    };

    public static void init() {
        BYG.LOGGER.debug("BYG: Item Group Created!");
    }
}
