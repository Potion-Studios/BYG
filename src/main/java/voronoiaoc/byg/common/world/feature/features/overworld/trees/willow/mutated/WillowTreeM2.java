package voronoiaoc.byg.common.world.feature.features.overworld.trees.willow.mutated;

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

public class WillowTreeM2 extends BYGAbstractTreeFeature<NoFeatureConfig> {

    public WillowTreeM2(Function<Dynamic<?>, ? extends NoFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn) {
        int randTreeHeight = 23 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable(pos);

        if (pos.getY() >= 1 && pos.getY() + randTreeHeight + 1 < worldIn.getMaxHeight()) {
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
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 0, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 0, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 0, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 0, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 1, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 1, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 2, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 2, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 2, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 2, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 3, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 3, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3, 5, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(6, 5, 7), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 6, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3, 6, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(4, 6, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 6, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-8, 6, 5), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 6, 5), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(6, 6, 5), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 6, 6), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(6, 6, 6), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(4, 6, 9), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-6, 7, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-5, 7, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 7, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-9, 7, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-5, 7, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 7, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-8, 7, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-7, 7, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-6, 7, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 7, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-7, 7, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3, 7, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-5, 7, 5), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 7, 5), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-7, 7, 6), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-5, 7, 6), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3, 7, 6), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(5, 7, 6), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 7, 7), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(4, 7, 7), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 7, 8), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3, 7, 8), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(4, 7, 9), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 8, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 8, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-5, 8, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 8, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3, 8, 6), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 9, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 9, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 9, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 9, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 9, 5), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3, 9, 6), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 10, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 10, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 10, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 10, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 3, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(7, 3, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 3, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 3, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(7, 3, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 3, 9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 3, 9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 4, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 4, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-9, 4, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 4, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 4, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 4, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 4, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 4, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-9, 4, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 4, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 4, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 4, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 4, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 4, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, 4, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-9, 4, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 4, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 4, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(7, 4, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 4, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 4, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(7, 4, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 4, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 4, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 4, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, 4, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(7, 4, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 4, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 4, 9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 4, 9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 4, 9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 5, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 5, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 5, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 5, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-9, 5, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 5, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 5, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-10, 5, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 5, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 5, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 5, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 5, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-10, 5, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-9, 5, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 5, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 5, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 5, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 5, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 5, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 5, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-9, 5, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 5, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 5, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 5, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 5, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 5, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, 5, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-9, 5, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 5, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 5, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 5, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 5, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 5, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, 5, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(7, 5, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 5, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 5, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 5, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 5, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 5, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 5, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 5, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(7, 5, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 5, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 5, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 5, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 5, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(7, 5, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 5, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 5, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 5, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, 5, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 5, 9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 5, 9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 5, 9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 5, 10), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 5, 10), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 6, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 6, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 6, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 6, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 6, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-9, 6, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 6, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 6, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 6, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 6, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 6, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 6, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-10, 6, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-9, 6, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 6, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 6, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 6, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 6, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 6, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 6, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 6, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 6, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-10, 6, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-9, 6, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 6, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 6, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 6, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 6, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 6, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 6, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-10, 6, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-9, 6, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 6, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 6, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 6, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 6, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 6, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 6, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 6, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 6, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 6, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, 6, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-9, 6, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 6, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 6, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 6, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 6, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 6, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 6, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 6, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 6, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 6, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(7, 6, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 6, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 6, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 6, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 6, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 6, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 6, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 6, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 6, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 6, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 6, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 6, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(7, 6, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 6, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 6, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 6, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 6, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 6, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 6, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 6, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 6, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 6, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 6, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, 6, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(7, 6, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 6, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 6, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 6, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 6, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, 6, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 6, 9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 6, 9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 6, 9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 6, 9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 6, 10), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 6, 10), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 6, 10), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 7, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 7, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 7, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 7, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 7, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-9, 7, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 7, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 7, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 7, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 7, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-10, 7, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 7, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 7, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 7, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 7, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 7, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 7, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 7, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 7, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-10, 7, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-9, 7, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 7, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 7, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 7, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 7, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 7, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 7, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-10, 7, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-9, 7, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 7, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 7, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 7, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 7, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 7, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 7, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 7, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 7, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 7, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 7, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 7, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, 7, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-9, 7, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 7, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 7, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 7, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 7, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 7, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 7, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 7, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 7, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 7, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 7, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 7, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 7, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(7, 7, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 7, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 7, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 7, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 7, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 7, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 7, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 7, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 7, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(7, 7, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 7, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 7, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 7, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 7, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 7, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 7, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 7, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 7, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 7, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, 7, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(7, 7, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 7, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 7, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 7, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 7, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, 7, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 7, 9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 7, 9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 7, 9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 7, 9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 7, 10), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 7, 10), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 7, 10), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-9, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-9, 8, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 8, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 8, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 8, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 8, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 8, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 8, 3), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-2, 8, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 8, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 8, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-9, 8, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 8, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 8, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 8, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 8, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 8, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 8, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 8, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 8, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 8, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 8, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 8, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 8, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 8, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 8, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 8, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 8, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 8, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 8, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, 8, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 8, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 8, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 8, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 8, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 8, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 8, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 8, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, 8, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 8, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 8, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 8, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 8, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 8, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, 8, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 8, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 8, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 8, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 8, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, 9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 8, 9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 8, 9), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-2, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 9, 2), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-3, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 9, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 9, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 9, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 9, 3), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-2, 9, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 9, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 9, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 9, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 9, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 9, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 9, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 9, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 9, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 9, 7), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-2, 10, 1), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-2, 10, 2), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-2, 10, 3), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-2, 11, 2), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-2, 12, 2), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-2, 13, 2), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-1, 13, 2), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-1, 14, 2), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-1, 15, 2), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-3, 16, -1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-2, 16, -1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(0, 16, -1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(1, 16, -1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-4, 16, 0), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-3, 16, 0), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(1, 16, 0), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(2, 16, 0), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-4, 16, 1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(2, 16, 1), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-1, 16, 2), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-4, 16, 3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(2, 16, 3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-4, 16, 4), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-3, 16, 4), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(1, 16, 4), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(2, 16, 4), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-3, 16, 5), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-2, 16, 5), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(0, 16, 5), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(1, 16, 5), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-1, 17, -1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-2, 17, 0), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-1, 17, 0), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(0, 17, 0), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-3, 17, 1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-2, 17, 1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-1, 17, 1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(0, 17, 1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(1, 17, 1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-4, 17, 2), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-3, 17, 2), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-2, 17, 2), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-1, 17, 2), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(0, 17, 2), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(1, 17, 2), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-3, 17, 3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-2, 17, 3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-1, 17, 3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(0, 17, 3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(1, 17, 3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-2, 17, 4), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-1, 17, 4), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(0, 17, 4), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-1, 17, 5), boundsIn);
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
        if (isAirOrWater(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos,  BYGBlockList.CYPRESS_LEAVES.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void stem(Set<BlockPos> blockPos, IWorldGenerationReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        BlockPos.Mutable blockpos = new BlockPos.Mutable(pos);
        if (isAirOrWater(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos,  BYGBlockList.PINE_LEAVES.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void glowshroom(Set<BlockPos> blockPos, IWorldGenerationReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        BlockPos.Mutable blockpos = new BlockPos.Mutable(pos);
        if (isAirOrWater(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos,  BYGBlockList.PINE_LEAVES.getDefaultState(), boundingBox);
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