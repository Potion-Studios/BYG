package potionstudios.byg.common.world.biome;

import net.minecraft.core.Registry;
import net.minecraft.world.level.biome.Biome;

public interface LazyLoadSeed {

    void lazyLoad(long seed, Registry<Biome> biomeRegistry);
}
