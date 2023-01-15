package potionstudios.byg.common.entity.pumpkinwarden;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import potionstudios.byg.BYG;
import software.bernie.geckolib3.geo.render.built.GeoBone;
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

    @Override
    public void renderRecursively(GeoBone bone, PoseStack stack, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        if (bone.getName().equals("RightArm")) {
            stack.pushPose();
            stack.mulPose(Vector3f.XP.rotationDegrees(15));
            stack.mulPose(Vector3f.YP.rotationDegrees(0));
            stack.mulPose(Vector3f.ZP.rotationDegrees(3.5f));
            stack.translate(0.05D, 0.2D, -1D);
            stack.scale(2f, 2f, 2f);
            Minecraft.getInstance().getItemRenderer().renderStatic(mainHand, ItemTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, packedLightIn, packedOverlayIn, stack, this.rtb, 1);
            stack.popPose();
            bufferIn = rtb.getBuffer(RenderType.entityTranslucent(whTexture));
        }
        super.renderRecursively(bone, stack, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }
}
