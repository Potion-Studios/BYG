package corgiaoc.byg.common.world.feature.overworld.trees.palm;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGTreeFeatureConfig;
import corgiaoc.byg.common.world.feature.overworld.trees.util.BYGAbstractTreeFeature;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;

import java.util.Random;
import java.util.Set;

public class PalmTree1 extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {
    //private static final BlockState LOG = Blocks.JUNGLE_LOG.getDefaultState();
    //private static final BlockState LEAVES = Blocks.JUNGLE_LEAVES.getDefaultState();
    private static final BlockState BEENEST = Blocks.BEE_NEST.getDefaultState();

    public PalmTree1(Codec<BYGTreeFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean generate(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeFeatureConfig config) {

        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            if (!isDesiredGroundwSandTag(worldIn, pos.down(), config)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 7, 5, 5, isSapling)) {
                return false;
            } else {
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.add(0, 0, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.add(0, 1, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(0, 2, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(0, 3, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(0, 4, -2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(0, 5, -2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(0, 6, -3), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(-1, 7, -3), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(0, 7, -4), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(0, 7, -3), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(0, 7, -2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(1, 7, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-3, 6, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-2, 6, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 6, -6), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 6, -5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 6, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 6, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 6, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, 6, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-2, 7, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-1, 7, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-1, 7, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 7, -5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 7, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 7, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 7, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, 7, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-1, 8, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 8, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 8, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, 8, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, 8, -3), boundsIn);
            }
        }
        return true;
    }
}