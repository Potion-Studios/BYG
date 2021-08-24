package corgiaoc.byg.common.properties.blocks.end.viscalisle;//package corgiaoc.byg.common.properties.blocks.end.viscalisle;
//
//import corgiaoc.byg.core.BYGBlocks;
//import corgiaoc.byg.core.BYGItems;
//import net.minecraft.advancements.CriteriaTriggers;
//import net.minecraft.block.Block;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.Blocks;
//import net.minecraft.block.IGrowable;
//import net.minecraft.block.material.Material;
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.entity.player.ServerPlayerEntity;
//import net.minecraft.entity.projectile.AbstractArrowEntity;
//import net.minecraft.entity.projectile.ProjectileEntity;
//import net.minecraft.fluid.FluidState;
//import net.minecraft.item.ItemStack;
//import net.minecraft.item.Items;
//import net.minecraft.particles.ParticleTypes;
//import net.minecraft.state.IntegerProperty;
//import net.minecraft.state.StateContainer;
//import net.minecraft.state.properties.BlockStateProperties;
//import net.minecraft.stats.Stats;
//import net.minecraft.tags.FluidTags;
//import net.minecraft.util.*;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.BlockRayTraceResult;
//import net.minecraft.util.math.shapes.ISelectionContext;
//import net.minecraft.util.math.shapes.VoxelShape;
//import net.minecraft.util.math.vector.Vector3d;
//import net.minecraft.world.*;
//import net.minecraft.world.server.ServerWorld;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//
//import java.util.Optional;
//import java.util.Random;
//
//public class TheriumBlock extends Block {
//
//    public TheriumBlock(Properties properties) {
//        super(properties);
//    }
//
//    public void onProjectileCollision(World worldIn, BlockState state, BlockRayTraceResult hit, ProjectileEntity projectile) {
//        int i = getPowerFromHitVec(worldIn, state, hit, projectile);
//        Entity entity = projectile.func_234616_v_();
//        if (entity instanceof ServerPlayerEntity) {
//            ServerPlayerEntity serverplayerentity = (ServerPlayerEntity)entity;
//            serverplayerentity.addStat(Stats.field_232863_aD_);
//            CriteriaTriggers.TARGET_HIT.test(serverplayerentity, projectile, hit.getHitVec(), i);
//        }
//
//    }
//
//    private static int getPowerFromHitVec(IWorld world, BlockState state, BlockRayTraceResult result, Entity entity) {
//        int i = getPowerFromHitVec(result, result.getHitVec());
//        int j = entity instanceof AbstractArrowEntity ? 20 : 8;
//        if (!world.getPendingBlockTicks().isTickScheduled(result.getPos(), state.getBlock())) {
//            powerTarget(world, state, i, result.getPos(), j);
//        }
//
//        return i;
//    }
//
//    private static boolean isNearWater(BlockPos pos, World world) {
//        FluidState fluidstate = world.getFluidState(pos);
//        if (!fluidstate.isTagged(FluidTags.WATER)) {
//            return false;
//        } else if (fluidstate.isSource()) {
//            return true;
//        } else {
//            float f = (float)fluidstate.getLevel();
//            if (f < 2.0F) {
//                return false;
//            } else {
//                FluidState fluidstate1 = world.getFluidState(pos.down());
//                return !fluidstate1.isTagged(FluidTags.WATER);
//            }
//        }
//    }
//}