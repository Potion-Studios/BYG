package potionstudios.byg.common.entity;

import net.minecraft.core.Registry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import potionstudios.byg.BYG;
import potionstudios.byg.common.entity.boat.BYGBoatEntity;
import potionstudios.byg.registration.BygRegistrationProvider;
import potionstudios.byg.registration.BygRegistryObject;
import potionstudios.byg.util.RegistryObject;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("deprecation")
public class BYGEntities {
    public static final BygRegistryObject<EntityType<BYGBoatEntity>> BOAT = createEntity("boat", EntityType.Builder.<BYGBoatEntity>of(BYGBoatEntity::new, MobCategory.MISC).sized(1.375F, 0.5625F));

    //TODO: Geckolib Mojmap 1.18
//    public static final EntityType<ManOWar> MAN_O_WAR = createEntity("man_o_war", EntityType.Builder.of(ManOWar::new, MobCategory.AMBIENT).sized(0.6F, 1.75F).build(BYG.MOD_ID + ":man_o_war"));

    public static <E extends Entity> BygRegistryObject<EntityType<E>> createEntity(String id, EntityType.Builder<E> entityType) {
        return BygRegistrationProvider.INSTANCE.registerUnsafeResult(Registry.ENTITY_TYPE_REGISTRY, id, () -> entityType.build(BYG.MOD_ID + ":" + id));
    }

    public static void loadClass() {}
}
