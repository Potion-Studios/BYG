package corgiaoc.byg.common.world.feature.overworld.trees.deadhazel;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGTreeConfig;
import corgiaoc.byg.common.world.feature.overworld.trees.util.BYGAbstractTreeFeature;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;

import java.util.Random;
import java.util.Set;

public class DeadHazel4 extends BYGAbstractTreeFeature<BYGTreeConfig> {

    public DeadHazel4(Codec<BYGTreeConfig> configIn) {
        super(configIn);
    }

    protected boolean generate(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeConfig config) {

        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        BlockPos.Mutable mutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {

            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), config)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isSapling)) {
                return false;
            } else {
                buildTrunkBase(changedBlocks, worldIn, config, rand, boundsIn, mutable.setPos(pos).toImmutable(), mutable.setPos(pos).move(-1, 0, -2).toImmutable(), mutable.setPos(pos).move(0, 0, -2).toImmutable(), mutable.setPos(pos).move(1, 0, -2).toImmutable(), mutable.setPos(pos).move(-1, 0, -1).toImmutable(), mutable.setPos(pos).move(0, 0, -1).toImmutable(), mutable.setPos(pos).move(3, 0, -1).toImmutable(), mutable.setPos(pos).move(-2, 0, 0).toImmutable(), mutable.setPos(pos).move(-1, 0, 0).toImmutable(), mutable.setPos(pos).move(1, 0, 0).toImmutable(), mutable.setPos(pos).move(-1, 0, 1).toImmutable(), mutable.setPos(pos).move(0, 0, 1).toImmutable(), mutable.setPos(pos).move(1, 0, 1).toImmutable());
                mutable.setPos(pos);

                for (int buildTrunk = 0; buildTrunk <= randTreeHeight; buildTrunk++) {
                    placeTrunk(config, rand, changedBlocks, worldIn, mutable, boundsIn);

                    mutable.move(Direction.UP);
                }
                mutable.setPos(pos);

                //Stump
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(-1, 0, -2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(0, 0, -2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(1, 0, -2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(-1, 0, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(0, 0, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(3, 0, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(-2, 0, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(-1, 0, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(1, 0, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(-1, 0, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(0, 0, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(1, 0, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(0, 1, -2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(-1, 1, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(0, 1, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(1, 1, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(2, 1, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(-1, 1, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(1, 1, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(0, 1, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(-1, 2, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(0, 2, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(0, 3, -1), boundsIn);


                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(0, randTreeHeight, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(-2, randTreeHeight, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(-1, randTreeHeight, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(1, randTreeHeight, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(2, randTreeHeight, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(-1, randTreeHeight, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(-4, randTreeHeight + 1, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(-3, randTreeHeight + 1, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(0, randTreeHeight + 1, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(2, randTreeHeight + 1, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(3, randTreeHeight + 1, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(4, randTreeHeight + 1, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(-1, randTreeHeight + 1, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(0, randTreeHeight + 1, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(0, randTreeHeight + 1, 2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(-2, randTreeHeight + 2, -4), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(-3, randTreeHeight + 2, -3), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(-3, randTreeHeight + 2, -2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(0, randTreeHeight + 2, -2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(3, randTreeHeight + 2, -2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(3, randTreeHeight + 2, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(-1, randTreeHeight + 2, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(2, randTreeHeight + 2, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(5, randTreeHeight + 2, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(1, randTreeHeight + 2, 3), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(1, randTreeHeight + 2, 4), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(4, randTreeHeight + 3, -3), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(0, randTreeHeight + 3, -2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(-2, randTreeHeight + 3, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(3, randTreeHeight + 3, 2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(3, randTreeHeight + 3, 3), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(-2, randTreeHeight + 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(1, randTreeHeight - 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(1, randTreeHeight - 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(-2, randTreeHeight - 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(-3, randTreeHeight, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(4, randTreeHeight, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(-2, randTreeHeight, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(0, randTreeHeight, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(-3, randTreeHeight + 1, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(2, randTreeHeight + 1, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(-1, randTreeHeight + 1, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(4, randTreeHeight + 1, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(0, randTreeHeight + 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(1, randTreeHeight + 1, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(3, randTreeHeight + 1, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(-3, randTreeHeight + 2, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(-2, randTreeHeight + 2, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(2, randTreeHeight + 2, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(3, randTreeHeight + 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(-1, randTreeHeight + 2, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(3, randTreeHeight + 2, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(-3, randTreeHeight + 3, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(3, randTreeHeight + 3, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(-1, randTreeHeight + 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.setPos(pos).move(4, randTreeHeight + 3, 2), boundsIn);
            }
        }
        return true;
    }

    private void treeBranch(Set<BlockPos> setlogblock, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlocks.WITCH_HAZEL_LOG.getDefaultState(), boundingBox);
        }
    }

    public BlockState randomLeaves() {
        Random random = new Random();
        int randomizer = random.nextInt(25);
        if (randomizer == 1)
            return BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES.getDefaultState();
        else if (randomizer == 0)
            return BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES.getDefaultState();
        else
            return BYGBlocks.WITCH_HAZEL_LEAVES.getDefaultState();
    }



}