package corgiaoc.byg.common.world.feature;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraftforge.common.Tags;

public class FeatureUtil {

    public static boolean isPlant(IWorldGenerationBaseReader world, BlockPos pos) {
        return world.hasBlockState(pos, (state) -> state.isIn(BlockTags.LEAVES) || state.getMaterial() == Material.LEAVES || state.getMaterial() == Material.PLANTS || state.getMaterial() == Material.TALL_PLANTS || state.getMaterial() == Material.OCEAN_PLANT);
    }

    public static boolean isTerrainOrRock(IWorldGenerationBaseReader world, BlockPos pos) {
        return world.hasBlockState(pos, (state) -> state.isIn(BlockTags.BASE_STONE_OVERWORLD) || state.getMaterial() == Material.ROCK || state.isIn(BlockTags.BASE_STONE_OVERWORLD) || state.getMaterial() == Material.EARTH || state.isIn(BlockTags.SAND) || state.isIn(Tags.Blocks.SAND) || state.isIn(Tags.Blocks.SAND_COLORLESS) || state.isIn(Tags.Blocks.SAND_RED) || state.isIn(Tags.Blocks.SANDSTONE) || state.getMaterial() == Material.SAND || state.getBlock() == Blocks.GRASS_BLOCK);
    }

    public static boolean isAir(IWorldGenerationBaseReader reader, BlockPos pos) {
        return reader.hasBlockState(pos, BlockState::isAir);
    }

    public static boolean isAirInRange(IWorldGenerationBaseReader world, BlockPos pos, int xRange, int yRange, int zRange) {
        return isAirInRange(world, pos, xRange, yRange, zRange, xRange, yRange, zRange);
    }

    public static boolean isAirInRange(IWorldGenerationBaseReader world, BlockPos pos, int xNegRange, int yNegRange, int zNegRange, int xPosRange, int yPosRange, int zPosRange) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (int x = -xNegRange; x <= xPosRange; x++) {
            for (int y = -yNegRange; y <= yPosRange; y++) {
                for (int z = -zNegRange; z <= zPosRange; z++) {
                    mutable.setPos(pos.add(x, y, z));
                    if (!isAir(world, mutable))
                        return false;
                }
            }
        }
        return true;
    }




    public static void transformMutable(BlockPos.Mutable pos, Mirror mirrorIn, Rotation rotationIn)
    {
        switch (mirrorIn)
        {
            case LEFT_RIGHT:
                pos.setZ(-pos.getZ());
                break;
            case FRONT_BACK:
                pos.setX(-pos.getX());
                break;
        }
        switch (rotationIn)
        {
            case COUNTERCLOCKWISE_90:
                pos.setPos(pos.getZ(), pos.getY(), -pos.getX());
                break;
            case CLOCKWISE_90:
                pos.setPos(-pos.getZ(), pos.getY(), pos.getX());
                break;
            case CLOCKWISE_180:
                pos.setPos(-pos.getX(), pos.getY(), -pos.getZ());
                break;
        }
    }

    public static BlockPos transform(BlockPos pos, Mirror mirrorIn, Rotation rotationIn)
    {
        int posX = pos.getX();
        int posZ = pos.getZ();
        boolean mirror = true;
        switch (mirrorIn)
        {
            case LEFT_RIGHT:
                posZ = -posZ;
                break;
            case FRONT_BACK:
                posX = -posX;
                break;
            default:
                mirror = false;
        }
        switch (rotationIn)
        {
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
}
