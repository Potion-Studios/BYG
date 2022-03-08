package potionstudios.byg.mixin.access;

import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.SurfaceSystem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(SurfaceRules.Context.class)
public interface SurfaceRuleContextAccess {

    @Accessor("system")
    SurfaceSystem byg_getSystem();

    @Accessor("chunk")
    ChunkAccess byg_getChunk();

}
