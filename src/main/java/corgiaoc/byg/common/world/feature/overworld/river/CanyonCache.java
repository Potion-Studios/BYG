package corgiaoc.byg.common.world.feature.overworld.river;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CanyonCache {
    private final Map<MegaChunkPos, MegaChunk> megaChunkPosMegaChunkMap = new HashMap<>();
    private final ChunkGenerator chunkGenerator;
    private final Set<Biome> qualifiedBiomes;

    public CanyonCache(ChunkGenerator chunkGenerator, Set<Biome> qualifiedBiomes) {
        this.chunkGenerator = chunkGenerator;
        this.qualifiedBiomes = qualifiedBiomes;
    }

    public MegaChunk getMegaChunk(MegaChunkPos megaChunkPos) {
        if (megaChunkPosMegaChunkMap.size() > 512) {
            megaChunkPosMegaChunkMap.clear();
        }

        return megaChunkPosMegaChunkMap.computeIfAbsent(megaChunkPos, (megaChunkPos1 -> {
            return new MegaChunk(megaChunkPos1, this.chunkGenerator, this.qualifiedBiomes);
        }));
    }


}
