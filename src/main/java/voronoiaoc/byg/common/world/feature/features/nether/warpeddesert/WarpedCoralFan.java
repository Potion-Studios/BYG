package voronoiaoc.byg.common.world.feature.features.nether.warpeddesert;

import com.mojang.serialization.Codec;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class WarpedCoralFan extends Feature<NoneFeatureConfiguration> {
    public WarpedCoralFan(Codec<NoneFeatureConfiguration> config) {
        super(config);
    }

    public boolean place(WorldGenLevel worldIn, ChunkGenerator generator, Random random, BlockPos pos, NoneFeatureConfiguration config) {
        if (!worldIn.isEmptyBlock(pos)) {
            return false;
        } else if ((worldIn.getBlockState(pos.below()).getBlock() == BYGBlockList.NYLIUM_SOUL_SAND) || (worldIn.getBlockState(pos.below()).getBlock() == BYGBlockList.NYLIUM_SOUL_SOIL)) {
            worldIn.setBlock(pos, BYGBlockList.WARPED_CORAL_FAN.defaultBlockState(), 2);
            return true;
        }
        return true;
    }
}