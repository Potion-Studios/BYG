package potionstudios.byg.common.world.feature.gen.nether.sythiantorrids;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.BambooBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BambooLeaves;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import potionstudios.byg.common.block.BYGBlocks;

import java.util.Random;

public class SythianStalk extends Feature<ProbabilityFeatureConfiguration> {
    private static final BlockState BAMBOO_BASE;
    private static final BlockState BAMBOO_LARGE_LEAVES_GROWN;
    private static final BlockState BAMBOO_LARGE_LEAVES;
    private static final BlockState BAMBOO_SMALL_LEAVES;

    public SythianStalk(Codec<ProbabilityFeatureConfiguration> config) {
        super(config);
    }

    @Override
    public boolean place(FeaturePlaceContext<ProbabilityFeatureConfiguration> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }

    public boolean place(WorldGenLevel world, ChunkGenerator generator, Random rand, BlockPos pos, ProbabilityFeatureConfiguration config) {
        int aNumber = 0;
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().set(pos);
        BlockPos.MutableBlockPos mutable2 = new BlockPos.MutableBlockPos().set(pos);
        if (world.isEmptyBlock(mutable)) {
            if (BYGBlocks.SYTHIAN_STALK_BLOCK.defaultBlockState().canSurvive(world, mutable)) {
                int randSpawnHeight = rand.nextInt(12) + 5;
                int randNextInt;
                if (rand.nextFloat() < config.probability) {
                    randNextInt = rand.nextInt(4) + 1;

                    for (int x = pos.getX() - randNextInt; x <= pos.getX() + randNextInt; ++x) {
                        for (int z = pos.getZ() - randNextInt; z <= pos.getZ() + randNextInt; ++z) {
                            int xBuild = x - pos.getX();
                            int zBuild = z - pos.getZ();
                            if (xBuild * xBuild + zBuild * zBuild <= randNextInt * randNextInt) {
                                mutable2.set(x, world.getHeight(Heightmap.Types.WORLD_SURFACE, x, z) - 1, z);
                                if (isDirt(world.getBlockState(mutable2))) {
                                    world.setBlock(mutable2, BYGBlocks.SYTHIAN_NYLIUM.defaultBlockState(), 2);
                                }
                            }
                        }
                    }
                }

                for (randNextInt = 0; randNextInt < randSpawnHeight && world.isEmptyBlock(mutable); ++randNextInt) {
                    world.setBlock(mutable, BAMBOO_BASE, 2);
                    mutable.move(Direction.UP, 1);
                }

                if (mutable.getY() - pos.getY() >= 3) {
                    world.setBlock(mutable, BAMBOO_LARGE_LEAVES_GROWN, 2);
                    world.setBlock(mutable.move(Direction.DOWN, 1), BAMBOO_LARGE_LEAVES, 2);
                    world.setBlock(mutable.move(Direction.DOWN, 1), BAMBOO_SMALL_LEAVES, 2);
                }
            }

            ++aNumber;
        }

        return aNumber > 0;
    }

    static {
        BAMBOO_BASE = BYGBlocks.SYTHIAN_STALK_BLOCK.defaultBlockState().setValue(BambooBlock.AGE, 1).setValue(BambooBlock.LEAVES, BambooLeaves.NONE).setValue(BambooBlock.STAGE, 0);
        BAMBOO_LARGE_LEAVES_GROWN = BAMBOO_BASE.setValue(BambooBlock.LEAVES, BambooLeaves.LARGE).setValue(BambooBlock.STAGE, 1);
        BAMBOO_LARGE_LEAVES = BAMBOO_BASE.setValue(BambooBlock.LEAVES, BambooLeaves.LARGE);
        BAMBOO_SMALL_LEAVES = BAMBOO_BASE.setValue(BambooBlock.LEAVES, BambooLeaves.SMALL);
    }
}