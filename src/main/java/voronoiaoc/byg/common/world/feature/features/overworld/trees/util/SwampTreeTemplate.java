package voronoiaoc.byg.common.world.feature.features.overworld.trees.util;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldWriter;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.function.Function;

import static net.minecraft.util.Direction.UP;

public class SwampTreeTemplate extends Feature<NoFeatureConfig>  {

    public static boolean doBlockNotify;

    public SwampTreeTemplate(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
        super(configFactoryIn);
    }

    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        int randTreeHeight = rand.nextInt(7) + 8;

        BlockPos blockPos = new BlockPos(posX, posY, posZ);
        BlockPos.Mutable block = new BlockPos.Mutable(blockPos);

        if (worldIn.getBlockState(pos.down()).getBlock() != BYGBlockList.MUD_BLOCK) {
            return false;
        } else {
            BlockPos.Mutable mutable = new BlockPos.Mutable();

            for (int i = 0; i <= randTreeHeight; i++) {
                mutable.setPos(block.up(3));
                this.setLogBlock(worldIn, mutable.move(UP, i));

                if (i <= randTreeHeight - 4) {
                    this.setLogBlock(worldIn, mutable.setPos(block));
                    for (Direction direction : Direction.Plane.HORIZONTAL) {
                        mutable.offset(direction, i);
                    }
                }
            }
//            mutable.setPos(block.up(4));
//            for ()
        }
        return true;
    }

    protected void setLogBlock(IWorldWriter worldIn, BlockPos pos) {
        this.setBlockStateWithoutUpdates(worldIn, pos, BYGBlockList.WILLOW_LOG.getDefaultState());
    }
    protected void setLeafBlock(IWorldWriter worldIn, BlockPos pos) {
        this.setBlockStateWithoutUpdates(worldIn, pos, BYGBlockList.WILLOW_LEAVES.getDefaultState());
    }

    private void setBlockStateWithoutUpdates(IWorldWriter worldWriter, BlockPos blockPos, BlockState blockState) {
        if (doBlockNotify) {
            worldWriter.setBlockState(blockPos, blockState, 19);
        } else {
            worldWriter.setBlockState(blockPos, blockState, 18);
        }
    }

    private boolean checkArea(IWorld world, BlockPos pos, int range) {
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();

        for (int checkX = -range; checkX <= range; checkX++) {
            for (int checkZ = -range; checkZ <= range; checkZ++) {
                BlockPos checkArea = new BlockPos(posX + checkX, posY, posZ + checkZ);

                if (world.getBlockState(checkArea).getBlock() == BYGBlockList.WILLOW_LOG) return false;

            }
        }
        return true;
    }
}