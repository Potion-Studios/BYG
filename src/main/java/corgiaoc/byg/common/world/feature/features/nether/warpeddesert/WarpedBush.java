package corgiaoc.byg.common.world.feature.features.nether.warpeddesert;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import corgiaoc.byg.core.byglists.BYGBlocks;

import java.util.Random;

public class WarpedBush extends Feature<NoFeatureConfig> {
    public WarpedBush(Codec<NoFeatureConfig> config) {
        super(config);
    }

    public boolean func_241855_a(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        if (!worldIn.isAirBlock(pos)) {
            return false;
        } else if ((worldIn.getBlockState(pos.down()).getBlock() == BYGBlocks.NYLIUM_SOUL_SAND) || (worldIn.getBlockState(pos.down()).getBlock() == BYGBlocks.NYLIUM_SOUL_SOIL)) {
            worldIn.setBlockState(pos, BYGBlocks.WARPED_BUSH.getDefaultState(), 2);
            return true;
        }
        return true;
    }
}