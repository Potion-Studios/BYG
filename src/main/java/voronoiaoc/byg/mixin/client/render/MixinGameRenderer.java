package voronoiaoc.byg.mixin.client.render;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
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

@Mixin(GameRenderer.class)
public abstract class MixinGameRenderer {

    @Shadow
    @Final
    private MinecraftClient client;

    @Inject(at = @At("RETURN"), method = "getViewDistance", cancellable = true)
    private void strengthenFog(CallbackInfoReturnable<Float> cir) {
        World world = client.world;
        assert client.player != null;
        BlockPos playerPos = client.player.getBlockPos();

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

                assert world != null;
                Biome biome = world.getBiome(pos);
                if (biome instanceof BiomeFog) {
                    modified = true;

                    float fogStrength = ((BiomeFog) biome).fogDistance(sampleX, sampleZ, originalFogStrength);

                    accumulatedFogStrength += fogStrength * fogStrength;
                }
                else
                    accumulatedFogStrength += defaultFogStrength;
            }

            if (modified) {
                float transitionSmoothness = 33 * 33;
                cir.setReturnValue((float) Math.sqrt(accumulatedFogStrength / transitionSmoothness));
            }

            else
                cir.setReturnValue(cir.getReturnValueF());
        }
    }
}
