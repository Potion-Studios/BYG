package corgiaoc.byg.mixin.access;

import net.minecraft.world.level.block.GrassPathBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(GrassPathBlock.class)
public interface GrassPathBlockAccess {

    @Invoker("<init>")
    static GrassPathBlock create(BlockBehaviour.Properties properties) {
        throw new Error("Mixin did not apply!");
    }
}
