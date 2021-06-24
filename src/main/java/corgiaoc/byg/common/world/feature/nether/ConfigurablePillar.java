package corgiaoc.byg.common.world.feature.nether;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.SimpleBlockProviderConfig;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Random;

public class ConfigurablePillar extends Feature<SimpleBlockProviderConfig> {
    public ConfigurablePillar(Codec<SimpleBlockProviderConfig> codec) {
        super(codec);
    }

    //A copy paste of Minecraft's Basalt Pillar Feature where the blocks can be chosen in a config rather than hardcoded.
    @Override
    public boolean generate(FeatureContext<SimpleBlockProviderConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos pos = context.getOrigin();
        Random rand = context.getRandom();
        SimpleBlockProviderConfig config = context.getConfig();

        if (world.isAir(pos) && !world.isAir(pos.up())) {
            BlockPos.Mutable mutable = pos.mutableCopy();
            BlockPos.Mutable mutable2 = pos.mutableCopy();
            boolean flag = true;
            boolean flag1 = true;
            boolean flag2 = true;
            boolean flag3 = true;

            while (world.isAir(mutable)) {
                if (world.toServerWorld().isOutOfHeightLimit(mutable)) {
                    return true;
                }

                world.setBlockState(mutable, config.getBlockProvider().getBlockState(rand, mutable), 2);
                flag = flag && this.randChanceBlock2(world, rand, mutable2.set(mutable, Direction.NORTH), config);
                flag1 = flag1 && this.randChanceBlock2(world, rand, mutable2.set(mutable, Direction.SOUTH), config);
                flag2 = flag2 && this.randChanceBlock2(world, rand, mutable2.set(mutable, Direction.WEST), config);
                flag3 = flag3 && this.randChanceBlock2(world, rand, mutable2.set(mutable, Direction.EAST), config);
                mutable.move(Direction.DOWN);
            }

            mutable.move(Direction.UP);
            this.randChanceBlock(world, rand, mutable2.set(mutable, Direction.NORTH), config);
            this.randChanceBlock(world, rand, mutable2.set(mutable, Direction.SOUTH), config);
            this.randChanceBlock(world, rand, mutable2.set(mutable, Direction.WEST), config);
            this.randChanceBlock(world, rand, mutable2.set(mutable, Direction.EAST), config);
            mutable.move(Direction.DOWN);
            BlockPos.Mutable mutable3 = new BlockPos.Mutable();

            for (int i = -3; i < 4; ++i) {
                for (int j = -3; j < 4; ++j) {
                    int k = MathHelper.abs(i) * MathHelper.abs(j);
                    if (rand.nextInt(10) < 10 - k) {
                        mutable3.set(mutable.add(i, 0, j));
                        int l = 3;

                        while (world.isAir(mutable2.set(mutable3, Direction.DOWN))) {
                            mutable3.move(Direction.DOWN);
                            --l;
                            if (l <= 0) {
                                break;
                            }
                        }

                        if (!world.isAir(mutable2.set(mutable3, Direction.DOWN))) {
                            world.setBlockState(mutable3, config.getBlockProvider().getBlockState(rand, mutable), 2);
                        }
                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }

    private void randChanceBlock(WorldAccess world, Random rand, BlockPos pos, SimpleBlockProviderConfig config) {
        if (rand.nextBoolean()) {
            world.setBlockState(pos, config.getBlockProvider().getBlockState(rand, pos), 2);
        }

    }

    private boolean randChanceBlock2(WorldAccess world, Random rand, BlockPos pos, SimpleBlockProviderConfig config) {
        if (rand.nextInt(10) != 0) {
            world.setBlockState(pos, config.getBlockProvider().getBlockState(rand, pos), 2);
            return true;
        } else {
            return false;
        }
    }
}