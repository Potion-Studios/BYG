package voronoiaoc.byg.common.world.feature.features.overworld.trees.aspen;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import voronoiaoc.byg.common.world.feature.config.BYGTreeFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;

public class AspenShrub2 extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {

    public AspenShrub2(Codec<BYGTreeFeatureConfig> configIn) {
        super(configIn);
    }

    public boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeFeatureConfig config) {
        BlockState LOG = config.getTrunkProvider().getBlockState(rand, pos);
        BlockState LEAVES = config.getLeavesProvider().getBlockState(rand, pos);
        int randTreeHeight = rand.nextInt(1) + 1;
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < worldIn.getHeight()) {

            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), Blocks.GRASS_BLOCK)) {
                return false;
            } else {
                Direction direction = Direction.Plane.HORIZONTAL.random(rand);
                int randTreeHeight2 = randTreeHeight - rand.nextInt(1);
                int posY1 = 2 - rand.nextInt(1);
                int posX1 = posX;
                int posZ1 = posZ;
                int topTrunkHeight = posY + randTreeHeight - 1;

                for (int buildTrunk = 0; buildTrunk < randTreeHeight; ++buildTrunk) {
                    if (buildTrunk >= randTreeHeight2 && posY1 < 0) {
                        posX1 += direction.getXOffset();
                        posZ1 += direction.getZOffset();
                        ++posY1;
                    }

                    int logplacer = posY + buildTrunk;
                    BlockPos blockpos1 = new BlockPos(posX1, logplacer, posZ1);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos1, boundsIn);
                }

                int squareSize = 2;

                for (int posXLeafWidth = -squareSize; posXLeafWidth <= squareSize; ++posXLeafWidth) {//has to do with leaves
                    for (int posZLeafWidthL0 = -squareSize; posZLeafWidthL0 <= squareSize; ++posZLeafWidthL0) {
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }

    private void treelog(Set<BlockPos> setlogblock, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.ASPEN_LOG.getDefaultState(), boundingBox);
        }

    }

    private void leafs(ISeedReader reader, int x, int y, int z, MutableBoundingBox boundingBox, Set<BlockPos> blockPos) {
        BlockPos blockpos = new BlockPos(x, y, z);
        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos, BYGBlockList.ASPEN_LEAVES.getDefaultState(), boundingBox);
        }
    }
}
