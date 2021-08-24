package corgiaoc.byg.mixin.access;

import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.placement.DecorationContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(DecorationContext.class)
public interface WorldDecoratingHelperAccess {

    @Accessor
    WorldGenLevel getLevel();

    @Accessor
    ChunkGenerator getGenerator();
}
