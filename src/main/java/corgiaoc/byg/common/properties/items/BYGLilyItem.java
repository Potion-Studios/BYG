package corgiaoc.byg.common.properties.items;


import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BYGLilyItem extends BlockItem {
    public BYGLilyItem(Block blockIn, Item.Properties builder) {
        super(blockIn, builder);
    }

    public ActionResultType useOn(ItemUseContext context) {
        return ActionResultType.PASS;
    }

    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        RayTraceResult raytraceresult = getPlayerPOVHitResult(worldIn, playerIn, RayTraceContext.FluidMode.SOURCE_ONLY);
        if (raytraceresult.getType() == RayTraceResult.Type.MISS) {
            return new ActionResult<>(ActionResultType.PASS, itemstack);
        } else {
            if (raytraceresult.getType() == RayTraceResult.Type.BLOCK) {
                BlockRayTraceResult blockraytraceresult = (BlockRayTraceResult) raytraceresult;
                BlockPos blockpos = blockraytraceresult.getBlockPos();
                Direction direction = blockraytraceresult.getDirection();
                if (!worldIn.mayInteract(playerIn, blockpos) || !playerIn.mayUseItemAt(blockpos.relative(direction), direction, itemstack)) {
                    return new ActionResult<>(ActionResultType.FAIL, itemstack);
                }

                BlockPos blockpos1 = blockpos.above();
                BlockState blockstate = worldIn.getBlockState(blockpos);
                Material material = blockstate.getMaterial();
                FluidState FluidState = worldIn.getFluidState(blockpos);
                if ((FluidState.getType() == Fluids.WATER || material == Material.ICE) && worldIn.isEmptyBlock(blockpos1)) {

                    // special case for handling block placement with water lilies
                    net.minecraftforge.common.util.BlockSnapshot blocksnapshot = net.minecraftforge.common.util.BlockSnapshot.create(worldIn.dimension(), worldIn, blockpos1);
                    worldIn.setBlock(blockpos1, BYGBlocks.TINY_LILYPADS.defaultBlockState(), 11);
                    if (net.minecraftforge.event.ForgeEventFactory.onBlockPlace(playerIn, blocksnapshot, net.minecraft.util.Direction.UP)) {
                        blocksnapshot.restore(true, false);
                        return new ActionResult<ItemStack>(ActionResultType.FAIL, itemstack);
                    }

                    if (playerIn instanceof ServerPlayerEntity) {
                        CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity) playerIn, blockpos1, itemstack);
                    }

                    if (!playerIn.abilities.instabuild) {
                        itemstack.shrink(1);
                    }

                    playerIn.awardStat(Stats.ITEM_USED.get(this));
                    worldIn.playSound(playerIn, blockpos, SoundEvents.LILY_PAD_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
                }
            }

            return new ActionResult<>(ActionResultType.FAIL, itemstack);
        }
    }
}
