package potionstudios.byg.mixin.dev;

import net.minecraft.tags.TagBuilder;
import net.minecraft.tags.TagEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(TagBuilder.class)
public interface TagBuilderAccess {
    @Accessor
    List<TagEntry> getEntries();
}
