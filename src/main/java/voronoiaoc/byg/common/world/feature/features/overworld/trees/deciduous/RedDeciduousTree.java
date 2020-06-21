package voronoiaoc.byg.common.world.feature.features.overworld.trees.deciduous;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

//Copied and Pasted Dark Oak to try and undertstand the logic and math for tree creation.
public class RedDeciduousTree extends BYGAbstractTreeFeature<NoFeatureConfig> {
    private static final BlockState LOG = Blocks.OAK_LOG.getDefaultState();
    private static final BlockState LEAVES = BYGBlockList.RED_OAK_LEAVES.getDefaultState();
    private static final BlockState BEENEST = Blocks.BEE_NEST.getDefaultState();

    public RedDeciduousTree(Function<Dynamic<?>, ? extends NoFeatureConfig> configIn) {
        super(configIn);
    }

    protected static boolean canTreeReplace(IWorldGenerationBaseReader p_214587_0_, BlockPos p_214587_1_) {
        return canTreePlaceHere(
                p_214587_0_, p_214587_1_
        );
    }

    public boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos position, MutableBoundingBox boundsIn) {
        int randTreeHeight = rand.nextInt(3) + rand.nextInt(3) + 10; //First value changes height of the trunk.
        int posX = position.getX();
        int posY = position.getY();
        int posZ = position.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < 256) {
            BlockPos blockpos = position.down();
            if (!isDesiredGround(worldIn, blockpos, Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.doesTreeFit(worldIn, position, randTreeHeight)) {
                return false;
            } else {

//this.setGroundBlockAt(worldIn, blockpos.east(), position, Blocks.DIRT.getDefaultState());

                //this.setGroundBlockAt(worldIn, blockpos.south(), position, Blocks.DIRT.getDefaultState());

                //this.setGroundBlockAt(worldIn, blockpos.south().east(), position, Blocks.DIRT.getDefaultState());

                Direction direction = Direction.Plane.HORIZONTAL.random(rand);
                int random1 = randTreeHeight - rand.nextInt(1);//Crashes on 0. Unknown use.
                int posY1 = 2 - rand.nextInt(1);//Crashes on 0. Unknown Use
                int posX1 = posX;
                int posZ1 = posZ;
                int topTrunkHeight = posY + randTreeHeight - 1;

                /*int z1 = posX;
                int z2 = posY;
                int z3 = posZ;*/


                for (int posX2LogRemover = 0; posX2LogRemover < randTreeHeight; ++posX2LogRemover) {//raising this value will remove log blocks from the ground up.
                    if (posX2LogRemover >= random1 && posY1 < 0) { //Unknown
                        posX1 += direction.getXOffset();
                        posZ1 += direction.getZOffset();
                        ++posY1;
                    }
                    int logplacer = posY + posX2LogRemover;
                    int logplacer2 = posY + posX2LogRemover;
                    BlockPos blockpos1 = new BlockPos(posX1, logplacer, posZ1);
                    //BlockPos blockpos2 = new BlockPos(posX1 , logplacer2, posZ1 );
                    BlockPos blockposwest1 = new BlockPos(posX1 - 1, logplacer2, posZ1);
                    BlockPos blockposeast1 = new BlockPos(posX1 + 1, logplacer2, posZ1);
                    BlockPos blockposnorth1 = new BlockPos(posX1, logplacer2, posZ1 - 1);
                    BlockPos blockpossouth1 = new BlockPos(posX1, logplacer2, posZ1 + 1);
                    //BlockPos blockpos7 = new BlockPos(posX1 - 1, logplacer2, posZ1 );

                    if (isAir(worldIn, blockpos1)) {
                        this.treelog(changedBlocks, worldIn, blockpos1, boundsIn);
                        //this.treelog(changedBlocks, worldIn, blockpos1.east(), boundsIn);
                        // this.treelog(changedBlocks, worldIn, blockpos1.south(), boundsIn);
                        // this.treelog(changedBlocks, worldIn, blockpos1.west(), boundsIn);
                        // this.treelog(changedBlocks, worldIn, blockpos1.north(), boundsIn);
                        //this.treelog(changedBlocks, worldIn, blockpos1.north(2), boundsIn);
                        //this.treelog(changedBlocks, worldIn, blockposnorth1.north(), boundsIn);
                        // this.treelog(changedBlocks, worldIn, blockpossouth1.south(), boundsIn);
                        //  this.treelog(changedBlocks, worldIn, blockposeast1.east(), boundsIn);
                        // this.treelog(changedBlocks, worldIn, blockposwest1.west(), boundsIn);

                    }
                }
                int leavesetting = rand.nextInt(3) + 1;
                {
                    if (leavesetting == 1) {
                        int leavessquarespos = rand.nextInt(1) + 1;
                        for (int posXLeafWidth = (leavessquarespos * -1); posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                            for (int posZLeafWidthL0 = (leavessquarespos * -1); posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {
                                //int leaveheight = 0;//0 lines it up with top log
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 6, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 4, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 2, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                //this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);

                                //Y + 0
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);

                                //Y=-2
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - 2, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - 2, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 2, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 2, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 2, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 2, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 2, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - 2, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - 2, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - 2, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - 2, posZ1 + 1, boundsIn, changedBlocks);

                                //Y=-3
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);

                                //Y=-4
                                int leafsize = rand.nextInt(10) + 1;
                                if (leafsize == 2) {
                                    this.leafs(worldIn, posX1 + 2, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 2, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight - 4, posZ1 - 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight - 4, posZ1 + 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 1, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 1, topTrunkHeight - 4, posZ1 + 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 1, topTrunkHeight - 4, posZ1 - 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1 - 1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1 + 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1 - 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1 - 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 2, topTrunkHeight - 4, posZ1 - 1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 2, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 2, topTrunkHeight - 4, posZ1 - 1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 2, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);
                                }
                                //Y=-5
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 5, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 5, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 5, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 5, posZ1 + 1, boundsIn, changedBlocks);

                                //Leave Layer On Top of Top Trunk Block Y + 1
                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1 + 1, boundsIn, changedBlocks);

                                //Leave Layer Trunk Y+2
                                this.leafs(worldIn, posX1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 2, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 2, posZ1 + 1, boundsIn, changedBlocks);

                                //Leave Layer Trunk Y-7
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 7, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 7, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 7, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 7, posZ1 + 1, boundsIn, changedBlocks);
                            }
                        /*for (int posXLeafWidth = (leavessquarespos * -1); posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                            for (int posZLeafWidthL0 = (leavessquarespos * -1); posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {
                                int leaveheight = 0;//0 lines it up with top log
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight + leaveheight - 3, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight + leaveheight - 2, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight + leaveheight - 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight + leaveheight - 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);


                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);

                                //Leave Layer On Top Trunk Block
                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1 + 1, boundsIn, changedBlocks);

                                //Leave Layer Trunk Y+2
                                this.leafs(worldIn, posX1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 2, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 2, posZ1 + 1, boundsIn, changedBlocks);

                                //Leave Layer Trunk Y-4
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 4, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);

                            }*/
                        }
                    } else if (leavesetting == 2) {
                        int leavessquarespos = rand.nextInt(1) + 1;
                        for (int posXLeafWidth = (leavessquarespos * -1); posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                            for (int posZLeafWidthL0 = (leavessquarespos * -1); posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {
                                //int leaveheight = 0;//0 lines it up with top log
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 6, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 4, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 2, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);

                                //Y + 0
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);

                                //Y=-2
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - 2, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - 2, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 2, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 2, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 2, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 2, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 2, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - 2, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - 2, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - 2, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - 2, posZ1 + 1, boundsIn, changedBlocks);

                                //Y=-3
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);

                                //Y=-4
                                if (rand.nextBoolean()) {
                                    this.leafs(worldIn, posX1 + 2, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 2, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight - 4, posZ1 - 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight - 4, posZ1 + 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 1, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 1, topTrunkHeight - 4, posZ1 + 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 1, topTrunkHeight - 4, posZ1 - 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1 - 1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1 + 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1 - 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1 - 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 2, topTrunkHeight - 4, posZ1 - 1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 2, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 2, topTrunkHeight - 4, posZ1 - 1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 2, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);
                                }

                                //Y=-5
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 5, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 5, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 5, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 5, posZ1 + 1, boundsIn, changedBlocks);

                                //Leave Layer On Top of Top Trunk Block Y + 1
                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1 + 1, boundsIn, changedBlocks);

                                //Leave Layer Trunk Y+2
                                this.leafs(worldIn, posX1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 2, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 2, posZ1 + 1, boundsIn, changedBlocks);

                                //Leave Layer Trunk Y-7
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 7, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 7, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 7, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 7, posZ1 + 1, boundsIn, changedBlocks);
                            }
                        }
                    } else if (leavesetting == 3) {
                        int leavessquarespos = rand.nextInt(1) + 1;
                        for (int posXLeafWidth = (leavessquarespos * -1); posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                            for (int posZLeafWidthL0 = (leavessquarespos * -1); posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {
                                //int leaveheight = 0;//0 lines it up with top log
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 6, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 5, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 4, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 3, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 2, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);

                                //Y + 0
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight, posZ1, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 + 2, boundsIn, changedBlocks);


                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);

                                //Y=-1
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 1, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 1, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 1, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 1, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 1, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 1, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 1, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 1, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 1, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - 1, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - 1, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - 1, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - 1, posZ1 + 1, boundsIn, changedBlocks);

                                //Y=-2
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - 2, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - 2, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 2, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 2, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 2, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 2, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 2, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - 2, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - 2, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - 2, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - 2, posZ1 + 1, boundsIn, changedBlocks);

                                int leaveyroundness = rand.nextInt(3) + 1;
                                {
                                    if (leaveyroundness == 1) {
                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1, topTrunkHeight - 3, posZ1 - 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1, topTrunkHeight - 3, posZ1 + 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 3, posZ1 + 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 3, posZ1 - 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 + 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 - 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 - 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
                                    } else if (leaveyroundness == 2) {
                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1, topTrunkHeight - 3, posZ1 - 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1, topTrunkHeight - 3, posZ1 + 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 3, posZ1 + 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 3, posZ1 - 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 + 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 - 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 - 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);

                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1, topTrunkHeight - 4, posZ1 - 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1, topTrunkHeight - 4, posZ1 + 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 4, posZ1 + 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 4, posZ1 - 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1 - 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1 + 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1 - 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1 - 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 4, posZ1 - 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 4, posZ1 - 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);
                                    } else if (leaveyroundness == 3) {
                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1, topTrunkHeight - 3, posZ1 - 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1, topTrunkHeight - 3, posZ1 + 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 3, posZ1 + 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 3, posZ1 - 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 + 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 - 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 - 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);

                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1, topTrunkHeight - 4, posZ1 - 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1, topTrunkHeight - 4, posZ1 + 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 4, posZ1 + 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 4, posZ1 - 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1 - 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1 + 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1 - 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1 - 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 4, posZ1 - 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 4, posZ1 - 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);

                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 5, posZ1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 5, posZ1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1, topTrunkHeight - 5, posZ1 - 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1, topTrunkHeight - 5, posZ1 + 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 5, posZ1 + 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 5, posZ1 + 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 5, posZ1 - 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 5, posZ1 - 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 5, posZ1 + 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 5, posZ1 - 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 5, posZ1 - 2, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 5, posZ1 - 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 5, posZ1 + 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 5, posZ1 - 1, boundsIn, changedBlocks);
                                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 5, posZ1 + 1, boundsIn, changedBlocks);
                                    }
                                }


                                //Leave Layer On Top of Top Trunk Block Y + 1
                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1 + 1, boundsIn, changedBlocks);

                                //Leave Layer Trunk Y+2
                                this.leafs(worldIn, posX1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 2, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 2, posZ1 + 1, boundsIn, changedBlocks);

                                //Leave Layer Trunk Y-4
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 7, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 7, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 7, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 7, posZ1 + 1, boundsIn, changedBlocks);
                            }
                        }
                    }
                }
                //Layer1
                //int leaves = rand.nextInt(2);
                //if (leaves == 2) {
                //Leave Layer level Top Trunk Block
                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);

                //Leave Layer On Top Trunk Block
                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                this.leafs(worldIn, posX1 - 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                this.leafs(worldIn, posX1 + 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1 - 1, boundsIn, changedBlocks);
                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1 + 1, boundsIn, changedBlocks);

                //Leave Layer Trunk Y+2
                this.leafs(worldIn, posX1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                this.leafs(worldIn, posX1 - 1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                this.leafs(worldIn, posX1 + 1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                this.leafs(worldIn, posX1, topTrunkHeight + 2, posZ1 - 1, boundsIn, changedBlocks);
                this.leafs(worldIn, posX1, topTrunkHeight + 2, posZ1 + 1, boundsIn, changedBlocks);

                //Leave Layer Trunk Y-4
                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                this.leafs(worldIn, posX1, topTrunkHeight - 4, posZ1 - 1, boundsIn, changedBlocks);
                this.leafs(worldIn, posX1, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);
            }

            return true;
            //}
        } else {
            return false;
        }
    }

    //BYGTree Height Maybe?
    private boolean doesTreeFit(IWorldGenerationBaseReader reader, BlockPos blockPos, int height) {
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        BlockPos.Mutable position = new BlockPos.Mutable();

        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
            int distance = 2; //higher the value, lower the density of trees?

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
