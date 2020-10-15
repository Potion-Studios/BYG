package corgiaoc.byg.common.world.feature.nether.trees.withering;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGTreeConfig;
import corgiaoc.byg.common.world.feature.overworld.trees.util.BYGAbstractTreeFeature;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;

import java.util.Random;
import java.util.Set;

public class WitheringOakTree1 extends BYGAbstractTreeFeature<BYGTreeConfig> {

    public WitheringOakTree1(Codec<BYGTreeConfig> configIn) {
        super(configIn);
    }

    protected boolean generate(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeConfig config) {

        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            if (!isDesiredGroundwNetherTags(worldIn, pos.down(), config)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 7, 5, 5, isSapling)) {
                return false;
            } else {
                placeNetherTrunk(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 0, 0), boundsIn);
                placeNetherTrunk(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 1, 0), boundsIn);
                placeNetherTrunk(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 2, 0), boundsIn);
                placeNetherTrunk(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 3, 0), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 3, 0), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 3, -1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 4, 0), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 4, -1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 5, 0), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 5, -2), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 5, -1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, 5, -1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 6, -1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 6, 0), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 6, 1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 6, -3), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, 6, -1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 7, -1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 7, 1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 7, -3), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 8, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, 5, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 6, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 6, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, 6, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, 6, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, 6, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, 7, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 7, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 7, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 7, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 7, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 7, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, 7, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 8, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 8, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 8, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 8, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 9, 1), boundsIn);
            }
        }
        return true;
    }
}