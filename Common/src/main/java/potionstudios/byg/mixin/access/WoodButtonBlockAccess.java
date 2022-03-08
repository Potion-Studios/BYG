package potionstudios.byg.mixin.access;

import net.minecraft.world.level.block.WoodButtonBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(WoodButtonBlock.class)
public interface WoodButtonBlockAccess {

    @Invoker("<init>")
    static WoodButtonBlock byg_create(BlockBehaviour.Properties properties) {
        throw new Error("Mixin did not apply!");
    }
}
