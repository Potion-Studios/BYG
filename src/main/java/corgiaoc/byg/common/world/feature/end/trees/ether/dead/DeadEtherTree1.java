package corgiaoc.byg.common.world.feature.end.trees.ether.dead;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGTreeConfig;
import corgiaoc.byg.common.world.feature.overworld.trees.util.BYGAbstractTreeFeature;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;

import java.util.Random;
import java.util.Set;

public class DeadEtherTree1 extends BYGAbstractTreeFeature<BYGTreeConfig> {

    public DeadEtherTree1(Codec<BYGTreeConfig> configIn) {
        super(configIn);
    }

    protected boolean generate(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeConfig config) {

        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {
            if (!isDesiredGroundwEndTags(worldIn, pos.below(), config)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 7, 5, 5, isSapling)) {
                return false;
            } else {
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 0, 0), boundsIn);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 1, 0), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 1, 1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 2, 1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 3, 1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 3, 2), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 4, 2), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 5, 2), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 6, 1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 6, 2), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 6, 2), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 7, 1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 7, 3), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 7, 0), boundsIn);
            }
        }
        return true;
    }
}