package potionstudios.byg.common.world.feature.gen.overworld;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import potionstudios.byg.common.world.feature.config.PointyRockConfig;
import potionstudios.byg.common.world.math.noise.simplex.OpenSimplex2;

import java.util.Random;

public class PointyRockFeature extends Feature<PointyRockConfig> {

    private static final int RADIUS = 8;
    private static final int BASE_HEIGHT_MULTIPLER = 96;
    private static final double NOISE_FREQUENCY_1 = 0.013;
    private static final double NOISE_FREQUENCY_2 = NOISE_FREQUENCY_1 * 2;
    
    // For the two octaves of the ridged noise.
    private static final double NOISE_RANGE = 1.0 + 0.5;
    
    // Noise height multiplier, counteracting both the ridged max range and the falloff curve max value.
    private static final double EFFECTIVE_HEIGHT_MULTIPLIER = BASE_HEIGHT_MULTIPLER * 1.0 / (RADIUS*RADIUS*RADIUS*RADIUS * NOISE_RANGE);

    // By starting the noise in the center of a triangle for each spike, we improve the variety in patterns.
    private static final double NOISE_OFFSET_X = 0.45534180126147955;
    private static final double NOISE_OFFSET_Y = 0.12200846792814621;
    
    public PointyRockFeature(Codec<PointyRockConfig> config) {
        super(config);
    }

    @Override
    public boolean place(FeaturePlaceContext<PointyRockConfig> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }

    public boolean place(WorldGenLevel world, ChunkGenerator changedBlock, Random rand, BlockPos position, PointyRockConfig config) {
        long seed1 = rand.nextLong();
        long seed2 = rand.nextLong();

        int baseX = position.getX();
        int baseZ = position.getZ();
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        BlockPos.MutableBlockPos top = new BlockPos.MutableBlockPos();

        double effectiveConfiguredHeightMultiplier = config.getHeightMultiplier() * EFFECTIVE_HEIGHT_MULTIPLIER;
        for (int z = 1-RADIUS; z < RADIUS; z++) {
            int worldZ = z + baseZ;
            for (int x = 1-RADIUS; x < RADIUS; x++) {
                int worldX = x + baseX;
                
                // Skip if we're not inside the radius
                int distSq = z*z + x*x;
                if (distSq >= RADIUS*RADIUS) continue;
                
                // Compute the falloff curve. Use a quartic curve to use a lot of the radius effectively before dropping off sharply.
                // Plug 1-xx and 1-xxxx into https://www.desmos.com/calculator to compare.
                double falloff = RADIUS*RADIUS*RADIUS*RADIUS - distSq*distSq;

                // Ridged noise
                double noise = NOISE_RANGE
                        - Math.abs(OpenSimplex2.noise2(seed1, x * NOISE_FREQUENCY_1 + NOISE_OFFSET_X, z * NOISE_FREQUENCY_1 + NOISE_OFFSET_Y))// * 1.0
                        - Math.abs(OpenSimplex2.noise2(seed2, x * NOISE_FREQUENCY_2 + NOISE_OFFSET_X, z * NOISE_FREQUENCY_2 + NOISE_OFFSET_Y)) * 0.5;
                
                // Multiply the noise by the falloff curve and the multiplier to get the final height
                noise *= falloff;
                noise *= effectiveConfiguredHeightMultiplier;

                // Determine range to place blocks
                int maximumHeight = (int)noise;
                int terrainHeight = world.getHeight(Heightmap.Types.OCEAN_FLOOR, worldX, worldZ);
                
                // If there are any blocks to place this column...
                if (maximumHeight > terrainHeight) {
                    mutable.set(worldX, maximumHeight, worldZ);
                    
                    // Place them all.
                    for (int y = maximumHeight; y >= terrainHeight; y--) {
                        mutable.setY(y);
                        if (mutable.getY() > top.getY()) {
                            top.set(mutable);
                        }
                        world.setBlock(mutable, config.getBlockProvider().getState(rand, mutable), 2);
                    }
                }
            }
        }
        if (!top.equals(BlockPos.ZERO)) {
            for (Holder<PlacedFeature> placedFeatureHolder : config.getPlacedFeatureHolderSet()) {
                placedFeatureHolder.value().place(world, world.getLevel().getChunkSource().getGenerator(), rand, top);
            }
        }


        return true;
    }
}