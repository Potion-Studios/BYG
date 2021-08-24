package corgiaoc.byg.mixin.access;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.NyliumBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(NyliumBlock.class)
public interface NyliumBlockAccess {

    @Invoker
    static boolean invokeCanBeNylium(BlockState state, LevelReader worldReader, BlockPos pos) {
        throw new Error("Mixin did not apply");
    }
}