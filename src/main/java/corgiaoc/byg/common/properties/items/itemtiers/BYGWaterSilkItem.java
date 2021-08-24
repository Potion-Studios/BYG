package corgiaoc.byg.common.properties.items.itemtiers;


import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class BYGWaterSilkItem extends BlockItem {
    public BYGWaterSilkItem(Block blockIn, Properties builder) {
        super(blockIn, builder);
    }

    public InteractionResult useOn(UseOnContext context) {
        return InteractionResult.PASS;
    }

    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        HitResult raytraceresult = getPlayerPOVHitResult(worldIn, playerIn, ClipContext.Fluid.SOURCE_ONLY);
        if (raytraceresult.getType() == HitResult.Type.MISS) {
            return new InteractionResultHolder<>(InteractionResult.PASS, itemstack);
        } else {
            if (raytraceresult.getType() == HitResult.Type.BLOCK) {
                BlockHitResult blockraytraceresult = (BlockHitResult) raytraceresult;
                BlockPos blockpos = blockraytraceresult.getBlockPos();
                Direction direction = blockraytraceresult.getDirection();
                if (!worldIn.mayInteract(playerIn, blockpos) || !playerIn.mayUseItemAt(blockpos.relative(direction), direction, itemstack)) {
                    return new InteractionResultHolder<>(InteractionResult.FAIL, itemstack);
                }

                BlockPos blockpos1 = blockpos.above();
                BlockState blockstate = worldIn.getBlockState(blockpos);
                Material material = blockstate.getMaterial();
                FluidState FluidState = worldIn.getFluidState(blockpos);
                if ((FluidState.getType() == Fluids.WATER || material == Material.ICE) && worldIn.isEmptyBlock(blockpos1)) {
                    // special case for handling block placement with water lilies
                    worldIn.setBlock(blockpos1, BYGBlocks.WATER_SILK.defaultBlockState(), 11);
                    if (playerIn instanceof ServerPlayer) {
                        CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer) playerIn, blockpos1, itemstack);
                    }

                    if (!playerIn.abilities.instabuild) {
                        itemstack.shrink(1);
                    }

                    playerIn.awardStat(Stats.ITEM_USED.get(this));
                    worldIn.playSound(playerIn, blockpos, SoundEvents.LILY_PAD_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemstack);
                }
            }

            return new InteractionResultHolder<>(InteractionResult.FAIL, itemstack);
        }
    }
}
