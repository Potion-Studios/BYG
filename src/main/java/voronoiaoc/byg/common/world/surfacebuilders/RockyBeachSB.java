package voronoiaoc.byg.common.world.surfacebuilders;

import com.mojang.serialization.Codec;
import voronoiaoc.byg.core.byglists.BYGSBList;

import java.util.Random;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

public class RockyBeachSB extends SurfaceBuilder<SurfaceBuilderBaseConfiguration> {
    public RockyBeachSB(Codec<SurfaceBuilderBaseConfiguration> p_i51312_1_) {
        super(p_i51312_1_);
    }

    public void apply(Random random, ChunkAccess chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderBaseConfiguration config) {
        if (noise > 1.75D && noise < 1.95D) {
            SurfaceBuilder.DEFAULT.apply
                    (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.STONE);
        } else if (noise > -0.95D && noise < - -0.75) {
            SurfaceBuilder.DEFAULT.apply
                    (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.STONE);
        } else if (noise > -2.0D && noise < -1.8D) {
            SurfaceBuilder.DEFAULT.apply
                    (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.ROCKY);
        } else if (noise > -2.0D && noise < -2.2D) {
            SurfaceBuilder.DEFAULT.apply
                    (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.SAND);
        } else if (noise > -2.5D && noise < -2.3D) {
            SurfaceBuilder.DEFAULT.apply
                    (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.STONE);
        } else if (noise > 2.3D && noise < 3.0D) {
            SurfaceBuilder.DEFAULT.apply
                    (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.ROCKY);
        } else {
            SurfaceBuilder.DEFAULT.apply
                    (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.ROCKY);
        }
    }
}