package corgiaoc.byg.common.world.feature.overworld.trees.deciduous;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGTreeConfig;
import corgiaoc.byg.common.world.feature.overworld.trees.util.BYGAbstractTreeFeature;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;

import java.util.Random;
import java.util.Set;

public class DeciduousTree4 extends BYGAbstractTreeFeature<BYGTreeConfig> {

    public DeciduousTree4(Codec<BYGTreeConfig> configIn) {
        super(configIn);
    }

    protected boolean generate(Set<BlockPos> changedBlocks, StructureWorldAccess worldIn, Random rand, BlockPos pos, BlockBox boundsIn, boolean isSapling, BYGTreeConfig config) {

        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        BlockPos.Mutable mutable = new BlockPos.Mutable().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), config)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 7, 5, 5, isSapling)) {
                return false;
            } else {
                buildTrunkBase(pos, changedBlocks, worldIn, config, rand, boundsIn, mutable.set(pos).toImmutable());
                mutable.set(pos);


                placeTrunk(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 0, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 1, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 2, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 3, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 4, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 5, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 6, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 7, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 8, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 9, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 10, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 11, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 12, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 13, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 14, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 15, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 16, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, 7, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, 7, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 7, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 7, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 7, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 7, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 7, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(2, 7, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-2, 8, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-2, 8, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, 8, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 8, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 8, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 8, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 8, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 8, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 8, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(2, 8, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-2, 9, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-2, 9, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, 9, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, 9, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, 9, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, 9, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 9, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 9, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 9, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 9, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 9, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 9, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 9, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 9, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(2, 9, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(2, 9, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(2, 9, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-2, 10, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-2, 10, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-2, 10, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, 10, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, 10, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, 10, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, 10, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 10, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 10, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 10, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 10, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 10, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 10, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 10, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-2, 11, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-2, 11, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, 11, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, 11, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, 11, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, 11, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 11, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 11, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 11, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 11, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 11, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 11, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 11, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 11, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 11, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(2, 11, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(2, 11, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(2, 11, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(2, 11, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(3, 11, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-2, 12, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, 12, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, 12, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 12, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 12, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 12, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 12, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 12, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 12, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(2, 12, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(2, 12, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, 13, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, 13, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, 13, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 13, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 13, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 13, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 13, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(2, 13, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(2, 13, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(3, 13, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-2, 14, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, 14, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 14, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 14, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 14, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 14, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 14, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(2, 14, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-2, 15, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, 15, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, 15, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 15, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 15, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 15, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 15, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 15, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(-1, 16, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 16, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 16, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 16, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 17, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 17, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 17, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 18, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(1, 18, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mutable.set(pos).move(0, 19, 0), boundsIn);
            }
        }
        return true;
    }
}