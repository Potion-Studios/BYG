package potionstudios.byg.common.loot;

import net.minecraft.world.level.storage.loot.parameters.LootContextParam;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlockFamily;

public class BYGLootContextParams {

    public static final LootContextParam<BYGBlockFamily> BOAT_TYPE = create("boat_type");

    private static <T> LootContextParam<T> create(String name) {
        return new LootContextParam<>(BYG.createLocation(name));
    }
}
