package voronoiaoc.byg.common.world.feature.features.overworld.trees.willow;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
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

public class WillowTree4 extends BYGAbstractTreeFeature<NoFeatureConfig> {

    public WillowTree4(Function<Dynamic<?>, ? extends NoFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn) {
        int randTreeHeight = 13 + rand.nextInt(8);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable(pos);
        BlockPos.Mutable mainmutable2 = new BlockPos.Mutable(pos.offset(Direction.NORTH));
        BlockPos.Mutable mainmutable3 = new BlockPos.Mutable(pos.offset(Direction.SOUTH));
        BlockPos.Mutable mainmutable4 = new BlockPos.Mutable(pos.offset(Direction.WEST));
        BlockPos.Mutable mainmutable5 = new BlockPos.Mutable(pos.offset(Direction.EAST));

        if (pos.getY() + randTreeHeight + 1 < worldIn.getMaxHeight()) {
            BlockPos blockpos = pos.down();
            if (!isDesiredGround(worldIn, blockpos, Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.doesTreeFit(worldIn, pos, randTreeHeight)) {
                return false;
            } else {
                for (int buildTrunk = 3; buildTrunk <= randTreeHeight; buildTrunk++) {
                    if (buildTrunk == 3)
                        mainmutable.move(Direction.UP, 3);
                    if (buildTrunk == 3) {
                        mainmutable2.move(Direction.UP, 4);
                        mainmutable3.move(Direction.UP, 4);
                        mainmutable4.move(Direction.UP, 4);
                        mainmutable5.move(Direction.UP, 4);
                    }
                    this.treeLog(changedBlocks, worldIn, mainmutable, boundsIn);

                    if (buildTrunk <= randTreeHeight - 3) {
                        this.treeLog(changedBlocks, worldIn, mainmutable2, boundsIn);
                        this.treeLog(changedBlocks, worldIn, mainmutable3, boundsIn);
                        this.treeLog(changedBlocks, worldIn, mainmutable4, boundsIn);
                        this.treeLog(changedBlocks, worldIn, mainmutable5, boundsIn);
                    }

                    mainmutable.move(Direction.UP);
                    mainmutable2.move(Direction.UP);
                    mainmutable3.move(Direction.UP);
                    mainmutable4.move(Direction.UP);
                    mainmutable5.move(Direction.UP);
                }
                mainmutable.setPos(pos);

                //Roots
                BlockPos.Mutable rootMutable = new BlockPos.Mutable(mainmutable.add(-4, 0, 0));
                BlockPos.Mutable rootMutable2 = new BlockPos.Mutable(mainmutable.add(4, 0, 0));
                BlockPos.Mutable rootMutable3 = new BlockPos.Mutable(mainmutable.add(0, 0, -4));
                BlockPos.Mutable rootMutable4 = new BlockPos.Mutable(mainmutable.add(0, 0, 4));

                for (int buildRoot = 0; buildRoot <= 5; buildRoot++) {
                    this.treeBranch(changedBlocks, worldIn, rootMutable, boundsIn);
                    this.treeBranch(changedBlocks, worldIn, rootMutable2, boundsIn);
                    this.treeBranch(changedBlocks, worldIn, rootMutable3, boundsIn);
                    this.treeBranch(changedBlocks, worldIn, rootMutable4, boundsIn);

                    for (Direction direction : Direction.Plane.HORIZONTAL) {
                        if (direction != Direction.WEST)
                            this.treeBranch(changedBlocks, worldIn, rootMutable.offset(direction), boundsIn);
                        if (direction != Direction.EAST)
                            this.treeBranch(changedBlocks, worldIn, rootMutable2.offset(direction), boundsIn);
                        if (direction != Direction.NORTH)
                            this.treeBranch(changedBlocks, worldIn, rootMutable3.offset(direction), boundsIn);
                        if (direction != Direction.SOUTH)
                            this.treeBranch(changedBlocks, worldIn, rootMutable4.offset(direction), boundsIn);
                    }

                    rootMutable.move(Direction.DOWN);
                    rootMutable2.move(Direction.DOWN);
                    rootMutable3.move(Direction.DOWN);
                    rootMutable4.move(Direction.DOWN);
                }

                //Roots/Stump
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 1, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 1, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 1, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 1, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(4, 1, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(4, 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 1, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(4, 1, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 1, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 1, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 1, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 2, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 2, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(4, 2, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 2, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 3, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 3, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3, 3, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 3, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 4, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 4, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 4, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 4, 2), boundsIn);
                
                
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight - 1, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight - 1, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight - 1, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight - 1, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight - 1, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight - 1, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight - 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight - 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight - 1, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight - 1, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight - 1, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight - 1, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight + 1, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight + 1, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight + 1, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight + 1, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight + 1, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight + 1, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight + 1, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight + 1, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight + 1, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight + 1, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight + 1, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight + 1, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight + 1, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight + 1, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight + 1, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight + 1, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight + 1, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight + 1, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight + 1, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight + 1, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight + 1, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight + 1, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight - 6, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight - 5, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight - 5, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight - 5, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight - 5, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight - 5, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight - 5, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight - 5, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight - 4, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight - 4, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight - 4, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight - 4, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight - 4, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight - 4, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight - 4, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight - 4, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight - 4, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight - 4, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight - 4, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight - 4, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight - 4, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight - 4, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight - 4, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight - 4, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight - 4, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight - 4, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight - 3, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight - 3, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight - 3, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight - 3, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight - 3, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight - 3, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight - 3, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight - 3, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight - 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight - 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight - 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight - 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight - 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight - 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight - 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight - 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight - 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight - 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight - 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight - 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight - 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight - 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight - 3, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight - 3, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight - 3, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight - 3, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight - 3, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight - 3, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight - 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight - 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight - 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight - 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight - 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight - 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight - 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight - 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight - 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight - 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight - 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight - 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight - 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight - 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight - 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight - 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight - 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight - 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight - 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight - 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight - 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight - 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight - 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight - 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight - 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight - 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight - 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight - 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight - 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight - 2, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight - 2, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight - 2, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight - 2, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight - 2, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight - 2, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight - 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight - 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight - 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight - 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight - 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight - 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight - 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight - 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight - 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight - 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight - 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight - 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight - 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight - 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight - 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight - 1, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight - 1, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6,randTreeHeight - 1, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight - 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight - 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight - 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight - 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6,randTreeHeight - 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight - 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight - 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6,randTreeHeight - 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight - 1, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight - 1, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight - 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight - 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight - 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight - 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight - 1, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight - 1, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight - 1, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight - 1, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight - 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight - 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight - 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight - 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight - 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight - 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6,randTreeHeight, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6,randTreeHeight, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6,randTreeHeight, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6,randTreeHeight, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight + 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight + 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight + 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight + 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight + 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight + 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight + 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight + 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight + 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight + 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight + 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight + 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight + 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight + 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight + 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight + 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight + 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight + 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight + 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight + 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight + 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight + 1, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight + 1, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight + 1, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight + 1, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight + 1, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight + 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight + 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight + 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight + 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight + 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight + 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight + 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight + 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight + 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight + 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight + 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6,randTreeHeight + 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight + 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight + 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight + 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight + 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight + 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight + 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight + 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight + 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight + 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight + 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6,randTreeHeight + 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight + 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight + 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight + 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight + 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight + 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight + 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight + 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight + 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight + 1, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight + 1, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight + 1, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight + 1, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight + 1, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight + 1, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight + 1, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight + 1, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight + 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight + 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight + 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight + 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight + 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight + 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight + 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight + 1, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight + 1, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight + 1, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight + 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight + 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight + 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight + 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight + 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight + 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight + 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight + 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight + 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight + 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight + 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight + 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight + 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight + 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight + 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight + 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight + 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight + 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight + 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight + 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight + 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight + 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight + 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight + 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight + 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight + 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight + 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight + 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight + 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight + 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight + 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight + 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight + 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight + 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight + 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight + 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight + 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight + 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight + 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight + 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight + 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight + 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight + 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight + 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight + 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight + 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight + 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5,randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight + 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight + 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight + 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight + 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight + 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight + 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight + 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight + 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight + 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5,randTreeHeight + 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight + 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight + 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight + 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight + 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight + 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight + 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight + 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight + 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight + 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight + 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight + 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight + 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight + 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight + 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight + 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight + 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight + 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight + 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight + 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight + 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight + 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight + 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight + 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight + 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight + 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight + 2, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight + 2, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight + 3, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight + 3, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight + 3, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight + 3, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight + 3, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight + 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight + 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight + 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight + 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight + 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight + 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight + 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight + 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight + 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight + 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight + 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight + 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight + 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight + 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight + 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight + 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight + 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight + 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight + 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight + 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight + 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight + 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight + 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight + 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight + 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight + 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight + 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight + 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight + 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4,randTreeHeight + 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight + 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight + 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight + 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight + 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight + 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight + 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight + 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight + 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3,randTreeHeight + 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight + 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight + 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight + 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight + 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight + 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3,randTreeHeight + 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4,randTreeHeight + 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2,randTreeHeight + 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight + 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight + 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1,randTreeHeight + 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2,randTreeHeight + 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1,randTreeHeight + 3, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0,randTreeHeight + 3, 4), boundsIn);
            }
        }
        return true;
    }

    //Log Placement
    private void treeLog(Set<BlockPos> setlogblock, IWorldGenerationReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (isQualifiedForLogWater(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.WILLOW_LOG.getDefaultState(), boundingBox);
        }
    }

    //Log Placement
    private void treeBranch(Set<BlockPos> setlogblock, IWorldGenerationReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (isQualifiedForLogWater(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.WILLOW_LOG.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs(Set<BlockPos> blockPos, IWorldGenerationReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        BlockPos.Mutable blockpos = new BlockPos.Mutable(pos);
        if (isAirOrWater(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos,  BYGBlockList.WILLOW_LEAVES.getDefaultState(), boundingBox);
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