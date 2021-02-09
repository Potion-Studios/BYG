package corgiaoc.byg.common.world.feature.overworld.trees.cherry;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGTreeConfig;
import corgiaoc.byg.common.world.feature.overworld.trees.util.BYGAbstractTreeFeature;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;

import java.util.Random;
import java.util.Set;

public class CherryTree2 extends BYGAbstractTreeFeature<BYGTreeConfig> {

    public CherryTree2(Codec<BYGTreeConfig> configIn) {
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
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 8, 5, 5, isSapling)) {
                return false;
            } else {
                buildTrunkBase(pos, changedBlocks, worldIn, config, rand, boundsIn, mainmutable);

                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable, boundsIn);
                for (int buildTrunk = 0; buildTrunk <= randTreeHeight; buildTrunk++) {
                    placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.move(Direction.UP), boundsIn);
                }
                mainmutable.set(pos);

                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight - 4, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight - 4, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight - 4, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, randTreeHeight - 4, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight - 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight - 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight - 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, randTreeHeight - 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight - 4, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight - 4, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight - 4, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, randTreeHeight - 4, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight - 4, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight - 4, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight - 4, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight - 4, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, randTreeHeight - 4, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight - 4, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight - 4, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight - 3, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight - 3, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight - 3, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, randTreeHeight - 3, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight - 3, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight - 3, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight - 3, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight - 3, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, randTreeHeight - 3, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight - 3, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight - 3, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight - 3, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight - 3, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, randTreeHeight - 3, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, randTreeHeight - 3, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight - 3, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight - 3, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight - 3, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight - 3, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, randTreeHeight - 3, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, randTreeHeight - 3, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight - 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight - 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight - 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight - 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight - 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, randTreeHeight - 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight - 3, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight - 3, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight - 3, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight - 3, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, randTreeHeight - 3, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight - 3, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight - 3, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight - 2, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight - 2, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight - 2, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight - 2, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight - 2, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight - 2, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight - 2, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, randTreeHeight - 2, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, randTreeHeight - 2, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight - 2, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight - 2, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight - 2, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight - 2, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight - 2, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, randTreeHeight - 2, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, randTreeHeight - 2, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight - 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight - 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight - 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight - 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, randTreeHeight - 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, randTreeHeight - 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight - 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight - 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight - 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight - 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight - 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, randTreeHeight - 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight - 2, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight - 2, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight - 2, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight - 2, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight - 2, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, randTreeHeight - 2, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, randTreeHeight - 2, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight - 2, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight - 2, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight - 2, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, randTreeHeight - 2, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight - 1, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight - 1, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight - 1, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, randTreeHeight - 1, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight - 1, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight - 1, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight - 1, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight - 1, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, randTreeHeight - 1, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, randTreeHeight - 1, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight - 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight - 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight - 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, randTreeHeight - 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, randTreeHeight - 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight - 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight - 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight - 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight - 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, randTreeHeight - 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, randTreeHeight - 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight - 1, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight - 1, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight - 1, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, randTreeHeight - 1, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, randTreeHeight, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, randTreeHeight, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, randTreeHeight, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight + 1, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight + 1, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight + 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight + 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight + 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, randTreeHeight + 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight + 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight + 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight + 2, 0), boundsIn);
            }
        }
        return true;
    }


    private void treeLog(Set<BlockPos> setlogblock, StructureWorldAccess reader, BlockPos pos, BlockBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlocks.CHERRY_LOG.getDefaultState(), boundingBox);
        }
    }


    private void treeBranch(Set<BlockPos> setlogblock, StructureWorldAccess reader, BlockPos pos, BlockBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlocks.CHERRY_LOG.getDefaultState(), boundingBox);
        }
    }


    private void leafs(Set<BlockPos> blockPos, StructureWorldAccess reader, BlockPos pos, BlockBox boundingBox) {
        BlockPos.Mutable blockpos = new BlockPos.Mutable().set(pos);
        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos, BYGBlocks.PINK_CHERRY_LEAVES.getDefaultState(), boundingBox);
        }
    }


}