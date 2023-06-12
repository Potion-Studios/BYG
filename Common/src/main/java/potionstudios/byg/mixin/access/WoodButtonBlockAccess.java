package potionstudios.byg.mixin.access;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Blocks.class)
public interface WoodButtonBlockAccess {

    @Invoker("woodenButton")
    static ButtonBlock byg_create() {
        throw new Error("Mixin did not apply!");
    }
}
