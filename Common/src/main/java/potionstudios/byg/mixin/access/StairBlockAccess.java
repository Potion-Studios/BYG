package potionstudios.byg.mixin.access;

import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(StairBlock.class)
public interface StairBlockAccess {

    @Invoker("<init>")
    static StairBlock byg_create(BlockState state, BlockBehaviour.Properties properties) {
        throw new Error("Mixin did not apply!");
    }
}
