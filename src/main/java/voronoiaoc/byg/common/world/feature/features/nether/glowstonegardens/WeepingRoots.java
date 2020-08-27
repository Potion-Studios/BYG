package voronoiaoc.byg.common.world.feature.features.nether.glowstonegardens;

import com.mojang.serialization.Codec;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.material.Material;

public class WeepingRoots extends Feature<NoneFeatureConfiguration> {
    public WeepingRoots(Codec<NoneFeatureConfiguration> config) {
        super(config);
    }

    public boolean place(WorldGenLevel worldIn, ChunkGenerator generator, Random random, BlockPos pos, NoneFeatureConfiguration config) {
        if (!worldIn.isEmptyBlock(pos)) {
            return false;
        } else if (!worldIn.isEmptyBlock(pos) || !(worldIn.getBlockState(pos.above()).getMaterial() == Material.STONE) || !worldIn.getBlockState(pos.above()).is(BlockTags.INFINIBURN_NETHER) && !worldIn.dimensionType().ultraWarm()) {
            return false;
        } else {
            worldIn.setBlock(pos, BYGBlockList.WEEPING_ROOTS.defaultBlockState(), 10);
            return true;
        }
    }
}