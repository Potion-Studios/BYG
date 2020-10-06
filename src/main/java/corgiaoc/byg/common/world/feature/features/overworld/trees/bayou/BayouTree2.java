package corgiaoc.byg.common.world.feature.features.overworld.trees.bayou;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.IWorldWriter;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;


public class BayouTree2 extends Feature<NoFeatureConfig> {
    public static boolean doBlockNotify;

    public BayouTree2(Codec<NoFeatureConfig> function) {
        super(function);
    }


    public boolean func_241855_a(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        int randChance = rand.nextInt(2);
        int randChance2 = (-4 + rand.nextInt(9));
        int randTreeHeight = rand.nextInt(6) + 14;
        BlockPos blockPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
        BlockPos.Mutable block = new BlockPos.Mutable().setPos(blockPos);
        BlockPos.Mutable mainMutable = new BlockPos.Mutable().setPos(block);

        if (!this.checkArea(worldIn, pos, randTreeHeight) /*||  (IWorld)worldIn.getBlockState(pos.down()).getBlock() != Blocks.DIRT && worldIn.getBlockState(pos.down()).getBlock() != BYGBlocks.MUD_BLOCK && worldIn.getBlockState(pos.down()).getBlock() != Blocks.GRASS_BLOCK && worldIn.getBlockState(pos.down()).getBlock() != Blocks.CLAY && worldIn.getBlockState(pos.down()).getBlock() != Blocks.GRASS_BLOCK*/) {
            return false;
        } else {
            //Trunk
            for (int i = 0; i <= randTreeHeight; i++) {
                int branch = 1;
                BlockPos.Mutable mutable = new BlockPos.Mutable().setPos(block);
                for (Direction direction : Direction.Plane.HORIZONTAL) {
                    if (i >= 4) {
                        if (i >= randTreeHeight - 2)
                            branch = 2;
                        if (i >= randTreeHeight - 1)
                            branch = 3;

                        mutable.setPos(block.offset(direction, branch));
                        this.setWillowLog(worldIn, mutable.move(Direction.UP, i));
                    }
                }
                if (i >= 3) {
                    mutable.setPos(block);
                    this.setWillowLog(worldIn, mutable.move(Direction.UP, i));
                }
            }

            for (int buildOuterTrunk = 0; buildOuterTrunk <= 10; buildOuterTrunk++) {
                BlockPos.Mutable mutable = new BlockPos.Mutable().setPos(block.up(4));
                for (Direction direction : Direction.Plane.HORIZONTAL) {
                    if (buildOuterTrunk <= 4 && buildOuterTrunk >= 2) {
                        mutable.setPos(block.up(6).offset(direction, buildOuterTrunk));
                        this.setWillowLog(worldIn, mutable.move(Direction.DOWN, buildOuterTrunk));
                    }
                    this.setWillowLog(worldIn, mutable.setPos(block.offset(direction, 4).offset(Direction.UP, 2)));
                    this.setWillowLog(worldIn, mutable.move(Direction.DOWN, buildOuterTrunk));
                }
            }
            mainMutable.setPos(block.offset(Direction.UP, randTreeHeight));
//            //X is E, -X is W, Z is S, -Z is N.
            this.setWillowLog(worldIn, mainMutable.add(-1, -1, 2));
            this.setWillowLog(worldIn, mainMutable.add(-2, -1, 3));
            this.setWillowLog(worldIn, mainMutable.add(-2, -1, 1));
            mainMutable.setPos(block);

            //Leaves
            this.setWillowLeaves(worldIn, mainMutable.move(Direction.UP, randTreeHeight));
            for (int placeX = -5; placeX <= 5; placeX++) {
                for (int placeZ = -5; placeZ <= 5; placeZ++) {
                    if (placeX <= 1 && placeX >= -1 && placeZ <= 1 && placeZ >= -1) {
                        this.setWillowLeaves(worldIn, mainMutable.add(placeX, 1, 4));
                        this.setWillowLeaves(worldIn, mainMutable.add(placeX, 1, -4));
                        this.setWillowLeaves(worldIn, mainMutable.add(4, 1, placeZ));
                        this.setWillowLeaves(worldIn, mainMutable.add(-4, 1, placeZ));
                    }

                    if (placeX <= 2 && placeX >= -2 && placeZ <= 2 && placeZ >= -2) {
                        this.setWillowLeaves(worldIn, mainMutable.add(placeX, 1, placeZ));

                        this.setWillowLeaves(worldIn, mainMutable.add(placeX, 1, 3));
                        this.setWillowLeaves(worldIn, mainMutable.add(placeX, 1, -3));
                        this.setWillowLeaves(worldIn, mainMutable.add(3, 1, placeZ));
                        this.setWillowLeaves(worldIn, mainMutable.add(-3, 1, placeZ));
                    }

                    if (placeX <= 3 && placeX >= -3 && placeZ <= 3 && placeZ >= -3) {
                        this.setWillowLeaves(worldIn, mainMutable.add(5, 0, placeZ));
                        this.setWillowLeaves(worldIn, mainMutable.add(-5, 0, placeZ));
                        this.setWillowLeaves(worldIn, mainMutable.add(placeX, 0, 5));
                        this.setWillowLeaves(worldIn, mainMutable.add(placeX, 0, -5));
                    }

                    if (placeX <= 4 && placeX >= -4 && placeZ <= 4 && placeZ >= -4) {
                        this.setWillowLeaves(worldIn, mainMutable.add(placeX, 0, placeZ));

                        for (int placeY = -1; placeY >= -(rand.nextInt(9) + 2); placeY--) {

                            this.setWillowLeaves(worldIn, mainMutable.add(6, placeY, placeZ));
                            this.setWillowLeaves(worldIn, mainMutable.add(-6, placeY, placeZ));
                            this.setWillowLeaves(worldIn, mainMutable.add(placeX, placeY, 6));
                            this.setWillowLeaves(worldIn, mainMutable.add(placeX, placeY, -6));

                            this.setWillowLeaves(worldIn, mainMutable.add(5, placeY, 4));
                            this.setWillowLeaves(worldIn, mainMutable.add(-5, placeY, -4));
                            this.setWillowLeaves(worldIn, mainMutable.add(5, placeY, -4));
                            this.setWillowLeaves(worldIn, mainMutable.add(-5, placeY, 4));

                            this.setWillowLeaves(worldIn, mainMutable.add(4, placeY, 5));
                            this.setWillowLeaves(worldIn, mainMutable.add(-4, placeY, -5));
                            this.setWillowLeaves(worldIn, mainMutable.add(-4, placeY, 5));
                            this.setWillowLeaves(worldIn, mainMutable.add(4, placeY, -5));

                            this.setWillowLeaves(worldIn, mainMutable.add(5, placeY, 5));
                            this.setWillowLeaves(worldIn, mainMutable.add(-5, placeY, -5));
                            this.setWillowLeaves(worldIn, mainMutable.add(-5, placeY, 5));
                            this.setWillowLeaves(worldIn, mainMutable.add(5, placeY, -5));
                        }
                    }
                }
            }
        }
        return true;
    }

    protected void setWillowLog(IWorldWriter worldIn, BlockPos pos) {
        this.setBlockStateWithoutUpdates(worldIn, pos, BYGBlocks.WILLOW_LOG.getDefaultState());
    }

    protected void setWillowLeaves(IWorldWriter worldIn, BlockPos pos) {
        if ((worldIn instanceof IWorldReader)) {
            if (((IWorldReader) worldIn).getBlockState(pos).getBlock() != BYGBlocks.WILLOW_LOG)
                this.setBlockStateWithoutUpdates(worldIn, pos, BYGBlocks.WILLOW_LEAVES.getDefaultState().with(BlockStateProperties.DISTANCE_1_7, Integer.valueOf(1)));
        }
    }

    private void setBlockStateWithoutUpdates(IWorldWriter worldWriter, BlockPos blockPos, BlockState blockState) {
        worldWriter.setBlockState(blockPos, blockState, 19);
    }

    private boolean checkArea(ISeedReader world, BlockPos pos, int radius) {
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();

        for (int checkX = -radius; checkX <= radius; checkX++) {
            for (int checkZ = -radius; checkZ <= radius; checkZ++) {
                BlockPos checkArea = new BlockPos(posX + checkX, posY, posZ + checkZ);

                if (world.getBlockState(checkArea).getBlock() == BYGBlocks.WILLOW_LOG) return false;

            }
        }
        return true;
    }
}