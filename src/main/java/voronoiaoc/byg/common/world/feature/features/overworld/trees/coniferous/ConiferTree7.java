package voronoiaoc.byg.common.world.feature.features.overworld.trees.coniferous;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import voronoiaoc.byg.common.world.feature.config.BYGTreeFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;

import java.util.Random;
import java.util.Set;

public class ConiferTree7 extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {

    public ConiferTree7(Codec<BYGTreeFeatureConfig> configIn) {
        super(configIn);
    }

    public boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeFeatureConfig config) {
        BlockState LOG = config.getTrunkProvider().getBlockState(rand, pos);
        BlockState LEAVES = config.getLeavesProvider().getBlockState(rand, pos);
        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        //Positions
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < worldIn.getHeight()) {
            BlockPos checkGround = pos.down();
            if (!isDesiredGroundwDirtTag(worldIn, checkGround, Blocks.GRASS_BLOCK)) {
                return false;
            } else {

                Direction direction = Direction.Plane.HORIZONTAL.random(rand);
                int randTreeHeight2 = randTreeHeight - rand.nextInt(1);
                int posY2 = 2 - rand.nextInt(1);
                int posX2 = posX;
                int posZ2 = posZ;
                int topTrunkHeight = posY + randTreeHeight - 1;

                for (int trunkBottom = 0; trunkBottom < randTreeHeight; ++trunkBottom) {
                    if (trunkBottom >= randTreeHeight2 && posY2 < 0) {
                        posX2 += direction.getXOffset();
                        posZ2 += direction.getZOffset();
                        ++posY2;
                    }
                    int logplacer = posY + trunkBottom;


                    BlockPos trunkPos1 = new BlockPos(posX2, logplacer, posZ2);
                    placeTrunk(LOG, changedBlocks, worldIn, trunkPos1, boundsIn);

                }
                for (int posXLeafSize = -1; posXLeafSize <= 1; ++posXLeafSize) {
                    for (int posZLeafSize = -1; posZLeafSize <= 1; ++posZLeafSize) {
                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight + 2, posZ2, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight + 1, posZ2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + 1, topTrunkHeight + 1, posZ2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 - 1, topTrunkHeight + 1, posZ2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight + 1, posZ2 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight + 1, posZ2 + 1, boundsIn, changedBlocks);


                        placeLeaves(LEAVES, worldIn, posX2 + posXLeafSize, topTrunkHeight - 1, posZ2 + posZLeafSize + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + posXLeafSize, topTrunkHeight - 1, posZ2 + posZLeafSize - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + posXLeafSize - 1, topTrunkHeight - 1, posZ2 + posZLeafSize, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + posXLeafSize + 1, topTrunkHeight - 1, posZ2 + posZLeafSize, boundsIn, changedBlocks);


                        placeLeaves(LEAVES, worldIn, posX2 + 1, topTrunkHeight - 2, posZ2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 - 1, topTrunkHeight - 2, posZ2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight - 2, posZ2 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight - 2, posZ2 + 1, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX2 + posXLeafSize, topTrunkHeight - 3, posZ2 + posZLeafSize + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + posXLeafSize, topTrunkHeight - 3, posZ2 + posZLeafSize - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + posXLeafSize - 1, topTrunkHeight - 3, posZ2 + posZLeafSize, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + posXLeafSize + 1, topTrunkHeight - 3, posZ2 + posZLeafSize, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX2 + 1, topTrunkHeight - 4, posZ2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 - 1, topTrunkHeight - 4, posZ2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight - 4, posZ2 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight - 4, posZ2 + 1, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX2 + posXLeafSize + 1, topTrunkHeight - 5, posZ2 + posZLeafSize + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + posXLeafSize - 1, topTrunkHeight - 5, posZ2 + posZLeafSize - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + posXLeafSize + 1, topTrunkHeight - 5, posZ2 + posZLeafSize - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + posXLeafSize - 1, topTrunkHeight - 5, posZ2 + posZLeafSize + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + 3, topTrunkHeight - 5, posZ2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 - 3, topTrunkHeight - 5, posZ2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight - 5, posZ2 - 3, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight - 5, posZ2 + 3, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX2 + posXLeafSize, topTrunkHeight - 6, posZ2 + posZLeafSize, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + 2, topTrunkHeight - 6, posZ2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 - 2, topTrunkHeight - 6, posZ2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight - 6, posZ2 - 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight - 6, posZ2 + 2, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX2 + posXLeafSize, topTrunkHeight - 7, posZ2 + posZLeafSize + 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + posXLeafSize, topTrunkHeight - 7, posZ2 + posZLeafSize - 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + posXLeafSize - 2, topTrunkHeight - 7, posZ2 + posZLeafSize, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + posXLeafSize + 2, topTrunkHeight - 7, posZ2 + posZLeafSize, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + posXLeafSize + 1, topTrunkHeight - 7, posZ2 + posZLeafSize + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + posXLeafSize - 1, topTrunkHeight - 7, posZ2 + posZLeafSize - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + posXLeafSize + 1, topTrunkHeight - 7, posZ2 + posZLeafSize - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + posXLeafSize - 1, topTrunkHeight - 7, posZ2 + posZLeafSize + 1, boundsIn, changedBlocks);


                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}