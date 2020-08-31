package voronoiaoc.byg.common.world.feature.features.overworld.trees.bayou;

import com.mojang.serialization.Codec;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelWriter;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;


public class BayouTree2 extends Feature<NoneFeatureConfiguration> {
    public static boolean doBlockNotify;

    public BayouTree2(Codec<NoneFeatureConfiguration> function) {
        super(function);
    }


    public boolean place(WorldGenLevel worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoneFeatureConfiguration config) {
        int randChance = rand.nextInt(2);
        int randChance2 = (-4 + rand.nextInt(9));
        int randTreeHeight = rand.nextInt(6) + 14;
        BlockPos blockPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
        BlockPos.MutableBlockPos block = new BlockPos.MutableBlockPos().set(blockPos);
        BlockPos.MutableBlockPos mainMutable = new BlockPos.MutableBlockPos().set(block);

        if (!this.checkArea(worldIn, pos, randTreeHeight) /*||  (IWorld)worldIn.getBlockState(pos.down()).getBlock() != Blocks.DIRT && worldIn.getBlockState(pos.down()).getBlock() != BYGBlockList.MUD_BLOCK && worldIn.getBlockState(pos.down()).getBlock() != Blocks.GRASS_BLOCK && worldIn.getBlockState(pos.down()).getBlock() != Blocks.CLAY && worldIn.getBlockState(pos.down()).getBlock() != Blocks.GRASS_BLOCK*/) {
            return false;
        } else {
            //Trunk
            for (int i = 0; i <= randTreeHeight; i++) {
                int branch = 1;
                BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().set(block);
                for (Direction direction : Direction.Plane.HORIZONTAL) {
                    if (i >= 4) {
                        if (i >= randTreeHeight - 2)
                            branch = 2;
                        if (i >= randTreeHeight - 1)
                            branch = 3;

                        mutable.set(block.relative(direction, branch));
                        this.setWillowLog(worldIn, mutable.move(Direction.UP, i));
                    }
                }
                if (i >= 3) {
                    mutable.set(block);
                    this.setWillowLog(worldIn, mutable.move(Direction.UP, i));
                }
            }

            for (int buildOuterTrunk = 0; buildOuterTrunk <= 10; buildOuterTrunk++) {
                BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().set(block.above(4));
                for (Direction direction : Direction.Plane.HORIZONTAL) {
                    if (buildOuterTrunk <= 4 && buildOuterTrunk >= 2) {
                        mutable.set(block.above(6).relative(direction, buildOuterTrunk));
                        this.setWillowLog(worldIn, mutable.move(Direction.DOWN, buildOuterTrunk));
                    }
                    this.setWillowLog(worldIn, mutable.set(block.relative(direction, 4).relative(Direction.UP, 2)));
                    this.setWillowLog(worldIn, mutable.move(Direction.DOWN, buildOuterTrunk));
                }
            }
            mainMutable.set(block.relative(Direction.UP, randTreeHeight));
//            //X is E, -X is W, Z is S, -Z is N.
            this.setWillowLog(worldIn, mainMutable.offset(-1, -1, 2));
            this.setWillowLog(worldIn, mainMutable.offset(-2, -1, 3));
            this.setWillowLog(worldIn, mainMutable.offset(-2, -1, 1));
            mainMutable.set(block);

            //Leaves
            this.setWillowLeaves(worldIn, mainMutable.move(Direction.UP, randTreeHeight));
            for (int placeX = -5; placeX <= 5; placeX++) {
                for (int placeZ = -5; placeZ <= 5; placeZ++) {
                    if (placeX <= 1 && placeX >= -1 && placeZ <= 1 && placeZ >= -1) {
                        this.setWillowLeaves(worldIn, mainMutable.offset(placeX, 1, 4));
                        this.setWillowLeaves(worldIn, mainMutable.offset(placeX, 1, -4));
                        this.setWillowLeaves(worldIn, mainMutable.offset(4, 1, placeZ));
                        this.setWillowLeaves(worldIn, mainMutable.offset(-4, 1, placeZ));
                    }

                    if (placeX <= 2 && placeX >= -2 && placeZ <= 2 && placeZ >= -2) {
                        this.setWillowLeaves(worldIn, mainMutable.offset(placeX, 1, placeZ));

                        this.setWillowLeaves(worldIn, mainMutable.offset(placeX, 1, 3));
                        this.setWillowLeaves(worldIn, mainMutable.offset(placeX, 1, -3));
                        this.setWillowLeaves(worldIn, mainMutable.offset(3, 1, placeZ));
                        this.setWillowLeaves(worldIn, mainMutable.offset(-3, 1, placeZ));
                    }

                    if (placeX <= 3 && placeX >= -3 && placeZ <= 3 && placeZ >= -3) {
                        this.setWillowLeaves(worldIn, mainMutable.offset(5, 0, placeZ));
                        this.setWillowLeaves(worldIn, mainMutable.offset(-5, 0, placeZ));
                        this.setWillowLeaves(worldIn, mainMutable.offset(placeX, 0, 5));
                        this.setWillowLeaves(worldIn, mainMutable.offset(placeX, 0, -5));
                    }

                    if (placeX <= 4 && placeX >= -4 && placeZ <= 4 && placeZ >= -4) {
                        this.setWillowLeaves(worldIn, mainMutable.offset(placeX, 0, placeZ));

                        for (int placeY = -1; placeY >= -(rand.nextInt(9) + 2); placeY--) {

                            this.setWillowLeaves(worldIn, mainMutable.offset(6, placeY, placeZ));
                            this.setWillowLeaves(worldIn, mainMutable.offset(-6, placeY, placeZ));
                            this.setWillowLeaves(worldIn, mainMutable.offset(placeX, placeY, 6));
                            this.setWillowLeaves(worldIn, mainMutable.offset(placeX, placeY, -6));

                            this.setWillowLeaves(worldIn, mainMutable.offset(5, placeY, 4));
                            this.setWillowLeaves(worldIn, mainMutable.offset(-5, placeY, -4));
                            this.setWillowLeaves(worldIn, mainMutable.offset(5, placeY, -4));
                            this.setWillowLeaves(worldIn, mainMutable.offset(-5, placeY, 4));

                            this.setWillowLeaves(worldIn, mainMutable.offset(4, placeY, 5));
                            this.setWillowLeaves(worldIn, mainMutable.offset(-4, placeY, -5));
                            this.setWillowLeaves(worldIn, mainMutable.offset(-4, placeY, 5));
                            this.setWillowLeaves(worldIn, mainMutable.offset(4, placeY, -5));

                            this.setWillowLeaves(worldIn, mainMutable.offset(5, placeY, 5));
                            this.setWillowLeaves(worldIn, mainMutable.offset(-5, placeY, -5));
                            this.setWillowLeaves(worldIn, mainMutable.offset(-5, placeY, 5));
                            this.setWillowLeaves(worldIn, mainMutable.offset(5, placeY, -5));
                        }
                    }
                }
            }
        }
        return true;
    }

    protected void setWillowLog(LevelWriter worldIn, BlockPos pos) {
        this.setBlockStateWithoutUpdates(worldIn, pos, BYGBlockList.WILLOW_LOG.defaultBlockState());
    }

    protected void setWillowLeaves(LevelWriter worldIn, BlockPos pos) {
        if ((worldIn instanceof LevelAccessor)) {
            if (((LevelAccessor) worldIn).getBlockState(pos).getBlock() != BYGBlockList.WILLOW_LOG)
                this.setBlockStateWithoutUpdates(worldIn, pos, BYGBlockList.WILLOW_LEAVES.defaultBlockState().setValue(BlockStateProperties.DISTANCE, Integer.valueOf(1)));
        }
    }

    private void setBlockStateWithoutUpdates(LevelWriter worldWriter, BlockPos blockPos, BlockState blockState) {
        worldWriter.setBlock(blockPos, blockState, 19);
    }

    private boolean checkArea(LevelAccessor world, BlockPos pos, int radius) {
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();

        for (int checkX = -radius; checkX <= radius; checkX++) {
            for (int checkZ = -radius; checkZ <= radius; checkZ++) {
                BlockPos checkArea = new BlockPos(posX + checkX, posY, posZ + checkZ);

                if (world.getBlockState(checkArea).getBlock() == BYGBlockList.WILLOW_LOG) return false;

            }
        }
        return true;
    }
}