package voronoiaoc.byg.common.world.feature.features.overworld;

import com.mojang.serialization.Codec;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class CanyonCactus extends Feature<NoneFeatureConfiguration> {
    public CanyonCactus(Codec<NoneFeatureConfiguration> config) {
        super(config);
    }


    public boolean place(WorldGenLevel worldIn, ChunkGenerator generator, Random random, BlockPos pos, NoneFeatureConfiguration config) {
        if (!worldIn.isEmptyBlock
                (pos) || worldIn.getBlockState(pos.below()).getBlock() != Blocks.RED_SAND)
            return false;
        if (pos.getY() < 140)
            return false;
        else {
            worldIn.setBlock(pos, Blocks.CACTUS.defaultBlockState(), 2);
            worldIn.setBlock(pos.above(), Blocks.CACTUS.defaultBlockState(), 2);
            return true;
        }
    }
}