package corgiaoc.byg.common.world.feature.features.overworld;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SnowyDirtBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class BlackIceAndSnowFeature extends Feature<NoFeatureConfig> {
    public BlackIceAndSnowFeature(Codec<NoFeatureConfig> p_i51435_1_) {
        super(p_i51435_1_);
    }

    public boolean func_241855_a(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
        BlockPos.Mutable blockpos$mutable1 = new BlockPos.Mutable();

        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                int k = pos.getX() + i;
                int l = pos.getZ() + j;
                int i1 = worldIn.getHeight(Heightmap.Type.MOTION_BLOCKING, k, l);
                blockpos$mutable.setPos(k, i1, l);
                blockpos$mutable1.setPos(blockpos$mutable).move(Direction.DOWN, 1);
                Biome biome = worldIn.getBiome(blockpos$mutable);
                if (biome.doesWaterFreeze(worldIn, blockpos$mutable1, false)) {
                    worldIn.setBlockState(blockpos$mutable1, BYGBlocks.BLACK_ICE.getDefaultState(), 2);
                }

                if (biome.doesSnowGenerate(worldIn, blockpos$mutable)) {
                    worldIn.setBlockState(blockpos$mutable, Blocks.SNOW.getDefaultState(), 2);
                    BlockState blockstate = worldIn.getBlockState(blockpos$mutable1);
                    if (blockstate.get(SnowyDirtBlock.SNOWY)) {
                        worldIn.setBlockState(blockpos$mutable1, blockstate.with(SnowyDirtBlock.SNOWY, Boolean.valueOf(true)), 2);
                    }
                }
            }
        }
        return true;
    }
}