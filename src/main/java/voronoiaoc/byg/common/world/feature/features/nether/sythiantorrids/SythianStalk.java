package voronoiaoc.byg.common.world.feature.features.nether.sythiantorrids;

import com.mojang.serialization.Codec;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.BambooBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BambooLeaves;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;

public class SythianStalk extends Feature<ProbabilityFeatureConfiguration> {
    private static final BlockState BAMBOO_BASE;
    private static final BlockState BAMBOO_LARGE_LEAVES_GROWN;
    private static final BlockState BAMBOO_LARGE_LEAVES;
    private static final BlockState BAMBOO_SMALL_LEAVES;

    public SythianStalk(Codec<ProbabilityFeatureConfiguration> configCodec) {
        super(configCodec);
    }

    public boolean place(WorldGenLevel world, ChunkGenerator generator, Random rand, BlockPos pos, ProbabilityFeatureConfiguration config) {
        int i = 0;
        BlockPos.MutableBlockPos pos1 = new BlockPos.MutableBlockPos().set(pos);
        BlockPos.MutableBlockPos pos2 = new BlockPos.MutableBlockPos().set(pos);
        if (world.isEmptyBlock(pos1)) {
            if (BYGBlockList.SYTHIAN_STALK_BLOCK.defaultBlockState().canSurvive(world, pos1)) {
                int lvt_9_1_ = rand.nextInt(12) + 5;
                int randNextInt;
                if (rand.nextFloat() < config.probability) {
                    randNextInt = rand.nextInt(4) + 1;

                    for (int x = pos.getX() - randNextInt; x <= pos.getX() + randNextInt; ++x) {
                        for (int z = pos.getZ() - randNextInt; z <= pos.getZ() + randNextInt; ++z) {
                            int lvt_13_1_ = x - pos.getX();
                            int lvt_14_1_ = z - pos.getZ();
                            if (lvt_13_1_ * lvt_13_1_ + lvt_14_1_ * lvt_14_1_ <= randNextInt * randNextInt) {
                                pos2.set(x, world.getHeight(Heightmap.Types.WORLD_SURFACE, x, z) - 1, z);
                                if (isDirt(world.getBlockState(pos2).getBlock())) {
                                    world.setBlock(pos2, BYGBlockList.SYTHIAN_NYLIUM.defaultBlockState(), 2);
                                }
                            }
                        }
                    }
                }

                for (randNextInt = 0; randNextInt < lvt_9_1_ && world.isEmptyBlock
                        (pos1); ++randNextInt) {
                    world.setBlock(pos1, BAMBOO_BASE, 2);
                    pos1.move(Direction.UP, 1);
                }

                if (pos1.getY() - pos.getY() >= 3) {
                    world.setBlock(pos1, BAMBOO_LARGE_LEAVES_GROWN, 2);
                    world.setBlock(pos1.move(Direction.DOWN, 1), BAMBOO_LARGE_LEAVES, 2);
                    world.setBlock(pos1.move(Direction.DOWN, 1), BAMBOO_SMALL_LEAVES, 2);
                }
            }

            ++i;
        }

        return i > 0;
    }

    static {
        BAMBOO_BASE = BYGBlockList.SYTHIAN_STALK_BLOCK.defaultBlockState().setValue(BambooBlock.AGE, 1).setValue(BambooBlock.LEAVES, BambooLeaves.NONE).setValue(BambooBlock.STAGE, 0);
        BAMBOO_LARGE_LEAVES_GROWN = BAMBOO_BASE.setValue(BambooBlock.LEAVES, BambooLeaves.LARGE).setValue(BambooBlock.STAGE, 1);
        BAMBOO_LARGE_LEAVES = BAMBOO_BASE.setValue(BambooBlock.LEAVES, BambooLeaves.LARGE);
        BAMBOO_SMALL_LEAVES = BAMBOO_BASE.setValue(BambooBlock.LEAVES, BambooLeaves.SMALL);
    }
}