package voronoiaoc.byg.common.world.feature.features.overworld.trees.jacaranda;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;

//THIS FEATURE MUST BE REGISTERED & ADDED TO A BIOME!
public class JacarandaTree1 extends BYGAbstractTreeFeature<DefaultFeatureConfig> {
    private static final BlockState LOG = BYGBlockList.JACARANDA_LOG.getDefaultState();
    private static final BlockState LEAVES = BYGBlockList.JACARANDA_LEAVES.getDefaultState();
    private static final BlockState BEENEST = Blocks.BEE_NEST.getDefaultState();

    public JacarandaTree1(Codec<DefaultFeatureConfig> configIn) {
        super(configIn);
        //setSapling((net.minecraftforge.common.IPlantable) BYGBlockList.JACARANDA_SAPLING);
    }


    public boolean place(Set<BlockPos> changedBlocks, StructureWorldAccess worldIn, Random rand, BlockPos position, BlockBox boundsIn) {

        int randTreeHeight = rand.nextInt(3) + rand.nextInt(5) + 9;
        //Positions
        int posX = position.getX();
        int posY = position.getY();
        int posZ = position.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < 256) {
            BlockPos blockpos = position.down();
            if (!isDesiredGroundwDirtTag(worldIn, blockpos, Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.doesTreeFit(worldIn, position, randTreeHeight)) {
                return false;
            } else {


                //this.setGroundBlockAt(worldIn, blockpos.west(), position, Blocks.DIRT.getDefaultState());
                //this.setGroundBlockAt(worldIn, blockpos.east(), position, Blocks.DIRT.getDefaultState());
                //this.setGroundBlockAt(worldIn, blockpos.south(), position, Blocks.DIRT.getDefaultState());
                //this.setGroundBlockAt(worldIn, blockpos.north(), position, Blocks.DIRT.getDefaultState());

                Direction direction = Direction.Type.HORIZONTAL.random(rand);
                int randTreeHeight2 = randTreeHeight - rand.nextInt(1);//Crashes on 0.
                int posY1 = 2 - rand.nextInt(1);//Crashes on 0.
                int posX1 = posX;
                int posZ1 = posZ;
                int topTrunkHeight = posY + randTreeHeight - 1;


                for (int buildTrunk = 0; buildTrunk < randTreeHeight; ++buildTrunk) {
                    if (buildTrunk >= randTreeHeight2 && posY1 < 0) { //Unknown
                        posX1 += direction.getOffsetX();
                        posZ1 += direction.getOffsetZ();
                        ++posY1;
                    }
                    int logplacer = posY + buildTrunk;
                    int logplacer2 = posY;
                    int logplacer3 = posY + randTreeHeight - 3;
                    int logplacer4 = posY + randTreeHeight - 1;
                    int logplacer5 = posY + randTreeHeight - 2;

                    BlockPos blockpos1 = new BlockPos(posX1, logplacer, posZ1);
                    BlockPos blockpos2 = new BlockPos(posX1, logplacer2, posZ1);
                    BlockPos blockpos3 = new BlockPos(posX1, logplacer3, posZ1);
                    BlockPos blockpos4 = new BlockPos(posX1, logplacer4, posZ1);
                    BlockPos blockpos5 = new BlockPos(posX1, logplacer5, posZ1);


                    int logPreset = rand.nextInt(14) + 1;

                    this.treelog(changedBlocks, worldIn, blockpos1, boundsIn);
                    if (rand.nextInt(3) == 0) {
                        this.treelog(changedBlocks, worldIn, blockpos2.south(), boundsIn);
                        this.treelog(changedBlocks, worldIn, blockpos2.north(), boundsIn);
                        if (logPreset == 0) {
                            this.treelog(changedBlocks, worldIn, blockpos2.south().up(), boundsIn);
                        } else if (logPreset == 2) {
                            this.treelog(changedBlocks, worldIn, blockpos2.north().up(), boundsIn);
                        } else if (logPreset == 10) {
                            this.treelog(changedBlocks, worldIn, blockpos2.west().up(), boundsIn);
                        }

                        if (rand.nextInt(3) == 1) {
                            this.treelog(changedBlocks, worldIn, blockpos2.east(), boundsIn);
                        } else if (rand.nextInt(4) == 1) {
                            this.treelog(changedBlocks, worldIn, blockpos2.west(), boundsIn);
                        }
                    }
                    if (rand.nextInt(3) == 2) {
                        this.treelog(changedBlocks, worldIn, blockpos2.west(), boundsIn);
                    }
                    this.treelog(changedBlocks, worldIn, blockpos3.west(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos3.south(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos3.east(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos3.north(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos3.west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos3.south(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos3.east(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos3.north(2), boundsIn);

                    this.treelog(changedBlocks, worldIn, blockpos4.west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos4.south(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos4.east(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos4.north(2), boundsIn);

                    this.treelog(changedBlocks, worldIn, blockpos5.west(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos5.south(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos5.east(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos5.north(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos5.west(4), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos5.south(4), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos5.east(4), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos5.north(4), boundsIn);

                    this.treelog(changedBlocks, worldIn, blockpos5.north(5).down().west(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos5.east(5).down().north(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos5.south(5).down().east(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos5.west(5).down().south(), boundsIn);

                }
                int leavePreset = rand.nextInt(1) + 1;
                {
                    if (leavePreset == 1) {
                        int leavessquarespos = 1;
                        for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                            for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {
                                for (int posYLeafHeight = 0; posYLeafHeight <= 3; ++posYLeafHeight) {
                                    this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight + 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 2, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 2, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1 + 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1 - 2, boundsIn, changedBlocks);

                                    this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight + posYLeafHeight - 3, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight + posYLeafHeight - 6, posZ1 - 1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight + posYLeafHeight - 3, posZ1 - 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight + posYLeafHeight - 2, posZ1 - 3, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight + posYLeafHeight - 3, posZ1 - 4, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight + posYLeafHeight - 5, posZ1 - 4, boundsIn, changedBlocks);

                                    if (posYLeafHeight <= 2) {
                                        this.leafs(worldIn, posX1, topTrunkHeight + posYLeafHeight - 3, posZ1 - 5, boundsIn, changedBlocks);
                                    }
                                    if (posYLeafHeight <= 1) {
                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight + posYLeafHeight - 2, posZ1 - 4, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight + posYLeafHeight - 1, posZ1 - 3, boundsIn, changedBlocks);
                                    }
                                    if (posYLeafHeight <= 2) {
                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight + posYLeafHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight + posYLeafHeight - 5, posZ1 - 4, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight + posYLeafHeight - 3, posZ1 - 3, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight + posYLeafHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight + posYLeafHeight - 2, posZ1 - 1, boundsIn, changedBlocks);

                                        this.leafs(worldIn, posX1 + 3, topTrunkHeight + posYLeafHeight - 2, posZ1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 4, topTrunkHeight + posYLeafHeight - 2, posZ1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 5, topTrunkHeight + posYLeafHeight - 3, posZ1, boundsIn, changedBlocks);

                                        this.leafs(worldIn, posX1 + 6, topTrunkHeight + posYLeafHeight - 4, posZ1 - 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 5, topTrunkHeight + posYLeafHeight - 5, posZ1 - 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight + posYLeafHeight - 2, posZ1 + 3, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight + posYLeafHeight - 3, posZ1 + 4, boundsIn, changedBlocks);

                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight + posYLeafHeight - 4, posZ1 + 6, boundsIn, changedBlocks);

                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight + posYLeafHeight - 2, posZ1 + 2, boundsIn, changedBlocks);

                                        this.leafs(worldIn, posX1 - 4, topTrunkHeight + posYLeafHeight - 2, posZ1 + 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 4, topTrunkHeight + posYLeafHeight - 2, posZ1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight + posYLeafHeight - 2, posZ + 1, boundsIn, changedBlocks);

                                        this.leafs(worldIn, posX1 - 5, topTrunkHeight + posYLeafHeight - 4, posZ1 + 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - posYLeafHeight, posZ1 - 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 3, topTrunkHeight - posYLeafHeight - 2, posZ1 - 2, boundsIn, changedBlocks);

                                        this.leafs(worldIn, posX1 + 4, topTrunkHeight - posYLeafHeight - 2, posZ1 - 3, boundsIn, changedBlocks);


                                    }
                                    this.leafs(worldIn, posX1 + 2, topTrunkHeight + posYLeafHeight - 3, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 5, topTrunkHeight + posYLeafHeight - 4, posZ1 - 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 5, topTrunkHeight + posYLeafHeight - 6, posZ1 - 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 4, topTrunkHeight + posYLeafHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 4, topTrunkHeight + posYLeafHeight - 4, posZ1 - 1, boundsIn, changedBlocks);

                                    this.leafs(worldIn, posX1 + 1, topTrunkHeight + posYLeafHeight - 4, posZ1 + 5, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 1, topTrunkHeight + posYLeafHeight - 6, posZ1 + 5, boundsIn, changedBlocks);

                                    this.leafs(worldIn, posX1, topTrunkHeight + posYLeafHeight - 3, posZ1 + 3, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight + posYLeafHeight - 3, posZ1 + 4, boundsIn, changedBlocks);

                                    this.leafs(worldIn, posX1 - 1, topTrunkHeight + posYLeafHeight - 4, posZ1 + 3, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 1, topTrunkHeight + posYLeafHeight - 5, posZ1 + 3, boundsIn, changedBlocks);

                                    this.leafs(worldIn, posX1 - 3, topTrunkHeight + posYLeafHeight - 3, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 2, topTrunkHeight + posYLeafHeight - 3, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 1, topTrunkHeight + posYLeafHeight - 5, posZ1, boundsIn, changedBlocks);

                                    this.leafs(worldIn, posX1 - 6, topTrunkHeight + posYLeafHeight - 6, posZ1 + 2, boundsIn, changedBlocks);


                                    this.leafs(worldIn, posX1 + 1, topTrunkHeight - 2, posZ1 - 5, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 1, topTrunkHeight - 1, posZ1 - 4, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 1, topTrunkHeight - 3, posZ1 - 4, boundsIn, changedBlocks);

                                    this.leafs(worldIn, posX1 + 2, topTrunkHeight - 2, posZ1 - 3, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 2, topTrunkHeight, posZ1 - 3, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 2, topTrunkHeight - 1, posZ1 - 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 5, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 5, topTrunkHeight - 1, posZ1 - 1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 3, topTrunkHeight - 1, posZ1 - 1, boundsIn, changedBlocks);

                                    this.leafs(worldIn, posX1 + 6, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 4, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 3, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 1, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);


                                    this.leafs(worldIn, posX1 + 1, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 3, topTrunkHeight - 1, posZ1 - 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 2, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);


                                    this.leafs(worldIn, posX1 + 5, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);


                                    this.leafs(worldIn, posX1 - 2, topTrunkHeight + posYLeafHeight - 5, posZ1 - 5, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 1, topTrunkHeight + posYLeafHeight - 4, posZ1 - 5, boundsIn, changedBlocks);

                                    this.leafs(worldIn, posX1 + 1, topTrunkHeight + posYLeafHeight - 3, posZ1 + 2, boundsIn, changedBlocks);


                                    if (posYLeafHeight <= 1) {
                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight + posYLeafHeight - 3, posZ1 - 6, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 3, topTrunkHeight + posYLeafHeight - 2, posZ1 + 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 3, topTrunkHeight + posYLeafHeight - 2, posZ1 + 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight + posYLeafHeight - 3, posZ1 + 5, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1, topTrunkHeight + posYLeafHeight - 2, posZ1 + 5, boundsIn, changedBlocks);

                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight + posYLeafHeight - 1, posZ1 + 2, boundsIn, changedBlocks);


                                    }
                                    this.leafs(worldIn, posX1 - 2, topTrunkHeight - 2, posZ1 - 6, boundsIn, changedBlocks);

                                    this.leafs(worldIn, posX1 + 4, topTrunkHeight - 1, posZ1 + 1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 4, topTrunkHeight - 1, posZ1 + 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 3, topTrunkHeight, posZ1 + 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 2, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 2, topTrunkHeight, posZ1 + 3, boundsIn, changedBlocks);

                                    this.leafs(worldIn, posX1 + 2, topTrunkHeight - 1, posZ1 + 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 2, topTrunkHeight - 1, posZ1 + 4, boundsIn, changedBlocks);

                                    this.leafs(worldIn, posX1 + 2, topTrunkHeight - 2, posZ1 + 3, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 2, topTrunkHeight - 2, posZ1 + 1, boundsIn, changedBlocks);

                                    this.leafs(worldIn, posX1 - 1, topTrunkHeight - 1, posZ1 + 4, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 + 4, boundsIn, changedBlocks);

                                    this.leafs(worldIn, posX1, topTrunkHeight - 1, posZ1 + 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight - 3, posZ1 + 2, boundsIn, changedBlocks);
                                    //this.leafs(worldIn, posX1 -1, topTrunkHeight + 3, posZ1 + 2, boundsIn, changedBlocks);

                                    this.leafs(worldIn, posX1 - 3, topTrunkHeight + 1, posZ1 + 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 3, topTrunkHeight + 1, posZ1 + 1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 3, topTrunkHeight - 1, posZ1 + 1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 3, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);


                                    this.leafs(worldIn, posX1 - 3, topTrunkHeight - 1, posZ1 + 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 3, topTrunkHeight - 2, posZ1 + 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 3, topTrunkHeight - 1, posZ1 + 3, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 2, topTrunkHeight, posZ1 + 3, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 2, topTrunkHeight - 2, posZ1 + 3, boundsIn, changedBlocks);

                                    this.leafs(worldIn, posX1 - 5, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 5, topTrunkHeight - 2, posZ1, boundsIn, changedBlocks);

                                    this.leafs(worldIn, posX1 - 4, topTrunkHeight - 1, posZ1 - 1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 3, topTrunkHeight - 1, posZ1 - 1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 3, topTrunkHeight - 2, posZ1 - 1, boundsIn, changedBlocks);


                                    this.leafs(worldIn, posX1 - 5, topTrunkHeight - 1, posZ1 + 1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 6, topTrunkHeight - 2, posZ1 + 1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 5, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);

                                    this.leafs(worldIn, posX1 - 3, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 2, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 2, topTrunkHeight - 1, posZ1 - 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 2, topTrunkHeight - 1, posZ1 - 3, boundsIn, changedBlocks);

                                    //this.leafs(worldIn, posX1 - 3, topTrunkHeight + 5, posZ1 + 3, boundsIn, changedBlocks);


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

    private boolean doesTreeFit(TestableWorld reader, BlockPos blockPos, int height) {
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        BlockPos.Mutable position = new BlockPos.Mutable();

        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
            //Distance/Density of trees. Positive Values ONLY
            int distance = 1;

            for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
                for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
                    if (!canTreePlaceHere(reader, position.set(x + xOffset, y + yOffset, z + zOffset))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //Log Placement
    private void treelog(Set<BlockPos> setlogblock, StructureWorldAccess reader, BlockPos pos, BlockBox boundingBox) {
        if (canTreePlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, LOG, boundingBox);
        }

    }

    //Leaves Placement
    private void leafs(StructureWorldAccess reader, int x, int y, int z, BlockBox boundingBox, Set<BlockPos> blockPos) {
        BlockPos blockpos = new BlockPos(x, y, z);
        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos, LEAVES, boundingBox);
        }

    }
}