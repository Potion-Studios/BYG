package voronoiaoc.byg.common.world.feature.features.overworld;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class CanyonCactus extends Feature<DefaultFeatureConfig> {
    public CanyonCactus(Codec<DefaultFeatureConfig> config) {
        super(config);
    }


    public boolean generate(StructureWorldAccess worldIn, ChunkGenerator generator, Random random, BlockPos pos, DefaultFeatureConfig config) {
        if (!worldIn.isAir
                (pos) || worldIn.getBlockState(pos.down()).getBlock() != Blocks.RED_SAND)
            return false;
        if (pos.getY() < 140)
            return false;
        else {
            worldIn.setBlockState(pos, Blocks.CACTUS.getDefaultState(), 2);
            worldIn.setBlockState(pos.up(), Blocks.CACTUS.getDefaultState(), 2);
            return true;
        }
    }
}