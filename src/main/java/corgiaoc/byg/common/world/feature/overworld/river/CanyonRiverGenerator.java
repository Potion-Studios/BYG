package corgiaoc.byg.common.world.feature.overworld.river;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.world.BYGBiomes;
import corgiaoc.byg.mixin.access.BiomeContainerAccess;
import corgiaoc.byg.util.noise.fastnoise.FastNoise;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.MutableRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeContainer;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.WorldGenRegion;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.*;
import java.util.function.Predicate;

import static net.minecraft.world.biome.BiomeContainer.HORIZONTAL_MASK;
import static net.minecraft.world.biome.BiomeContainer.VERTICAL_MASK;

public class CanyonRiverGenerator extends Feature<NoFeatureConfig> {
    public CanyonRiverGenerator(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    private static final int MAX_RIVER_DISTANCE = 512;
    private static final int MAX_RIVER_DISTANCE_IN_MEGA_CHUNKS = -Math.floorDiv(-MAX_RIVER_DISTANCE, 256);
    private static long seed;


    private final Map<World, CanyonCache> worldToCanyonPoint = new WeakHashMap<>();

    public static FastNoise noise;

    @Override
    public boolean generate(ISeedReader worldRegion, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        setupNoise(worldRegion.getSeed());
        CanyonCache canyonCache = worldToCanyonPoint.computeIfAbsent(worldRegion.getWorld(), (world) -> {
            return new CanyonCache(worldRegion.getWorld().getChunkProvider().generator, Collections.singleton(worldRegion.func_241828_r().getRegistry(Registry.BIOME_KEY).getValueForKey(BYGBiomes.CANYON_KEY)));
        });

        for (int xMegaScan = -MAX_RIVER_DISTANCE_IN_MEGA_CHUNKS; xMegaScan <= MAX_RIVER_DISTANCE_IN_MEGA_CHUNKS; xMegaScan++) {
            for (int zMegaScan = -MAX_RIVER_DISTANCE_IN_MEGA_CHUNKS; zMegaScan <= MAX_RIVER_DISTANCE_IN_MEGA_CHUNKS; zMegaScan++) {
                MegaChunkPos megaChunkPos = MegaChunkPos.fromBlockPos(pos).add(xMegaScan, zMegaScan);


                MegaChunk megaChunk = canyonCache.getMegaChunk(megaChunkPos);
                int count = megaChunk.getCount();
                if (count == 0) {
                    continue;
                }
                if (!scanNeighbors(megaChunk, canyonCache)) {
                    continue;
                }

                RiverGenerator riverGenerator = megaChunk.getRiverGenerator();
                if (riverGenerator == null) {
                    megaChunk.createRiverGenerator(noise, worldRegion.getSeed(), MAX_RIVER_DISTANCE);
                    riverGenerator = megaChunk.getRiverGenerator();
                }

                if (!riverGenerator.exists()) {
                    continue;
                }

                List<RiverGenerator.Node> nodes = riverGenerator.getNodes();

                for (RiverGenerator.Node node : nodes) {
                    ChunkPos nodePosAsChunkPos = new ChunkPos(node.getPos());

                    ChunkPos chunk = worldRegion.getChunk(pos).getPos();

                    if (nodePosAsChunkPos.equals(chunk)) {
                        BlockPos.Mutable mutable = new BlockPos.Mutable().setPos(node.getPos());
                        for (int buildY = 0; buildY < 256; buildY++) {
                            mutable.setY(buildY);
                            worldRegion.setBlockState(mutable, Blocks.DIAMOND_BLOCK.getDefaultState(), 2);
                        }
                    }

                }
            }
        }


        return true;
    }


    public boolean scanNeighbors(MegaChunk megaChunk, CanyonCache canyonCache) {
        for (int xNeighborScan = -1; xNeighborScan <= 1; xNeighborScan++) {
            for (int zNeighborScan = -1; zNeighborScan <= 1; zNeighborScan++) {
                if (xNeighborScan == 0 && zNeighborScan == 0) {
                    continue;
                }
                MegaChunkPos neighbor = megaChunk.getMegaChunkPos().add(xNeighborScan, zNeighborScan);

                MegaChunk neighborMegaChunk = canyonCache.getMegaChunk(neighbor);
                if (neighborMegaChunk.getCount() >= megaChunk.getCount()) {
                    return false;
                }
            }
        }
        return true;
    }

    //Set the stream biome for this biome container.
    public static void upgradeBiomeContainer(ChunkPrimer chunkPrimer, BlockPos pos, WorldGenRegion region, ResourceLocation matcher) {
        BiomeContainer biomeContainer = chunkPrimer.getBiomes();
        if (biomeContainer == null) {
            return;
        }

        MutableRegistry<Biome> registry = region.func_241828_r().getRegistry(Registry.BIOME_KEY);

        if (registry.getKey(biomeContainer.getNoiseBiome(pos.getX(), pos.getY(), pos.getZ())) != matcher) {
            int quartX = pos.getX() & HORIZONTAL_MASK;
            int quartY = MathHelper.clamp(pos.getY(), 0, VERTICAL_MASK);
            int quartZ = pos.getZ() & HORIZONTAL_MASK;
            ((BiomeContainerAccess) biomeContainer).getBiomes()[quartY << BiomeContainerAccess.getWIDTH_BITS() + BiomeContainerAccess.getWIDTH_BITS() | quartZ << BiomeContainerAccess.getWIDTH_BITS() | quartX] = registry.getOptional(matcher).get();
        }
    }

    public BlockPos findBiomePositionForDirection(int x, int y, int z, int radius, int increment, Predicate<Biome> biomes, Random rand, boolean findClosest, BiomeProvider source, Direction direction) {
        int quartX = x >> 2;
        int quartZ = z >> 2;
        int quartRadius = radius >> 2;
        int quartY = y >> 2;
        BlockPos blockpos = null;
        int iterations = 0;
        int quartRadiusRange = findClosest ? 0 : quartRadius;

        for (int currentQuartRadius = quartRadiusRange; currentQuartRadius <= quartRadius; currentQuartRadius += increment) {
            for (int offsetForRadius = 0; offsetForRadius <= currentQuartRadius; offsetForRadius += increment) {
                if (findClosest) {
                    boolean flag1 = Math.abs(offsetForRadius) == currentQuartRadius;
                    if (!flag1) {
                        continue;
                    }
                }
                int offset;
                switch (direction) {
                    case NORTH:
                        offset = quartZ + offsetForRadius;
                        if (biomes.test(source.getNoiseBiome(quartX, quartY, offset))) {
                            if (blockpos == null || rand.nextInt(iterations + 1) == 0) {
                                blockpos = new BlockPos(quartX << 2, y, offset << 2);
                                if (findClosest) {
                                    return blockpos;
                                }
                            }

                        }
                        break;
                    case SOUTH:
                        offset = quartZ - offsetForRadius;
                        if (biomes.test(source.getNoiseBiome(quartX, quartY, offset))) {
                            if (blockpos == null || rand.nextInt(iterations + 1) == 0) {
                                blockpos = new BlockPos(offset << 2, y, offset << 2);
                                if (findClosest) {
                                    return blockpos;
                                }
                            }

                        }
                        break;
                    case EAST:
                        offset = quartX + offsetForRadius;
                        if (biomes.test(source.getNoiseBiome(offset, quartY, quartZ))) {
                            if (blockpos == null || rand.nextInt(iterations + 1) == 0) {
                                blockpos = new BlockPos(offset << 2, y, quartZ << 2);
                                if (findClosest) {
                                    return blockpos;
                                }
                            }

                        }
                        break;
                    case WEST:
                        offset = quartX - offsetForRadius;
                        if (biomes.test(source.getNoiseBiome(offset, quartY, quartZ))) {
                            if (blockpos == null || rand.nextInt(iterations + 1) == 0) {
                                blockpos = new BlockPos(offset << 2, y, quartZ << 2);
                                if (findClosest) {
                                    return blockpos;
                                }
                            }

                        }
                        break;
                }
                ++iterations;
            }
        }

        return blockpos;
    }

    public static void setupNoise(long serverSeed) {
        if (seed != serverSeed || noise == null) {
            seed = serverSeed;
            noise = new FastNoise((int) seed);
            noise.SetNoiseType(FastNoise.NoiseType.PerlinFractal);
            noise.SetGradientPerturbAmp(1);
            noise.SetFractalOctaves(5);
            noise.SetFractalGain(0.3f);
            noise.SetFrequency(0.0002F);
        }
    }
}
