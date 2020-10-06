package corgiaoc.byg.common.world.feature.features.overworld.trees.skyris;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import corgiaoc.byg.common.world.feature.featureconfig.BYGTreeFeatureConfig;
import corgiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;

import java.util.Random;
import java.util.Set;

public class SkyrisTree5 extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {

    public SkyrisTree5(Codec<BYGTreeFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeFeatureConfig config) {

        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 7, 5, 5, isSapling)) {
                return false;
            } else {
                placeTrunk(config, rand,changedBlocks, worldIn, mainmutable.add(0, 0, 0), boundsIn);
                placeTrunk(config, rand,changedBlocks, worldIn, mainmutable.add(0, 1, 0), boundsIn);
                placeTrunk(config, rand,changedBlocks, worldIn, mainmutable.add(0, 2, 0), boundsIn);
                placeTrunk(config, rand,changedBlocks, worldIn, mainmutable.add(0, 3, 0), boundsIn);
                placeTrunk(config, rand,changedBlocks, worldIn, mainmutable.add(0, 4, 0), boundsIn);
                placeTrunk(config, rand,changedBlocks, worldIn, mainmutable.add(0, 5, 0), boundsIn);
                placeTrunk(config, rand,changedBlocks, worldIn, mainmutable.add(0, 6, 0), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(1, 5, 1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(0, 6, -1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(1, 6, 1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(2, 6, 1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 7, 0), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(0, 7, -2), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(1, 7, 1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(1, 8, 1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(1, 9, 1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(1, 10, 1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(2, 10, 1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(1, 11, 1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(3, 11, 1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(0, 12, 1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(4, 12, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-4, 7, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-4, 7, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-4, 7, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-4, 7, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-4, 7, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 7, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 7, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 7, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 7, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 7, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 7, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 7, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 7, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 7, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 7, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 7, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 7, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 7, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 7, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 7, -4), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 7, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 7, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 7, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 7, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 7, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 7, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 7, -4), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 7, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 7, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 7, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 7, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 7, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 7, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 7, -4), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 7, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 7, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 7, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 7, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 7, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 7, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 7, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 7, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 7, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 7, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 7, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 7, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 8, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 8, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 8, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 8, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 8, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 8, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 8, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 8, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 8, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 8, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 8, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 8, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 8, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 8, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 12, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 12, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 12, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 12, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 12, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 12, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 12, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 12, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 12, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 12, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 12, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 12, 4), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 12, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 12, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 12, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 12, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 12, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 12, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 12, 4), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 12, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 12, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 12, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 12, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 12, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 12, 4), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 12, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 12, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 12, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 12, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 12, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 12, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 12, 4), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 12, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 12, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 12, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 12, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 12, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 12, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 12, 4), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(3, 12, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(3, 12, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(3, 12, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(3, 12, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(3, 12, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(4, 12, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(4, 12, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(4, 12, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(4, 12, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(5, 12, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(5, 12, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(5, 12, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(5, 12, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(5, 12, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(6, 12, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(6, 12, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(6, 12, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 13, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 13, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 13, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 13, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 13, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 13, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 13, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 13, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 13, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 13, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 13, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 13, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 13, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(3, 13, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(3, 13, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(3, 13, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(4, 13, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(4, 13, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(4, 13, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(5, 13, 1), boundsIn);
            }
        }
        return true;
    }
}