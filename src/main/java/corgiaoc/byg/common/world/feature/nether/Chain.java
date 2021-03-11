package corgiaoc.byg.common.world.feature.nether;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.ChainConfig;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class Chain extends Feature<ChainConfig> {
    public Chain(Codec<ChainConfig> config) {
        super(config);
    }

    public boolean place(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, ChainConfig config) {
        int randChainLength = config.getMinLength() + rand.nextInt(config.getMaxPossibleLength());

        BlockPos.Mutable mainMutable1 = new BlockPos.Mutable().set(pos);
        BlockPos.Mutable mainMutable2 = new BlockPos.Mutable().set(pos);
        mainMutable1.move(Direction.UP, 2);
        mainMutable2.move(Direction.UP, 2);

        if (worldIn.getBlockState(pos).getBlock() == Blocks.BEDROCK) {
            return false;
        } else if (!config.getWhitelist().contains(worldIn.getBlockState(pos.above()).getBlock())) {
            return false;
        } else {
            for (int moveDown = 0; moveDown <= randChainLength; ) {
                for (int move = -1; move <= 1; move++) {
                    BlockPos.Mutable mutable1 = new BlockPos.Mutable(mainMutable1.getX() + move, mainMutable1.getY(), mainMutable1.getZ());
                    BlockPos.Mutable mutable2 = new BlockPos.Mutable().set(mutable1.offset(0, -4, 0));
                    BlockPos.Mutable mutable3 = new BlockPos.Mutable().set(mainMutable2.getX(), mainMutable2.getY() - 3, mainMutable2.getZ() + move);
                    BlockPos.Mutable mutable4 = new BlockPos.Mutable().set(mutable3.offset(0, -4, 0));

                    //X axis
                    if (canReplaceBlock(worldIn, mutable1))
                        worldIn.setBlock(mutable1, config.getXAxisBlockProvider().getState(rand, mutable1), 2);
                    if (canReplaceBlock(worldIn, mutable2))
                        worldIn.setBlock(mutable2, config.getXAxisBlockProvider().getState(rand, mutable2), 2);

                    //Z axis
                    if (canReplaceBlock(worldIn, mutable3))
                        worldIn.setBlock(mutable3, config.getzAxisBlockProvider().getState(rand, mutable3), 2);
                    if (canReplaceBlock(worldIn, mutable4))
                        worldIn.setBlock(mutable4, config.getzAxisBlockProvider().getState(rand, mutable4), 2);


                    BlockPos.Mutable mutable5 = new BlockPos.Mutable(mainMutable1.getX() + 2, (mainMutable1.getY() - 2) + move, mainMutable1.getZ());
                    BlockPos.Mutable mutable6 = new BlockPos.Mutable(mainMutable2.getX(), (mainMutable2.getY() - 5) + move, mainMutable2.getZ() + 2);
                    //X axis
                    if (canReplaceBlock(worldIn, mutable5))
                        worldIn.setBlock(mutable5, config.getXAxisBlockProvider().getState(rand, mutable5), 2);
                    if (worldIn.getBlockState(mutable5.west(4)).isAir())
                        worldIn.setBlock(mutable5.west(4), config.getXAxisBlockProvider().getState(rand, mutable5), 2);

                    //Z axis
                    if (canReplaceBlock(worldIn, mutable6))
                        worldIn.setBlock(mutable6, config.getzAxisBlockProvider().getState(rand, mutable6), 2);
                    if (worldIn.getBlockState(mutable6.north(4)).isAir())
                        worldIn.setBlock(mutable6.north(4), config.getzAxisBlockProvider().getState(rand, mutable6), 2);

                }
                moveDown++;
                mainMutable1.move(Direction.DOWN, 6);
                mainMutable2.move(Direction.DOWN, 6);
            }
            return true;
        }
    }

    public boolean canReplaceBlock(IWorld world, BlockPos pos) {
        return world.getBlockState(pos).getMaterial() != Material.STONE || world.getBlockState(pos).getBlock() != Blocks.BEDROCK;
    }
}