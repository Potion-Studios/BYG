package corgiaoc.byg.common.entity.boat;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.BoatModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;

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
            new ResourceLocation("byg:textures/entity/boat/palm.png"),
            new ResourceLocation("byg:textures/entity/boat/pine.png"),
            new ResourceLocation("byg:textures/entity/boat/rainbow_eucalyptus.png"),
            new ResourceLocation("byg:textures/entity/boat/redwood.png"),
            new ResourceLocation("byg:textures/entity/boat/skyris.png"),
            new ResourceLocation("byg:textures/entity/boat/willow.png"),
            new ResourceLocation("byg:textures/entity/boat/witch_hazel.png"),
            new ResourceLocation("byg:textures/entity/boat/zelkova.png")
    };
    protected final BoatModel modelBoat = new BoatModel();

    public BYGBoatRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn);
        this.shadowRadius = 0.8F;
    }

    @Override
    public void render(BYGBoatEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.translate(0.0D, 0.375D, 0.0D);
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180.0F - entityYaw));
        float f = (float) entityIn.getHurtTime() - partialTicks;
        float f1 = entityIn.getDamage() - partialTicks;
        if (f1 < 0.0F) {
            f1 = 0.0F;
        }

        if (f > 0.0F) {
            matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(MathHelper.sin(f) * f * f1 / 10.0F * (float) entityIn.getHurtDir()));
        }

        float f2 = entityIn.getBubbleAngle(partialTicks);
        if (!MathHelper.equal(f2, 0.0F)) {
            matrixStackIn.mulPose(new Quaternion(new Vector3f(1.0F, 0.0F, 1.0F), entityIn.getBubbleAngle(partialTicks), true));
        }

        matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90.0F));
        this.modelBoat.setupAnim(entityIn, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.modelBoat.renderType(this.getTextureLocation(entityIn)));
        this.modelBoat.renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        IVertexBuilder ivertexbuilder1 = bufferIn.getBuffer(RenderType.waterMask());
        this.modelBoat.waterPatch().render(matrixStackIn, ivertexbuilder1, packedLightIn, OverlayTexture.NO_OVERLAY);
        matrixStackIn.popPose();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    /**
     * Returns the location of an entity's texture.
     */
    @Override
    public ResourceLocation getTextureLocation(BYGBoatEntity entity) {
        return BOAT_TEXTURES[entity.getBYGBoatType().ordinal()];
    }
}
