package voronoiaoc.byg.common.world.feature.features.nether.wailinggarth;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class ScorchedBush extends Feature<NoFeatureConfig> {
    public ScorchedBush(Codec<NoFeatureConfig> config) {
        super(config);
    }

    public boolean func_241855_a(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        if (!worldIn.isAirBlock(pos)) {
            return false;
        } else if ((worldIn.getBlockState(pos.down()).getBlock() == BYGBlockList.OVERGROWN_NETHERRACK) || (worldIn.getBlockState(pos.down()).getBlock() == Blocks.SOUL_SAND) || (worldIn.getBlockState(pos.down()).getBlock() == Blocks.SOUL_SOIL)) {
            worldIn.setBlockState(pos, BYGBlockList.SCORCHED_BUSH.getDefaultState(), 2);
            return true;
        }
        return true;
    }
}