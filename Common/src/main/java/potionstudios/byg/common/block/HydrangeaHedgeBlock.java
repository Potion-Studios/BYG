package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.AzaleaBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.common.BYGTags;

public class HydrangeaHedgeBlock extends AzaleaBlock {
    private static final VoxelShape SHAPE = Shapes.or(Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(6.0D, 0.0D, 6.0D, 10.0D, 8.0D, 10.0D));
    private final TagKey<Block> validGround;

    protected HydrangeaHedgeBlock(Properties properties, TagKey<Block> validGround) {
        super(properties.dynamicShape());
        this.validGround = validGround;

    }

    @Override
    protected boolean mayPlaceOn(BlockState state, @NotNull BlockGetter worldIn, @NotNull BlockPos pos) {
        return state.is(validGround);
    }


    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return SHAPE;
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState blockState, Level level, BlockPos blockPos, Player player, @NotNull InteractionHand interactionHand, @NotNull BlockHitResult blockHitResult) {
        RandomSource random = level.random;
        BlockPos blockPos2 = blockPos.below();

        if (player.getItemInHand(interactionHand).is(BYGTags.SHEARS.all(BYGTags.RegistryType.ITEMS)) && level.getBlockState(blockPos2).is(BlockTags.DIRT)) {
            level.playSound(null, blockPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            double d = (double) blockPos.getX() + random.nextDouble();
            double e = (double) blockPos.getY() + 1.0D;
            double f = (double) blockPos.getZ() + random.nextDouble();
            level.setBlockAndUpdate(blockPos, BYGBlocks.HYDRANGEA_BUSH.defaultBlockState());
            level.neighborChanged(blockPos, BYGBlocks.HYDRANGEA_BUSH.get(), blockPos);
            level.addParticle(ParticleTypes.HAPPY_VILLAGER, d, e, f, 0.0D, 0.0D, 0.0D);
        }
        return InteractionResult.sidedSuccess(level.isClientSide);

    }

    @Override
    public boolean isValidBonemealTarget(@NotNull LevelReader $$0, @NotNull BlockPos $$1, @NotNull BlockState $$2, boolean $$3) {
        return false;
    }

    @Override
    public boolean isBonemealSuccess(@NotNull Level $$0, @NotNull RandomSource $$1, @NotNull BlockPos $$2, @NotNull BlockState $$3) {
        return false;
    }

    @Override
    public void performBonemeal(@NotNull ServerLevel $$0, @NotNull RandomSource $$1, @NotNull BlockPos $$2, @NotNull BlockState $$3) {
    }
}
