package voronoiaoc.byg.mixin.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import voronoiaoc.byg.common.biomes.BiomeFog;
import voronoiaoc.byg.config.BYGConfig;

@Mixin(GameRenderer.class)
public abstract class MixinGameRenderer {

    @Shadow
    @Final
    private Minecraft mc;

    @Inject(at = @At("RETURN"), method = "getFarPlaneDistance", cancellable = true)
    private void strengthenFog(CallbackInfoReturnable<Float> cir) {

        World world = mc.world;
        BlockPos playerPos = mc.player.getPosition();

        int transitionStart = 8;

        float originalFogStrength = cir.getReturnValueF();
        float defaultFogStrength = originalFogStrength;
        defaultFogStrength *= defaultFogStrength;

        final int x = playerPos.getX();
        final int z = playerPos.getZ();
        boolean modified = false;

        float accumulatedFogStrength = 0.0F;

        BlockPos.Mutable pos = new BlockPos.Mutable();
        for (int sampleX = x - transitionStart; sampleX <= x + transitionStart; ++sampleX) {
            pos.setX(sampleX);

            for (int sampleZ = z - transitionStart; sampleZ <= z + transitionStart; ++sampleZ) {
                pos.setZ(sampleZ);

                Biome biome = world.getBiome(pos);
                if (biome instanceof BiomeFog) {
                    modified = true;

                    float fogStrength = ((BiomeFog) biome).fogDistance(sampleX, sampleZ, originalFogStrength);

                    accumulatedFogStrength += fogStrength * fogStrength;
                } else
                    accumulatedFogStrength += defaultFogStrength;
            }

            if (modified && BYGConfig.biomeFogEffects.get() == BYGConfig.BiomeFogSettings.DENSEFOG || BYGConfig.biomeFogEffects.get() == BYGConfig.BiomeFogSettings.DENSEFOGCOLOR) {
                float transitionSmoothness = 33 * 33;
                cir.setReturnValue((float) Math.sqrt(accumulatedFogStrength / transitionSmoothness));
            } else
                cir.setReturnValue(cir.getReturnValueF());
        }
    }
}
