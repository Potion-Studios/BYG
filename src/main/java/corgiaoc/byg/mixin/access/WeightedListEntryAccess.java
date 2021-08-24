package corgiaoc.byg.mixin.access;

import net.minecraft.world.entity.ai.behavior.WeightedList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(WeightedList.WeightedEntry.class)
public interface WeightedListEntryAccess {

    @Accessor
    int getWeight();
}
