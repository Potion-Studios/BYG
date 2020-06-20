package voronoiaoc.byg.common.world.feature.features.overworld.trees.willow.mutated;

import com.mojang.datafixers.Dynamic;
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

public class MutatedBayouTree1 extends BYGAbstractTreeFeature<NoFeatureConfig> {

    public MutatedBayouTree1(Function<Dynamic<?>, ? extends NoFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn) {
        int randTreeHeight = 23 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable(pos);

        if (pos.getY() >= 1 && pos.getY() + randTreeHeight + 1 < 256) {
            BlockPos blockpos = pos.down();
            if (!isSoil(worldIn, blockpos, getSapling())) {
                return false;
            } else if (!this.doesTreeFit(worldIn, pos, randTreeHeight)) {
                return false;
            } else {
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 2, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 3, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 4, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 5, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 6, 0), boundsIn);
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
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 3, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 3, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-6, 4, -8), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 4, -8), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-7, 4, -6), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 4, -6), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-6, 4, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-5, 5, -8), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-5, 5, -7), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-5, 5, -6), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 5, -6), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-6, 5, -5), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-5, 6, -6), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 6, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 6, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 7, -5), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 7, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 7, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 7, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 7, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 7, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3, 7, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 8, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 8, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 8, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 8, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 8, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 8, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 9, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 9, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 9, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 2, -9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 2, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 2, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 2, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 2, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 3, -9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 3, -9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 3, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 3, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 3, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 3, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 3, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 3, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 4, -9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 4, -9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 4, -9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 4, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 4, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 4, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 4, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 4, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 4, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 4, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 4, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 4, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 4, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 4, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 4, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 4, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 4, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 4, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 4, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 4, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 4, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 4, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 4, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 5, -9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 5, -9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 5, -9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 5, -9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 5, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 5, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 5, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 5, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 5, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 5, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 5, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 5, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 5, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 5, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 5, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 5, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-9, 5, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 5, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 5, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 5, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 5, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 5, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 5, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 5, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 5, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 5, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 5, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 5, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 5, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 5, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 6, -9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 6, -9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 6, -9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 6, -9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 6, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 6, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 6, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 6, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 6, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 6, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 6, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 6, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 6, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 6, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 6, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 6, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 6, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 6, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 6, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 6, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-9, 6, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 6, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 6, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 6, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 6, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 6, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 6, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 6, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 6, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 6, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 6, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 6, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 6, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 6, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 6, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 6, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 6, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 7, -9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 7, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 7, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 7, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 7, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 7, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 7, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 7, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 7, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 7, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 7, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 7, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 7, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 7, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 7, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, 7, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 7, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 7, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 7, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 7, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 7, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 7, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 7, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 7, -3), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-1, 7, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 8, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 8, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 8, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 8, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 8, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 8, -4), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-1, 8, -3), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-2, 8, -2), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(0, 8, -2), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-1, 9, -3), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-2, 9, -1), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(0, 10, -3), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-2, 10, -1), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-3, 10, 0), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(0, 11, -3), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-3, 11, 0), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(0, 12, -3), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-3, 12, 0), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-4, 12, 1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-1, 13, -4), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(0, 13, -4), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(1, 13, -4), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-1, 13, -3), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(0, 13, -3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(1, 13, -3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-1, 13, -2), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(0, 13, -2), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(1, 13, -2), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-4, 13, 1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(0, 14, -4), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-1, 14, -3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(0, 14, -3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(1, 14, -3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(0, 14, -2), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-5, 14, 0), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-4, 14, 0), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-3, 14, 0), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-5, 14, 1), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-4, 14, 1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-3, 14, 1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-5, 14, 2), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-4, 14, 2), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-3, 14, 2), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(0, 15, -4), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-1, 15, -3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(0, 15, -3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(1, 15, -3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(0, 15, -2), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-4, 15, 0), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-5, 15, 1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-4, 15, 1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-3, 15, 1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-4, 15, 2), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-1, 16, -3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(0, 16, -3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(1, 16, -3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-4, 16, 0), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-5, 16, 1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-4, 16, 1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-3, 16, 1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-4, 16, 2), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(0, 17, -3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-4, 17, 0), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-4, 17, 1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-4, 17, 2), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(0, 18, -3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-4, 18, 1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-4, 19, 1), boundsIn);
            }
        }
        return true;
    }

    //Log Placement
    private void treeLog(Set<BlockPos> setlogblock, IWorldGenerationReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canTreePlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.PINE_LOG.getDefaultState(), boundingBox);
        }
    }

    //Log Placement
    private void treeBranch(Set<BlockPos> setlogblock, IWorldGenerationReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canTreePlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.PINE_LOG.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs(Set<BlockPos> blockPos, IWorldGenerationReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        BlockPos.Mutable blockpos = new BlockPos.Mutable(pos);
        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos,  BYGBlockList.PINE_LEAVES.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void stem(Set<BlockPos> blockPos, IWorldGenerationReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        BlockPos.Mutable blockpos = new BlockPos.Mutable(pos);
        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos,  BYGBlockList.PINE_LEAVES.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void glowshroom(Set<BlockPos> blockPos, IWorldGenerationReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        BlockPos.Mutable blockpos = new BlockPos.Mutable(pos);
        if (isAir(reader, blockpos)) {
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
                    if (!canTreePlaceHere(reader, pos.setPos(x + xOffset, y + yOffset, z + zOffset))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}