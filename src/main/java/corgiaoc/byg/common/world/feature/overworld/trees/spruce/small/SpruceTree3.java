package corgiaoc.byg.common.world.feature.overworld.trees.spruce.small;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGTreeConfig;
import corgiaoc.byg.common.world.feature.overworld.trees.util.BYGAbstractTreeFeature;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;

import java.util.Random;
import java.util.Set;

public class SpruceTree3 extends BYGAbstractTreeFeature<BYGTreeConfig> {

    public SpruceTree3(Codec<BYGTreeConfig> configIn) {
        super(configIn);
    }

    protected boolean generate(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeConfig config) {

        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), config)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 7, 5, 5, isSapling)) {
                return false;
            } else {
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 0, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 1, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 2, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 3, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 4, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 5, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 6, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 7, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 8, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 9, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 10, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 11, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 12, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, 3, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, 3, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 3, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 3, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 3, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 3, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 3, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 3, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 3, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 3, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 3, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 3, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 3, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 3, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 3, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 3, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, 3, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, 3, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, 3, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, 3, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, 4, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 4, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 4, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 4, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 4, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 4, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 4, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 4, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 4, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 4, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 4, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 4, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 4, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 4, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 4, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 4, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 4, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 4, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, 4, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, 4, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, 4, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, 4, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, 5, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, 5, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 5, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 5, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 5, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 5, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 5, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 5, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 5, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 5, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 5, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 5, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 5, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 5, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 5, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 5, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 5, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 5, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 5, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 5, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 5, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, 5, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, 5, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, 5, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, 5, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, 5, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, 5, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 6, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 6, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 6, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 6, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 6, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 6, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 6, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 6, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 6, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 6, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 6, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 6, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 6, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 6, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 6, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, 6, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, 6, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, 6, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, 6, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, 6, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, 6, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, 6, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 7, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 7, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 7, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 7, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 7, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 7, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 7, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 7, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 7, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 7, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 7, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 7, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 7, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, 7, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, 7, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 8, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, 8, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 8, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 8, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 8, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 8, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 8, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 8, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 8, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 8, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 8, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 8, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 8, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, 8, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 9, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 9, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 9, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 9, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 9, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 9, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 9, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 9, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 10, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 10, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 10, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 10, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 10, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 10, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 11, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 11, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 11, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 11, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 11, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, 12, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 12, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, 12, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 13, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, 14, 0), boundsIn);
            }
        }
        return true;
    }
}