package corgiaoc.byg.common.properties.items;


import corgiaoc.byg.common.entity.boat.BYGBoatEntity;
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

import java.util.List;
import java.util.function.Predicate;

public class BYGBoatItem extends Item {
    private static final Predicate<Entity> RIDERS = EntitySelector.NO_SPECTATORS.and(Entity::isPickable);
    private final BYGBoatEntity.BYGType type;

    public BYGBoatItem(BYGBoatEntity.BYGType typeIn, Properties properties) {
        super(properties);
        this.type = typeIn;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        HitResult raytraceresult = getPlayerPOVHitResult(worldIn, playerIn, ClipContext.Fluid.ANY);
        if (raytraceresult.getType() == HitResult.Type.MISS) {
            return InteractionResultHolder.pass(itemstack);
        } else {
            Vec3 Vector3d = playerIn.getViewVector(1.0F);
            List<Entity> list = worldIn.getEntities(playerIn, playerIn.getBoundingBox().expandTowards(Vector3d.scale(5.0D)).inflate(1.0D), RIDERS);
            if (!list.isEmpty()) {
                Vec3 Vector3d1 = playerIn.getEyePosition(1.0F);

                for (Entity entity : list) {
                    AABB axisalignedbb = entity.getBoundingBox().inflate(entity.getPickRadius());
                    if (axisalignedbb.contains(Vector3d1)) {
                        return InteractionResultHolder.pass(itemstack);
                    }
                }
            }

            if (raytraceresult.getType() == HitResult.Type.BLOCK) {
                BYGBoatEntity bygBoatEntity = new BYGBoatEntity(worldIn, raytraceresult.getLocation().x, raytraceresult.getLocation().y, raytraceresult.getLocation().z);
                bygBoatEntity.setBYGBoatType(this.type);
                bygBoatEntity.yRot = playerIn.yRot;
                if (!worldIn.noCollision(bygBoatEntity, bygBoatEntity.getBoundingBox().inflate(-0.1D))) {
                    return InteractionResultHolder.fail(itemstack);
                } else {
                    if (!worldIn.isClientSide) {
                        worldIn.addFreshEntity(bygBoatEntity);
                        if (!playerIn.abilities.instabuild) {
                            itemstack.shrink(1);
                        }
                    }

                    playerIn.awardStat(Stats.ITEM_USED.get(this));
                    return InteractionResultHolder.success(itemstack);
                }
            } else {
                return InteractionResultHolder.pass(itemstack);
            }
        }
    }
}