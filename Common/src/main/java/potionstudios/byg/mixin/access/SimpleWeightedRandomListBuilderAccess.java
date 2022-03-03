package potionstudios.byg.mixin.access;

import com.google.common.collect.ImmutableList;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.random.WeightedEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(SimpleWeightedRandomList.Builder.class)
public interface SimpleWeightedRandomListBuilderAccess<E> {

    @Accessor("result")
    ImmutableList.Builder<WeightedEntry.Wrapper<E>> byg_getResult();
}
