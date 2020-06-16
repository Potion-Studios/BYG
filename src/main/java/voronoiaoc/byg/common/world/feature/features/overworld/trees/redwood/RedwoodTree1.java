package voronoiaoc.byg.common.world.feature.features.overworld.trees.redwood;

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

public class RedwoodTree1 extends BYGAbstractTreeFeature<NoFeatureConfig> {
    //Blocks used for the tree.
    private static final BlockState LOG = BYGBlockList.REDWOOD_LOG.getDefaultState();
    private static final BlockState LEAVES = BYGBlockList.REDWOOD_LEAVES.getDefaultState();
    private static final BlockState BEENEST = Blocks.BEE_NEST.getDefaultState();

    public RedwoodTree1(Function<Dynamic<?>, ? extends NoFeatureConfig> configIn, boolean doBlockNotifyIn, int beeHiveChance) {
        super(configIn);
        setSapling((net.minecraftforge.common.IPlantable) BYGBlockList.BROWN_BIRCH_SAPLING);
    }

    protected static boolean canTreeReplace(IWorldGenerationBaseReader genBaseReader, BlockPos blockPos) {
        return canTreePlaceHere(
                genBaseReader, blockPos
        );
    }

    public boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos position, MutableBoundingBox boundsIn) {
        //This sets heights for trees. Rand.nextint allows for tree height randomization. The final int value sets the minimum for tree Height.
        int randTreeHeight = rand.nextInt(15) + 50;
        int randOuterEdgeHeight = rand.nextInt(6);

        int trunkLevelHeight1 = randTreeHeight - randOuterEdgeHeight - 37;
        int trunkLevelHeight2 = randTreeHeight - 33;
        int trunkLevelHeight3 = randTreeHeight - 28;
        int trunkLevelHeight4 = randTreeHeight - 24;
        int trunkLevelHeight5 = randTreeHeight - 20;
        int trunkLevelHeight6 = randTreeHeight - 16;
        int trunkLevelHeight7 = randTreeHeight - 12;
        int trunkLevelHeight8 = randTreeHeight - 8;
        int trunkLevelHeight9 = randTreeHeight - 4;

        //Positions
        int posX = position.getX();
        int posY = position.getY();
        int posZ = position.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < 256) {
            BlockPos blockpos = position.down();
            if (!isSoil(worldIn, blockpos, getSapling())) {
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
                int branchPlacer1 = posY + trunkLevelHeight1;
                int branchPlacer2 = posY + trunkLevelHeight2;
                int branchPlacer3 = posY + trunkLevelHeight3;
                int branchPlacer4 = posY + trunkLevelHeight4;
                int branchPlacer5 = posY + trunkLevelHeight5;
                int branchPlacer6 = posY + trunkLevelHeight6;
                int branchPlacer7 = posY + trunkLevelHeight7;
                int branchPlacer8 = posY + trunkLevelHeight8;
                int branchPlacer9 = posY + trunkLevelHeight9;
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
                    BlockPos branchPos1 = new BlockPos(posX1, branchPlacer1, posZ1);
                    BlockPos branchPos2 = new BlockPos(posX1, branchPlacer2, posZ1);
                    BlockPos branchPos3 = new BlockPos(posX1, branchPlacer3, posZ1);
                    BlockPos branchPos4 = new BlockPos(posX1, branchPlacer4, posZ1);
                    BlockPos branchPos5 = new BlockPos(posX1, branchPlacer5, posZ1);
                    BlockPos branchPos6 = new BlockPos(posX1, branchPlacer6, posZ1);
                    BlockPos branchPos7 = new BlockPos(posX1, branchPlacer7, posZ1);
                    BlockPos branchPos8 = new BlockPos(posX1, branchPlacer8, posZ1);
                    BlockPos branchPos9 = new BlockPos(posX1, branchPlacer9, posZ1);

                    //Sets Logs
                    this.treelog(changedBlocks, worldIn, blockpos1, boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos1.north(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos1.south(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos1.east(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos1.west(), boundsIn);

                    if (groundUpLogRemover <= randTreeHeight - 25) {
                        this.treelog(changedBlocks, worldIn, blockpos1.north().west(), boundsIn);
                        this.treelog(changedBlocks, worldIn, blockpos1.north().east(), boundsIn);
                        this.treelog(changedBlocks, worldIn, blockpos1.south().east(), boundsIn);
                        this.treelog(changedBlocks, worldIn, blockpos1.south().west(), boundsIn);
                    }

                    if (groundUpLogRemover <= 38) {
                        this.treelog(changedBlocks, worldIn, blockpos1.north(2), boundsIn);
                        this.treelog(changedBlocks, worldIn, blockpos1.south(2), boundsIn);
                        this.treelog(changedBlocks, worldIn, blockpos1.east(2), boundsIn);
                        this.treelog(changedBlocks, worldIn, blockpos1.west(2), boundsIn);
                    }

                    if (groundUpLogRemover <= randOuterEdgeHeight) {
                        this.treelog(changedBlocks, worldIn, blockpos1.north(2).west(), boundsIn);
                        this.treelog(changedBlocks, worldIn, blockpos1.north(2).east(), boundsIn);
                        this.treelog(changedBlocks, worldIn, blockpos1.south(2).east(), boundsIn);
                        this.treelog(changedBlocks, worldIn, blockpos1.south(2).west(), boundsIn);

                        this.treelog(changedBlocks, worldIn, blockpos1.north().west(2), boundsIn);
                        this.treelog(changedBlocks, worldIn, blockpos1.north().east(2), boundsIn);
                        this.treelog(changedBlocks, worldIn, blockpos1.south().east(2), boundsIn);
                        this.treelog(changedBlocks, worldIn, blockpos1.south().west(2), boundsIn);
                    }

                    if (groundUpLogRemover <= 6) {
                        this.treelog(changedBlocks, worldIn, blockpos1.north(3), boundsIn);
                        this.treelog(changedBlocks, worldIn, blockpos1.south(3), boundsIn);
                        this.treelog(changedBlocks, worldIn, blockpos1.east(3), boundsIn);
                        this.treelog(changedBlocks, worldIn, blockpos1.west(3), boundsIn);
                    }

                    this.treelog(changedBlocks, worldIn, branchPos1.east(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos1.west(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos1.south(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos1.north(3), boundsIn);

                    this.treelog(changedBlocks, worldIn, branchPos2.east(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos2.east(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos2.west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos2.west(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos2.south(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos2.south(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos2.north(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos2.north(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos2.east(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos2.east(5).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos2.west(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos2.west(5).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos2.south(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos2.south(5).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos2.north(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos2.north(5).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos2.north(2).east(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos2.south(2).east(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos2.north(2).west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos2.south(2).west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos2.north(3).east(3).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos2.south(3).east(3).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos2.north(3).west(3).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos2.south(3).west(3).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos2.north(4).east(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos2.south(4).east(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos2.north(4).west(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos2.south(4).west(4).down(), boundsIn);

                    this.treelog(changedBlocks, worldIn, branchPos3.east(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.east(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.west(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.south(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.south(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.north(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.north(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.east(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.east(5).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.west(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.west(5).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.south(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.south(5).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.north(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.north(5).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.east(6).down(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.east(7).down(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.west(6).down(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.west(7).down(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.south(6).down(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.south(7).down(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.north(6).down(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.north(7).down(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.north(2).east(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.south(2).east(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.north(2).west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.south(2).west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.north(3).east(3).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.south(3).east(3).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.north(3).west(3).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.south(3).west(3).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.north(4).east(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.south(4).east(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.north(4).west(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.south(4).west(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.north(5).east(5).down(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.south(5).east(5).down(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.north(5).west(5).down(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.south(5).west(5).down(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.north(6).east(6).down(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.south(6).east(6).down(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.north(6).west(6).down(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos3.south(6).west(6).down(2), boundsIn);

                    BlockPos.Mutable branch4PosMutable = new BlockPos.Mutable(branchPos4);
                    for (int i = 2; i <= 4; i++) {
                        BlockPos.Mutable mutable = new BlockPos.Mutable(branch4PosMutable);
                        if (i > 2) {
                            mutable.move(Direction.DOWN, 1);
                        }
                        mutable.move(Direction.EAST, i);

                        this.treelog(changedBlocks, worldIn, mutable.move(Direction.NORTH, i), boundsIn);
                        //you multiply by 2 here to reverse the north
                        this.treelog(changedBlocks, worldIn, mutable.move(Direction.SOUTH, i * 2), boundsIn);

                        //same deal here, but with west and east
                        mutable.move(Direction.WEST, i);
                        this.treelog(changedBlocks, worldIn, mutable, boundsIn);
                        this.treelog(changedBlocks, worldIn, mutable.move(Direction.NORTH, i * 2), boundsIn);
                    }

                    this.treelog(changedBlocks, worldIn, branchPos5.east(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.east(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.west(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.south(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.south(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.north(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.north(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.east(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.east(5).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.west(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.west(5).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.south(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.south(5).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.north(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.north(5).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.east(6).down(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.east(7).down(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.west(6).down(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.west(7).down(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.south(6).down(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.south(7).down(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.north(6).down(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.north(7).down(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.north().east(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.south().east(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.north().west(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.south().west(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.north(2).east(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.south(2).east(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.north(2).west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.south(2).west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.north(3).east(3).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.south(3).east(3).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.north(3).west(3).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.south(3).west(3).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.north(4).east(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.south(4).east(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.north(4).west(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.south(4).west(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.north(5).east(5).down(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.south(5).east(5).down(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.north(5).west(5).down(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.south(5).west(5).down(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.north(6).east(6).down(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.south(6).east(6).down(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.north(6).west(6).down(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos5.south(6).west(6).down(2), boundsIn);

                    this.treelog(changedBlocks, worldIn, branchPos6.east(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.east(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.west(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.south(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.south(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.north(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.north(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.east(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.east(5).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.east(6).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.west(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.west(5).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.west(6).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.south(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.south(5).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.south(6).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.north(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.north(5).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.north(6).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.north().east(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.south().east(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.north().west(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.south().west(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.north(2).east(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.south(2).east(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.north(2).west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.south(2).west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.north(3).east(3).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.south(3).east(3).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.north(3).west(3).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.south(3).west(3).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.north(4).east(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.south(4).east(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.north(4).west(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.south(4).west(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.north(5).east(5).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.south(5).east(5).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.north(5).west(5).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos6.south(5).west(5).down(), boundsIn);

                    this.treelog(changedBlocks, worldIn, branchPos7.east(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos7.east(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos7.west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos7.west(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos7.south(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos7.south(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos7.north(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos7.north(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos7.east(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos7.east(5).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos7.west(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos7.west(5).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos7.south(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos7.south(5).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos7.north(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos7.north(5).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos7.north().east(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos7.south().east(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos7.north().west(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos7.south().west(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos7.north(2).east(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos7.south(2).east(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos7.north(2).west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos7.south(2).west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos7.north(3).east(3).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos7.south(3).east(3).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos7.north(3).west(3).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos7.south(3).west(3).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos7.north(4).east(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos7.south(4).east(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos7.north(4).west(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos7.south(4).west(4).down(), boundsIn);

                    this.treelog(changedBlocks, worldIn, branchPos8.east(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos8.east(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos8.west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos8.west(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos8.south(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos8.south(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos8.north(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos8.north(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos8.east(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos8.west(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos8.south(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos8.north(4).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos8.north().east(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos8.south().east(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos8.north().west(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos8.south().west(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos8.north(2).east(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos8.south(2).east(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos8.north(2).west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos8.south(2).west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos8.north(3).east(3).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos8.south(3).east(3).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos8.north(3).west(3).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos8.south(3).west(3).down(), boundsIn);

                    this.treelog(changedBlocks, worldIn, branchPos9.east(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos9.west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos9.south(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos9.north(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos9.east(3).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos9.west(3).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos9.south(3).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos9.north(3).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos9.north().east(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos9.south().east(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos9.north().west(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos9.south().west(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos9.north(2).east(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos9.south(2).east(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos9.north(2).west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos9.south(2).west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos9.north(3).east(3).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos9.south(3).east(3).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos9.north(3).west(3).down(), boundsIn);
                    this.treelog(changedBlocks, worldIn, branchPos9.south(3).west(3).down(), boundsIn);
                }

                int leavessquarespos = 3;
                for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                    for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                        this.leafs(worldIn, posX1 + posXLeafWidth, branchPlacer6, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 + posXLeafWidth, branchPlacer7, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);

                        if (posXLeafWidth <= 1 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {
                            this.leafs(worldIn, posX1 + posXLeafWidth, branchPlacer6 + 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, branchPlacer7 + 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                        }
                        //2x2
                        if (posXLeafWidth <= 1 && posZLeafWidthL0 <= 0 && posZLeafWidthL0 >= -1 && posXLeafWidth >= 0) {
                            
                            this.leafs(worldIn, posX1 + posXLeafWidth + 4, branchPlacer7 - 1, posZ1 + posZLeafWidthL0 - 4, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth + 4, branchPlacer7 - 1, posZ1 + posZLeafWidthL0 + 5, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth - 5, branchPlacer7 - 1, posZ1 + posZLeafWidthL0 - 4, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth - 5, branchPlacer7 - 1, posZ1 + posZLeafWidthL0 + 5, boundsIn, changedBlocks);

                            this.leafs(worldIn, posX1 + posXLeafWidth + 3, branchPlacer7 - 1, posZ1 + posZLeafWidthL0 - 3, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth + 3, branchPlacer7 - 1, posZ1 + posZLeafWidthL0 + 4, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth - 4, branchPlacer7 - 1, posZ1 + posZLeafWidthL0 - 3, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth - 4, branchPlacer7 - 1, posZ1 + posZLeafWidthL0 + 4, boundsIn, changedBlocks);

                            this.leafs(worldIn, posX1 + posXLeafWidth + 2, branchPlacer7 - 1, posZ1 + posZLeafWidthL0 - 2, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth + 2, branchPlacer7 - 1, posZ1 + posZLeafWidthL0 + 3, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth - 3, branchPlacer7 - 1, posZ1 + posZLeafWidthL0 - 2, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth - 3, branchPlacer7 - 1, posZ1 + posZLeafWidthL0 + 3, boundsIn, changedBlocks);

                        }

                        //X Rows
                        if (posXLeafWidth <= 1 && posXLeafWidth >= -1) {
                            this.leafs(worldIn, posX1 + posXLeafWidth - 2, branchPlacer6 + 1, posZ1, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth + 2, branchPlacer6 + 1, posZ1, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth - 5, branchPlacer6, posZ1, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth + 5, branchPlacer6, posZ1, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth - 5, branchPlacer6 - 1, posZ1 - 1, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth - 5, branchPlacer6 - 1, posZ1 + 1, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth + 5, branchPlacer6 - 1, posZ1 - 1, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth + 5, branchPlacer6 - 1, posZ1 + 1, boundsIn, changedBlocks);

                        }

                        //Z Rows 3
                        if (posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1) {
                            this.leafs(worldIn, posX1, branchPlacer6 + 1, posZ1 + posZLeafWidthL0 + 2, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1, branchPlacer6 + 1, posZ1 + posZLeafWidthL0 - 2, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1, branchPlacer6, posZ1 + posZLeafWidthL0 + 5, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1, branchPlacer6, posZ1 + posZLeafWidthL0 - 5, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + 1, branchPlacer6 - 1, posZ1 + posZLeafWidthL0 + 5, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 1, branchPlacer6 - 1, posZ1 + posZLeafWidthL0 + 5, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + 1, branchPlacer6 - 1, posZ1 + posZLeafWidthL0 - 5, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 1, branchPlacer6 - 1, posZ1 + posZLeafWidthL0 - 5, boundsIn, changedBlocks);

                        }

                            //X Rows 2
                        if (posXLeafWidth <= 1 && posXLeafWidth >= 0) {
                            this.leafs(worldIn, posX1 + posXLeafWidth - 3, branchPlacer7 + 1, posZ1, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth + 2, branchPlacer7 + 1, posZ1, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth - 5, branchPlacer7, posZ1, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth + 4, branchPlacer7, posZ1, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth - 5, branchPlacer7 - 1, posZ1 + 1, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth - 5, branchPlacer7 - 1, posZ1 - 1, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth + 4, branchPlacer7 - 1, posZ1 + 1, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth + 4, branchPlacer7 - 1, posZ1 - 1, boundsIn, changedBlocks);

                        }
                            //Z Rows 2
                        if (posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= 0) {
                            this.leafs(worldIn, posX1, branchPlacer7 + 1, posZ1 + posZLeafWidthL0 + 2, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1, branchPlacer7 + 1, posZ1 + posZLeafWidthL0 - 3, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1, branchPlacer7, posZ1 + posZLeafWidthL0 + 4, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1, branchPlacer7, posZ1 + posZLeafWidthL0 - 5, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 1, branchPlacer7 - 1, posZ1 + posZLeafWidthL0 + 4, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + 1, branchPlacer7 - 1, posZ1 + posZLeafWidthL0 + 4, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 1, branchPlacer7 - 1, posZ1 + posZLeafWidthL0 - 5, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + 1, branchPlacer7 - 1, posZ1 + posZLeafWidthL0 - 5, boundsIn, changedBlocks);
                        }

                        this.leafs(worldIn, posX1 + 2, branchPlacer7 + 1, posZ1 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 2, branchPlacer7 + 1, posZ1 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 + 2, branchPlacer7 + 1, posZ1 - 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 2, branchPlacer7 + 1, posZ1 - 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 + 4, branchPlacer7 , posZ1 + 4, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 4, branchPlacer7 , posZ1 + 4, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 + 4, branchPlacer7 , posZ1 - 4, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 4, branchPlacer7 , posZ1 - 4, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX1 + 2, branchPlacer6 + 1, posZ1 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 2, branchPlacer6 + 1, posZ1 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 + 2, branchPlacer6 + 1, posZ1 - 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 2, branchPlacer6 + 1, posZ1 - 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 + 4, branchPlacer6 , posZ1 + 4, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 4, branchPlacer6 , posZ1 + 4, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 + 4, branchPlacer6 , posZ1 - 4, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 4, branchPlacer6 , posZ1 - 4, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 + 5, branchPlacer6 , posZ1 + 5, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 5, branchPlacer6 , posZ1 + 5, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 + 5, branchPlacer6 , posZ1 - 5, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 5, branchPlacer6 , posZ1 - 5, boundsIn, changedBlocks);

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
            int distance = 15;

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