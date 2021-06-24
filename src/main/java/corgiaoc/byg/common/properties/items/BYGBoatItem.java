package corgiaoc.byg.common.properties.items;


import corgiaoc.byg.common.entity.boat.BYGBoatEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Predicate;

public class BYGBoatItem extends Item {
    private static final Predicate<Entity> RIDERS = EntityPredicates.EXCEPT_SPECTATOR.and(Entity::collides);
    private final BYGBoatEntity.BYGType type;

    public BYGBoatItem(BYGBoatEntity.BYGType typeIn, Item.Settings properties) {
        super(properties);
        this.type = typeIn;
    }

    @Override
    public TypedActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getStackInHand(handIn);
        HitResult raytraceresult = raycast(worldIn, playerIn, RaycastContext.FluidHandling.ANY);
        if (raytraceresult.getType() == HitResult.Type.MISS) {
            return TypedActionResult.pass(itemstack);
        } else {
            Vec3d Vector3d = playerIn.getRotationVec(1.0F);
            List<Entity> list = worldIn.getOtherEntities(playerIn, playerIn.getBoundingBox().stretch(Vector3d.multiply(5.0D)).expand(1.0D), RIDERS);
            if (!list.isEmpty()) {
                Vec3d Vector3d1 = playerIn.getCameraPosVec(1.0F);

                for (Entity entity : list) {
                    Box axisalignedbb = entity.getBoundingBox().expand(entity.getTargetingMargin());
                    if (axisalignedbb.contains(Vector3d1)) {
                        return TypedActionResult.pass(itemstack);
                    }
                }
            }

            if (raytraceresult.getType() == HitResult.Type.BLOCK) {
                BYGBoatEntity bygBoatEntity = new BYGBoatEntity(worldIn, raytraceresult.getPos().x, raytraceresult.getPos().y, raytraceresult.getPos().z);
                bygBoatEntity.setBYGBoatType(this.type);
                bygBoatEntity.setYaw(playerIn.getYaw());
                if (!worldIn.isSpaceEmpty(bygBoatEntity, bygBoatEntity.getBoundingBox().expand(-0.1D))) {
                    return TypedActionResult.fail(itemstack);
                } else {
                    if (!worldIn.isClient) {
                        worldIn.spawnEntity(bygBoatEntity);
                        if (!playerIn.getAbilities().creativeMode) {
                            itemstack.decrement(1);
                        }
                    }

                    playerIn.incrementStat(Stats.USED.getOrCreateStat(this));
                    return TypedActionResult.success(itemstack);
                }
            } else {
                return TypedActionResult.pass(itemstack);
            }
        }
    }
}