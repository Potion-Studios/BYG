package voronoiaoc.byg.common.world.feature.features.overworld.trees.deadhazel;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import voronoiaoc.byg.common.world.feature.config.BYGTreeFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;

public class DeadHazel2 extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {

    public DeadHazel2(Codec<BYGTreeFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeFeatureConfig config) {
        
        BlockState LEAVES = config.getLeavesProvider().getBlockState(rand, pos);
        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        BlockPos.Mutable mutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {

            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isSapling)) {
                return false;
            } else {
                for (int buildTrunk = 0; buildTrunk <= randTreeHeight; buildTrunk++) {
                    placeTrunk(config, rand, changedBlocks, worldIn, mutable, boundsIn);

                    mutable.move(Direction.UP);
                }
                mutable.setPos(pos);

                //Stump
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(0, 0, -2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(-1, 0, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(0, 0, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(1, 0, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(-2, 0, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(-1, 0, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(1, 0, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(2, 0, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(-2, 0, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(-1, 0, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(0, 0, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(1, 0, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(-1, 0, 2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(-1, 1, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(0, 1, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(1, 1, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(-1, 1, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(1, 1, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(-1, 1, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(0, 1, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(-1, 2, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(0, 2, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(-1, 2, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(1, 2, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(0, 2, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(0, 3, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(-1, 3, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(0, 3, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight - 3, 0), boundsIn);

                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight - 1, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight - 1, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight, -2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight, -2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(-2, randTreeHeight, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(-2, randTreeHeight + 1, -4), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight + 1, -3), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(-3, randTreeHeight + 1, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(-4, randTreeHeight + 1, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight + 1, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight + 1, 2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(4, randTreeHeight + 1, 2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight + 2, 3), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight + 2, 4), boundsIn);

                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-3, randTreeHeight - 3, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight - 3, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(5, randTreeHeight - 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight - 2, -5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight - 2, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-3, randTreeHeight - 2, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight - 2, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight - 2, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight - 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight - 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight - 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight - 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(5, randTreeHeight - 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(4, randTreeHeight - 2, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight - 1, -5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, randTreeHeight - 1, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight - 1, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight - 1, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight - 1, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight - 1, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight - 1, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight - 1, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight - 1, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight - 1, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(4, randTreeHeight - 1, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-3, randTreeHeight - 1, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight - 1, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight - 1, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight - 1, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight - 1, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, randTreeHeight - 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight - 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight - 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight - 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight - 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(4, randTreeHeight - 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-3, randTreeHeight - 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight - 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight - 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight - 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight - 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(4, randTreeHeight - 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(5, randTreeHeight - 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight - 1, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight - 1, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight - 1, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight - 1, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(4, randTreeHeight - 1, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight - 1, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight - 1, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(4, randTreeHeight - 1, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight - 1, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, randTreeHeight, -5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight, -5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-4, randTreeHeight, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-3, randTreeHeight, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, randTreeHeight, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, randTreeHeight, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(4, randTreeHeight, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-3, randTreeHeight, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(4, randTreeHeight, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(5, randTreeHeight, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-4, randTreeHeight, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-3, randTreeHeight, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, randTreeHeight, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(4, randTreeHeight, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-4, randTreeHeight, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-3, randTreeHeight, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(4, randTreeHeight, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-5, randTreeHeight, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-4, randTreeHeight, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-3, randTreeHeight, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, randTreeHeight, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(4, randTreeHeight, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(5, randTreeHeight, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, randTreeHeight, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(4, randTreeHeight, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(5, randTreeHeight, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(4, randTreeHeight, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-3, randTreeHeight + 1, -5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, randTreeHeight + 1, -5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight + 1, -5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight + 1, -5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-3, randTreeHeight + 1, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight + 1, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight + 1, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight + 1, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight + 1, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight + 1, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-3, randTreeHeight + 1, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, randTreeHeight + 1, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight + 1, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight + 1, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight + 1, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-3, randTreeHeight + 1, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, randTreeHeight + 1, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight + 1, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight + 1, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight + 1, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight + 1, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight + 1, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(4, randTreeHeight + 1, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-4, randTreeHeight + 1, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-3, randTreeHeight + 1, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, randTreeHeight + 1, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight + 1, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight + 1, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight + 1, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight + 1, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight + 1, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(4, randTreeHeight + 1, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-5, randTreeHeight + 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-4, randTreeHeight + 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, randTreeHeight + 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight + 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight + 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight + 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight + 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight + 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-5, randTreeHeight + 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-3, randTreeHeight + 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, randTreeHeight + 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight + 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight + 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight + 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight + 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(4, randTreeHeight + 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(5, randTreeHeight + 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-5, randTreeHeight + 1, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-4, randTreeHeight + 1, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-3, randTreeHeight + 1, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, randTreeHeight + 1, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight + 1, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight + 1, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight + 1, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight + 1, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(5, randTreeHeight + 1, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, randTreeHeight + 1, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight + 1, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight + 1, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight + 1, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight + 1, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(4, randTreeHeight + 1, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(5, randTreeHeight + 1, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight + 1, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight + 1, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight + 1, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight + 1, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(4, randTreeHeight + 1, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight + 1, 5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight + 1, 5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, randTreeHeight + 2, -5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-3, randTreeHeight + 2, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, randTreeHeight + 2, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight + 2, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight + 2, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight + 2, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight + 2, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, randTreeHeight + 2, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight + 2, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight + 2, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight + 2, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight + 2, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight + 2, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-3, randTreeHeight + 2, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight + 2, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight + 2, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight + 2, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight + 2, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight + 2, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-4, randTreeHeight + 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-3, randTreeHeight + 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, randTreeHeight + 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight + 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight + 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight + 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight + 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight + 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(4, randTreeHeight + 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-5, randTreeHeight + 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-4, randTreeHeight + 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-3, randTreeHeight + 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, randTreeHeight + 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight + 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight + 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight + 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight + 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(4, randTreeHeight + 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-5, randTreeHeight + 2, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-4, randTreeHeight + 2, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-2, randTreeHeight + 2, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight + 2, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight + 2, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight + 2, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight + 2, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight + 2, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(4, randTreeHeight + 2, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(5, randTreeHeight + 2, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight + 2, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight + 2, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight + 2, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight + 2, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight + 2, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight + 2, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight + 2, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight + 2, 5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight + 2, 5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight + 2, 6), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight + 3, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight + 3, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight + 3, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-1, randTreeHeight + 3, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight + 3, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight + 3, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight + 3, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(-4, randTreeHeight + 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight + 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight + 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight + 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight + 3, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight + 3, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight + 3, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(0, randTreeHeight + 3, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight + 3, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight + 3, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(3, randTreeHeight + 3, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight + 3, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight + 3, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(1, randTreeHeight + 3, 5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight + 4, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.add(2, randTreeHeight + 4, 3), boundsIn);
            }
        }
        return true;
    }

    private void treeBranch(Set<BlockPos> setlogblock, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.WITCH_HAZEL_LOG.getDefaultState(), boundingBox);
        }
    }

    public BlockState randomLeaves() {
        Random random = new Random();
        int randomizer = random.nextInt(25);
        if (randomizer == 1)
            return BYGBlockList.BLOOMING_WITCH_HAZEL_LEAVES.getDefaultState();
        else if (randomizer == 0)
            return BYGBlockList.BLOOMING_WITCH_HAZEL_LEAVES.getDefaultState();
        else
            return BYGBlockList.WITCH_HAZEL_LEAVES.getDefaultState();
    }
}