package potionstudios.byg.common.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.CampfireBlockEntity;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.common.world.BYGDamageTypes;

public class CampfireExplodingBlockItem extends BlockItem {

    public CampfireExplodingBlockItem(Block block, Properties $$0) {
        super(block, $$0);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos clickedPos = context.getClickedPos();
        if (!level.isClientSide) {
            if (level.getBlockEntity(clickedPos) instanceof CampfireBlockEntity blockEntity) {
                if (blockEntity.getItems().stream().anyMatch(ItemStack::isEmpty)) {
                    level.explode(null, new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(BYGDamageTypes.CATTAIL_EXPLOSION)), null, (double) clickedPos.getX() + 0.5D, (double) clickedPos.getY() + 0.5D, (double) clickedPos.getZ() + 0.5D, 5.0F, false, Level.ExplosionInteraction.NONE);
                    return InteractionResult.CONSUME;
                }
            }
        }

        return super.useOn(context);
    }
}
