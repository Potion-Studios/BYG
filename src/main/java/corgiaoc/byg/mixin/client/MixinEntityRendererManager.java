package corgiaoc.byg.mixin.client;

import corgiaoc.byg.common.entity.boat.BYGBoatRenderer;
import corgiaoc.byg.core.BYGEntities;
import net.minecraft.client.GameSettings;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.resources.IReloadableResourceManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRendererManager.class)
public abstract class MixinEntityRendererManager {

    @Shadow
    public abstract <T extends Entity> void register(EntityType<T> entityType, EntityRenderer<? super T> entityRenderer);

    @Inject(method = "<init>", at = @At("RETURN"))
    private void registerBYGRenderers(TextureManager textureManager, ItemRenderer itemRenderer, IReloadableResourceManager resourceManager, FontRenderer fontRenderer, GameSettings settings, CallbackInfo ci) {
        register(BYGEntities.BOAT, new BYGBoatRenderer((EntityRendererManager) (Object) this));
    }
}
