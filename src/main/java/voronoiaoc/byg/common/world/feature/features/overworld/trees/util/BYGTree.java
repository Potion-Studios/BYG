package voronoiaoc.byg.common.world.feature.features.overworld.trees.util;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.StructureManager;

import javax.annotation.Nullable;
import java.util.Random;

public abstract class BYGTree {
    @Nullable
    protected abstract BYGAbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random);

    public boolean func_242575_a(ISeedReader worldIn, StructureManager structureManager, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, Random random) {
        BYGAbstractTreeFeature<NoFeatureConfig> abstracttreefeature = this.getTreeFeature(random);
        if (abstracttreefeature == null) {
            return false;
        } else {
            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);
            if (abstracttreefeature.func_230362_a_(worldIn, structureManager, chunkGenerator, random, pos, IFeatureConfig.NO_FEATURE_CONFIG)) {
                return true;
            } else {
                worldIn.setBlockState(pos, blockUnder, 4);
                return false;
            }
        }

    }
}