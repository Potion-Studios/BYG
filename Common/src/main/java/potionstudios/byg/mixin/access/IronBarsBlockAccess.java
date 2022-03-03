package potionstudios.byg.mixin.access;

import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(IronBarsBlock.class)
public interface IronBarsBlockAccess {

    @Invoker("<init>")
    static IronBarsBlock byg_create(BlockBehaviour.Properties properties) {
        throw new Error("Mixin did not apply!");
    }
}
