package corgiaoc.byg.mixin.common.block;

import corgiaoc.byg.core.BYGItems;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(AbstractFurnaceBlockEntity.class)
public class MixinAbstractFurnaceBlockEntity {


    @Inject(at = @At("RETURN"), method = "createFuelTimeMap()Ljava/util/Map;", cancellable = true)
    private static void injectBYGFuels(CallbackInfoReturnable<Map<Item, Integer>> cir) {
        cir.getReturnValue().put(BYGItems.ANTHRACITE, 2400);
        cir.getReturnValue().put(BYGItems.ANTHRACITE_BLOCK, 20000);

    }
}