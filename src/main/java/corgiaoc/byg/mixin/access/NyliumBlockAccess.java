package corgiaoc.byg.mixin.access;

import net.minecraft.block.BlockState;
import net.minecraft.block.NyliumBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(NyliumBlock.class)
public interface NyliumBlockAccess {

    @Invoker
    static boolean invokeCanBeNylium(BlockState state, IWorldReader worldReader, BlockPos pos) {
        throw new Error("Mixin did not apply");
    }
}