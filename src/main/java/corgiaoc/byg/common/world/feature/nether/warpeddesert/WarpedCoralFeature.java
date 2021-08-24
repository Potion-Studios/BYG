package corgiaoc.byg.common.world.feature.nether.warpeddesert;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.WhitelistedSimpleBlockProviderConfig;
import net.minecraft.util.Direction;
import net.minecraft.util.Direction.Plane;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

import static net.minecraft.util.Direction.UP;

public class WarpedCoralFeature extends Feature<WhitelistedSimpleBlockProviderConfig> {

    public WarpedCoralFeature(Codec<WhitelistedSimpleBlockProviderConfig> config) {
        super(config);
    }

    public boolean place(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, WhitelistedSimpleBlockProviderConfig config) {
        int randCoralHeight = rand.nextInt(7) + 16 / 2;

        if (!checkArea(worldIn, pos, rand, config)) {
            return false;
        } else if (config.getWhitelist().contains(worldIn.getBlockState(pos.below()).getBlock())) {
            for (int i = 0; i <= randCoralHeight; i++) {
                BlockPos.Mutable mutable = new BlockPos.Mutable().set(pos);

                placeCoral(worldIn, mutable, rand, config);
                placeCoral(worldIn, mutable.move(UP, i), rand, config);

                for (Direction direction : Plane.HORIZONTAL) {
                    placeCoral(worldIn, mutable.relative(direction, i / 2), rand, config);

                }
            }
        }
        return true;
    }

    private void placeCoral(ISeedReader world, BlockPos pos, Random rand, WhitelistedSimpleBlockProviderConfig config) {
        if (world.isEmptyBlock(pos))
            world.setBlock(pos, config.getBlockProvider().getState(rand, pos), 2);
    }


    private boolean checkArea(IWorld world, BlockPos pos, Random rand, WhitelistedSimpleBlockProviderConfig config) {
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for (int checkX = -2; checkX <= 2; checkX++) {
            for (int checkZ = -2; checkZ <= 2; checkZ++) {
                mutable.set(posX + checkX, posY, posZ + checkZ);

                if (!world.isEmptyBlock(mutable))
                    return false;
                if (world.getBlockState(mutable) == config.getBlockProvider().getState(rand, mutable))
                    return false;

            }
        }
        return true;
    }
}