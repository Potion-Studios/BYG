package voronoiaoc.byg.common.world.feature.features.overworld.trees.util;

import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import java.util.Random;

public abstract class BYGTree {
    @Nullable
    protected abstract BYGAbstractTreeFeature<NoneFeatureConfiguration> getTreeFeature(Random random);

    public boolean spawn(ServerLevel worldIn, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, Random random) {
        BYGAbstractTreeFeature<NoneFeatureConfiguration> abstracttreefeature = this.getTreeFeature(random);
        if (abstracttreefeature == null) {
            return false;
        } else {
            worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 4);
            if (abstracttreefeature.placeTree(worldIn, chunkGenerator, random, pos, NoneFeatureConfiguration.NONE, true)) {
                return true;
            } else {
                worldIn.setBlock(pos, blockUnder, 4);
                return false;
            }
        }

    }
}