package potionstudios.byg.mixin.access;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(WoodType.class)
public interface WoodTypeAccess {

    @Invoker("<init>")
    static WoodType byg_create(String name, BlockSetType blockSetType) {
        throw new Error("Mixin did not apply!");
    }

    @Invoker("register")
    static WoodType byg_invokeRegister(WoodType woodType) {
        throw new Error("Mixin did not apply!");
    }
}