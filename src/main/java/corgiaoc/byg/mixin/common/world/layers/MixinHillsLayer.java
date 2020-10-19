package corgiaoc.byg.mixin.common.world.layers;

import corgiaoc.byg.common.world.biome.BYGBiome;
import corgiaoc.byg.core.world.BYGBiomes;
import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import net.minecraft.util.Util;
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

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
@Mixin(HillsLayer.class)
public abstract class MixinHillsLayer {

    private static final List<Biome> topOceanList = new ArrayList<>();
    private static final List<Biome> volcanoOceanList = new ArrayList<>();

    private static final Int2IntMap MUTATIONS_MAP = Util.make(new Int2IntOpenHashMap(), (map) -> {
//        map.put(WorldGenRegistries.BIOME.getId(WorldGenRegistries.BIOME.getValueForKey(Biomes.DEEP_OCEAN)), WorldGenRegistries.BIOME.getId(BYGBiomes.VOLCANO));
    });



    @Inject(method = "apply(Lnet/minecraft/world/gen/INoiseRandom;Lnet/minecraft/world/gen/area/IArea;Lnet/minecraft/world/gen/area/IArea;II)I",
            at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/world/gen/INoiseRandom;random(I)I"),
            cancellable = true,
            locals = LocalCapture.CAPTURE_FAILHARD)
    private void injectBYGSubBiomes(INoiseRandom rand, IArea area1, IArea area2, int x, int z, CallbackInfoReturnable<Integer> cir, int i, int j, int k) {
        if (rand.random(9) == 0 || k == 0) {
            int l = i;
            Biome biome = WorldGenRegistries.BIOME.getByValue(i);
            if (topOceanList.contains(biome))
                l = WorldGenRegistries.BIOME.getId(BYGBiomes.TROPICAL_ISLAND);
            cir.setReturnValue(l);
        }

        if (rand.random(3) == 0 || k == 0) {
            int l = i;
            Biome biome = WorldGenRegistries.BIOME.getByValue(i);
            if (biome != null) {
                Biome hill = getHillBiomeValue(biome, rand);
                if (hill != null) l = WorldGenRegistries.BIOME.getId(hill);
            }

//            if (k == 0 && l != i) {
//                l = MUTATIONS_MAP.getOrDefault(l, i);
//            }
//
//            //Mutations Handler
//            if (l != i) {
//                int i1 = 0;
//                if (BYGBiome.areBiomesSimilar(area1.getValue(((HillsLayer)(Object)this).getOffsetX(x + 1), ((HillsLayer)(Object)this).getOffsetZ(z)), i)) {
//                    ++i1;
//                }
//
//                if (BYGBiome.areBiomesSimilar(area1.getValue(((HillsLayer)(Object)this).getOffsetX(x + 2), ((HillsLayer)(Object)this).getOffsetZ(z + 1)), i)) {
//                    ++i1;
//                }
//
//                if (BYGBiome.areBiomesSimilar(area1.getValue(((HillsLayer)(Object)this).getOffsetX(x), ((HillsLayer)(Object)this).getOffsetZ(z + 1)), i)) {
//                    ++i1;
//                }
//
//                if (BYGBiome.areBiomesSimilar(area1.getValue(((HillsLayer)(Object)this).getOffsetX(x + 1), ((HillsLayer)(Object)this).getOffsetZ(z + 2)), i)) {
//                    ++i1;
//                }
//
//                if (i1 >= 3) {
//                    cir.setReturnValue(l);
//                }
//            }
            cir.setReturnValue(l);
        }
    }

    @Nullable
    private static Biome getHillBiomeValue(Biome firstLayerBiomeValue, INoiseRandom random) {
        for (BYGBiome bygBiome : BYGBiome.BYG_BIOMES) {
            if (firstLayerBiomeValue == bygBiome.getBiome())
                return bygBiome.getHills(random);
        }
        return null;
    }


    static {
        topOceanList.add(WorldGenRegistries.BIOME.getValueForKey(Biomes.DEEP_OCEAN));
        topOceanList.add(WorldGenRegistries.BIOME.getValueForKey(Biomes.DEEP_LUKEWARM_OCEAN));
        topOceanList.add(WorldGenRegistries.BIOME.getValueForKey(Biomes.DEEP_WARM_OCEAN));
        volcanoOceanList.add(WorldGenRegistries.BIOME.getValueForKey(Biomes.DEEP_OCEAN));
        volcanoOceanList.add(WorldGenRegistries.BIOME.getValueForKey(Biomes.DEEP_LUKEWARM_OCEAN));
        volcanoOceanList.add(WorldGenRegistries.BIOME.getValueForKey(Biomes.DEEP_WARM_OCEAN));
        volcanoOceanList.add(WorldGenRegistries.BIOME.getValueForKey(Biomes.OCEAN));
        volcanoOceanList.add(WorldGenRegistries.BIOME.getValueForKey(Biomes.LUKEWARM_OCEAN));
        volcanoOceanList.add(WorldGenRegistries.BIOME.getValueForKey(Biomes.WARM_OCEAN));
    }
}
