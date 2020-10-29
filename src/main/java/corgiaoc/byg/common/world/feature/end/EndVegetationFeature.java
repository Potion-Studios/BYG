package corgiaoc.byg.common.world.feature.end;

import corgiaoc.byg.util.FabricTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.BlockPileFeatureConfig;

import java.util.Random;

public class EndVegetationFeature {
   public EndVegetationFeature() {}

   public static boolean placeBonemeal(WorldAccess world, Random rand, BlockPos pos, BlockPileFeatureConfig config, int spreadRandom1, int spreadRandom2) {
      Block block = world.getBlockState(pos.down()).getBlock();
      if (block.isIn(FabricTags.END_STONES)) {
         return false;
      } else {
         int i = pos.getY();
         if (i >= 1 && i + 1 < world.getHeight()) {
            int j = 0;

            for(int k = 0; k < spreadRandom1 * spreadRandom1; ++k) {
               BlockPos blockpos = pos.add(rand.nextInt(spreadRandom1) - rand.nextInt(spreadRandom1), rand.nextInt(spreadRandom2) - rand.nextInt(spreadRandom2), rand.nextInt(spreadRandom1) - rand.nextInt(spreadRandom1));
               BlockState blockstate = config.stateProvider.getBlockState(rand, blockpos);
               if (world.isAir(blockpos) && blockpos.getY() > 0 && blockstate.canPlaceAt(world, blockpos)) {
                  world.setBlockState(blockpos, blockstate, 2);
                  ++j;
               }
            }
            return j > 0;
         } else {
            return false;
         }
      }
   }
}