package potionstudios.byg.common.world.feature.gen;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.material.Material;
import potionstudios.byg.util.BlockHelper;

public class FeatureGenUtil {

    public static boolean isPlant(LevelSimulatedReader world, BlockPos pos) {
        return world.isStateAtPosition(pos, (state) -> state.is(BlockTags.LEAVES) || state.getMaterial() == Material.LEAVES || state.getMaterial() == Material.PLANT || state.getMaterial() == Material.REPLACEABLE_PLANT || state.getMaterial() == Material.WATER_PLANT || state.getMaterial() == Material.REPLACEABLE_FIREPROOF_PLANT);
    }

    public static boolean isTerrainOrRock(LevelSimulatedReader world, BlockPos pos) {
        return world.isStateAtPosition(pos, (state) -> state.is(BlockTags.BASE_STONE_OVERWORLD) || state.getMaterial() == Material.STONE || state.is(BlockTags.BASE_STONE_OVERWORLD) || state.getMaterial() == Material.DIRT || state.is(BlockTags.SAND) || state.getMaterial() == Material.SAND || state.getBlock() == Blocks.GRASS_BLOCK);
    }

    public static boolean isAir(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, BlockState::isAir);
    }

    public static boolean isAirInRange(LevelSimulatedReader world, BlockPos pos, int xRange, int yRange, int zRange) {
        return isAirInRange(world, pos, xRange, yRange, zRange, xRange, yRange, zRange);
    }

    public static boolean isAirInRange(LevelSimulatedReader world, BlockPos pos, int xNegRange, int yNegRange, int zNegRange, int xPosRange, int yPosRange, int zPosRange) {
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        for (int x = -xNegRange; x <= xPosRange; x++) {
            for (int y = -yNegRange; y <= yPosRange; y++) {
                for (int z = -zNegRange; z <= zPosRange; z++) {
                    mutable.set(pos.offset(x, y, z));
                    if (!isAir(world, mutable))
                        return false;
                }
            }
        }
        return true;
    }


    public static void transformMutable(BlockPos.MutableBlockPos pos, Mirror mirrorIn, Rotation rotationIn) {
        switch (mirrorIn) {
            case LEFT_RIGHT -> pos.setZ(-pos.getZ());
            case FRONT_BACK -> pos.setX(-pos.getX());
        }
        switch (rotationIn) {
            case COUNTERCLOCKWISE_90 -> pos.set(pos.getZ(), pos.getY(), -pos.getX());
            case CLOCKWISE_90 -> pos.set(-pos.getZ(), pos.getY(), pos.getX());
            case CLOCKWISE_180 -> pos.set(-pos.getX(), pos.getY(), -pos.getZ());
        }
    }

    public static BlockPos transform(BlockPos pos, Mirror mirrorIn, Rotation rotationIn) {
        int posX = pos.getX();
        int posZ = pos.getZ();
        boolean mirror = true;
        switch (mirrorIn) {
            case LEFT_RIGHT -> posZ = -posZ;
            case FRONT_BACK -> posX = -posX;
            default -> mirror = false;
        }
        return switch (rotationIn) {
            case COUNTERCLOCKWISE_90 -> new BlockPos(posZ, pos.getY(), -posX);
            case CLOCKWISE_90 -> new BlockPos(-posZ, pos.getY(), posX);
            case CLOCKWISE_180 -> new BlockPos(-posX, pos.getY(), -posZ);
            default -> mirror ? new BlockPos(posX, pos.getY(), posZ) : pos;
        };
    }

    public static BlockPos extractOffset(BlockPos startPos, BlockPos blockPos) {
        return blockPos instanceof BlockPos.MutableBlockPos ? new BlockPos.MutableBlockPos(startPos.getX() - blockPos.getX(), blockPos.getY(), startPos.getZ() - blockPos.getZ()) :
                new BlockPos(startPos.getX() - blockPos.getX(), blockPos.getY(), startPos.getZ() - blockPos.getZ());
    }


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
