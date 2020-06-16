package voronoiaoc.byg.common.world.dimension.end.biome;

import com.google.common.collect.ImmutableSet;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.biome.provider.EndBiomeProviderSettings;
import net.minecraft.world.gen.SimplexNoiseGenerator;
import net.minecraft.world.gen.layer.Layer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BYGEndBiomeProvider extends BiomeProvider {
   private final SimplexNoiseGenerator generator;
   private final SharedSeedRandom random;
   private static final Set<Biome> BIOMESET = ImmutableSet.of(Biomes.THE_END, Biomes.END_HIGHLANDS, Biomes.END_MIDLANDS, Biomes.SMALL_END_ISLANDS, Biomes.END_BARRENS);
   public static List <Biome> biomeList = new ArrayList<>();
   public Layer biomeLayer;

   public BYGEndBiomeProvider(EndBiomeProviderSettings settings) {
      super(BIOMESET);
      this.random = new SharedSeedRandom(settings.getSeed());
      this.random.skip(17292);
      this.generator = new SimplexNoiseGenerator(this.random);
      biomeLayer = BYGEndLayerProvider.build(settings.getSeed());

   }
   @MethodsReturnNonnullByDefault
   @Override
   public Biome getNoiseBiome(int x, int y, int z) {
      int i = x >> 2;
      int j = z >> 2;
      if ((long)i * (long)i + (long)j * (long)j <= 4096L) {
         return Biomes.THE_END;
      } else {
         return biomeLayer.func_215738_a(x, z);
         }
      }

   @Override
   public float func_222365_c(int x, int z) {
      int i = x / 2;
      int j = z / 2;
      int k = x % 2;
      int l = z % 2;
      float f = 100.0F - MathHelper.sqrt((float)(x * x + z * z)) * 8.0F;
      f = MathHelper.clamp(f, -100.0F, 80.0F);

      for(int i1 = -12; i1 <= 12; ++i1) {
         for(int j1 = -12; j1 <= 12; ++j1) {
            long k1 = i + i1;
            long l1 = j + j1;
            if (k1 * k1 + l1 * l1 > 4096L && this.generator.getValue((double)k1, (double)l1) < (double)-0.9F) {
               float f1 = (MathHelper.abs((float)k1) * 3439.0F + MathHelper.abs((float)l1) * 147.0F) % 13.0F + 9.0F;
               float f2 = (float)(k - i1 * 2);
               float f3 = (float)(l - j1 * 2);
               float f4 = 100.0F - MathHelper.sqrt(f2 * f2 + f3 * f3) * f1;
               f4 = MathHelper.clamp(f4, -100.0F, 80.0F);
               f = Math.max(f, f4);
            }
         }
      }

      return f;
   }
}