package potionstudios.byg.common.entity.pumpkinwarden;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemDisplayContext;
import potionstudios.byg.BYG;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class PumpkinWardenRenderer<T extends PumpkinWarden> extends GeoEntityRenderer<T> {

    public static final ModelLayerLocation MODEL_LAYER = new ModelLayerLocation(BYG.createLocation("pumpkinwarden"), "main");

    public PumpkinWardenRenderer(EntityRendererProvider.Context context) {
        super(context, new PumpkinWardenModel<T>());
    }

    @Override
    public void render(T entity, float entityYaw, float partialTicks, PoseStack stack, MultiBufferSource bufferIn, int packedLightIn) {
        stack.scale(0.5f, 0.5f, 0.5f);
        shadowRadius = 0.8f;
        super.render(entity, entityYaw, partialTicks, stack, bufferIn, packedLightIn);
    }

    @Override
    public void renderRecursively(PoseStack stack, T animatable, GeoBone bone, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        if (bone.getName().equals("RightArm")) {
            stack.pushPose();
            stack.mulPose(Axis.XP.rotationDegrees(15));
            stack.mulPose(Axis.YP.rotationDegrees(0));
            stack.mulPose(Axis.ZP.rotationDegrees(3.5f));
            stack.translate(0.05D, 0.2D, -1D);
            stack.scale(2f, 2f, 2f);
            Minecraft.getInstance().getItemRenderer().renderStatic(animatable.getMainHandItem(), ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, packedLight, packedOverlay, stack, bufferSource, animatable.getLevel(), 1);
            stack.popPose();
            buffer = bufferSource.getBuffer(RenderType.entityTranslucent(((GeoEntityRenderer)this).getTextureLocation((Entity) animatable)));
        }

        super.renderRecursively(stack, animatable, bone, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);


    }
}
