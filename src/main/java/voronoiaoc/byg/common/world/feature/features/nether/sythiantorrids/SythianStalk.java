package voronoiaoc.byg.common.world.feature.features.nether.sythiantorrids;

import com.mojang.serialization.Codec;
import net.minecraft.block.BambooBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.BambooLeaves;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class SythianStalk extends Feature<ProbabilityConfig> {
    private static final BlockState BAMBOO_BASE;
    private static final BlockState BAMBOO_LARGE_LEAVES_GROWN;
    private static final BlockState BAMBOO_LARGE_LEAVES;
    private static final BlockState BAMBOO_SMALL_LEAVES;

    public SythianStalk(Codec<ProbabilityConfig> configCodec) {
        super(configCodec);
    }

    public boolean generate(StructureWorldAccess world, ChunkGenerator generator, Random rand, BlockPos pos, ProbabilityConfig config) {
        int i = 0;
        BlockPos.Mutable pos1 = new BlockPos.Mutable().set(pos);
        BlockPos.Mutable pos2 = new BlockPos.Mutable().set(pos);
        if (world.isAir(pos1)) {
            if (BYGBlockList.SYTHIAN_STALK_BLOCK.getDefaultState().canPlaceAt(world, pos1)) {
                int lvt_9_1_ = rand.nextInt(12) + 5;
                int randNextInt;
                if (rand.nextFloat() < config.probability) {
                    randNextInt = rand.nextInt(4) + 1;

                    for (int x = pos.getX() - randNextInt; x <= pos.getX() + randNextInt; ++x) {
                        for (int z = pos.getZ() - randNextInt; z <= pos.getZ() + randNextInt; ++z) {
                            int lvt_13_1_ = x - pos.getX();
                            int lvt_14_1_ = z - pos.getZ();
                            if (lvt_13_1_ * lvt_13_1_ + lvt_14_1_ * lvt_14_1_ <= randNextInt * randNextInt) {
                                pos2.set(x, world.getTopY(Heightmap.Type.WORLD_SURFACE, x, z) - 1, z);
                                if (isSoil(world.getBlockState(pos2).getBlock())) {
                                    world.setBlockState(pos2, BYGBlockList.SYTHIAN_NYLIUM.getDefaultState(), 2);
                                }
                            }
                        }
                    }
                }

                for (randNextInt = 0; randNextInt < lvt_9_1_ && world.isAir
                        (pos1); ++randNextInt) {
                    world.setBlockState(pos1, BAMBOO_BASE, 2);
                    pos1.move(Direction.UP, 1);
                }

                if (pos1.getY() - pos.getY() >= 3) {
                    world.setBlockState(pos1, BAMBOO_LARGE_LEAVES_GROWN, 2);
                    world.setBlockState(pos1.move(Direction.DOWN, 1), BAMBOO_LARGE_LEAVES, 2);
                    world.setBlockState(pos1.move(Direction.DOWN, 1), BAMBOO_SMALL_LEAVES, 2);
                }
            }

            ++i;
        }

        return i > 0;
    }

    static {
        BAMBOO_BASE = BYGBlockList.SYTHIAN_STALK_BLOCK.getDefaultState().with(BambooBlock.AGE, 1).with(BambooBlock.LEAVES, BambooLeaves.NONE).with(BambooBlock.STAGE, 0);
        BAMBOO_LARGE_LEAVES_GROWN = BAMBOO_BASE.with(BambooBlock.LEAVES, BambooLeaves.LARGE).with(BambooBlock.STAGE, 1);
        BAMBOO_LARGE_LEAVES = BAMBOO_BASE.with(BambooBlock.LEAVES, BambooLeaves.LARGE);
        BAMBOO_SMALL_LEAVES = BAMBOO_BASE.with(BambooBlock.LEAVES, BambooLeaves.SMALL);
    }
}