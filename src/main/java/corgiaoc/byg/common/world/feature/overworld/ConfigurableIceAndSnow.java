package corgiaoc.byg.common.world.feature.overworld;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.Simple2BlockProviderConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;

import java.util.Random;

public class ConfigurableIceAndSnow extends ChunkCoordinatesFeature<Simple2BlockProviderConfig> {
    public ConfigurableIceAndSnow(Codec<Simple2BlockProviderConfig> config) {
        super(config);
    }

    @Override
    public boolean generate(StructureWorldAccess world, Random random, Chunk chunkIn, int x, int z, Simple2BlockProviderConfig config) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        BlockPos.Mutable mutable2 = new BlockPos.Mutable();

        int height = world.getTopY(Heightmap.Type.MOTION_BLOCKING, x, z);
        mutable.set(x, height, z);
        mutable2.set(mutable).move(Direction.DOWN, 1);
        Biome biome = world.getBiome(mutable);
        if (biome.canSetIce(world, mutable2, false)) {
            chunkIn.setBlockState(mutable2, config.getBlockProvider().getBlockState(random, mutable2), false);
        }

        if (biome.canSetSnow(world, mutable)) {
            chunkIn.setBlockState(mutable, config.getBlockProvider2().getBlockState(random, mutable), false);
            BlockState blockstate = world.getBlockState(mutable2);
            if (blockstate.contains(Properties.SNOWY)) {
                if (blockstate.get(Properties.SNOWY) && world.getBlockState(mutable2.offset(Direction.UP)).getBlock() == Blocks.SNOW) {
                    chunkIn.setBlockState(mutable2, blockstate.with(Properties.SNOWY, true), false);
                }
            }
        }

        return true;
    }
}