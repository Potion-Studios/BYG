package potionstudios.byg.common.properties;

import net.minecraft.world.item.CreativeModeTab;

public class BYGCreativeTab {
    public static CreativeModeTab CREATIVE_TAB = null;

    public static void init(CreativeModeTab creativeModeTab) {
        CREATIVE_TAB = creativeModeTab;
    }
}
