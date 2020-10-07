package corgiaoc.byg.common.world.feature.features.end.obsidianspires;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.BYGBlocks;
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
import corgiaoc.byg.util.noise.simplex.chunkgen.ChunkFastSimplexStyleNoise;

import java.util.Random;

public class ObsidianSpike extends Feature<NoFeatureConfig> {
    public static boolean doBlockNotify;
    static Random random = new Random();
    protected long seed;
    protected ChunkFastSimplexStyleNoise noiseGen;
    protected ChunkFastSimplexStyleNoise noiseGen2;

    public ObsidianSpike(Codec<NoFeatureConfig> config) {
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
    public boolean func_241855_a(ISeedReader world, ChunkGenerator changedBlock, Random rand, BlockPos position, NoFeatureConfig config) {
        setSeed(world.getSeed());
        int randLightHeight = rand.nextInt(25);
        int randChance = rand.nextInt(26);
        double noise;
        double noise2;

        int maximumHeight;
        int terrainHeight;
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        if (!checkArea(world, position) || world.getBlockState(position.down()).getBlock() != BYGBlocks.IVIS_PHYLIUM) {
            return false;
        }

        if (world.getBlockState(position.down()).getBlock() == BYGBlocks.IVIS_PHYLIUM) {
            for (int x = 0; x < 16; x++) {
                for (int z = 0; z < 16; z++) {
                    mutable.setPos(position.getX() + x, 0, position.getZ() + z);

                    noise2 = (noiseGen.noise3_Classic(mutable.getX() * 0.04D, mutable.getY() * 0.04D, mutable.getZ() * 0.04D) + 1D) * 5D;
                    noise = Math.pow(Math.abs(noiseGen.sample2D(mutable.getX() * 0.018D, mutable.getZ() * 0.015D)) + noise2 * 0.005D, 7); //0.70990733195111407153665966708847

                    maximumHeight = (int) (noise * 100D);
                    terrainHeight = world.getHeight(Heightmap.Type.MOTION_BLOCKING, mutable.getX(), mutable.getZ());

                    if (terrainHeight >= 55) {
                        mutable.move(Direction.UP, maximumHeight);
                        for (int y = maximumHeight; y >= terrainHeight; y--) {
                            world.setBlockState(mutable, Blocks.OBSIDIAN.getDefaultState(), 2);

                            mutable.move(Direction.DOWN);
                        }
                    }
                }
            }
        }
        return true;
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

                if (!world.isAirBlock(checkArea)) return false;
                if (world.getBlockState(checkArea).getBlock() == Blocks.OBSIDIAN) return false;
            }
        }
        return true;
    }

    private BlockState blockState() {
        return (random.nextInt(2) == 0) ? Blocks.END_STONE.getDefaultState() : Blocks.OBSIDIAN.getDefaultState();
    }
}