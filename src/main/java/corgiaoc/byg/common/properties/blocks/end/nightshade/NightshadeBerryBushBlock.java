package corgiaoc.byg.common.properties.blocks.end.nightshade;

import corgiaoc.byg.core.BYGItems;
import corgiaoc.byg.util.FabricTags;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
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
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.Random;

public class NightshadeBerryBushBlock extends SweetBerryBushBlock implements Fertilizable {
    public static final IntProperty AGE = Properties.AGE_3;

    public NightshadeBerryBushBlock(Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(AGE, Integer.valueOf(0)));
    }

    @Override
    public ItemStack getPickStack(BlockView worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(BYGItems.NIGHTSHADE_BERRIES);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        int i = state.get(AGE);
        if (i < 3 && worldIn.getBaseLightLevel(pos.up(), 0) <= 10 && random.nextInt(5) == 0) {
            worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i + 1)), 2);
        }

    }

    @Override
    public ActionResult onUse(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockHitResult hit) {
        int i = state.get(AGE);
        boolean flag = i == 3;
        if (!flag && player.getStackInHand(handIn).getItem() == Items.BONE_MEAL) {
            return ActionResult.PASS;
        } else if (i > 1) {
            int j = 1 + worldIn.random.nextInt(2);
            dropStack(worldIn, pos, new ItemStack(BYGItems.NIGHTSHADE_BERRIES, j + (flag ? 1 : 0)));
            worldIn.playSound(null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.random.nextFloat() * 0.4F);
            worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(1)), 2);
            return ActionResult.SUCCESS;
        } else {
            return super.onUse(state, worldIn, pos, player, handIn, hit);
        }
    }

    @Override
    protected boolean canPlantOnTop(BlockState state, BlockView worldIn, BlockPos pos) {
        return state.isIn(BlockTags.NYLIUM) || state.isIn(FabricTags.END_STONES) || super.canPlantOnTop(state, worldIn, pos);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        return this.canPlantOnTop(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn instanceof LivingEntity && entityIn.getType() != EntityType.PHANTOM && entityIn.getType() != EntityType.ENDERMAN) {
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

    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        VoxelShape lvt_5_1_ = this.getOutlineShape(stateIn, worldIn, pos, ShapeContext.absent());
        Vec3d lvt_6_1_ = lvt_5_1_.getBoundingBox().getCenter();
        double lvt_7_1_ = (double) pos.getX() + lvt_6_1_.x;
        double lvt_9_1_ = (double) pos.getZ() + lvt_6_1_.z;

        for (int lvt_11_1_ = 0; lvt_11_1_ < 3; ++lvt_11_1_) {
            if (rand.nextBoolean()) {
                worldIn.addParticle(ParticleTypes.WARPED_SPORE, lvt_7_1_ + (double) (rand.nextFloat() / 5.0F), (double) pos.getY() + (0.5D - (double) rand.nextFloat()), lvt_9_1_ + (double) (rand.nextFloat() / 5.0F), 0.0D, 0.0D, 0.0D);
            }
        }

    }
}