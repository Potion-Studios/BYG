package corgiaoc.byg.common.world.surfacebuilder;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

import java.util.Random;

@SuppressWarnings("deprecation")
public class ShatteredGlacierSB2 extends ShatteredGlacierSB {
    private static final BlockState PACKED_ICE = BYGBlocks.PACKED_BLACK_ICE.defaultBlockState();
    private static final BlockState BLUE_ICE = BYGBlocks.BLACK_ICE.defaultBlockState();
    private static final BlockState BLUE_ICE2 = Blocks.SNOW_BLOCK.defaultBlockState();

    public ShatteredGlacierSB2(Codec<SurfaceBuilderBaseConfiguration> config) {
        super(config);
    }

    public void apply(Random random, ChunkAccess chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderBaseConfiguration config) {
        double d0 = 0.0D;
        double d1 = Math.min(Math.abs(noise), this.perlin1.getValue((double) x * 0.25D, (double) z * 0.25D, false) * 15.0D);
        if (d1 > 0.0D) {
            double d3 = Math.abs(this.perlin2.getValue((double) x * 0.001953125D, (double) z * 0.001953125D, false));
            d0 = d1 * d1 * 2.5D;
            double d4 = Math.ceil(d3 * 50.0D) + 14.0D;
            if (d0 > d4) {
                d0 = d4;
            }

            d0 = d0 + 64.0D;
        }

        int chunkX = x & 15;
        int chunkZ = z & 15;
        BlockState blockstatePackedIce = PACKED_ICE;
        BlockState blockstateUnder = biomeIn.getGenerationSettings().getSurfaceBuilderConfig().getUnderMaterial();
        int i1 = (int) (noise / 3.0D + 3.0D + random.nextDouble() * 0.25D);
        boolean flag = Math.cos(noise / 3.0D * Math.PI) > 0.0D;
        int j = -1;
        boolean flag1 = false;
        BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();

        for (int k = Math.max(startHeight, (int) d0 + 1); k >= 0; --k) {
            blockpos$mutable.set(chunkX, k, chunkZ);
            if (chunkIn.getBlockState(blockpos$mutable).isAir() && k < (int) d0) {
                chunkIn.setBlockState(blockpos$mutable, defaultBlock, false);
            }

            BlockState blockstate1 = chunkIn.getBlockState(blockpos$mutable);
            if (blockstate1.isAir()) {
                j = -1;
            } else if (blockstate1.getBlock() == defaultBlock.getBlock()) {
                if (j == -1) {
                    flag1 = false;
                    if (i1 <= 0) {
                        blockstatePackedIce = Blocks.AIR.defaultBlockState();
                        blockstateUnder = defaultBlock;
                    } else if (k >= seaLevel - 4 && k <= seaLevel + 1) {
                        blockstatePackedIce = PACKED_ICE;
                        blockstateUnder = biomeIn.getGenerationSettings().getSurfaceBuilderConfig().getUnderMaterial();
                    }

                    if (k < seaLevel && (blockstatePackedIce == null || blockstatePackedIce.isAir())) {
                        blockstatePackedIce = defaultFluid;
                    }

                    j = i1 + Math.max(0, k - seaLevel);
                    if (k >= seaLevel - 1) {
                        if (k <= seaLevel + 3 + i1) {
                            chunkIn.setBlockState(blockpos$mutable, biomeIn.getGenerationSettings().getSurfaceBuilderConfig().getTopMaterial(), false);
                            flag1 = true;
                        } else {
                            BlockState blockstate3;
                            if (k >= 64 && k <= 127) {
                                if (flag) {
                                    blockstate3 = BLUE_ICE2;
                                } else {
                                    blockstate3 = this.noiseBlockState(x, k, z);
                                }
                            } else {
                                blockstate3 = BLUE_ICE;
                            }

                            chunkIn.setBlockState(blockpos$mutable, blockstate3, false);
                        }
                    } else {
                        chunkIn.setBlockState(blockpos$mutable, blockstateUnder, false);
                        Block block = blockstateUnder.getBlock();
                        if (block == Blocks.WHITE_TERRACOTTA || block == Blocks.ORANGE_TERRACOTTA || block == Blocks.MAGENTA_TERRACOTTA || block == Blocks.LIGHT_BLUE_TERRACOTTA || block == Blocks.YELLOW_TERRACOTTA || block == Blocks.LIME_TERRACOTTA || block == Blocks.PINK_TERRACOTTA || block == Blocks.GRAY_TERRACOTTA || block == Blocks.LIGHT_GRAY_TERRACOTTA || block == Blocks.CYAN_TERRACOTTA || block == Blocks.PURPLE_TERRACOTTA || block == Blocks.BLUE_TERRACOTTA || block == Blocks.BROWN_TERRACOTTA || block == Blocks.GREEN_TERRACOTTA || block == Blocks.RED_TERRACOTTA || block == Blocks.BLACK_TERRACOTTA) {
                            chunkIn.setBlockState(blockpos$mutable, BLUE_ICE, false);
                        }
                    }
                } else if (j > 0) {
                    --j;
                    if (flag1) {
                        chunkIn.setBlockState(blockpos$mutable, BLUE_ICE, false);
                    } else {
                        chunkIn.setBlockState(blockpos$mutable, this.noiseBlockState(x, k, z), false);
                    }
                }
            }
        }

    }
}