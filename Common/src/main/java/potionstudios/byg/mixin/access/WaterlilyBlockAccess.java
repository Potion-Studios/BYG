package potionstudios.byg.mixin.access;

import net.minecraft.world.level.block.WaterlilyBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(WaterlilyBlock.class)
public interface WaterlilyBlockAccess {

    @Invoker("<init>")
    static WaterlilyBlock byg_create(BlockBehaviour.Properties properties) {
        throw new Error("Mixin did not apply");
    }
}
