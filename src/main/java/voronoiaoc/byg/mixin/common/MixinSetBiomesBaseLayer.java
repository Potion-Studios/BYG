package voronoiaoc.byg.mixin.common;

import net.minecraft.world.biome.layer.SetBaseBiomesLayer;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import voronoiaoc.byg.core.registries.BYGBiomeRegistry;

@Mixin(SetBaseBiomesLayer.class)
public class MixinSetBiomesBaseLayer {

    //TODO: REMOVE WHEN FABRIC ADDS MODDED BIOME SUPPORT
    /**
     * @author Corgi Taco
     * @reason Temp fix to the biome layer for BYG's biomes
     */
    @Overwrite
    public int sample(LayerRandomnessSource context, int value) {
        int i = (value & 3840) >> 8;
        value &= -3841;
        if (!isOcean(value) && value != 14) {
            switch(value) {
                case 1:
                    if (i > 0) {
                        return context.nextInt(3) == 0 ? 39 : 38;
                    }

                    return BYGBiomeRegistry.HOT.get(context.nextInt(BYGBiomeRegistry.HOT.size()));
                    case 2:
                    if (i > 0) {
                        return 21;
                    }

                    return BYGBiomeRegistry.HOT.get(context.nextInt(BYGBiomeRegistry.WARM.size()));
                case 3:
                    if (i > 0) {
                        return 32;
                    }

                    return BYGBiomeRegistry.COOL.get(context.nextInt(BYGBiomeRegistry.COOL.size()));
                case 4:
                    return BYGBiomeRegistry.ICY.get(context.nextInt(BYGBiomeRegistry.ICY.size()));
                default:
                    return 14;
            }
        } else {
            return value;
        }
    }

    protected static boolean isOcean(int id) {
        return id == 44 || id == 45 || id == 0 || id == 46 || id == 10 || id == 47 || id == 48 || id == 24 || id == 49 || id == 50;
    }
}
