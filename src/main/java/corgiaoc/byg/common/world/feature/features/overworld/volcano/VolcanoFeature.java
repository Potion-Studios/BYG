package corgiaoc.byg.common.world.feature.features.overworld.volcano;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import corgiaoc.byg.util.noise.simplex.chunkgen.ChunkFastSimplexStyleNoise;
import corgiaoc.byg.core.world.BYGBiomes;

import java.util.Optional;
import java.util.Random;


public class VolcanoFeature extends Feature<NoFeatureConfig> {
    protected long seed;
    protected ChunkFastSimplexStyleNoise noiseGen;
    protected ChunkFastSimplexStyleNoise noiseGen2;
    private static final BlockState PODZOL = Blocks.PODZOL.getDefaultState();
    private static final BlockState POWDER = Blocks.LIGHT_GRAY_CONCRETE_POWDER.getDefaultState();
    private static final BlockState SNOW = Blocks.SNOW_BLOCK.getDefaultState();
    private static final BlockState DARK_POWDER = Blocks.GRAY_CONCRETE_POWDER.getDefaultState();
    private static final BlockState BLACK_POWDER = Blocks.BLACK_CONCRETE_POWDER.getDefaultState();
    private static final BlockState MAGMA_BLOCK = Blocks.MAGMA_BLOCK.getDefaultState();
    private static final BlockState LAVA = Blocks.LAVA.getDefaultState();
    private static final BlockState STONE = Blocks.BLACKSTONE.getDefaultState();
    private static final BlockState SAND = Blocks.SAND.getDefaultState();
    private static final BlockState GRAVEL = Blocks.GRAVEL.getDefaultState();

    private final int seedModifier;

    public void setSeed(long seed) {
        if (this.seed != seed || this.noiseGen == null) {
            this.noiseGen = new ChunkFastSimplexStyleNoise(seed);
            this.seed = seed;
        }

        if (this.noiseGen2 == null) {
            this.noiseGen2 = new ChunkFastSimplexStyleNoise(seed + 385858686);
            this.seed = seed;
        }
    }


    public VolcanoFeature(Codec<NoFeatureConfig> config, int seedModifier) {
        super(config);
        this.seedModifier = seedModifier;
    }


    @Override
    public boolean func_241855_a(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos position, NoFeatureConfig config) {
        setSeed(world.getSeed() + this.seedModifier);
        double noise;
        double noise2;
        int maximumHeight;
        int terrainHeight;
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        double noise3;
        boolean foundVolcanoBiome = true;

        for (int x = -32; x <= 32; x++) {
            for (int z = -32; z <= 32; z++) {
                mutable.setPos(position.getX() + x, world.getSeaLevel(), position.getZ() + z);
                Optional<RegistryKey<Biome>> key = WorldGenRegistries.BIOME.getOptionalKey(BYGBiomes.VOLCANO);
                if (key.isPresent()) {
                    if (world.func_242406_i(mutable).equals(key)) {
                        foundVolcanoBiome = false;
                    }
                }
            }
        }

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                boolean topBlock = true;
                boolean insideCone = false;
                mutable.setPos(position.getX() + x, 0, position.getZ() + z);
                noise2 = (noiseGen.noise3_Classic(mutable.getX() * 0.04D, mutable.getY() * 0.04D, mutable.getZ() * 0.04D) + 1D) * 5D;
                noise = Math.pow(Math.abs(noiseGen.sample2D(mutable.getX() * 0.003D, mutable.getZ() * 0.003D)) + noise2 * 0.005D, 150);
                maximumHeight = (int) (noise * 700D);
                terrainHeight = world.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, mutable.getX(), mutable.getZ());
                if (maximumHeight > 140 + noise2) {
                    maximumHeight = (int) Math.max((maximumHeight - (maximumHeight - 140 - noise2) * 1.1), terrainHeight);
                    insideCone = true;
                }

                mutable.move(Direction.UP, maximumHeight);
                for (int y = maximumHeight; y >= terrainHeight; y--) {
                    noise2 = (noiseGen.noise3_Classic(mutable.getX() * 0.045D, y * 0.04D, mutable.getZ() * 0.045D) + 1D) * 10;


                    if (topBlock) {
                        if (insideCone) {
                            if (y < 125) {
                                world.setBlockState(mutable, MAGMA_BLOCK, 2);
                            } else {
                                world.setBlockState(mutable, DARK_POWDER, 2);
                            }
                        }
                        topBlock = false;
                    }

                    mutable.move(Direction.DOWN);
                }
            }
        }

        return true;
    }
}
