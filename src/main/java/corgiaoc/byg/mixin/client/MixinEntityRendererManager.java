package corgiaoc.byg.mixin.client;

import corgiaoc.byg.common.entity.boat.BYGBoatRenderer;
import corgiaoc.byg.core.BYGEntities;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.server.packs.resources.ReloadableResourceManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderDispatcher.class)
public abstract class MixinEntityRendererManager {

    @Shadow
    protected abstract <T extends Entity> void register(EntityType<T> entityType, EntityRenderer<? super T> entityRenderer);

    @Inject(method = "registerRenderers", at = @At("RETURN"))
    private void registerBYGRenderers(ItemRenderer itemRenderer, ReloadableResourceManager reloadableResourceManager, CallbackInfo ci) {
        register(BYGEntities.BOAT, new BYGBoatRenderer((EntityRenderDispatcher) (Object) this));
    }
}
