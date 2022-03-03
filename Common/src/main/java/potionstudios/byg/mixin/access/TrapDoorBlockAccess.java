package potionstudios.byg.mixin.access;

import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(TrapDoorBlock.class)
public interface TrapDoorBlockAccess {

    @Invoker("<init>")
    static TrapDoorBlock byg_create(BlockBehaviour.Properties properties) {
        throw new Error("Mixin did not apply!");
    }
}
