package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.common.item.BYGItems;

import java.util.Random;

public class BloomingAloeVeraBlock extends DoublePlantBlock {

    public BloomingAloeVeraBlock(Properties $$0) {
        super($$0);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter $$1, BlockPos $$2) {
        return state.is(BlockTags.SAND);
    }

    @Override
    public InteractionResult use(BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        Random random = level.random;
        BlockPos blockPos2 = blockPos.below();
        BlockPos blockPos3 = blockPos.above();

        if (player.getItemInHand(interactionHand).is(Items.SHEARS) && level.getBlockState(blockPos2).is(BlockTags.DIRT) || level.getBlockState(blockPos2).is(BlockTags.SAND)) {
            level.playSound(null, blockPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            double d = (double) blockPos.getX() + random.nextDouble();
            double e = (double) blockPos.getY() + 1.0D;
            double f = (double) blockPos.getZ() + random.nextDouble();
            int j = 1 + level.random.nextInt(2);
            popResource(level, blockPos, new ItemStack(BYGItems.ALOE_VERA, j));
            level.setBlockAndUpdate(blockPos, BYGBlocks.ALOE_VERA.defaultBlockState());
            level.neighborChanged(blockPos, BYGBlocks.ALOE_VERA, blockPos);
            level.neighborChanged(blockPos, Blocks.AIR, blockPos3);
            level.addParticle(ParticleTypes.HAPPY_VILLAGER, d, e, f, 0.0D, 0.0D, 0.0D);
        }
        return InteractionResult.sidedSuccess(level.isClientSide);

    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState) {
        return new ItemStack(BYGItems.ALOE_VERA);
    }


}
