package corgiaoc.byg.common.world.feature.overworld;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Random;

public abstract class ChunkCoordinatesFeature<FC extends FeatureConfig> extends Feature<FC> {

    public ChunkCoordinatesFeature(Codec<FC> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<FC> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos pos = context.getOrigin();
        Random rand = context.getRandom();
        FC config = context.getConfig();

        ChunkPos chunk = world.getChunk(pos).getPos();
        int xStart = chunk.getStartX();
        int zStart = chunk.getStartZ();
        for (int xMove = 0; xMove < 16; ++xMove) {
            for (int zMove = 0; zMove < 16; ++zMove) {
                int x = xStart + xMove;
                int z = zStart + zMove;
                generate(world, rand, world.getChunk(pos), x, z, config);
            }
        }
        return true;
    }


    public abstract boolean generate(StructureWorldAccess world, Random random, Chunk chunkIn, int x, int z, FC config);
}
