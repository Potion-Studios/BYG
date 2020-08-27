package voronoiaoc.byg.common.world.surfacebuilders;

import com.mojang.serialization.Codec;
import voronoiaoc.byg.core.byglists.BYGSBList;

import java.util.Random;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

public class MojaveSB extends SurfaceBuilder<SurfaceBuilderBaseConfiguration> {
    public MojaveSB(Codec<SurfaceBuilderBaseConfiguration> config) {
        super(config);
    }

    public void apply(Random random, ChunkAccess chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderBaseConfiguration config) {
        int randomizer = random.nextInt(5);

        if (randomizer <= 2)
            SurfaceBuilder.DEFAULT.apply
                    (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.SAND);
        if (randomizer == 3)
            SurfaceBuilder.DEFAULT.apply
                    (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.COARSE);
        if (randomizer == 4)
            SurfaceBuilder.DEFAULT.apply
                    (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, SurfaceBuilder.CONFIG_GRASS);
    }
}