package voronoiaoc.byg.common.world.feature.features.nether.warpeddesert;

import com.mojang.serialization.Codec;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelWriter;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class WarpedCoralFeature extends Feature<NoneFeatureConfiguration> {
    public static boolean doBlockNotify;

    public WarpedCoralFeature(Codec<NoneFeatureConfiguration> config) {
        super(config);
    }

    public boolean place(WorldGenLevel worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoneFeatureConfiguration config) {
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        int randCoralHeight = rand.nextInt(9) + 10 / 2;
        BlockPos blockPos = new BlockPos(posX, posY, posZ);
        BlockPos.MutableBlockPos block = new BlockPos.MutableBlockPos().set(blockPos);

        if (!checkArea(worldIn, pos)) {
            return false;
        } else if ((worldIn.getBlockState(pos.below()).getBlock() == BYGBlockList.NYLIUM_SOUL_SAND) || (worldIn.getBlockState(pos.below()).getBlock() == BYGBlockList.NYLIUM_SOUL_SOIL)) {
            for (int i = 0; i <= randCoralHeight; i++) {
                BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().set(block);

                this.setCoralBlock(worldIn, mutable);
                this.setCoralBlock(worldIn, mutable.move(Direction.UP, i));

                for (Direction direction : Direction.Plane.HORIZONTAL) {
                    this.setCoralBlock(worldIn, mutable.relative(direction, i / 2));

                }
            }
        }
        return true;
    }

    protected void setCoralBlock(LevelWriter worldIn, BlockPos pos) {
        this.setBlockStateWithoutUpdates(worldIn, pos, BYGBlockList.WARPED_CORAL_BLOCK.defaultBlockState());
    }

    private void setBlockStateWithoutUpdates(LevelWriter worldWriter, BlockPos blockPos, BlockState blockState) {
        if (doBlockNotify) {
            worldWriter.setBlock(blockPos, blockState, 19);
        } else {
            worldWriter.setBlock(blockPos, blockState, 18);
        }
    }

    private boolean checkArea(LevelAccessor world, BlockPos pos) {
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();

        for (int checkX = -2; checkX <= 2; checkX++) {
            for (int checkZ = -2; checkZ <= 2; checkZ++) {
                BlockPos checkArea = new BlockPos(posX + checkX, posY, posZ + checkZ);

                if (!world.isEmptyBlock
                        (checkArea)) return false;
                if (world.getBlockState(checkArea).getBlock() == BYGBlockList.WARPED_CORAL_BLOCK) return false;

            }
        }
        return true;
    }
}