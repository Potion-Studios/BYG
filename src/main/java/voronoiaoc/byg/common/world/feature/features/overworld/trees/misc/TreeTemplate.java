package voronoiaoc.byg.common.world.feature.features.overworld.trees.misc;//package sporeaoc.byg.common.world.feature.tree.misc;
//
//import net.minecraft.block.BlockState;
//import net.minecraft.block.BYGBlockRenders;
////import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.BlockBox;
//////import net.minecraft.world.gen.feature.AbstractTreeFeature;
//import net.minecraft.world.gen.feature.DefaultFeatureConfig;
//
//import java.util.Random;
//import java.util.Set;
//
//import static net.minecraft.util.math.BlockPos.MutableBlockPos;
//
////THIS FEATURE MUST BE REGISTERED & ADDED TO A BIOME!
//public class TreeStructure extends AbstractTreeFeature<DefaultFeatureConfig> {
//    //BYGBlockRenders used for the tree.
//    private static final BlockState LOG = Blocks.OAK_LOG.getDefaultState();
//    private static final BlockState LEAVES = Blocks.OAK_LEAVES.getDefaultState();
//
//
//
//    public TreeStructure() {
//        super(null, true);
//    }
//
//    public boolean place(Set<BlockPos> changedBlocks, ServerWorldAccess worldIn, Random rand, BlockPos position, BlockBox boundsIn) {
//
//        int randTreeHeight = rand.nextInt(3) + rand.nextInt(3) + 10;
//        //Positions
//        int posX = position.getX();
//        int posY = position.getY();
//        int posZ = position.getZ();
//        if (posY >= 1 && posY + randTreeHeight + 1 < 256) {
//            BlockPos checkGround = position.down();
//            if (!isDesiredGroundwDirtTag(worldIn, checkGround, Blocks.GRASS_BLOCK)) {
//                return false;
//            } else if (!this.doesTreeFit(worldIn, position, randTreeHeight)) {
//                return false;
//            }
//            else {
//
//                //this.setGroundBlockAt(worldIn, checkGround, position, Blocks.DIRT.getDefaultState());

//                //Uncommenting this will allow for a 2x2 dirt patch under the tree.
//                /*//this.setGroundBlockAt(worldIn, checkGround.east(), position, Blocks.DIRT.getDefaultState());

//                //this.setGroundBlockAt(worldIn, checkGround.south(), position, Blocks.DIRT.getDefaultState());

//                //this.setGroundBlockAt(worldIn, checkGround.south().east(), position, Blocks.DIRT.getDefaultState());
//                //Uncommenting this will allow for a 3x3 dirt patch under the tree.
//                /*//this.setGroundBlockAt(worldIn, checkGround.west(), position, Blocks.DIRT.getDefaultState());

//                //this.setGroundBlockAt(worldIn, checkGround.south().west(), position, Blocks.DIRT.getDefaultState());

//                //this.setGroundBlockAt(worldIn, checkGround.north(), position, Blocks.DIRT.getDefaultState());

//                //this.setGroundBlockAt(worldIn, checkGround.north().east(), position, Blocks.DIRT.getDefaultState());

//                //this.setGroundBlockAt(worldIn, checkGround.north().west(), position, Blocks.DIRT.getDefaultState());
//
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
//                    BlockPos blockpos1 = new BlockPos(posX1, logplacer, posZ1);
//
//                    //Sets Logs
//                        this.treelog(changedBlocks, worldIn, blockpos1, boundsIn);
//                }
//
//                int leavePreset = rand.nextInt(3) + 1;
//                {
//                    if (leavePreset == 1) {
//                        //This randomizer allows you to have randomly generating sized leave widths(X & Z). You can remove the randomizer and set your own value instead.
//                        int leavessquarespos = rand.nextInt(1) + 1;
//                        //This loads leaves in squares. Manually placing the squares can allow you to load in perfect squares.
//                        for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
//                            for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {
//                                //int leaveheight = 0;//0 lines it up with top log
//                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
//                            }
//                        }
//                    } else if (leavePreset == 2) {
//                        int leavessquarespos = rand.nextInt(1) + 1;
//                        for (int posXLeafWidth = (leavessquarespos * -1); posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
//                            for (int posZLeafWidthL0 = (leavessquarespos * -1); posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {
//                                //int leaveheight = 0;// '0' lines it up with top log. This shouldn't be necessary.
//
//                                //Places your square leaves.
//                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight + 6, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
//
//
//                                //Places your individual leave blocks by hand. 1 at a time.
//                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);
//                            }
//                        }
//                    }
//                    //This is the BYGTree Maker in action. This would be tree leave Preset 3. I'd suggest commenting this out! SHOULD BE USED ONLY ON 1x1 TREE TRUNKS!
//                    else if (leavePreset == 3) {
//                        int leavessquarespos = rand.nextInt(1) + 1;
//                        for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
//                            for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {
//                                //int leaveheight = 0;//0 lines it up with top log
//                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 6, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 5, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 4, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
//
//                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 3, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 2, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
//
//                                //Y + 0
//                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 + 2, topTrunkHeight, posZ1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 - 2, topTrunkHeight, posZ1, boundsIn, changedBlocks);
//
//                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 + 2, boundsIn, changedBlocks);
//
//
//                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1 + 2, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 + 2, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 + 2, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 + 2, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 - 2, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 - 2, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
//
//                                //Y=-1
//                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1, topTrunkHeight - 1, posZ1 - 2, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1, topTrunkHeight - 1, posZ1 + 2, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 1, posZ1 + 1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 1, posZ1 + 2, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 1, posZ1 - 2, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 1, posZ1 - 1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 1, posZ1 + 2, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 1, posZ1 - 2, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 1, posZ1 - 2, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - 1, posZ1 - 1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - 1, posZ1 + 1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - 1, posZ1 - 1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - 1, posZ1 + 1, boundsIn, changedBlocks);
//
//                                //Y=-2
//                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - 2, posZ1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - 2, posZ1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1, topTrunkHeight - 2, posZ1 + 2, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 2, posZ1 + 1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 2, posZ1 + 2, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 2, posZ1 - 1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 2, posZ1 + 2, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - 2, posZ1 - 1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - 2, posZ1 + 1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - 2, posZ1 - 1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - 2, posZ1 + 1, boundsIn, changedBlocks);
//
//                                int leaveyroundness = rand.nextInt(3) + 1;
//                                {
//                                    if (leaveyroundness == 1) {
//                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1, topTrunkHeight - 3, posZ1 - 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1, topTrunkHeight - 3, posZ1 + 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 3, posZ1 + 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 3, posZ1 - 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 + 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 - 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 - 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
//                                    } else if (leaveyroundness == 2) {
//                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1, topTrunkHeight - 3, posZ1 - 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1, topTrunkHeight - 3, posZ1 + 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 3, posZ1 + 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 3, posZ1 - 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 + 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 - 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 - 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
//
//                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1, topTrunkHeight - 4, posZ1 - 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1, topTrunkHeight - 4, posZ1 + 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 4, posZ1 + 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 4, posZ1 - 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1 - 1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1 + 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1 - 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1 - 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 4, posZ1 - 1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 4, posZ1 - 1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);
//                                    } else if (leaveyroundness == 3) {
//                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1, topTrunkHeight - 3, posZ1 - 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1, topTrunkHeight - 3, posZ1 + 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 3, posZ1 + 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 3, posZ1 - 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 + 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 - 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 - 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
//
//                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1, topTrunkHeight - 4, posZ1 - 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1, topTrunkHeight - 4, posZ1 + 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 4, posZ1 + 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 4, posZ1 - 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1 - 1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1 + 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1 - 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1 - 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 4, posZ1 - 1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 4, posZ1 - 1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);
//
//                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 5, posZ1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 5, posZ1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1, topTrunkHeight - 5, posZ1 - 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1, topTrunkHeight - 5, posZ1 + 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 5, posZ1 + 1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 5, posZ1 + 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 5, posZ1 - 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 5, posZ1 - 1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 5, posZ1 + 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 5, posZ1 - 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 5, posZ1 - 2, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 5, posZ1 - 1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 5, posZ1 + 1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 5, posZ1 - 1, boundsIn, changedBlocks);
//                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 5, posZ1 + 1, boundsIn, changedBlocks);
//                                    }
//                                }
//
//
//                                //Leave Layer On Top of Top Trunk Block Y + 1
//                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 - 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 + 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1 - 1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1 + 1, boundsIn, changedBlocks);
//
//                                //Leave Layer Trunk Y+2
//                                this.leafs(worldIn, posX1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 - 1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 + 1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1, topTrunkHeight + 2, posZ1 - 1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1, topTrunkHeight + 2, posZ1 + 1, boundsIn, changedBlocks);
//
//                                //Leave Layer Trunk Y-4
//                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 7, posZ1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 7, posZ1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1, topTrunkHeight - 7, posZ1 - 1, boundsIn, changedBlocks);
//                                this.leafs(worldIn, posX1, topTrunkHeight - 7, posZ1 + 1, boundsIn, changedBlocks);
//                            }
//                        }
//                    }
//                }
//            }
//
//            return true;
//            //}
//        }
//        else {
//            return false;
//        }
//    }
//
//    private boolean doesTreeFit(TestableWorld reader, BlockPos blockPos, int height) {
//        int x = blockPos.getX();
//        int y = blockPos.getY();
//        int z = blockPos.getZ();
//        MutableBlockPos position = new MutableBlockPos();
//
//        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
//            //Distance/Density of trees. Positive Values ONLY
//            int distance = 5;
//
//            for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
//                for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
//                    if (!canTreePlace(reader, position.set(x + xOffset, y + yOffset, z + zOffset))) {
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
//        if (canTreePlace(reader, pos)) {
//            this.setFinalBlockState(setlogblock, reader, pos, LOG, boundingBox);
//        }
//
//    }
//
//    //Leaves Placement
//    private void leafs(ServerWorldAccess reader, int x, int y, int z, BlockBox boundingBox, Set<BlockPos> blockPos) {
//        BlockPos leafpos = new BlockPos(x, y, z);
//        if (isAir(reader, leafpos)) {
//            this.setFinalBlockState(blockPos, reader, leafpos, LEAVES, boundingBox);
//        }
//
//    }
//
//    protected static boolean canTreePlace(TestableWorld genBaseReader, BlockPos blockPos) {
//        return canTreePlaceHere(
//                genBaseReader, blockPos
//        );
//    }
//}