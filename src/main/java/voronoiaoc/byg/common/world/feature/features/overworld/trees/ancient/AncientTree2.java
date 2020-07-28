package voronoiaoc.byg.common.world.feature.features.overworld.trees.ancient;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;

public class AncientTree2 extends BYGAbstractTreeFeature<DefaultFeatureConfig> {

    public AncientTree2(Codec<DefaultFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean place(Set<BlockPos> changedBlocks, StructureWorldAccess worldIn, Random rand, BlockPos pos, BlockBox boundsIn) {
        int randTreeHeight = 23 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            BlockPos blockpos = pos.down();
            if (!isDesiredGroundwDirtTag(worldIn, blockpos, Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.doesTreeFit(worldIn, pos, randTreeHeight)) {
                return false;
            } else {
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 0, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 1, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 2, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 3, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 4, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 14, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 0, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 0, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 0, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 0, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 0, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 0, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 0, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 0, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 0, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 0, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 0, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 0, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 0, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 1, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 1, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 1, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 1, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 1, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 2, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 2, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 2, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 2, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 2, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 3, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 3, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 3, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 3, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 3, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 3, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 4, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 4, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 4, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 4, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 4, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 4, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 4, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 5, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 5, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 5, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 5, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 5, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 5, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 5, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 5, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 6, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 6, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 6, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 6, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 6, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 6, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 6, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 7, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 7, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 7, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 7, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 7, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 7, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 8, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 8, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 8, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 8, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 8, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 8, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 9, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 9, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-5, 9, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 9, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 9, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-6, 9, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 9, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 9, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 9, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 10, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 10, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 10, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 11, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 11, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 11, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 12, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 12, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 12, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 12, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 12, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 13, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 13, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 13, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 13, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 13, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 13, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 13, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 13, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 13, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 13, 5), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 13, 6), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 13, 6), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 14, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 14, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 14, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 14, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 14, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 14, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 14, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 14, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-5, 14, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 14, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 14, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 14, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 14, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 14, 5), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 14, 5), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 14, 6), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 14, 6), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 14, 6), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 14, 6), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 14, 7), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 15, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 15, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 15, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 15, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-5, 15, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 15, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-6, 15, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-5, 15, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 15, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-5, 15, 5), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 15, 6), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 15, 6), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 15, 7), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 16, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-5, 16, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 16, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 16, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 16, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 16, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 16, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 16, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 16, 5), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 16, 5), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 16, 6), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 16, 6), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 16, 7), boundsIn);
                this.roots(changedBlocks, worldIn, mainmutable.add(-3, 8, -3), boundsIn);
                this.roots(changedBlocks, worldIn, mainmutable.add(-5, 8, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 9, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 9, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 9, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 9, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 9, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 9, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 9, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 9, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 9, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 9, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 9, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 9, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 9, 1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-5, 9, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 10, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 10, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 10, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 10, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 10, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 10, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 10, 0), boundsIn);
                this.roots(changedBlocks, worldIn, mainmutable.add(-2, 12, 1), boundsIn);
                this.roots(changedBlocks, worldIn, mainmutable.add(-1, 12, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 13, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 13, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 13, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 13, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 13, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 13, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 13, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 13, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 13, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 13, 8), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-1, 13, 2), boundsIn);
                this.roots(changedBlocks, worldIn, mainmutable.add(-5, 13, 4), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-1, 13, 4), boundsIn);
                this.roots(changedBlocks, worldIn, mainmutable.add(2, 13, 4), boundsIn);
                this.roots(changedBlocks, worldIn, mainmutable.add(0, 13, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 14, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 14, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 14, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 14, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 14, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 14, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 14, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 14, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 14, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 14, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 14, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 14, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 14, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 14, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 14, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 14, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 14, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 14, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 14, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 14, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 14, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 14, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 14, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 14, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 14, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 14, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 14, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 14, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 14, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 14, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 14, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 14, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 14, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 14, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 14, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 14, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 14, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 14, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 14, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 14, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 14, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 14, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 14, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 14, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 14, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 14, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 14, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 14, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 14, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 14, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 14, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 14, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 14, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 14, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 14, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 14, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 14, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 14, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 14, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 14, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 14, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 14, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 14, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 14, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 14, 9), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(0, 14, 1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-3, 14, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 15, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 15, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 15, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 15, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 15, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 15, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 15, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 15, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 15, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 15, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 15, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 15, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 15, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 15, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 15, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 15, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 15, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 15, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 15, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 15, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 15, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 15, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 15, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 15, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 15, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 15, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 15, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 15, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 15, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 15, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 15, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 15, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 15, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 15, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, 15, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 15, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 15, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 15, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 15, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 15, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 15, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 15, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 15, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 15, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 15, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 15, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 15, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 15, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 15, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 15, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 15, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 15, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 15, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 15, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 15, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 15, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 16, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 16, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 16, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 16, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 16, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 16, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 16, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 16, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 16, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 16, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 16, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 16, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 16, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 16, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 16, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 16, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 16, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 16, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 16, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 16, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 16, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 16, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 16, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 16, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 16, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 16, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 16, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 16, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 16, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 16, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 16, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 16, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 16, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 16, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 16, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 16, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 16, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 16, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 16, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 16, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 16, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 16, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 16, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 16, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 16, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 16, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 16, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 17, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 17, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 17, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 17, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 17, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 17, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 17, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 17, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 17, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 17, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 17, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 17, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 17, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 17, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 17, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 17, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 17, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 17, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 17, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 17, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 17, 7), boundsIn);
            }
        }
        return true;
    }

    //Log Placement
    private void treeLog(Set<BlockPos> setlogblock, StructureWorldAccess reader, BlockPos pos, BlockBox boundingBox) {
        if (canTreePlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.EBONY_LOG.getDefaultState(), boundingBox);
        }
    }

    //Log Placement
    private void treeBranch(Set<BlockPos> setlogblock, StructureWorldAccess reader, BlockPos pos, BlockBox boundingBox) {
        if (canTreePlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.EBONY_LOG.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs(Set<BlockPos> blockPos, StructureWorldAccess reader, BlockPos pos, BlockBox boundingBox) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(blockPos, reader, pos, BYGBlockList.EBONY_LEAVES.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs2(Set<BlockPos> blockPos, StructureWorldAccess reader, BlockPos pos, BlockBox boundingBox) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(blockPos, reader, pos, BYGBlockList.POLLEN_BLOCK.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void roots(Set<BlockPos> blockPos, StructureWorldAccess reader, BlockPos pos, BlockBox boundingBox) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(blockPos, reader, pos, BYGBlockList.WEEPING_ROOTS.getDefaultState(), boundingBox);
        }
    }


    private boolean doesTreeFit(ModifiableTestableWorld reader, BlockPos blockPos, int height) {
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        BlockPos.Mutable pos = new BlockPos.Mutable();

        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
            //Distance/Density of trees. Positive Values ONLY
            int distance = 0;

            for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
                for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
                    if (!canTreePlaceHere(reader, pos.set(x + xOffset, y + yOffset, z + zOffset))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}