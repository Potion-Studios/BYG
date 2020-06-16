package voronoiaoc.byg.common.world.feature.features.nether.warpeddesert;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ModifiableWorld;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

import static net.minecraft.util.math.Direction.UP;

public class WarpedCoralFeature extends Feature<DefaultFeatureConfig> {
    public static boolean doBlockNotify;

    public WarpedCoralFeature(Codec<DefaultFeatureConfig> config) {
        super(config);
    }

    public boolean generate(ServerWorldAccess worldIn, StructureAccessor accessor, ChunkGenerator generator, Random rand, BlockPos pos, DefaultFeatureConfig config) {
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        int randCoralHeight = rand.nextInt(7) + 16 / 2;
        BlockPos blockPos = new BlockPos(posX, posY, posZ);
        BlockPos.Mutable block = new BlockPos.Mutable().set(blockPos);

        if (!checkArea(worldIn, pos) || worldIn.getBlockState(pos.down()).getBlock() != BYGBlockList.NYLIUM_SOUL_SAND) {
            return false;
        } else {

            for (int i = 0; i <= randCoralHeight; i++) {
                BlockPos.Mutable mutable = new BlockPos.Mutable().set(block);

                this.setCoralBlock(worldIn, mutable);
                this.setCoralBlock(worldIn, mutable.move(Direction.UP, i));

                for (Direction direction : Direction.Type.HORIZONTAL) {
                    this.setCoralBlock(worldIn, mutable.offset(direction, i / 2));

                }
            }
        }
        return true;
    }

    protected void setCoralBlock(ModifiableWorld worldIn, BlockPos pos) {
        this.setBlockStateWithoutUpdates(worldIn, pos, BYGBlockList.WARPED_CORAL_BLOCK.getDefaultState());
    }

    private void setBlockStateWithoutUpdates(ModifiableWorld worldWriter, BlockPos blockPos, BlockState blockState) {
        if (doBlockNotify) {
            worldWriter.setBlockState(blockPos, blockState, 19);
        } else {
            worldWriter.setBlockState(blockPos, blockState, 18);
        }
    }

    private boolean checkArea(WorldAccess world, BlockPos pos) {
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();

        for (int checkX = -2; checkX <= 2; checkX++) {
            for (int checkZ = -2; checkZ <= 2; checkZ++) {
                BlockPos checkArea = new BlockPos(posX + checkX, posY, posZ + checkZ);

                if (!world.isAir
                        (checkArea)) return false;
                if (world.getBlockState(checkArea).getBlock() == BYGBlockList.WARPED_CORAL_BLOCK) return false;

            }
        }
        return true;
    }
}