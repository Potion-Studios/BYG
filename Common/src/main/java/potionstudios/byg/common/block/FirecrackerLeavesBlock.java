package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.common.BYGTags;

public class FirecrackerLeavesBlock extends LeavesBlock {
    public FirecrackerLeavesBlock(Properties properties) {
        super(properties);
    }

    public @NotNull InteractionResult use(@NotNull BlockState blockState, Level level, BlockPos blockPos, Player player, @NotNull InteractionHand interactionHand, @NotNull BlockHitResult blockHitResult) {
        RandomSource random = level.random;
        BlockPos blockPos2 = blockPos.below();

        if (player.getItemInHand(interactionHand).is(BYGTags.SHEARS.all(BYGTags.RegistryType.ITEMS)) && level.getBlockState(blockPos2).is(BlockTags.DIRT)) {
            level.playSound(null, blockPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            double d = (double) blockPos.getX() + random.nextDouble();
            double e = (double) blockPos.getY() + 1.0D;
            double f = (double) blockPos.getZ() + random.nextDouble();
            level.setBlockAndUpdate(blockPos, BYGBlocks.FIRECRACKER_FLOWER_BUSH.defaultBlockState());
            level.neighborChanged(blockPos, BYGBlocks.FIRECRACKER_FLOWER_BUSH.get(), blockPos);
            level.addParticle(ParticleTypes.HAPPY_VILLAGER, d, e, f, 0.0D, 0.0D, 0.0D);
        }
        return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
    }
}
