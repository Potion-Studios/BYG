package potionstudios.byg.common;

import net.minecraft.world.item.Item;
import potionstudios.byg.common.item.BYGItems;

public class BYGFuels {

    public static void loadFuels(final FuelConsumer consumer) {
        consumer.add(BYGItems.ANTHRACITE_BLOCK.get(), 20000);
        consumer.add(BYGItems.ANTHRACITE.get(), 2400);
        consumer.add(BYGItems.PEAT.get(), 1200);
    }

    @FunctionalInterface
    public interface FuelConsumer {
        void add(Item item, int value);
    }
}
