package potionstudios.byg.mixin.access;

import net.minecraft.world.level.block.SnowyDirtBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(SnowyDirtBlock.class)
public interface SnowyDirtBlockAccess {

    @Invoker("<init>")
    static SnowyDirtBlock byg_create(BlockBehaviour.Properties properties) {
        throw new Error("Mixin did not apply");
    }
}