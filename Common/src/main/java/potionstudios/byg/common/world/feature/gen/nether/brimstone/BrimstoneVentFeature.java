package potionstudios.byg.common.world.feature.gen.nether.brimstone;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.feature.config.BrimstoneVentsConfig;

import java.util.Random;

public class BrimstoneVentFeature extends Feature<BrimstoneVentsConfig> {
    private static final BlockStatePredicate IS_BRIMSTONE = BlockStatePredicate.forBlock(BYGBlocks.BRIMSTONE);
    private final BlockState brimstone = BYGBlocks.BRIMSTONE.defaultBlockState();
    private final BlockState lava = Blocks.LAVA.defaultBlockState();

    public BrimstoneVentFeature(Codec<BrimstoneVentsConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<BrimstoneVentsConfig> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }

    public boolean place(WorldGenLevel world, ChunkGenerator generator, Random random, BlockPos pos, BrimstoneVentsConfig config) {

        int type = random.nextInt(2);

        if (type == 1) {
            for (int k1 = 1; k1 <= 4; ++k1) {
                world.setBlock(pos.offset(2, k1, 0), this.brimstone, 3);
                world.setBlock(pos.offset(0, k1, -2), this.brimstone, 3);
                world.setBlock(pos.offset(1, k1, -1), this.brimstone, 3);
                world.setBlock(pos.offset(-2, k1, -1), this.brimstone, 3);
                world.setBlock(pos.offset(-2, k1, 1), this.brimstone, 3);
                world.setBlock(pos.offset(-1, k1, -2), this.brimstone, 3);
                world.setBlock(pos.offset(-1, k1, 2), this.brimstone, 3);
            }

            for (int k1 = 1; k1 <= 5; ++k1) {
                world.setBlock(pos.offset(0, k1, 2), this.brimstone, 3);
                world.setBlock(pos.offset(-2, k1, 0), this.brimstone, 3);
                world.setBlock(pos.offset(1, k1, 1), this.brimstone, 3);
            }

            for (int k1 = 1; k1 <= 3; ++k1) {
                world.setBlock(pos.offset(2, k1, -1), this.brimstone, 3);
                world.setBlock(pos.offset(2, k1, 1), this.brimstone, 3);
                world.setBlock(pos.offset(1, k1, -2), this.brimstone, 3);
                world.setBlock(pos.offset(1, k1, 2), this.brimstone, 3);


                world.setBlock(pos.offset(0, k1, 0), this.lava, 2);
                world.setBlock(pos.offset(-1, k1, 0), this.lava, 2);
                world.setBlock(pos.offset(1, k1, 0), this.lava, 2);
                world.setBlock(pos.offset(0, k1, 1), this.lava, 2);
                world.setBlock(pos.offset(0, k1, -1), this.lava, 2);
                world.setBlock(pos.offset(-1, k1, -1), this.lava, 2);
                world.setBlock(pos.offset(-1, k1, 1), this.lava, 2);

            }

            for (int k1 = 1; k1 <= 2; ++k1) {
                world.setBlock(pos.offset(2, 1, -2), this.brimstone, 3);
                world.setBlock(pos.offset(2, 1, 2), this.brimstone, 3);
                world.setBlock(pos.offset(-2, k1, -2), this.brimstone, 3);
                world.setBlock(pos.offset(-2, 1, 2), this.brimstone, 3);
                world.setBlock(pos.offset(-3, 1, 1), this.brimstone, 3);
                world.setBlock(pos.offset(-3, 1, -1), this.brimstone, 3);
                world.setBlock(pos.offset(3, k1, -1), this.brimstone, 3);
                world.setBlock(pos.offset(-1, k1, 3), this.brimstone, 3);
                world.setBlock(pos.offset(1, 1, -3), this.brimstone, 3);
                world.setBlock(pos.offset(-1, 1, -3), this.brimstone, 3);
                world.setBlock(pos.offset(-3, 1, 0), this.brimstone, 3);
                world.setBlock(pos.offset(3, 1, 0), this.brimstone, 3);
                world.setBlock(pos.offset(0, 1, 3), this.brimstone, 3);
                world.setBlock(pos.offset(0, k1, -3), this.brimstone, 3);

            }
        } else {
            for (int k1 = 1; k1 <= 4; ++k1) {
                world.setBlock(pos.offset(2, k1, 0), this.brimstone, 3);
                world.setBlock(pos.offset(-1, k1, -2), this.brimstone, 3);
                world.setBlock(pos.offset(-1, k1, 2), this.brimstone, 3);
                world.setBlock(pos.offset(2, k1, -1), this.brimstone, 3);
                world.setBlock(pos.offset(1, k1, 2), this.brimstone, 3);
                world.setBlock(pos.offset(2, k1, 1), this.brimstone, 3);

            }

            for (int k1 = 1; k1 <= 5; ++k1) {
                world.setBlock(pos.offset(0, k1, 2), this.brimstone, 3);
                world.setBlock(pos.offset(-2, k1, 0), this.brimstone, 3);
                world.setBlock(pos.offset(1, k1, 1), this.brimstone, 3);
                world.setBlock(pos.offset(0, k1, -2), this.brimstone, 3);


            }

            for (int k1 = 1; k1 <= 3; ++k1) {

                world.setBlock(pos.offset(1, k1, -2), this.brimstone, 3);
                world.setBlock(pos.offset(1, k1, -1), this.brimstone, 3);
                world.setBlock(pos.offset(-2, k1, -1), this.brimstone, 3);
                world.setBlock(pos.offset(-2, k1, 1), this.brimstone, 3);


                world.setBlock(pos.offset(0, k1, 0), this.lava, 2);
                world.setBlock(pos.offset(-1, k1, 0), this.lava, 2);
                world.setBlock(pos.offset(1, k1, 0), this.lava, 2);
                world.setBlock(pos.offset(0, k1, 1), this.lava, 2);
                world.setBlock(pos.offset(0, k1, -1), this.lava, 2);
                world.setBlock(pos.offset(-1, k1, -1), this.lava, 2);
                world.setBlock(pos.offset(-1, k1, 1), this.lava, 2);

            }

            for (int k1 = 1; k1 <= 2; ++k1) {
                world.setBlock(pos.offset(2, k1, -2), this.brimstone, 3);
                world.setBlock(pos.offset(2, 1, 2), this.brimstone, 3);
                world.setBlock(pos.offset(-2, k1, -2), this.brimstone, 3);
                world.setBlock(pos.offset(-2, 1, 2), this.brimstone, 3);
                world.setBlock(pos.offset(-3, 1, 1), this.brimstone, 3);
                world.setBlock(pos.offset(-3, 1, -1), this.brimstone, 3);
                world.setBlock(pos.offset(3, k1, -1), this.brimstone, 3);
                world.setBlock(pos.offset(-1, k1, 3), this.brimstone, 3);
                world.setBlock(pos.offset(1, k1, -3), this.brimstone, 3);
                world.setBlock(pos.offset(-1, 1, -3), this.brimstone, 3);
                world.setBlock(pos.offset(-3, k1, 0), this.brimstone, 3);
                world.setBlock(pos.offset(3, 1, 0), this.brimstone, 3);
                world.setBlock(pos.offset(0, 1, 3), this.brimstone, 3);
                world.setBlock(pos.offset(0, k1, -3), this.brimstone, 3);

            }

        }

        return true;
    }
}
