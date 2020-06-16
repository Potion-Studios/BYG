package voronoiaoc.byg.common.world.feature.features.overworld.trees.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.math.shapes.BitSetVoxelShapePart;
import net.minecraft.util.math.shapes.VoxelShapePart;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.IWorldWriter;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraftforge.common.IPlantable;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public abstract class BYGTreeFeatureHelper<T extends IFeatureConfig> extends Feature<T> {
    public static boolean doBlockNotify;
    protected IPlantable sapling = (net.minecraftforge.common.IPlantable) Blocks.OAK_SAPLING;

    public BYGTreeFeatureHelper(Function<Dynamic<?>, ? extends T> function, int beeHiveChance) {
        super(function);
    }

    public static boolean canTreePlaceHere(IWorldGenerationBaseReader worldReader, BlockPos blockPos) {
        if (!(worldReader instanceof IWorldReader))
            return worldReader.hasBlockState(blockPos, (blockPos2) -> {
                Block block = blockPos2.getBlock();
                return blockPos2.isAir() || blockPos2.isIn(BlockTags.LEAVES) || block == Blocks.GRASS_BLOCK || Feature.isDirt(block) || block.isIn(BlockTags.LOGS) || block.isIn(BlockTags.SAPLINGS) || block == Blocks.VINE || block == BYGBlockList.OVERGROWN_STONE || block == BYGBlockList.MAHOGANY_LOG || block == BYGBlockList.MAHOGANY_LEAVES;
            });
        else
            return worldReader.hasBlockState(blockPos, state -> state.canBeReplacedByLogs((IWorldReader) worldReader, blockPos));
    }

    protected final void setFinalBlockState(Set<BlockPos> changedBlocks, IWorldWriter worldIn, BlockPos pos, BlockState blockState, MutableBoundingBox boundingBox) {
        this.setBlockStateWithoutUpdates(worldIn, pos, blockState);
        boundingBox.expandTo(new MutableBoundingBox(pos, pos));
        if (BlockTags.LOGS.contains(blockState.getBlock()))
            changedBlocks.add(pos.toImmutable());
    }

    private void setBlockStateWithoutUpdates(IWorldWriter worldWriter, BlockPos blockPos, BlockState blockState) {
        if (doBlockNotify) {
            worldWriter.setBlockState(blockPos, blockState, 19);
        } else {
            worldWriter.setBlockState(blockPos, blockState, 18);
        }

    }

    public final boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, T config) {
        Set<BlockPos> set = Sets.newHashSet();
        MutableBoundingBox mutableboundingbox = MutableBoundingBox.getNewBoundingBox();
        boolean flag = this.place(set, worldIn, rand, pos, mutableboundingbox);
        if (mutableboundingbox.minX > mutableboundingbox.maxX) {
            return false;
        } else {
            List<Set<BlockPos>> list = Lists.newArrayList();
            int i = 6;

            for (int j = 0; j < 6; ++j) {
                list.add(Sets.newHashSet());
            }

            VoxelShapePart voxelshapepart = new BitSetVoxelShapePart(mutableboundingbox.getXSize(), mutableboundingbox.getYSize(), mutableboundingbox.getZSize());

            try (BlockPos.PooledMutable blockpos$pooledmutableblockpos = BlockPos.PooledMutable.retain()) {
                if (flag && !set.isEmpty()) {
                    for (BlockPos blockpos : Lists.newArrayList(set)) {
                        if (mutableboundingbox.isVecInside(blockpos)) {
                            voxelshapepart.setFilled(blockpos.getX() - mutableboundingbox.minX, blockpos.getY() - mutableboundingbox.minY, blockpos.getZ() - mutableboundingbox.minZ, true, true);
                        }

                        for (Direction direction : Direction.values()) {
                            blockpos$pooledmutableblockpos.setPos(blockpos).move(direction);
                            if (!set.contains(blockpos$pooledmutableblockpos)) {
                                BlockState blockstate = worldIn.getBlockState(blockpos$pooledmutableblockpos);
                                if (blockstate.has(BlockStateProperties.DISTANCE_1_7)) {
                                    list.get(0).add(blockpos$pooledmutableblockpos.toImmutable());
                                    this.setBlockStateWithoutUpdates(worldIn, blockpos$pooledmutableblockpos, blockstate.with(BlockStateProperties.DISTANCE_1_7, Integer.valueOf(1)));
                                    if (mutableboundingbox.isVecInside(blockpos$pooledmutableblockpos)) {
                                        voxelshapepart.setFilled(blockpos$pooledmutableblockpos.getX() - mutableboundingbox.minX, blockpos$pooledmutableblockpos.getY() - mutableboundingbox.minY, blockpos$pooledmutableblockpos.getZ() - mutableboundingbox.minZ, true, true);
                                    }
                                }
                            }
                        }
                    }
                }

                for (int l = 1; l < 6; ++l) {
                    Set<BlockPos> set1 = list.get(l - 1);
                    Set<BlockPos> set2 = list.get(l);

                    for (BlockPos blockpos1 : set1) {
                        if (mutableboundingbox.isVecInside(blockpos1)) {
                            voxelshapepart.setFilled(blockpos1.getX() - mutableboundingbox.minX, blockpos1.getY() - mutableboundingbox.minY, blockpos1.getZ() - mutableboundingbox.minZ, true, true);
                        }

                        for (Direction direction1 : Direction.values()) {
                            blockpos$pooledmutableblockpos.setPos(blockpos1).move(direction1);
                            if (!set1.contains(blockpos$pooledmutableblockpos) && !set2.contains(blockpos$pooledmutableblockpos)) {
                                BlockState blockstate1 = worldIn.getBlockState(blockpos$pooledmutableblockpos);
                                if (blockstate1.has(BlockStateProperties.DISTANCE_1_7)) {
                                    int k = blockstate1.get(BlockStateProperties.DISTANCE_1_7);
                                    if (k > l + 1) {
                                        BlockState blockstate2 = blockstate1.with(BlockStateProperties.DISTANCE_1_7, Integer.valueOf(l + 1));
                                        this.setBlockStateWithoutUpdates(worldIn, blockpos$pooledmutableblockpos, blockstate2);
                                        if (mutableboundingbox.isVecInside(blockpos$pooledmutableblockpos)) {
                                            voxelshapepart.setFilled(blockpos$pooledmutableblockpos.getX() - mutableboundingbox.minX, blockpos$pooledmutableblockpos.getY() - mutableboundingbox.minY, blockpos$pooledmutableblockpos.getZ() - mutableboundingbox.minZ, true, true);
                                        }

                                        set2.add(blockpos$pooledmutableblockpos.toImmutable());
                                    }
                                }
                            }
                        }
                    }
                }
            }

            Template.func_222857_a(worldIn, 3, voxelshapepart, mutableboundingbox.minX, mutableboundingbox.minY, mutableboundingbox.minZ);
            return flag;
        }
    }

    public abstract boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos position, MutableBoundingBox boundsIn);

    public IPlantable getSapling() {
        return sapling;
    }

    public BYGTreeFeatureHelper<T> setSapling(net.minecraftforge.common.IPlantable sapling) {
        this.sapling = sapling;
        return this;
    }
}