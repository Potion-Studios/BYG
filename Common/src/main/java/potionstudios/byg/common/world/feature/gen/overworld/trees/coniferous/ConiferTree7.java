package potionstudios.byg.common.world.feature.gen.overworld.trees.coniferous;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import potionstudios.byg.common.world.feature.config.BYGTreeConfig;
import potionstudios.byg.common.world.feature.gen.overworld.trees.util.BYGAbstractTreeFeature;

import java.util.Random;
import java.util.Set;

public class ConiferTree7 extends BYGAbstractTreeFeature<BYGTreeConfig> {

    public ConiferTree7(Codec<BYGTreeConfig> configIn) {
        super(configIn);
    }

    public boolean generate(Set<BlockPos> changedBlocks, WorldGenLevel worldIn, Random rand, BlockPos pos, BoundingBox boundsIn, boolean isSapling, BYGTreeConfig config) {

        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        //Positions
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {
            BlockPos checkGround = pos.below();
            if (!isDesiredGroundwDirtTag(worldIn, checkGround, config)) {
                return false;
            } else {

                Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(rand);
                int randTreeHeight2 = randTreeHeight - rand.nextInt(1);
                int posY2 = 2 - rand.nextInt(1);
                int posX2 = posX;
                int posZ2 = posZ;
                int topTrunkHeight = posY + randTreeHeight - 1;

                for (int trunkBottom = 0; trunkBottom < randTreeHeight; ++trunkBottom) {
                    if (trunkBottom >= randTreeHeight2 && posY2 < 0) {
                        posX2 += direction.getStepX();
                        posZ2 += direction.getStepZ();
                        ++posY2;
                    }
                    int logplacer = posY + trunkBottom;


                    BlockPos trunkPos1 = new BlockPos(posX2, logplacer, posZ2);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, trunkPos1, boundsIn);

                }
                for (int posXLeafSize = -1; posXLeafSize <= 1; ++posXLeafSize) {
                    for (int posZLeafSize = -1; posZLeafSize <= 1; ++posZLeafSize) {
                        placeLeaves(pos, config, rand, worldIn, posX2, topTrunkHeight + 2, posZ2, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX2, topTrunkHeight + 1, posZ2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + 1, topTrunkHeight + 1, posZ2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 - 1, topTrunkHeight + 1, posZ2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2, topTrunkHeight + 1, posZ2 - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2, topTrunkHeight + 1, posZ2 + 1, boundsIn, changedBlocks);


                        placeLeaves(pos, config, rand, worldIn, posX2 + posXLeafSize, topTrunkHeight - 1, posZ2 + posZLeafSize + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + posXLeafSize, topTrunkHeight - 1, posZ2 + posZLeafSize - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + posXLeafSize - 1, topTrunkHeight - 1, posZ2 + posZLeafSize, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + posXLeafSize + 1, topTrunkHeight - 1, posZ2 + posZLeafSize, boundsIn, changedBlocks);


                        placeLeaves(pos, config, rand, worldIn, posX2 + 1, topTrunkHeight - 2, posZ2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 - 1, topTrunkHeight - 2, posZ2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2, topTrunkHeight - 2, posZ2 - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2, topTrunkHeight - 2, posZ2 + 1, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX2 + posXLeafSize, topTrunkHeight - 3, posZ2 + posZLeafSize + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + posXLeafSize, topTrunkHeight - 3, posZ2 + posZLeafSize - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + posXLeafSize - 1, topTrunkHeight - 3, posZ2 + posZLeafSize, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + posXLeafSize + 1, topTrunkHeight - 3, posZ2 + posZLeafSize, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX2 + 1, topTrunkHeight - 4, posZ2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 - 1, topTrunkHeight - 4, posZ2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2, topTrunkHeight - 4, posZ2 - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2, topTrunkHeight - 4, posZ2 + 1, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX2 + posXLeafSize + 1, topTrunkHeight - 5, posZ2 + posZLeafSize + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + posXLeafSize - 1, topTrunkHeight - 5, posZ2 + posZLeafSize - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + posXLeafSize + 1, topTrunkHeight - 5, posZ2 + posZLeafSize - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + posXLeafSize - 1, topTrunkHeight - 5, posZ2 + posZLeafSize + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + 3, topTrunkHeight - 5, posZ2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 - 3, topTrunkHeight - 5, posZ2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2, topTrunkHeight - 5, posZ2 - 3, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2, topTrunkHeight - 5, posZ2 + 3, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX2 + posXLeafSize, topTrunkHeight - 6, posZ2 + posZLeafSize, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + 2, topTrunkHeight - 6, posZ2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 - 2, topTrunkHeight - 6, posZ2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2, topTrunkHeight - 6, posZ2 - 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2, topTrunkHeight - 6, posZ2 + 2, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX2 + posXLeafSize, topTrunkHeight - 7, posZ2 + posZLeafSize + 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + posXLeafSize, topTrunkHeight - 7, posZ2 + posZLeafSize - 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + posXLeafSize - 2, topTrunkHeight - 7, posZ2 + posZLeafSize, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + posXLeafSize + 2, topTrunkHeight - 7, posZ2 + posZLeafSize, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + posXLeafSize + 1, topTrunkHeight - 7, posZ2 + posZLeafSize + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + posXLeafSize - 1, topTrunkHeight - 7, posZ2 + posZLeafSize - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + posXLeafSize + 1, topTrunkHeight - 7, posZ2 + posZLeafSize - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + posXLeafSize - 1, topTrunkHeight - 7, posZ2 + posZLeafSize + 1, boundsIn, changedBlocks);


                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}