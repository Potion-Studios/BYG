package voronoiaoc.byg.common.biomes;

import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BuiltInBiomes;

import java.util.HashMap;

public interface BiomeTools {

    default Biome getRiver() {
        return BuiltinRegistries.BIOME.get(BuiltInBiomes.RIVER);
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
