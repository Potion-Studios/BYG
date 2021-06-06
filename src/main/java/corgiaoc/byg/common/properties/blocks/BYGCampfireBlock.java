package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.common.entity.tileentities.BYGCampfireTE;
import corgiaoc.byg.core.BYGTileEntities;
import net.minecraft.block.*;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CampfireCookingRecipe;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.tileentity.CampfireTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.Random;

public class BYGCampfireBlock extends ContainerBlock implements IWaterLoggable {
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D);
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final BooleanProperty SIGNAL_FIRE = BlockStateProperties.SIGNAL_FIRE;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    private static final VoxelShape VIRTUAL_FENCE_POST = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D);
    private final boolean spawnParticles;
    private final int fireDamage;

    public BYGCampfireBlock(boolean p_i241174_1_, int p_i241174_2_, AbstractBlock.Properties p_i241174_3_) {
        super(p_i241174_3_);
        this.spawnParticles = p_i241174_1_;
        this.fireDamage = p_i241174_2_;
        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, Boolean.valueOf(true)).setValue(SIGNAL_FIRE, Boolean.valueOf(false)).setValue(WATERLOGGED, Boolean.valueOf(false)).setValue(FACING, Direction.NORTH));
    }

    public ActionResultType use(BlockState p_225533_1_, World p_225533_2_, BlockPos p_225533_3_, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
        TileEntity tileentity = p_225533_2_.getBlockEntity(p_225533_3_);
        if (tileentity instanceof BYGCampfireTE) {
            BYGCampfireTE campfiretileentity = (BYGCampfireTE)tileentity;
            ItemStack itemstack = p_225533_4_.getItemInHand(p_225533_5_);
            Optional<CampfireCookingRecipe> optional = campfiretileentity.getCookableRecipe(itemstack);
            if (optional.isPresent()) {
                if (!p_225533_2_.isClientSide && campfiretileentity.placeFood(p_225533_4_.abilities.instabuild ? itemstack.copy() : itemstack, optional.get().getCookingTime())) {
                    p_225533_4_.awardStat(Stats.INTERACT_WITH_CAMPFIRE);
                    return ActionResultType.SUCCESS;
                }

                return ActionResultType.CONSUME;
            }
        }

        return ActionResultType.PASS;
    }

    public void entityInside(BlockState p_196262_1_, World p_196262_2_, BlockPos p_196262_3_, Entity p_196262_4_) {
        if (!p_196262_4_.fireImmune() && p_196262_1_.getValue(LIT) && p_196262_4_ instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)p_196262_4_)) {
            p_196262_4_.hurt(DamageSource.IN_FIRE, (float)this.fireDamage);
        }

        super.entityInside(p_196262_1_, p_196262_2_, p_196262_3_, p_196262_4_);
    }

    public void onRemove(BlockState p_196243_1_, World p_196243_2_, BlockPos p_196243_3_, BlockState p_196243_4_, boolean p_196243_5_) {
        if (!p_196243_1_.is(p_196243_4_.getBlock())) {
            TileEntity tileentity = p_196243_2_.getBlockEntity(p_196243_3_);
            if (tileentity instanceof BYGCampfireTE) {
                InventoryHelper.dropContents(p_196243_2_, p_196243_3_, ((BYGCampfireTE)tileentity).getItems());
            }

            super.onRemove(p_196243_1_, p_196243_2_, p_196243_3_, p_196243_4_, p_196243_5_);
        }
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
        IWorld iworld = p_196258_1_.getLevel();
        BlockPos blockpos = p_196258_1_.getClickedPos();
        boolean flag = iworld.getFluidState(blockpos).getType() == Fluids.WATER;
        return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(flag)).setValue(SIGNAL_FIRE, Boolean.valueOf(this.isSmokeSource(iworld.getBlockState(blockpos.below())))).setValue(LIT, Boolean.valueOf(!flag)).setValue(FACING, p_196258_1_.getHorizontalDirection());
    }

    public BlockState updateShape(BlockState p_196271_1_, Direction p_196271_2_, BlockState p_196271_3_, IWorld p_196271_4_, BlockPos p_196271_5_, BlockPos p_196271_6_) {
        if (p_196271_1_.getValue(WATERLOGGED)) {
            p_196271_4_.getLiquidTicks().scheduleTick(p_196271_5_, Fluids.WATER, Fluids.WATER.getTickDelay(p_196271_4_));
        }

        return p_196271_2_ == Direction.DOWN ? p_196271_1_.setValue(SIGNAL_FIRE, Boolean.valueOf(this.isSmokeSource(p_196271_3_))) : super.updateShape(p_196271_1_, p_196271_2_, p_196271_3_, p_196271_4_, p_196271_5_, p_196271_6_);
    }

    private boolean isSmokeSource(BlockState p_220099_1_) {
        return p_220099_1_.is(Blocks.HAY_BLOCK);
    }

    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        return SHAPE;
    }

    public BlockRenderType getRenderShape(BlockState p_149645_1_) {
        return BlockRenderType.MODEL;
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState p_180655_1_, World p_180655_2_, BlockPos p_180655_3_, Random p_180655_4_) {
        if (p_180655_1_.getValue(LIT)) {
            if (p_180655_4_.nextInt(10) == 0) {
                p_180655_2_.playLocalSound((double)p_180655_3_.getX() + 0.5D, (double)p_180655_3_.getY() + 0.5D, (double)p_180655_3_.getZ() + 0.5D, SoundEvents.CAMPFIRE_CRACKLE, SoundCategory.BLOCKS, 0.5F + p_180655_4_.nextFloat(), p_180655_4_.nextFloat() * 0.7F + 0.6F, false);
            }

            if (this.spawnParticles && p_180655_4_.nextInt(5) == 0) {
                for(int i = 0; i < p_180655_4_.nextInt(1) + 1; ++i) {
                    p_180655_2_.addParticle(ParticleTypes.LAVA, (double)p_180655_3_.getX() + 0.5D, (double)p_180655_3_.getY() + 0.5D, (double)p_180655_3_.getZ() + 0.5D, (double)(p_180655_4_.nextFloat() / 2.0F), 5.0E-5D, (double)(p_180655_4_.nextFloat() / 2.0F));
                }
            }

        }
    }

    public static void dowse(IWorld p_235475_0_, BlockPos p_235475_1_, BlockState p_235475_2_) {
        if (p_235475_0_.isClientSide()) {
            for(int i = 0; i < 20; ++i) {
                makeParticles((World)p_235475_0_, p_235475_1_, p_235475_2_.getValue(SIGNAL_FIRE), true);
            }
        }

        TileEntity tileentity = p_235475_0_.getBlockEntity(p_235475_1_);
        if (tileentity instanceof BYGCampfireTE) {
            ((BYGCampfireTE)tileentity).dowse();
        }

    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return isLitCampfire(state);
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return BYGTileEntities.BYGCAMPFIRE.get().create();
    }

    public boolean placeLiquid(IWorld p_204509_1_, BlockPos p_204509_2_, BlockState p_204509_3_, FluidState p_204509_4_) {
        if (!p_204509_3_.getValue(BlockStateProperties.WATERLOGGED) && p_204509_4_.getType() == Fluids.WATER) {
            boolean flag = p_204509_3_.getValue(LIT);
            if (flag) {
                if (!p_204509_1_.isClientSide()) {
                    p_204509_1_.playSound((PlayerEntity)null, p_204509_2_, SoundEvents.GENERIC_EXTINGUISH_FIRE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                }

                dowse(p_204509_1_, p_204509_2_, p_204509_3_);
            }

            p_204509_1_.setBlock(p_204509_2_, p_204509_3_.setValue(WATERLOGGED, Boolean.valueOf(true)).setValue(LIT, Boolean.valueOf(false)), 3);
            p_204509_1_.getLiquidTicks().scheduleTick(p_204509_2_, p_204509_4_.getType(), p_204509_4_.getType().getTickDelay(p_204509_1_));
            return true;
        } else {
            return false;
        }
    }

    public void onProjectileHit(World p_220066_1_, BlockState p_220066_2_, BlockRayTraceResult p_220066_3_, ProjectileEntity p_220066_4_) {
        if (!p_220066_1_.isClientSide && p_220066_4_.isOnFire()) {
            Entity entity = p_220066_4_.getOwner();
            boolean flag = entity == null || entity instanceof PlayerEntity || net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(p_220066_1_, entity);
            if (flag && !p_220066_2_.getValue(LIT) && !p_220066_2_.getValue(WATERLOGGED)) {
                BlockPos blockpos = p_220066_3_.getBlockPos();
                p_220066_1_.setBlock(blockpos, p_220066_2_.setValue(BlockStateProperties.LIT, Boolean.valueOf(true)), 11);
            }
        }

    }

    public static void makeParticles(World p_220098_0_, BlockPos p_220098_1_, boolean p_220098_2_, boolean p_220098_3_) {
        Random random = p_220098_0_.getRandom();
        BasicParticleType basicparticletype = p_220098_2_ ? ParticleTypes.CAMPFIRE_SIGNAL_SMOKE : ParticleTypes.CAMPFIRE_COSY_SMOKE;
        p_220098_0_.addAlwaysVisibleParticle(basicparticletype, true, (double)p_220098_1_.getX() + 0.5D + random.nextDouble() / 3.0D * (double)(random.nextBoolean() ? 1 : -1), (double)p_220098_1_.getY() + random.nextDouble() + random.nextDouble(), (double)p_220098_1_.getZ() + 0.5D + random.nextDouble() / 3.0D * (double)(random.nextBoolean() ? 1 : -1), 0.0D, 0.07D, 0.0D);
        if (p_220098_3_) {
            p_220098_0_.addParticle(ParticleTypes.SMOKE, (double)p_220098_1_.getX() + 0.25D + random.nextDouble() / 2.0D * (double)(random.nextBoolean() ? 1 : -1), (double)p_220098_1_.getY() + 0.4D, (double)p_220098_1_.getZ() + 0.25D + random.nextDouble() / 2.0D * (double)(random.nextBoolean() ? 1 : -1), 0.0D, 0.005D, 0.0D);
        }

    }

    public static boolean isSmokeyPos(World p_235474_0_, BlockPos p_235474_1_) {
        for(int i = 1; i <= 5; ++i) {
            BlockPos blockpos = p_235474_1_.below(i);
            BlockState blockstate = p_235474_0_.getBlockState(blockpos);
            if (isLitCampfire(blockstate)) {
                return true;
            }

            boolean flag = VoxelShapes.joinIsNotEmpty(VIRTUAL_FENCE_POST, blockstate.getCollisionShape(p_235474_0_, blockpos, ISelectionContext.empty()), IBooleanFunction.AND);//Forge fix: MC-201374
            if (flag) {
                BlockState blockstate1 = p_235474_0_.getBlockState(blockpos.below());
                return isLitCampfire(blockstate1);
            }
        }

        return false;
    }

    public static boolean isLitCampfire(BlockState p_226915_0_) {
        return p_226915_0_.hasProperty(LIT) && p_226915_0_.is(BlockTags.CAMPFIRES) && p_226915_0_.getValue(LIT);
    }

    public FluidState getFluidState(BlockState p_204507_1_) {
        return p_204507_1_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_204507_1_);
    }

    public BlockState rotate(BlockState p_185499_1_, Rotation p_185499_2_) {
        return p_185499_1_.setValue(FACING, p_185499_2_.rotate(p_185499_1_.getValue(FACING)));
    }

    public BlockState mirror(BlockState p_185471_1_, Mirror p_185471_2_) {
        return p_185471_1_.rotate(p_185471_2_.getRotation(p_185471_1_.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(LIT, SIGNAL_FIRE, WATERLOGGED, FACING);
    }

    public TileEntity newBlockEntity(IBlockReader p_196283_1_) {
        return new BYGCampfireTE();
    }

    public boolean isPathfindable(BlockState p_196266_1_, IBlockReader p_196266_2_, BlockPos p_196266_3_, PathType p_196266_4_) {
        return false;
    }

    public static boolean canLight(BlockState p_241470_0_) {
        return p_241470_0_.is(BlockTags.CAMPFIRES, (p_241469_0_) -> {
            return p_241469_0_.hasProperty(BlockStateProperties.WATERLOGGED) && p_241469_0_.hasProperty(BlockStateProperties.LIT);
        }) && !p_241470_0_.getValue(BlockStateProperties.WATERLOGGED) && !p_241470_0_.getValue(BlockStateProperties.LIT);
    }
}