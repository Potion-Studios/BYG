package corgiaoc.byg.common.world.surfacebuilder;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.PerlinNoiseGenerator;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Arrays;
import java.util.Random;

@SuppressWarnings("deprecation")
public class ShatteredGlacierSB extends SurfaceBuilder<SurfaceBuilderConfig> {
    private static final BlockState PACKED_ICE = BYGBlocks.PACKED_BLACK_ICE.defaultBlockState();
    private static final BlockState BLUE_ICE = BYGBlocks.BLACK_ICE.defaultBlockState();
    private static final BlockState PACKED_ICE2 = BYGBlocks.PACKED_BLACK_ICE.defaultBlockState();
    private static final BlockState BLUE_ICE2 = BYGBlocks.BLACK_ICE.defaultBlockState();
    private static final BlockState PACKED_ICE3 = BYGBlocks.PACKED_BLACK_ICE.defaultBlockState();
    private static final BlockState BLUE_ICE3 = BYGBlocks.BLACK_ICE.defaultBlockState();
    private static final BlockState PACKED_ICE4 = BYGBlocks.PACKED_BLACK_ICE.defaultBlockState();
    protected BlockState[] blockState;
    protected long seed;
    protected PerlinNoiseGenerator perlin1;
    protected PerlinNoiseGenerator perlin2;
    protected PerlinNoiseGenerator perlin3;

    public ShatteredGlacierSB(Codec<SurfaceBuilderConfig> config) {
        super(config);
    }

    public void apply(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        int chunkX = x & 15;
        int chunkZ = z & 15;
        BlockState blockstate = PACKED_ICE;
        BlockState blockstate1 = biomeIn.getGenerationSettings().getSurfaceBuilderConfig().getUnderMaterial();
        int k = (int) (noise / 3.0D + 3.0D + random.nextDouble() * 0.25D);
        boolean flag = Math.cos(noise / 3.0D * Math.PI) > 0.0D;
        int l = -1;
        boolean flag1 = false;
        int i1 = 0;
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

        for (int chunkY = startHeight; chunkY >= 0; --chunkY) {
            if (i1 < 15) {
                blockpos$mutable.set(chunkX, chunkY, chunkZ);
                BlockState blockstate2 = chunkIn.getBlockState(blockpos$mutable);
                if (blockstate2.isAir()) {
                    l = -1;
                } else if (blockstate2.getBlock() == defaultBlock.getBlock()) {
                    if (l == -1) {
                        flag1 = false;
                        if (k <= 0) {
                            blockstate = Blocks.AIR.defaultBlockState();
                            blockstate1 = defaultBlock;
                        } else if (chunkY >= seaLevel - 4 && chunkY <= seaLevel + 1) {
                            blockstate = PACKED_ICE;
                            blockstate1 = biomeIn.getGenerationSettings().getSurfaceBuilderConfig().getUnderMaterial();
                        }

                        if (chunkY < seaLevel && (blockstate == null || blockstate.isAir())) {
                            blockstate = defaultFluid;
                        }

                        l = k + Math.max(0, chunkY - seaLevel);
                        if (chunkY >= seaLevel - 1) {
                            if (chunkY > seaLevel + 3 + k) {
                                BlockState blockstate3;
                                if (chunkY >= 64 && chunkY <= 127) {
                                    if (flag) {
                                        blockstate3 = PACKED_ICE2;
                                    } else {
                                        blockstate3 = this.noiseBlockState(x, chunkY, z);
                                    }
                                } else {
                                    blockstate3 = BLUE_ICE;
                                }

                                chunkIn.setBlockState(blockpos$mutable, blockstate3, false);
                            } else {
                                chunkIn.setBlockState(blockpos$mutable, biomeIn.getGenerationSettings().getSurfaceBuilderConfig().getTopMaterial(), false);
                                flag1 = true;
                            }
                        } else {
                            chunkIn.setBlockState(blockpos$mutable, blockstate1, false);
                            Block block = blockstate1.getBlock();
                            if (block == Blocks.WHITE_TERRACOTTA || block == Blocks.ORANGE_TERRACOTTA || block == Blocks.MAGENTA_TERRACOTTA || block == Blocks.LIGHT_BLUE_TERRACOTTA || block == Blocks.YELLOW_TERRACOTTA || block == Blocks.LIME_TERRACOTTA || block == Blocks.PINK_TERRACOTTA || block == Blocks.GRAY_TERRACOTTA || block == Blocks.LIGHT_GRAY_TERRACOTTA || block == Blocks.CYAN_TERRACOTTA || block == Blocks.PURPLE_TERRACOTTA || block == Blocks.BLUE_TERRACOTTA || block == Blocks.BROWN_TERRACOTTA || block == Blocks.GREEN_TERRACOTTA || block == Blocks.RED_TERRACOTTA || block == Blocks.BLACK_TERRACOTTA) {
                                chunkIn.setBlockState(blockpos$mutable, BLUE_ICE, false);
                            }
                        }
                    } else if (l > 0) {
                        --l;
                        if (flag1) {
                            chunkIn.setBlockState(blockpos$mutable, BLUE_ICE, false);
                        } else {
                            chunkIn.setBlockState(blockpos$mutable, this.noiseBlockState(x, chunkY, z), false);
                        }
                    }

                    ++i1;
                }
            }
        }

    }

    public void initNoise(long seed) {
        if (this.seed != seed || this.blockState == null) {
            this.fillBlockStateArray(seed);
        }

        if (this.seed != seed || this.perlin1 == null || this.perlin2 == null) {
            SharedSeedRandom sharedseedrandom = new SharedSeedRandom(seed);
            this.perlin1 = new PerlinNoiseGenerator(sharedseedrandom, ImmutableList.of(0));
            this.perlin2 = new PerlinNoiseGenerator(sharedseedrandom, ImmutableList.of(0));
        }

        this.seed = seed;
    }

    protected void fillBlockStateArray(long seed) {
        this.blockState = new BlockState[64];
        Arrays.fill(this.blockState, PACKED_ICE2);
        SharedSeedRandom sharedseedrandom = new SharedSeedRandom(seed);
        this.perlin3 = new PerlinNoiseGenerator(sharedseedrandom, ImmutableList.of(0));

        for (int l1 = 0; l1 < 64; ++l1) {
            l1 += sharedseedrandom.nextInt(5) + 1;
            if (l1 < 64) {
                this.blockState[l1] = BLUE_ICE;
            }
        }

        int i2 = sharedseedrandom.nextInt(4) + 2;

        for (int i = 0; i < i2; ++i) {
            int j = sharedseedrandom.nextInt(3) + 1;
            int k = sharedseedrandom.nextInt(64);

            for (int l = 0; k + l < 64 && l < j; ++l) {
                this.blockState[k + l] = BLUE_ICE2;
            }
        }

        int j2 = sharedseedrandom.nextInt(4) + 2;

        for (int k2 = 0; k2 < j2; ++k2) {
            int i3 = sharedseedrandom.nextInt(3) + 2;
            int l3 = sharedseedrandom.nextInt(64);

            for (int i1 = 0; l3 + i1 < 64 && i1 < i3; ++i1) {
                this.blockState[l3 + i1] = PACKED_ICE3;
            }
        }

        int l2 = sharedseedrandom.nextInt(4) + 2;

        for (int j3 = 0; j3 < l2; ++j3) {
            int i4 = sharedseedrandom.nextInt(3) + 1;
            int k4 = sharedseedrandom.nextInt(64);

            for (int j1 = 0; k4 + j1 < 64 && j1 < i4; ++j1) {
                this.blockState[k4 + j1] = BLUE_ICE3;
            }
        }

        int k3 = sharedseedrandom.nextInt(3) + 3;
        int j4 = 0;

        for (int l4 = 0; l4 < k3; ++l4) {
            int i5 = 1;
            j4 += sharedseedrandom.nextInt(16) + 4;

            for (int k1 = 0; j4 + k1 < 64 && k1 < 1; ++k1) {
                this.blockState[j4 + k1] = PACKED_ICE;
                if (j4 + k1 > 1 && sharedseedrandom.nextBoolean()) {
                    this.blockState[j4 + k1 - 1] = PACKED_ICE4;
                }

                if (j4 + k1 < 63 && sharedseedrandom.nextBoolean()) {
                    this.blockState[j4 + k1 + 1] = PACKED_ICE4;
                }
            }
        }

    }

    protected BlockState noiseBlockState(int x, int y, int z) {
        int i = (int) Math.round(this.perlin3.getValue((double) x / 512.0D, (double) z / 512.0D, false) * 2.0D);
        return this.blockState[(y + i + 64) % 64];
    }
}