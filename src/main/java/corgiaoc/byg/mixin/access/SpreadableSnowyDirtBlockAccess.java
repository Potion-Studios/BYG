package corgiaoc.byg.mixin.access;

import net.minecraft.block.BlockState;
import net.minecraft.block.SpreadableSnowyDirtBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(SpreadableSnowyDirtBlock.class)
public interface SpreadableSnowyDirtBlockAccess {

    @Invoker
    static boolean invokeCanBeGrass(BlockState state, IWorldReader reader, BlockPos pos) {
        throw new Error("Mixin did not apply");
    }


    @Invoker
    static boolean invokeCanPropagate(BlockState state, IWorldReader reader, BlockPos pos) {
        throw new Error("Mixin did not apply");
    }
}
