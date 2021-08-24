package corgiaoc.byg.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.levelgen.Heightmap;
//Credits to BetterEnd & Pauelevs
public class FeatureHelper
{
	public static int getYOnSurface(LevelReader world, int x, int z)
	{
		return world.getHeight(Heightmap.Types.WORLD_SURFACE, x, z);
	}
	
	public static int getYOnSurfaceWG(LevelReader world, int x, int z) 
	{
		return world.getHeight(Heightmap.Types.WORLD_SURFACE_WG, x, z);
	}
	
	public static BlockPos getPosOnSurface(LevelReader world, BlockPos pos)
	{
		return world.getHeightmapPos(Heightmap.Types.WORLD_SURFACE, pos);
	}
	
	public static BlockPos getPosOnSurfaceWG(LevelReader world, BlockPos pos) 
	{
		return world.getHeightmapPos(Heightmap.Types.WORLD_SURFACE_WG, pos);
	}
	
	public static BlockPos getPosOnSurfaceRaycast(LevelReader world, BlockPos pos) 
	{
		return getPosOnSurfaceRaycast(world, pos, 256);
	}
	
	public static BlockPos getPosOnSurfaceRaycast(LevelReader world, BlockPos pos, int dist) 
	{
		int h = BlockHelper.downRay(world, pos, dist);
		return pos.below(h);
	}
}