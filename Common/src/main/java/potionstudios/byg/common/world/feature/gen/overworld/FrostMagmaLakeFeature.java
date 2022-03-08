package potionstudios.byg.common.world.feature.gen.overworld;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.material.Material;
import potionstudios.byg.common.block.BYGBlocks;

import java.util.Random;

public class FrostMagmaLakeFeature extends Feature<BlockStateConfiguration> {
    private static final BlockState AIR;

    static {
        AIR = Blocks.AIR.defaultBlockState();
    }

    public FrostMagmaLakeFeature(Codec<BlockStateConfiguration> config) {
        super(config);
    }

    @Override
    public boolean place(FeaturePlaceContext<BlockStateConfiguration> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }

    public boolean place(WorldGenLevel world, ChunkGenerator genSettings, Random rand, BlockPos blockPos, BlockStateConfiguration blockStateFeatureConfig) {
        while (blockPos.getY() > 5 && world.isEmptyBlock(blockPos)) {
            blockPos = blockPos.below();
        }

        if (blockPos.getY() <= 4) {
            return false;
        } else {
            blockPos = blockPos.below(4);
            ChunkPos chunkPos = new ChunkPos(blockPos);
//            if (structureManager.startsForFeature(SectionPos.from(blockPos), Structure.VILLAGE).findAny().isPresent()) {
//                return false;
//            } else {
            boolean[] flagArray = new boolean[2048];
            int lvt_8_1_ = rand.nextInt(4) + 4;

            int lvt_9_5_;
            for (lvt_9_5_ = 0; lvt_9_5_ < lvt_8_1_; ++lvt_9_5_) {
                double lvt_10_1_ = rand.nextDouble() * 6.0D + 3.0D;
                double lvt_12_1_ = rand.nextDouble() * 4.0D + 2.0D;
                double lvt_14_1_ = rand.nextDouble() * 6.0D + 3.0D;
                double lvt_16_1_ = rand.nextDouble() * (16.0D - lvt_10_1_ - 2.0D) + 1.0D + lvt_10_1_ / 2.0D;
                double lvt_18_1_ = rand.nextDouble() * (8.0D - lvt_12_1_ - 4.0D) + 2.0D + lvt_12_1_ / 2.0D;
                double lvt_20_1_ = rand.nextDouble() * (16.0D - lvt_14_1_ - 2.0D) + 1.0D + lvt_14_1_ / 2.0D;

                for (int lvt_22_1_ = 1; lvt_22_1_ < 15; ++lvt_22_1_) {
                    for (int lvt_23_1_ = 1; lvt_23_1_ < 15; ++lvt_23_1_) {
                        for (int lvt_24_1_ = 1; lvt_24_1_ < 7; ++lvt_24_1_) {
                            double lvt_25_1_ = ((double) lvt_22_1_ - lvt_16_1_) / (lvt_10_1_ / 2.0D);
                            double lvt_27_1_ = ((double) lvt_24_1_ - lvt_18_1_) / (lvt_12_1_ / 2.0D);
                            double lvt_29_1_ = ((double) lvt_23_1_ - lvt_20_1_) / (lvt_14_1_ / 2.0D);
                            double lvt_31_1_ = lvt_25_1_ * lvt_25_1_ + lvt_27_1_ * lvt_27_1_ + lvt_29_1_ * lvt_29_1_;
                            if (lvt_31_1_ < 1.0D) {
                                flagArray[(lvt_22_1_ * 16 + lvt_23_1_) * 8 + lvt_24_1_] = true;
                            }
                        }
                    }
                }
            }

            int lvt_11_4_;
            int lvt_10_5_;
            boolean lvt_12_4_;
            for (lvt_9_5_ = 0; lvt_9_5_ < 16; ++lvt_9_5_) {
                for (lvt_10_5_ = 0; lvt_10_5_ < 16; ++lvt_10_5_) {
                    for (lvt_11_4_ = 0; lvt_11_4_ < 8; ++lvt_11_4_) {
                        lvt_12_4_ = !flagArray[(lvt_9_5_ * 16 + lvt_10_5_) * 8 + lvt_11_4_] && (lvt_9_5_ < 15 && flagArray[((lvt_9_5_ + 1) * 16 + lvt_10_5_) * 8 + lvt_11_4_] || lvt_9_5_ > 0 && flagArray[((lvt_9_5_ - 1) * 16 + lvt_10_5_) * 8 + lvt_11_4_] || lvt_10_5_ < 15 && flagArray[(lvt_9_5_ * 16 + lvt_10_5_ + 1) * 8 + lvt_11_4_] || lvt_10_5_ > 0 && flagArray[(lvt_9_5_ * 16 + (lvt_10_5_ - 1)) * 8 + lvt_11_4_] || lvt_11_4_ < 7 && flagArray[(lvt_9_5_ * 16 + lvt_10_5_) * 8 + lvt_11_4_ + 1] || lvt_11_4_ > 0 && flagArray[(lvt_9_5_ * 16 + lvt_10_5_) * 8 + (lvt_11_4_ - 1)]);
                        if (lvt_12_4_) {
                            Material lvt_13_1_ = world.getBlockState(blockPos.offset(lvt_9_5_, lvt_11_4_, lvt_10_5_)).getMaterial();
                            if (lvt_11_4_ >= 4 && lvt_13_1_.isLiquid()) {
                                return false;
                            }

                            if (lvt_11_4_ < 4 && !lvt_13_1_.isSolid() && world.getBlockState(blockPos.offset(lvt_9_5_, lvt_11_4_, lvt_10_5_)) != blockStateFeatureConfig.state) {
                                return false;
                            }
                        }
                    }
                }
            }

            for (lvt_9_5_ = 0; lvt_9_5_ < 16; ++lvt_9_5_) {
                for (lvt_10_5_ = 0; lvt_10_5_ < 16; ++lvt_10_5_) {
                    for (lvt_11_4_ = 0; lvt_11_4_ < 8; ++lvt_11_4_) {
                        if (flagArray[(lvt_9_5_ * 16 + lvt_10_5_) * 8 + lvt_11_4_]) {
                            world.setBlock(blockPos.offset(lvt_9_5_, lvt_11_4_, lvt_10_5_), lvt_11_4_ >= 4 ? AIR : blockStateFeatureConfig.state, 2);
                        }
                    }
                }
            }

            BlockPos lvt_12_5_;
            for (lvt_9_5_ = 0; lvt_9_5_ < 16; ++lvt_9_5_) {
                for (lvt_10_5_ = 0; lvt_10_5_ < 16; ++lvt_10_5_) {
                    for (lvt_11_4_ = 4; lvt_11_4_ < 8; ++lvt_11_4_) {
                        if (flagArray[(lvt_9_5_ * 16 + lvt_10_5_) * 8 + lvt_11_4_]) {
                            lvt_12_5_ = blockPos.offset(lvt_9_5_, lvt_11_4_ - 1, lvt_10_5_);
                            if (isDirt(world.getBlockState(lvt_12_5_)) && world.getBrightness(LightLayer.SKY, blockPos.offset(lvt_9_5_, lvt_11_4_, lvt_10_5_)) > 0) {
                                world.setBlock(lvt_12_5_, BYGBlocks.FROST_MAGMA.defaultBlockState(), 2);
                            }
                        }
                    }
                }
            }

            if (blockStateFeatureConfig.state.getMaterial() == Material.STONE) {
                for (lvt_9_5_ = 0; lvt_9_5_ < 16; ++lvt_9_5_) {
                    for (lvt_10_5_ = 0; lvt_10_5_ < 16; ++lvt_10_5_) {
                        for (lvt_11_4_ = 0; lvt_11_4_ < 8; ++lvt_11_4_) {
                            lvt_12_4_ = !flagArray[(lvt_9_5_ * 16 + lvt_10_5_) * 8 + lvt_11_4_] && (lvt_9_5_ < 15 && flagArray[((lvt_9_5_ + 1) * 16 + lvt_10_5_) * 8 + lvt_11_4_] || lvt_9_5_ > 0 && flagArray[((lvt_9_5_ - 1) * 16 + lvt_10_5_) * 8 + lvt_11_4_] || lvt_10_5_ < 15 && flagArray[(lvt_9_5_ * 16 + lvt_10_5_ + 1) * 8 + lvt_11_4_] || lvt_10_5_ > 0 && flagArray[(lvt_9_5_ * 16 + (lvt_10_5_ - 1)) * 8 + lvt_11_4_] || lvt_11_4_ < 7 && flagArray[(lvt_9_5_ * 16 + lvt_10_5_) * 8 + lvt_11_4_ + 1] || lvt_11_4_ > 0 && flagArray[(lvt_9_5_ * 16 + lvt_10_5_) * 8 + (lvt_11_4_ - 1)]);
                            if (lvt_12_4_ && (lvt_11_4_ < 4 || rand.nextInt(2) != 0) && world.getBlockState(blockPos.offset(lvt_9_5_, lvt_11_4_, lvt_10_5_)).getMaterial().isSolid()) {
                                world.setBlock(blockPos.offset(lvt_9_5_, lvt_11_4_, lvt_10_5_), BYGBlocks.PACKED_BLACK_ICE.defaultBlockState(), 2);
                            }
                        }
                    }
                }
            }

            if (blockStateFeatureConfig.state.getMaterial() == Material.WATER) {
                for (lvt_9_5_ = 0; lvt_9_5_ < 16; ++lvt_9_5_) {
                    for (lvt_10_5_ = 0; lvt_10_5_ < 16; ++lvt_10_5_) {
                        lvt_12_5_ = blockPos.offset(lvt_9_5_, 4, lvt_10_5_);
                        if (world.getBiome(lvt_12_5_).value().shouldFreeze(world, lvt_12_5_, false)) {
                            world.setBlock(lvt_12_5_, Blocks.ICE.defaultBlockState(), 2);
                        }
                    }
                }
            }

            return true;
//            }
        }
    }
}

