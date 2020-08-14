package voronoiaoc.byg.common.world.feature.features.nether.sythiantorrids;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class SythianRoots extends Feature<NoFeatureConfig> {
    public SythianRoots(Codec<NoFeatureConfig> config) {
        super(config);
    }

    public boolean func_241855_a(ISeedReader worldIn,  ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        if (!worldIn.isAirBlock(pos) || worldIn.getBlockState(pos.down()).getBlock() != BYGBlockList.SYTHIAN_NYLIUM) {
            return false;
        } else {
            worldIn.setBlockState(pos, BYGBlockList.SYTHIAN_ROOTS.getDefaultState(), 10);
            return true;
        }
    }
}