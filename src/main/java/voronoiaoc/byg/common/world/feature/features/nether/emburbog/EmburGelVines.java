package voronoiaoc.byg.common.world.feature.features.nether.emburbog;

import com.mojang.serialization.Codec;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class EmburGelVines extends Feature<NoneFeatureConfiguration> {
    public EmburGelVines(Codec<NoneFeatureConfiguration> config) {
        super(config);
    }

    public boolean place(WorldGenLevel worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoneFeatureConfiguration config) {
        int randLength = rand.nextInt(2) + 3;

        if (!worldIn.isEmptyBlock(pos)) {
            return false;
        } else if (worldIn.getBlockState(pos.above()).getBlock() != BYGBlockList.EMBUR_GEL_BLOCK) {
            return false;
        } else {
            for (int WeepingRootPlantLength = 0; WeepingRootPlantLength <= randLength; WeepingRootPlantLength++) {
                BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos(pos.getX(), pos.getY() - WeepingRootPlantLength, pos.getZ());
                if (worldIn.getBlockState(mutable).getBlock() == Blocks.AIR)
                    worldIn.setBlock(mutable, BYGBlockList.EMBUR_GEL_VINES.defaultBlockState(), 10);

            }
            return true;
        }
    }
}