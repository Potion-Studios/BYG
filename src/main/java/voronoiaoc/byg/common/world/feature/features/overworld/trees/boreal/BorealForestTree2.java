package voronoiaoc.byg.common.world.feature.features.overworld.trees.boreal;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.common.IPlantable;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

//THIS FEATURE MUST BE REGISTERED & ADDED TO A BIOME!
public class BorealForestTree2 extends BYGAbstractTreeFeature<NoFeatureConfig> {
    //Blocks used for the tree.
    private static final BlockState LOG = Blocks.SPRUCE_LOG.getDefaultState();
    private static final BlockState LEAVES = Blocks.SPRUCE_LEAVES.getDefaultState();
    private static final BlockState BEENEST = Blocks.BEE_NEST.getDefaultState();

    public BorealForestTree2(Function<Dynamic<?>, ? extends NoFeatureConfig> configIn) {
        super(configIn);
    }

    protected static boolean canTreeReplace(IWorldGenerationBaseReader genBaseReader, BlockPos blockPos) {
        return canTreePlaceHere(
                genBaseReader, blockPos
        );
    }

    protected static boolean isDirtOrPeatBlock(IWorldGenerationBaseReader worldIn, BlockPos pos, IPlantable sapling) {
        return worldIn.hasBlockState(pos, (p_214582_0_) -> {
            Block block = p_214582_0_.getBlock();
            return Feature.isDirt(block) || block == BYGBlockList.PEAT;
        });
    }

    public boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos position, MutableBoundingBox boundsIn) {
        //This sets heights for trees. Rand.nextint allows for tree height randomization. The final int value sets the minimum for tree Height.
        int randTreeHeight = rand.nextInt(2) + rand.nextInt(2) + 11;
        //Positions
        int posX = position.getX();
        int posY = position.getY();
        int posZ = position.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < 256) {
            BlockPos blockpos = position.down();
            if (!isDirtOrPeatBlock(worldIn, blockpos, getSapling())) {
                return false;
            } else if (!this.doesTreeFit(worldIn, position, randTreeHeight)) {
                return false;
            } else {
                //Places dirt under logs where/when necessary.
                this.setGroundBlockAt(worldIn, blockpos, position, Blocks.DIRT.getDefaultState());
                Direction direction = Direction.Plane.HORIZONTAL.random(rand);
                int randTreeHeight2 = randTreeHeight - rand.nextInt(1);//Crashes on 0.
                int posY1 = 2 - rand.nextInt(1);//Crashes on 0.
                int posX1 = posX;
                int posZ1 = posZ;
                int topTrunkHeight = posY + randTreeHeight - 1;

                //Raising the 'groundUpLogRemover'  will remove all log blocks from the ground up no matter how thick the trunk is based on the value given. 5 would destroy all trunks from 5 up off the ground.
                for (int groundUpLogRemover = 0; groundUpLogRemover < randTreeHeight; ++groundUpLogRemover) {
                    if (groundUpLogRemover >= randTreeHeight2 && posY1 < 0) { //Unknown
                        posX1 += direction.getXOffset();
                        posZ1 += direction.getZOffset();
                        ++posY1;
                    }
                    //This Int is responsible for the Y coordinate of the trunk BlockPos'.
                    int logplacer = posY + groundUpLogRemover;
                    BlockPos blockpos1 = new BlockPos(posX1, logplacer, posZ1);
                    //These BlockPos' allow you to make trunks thicker than 2x2,
                    BlockPos blockposwest1 = new BlockPos(posX1 - 1, logplacer, posZ1);
                    BlockPos blockposnorth1 = new BlockPos(posX1, logplacer, posZ1 - 1);
                    BlockPos blockposnorthwest1 = new BlockPos(posX1 - 1, logplacer, posZ1 - 1);


                    //Sets Logs

                    this.treelog(changedBlocks, worldIn, blockpos1, boundsIn);


                }
                //This allows a random rotation between 3 differently leave Presets in the same class. Optimizes Performance instead of the loading of several classes.
                int leavePreset = rand.nextInt(1) + 1;
                int leaveRandomizer = rand.nextInt(10) + 1;
                int leaveRandomizer2 = rand.nextInt(65) + 1;
                int leaveRandomizer3 = rand.nextInt(4) + 1;
                int leaveRandomizer4 = rand.nextInt(25) + 17;
                int leaveRandomizer5 = rand.nextInt(2) + 1;


                int tHSub7 = 7;
                int tHSub8 = 8;
                int tHSub6 = 6;
                int tHSub4 = 4;
                int tHSub5 = 5;
                int tHSub3 = 3;
                int tHSub2 = 2;
                int tHSub1 = 1;
                {
                    if (leavePreset == 1) {
                        int leavessquarespos = 1;
                        for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                            for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub8, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub8, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - tHSub8, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - tHSub8, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - tHSub8, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - tHSub8, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - tHSub8, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - tHSub8, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub8, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub8, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub8, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub8, posZ1 + 1, boundsIn, changedBlocks);

                                if (leaveRandomizer <= 4) {
                                    this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub7, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub7, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub7, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight - tHSub7, posZ1 - 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight - tHSub7, posZ1 + 2, boundsIn, changedBlocks);
                                } else if (leaveRandomizer > 5) {
                                    this.leafs(worldIn, posX1 + 1, topTrunkHeight - tHSub7, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 1, topTrunkHeight - tHSub7, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight - tHSub7, posZ1 - 1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight - tHSub7, posZ1 + 1, boundsIn, changedBlocks);
                                }
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub6, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub6, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub6, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - tHSub6, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - tHSub6, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - tHSub6, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - tHSub6, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - tHSub6, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - tHSub6, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub6, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub6, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub6, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub6, posZ1 + 1, boundsIn, changedBlocks);

                                if (leaveRandomizer2 <= 40) {

                                    this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub5, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub5, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub5, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight - tHSub5, posZ1 - 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight - tHSub5, posZ1 + 2, boundsIn, changedBlocks);
                                } else if (leaveRandomizer2 < 60) {
                                    this.leafs(worldIn, posX1 + 1, topTrunkHeight - tHSub5, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 1, topTrunkHeight - tHSub5, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight - tHSub5, posZ1 - 1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight - tHSub5, posZ1 + 1, boundsIn, changedBlocks);
                                }
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub4, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub4, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - tHSub4, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - tHSub4, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - tHSub4, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - tHSub4, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - tHSub4, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - tHSub4, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub4, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub4, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub4, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub4, posZ1 + 1, boundsIn, changedBlocks);

                                if (leaveRandomizer3 == 1) {
                                    this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub3, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub3, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub3, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight - tHSub3, posZ1 - 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight - tHSub3, posZ1 + 2, boundsIn, changedBlocks);
                                } else if (leaveRandomizer3 == 2) {
                                    this.leafs(worldIn, posX1 + 1, topTrunkHeight - tHSub2, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 1, topTrunkHeight - tHSub2, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight - tHSub2, posZ1 - 1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight - tHSub2, posZ1 + 1, boundsIn, changedBlocks);
                                }
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - tHSub1, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - tHSub1, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - tHSub1, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - tHSub1, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - tHSub1, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - tHSub1, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub1, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub1, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub1, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub1, posZ1 + 1, boundsIn, changedBlocks);

                                if (leaveRandomizer4 < 17) {
                                    this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 2, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 2, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight, posZ1 + 2, boundsIn, changedBlocks);
                                } else if (leaveRandomizer4 > 19) {
                                    this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                }
                                if (leaveRandomizer5 == 1) {
                                    this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                } else if (leaveRandomizer5 == 2) {
                                    this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight + 2, posZ1 - 1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight + 2, posZ1 + 1, boundsIn, changedBlocks);

                                }
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

    private boolean doesTreeFit(IWorldGenerationBaseReader reader, BlockPos blockPos, int height) {
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        BlockPos.Mutable position = new BlockPos.Mutable();

        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
            //Distance/Density of trees. Positive Values ONLY
            int distance = 2;

            for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
                for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
                    if (!canTreeReplace(reader, position.setPos(x + xOffset, y + yOffset, z + zOffset))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //Log Placement
    private void treelog(Set<BlockPos> setlogblock, IWorldGenerationReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canTreeReplace(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, LOG, boundingBox);
        }

    }

    //Leaves Placement
    private void leafs(IWorldGenerationReader reader, int x, int y, int z, MutableBoundingBox boundingBox, Set<BlockPos> blockPos) {
        BlockPos blockpos = new BlockPos(x, y, z);
        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos, LEAVES, boundingBox);
        }

    }
}