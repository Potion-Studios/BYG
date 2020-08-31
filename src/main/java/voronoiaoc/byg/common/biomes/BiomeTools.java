package voronoiaoc.byg.common.biomes;

import java.util.HashMap;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

public interface BiomeTools {

    default Biome getRiver() {
        return BuiltinRegistries.BIOME.get(Biomes.RIVER);
    }

    default HashMap<Biome, Integer> getHills() {
        return new HashMap<>();
    }

    default HashMap<Biome, Integer> getEdges() {
        return new HashMap<>();
    }

    default HashMap<Biome, Integer> getBeaches() {
        return new HashMap<>();
    }

    default HashMap<Biome, Integer> getMutations() {
        return new HashMap<>();
    }
}
