package voronoiaoc.byg.common.world.feature.features.overworld.trees.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;
import net.minecraft.block.*;
import net.minecraft.state.property.Properties;
import net.minecraft.structure.Structure;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.*;
import net.minecraft.util.shape.BitSetVoxelSet;
import net.minecraft.util.shape.VoxelSet;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.ModifiableWorld;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.List;
import java.util.Random;
import java.util.Set;

public abstract class BYGAbstractTreeFeature<T extends DefaultFeatureConfig> extends Feature<T> {
    public static boolean doBlockNotify;

    public BYGAbstractTreeFeature(Codec<T> function) {
        super(function);
    }

    public static boolean canTreePlaceHere(TestableWorld worldReader, BlockPos blockPos) {
            return worldReader.testBlockState(blockPos, (state) -> {
                Block block = state.getBlock();
                return state.isAir() || state.isIn(BlockTags.LEAVES) || block == Blocks.GRASS_BLOCK || state.getMaterial() == Material.SOIL || block.isIn(BlockTags.LOGS) || block.isIn(BlockTags.SAPLINGS) || block == Blocks.VINE || block == BYGBlockList.OVERGROWN_STONE || block == BYGBlockList.MAHOGANY_LOG || block == BYGBlockList.MAHOGANY_LEAVES || block == BYGBlockList.GLOWCELIUM;
            });
    }

    //Qualifies Tree Placement in Water
    public static boolean canTreePlaceHereWater(TestableWorld worldReader, BlockPos blockPos) {
        return worldReader.testBlockState(blockPos, (state) -> {
            Block block = state.getBlock();
            return state.isAir() || state.isIn(BlockTags.LEAVES) || block == Blocks.GRASS_BLOCK || Feature.isDirt(block) || block.isIn(BlockTags.LOGS) || block.isIn(BlockTags.SAPLINGS) || block == Blocks.VINE || block == BYGBlockList.OVERGROWN_STONE || block == BYGBlockList.GLOWCELIUM || block == Blocks.WATER;
        });
    }

    public static void setGroundBlock(ModifiableTestableWorld reader, Block block, BlockPos... positions) {
        for (BlockPos pos : positions) {
            reader.setBlockState(pos.offset(Direction.DOWN), block.getDefaultState(), 2);
        }
    }

    public static boolean isQualifiedForLog(TestableWorld worldReader, BlockPos blockPos) {
        return worldReader.testBlockState(blockPos, (state) -> state.isAir() || state.isIn(BlockTags.LEAVES));
    }

    public static boolean isQualifiedForLogWater(TestableWorld worldReader, BlockPos blockPos) {
        return worldReader.testBlockState(blockPos, (state) -> state.isAir() || state.isIn(BlockTags.LEAVES) || state.getBlock() == Blocks.WATER);
    }
    
    protected static boolean isAir(TestableWorld worldIn, BlockPos pos) {
            return worldIn.testBlockState(pos, AbstractBlock.AbstractBlockState::isAir);
    }

    public static boolean isAirOrWater(TestableWorld worldIn, BlockPos pos) {
        return worldIn.testBlockState(pos, (state) -> state.isAir() || state.getBlock() == Blocks.WATER);
    }

    public static boolean isDesiredGround(TestableWorld worldIn, BlockPos pos, Block... desiredGroundBlock) {
        return worldIn.testBlockState(pos, (state) -> {
            Block block = state.getBlock();
            for (Block block1 : desiredGroundBlock) {
                return state.getMaterial() == Material.SOIL || block == block1 ;
            }
            return false;
        });
    }

    protected boolean doesTreeFit(TestableWorld reader, BlockPos blockPos, int height, int distance) {
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        BlockPos.Mutable position = new BlockPos.Mutable();

        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {

            for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
                for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
                    if (!canTreePlaceHere(reader, position.set(x + xOffset, y + yOffset, z + zOffset))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    protected void setBlockState(ModifiableWorld worldIn, BlockPos pos, BlockState state) {
        this.setBlockStateWithoutUpdates(worldIn, pos, state);
    }

    protected final void setFinalBlockState(Set<BlockPos> changedBlocks, ModifiableWorld worldIn, BlockPos pos, BlockState blockState, BlockBox boundingBox) {
        if (blockState == null)
            throw new NullPointerException(blockState + " is missing!");
        else{
            this.setBlockStateWithoutUpdates(worldIn, pos, blockState);
            boundingBox.encompass(new BlockBox(pos, pos));
                if (BlockTags.LOGS.contains(blockState.getBlock())) {
                    changedBlocks.add(pos.toImmutable());
            }
        }
    }

    private void setBlockStateWithoutUpdates(ModifiableWorld worldWriter, BlockPos blockPos, BlockState blockState) {
        if (doBlockNotify) {
            worldWriter.setBlockState(blockPos, blockState, 19);
        } else {
            worldWriter.setBlockState(blockPos, blockState, 18);
        }
    }

    @Override
    public boolean generate(ServerWorldAccess worldIn, StructureAccessor accessor, ChunkGenerator generator, Random rand, BlockPos pos, T config) {
        Set<BlockPos> set = Sets.newHashSet();
        BlockBox mutableboundingbox = BlockBox.empty();
        boolean flag = this.place(set, worldIn, rand, pos, mutableboundingbox);
        if (mutableboundingbox.minX > mutableboundingbox.maxX) {
            return false;
        } else {
            List<Set<BlockPos>> list = Lists.newArrayList();

            for (int j = 0; j < 6; ++j) {
                list.add(Sets.newHashSet());
            }

            VoxelSet voxelshapepart = new BitSetVoxelSet(mutableboundingbox.getBlockCountX(), mutableboundingbox.getBlockCountY(), mutableboundingbox.getBlockCountZ());

            try (PooledMutable blockpos$pooledmutableblockpos = PooledMutable.get()) {
                if (flag && !set.isEmpty()) {
                    for (BlockPos blockpos : Lists.newArrayList(set)) {
                        if (mutableboundingbox.contains(blockpos)) {
                            voxelshapepart.set(blockpos.getX() - mutableboundingbox.minX, blockpos.getY() - mutableboundingbox.minY, blockpos.getZ() - mutableboundingbox.minZ, true, true);
                        }

                        for (Direction direction : Direction.values()) {
                            blockpos$pooledmutableblockpos.set(blockpos).move(direction);
                            if (!set.contains(blockpos$pooledmutableblockpos)) {
                                BlockState blockstate = worldIn.getBlockState(blockpos$pooledmutableblockpos);
                                if (blockstate.contains(Properties.DISTANCE_1_7)) {
                                    list.get(0).add(blockpos$pooledmutableblockpos.toImmutable());
                                    this.setBlockStateWithoutUpdates(worldIn, blockpos$pooledmutableblockpos, blockstate.with(Properties.DISTANCE_1_7, Integer.valueOf(1)));
                                    if (mutableboundingbox.contains(blockpos$pooledmutableblockpos)) {
                                        voxelshapepart.set(blockpos$pooledmutableblockpos.getX() - mutableboundingbox.minX, blockpos$pooledmutableblockpos.getY() - mutableboundingbox.minY, blockpos$pooledmutableblockpos.getZ() - mutableboundingbox.minZ, true, true);
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
                        if (mutableboundingbox.contains(blockpos1)) {
                            voxelshapepart.set(blockpos1.getX() - mutableboundingbox.minX, blockpos1.getY() - mutableboundingbox.minY, blockpos1.getZ() - mutableboundingbox.minZ, true, true);
                        }

                        for (Direction direction1 : Direction.values()) {
                            blockpos$pooledmutableblockpos.set(blockpos1).move(direction1);
                            if (!set1.contains(blockpos$pooledmutableblockpos) && !set2.contains(blockpos$pooledmutableblockpos)) {
                                BlockState blockstate1 = worldIn.getBlockState(blockpos$pooledmutableblockpos);
                                if (blockstate1.contains(Properties.DISTANCE_1_7)) {
                                    int k = blockstate1.get(Properties.DISTANCE_1_7);
                                    if (k > l + 1) {
                                        BlockState blockstate2 = blockstate1.with(Properties.DISTANCE_1_7, l + 1);
                                        this.setBlockStateWithoutUpdates(worldIn, blockpos$pooledmutableblockpos, blockstate2);
                                        if (mutableboundingbox.contains(blockpos$pooledmutableblockpos)) {
                                            voxelshapepart.set(blockpos$pooledmutableblockpos.getX() - mutableboundingbox.minX, blockpos$pooledmutableblockpos.getY() - mutableboundingbox.minY, blockpos$pooledmutableblockpos.getZ() - mutableboundingbox.minZ, true, true);
                                        }

                                        set2.add(blockpos$pooledmutableblockpos.toImmutable());
                                    }
                                }
                            }
                        }
                    }
                }
            }

            Structure.updateCorner(worldIn, 3, voxelshapepart, mutableboundingbox.minX, mutableboundingbox.minY, mutableboundingbox.minZ);
            return flag;
        }
    }

    protected abstract boolean place(Set<BlockPos> changedBlocks, ServerWorldAccess worldIn, Random rand, BlockPos position, BlockBox boundsIn);

    public static final class PooledMutable extends BlockPos.Mutable implements AutoCloseable {
        private boolean free;
        private static final List<PooledMutable> POOL = Lists.newArrayList();

        private PooledMutable(int x, int y, int z) {
            super(x, y, z);
        }

        public static PooledMutable get() {
            return get(0, 0, 0);
        }

        public static PooledMutable get(double x, double y, double z) {
            return get(MathHelper.floor(x), MathHelper.floor(y), MathHelper.floor(z));
        }

        public static PooledMutable get(int x, int y, int z) {
            synchronized (POOL) {
                if (!POOL.isEmpty()) {
                    PooledMutable pooledMutable = POOL.remove(POOL.size() - 1);
                    if (pooledMutable != null && pooledMutable.free) {
                        pooledMutable.free = false;
                        pooledMutable.set(x, y, z);
                        return pooledMutable;
                    }
                }
            }

            return new PooledMutable(x, y, z);
        }

        public PooledMutable set(int i, int j, int k) {
            return (PooledMutable) super.set(i, j, k);
        }

        public PooledMutable set(double d, double e, double f) {
            return (PooledMutable) super.set(d, e, f);
        }

        public PooledMutable set(Vec3i vec3i) {
            return (PooledMutable) super.set(vec3i);
        }

        public PooledMutable setOffset(Direction direction) {
            return this.setOffset(direction, 1);
        }

        public PooledMutable setOffset(Direction direction, int distance) {
            return this.set(this.getX() + direction.getOffsetX() * distance, this.getY() + direction.getOffsetY() * distance, this.getZ() + direction.getOffsetZ() * distance);
        }

        public Mutable setOffset(int x, int y, int z) {
            return this.set(this.getX() + x, this.getY() + y, this.getZ() + z);
        }

        public void close() {
            synchronized (POOL) {
                if (POOL.size() < 100) {
                    POOL.add(this);
                }

                this.free = true;
            }
        }
    }
}