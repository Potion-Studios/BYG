package corgiaoc.byg.common.world.feature.nether.wailinggarth;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class WailingGrass extends Feature<NoFeatureConfig> {
    public WailingGrass(Codec<NoFeatureConfig> config) {
        super(config);
    }

    public boolean func_241855_a(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        if (!worldIn.isAirBlock(pos)) {
            return false;
        } else if ((worldIn.getBlockState(pos.down()).getBlock() == BYGBlocks.OVERGROWN_NETHERRACK) || (worldIn.getBlockState(pos.down()).getBlock() == Blocks.SOUL_SAND) || (worldIn.getBlockState(pos.down()).getBlock() == Blocks.SOUL_SOIL)) {
            worldIn.setBlockState(pos, BYGBlocks.WHALING_GRASS.getDefaultState(), 2);
            return true;
        }
        return true;
    }
}