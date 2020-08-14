package voronoiaoc.byg.common.biomes;

import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;

import javax.annotation.Nullable;
import java.util.HashMap;

public interface BiomeTools {

    default Biome getRiver() {
        return WorldGenRegistries.field_243657_i.func_243576_d(Biomes.RIVER);
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

    @Nullable
    default Biome getHill(INoiseRandom random) {
        return null;
    }

}