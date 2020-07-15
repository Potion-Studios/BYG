package voronoiaoc.byg.common.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

import javax.annotation.Nullable;
import java.util.HashMap;

public interface BiomeTools {

    default Biome getRiver() {
        return Biomes.RIVER;
    }

    default HashMap<Biome,Integer> getHills() {
        return new HashMap<>();
    }

    default HashMap<Biome,Integer> getEdges() {
        return new HashMap<>();
    }

    default HashMap<Biome,Integer> getBeaches() {
        return new HashMap<>();
    }

    default HashMap<Biome,Integer> getMutations() {
        return new HashMap<>();
    }
}
