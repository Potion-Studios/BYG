package potionstudios.byg.config.biome;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public class BiomeGenerationWorldProperties {

    private final ResourceKey<Biome> spawnsLike;
    private final int weight;

    public BiomeGenerationWorldProperties(ResourceKey<Biome> spawnsLike, int weight) {
        this.spawnsLike = spawnsLike;
        this.weight = weight;
    }

    public ResourceKey<Biome> getSpawnsLike() {
        return spawnsLike;
    }

    public int getWeight() {
        return weight;
    }
}
