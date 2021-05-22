package corgiaoc.byg.common.world.feature.overworld;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;

import java.util.Random;

public abstract class ChunkCoordinatesFeature<FC extends IFeatureConfig> extends Feature<FC> {

    public ChunkCoordinatesFeature(Codec<FC> codec) {
        super(codec);
    }

    @Override
    public boolean place(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, FC config) {
        ChunkPos chunk = world.getChunk(pos).getPos();
        int xStart = chunk.getMinBlockX();
        int zStart = chunk.getMinBlockZ();
        for(int xMove = 0; xMove < 16; ++xMove) {
            for (int zMove = 0; zMove < 16; ++zMove) {
                int x = xStart + xMove;
                int z = zStart + zMove;
                generate(world, rand, world.getChunk(pos), x, z, config);
            }
        }
        return true;
    }


    public abstract boolean generate(ISeedReader world, Random random, IChunk chunkIn, int x, int z, FC config);
}
