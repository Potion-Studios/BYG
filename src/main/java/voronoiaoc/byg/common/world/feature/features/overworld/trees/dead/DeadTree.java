package voronoiaoc.byg.common.world.feature.features.overworld.trees.dead;//package voronoiaoc.byg.common.world.feature.features.overworld.trees.dead;
//
//import com.mojang.serialization.Codec;
//import net.minecraft.block.Block;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.BYGBlockRenders;
//import net.minecraft.util.math.MutableBoundingBox;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.Direction;
//import net.minecraft.world.ISeedReader;
//import net.minecraft.world.TestableWorld;
//import net.minecraft.world.gen.feature.NoFeatureConfig;
//import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
//import voronoiaoc.byg.core.byglists.BYGBlockList;
//
//import java.util.Random;
//import java.util.Set;
//
//public class DeadTree extends BYGAbstractTreeFeature<NoFeatureConfig> {
//    //BYGBlockRenders used for the tree.
//    private static final BlockState LOG = Blocks.OAK_LOG.getDefaultState();
//    private static final BlockState LEAVES = Blocks.OAK_LEAVES.getDefaultState();
//    private static final BlockState BEENEST = Blocks.BEE_NEST.getDefaultState();
//
//    public DeadTree(Codec<NoFeatureConfig> configIn) {
//        super(configIn);
//    }
//
//
//
//    public static boolean isQuagmireSB(IWorldGenerationBaseReader worldIn, BlockPos pos, net.minecraftforge.common.IPlantable sapling) {
//        return worldIn.hasBlockState(pos, (p_214582_0_) -> {
//            Block block = p_214582_0_.getBlock();
//            return block == BYGBlockList.MUD_BLOCK || block == BYGBlockList.PEAT;
//        });
//    }
//
//    public boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling) {
//        int randTreeHeight = rand.nextInt(4) + 4;
//        int posX = pos.getX();
//        int posY = pos.getY();
//        int posZ = pos.getZ();
//        if (posY >= 1 && posY + randTreeHeight + 1 < 256) {
//            BlockPos blockpos = pos.down();
//            if (!isQuagmireSB(worldIn, blockpos, Blocks.GRASS_BLOCK)) {
//                return false;
//            } else if (!this.doesTreeFit(worldIn, pos, randTreeHeight)) {
//                return false;
//            } else {
//
//                Direction direction = Direction.Plane
//.HORIZONTAL.random(rand);
//                int randTreeHeight2 = randTreeHeight - rand.nextInt(1);//Crashes on 0.
//                int posY1 = 2 - rand.nextInt(1);//Crashes on 0.
//                int posX1 = posX;
//                int posZ1 = posZ;
//                int topTrunkHeight = posY + randTreeHeight - 1;
//
//
//                for (int buildTrunk = 0; buildTrunk < randTreeHeight; ++buildTrunk) {
//                    if (buildTrunk >= randTreeHeight2 && posY1 < 0) { //Unknown
//                        posX1 += direction.getXOffset();
//                        posZ1 += direction.getZOffset();
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
//                    if (isAir(worldIn, blockpos1)) {
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
//    private boolean doesTreeFit(IWorldGenerationBaseReader reader, BlockPos blockPos, int height) {
//        int x = blockPos.getX();
//        int y = blockPos.getY();
//        int z = blockPos.getZ();
//        BlockPos.Mutable pos = new BlockPos.Mutable();
//
//        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
//            int distance = 5;
//
//            for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
//                for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
//                    if (!canLogPlaceHere(reader, pos.setPos(x + xOffset, y + yOffset, z + zOffset))) {
//                        return false;
//                    }
//                }
//            }
//        }
//        return true;
//    }
//
//    //Log Placement
//    private void treelog(Set<BlockPos> setlogblock, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
//        if (canLogPlaceHere(reader, pos)) {
//            this.setFinalBlockState(setlogblock, reader, pos, LOG, boundingBox);
//        }
//
//    }
//
//    //Leaves Placement
//    private void leafs(ISeedReader reader, int x, int y, int z, MutableBoundingBox boundingBox, Set<BlockPos> blockPos) {
//        BlockPos blockpos = new BlockPos(x, y, z);
//        if (isAir(reader, blockpos)) {
//            this.setFinalBlockState(blockPos, reader, blockpos, LEAVES, boundingBox);
//        }
//    }
//}