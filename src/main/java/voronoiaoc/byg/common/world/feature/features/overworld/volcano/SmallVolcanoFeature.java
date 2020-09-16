package voronoiaoc.byg.common.world.feature.features.overworld.volcano;

import com.mojang.serialization.Codec;
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
import voronoiaoc.byg.common.world.worldtype.noise.fastnoise.FastNoise;
import voronoiaoc.byg.core.byglists.BYGBiomeList;

import java.util.Optional;
import java.util.Random;

public class SmallVolcanoFeature extends Feature<NoFeatureConfig> {
    private final int seedModifier;

    private FastNoise noiseGen = null;

    public void setSeed(long seed) {
        if (noiseGen == null) {
            noiseGen = new FastNoise((int) seed);
            noiseGen.SetNoiseType(FastNoise.NoiseType.Perlin);
            noiseGen.SetGradientPerturbAmp(1);
            noiseGen.SetFractalOctaves(2);
            noiseGen.SetFractalGain(0.3f);
            noiseGen.SetFrequency(0.00375F);
        }
    }


    public SmallVolcanoFeature(Codec<NoFeatureConfig> config, int seedModifier) {
        super(config);
        this.seedModifier = seedModifier;
    }


    @Override
    public boolean func_241855_a(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        setSeed(world.getSeed() + this.seedModifier);
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        boolean foundVolcanoBiome = true;

        for (int x = -32; x <= 32; x++) {
            for (int z = -32; z <= 32; z++) {
                mutable.setPos(pos.getX() + x, world.getSeaLevel(), pos.getZ() + z);
                Optional<RegistryKey<Biome>> key = WorldGenRegistries.field_243657_i.func_230519_c_(BYGBiomeList.VOLCANO);
                if (key.isPresent()) {
                    if (world.func_242406_i(mutable).equals(key)) {
                        foundVolcanoBiome = false;
                    }
                }
            }
        }
        if (foundVolcanoBiome) {
            return false;
        }

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                mutable.setPos(pos.getX() + x, 0, pos.getZ() + z);
                double noise2 = noiseGen.GetNoise(mutable.getX(), mutable.getZ()) * 2;
                int terrainHeight = world.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, mutable.getX(), mutable.getZ());

                int topHeight = (int) (noise2 * 175);
                mutable.move(Direction.UP, topHeight);
                for (int y = topHeight; y >= terrainHeight; y--) {
                    world.setBlockState(mutable, Blocks.STONE.getDefaultState(), 2);
                    mutable.move(Direction.DOWN);
                }
            }
        }
        return true;
    }
}