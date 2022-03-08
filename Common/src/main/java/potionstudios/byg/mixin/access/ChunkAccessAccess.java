package potionstudios.byg.mixin.access;

import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.NoiseChunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import javax.annotation.Nullable;

@Mixin(ChunkAccess.class)
public interface ChunkAccessAccess {

    @Accessor("noiseChunk")
    @Nullable
    NoiseChunk byg_getNoiseChunk();
}
