package corgiaoc.byg.common.properties.items;


import corgiaoc.byg.common.entity.boat.BYGBoatEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Predicate;

public class BYGBoatItem extends Item {
    private static final Predicate<Entity> RIDERS = EntityPredicates.NO_SPECTATORS.and(Entity::isPickable);
    private final BYGBoatEntity.BYGType type;

    public BYGBoatItem(BYGBoatEntity.BYGType typeIn, Item.Properties properties) {
        super(properties);
        this.type = typeIn;
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        RayTraceResult raytraceresult = getPlayerPOVHitResult(worldIn, playerIn, RayTraceContext.FluidMode.ANY);
        if (raytraceresult.getType() == RayTraceResult.Type.MISS) {
            return ActionResult.pass(itemstack);
        } else {
            Vector3d Vector3d = playerIn.getViewVector(1.0F);
            List<Entity> list = worldIn.getEntities(playerIn, playerIn.getBoundingBox().expandTowards(Vector3d.scale(5.0D)).inflate(1.0D), RIDERS);
            if (!list.isEmpty()) {
                Vector3d Vector3d1 = playerIn.getEyePosition(1.0F);

                for (Entity entity : list) {
                    AxisAlignedBB axisalignedbb = entity.getBoundingBox().inflate(entity.getPickRadius());
                    if (axisalignedbb.contains(Vector3d1)) {
                        return ActionResult.pass(itemstack);
                    }
                }
            }

            if (raytraceresult.getType() == RayTraceResult.Type.BLOCK) {
                BYGBoatEntity bygBoatEntity = new BYGBoatEntity(worldIn, raytraceresult.getLocation().x, raytraceresult.getLocation().y, raytraceresult.getLocation().z);
                bygBoatEntity.setBYGBoatType(this.type);
                bygBoatEntity.yRot = playerIn.yRot;
                if (!worldIn.noCollision(bygBoatEntity, bygBoatEntity.getBoundingBox().inflate(-0.1D))) {
                    return ActionResult.fail(itemstack);
                } else {
                    if (!worldIn.isClientSide) {
                        worldIn.addFreshEntity(bygBoatEntity);
                        if (!playerIn.abilities.instabuild) {
                            itemstack.shrink(1);
                        }
                    }

                    playerIn.awardStat(Stats.ITEM_USED.get(this));
                    return ActionResult.success(itemstack);
                }
            } else {
                return ActionResult.pass(itemstack);
            }
        }
    }
}