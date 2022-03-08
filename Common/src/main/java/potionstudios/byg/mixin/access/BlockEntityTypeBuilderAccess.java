package potionstudios.byg.mixin.access;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;

@Mixin(BlockEntityType.Builder.class)
public interface BlockEntityTypeBuilderAccess<T> {

    @Accessor("validBlocks")
    Set<Block> byg_getValidBlocks();
}