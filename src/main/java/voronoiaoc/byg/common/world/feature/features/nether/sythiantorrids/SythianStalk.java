package voronoiaoc.byg.common.world.feature.features.nether.sythiantorrids;

import com.mojang.serialization.Codec;
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
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class SythianStalk extends Feature<ProbabilityConfig> {
    private static final BlockState BAMBOO_BASE;
    private static final BlockState BAMBOO_LARGE_LEAVES_GROWN;
    private static final BlockState BAMBOO_LARGE_LEAVES;
    private static final BlockState BAMBOO_SMALL_LEAVES;

    public SythianStalk(Codec<ProbabilityConfig> config) {
        super(config);
    }

    public boolean func_241855_a(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, ProbabilityConfig config) {
        int lvt_6_1_ = 0;
        BlockPos.Mutable mutable = new BlockPos.Mutable().setPos(pos);
        BlockPos.Mutable mutable2 = new BlockPos.Mutable().setPos(pos);
        if (world.isAirBlock(mutable)) {
            if (BYGBlockList.SYTHIAN_STALK_BLOCK.getDefaultState().isValidPosition(world, mutable)) {
                int randSpawnHeight = rand.nextInt(12) + 5;
                int randNextInt;
                if (rand.nextFloat() < config.probability) {
                    randNextInt = rand.nextInt(4) + 1;

                    for (int x = pos.getX() - randNextInt; x <= pos.getX() + randNextInt; ++x) {
                        for (int z = pos.getZ() - randNextInt; z <= pos.getZ() + randNextInt; ++z) {
                            int lvt_13_1_ = x - pos.getX();
                            int lvt_14_1_ = z - pos.getZ();
                            if (lvt_13_1_ * lvt_13_1_ + lvt_14_1_ * lvt_14_1_ <= randNextInt * randNextInt) {
                                mutable2.setPos(x, world.getHeight(Heightmap.Type.WORLD_SURFACE, x, z) - 1, z);
                                if (isDirt(world.getBlockState(mutable2).getBlock())) {
                                    world.setBlockState(mutable2, BYGBlockList.SYTHIAN_NYLIUM.getDefaultState(), 2);
                                }
                            }
                        }
                    }
                }

                for (randNextInt = 0; randNextInt < randSpawnHeight && world.isAirBlock(mutable); ++randNextInt) {
                    world.setBlockState(mutable, BAMBOO_BASE, 2);
                    mutable.move(Direction.UP, 1);
                }

                if (mutable.getY() - pos.getY() >= 3) {
                    world.setBlockState(mutable, BAMBOO_LARGE_LEAVES_GROWN, 2);
                    world.setBlockState(mutable.move(Direction.DOWN, 1), BAMBOO_LARGE_LEAVES, 2);
                    world.setBlockState(mutable.move(Direction.DOWN, 1), BAMBOO_SMALL_LEAVES, 2);
                }
            }

            ++lvt_6_1_;
        }

        return lvt_6_1_ > 0;
    }

    static {
        BAMBOO_BASE = BYGBlockList.SYTHIAN_STALK_BLOCK.getDefaultState().with(BambooBlock.PROPERTY_AGE, 1).with(BambooBlock.PROPERTY_BAMBOO_LEAVES, BambooLeaves.NONE).with(BambooBlock.PROPERTY_STAGE, 0);
        BAMBOO_LARGE_LEAVES_GROWN = BAMBOO_BASE.with(BambooBlock.PROPERTY_BAMBOO_LEAVES, BambooLeaves.LARGE).with(BambooBlock.PROPERTY_STAGE, 1);
        BAMBOO_LARGE_LEAVES = BAMBOO_BASE.with(BambooBlock.PROPERTY_BAMBOO_LEAVES, BambooLeaves.LARGE);
        BAMBOO_SMALL_LEAVES = BAMBOO_BASE.with(BambooBlock.PROPERTY_BAMBOO_LEAVES, BambooLeaves.SMALL);
    }
}