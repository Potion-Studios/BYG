package corgiaoc.byg.common.entity.manowar;


import corgiaoc.byg.BYG;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class ManOWarModel<T extends IAnimatable> extends AnimatedGeoModel<T>{

		@Override
		public ResourceLocation getModelLocation(T object) {
			return new ResourceLocation(BYG.MOD_ID, "geo/man_o_war.geo.json");
		}
		@Override
		public ResourceLocation getTextureLocation(T object) {
			ManOWar manOWar = (ManOWar) object;
			return ManOWarRenderer.TEXTURES.get(manOWar.getColor());
		}
		@Override
		public ResourceLocation getAnimationFileLocation(T animatable) {
			return new ResourceLocation(BYG.MOD_ID, "animations/man_o_war.animation.json");
	}


		@Override
		public void setLivingAnimations(IAnimatable entity, Integer uniqueID, AnimationEvent customPredicate) {
			super.setLivingAnimations((T) entity, uniqueID, customPredicate);
			IBone head = this.getAnimationProcessor().getBone("Head");

			LivingEntity entityIn = (LivingEntity) entity;
			EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
			head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
			head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
		}
}