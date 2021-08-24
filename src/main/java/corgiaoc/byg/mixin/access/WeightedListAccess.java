package corgiaoc.byg.mixin.access;

import net.minecraft.world.entity.ai.behavior.WeightedList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(WeightedList.class)
public interface WeightedListAccess<U> {

    @Accessor
    List<WeightedList.WeightedEntry<U>> getEntries();
}
