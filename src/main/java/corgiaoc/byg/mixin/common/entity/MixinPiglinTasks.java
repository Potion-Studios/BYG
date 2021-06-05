package corgiaoc.byg.mixin.common.entity;

import corgiaoc.byg.core.BYGItems;
import it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenHashMap;
import net.minecraft.entity.monster.piglin.PiglinEntity;
import net.minecraft.entity.monster.piglin.PiglinTasks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Util;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Map;
import java.util.Random;

@Mixin(PiglinTasks.class)
public class MixinPiglinTasks {

    //Weight to item stack
    private static final Reference2ReferenceOpenHashMap<Double, ItemStack> BYG_BARTER_ITEMS = Util.make(new Reference2ReferenceOpenHashMap<>(), (map) -> {
        map.put(0.2, new ItemStack(BYGItems.ANTHRACITE, 8));
        map.put(0.05, new ItemStack(BYGItems.EMERALDITE_SHARDS, 1));
        map.put(0.045, new ItemStack(BYGItems.RAW_PENDORITE, 1));
    });

    @Inject(method = "getBarterResponseItems", at = @At("RETURN"), cancellable = true)
    private static void addBYGBlocksForBarter(PiglinEntity piglin, CallbackInfoReturnable<List<ItemStack>> cir) {
        for (Map.Entry<Double, ItemStack> entry : BYG_BARTER_ITEMS.entrySet()) {
            Double weight = entry.getKey();
            ItemStack itemstack = entry.getValue();

            Random random = piglin.level.getRandom();
            if (random.nextDouble() < weight) {
                cir.getReturnValue().add(new ItemStack(itemstack.getItem(), random.nextInt(itemstack.getCount())));
            }
        }
    }
}
