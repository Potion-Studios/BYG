package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class BYGFrostMagmaBlock extends Block {
    public BYGFrostMagmaBlock(Properties properties) {
        super(properties);
    }

    public void stepOn(@NotNull Level block, @NotNull BlockPos pos, @NotNull BlockState state, Entity entity) {
        if (!entity.fireImmune() && entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity) entity)) {
            entity.hurt(DamageSource.HOT_FLOOR, 1.0F);
        }
        super.stepOn(block, pos, state, entity);
    }

    @Override
    public void randomTick(@NotNull BlockState state, ServerLevel world, BlockPos pos, @NotNull RandomSource rand) {
        BlockState blockAbove = world.getBlockState(pos.above());
        if (blockAbove.getBlock() == Blocks.WATER) {
            world.setBlock(pos.above(), Blocks.ICE.defaultBlockState(), 2);
        }

        if (rand.nextInt(5) == 0) {
            if (blockAbove.getBlock() == Blocks.ICE) {
                world.setBlock(pos.above(), Blocks.PACKED_ICE.defaultBlockState(), 2);
            }
        }
    }

    public int tickRate() {
        return 20;
    }

    public void onPlace(@NotNull BlockState state, Level world, @NotNull BlockPos pos, @NotNull BlockState state2, boolean isMoving) {
        world.scheduleTick(pos, this, this.tickRate());
    }

}
