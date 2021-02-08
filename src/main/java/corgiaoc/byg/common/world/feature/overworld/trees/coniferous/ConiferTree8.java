package corgiaoc.byg.common.world.feature.overworld.trees.coniferous;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGTreeConfig;
import corgiaoc.byg.common.world.feature.overworld.trees.util.BYGAbstractTreeFeature;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;

import java.util.Random;
import java.util.Set;

public class ConiferTree8 extends BYGAbstractTreeFeature<BYGTreeConfig> {

    public ConiferTree8(Codec<BYGTreeConfig> configIn) {
        super(configIn);
    }

    public boolean generate(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeConfig config) {

        BlockState LEAVES = config.getLeavesProvider().getBlockState(rand, pos);//This sets heights for trees. Rand.nextint allows for tree height randomization. The final int value sets the minimum for tree Height.
        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        //Positions
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < worldIn.getHeight()) {
            BlockPos checkGround = pos.down();
            if (!isDesiredGroundwDirtTag(worldIn, checkGround, config)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, randTreeHeight - 10, 5, 5, 5, 5, isSapling)) {
                return false;
            } else {
                buildTrunkBase(pos, changedBlocks, worldIn, config, rand, boundsIn, pos, pos.west(), pos.south(), pos.south().west());


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
                    placeTrunk(config, rand, changedBlocks, worldIn, trunkPos1, boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, trunkPos1.west(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, trunkPos1.south(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, trunkPos1.south().west(), boundsIn);

                }
                for (int posXLeafSize = 0; posXLeafSize <= 1; ++posXLeafSize) {
                    for (int posZLeafSize = 0; posZLeafSize <= 1; ++posZLeafSize) {
                        int posX3 = posX2 + posXLeafSize - 1;
                        int posZ3 = posZ2 + posZLeafSize;

                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight + 2, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 1, topTrunkHeight + 1, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 1, topTrunkHeight + 1, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight + 1, posZ3 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight + 1, posZ3 + 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX3 + 1, topTrunkHeight - 1, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 1, topTrunkHeight - 1, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight - 1, posZ3 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight - 1, posZ3 + 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX3 + 2, topTrunkHeight - 2, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 2, topTrunkHeight - 2, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight - 2, posZ3 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight - 2, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 1, topTrunkHeight - 2, posZ3 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 1, topTrunkHeight - 2, posZ3 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 1, topTrunkHeight - 2, posZ3 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 1, topTrunkHeight - 2, posZ3 - 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX3 + 3, topTrunkHeight - 3, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 3, topTrunkHeight - 3, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight - 3, posZ3 - 3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight - 3, posZ3 + 3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 2, topTrunkHeight - 3, posZ3 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 2, topTrunkHeight - 3, posZ3 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 2, topTrunkHeight - 3, posZ3 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 2, topTrunkHeight - 3, posZ3 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 1, topTrunkHeight - 3, posZ3 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 1, topTrunkHeight - 3, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 1, topTrunkHeight - 3, posZ3 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 1, topTrunkHeight - 3, posZ3 + 2, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX3 + 2, topTrunkHeight - 4, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 2, topTrunkHeight - 4, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight - 4, posZ3 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight - 4, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 1, topTrunkHeight - 4, posZ3 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 1, topTrunkHeight - 4, posZ3 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 1, topTrunkHeight - 4, posZ3 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 1, topTrunkHeight - 4, posZ3 - 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX3 + 2, topTrunkHeight - 5, posZ3 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 2, topTrunkHeight - 5, posZ3 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 2, topTrunkHeight - 5, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 2, topTrunkHeight - 5, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 2, topTrunkHeight - 5, posZ3 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 2, topTrunkHeight - 5, posZ3 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 2, topTrunkHeight - 5, posZ3 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 2, topTrunkHeight - 5, posZ3 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 1, topTrunkHeight - 5, posZ3 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 1, topTrunkHeight - 5, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 1, topTrunkHeight - 5, posZ3 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 1, topTrunkHeight - 5, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 3, topTrunkHeight - 5, posZ3 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 3, topTrunkHeight - 5, posZ3 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 3, topTrunkHeight - 5, posZ3 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 3, topTrunkHeight - 5, posZ3 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 1, topTrunkHeight - 5, posZ3 - 3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 1, topTrunkHeight - 5, posZ3 + 3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 1, topTrunkHeight - 5, posZ3 - 3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 1, topTrunkHeight - 5, posZ3 + 3, boundsIn, changedBlocks);


                        placeLeaves(config, rand, worldIn, posX3 + 2, topTrunkHeight - 6, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 2, topTrunkHeight - 6, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight - 6, posZ3 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight - 6, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 1, topTrunkHeight - 6, posZ3 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 1, topTrunkHeight - 6, posZ3 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 1, topTrunkHeight - 6, posZ3 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 1, topTrunkHeight - 6, posZ3 - 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX3 + 2, topTrunkHeight - 7, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 2, topTrunkHeight - 7, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight - 7, posZ3 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight - 7, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 3, topTrunkHeight - 7, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 3, topTrunkHeight - 7, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight - 7, posZ3 - 3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight - 7, posZ3 + 3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 3, topTrunkHeight - 7, posZ3 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 3, topTrunkHeight - 7, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 2, topTrunkHeight - 7, posZ3 - 3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 2, topTrunkHeight - 7, posZ3 + 3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 3, topTrunkHeight - 7, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 3, topTrunkHeight - 7, posZ3 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 2, topTrunkHeight - 7, posZ3 - 3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 2, topTrunkHeight - 7, posZ3 + 3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 1, topTrunkHeight - 7, posZ3 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 1, topTrunkHeight - 7, posZ3 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 1, topTrunkHeight - 7, posZ3 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 1, topTrunkHeight - 7, posZ3 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 4, topTrunkHeight - 7, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 4, topTrunkHeight - 7, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight - 7, posZ3 - 4, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight - 7, posZ3 + 4, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX3 + 2, topTrunkHeight - 8, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 2, topTrunkHeight - 8, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight - 8, posZ3 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight - 8, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 1, topTrunkHeight - 8, posZ3 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 1, topTrunkHeight - 8, posZ3 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 1, topTrunkHeight - 8, posZ3 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 1, topTrunkHeight - 8, posZ3 - 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX3 + 2, topTrunkHeight - 9, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 2, topTrunkHeight - 9, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight - 9, posZ3 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight - 9, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 2, topTrunkHeight - 9, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 2, topTrunkHeight - 9, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 2, topTrunkHeight - 9, posZ3 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 2, topTrunkHeight - 9, posZ3 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 4, topTrunkHeight - 9, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 4, topTrunkHeight - 9, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight - 9, posZ3 - 4, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight - 9, posZ3 + 4, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 4, topTrunkHeight - 9, posZ3 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 4, topTrunkHeight - 9, posZ3 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 2, topTrunkHeight - 9, posZ3 - 4, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 2, topTrunkHeight - 9, posZ3 + 4, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 4, topTrunkHeight - 9, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 4, topTrunkHeight - 9, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 2, topTrunkHeight - 9, posZ3 - 4, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 2, topTrunkHeight - 9, posZ3 + 4, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX3 + 2, topTrunkHeight - 10, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 2, topTrunkHeight - 10, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight - 10, posZ3 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight - 10, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 1, topTrunkHeight - 10, posZ3 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 1, topTrunkHeight - 10, posZ3 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 1, topTrunkHeight - 10, posZ3 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 1, topTrunkHeight - 10, posZ3 - 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX3 + 2, topTrunkHeight - 11, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 2, topTrunkHeight - 11, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight - 11, posZ3 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight - 11, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 2, topTrunkHeight - 11, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 2, topTrunkHeight - 11, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 2, topTrunkHeight - 11, posZ3 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 2, topTrunkHeight - 11, posZ3 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 4, topTrunkHeight - 11, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 4, topTrunkHeight - 11, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight - 11, posZ3 - 4, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight - 11, posZ3 + 4, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 4, topTrunkHeight - 11, posZ3 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 4, topTrunkHeight - 11, posZ3 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 2, topTrunkHeight - 11, posZ3 - 4, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 2, topTrunkHeight - 11, posZ3 + 4, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 4, topTrunkHeight - 11, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 4, topTrunkHeight - 11, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 2, topTrunkHeight - 11, posZ3 - 4, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 2, topTrunkHeight - 11, posZ3 + 4, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 5, topTrunkHeight - 11, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 5, topTrunkHeight - 11, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight - 11, posZ3 - 5, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight - 11, posZ3 + 5, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX3 + 2, topTrunkHeight - 12, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 2, topTrunkHeight - 12, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight - 12, posZ3 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3, topTrunkHeight - 12, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 1, topTrunkHeight - 12, posZ3 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 1, topTrunkHeight - 12, posZ3 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 1, topTrunkHeight - 12, posZ3 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 1, topTrunkHeight - 12, posZ3 - 1, boundsIn, changedBlocks);

                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}