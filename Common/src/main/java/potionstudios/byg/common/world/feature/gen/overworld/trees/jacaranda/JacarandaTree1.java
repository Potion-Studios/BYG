package potionstudios.byg.common.world.feature.gen.overworld.trees.jacaranda;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import potionstudios.byg.common.world.feature.config.BYGTreeConfig;
import potionstudios.byg.common.world.feature.gen.overworld.trees.util.BYGAbstractTreeFeature;

import java.util.Random;
import java.util.Set;

public class JacarandaTree1 extends BYGAbstractTreeFeature<BYGTreeConfig> {

    public JacarandaTree1(Codec<BYGTreeConfig> configIn) {
        super(configIn);
    }


    public boolean generate(Set<BlockPos> changedBlocks, WorldGenLevel worldIn, Random rand, BlockPos pos, BoundingBox boundsIn, boolean isSapling, BYGTreeConfig config) {

        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        //Positions
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {

            if (!isDesiredGroundwDirtTag(worldIn, pos.below(), config)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isSapling)) {
                return false;
            } else {

                Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(rand);
                int randTreeHeight2 = randTreeHeight - rand.nextInt(1);
                int posY1 = 2 - rand.nextInt(1);
                int posX1 = posX;
                int posZ1 = posZ;
                int topTrunkHeight = posY + randTreeHeight - 1;


                for (int buildTrunk = 0; buildTrunk < randTreeHeight; ++buildTrunk) {
                    if (buildTrunk >= randTreeHeight2 && posY1 < 0) {
                        posX1 += direction.getStepX();
                        posZ1 += direction.getStepZ();
                        ++posY1;
                    }
                    int logplacer = posY + buildTrunk;
                    int logplacer3 = posY + randTreeHeight - 3;
                    int logplacer4 = posY + randTreeHeight - 1;
                    int logplacer5 = posY + randTreeHeight - 2;

                    BlockPos blockpos1 = new BlockPos(posX1, logplacer, posZ1);
                    BlockPos blockpos2 = new BlockPos(posX1, posY, posZ1);
                    BlockPos blockpos3 = new BlockPos(posX1, logplacer3, posZ1);
                    BlockPos blockpos4 = new BlockPos(posX1, logplacer4, posZ1);
                    BlockPos blockpos5 = new BlockPos(posX1, logplacer5, posZ1);


                    int logPreset = rand.nextInt(14) + 1;

                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos1, boundsIn);
                    if (rand.nextInt(3) == 0) {
                        placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.south(), boundsIn);
                        placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.north(), boundsIn);
                        if (logPreset == 0) {
                            placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.south().above(), boundsIn);
                        } else if (logPreset == 2) {
                            placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.north().above(), boundsIn);
                        } else if (logPreset == 10) {
                            placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.west().above(), boundsIn);
                        }

                        if (rand.nextInt(3) == 1) {
                            placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.east(), boundsIn);
                        } else if (rand.nextInt(4) == 1) {
                            placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.west(), boundsIn);
                        }
                    }
                    if (rand.nextInt(3) == 2) {
                        placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.west(), boundsIn);
                    }
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos3.west(), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos3.south(), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos3.east(), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos3.north(), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos3.west(2), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos3.south(2), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos3.east(2), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos3.north(2), boundsIn);

                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos4.west(2), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos4.south(2), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos4.east(2), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos4.north(2), boundsIn);

                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos5.west(3), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos5.south(3), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos5.east(3), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos5.north(3), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos5.west(4), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos5.south(4), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos5.east(4), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos5.north(4), boundsIn);

                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos5.north(5).below().west(), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos5.east(5).below().north(), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos5.south(5).below().east(), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos5.west(5).below().south(), boundsIn);

                }
                int leavePreset = rand.nextInt(1) + 1;
                {
                    if (leavePreset == 1) {
                        int leavessquarespos = 1;
                        for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                            for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {
                                for (int posYLeafHeight = 0; posYLeafHeight <= 3; ++posYLeafHeight) {
                                    placeLeaves(pos, config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight + 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight + 1, posZ1 + 2, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight + 1, posZ1 - 2, boundsIn, changedBlocks);

                                    placeLeaves(pos, config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight + posYLeafHeight - 3, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight + posYLeafHeight - 6, posZ1 - 1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight + posYLeafHeight - 3, posZ1 - 2, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight + posYLeafHeight - 2, posZ1 - 3, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight + posYLeafHeight - 3, posZ1 - 4, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight + posYLeafHeight - 5, posZ1 - 4, boundsIn, changedBlocks);

                                    if (posYLeafHeight <= 2) {
                                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight + posYLeafHeight - 3, posZ1 - 5, boundsIn, changedBlocks);
                                    }
                                    if (posYLeafHeight <= 1) {
                                        placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight + posYLeafHeight - 2, posZ1 - 4, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight + posYLeafHeight - 1, posZ1 - 3, boundsIn, changedBlocks);
                                    }
                                    if (posYLeafHeight <= 2) {
                                        placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight + posYLeafHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight + posYLeafHeight - 5, posZ1 - 4, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight + posYLeafHeight - 3, posZ1 - 3, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight + posYLeafHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight + posYLeafHeight - 2, posZ1 - 1, boundsIn, changedBlocks);

                                        placeLeaves(pos, config, rand, worldIn, posX1 + 3, topTrunkHeight + posYLeafHeight - 2, posZ1, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1 + 4, topTrunkHeight + posYLeafHeight - 2, posZ1, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1 + 5, topTrunkHeight + posYLeafHeight - 3, posZ1, boundsIn, changedBlocks);

                                        placeLeaves(pos, config, rand, worldIn, posX1 + 6, topTrunkHeight + posYLeafHeight - 4, posZ1 - 1, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1 + 5, topTrunkHeight + posYLeafHeight - 5, posZ1 - 1, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight + posYLeafHeight - 2, posZ1 + 3, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight + posYLeafHeight - 3, posZ1 + 4, boundsIn, changedBlocks);

                                        placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight + posYLeafHeight - 4, posZ1 + 6, boundsIn, changedBlocks);

                                        placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight + posYLeafHeight - 2, posZ1 + 2, boundsIn, changedBlocks);

                                        placeLeaves(pos, config, rand, worldIn, posX1 - 4, topTrunkHeight + posYLeafHeight - 2, posZ1 + 1, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1 - 4, topTrunkHeight + posYLeafHeight - 2, posZ1, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight + posYLeafHeight - 2, posZ + 1, boundsIn, changedBlocks);

                                        placeLeaves(pos, config, rand, worldIn, posX1 - 5, topTrunkHeight + posYLeafHeight - 4, posZ1 + 2, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight - posYLeafHeight, posZ1 - 1, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1 - 3, topTrunkHeight - posYLeafHeight - 2, posZ1 - 2, boundsIn, changedBlocks);

                                        placeLeaves(pos, config, rand, worldIn, posX1 + 4, topTrunkHeight - posYLeafHeight - 2, posZ1 - 3, boundsIn, changedBlocks);


                                    }
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight + posYLeafHeight - 3, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 5, topTrunkHeight + posYLeafHeight - 4, posZ1 - 2, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 5, topTrunkHeight + posYLeafHeight - 6, posZ1 - 2, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 4, topTrunkHeight + posYLeafHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 4, topTrunkHeight + posYLeafHeight - 4, posZ1 - 1, boundsIn, changedBlocks);

                                    placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight + posYLeafHeight - 4, posZ1 + 5, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight + posYLeafHeight - 6, posZ1 + 5, boundsIn, changedBlocks);

                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight + posYLeafHeight - 3, posZ1 + 3, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight + posYLeafHeight - 3, posZ1 + 4, boundsIn, changedBlocks);

                                    placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight + posYLeafHeight - 4, posZ1 + 3, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight + posYLeafHeight - 5, posZ1 + 3, boundsIn, changedBlocks);

                                    placeLeaves(pos, config, rand, worldIn, posX1 - 3, topTrunkHeight + posYLeafHeight - 3, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight + posYLeafHeight - 3, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight + posYLeafHeight - 5, posZ1, boundsIn, changedBlocks);

                                    placeLeaves(pos, config, rand, worldIn, posX1 - 6, topTrunkHeight + posYLeafHeight - 6, posZ1 + 2, boundsIn, changedBlocks);


                                    placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - 2, posZ1 - 5, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - 1, posZ1 - 4, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - 3, posZ1 - 4, boundsIn, changedBlocks);

                                    placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight - 2, posZ1 - 3, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight, posZ1 - 3, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight - 1, posZ1 - 2, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 5, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 5, topTrunkHeight - 1, posZ1 - 1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 3, topTrunkHeight - 1, posZ1 - 1, boundsIn, changedBlocks);

                                    placeLeaves(pos, config, rand, worldIn, posX1 + 6, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 4, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 3, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);


                                    placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 3, topTrunkHeight - 1, posZ1 - 2, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);


                                    placeLeaves(pos, config, rand, worldIn, posX1 + 5, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);


                                    placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight + posYLeafHeight - 5, posZ1 - 5, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight + posYLeafHeight - 4, posZ1 - 5, boundsIn, changedBlocks);

                                    placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight + posYLeafHeight - 3, posZ1 + 2, boundsIn, changedBlocks);


                                    if (posYLeafHeight <= 1) {
                                        placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight + posYLeafHeight - 3, posZ1 - 6, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1 + 3, topTrunkHeight + posYLeafHeight - 2, posZ1 + 1, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1 + 3, topTrunkHeight + posYLeafHeight - 2, posZ1 + 2, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight + posYLeafHeight - 3, posZ1 + 5, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight + posYLeafHeight - 2, posZ1 + 5, boundsIn, changedBlocks);

                                        placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight + posYLeafHeight - 1, posZ1 + 2, boundsIn, changedBlocks);


                                    }
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight - 2, posZ1 - 6, boundsIn, changedBlocks);

                                    placeLeaves(pos, config, rand, worldIn, posX1 + 4, topTrunkHeight - 1, posZ1 + 1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 4, topTrunkHeight - 1, posZ1 + 2, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 3, topTrunkHeight, posZ1 + 2, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight, posZ1 + 3, boundsIn, changedBlocks);

                                    placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight - 1, posZ1 + 2, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight - 1, posZ1 + 4, boundsIn, changedBlocks);

                                    placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight - 2, posZ1 + 3, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight - 2, posZ1 + 1, boundsIn, changedBlocks);

                                    placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - 1, posZ1 + 4, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 + 4, boundsIn, changedBlocks);

                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 1, posZ1 + 2, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 3, posZ1 + 2, boundsIn, changedBlocks);
                                    //placePetal(LEAVES, worldIn, posX1 -1, topTrunkHeight + 3, posZ1 + 2, boundsIn, changedBlocks);

                                    placeLeaves(pos, config, rand, worldIn, posX1 - 3, topTrunkHeight + 1, posZ1 + 2, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 3, topTrunkHeight + 1, posZ1 + 1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 3, topTrunkHeight - 1, posZ1 + 1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 3, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);


                                    placeLeaves(pos, config, rand, worldIn, posX1 - 3, topTrunkHeight - 1, posZ1 + 2, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 3, topTrunkHeight - 2, posZ1 + 2, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 3, topTrunkHeight - 1, posZ1 + 3, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight, posZ1 + 3, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight - 2, posZ1 + 3, boundsIn, changedBlocks);

                                    placeLeaves(pos, config, rand, worldIn, posX1 - 5, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 5, topTrunkHeight - 2, posZ1, boundsIn, changedBlocks);

                                    placeLeaves(pos, config, rand, worldIn, posX1 - 4, topTrunkHeight - 1, posZ1 - 1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 3, topTrunkHeight - 1, posZ1 - 1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 3, topTrunkHeight - 2, posZ1 - 1, boundsIn, changedBlocks);


                                    placeLeaves(pos, config, rand, worldIn, posX1 - 5, topTrunkHeight - 1, posZ1 + 1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 6, topTrunkHeight - 2, posZ1 + 1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 5, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);

                                    placeLeaves(pos, config, rand, worldIn, posX1 - 3, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight - 1, posZ1 - 2, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight - 1, posZ1 - 3, boundsIn, changedBlocks);

                                    //placePetal(LEAVES, worldIn, posX1 - 3, topTrunkHeight + 5, posZ1 + 3, boundsIn, changedBlocks);


                                }
                            }
                        }
                    } else if (leavePreset == 2) {
                        int leavessquarespos = 2;
                        for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                            for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                            }
                        }
                    } else if (leavePreset == 3) {
                        int leavessquarespos = 2;
                        for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                            for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                            }
                        }
                    } else if (leavePreset == 4) {
                        int leavessquarespos = 2;
                        for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                            for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                            }
                        }
                    }
                }
            }

            return true;
            //}
        } else {
            return false;
        }
    }


}