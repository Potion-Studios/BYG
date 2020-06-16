//package voronoiaoc.byg.common.world.feature.features.overworld.trees.dead;
//
//import com.mojang.serialization.Codec;
//import net.minecraft.block.Block;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.BYGBlockRenders;
//import net.minecraft.util.math.BlockBox;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.Direction;
//import net.minecraft.world.ServerWorldAccess;
//import net.minecraft.world.TestableWorld;
//import net.minecraft.world.gen.feature.DefaultFeatureConfig;
//import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
//import voronoiaoc.byg.core.byglists.BYGBlockList;
//
//import java.util.Random;
//import java.util.Set;
//
//public class DeadTree extends BYGAbstractTreeFeature<DefaultFeatureConfig> {
//    //BYGBlockRenders used for the tree.
//    private static final BlockState LOG = Blocks.OAK_LOG.getDefaultState();
//    private static final BlockState LEAVES = Blocks.OAK_LEAVES.getDefaultState();
//    private static final BlockState BEENEST = Blocks.BEE_NEST.getDefaultState();
//
//    public DeadTree(Codec<DefaultFeatureConfig> configIn) {
//        super(configIn);
//    }
//
//
//
//    public static boolean isQuagmireSB(TestableWorld worldIn, BlockPos pos, net.minecraftforge.common.IPlantable sapling) {
//        return worldIn.testBlockState(pos, (p_214582_0_) -> {
//            Block block = p_214582_0_.getBlock();
//            return block == BYGBlockList.MUD_BLOCK || block == BYGBlockList.PEAT;
//        });
//    }
//
//    public boolean place(Set<BlockPos> changedBlocks, ServerWorldAccess worldIn, Random rand, BlockPos position, BlockBox boundsIn) {
//        int randTreeHeight = rand.nextInt(4) + 4;
//        int posX = position.getX();
//        int posY = position.getY();
//        int posZ = position.getZ();
//        if (posY >= 1 && posY + randTreeHeight + 1 < 256) {
//            BlockPos blockpos = position.down();
//            if (!isQuagmireSB(worldIn, blockpos, Blocks.GRASS_BLOCK)) {
//                return false;
//            } else if (!this.doesTreeFit(worldIn, position, randTreeHeight)) {
//                return false;
//            } else {
//
//                Direction direction = Direction.Type.HORIZONTAL.random(rand);
//                int randTreeHeight2 = randTreeHeight - rand.nextInt(1);//Crashes on 0.
//                int posY1 = 2 - rand.nextInt(1);//Crashes on 0.
//                int posX1 = posX;
//                int posZ1 = posZ;
//                int topTrunkHeight = posY + randTreeHeight - 1;
//
//
//                for (int buildTrunk = 0; buildTrunk < randTreeHeight; ++buildTrunk) {
//                    if (buildTrunk >= randTreeHeight2 && posY1 < 0) { //Unknown
//                        posX1 += direction.getOffsetX();
//                        posZ1 += direction.getOffsetZ();
//                        ++posY1;
//                    }
//
//                    int logplacer = posY + buildTrunk;
//                    int logplacer2 = posY + randTreeHeight;
//
//                    BlockPos blockpos1 = new BlockPos(posX1, logplacer, posZ1);
//                    BlockPos blockpos2 = new BlockPos(posX1, logplacer2, posZ1);
//
//
//                    //Sets Logs
//                    if (isAirOrLeaves(worldIn, blockpos1)) {
//                        this.treelog(changedBlocks, worldIn, blockpos1, boundsIn);
//                        this.treelog(changedBlocks, worldIn, blockpos2.west(), boundsIn);
//                        this.treelog(changedBlocks, worldIn, blockpos2.west().up(), boundsIn);
//
//
//                    }
//                }
//                {
//                    int leavessquarespos = rand.nextInt(1) + 1;
//                    for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
//                        for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {
//
//                        }
//                    }
//                }
//            }
//
//            return true;
//            //}
//        } else {
//            return false;
//        }
//    }
//
//    private boolean doesTreeFit(TestableWorld reader, BlockPos blockPos, int height) {
//        int x = blockPos.getX();
//        int y = blockPos.getY();
//        int z = blockPos.getZ();
//        BlockPos.Mutable position = new BlockPos.Mutable();
//
//        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
//            int distance = 5;
//
//            for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
//                for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
//                    if (!canTreePlaceHere(reader, position.set(x + xOffset, y + yOffset, z + zOffset))) {
//                        return false;
//                    }
//                }
//            }
//        }
//        return true;
//    }
//
//    //Log Placement
//    private void treelog(Set<BlockPos> setlogblock, ServerWorldAccess reader, BlockPos pos, BlockBox boundingBox) {
//        if (canTreePlaceHere(reader, pos)) {
//            this.setFinalBlockState(setlogblock, reader, pos, LOG, boundingBox);
//        }
//
//    }
//
//    //Leaves Placement
//    private void leafs(ServerWorldAccess reader, int x, int y, int z, BlockBox boundingBox, Set<BlockPos> blockPos) {
//        BlockPos blockpos = new BlockPos(x, y, z);
//        if (isAir(reader, blockpos)) {
//            this.setFinalBlockState(blockPos, reader, blockpos, LEAVES, boundingBox);
//        }
//    }
//}