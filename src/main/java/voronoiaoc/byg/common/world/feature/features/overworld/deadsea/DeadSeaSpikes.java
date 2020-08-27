package voronoiaoc.byg.common.world.feature.features.overworld.deadsea;

import com.mojang.serialization.Codec;
import voronoiaoc.byg.common.noise.simplex.chunkgen.ChunkFastSimplexStyleNoise;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelWriter;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class DeadSeaSpikes extends Feature<NoneFeatureConfiguration> {
    public static boolean doBlockNotify;
    static Random random = new Random();
    protected long seed;
    protected ChunkFastSimplexStyleNoise noiseGen;
    protected ChunkFastSimplexStyleNoise noiseGen2;
    static BlockState[] blockStateArray = {BYGBlockList.ROCKY_STONE.defaultBlockState(), Blocks.COBBLESTONE.defaultBlockState(), Blocks.STONE.defaultBlockState()};

    public DeadSeaSpikes(Codec<NoneFeatureConfiguration> config) {
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
    public boolean place(WorldGenLevel world, ChunkGenerator generator, Random rand, BlockPos pos, NoneFeatureConfiguration config) {
        long randomLong = rand.nextLong();
        setSeed(world.getSeed() + 215465128 + randomLong);
        double noise;
        double noise2;

        int maximumHeight;
        int terrainHeight;
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

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
                terrainHeight = world.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, mutable.getX(), mutable.getZ());

                mutable.move(Direction.UP, maximumHeight);
                for (int y = maximumHeight; y >= terrainHeight; y--) {
                    world.setBlock(mutable, blockStateArray[rand.nextInt(blockStateArray.length)], 2);

                    mutable.move(Direction.DOWN);
                }
            }
        }
//        }
        return true;
    }

    private void setBlockStateWithoutUpdates(LevelWriter worldWriter, BlockPos blockPos, BlockState blockState) {
        if (doBlockNotify) {
            worldWriter.setBlock(blockPos, blockState, 19);
        } else {
            worldWriter.setBlock(blockPos, blockState, 18);
        }
    }
}