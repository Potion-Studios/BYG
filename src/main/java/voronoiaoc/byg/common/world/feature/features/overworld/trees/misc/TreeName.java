//package sporeaoc.byg.common.world.feature.tree.misc;
//
//import net.minecraft.block.BlockState;
//import net.minecraft.block.Blocks;
//import net.minecraft.util.Direction;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.MutableBoundingBox;
//import net.minecraft.world.gen.IWorldGenerationBaseReader;
//import net.minecraft.world.gen.IWorldGenerationReader;
//import net.minecraft.world.gen.feature.AbstractTreeFeature;
//import net.minecraft.world.gen.feature.NoFeatureConfig;
//
//import java.util.Random;
//import java.util.Set;
//
//public class TreeName extends AbstractTreeFeature<NoFeatureConfig> {
//    //Blocks used for the tree.
//    private static final BlockState LOG = Blocks.OAK_LOG.getDefaultState();
//    private static final BlockState LEAVES = Blocks.OAK_LEAVES.getDefaultState();
//
//    public TreeName() {
//        super(null, true);
//    }
//
//    public boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos position, MutableBoundingBox boundsIn) {
//        //This sets heights for trees. Rand.nextint allows for tree height randomization. The final int value sets the minimum for tree Height.
//        int randTreeHeight = rand.nextInt(3) + rand.nextInt(3) + 10;
//        //Positions
//        int posX = position.getX();
//        int posY = position.getY();
//        int posZ = position.getZ();
//        if (posY >= 1 && posY + randTreeHeight + 1 < 256) {
//            BlockPos checkGround = position.down();
//            if (!isSoil(worldIn, checkGround, getSapling())) {
//                return false;
//            } else if (!this.doesTreeFit(worldIn, position, randTreeHeight)) {
//                return false;
//            } else {
//                this.setGroundBlockAt(worldIn, checkGround, position, Blocks.DIRT.getDefaultState());

//                Direction direction = Direction.Plane.HORIZONTAL.random(rand);
//                int randTreeHeight2 = randTreeHeight - rand.nextInt(1);//Crashes on 0.
//                int posY2 = 2 - rand.nextInt(1);//Crashes on 0.
//                int posX2 = posX;
//                int posZ2 = posZ;
//                int topTrunkHeight = posY + randTreeHeight - 1;
//
//                for (int trunkBottom = 0; trunkBottom < randTreeHeight; ++trunkBottom) {
//                    if (trunkBottom >= randTreeHeight2 && posY2 < 0) { //Unknown
//                        posX2 += direction.getXOffset();
//                        posZ2 += direction.getZOffset();
//                        ++posY2;
//                    }
//                    int logplacer = posY + trunkBottom;
//
//
//                    BlockPos trunkPos1 = new BlockPos(posX2, logplacer, posZ2);
//                    this.treelog(changedBlocks, worldIn, trunkPos1, boundsIn);
//                    this.treelog(changedBlocks, worldIn, trunkPos1.north(), boundsIn);
//                    this.treelog(changedBlocks, worldIn, trunkPos1.east(), boundsIn);
//                    this.treelog(changedBlocks, worldIn, trunkPos1.north().east(), boundsIn);
//
//
//                    this.treelog(changedBlocks, worldIn, trunkPos1, boundsIn);
//                    this.treelog(changedBlocks, worldIn, trunkPos1.north(5), boundsIn);
//                    this.treelog(changedBlocks, worldIn, trunkPos1.east(1), boundsIn);
//                    this.treelog(changedBlocks, worldIn, trunkPos1.north(1).east(1), boundsIn);
//                }
//                for (int posXLeafSize = -2; posXLeafSize <= 2; ++posXLeafSize) {
//                    for (int posZLeafSize = -2; posZLeafSize <= 2; ++posZLeafSize) {
//                        //This places our leaf square on the center of the tree. In line with the top block of the trunk.
//                        this.leafs(worldIn, posX2 + posXLeafSize, topTrunkHeight, posZ2 + posZLeafSize, boundsIn, changedBlocks);
//                        //This places a leaf plus above the trunk above the trunk.
//                        this.leafs(worldIn, posX2, topTrunkHeight + 1, posZ2, boundsIn, changedBlocks);
//                        this.leafs(worldIn, posX2 + 1, topTrunkHeight + 1, posZ2, boundsIn, changedBlocks);
//                        this.leafs(worldIn, posX2 - 1, topTrunkHeight + 1, posZ2, boundsIn, changedBlocks);
//                        this.leafs(worldIn, posX2, topTrunkHeight + 1, posZ2 + 1, boundsIn, changedBlocks);
//                        this.leafs(worldIn, posX2, topTrunkHeight + 1, posZ2 - 1, boundsIn, changedBlocks);
//                    }
//                }
//            }
//            return true;
//        }
//        else {
//            return false;
//        }
//    }
//
//    //This Method essentially checks whether or not our tree can generate
//    private boolean doesTreeFit(IWorldGenerationBaseReader reader, BlockPos blockPos, int height) {
//        int x = blockPos.getX();
//        int y = blockPos.getY();
//        int z = blockPos.getZ();
//        BlockPos.MutableBlockPos position = new BlockPos.MutableBlockPos();
//
//        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
//            //Distance/Density of trees. Positive Values ONLY
//            int distance = 0;
//
//            for (int xDistance = -distance; xDistance <= distance; ++xDistance) {
//                for (int zDistance = -distance; zDistance <= distance; ++zDistance) {
//                    if (!canTreePlace(reader, position.setPos(x + xDistance, y + yOffset, z + zDistance))) {
//                        return false;
//                    }
//                }
//            }
//        }
//        return true;
//    }
//
//    //Log Placement
//    private void treelog(Set<BlockPos> setlogblock, IWorldGenerationReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
//        if (canTreePlace(reader, pos)) {
//            this.setFinalBlockState(setlogblock, reader, pos, LOG, boundingBox);
//        }
//
//    }
//
//    //Leaves Placement
//    private void leafs(IWorldGenerationReader reader, int x, int y, int z, MutableBoundingBox boundingBox, Set<BlockPos> blockPos) {
//        BlockPos leafpos = new BlockPos(x, y, z);
//        if (isAir(reader, leafpos)) {
//            this.setFinalBlockState(blockPos, reader, leafpos, LEAVES, boundingBox);
//        }
//
//    }
//
//    protected static boolean canTreePlace(IWorldGenerationBaseReader genBaseReader, BlockPos blockPos) {
//        return canTreePlaceHere(
//                genBaseReader, blockPos
//        );
//    }
//
//}