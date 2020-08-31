package voronoiaoc.byg.common.properties.items;


import voronoiaoc.byg.common.entity.boat.BYGBoatEntity;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class BYGBoatItem extends Item {
    private static final Predicate<Entity> RIDERS;
    private final BYGBoatEntity.BYGType type;

    public BYGBoatItem(BYGBoatEntity.BYGType type, Item.Properties settings) {
        super(settings);
        this.type = type;
    }

    public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
        ItemStack itemStack = user.getItemInHand(hand);
        HitResult hitResult = getPlayerPOVHitResult(world, user, ClipContext.Fluid.ANY);
        if (hitResult.getType() == HitResult.Type.MISS) {
            return InteractionResultHolder.pass(itemStack);
        } else {
            Vec3 vec3d = user.getViewVector(1.0F);
            double d = 5.0D;
            List<Entity> list = world.getEntities(user, user.getBoundingBox().expandTowards(vec3d.scale(5.0D)).inflate(1.0D), RIDERS);
            if (!list.isEmpty()) {
                Vec3 vec3d2 = user.getEyePosition(1.0F);
                Iterator var11 = list.iterator();

                while (var11.hasNext()) {
                    Entity entity = (Entity) var11.next();
                    AABB box = entity.getBoundingBox().inflate(entity.getPickRadius());
                    if (box.contains(vec3d2)) {
                        return InteractionResultHolder.pass(itemStack);
                    }
                }
            }

            if (hitResult.getType() == HitResult.Type.BLOCK) {
                BYGBoatEntity bygBoatEntity = new BYGBoatEntity(world, hitResult.getLocation().x, hitResult.getLocation().y, hitResult.getLocation().z);
                //BYG.LOGGER.info("BOAT ENTITY: " + bygBoatEntity.toString());
                bygBoatEntity.setBYGBoatType(this.type);
                bygBoatEntity.yRot = user.yRot;
                if (!world.noCollision(bygBoatEntity, bygBoatEntity.getBoundingBox().inflate(-0.1D))) {
                    return InteractionResultHolder.fail(itemStack);
                } else {
                    if (!world.isClientSide) {
                        world.addFreshEntity(bygBoatEntity);
                        if (!user.abilities.instabuild) {
                            itemStack.shrink(1);
                        }
                    }

                    user.awardStat(Stats.ITEM_USED.get(this));
                    return InteractionResultHolder.sidedSuccess(itemStack, world.isClientSide());
                }
            } else {
                return InteractionResultHolder.pass(itemStack);
            }
        }
    }

    static {
        RIDERS = EntitySelector.NO_SPECTATORS.and(Entity::isPickable);
    }
}