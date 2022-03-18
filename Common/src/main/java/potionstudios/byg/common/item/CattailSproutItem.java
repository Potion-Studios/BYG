package potionstudios.byg.common.item;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.CampfireBlockEntity;

public class CattailSproutItem extends Item {
    public CattailSproutItem(Properties $$0) {
        super($$0);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos clickedPos = context.getClickedPos();
        if (!level.isClientSide) {
            if (level.getBlockEntity(clickedPos) instanceof CampfireBlockEntity blockEntity) {
                if (blockEntity.getItems().stream().anyMatch(ItemStack::isEmpty)) {
                    level.explode(null, new CattailExplosionDamageSource(), null, (double) clickedPos.getX() + 0.5D, (double) clickedPos.getY() + 0.5D, (double) clickedPos.getZ() + 0.5D, 5.0F, false, Explosion.BlockInteraction.NONE);
                    return InteractionResult.CONSUME;
                }
            }
        }

        return super.useOn(context);
    }

    public static class CattailExplosionDamageSource extends DamageSource {

        public CattailExplosionDamageSource() {
            super("byg.cattail_campfire");
        }
    }
}
