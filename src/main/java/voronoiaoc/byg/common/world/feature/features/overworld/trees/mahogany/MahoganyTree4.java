package voronoiaoc.byg.common.world.feature.features.overworld.trees.mahogany;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import voronoiaoc.byg.common.world.feature.config.BYGTreeFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;

public class MahoganyTree4 extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {

    public MahoganyTree4(Codec<BYGTreeFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeFeatureConfig config) {
        BlockState LOG = config.getTrunkProvider().getBlockState(rand, pos);
        BlockState LEAVES = config.getLeavesProvider().getBlockState(rand, pos);
        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isSapling)) {
                return false;
            } else {
                placeTrunk(LOG, changedBlocks, worldIn, mainmutable.add(0, 0, 0), boundsIn);
                placeTrunk(LOG, changedBlocks, worldIn, mainmutable.add(0, 1, 0), boundsIn);
                placeTrunk(LOG, changedBlocks, worldIn, mainmutable.add(0, 2, 0), boundsIn);
                placeTrunk(LOG, changedBlocks, worldIn, mainmutable.add(0, 3, 0), boundsIn);
                placeTrunk(LOG, changedBlocks, worldIn, mainmutable.add(0, 4, 0), boundsIn);
                placeTrunk(LOG, changedBlocks, worldIn, mainmutable.add(0, 5, 0), boundsIn);
                placeTrunk(LOG, changedBlocks, worldIn, mainmutable.add(0, 6, 0), boundsIn);
                placeTrunk(LOG, changedBlocks, worldIn, mainmutable.add(0, 7, 0), boundsIn);
                placeTrunk(LOG, changedBlocks, worldIn, mainmutable.add(0, 8, 0), boundsIn);
                placeTrunk(LOG, changedBlocks, worldIn, mainmutable.add(0, 9, 0), boundsIn);
                placeTrunk(LOG, changedBlocks, worldIn, mainmutable.add(0, 10, 0), boundsIn);
                placeTrunk(LOG, changedBlocks, worldIn, mainmutable.add(0, 11, 0), boundsIn);
                placeTrunk(LOG, changedBlocks, worldIn, mainmutable.add(0, 12, 0), boundsIn);
                placeTrunk(LOG, changedBlocks, worldIn, mainmutable.add(0, 13, 0), boundsIn);
                placeTrunk(LOG, changedBlocks, worldIn, mainmutable.add(0, 14, 0), boundsIn);
                placeTrunk(LOG, changedBlocks, worldIn, mainmutable.add(0, 15, 0), boundsIn);
                placeTrunk(LOG, changedBlocks, worldIn, mainmutable.add(0, 16, 0), boundsIn);
                placeTrunk(LOG, changedBlocks, worldIn, mainmutable.add(0, 17, 0), boundsIn);
                placeTrunk(LOG, changedBlocks, worldIn, mainmutable.add(0, 18, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 0, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 0, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 0, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 0, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 8, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 8, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 9, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 9, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 9, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 9, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 10, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 10, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 10, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 10, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 11, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 11, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 11, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 11, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 12, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 12, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 12, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 12, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 13, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 13, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 13, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 13, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3, 13, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3, 13, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 14, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 14, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 14, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 14, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 14, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 14, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 14, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 14, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 14, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 14, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 14, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 14, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 14, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 14, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 14, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3, 14, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3, 14, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3, 14, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(4, 14, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 15, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 15, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 16, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 16, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 16, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 16, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 17, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 17, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 17, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 17, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 18, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 18, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 18, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 18, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 18, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 18, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 18, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 18, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 18, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 18, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 18, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 18, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 18, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 18, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3, 18, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3, 18, 2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(3, 12, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-5, 13, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-4, 13, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-4, 13, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-4, 13, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-4, 13, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-3, 13, -5), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-3, 13, -4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-3, 13, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-3, 13, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-3, 13, 2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 13, -6), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 13, -5), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 13, -4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 13, -3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 13, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 13, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 13, 4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 13, -6), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 13, -5), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 13, -4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 13, -3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 13, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 13, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 13, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 13, 2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 13, 3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 13, 4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 13, -6), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 13, -5), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 13, -4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 13, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 13, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 13, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 13, 2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 13, 4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 13, 5), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 13, -5), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 13, -4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 13, -3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 13, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 13, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 13, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 13, 2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 13, 3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 13, 4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 13, -4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 13, -3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 13, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 13, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 13, 3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(3, 13, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(3, 13, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(4, 13, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(4, 13, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-6, 14, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-6, 14, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-6, 14, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-5, 14, -3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-5, 14, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-5, 14, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-5, 14, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-5, 14, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-5, 14, 2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-4, 14, -4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-4, 14, -3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-4, 14, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-4, 14, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-4, 14, 2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-4, 14, 3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-3, 14, -4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-3, 14, -3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-3, 14, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-3, 14, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-3, 14, 3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-3, 14, 4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-3, 14, 5), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 14, -4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 14, -3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 14, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 14, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 14, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 14, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 14, 2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 14, 3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 14, 5), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 14, 6), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 14, -4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 14, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 14, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 14, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 14, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 14, 2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 14, 5), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 14, 6), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 14, -5), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 14, -4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 14, -3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 14, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 14, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 14, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 14, 2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 14, 3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 14, 4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 14, 5), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 14, 6), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 14, -6), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 14, -5), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 14, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 14, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 14, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 14, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 14, 2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 14, 5), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 14, 6), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 14, -6), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 14, -5), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 14, -3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 14, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 14, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 14, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 14, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 14, 2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 14, 4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 14, 5), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(3, 14, -5), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(3, 14, -4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(3, 14, -3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(3, 14, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(3, 14, 2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(3, 14, 3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(3, 14, 4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(4, 14, -4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(4, 14, -3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(4, 14, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(4, 14, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(4, 14, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(4, 14, 2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(4, 14, 3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(5, 14, -3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(5, 14, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(5, 14, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(5, 14, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(5, 14, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-4, 15, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-4, 15, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-3, 15, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-3, 15, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-3, 15, 2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 15, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 15, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 15, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 15, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 15, 2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 15, 4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 15, -3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 15, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 15, 3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 15, 4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 15, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 15, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 15, 2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 15, 3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 15, -4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 15, -3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 15, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 15, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 15, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 15, 2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 15, 3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 15, 4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 15, -4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 15, -3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 15, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 15, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 15, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 15, 3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(3, 15, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(3, 15, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(3, 15, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(4, 15, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-5, 18, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-5, 18, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-5, 18, 2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-4, 18, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-4, 18, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-4, 18, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-4, 18, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-4, 18, 2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-3, 18, -3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-3, 18, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-3, 18, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-3, 18, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-3, 18, 3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 18, -4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 18, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 18, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 18, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 18, 4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 18, -5), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 18, -4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 18, -3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 18, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 18, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 18, 2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 18, 3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 18, 4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 18, 5), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 18, -5), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 18, -4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 18, -3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 18, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 18, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 18, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 18, 2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 18, 3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 18, 4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 18, 5), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 18, -4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 18, -3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 18, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 18, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 18, 2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 18, 3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 18, 4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 18, 5), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 18, -4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 18, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 18, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 18, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 18, 4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(3, 18, -3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(3, 18, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(3, 18, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(3, 18, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(3, 18, 3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(4, 18, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(4, 18, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(4, 18, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(4, 18, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(4, 18, 2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(5, 18, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(5, 18, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(5, 18, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-4, 19, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-3, 19, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-3, 19, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-3, 19, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-3, 19, 2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 19, -3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 19, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 19, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 19, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 19, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 19, 2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-2, 19, 3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 19, -4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 19, -3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 19, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 19, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 19, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 19, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 19, 2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 19, 3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(-1, 19, 4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 19, -3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 19, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 19, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 19, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 19, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 19, 2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 19, 3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(0, 19, 4), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 19, -3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 19, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 19, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 19, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 19, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 19, 2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(1, 19, 3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 19, -3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 19, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 19, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 19, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 19, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 19, 2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(2, 19, 3), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(3, 19, -2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(3, 19, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(3, 19, 0), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(3, 19, 1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(3, 19, 2), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(4, 19, -1), boundsIn);
                placeLeaves(LEAVES, changedBlocks, worldIn, mainmutable.add(4, 19, 0), boundsIn);
            }
        }
        return true;
    }


    private void treeLog(Set<BlockPos> setlogblock, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.MAHOGANY_LOG.getDefaultState(), boundingBox);
        }
    }


    private void treeBranch(Set<BlockPos> setlogblock, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.MAHOGANY_LOG.getDefaultState(), boundingBox);
        }
    }


    private void leafs(Set<BlockPos> blockPos, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(blockPos, reader, pos, BYGBlockList.MAHOGANY_LEAVES.getDefaultState(), boundingBox);
        }
    }


    private boolean doesTreeFit(IWorldGenerationBaseReader reader, BlockPos blockPos, int height) {
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        BlockPos.Mutable pos = new BlockPos.Mutable();

        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
            //Distance/Density of trees. Positive Values ONLY
            int distance = 0;

            for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
                for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
                    if (!canLogPlaceHere(reader, pos.setPos(x + xOffset, y + yOffset, z + zOffset))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}