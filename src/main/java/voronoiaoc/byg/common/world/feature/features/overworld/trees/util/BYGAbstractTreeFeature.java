package voronoiaoc.byg.common.world.feature.features.overworld.trees.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.state.property.Properties;
import net.minecraft.structure.Structure;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.*;
import net.minecraft.util.shape.BitSetVoxelSet;
import net.minecraft.util.shape.VoxelSet;
import net.minecraft.world.ModifiableWorld;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.TestableWorld;
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

    public static boolean canLogPlaceHere(TestableWorld worldReader, BlockPos blockPos) {
        return worldReader.testBlockState(blockPos, (state) -> state.isAir() || state.isIn(BlockTags.LEAVES) || state.getMaterial() == Material.PLANT || state.getMaterial() == Material.REPLACEABLE_PLANT || state.getMaterial() == Material.UNDERWATER_PLANT);
    }

    public boolean canLogPlaceHereWater(TestableWorld worldReader, BlockPos blockPos) {
        return worldReader.testBlockState(blockPos, (state) -> state.isAir() || state.isIn(BlockTags.LEAVES) || state.getMaterial() == Material.PLANT || state.getMaterial() == Material.REPLACEABLE_PLANT || state.getMaterial() == Material.UNDERWATER_PLANT || state.getMaterial() == Material.WATER);
    }

    public boolean isAnotherTreeHere(TestableWorld worldReader, BlockPos blockPos) {
        return worldReader.testBlockState(blockPos, (state) -> {
            Block block = state.getBlock();
            return block.isIn(BlockTags.LOGS) || block.isIn(BlockTags.LEAVES);
        });
    }

    public boolean isAnotherTreeLikeThisHere(TestableWorld worldReader, BlockPos blockPos, Block logBlock, Block leafBlock) {
        return worldReader.testBlockState(blockPos, (state) -> {
            Block block = state.getBlock();
            return block == logBlock || block == leafBlock;
        });
    }


    /**
     * We use this to determine if a sapling's tree can grow at the given pos.
     * This is likely if not guaranteed to be used in a for loop checking the surrounding in another method as it's useless like this.
     *
     * @param reader Gives us access to world.
     * @param pos    Position to check.
     * @return Determine whether or not the pos can support a sapling's tree.
     */
    public boolean canSaplingGrowHere(TestableWorld reader, BlockPos pos) {
        return reader.testBlockState(pos, (state) -> {
            Block block = state.getBlock();
            return block.isIn(BlockTags.LOGS) || block.isIn(BlockTags.LEAVES) || state.isAir() || state.getMaterial() == Material.PLANT || state.getMaterial() == Material.REPLACEABLE_PLANT || state.getMaterial() == Material.UNDERWATER_PLANT || state.getMaterial() == Material.LEAVES || state.getMaterial() == Material.SOIL;
        });
    }

    /**
     * @param reader Gives us access to world.
     * @param pos    Position to check.
     * @return Determines whether or not a pos is air.
     */

    public static boolean isAir(TestableWorld reader, BlockPos pos) {
        return reader.testBlockState(pos, BlockState::isAir);
    }

    public boolean isAirOrWater(TestableWorld worldIn, BlockPos pos) {
        return worldIn.testBlockState(pos, (state) -> state.isAir() || state.getBlock() == Blocks.WATER);
    }

    /**
     * @param reader             Gives us access to world.
     * @param pos                Position to check.
     * @param desiredGroundBlock Allows to add other blocks that do not have the dirt tag.
     * @return Determines if the pos is of the dirt tag or another block.
     */
    public static boolean isDesiredGroundwDirtTag(TestableWorld reader, BlockPos pos, Block... desiredGroundBlock) {
        return reader.testBlockState(pos, (state) -> {
            Block block = state.getBlock();
            for (Block block1 : desiredGroundBlock) {
                return Feature.isSoil(block) || block == block1;
            }
            return false;
        });
    }

    /**
     * @param reader             Gives us access to world.
     * @param pos                Position to check.
     * @param desiredGroundBlock Add a blacklist of blocks that we want.
     * @return Determines if the pos contains a block from our whitelist.
     */
    public boolean isDesiredGround(TestableWorld reader, BlockPos pos, Block... desiredGroundBlock) {
        return reader.testBlockState(pos, (state) -> {
            Block block = state.getBlock();
            for (Block block1 : desiredGroundBlock) {
                return block == block1;
            }
            return false;
        });
    }

    /**
     * Use this method if the canopy has a mirrored shape on both the X/Z axises.
     * Only used during sapling growth.
     *
     * @param reader            Gives us access to world.
     * @param pos               The start pos of the feature from the decorator/pos of the sapling.
     * @param treeHeight        The height of the tree trunk determined within the feature. Typically a random number.
     * @param canopyStartHeight The start height at which leaves begin to generate. I.E: "randTreeHeight - 15".
     * @param xDistance         Used to check the canopy's X offset blocks.
     * @param zDistance         Used to check the canopy's Z offset blocks.
     * @param isSapling         Boolean Passed in to determine whether or not the tree is being generated during world gen or with a sapling.
     * @param trunkPositions    Typically this is going to be the bottom most logs of the trunks for the tree.
     * @return Determine Whether or not a sapling can grow at the given pos by checking the surrounding area.
     */

    public boolean doesSaplingHaveSpaceToGrow(TestableWorld reader, BlockPos pos, int treeHeight, int canopyStartHeight, int xDistance, int zDistance, boolean isSapling, BlockPos... trunkPositions) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        //Skip if this is not a sapling.
        if (isSapling) {
            //Check the tree trunk and determine whether or not there's a block in the way.
            for (int yOffSet = 0; yOffSet <= treeHeight; yOffSet++) {
                if (!canSaplingGrowHere(reader, mutable.set(x, y + yOffSet, z))) {
                    return false;
                }
                //If the list of trunk poss(other than the center trunk) is greater than 0, we check each of these trunk poss from the bottom to the tree height.
                if (trunkPositions.length > 0) {
                    for (BlockPos trunkPos : trunkPositions) {
                        if (!canSaplingGrowHere(reader, mutable.set(trunkPos.getX(), trunkPos.getY() + yOffSet, trunkPos.getZ()))) {
                            return false;
                        }
                    }
                }
            }
            //We use canopyStartHeight instead of 0 because we want to check the area only in the canopy's area and not around the trunk. This makes our saplings much smarter and easier to grow.
            for (int yOffset = canopyStartHeight; yOffset <= treeHeight + 1; ++yOffset) {
                for (int xOffset = -xDistance; xOffset <= xDistance; ++xOffset) {
                    for (int zOffset = -zDistance; zOffset <= zDistance; ++zOffset) {
                        if (!canSaplingGrowHere(reader, mutable.set(x + xOffset, y + yOffset, z + zOffset))) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * Use this method instead of the previous if the canopy does not have a mirror shape on the X/Z axises.
     * Only used during sapling growth.
     *
     * @param reader            Gives us access to world.
     * @param pos               The start pos of the feature from the decorator/pos of the sapling.
     * @param treeHeight        The height of the given tree.
     * @param canopyStartHeight The start height at which leaves begin to generate. I.E: "randTreeHeight - 15".
     * @param xNegativeDistance Used to check the canopy's negative X offset blocks.
     * @param zNegativeDistance Used to check the canopy's negative Z offset blocks.
     * @param xPositiveDistance Used to check the canopy's positive x offset blocks.
     * @param zPositiveDistance Used to check the canopy's positive Z offset blocks.
     * @param isSapling         Boolean passed in to determine whether or not the tree is being generated during world gen or with a sapling.
     * @param trunkPositions    Typically this is going to be the bottom most logs of the trunk for the tree.
     * @return Determine Whether or not a sapling can grow at the given pos by checking the surrounding area.
     */

    public boolean doesSaplingHaveSpaceToGrow(TestableWorld reader, BlockPos pos, int treeHeight, int canopyStartHeight, int xNegativeDistance, int zNegativeDistance, int xPositiveDistance, int zPositiveDistance, boolean isSapling, BlockPos... trunkPositions) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        //Skip if tree is being called during world gen.
        if (isSapling) {

            //Check the tree trunk and determine whether or not there's a block in the way.
            for (int yOffSet = 0; yOffSet <= treeHeight; yOffSet++) {
                if (!canSaplingGrowHere(reader, mutable.set(x, y + yOffSet, z))) {
                    return false;
                }

                //If the list of trunk poss(other than the center trunk) is greater than 0, we check each of these trunk poss from the bottom to the tree height.
                if (trunkPositions.length > 0) {
                    for (BlockPos trunkPos : trunkPositions) {
                        if (!canSaplingGrowHere(reader, mutable.set(trunkPos.getX(), trunkPos.getY() + yOffSet, trunkPos.getZ()))) {
                            return false;
                        }
                    }
                }
            }

            //We use canopyStartHeight instead of 0 because we want to check the area only in the canopy's area and not around the trunk. This makes our saplings much smarter and easier to grow.
            for (int yOffset = canopyStartHeight; yOffset <= treeHeight + 1; ++yOffset) {
                for (int xOffset = -xNegativeDistance; xOffset <= xPositiveDistance; ++xOffset) {
                    for (int zOffset = -zNegativeDistance; zOffset <= zPositiveDistance; ++zOffset) {
                        if (!canSaplingGrowHere(reader, mutable.set(x + xOffset, y + yOffset, z + zOffset))) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * Checks the area surrounding the pos for any blocks using either the log or leaves tag.
     * Called only during world gen.
     *
     * @param reader     Gives us access to world
     * @param pos        The given pos of either the feature during world gen or the sapling.
     * @param treeHeight The height of the given tree.
     * @param distance   Checks the surrounding pos
     * @param isSapling  Boolean passed in to determine whether or not the tree is being generated during world gen or with a sapling.
     * @return Determines whether or not any tree is within the givem distance
     */
    public boolean isAnotherTreeNearby(TestableWorld reader, BlockPos pos, int treeHeight, int distance, boolean isSapling) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        //Skip if tree is being spawned with a sapling.
        if (!isSapling) {
            for (int yOffset = 0; yOffset <= treeHeight + 1; ++yOffset) {
                for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
                    for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
                        if (isAnotherTreeHere(reader, mutable.set(x + xOffset, y + yOffset, z + zOffset))) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * Checks the area surrounding the pos for a tree matching its wood/leaves block.
     * Called only during world gen
     *
     * @param reader     Gives us access to world
     * @param pos        The given pos of either the feature during world gen or the sapling.
     * @param treeHeight The height of the given tree.
     * @param distance   Checks the surrounding pos
     * @param logBlock   The log block we're checking for.
     * @param leafBlock  The leaf block we're checking for.
     * @param isSapling  Boolean passed in to determine whether or not the tree is being generated during world gen or with a sapling.
     * @return Determines whether or not the tree we're searching for is within the given distance.
     */

    public boolean isAnotherTreeLikeThisNearby(TestableWorld reader, BlockPos pos, int treeHeight, int distance, Block logBlock, Block leafBlock, boolean isSapling) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        //Skip if tree is being spawned with a sapling.
        if (!isSapling) {
            for (int yOffset = 0; yOffset <= treeHeight + 1; ++yOffset) {
                for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
                    for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
                        if (!isAnotherTreeLikeThisHere(reader, mutable.set(x + xOffset, y + yOffset, z + zOffset), logBlock, leafBlock)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * Use this to set the soil under large trunked trees. I.E: Baobab or Redwood.
     *
     * @param treeBlocksSet  Gives us access to the tree block set where we add our trees blocks.
     * @param reader         Gives us access to world
     * @param fillerBlock    Typically this is the log of the tree we're trying to fill the base of.
     * @param earthBlock     The block used under logs. Typically a block found in the dirt tag
     * @param boundingBox    Bounding Box of our tree.
     * @param trunkPositions List of trunk poss where the base is built under the given poss.
     */

    public void buildTrunk(Set<BlockPos> treeBlocksSet, TestableWorld reader, Block fillerBlock, Block earthBlock, BlockBox boundingBox, BlockPos... trunkPositions) {
        if (trunkPositions.length > 0) {
            BlockPos.Mutable mutableTrunk = new BlockPos.Mutable();
            for (BlockPos trunkPos : trunkPositions) {
                mutableTrunk.set(trunkPos);
                for (int fill = 1; fill <= 15; fill++) {
                    if (canLogPlaceHere(reader, mutableTrunk)) {
                        if (fill <= 7)
                            setFinalBlockState(treeBlocksSet, (ModifiableWorld) reader, mutableTrunk, fillerBlock.getDefaultState(), boundingBox);
                        else
                            setFinalBlockState(treeBlocksSet, (ModifiableWorld) reader, mutableTrunk, earthBlock.getDefaultState(), boundingBox);
                    } else {
                        if (isDesiredGround(reader, mutableTrunk, Blocks.PODZOL, Blocks.MYCELIUM, BYGBlockList.PODZOL_DACITE, BYGBlockList.OVERGROWN_STONE, BYGBlockList.GLOWCELIUM))
                            setFinalBlockState(treeBlocksSet, (ModifiableWorld) reader, mutableTrunk, earthBlock.getDefaultState(), boundingBox);
                        fill = 15;
                    }
                    mutableTrunk.move(Direction.DOWN);
                }
            }
        }
    }

    /**
     * Use this to set the soil under large trunked trees. Has an extra parameter to specify when the earth block should start placing. I.E: Baobab or Redwood.
     *
     * @param treeBlocksSet       Gives us access to the tree block set where we add our trees blocks.
     * @param reader              Gives us access to world
     * @param earthBlockThreshold Used to specify when earthBlock starts placing.
     * @param fillerBlock         Typically this is the log of the tree we're trying to fill the base of.
     * @param earthBlock          The block used under logs. Typically a block found in the dirt tag
     * @param boundingBox         Bounding Box of our tree.
     * @param trunkPositions      List of trunk poss where the base is built under the given poss.
     */
    public void buildBase(Set<BlockPos> treeBlocksSet, TestableWorld reader, int earthBlockThreshold, Block fillerBlock, Block earthBlock, BlockBox boundingBox, BlockPos... trunkPositions) {
        if (trunkPositions.length > 0) {
            BlockPos.Mutable mutableTrunk = new BlockPos.Mutable();
            for (BlockPos trunkPos : trunkPositions) {
                mutableTrunk.set(trunkPos);
                for (int fill = 1; fill <= 15; fill++) {
                    if (canLogPlaceHere(reader, mutableTrunk)) {
                        if (fill <= earthBlockThreshold)
                            setFinalBlockState(treeBlocksSet, (ModifiableWorld) reader, mutableTrunk, fillerBlock.getDefaultState(), boundingBox);
                        else
                            setFinalBlockState(treeBlocksSet, (ModifiableWorld) reader, mutableTrunk, earthBlock.getDefaultState(), boundingBox);
                    } else {
                        if (canLogPlaceHere(reader, mutableTrunk)) {
                            setFinalBlockState(treeBlocksSet, (ModifiableWorld) reader, mutableTrunk, fillerBlock.getDefaultState(), boundingBox);
                        } else {
                            if (isDesiredGround(reader, mutableTrunk, Blocks.PODZOL, Blocks.MYCELIUM, BYGBlockList.PODZOL_DACITE, BYGBlockList.OVERGROWN_STONE, BYGBlockList.GLOWCELIUM))
                                setFinalBlockState(treeBlocksSet, (ModifiableWorld) reader, mutableTrunk, earthBlock.getDefaultState(), boundingBox);
                            fill = 15;
                        }
                    }
                    mutableTrunk.move(Direction.DOWN);
                }
            }
        }
    }

    /**
     * Use this to set the soil under small trunked trees.
     */

    public void setSoil(Set<BlockPos> treeBlocksSet, TestableWorld reader, Block soil, BlockBox boundingBox, BlockPos... trunkPositions) {
        if (trunkPositions.length > 0) {
            BlockPos.Mutable mutableTrunk = new BlockPos.Mutable();
            for (BlockPos trunkPos : trunkPositions) {
                mutableTrunk.set(trunkPos);
                if (isDesiredGround(reader, mutableTrunk, Blocks.PODZOL, Blocks.MYCELIUM, BYGBlockList.PODZOL_DACITE, BYGBlockList.OVERGROWN_STONE, BYGBlockList.GLOWCELIUM))
                    setFinalBlockState(treeBlocksSet, (ModifiableWorld) reader, mutableTrunk.move(Direction.DOWN), soil.getDefaultState(), boundingBox);
            }
        }
    }

    public final void setFinalBlockState(Set<BlockPos> treeBlockSet, ModifiableWorld worldIn, BlockPos pos, BlockState blockState, BlockBox boundingBox) {
        this.setBlockStateWithoutUpdates(worldIn, pos, blockState);
        boundingBox.encompass(new BlockBox(pos, pos));
        if (BlockTags.LOGS.contains(blockState.getBlock())) {
            treeBlockSet.add(pos.toImmutable());
        }
    }

    public void setBlockStateWithoutUpdates(ModifiableWorld worldWriter, BlockPos blockPos, BlockState blockState) {
        worldWriter.setBlockState(blockPos, blockState, 18);
    }

    @Override
    public void setBlockState(ModifiableWorld worldIn, BlockPos pos, BlockState state) {
        this.setBlockStateWithoutUpdates(worldIn, pos, state);
    }

    @Override
    public boolean generate(StructureWorldAccess world, ChunkGenerator chunkGenerator, Random random, BlockPos blockPos, T featureConfig) {
        return this.placeTree(world, chunkGenerator, random, blockPos, featureConfig, false);
    }

    public boolean placeTree(StructureWorldAccess worldIn, ChunkGenerator generator, Random rand, BlockPos pos, T config, boolean isSapling) {
        Set<BlockPos> set = Sets.newHashSet();
        BlockBox mutableboundingbox = BlockBox.empty();
        boolean flag = this.place(set, worldIn, rand, pos, mutableboundingbox, isSapling);
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

    protected abstract boolean place(Set<BlockPos> changedBlocks, StructureWorldAccess worldIn, Random rand, BlockPos pos, BlockBox boundsIn, boolean isSapling);

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