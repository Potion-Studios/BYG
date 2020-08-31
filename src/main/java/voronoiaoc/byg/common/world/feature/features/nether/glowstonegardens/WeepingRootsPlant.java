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

public class WeepingRootsPlant extends Feature<NoneFeatureConfiguration> {
    public WeepingRootsPlant(Codec<NoneFeatureConfiguration> config) {
        super(config);
    }

    public boolean place(WorldGenLevel worldIn, ChunkGenerator generator, Random random, BlockPos pos, NoneFeatureConfiguration config) {
        int randLength = random.nextInt(7) + 3;

        if (!worldIn.isEmptyBlock(pos)) {
            return false;
        } else if (!worldIn.getBlockState(pos.above()).is(BlockTags.INFINIBURN_NETHER) || !(worldIn.getBlockState(pos.above()).getMaterial() == Material.STONE) && !worldIn.dimensionType().ultraWarm()) {
            return false;
        } else {
            for (int WeepingRootPlantLength = 0; WeepingRootPlantLength <= randLength; WeepingRootPlantLength++) {
                BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().set(pos.getX(), pos.getY() - WeepingRootPlantLength, pos.getZ());
//            if (worldIn.getBlockState(mutable).getBlock() == Blocks.AIR)
                worldIn.setBlock(mutable, BYGBlockList.WEEPING_ROOTS_PLANT.defaultBlockState(), 10);
            }
            return true;
        }
    }
}