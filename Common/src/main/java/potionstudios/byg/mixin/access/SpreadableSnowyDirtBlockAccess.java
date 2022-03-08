package potionstudios.byg.mixin.access;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SpreadingSnowyDirtBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(SpreadingSnowyDirtBlock.class)
public interface SpreadableSnowyDirtBlockAccess {

    @Invoker("canBeGrass")
    static boolean byg_invokeCanBeGrass(BlockState state, LevelReader reader, BlockPos pos) {
        throw new Error("Mixin did not apply");
    }


    @Invoker("canPropagate")
    static boolean byg_invokeCanPropagate(BlockState state, LevelReader reader, BlockPos pos) {
        throw new Error("Mixin did not apply");
    }
}
