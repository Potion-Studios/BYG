package corgiaoc.byg.common.world.surfacebuilder;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;

public class ErodedLunaSB extends LunaSB {
    private static final BlockState WHITE_TERRACOTTA = Blocks.WHITE_TERRACOTTA.defaultBlockState();
    private static final BlockState ORANGE_TERRACOTTA = Blocks.ORANGE_TERRACOTTA.defaultBlockState();
    private static final BlockState TERRACOTTA = Blocks.TERRACOTTA.defaultBlockState();

    public ErodedLunaSB(Codec<SurfaceBuilderConfig> p_i51314_1_) {
        super(p_i51314_1_);
    }

    public void apply(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        double d0 = 0.0D;
        double d1 = Math.min(Math.abs(noise), this.pillarNoise.getValue((double) x * 0.25D, (double) z * 0.25D, false) * 15.0D);
        if (d1 > 0.0D) {
            double d2 = 0.001953125D;
            double d3 = Math.abs(this.pillarRoofNoise.getValue((double) x * 0.001953125D, (double) z * 0.001953125D, false));
            d0 = d1 * d1 * 2.5D;
            double d4 = Math.ceil(d3 * 50.0D) + 14.0D;
            if (d0 > d4) {
                d0 = d4;
            }

            d0 = d0 + 64.0D;
        }

        int l = x & 15;
        int i = z & 15;
        BlockState blockstate2 = TERRACOTTA;
        BlockState blockstate = biomeIn.getGenerationSettings().getSurfaceBuilderConfig().getUnderMaterial();
        int i1 = (int) (noise / 3.0D + 3.0D + random.nextDouble() * 0.25D);
        boolean flag = Math.cos(noise / 3.0D * Math.PI) > 0.0D;
        int j = -1;
        boolean flag1 = false;
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

        for (int k = Math.max(startHeight, (int) d0 + 1); k >= 0; --k) {
            blockpos$mutable.set(l, k, i);
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
                        blockstate2 = Blocks.AIR.defaultBlockState();
                        blockstate = defaultBlock;
                    } else if (k >= seaLevel - 4 && k <= seaLevel + 1) {
                        blockstate2 = TERRACOTTA;
                        blockstate = biomeIn.getGenerationSettings().getSurfaceBuilderConfig().getUnderMaterial();
                    }

                    if (k < seaLevel && (blockstate2 == null || blockstate2.isAir())) {
                        blockstate2 = defaultFluid;
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
                                    blockstate3 = TERRACOTTA;
                                } else {
                                    blockstate3 = this.getBand(x, k, z);
                                }
                            } else {
                                blockstate3 = TERRACOTTA;
                            }

                            chunkIn.setBlockState(blockpos$mutable, blockstate3, false);
                        }
                    } else {
                        chunkIn.setBlockState(blockpos$mutable, blockstate, false);
                        Block block = blockstate.getBlock();
                        if (block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA) {
                            chunkIn.setBlockState(blockpos$mutable, TERRACOTTA, false);
                        }
                    }
                } else if (j > 0) {
                    --j;
                    if (flag1) {
                        chunkIn.setBlockState(blockpos$mutable, TERRACOTTA, false);
                    } else {
                        chunkIn.setBlockState(blockpos$mutable, this.getBand(x, k, z), false);
                    }
                }
            }
        }

    }
}