package potionstudios.byg.common.entity.pumpkinwarden;


import net.minecraft.resources.ResourceLocation;
import potionstudios.byg.BYG;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class PumpkinWardenModel<T extends GeoAnimatable> extends GeoModel<T> {

    @Override
    public ResourceLocation getModelResource(T object) {
        return BYG.createLocation("geo/pumpkinwarden.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(T object) {
        return ((PumpkinWarden) object).isHiding() ? BYG.createLocation("textures/entity/pumpkin_warden_hiding.png") : BYG.createLocation("textures/entity/pumpkin_warden.png");
    }

    @Override
    public ResourceLocation getAnimationResource(T animatable) {
        return BYG.createLocation("animations/pumpkinwarden.animation.json");
    }

    @Override
    public Animation getAnimation(T animatable, String name) {
        return super.getAnimation(animatable, name);
    }

    @Override
    public void setCustomAnimations(T entity, long uniqueID, AnimationState<T> customPredicate) {
        super.setCustomAnimations(entity, uniqueID, customPredicate);
        CoreGeoBone head = this.getAnimationProcessor().getBone("Head");
        EntityModelData extraData = customPredicate.getData(DataTickets.ENTITY_MODEL_DATA);
        head.setPivotX(extraData.headPitch() * ((float) Math.PI / 180F));
        head.setPivotY(extraData.netHeadYaw() * ((float) Math.PI / 180F));
    }
}