package corgiaoc.byg.mixin.access;

import net.minecraft.util.WeightedList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(WeightedList.class)
public interface WeightedListAccess<U> {

    @Accessor
    List<WeightedList.Entry<U>> getEntries();
}
