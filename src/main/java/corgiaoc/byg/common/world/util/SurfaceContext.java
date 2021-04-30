package corgiaoc.byg.common.world.util;

import corgiaoc.byg.BYG;
import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.server.ServerWorld;

import java.lang.ref.WeakReference;

/**
 * This class stores surface context on the thread and allows it to be accessed statically.
 * Implementation stolen from the following PR: https://github.com/yungnickyoung/YUNGs-Better-Caves/pull/105 with YUNGNICKYOUNG's permission!
 */
public class SurfaceContext {

    private static final ThreadLocal<SurfaceContext> CONTEXT = new ThreadLocal<>();

    private final WeakReference<ServerWorld> world;

    public SurfaceContext(ServerWorld world) {
        this.world = new WeakReference<>(world);
    }

    public ServerWorld getWorld() {
        return world.get();
    }


    /**
     * Consume the currently held SurfaceContext.
     * A null value means we are in the wrong generation stage, or the context has already been consumed.
     */
    @Nullable
    public static SurfaceContext pop() {
        SurfaceContext context = CONTEXT.get();
        CONTEXT.set(null);
        return context;
    }

    /**
     * Peek the currently held SurfaceContext without consuming it.
     * A null value means we are in the wrong generation stage, or the context has already been consumed.
     */
    @Nullable
    public static SurfaceContext peek() {
        return CONTEXT.get();
    }

    /**
     * Should only be called during the surface builder stage (ChunkStatus.SURFACE).
     */
    public static void push(ServerWorld world, IChunk chunk) {
        if (chunk instanceof ChunkPrimer) {
            CONTEXT.set(new SurfaceContext(world));
        } else if (chunk != null) {
            // Shouldn't ever happen unless another mod has done a similar hook in ChunkStatus and changed the IChunk type
            BYG.LOGGER.error("ERROR: Attempted to push invalid IChunk implementation to SurfaceContext: {}", chunk.getClass());
        }
    }
}
