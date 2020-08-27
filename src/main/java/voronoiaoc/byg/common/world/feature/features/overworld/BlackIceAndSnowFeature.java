package voronoiaoc.byg.common.world.feature.features.overworld;

import com.mojang.serialization.Codec;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SnowyDirtBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class BlackIceAndSnowFeature extends Feature<NoneFeatureConfiguration> {
    public BlackIceAndSnowFeature(Codec<NoneFeatureConfiguration> config) {
        super(config);
    }

    public boolean place(WorldGenLevel worldIn, ChunkGenerator generator, Random random, BlockPos pos, NoneFeatureConfiguration config) {
        BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();
        BlockPos.MutableBlockPos blockpos$mutable1 = new BlockPos.MutableBlockPos();

        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                int k = pos.getX() + i;
                int l = pos.getZ() + j;
                int i1 = worldIn.getHeight(Heightmap.Types.MOTION_BLOCKING, k, l);
                blockpos$mutable.set(k, i1, l);
                blockpos$mutable1.set(blockpos$mutable).move(Direction.DOWN, 1);
                Biome biome = worldIn.getBiome(blockpos$mutable);
                if (biome.shouldFreeze(worldIn, blockpos$mutable1, false)) {
                    worldIn.setBlock(blockpos$mutable1, BYGBlockList.BLACK_ICE.defaultBlockState(), 2);
                }

                if (biome.shouldFreeze(worldIn, blockpos$mutable)) {
                    worldIn.setBlock(blockpos$mutable, Blocks.SNOW.defaultBlockState(), 2);
                    BlockState blockstate = worldIn.getBlockState(blockpos$mutable1);
                    if (blockstate.hasProperty(SnowyDirtBlock.SNOWY)) {
                        worldIn.setBlock(blockpos$mutable1, blockstate.setValue(SnowyDirtBlock.SNOWY, Boolean.valueOf(true)), 2);
                    }
                }
            }
        }
        return true;
    }

}