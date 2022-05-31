package potionstudios.byg.mixin.access.client;

import net.minecraft.client.gui.components.EditBox;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(EditBox.class)
public interface EditBoxAccess {


    @Accessor("textColor")
    int byg_getTextColor();
}
