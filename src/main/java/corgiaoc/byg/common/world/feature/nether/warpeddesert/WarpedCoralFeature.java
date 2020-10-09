package corgiaoc.byg.common.world.feature.nether.warpeddesert;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.WhiteListedSimpleBlockProviderConfig;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

import static net.minecraft.util.Direction.Plane;
import static net.minecraft.util.Direction.UP;

public class WarpedCoralFeature extends Feature<WhiteListedSimpleBlockProviderConfig> {

    public WarpedCoralFeature(Codec<WhiteListedSimpleBlockProviderConfig> config) {
        super(config);
    }

    public boolean func_241855_a(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, WhiteListedSimpleBlockProviderConfig config) {
        int randCoralHeight = rand.nextInt(7) + 16 / 2;

        if (!checkArea(worldIn, pos, rand, config)) {
            return false;
        } else if (config.getWhitelist().contains(worldIn.getBlockState(pos.down()).getBlock())) {
            for (int i = 0; i <= randCoralHeight; i++) {
                BlockPos.Mutable mutable = new BlockPos.Mutable().setPos(pos);

                worldIn.setBlockState(mutable, config.getBlockProvider().getBlockState(rand, mutable),  2);
                worldIn.setBlockState(mutable.move(UP, i), config.getBlockProvider().getBlockState(rand, mutable),  2);

                for (Direction direction : Plane.HORIZONTAL) {
                    worldIn.setBlockState(mutable.offset(direction, i / 2), config.getBlockProvider().getBlockState(rand, mutable), 2);

                }
            }
        }
        return true;
    }


    private boolean checkArea(IWorld world, BlockPos pos, Random rand, WhiteListedSimpleBlockProviderConfig config) {
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for (int checkX = -2; checkX <= 2; checkX++) {
            for (int checkZ = -2; checkZ <= 2; checkZ++) {
                mutable.setPos(posX + checkX, posY, posZ + checkZ);

                if (!world.isAirBlock(mutable))
                    return false;
                if (world.getBlockState(mutable) == config.getBlockProvider().getBlockState(rand, mutable))
                    return false;

            }
        }
        return true;
    }
}