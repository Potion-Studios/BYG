package voronoiaoc.byg.common.world.feature.features.overworld.trees.willow;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;

public class WillowTree2 extends BYGAbstractTreeFeature<DefaultFeatureConfig> {

    public WillowTree2(Codec<DefaultFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean place(Set<BlockPos> changedBlocks, StructureWorldAccess worldIn, Random rand, BlockPos pos, BlockBox boundsIn, boolean isSapling) {
        int randTreeHeight = 7 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getDimensionHeight()) {

            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isSapling)) {
                return false;
            } else {
                for (int buildTrunk = 2; buildTrunk <= randTreeHeight; buildTrunk++) {
                    this.treeLog(changedBlocks, worldIn, mainmutable, boundsIn);

                    mainmutable.move(Direction.UP);
                }
                mainmutable.set(pos);

                BlockPos.Mutable rootMutable = new BlockPos.Mutable().set(mainmutable.add(0, 0, -2));
                BlockPos.Mutable rootMutable2 = new BlockPos.Mutable().set(mainmutable.add(-2, 0, 0));
                BlockPos.Mutable rootMutable3 = new BlockPos.Mutable().set(mainmutable.add(2, 0, 0));
                BlockPos.Mutable rootMutable4 = new BlockPos.Mutable().set(mainmutable.add(0, 0, 2));

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
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 2, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 2, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 2, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 2, 1), boundsIn);


                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight - 1, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight - 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight, -6), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight, -5), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(5, randTreeHeight, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight, 5), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 1, -5), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 1, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 1, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 1, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 1, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 1, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 1, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 1, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 1, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 1, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 1, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 1, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 1, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 1, 6), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 1, 7), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 2, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 2, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 2, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 2, 5), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 2, 5), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 2, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight - 4, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight - 3, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight - 3, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, randTreeHeight - 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight - 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight - 3, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight - 3, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight - 2, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight - 2, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight - 2, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight - 2, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight - 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, randTreeHeight - 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight - 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, randTreeHeight - 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight - 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, randTreeHeight - 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight - 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight - 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight - 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight - 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight - 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight - 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight - 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight - 2, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight - 2, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight - 2, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight - 1, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight - 1, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight - 1, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight - 1, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight - 1, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight - 1, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight - 1, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight - 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, randTreeHeight - 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight - 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, randTreeHeight - 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight - 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, randTreeHeight - 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight - 1, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight - 1, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, randTreeHeight - 1, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight - 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight - 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, randTreeHeight - 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight - 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, randTreeHeight - 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight - 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight - 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight - 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight - 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight - 1, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight - 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, randTreeHeight - 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight - 1, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight - 1, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight - 1, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight - 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, randTreeHeight - 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight - 1, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight - 1, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight - 1, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight - 1, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight - 1, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, randTreeHeight, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, randTreeHeight, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, randTreeHeight, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, randTreeHeight, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, randTreeHeight, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, randTreeHeight, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, randTreeHeight, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, randTreeHeight, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, randTreeHeight, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, randTreeHeight, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, randTreeHeight, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, randTreeHeight, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, randTreeHeight, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight, 9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 1, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 1, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 1, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 1, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 1, -7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 1, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 1, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 1, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 1, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 1, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 1, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, randTreeHeight + 1, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, randTreeHeight + 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, randTreeHeight + 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, randTreeHeight + 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, randTreeHeight + 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, randTreeHeight + 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 1, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 1, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 1, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 1, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 1, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 1, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 1, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, randTreeHeight + 1, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, randTreeHeight + 1, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, randTreeHeight + 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, randTreeHeight + 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 1, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 1, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 1, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 1, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 1, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight + 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, randTreeHeight + 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight + 1, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 1, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 1, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 1, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 1, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 1, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 1, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 1, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, randTreeHeight + 1, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight + 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, randTreeHeight + 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 1, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 1, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 1, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 1, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 1, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 1, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 1, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 1, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 1, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 1, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 1, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 1, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 1, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 1, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 1, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 1, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 1, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 1, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 1, 9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 1, 9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 2, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 2, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 2, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, randTreeHeight + 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, randTreeHeight + 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, randTreeHeight + 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight + 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 2, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 2, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 2, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 2, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 2, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 2, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 2, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 2, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 2, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 2, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 2, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 2, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 2, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 2, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 2, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 2, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 2, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 2, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 2, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 2, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 2, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 2, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 2, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 2, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 2, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 2, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 2, 8), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 2, 9), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 3, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 3, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 3, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 3, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 3, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 3, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 3, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 3, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 3, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 3, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 3, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 3, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 3, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 3, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 3, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 3, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 3, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 3, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 3, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 3, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 3, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 3, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 3, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 3, 7), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 4, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 4, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 4, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 4, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 4, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 4, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 4, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 4, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 4, 6), boundsIn);
            }
        }
        return true;
    }

    //Log Placement
    private void treeLog(Set<BlockPos> setlogblock, StructureWorldAccess reader, BlockPos pos, BlockBox boundingBox) {
        if (canLogPlaceHereWater(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.WILLOW_LOG.getDefaultState(), boundingBox);
        }
    }

    //Log Placement
    private void treeBranch(Set<BlockPos> setlogblock, StructureWorldAccess reader, BlockPos pos, BlockBox boundingBox) {
        if (canLogPlaceHereWater(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.WILLOW_LOG.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs(Set<BlockPos> blockPos, StructureWorldAccess reader, BlockPos pos, BlockBox boundingBox) {
        BlockPos.Mutable blockpos = new BlockPos.Mutable().set(pos);
        if (isAirOrWater(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos, BYGBlockList.WILLOW_LEAVES.getDefaultState(), boundingBox);
        }
    }


    private boolean doesTreeFit(ModifiableTestableWorld reader, BlockPos blockPos, int height) {
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        BlockPos.Mutable pos = new BlockPos.Mutable();

        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
            //Distance/Density of trees. Positive Values ONLY
            int distance = 2;

            for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
                for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
                    if (!canLogPlaceHereWater(reader, pos.set(x + xOffset, y + yOffset, z + zOffset))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}