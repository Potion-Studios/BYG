package potionstudios.byg.common.world.feature.gen.nether.warpeddesert;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Plane;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import potionstudios.byg.common.world.feature.config.WhitelistedSimpleBlockProviderConfig;

import java.util.Random;

import static net.minecraft.core.Direction.UP;

public class WarpedCoralFeature extends Feature<WhitelistedSimpleBlockProviderConfig> {

    public WarpedCoralFeature(Codec<WhitelistedSimpleBlockProviderConfig> config) {
        super(config);
    }

    @Override
    public boolean place(FeaturePlaceContext<WhitelistedSimpleBlockProviderConfig> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }

    public boolean place(WorldGenLevel worldIn, ChunkGenerator generator, Random rand, BlockPos pos, WhitelistedSimpleBlockProviderConfig config) {
        int randCoralHeight = rand.nextInt(7) + 16 / 2;

        if (!checkArea(worldIn, pos, rand, config)) {
            return false;
        } else if (config.getWhitelist().contains(worldIn.getBlockState(pos.below()).getBlock())) {
            for (int i = 0; i <= randCoralHeight; i++) {
                BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().set(pos);

                placeCoral(worldIn, mutable, rand, config);
                placeCoral(worldIn, mutable.move(UP, i), rand, config);

                for (Direction direction : Plane.HORIZONTAL) {
                    placeCoral(worldIn, mutable.relative(direction, i / 2), rand, config);

                }
            }
        }
        return true;
    }

    private void placeCoral(WorldGenLevel world, BlockPos pos, Random rand, WhitelistedSimpleBlockProviderConfig config) {
        if (world.isEmptyBlock(pos))
            world.setBlock(pos, config.getBlockProvider().getState(rand, pos), 2);
    }


    private boolean checkArea(LevelAccessor world, BlockPos pos, Random rand, WhitelistedSimpleBlockProviderConfig config) {
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

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