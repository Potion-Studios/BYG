package potionstudios.byg.mixin.access;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(LeavesBlock.class)
public interface LeavesBlockAccess {


    @Invoker("updateDistance")
    static BlockState byg_invokeUpdateDistance(BlockState $$0, LevelAccessor $$1, BlockPos $$2) {
        throw new Error("Mixin did not apply!");
    }
}
