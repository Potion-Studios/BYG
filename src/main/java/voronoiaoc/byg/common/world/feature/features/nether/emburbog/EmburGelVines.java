package voronoiaoc.byg.common.world.feature.features.nether.emburbog;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class EmburGelVines extends Feature<DefaultFeatureConfig> {
    public EmburGelVines(Codec<DefaultFeatureConfig> config) {
        super(config);
    }

    public boolean generate(StructureWorldAccess worldIn, ChunkGenerator generator, Random rand, BlockPos pos, DefaultFeatureConfig config) {
        int randLength = rand.nextInt(2) + 3;

        if (!worldIn.isAir(pos)) {
            return false;
        } else if (worldIn.getBlockState(pos.up()).getBlock() != BYGBlockList.EMBUR_GEL_BLOCK) {
            return false;
        } else {
            for (int WeepingRootPlantLength = 0; WeepingRootPlantLength <= randLength; WeepingRootPlantLength++) {
                BlockPos.Mutable mutable = new BlockPos.Mutable(pos.getX(), pos.getY() - WeepingRootPlantLength, pos.getZ());
            if (worldIn.getBlockState(mutable).getBlock() == Blocks.AIR)
                worldIn.setBlockState(mutable, BYGBlockList.EMBUR_GEL_VINES.getDefaultState(), 10);

            }
            return true;
        }
    }
}