package corgiaoc.byg.mixin.access;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SpreadingSnowyDirtBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(SpreadingSnowyDirtBlock.class)
public interface SpreadableSnowyDirtBlockAccess {

    @Invoker
    static boolean invokeCanBeGrass(BlockState state, LevelReader reader, BlockPos pos) {
        throw new Error("Mixin did not apply");
    }


    @Invoker
    static boolean invokeCanPropagate(BlockState state, LevelReader reader, BlockPos pos) {
        throw new Error("Mixin did not apply");
    }
}
