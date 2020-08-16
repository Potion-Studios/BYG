package voronoiaoc.byg.common.world.feature.features.overworld.mushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public class MiniGreenMushroom extends BYGAbstractTreeFeature<NoFeatureConfig> {

    public MiniGreenMushroom(Codec<NoFeatureConfig> configIn) {
        super(configIn);
    }

    public boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling) {
        int randTreeHeight = 3 + rand.nextInt(2);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            BlockPos blockpos = pos.down();
            if (((IWorld) worldIn).getBlockState(pos.down()).getBlock() != Blocks.GRASS_BLOCK && ((IWorld) worldIn).getBlockState(pos.down()).getBlock() != Blocks.SOUL_SAND && ((IWorld) worldIn).getBlockState(pos.down()).getBlock() != BYGBlockList.OVERGROWN_NETHERRACK) {
                return false;
            } else if (!this.doesTreeFit(worldIn, pos, randTreeHeight)) {
                return false;
            } else {
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 0, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 1, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 3, 1), boundsIn);
            }
        }
        return true;
    }

    //Log Placement
    private void treeLog(Set<BlockPos> setlogblock, IWorldGenerationReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.WHITE_MUSHROOM_STEM.getDefaultState(), boundingBox);
        }
    }

    //Log Placement
    private void treeBranch(Set<BlockPos> setlogblock, IWorldGenerationReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.WHITE_MUSHROOM_STEM.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs(Set<BlockPos> blockPos, IWorldGenerationReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(blockPos, reader, pos, BYGBlockList.GREEN_MUSHROOM_BLOCK.getDefaultState(), boundingBox);
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