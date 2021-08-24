package corgiaoc.byg.mixin.access;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;

@Mixin(WorldCarver.class)
public interface WorldCarverAccess {

    @Accessor
    Set<Block> getReplaceableBlocks();

    @Accessor
    void setReplaceableBlocks(Set<Block> blocks);
}
