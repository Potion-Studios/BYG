package corgiaoc.byg.common.properties;

import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.BYGItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class EtherBulbsBlock extends Block implements BonemealableBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    protected static final VoxelShape SHAPE = Block.box(4.0D, 9.0D, 4.0D, 12.0D, 16.0D, 12.0D);

    public EtherBulbsBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(BYGItems.ETHER_BULBS);
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        int i = state.getValue(AGE);
        boolean flag = i == 3;
        if (!flag && player.getItemInHand(handIn).getItem() == Items.BONE_MEAL) {
            return InteractionResult.PASS;
        } else if (i > 2) {
            int j = 1;
            popResource(worldIn, pos, new ItemStack(BYGItems.ETHER_BULBS, j));
            worldIn.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + worldIn.random.nextFloat() * 0.4F);
            worldIn.setBlock(pos, state.setValue(AGE, Integer.valueOf(0)), 2);
            return InteractionResult.SUCCESS;
        } else {
            return super.use(state, worldIn, pos, player, handIn, hit);
        }
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.above();
        BlockState blockstate = worldIn.getBlockState(blockpos);
        Block block = blockstate.getBlock();
            return block == BYGBlocks.ETHER_LEAVES;
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
        return !stateIn.canSurvive(worldIn, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, Random rand) {
        if (!state.canSurvive(worldIn, pos)) {
            worldIn.destroyBlock(pos.above(), true);
        }
    }

    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(AGE) < 3;
    }

    public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, Random random) {
        int i = state.getValue(AGE);
        if (i < 3 && worldIn.getRawBrightness(pos.above(), 0) >= 9 && random.nextInt(5) == 0) {
            worldIn.setBlock(pos, state.setValue(AGE, i + 1), 2);
        }

    }

    public boolean isValidBonemealTarget(BlockGetter worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return state.getValue(AGE) < 3;
    }

    public boolean isBonemealSuccess(Level worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    public void performBonemeal(ServerLevel worldIn, Random rand, BlockPos pos, BlockState state) {
        int i = Math.min(3, state.getValue(AGE) + 1);
        worldIn.setBlock(pos, state.setValue(AGE, i), 2);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Environment(EnvType.CLIENT)
    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, Random rand) {
        VoxelShape lvt_5_1_ = this.getShape(stateIn, worldIn, pos, CollisionContext.empty());
        Vec3 lvt_6_1_ = lvt_5_1_.bounds().getCenter();
        double lvt_7_1_ = (double) pos.getX() + lvt_6_1_.x;
        double lvt_9_1_ = (double) pos.getZ() + lvt_6_1_.z;

        for (int lvt_11_1_ = 0; lvt_11_1_ < 3; ++lvt_11_1_) {
            if (rand.nextBoolean()) {
                worldIn.addParticle(ParticleTypes.REVERSE_PORTAL, lvt_7_1_ + (double) (rand.nextFloat() / 5.0F), (double) pos.getY() + (0.5D - (double) rand.nextFloat()), lvt_9_1_ + (double) (rand.nextFloat() / 5.0F), 0.0D, 0.0D, 0.0D);
            }
        }

    }
}