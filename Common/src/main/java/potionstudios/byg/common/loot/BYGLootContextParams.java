package potionstudios.byg.common.loot;

import net.minecraft.world.level.storage.loot.parameters.LootContextParam;
import potionstudios.byg.BYG;
import potionstudios.byg.common.entity.boat.BYGBoatEntity;

public class BYGLootContextParams {

    public static final LootContextParam<BYGBoatEntity.BYGType> BOAT_TYPE = create("boat_type");

    private static <T> LootContextParam<T> create(String name) {
        return new LootContextParam<>(BYG.createLocation(name));
    }
}
