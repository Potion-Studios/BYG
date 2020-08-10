package voronoiaoc.byg.common.world.feature.features.overworld.deadsea;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.Heightmap;
import net.minecraft.world.ModifiableWorld;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import voronoiaoc.byg.common.noise.simplex.chunkgen.ChunkFastSimplexStyleNoise;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class DeadSeaSpikes extends Feature<DefaultFeatureConfig> {
    public static boolean doBlockNotify;
    static Random random = new Random();
    protected long seed;
    protected ChunkFastSimplexStyleNoise noiseGen;
    protected ChunkFastSimplexStyleNoise noiseGen2;
    static BlockState[] blockStateArray = {BYGBlockList.ROCKY_STONE.getDefaultState(), Blocks.COBBLESTONE.getDefaultState(), Blocks.STONE.getDefaultState()};

    public DeadSeaSpikes(Codec<DefaultFeatureConfig> config) {
        super(config);
    }


    public void setSeed(long seed) {
        if (this.seed != seed || this.noiseGen == null) {
            this.noiseGen = new ChunkFastSimplexStyleNoise(seed + 193895856);
            this.noiseGen2 = new ChunkFastSimplexStyleNoise(seed + 294856869);
            this.seed = seed;
        }
    }

    @Override
    public boolean generate(StructureWorldAccess world, ChunkGenerator generator, Random rand, BlockPos pos, DefaultFeatureConfig config) {
        long randomLong = rand.nextLong();
        setSeed(world.getSeed() + 215465128 + randomLong);
        double noise;
        double noise2;

        int maximumHeight;
        int terrainHeight;
        BlockPos.Mutable mutable = new BlockPos.Mutable();

//        if (world.getBlockState(pos.down()).getBlock() != BYGBlockList.BLACK_SAND) {
//            return false;
//        }

//        if (world.getBlockState(pos.down()).getBlock() == BYGBlockList.BLACK_SAND) {
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                mutable.set(pos.getX() + x, 0, pos.getZ() + z);

                noise2 = (noiseGen.noise3_Classic(mutable.getX() * 0.04D, mutable.getY() * 0.04D, mutable.getZ() * 0.04D) + 1D) * 5D;
                noise = Math.pow(Math.abs(noiseGen.sample2D(mutable.getX() * 0.013D, mutable.getZ() * 0.013D)) + noise2 * 0.005D, 7); //0.70990733195111407153665966708847

                maximumHeight = (int) (noise * 65D);
                terrainHeight = world.getTopY(Heightmap.Type.OCEAN_FLOOR_WG, mutable.getX(), mutable.getZ());

                mutable.move(Direction.UP, maximumHeight);
                for (int y = maximumHeight; y >= terrainHeight; y--) {
                    world.setBlockState(mutable, blockStateArray[rand.nextInt(blockStateArray.length)], 2);

                    mutable.move(Direction.DOWN);
                }
            }
        }
//        }
        return true;
    }

    private void setBlockStateWithoutUpdates(ModifiableWorld worldWriter, BlockPos blockPos, BlockState blockState) {
        if (doBlockNotify) {
            worldWriter.setBlockState(blockPos, blockState, 19);
        } else {
            worldWriter.setBlockState(blockPos, blockState, 18);
        }
    }
}