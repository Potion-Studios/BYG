package corgiaoc.byg.common.world.feature.features.overworld.trees.baobab;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.byglists.BYGBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import corgiaoc.byg.common.world.feature.features.config.BYGTreeFeatureConfig;
import corgiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;

import java.util.Random;
import java.util.Set;

public class BaobabTree1 extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {


    public BaobabTree1(Codec<BYGTreeFeatureConfig> configIn) {
        super(configIn);
    }


    public boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeFeatureConfig config) {

        int randTreeHeight = rand.nextInt(config.getMaxPossibleHeight()) + config.getMinHeight();
        int randCorner1 = randTreeHeight - rand.nextInt(12) - 7;
        int randCorner2 = randTreeHeight - rand.nextInt(12) - 7;
        int randCorner3 = randTreeHeight - rand.nextInt(12) - 7;
        int randCorner4 = randTreeHeight - rand.nextInt(12) - 7;

        int randOuterEdge = rand.nextInt(6) + 2;
        int randOuterEdge2 = rand.nextInt(6) + 2;
        int randOuterEdge3 = rand.nextInt(6) + 2;
        int randOuterEdge4 = rand.nextInt(6) + 1;
        int randOuterEdge5 = rand.nextInt(6) + 2;
        int randOuterEdge6 = rand.nextInt(6) + 2;
        int randOuterEdge7 = rand.nextInt(6) + 1;
        int randOuterEdge8 = rand.nextInt(6) + 2;

        //Positions
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < 256) {
            BlockPos posDown = pos.down();
            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 30, 5, 5, isSapling)) {
                return false;
            } else {
                Direction direction = Direction.Plane.HORIZONTAL.random(rand);
                int randTreeHeight2 = randTreeHeight - rand.nextInt(1);
                int posY1 = 2 - rand.nextInt(1);
                int posX1 = posX;
                int posZ1 = posZ;
                int topTrunkHeight2 = posY + randTreeHeight + 2;
                int topTrunkHeight3 = posY + randTreeHeight + 5;
                int topTrunkHeight4 = posY + randTreeHeight + 4;
                int topTrunkHeight5 = posY + randTreeHeight + 4;
                int topTrunkHeight6 = posY + randTreeHeight + 5;
                int topTrunkHeight7 = posY + randTreeHeight + 2;
                int topTrunkHeight8 = posY + randTreeHeight + 2;
                int topTrunkHeight9 = posY + randTreeHeight + 4;
                int topTrunkHeight10 = posY + randTreeHeight + 2;

                for (int buildTrunk = 0; buildTrunk < randTreeHeight; ++buildTrunk) {
                    if (buildTrunk >= randTreeHeight2 && posY1 < 0) {
                        posX1 += direction.getXOffset();
                        posZ1 += direction.getZOffset();
                        ++posY1;
                    }

                    int logplacerY = posY + buildTrunk;
                    int topTreeHeight = posY + randTreeHeight - 1;

                    BlockPos blockpos1 = new BlockPos(posX1, logplacerY, posZ1);
                    BlockPos blockpos2 = new BlockPos(posX1, topTreeHeight, posZ1);

                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos1, boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos1.north(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos1.north().west(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos1.west(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos1.north(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos1.north(2).west(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos1.north().west(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos1.west(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos1.east(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos1.north().east(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos1.south().west(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos1.south(), boundsIn);

                    if (buildTrunk <= randCorner1)
                        placeTrunk(config, rand, changedBlocks, worldIn, blockpos1.south().east(), boundsIn);
                    if (buildTrunk <= randCorner2)
                        placeTrunk(config, rand, changedBlocks, worldIn, blockpos1.south().west(2), boundsIn);
                    if (buildTrunk <= randCorner3)
                        placeTrunk(config, rand, changedBlocks, worldIn, blockpos1.north(2).east(), boundsIn);
                    if (buildTrunk <= randCorner4)
                        placeTrunk(config, rand, changedBlocks, worldIn, blockpos1.north(2).west(2), boundsIn);

                    if (buildTrunk <= randOuterEdge)
                        placeTrunk(config, rand, changedBlocks, worldIn, blockpos1.north(3), boundsIn);
                    if (buildTrunk <= randOuterEdge2)
                        placeTrunk(config, rand, changedBlocks, worldIn, blockpos1.north(3).west(), boundsIn);
                    if (buildTrunk <= randOuterEdge3)
                        placeTrunk(config, rand, changedBlocks, worldIn, blockpos1.east(2), boundsIn);
                    if (buildTrunk <= randOuterEdge4)
                        placeTrunk(config, rand, changedBlocks, worldIn, blockpos1.east(2).north(), boundsIn);
                    if (buildTrunk <= randOuterEdge5)
                        placeTrunk(config, rand, changedBlocks, worldIn, blockpos1.south(2).west(), boundsIn);
                    if (buildTrunk <= randOuterEdge6)
                        placeTrunk(config, rand, changedBlocks, worldIn, blockpos1.south(2), boundsIn);
                    if (buildTrunk <= randOuterEdge7)
                        placeTrunk(config, rand, changedBlocks, worldIn, blockpos1.west(3), boundsIn);
                    if (buildTrunk <= randOuterEdge8)
                        placeTrunk(config, rand, changedBlocks, worldIn, blockpos1.west(3).north(), boundsIn);

                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east().up(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east(2).up(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north().east().up(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north().east(2).up(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north().east(2).up(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north().east(2).up(3), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(2).east(3).up(4), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(2).east(3).up(5), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(2).east(3).up(6), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.south().east(3).up(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.south().east(4).up(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.south().east(5).up(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.south().east(5).up(3), boundsIn);

                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.south().west().up(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.south(2).west(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.south(2).west().up(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.south(2).west(2).up(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.south(3).up(2), boundsIn);

                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.south(3).up(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.south(4).up(3).east(), boundsIn);

                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.south(3).up(2).west(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.south(4).up(2).west(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.south(5).up(3).west(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.south(5).up(4).west(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.south(3).up(3).west(3), boundsIn);

                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.west().up(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.west().up(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.west(3).up(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.west(3), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.west(4).south().up(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.west(5).up(3), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.west(6).up(3), boundsIn);

                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.west(7).up(4).south(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.west(7).up(5).south(), boundsIn);
//                    placeStem(LOG, changedBlocks, worldIn, blockpos2.west(7).up(6).south(), boundsIn);


                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north().up(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north().up(2), boundsIn);
//                    placeStem(LOG, changedBlocks, worldIn, blockpos2.north().up(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(3).up(3), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(3).up(4), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(3).up(5), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(6).up(3), boundsIn);

                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(4).west().up(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(5).west().up(2), boundsIn);

                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(3).west(2).up(1), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(3).west(3).up(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(2).west(4).up(3), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(3).west(5).up(4), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(3).west(5).up(5), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(3).west(5).up(6), boundsIn);


                }

                int leavessquarespos = 2;
                for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                    for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {
                        int posX2 = posX1 + 5;
                        int posZ2 = posZ1 + 1;
                        int posX3 = posX1 + 3;
                        int posZ3 = posZ1 - 2;
                        int posX4 = posX1 - 1;
                        int posZ4 = posZ1 + 4;
                        int posX5 = posX1 - 7;
                        int posZ5 = posZ1 + 1;
                        int posX6 = posX1 - 5;
                        int posZ6 = posZ1 - 3;
                        int posX7 = posX1;
                        int posZ7 = posZ1 - 6;
                        int posX8 = posX1 - 6;
                        int posZ8 = posZ1;
                        int posX9 = posX1;
                        int posZ9 = posZ1 - 3;
                        int posX10 = posX1 + 1;
                        int posZ10 = posZ1 + 4;

                        placeLeaves(config, rand, worldIn, posX2 + posXLeafWidth, topTrunkHeight2, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + posXLeafWidth, topTrunkHeight3, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX4 + posXLeafWidth, topTrunkHeight4, posZ4 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX5 + posXLeafWidth, topTrunkHeight5, posZ5 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX7 + posXLeafWidth, topTrunkHeight7, posZ7 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX8 + posXLeafWidth, topTrunkHeight8, posZ8 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX9 + posXLeafWidth, topTrunkHeight9, posZ9 + posZLeafWidthL0, boundsIn, changedBlocks);


                        if (posXLeafWidth <= 1 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {
                            placeLeaves(config, rand, worldIn, posX2 + posXLeafWidth, topTrunkHeight2, posZ2 + posZLeafWidthL0 - 2, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX2 + posXLeafWidth, topTrunkHeight2, posZ2 + posZLeafWidthL0 + 2, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX2 + posXLeafWidth + 2, topTrunkHeight2, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX2 + posXLeafWidth - 2, topTrunkHeight2, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX2 + posXLeafWidth, topTrunkHeight2 + 1, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);

                            placeLeaves(config, rand, worldIn, posX3 + posXLeafWidth + 2, topTrunkHeight3, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX3 + posXLeafWidth - 2, topTrunkHeight3, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX3 + posXLeafWidth, topTrunkHeight3, posZ3 + posZLeafWidthL0 + 2, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX3 + posXLeafWidth, topTrunkHeight3, posZ3 + posZLeafWidthL0 - 2, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX3 + posXLeafWidth, topTrunkHeight3 + 1, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);

                            placeLeaves(config, rand, worldIn, posX4 + posXLeafWidth + 2, topTrunkHeight4, posZ4 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX4 + posXLeafWidth - 2, topTrunkHeight4, posZ4 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX4 + posXLeafWidth, topTrunkHeight4, posZ4 + posZLeafWidthL0 + 2, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX4 + posXLeafWidth, topTrunkHeight4, posZ4 + posZLeafWidthL0 - 2, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX4 + posXLeafWidth, topTrunkHeight4 + 1, posZ4 + posZLeafWidthL0, boundsIn, changedBlocks);

                            placeLeaves(config, rand, worldIn, posX5 + posXLeafWidth - 2, topTrunkHeight5, posZ5 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX5 + posXLeafWidth + 2, topTrunkHeight5, posZ5 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX5 + posXLeafWidth, topTrunkHeight5, posZ5 + posZLeafWidthL0 + 2, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX5 + posXLeafWidth, topTrunkHeight5, posZ5 + posZLeafWidthL0 - 2, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX5 + posXLeafWidth, topTrunkHeight5 + 1, posZ5 + posZLeafWidthL0, boundsIn, changedBlocks);

                            placeLeaves(config, rand, worldIn, posX6 + posXLeafWidth, topTrunkHeight6, posZ6 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX6 + posXLeafWidth - 1, topTrunkHeight6, posZ6 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX6 + posXLeafWidth + 1, topTrunkHeight6, posZ6 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX6 + posXLeafWidth, topTrunkHeight6, posZ6 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX6 + posXLeafWidth, topTrunkHeight6, posZ6 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);

                            placeLeaves(config, rand, worldIn, posX7 + posXLeafWidth, topTrunkHeight7, posZ7 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX7 + posXLeafWidth - 2, topTrunkHeight7, posZ7 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX7 + posXLeafWidth + 2, topTrunkHeight7, posZ7 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX7 + posXLeafWidth, topTrunkHeight7, posZ7 + posZLeafWidthL0 - 2, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX7 + posXLeafWidth, topTrunkHeight7, posZ7 + posZLeafWidthL0 + 2, boundsIn, changedBlocks);

                            placeLeaves(config, rand, worldIn, posX8 + posXLeafWidth, topTrunkHeight8 + 1, posZ8 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX8 + posXLeafWidth + 1, topTrunkHeight8 + 1, posZ8 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX8 + posXLeafWidth - 1, topTrunkHeight8 + 1, posZ8 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX8 + posXLeafWidth, topTrunkHeight8 + 1, posZ8 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX8 + posXLeafWidth, topTrunkHeight8 + 1, posZ8 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX8 + posXLeafWidth - 2, topTrunkHeight8, posZ8 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX8 + posXLeafWidth + 2, topTrunkHeight8, posZ8 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX8 + posXLeafWidth, topTrunkHeight8, posZ8 + posZLeafWidthL0 - 2, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX8 + posXLeafWidth, topTrunkHeight8, posZ8 + posZLeafWidthL0 + 2, boundsIn, changedBlocks);

                            placeLeaves(config, rand, worldIn, posX9 + posXLeafWidth, topTrunkHeight9, posZ9 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX9 + posXLeafWidth - 2, topTrunkHeight9, posZ9 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX9 + posXLeafWidth + 2, topTrunkHeight9, posZ9 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX9 + posXLeafWidth, topTrunkHeight9, posZ9 + posZLeafWidthL0 - 2, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX9 + posXLeafWidth, topTrunkHeight9, posZ9 + posZLeafWidthL0 + 2, boundsIn, changedBlocks);

                        }

                        placeLeaves(config, rand, worldIn, posX2, topTrunkHeight2 + 1, posZ2 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX2, topTrunkHeight2 + 1, posZ2 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX2 + 2, topTrunkHeight2 + 1, posZ2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX2 - 2, topTrunkHeight2 + 1, posZ2, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight3 + 1, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight3 + 1, posZ3 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 2, topTrunkHeight3 + 1, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 2, topTrunkHeight3 + 1, posZ3, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX4, topTrunkHeight4 + 1, posZ4 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX4, topTrunkHeight4 + 1, posZ4 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX4 + 2, topTrunkHeight4 + 1, posZ4, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX4 - 2, topTrunkHeight4 + 1, posZ4, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX5, topTrunkHeight5 + 1, posZ5 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX5, topTrunkHeight5 + 1, posZ5 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX5 + 2, topTrunkHeight5 + 1, posZ5, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX5 - 2, topTrunkHeight5 + 1, posZ5, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX6, topTrunkHeight6 + 1, posZ6 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX6, topTrunkHeight6 + 1, posZ6 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX6 + 1, topTrunkHeight6 + 1, posZ6, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX6 - 1, topTrunkHeight6 + 1, posZ6, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX6, topTrunkHeight6 + 1, posZ6, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX7, topTrunkHeight7 + 1, posZ7 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX7, topTrunkHeight7 + 1, posZ7 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX7 + 1, topTrunkHeight7 + 1, posZ7, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX7 - 1, topTrunkHeight7 + 1, posZ7, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX7, topTrunkHeight7 + 1, posZ7, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX7, topTrunkHeight7 - 1, posZ7 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX7, topTrunkHeight7 - 1, posZ7 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX7 + 1, topTrunkHeight7 - 1, posZ7, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX7 - 1, topTrunkHeight7 - 1, posZ7, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX7, topTrunkHeight7 - 1, posZ7, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX9, topTrunkHeight9 + 1, posZ9 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX9, topTrunkHeight9 + 1, posZ9 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX9 + 1, topTrunkHeight9 + 1, posZ9, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX9 - 1, topTrunkHeight9 + 1, posZ9, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX9, topTrunkHeight9 + 1, posZ9, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX9, topTrunkHeight9 - 1, posZ9 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX9, topTrunkHeight9 - 1, posZ9 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX9, topTrunkHeight9 - 2, posZ9 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX9 + 1, topTrunkHeight9 - 1, posZ9, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX9 - 1, topTrunkHeight9 - 1, posZ9, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX9, topTrunkHeight9 - 1, posZ9, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX10, topTrunkHeight10, posZ10 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX10, topTrunkHeight10, posZ10 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX10 + 1, topTrunkHeight10, posZ10, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX10 - 1, topTrunkHeight10, posZ10, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX10, topTrunkHeight10 + 1, posZ10, boundsIn, changedBlocks);

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
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlocks.BAOBAB_LOG.getDefaultState(), boundingBox);
        }

    }


    private void leafs(ISeedReader reader, int x, int y, int z, MutableBoundingBox boundingBox, Set<BlockPos> blockPos) {
        BlockPos blockpos = new BlockPos(x, y, z);
        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos, BYGBlocks.BAOBAB_LEAVES.getDefaultState(), boundingBox);
        }

    }
}