package corgiaoc.byg.common.world.feature.end.trees.nightshade;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGTreeConfig;
import corgiaoc.byg.common.world.feature.overworld.trees.util.BYGAbstractTreeFeature;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;

import java.util.Random;
import java.util.Set;

public class NightshadeTree1 extends BYGAbstractTreeFeature<BYGTreeConfig> {

    public NightshadeTree1(Codec<BYGTreeConfig> configIn) {
        super(configIn);
    }

    protected boolean generate(Set<BlockPos> changedBlocks, StructureWorldAccess worldIn, Random rand, BlockPos pos, BlockBox boundsIn, boolean isSapling, BYGTreeConfig config) {

        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            if (!isDesiredGroundwEndTags(worldIn, pos.down(), config)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 7, 5, 5, isSapling)) {
                return false;
            } else {
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 0, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 1, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 2, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 3, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 3, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 4, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 5, 2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 5, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 6, 2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 7, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 0, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 0, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 0, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 0, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 0, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 0, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 1, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 4, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 5, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 6, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 7, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 7, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 7, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 7, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 7, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 7, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 7, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 7, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 7, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 7, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 7, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 7, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 7, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 7, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 7, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 7, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 7, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 7, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 7, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 7, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 8, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 8, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 8, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 8, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 8, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 8, 2), boundsIn);
            }
        }
        return true;
    }
}