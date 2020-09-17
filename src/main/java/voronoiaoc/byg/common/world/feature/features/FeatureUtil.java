package voronoiaoc.byg.common.world.feature.features;

import net.minecraft.block.material.Material;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.IWorldGenerationBaseReader;

public class FeatureUtil {

    public static boolean isPlant(IWorldGenerationBaseReader world, BlockPos pos) {
        return world.hasBlockState(pos, (state) -> state.isIn(BlockTags.LEAVES) || state.getMaterial() == Material.PLANTS || state.getMaterial() == Material.TALL_PLANTS || state.getMaterial() == Material.OCEAN_PLANT);
    }
}
