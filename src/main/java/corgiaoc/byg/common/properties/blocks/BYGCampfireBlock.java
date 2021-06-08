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

public class BYGCampfireBlock extends CampfireBlock {
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D);
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final BooleanProperty SIGNAL_FIRE = BlockStateProperties.SIGNAL_FIRE;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public BYGCampfireBlock(boolean bool, int i, AbstractBlock.Properties properties) {
        super(bool, i, properties);
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


    public void onRemove(BlockState p_196243_1_, World p_196243_2_, BlockPos p_196243_3_, BlockState p_196243_4_, boolean p_196243_5_) {
        if (!p_196243_1_.is(p_196243_4_.getBlock())) {
            TileEntity tileentity = p_196243_2_.getBlockEntity(p_196243_3_);
            if (tileentity instanceof BYGCampfireTE) {
                InventoryHelper.dropContents(p_196243_2_, p_196243_3_, ((BYGCampfireTE)tileentity).getItems());
            }

            super.onRemove(p_196243_1_, p_196243_2_, p_196243_3_, p_196243_4_, p_196243_5_);
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

    public TileEntity newBlockEntity(IBlockReader p_196283_1_) {
        return new BYGCampfireTE();
    }
}