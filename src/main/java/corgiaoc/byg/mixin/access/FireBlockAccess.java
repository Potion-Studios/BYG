package corgiaoc.byg.mixin.access;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FireBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(FireBlock.class)
public interface FireBlockAccess {

    @Invoker
    void invokeSetFlammable(Block block, int flameOdd, int burnOdd);
}
