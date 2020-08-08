package voronoiaoc.byg.common.world.feature.features.overworld.trees.bayou;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
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


public class BayouTree3 extends Feature<DefaultFeatureConfig> {
    public static boolean doBlockNotify;

    public BayouTree3(Codec<DefaultFeatureConfig> config) {
        super(config);
    }

    public boolean generate(StructureWorldAccess worldIn, ChunkGenerator generator, Random rand, BlockPos pos, DefaultFeatureConfig config) {
        int randChance = rand.nextInt(2);
        int randTreeHeight = rand.nextInt(6) + 5;
        BlockPos blockPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
        BlockPos.Mutable block = new BlockPos.Mutable().set(blockPos);
        BlockPos.Mutable mainMutable = new BlockPos.Mutable().set(block);

        if (!this.checkArea(worldIn, pos, 5) || worldIn.getBlockState(pos.down()).getBlock() != Blocks.DIRT && worldIn.getBlockState(pos.down()).getBlock() != BYGBlockList.MUD_BLOCK && worldIn.getBlockState(pos.down()).getBlock() != Blocks.GRASS_BLOCK) {
            return false;
        } else {
            for (int i = 3; i <= randTreeHeight; i++) {
                BlockPos.Mutable mutable = new BlockPos.Mutable().set(block);
                this.setWillowLog(worldIn, mutable.move(Direction.UP, i));
            }

            for (int baseSize = 0; baseSize < 4; baseSize++) {
                BlockPos.Mutable mutable = new BlockPos.Mutable().set(block.up(3));
                for (Direction direction : Direction.Type.HORIZONTAL) {
                    mutable.set(block.up(3).offset(direction, baseSize));
                    if (worldIn.getBlockState(mutable).getBlock() != Blocks.DIRT)
                        this.setWillowLog(worldIn, mutable.move(Direction.DOWN, baseSize));
                }
            }
            this.setWillowLog(worldIn, mainMutable.move(Direction.UP, randTreeHeight - 1).move(Direction.SOUTH).move(Direction.EAST));
            this.setWillowLog(worldIn, mainMutable.move(Direction.DOWN));
            this.setWillowLog(worldIn, mainMutable.move(Direction.UP, 2).move(Direction.EAST));
            mainMutable.set(block);
            this.setWillowLog(worldIn, mainMutable.move(Direction.UP, randTreeHeight - 1).move(Direction.WEST));
            this.setWillowLog(worldIn, mainMutable.move(Direction.WEST).move(Direction.UP).move(Direction.NORTH));
            mainMutable.set(block);
            this.setWillowLog(worldIn, mainMutable.move(Direction.UP, randTreeHeight - 2).move(Direction.NORTH));
            this.setWillowLog(worldIn, mainMutable.move(Direction.UP).move(Direction.NORTH));
            mainMutable.set(block);

//            this.setWillowLeaves(worldIn, mainMutable.move(Direction.UP, randTreeHeight));
//            for (int placeX = -3; placeX <= 3; placeX++) {
//                for (int placeZ = -3; placeZ <= 3; placeZ++) {
//                    if (placeX <= 2 && placeX >= -2 && placeZ <= 2 && placeZ >= -2) {
//                        this.setWillowLeaves(worldIn, mainMutable.add(placeX, 0, placeZ));
//                        this.setWillowLeaves(worldIn, mainMutable.add(3, 0, placeZ));
//                        this.setWillowLeaves(worldIn, mainMutable.add(-3, 0, placeZ));
//                        this.setWillowLeaves(worldIn, mainMutable.add(placeX, 0, 3));
//                        this.setWillowLeaves(worldIn, mainMutable.add(placeX, 0, -3));
//
//                        for (int placeY = -1; placeY >= -(rand.nextInt(4) + 2); placeY--) {
//                            this.setWillowLeaves(worldIn, mainMutable.add(4, placeY, placeZ));
//                            this.setWillowLeaves(worldIn, mainMutable.add(-4, placeY, placeZ));
//                            this.setWillowLeaves(worldIn, mainMutable.add(placeX, placeY, 4));
//                            this.setWillowLeaves(worldIn, mainMutable.add(placeX, placeY, -4));
//                            this.setWillowLeaves(worldIn, mainMutable.add(3, placeY, 3));
//                            this.setWillowLeaves(worldIn, mainMutable.add(-3, placeY, 3));
//                            this.setWillowLeaves(worldIn, mainMutable.add(3, placeY, -3));
//                            this.setWillowLeaves(worldIn, mainMutable.add(-3, placeY, -3));
//                        }
//                    }
//
//                    if (placeX <= 1 && placeX >= -1 && placeZ <= 1 && placeZ >= -1) {
//                        this.setWillowLeaves(worldIn, mainMutable.add(placeX, 1, placeZ));
//                        this.setWillowLeaves(worldIn, mainMutable.add(placeX, 1, 2));
//                        this.setWillowLeaves(worldIn, mainMutable.add(placeX, 1, -2));
//                        this.setWillowLeaves(worldIn, mainMutable.add(2, 1, placeZ));
//                        this.setWillowLeaves(worldIn, mainMutable.add(-2, 1, placeZ));
//                        if (randChance == 0) {
//                            this.setWillowLeaves(worldIn, mainMutable.add(placeX, 0, 4));
//                            this.setWillowLeaves(worldIn, mainMutable.add(placeX, 0, -4));
//                            this.setWillowLeaves(worldIn, mainMutable.add(4, 0, placeZ));
//                            this.setWillowLeaves(worldIn, mainMutable.add(-4, 0, placeZ));
//                        }
//                    }
//                }
//            }
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