package potionstudios.byg.common.world.feature.gen.nether;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import potionstudios.byg.common.world.feature.config.SimpleBlockProviderConfig;

import java.util.Random;

public class ConfigurablePillar extends Feature<SimpleBlockProviderConfig> {
    public ConfigurablePillar(Codec<SimpleBlockProviderConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<SimpleBlockProviderConfig> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }

    //A copy paste of Minecraft's Basalt Pillar Feature where the blocks can be chosen in a config rather than hardcoded.
    public boolean place(WorldGenLevel world, ChunkGenerator generator, Random rand, BlockPos pos, SimpleBlockProviderConfig config) {
        if (world.isEmptyBlock(pos) && !world.isEmptyBlock(pos.above())) {
            BlockPos.MutableBlockPos mutable = pos.mutable();
            BlockPos.MutableBlockPos mutable2 = pos.mutable();
            boolean flag = true;
            boolean flag1 = true;
            boolean flag2 = true;
            boolean flag3 = true;

            while (world.isEmptyBlock(mutable)) {
                if (world.isOutsideBuildHeight(mutable)) {
                    return true;
                }

                world.setBlock(mutable, config.getBlockProvider().getState(rand, mutable), 2);
                flag = flag && this.randChanceBlock2(world, rand, mutable2.setWithOffset(mutable, Direction.NORTH), config);
                flag1 = flag1 && this.randChanceBlock2(world, rand, mutable2.setWithOffset(mutable, Direction.SOUTH), config);
                flag2 = flag2 && this.randChanceBlock2(world, rand, mutable2.setWithOffset(mutable, Direction.WEST), config);
                flag3 = flag3 && this.randChanceBlock2(world, rand, mutable2.setWithOffset(mutable, Direction.EAST), config);
                mutable.move(Direction.DOWN);
            }

            mutable.move(Direction.UP);
            this.randChanceBlock(world, rand, mutable2.setWithOffset(mutable, Direction.NORTH), config);
            this.randChanceBlock(world, rand, mutable2.setWithOffset(mutable, Direction.SOUTH), config);
            this.randChanceBlock(world, rand, mutable2.setWithOffset(mutable, Direction.WEST), config);
            this.randChanceBlock(world, rand, mutable2.setWithOffset(mutable, Direction.EAST), config);
            mutable.move(Direction.DOWN);
            BlockPos.MutableBlockPos mutable3 = new BlockPos.MutableBlockPos();

            for (int i = -3; i < 4; ++i) {
                for (int j = -3; j < 4; ++j) {
                    int k = Mth.abs(i) * Mth.abs(j);
                    if (rand.nextInt(10) < 10 - k) {
                        mutable3.set(mutable.offset(i, 0, j));
                        int l = 3;

                        while (world.isEmptyBlock(mutable2.setWithOffset(mutable3, Direction.DOWN))) {
                            mutable3.move(Direction.DOWN);
                            --l;
                            if (l <= 0) {
                                break;
                            }
                        }

                        if (!world.isEmptyBlock(mutable2.setWithOffset(mutable3, Direction.DOWN))) {
                            world.setBlock(mutable3, config.getBlockProvider().getState(rand, mutable), 2);
                        }
                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }

    private void randChanceBlock(LevelAccessor world, Random rand, BlockPos pos, SimpleBlockProviderConfig config) {
        if (rand.nextBoolean()) {
            world.setBlock(pos, config.getBlockProvider().getState(rand, pos), 2);
        }

    }

    private boolean randChanceBlock2(LevelAccessor world, Random rand, BlockPos pos, SimpleBlockProviderConfig config) {
        if (rand.nextInt(10) != 0) {
            world.setBlock(pos, config.getBlockProvider().getState(rand, pos), 2);
            return true;
        } else {
            return false;
        }
    }
}