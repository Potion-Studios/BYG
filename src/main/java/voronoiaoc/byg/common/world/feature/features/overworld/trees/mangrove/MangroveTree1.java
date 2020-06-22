package voronoiaoc.byg.common.world.feature.features.overworld.trees.mangrove;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Blocks;
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

public class MangroveTree1 extends BYGAbstractTreeFeature<NoFeatureConfig> {

    public MangroveTree1(Function<Dynamic<?>, ? extends NoFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn) {
        int randTreeHeight = 23 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getMaxHeight()) {
            BlockPos blockpos = pos.down();
            if (!isDesiredGround(worldIn, blockpos, Blocks.GRASS_BLOCK) || !isDesiredGround(worldIn, blockpos, BYGBlockList.MOSSY_STONE) ) {
                return false;
            } else if (!this.doesTreeFit(worldIn, pos, randTreeHeight)) {
                return false;
            } else {
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 3, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 4, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 5, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 6, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 7, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 8, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 9, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 10, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 0, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 0, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 0, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 0, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 0, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 0, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 1, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 1, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 1, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 1, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 2, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 2, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 2, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 3, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 3, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 3, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 4, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 4, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 4, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 5, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 5, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 5, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 6, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 7, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 10, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 10, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 10, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 10, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 10, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 10, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 10, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 10, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 9, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 9, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 10, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 10, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 10, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 10, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 10, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 10, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 10, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 10, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 10, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 10, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 10, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 10, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 10, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 10, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 10, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 10, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 10, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 10, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 10, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 10, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 10, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 11, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 11, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 11, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 11, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 11, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 11, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 11, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 11, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 11, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 11, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 11, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 11, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 11, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 11, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 11, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 11, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 11, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 11, 3), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 3, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 4, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 5, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 6, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 7, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 8, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 9, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 10, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 0, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 0, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 0, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 0, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 0, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 0, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 1, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 1, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 1, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 1, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 2, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 2, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 2, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 3, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 3, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 3, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 4, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 4, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 4, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 5, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 5, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 5, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 6, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 7, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 10, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 10, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 10, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 10, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 10, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 10, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 10, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 10, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 9, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 9, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 10, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 10, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 10, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 10, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 10, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 10, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 10, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 10, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 10, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 10, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 10, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 10, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 10, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 10, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 10, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 10, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 10, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 10, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 10, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 10, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 10, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 11, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 11, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 11, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 11, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 11, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 11, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 11, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 11, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 11, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 11, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 11, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 11, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 11, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 11, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 11, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 11, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 11, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 11, 3), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 3, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 4, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 5, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 6, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 7, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 8, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 9, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 10, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 0, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 0, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 0, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 0, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 0, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 0, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 1, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 1, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 1, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 1, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 2, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 2, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 2, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 3, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 3, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 3, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 4, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 4, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 4, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 5, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 5, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 5, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 6, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 7, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 10, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 10, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 10, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 10, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 10, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 10, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 10, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 10, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 9, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 9, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 10, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 10, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 10, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 10, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 10, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 10, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 10, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 10, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 10, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 10, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 10, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 10, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 10, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 10, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 10, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 10, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 10, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 10, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 10, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 10, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 10, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 11, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 11, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 11, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 11, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 11, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 11, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 11, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 11, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 11, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 11, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 11, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 11, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 11, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 11, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 11, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 11, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 11, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 11, 3), boundsIn);
            }
        }
        return true;
    }

    //Log Placement
    private void treeLog(Set<BlockPos> setlogblock, IWorldGenerationReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canTreePlaceHereWater(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.MANGROVE_LOG.getDefaultState(), boundingBox);
        }
    }

    //Log Placement
    private void treeBranch(Set<BlockPos> setlogblock, IWorldGenerationReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canTreePlaceHereWater(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.MANGROVE_LOG.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs(Set<BlockPos> blockPos, IWorldGenerationReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        BlockPos.Mutable blockpos = new BlockPos.Mutable(pos);
        if (isAirOrWater(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos,  BYGBlockList.MANGROVE_LEAVES.getDefaultState(), boundingBox);
        }
    }



    private boolean doesTreeFit(IWorldGenerationBaseReader reader, BlockPos blockPos, int height) {
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        BlockPos.Mutable pos = new BlockPos.Mutable();

        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
            //Distance/Density of trees. Positive Values ONLY
            int distance = 2;

            for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
                for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
                    if (!canTreePlaceHereWater(reader, pos.setPos(x + xOffset, y + yOffset, z + zOffset))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}