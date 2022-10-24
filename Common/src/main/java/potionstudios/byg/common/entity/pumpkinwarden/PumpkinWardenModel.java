package potionstudios.byg.common.entity.pumpkinwarden;


import net.minecraft.resources.ResourceLocation;
import potionstudios.byg.BYG;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

import javax.annotation.Nullable;

public class PumpkinWardenModel<T extends IAnimatable> extends AnimatedGeoModel<T>{

		@Override
		public ResourceLocation getModelResource(T object) {
			return BYG.createLocation("geo/pumpkinwarden.geo.json");
		}
		@Override
		public ResourceLocation getTextureResource(T object) {
			return BYG.createLocation("textures/entity/pumpkin_warden.png");
		}
		@Override
		public ResourceLocation getAnimationResource(T animatable) {
			return BYG.createLocation("animations/pumpkinwarden.animation.json");
	}
	@Override
	public void setLivingAnimations(T entity, Integer uniqueID, @Nullable AnimationEvent customPredicate) {
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		IBone head = this.getAnimationProcessor().getBone("Head");
		IBone nose = this.getAnimationProcessor().getBone("Nose");
		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
		head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
		nose.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
		nose.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
	}
}