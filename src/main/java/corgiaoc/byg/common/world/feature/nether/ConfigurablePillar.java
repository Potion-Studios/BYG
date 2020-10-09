package corgiaoc.byg.common.world.feature.nether;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.SimpleBlockProviderConfig;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class ConfigurablePillar extends Feature<SimpleBlockProviderConfig> {
    public ConfigurablePillar(Codec<SimpleBlockProviderConfig> codec) {
        super(codec);
    }

    //A copy paste of Minecraft's Basalt Pillar Feature where the blocks can be chosen in a config rather than hardcoded.
    public boolean func_241855_a(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, SimpleBlockProviderConfig config) {
        if (world.isAirBlock(pos) && !world.isAirBlock(pos.up())) {
            BlockPos.Mutable mutable = pos.toMutable();
            BlockPos.Mutable mutable2 = pos.toMutable();
            boolean flag = true;
            boolean flag1 = true;
            boolean flag2 = true;
            boolean flag3 = true;

            while (world.isAirBlock(mutable)) {
                if (World.isOutsideBuildHeight(mutable)) {
                    return true;
                }

                world.setBlockState(mutable, config.getBlockProvider().getBlockState(rand, mutable), 2);
                flag = flag && this.randChanceBlock2(world, rand, mutable2.setAndMove(mutable, Direction.NORTH), config);
                flag1 = flag1 && this.randChanceBlock2(world, rand, mutable2.setAndMove(mutable, Direction.SOUTH), config);
                flag2 = flag2 && this.randChanceBlock2(world, rand, mutable2.setAndMove(mutable, Direction.WEST), config);
                flag3 = flag3 && this.randChanceBlock2(world, rand, mutable2.setAndMove(mutable, Direction.EAST), config);
                mutable.move(Direction.DOWN);
            }

            mutable.move(Direction.UP);
            this.randChanceBlock(world, rand, mutable2.setAndMove(mutable, Direction.NORTH), config);
            this.randChanceBlock(world, rand, mutable2.setAndMove(mutable, Direction.SOUTH), config);
            this.randChanceBlock(world, rand, mutable2.setAndMove(mutable, Direction.WEST), config);
            this.randChanceBlock(world, rand, mutable2.setAndMove(mutable, Direction.EAST), config);
            mutable.move(Direction.DOWN);
            BlockPos.Mutable mutable3 = new BlockPos.Mutable();

            for (int i = -3; i < 4; ++i) {
                for (int j = -3; j < 4; ++j) {
                    int k = MathHelper.abs(i) * MathHelper.abs(j);
                    if (rand.nextInt(10) < 10 - k) {
                        mutable3.setPos(mutable.add(i, 0, j));
                        int l = 3;

                        while (world.isAirBlock(mutable2.setAndMove(mutable3, Direction.DOWN))) {
                            mutable3.move(Direction.DOWN);
                            --l;
                            if (l <= 0) {
                                break;
                            }
                        }

                        if (!world.isAirBlock(mutable2.setAndMove(mutable3, Direction.DOWN))) {
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

    private void randChanceBlock(IWorld world, Random rand, BlockPos pos, SimpleBlockProviderConfig config) {
        if (rand.nextBoolean()) {
            world.setBlockState(pos, config.getBlockProvider().getBlockState(rand, pos), 2);
        }

    }

    private boolean randChanceBlock2(IWorld world, Random rand, BlockPos pos, SimpleBlockProviderConfig config) {
        if (rand.nextInt(10) != 0) {
            world.setBlockState(pos, config.getBlockProvider().getBlockState(rand, pos), 2);
            return true;
        } else {
            return false;
        }
    }
}