package voronoiaoc.byg.common.world.feature.features.nether.warpeddesert;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldWriter;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

import static net.minecraft.util.Direction.Plane;
import static net.minecraft.util.Direction.UP;

public class WarpedCoralFeature extends Feature<NoFeatureConfig> {
    public static boolean doBlockNotify;

    public WarpedCoralFeature(Codec<NoFeatureConfig> config) {
        super(config);
    }

    public boolean func_241855_a(ISeedReader worldIn,  ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        int randCoralHeight = rand.nextInt(7) + 16 / 2;
        BlockPos blockPos = new BlockPos(posX, posY, posZ);
        BlockPos.Mutable block = new BlockPos.Mutable().setPos(blockPos);

        if (!checkArea(worldIn, pos)) {
            return false;
        } else if ((worldIn.getBlockState(pos.down()).getBlock() == BYGBlockList.NYLIUM_SOUL_SAND) || (worldIn.getBlockState(pos.down()).getBlock() == BYGBlockList.NYLIUM_SOUL_SOIL)) {
            for (int i = 0; i <= randCoralHeight; i++) {
                BlockPos.Mutable mutable = new BlockPos.Mutable().setPos(block);

                this.setCoralBlock(worldIn, mutable);
                this.setCoralBlock(worldIn, mutable.move(UP, i));

                for (Direction direction : Plane.HORIZONTAL) {
                    this.setCoralBlock(worldIn, mutable.offset(direction, i / 2));

                }
            }
        }
        return true;
    }

    protected void setCoralBlock(IWorldWriter worldIn, BlockPos pos) {
        this.setBlockStateWithoutUpdates(worldIn, pos, BYGBlockList.WARPED_CORAL_BLOCK.getDefaultState());
    }

    private void setBlockStateWithoutUpdates(IWorldWriter worldWriter, BlockPos blockPos, BlockState blockState) {
        if (doBlockNotify) {
            worldWriter.setBlockState(blockPos, blockState, 19);
        } else {
            worldWriter.setBlockState(blockPos, blockState, 18);
        }
    }

    private boolean checkArea(IWorld world, BlockPos pos) {
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();

        for (int checkX = -2; checkX <= 2; checkX++) {
            for (int checkZ = -2; checkZ <= 2; checkZ++) {
                BlockPos checkArea = new BlockPos(posX + checkX, posY, posZ + checkZ);

                if (!world.isAirBlock(checkArea)) return false;
                if (world.getBlockState(checkArea).getBlock() == BYGBlockList.WARPED_CORAL_BLOCK) return false;

            }
        }
        return true;
    }
}