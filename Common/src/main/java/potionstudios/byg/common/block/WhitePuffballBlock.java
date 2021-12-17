package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.common.item.BYGItems;

import java.util.Random;

public class WhitePuffballBlock extends BushBlock implements BonemealableBlock {
    public static final IntegerProperty AGE;
    private static final VoxelShape BABY_SHAPE;
    private static final VoxelShape MID_GROWTH_SHAPE;
    
    public WhitePuffballBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    public ItemStack getCloneItemStack(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState) {
        return new ItemStack(BYGItems.WHITE_PUFFBALL_SPORES);
    }

    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        if (blockState.getValue(AGE) == 0) {
            return BABY_SHAPE;
        } else {
            return blockState.getValue(AGE) < 3 ? MID_GROWTH_SHAPE : super.getShape(blockState, blockGetter, blockPos, collisionContext);
        }
    }

    public boolean isRandomlyTicking(BlockState blockState) {
        return blockState.getValue(AGE) < 3;
    }

    public void randomTick(BlockState blockState, @NotNull ServerLevel serverLevel, @NotNull BlockPos blockPos, @NotNull Random random) {
        int i = blockState.getValue(AGE);
        if (i < 3 && random.nextInt(5) == 0 && serverLevel.getRawBrightness(blockPos.above(), 0) < 13) {
            serverLevel.setBlock(blockPos, blockState.setValue(AGE, i + 1), 2);
        }

    }

    public InteractionResult use(BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull InteractionHand interactionHand, @NotNull BlockHitResult blockHitResult) {
        int i = blockState.getValue(AGE);
        boolean bl = i == 3;
        if (!bl && player.getItemInHand(interactionHand).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else if (i > 2) {
            int j = 1 + level.random.nextInt(2);
            popResource(level, blockPos, new ItemStack(BYGItems.WHITE_PUFFBALL_SPORES, j + (bl ? 1 : 0)));
            popResource(level, blockPos, new ItemStack(BYGItems.WHITE_PUFFBALL_CAP, j));

            level.playSound(null, blockPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            level.setBlock(blockPos, blockState.setValue(AGE, 0), 2);
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
        }
    }

    protected boolean mayPlaceOn(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return blockState.isSolidRender(blockGetter, blockPos);
    }

    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        BlockPos blockPos2 = blockPos.below();
        BlockState blockState2 = levelReader.getBlockState(blockPos2);
        if (blockState2.is(BlockTags.MUSHROOM_GROW_BLOCK)) {
            return true;
        } else {
            return levelReader.getRawBrightness(blockPos, 0) < 13 && this.mayPlaceOn(blockState2, levelReader, blockPos2);
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    public boolean isValidBonemealTarget(@NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, BlockState blockState, boolean bl) {
        return blockState.getValue(AGE) < 3;
    }

    public boolean isBonemealSuccess(@NotNull Level level, @NotNull Random random, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return true;
    }

    public void performBonemeal(ServerLevel serverLevel, @NotNull Random random, @NotNull BlockPos blockPos, BlockState blockState) {
        int i = Math.min(3, blockState.getValue(AGE) + 1);
        serverLevel.setBlock(blockPos, blockState.setValue(AGE, i), 2);
    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    static {
        AGE = BlockStateProperties.AGE_3;
        BABY_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
        MID_GROWTH_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
    }
}
