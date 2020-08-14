package voronoiaoc.byg.common.world.feature.features.overworld.trees.ebony;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;

public class EbonyBush1 extends BYGAbstractTreeFeature<NoFeatureConfig> {

    public EbonyBush1(Codec<NoFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling) {
        int randTreeHeight = 23 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {

            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isSapling)) {
                return false;
            } else {
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 0, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 1, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 2, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 7, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 0, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 0, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 0, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 0, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 0, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 0, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 0, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 0, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 0, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 1, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 1, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 1, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 1, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 2, -5), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 2, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 2, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 2, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 2, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 2, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 2, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 2, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 3, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(4, 3, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 3, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 3, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 3, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 3, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 3, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 4, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 4, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 4, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 4, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 4, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3, 4, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 4, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 5, -5), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 5, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 5, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 5, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 5, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 5, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 5, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 6, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 6, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-5, 6, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3, 6, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 7, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 7, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 7, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 7, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 8, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 8, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 8, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 8, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 9, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 10, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 1, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 1, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 1, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 1, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 2, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 2, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 2, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 3, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 3, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 3, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 3, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 3, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 3, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 3, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 3, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 3, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 3, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 3, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 4, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 4, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 4, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 4, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 4, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 4, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 4, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 4, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 4, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 4, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 4, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 4, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 4, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 4, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 4, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 4, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 4, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 4, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 4, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 4, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 4, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 4, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 4, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 4, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 4, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 4, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 4, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 4, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 4, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 4, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 4, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 4, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 4, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 4, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 4, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 4, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 4, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 4, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 4, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 4, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 4, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 4, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 4, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 4, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 4, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 4, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 5, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 5, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 5, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 5, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 5, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 5, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 5, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 5, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 5, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 5, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 5, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 5, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 5, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 5, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 5, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 5, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 5, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 5, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 5, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 5, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 5, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 5, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 5, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 5, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 5, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 5, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 5, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 5, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 5, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 5, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 5, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 5, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 5, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 5, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 5, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 5, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 5, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 5, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 5, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 5, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 5, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 5, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 5, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 5, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 5, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 6, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 6, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 6, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 6, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 6, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 6, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 6, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 6, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 6, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 6, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 6, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 6, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 6, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 6, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 6, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 6, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 6, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 6, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 6, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 6, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 6, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 6, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 6, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 6, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 6, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 6, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 6, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 6, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 6, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 6, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 6, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 6, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 6, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 6, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 6, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 6, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 6, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 6, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 6, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 6, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 6, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 6, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 6, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 6, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 6, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 6, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 6, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 6, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 7, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 7, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 7, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 7, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 7, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 7, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 7, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 7, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 7, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 7, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 7, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 7, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 7, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 7, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 7, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 7, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 7, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 7, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 7, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 7, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 7, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 7, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 7, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 7, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 7, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 7, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 7, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 7, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 7, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 7, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 7, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 7, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 7, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 7, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 7, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 7, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 7, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 7, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 7, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 7, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 7, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 7, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 8, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 8, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 8, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 8, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 8, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 8, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 8, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 8, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 8, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 8, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 8, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 8, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 8, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 9, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 9, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 9, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 9, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 9, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 9, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 10, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 11, 0), boundsIn);
            }
        }
        return true;
    }

    //Log Placement
    private void treeLog(Set<BlockPos> setlogblock, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.EBONY_LOG.getDefaultState(), boundingBox);
        }
    }

    //Log Placement
    private void treeBranch(Set<BlockPos> setlogblock, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.EBONY_LOG.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs(Set<BlockPos> blockPos, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        BlockPos.Mutable blockpos = new BlockPos.Mutable().setPos(pos);
        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos, BYGBlockList.EBONY_LEAVES.getDefaultState(), boundingBox);
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
                    if (!canLogPlaceHere(reader, pos.setPos(x + xOffset, y + yOffset, z + zOffset))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}