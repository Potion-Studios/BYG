package corgiaoc.byg.common.properties.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

@SuppressWarnings("deprecation")
public class BYGFrostMagmaBlock extends Block {
    public BYGFrostMagmaBlock(Properties properties) {
        super(properties);
    }

    public void stepOn(World block, BlockPos pos, Entity entity) {
        if (!entity.fireImmune() && entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity) entity)) {
            entity.hurt(DamageSource.HOT_FLOOR, 1.0F);
        }
        super.stepOn(block, pos, entity);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
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

    public void onPlace(BlockState state, World world, BlockPos pos, BlockState state2, boolean isMoving) {
        world.getBlockTicks().scheduleTick(pos, this, this.tickRate());
    }

}
