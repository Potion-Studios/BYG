package corgiaoc.byg.mixin.common.world;

import com.mojang.datafixers.util.Either;
import corgiaoc.byg.common.world.util.SurfaceContext;
import net.minecraft.server.level.ChunkHolder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ThreadedLevelLightEngine;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.chunk.ChunkStatus;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

@Mixin(ChunkStatus.class)
public class ChunkStatusMixin {
    @Inject(method = "generate", at = @At(value = "HEAD"))
    private void pushCarvingContext(ServerLevel worldIn,
                                    ChunkGenerator chunkGeneratorIn,
                                    StructureManager templateManagerIn,
                                    ThreadedLevelLightEngine lightManager,
                                    Function<ChunkAccess, CompletableFuture<Either<ChunkAccess, ChunkHolder.ChunkLoadingFailure>>> loadingFunction,
                                    List<ChunkAccess> chunks,
                                    CallbackInfoReturnable<CompletableFuture<Either<ChunkAccess, ChunkHolder.ChunkLoadingFailure>>> cir) {
        // Limit context to CARVERS (air carving stage)
        if (Objects.equals((ChunkStatus) (Object) this, ChunkStatus.SURFACE)) {
            // Refer to ChunkStatus::doGenerationWork for method of getting the main chunk.
            SurfaceContext.push(worldIn, chunks.get(chunks.size() / 2));
        }
    }
}