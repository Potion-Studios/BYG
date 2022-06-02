package potionstudios.byg.common.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.util.codec.CollectionCodec;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

public final class LevelBiomeTracker {

    private final Map<ResourceKey<Biome>, Collection<ResourceKey<Level>>> biomeDimensions = new Object2ObjectOpenHashMap<>();

    public LevelBiomeTracker(Map<ResourceKey<Level>, ObjectOpenHashSet<ResourceKey<Biome>>> biomesForLevel) {
        this.biomesForLevel = biomesForLevel;
        biomesForLevel.forEach(((level, biomes) -> {
            for (ResourceKey<Biome> biome : biomes) {
                biomeDimensions.computeIfAbsent(biome, key -> new ObjectOpenHashSet<>()).add(level);
            }
        }));
    }

    public static LevelBiomeTracker client_instance = null;

    public static final Codec<LevelBiomeTracker> CODEC = RecordCodecBuilder.create(builder ->
            builder.group(
                    Codec.unboundedMap(ResourceKey.codec(Registry.DIMENSION_REGISTRY), new CollectionCodec<>(ResourceKey.codec(Registry.BIOME_REGISTRY), ObjectOpenHashSet::new)).fieldOf("biomes_for_level").forGetter(LevelBiomeTracker::biomesForLevel)
            ).apply(builder, LevelBiomeTracker::new));
    private final Map<ResourceKey<Level>, ObjectOpenHashSet<ResourceKey<Biome>>> biomesForLevel;


    public static LevelBiomeTracker fromServer(MinecraftServer server) {
        Object2ObjectOpenHashMap<ResourceKey<Level>, ObjectOpenHashSet<ResourceKey<Biome>>> map = new Object2ObjectOpenHashMap<>();
        for (ServerLevel level : server.getAllLevels()) {
            ObjectOpenHashSet<ResourceKey<Biome>> biomes = map.computeIfAbsent(level.dimension(), key -> new ObjectOpenHashSet<>());

            for (Holder<Biome> possibleBiome : level.getChunkSource().getGenerator().getBiomeSource().possibleBiomes()) {
                biomes.add(possibleBiome.unwrapKey().orElseThrow());
            }
        }
        return new LevelBiomeTracker(map);
    }

    public Map<ResourceKey<Level>, ObjectOpenHashSet<ResourceKey<Biome>>> biomesForLevel() {
        return biomesForLevel;
    }

    public Map<ResourceKey<Biome>, Collection<ResourceKey<Level>>> biomeDimensions() {
        return biomeDimensions;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (LevelBiomeTracker) obj;
        return Objects.equals(this.biomesForLevel, that.biomesForLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(biomesForLevel);
    }

    @Override
    public String toString() {
        return "LevelBiomeTracker[" +
                "biomesForLevel=" + biomesForLevel + ']';
    }

}