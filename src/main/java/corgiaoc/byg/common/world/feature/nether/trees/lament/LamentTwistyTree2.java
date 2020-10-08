package corgiaoc.byg.common.world.feature.nether.trees.lament;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGTreeFeatureConfig;
import corgiaoc.byg.common.world.feature.overworld.trees.util.BYGAbstractTreeFeature;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;

import java.util.Random;
import java.util.Set;

public class LamentTwistyTree2 extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {

    public LamentTwistyTree2(Codec<BYGTreeFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean generate(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeFeatureConfig config) {

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
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.add(0, 0, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.add(0, 1, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.add(0, 7, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.add(0, 8, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.add(0, 9, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(1, 1, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(1, 2, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(1, 3, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(2, 3, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(2, 4, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(1, 5, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(2, 5, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(1, 6, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(1, 7, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(1, 9, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(1, 10, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(1, 11, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(2, 11, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(1, 12, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(2, 12, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(1, 13, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(1, 14, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-1, 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-1, 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 2, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 2, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 2, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 2, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 2, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 2, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 3, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 4, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 4, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 4, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 4, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 4, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 4, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 4, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 4, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, 4, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, 4, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 5, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 5, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, 5, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-1, 6, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-1, 6, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 6, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 6, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 6, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 6, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 6, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 6, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 6, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 6, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 6, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 6, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 6, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 6, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 6, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, 6, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, 6, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-2, 8, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-1, 8, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-1, 8, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-1, 8, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-1, 8, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 8, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 8, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 8, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 8, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 8, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 8, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 8, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 8, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 8, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 8, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 8, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 8, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 8, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 8, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 8, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, 8, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, 8, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-1, 9, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 9, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 9, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 9, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 9, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 9, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-1, 10, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-1, 10, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-1, 10, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 10, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 10, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 10, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 10, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 10, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 10, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 10, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 10, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 10, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 10, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 10, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 10, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 10, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, 10, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, 10, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, 10, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 11, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 11, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 11, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 11, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 11, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 11, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 11, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 11, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 11, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 11, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 11, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 11, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 11, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, 11, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, 11, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, 11, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, 11, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, 11, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(4, 11, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(4, 11, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 12, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 12, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 12, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 12, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 12, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 12, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, 12, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, 12, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(4, 12, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 13, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-1, 14, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-1, 14, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 14, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 14, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 14, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 14, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 14, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 14, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 14, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 14, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 14, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 14, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 14, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, 14, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 15, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 15, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 15, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 15, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 15, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 15, -1), boundsIn);
            }
        }
        return true;
    }
}