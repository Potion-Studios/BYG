package voronoiaoc.byg.common.world.feature.features.nether.trees.lament;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import voronoiaoc.byg.common.world.feature.featureconfig.BYGTreeFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;

import java.util.Random;
import java.util.Set;

public class LamentTwistyTree1 extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {

    public LamentTwistyTree1(Codec<BYGTreeFeatureConfig> configIn) {
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
                placeTrunk(config, rand,changedBlocks, worldIn, mainmutable.add(0, 7, 0), boundsIn);
                placeTrunk(config, rand,changedBlocks, worldIn, mainmutable.add(0, 8, 0), boundsIn);
                placeTrunk(config, rand,changedBlocks, worldIn, mainmutable.add(0, 9, 0), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 2, 1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 3, 1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 4, 0), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 4, 1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 5, 0), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 5, -1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 6, -1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 7, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 1, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 1, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 1, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 1, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 1, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 1, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 1, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 1, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 1, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 1, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 1, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 1, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 1, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 2, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 2, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 2, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 2, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 2, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 2, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 2, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 2, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 2, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 2, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 2, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 2, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 2, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-4, 4, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-4, 4, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 4, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 4, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 4, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 4, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 4, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 4, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 4, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 4, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 4, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 4, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 4, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 4, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 4, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 4, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 4, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-4, 5, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 5, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 5, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 5, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 5, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 5, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 5, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 6, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 6, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 6, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 6, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 6, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 6, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 6, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 6, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 6, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 6, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 6, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 6, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 6, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 8, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 8, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 8, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 8, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 9, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 9, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 9, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 9, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 9, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 9, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 9, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 9, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 9, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 9, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 9, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 9, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 9, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 9, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 9, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 9, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 9, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 9, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 10, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 10, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 10, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 10, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 10, 0), boundsIn);
            }
        }
        return true;
    }
}