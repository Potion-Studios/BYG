package voronoiaoc.byg.core.byglists;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import voronoiaoc.byg.common.entity.boat.BYGBoatEntity;

public class BYGEntityList {
    public static final EntityType<BYGBoatEntity> BYGBOAT = FabricEntityTypeBuilder.<BYGBoatEntity>create(MobCategory.MISC, BYGBoatEntity::new).dimensions(new EntityDimensions(1.375F, 0.5625F, false)).build();
}
