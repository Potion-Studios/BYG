package voronoiaoc.byg.common.world.feature.features.overworld.trees.baobab;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;

public class BaobabTree1 extends BYGAbstractTreeFeature<DefaultFeatureConfig> {


    public BaobabTree1(Codec<DefaultFeatureConfig> configIn) {
        super(configIn);
    }



    public boolean place(Set<BlockPos> changedBlocks, ServerWorldAccess worldIn, Random rand, BlockPos position, BlockBox boundsIn) {
        int randTreeHeight = rand.nextInt(9) + 20;
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
        int posX = position.getX();
        int posY = position.getY();
        int posZ = position.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < 256) {
            BlockPos posDown = position.down();
            if (!isDesiredGround(worldIn, posDown, Blocks.GRASS_BLOCK)) {
                return false;
            }
            if (!this.doesTreeFit(worldIn, position, randTreeHeight, 5)) {
                return false;
            } else {
                Direction direction = Direction.Type.HORIZONTAL.random(rand);
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
                    if (buildTrunk >= randTreeHeight2 && posY1 < 0) { //Unknown
                        posX1 += direction.getOffsetX();
                        posZ1 += direction.getOffsetZ();
                        ++posY1;
                    }

                    int logplacerY = posY + buildTrunk;
                    int topTreeHeight = posY + randTreeHeight - 1;

                    BlockPos blockpos1 = new BlockPos(posX1, logplacerY, posZ1);
                    BlockPos blockpos2 = new BlockPos(posX1, topTreeHeight, posZ1);

                    this.treelog(changedBlocks, worldIn, blockpos1, boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos1.north(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos1.north().west(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos1.west(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos1.north(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos1.north(2).west(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos1.north().west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos1.west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos1.east(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos1.north().east(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos1.south().west(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos1.south(), boundsIn);

                    if (buildTrunk <= randCorner1)
                        this.treelog(changedBlocks, worldIn, blockpos1.south().east(), boundsIn);
                    if (buildTrunk <= randCorner2)
                        this.treelog(changedBlocks, worldIn, blockpos1.south().west(2), boundsIn);
                    if (buildTrunk <= randCorner3)
                        this.treelog(changedBlocks, worldIn, blockpos1.north(2).east(), boundsIn);
                    if (buildTrunk <= randCorner4)
                        this.treelog(changedBlocks, worldIn, blockpos1.north(2).west(2), boundsIn);

                    if (buildTrunk <= randOuterEdge)
                        this.treelog(changedBlocks, worldIn, blockpos1.north(3), boundsIn);
                    if (buildTrunk <= randOuterEdge2)
                        this.treelog(changedBlocks, worldIn, blockpos1.north(3).west(), boundsIn);
                    if (buildTrunk <= randOuterEdge3)
                        this.treelog(changedBlocks, worldIn, blockpos1.east(2), boundsIn);
                    if (buildTrunk <= randOuterEdge4)
                        this.treelog(changedBlocks, worldIn, blockpos1.east(2).north(), boundsIn);
                    if (buildTrunk <= randOuterEdge5)
                        this.treelog(changedBlocks, worldIn, blockpos1.south(2).west(), boundsIn);
                    if (buildTrunk <= randOuterEdge6)
                        this.treelog(changedBlocks, worldIn, blockpos1.south(2), boundsIn);
                    if (buildTrunk <= randOuterEdge7)
                        this.treelog(changedBlocks, worldIn, blockpos1.west(3), boundsIn);
                    if (buildTrunk <= randOuterEdge8)
                        this.treelog(changedBlocks, worldIn, blockpos1.west(3).north(), boundsIn);

                    this.treelog(changedBlocks, worldIn, blockpos2.east().up(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.east(2).up(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north().east().up(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north().east(2).up(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north().east(2).up(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north().east(2).up(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north(2).east(3).up(4), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north(2).east(3).up(5), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north(2).east(3).up(6), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.south().east(3).up(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.south().east(4).up(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.south().east(5).up(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.south().east(5).up(3), boundsIn);

                    this.treelog(changedBlocks, worldIn, blockpos2.south().west().up(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.south(2).west(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.south(2).west().up(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.south(2).west(2).up(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.south(3).up(2), boundsIn);

                    this.treelog(changedBlocks, worldIn, blockpos2.south(3).up(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.south(4).up(3).east(), boundsIn);

                    this.treelog(changedBlocks, worldIn, blockpos2.south(3).up(2).west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.south(4).up(2).west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.south(5).up(3).west(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.south(5).up(4).west(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.south(3).up(3).west(3), boundsIn);

                    this.treelog(changedBlocks, worldIn, blockpos2.west().up(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.west().up(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.west(3).up(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.west(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.west(4).south().up(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.west(5).up(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.west(6).up(3), boundsIn);

                    this.treelog(changedBlocks, worldIn, blockpos2.west(7).up(4).south(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.west(7).up(5).south(), boundsIn);
//                    this.treelog(changedBlocks, worldIn, blockpos2.west(7).up(6).south(), boundsIn);


                    this.treelog(changedBlocks, worldIn, blockpos2.north().up(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north().up(2), boundsIn);
//                    this.treelog(changedBlocks, worldIn, blockpos2.north().up(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north(3).up(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north(3).up(4), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north(3).up(5), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north(6).up(3), boundsIn);

                    this.treelog(changedBlocks, worldIn, blockpos2.north(4).west().up(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north(5).west().up(2), boundsIn);

                    this.treelog(changedBlocks, worldIn, blockpos2.north(3).west(2).up(1), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north(3).west(3).up(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north(2).west(4).up(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north(3).west(5).up(4), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north(3).west(5).up(5), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north(3).west(5).up(6), boundsIn);


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

                        this.leafs(worldIn, posX2 + posXLeafWidth, topTrunkHeight2, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX3 + posXLeafWidth, topTrunkHeight3, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX4 + posXLeafWidth, topTrunkHeight4, posZ4 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX5 + posXLeafWidth, topTrunkHeight5, posZ5 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX7 + posXLeafWidth, topTrunkHeight7, posZ7 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX8 + posXLeafWidth, topTrunkHeight8, posZ8 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX9 + posXLeafWidth, topTrunkHeight9, posZ9 + posZLeafWidthL0, boundsIn, changedBlocks);


                        if (posXLeafWidth <= 1 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {
                            this.leafs(worldIn, posX2 + posXLeafWidth, topTrunkHeight2, posZ2 + posZLeafWidthL0 - 2, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX2 + posXLeafWidth, topTrunkHeight2, posZ2 + posZLeafWidthL0 + 2, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX2 + posXLeafWidth + 2, topTrunkHeight2, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX2 + posXLeafWidth - 2, topTrunkHeight2, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX2 + posXLeafWidth, topTrunkHeight2 + 1, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);

                            this.leafs(worldIn, posX3 + posXLeafWidth + 2, topTrunkHeight3, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX3 + posXLeafWidth - 2, topTrunkHeight3, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX3 + posXLeafWidth, topTrunkHeight3, posZ3 + posZLeafWidthL0 + 2, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX3 + posXLeafWidth, topTrunkHeight3, posZ3 + posZLeafWidthL0 - 2, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX3 + posXLeafWidth, topTrunkHeight3 + 1, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);

                            this.leafs(worldIn, posX4 + posXLeafWidth + 2, topTrunkHeight4, posZ4 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX4 + posXLeafWidth - 2, topTrunkHeight4, posZ4 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX4 + posXLeafWidth, topTrunkHeight4, posZ4 + posZLeafWidthL0 + 2, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX4 + posXLeafWidth, topTrunkHeight4, posZ4 + posZLeafWidthL0 - 2, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX4 + posXLeafWidth, topTrunkHeight4 + 1, posZ4 + posZLeafWidthL0, boundsIn, changedBlocks);

                            this.leafs(worldIn, posX5 + posXLeafWidth - 2, topTrunkHeight5, posZ5 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX5 + posXLeafWidth + 2, topTrunkHeight5, posZ5 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX5 + posXLeafWidth, topTrunkHeight5, posZ5 + posZLeafWidthL0 + 2, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX5 + posXLeafWidth, topTrunkHeight5, posZ5 + posZLeafWidthL0 - 2, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX5 + posXLeafWidth, topTrunkHeight5 + 1, posZ5 + posZLeafWidthL0, boundsIn, changedBlocks);

                            this.leafs(worldIn, posX6 + posXLeafWidth, topTrunkHeight6, posZ6 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX6 + posXLeafWidth - 1, topTrunkHeight6, posZ6 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX6 + posXLeafWidth + 1, topTrunkHeight6, posZ6 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX6 + posXLeafWidth, topTrunkHeight6, posZ6 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX6 + posXLeafWidth, topTrunkHeight6, posZ6 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);

                            this.leafs(worldIn, posX7 + posXLeafWidth, topTrunkHeight7, posZ7 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX7 + posXLeafWidth - 2, topTrunkHeight7, posZ7 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX7 + posXLeafWidth + 2, topTrunkHeight7, posZ7 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX7 + posXLeafWidth, topTrunkHeight7, posZ7 + posZLeafWidthL0 - 2, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX7 + posXLeafWidth, topTrunkHeight7, posZ7 + posZLeafWidthL0 + 2, boundsIn, changedBlocks);

                            this.leafs(worldIn, posX8 + posXLeafWidth, topTrunkHeight8 + 1, posZ8 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX8 + posXLeafWidth + 1, topTrunkHeight8 + 1, posZ8 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX8 + posXLeafWidth - 1, topTrunkHeight8 + 1, posZ8 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX8 + posXLeafWidth, topTrunkHeight8 + 1, posZ8 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX8 + posXLeafWidth, topTrunkHeight8 + 1, posZ8 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX8 + posXLeafWidth - 2, topTrunkHeight8, posZ8 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX8 + posXLeafWidth + 2, topTrunkHeight8, posZ8 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX8 + posXLeafWidth, topTrunkHeight8, posZ8 + posZLeafWidthL0 - 2, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX8 + posXLeafWidth, topTrunkHeight8, posZ8 + posZLeafWidthL0 + 2, boundsIn, changedBlocks);

                            this.leafs(worldIn, posX9 + posXLeafWidth, topTrunkHeight9, posZ9 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX9 + posXLeafWidth - 2, topTrunkHeight9, posZ9 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX9 + posXLeafWidth + 2, topTrunkHeight9, posZ9 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX9 + posXLeafWidth, topTrunkHeight9, posZ9 + posZLeafWidthL0 - 2, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX9 + posXLeafWidth, topTrunkHeight9, posZ9 + posZLeafWidthL0 + 2, boundsIn, changedBlocks);

                        }

                        this.leafs(worldIn, posX2, topTrunkHeight2 + 1, posZ2 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2, topTrunkHeight2 + 1, posZ2 - 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 + 2, topTrunkHeight2 + 1, posZ2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 - 2, topTrunkHeight2 + 1, posZ2, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX3, topTrunkHeight3 + 1, posZ3 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX3, topTrunkHeight3 + 1, posZ3 - 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX3 + 2, topTrunkHeight3 + 1, posZ3, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX3 - 2, topTrunkHeight3 + 1, posZ3, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX4, topTrunkHeight4 + 1, posZ4 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX4, topTrunkHeight4 + 1, posZ4 - 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX4 + 2, topTrunkHeight4 + 1, posZ4, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX4 - 2, topTrunkHeight4 + 1, posZ4, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX5, topTrunkHeight5 + 1, posZ5 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX5, topTrunkHeight5 + 1, posZ5 - 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX5 + 2, topTrunkHeight5 + 1, posZ5, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX5 - 2, topTrunkHeight5 + 1, posZ5, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX6, topTrunkHeight6 + 1, posZ6 + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX6, topTrunkHeight6 + 1, posZ6 - 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX6 + 1, topTrunkHeight6 + 1, posZ6, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX6 - 1, topTrunkHeight6 + 1, posZ6, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX6, topTrunkHeight6 + 1, posZ6, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX7, topTrunkHeight7 + 1, posZ7 + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX7, topTrunkHeight7 + 1, posZ7 - 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX7 + 1, topTrunkHeight7 + 1, posZ7, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX7 - 1, topTrunkHeight7 + 1, posZ7, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX7, topTrunkHeight7 + 1, posZ7, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX7, topTrunkHeight7 - 1, posZ7 + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX7, topTrunkHeight7 - 1, posZ7 - 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX7 + 1, topTrunkHeight7 - 1, posZ7, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX7 - 1, topTrunkHeight7 - 1, posZ7, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX7, topTrunkHeight7 - 1, posZ7, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX9, topTrunkHeight9 + 1, posZ9 + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX9, topTrunkHeight9 + 1, posZ9 - 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX9 + 1, topTrunkHeight9 + 1, posZ9, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX9 - 1, topTrunkHeight9 + 1, posZ9, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX9, topTrunkHeight9 + 1, posZ9, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX9, topTrunkHeight9 - 1, posZ9 + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX9, topTrunkHeight9 - 1, posZ9 - 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX9, topTrunkHeight9 - 2, posZ9 - 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX9 + 1, topTrunkHeight9 - 1, posZ9, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX9 - 1, topTrunkHeight9 - 1, posZ9, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX9, topTrunkHeight9 - 1, posZ9, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX10, topTrunkHeight10, posZ10 + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX10, topTrunkHeight10, posZ10 - 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX10 + 1, topTrunkHeight10, posZ10, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX10 - 1, topTrunkHeight10, posZ10, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX10, topTrunkHeight10 + 1, posZ10, boundsIn, changedBlocks);

                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }

    private void treelog(Set<BlockPos> setlogblock, ServerWorldAccess reader, BlockPos pos, BlockBox boundingBox) {
        if (canTreePlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.BAOBAB_LOG.getDefaultState(), boundingBox);
        }

    }

    //Leaves Placement
    private void leafs(ServerWorldAccess reader, int x, int y, int z, BlockBox boundingBox, Set<BlockPos> blockPos) {
        BlockPos blockpos = new BlockPos(x, y, z);
        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos, BYGBlockList.BAOBAB_LEAVES.getDefaultState(), boundingBox);
        }

    }
}