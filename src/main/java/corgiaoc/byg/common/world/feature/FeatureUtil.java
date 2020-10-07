package corgiaoc.byg.common.world.feature;

import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.tags.BlockTags;
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
}
