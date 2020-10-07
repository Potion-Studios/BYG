package corgiaoc.byg.common.world.feature.nether.sythiantorrids;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class SythianFungus extends Feature<NoFeatureConfig> {
    public SythianFungus(Codec<NoFeatureConfig> config) {
        super(config);
    }

    public boolean func_241855_a(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        if (!worldIn.isAirBlock(pos) || worldIn.getBlockState(pos.down()).getBlock() != BYGBlocks.SYTHIAN_NYLIUM) {
            return false;
        } else {
            worldIn.setBlockState(pos, BYGBlocks.SYTHIAN_FUNGUS.getDefaultState(), 10);
            return true;
        }
    }
}