package voronoiaoc.byg.common.world.feature.features.overworld;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SnowyBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.Heightmap;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class BlackIceAndSnowFeature extends Feature<DefaultFeatureConfig> {
    public BlackIceAndSnowFeature(Codec<DefaultFeatureConfig> config) {
        super(config);
    }

    public boolean generate(ServerWorldAccess worldIn, ChunkGenerator generator, Random random, BlockPos pos, DefaultFeatureConfig config) {
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
        BlockPos.Mutable blockpos$mutable1 = new BlockPos.Mutable();

        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                int k = pos.getX() + i;
                int l = pos.getZ() + j;
                int i1 = worldIn.getTopY(Heightmap.Type.MOTION_BLOCKING, k, l);
                blockpos$mutable.set(k, i1, l);
                blockpos$mutable1.set(blockpos$mutable).move(Direction.DOWN, 1);
                Biome biome = worldIn.getBiome(blockpos$mutable);
                if (biome.canSetIce(worldIn, blockpos$mutable1, false)) {
                    worldIn.setBlockState(blockpos$mutable1, BYGBlockList.BLACK_ICE.getDefaultState(), 2);
                }

                if (biome.canSetIce(worldIn, blockpos$mutable)) {
                    worldIn.setBlockState(blockpos$mutable, Blocks.SNOW.getDefaultState(), 2);
                    BlockState blockstate = worldIn.getBlockState(blockpos$mutable1);
                    if (blockstate.contains(SnowyBlock.SNOWY)) {
                        worldIn.setBlockState(blockpos$mutable1, blockstate.with(SnowyBlock.SNOWY, Boolean.valueOf(true)), 2);
                    }
                }
            }
        }
        return true;
    }

}