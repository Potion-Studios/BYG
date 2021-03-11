package corgiaoc.byg.common.world.feature.nether.sythiantorrids;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.BambooBlock;
import net.minecraft.block.BlockState;
import net.minecraft.state.properties.BambooLeaves;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ProbabilityConfig;

import java.util.Random;

public class SythianStalk extends Feature<ProbabilityConfig> {
    private static final BlockState BAMBOO_BASE;
    private static final BlockState BAMBOO_LARGE_LEAVES_GROWN;
    private static final BlockState BAMBOO_LARGE_LEAVES;
    private static final BlockState BAMBOO_SMALL_LEAVES;

    public SythianStalk(Codec<ProbabilityConfig> config) {
        super(config);
    }

    public boolean place(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, ProbabilityConfig config) {
        int aNumber = 0;
        BlockPos.Mutable mutable = new BlockPos.Mutable().set(pos);
        BlockPos.Mutable mutable2 = new BlockPos.Mutable().set(pos);
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
                                mutable2.set(x, world.getHeight(Heightmap.Type.WORLD_SURFACE, x, z) - 1, z);
                                if (isDirt(world.getBlockState(mutable2).getBlock())) {
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