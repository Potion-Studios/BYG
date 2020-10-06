package corgiaoc.byg.common.world.feature.features.overworld.trees.deciduous;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import corgiaoc.byg.common.world.feature.features.config.BYGTreeFeatureConfig;
import corgiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;

import java.util.Random;
import java.util.Set;

public class DeciduousTree4 extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {

    public DeciduousTree4(Codec<BYGTreeFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeFeatureConfig config) {

        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        BlockPos.Mutable mutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 7, 5, 5, isSapling)) {
                return false;
            } else {
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.add(0, 0, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.add(0, 1, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.add(0, 2, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.add(0, 3, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.add(0, 4, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.add(0, 5, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.add(0, 6, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.add(0, 7, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.add(0, 8, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.add(0, 9, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.add(0, 10, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.add(0, 11, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.add(0, 12, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.add(0, 13, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.add(0, 14, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.add(0, 15, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.add(0, 16, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, 7, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, 7, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, 7, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, 7, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 7, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 7, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 7, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, 7, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, 8, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, 8, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, 8, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, 8, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, 8, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 8, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 8, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 8, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 8, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, 8, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, 9, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, 9, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, 9, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, 9, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, 9, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, 9, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, 9, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, 9, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, 9, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, 9, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 9, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 9, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 9, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 9, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, 9, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, 9, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, 9, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, 10, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, 10, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, 10, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, 10, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, 10, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, 10, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, 10, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, 10, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, 10, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, 10, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 10, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 10, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 10, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 10, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, 11, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, 11, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, 11, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, 11, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, 11, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, 11, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, 11, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, 11, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, 11, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, 11, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, 11, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 11, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 11, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 11, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 11, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, 11, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, 11, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, 11, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, 11, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, 11, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, 12, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, 12, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, 12, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, 12, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, 12, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, 12, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 12, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 12, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 12, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, 12, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, 12, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, 13, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, 13, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, 13, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, 13, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, 13, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, 13, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 13, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, 13, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, 13, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, 13, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, 14, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, 14, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, 14, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 14, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 14, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 14, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 14, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, 14, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, 15, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, 15, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, 15, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, 15, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, 15, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, 15, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 15, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 15, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, 16, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, 16, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 16, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 16, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, 17, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, 17, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 17, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, 18, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, 18, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, 19, 0), boundsIn);
            }
        }
        return true;
    }
}