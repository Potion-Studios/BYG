package potionstudios.byg.mixin.access;

import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(DoorBlock.class)
public interface DoorBlockAccess {

    @Invoker("<init>")
    static DoorBlock byg_create(BlockBehaviour.Properties properties) {
        throw new Error("Mixin did not apply!");
    }
}
