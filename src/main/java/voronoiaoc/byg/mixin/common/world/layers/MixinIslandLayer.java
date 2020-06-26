package voronoiaoc.byg.mixin.common.world.layers;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.AddMushroomIslandLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import voronoiaoc.byg.core.byglists.BYGBiomeList;

@SuppressWarnings("deprecation")
@Mixin(AddMushroomIslandLayer.class)
public class MixinIslandLayer {

    private static final int WARM_OCEAN = Registry.BIOME.getId(Biomes.WARM_OCEAN);
    private static final int LUKEWARM_OCEAN = Registry.BIOME.getId(Biomes.LUKEWARM_OCEAN);
    private static final int OCEAN = Registry.BIOME.getId(Biomes.OCEAN);
    private static final int COLD_OCEAN = Registry.BIOME.getId(Biomes.COLD_OCEAN);
    private static final int FROZEN_OCEAN = Registry.BIOME.getId(Biomes.FROZEN_OCEAN);
    private static final int TROPISLAND = Registry.BIOME.getId(BYGBiomeList.TROPICALISLAND);


    @Inject(at = @At("HEAD"), method = "apply", cancellable = true)
    private void apply(INoiseRandom context, int sw, int se, int ne, int nw, int center, CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(this.isShallowOcean(sw) && this.isShallowOcean(se) && this.isShallowOcean(ne) && this.isShallowOcean(nw) && this.isShallowOcean(center) && context.random(50) == 0 ? TROPISLAND : center);
    }

    private boolean isShallowOcean(int biomeIn) {
        return biomeIn == WARM_OCEAN || biomeIn == LUKEWARM_OCEAN || biomeIn == OCEAN || biomeIn == COLD_OCEAN || biomeIn == FROZEN_OCEAN;
    }
}
