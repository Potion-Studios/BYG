package corgiaoc.byg.common.world.feature.nether.brimstone;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BrimstoneVentsConfig;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockStateMatcher;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class BrimstoneVentFeature extends Feature<BrimstoneVentsConfig> {
    private static final BlockStateMatcher IS_BRIMSTONE = BlockStateMatcher.forBlock(BYGBlocks.BRIMSTONE);
    private final BlockState brimstone = BYGBlocks.BRIMSTONE.defaultBlockState();
    private final BlockState lava = Blocks.LAVA.defaultBlockState();

    public BrimstoneVentFeature(Codec<BrimstoneVentsConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(ISeedReader world, ChunkGenerator generator, Random random, BlockPos pos, BrimstoneVentsConfig config) {

        if (world.getBlockState(pos.below()) != config.getBlockProvider().getState(random, pos) || !world.getBlockState(pos.below()).canOcclude())
            return false;

        if (!IS_BRIMSTONE.test(world.getBlockState(pos))) {
            return false;
        } else {
            for(int i = -3; i <= 3; ++i) {
                for(int j = -3; j <= 3; ++j) {
                    if (world.isEmptyBlock(pos.offset(i, -1, j)) && world.isEmptyBlock(pos.offset(i, -3, j))) {
                        return false;
                    }
                }
            }
            if (world.getBlockState(pos.above()) == BYGBlocks.BRIMSTONE.defaultBlockState()){
                return false;
            }

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
            }
            else {
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
}
