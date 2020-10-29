package corgiaoc.byg.common.properties.blocks.nether.crimson;

import corgiaoc.byg.core.BYGItems;
import corgiaoc.byg.util.FabricTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class CrimsonBerryBushBlock extends SweetBerryBushBlock implements Fertilizable {
    public static final IntProperty AGE = Properties.AGE_3;

    public CrimsonBerryBushBlock(Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(AGE, Integer.valueOf(0)));
    }

    @Override
    public ItemStack getPickStack(BlockView worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(BYGItems.CRIMSON_BERRIES);
    }

    @Override
    public ActionResult onUse(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockHitResult hit) {
        int i = state.get(AGE);
        boolean flag = i == 3;
        if (!flag && player.getStackInHand(handIn).getItem() == Items.BONE_MEAL) {
            return ActionResult.PASS;
        } else if (i > 1) {
            int j = 1 + worldIn.random.nextInt(2);
            dropStack(worldIn, pos, new ItemStack(BYGItems.CRIMSON_BERRIES, j + (flag ? 1 : 0)));
            worldIn.playSound(null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.random.nextFloat() * 0.4F);
            worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(1)), 2);
            return ActionResult.SUCCESS;
        } else {
            return super.onUse(state, worldIn, pos, player, handIn, hit);
        }
    }

    @Override
    protected boolean canPlantOnTop(BlockState state, BlockView worldIn, BlockPos pos) {
        return state.isIn(BlockTags.NYLIUM) || state.isIn(FabricTags.NETHERRACK) || super.canPlantOnTop(state, worldIn, pos);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        return this.canPlantOnTop(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }


    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn instanceof LivingEntity && entityIn.getType() != EntityType.PIGLIN && entityIn.getType() != EntityType.HOGLIN) {
            entityIn.slowMovement(state, new Vec3d(0.8F, 0.75D, 0.8F));
            if (!worldIn.isClient && state.get(AGE) > 0 && (entityIn.lastRenderX != entityIn.getX() || entityIn.lastRenderZ != entityIn.getZ())) {
                double d0 = Math.abs(entityIn.getX() - entityIn.lastRenderX);
                double d1 = Math.abs(entityIn.getZ() - entityIn.lastRenderZ);
                if (d0 >= (double) 0.003F || d1 >= (double) 0.003F) {
                    entityIn.damage(DamageSource.SWEET_BERRY_BUSH, 1.0F);
                }
            }

        }
    }

}