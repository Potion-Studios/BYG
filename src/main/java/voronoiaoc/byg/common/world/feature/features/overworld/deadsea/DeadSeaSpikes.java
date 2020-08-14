package voronoiaoc.byg.common.world.feature.features.overworld.deadsea;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldWriter;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.StructureManager;
import voronoiaoc.byg.common.world.worldtype.noise.simplex.chunkgen.ChunkFastSimplexStyleNoise;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class DeadSeaSpikes extends Feature<NoFeatureConfig> {
    public static boolean doBlockNotify;
    static Random random = new Random();
    protected long seed;
    protected ChunkFastSimplexStyleNoise noiseGen;
    protected ChunkFastSimplexStyleNoise noiseGen2;
    static BlockState[] blockStateArray = {BYGBlockList.ROCKY_STONE.getDefaultState(), Blocks.COBBLESTONE.getDefaultState(), Blocks.STONE.getDefaultState()};

    public DeadSeaSpikes(Codec<NoFeatureConfig> config) {
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
    public boolean func_241855_a(ISeedReader world,  ChunkGenerator changedBlock, Random rand, BlockPos position, NoFeatureConfig config) {
        long randomLong = rand.nextLong();
        setSeed(world.getSeed() + 215465128 + randomLong);
        double noise;
        double noise2;

        int maximumHeight;
        int terrainHeight;
        BlockPos.Mutable mutable = new BlockPos.Mutable();

//        if (world.getBlockState(position.down()).getBlock() != BYGBlockList.BLACK_SAND) {
//            return false;
//        }

//        if (world.getBlockState(position.down()).getBlock() == BYGBlockList.BLACK_SAND) {
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                mutable.setPos(position.getX() + x, 0, position.getZ() + z);

                noise2 = (noiseGen.noise3_Classic(mutable.getX() * 0.04D, mutable.getY() * 0.04D, mutable.getZ() * 0.04D) + 1D) * 5D;
                noise = Math.pow(Math.abs(noiseGen.sample2D(mutable.getX() * 0.013D, mutable.getZ() * 0.013D)) + noise2 * 0.005D, 7); //0.70990733195111407153665966708847

                maximumHeight = (int) (noise * 65D);
                terrainHeight = world.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, mutable.getX(), mutable.getZ());

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

    protected void setCoralBlock(IWorldWriter worldIn, BlockPos pos) {
        this.setBlockStateWithoutUpdates(worldIn, pos, BYGBlockList.WARPED_CORAL_BLOCK.getDefaultState());
    }

    private void setBlockStateWithoutUpdates(IWorldWriter worldWriter, BlockPos blockPos, BlockState blockState) {
        if (doBlockNotify) {
            worldWriter.setBlockState(blockPos, blockState, 19);
        } else {
            worldWriter.setBlockState(blockPos, blockState, 18);
        }
    }

    private boolean checkArea(IWorld world, BlockPos pos) {
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();

        for (int checkX = -3; checkX <= 3; checkX++) {
            for (int checkZ = -3; checkZ <= 3; checkZ++) {

                BlockPos checkArea = new BlockPos(posX + checkX, posY, posZ + checkZ);

                if (!world.hasWater(checkArea)) return false;
            }
        }
        return true;
    }

    private BlockState blockState() {
        return (random.nextInt(2) == 0) ? BYGBlockList.ROCKY_STONE.getDefaultState() : Blocks.STONE.getDefaultState();
    }
}