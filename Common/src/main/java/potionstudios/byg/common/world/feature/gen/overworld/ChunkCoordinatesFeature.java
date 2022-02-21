package potionstudios.byg.common.world.feature.gen.overworld;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

import java.util.Random;

public abstract class ChunkCoordinatesFeature<FC extends FeatureConfiguration> extends Feature<FC> {

    public ChunkCoordinatesFeature(Codec<FC> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<FC> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }

    public boolean place(WorldGenLevel world, ChunkGenerator generator, Random rand, BlockPos pos, FC config) {
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


    public abstract boolean generate(WorldGenLevel world, Random random, ChunkAccess chunkIn, int x, int z, FC config);
}
