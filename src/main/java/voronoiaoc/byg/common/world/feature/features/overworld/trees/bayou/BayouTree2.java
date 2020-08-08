package voronoiaoc.byg.common.world.feature.features.overworld.trees.bayou;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ModifiableWorld;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;


public class BayouTree2 extends Feature<DefaultFeatureConfig> {
    public static boolean doBlockNotify;

    public BayouTree2(Codec<DefaultFeatureConfig> function) {
        super(function);
    }


    public boolean generate(StructureWorldAccess worldIn, ChunkGenerator generator, Random rand, BlockPos pos, DefaultFeatureConfig config) {
        int randChance = rand.nextInt(2);
        int randChance2 = (-4 + rand.nextInt(9));
        int randTreeHeight = rand.nextInt(6) + 14;
        BlockPos blockPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
        BlockPos.Mutable block = new BlockPos.Mutable().set(blockPos);
        BlockPos.Mutable mainMutable = new BlockPos.Mutable().set(block);

        if (!this.checkArea(worldIn, pos, randTreeHeight) /*||  (IWorld)worldIn.getBlockState(pos.down()).getBlock() != Blocks.DIRT && worldIn.getBlockState(pos.down()).getBlock() != BYGBlockList.MUD_BLOCK && worldIn.getBlockState(pos.down()).getBlock() != Blocks.GRASS_BLOCK && worldIn.getBlockState(pos.down()).getBlock() != Blocks.CLAY && worldIn.getBlockState(pos.down()).getBlock() != Blocks.GRASS_BLOCK*/) {
            return false;
        } else {
            //Trunk
            for (int i = 0; i <= randTreeHeight; i++) {
                int branch = 1;
                BlockPos.Mutable mutable = new BlockPos.Mutable().set(block);
                for (Direction direction : Direction.Type.HORIZONTAL) {
                    if (i >= 4) {
                        if (i >= randTreeHeight - 2)
                            branch = 2;
                        if (i >= randTreeHeight - 1)
                            branch = 3;

                        mutable.set(block.offset(direction, branch));
                        this.setWillowLog(worldIn, mutable.move(Direction.UP, i));
                    }
                }
                if (i >= 3) {
                    mutable.set(block);
                    this.setWillowLog(worldIn, mutable.move(Direction.UP, i));
                }
            }

            for (int buildOuterTrunk = 0; buildOuterTrunk <= 10; buildOuterTrunk++) {
                BlockPos.Mutable mutable = new BlockPos.Mutable().set(block.up(4));
                for (Direction direction : Direction.Type.HORIZONTAL) {
                    if (buildOuterTrunk <= 4 && buildOuterTrunk >= 2) {
                        mutable.set(block.up(6).offset(direction, buildOuterTrunk));
                        this.setWillowLog(worldIn, mutable.move(Direction.DOWN, buildOuterTrunk));
                    }
                    this.setWillowLog(worldIn, mutable.set(block.offset(direction, 4).offset(Direction.UP, 2)));
                    this.setWillowLog(worldIn, mutable.move(Direction.DOWN, buildOuterTrunk));
                }
            }
            mainMutable.set(block.offset(Direction.UP, randTreeHeight));
//            //X is E, -X is W, Z is S, -Z is N.
            this.setWillowLog(worldIn, mainMutable.add(-1, -1, 2));
            this.setWillowLog(worldIn, mainMutable.add(-2, -1, 3));
            this.setWillowLog(worldIn, mainMutable.add(-2, -1, 1));
            mainMutable.set(block);

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

    protected void setWillowLog(ModifiableWorld worldIn, BlockPos pos) {
        this.setBlockStateWithoutUpdates(worldIn, pos, BYGBlockList.WILLOW_LOG.getDefaultState());
    }

    protected void setWillowLeaves(ModifiableWorld worldIn, BlockPos pos) {
        if ((worldIn instanceof WorldAccess)) {
            if (((WorldAccess) worldIn).getBlockState(pos).getBlock() != BYGBlockList.WILLOW_LOG)
                this.setBlockStateWithoutUpdates(worldIn, pos, BYGBlockList.WILLOW_LEAVES.getDefaultState().with(Properties.DISTANCE_1_7, Integer.valueOf(1)));
        }
    }

    private void setBlockStateWithoutUpdates(ModifiableWorld worldWriter, BlockPos blockPos, BlockState blockState) {
        worldWriter.setBlockState(blockPos, blockState, 19);
    }

    private boolean checkArea(WorldAccess world, BlockPos pos, int radius) {
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