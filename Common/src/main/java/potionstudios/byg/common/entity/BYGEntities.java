package potionstudios.byg.common.entity;

import net.minecraft.core.Registry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import potionstudios.byg.BYG;
import potionstudios.byg.common.entity.boat.BYGBoat;
import potionstudios.byg.common.entity.boat.BYGChestBoat;
import potionstudios.byg.common.entity.manowar.ManOWar;
import potionstudios.byg.common.entity.pumpkinwarden.PumpkinWarden;
import potionstudios.byg.reg.RegistrationProvider;
import potionstudios.byg.reg.RegistryObject;

public class BYGEntities {
    public static final RegistrationProvider<EntityType<?>> PROVIDER = RegistrationProvider.get(Registry.ENTITY_TYPE_REGISTRY, BYG.MOD_ID);

    public static final RegistryObject<EntityType<BYGBoat>> BOAT = createEntity("boat", EntityType.Builder.<BYGBoat>of(BYGBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F));
    public static final RegistryObject<EntityType<BYGChestBoat>> CHEST_BOAT = createEntity("chest_boat", EntityType.Builder.<BYGChestBoat>of(BYGChestBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10));

    public static final RegistryObject<EntityType<ManOWar>> MAN_O_WAR = createEntity("man_o_war", EntityType.Builder.of(ManOWar::new, MobCategory.AMBIENT).sized(0.6F, 1F));
    public static final RegistryObject<EntityType<PumpkinWarden>> PUMPKIN_WARDEN = createEntity("pumpkin_warden", EntityType.Builder.of(PumpkinWarden::new, MobCategory.AMBIENT).sized(1F, 1.4F));

    public static <E extends Entity> RegistryObject<EntityType<E>> createEntity(String id, EntityType.Builder<E> entityType) {
        return PROVIDER.register(id, () -> entityType.build(BYG.MOD_ID + ":" + id));
    }

    public static void loadClass() {}
}
