package potionstudios.byg.mixin.access;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;

@Mixin(WorldCarver.class)
public interface WorldCarverAccess {

    @Accessor("replaceableBlocks")
    Set<Block> byg_getReplaceableBlocks();

    @Accessor("replaceableBlocks") @Mutable
    void setReplaceableBlocks(Set<Block> replaceableBlocks);
}
