package corgiaoc.byg.core;

import corgiaoc.byg.BYG;
import corgiaoc.byg.common.entity.boat.BYGBoatEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("deprecation")
public class BYGEntities {
    public static Set<EntityType<?>> entities = new HashSet<>();

    public static final EntityType<BYGBoatEntity> BOAT = createEntity("boat", FabricEntityTypeBuilder.<BYGBoatEntity>create(SpawnGroup.MISC, BYGBoatEntity::new).dimensions(new EntityDimensions(1.375F, 0.5625F, false)).build());

    public static <E extends Entity, ET extends EntityType<E>> ET createEntity(String id, ET entityType) {
        Registry.register(Registry.ENTITY_TYPE, new Identifier(BYG.MOD_ID, id), entityType);
//        entityType.setRegistryName(new Identifier(BYG.MOD_ID, id)); //Forge
        entities.add(entityType);
        return entityType;
    }

    public static void init() {
    }
}
