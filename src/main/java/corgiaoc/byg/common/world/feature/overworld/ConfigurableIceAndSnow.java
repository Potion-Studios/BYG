package corgiaoc.byg.common.world.feature.overworld;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.Simple2BlockProviderConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.Heightmap;

import java.util.Random;

public class ConfigurableIceAndSnow extends ChunkCoordinatesFeature<Simple2BlockProviderConfig> {
    public ConfigurableIceAndSnow(Codec<Simple2BlockProviderConfig> config) {
        super(config);
    }

    @Override
    public boolean generate(ISeedReader world, Random random, IChunk chunkIn, int x, int z, Simple2BlockProviderConfig config) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        BlockPos.Mutable mutable2 = new BlockPos.Mutable();

        int height = world.getHeight(Heightmap.Type.MOTION_BLOCKING, x, z);
        mutable.set(x, height, z);
        mutable2.set(mutable).move(Direction.DOWN, 1);
        Biome biome = world.getBiome(mutable);
        if (biome.shouldFreeze(world, mutable2, false)) {
            chunkIn.setBlockState(mutable2, config.getBlockProvider().getState(random, mutable2), false);
        }

        if (biome.shouldSnow(world, mutable)) {
            chunkIn.setBlockState(mutable, config.getBlockProvider2().getState(random, mutable), false);
            BlockState blockstate = world.getBlockState(mutable2);
            if (blockstate.hasProperty(BlockStateProperties.SNOWY)) {
                if (blockstate.getValue(BlockStateProperties.SNOWY) && world.getBlockState(mutable2.relative(Direction.UP)).getBlock() == Blocks.SNOW) {
                    chunkIn.setBlockState(mutable2, blockstate.setValue(BlockStateProperties.SNOWY, true), false);
                }
            }
        }

        return true;
    }
}