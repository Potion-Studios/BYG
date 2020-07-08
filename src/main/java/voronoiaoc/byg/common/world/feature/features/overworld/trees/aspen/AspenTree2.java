package voronoiaoc.byg.common.world.feature.features.overworld.trees.aspen;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBiomeList;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;

public class AspenTree2 extends BYGAbstractTreeFeature<DefaultFeatureConfig> {

    public AspenTree2(Codec<DefaultFeatureConfig> configIn) {
        super(configIn);
    }

    public boolean place(Set<BlockPos> changedBlocks, ServerWorldAccess worldIn, Random rand, BlockPos position, BlockBox boundsIn) {
        int minHeight = 12;
        Biome biome = worldIn.getBiome(position);
        if (biome == BYGBiomeList.ASPENFORESTHILLS)
            minHeight = 17;
        int randTreeHeight = rand.nextInt(4) + minHeight;
        int posX = position.getX();
        int posY = position.getY();
        int posZ = position.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < 256) {
            BlockPos blockpos = position.down();
            if (!isDesiredGroundwDirtTag(worldIn, blockpos, Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.doesTreeFit(worldIn, position, randTreeHeight, 2)) {
                return false;
            } else {

                Direction direction = Direction.Type.HORIZONTAL.random(rand);
                int randTreeHeight2 = randTreeHeight - rand.nextInt(1);
                int posY1 = 2 - rand.nextInt(1);
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
                    int logplacer2 = posY + randTreeHeight;
                    BlockPos blockpos1 = new BlockPos(posX1, logplacer, posZ1);
                    BlockPos blockpos2 = new BlockPos(posX1, logplacer2, posZ1);

                    //Sets Logs
                    this.placeLog(changedBlocks, worldIn, blockpos1, boundsIn);
                    this.placeLog(changedBlocks, worldIn, blockpos2.down(7).north().west(), boundsIn);
                    this.placeLog(changedBlocks, worldIn, blockpos2.down(7).west(2), boundsIn);
                    this.placeLog(changedBlocks, worldIn, blockpos2.down(6).north().west(3), boundsIn);
                    this.placeLog(changedBlocks, worldIn, blockpos2.down(4).south(), boundsIn);
                    this.placeLog(changedBlocks, worldIn, blockpos2.down(10).east(), boundsIn);
                }

                int leavessquarespos = 2;
                for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                    for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                        int posX2 = posX1 - 3;
                        int posZ2 = posZ1 - 1;

                        //3x3
                        if (posXLeafWidth <= 1 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {

                            this.placeLeaf(worldIn, posX2 + posXLeafWidth, topTrunkHeight - 5, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);
                        }

                        this.placeLeaf(worldIn, posX1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);

                        this.placeLeaf(worldIn, posX1 - 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX1 - 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX1 - 1, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX1 - 1, topTrunkHeight - 2, posZ1, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX1 - 1, topTrunkHeight - 9, posZ1, boundsIn, changedBlocks);

                        this.placeLeaf(worldIn, posX1 + 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX1 + 1, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX1 + 1, topTrunkHeight - 5, posZ1, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX1 + 1, topTrunkHeight - 8, posZ1, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX1 + 1, topTrunkHeight - 10, posZ1, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX1 + 1, topTrunkHeight - 9, posZ1, boundsIn, changedBlocks);

                        this.placeLeaf(worldIn, posX1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX1, topTrunkHeight - 1, posZ1 - 1, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX1, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX1, topTrunkHeight - 6, posZ1 - 1, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX1, topTrunkHeight - 11, posZ1 - 1, boundsIn, changedBlocks);

                        this.placeLeaf(worldIn, posX1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX1, topTrunkHeight - 2, posZ1 + 1, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX1, topTrunkHeight - 3, posZ1 + 2, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX1, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX1, topTrunkHeight - 7, posZ1 + 1, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX1, topTrunkHeight - 10, posZ1 + 1, boundsIn, changedBlocks);

                        this.placeLeaf(worldIn, posX1 + 1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX1 + 1, topTrunkHeight - 9, posZ1 + 1, boundsIn, changedBlocks);

                        this.placeLeaf(worldIn, posX1 - 1, topTrunkHeight - 2, posZ1 - 1, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX1 - 1, topTrunkHeight - 7, posZ1 - 1, boundsIn, changedBlocks);

                        this.placeLeaf(worldIn, posX1 + 1, topTrunkHeight - 1, posZ1 - 1, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX1 + 1, topTrunkHeight - 2, posZ1 - 1, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX1 + 1, topTrunkHeight - 9, posZ1 - 1, boundsIn, changedBlocks);

                        this.placeLeaf(worldIn, posX1 - 1, topTrunkHeight - 1, posZ1 + 1, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);

                        //Bottom Leaves
                        this.placeLeaf(worldIn, posX2 + 1, topTrunkHeight - 6, posZ2, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX2 + 2, topTrunkHeight - 6, posZ2, boundsIn, changedBlocks);

                        this.placeLeaf(worldIn, posX2, topTrunkHeight - 6, posZ2 + 1, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX2, topTrunkHeight - 6, posZ2 + 2, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX2, topTrunkHeight - 5, posZ2 + 2, boundsIn, changedBlocks);

                        this.placeLeaf(worldIn, posX2 - 1, topTrunkHeight - 6, posZ2, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX2 - 2, topTrunkHeight - 6, posZ2, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX2 - 2, topTrunkHeight - 5, posZ2, boundsIn, changedBlocks);

                        this.placeLeaf(worldIn, posX2, topTrunkHeight - 5, posZ2 - 2, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX2, topTrunkHeight - 6, posZ2 - 2, boundsIn, changedBlocks);

                        this.placeLeaf(worldIn, posX2 + 1, topTrunkHeight - 5, posZ2 - 1, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX2 + 1, topTrunkHeight - 6, posZ2 - 1, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX2 + 2, topTrunkHeight - 5, posZ2 - 1, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX2 + 1, topTrunkHeight - 6, posZ2 - 2, boundsIn, changedBlocks);

                        this.placeLeaf(worldIn, posX2 - 1, topTrunkHeight - 5, posZ2 - 1, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX2 - 1, topTrunkHeight - 5, posZ2 - 2, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX2 - 2, topTrunkHeight - 6, posZ2 - 1, boundsIn, changedBlocks);

                        this.placeLeaf(worldIn, posX2 - 1, topTrunkHeight - 5, posZ2 + 1, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX2 - 2, topTrunkHeight - 5, posZ2 + 1, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX2 - 1, topTrunkHeight - 5, posZ2 + 2, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX2 - 1, topTrunkHeight - 6, posZ2 + 1, boundsIn, changedBlocks);

                        this.placeLeaf(worldIn, posX2 + 1, topTrunkHeight - 5, posZ2 + 1, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX2 + 1, topTrunkHeight - 5, posZ2 + 2, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX2 + 1, topTrunkHeight - 6, posZ2 + 2, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX2 + 2, topTrunkHeight - 6, posZ2 + 2, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX2 + 2, topTrunkHeight - 5, posZ2 + 1, boundsIn, changedBlocks);


                        this.placeLeaf(worldIn, posX2, topTrunkHeight - 2, posZ2, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX2, topTrunkHeight - 3, posZ2, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX2, topTrunkHeight - 4, posZ2, boundsIn, changedBlocks);

                        this.placeLeaf(worldIn, posX2, topTrunkHeight - 4, posZ2 + 1, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX2 - 1, topTrunkHeight - 4, posZ2, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX2 + 1, topTrunkHeight - 4, posZ2, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX2 + 1, topTrunkHeight - 3, posZ2, boundsIn, changedBlocks);
                        this.placeLeaf(worldIn, posX2, topTrunkHeight - 4, posZ2 - 1, boundsIn, changedBlocks);
                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }

    //Log Placement
    private void placeLog(Set<BlockPos> setlogblock, ServerWorldAccess reader, BlockPos pos, BlockBox boundingBox) {
        if (canTreePlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.ASPEN_LOG.getDefaultState(), boundingBox);
        }

    }

    //Leaves Placement
    private void placeLeaf(ServerWorldAccess reader, int x, int y, int z, BlockBox boundingBox, Set<BlockPos> blockPos) {
        BlockPos blockpos = new BlockPos(x, y, z);
        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos, BYGBlockList.ASPEN_LEAVES.getDefaultState(), boundingBox);
        }
    }
}