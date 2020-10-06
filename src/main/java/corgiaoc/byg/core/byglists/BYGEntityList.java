package corgiaoc.byg.core.byglists;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import corgiaoc.byg.BYG;
import corgiaoc.byg.common.entity.boat.BYGBoatEntity;

public class BYGEntityList {
    public static final EntityType<BYGBoatEntity> BYGBOAT = EntityType.Builder.<BYGBoatEntity>create(BYGBoatEntity::new, EntityClassification.MISC).size(1.375F, 0.5625F).build(BYG.MOD_ID + ":boat");
}
