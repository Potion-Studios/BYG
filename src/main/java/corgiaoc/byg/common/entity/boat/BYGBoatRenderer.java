package corgiaoc.byg.common.entity.boat;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.model.BoatEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Quaternion;

public class BYGBoatRenderer extends EntityRenderer<BYGBoatEntity> {

    private static final Identifier[] BOAT_TEXTURES = new Identifier[]{
            new Identifier("byg:textures/entity/boat/aspen.png"),
            new Identifier("byg:textures/entity/boat/baobab.png"),
            new Identifier("byg:textures/entity/boat/blue_enchanted.png"),
            new Identifier("byg:textures/entity/boat/cherry.png"),
            new Identifier("byg:textures/entity/boat/cika.png"),
            new Identifier("byg:textures/entity/boat/cypress.png"),
            new Identifier("byg:textures/entity/boat/ebony.png"),
            new Identifier("byg:textures/entity/boat/fir.png"),
            new Identifier("byg:textures/entity/boat/green_enchanted.png"),
            new Identifier("byg:textures/entity/boat/holly.png"),
            new Identifier("byg:textures/entity/boat/jacaranda.png"),
            new Identifier("byg:textures/entity/boat/mahogany.png"),
            new Identifier("byg:textures/entity/boat/mangrove.png"),
            new Identifier("byg:textures/entity/boat/maple.png"),
            new Identifier("byg:textures/entity/boat/palm.png"),
            new Identifier("byg:textures/entity/boat/pine.png"),
            new Identifier("byg:textures/entity/boat/rainbow_eucalyptus.png"),
            new Identifier("byg:textures/entity/boat/redwood.png"),
            new Identifier("byg:textures/entity/boat/skyris.png"),
            new Identifier("byg:textures/entity/boat/willow.png"),
            new Identifier("byg:textures/entity/boat/witch_hazel.png"),
            new Identifier("byg:textures/entity/boat/zelkova.png")
    };
    protected final BoatEntityModel model = new BoatEntityModel();

    public BYGBoatRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher);
        this.shadowRadius = 0.8F;
    }

    @Override
    public void render(BYGBoatEntity bygBoatEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        //BYG.LOGGER.info("RENDERED");
        matrixStack.push();
        matrixStack.translate(0.0D, 0.375D, 0.0D);
        matrixStack.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(180.0F - f));
        float h = (float) bygBoatEntity.getDamageWobbleTicks() - g;
        float j = bygBoatEntity.getDamageWobbleStrength() - g;
        if (j < 0.0F) {
            j = 0.0F;
        }

        if (h > 0.0F) {
            matrixStack.multiply(Vector3f.POSITIVE_X.getDegreesQuaternion(MathHelper.sin(h) * h * j / 10.0F * (float) bygBoatEntity.getDamageWobbleSide()));
        }

        float k = bygBoatEntity.interpolateBubbleWobble(g);
        if (!MathHelper.approximatelyEquals(k, 0.0F)) {
            matrixStack.multiply(new Quaternion(new Vector3f(1.0F, 0.0F, 1.0F), bygBoatEntity.interpolateBubbleWobble(g), true));
        }

        matrixStack.scale(-1.0F, -1.0F, 1.0F);
        matrixStack.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(90.0F));
        this.model.setAngles(bygBoatEntity, g, 0.0F, -0.1F, 0.0F, 0.0F);
        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(this.model.getLayer(this.getTexture(bygBoatEntity)));
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        if (!bygBoatEntity.isSubmergedInWater()) {
            VertexConsumer vertexConsumer2 = vertexConsumerProvider.getBuffer(RenderLayer.getWaterMask());
            this.model.getBottom().render(matrixStack, vertexConsumer2, i, OverlayTexture.DEFAULT_UV);
        }

        matrixStack.pop();
        super.render(bygBoatEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(BYGBoatEntity entity) {
        return BOAT_TEXTURES[entity.getBYGBoatType().ordinal()];
    }
}