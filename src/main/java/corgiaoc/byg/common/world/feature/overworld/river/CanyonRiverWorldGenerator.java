package corgiaoc.byg.common.world.feature.overworld.river;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.NoisyCaveSphereWater;
import corgiaoc.byg.core.world.BYGBiomes;
import corgiaoc.byg.util.noise.fastnoise.FastNoise;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.*;

public class CanyonRiverWorldGenerator extends Feature<NoFeatureConfig> {
    public CanyonRiverWorldGenerator(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    private static final int MAX_RIVER_DISTANCE = 512;
    private static final int MAX_RIVER_DISTANCE_IN_MEGA_CHUNKS = -Math.floorDiv(-MAX_RIVER_DISTANCE, 256);
    private static long seed;


    private final Map<World, CanyonCache> worldToCanyonPoint = new WeakHashMap<>();

    public static FastNoise noise;

    @Override
    public boolean place(ISeedReader worldRegion, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        setupNoise(worldRegion.getSeed());
        NoisyCaveSphereWater.setSeed(worldRegion.getSeed());

        IChunk chunk = worldRegion.getChunk(pos);
        ChunkPos chunkPos = chunk.getPos();

        CanyonCache canyonCache = worldToCanyonPoint.computeIfAbsent(worldRegion.getLevel(), (world) -> {
            return new CanyonCache(worldRegion.getLevel().getChunkSource().generator, Collections.singleton(worldRegion.registryAccess().registryOrThrow(Registry.BIOME_REGISTRY).get(BYGBiomes.CANYON_KEY)));
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

    private void generateForChunk(ISeedReader worldRegion, ChunkPos chunkPos, RiverGenerator riverGenerator) {
        List<RiverGenerator.Node> nodes = riverGenerator.getNodesForChunk(chunkPos);

        for (int idx = 0; idx < nodes.size(); idx++) {
            RiverGenerator.Node node = nodes.get(idx);
            RiverGenerator.Node prevNode = idx == 0 ? riverGenerator.getNodes().get(nodes.get(0).getIdx() - 1) : nodes.get(idx - 1);
            carveRiverNode(worldRegion, node, prevNode, riverGenerator);
        }
    }

    private void carveRiverNode(ISeedReader worldRegion, RiverGenerator.Node node, RiverGenerator.Node prevNode, RiverGenerator riverGenerator) {
        BlockPos.Mutable mutable = new BlockPos.Mutable().set(node.getPos());
        BlockPos.Mutable prevMutable = new BlockPos.Mutable().set(prevNode.getPos());

//        if (node.getIdx() >= (riverGenerator.getTotalNumberOfNodes() - 4)) {
//            double slide = mutable.getY() / ((float) + riverGenerator.getFinalPosition().getY());
//            mutable.setY((int) MathHelper.clampedLerp(riverGenerator.getFinalPosition().getY(), prevMutable.getY(), slide));
//        }



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

        BlockPos.Mutable mutable2 = new BlockPos.Mutable().set(mutable);

        int yDiff = prevMutable.getY() - mutable.getY();

        for (int x = minXRadius; x <= maxXRadius; x++) {
            for (int z = minZRadius; z <= maxZRadius; z++) {
                mutable2.set(mutable).move(x, -yRadius, z);


                //Check if the bottom of the sphere will be hanging over air, if so continue, don't waste time filling the remainder of the sphere!
                int height = worldRegion.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, mutable2.getX(), mutable2.getZ());
                if (height <= mutable2.getY()) {
                    continue;
                }

                if (yDiff >= 10) {
                    if (height >= mutable2.getY()) {
                        continue;
                    }
                }

                for (int y = -yRadius; y <= yRadius; y++) {
                    mutable2.set(mutable).move(x, y, z);

                    //Credits to Hex_26 for this equation!
                    double equationResult = Math.pow(x, 2) / Math.pow((xRadius), 2) + Math.pow(y, 2) / Math.pow(yRadius, 2) + Math.pow(z, 2) / Math.pow(zRadius, 2);
                    double threshold = 1 + 0.7 * NoisyCaveSphereWater.fastNoise.GetNoise(mutable2.getX(), mutable2.getY(), mutable2.getZ());
                    if (equationResult >= threshold)
                        continue;

                    int sphereWaterY = -2;

                    if (node.getIdx() >= (riverGenerator.getTotalNumberOfNodes() - 4)) {

                    }

                    if (y <= sphereWaterY) {
                        worldRegion.setBlock(mutable2, Blocks.WATER.defaultBlockState(), 2);
                        worldRegion.getLiquidTicks().scheduleTick(mutable2, Fluids.WATER, 0);
                    } else {
                        worldRegion.setBlock(mutable2, Blocks.AIR.defaultBlockState(), 2);
                    }
                }
            }
        }
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
