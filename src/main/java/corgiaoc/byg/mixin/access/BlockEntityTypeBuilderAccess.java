package corgiaoc.byg.mixin.access;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;

@Mixin(TileEntityType.Builder.class)
public interface BlockEntityTypeBuilderAccess<T> {

    @Accessor
    Set<Block> getValidBlocks();
}