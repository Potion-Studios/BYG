package potionstudios.byg.common.entity.boat;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Axis;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.joml.Quaternionf;
import potionstudios.byg.BYG;
import potionstudios.byg.common.registration.BYGBlockFamilies;
import potionstudios.byg.common.registration.BYGBlockFamily;
import potionstudios.byg.util.ModPlatform;

import java.util.HashMap;
import java.util.Map;

public class BYGBoatRenderer extends EntityRenderer<BYGBoat> {

    private final Map<BYGBlockFamily, Pair<ResourceLocation, BoatModel>> boatResources;

    public BYGBoatRenderer(EntityRendererProvider.Context context, boolean hasChest) {
        super(context);
        this.shadowRadius = 0.8F;
        this.boatResources = ModPlatform.INSTANCE.hasLoadErrors() ? new HashMap<>() :
                BYGBlockFamilies.woodFamilyMap.values().stream()
                        .collect(ImmutableMap.toImmutableMap((bygType) -> {
                    return bygType;
                }, (bygType) -> {
                    return Pair.of(BYG.createLocation(getTextureLocation(bygType, hasChest)), this.createBoatModel(context, bygType, hasChest));
                }));
    }

    private BoatModel createBoatModel(EntityRendererProvider.Context context, BYGBlockFamily bygType, boolean hasChest) {
        ModelLayerLocation modellayerlocation = hasChest ? createChestBoatModelName(bygType) : createBoatModelName(bygType);
        return hasChest ? new ChestBoatModel(context.bakeLayer(modellayerlocation)) : new BoatModel(context.bakeLayer(modellayerlocation));
    }

    public static ModelLayerLocation createChestBoatModelName(BYGBlockFamily type) {
        return new ModelLayerLocation(BYG.createLocation("chest_boat/" + type.getBaseName()), "main");
    }

    public static ModelLayerLocation createBoatModelName(BYGBlockFamily type) {
        return new ModelLayerLocation(BYG.createLocation("boat/" + type.getBaseName()), "main");
    }

    private static String getTextureLocation(BYGBlockFamily bygType, boolean hasChest) {
        return hasChest ? "textures/entity/chest_boat/" + bygType.getBaseName() + ".png" : "textures/entity/boat/"
                + bygType.getBaseName() + ".png";
    }

    @Override
    public void render(BYGBoat boat, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource multiBufferSource, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.translate(0.0D, 0.375D, 0.0D);
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(180.0F - entityYaw));
        float h = (float) boat.getHurtTime() - partialTicks;
        float j = boat.getDamage() - partialTicks;
        if (j < 0.0F) {
            j = 0.0F;
        }
        if (h > 0.0F) {
            matrixStackIn.mulPose(Axis.XP.rotationDegrees(Mth.sin(h) * h * j / 10.0F * (float) boat.getHurtDir()));
        }

        float k = boat.getBubbleAngle(partialTicks);
        if (!Mth.equal(k, 0.0F)) {
            matrixStackIn.mulPose(new Quaternionf().setAngleAxis(boat.getBubbleAngle(partialTicks) * ((float)Math.PI / 180F), 1.0F, 0.0F, 1.0F));
        }
        Pair<ResourceLocation, BoatModel> pair = this.boatResources.get(boat.getBYGBoatType());
        ResourceLocation resourceLocation = (ResourceLocation) pair.getFirst();
        BoatModel boatModel = (BoatModel) pair.getSecond();
        matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(90.0F));
        boatModel.setupAnim(boat, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(boatModel.renderType(resourceLocation));
        boatModel.renderToBuffer(matrixStackIn, vertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        if (!boat.isUnderWater()) {
            VertexConsumer vertexConsumer2 = multiBufferSource.getBuffer(RenderType.waterMask());
            boatModel.waterPatch().render(matrixStackIn, vertexConsumer2, packedLightIn, OverlayTexture.NO_OVERLAY);
        }
        matrixStackIn.popPose();
        super.render(boat, entityYaw, partialTicks, matrixStackIn, multiBufferSource, packedLightIn);
    }

    /**
     * Returns the location of an entity's texture.
     */
    public ResourceLocation getTextureLocation(BYGBoat boat) {
        return this.boatResources.get(boat.getBYGBoatType()).getFirst();
    }
}
