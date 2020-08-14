package voronoiaoc.byg.common.world.feature.features.overworld.trees.willow.mutated;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;

public class WillowTreeM1 extends BYGAbstractTreeFeature<NoFeatureConfig> {

    public WillowTreeM1(Codec<NoFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling) {
        int randTreeHeight = 6 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {

            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isSapling)) {
                return false;
            } else {
                for (int buildTrunk = 0; buildTrunk <= randTreeHeight; buildTrunk++) {
                    this.treeLog(changedBlocks, worldIn, mainmutable, boundsIn);

                    mainmutable.move(Direction.UP);
                }
                mainmutable.setPos(pos);

                BlockPos.Mutable rootMutable = new BlockPos.Mutable().setPos(mainmutable.add(0, 0, -2));
                BlockPos.Mutable rootMutable2 = new BlockPos.Mutable().setPos(mainmutable.add(-2, 0, 0));
                BlockPos.Mutable rootMutable3 = new BlockPos.Mutable().setPos(mainmutable.add(2, 0, 0));
                BlockPos.Mutable rootMutable4 = new BlockPos.Mutable().setPos(mainmutable.add(0, 0, 2));

                for (int buildRoot = 0; buildRoot <= 5; buildRoot++) {
                    this.treeBranch(changedBlocks, worldIn, rootMutable, boundsIn);
                    this.treeBranch(changedBlocks, worldIn, rootMutable2, boundsIn);
                    this.treeBranch(changedBlocks, worldIn, rootMutable3, boundsIn);
                    this.treeBranch(changedBlocks, worldIn, rootMutable4, boundsIn);

                    rootMutable.move(Direction.DOWN);
                    rootMutable2.move(Direction.DOWN);
                    rootMutable3.move(Direction.DOWN);
                    rootMutable4.move(Direction.DOWN);
                }

                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 1, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 1, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight - 4, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight - 4, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight - 4, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight - 4, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight - 3, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight - 3, 1), boundsIn);

                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-6, randTreeHeight - 2, -8), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight - 2, -8), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-7, randTreeHeight - 2, -6), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight - 2, -6), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-6, randTreeHeight - 2, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight - 1, -8), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight - 1, -7), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight - 1, -6), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight - 1, -6), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-6, randTreeHeight - 1, -5), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight, -6), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 1, -5), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 1, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 1, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 1, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 1, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 2, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 2, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 2, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 2, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 2, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 2, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 3, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 3, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight - 4, -9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, randTreeHeight - 4, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight - 4, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, randTreeHeight - 4, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight - 4, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight - 4, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, randTreeHeight - 3, -9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight - 3, -9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, randTreeHeight - 3, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight - 3, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, randTreeHeight - 3, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, randTreeHeight - 3, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight - 3, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, randTreeHeight - 3, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight - 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight - 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, randTreeHeight - 2, -9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight - 2, -9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight - 2, -9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, randTreeHeight - 2, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight - 2, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight - 2, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, randTreeHeight - 2, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, randTreeHeight - 2, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight - 2, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight - 2, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight - 2, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight - 2, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, randTreeHeight - 2, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight - 2, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, randTreeHeight - 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, randTreeHeight - 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight - 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, randTreeHeight - 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight - 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight - 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, randTreeHeight - 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight - 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight - 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, randTreeHeight - 1, -9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight - 1, -9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight - 1, -9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight - 1, -9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, randTreeHeight - 1, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight - 1, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, randTreeHeight - 1, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, randTreeHeight - 1, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, randTreeHeight - 1, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight - 1, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight - 1, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight - 1, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, randTreeHeight - 1, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, randTreeHeight - 1, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, randTreeHeight - 1, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight - 1, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-9, randTreeHeight - 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, randTreeHeight - 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, randTreeHeight - 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight - 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight - 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight - 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, randTreeHeight - 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, randTreeHeight - 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight - 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight - 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight - 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, randTreeHeight - 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight - 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight - 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, randTreeHeight, -9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight, -9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight, -9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight, -9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, randTreeHeight, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, randTreeHeight, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, randTreeHeight, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, randTreeHeight, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, randTreeHeight, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, randTreeHeight, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, randTreeHeight, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, randTreeHeight, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-9, randTreeHeight, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, randTreeHeight, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, randTreeHeight, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, randTreeHeight, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, randTreeHeight, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, randTreeHeight, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, randTreeHeight, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, randTreeHeight, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 1, -9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, randTreeHeight + 1, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight + 1, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 1, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 1, -8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, randTreeHeight + 1, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, randTreeHeight + 1, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight + 1, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 1, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 1, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, randTreeHeight + 1, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, randTreeHeight + 1, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight + 1, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 1, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 1, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-8, randTreeHeight + 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, randTreeHeight + 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, randTreeHeight + 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight + 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-7, randTreeHeight + 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, randTreeHeight + 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight + 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight + 1, -3), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 1, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight + 2, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 2, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, randTreeHeight + 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight + 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight + 2, -4), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 2, -3), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 2, -2), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 2, -2), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 3, -3), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 3, -1), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 4, -3), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 4, -1), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 4, 0), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 5, -3), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 5, 0), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 6, -3), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 6, 0), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 6, 1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 7, -4), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 7, -4), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 7, -4), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 7, -3), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 7, -3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 7, -3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 7, -2), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 7, -2), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 7, -2), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 7, 1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 8, -4), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 8, -3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 8, -3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 8, -3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 8, -2), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight + 8, 0), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 8, 0), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 8, 0), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight + 8, 1), boundsIn);
                this.stem(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 8, 1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 8, 1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight + 8, 2), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 8, 2), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 8, 2), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 9, -4), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 9, -3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 9, -3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 9, -3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 9, -2), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 9, 0), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight + 9, 1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 9, 1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 9, 1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 9, 2), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 10, -3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 10, -3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 10, -3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 10, 0), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight + 10, 1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 10, 1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 10, 1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 10, 2), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 11, -3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 11, 0), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 11, 1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 11, 2), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 12, -3), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 12, 1), boundsIn);
                this.glowshroom(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 13, 1), boundsIn);
            }
        }
        return true;
    }

    //Log Placement
    private void treeLog(Set<BlockPos> setlogblock, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canLogPlaceHereWater(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.WILLOW_LOG.getDefaultState(), boundingBox);
        }
    }

    //Log Placement
    private void treeBranch(Set<BlockPos> setlogblock, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canLogPlaceHereWater(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.WILLOW_LOG.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs(Set<BlockPos> blockPos, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        BlockPos.Mutable blockpos = new BlockPos.Mutable().setPos(pos);
        if (isAirOrWater(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos, BYGBlockList.WILLOW_LEAVES.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void stem(Set<BlockPos> blockPos, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        BlockPos.Mutable blockpos = new BlockPos.Mutable().setPos(pos);
        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos, BYGBlockList.RED_GLOWSHROOM_STEM.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void glowshroom(Set<BlockPos> blockPos, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        BlockPos.Mutable blockpos = new BlockPos.Mutable().setPos(pos);
        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos, BYGBlockList.PURPLE_GLOWSHROOM_BLOCK.getDefaultState(), boundingBox);
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