package voronoiaoc.byg.common.world.feature.features.nether.warpeddesert;

import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.function.Function;

public class WarpedCoralFan extends Feature<NoFeatureConfig> {
   public WarpedCoralFan(Function<Dynamic<?>, ? extends NoFeatureConfig> config) {
      super(config);
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
      if (!worldIn.isAirBlock(pos)) {
         return false;
      }
      else if ((worldIn.getBlockState(pos.down()).getBlock() == BYGBlockList.NYLIUM_SOUL_SAND) || (worldIn.getBlockState(pos.down()).getBlock() == BYGBlockList.NYLIUM_SOUL_SOIL)) {
         worldIn.setBlockState(pos, BYGBlockList.WARPED_CORAL_FAN.getDefaultState(), 2);
         return true;
      }
      return true;
   }
}