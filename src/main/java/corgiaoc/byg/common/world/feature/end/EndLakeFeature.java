package corgiaoc.byg.common.world.feature.end;

import corgiaoc.byg.common.world.OpenSimplexNoiseEnd;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.util.BlockHelper;
import corgiaoc.byg.util.FeatureHelper;
import corgiaoc.byg.util.ModMathHelper;
import corgiaoc.byg.util.noise.simplex.biome.OpenSimplexNoise;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.BlockStateProvidingFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.common.Tags;
import org.spongepowered.asm.mixin.Mutable;

import java.util.Random;
//Credits to BetterEnd & Pauelevs
public class EndLakeFeature extends Feature<NoFeatureConfig>
{
   private static final BlockState END_STONE = Blocks.END_STONE.getDefaultState();
   private static final OpenSimplexNoiseEnd NOISE = new OpenSimplexNoiseEnd(15152);
   private static final BlockPos.Mutable POS = new BlockPos.Mutable();

   public EndLakeFeature()
   {
      super(NoFeatureConfig.field_236558_a_);
   }

   @Override
   public boolean generate(ISeedReader world, ChunkGenerator chunkGenerator_, Random random,
                           BlockPos blockPos, NoFeatureConfig config)
   {
      double radius = ModMathHelper.randRange(10.0, 20.0, random);
      double depth = radius * 0.5 * ModMathHelper.randRange(0.8, 1.2, random);
      int dist = ModMathHelper.floor(radius);
      int dist2 = ModMathHelper.floor(radius * 1.5);
      int bott = ModMathHelper.floor(depth);

      blockPos = FeatureHelper.getPosOnSurfaceWG(world, blockPos);
      if (blockPos.getY() < 10) return false;

      int waterLevel = blockPos.getY();

      BlockPos pos = FeatureHelper.getPosOnSurfaceRaycast(world, blockPos.north(dist).up(10), 20);
      if (Math.abs(blockPos.getY() - pos.getY()) > 5) return false;
      waterLevel = ModMathHelper.min(pos.getY(), waterLevel);

      pos = FeatureHelper.getPosOnSurfaceRaycast(world, blockPos.south(dist).up(10), 20);
      if (Math.abs(blockPos.getY() - pos.getY()) > 5) return false;
      waterLevel = ModMathHelper.min(pos.getY(), waterLevel);

      pos = FeatureHelper.getPosOnSurfaceRaycast(world, blockPos.east(dist).up(10), 20);
      if (Math.abs(blockPos.getY() - pos.getY()) > 5) return false;
      waterLevel = ModMathHelper.min(pos.getY(), waterLevel);

      pos = FeatureHelper.getPosOnSurfaceRaycast(world, blockPos.west(dist).up(10), 20);
      if (Math.abs(blockPos.getY() - pos.getY()) > 5) return false;
      waterLevel = ModMathHelper.min(pos.getY(), waterLevel);
      BlockState state;

      int minX = blockPos.getX() - dist2;
      int maxX = blockPos.getX() + dist2;
      int minZ = blockPos.getZ() - dist2;
      int maxZ = blockPos.getZ() + dist2;
      int maskMinX = minX - 1;
      int maskMinZ = minZ - 1;

      boolean[][] mask = new boolean[maxX - minX + 3][maxZ - minZ + 3];
      for (int x = minX; x <= maxX; x++)
      {
         POS.setX(x);
         int mx = x - maskMinX;
         for (int z = minZ; z <= maxZ; z++)
         {
            POS.setZ(z);
            int mz = z - maskMinZ;
            if (!mask[mx][mz])
            {
               for (int y = waterLevel + 1; y <= waterLevel + 20; y++)
               {
                  POS.setY(y);
                  FluidState fluid = world.getFluidState(POS);
                  if (!fluid.isEmpty())
                  {
                     for (int i = -1; i < 2; i++)
                     {
                        int px = mx + i;
                        for (int j = -1; j < 2; j++)
                        {
                           int pz = mz + j;
                           mask[px][pz] = true;
                        }
                     }
                     break;
                  }
               }
            }
         }
      }

      for (int x = minX; x <= maxX; x++)
      {
         POS.setX(x);
         int x2 = x - blockPos.getX();
         x2 *= x2;
         int mx = x - maskMinX;
         for (int z = minZ; z <= maxZ; z++)
         {
            POS.setZ(z);
            int z2 = z - blockPos.getZ();
            z2 *= z2;
            int mz = z - maskMinZ;
            if (!mask[mx][mz])
            {
               double size = 1;
               for (int y = blockPos.getY(); y <= blockPos.getY() + 20; y++)
               {
                  POS.setY(y);
                  double add = y - blockPos.getY();
                  if (add > 5)
                  {
                     size *= 0.8;
                     add = 5;
                  }
                  double r = (add * 1.8 + radius * (NOISE.eval(x * 0.2, y * 0.2, z * 0.2) * 0.25 + 0.75)) - 1.0 / size;
                  if (r > 0)
                  {
                     r *= r;
                     if (x2 + z2 <= r)
                     {
                        state = world.getBlockState(POS);
                        if (state.isIn(Tags.Blocks.END_STONES))
                        {
                           BlockHelper.setWithoutUpdate(world, POS, Blocks.AIR.getDefaultState());
                        }
                        pos = POS.down();
                        if (world.getBlockState(pos).isIn(Tags.Blocks.END_STONES))
                        {
                           state = world.getBiome(pos).getGenerationSettings().getSurfaceBuilderConfig().getTop();
                           if (y > waterLevel + 1)
                              BlockHelper.setWithoutUpdate(world, pos, state);
                           else if (y > waterLevel)
                              BlockHelper.setWithoutUpdate(world, pos, random.nextBoolean() ? state : BYGBlocks.WHITE_SAND.getDefaultState());
                           else
                              BlockHelper.setWithoutUpdate(world, pos, BYGBlocks.WHITE_SAND.getDefaultState());
                        }
                     }
                  }
                  else
                  {
                     break;
                  }
               }
            }
         }
      }

      double aspect = ((double) radius / (double) depth);

      for (int x = blockPos.getX() - dist; x <= blockPos.getX() + dist; x++)
      {
         POS.setX(x);
         int x2 = x - blockPos.getX();
         x2 *= x2;
         int mx = x - maskMinX;
         for (int z = blockPos.getZ() - dist; z <= blockPos.getZ() + dist; z++)
         {
            POS.setZ(z);
            int z2 = z - blockPos.getZ();
            z2 *= z2;
            int mz = z - maskMinZ;
            if (!mask[mx][mz])
            {
               for (int y = blockPos.getY() - bott; y < blockPos.getY(); y++)
               {
                  POS.setY(y);
                  double y2 = (double) (y - blockPos.getY()) * aspect;
                  y2 *= y2;
                  double r = radius * (NOISE.eval(x * 0.2, y * 0.2, z * 0.2) * 0.25 + 0.75);
                  double rb = r * 1.2;
                  r *= r;
                  rb *= rb;
                  if (y2 + x2 + z2 <= r)
                  {
                     state = world.getBlockState(POS);
                     if (canReplace(state))
                     {
                        state = world.getBlockState(POS.up());
                        state = canReplace(state) ? (y < waterLevel ? Blocks.WATER.getDefaultState() : Blocks.AIR.getDefaultState()) : state;
                        BlockHelper.setWithoutUpdate(world, POS, state);
                     }
                     pos = POS.down();
                     if (world.getBlockState(pos).getBlock().isIn(Tags.Blocks.END_STONES))
                     {
                        BlockHelper.setWithoutUpdate(world, pos, BYGBlocks.WHITE_SAND.getDefaultState());
                     }
                     pos = POS.up();
                     while (canReplace(state = world.getBlockState(pos)) && !state.isAir() && state.getFluidState().isEmpty())
                     {
                        BlockHelper.setWithoutUpdate(world, pos, pos.getY() < waterLevel ? Blocks.WATER : Blocks.AIR);
                        pos = pos.up();
                     }
                  }
                  // Make border
                  else if (y < waterLevel && y2 + x2 + z2 <= rb)
                  {
                     if (world.isAirBlock(POS.up()))
                     {
                        state = world.getBiome(POS).getGenerationSettings().getSurfaceBuilderConfig().getTop();
                        BlockHelper.setWithoutUpdate(world, POS, random.nextBoolean() ? state : BYGBlocks.WHITE_SAND.getDefaultState());
                        BlockHelper.setWithoutUpdate(world, POS.down(), END_STONE);
                     }
                     else
                     {
                        BlockHelper.setWithoutUpdate(world, POS, BYGBlocks.WHITE_SAND.getDefaultState());
                        BlockHelper.setWithoutUpdate(world, POS.down(), END_STONE);
                     }
                  }
               }
            }
         }
      }

      BlockHelper.fixBlocks(world, new BlockPos(minX - 2, waterLevel - 2, minZ - 2), new BlockPos(maxX + 2, blockPos.getY() + 20, maxZ + 2));

      return true;
   }

   private boolean canReplace(BlockState state)
   {
      return state.getMaterial().isReplaceable()
              || state.isIn(Tags.Blocks.END_STONES)
              || state.isIn(Tags.Blocks.ORES) // Handles floating ores
              || state.isIn(BYGBlocks.BULBIS_SPROUTS) // Handles other blocks that could be left floating
              || state.isIn(BYGBlocks.WHITE_SAND)
              || state.getMaterial().equals(Material.PLANTS)
              || state.getMaterial().equals(Material.OCEAN_PLANT)
              || state.getMaterial().equals(Material.SEA_GRASS);
   }
}