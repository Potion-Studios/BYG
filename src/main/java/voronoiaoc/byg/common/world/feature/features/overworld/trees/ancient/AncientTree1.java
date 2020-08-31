package voronoiaoc.byg.common.world.feature.features.overworld.trees.ancient;

import com.mojang.serialization.Codec;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelSimulatedRW;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.BoundingBox;

public class AncientTree1 extends BYGAbstractTreeFeature<NoneFeatureConfiguration> {

    public AncientTree1(Codec<NoneFeatureConfiguration> configIn) {
        super(configIn);
    }

    protected boolean place(Set<BlockPos> changedBlocks, WorldGenLevel worldIn, Random rand, BlockPos pos, BoundingBox boundsIn, boolean isSapling) {
        int randTreeHeight = 23 + rand.nextInt(5);
        BlockPos.MutableBlockPos mainmutable = new BlockPos.MutableBlockPos().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {

            if (!isDesiredGroundwDirtTag(worldIn, pos.below(), Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isSapling)) {
                return false;
            } else {
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 7, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 8, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 9, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 10, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 11, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 12, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 13, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 14, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 15, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 16, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 17, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 18, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 19, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 0, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 0, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 0, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, 0, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 0, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 0, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-3, 0, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 0, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 0, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 0, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 1, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 1, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, 1, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 1, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-3, 1, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 1, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 1, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 1, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 2, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, 2, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 2, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 2, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 2, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 2, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 3, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 3, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 3, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 3, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 3, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 3, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 4, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 4, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 4, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 4, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 5, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 5, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 5, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 6, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 6, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 6, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 6, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 6, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, 7, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 7, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 7, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 7, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 7, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 7, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, 8, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 8, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 8, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 8, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 8, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-3, 8, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 9, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 9, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 9, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, 9, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-3, 9, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 10, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 10, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, 10, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, 10, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 11, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(3, 11, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(3, 11, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, 12, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(3, 12, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(4, 12, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(3, 12, 5), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(3, 13, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(3, 13, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 13, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, 13, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(4, 13, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(5, 13, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(3, 13, 5), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(3, 13, 6), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 19, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 19, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 19, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 19, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, 19, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 19, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 19, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 19, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 20, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 20, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 20, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 20, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(3, 20, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(4, 20, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-4, 20, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-3, 20, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(3, 20, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-3, 20, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 20, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 20, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 20, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 20, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 8, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 8, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 8, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 8, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 8, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 8, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 8, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 8, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 8, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 8, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 8, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 8, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 8, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 8, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 8, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 8, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 8, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 8, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 8, -2), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(3, 8, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 9, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 9, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 9, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 9, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 9, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, 9, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 9, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 9, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 9, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, 9, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 9, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 9, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 9, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 9, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 9, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 9, 5), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(-3, 9, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 10, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 10, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 10, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 11, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 11, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 11, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 11, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 11, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 11, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 11, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 11, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 11, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 11, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 11, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 11, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 11, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 11, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 11, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 11, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 11, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 11, -1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(-2, 11, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 12, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 12, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 12, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 12, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 12, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 12, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 12, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 12, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 12, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 12, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 12, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 12, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 12, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 12, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 12, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, 12, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 12, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 12, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 12, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 12, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 12, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, 12, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 12, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 12, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 12, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 12, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 12, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, 12, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(7, 12, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 12, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 12, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 12, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, 12, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(7, 12, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 12, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 12, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 12, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 12, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, 12, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(7, 12, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 12, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 12, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 12, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 12, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 12, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 12, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, 12, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 12, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 12, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 12, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 12, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 12, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 12, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, 12, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 12, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 12, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 12, 8), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(3, 12, 2), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(3, 12, 3), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(5, 12, 3), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(1, 12, 4), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(1, 12, 5), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(4, 12, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 13, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 13, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 13, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 13, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 13, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 13, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 13, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 13, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 13, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 13, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 13, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 13, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, 13, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 13, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 13, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, 13, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 13, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 13, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 13, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 13, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 13, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, 13, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 13, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 13, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 13, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 13, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 13, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 13, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 13, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 14, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 14, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 14, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 14, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 14, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 14, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 14, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 14, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 14, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 14, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 14, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 14, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 14, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 18, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 18, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 18, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 18, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 18, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 18, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 18, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 18, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 18, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 19, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 19, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 19, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 19, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 19, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 19, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 19, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 19, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 19, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 19, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 19, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 19, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 19, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 19, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 19, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 19, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 19, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 19, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 19, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 19, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 19, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 19, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 19, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 19, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 19, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 19, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 19, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 19, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 19, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 19, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 19, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 19, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 19, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 19, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 19, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 19, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 19, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 19, 5), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(0, 19, -1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(2, 19, -1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(-1, 19, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 20, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 20, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 20, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 20, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 20, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 20, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 20, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 20, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 20, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 20, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 20, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 20, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 20, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 20, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 20, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 20, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 20, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 20, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 20, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 20, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, 20, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 20, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 20, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 20, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 20, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 20, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 20, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, 20, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 20, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 20, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 20, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 20, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 20, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 20, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-6, 20, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, 20, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 20, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 20, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 20, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 20, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 20, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 20, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, 20, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-6, 20, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, 20, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 20, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 20, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 20, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 20, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 20, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 20, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, 20, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, 20, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 20, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 20, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 20, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 20, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 20, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 20, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 20, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 20, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, 20, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, 20, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 20, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 20, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 20, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 20, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 20, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 20, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 20, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 20, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 20, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 20, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 20, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 20, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 20, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 20, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 20, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 20, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 20, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 20, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 20, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 20, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 20, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 20, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 20, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 20, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 20, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 20, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 20, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 20, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 20, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 20, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 20, 6), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(-1, 20, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 21, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 21, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 21, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 21, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 21, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 21, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 21, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 21, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 21, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 21, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 21, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 21, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 21, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 21, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 21, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 21, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 21, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 21, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 21, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 21, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 21, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 21, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 21, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 21, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 21, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 21, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 21, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 21, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 21, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 21, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 21, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, 21, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 21, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 21, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 21, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 21, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 21, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 21, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 21, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 21, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 21, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-6, 21, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, 21, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 21, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 21, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 21, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 21, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 21, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 21, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 21, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 21, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 21, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 21, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, 21, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 21, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 21, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 21, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 21, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 21, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 21, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 21, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 21, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 21, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 21, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 21, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 21, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 21, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 21, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 21, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 21, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 21, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 21, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 21, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 21, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 21, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 21, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 21, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 21, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 21, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 21, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 21, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 21, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 21, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 21, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 21, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 21, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 21, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 21, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 21, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 21, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 21, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 21, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 21, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 22, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 22, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 22, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 22, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 22, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 22, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 22, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 22, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 22, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 22, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 22, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 22, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 22, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 22, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 22, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 22, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 22, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 22, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 22, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 22, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 22, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 22, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 22, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 22, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 22, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 22, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 22, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 22, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 22, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 22, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 22, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 22, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 22, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 22, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 22, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 22, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 22, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 22, 3), boundsIn);

            }
        }
        return true;
    }

    //Log Placement
    private void treeLog(Set<BlockPos> setlogblock, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.MAPLE_LOG.defaultBlockState(), boundingBox);
        }
    }

    //Log Placement
    private void treeBranch(Set<BlockPos> setlogblock, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.MAPLE_LOG.defaultBlockState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs(Set<BlockPos> blockPos, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(blockPos, reader, pos, BYGBlockList.SILVER_MAPLE_LEAVES.defaultBlockState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs2(Set<BlockPos> blockPos, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(blockPos, reader, pos, BYGBlockList.POLLEN_BLOCK.defaultBlockState(), boundingBox);
        }
    }

    //Leaves Placement
    private void roots(Set<BlockPos> blockPos, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(blockPos, reader, pos, BYGBlockList.WEEPING_ROOTS.defaultBlockState(), boundingBox);
        }
    }


    private boolean doesTreeFit(LevelSimulatedRW reader, BlockPos blockPos, int height) {
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