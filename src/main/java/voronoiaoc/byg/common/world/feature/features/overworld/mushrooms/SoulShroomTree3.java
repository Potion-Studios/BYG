package voronoiaoc.byg.common.world.feature.features.overworld.mushrooms;

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

public class SoulShroomTree3 extends BYGAbstractTreeFeature<NoFeatureConfig> {

    public SoulShroomTree3(Codec<NoFeatureConfig> configIn) {
        super(configIn);
    }

    public boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling) {
        int randTreeHeight = 11 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            BlockPos blockpos = pos.down();
            if (!isDesiredGroundwDirtTag(worldIn, blockpos, BYGBlockList.SYTHIAN_NYLIUM)) {
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
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 5, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 6, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 6, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 6, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 6, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 7, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 7, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 7, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 7, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 7, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 7, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 7, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 8, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 8, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 8, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 8, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 8, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 8, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 9, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 9, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 9, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 9, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 9, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3, 9, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3, 9, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 10, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 10, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3, 10, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3, 10, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(4, 10, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 11, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(4, 11, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(4, 12, -3), boundsIn);
                this.vines(changedBlocks, worldIn, mainmutable.add(5, 8, -5), boundsIn);
                this.vines(changedBlocks, worldIn, mainmutable.add(-5, 9, -4), boundsIn);
                this.vines(changedBlocks, worldIn, mainmutable.add(-4, 9, -2), boundsIn);
                this.vines(changedBlocks, worldIn, mainmutable.add(3, 9, -4), boundsIn);
                this.vines(changedBlocks, worldIn, mainmutable.add(4, 9, -1), boundsIn);
                this.vinesplant(changedBlocks, worldIn, mainmutable.add(5, 9, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 10, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 10, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 10, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 10, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 10, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 10, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 10, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, -2), boundsIn);
                this.vines(changedBlocks, worldIn, mainmutable.add(-1, 10, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 10, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 10, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, 5), boundsIn);
                this.vinesplant(changedBlocks, worldIn, mainmutable.add(3, 10, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 10, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 10, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 10, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 10, 5), boundsIn);
                this.vinesplant(changedBlocks, worldIn, mainmutable.add(4, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 10, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 10, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 10, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 10, 5), boundsIn);
                this.vinesplant(changedBlocks, worldIn, mainmutable.add(5, 10, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 10, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 10, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 11, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 11, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 11, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 11, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 11, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 11, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 11, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 11, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 11, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 11, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 11, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 11, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 11, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 11, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 11, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 11, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 11, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 11, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 11, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 11, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 11, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 11, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 11, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 11, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 11, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 11, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 11, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 11, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 11, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 11, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 11, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 11, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 11, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 11, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 11, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 11, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 11, 4), boundsIn);
                this.vinesplant(changedBlocks, worldIn, mainmutable.add(3, 11, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 11, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 11, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 11, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 11, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 11, 5), boundsIn);
                this.vinesplant(changedBlocks, worldIn, mainmutable.add(4, 11, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 11, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 11, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 11, 4), boundsIn);
                this.vinesplant(changedBlocks, worldIn, mainmutable.add(5, 11, -5), boundsIn);
                this.vines(changedBlocks, worldIn, mainmutable.add(5, 11, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 11, 3), boundsIn);
                this.vines(changedBlocks, worldIn, mainmutable.add(6, 11, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 12, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 12, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 12, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 12, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 12, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 12, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 12, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 12, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 12, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 12, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 12, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 12, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 12, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 12, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 12, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 12, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 12, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 12, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 12, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 12, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 12, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 12, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 12, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 12, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 12, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 12, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 12, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 12, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 12, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 12, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 12, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 12, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 12, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 12, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 12, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 12, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 12, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 12, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 12, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 12, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 12, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 12, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 12, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 12, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 12, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 12, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 12, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 12, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 12, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 12, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 12, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 12, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 12, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 12, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 12, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 12, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, 12, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, 12, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, 12, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 13, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 13, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 13, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 13, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 13, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 13, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 13, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 13, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 13, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 13, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 13, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 13, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 13, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 13, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 13, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 13, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 13, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 13, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 13, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 13, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 13, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 13, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 13, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 13, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 13, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 13, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 13, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 13, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 13, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 13, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 13, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 13, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 13, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 13, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 13, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 13, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 13, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 13, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 13, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 13, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 13, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 13, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 13, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, 13, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 14, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 14, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 14, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 14, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 14, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 14, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 14, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 14, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 14, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 14, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 14, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 14, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 14, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 14, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 14, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 14, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 14, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 14, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 14, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 14, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 14, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 14, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 14, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, 14, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 15, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 15, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 15, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 15, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 15, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 15, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 15, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 15, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 15, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 15, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 16, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 16, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 17, -3), boundsIn);
            }
        }
        return true;
    }

    //Log Placement
    private void treeLog(Set<BlockPos> setlogblock, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.SOUL_SHROOM_STEM.getDefaultState(), boundingBox);
        }
    }

    //Log Placement
    private void treeBranch(Set<BlockPos> setlogblock, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.SOUL_SHROOM_STEM.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs(Set<BlockPos> blockPos, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(blockPos, reader, pos, BYGBlockList.SOUL_SHROOM_BLOCK.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void vines(Set<BlockPos> blockPos, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(blockPos, reader, pos, BYGBlockList.SOUL_SHROOM_SPORE_END.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void vinesplant(Set<BlockPos> blockPos, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(blockPos, reader, pos, BYGBlockList.SOUL_SHROOM_SPORE.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void shroomlight(Set<BlockPos> blockPos, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(blockPos, reader, pos, Blocks.SHROOMLIGHT.getDefaultState(), boundingBox);
        }
    }



    private boolean doesTreeFit(IWorldGenerationBaseReader reader, BlockPos blockPos, int height) {
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        BlockPos.Mutable pos = new BlockPos.Mutable();

        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
            //Distance/Density of trees. Positive Values ONLY
            int distance = 0;

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