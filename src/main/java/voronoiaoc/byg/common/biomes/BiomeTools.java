package voronoiaoc.byg.common.biomes;

import net.minecraft.world.biome.Biome;

import javax.annotation.Nullable;

public interface BiomeTools {

    @Nullable
    Biome getRiver();

    @Nullable
    Biome getHill();

    @Nullable
    Biome getEdge();

    @Nullable
    Biome getBeach();

    @Nullable
    Biome getMutation();
}
