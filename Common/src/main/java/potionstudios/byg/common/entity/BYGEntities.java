package potionstudios.byg.common.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import potionstudios.byg.BYG;
import potionstudios.byg.common.entity.boat.BYGBoatEntity;
import potionstudios.byg.util.RegistryObject;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("deprecation")
public class BYGEntities {
    public static Set<RegistryObject<EntityType<?>>> ENTITIES = new HashSet<>();

    public static final EntityType<BYGBoatEntity> BOAT = createEntity("boat", EntityType.Builder.<BYGBoatEntity>of(BYGBoatEntity::new, MobCategory.MISC).sized(1.375F, 0.5625F).build(BYG.MOD_ID + ":boat"));

    //TODO: Geckolib Mojmap 1.18
//    public static final EntityType<ManOWar> MAN_O_WAR = createEntity("man_o_war", EntityType.Builder.of(ManOWar::new, MobCategory.AMBIENT).sized(0.6F, 1.75F).build(BYG.MOD_ID + ":man_o_war"));

    public static <E extends Entity, ET extends EntityType<E>> ET createEntity(String id, ET entityType) {
//        Registry.register(Registry.ENTITY_TYPE, BYG.createLocation(id), entityType);
        ENTITIES.add(new RegistryObject<>(entityType, id));
        return entityType;
    }


    public static Collection<RegistryObject<EntityType<?>>> bootStrap() {
        return ENTITIES;
    }

    static {
        BYG.LOGGER.info("BYG Entities class loaded.");
    }
}
