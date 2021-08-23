package corgiaoc.byg.mixin.access;

import net.minecraft.util.WeightedList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(WeightedList.Entry.class)
public interface WeightedListEntryAccess {

    @Accessor
    int getWeight();
}
