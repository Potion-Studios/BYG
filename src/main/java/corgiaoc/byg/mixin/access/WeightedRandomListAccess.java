package corgiaoc.byg.mixin.access;

import com.google.common.collect.ImmutableList;
import net.minecraft.util.random.WeightedEntry;
import net.minecraft.util.random.WeightedRandomList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(WeightedRandomList.class)
public interface WeightedRandomListAccess<E extends WeightedEntry> {

    @Accessor
    ImmutableList<E> getItems();
}
