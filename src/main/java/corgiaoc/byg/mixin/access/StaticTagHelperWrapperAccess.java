package corgiaoc.byg.mixin.access;

import net.minecraft.tags.StaticTagHelper;
import net.minecraft.tags.Tag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(StaticTagHelper.Wrapper.class)
public interface StaticTagHelperWrapperAccess<T> {

    @Accessor
    Tag<T> getTag();
}
