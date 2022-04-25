package potionstudios.byg.client;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import potionstudios.byg.common.entity.BYGEntities;
import potionstudios.byg.common.entity.boat.BYGBoatRenderer;

public class BYGEntityRenderers {

    public static <T extends Entity> void register(RegisterStrategy registerStrategy) {
        registerStrategy.register(BYGEntities.BOAT, BYGBoatRenderer::new);
    }

    @FunctionalInterface
    public interface RegisterStrategy {
        <T extends Entity> void register(EntityType<? extends T> entityType, EntityRendererProvider<T> entityRendererProvider);
    }
}
