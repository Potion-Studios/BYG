package corgiaoc.byg.common.world.surfacebuilder;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import java.util.Random;

public class RockyBeachSB extends SurfaceBuilder<TernarySurfaceConfig> {
    public RockyBeachSB(Codec<TernarySurfaceConfig> p_i51312_1_) {
        super(p_i51312_1_);
    }

    @Override
    public void generate(Random random, Chunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, int i, long seed, TernarySurfaceConfig config) {
        if (noise > 1.75D && noise < 1.95D) {
            SurfaceBuilder.DEFAULT.generate(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, i, seed, BYGSurfaceBuilders.Configs.STONE);
        } else if (noise > -0.95D && noise < - -0.75) {
            SurfaceBuilder.DEFAULT.generate(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, i, seed, BYGSurfaceBuilders.Configs.STONE);
        } else if (noise > -2.0D && noise < -1.8D) {
            SurfaceBuilder.DEFAULT.generate(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, i, seed, BYGSurfaceBuilders.Configs.ROCKY);
        } else if (noise > -2.0D && noise < -2.2D) {
            SurfaceBuilder.DEFAULT.generate(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, i, seed, BYGSurfaceBuilders.Configs.SAND);
        } else if (noise > -2.5D && noise < -2.3D) {
            SurfaceBuilder.DEFAULT.generate(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, i, seed, BYGSurfaceBuilders.Configs.STONE);
        } else if (noise > 2.3D && noise < 3.0D) {
            SurfaceBuilder.DEFAULT.generate(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, i, seed, BYGSurfaceBuilders.Configs.ROCKY);
        } else {
            SurfaceBuilder.DEFAULT.generate(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, i, seed, BYGSurfaceBuilders.Configs.ROCKY);
        }
    }
}