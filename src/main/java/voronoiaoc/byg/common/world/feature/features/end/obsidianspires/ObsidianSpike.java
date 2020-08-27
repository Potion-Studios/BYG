package voronoiaoc.byg.common.world.feature.features.end.obsidianspires;

import com.mojang.serialization.Codec;
import voronoiaoc.byg.common.noise.simplex.chunkgen.ChunkFastSimplexStyleNoise;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelWriter;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class ObsidianSpike extends Feature<NoneFeatureConfiguration> {
    public static boolean doBlockNotify;
    static Random random = new Random();
    protected long seed;
    protected ChunkFastSimplexStyleNoise noiseGen;
    protected ChunkFastSimplexStyleNoise noiseGen2;

    public ObsidianSpike(Codec<NoneFeatureConfiguration> config) {
        super(config);
    }

    public void setSeed(long seed) {
        if (this.seed != seed || this.noiseGen == null) {
            this.noiseGen = new ChunkFastSimplexStyleNoise(seed);
            this.noiseGen2 = new ChunkFastSimplexStyleNoise(seed + 13838344);
            this.seed = seed;
        }
    }

    @Override
    public boolean place(WorldGenLevel world, ChunkGenerator generator, Random rand, BlockPos pos, NoneFeatureConfiguration config) {
        setSeed(world.getSeed());
        int randLightHeight = rand.nextInt(25);
        int randChance = rand.nextInt(26);
        double noise;
        double noise2;

        int maximumHeight;
        int terrainHeight;
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

        if (!checkArea(world, pos) || world.getBlockState(pos.below()).getBlock() != BYGBlockList.IVIS_PHYLIUM) {
            return false;
        }

        if (world.getBlockState(pos.below()).getBlock() == BYGBlockList.IVIS_PHYLIUM) {
            for (int x = 0; x < 16; x++) {
                for (int z = 0; z < 16; z++) {
                    mutable.set(pos.getX() + x, 0, pos.getZ() + z);

                    noise2 = (noiseGen.noise3_Classic(mutable.getX() * 0.04D, mutable.getY() * 0.04D, mutable.getZ() * 0.04D) + 1D) * 5D;
                    noise = Math.pow(Math.abs(noiseGen.sample2D(mutable.getX() * 0.018D, mutable.getZ() * 0.015D)) + noise2 * 0.005D, 7); //0.70990733195111407153665966708847

                    maximumHeight = (int) (noise * 100D);
                    terrainHeight = world.getHeight(Heightmap.Types.MOTION_BLOCKING, mutable.getX(), mutable.getZ());

                    if (terrainHeight >= 55) {
                        mutable.move(Direction.UP, maximumHeight);
                        for (int y = maximumHeight; y >= terrainHeight; y--) {
                            world.setBlock(mutable, Blocks.OBSIDIAN.defaultBlockState(), 2);

                            mutable.move(Direction.DOWN);
                        }
                    }
                }
            }
        }
        return true;
    }

    protected void setCoralBlock(LevelWriter worldIn, BlockPos pos) {
        this.setBlockStateWithoutUpdates(worldIn, pos, BYGBlockList.WARPED_CORAL_BLOCK.defaultBlockState());
    }

    private void setBlockStateWithoutUpdates(LevelWriter worldWriter, BlockPos blockPos, BlockState blockState) {
        if (doBlockNotify) {
            worldWriter.setBlock(blockPos, blockState, 19);
        } else {
            worldWriter.setBlock(blockPos, blockState, 18);
        }
    }

    private boolean checkArea(LevelAccessor world, BlockPos pos) {
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();

        for (int checkX = -3; checkX <= 3; checkX++) {
            for (int checkZ = -3; checkZ <= 3; checkZ++) {

                BlockPos checkArea = new BlockPos(posX + checkX, posY, posZ + checkZ);

                if (!world.isEmptyBlock
                        (checkArea)) return false;
                if (world.getBlockState(checkArea).getBlock() == Blocks.OBSIDIAN) return false;
            }
        }
        return true;
    }

    private BlockState blockState() {
        return (random.nextInt(2) == 0) ? Blocks.END_STONE.defaultBlockState() : Blocks.OBSIDIAN.defaultBlockState();
    }
}