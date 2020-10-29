package corgiaoc.byg.common.properties.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@SuppressWarnings("deprecation")
public class BYGFrostMagmaBlock extends Block {
    public BYGFrostMagmaBlock(Settings properties) {
        super(properties);
    }

    public void onSteppedOn(World block, BlockPos pos, Entity entity) {
        if (!entity.isFireImmune() && entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity) entity)) {
            entity.damage(DamageSource.HOT_FLOOR, 1.0F);
        }


        super.onSteppedOn(block, pos, entity);
    }

    public int tickRate() {
        return 20;
    }

    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState state2, boolean isMoving) {
        world.getBlockTickScheduler().schedule(pos, this, this.tickRate());
    }

}
