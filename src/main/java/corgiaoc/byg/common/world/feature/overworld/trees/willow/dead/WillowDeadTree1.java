package corgiaoc.byg.common.world.feature.overworld.trees.willow.dead;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGTreeConfig;
import corgiaoc.byg.common.world.feature.overworld.trees.util.BYGAbstractTreeFeature;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;

import java.util.Random;
import java.util.Set;

public class WillowDeadTree1 extends BYGAbstractTreeFeature<BYGTreeConfig> {

    public WillowDeadTree1(Codec<BYGTreeConfig> configIn) {
        super(configIn);
    }

    protected boolean generate(Set<BlockPos> changedBlocks, StructureWorldAccess worldIn, Random rand, BlockPos pos, BlockBox boundsIn, boolean isSapling, BYGTreeConfig config) {

        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {

            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), config)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isSapling)) {
                return false;
            } else {
                buildTrunkBase(pos, changedBlocks, worldIn, config, rand, boundsIn, pos, mainmutable.set(pos).move(-1, 0, -2).toImmutable(), mainmutable.set(pos).move(0, 0, -2).toImmutable(), mainmutable.set(pos).move(1, 0, -2).toImmutable(), mainmutable.set(pos).move(-1, 0, -1).toImmutable(), mainmutable.set(pos).move(0, 0, -1).toImmutable(), mainmutable.set(pos).move(3, 0, -1).toImmutable(), mainmutable.set(pos).move(-2, 0, 0).toImmutable(), mainmutable.set(pos).move(-1, 0, 0).toImmutable(), mainmutable.set(pos).move(1, 0, 0).toImmutable(), mainmutable.set(pos).move(-1, 0, 1).toImmutable(), mainmutable.set(pos).move(0, 0, 1).toImmutable(), mainmutable.set(pos).move(1, 0, 1).toImmutable());


                for (int buildTrunk = 0; buildTrunk <= randTreeHeight; buildTrunk++) {
                    placeTrunk(config, rand, changedBlocks, worldIn, mainmutable, boundsIn);

                    mainmutable.move(Direction.UP);
                }
                mainmutable.set(pos);

                //Stump
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 0, -2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 0, -2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 0, -2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 0, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 0, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 0, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 0, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 0, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 0, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 0, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 0, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 0, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 1, -2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 1, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 1, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 1, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 1, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 1, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 1, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 1, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 2, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 2, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 3, -1), boundsIn);


                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, randTreeHeight, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight + 1, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight + 1, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight + 1, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, randTreeHeight + 1, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, randTreeHeight + 1, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, randTreeHeight + 1, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight + 1, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight + 1, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight + 1, 2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight + 2, -4), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight + 2, -3), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight + 2, -2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight + 2, -2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, randTreeHeight + 2, -2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, randTreeHeight + 2, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight + 2, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, randTreeHeight + 2, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(5, randTreeHeight + 2, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight + 2, 3), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight + 2, 4), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, randTreeHeight + 3, -3), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight + 3, -2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight + 3, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, randTreeHeight + 3, 2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, randTreeHeight + 3, 3), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight + 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight - 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight - 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight - 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, randTreeHeight, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight + 1, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, randTreeHeight + 1, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight + 1, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, randTreeHeight + 1, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight + 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight + 1, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, randTreeHeight + 1, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight + 2, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight + 2, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, randTreeHeight + 2, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, randTreeHeight + 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight + 2, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, randTreeHeight + 2, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight + 3, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, randTreeHeight + 3, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight + 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, randTreeHeight + 3, 2), boundsIn);
            }
        }
        return true;
    }
}