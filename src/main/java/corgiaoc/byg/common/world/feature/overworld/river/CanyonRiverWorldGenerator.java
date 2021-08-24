package corgiaoc.byg.common.world.feature.overworld.river;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.NoisyCaveSphereWater;
import corgiaoc.byg.core.world.BYGBiomes;
import corgiaoc.byg.util.noise.fastnoise.FastNoise;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;

import java.util.*;

public class CanyonRiverWorldGenerator extends Feature<NoneFeatureConfiguration> {
    public CanyonRiverWorldGenerator(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    private static final int MAX_RIVER_DISTANCE = 512;
    private static final int MAX_RIVER_DISTANCE_IN_MEGA_CHUNKS = -Math.floorDiv(-MAX_RIVER_DISTANCE, 256);
    private static long seed;


    private final Map<Level, CanyonCache> worldToCanyonPoint = new WeakHashMap<>();

    public static FastNoise noise;

    @Override
    public boolean place(WorldGenLevel worldRegion, ChunkGenerator generator, Random rand, BlockPos pos, NoneFeatureConfiguration config) {
        setupNoise(worldRegion.getSeed());
        NoisyCaveSphereWater.setSeed(worldRegion.getSeed());

        ChunkAccess chunk = worldRegion.getChunk(pos);
        ChunkPos chunkPos = chunk.getPos();

        CanyonCache canyonCache = worldToCanyonPoint.computeIfAbsent(worldRegion.getLevel(), (world) -> {
            return new CanyonCache(worldRegion.getLevel().getChunkSource().getGenerator(), Collections.singleton(worldRegion.registryAccess().registryOrThrow(Registry.BIOME_REGISTRY).get(BYGBiomes.CANYON_KEY)));
        });

        for (int xMegaScan = -MAX_RIVER_DISTANCE_IN_MEGA_CHUNKS; xMegaScan <= MAX_RIVER_DISTANCE_IN_MEGA_CHUNKS; xMegaScan++) {
            for (int zMegaScan = -MAX_RIVER_DISTANCE_IN_MEGA_CHUNKS; zMegaScan <= MAX_RIVER_DISTANCE_IN_MEGA_CHUNKS; zMegaScan++) {
                MegaChunkPos megaChunkPos = MegaChunkPos.fromBlockPos(pos).add(xMegaScan, zMegaScan);

                MegaChunk megaChunk = canyonCache.getMegaChunk(megaChunkPos);
                int count = megaChunk.getCount();
                if (count == 0) {
                    continue;
                }

                RiverGenerator riverGenerator = megaChunk.getRiverGenerator();

                if (riverGenerator == null) {
                    if (!isMegaChunkWithMostCanyonChunks(megaChunk, canyonCache)) {
                        continue;
                    }

                    megaChunk.createRiverGeneratorStart(noise, worldRegion, worldRegion.getSeed(), MAX_RIVER_DISTANCE);
                    riverGenerator = megaChunk.getRiverGenerator();
                }

                if (!riverGenerator.exists()) {
                    continue;
                }

                if (riverGenerator.getNodeChunkPositions().contains(chunkPos)) {
                    generateForChunk(worldRegion, chunkPos, riverGenerator);
                }
            }
        }
        return true;
    }

    private void generateForChunk(WorldGenLevel worldRegion, ChunkPos chunkPos, RiverGenerator riverGenerator) {
        List<RiverGenerator.Node> nodes = riverGenerator.getNodesForChunk(chunkPos);

        for (int idx = 0; idx < nodes.size(); idx++) {
            RiverGenerator.Node node = nodes.get(idx);
            RiverGenerator.Node prevNode = idx == 0 ? riverGenerator.getNodes().get(nodes.get(0).getIdx() - 1) : nodes.get(idx - 1);
            carveRiverNode(worldRegion, node, prevNode, riverGenerator);
        }
    }

    private void carveRiverNode(WorldGenLevel worldRegion, RiverGenerator.Node node, RiverGenerator.Node prevNode, RiverGenerator riverGenerator) {
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().set(node.getPos());
        BlockPos.MutableBlockPos prevMutable = new BlockPos.MutableBlockPos().set(prevNode.getPos());

        int xRadius = 10;
        int yRadius = 10;
        int zRadius = 10;


        int minXRadius = -xRadius;
        int minZRadius = -zRadius;

        int maxXRadius = xRadius;
        int maxZRadius = zRadius;


        int xDiff = mutable.getX() - prevMutable.getX();
        int zDiff = mutable.getZ() - prevMutable.getZ();


        if (xDiff > 0) {
            maxXRadius = maxXRadius + xDiff;
        }

        if (zDiff > 0) {
            maxZRadius = maxZRadius + zDiff;
        }

        if (xDiff < 0) {
            minXRadius = minXRadius + xDiff;
        }

        if (zDiff < 0) {
            minZRadius = minZRadius + zDiff;
        }

        BlockPos.MutableBlockPos mutable2 = new BlockPos.MutableBlockPos().set(mutable);

        int yDiff = prevMutable.getY() - mutable.getY();

        for (int x = minXRadius; x <= maxXRadius; x++) {
            for (int z = minZRadius; z <= maxZRadius; z++) {
                mutable2.set(mutable).move(x, 0, z);
                int height = worldRegion.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, mutable2.getX(), mutable2.getZ());
                mutable2.setY(mutable2.getY() - 3);

                for (int y = -yRadius; y <= 25; y++) {
                    BlockPos pos3 = mutable2.offset(0, y, 0);


                    if (y <= 0) {
                        BlockState state = Blocks.WATER.defaultBlockState();
                        //Credits to Hex_26 for this equation!
                        double equationResult = Math.pow(x, 2) / Math.pow((xRadius), 2) + Math.pow(y, 2) / Math.pow(yRadius, 2) + Math.pow(z, 2) / Math.pow(zRadius, 2);
                        double threshold = 1 + 0.7 * NoisyCaveSphereWater.fastNoise.GetNoise(pos3.getX(), pos3.getY(), pos3.getZ());
                        if (equationResult >= threshold)
                            continue;


                        if (isSolidAllAround(worldRegion, pos3)) {
                            worldRegion.setBlock(pos3, state, 2);
                            if (state.getBlock() == Blocks.WATER) {
                                worldRegion.getLiquidTicks().scheduleTick(pos3, Fluids.WATER, 0);
                            }
                        } else {
                            if (pos3.getY() <= height) {
                                worldRegion.setBlock(pos3, Blocks.STONE.defaultBlockState(), 2);
                            }
                        }
                    } else {
                        double equationResult = Math.pow(x, 2) / Math.pow((xRadius), 2) + Math.pow(z, 2) / Math.pow(zRadius, 2);
                        double threshold = 1 + 0.7 * NoisyCaveSphereWater.fastNoise.GetNoise(pos3.getX(), pos3.getY(), pos3.getZ());
                        if (equationResult >= threshold)
                            continue;
                        BlockState state = Blocks.AIR.defaultBlockState();
                        if (pos3.getY() + 5 > height) {
                            worldRegion.setBlock(pos3, state, 2);
                        }
                    }
                }
            }
        }
    }

    private boolean isSolidAllAround(WorldGenLevel worldRegion, BlockPos pos3) {
        for (Direction direction : Direction.values()) {
            if (direction != Direction.UP) {
                BlockPos relative = pos3.relative(direction);
                BlockState blockState = worldRegion.getBlockState(relative);
                if (blockState.getMaterial() == Material.WATER) {
                    continue;
                }

                if (!blockState.canOcclude()) {
                    return false;
                }
            }
        }
        return true;
    }

    //Find the mega chunk with the highest frequency of Canyon Biome(s)
    public boolean isMegaChunkWithMostCanyonChunks(MegaChunk megaChunk, CanyonCache canyonCache) {
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

    public static void setupNoise(long serverSeed) {
        if (seed != serverSeed || noise == null) {
            seed = serverSeed;
            noise = new FastNoise((int) seed);
            noise.SetNoiseType(FastNoise.NoiseType.PerlinFractal);
            noise.SetGradientPerturbAmp(1);
            noise.SetFractalOctaves(5);
            noise.SetFractalGain(0.5f);
            noise.SetFrequency(0.08F / 5);
        }
    }
}
