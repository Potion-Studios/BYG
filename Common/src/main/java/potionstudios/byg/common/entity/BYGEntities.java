package potionstudios.byg.common.entity;

import net.minecraft.core.Registry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import potionstudios.byg.BYG;
import potionstudios.byg.common.entity.boat.BYGBoat;
import potionstudios.byg.common.entity.boat.BYGChestBoat;
import potionstudios.byg.reg.RegistrationProvider;
import potionstudios.byg.reg.RegistryObject;

public class BYGEntities {
    public static final RegistrationProvider<EntityType<?>> PROVIDER = RegistrationProvider.get(Registry.ENTITY_TYPE_REGISTRY, BYG.MOD_ID);

    public static final RegistryObject<EntityType<BYGBoat>> BOAT = createEntity("boat", EntityType.Builder.<BYGBoat>of(BYGBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F));
    public static final RegistryObject<EntityType<BYGChestBoat>> CHEST_BOAT = createEntity("chest_boat", EntityType.Builder.<BYGChestBoat>of(BYGChestBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10));

    //TODO: Geckolib Mojmap 1.18
//    public static final EntityType<ManOWar> MAN_O_WAR = createEntity("man_o_war", EntityType.Builder.of(ManOWar::new, MobCategory.AMBIENT).sized(0.6F, 1.75F).build(BYG.MOD_ID + ":man_o_war"));

    public static <E extends Entity> RegistryObject<EntityType<E>> createEntity(String id, EntityType.Builder<E> entityType) {
        return PROVIDER.register(id, () -> entityType.build(BYG.MOD_ID + ":" + id));
    }

    public static void loadClass() {}
}
