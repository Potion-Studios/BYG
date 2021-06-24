package corgiaoc.byg.common.world.feature.nether;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.HangingColumnWithBaseConfig;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Random;

public class HangingColumnWithBase extends Feature<HangingColumnWithBaseConfig> {
    private static final Direction[] DIRECTIONS = Direction.values();

    public HangingColumnWithBase(Codec<HangingColumnWithBaseConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<HangingColumnWithBaseConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos pos = context.getOrigin();
        Random rand = context.getRandom();
        HangingColumnWithBaseConfig config = context.getConfig();

        if (!world.isAir(pos)) {
            return false;
        } else {
            BlockState blockstate = world.getBlockState(pos.up());
            if (!config.getWhitelist().contains(blockstate.getBlock())) {
                return false;
            } else {
                this.generateBase(world, rand, pos, config);
                this.generateVinesInArea(world, rand, pos, config);
                return true;
            }
        }
    }

    private void generateBase(WorldAccess world, Random rand, BlockPos pos, HangingColumnWithBaseConfig config) {
        world.setBlockState(pos, config.getBaseBlockProvider().getBlockState(rand, pos), 2);
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        BlockPos.Mutable mutable2 = new BlockPos.Mutable();

        for (int i = 0; i < 200; ++i) {
            mutable.set(pos, rand.nextInt(6) - rand.nextInt(6), rand.nextInt(2) - rand.nextInt(5), rand.nextInt(6) - rand.nextInt(6));
            if (world.isAir(mutable)) {
                int j = 0;

                for (Direction direction : DIRECTIONS) {
                    BlockState blockstate = world.getBlockState(mutable2.set(mutable, direction));
                    if (config.getWhitelist().contains(blockstate.getBlock())) {
                        ++j;
                    }

                    if (j > 1) {
                        break;
                    }
                }

                if (j == 1) {
                    world.setBlockState(mutable, config.getBaseBlockProvider().getBlockState(rand, mutable), 2);
                }
            }
        }

    }

    private void generateVinesInArea(WorldAccess world, Random rand, BlockPos pos, HangingColumnWithBaseConfig config) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for (int i = 0; i < 100; ++i) {
            mutable.set(pos, rand.nextInt(8) - rand.nextInt(8), rand.nextInt(2) - rand.nextInt(7), rand.nextInt(8) - rand.nextInt(8));
            if (world.isAir(mutable)) {
                BlockState blockstate = world.getBlockState(mutable.up());
                if (config.getWhitelist().contains(blockstate.getBlock())) {
                    int length = MathHelper.nextInt(rand, config.getMinLength(), config.getMaxLength());
                    if (rand.nextInt(6) == 0) {
                        length *= 2;
                    }

                    if (rand.nextInt(5) == 0) {
                        length = 1;
                    }
                    generateLength(world, mutable, length, rand, config);
                }
            }
        }

    }

    public static void generateLength(WorldAccess world, BlockPos.Mutable mutable, int length, Random rand, HangingColumnWithBaseConfig config) {
        for (int i = 0; i <= length; ++i) {
            if (world.isAir(mutable)) {
                if (i == length || !world.isAir(mutable.down())) {
                    world.setBlockState(mutable, config.getEndBlockProvider().getBlockState(rand, mutable), 2);
                    break;
                }

                world.setBlockState(mutable, config.getBlockProvider().getBlockState(rand, mutable), 2);
            }

            mutable.move(Direction.DOWN);
        }

    }
}