package voronoiaoc.byg.common.world.feature.features.overworld.trees.cypress;

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

public class CypressTree2 extends BYGAbstractTreeFeature<NoFeatureConfig> {

    public CypressTree2(Function<Dynamic<?>, ? extends NoFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn) {
        int randTreeHeight = 23 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable(pos);

        if (pos.getY() >= 1 && pos.getY() + randTreeHeight + 1 < 256) {
            BlockPos blockpos = pos.down();
            if (!isDesiredGround(worldIn, blockpos, Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.doesTreeFit(worldIn, pos, randTreeHeight)) {
                return false;
            } else {
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 0, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 1, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 2, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 3, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 4, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 5, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 6, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 7, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 8, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 9, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 10, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 11, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 12, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 13, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 14, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 0, -5), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 0, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 0, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 0, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 0, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(4, 0, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-5, 0, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 0, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 0, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(5, 0, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 0, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 0, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(4, 0, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 0, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 0, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 0, 5), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 1, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(4, 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 1, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 2, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 2, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3, 2, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 2, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 3, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 3, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 3, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 3, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 3, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 3, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 3, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 3, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 4, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 4, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 4, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 4, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 5, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 5, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 7, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 7, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 8, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 8, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 9, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 13, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 13, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 14, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 14, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 14, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 14, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 14, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 14, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 14, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 15, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3, 15, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 15, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 15, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 7, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 7, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 7, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 7, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 7, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 7, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 7, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 7, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 7, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 7, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 7, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 7, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 7, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 7, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 7, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 7, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 7, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 7, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 7, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 7, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 7, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 7, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 7, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 7, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 7, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 7, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 7, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 7, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 7, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 7, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 7, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 7, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 7, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 7, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 7, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 7, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 7, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 7, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 7, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 7, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 7, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 8, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 8, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 8, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 8, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 8, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 8, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 8, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 8, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 8, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 8, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 8, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 8, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 8, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 8, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 8, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 8, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 8, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 8, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 8, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 8, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 8, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 8, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 8, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 8, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 8, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 8, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 8, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 8, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 8, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 8, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 8, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 8, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 8, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 8, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 8, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 9, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 9, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 9, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 9, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 9, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 9, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 9, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 9, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 9, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 9, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 9, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 9, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 9, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 15, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 15, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 15, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 15, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 15, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 15, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 15, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 15, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 15, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 15, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 15, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 15, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 15, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 15, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 15, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 15, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 15, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 15, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 15, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 15, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 15, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 15, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 15, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 15, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 15, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 15, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 15, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 15, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 15, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 15, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 15, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 15, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 15, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 15, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 15, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 15, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 15, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 15, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 15, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 15, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 15, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 15, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 15, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 15, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 15, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 15, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, 15, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 15, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 15, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 15, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 15, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 15, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 15, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 15, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 15, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 15, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 15, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 15, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, 15, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 15, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 15, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 15, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 15, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 15, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 15, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 15, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 15, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 15, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 15, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 15, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, 15, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 15, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 15, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 15, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 15, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 15, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 15, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 15, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 15, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 15, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 15, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 15, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 15, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, 15, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 15, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 15, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 15, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 15, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 15, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 15, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 15, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 15, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 15, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 15, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 15, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 15, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 15, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 15, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 15, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 15, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 15, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 15, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 15, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 15, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 15, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 15, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 15, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 15, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 15, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 15, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 15, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 15, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 15, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 15, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 15, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 15, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 15, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 15, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 15, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 15, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 15, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 15, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 15, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 15, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 16, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 16, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 16, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 16, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 16, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 16, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 16, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 16, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 16, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 16, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 16, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 16, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 16, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 16, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 16, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 16, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 16, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 16, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 16, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 16, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 16, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 16, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 16, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 16, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 16, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 16, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 16, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 16, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 16, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 16, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 16, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 16, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 16, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 16, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 16, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 16, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 16, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 16, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 16, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 16, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 16, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 16, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 16, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 16, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 16, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 16, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 16, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 16, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 16, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 16, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 16, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 16, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 16, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 16, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 16, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 16, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 16, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 16, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 16, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 16, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 16, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 16, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 16, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 16, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 16, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 16, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 16, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 16, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 16, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 16, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 16, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 16, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 16, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 16, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 16, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 16, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 16, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 16, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 16, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 16, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 16, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 16, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 16, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 16, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 16, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 16, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 16, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 16, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 16, 5), boundsIn);
            }
        }
        return true;
    }

    //Log Placement
    private void treeLog(Set<BlockPos> setlogblock, IWorldGenerationReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canTreePlaceHereWater(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.CYPRESS_LOG.getDefaultState(), boundingBox);
        }
    }

    //Log Placement
    private void treeBranch(Set<BlockPos> setlogblock, IWorldGenerationReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canTreePlaceHereWater(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.CYPRESS_LOG.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs(Set<BlockPos> blockPos, IWorldGenerationReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        BlockPos.Mutable blockpos = new BlockPos.Mutable(pos);
        if (isAirLeavesOrWater(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos,  BYGBlockList.CYPRESS_LEAVES.getDefaultState(), boundingBox);
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