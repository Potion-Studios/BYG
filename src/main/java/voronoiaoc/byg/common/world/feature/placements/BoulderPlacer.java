package voronoiaoc.byg.common.world.feature.placements;

import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BoulderPlacer extends Placement<FrequencyConfig> {
   public static final Placement<FrequencyConfig> BOULDER =  new BoulderPlacer(FrequencyConfig::deserialize);

   public BoulderPlacer(Function<Dynamic<?>, ? extends FrequencyConfig> config) {
      super(config);
   }

   public Stream<BlockPos> getPositions(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generatorIn, Random random, FrequencyConfig configIn, BlockPos pos) {
      int i = random.nextInt(configIn.count);
      return IntStream.range(0, i).mapToObj((idx) -> {
         int j = random.nextInt(16) + pos.getX();
         int k = random.nextInt(16) + pos.getZ();
         int l = random.nextInt(75) + 100;
         return new BlockPos(j, l, k);
      });
   }
}