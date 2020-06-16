//package voronoiaoc.byg.common.properties.blocks;
//
//import net.fabricmc.api.EnvType;
//import net.fabricmc.api.Environment;
//import net.minecraft.block.*;
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.EntityType;
//import net.minecraft.entity.LivingEntity;
//import net.minecraft.entity.damage.DamageSource;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.item.ItemStack;
//import net.minecraft.item.Items;
//import net.minecraft.server.world.ServerWorld;
//import net.minecraft.sound.SoundCategory;
//import net.minecraft.sound.SoundEvents;
//import net.minecraft.state.StateManager;
//import net.minecraft.state.property.IntProperty;
//import net.minecraft.util.ActionResult;
//import net.minecraft.util.Hand;
//import net.minecraft.util.hit.BlockHitResult;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.Vec3d;
//import net.minecraft.util.shape.VoxelShape;
//import net.minecraft.world.BlockView;
//import net.minecraft.world.World;
//import java.util.Random;
//
//public class BlueBerryBush extends PlantBlock implements Fertilizable {
//    public static IntProperty AGE;
//    private static final VoxelShape SMALL_SHAPE = Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
//    private static final VoxelShape LARGE_SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
//
//    public BlueBerryBush(Settings p_i49971_1_) {
//        super(p_i49971_1_);
//        this.setDefaultState(this.stateManager.getDefaultState().with(AGE, Integer.valueOf(0)));
//    }
//
//    @Environment(EnvType.CLIENT)
//    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
//        return new ItemStack(BYGItemList.BLUE_BERRY);
//    }
//
//    public VoxelShape getOutlineShape(BlockState state, BlockView worldIn, BlockPos pos, ShapeContext context) {
//        if (state.get(AGE) == 0) {
//            return SMALL_SHAPE;
//        } else {
//            return state.get(AGE) < 3 ? LARGE_SHAPE : super.getOutlineShape(state, worldIn, pos, context);
//        }
//    }
//
//    public boolean hasRandomTicks(BlockState state) {
//        return state.get(AGE) < 3;
//    }
//
//    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
//        int i = state.get(AGE);
//        if (i < 3 && random.nextInt(5) == 0 && world.getBaseLightLevel(pos.up(), 0) >= 9) {
//            world.setBlockState(pos, state.with(AGE, i + 1), 2);
//        }
//
//    }
//
//    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
//        if (entity instanceof LivingEntity && entity.getType() != EntityType.FOX && entity.getType() != EntityType.BEE) {
//            entity.slowMovement(state, new Vec3d(0.800000011920929D, 0.75D, 0.800000011920929D));
//            if (!world.isClient && state.get(AGE) > 0 && (entity.lastRenderX != entity.getX() || entity.lastRenderZ != entity.getZ())) {
//                double d = Math.abs(entity.getX() - entity.lastRenderX);
//                double e = Math.abs(entity.getZ() - entity.lastRenderZ);
//                if (d >= 0.003000000026077032D || e >= 0.003000000026077032D) {
//                    entity.damage(DamageSource.SWEET_BERRY_BUSH, 1.0F);
//                }
//            }
//
//        }
//    }
//
//    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
//        int i = state.get(AGE);
//        boolean bl = i == 3;
//        if (!bl && player.getStackInHand(hand).getItem() == Items.BONE_MEAL) {
//            return ActionResult.PASS;
//        } else if (i > 1) {
//            int j = 1 + world.random.nextInt(2);
//            dropStack(world, pos, new ItemStack(BYGItemList.BLUE_BERRY, j + (bl ? 1 : 0)));
//            world.playSound(null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
//            world.setBlockState(pos, state.with(AGE, 1), 2);
//            return ActionResult.method_29236(world.isClient);
//        } else {
//            return super.onUse(state, world, pos, player, hand, hit);
//        }
//    }
//
//    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
//        builder.add(AGE);
//    }
//
//    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
//        return state.get(AGE) < 3;
//    }
//
//    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
//        return true;
//    }
//
//    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
//        int i = Math.min(3, state.get(AGE) + 1);
//        world.setBlockState(pos, state.with(AGE, i), 2);
//    }
//}