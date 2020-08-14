package voronoiaoc.byg.common.world.feature.features.overworld;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class CanyonCactus extends Feature<NoFeatureConfig> {
    public CanyonCactus(Codec<NoFeatureConfig> config) {
        super(config);
    }

    public boolean func_241855_a(ISeedReader worldIn,  ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        if (!worldIn.isAirBlock(pos) || worldIn.getBlockState(pos.down()).getBlock() != Blocks.RED_SAND)
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