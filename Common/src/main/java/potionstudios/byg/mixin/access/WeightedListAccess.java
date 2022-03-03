package potionstudios.byg.mixin.access;


import com.google.common.collect.ImmutableList;
import net.minecraft.util.random.WeightedRandomList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(WeightedRandomList.class)
public interface WeightedListAccess<E> {

    @Accessor("totalWeight")
    int byg_getTotalWeight();

    @Accessor("items")
    ImmutableList<E> byg_getItems();
}