package voronoiaoc.byg.common.world.feature.features.overworld.mushrooms;

import com.mojang.serialization.Codec;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.BoundingBox;

public class EmburMushroom extends BYGAbstractTreeFeature<NoneFeatureConfiguration> {

    public EmburMushroom(Codec<NoneFeatureConfiguration> configIn) {
        super(configIn);
    }

    protected boolean place(Set<BlockPos> changedBlocks, WorldGenLevel worldIn, Random rand, BlockPos pos, BoundingBox boundsIn, boolean isSapling) {
        int randTreeHeight = 14 + rand.nextInt(5);
        BlockPos.MutableBlockPos mainmutable = new BlockPos.MutableBlockPos().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {
            BlockPos blockpos = pos.below();
            if (!isDesiredGround(worldIn, blockpos, BYGBlockList.EMBUR_NYLIUM)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isSapling)) {
                return false;
            } else {
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 0, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 1, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 2, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 3, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 4, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 5, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 6, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 7, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 8, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 9, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 10, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 11, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 12, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 13, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 14, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 3, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 4, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, 4, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 5, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, 5, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(5, 6, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 6, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 6, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, 6, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, 7, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(5, 7, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 7, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, 7, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, 8, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(4, 8, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 8, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(3, 9, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 9, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 9, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 10, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 10, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 10, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 11, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 11, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 12, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 13, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 14, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 14, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 15, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 15, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 15, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, 15, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 16, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, 16, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 17, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, 17, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 18, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 5, -4), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(6, 5, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(7, 5, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 5, -3), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(5, 5, -3), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(6, 5, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(7, 5, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 5, -2), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(4, 5, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(7, 5, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 5, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 5, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, 5, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 6, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 6, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, 6, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 6, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, 6, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 6, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 6, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, 6, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 7, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 7, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, 7, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 7, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 7, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 7, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 7, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 7, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 7, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 7, 2), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(1, 7, 2), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(3, 7, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 7, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 7, 3), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(3, 7, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 7, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 7, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 7, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 7, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 8, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 8, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 8, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 9, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 11, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 11, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 11, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 11, -3), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(2, 11, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 11, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 11, -2), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(2, 11, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 11, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 11, -1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(0, 11, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 11, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 11, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 11, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 12, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 12, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 12, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 12, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 12, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 12, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 12, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 12, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 12, -1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(-2, 12, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 13, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 13, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 13, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 13, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 13, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 13, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 13, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 13, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 13, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 13, 1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(-2, 13, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 13, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 13, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 13, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 13, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 13, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 13, 3), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(-2, 13, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 13, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 13, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 13, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 13, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 13, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 14, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 14, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 14, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 14, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 14, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 14, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 14, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 14, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 14, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 15, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 15, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 15, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 15, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 15, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 17, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 17, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 17, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 17, 1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(1, 17, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 17, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 17, 2), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(1, 17, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 17, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 17, 3), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(3, 17, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 17, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 17, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 17, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 17, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 18, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 18, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 18, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 18, -3), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(-3, 18, -3), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(-2, 18, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 18, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 18, -2), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(-1, 18, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 18, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 18, -1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(-2, 18, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 18, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 18, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 18, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 18, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 18, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 18, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 18, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 18, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 18, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 18, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 18, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 18, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 18, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 19, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 19, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 19, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 19, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 19, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 19, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 19, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 19, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 19, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 19, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 19, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 19, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 19, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 19, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 20, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 20, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 20, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 20, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 20, -1), boundsIn);
            }
        }
        return true;
    }

    //Log Placement
    private void treeLog(Set<BlockPos> setlogblock, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.EMBUR_PEDU.defaultBlockState(), boundingBox);
        }
    }

    //Log Placement
    private void treeBranch(Set<BlockPos> setlogblock, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.EMBUR_PEDU.defaultBlockState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs(Set<BlockPos> blockPos, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(blockPos, reader, pos, BYGBlockList.EMBUR_GEL_BLOCK.defaultBlockState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs2(Set<BlockPos> blockPos, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(blockPos, reader, pos, BYGBlockList.POLLEN_BLOCK.defaultBlockState(), boundingBox);
        }
    }


    private boolean doesTreeFit(LevelSimulatedReader reader, BlockPos blockPos, int height) {
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
            //Distance/Density of trees. Positive Values ONLY
            int distance = 0;

            for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
                for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
                    if (!canLogPlaceHere(reader, pos.set(x + xOffset, y + yOffset, z + zOffset))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}