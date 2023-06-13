package potionstudios.byg.mixin.access;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BlockSetType.class)
public interface BlockSetTypeAccess {

    @Invoker("register")
    static BlockSetType byg_invokeRegister(BlockSetType blockSetType) {
        throw new Error("Mixin did not apply!");
    }
}
