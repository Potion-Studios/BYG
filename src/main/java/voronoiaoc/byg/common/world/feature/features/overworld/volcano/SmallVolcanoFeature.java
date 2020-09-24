package voronoiaoc.byg.common.world.feature.features.overworld.volcano;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import voronoiaoc.byg.common.world.worldtype.noise.fastnoise.FastNoise;

import java.util.Random;

public class SmallVolcanoFeature extends Feature<NoFeatureConfig> {
    private final int seedModifier;

    private FastNoise noiseGen = null;
    private FastNoise noiseGen2 = null;

    public void setSeed(long seed) {
        if (noiseGen == null) {
            noiseGen = new FastNoise((int) seed);
            noiseGen.SetFractalType(FastNoise.FractalType.RigidMulti);
            noiseGen.SetNoiseType(FastNoise.NoiseType.SimplexFractal);
            noiseGen.SetFractalOctaves(1);
            noiseGen.SetFractalGain(0.1f);
            noiseGen.SetFrequency(0.004f);
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

//        boolean foundVolcanoBiome = true;
//
//        for (int x = -32; x <= 32; x++) {
//            for (int z = -32; z <= 32; z++) {
//                mutable.setPos(pos.getX() + x, world.getSeaLevel(), pos.getZ() + z);
//                Optional<RegistryKey<Biome>> key = WorldGenRegistries.BIOME.getOptionalKey(BYGBiomeList.VOLCANO);
//                if (key.isPresent()) {
//                    if (world.func_242406_i(mutable).equals(key)) {
//                        foundVolcanoBiome = false;
//                    }
//                }
//            }
//        }

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                mutable.setPos(pos.getX() + x, 0, pos.getZ() + z);
                double noise = noiseGen.GetNoise(mutable.getX(), mutable.getZ()) * 2;
                int terrainHeight = world.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, mutable.getX(), mutable.getZ());

                if (noise <= 0.46) {
                    int topHeight = (int) (Math.abs((int) (noise * 11D) * 1.4) + terrainHeight);
                    mutable.move(Direction.UP, topHeight);
                    for (int y = topHeight; y >= terrainHeight; y--) {
                        world.setBlockState(mutable, Blocks.DIAMOND_BLOCK.getDefaultState(), 2);
                        mutable.move(Direction.DOWN);
                    }
                }

                else if (noise <= 0.63) {
                    int valueToReverse = (int) (Math.abs((int) (noise * 55D) * 1.4));
                    int topHeight = (int) ((valueToReverse - Math.abs(((-noise * 55D) * 1.4 - valueToReverse))) + (terrainHeight * 1.8));

                    System.out.println(topHeight);
                    mutable.move(Direction.UP, topHeight);
                    for (int y = topHeight; y >= terrainHeight; y--) {
                        world.setBlockState(mutable, Blocks.REDSTONE_BLOCK.getDefaultState(), 2);
                        mutable.move(Direction.DOWN);
                    }
                }
            }
        }
        return true;
    }
}