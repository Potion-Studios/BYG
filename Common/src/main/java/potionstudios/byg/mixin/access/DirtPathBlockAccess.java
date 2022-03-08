package potionstudios.byg.mixin.access;

import net.minecraft.world.level.block.DirtPathBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(DirtPathBlock.class)
public interface DirtPathBlockAccess {

    @Invoker("<init>")
    static DirtPathBlock byg_create(BlockBehaviour.Properties properties) {
        throw new Error("Mixin did not apply!");
    }
}
