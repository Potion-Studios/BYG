package potionstudios.byg.common.item;

import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import potionstudios.byg.BYG;

public class BYGItemTags {

    public static final TagKey<Item> STICKS = byg("sticks");

    private static TagKey<Item> byg(String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, BYG.createLocation(path));
    }
}
