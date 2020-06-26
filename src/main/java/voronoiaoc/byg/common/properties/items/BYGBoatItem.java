package voronoiaoc.byg.common.properties.items;


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
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.common.entity.boat.BYGBoatEntity;

import java.util.List;
import java.util.function.Predicate;

public class BYGBoatItem extends Item {
    private static final Predicate<Entity> RIDERS = EntityPredicates.NOT_SPECTATING.and(Entity::canBeCollidedWith);
    private final BYGBoatEntity.BYGType type;

    public BYGBoatItem(BYGBoatEntity.BYGType typeIn, Item.Properties properties) {
        super(properties);
        this.type = typeIn;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        RayTraceResult raytraceresult = rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.ANY);
        if (raytraceresult.getType() == RayTraceResult.Type.MISS) {
            return ActionResult.resultPass(itemstack);
        } else {
            Vector3d Vector3d = playerIn.getLook(1.0F);
            List<Entity> list = worldIn.getEntitiesInAABBexcluding(playerIn, playerIn.getBoundingBox().expand(Vector3d.scale(5.0D)).grow(1.0D), RIDERS);
            if (!list.isEmpty()) {
                Vector3d Vector3d1 = playerIn.getEyePosition(1.0F);

                for (Entity entity : list) {
                    AxisAlignedBB axisalignedbb = entity.getBoundingBox().grow(entity.getCollisionBorderSize());
                    if (axisalignedbb.contains(Vector3d1)) {
                        return ActionResult.resultPass(itemstack);
                    }
                }
            }

            if (raytraceresult.getType() == RayTraceResult.Type.BLOCK) {
                BYGBoatEntity bygBoatEntity = new BYGBoatEntity(worldIn, raytraceresult.getHitVec().x, raytraceresult.getHitVec().y, raytraceresult.getHitVec().z);
                BYG.LOGGER.info("BOAT ENTITY: " + bygBoatEntity.getEntityString());
                bygBoatEntity.setBYGBoatType(this.type);
                bygBoatEntity.rotationYaw = playerIn.rotationYaw;
                if (!worldIn.hasNoCollisions(bygBoatEntity, bygBoatEntity.getBoundingBox().grow(-0.1D))) {
                    return ActionResult.resultFail(itemstack);
                } else {
                    if (!worldIn.isRemote) {
                        worldIn.addEntity(bygBoatEntity);
                        if (!playerIn.abilities.isCreativeMode) {
                            itemstack.shrink(1);
                        }
                    }

                    playerIn.addStat(Stats.ITEM_USED.get(this));
                    return ActionResult.resultSuccess(itemstack);
                }
            } else {
                return ActionResult.resultPass(itemstack);
            }
        }
    }
}