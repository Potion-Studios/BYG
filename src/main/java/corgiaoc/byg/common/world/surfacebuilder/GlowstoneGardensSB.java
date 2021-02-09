package corgiaoc.byg.common.world.surfacebuilder;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import java.util.Random;

public class GlowstoneGardensSB extends SurfaceBuilder<TernarySurfaceConfig> {
    public GlowstoneGardensSB(Codec<TernarySurfaceConfig> config) {
        super(config);
    }

    public void generate(Random random, Chunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, TernarySurfaceConfig config) {
        int randomizer = random.nextInt(5);

        if (randomizer <= 1)
            SurfaceBuilder.DEFAULT.generate(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSurfaceBuilders.Configs.WARPED_NYLIUM);
        if (randomizer <= 2)
            SurfaceBuilder.DEFAULT.generate(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSurfaceBuilders.Configs.MYCELIUM_NETHERRACK);
        if (randomizer == 3)
            SurfaceBuilder.DEFAULT.generate(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSurfaceBuilders.Configs.GLOWSTONE_GARDENS);
        if (randomizer == 4)
            SurfaceBuilder.DEFAULT.generate(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSurfaceBuilders.Configs.GLOWSTONE_GARDENS);
    }
}