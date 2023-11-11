package potionstudios.byg.common.entity.manowar;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.BYG;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

import java.util.Map;

public class ManOWarRenderer<T extends ManOWar> extends GeoEntityRenderer<T> {

    public static final Map<ManOWar.Colors, ResourceLocation> TEXTURES = Util.make(Maps.newEnumMap(ManOWar.Colors.class), (map) -> {
        map.put(ManOWar.Colors.MAGENTA, BYG.createLocation("textures/entity/manowar/magenta.png"));
        map.put(ManOWar.Colors.RAINBOW, BYG.createLocation("textures/entity/manowar/rainbow.png"));
        map.put(ManOWar.Colors.PURPLE, BYG.createLocation("textures/entity/manowar/purple.png"));
        map.put(ManOWar.Colors.BLUE, BYG.createLocation("textures/entity/manowar/blue.png"));

    });


    public ManOWarRenderer(EntityRendererProvider.Context context) {
        super(context, new ManOWarModel<>());
        this.addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }

    @Override
    public void render(T entity, float entityYaw, float partialTicks, @NotNull PoseStack stack, @NotNull MultiBufferSource bufferIn, int packedLightIn) {
        if (entity.isBaby()) {
            stack.scale(0.5f, 0.5f, 0.5f);
            shadowRadius = 0.5f;
        } else {
            shadowRadius = 0.8f;
        }
        super.render(entity, entityYaw, partialTicks, stack, bufferIn, packedLightIn);
    }

    /**
     * Returns the location of an entity's texture.
     */
    @Override
    public @NotNull ResourceLocation getTextureLocation(T entity) {
        return TEXTURES.get(entity.getColor());
    }


    protected void applyRotations(T squid, PoseStack poseStack, float f, float g, float h) {
        float i = Mth.lerp(h, squid.xBodyRotO, squid.xBodyRot);
        float j = Mth.lerp(h, squid.zBodyRotO, squid.zBodyRot);
        poseStack.translate(0.0D, 0.5D, 0.0D);
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - g));
        poseStack.mulPose(Axis.XP.rotationDegrees(i));
        poseStack.mulPose(Axis.YP.rotationDegrees(j));
        poseStack.translate(0.0D, -1.2000000476837158D, 0.0D);
    }
}
