//package corgiaoc.byg.mixin.common.world.layers;
//
//import net.minecraft.world.biome.Biome;
//import net.minecraft.world.gen.area.LazyArea;
//import net.minecraft.world.gen.layer.Layer;
//import org.spongepowered.asm.mixin.Final;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//
//@Mixin(Layer.class)
//public class MixinLayer {
//
//    @Shadow
//    @Final
//    private LazyArea field_215742_b;
//
//
//    /**
//     * @reason Break out of the int2obj map of biome IDs and biome keys that Mojang has decided was a good idea implement.
//     */
//    @Inject(at = @At("HEAD"), method = "func_242936_a(Lnet/minecraft/util/registry/Registry;II)Lnet/minecraft/world/biome/Biome;", cancellable = true)
//    private void useDatapackBiomeRegistry(Registry<Biome> biomeRegistry, int x, int z, CallbackInfoReturnable<Biome> cir) {
//            cir.cancel();
//            int rawBiomeID = this.field_215742_b.getValue(x, z);
//            RegistryKey<Biome> registryKey = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, biomeRegistry.getKey(biomeRegistry.getByValue(rawBiomeID)));
//            if (registryKey == null) {
//                throw new IllegalStateException("Unknown biome id emitted by layers: " + rawBiomeID);
//            } else {
//                Biome biome = biomeRegistry.getValueForKey(registryKey);
//                if (biome == null) {
//                    if (SharedConstants.developmentMode) {
//                        throw Util.pauseDevMode(new IllegalStateException("Unknown biome id: " + rawBiomeID));
//                    } else {
//                        BYG.LOGGER.warn("Unknown biome id: ", rawBiomeID);
//                        cir.setReturnValue(biomeRegistry.getValueForKey(BiomeRegistry.getKeyFromID(0)));
//                    }
//                } else {
//                    cir.setReturnValue(biome);
//                }
//            }
//    }
//}
