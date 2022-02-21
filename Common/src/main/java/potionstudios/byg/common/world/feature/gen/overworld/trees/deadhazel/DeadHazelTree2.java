package potionstudios.byg.common.world.feature.gen.overworld.trees.deadhazel;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import potionstudios.byg.common.world.feature.config.BYGTreeConfig;
import potionstudios.byg.common.world.feature.gen.overworld.trees.util.BYGAbstractTreeFeature;

import java.util.Random;
import java.util.Set;

public class DeadHazelTree2 extends BYGAbstractTreeFeature<BYGTreeConfig> {

    public DeadHazelTree2(Codec<BYGTreeConfig> configIn) {
        super(configIn);
    }

    protected boolean generate(Set<BlockPos> changedBlocks, WorldGenLevel worldIn, Random rand, BlockPos pos, BoundingBox boundsIn, boolean isSapling, BYGTreeConfig config) {

        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {

            if (!isDesiredGroundwDirtTag(worldIn, pos.below(), config)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isSapling)) {
                return false;
            } else {
                mutable.set(pos).immutable();
                mutable.set(pos).move(-1, 0, -2).immutable();
                mutable.set(pos).move(0, 0, -2).immutable();
                mutable.set(pos).move(1, 0, -2).immutable();
                mutable.set(pos).move(-1, 0, -1).immutable();
                mutable.set(pos).move(0, 0, -1).immutable();
                mutable.set(pos).move(3, 0, -1).immutable();
                mutable.set(pos).move(-2, 0, 0).immutable();
                mutable.set(pos).move(-1, 0, 0).immutable();
                mutable.set(pos).move(1, 0, 0).immutable();
                mutable.set(pos).move(-1, 0, 1).immutable();
                mutable.set(pos).move(0, 0, 1).immutable();
                mutable.set(pos).move(1, 0, 1).immutable();
                mutable.set(pos);

                for (int buildTrunk = 0; buildTrunk <= randTreeHeight; buildTrunk++) {
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, mutable, boundsIn);

                    mutable.move(Direction.UP);
                }
                mutable.set(pos);

                //Stump
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, 0, -2), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 0, -2), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 0, -2), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, 0, -1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 0, -1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(3, 0, -1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(-2, 0, 0), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, 0, 0), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 0, 0), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, 0, 1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 0, 1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 0, 1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 1, -2), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, 1, -1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 1, -1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 1, -1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(2, 1, -1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, 1, 0), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 1, 0), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 1, 1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, 2, -1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 2, -1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 3, -1), boundsIn);


                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, randTreeHeight, -1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(-2, randTreeHeight, 0), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, randTreeHeight, 0), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, randTreeHeight, 0), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(2, randTreeHeight, 0), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, randTreeHeight, 1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(-4, randTreeHeight + 1, -1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(-3, randTreeHeight + 1, -1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, randTreeHeight + 1, -1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(2, randTreeHeight + 1, 0), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(3, randTreeHeight + 1, 0), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(4, randTreeHeight + 1, 0), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, randTreeHeight + 1, 1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, randTreeHeight + 1, 1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, randTreeHeight + 1, 2), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(-2, randTreeHeight + 2, -4), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(-3, randTreeHeight + 2, -3), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(-3, randTreeHeight + 2, -2), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, randTreeHeight + 2, -2), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(3, randTreeHeight + 2, -2), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(3, randTreeHeight + 2, -1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, randTreeHeight + 2, 1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(2, randTreeHeight + 2, 1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(5, randTreeHeight + 2, 1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, randTreeHeight + 2, 3), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, randTreeHeight + 2, 4), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(4, randTreeHeight + 3, -3), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, randTreeHeight + 3, -2), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(-2, randTreeHeight + 3, 1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(3, randTreeHeight + 3, 2), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(3, randTreeHeight + 3, 3), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(-2, randTreeHeight + 1, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, randTreeHeight - 2, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, randTreeHeight - 1, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(-2, randTreeHeight - 1, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(-3, randTreeHeight, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(4, randTreeHeight, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(-2, randTreeHeight, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, randTreeHeight, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(-3, randTreeHeight + 1, -3), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(2, randTreeHeight + 1, -2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, randTreeHeight + 1, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(4, randTreeHeight + 1, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, randTreeHeight + 1, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, randTreeHeight + 1, 3), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(3, randTreeHeight + 1, 3), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(-3, randTreeHeight + 2, -4), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(-2, randTreeHeight + 2, -3), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(2, randTreeHeight + 2, -2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(3, randTreeHeight + 2, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, randTreeHeight + 2, 2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(3, randTreeHeight + 2, 3), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(-3, randTreeHeight + 3, -4), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(3, randTreeHeight + 3, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, randTreeHeight + 3, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mutable.set(pos).move(4, randTreeHeight + 3, 2), boundsIn);
            }
        }
        return true;
    }
}