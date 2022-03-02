package potionstudios.byg.mixin.access;

import net.minecraft.util.random.Weight;
import net.minecraft.util.random.WeightedEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(WeightedEntry.Wrapper.class)
public interface WeightedEntryWrapperAccess<T> {

    @Accessor
    T getData();

    @Accessor
    Weight getWeight();
}
