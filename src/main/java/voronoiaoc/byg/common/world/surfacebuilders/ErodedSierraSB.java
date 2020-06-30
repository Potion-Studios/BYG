package voronoiaoc.byg.common.world.surfacebuilders;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import java.util.Random;

public class ErodedSierraSB extends SierraSB {
    private static final BlockState WHITE_TERRACOTTA;
    private static final BlockState ORANGE_TERRACOTTA;
    private static final BlockState TERRACOTTA;

    public ErodedSierraSB(Codec<TernarySurfaceConfig> codec) {
        super(codec);
    }

    public void generate(Random random, Chunk chunk, Biome biome, int i, int j, int k, double d, BlockState blockState, BlockState blockState2, int l, long m, TernarySurfaceConfig ternarySurfaceConfig) {
        double e = 0.0D;
        double f = Math.min(Math.abs(d), this.heightCutoffNoise.sample((double)i * 0.25D, (double)j * 0.25D, false) * 15.0D);
        if (f > 0.0D) {
            double g = 0.001953125D;
            double h = Math.abs(this.heightNoise.sample((double)i * 0.001953125D, (double)j * 0.001953125D, false));
            e = f * f * 2.5D;
            double n = Math.ceil(h * 50.0D) + 14.0D;
            if (e > n) {
                e = n;
            }

            e += 64.0D;
        }

        int o = i & 15;
        int p = j & 15;
        BlockState blockState3 = WHITE_TERRACOTTA;
        BlockState blockState4 = biome.getSurfaceConfig().getUnderMaterial();
        int q = (int)(d / 3.0D + 3.0D + random.nextDouble() * 0.25D);
        boolean bl = Math.cos(d / 3.0D * 3.141592653589793D) > 0.0D;
        int r = -1;
        boolean bl2 = false;
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for(int s = Math.max(k, (int)e + 1); s >= 0; --s) {
            mutable.set(o, s, p);
            if (chunk.getBlockState(mutable).isAir() && s < (int)e) {
                chunk.setBlockState(mutable, blockState, false);
            }

            BlockState blockState5 = chunk.getBlockState(mutable);
            if (blockState5.isAir()) {
                r = -1;
            } else if (blockState5.isOf(blockState.getBlock())) {
                if (r == -1) {
                    bl2 = false;
                    if (q <= 0) {
                        blockState3 = Blocks.AIR.getDefaultState();
                        blockState4 = blockState;
                    } else if (s >= l - 4 && s <= l + 1) {
                        blockState3 = WHITE_TERRACOTTA;
                        blockState4 = biome.getSurfaceConfig().getUnderMaterial();
                    }

                    if (s < l && (blockState3 == null || blockState3.isAir())) {
                        blockState3 = blockState2;
                    }

                    r = q + Math.max(0, s - l);
                    if (s >= l - 1) {
                        if (s <= l + 3 + q) {
                            chunk.setBlockState(mutable, biome.getSurfaceConfig().getTopMaterial(), false);
                            bl2 = true;
                        } else {
                            BlockState blockState8;
                            if (s >= 64 && s <= 127) {
                                if (bl) {
                                    blockState8 = TERRACOTTA;
                                } else {
                                    blockState8 = this.calculateLayerBlockState(i, s, j);
                                }
                            } else {
                                blockState8 = ORANGE_TERRACOTTA;
                            }

                            chunk.setBlockState(mutable, blockState8, false);
                        }
                    } else {
                        chunk.setBlockState(mutable, blockState4, false);
                        Block block = blockState4.getBlock();
                        if (block == Blocks.WHITE_TERRACOTTA || block == Blocks.ORANGE_TERRACOTTA || block == Blocks.MAGENTA_TERRACOTTA || block == Blocks.LIGHT_BLUE_TERRACOTTA || block == Blocks.YELLOW_TERRACOTTA || block == Blocks.LIME_TERRACOTTA || block == Blocks.PINK_TERRACOTTA || block == Blocks.GRAY_TERRACOTTA || block == Blocks.LIGHT_GRAY_TERRACOTTA || block == Blocks.CYAN_TERRACOTTA || block == Blocks.PURPLE_TERRACOTTA || block == Blocks.BLUE_TERRACOTTA || block == Blocks.BROWN_TERRACOTTA || block == Blocks.GREEN_TERRACOTTA || block == Blocks.RED_TERRACOTTA || block == Blocks.BLACK_TERRACOTTA) {
                            chunk.setBlockState(mutable, ORANGE_TERRACOTTA, false);
                        }
                    }
                } else if (r > 0) {
                    --r;
                    if (bl2) {
                        chunk.setBlockState(mutable, ORANGE_TERRACOTTA, false);
                    } else {
                        chunk.setBlockState(mutable, this.calculateLayerBlockState(i, s, j), false);
                    }
                }
            }
        }

    }

    static {
        WHITE_TERRACOTTA = Blocks.TERRACOTTA.getDefaultState();
        ORANGE_TERRACOTTA = Blocks.TERRACOTTA.getDefaultState();
        TERRACOTTA = Blocks.TERRACOTTA.getDefaultState();
    }
}