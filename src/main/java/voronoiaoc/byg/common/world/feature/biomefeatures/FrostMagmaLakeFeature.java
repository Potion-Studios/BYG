package voronoiaoc.byg.common.world.feature.biomefeatures;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.LightType;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.SingleStateFeatureConfig;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class FrostMagmaLakeFeature extends Feature<SingleStateFeatureConfig> {
    private static final BlockState AIR;

    static {
        AIR = Blocks.CAVE_AIR.getDefaultState();
    }

    public FrostMagmaLakeFeature(Codec<SingleStateFeatureConfig> config) {
        super(config);
    }

    public boolean generate(StructureWorldAccess world, ChunkGenerator generator, Random rand, BlockPos blockPos, SingleStateFeatureConfig config) {
        while (blockPos.getY() > 5 && world.isAir
                (blockPos)) {
            blockPos = blockPos.down();
        }

        if (blockPos.getY() <= 4) {
            return false;
        } else {
            blockPos = blockPos.down(4);
            ChunkPos chunkPos = new ChunkPos(blockPos);
            /*if (!world.getChunk(chunkPos.x, chunkPos.z, ChunkStatus.STRUCTURE_REFERENCES).getStructureReferences(Feature.VILLAGE.getStructureName()).isEmpty()) {
                return false;
            } else {*/
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
                            Material lvt_13_1_ = world.getBlockState(blockPos.add(lvt_9_5_, lvt_11_4_, lvt_10_5_)).getMaterial();
                            if (lvt_11_4_ >= 4 && lvt_13_1_.isLiquid()) {
                                return false;
                            }

                            if (lvt_11_4_ < 4 && !lvt_13_1_.isSolid() && world.getBlockState(blockPos.add(lvt_9_5_, lvt_11_4_, lvt_10_5_)) != config.state) {
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
                            world.setBlockState(blockPos.add(lvt_9_5_, lvt_11_4_, lvt_10_5_), lvt_11_4_ >= 4 ? AIR : config.state, 2);
                        }
                    }
                }
            }

            BlockPos lvt_12_5_;
            for (lvt_9_5_ = 0; lvt_9_5_ < 16; ++lvt_9_5_) {
                for (lvt_10_5_ = 0; lvt_10_5_ < 16; ++lvt_10_5_) {
                    for (lvt_11_4_ = 4; lvt_11_4_ < 8; ++lvt_11_4_) {
                        if (flagArray[(lvt_9_5_ * 16 + lvt_10_5_) * 8 + lvt_11_4_]) {
                            lvt_12_5_ = blockPos.add(lvt_9_5_, lvt_11_4_ - 1, lvt_10_5_);
                            if (isSoil(world.getBlockState(lvt_12_5_).getBlock()) && world.getLightLevel(LightType.SKY, blockPos.add(lvt_9_5_, lvt_11_4_, lvt_10_5_)) > 0) {
                                Biome lvt_13_2_ = world.getBiome(lvt_12_5_);
                                if (lvt_13_2_.getSurfaceBuilder().get().getConfig().getTopMaterial().getBlock() == BYGBlockList.FROST_MAGMA) {
                                    world.setBlockState(lvt_12_5_, BYGBlockList.FROST_MAGMA.getDefaultState(), 2);
                                } else {
                                    world.setBlockState(lvt_12_5_, BYGBlockList.FROST_MAGMA.getDefaultState(), 2);
                                }
                            }
                        }
                    }
                }
            }

            if (config.state.getMaterial() == Material.STONE) {
                for (lvt_9_5_ = 0; lvt_9_5_ < 16; ++lvt_9_5_) {
                    for (lvt_10_5_ = 0; lvt_10_5_ < 16; ++lvt_10_5_) {
                        for (lvt_11_4_ = 0; lvt_11_4_ < 8; ++lvt_11_4_) {
                            lvt_12_4_ = !flagArray[(lvt_9_5_ * 16 + lvt_10_5_) * 8 + lvt_11_4_] && (lvt_9_5_ < 15 && flagArray[((lvt_9_5_ + 1) * 16 + lvt_10_5_) * 8 + lvt_11_4_] || lvt_9_5_ > 0 && flagArray[((lvt_9_5_ - 1) * 16 + lvt_10_5_) * 8 + lvt_11_4_] || lvt_10_5_ < 15 && flagArray[(lvt_9_5_ * 16 + lvt_10_5_ + 1) * 8 + lvt_11_4_] || lvt_10_5_ > 0 && flagArray[(lvt_9_5_ * 16 + (lvt_10_5_ - 1)) * 8 + lvt_11_4_] || lvt_11_4_ < 7 && flagArray[(lvt_9_5_ * 16 + lvt_10_5_) * 8 + lvt_11_4_ + 1] || lvt_11_4_ > 0 && flagArray[(lvt_9_5_ * 16 + lvt_10_5_) * 8 + (lvt_11_4_ - 1)]);
                            if (lvt_12_4_ && (lvt_11_4_ < 4 || rand.nextInt(2) != 0) && world.getBlockState(blockPos.add(lvt_9_5_, lvt_11_4_, lvt_10_5_)).getMaterial().isSolid()) {
                                world.setBlockState(blockPos.add(lvt_9_5_, lvt_11_4_, lvt_10_5_), BYGBlockList.PACKED_BLACK_ICE.getDefaultState(), 2);
                            }
                        }
                    }
                }
            }

            if (config.state.getMaterial() == Material.WATER) {
                for (lvt_9_5_ = 0; lvt_9_5_ < 16; ++lvt_9_5_) {
                    for (lvt_10_5_ = 0; lvt_10_5_ < 16; ++lvt_10_5_) {
                        lvt_12_5_ = blockPos.add(lvt_9_5_, 4, lvt_10_5_);
                        if (world.getBiome(lvt_12_5_).canSetIce(world, lvt_12_5_, false)) {
                            world.setBlockState(lvt_12_5_, Blocks.ICE.getDefaultState(), 2);
                        }
                    }
                }
            }

            return true;
        }
//        }
    }
}

