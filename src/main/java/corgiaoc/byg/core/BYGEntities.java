package corgiaoc.byg.core;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import corgiaoc.byg.BYG;
import corgiaoc.byg.common.entity.boat.BYGBoatEntity;
import net.minecraftforge.registries.IForgeRegistry;

public class BYGEntities {
    public static final EntityType<BYGBoatEntity> BYGBOAT = EntityType.Builder.<BYGBoatEntity>create(BYGBoatEntity::new, EntityClassification.MISC).size(1.375F, 0.5625F).build(BYG.MOD_ID + ":boat");

    public static void registerEntities(IForgeRegistry<EntityType<?>> registry) {
        registry.registerAll(
                BYGEntities.BYGBOAT.setRegistryName("boat")
        );
    }
}
