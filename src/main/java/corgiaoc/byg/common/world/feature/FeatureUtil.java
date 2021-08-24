package corgiaoc.byg.common.world.feature;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.IWorldGenerationBaseReader;

public class FeatureUtil {

    public static boolean isPlant(IWorldGenerationBaseReader world, BlockPos pos) {
        return world.isStateAtPosition(pos, (state) -> state.is(BlockTags.LEAVES) || state.getMaterial() == Material.LEAVES || state.getMaterial() == Material.PLANT || state.getMaterial() == Material.REPLACEABLE_PLANT || state.getMaterial() == Material.WATER_PLANT || state.getMaterial() == Material.REPLACEABLE_FIREPROOF_PLANT);
    }

    public static boolean isTerrainOrRock(IWorldGenerationBaseReader world, BlockPos pos) {
        return world.isStateAtPosition(pos, (state) -> state.is(BlockTags.BASE_STONE_OVERWORLD) || state.getMaterial() == Material.STONE || state.is(BlockTags.BASE_STONE_OVERWORLD) || state.getMaterial() == Material.DIRT || state.is(BlockTags.SAND) || state.getMaterial() == Material.SAND || state.getBlock() == Blocks.GRASS_BLOCK);
    }

    public static boolean isAir(IWorldGenerationBaseReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, BlockState::isAir);
    }

    public static boolean isAirInRange(IWorldGenerationBaseReader world, BlockPos pos, int xRange, int yRange, int zRange) {
        return isAirInRange(world, pos, xRange, yRange, zRange, xRange, yRange, zRange);
    }

    public static boolean isAirInRange(IWorldGenerationBaseReader world, BlockPos pos, int xNegRange, int yNegRange, int zNegRange, int xPosRange, int yPosRange, int zPosRange) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();
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


    public static void transformMutable(BlockPos.Mutable pos, Mirror mirrorIn, Rotation rotationIn) {
        switch (mirrorIn) {
            case LEFT_RIGHT:
                pos.setZ(-pos.getZ());
                break;
            case FRONT_BACK:
                pos.setX(-pos.getX());
                break;
        }
        switch (rotationIn) {
            case COUNTERCLOCKWISE_90:
                pos.set(pos.getZ(), pos.getY(), -pos.getX());
                break;
            case CLOCKWISE_90:
                pos.set(-pos.getZ(), pos.getY(), pos.getX());
                break;
            case CLOCKWISE_180:
                pos.set(-pos.getX(), pos.getY(), -pos.getZ());
                break;
        }
    }

    public static BlockPos transform(BlockPos pos, Mirror mirrorIn, Rotation rotationIn) {
        int posX = pos.getX();
        int posZ = pos.getZ();
        boolean mirror = true;
        switch (mirrorIn) {
            case LEFT_RIGHT:
                posZ = -posZ;
                break;
            case FRONT_BACK:
                posX = -posX;
                break;
            default:
                mirror = false;
        }
        switch (rotationIn) {
            case COUNTERCLOCKWISE_90:
                return new BlockPos(posZ, pos.getY(), -posX);
            case CLOCKWISE_90:
                return new BlockPos(-posZ, pos.getY(), posX);
            case CLOCKWISE_180:
                return new BlockPos(-posX, pos.getY(), -posZ);
            default:
                return mirror ? new BlockPos(posX, pos.getY(), posZ) : pos;
        }
    }

    public static BlockPos extractOffset(BlockPos startPos, BlockPos blockPos) {
        return blockPos instanceof BlockPos.Mutable ? new BlockPos.Mutable(startPos.getX() - blockPos.getX(), blockPos.getY(), startPos.getZ() - blockPos.getZ()) :
                new BlockPos(startPos.getX() - blockPos.getX(), blockPos.getY(), startPos.getZ() - blockPos.getZ());
    }
}
