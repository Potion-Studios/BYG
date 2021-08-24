package corgiaoc.byg.common.world.feature.overworld;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.Simple2BlockProviderConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Heightmap;

import java.util.Random;

public class ConfigurableIceAndSnow extends ChunkCoordinatesFeature<Simple2BlockProviderConfig> {
    public ConfigurableIceAndSnow(Codec<Simple2BlockProviderConfig> config) {
        super(config);
    }

    @Override
    public boolean generate(WorldGenLevel world, Random random, ChunkAccess chunkIn, int x, int z, Simple2BlockProviderConfig config) {
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        BlockPos.MutableBlockPos mutable2 = new BlockPos.MutableBlockPos();

        int height = world.getHeight(Heightmap.Types.MOTION_BLOCKING, x, z);
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