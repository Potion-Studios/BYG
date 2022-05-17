package potionstudios.byg.mixin.access;

import net.minecraft.tags.Tag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(Tag.Builder.class)
public interface TagBuilderAccess {

    @Accessor("entries")
    List<Tag.BuilderEntry> byg_getEntries();
}
