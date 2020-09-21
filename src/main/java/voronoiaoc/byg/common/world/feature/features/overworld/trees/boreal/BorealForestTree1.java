package voronoiaoc.byg.common.world.feature.features.overworld.trees.boreal;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import voronoiaoc.byg.common.world.feature.featureconfig.BYGTreeFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;

public class BorealForestTree1 extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {

    public BorealForestTree1(Codec<BYGTreeFeatureConfig> configIn) {
        super(configIn);
    }

    public boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeFeatureConfig config) {

        int randTreeHeight = rand.nextInt(config.getMaxPossibleHeight()) + config.getMinHeight();
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < worldIn.getHeight()) {
            BlockPos blockpos = pos.down();
            if (!isDesiredGroundwDirtTag(worldIn, blockpos, Blocks.GRASS_BLOCK) || !isDesiredGroundwDirtTag(worldIn, blockpos, BYGBlockList.PEAT)) {
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
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos1, boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos1.up(1), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos1.up(2), boundsIn);

                }

                int leaveColor = rand.nextInt(2) + 1;
                int tHSub5 = 5;
                int tHSub4 = 4;
                int tHSub3 = 3;
                int tHSub2 = 2;
                int tHSub1 = 1;

                int leavessquarespos = 1;
                for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                    for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {
                        placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub5, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight - tHSub5, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 2, topTrunkHeight - tHSub5, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - tHSub5, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - tHSub5, posZ1 + 2, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight - tHSub4, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 2, topTrunkHeight - tHSub4, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - tHSub4, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - tHSub4, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight - tHSub4, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight - tHSub4, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight - tHSub4, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight - tHSub4, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight - tHSub4, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight - tHSub4, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 2, topTrunkHeight - tHSub4, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 2, topTrunkHeight - tHSub4, posZ1 + 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub3, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight - tHSub3, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 2, topTrunkHeight - tHSub3, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - tHSub3, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - tHSub3, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight - tHSub3, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight - tHSub3, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight - tHSub3, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight - tHSub3, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight - tHSub3, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight - tHSub3, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 2, topTrunkHeight - tHSub3, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 2, topTrunkHeight - tHSub3, posZ1 + 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub2, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight - tHSub2, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 2, topTrunkHeight - tHSub2, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - tHSub2, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - tHSub2, posZ1 + 2, boundsIn, changedBlocks);


                        placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight + tHSub1, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight + tHSub1, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + tHSub1, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + tHSub1, posZ1 + 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight + tHSub2, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight + tHSub2, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + tHSub2, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + tHSub2, posZ1 + 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + tHSub3, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + tHSub4, posZ1, boundsIn, changedBlocks);

                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}