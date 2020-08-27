package voronoiaoc.byg.common.entity.boat;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class BYGBoatRenderer extends EntityRenderer<BYGBoatEntity> {

    private static final ResourceLocation[] BOAT_TEXTURES = new ResourceLocation[]{
            new ResourceLocation("byg:textures/entity/boat/aspen.png"),
            new ResourceLocation("byg:textures/entity/boat/baobab.png"),
            new ResourceLocation("byg:textures/entity/boat/blue_enchanted.png"),
            new ResourceLocation("byg:textures/entity/boat/cherry.png"),
            new ResourceLocation("byg:textures/entity/boat/cika.png"),
            new ResourceLocation("byg:textures/entity/boat/cypress.png"),
            new ResourceLocation("byg:textures/entity/boat/ebony.png"),
            new ResourceLocation("byg:textures/entity/boat/fir.png"),
            new ResourceLocation("byg:textures/entity/boat/green_enchanted.png"),
            new ResourceLocation("byg:textures/entity/boat/holly.png"),
            new ResourceLocation("byg:textures/entity/boat/jacaranda.png"),
            new ResourceLocation("byg:textures/entity/boat/mahogany.png"),
            new ResourceLocation("byg:textures/entity/boat/mangrove.png"),
            new ResourceLocation("byg:textures/entity/boat/maple.png"),
            new ResourceLocation("byg:textures/entity/boat/pine.png"),
            new ResourceLocation("byg:textures/entity/boat/rainbow_eucalyptus.png"),
            new ResourceLocation("byg:textures/entity/boat/redwood.png"),
            new ResourceLocation("byg:textures/entity/boat/skyris.png"),
            new ResourceLocation("byg:textures/entity/boat/willow.png"),
            new ResourceLocation("byg:textures/entity/boat/witch_hazel.png"),
            new ResourceLocation("byg:textures/entity/boat/zelkova.png")
    };
    protected final BoatModel model = new BoatModel();

    public BYGBoatRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher);
        this.shadowRadius = 0.8F;
        //BYG.LOGGER.info("ACCESSING");

    }

    @Override
    public void render(BYGBoatEntity bygBoatEntity, float f, float g, PoseStack matrixStack, MultiBufferSource vertexConsumerProvider, int i) {
        //BYG.LOGGER.info("RENDERED");
        matrixStack.pushPose();
        matrixStack.translate(0.0D, 0.375D, 0.0D);
        matrixStack.mulPose(Vector3f.YP.rotationDegrees(180.0F - f));
        float h = (float) bygBoatEntity.getHurtTime() - g;
        float j = bygBoatEntity.getDamage() - g;
        if (j < 0.0F) {
            j = 0.0F;
        }

        if (h > 0.0F) {
            matrixStack.mulPose(Vector3f.XP.rotationDegrees(Mth.sin(h) * h * j / 10.0F * (float) bygBoatEntity.getHurtDir()));
        }

        float k = bygBoatEntity.getBubbleAngle(g);
        if (!Mth.equal(k, 0.0F)) {
            matrixStack.mulPose(new Quaternion(new Vector3f(1.0F, 0.0F, 1.0F), bygBoatEntity.getBubbleAngle(g), true));
        }

        matrixStack.scale(-1.0F, -1.0F, 1.0F);
        matrixStack.mulPose(Vector3f.YP.rotationDegrees(90.0F));
        this.model.setupAnim(bygBoatEntity, g, 0.0F, -0.1F, 0.0F, 0.0F);
        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(this.model.renderType(this.getTextureLocation(bygBoatEntity)));
        this.model.renderToBuffer(matrixStack, vertexConsumer, i, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        if (!bygBoatEntity.isUnderWater()) {
            VertexConsumer vertexConsumer2 = vertexConsumerProvider.getBuffer(RenderType.waterMask());
            this.model.waterPatch().render(matrixStack, vertexConsumer2, i, OverlayTexture.NO_OVERLAY);
        }

        matrixStack.popPose();
        //BYG.LOGGER.info("RENDERED");
        super.render(bygBoatEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public ResourceLocation getTextureLocation(BYGBoatEntity boatEntity) {
        return BOAT_TEXTURES[boatEntity.getBYGBoatType().ordinal()];
    }
}
