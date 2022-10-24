package potionstudios.byg.common.entity.manowar;


import net.minecraft.resources.ResourceLocation;
import potionstudios.byg.BYG;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ManOWarModel<T extends IAnimatable> extends AnimatedGeoModel<T>{

		@Override
		public ResourceLocation getModelResource(T object) {
			return BYG.createLocation("geo/man_o_war.geo.json");
		}
		@Override
		public ResourceLocation getTextureResource(T object) {
			ManOWar manOWar = (ManOWar) object;
			return ManOWarRenderer.TEXTURES.get(manOWar.getColor());
		}
		@Override
		public ResourceLocation getAnimationResource(T animatable) {
			return BYG.createLocation("animations/man_o_war.animation.json");
	}
}