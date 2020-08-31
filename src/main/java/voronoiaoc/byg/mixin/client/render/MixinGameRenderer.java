//package voronoiaoc.byg.mixin.client.render;
//
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.renderer.GameRenderer;
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.biome.Biome;
//import org.spongepowered.asm.mixin.Final;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//import voronoiaoc.byg.common.biomes.BiomeFog;
//
//@Mixin(GameRenderer.class)
//public abstract class MixinGameRenderer {
//
//    @Shadow
//    @Final
//    private Minecraft client;
//
//    @Inject(at = @At("RETURN"), method = "getViewDistance", cancellable = true)
//    private void strengthenFog(CallbackInfoReturnable<Float> cir) {
//        Level world = client.level;
//        assert client.player != null;
//        BlockPos playerPos = client.player.blockPosition();
//
//        int transitionStart = 8;
//
//        float originalFogStrength = cir.getReturnValueF();
//        float defaultFogStrength = originalFogStrength;
//        defaultFogStrength *= defaultFogStrength;
//
//        final int x = playerPos.getX();
//        final int z = playerPos.getZ();
//        boolean modified = false;
//
//        float accumulatedFogStrength = 0.0F;
//
//        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
//        for (int sampleX = x - transitionStart; sampleX <= x + transitionStart; ++sampleX) {
//            pos.setX(sampleX);
//
//            for (int sampleZ = z - transitionStart; sampleZ <= z + transitionStart; ++sampleZ) {
//                pos.setZ(sampleZ);
//
//                assert world != null;
//                Biome biome = world.getBiome(pos);
//                if (biome instanceof BiomeFog) {
//                    modified = true;
//
//                    float fogStrength = ((BiomeFog) biome).fogDistance(sampleX, sampleZ, originalFogStrength);
//
//                    accumulatedFogStrength += fogStrength * fogStrength;
//                } else
//                    accumulatedFogStrength += defaultFogStrength;
//            }
//
//            if (modified) {
//                float transitionSmoothness = 33 * 33;
//                cir.setReturnValue((float) Math.sqrt(accumulatedFogStrength / transitionSmoothness));
//            } else
//                cir.setReturnValue(cir.getReturnValueF());
//        }
//    }
//}
