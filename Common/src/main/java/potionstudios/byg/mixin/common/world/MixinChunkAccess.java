package potionstudios.byg.mixin.common.world;

import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.PositionalRandomFactory;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import javax.annotation.Nullable;

@Mixin(ChunkAccess.class)
public class MixinChunkAccess {

    @Shadow
    @Final
    protected ChunkPos chunkPos;

    @Shadow @Final protected LevelHeightAccessor levelHeightAccessor;
    @Nullable
    private PositionalRandomFactory random;
}
