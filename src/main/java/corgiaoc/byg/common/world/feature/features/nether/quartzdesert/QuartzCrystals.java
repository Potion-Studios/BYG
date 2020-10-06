package corgiaoc.byg.common.world.feature.features.nether.quartzdesert;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import corgiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class QuartzCrystals extends Feature<NoFeatureConfig> {
    public QuartzCrystals(Codec<NoFeatureConfig> config) {
        super(config);
    }

    public boolean func_241855_a(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        if (!worldIn.isAirBlock(pos)) {
            return false;
        } else if ((worldIn.getBlockState(pos.down()).getBlock() == BYGBlockList.QUARTZITE_SAND) || (worldIn.getBlockState(pos.down()).getBlock() == BYGBlockList.RAW_QUARTZ_BLOCK)) {
            worldIn.setBlockState(pos, BYGBlockList.QUARTZ_CRYSTAL.getDefaultState(), 2);
            return true;
        }
        return true;
    }
}