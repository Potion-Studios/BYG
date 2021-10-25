package corgiaoc.byg.common.entity.manowar;

import com.google.common.collect.Maps;
import corgiaoc.byg.BYG;
import net.minecraft.Util;
import net.minecraft.client.model.SquidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class ManOWarRenderer <T extends ManOWar> extends MobRenderer<T, ManOWarModel<T>> {

    public static final Map<ManOWar.Colors, ResourceLocation> TEXTURES = Util.make(Maps.newEnumMap(ManOWar.Colors.class), (map) -> {
        map.put(ManOWar.Colors.MAGENTA, new ResourceLocation(BYG.MOD_ID, "textures/entity/manowar/magenta.png"));
        map.put(ManOWar.Colors.RAINBOW, new ResourceLocation(BYG.MOD_ID, "textures/entity/manowar/rainbow.png"));
        map.put(ManOWar.Colors.PURPLE, new ResourceLocation(BYG.MOD_ID, "textures/entity/manowar/purple.png"));
        map.put(ManOWar.Colors.BLUE, new ResourceLocation(BYG.MOD_ID, "textures/entity/manowar/blue.png"));

    });

    public static final ModelLayerLocation MODEL_LAYER = new ModelLayerLocation(new ResourceLocation(BYG.MOD_ID, "man_o_war"), "main");

    public ManOWarRenderer(EntityRendererProvider.Context context) {
        super(context, new ManOWarModel(context.bakeLayer(MODEL_LAYER)), 0.7F);
    }

    /**
     * Returns the location of an entity's texture.
     */
    public ResourceLocation getTextureLocation(T entity) {
        return TEXTURES.get(entity.getColor());
    }

//    protected void setupRotations(T entity, PoseStack poseStack, float f, float g, float h) {
//        float i = Mth.lerp(h, entity.xBodyRotO, entity.xBodyRot);
//        float j = Mth.lerp(h, entity.zBodyRotO, entity.zBodyRot);
//        poseStack.translate(0.0D, 0.5D, 0.0D);
//        poseStack.mulPose(Vector3f.YP.rotationDegrees(180.0F - g));
//        poseStack.mulPose(Vector3f.XP.rotationDegrees(i));
//        poseStack.mulPose(Vector3f.YP.rotationDegrees(j));
//        poseStack.translate(0.0D, -1.2000000476837158D, 0.0D);
//    }
}
