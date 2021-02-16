package corgiaoc.byg.util;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.gen.Heightmap;
//Credits to BetterEnd & Pauelevs
public class FeatureHelper
{
	public static int getYOnSurface(IWorldReader world, int x, int z)
	{
		return world.getHeight(Heightmap.Type.WORLD_SURFACE, x, z);
	}
	
	public static int getYOnSurfaceWG(IWorldReader world, int x, int z) 
	{
		return world.getHeight(Heightmap.Type.WORLD_SURFACE_WG, x, z);
	}
	
	public static BlockPos getPosOnSurface(IWorldReader world, BlockPos pos)
	{
		return world.getHeight(Heightmap.Type.WORLD_SURFACE, pos);
	}
	
	public static BlockPos getPosOnSurfaceWG(IWorldReader world, BlockPos pos) 
	{
		return world.getHeight(Heightmap.Type.WORLD_SURFACE_WG, pos);
	}
	
	public static BlockPos getPosOnSurfaceRaycast(IWorldReader world, BlockPos pos) 
	{
		return getPosOnSurfaceRaycast(world, pos, 256);
	}
	
	public static BlockPos getPosOnSurfaceRaycast(IWorldReader world, BlockPos pos, int dist) 
	{
		int h = BlockHelper.downRay(world, pos, dist);
		return pos.down(h);
	}
}