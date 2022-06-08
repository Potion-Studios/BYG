package potionstudios.byg.util;

import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.PositionalRandomFactory;

public interface SeedGetter {
    PositionalRandomFactory getRandom();
}
