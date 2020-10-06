package corgiaoc.byg.common.world.feature.features.nether.trees.withering;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import corgiaoc.byg.common.world.feature.features.config.BYGTreeFeatureConfig;
import corgiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;

import java.util.Random;
import java.util.Set;

public class WitheringOakTree4 extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {

    public WitheringOakTree4(Codec<BYGTreeFeatureConfig> configIn) {
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
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 0, 0), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(0, 0, -1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(0, 0, 1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(1, 0, 0), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 1, 0), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(0, 1, -2), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(0, 1, 2), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(2, 1, 0), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 2, -1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 2, 0), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 2, 2), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(0, 2, -2), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(0, 2, 2), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(1, 2, 3), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(2, 2, 0), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(3, 2, -1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 3, -1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 3, 0), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 3, 2), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(0, 3, -2), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(1, 3, 3), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(3, 3, -1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 4, -1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(0, 4, -3), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(1, 4, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 1, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 1, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 1, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 1, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 1, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 1, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 1, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 1, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 1, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 1, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(3, 1, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(3, 1, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-4, 2, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 2, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 2, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 2, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 2, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 2, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 2, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 2, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 2, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 2, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 2, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 2, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 2, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 2, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 2, 4), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 2, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 2, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 2, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 2, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 2, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(3, 2, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(3, 2, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(4, 2, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-4, 3, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 3, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 3, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 3, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 3, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 3, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 3, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 3, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 3, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 3, -4), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 3, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 3, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 3, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 3, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 3, 4), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 3, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 3, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 3, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 3, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 3, 4), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 3, -4), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 3, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 3, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 3, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 3, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(3, 3, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(3, 3, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(3, 3, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(4, 3, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(4, 3, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 4, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 4, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 4, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 4, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 4, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 4, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 4, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 4, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 4, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 4, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 4, 4), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 4, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 4, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 4, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 4, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 4, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 4, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 4, 4), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 4, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 4, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 4, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 4, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 4, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 4, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(3, 4, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(3, 4, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(3, 4, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 5, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 5, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 5, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 5, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 5, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 5, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 5, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 5, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 5, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 5, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 5, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 5, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 5, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 5, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 5, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 5, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 5, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 5, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 6, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 6, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 6, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 6, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 6, 0), boundsIn);
            }
        }
        return true;
    }
}