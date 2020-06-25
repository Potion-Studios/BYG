package voronoiaoc.byg.core.byglists;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.common.entity.boat.BYGBoatEntity;

public class BYGEntityList {
    public static final EntityType<BYGBoatEntity> BYGBOAT = EntityType.Builder.<BYGBoatEntity>create(BYGBoatEntity::new, SpawnGroup.MISC).setDimensions(1.375F, 0.5625F).build(BYG.MODID + ":boat");
}
