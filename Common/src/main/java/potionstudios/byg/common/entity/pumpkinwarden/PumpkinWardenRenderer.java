package potionstudios.byg.common.entity.pumpkinwarden;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import potionstudios.byg.BYG;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class PumpkinWardenRenderer<T extends PumpkinWarden> extends GeoEntityRenderer<T> {

    public static final ModelLayerLocation MODEL_LAYER = new ModelLayerLocation(BYG.createLocation("pumpkinwarden"), "main");

    public PumpkinWardenRenderer(EntityRendererProvider.Context context) {
        super(context, new PumpkinWardenModel());
    }

    @Override
    public void render(T entity, float entityYaw, float partialTicks, PoseStack stack, MultiBufferSource bufferIn, int packedLightIn) {
        stack.scale(0.5f, 0.5f, 0.5f);
        shadowRadius = 0.8f;
        super.render(entity, entityYaw, partialTicks, stack, bufferIn, packedLightIn);
    }

    /**
     * Returns the location of an entity's texture.
     */
    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return BYG.createLocation("textures/entity/pumpkin_warden.png");
    }
}
