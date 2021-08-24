package corgiaoc.byg.mixin.access;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.blockplacers.BlockPlacer;
import net.minecraft.world.level.levelgen.feature.blockplacers.BlockPlacerType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BlockPlacerType.class)
public interface BlockPlacerTypeAccess {

    @Invoker("<init>")
    static <P extends BlockPlacer> BlockPlacerType<P> create(Codec<P> codec) {
        throw new Error("Mixin did not apply!");
    }
}
