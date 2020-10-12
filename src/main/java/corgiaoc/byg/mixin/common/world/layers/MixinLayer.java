package corgiaoc.byg.mixin.common.world.layers;

import corgiaoc.byg.config.BYGWorldConfig;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeRegistry;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.Layer;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Layer.class)
public class MixinLayer {

    @Shadow @Final private LazyArea field_215742_b;

    @Shadow @Final private static Logger LOGGER;

    /**
     * @reason Break out of the int2obj map of biome IDs and biome keys that Mojang has decided was a good idea to implement. Because it really wasn't.
     */
    @Inject(at = @At("HEAD"), method = "func_242936_a(Lnet/minecraft/util/registry/Registry;II)Lnet/minecraft/world/biome/Biome;", cancellable = true)
    private void useDatapackBiomeRegistry(Registry<Biome> biomeRegistry, int x, int z, CallbackInfoReturnable<Biome> cir) {
        if (BYGWorldConfig.useDangerousHacks.get()) {
            cir.cancel();
            int biomeID = this.field_215742_b.getValue(x, z);
            RegistryKey<Biome> registryKey = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, biomeRegistry.getKey(biomeRegistry.getByValue(biomeID)));
            Biome biome = biomeRegistry.getValueForKey(registryKey);
            if (biome == null) {
                if (SharedConstants.developmentMode) {
                    throw Util.pauseDevMode(new IllegalStateException("Unknown biome id: " + biomeID));
                } else {
                    LOGGER.warn("Unknown biome id: ", biomeID);
                    cir.setReturnValue(biomeRegistry.getValueForKey(BiomeRegistry.getKeyFromID(0)));
                }
            } else {
                cir.setReturnValue(biome);
            }
        }
    }
}