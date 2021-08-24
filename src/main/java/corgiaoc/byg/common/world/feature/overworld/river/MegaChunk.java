package corgiaoc.byg.common.world.feature.overworld.river;

import corgiaoc.byg.util.noise.fastnoise.FastNoise;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldgenRandom;

import java.io.ByteArrayOutputStream;
import java.util.Set;

public class MegaChunk {
    private final MegaChunkPos megaChunkPos;
    private final BiomeSource provider;
    private final ChunkGenerator chunkGenerator;
    private final Set<Biome> allowedBiomes;
    private final byte[] canyonChunks;
    private RiverGenerator riverGenerator;

    public MegaChunk(MegaChunkPos megaChunkPos, ChunkGenerator chunkGenerator, Set<Biome> allowedBiomes) {
        this.megaChunkPos = megaChunkPos;
        this.chunkGenerator = chunkGenerator;
        this.provider = chunkGenerator.getBiomeSource();
        this.allowedBiomes = allowedBiomes;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                ChunkPos chunkPos = megaChunkPos.toChunkPos(x, z);
                Biome noiseBiome = chunkGenerator.getBiomeSource().getNoiseBiome((chunkPos.x << 2) + 2, 0, (chunkPos.z << 2) + 2);

                if (allowedBiomes.contains(noiseBiome)) {
                    byteArrayOutputStream.write(MegaChunkPos.packLocalPos(x, z));
                }

            }
        }
        this.canyonChunks = byteArrayOutputStream.toByteArray();
    }

    public int getCount() {
        return canyonChunks.length;
    }

    public MegaChunkPos getMegaChunkPos() {
        return megaChunkPos;
    }

    public RiverGenerator getRiverGenerator() {
        return riverGenerator;
    }

    public void createRiverGeneratorStart(FastNoise noise, WorldGenLevel world, long worldSeed, int maxRiverDistance) {
        WorldgenRandom seedRandom = new WorldgenRandom(worldSeed);

        seedRandom.setFeatureSeed(934893458905904595L, megaChunkPos.getX(), megaChunkPos.getZ());

        byte canyonChunkByte = canyonChunks[seedRandom.nextInt(canyonChunks.length)];

        BlockPos startPos = this.megaChunkPos.unpackLocalPos(canyonChunkByte).getWorldPosition();

        this.riverGenerator = new RiverGenerator(noise, world, new BlockPos(startPos.getX(), this.chunkGenerator.getFirstFreeHeight(startPos.getX(), startPos.getZ(), Heightmap.Types.OCEAN_FLOOR_WG) /*218*/, startPos.getZ()), this.chunkGenerator, blockpos -> false, blockpos -> {
            Biome.BiomeCategory category = this.provider.getNoiseBiome(blockpos.getX() >> 2, blockpos.getY() >> 2, blockpos.getZ() >> 2).getBiomeCategory();
            return category == Biome.BiomeCategory.RIVER || category == Biome.BiomeCategory.OCEAN || this.chunkGenerator.getBaseHeight(blockpos.getX(), blockpos.getZ(), Heightmap.Types.OCEAN_FLOOR_WG) <= this.chunkGenerator.getSeaLevel();
        }, maxRiverDistance);
    }

    public void createRiverGenerator(FastNoise noise, BlockPos generatorStartPos, WorldGenLevel world, int maxRiverDistance) {
        this.riverGenerator = new RiverGenerator(noise, world, new BlockPos(generatorStartPos.getX(), 218, generatorStartPos.getZ()), this.chunkGenerator, blockpos -> false, blockpos -> {
            Biome.BiomeCategory category = this.provider.getNoiseBiome(blockpos.getX() >> 2, blockpos.getY() >> 2, blockpos.getZ() >> 2).getBiomeCategory();
            return category == Biome.BiomeCategory.RIVER || category == Biome.BiomeCategory.OCEAN || this.chunkGenerator.getBaseHeight(blockpos.getX(), blockpos.getZ(), Heightmap.Types.OCEAN_FLOOR_WG) <= this.chunkGenerator.getSeaLevel();
        }, maxRiverDistance);
    }
}
