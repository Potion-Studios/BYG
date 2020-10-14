package corgiaoc.byg.common.world.feature.nether.trees.withering;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGTreeFeatureConfig;
import corgiaoc.byg.common.world.feature.overworld.trees.util.BYGAbstractTreeFeature;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;

import java.util.Random;
import java.util.Set;

public class WitheringOakTree3 extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {

    public WitheringOakTree3(Codec<BYGTreeFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean generate(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeFeatureConfig config) {

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
                placeNetherTrunk(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 4, 0), boundsIn);
                placeNetherTrunk(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 5, 0), boundsIn);
                placeNetherTrunk(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 6, 0), boundsIn);
                placeNetherTrunk(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 7, 0), boundsIn);
                placeNetherTrunk(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 12, 0), boundsIn);
                placeNetherTrunk(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 13, 0), boundsIn);
                placeNetherTrunk(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 14, 0), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 6, 0), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 6, 1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 7, 0), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 7, -1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 7, 2), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 8, 0), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 8, -1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 8, 2), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 9, 0), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 9, -1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 9, 2), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 10, -1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 10, 0), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 10, 2), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 10, -1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 10, 3), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 11, -1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 11, -1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 11, 3), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 11, 4), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, 12, 0), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 12, -2), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 12, -1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 12, -1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 12, 3), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 12, 5), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, 12, -2), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, 13, 0), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 13, -2), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 13, 5), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, 13, -2), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, 14, 0), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, 15, 0), boundsIn);
            }
        }
        return true;
    }
}