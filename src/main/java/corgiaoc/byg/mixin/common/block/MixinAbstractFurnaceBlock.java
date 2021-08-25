package corgiaoc.byg.mixin.common.block;

import corgiaoc.byg.core.BYGItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(AbstractFurnaceBlockEntity.class)
public class MixinAbstractFurnaceBlock {

    @Inject(method = "getFuel", at = @At("RETURN"))
    private static void addBYGFuels(CallbackInfoReturnable<Map<Item, Integer>> cir) {
        cir.getReturnValue().put(BYGItems.LIGNITE_BLOCK, 14000);
        cir.getReturnValue().put(BYGItems.LIGNITE, 1400);
        cir.getReturnValue().put(BYGItems.ANTHRACITE_BLOCK, 20000);
        cir.getReturnValue().put(BYGItems.ANTHRACITE, 2400);
        cir.getReturnValue().put(BYGItems.PEAT, 1200);
    }
}
