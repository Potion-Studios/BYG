package voronoiaoc.byg.common.world.feature.features.nether.trees.withering;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import voronoiaoc.byg.common.world.feature.featureconfig.BYGTreeFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;

import java.util.Random;
import java.util.Set;

public class WitheringOakTree2 extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {

    public WitheringOakTree2(Codec<BYGTreeFeatureConfig> configIn) {
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
                placeTrunk(config, rand,changedBlocks, worldIn, mainmutable.add(0, 7, 0), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(0, 6, -1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(0, 7, -2), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(1, 7, 1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(0, 8, -2), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(1, 8, 1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 9, -2), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(0, 9, -2), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(1, 9, 1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 10, -2), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(0, 10, -2), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(1, 10, 1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 11, -2), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(0, 11, -2), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(0, 11, 2), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(1, 11, 1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 12, -2), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 12, 3), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(0, 12, -2), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(0, 12, 2), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(1, 12, -3), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(1, 12, 1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(2, 12, 1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 13, -2), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 13, 3), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(1, 13, -3), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(1, 13, 1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(3, 13, 1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 14, -3), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 14, -2), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 14, -1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 14, 3), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(1, 14, -3), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(3, 14, 1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 15, -3), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 15, -1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 15, 3), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 15, 3), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(1, 15, -3), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(3, 15, 1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 16, -3), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 16, 3), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 16, -1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 16, 3), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(1, 16, -3), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(2, 16, -4), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(3, 16, 1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(4, 16, 2), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 17, 3), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 17, -1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 17, 3), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(0, 17, 2), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(2, 17, -4), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(4, 17, 2), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 18, 3), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 18, 3), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(0, 18, 1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(0, 18, 2), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(2, 18, -4), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(4, 18, 1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(4, 18, 2), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 19, 3), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(0, 19, 1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(3, 19, 3), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(4, 19, 0), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(4, 19, 2), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(0, 20, 1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(3, 20, 3), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(4, 20, 0), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(0, 21, 1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(3, 21, 3), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(0, 22, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 12, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 13, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 14, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 14, -4), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-4, 15, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 15, -4), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 15, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 15, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 15, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 15, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-4, 16, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 16, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 16, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 16, 4), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 16, -4), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 16, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-4, 17, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 17, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 17, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 17, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 17, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 17, -5), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 17, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(3, 17, -4), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-4, 18, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 18, 4), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 18, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 18, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 18, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 18, 4), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 18, -4), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 18, -5), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(3, 18, -5), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 19, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 19, 4), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 19, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(4, 19, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(4, 19, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(4, 19, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(5, 19, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 20, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 20, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 20, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(3, 20, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(3, 20, 4), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(5, 20, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 21, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 21, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 21, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(3, 21, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(4, 21, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(4, 21, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 22, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 22, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 22, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 22, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(3, 22, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 23, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 23, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 23, 1), boundsIn);
            }
        }
        return true;
    }
}