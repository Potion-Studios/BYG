package voronoiaoc.byg.mixin.common.world.layers;

import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.HillsLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import voronoiaoc.byg.common.biomes.BiomeTools;
import voronoiaoc.byg.core.byglists.BYGBiomeList;

import java.util.ArrayList;
import java.util.List;

@Mixin(HillsLayer.class)
public class MixinHillsLayer {

    private static final List<Biome> oceanBiomeList = new ArrayList<>();

    @Inject(method = "apply(Lnet/minecraft/world/gen/INoiseRandom;Lnet/minecraft/world/gen/area/IArea;Lnet/minecraft/world/gen/area/IArea;II)I",
            at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/world/gen/INoiseRandom;random(I)I"),
            cancellable = true,
            locals = LocalCapture.CAPTURE_FAILHARD)
    private void injectApply(INoiseRandom rand, IArea area1, IArea area2, int x, int z, CallbackInfoReturnable<Integer> cir, int i, int j, int k) {

        if (rand.random(9) == 0 || k == 0) {
            int l = i;
            Biome biome = WorldGenRegistries.BIOME.getByValue(i);
            if (oceanBiomeList.contains(biome))
                l = WorldGenRegistries.BIOME.getId(BYGBiomeList.TROPICALISLAND);
            cir.setReturnValue(l);
        }

        if (rand.random(3) == 0 || k == 0) {
            int l = i;
            Biome biome = WorldGenRegistries.BIOME.getByValue(i);
            if (biome != null) {
                if (biome instanceof BiomeTools) {
                    Biome hill = ((BiomeTools) biome).getHill(rand);
                    if (hill != null) l = WorldGenRegistries.BIOME.getId(hill);
                }
        }
            cir.setReturnValue(l);
        }
    }

    static {
        oceanBiomeList.add(WorldGenRegistries.BIOME.getValueForKey(Biomes.DEEP_OCEAN));
        oceanBiomeList.add(WorldGenRegistries.BIOME.getValueForKey(Biomes.DEEP_LUKEWARM_OCEAN));
        oceanBiomeList.add(WorldGenRegistries.BIOME.getValueForKey(Biomes.DEEP_WARM_OCEAN));
    }
}
