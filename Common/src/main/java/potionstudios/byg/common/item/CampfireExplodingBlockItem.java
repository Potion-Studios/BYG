package potionstudios.byg.common.item;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.CampfireBlockEntity;
import org.jetbrains.annotations.NotNull;

public class CampfireExplodingBlockItem extends BlockItem {
    private final String translationComponent;

    public CampfireExplodingBlockItem(Block block, String translationComponent, Properties $$0) {
        super(block, $$0);
        this.translationComponent = translationComponent;
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos clickedPos = context.getClickedPos();
        if (!level.isClientSide) {
            if (level.getBlockEntity(clickedPos) instanceof CampfireBlockEntity blockEntity) {
                if (blockEntity.getItems().stream().anyMatch(ItemStack::isEmpty)) {
                    level.explode(null, new CattailExplosionDamageSource(translationComponent), null, (double) clickedPos.getX() + 0.5D, (double) clickedPos.getY() + 0.5D, (double) clickedPos.getZ() + 0.5D, 5.0F, false, Level.ExplosionInteraction.NONE);
                    return InteractionResult.CONSUME;
                }
            }
        }

        return super.useOn(context);
    }

    public static class CattailExplosionDamageSource extends DamageSource {

        public CattailExplosionDamageSource(String translationComponent) {
            super(translationComponent);
        }
    }
}
