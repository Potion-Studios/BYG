package corgiaoc.byg.common.world.feature.overworld.trees.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;
import corgiaoc.byg.BYG;
import corgiaoc.byg.common.properties.EtherBulbsBlock;
import corgiaoc.byg.common.properties.blocks.BaobabFruitBlock;
import corgiaoc.byg.common.properties.blocks.end.impariusgrove.ImpariusMushroomBranchBlock;
import corgiaoc.byg.common.world.feature.FeatureUtil;
import corgiaoc.byg.common.world.feature.config.BYGTreeConfig;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.util.MLBlockTags;
import corgiaoc.byg.util.noise.fastnoise.FastNoise;
import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.math.shapes.BitSetVoxelShapePart;
import net.minecraft.util.math.shapes.VoxelShapePart;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorldWriter;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.template.Template;

import java.util.*;

public abstract class BYGAbstractTreeFeature<TFC extends BYGTreeConfig> extends Feature<TFC> {

    protected static FastNoise fastNoise;
    protected long seed;

    public static final Map<Block, Block> SPREADABLE_TO_NON_SPREADABLE = new HashMap<>();

    public BYGAbstractTreeFeature(Codec<TFC> configCodec) {
        super(configCodec);
    }

    public static boolean canLogPlaceHere(IWorldGenerationBaseReader worldReader, BlockPos blockPos) {
        return worldReader.isStateAtPosition(blockPos, (state) -> state.getMaterial() == Material.AIR || state.getMaterial() == Material.WATER) || FeatureUtil.isPlant(worldReader, blockPos);
    }

    public boolean canLogPlaceHereWater(IWorldGenerationBaseReader worldReader, BlockPos blockPos) {
        return worldReader.isStateAtPosition(blockPos, (state) -> state.getMaterial() == Material.AIR || state.getMaterial() == Material.WATER) || FeatureUtil.isPlant(worldReader, blockPos);
    }

    public boolean canLogPlaceHereNether(IWorldGenerationBaseReader worldReader, BlockPos blockPos) {
        return worldReader.isStateAtPosition(blockPos, (state) -> state.getMaterial() == Material.AIR || state.getMaterial() == Material.WATER || state.getMaterial() == Material.LAVA) || FeatureUtil.isPlant(worldReader, blockPos);
    }

    public boolean isAnotherTreeHere(IWorldGenerationBaseReader worldReader, BlockPos blockPos) {
        return worldReader.isStateAtPosition(blockPos, (state) -> {
            Block block = state.getBlock();
            return block.is(BlockTags.LOGS) || block.is(BlockTags.LEAVES);
        });
    }

    public boolean isAnotherTreeLikeThisHere(IWorldGenerationBaseReader worldReader, BlockPos blockPos, Block logBlock, Block leafBlock) {
        return worldReader.isStateAtPosition(blockPos, (state) -> {
            Block block = state.getBlock();
            return block == logBlock || block == leafBlock;
        });
    }

    public void placeTrunk(BlockPos startPos, BYGTreeConfig config, Random random, Set<BlockPos> blockSet, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        pos = getTransformedPos(config, startPos, pos);
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(startPos, config, blockSet, reader, pos, config.getTrunkProvider().getState(random, pos), boundingBox);
        }
    }

    public void placeBranch(BlockPos startPos, BYGTreeConfig config, Random random, Set<BlockPos> blockSet, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        pos = getTransformedPos(config, startPos, pos);
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(startPos, config, blockSet, reader, pos, config.getTrunkProvider().getState(random, pos), boundingBox);
        }
    }

    public void placeLeaves(BlockPos startPos, BYGTreeConfig config, Random random, Set<BlockPos> blockSet, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        pos = getTransformedPos(config, startPos, pos);
        if (isAir(reader, pos)) {
            this.setFinalBlockState(startPos, config, blockSet, reader, pos, config.getLeavesProvider().getState(random, pos), boundingBox);
        }
    }

    //TODO: Make all our trees use the method above.
    public void placeLeaves(BlockPos startPos, BYGTreeConfig config, Random random, ISeedReader reader, int x, int y, int z, MutableBoundingBox boundingBox, Set<BlockPos> blockPos) {
        BlockPos pos = new BlockPos(x, y, z);
        pos = getTransformedPos(config, startPos, pos);

        if (isAir(reader, pos)) {
            this.setFinalBlockState(startPos, config, blockPos, reader, pos, config.getLeavesProvider().getState(random, pos), boundingBox);
        }
    }


    public static BlockPos getTransformedPos(BYGTreeConfig config, BlockPos startPos, BlockPos pos) {
        Rotation rotation = config.getRotation();
        Mirror mirror = config.getMirror();
        BlockPos blockPos = FeatureUtil.extractOffset(startPos, pos);
        if (blockPos instanceof BlockPos.Mutable) {
            FeatureUtil.transformMutable((BlockPos.Mutable) blockPos, mirror, rotation);
            ((BlockPos.Mutable) blockPos).move(startPos.getX(), 0, startPos.getZ());
            return blockPos;
        }

        return FeatureUtil.transform(blockPos, mirror, rotation).offset(startPos.getX(), 0, startPos.getZ());
    }

    public void etherBulbs(BlockPos startPos, BYGTreeConfig config, Random random, Set<BlockPos> blockSet, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        pos = getTransformedPos(config, startPos, pos);
        this.setFinalBlockState(startPos, config, blockSet, reader, pos, BYGBlocks.ETHER_BULB.defaultBlockState().setValue(EtherBulbsBlock.AGE, random.nextInt(4)), boundingBox);
    }

    public void ArisianBloomBranch(BlockPos startPos, BYGTreeConfig config, Random random, Set<BlockPos> blockSet, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox, Direction direction) {
        pos = getTransformedPos(config, startPos, pos);
        this.setFinalBlockState(startPos, config, blockSet, reader, pos, BYGBlocks.ARISIAN_BLOOM_BRANCH.defaultBlockState().setValue(ImpariusMushroomBranchBlock.FACING, direction), boundingBox);
    }

    public void baobabFruit(BlockPos startPos, BYGTreeConfig config, Random random, Set<BlockPos> blockSet, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        pos = getTransformedPos(config, startPos, pos);
        if (isAir(reader, pos) && reader.getBlockState(pos.above()).getBlock() == BYGBlocks.BAOBAB_LEAVES) {
            this.setFinalBlockState(startPos, config, blockSet, reader, pos, BYGBlocks.BAOBAB_FRUIT_BLOCK.defaultBlockState().setValue(BaobabFruitBlock.AGE, random.nextInt(4)), boundingBox);
        }
    }

    public void placeNetherTrunk(BlockPos startPos, BYGTreeConfig config, Random random, Set<BlockPos> blockSet, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        pos = getTransformedPos(config, startPos, pos);
        if (canLogPlaceHereNether(reader, pos)) {
            this.setFinalBlockState(startPos, config, blockSet, reader, pos, config.getTrunkProvider().getState(random, pos), boundingBox);
        }
    }

    public void placeNetherBranch(BlockPos startPos, BYGTreeConfig config, Random random, Set<BlockPos> blockSet, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        pos = getTransformedPos(config, startPos, pos);
        if (canLogPlaceHereNether(reader, pos)) {
            this.setFinalBlockState(startPos, config, blockSet, reader, pos, config.getTrunkProvider().getState(random, pos), boundingBox);
        }
    }


    /**
     * We use this to determine if a sapling's tree can grow at the given pos.
     * This is likely if not guaranteed to be used in a for loop checking the surrounding in another method as it's useless like this.
     *
     * @param reader Gives us access to world.
     * @param pos    Position to check.
     * @return Determine whether or not the pos can support a sapling's tree.
     */
    public boolean canSaplingGrowHere(IWorldGenerationBaseReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, (state) -> {
            Block block = state.getBlock();
            return block.is(BlockTags.LOGS) || block.is(BlockTags.LEAVES) || state.isAir() || state.getMaterial() == Material.PLANT || state.getMaterial() == Material.REPLACEABLE_PLANT || state.getMaterial() == Material.WATER_PLANT || state.getMaterial() == Material.LEAVES || state.getMaterial() == Material.DIRT;
        });
    }

    /**
     * @param reader Gives us access to world.
     * @param pos    Position to check.
     * @return Determines whether or not a pos is air.
     */

    public static boolean isAir(IWorldGenerationBaseReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, BlockState::isAir);
    }

    public boolean isAirOrWater(IWorldGenerationBaseReader worldIn, BlockPos pos) {
        return worldIn.isStateAtPosition(pos, (state) -> state.isAir() || state.getBlock() == Blocks.WATER);
    }

    /**
     * @param reader Gives us access to world.
     * @param pos    Position to check.
     * @param config Allows to add other blocks that do not have the dirt tag.
     * @return Determines if the pos is of the dirt tag or another block.
     */
    public static boolean isDesiredGroundwDirtTag(IWorldGenerationBaseReader reader, BlockPos pos, BYGTreeConfig config) {
        if (config.isPlacementForced())
            return true;

        return reader.isStateAtPosition(pos, (state) -> {
            Block block = state.getBlock();
            for (Block block1 : config.getWhitelist()) {
                return block.is(MLBlockTags.DIRT) || block == block1;
            }
            return block.is(MLBlockTags.DIRT);
        });
    }

    public static boolean isDesiredGroundwNetherTags(IWorldGenerationBaseReader reader, BlockPos pos, BYGTreeConfig config) {
        if (config.isPlacementForced())
            return true;

        return reader.isStateAtPosition(pos, (state) -> {
            Block block = state.getBlock();
            for (Block block1 : config.getWhitelist()) {
                return block.is(MLBlockTags.NETHERRACK) || block.is(BlockTags.NYLIUM) || block.is(BlockTags.SOUL_FIRE_BASE_BLOCKS) || block == block1;
            }
            return block.is(MLBlockTags.NETHERRACK) || block.is(BlockTags.NYLIUM) || block.is(BlockTags.SOUL_FIRE_BASE_BLOCKS);
        });
    }

    public static boolean isDesiredGroundwEndTags(IWorldGenerationBaseReader reader, BlockPos pos, BYGTreeConfig config) {
        if (config.isPlacementForced())
            return true;

        return reader.isStateAtPosition(pos, (state) -> {
            Block block = state.getBlock();
            for (Block block1 : config.getWhitelist()) {
                return block.is(MLBlockTags.END_STONES) || block == block1;
            }
            return block.is(MLBlockTags.END_STONES);
        });
    }

    public static boolean isDesiredGroundwSandTag(IWorldGenerationBaseReader reader, BlockPos pos, BYGTreeConfig config) {
        if (config.isPlacementForced())
            return true;

        return reader.isStateAtPosition(pos, (state) -> {
            Block block = state.getBlock();
            for (Block block1 : config.getWhitelist()) {
                return block.is(BlockTags.SAND) || block == block1;
            }
            return block.is(BlockTags.SAND);
        });
    }

    /**
     * @param reader             Gives us access to world.
     * @param pos                Position to check.
     * @param desiredGroundBlock Add a blacklist of blocks that we want.
     * @return Determines if the pos contains a block from our whitelist.
     */
    public boolean isDesiredGround(IWorldGenerationBaseReader reader, BlockPos pos, Block... desiredGroundBlock) {
        return reader.isStateAtPosition(pos, (state) -> {
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

    public boolean doesSaplingHaveSpaceToGrow(IWorldGenerationBaseReader reader, BlockPos pos, int treeHeight, int canopyStartHeight, int xDistance, int zDistance, boolean isSapling, BlockPos... trunkPositions) {
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
                //If the list of trunk positions(other than the center trunk) is greater than 0, we check each of these trunk positions from the bottom to the tree height.
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

    public boolean doesSaplingHaveSpaceToGrow(IWorldGenerationBaseReader reader, BlockPos pos, int treeHeight, int canopyStartHeight, int xNegativeDistance, int zNegativeDistance, int xPositiveDistance, int zPositiveDistance, boolean isSapling, BlockPos... trunkPositions) {
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

                //If the list of trunk pos(other than the center trunk) is greater than 0, we check each of these trunk pos from the bottom to the tree height.
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
     * Checks the area surrounding the position for any blocks using either the log or leaves tag.
     * <p>
     * Called only during world gen.
     *
     * @param reader     Gives us access to world
     * @param pos        The given pos of either the feature during world gen or the sapling.
     * @param treeHeight The height of the given tree.
     * @param distance   Checks the surrounding pos
     * @param isSapling  Boolean passed in to determine whether or not the tree is being generated during world gen or with a sapling.
     * @return Determines whether or not any tree is within the given distance
     */
    public boolean isAnotherTreeNearby(IWorldGenerationBaseReader reader, BlockPos pos, int treeHeight, int distance, boolean isSapling) {
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

    public boolean isAnotherTreeLikeThisNearby(IWorldGenerationBaseReader reader, BlockPos pos, int treeHeight, int distance, Block logBlock, Block leafBlock, boolean isSapling) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        //Skip if tree is being spawned with a sapling.
        if (!isSapling) {
            for (int yOffset = 0; yOffset <= treeHeight + 1; ++yOffset) {
                for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
                    for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
                        if (isAnotherTreeLikeThisHere(reader, mutable.set(x + xOffset, y + yOffset, z + zOffset), logBlock, leafBlock)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean isCliff(IWorldGenerationBaseReader reader, BlockPos... trunkPositions) {
        return isCliff(reader, 5, trunkPositions);
    }


    public boolean isCliff(IWorldGenerationBaseReader reader, int checkDownRange, BlockPos... trunkPositions) {
        if (trunkPositions.length > 0) {
            BlockPos.Mutable mutable = new BlockPos.Mutable();

            for (BlockPos trunkPos : trunkPositions) {
                mutable.set(trunkPos);
                for (int moveDown = 0; moveDown <= checkDownRange; moveDown++) {
                    if (!isAirOrWater(reader, mutable) && !FeatureUtil.isPlant(reader, mutable)) {
                        break;
                    }
                    if (moveDown == checkDownRange)
                        return true;
                    mutable.move(Direction.DOWN);
                }
            }
        }
        return false;
    }

    public void buildTrunk(ISeedReader reader, BYGTreeConfig config, Random random, BlockPos operatingPos, int downRange) {
        BlockPos.Mutable mutable = new BlockPos.Mutable().set(operatingPos);

        for (int moveDown = 0; moveDown < downRange; moveDown++) {
            BlockState movingState = reader.getBlockState(mutable);
            if (SPREADABLE_TO_NON_SPREADABLE.containsKey(movingState.getBlock())) {
                reader.setBlock(mutable, SPREADABLE_TO_NON_SPREADABLE.get(movingState.getBlock()).defaultBlockState(), 2);
                break;
            } else {
                if (!FeatureUtil.isTerrainOrRock(reader, mutable)) {
                    reader.setBlock(mutable, config.getTrunkProvider().getState(random, mutable), 2);
                } else {
                    break;
                }
            }
            mutable.move(Direction.DOWN);
        }
    }

    public void setDisk(ISeedReader world, Random random, BlockPos pos, BYGTreeConfig config) {
        if (config.isPlacementForced() || config.getDiskRadius() <= 0)
            return;

        setSeed(world.getSeed());
        BlockPos.Mutable mutable = new BlockPos.Mutable().set(pos);

        int diskRadius = config.getDiskRadius();
        for (int x = -diskRadius; x <= diskRadius; x++) {
            for (int z = -diskRadius; z <= diskRadius; z++) {

                int squaredDistance = x * x + z * z;
                if (squaredDistance <= diskRadius * diskRadius) {

                    mutable.set(pos).move(x, 0, z);

                    //Roughen the radius of the disks a bit
                    double diskRoughnessNoise = fastNoise.GetNoise(mutable.getX() * 0.04F, mutable.getY() * 0.01F, mutable.getZ() * 0.04F);

                    if (squaredDistance > diskRadius * diskRadius * 0.8f && diskRoughnessNoise > -0.3D && diskRoughnessNoise < 0.3D)
                        continue;

                    if (FeatureUtil.isTerrainOrRock(world, mutable)) {
                        if (world.getBlockState(mutable.above()).isAir() || FeatureUtil.isPlant(world, mutable.above())) {
                            world.setBlock(mutable, config.getDiskProvider().getState(random, mutable), 2);
                        }
                    }
                }
            }
        }
    }

    public void setSeed(long seed) {
        if (this.seed != seed || fastNoise == null) {
            fastNoise = new FastNoise((int) seed);
            fastNoise.SetNoiseType(FastNoise.NoiseType.Simplex);
            this.seed = seed;
        }
    }


    public final void setFinalBlockState(BlockPos startPos, BYGTreeConfig config, Set<BlockPos> changedBlocks, IWorldWriter worldIn, BlockPos pos, BlockState blockState, MutableBoundingBox boundingBox) {
        this.setBlockStateWithoutUpdates(startPos, config, worldIn, pos, blockState);
        boundingBox.expand(new MutableBoundingBox(pos, pos));
        if (BlockTags.LOGS.contains(blockState.getBlock())) {
            changedBlocks.add(pos.immutable());
        }
    }

    public void setBlockStateWithoutUpdates(BlockPos startPos, BYGTreeConfig config, IWorldWriter worldWriter, BlockPos blockPos, BlockState blockState) {
        worldWriter.setBlock(blockPos, blockState, 18);
    }

    public void setBlockStateWithoutUpdates(BlockPos startPos, BYGTreeConfig config, IWorldWriter worldWriter, BlockPos blockPos, BlockState blockState, int flags) {
        worldWriter.setBlock(blockPos, blockState, flags);
    }

    @Override
    public boolean place(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, TFC config) {

        if (worldIn.getLevel().dimension() == World.OVERWORLD && !BYG.ENABLE_OVERWORLD_TREES) {
            return false;
        }

        Rotation rotation = Rotation.values()[rand.nextInt(Rotation.values().length)];
        Mirror mirror = Mirror.values()[rand.nextInt(Mirror.values().length)];
        config.setRotationAndMirror(rotation, mirror);

        return placeTree(worldIn, rand, pos, config);
    }

    public boolean placeTree(ISeedReader worldIn, Random rand, BlockPos pos, TFC config) {
        Set<BlockPos> set = Sets.newHashSet();
        MutableBoundingBox mutableboundingbox = MutableBoundingBox.getUnknownBox();
        boolean flag = this.generate(set, worldIn, rand, pos, mutableboundingbox, config.isPlacementForced(), config);
        if (mutableboundingbox.x0 > mutableboundingbox.x1) {
            return false;
        } else {
            List<Set<BlockPos>> list = Lists.newArrayList();

            for (int j = 0; j < 6; ++j) {
                list.add(Sets.newHashSet());
            }

            for (BlockPos blockPos : set) {
                if (blockPos.getY() == pos.getY()) {
                    boolean cliff = isCliff(worldIn, 9, blockPos);
                    if (!cliff && !FeatureUtil.isTerrainOrRock(worldIn, blockPos.below())) {
                        this.buildTrunk(worldIn, config, rand, blockPos, 10);
                    }
                }
            }

            VoxelShapePart voxelshapepart = new BitSetVoxelShapePart(mutableboundingbox.getXSpan(), mutableboundingbox.getYSpan(), mutableboundingbox.getZSpan());

            try (PooledMutable posInPool = PooledMutable.get()) {
                if (flag && !set.isEmpty()) {
                    for (BlockPos blockpos : Lists.newArrayList(set)) {
                        if (mutableboundingbox.isInside(blockpos)) {
                            voxelshapepart.setFull(blockpos.getX() - mutableboundingbox.x0, blockpos.getY() - mutableboundingbox.y0, blockpos.getZ() - mutableboundingbox.z0, true, true);
                        }

                        for (Direction direction : Direction.values()) {
                            posInPool.set(blockpos).move(direction);
                            if (!set.contains(posInPool)) {
                                BlockState blockstate = worldIn.getBlockState(posInPool);
                                if (blockstate.hasProperty(BlockStateProperties.DISTANCE)) {
                                    list.get(0).add(posInPool.immutable());
                                    this.setBlockStateWithoutUpdates(pos, config, worldIn, posInPool, blockstate.setValue(BlockStateProperties.DISTANCE, 1));
                                    if (mutableboundingbox.isInside(posInPool)) {
                                        voxelshapepart.setFull(posInPool.getX() - mutableboundingbox.x0, posInPool.getY() - mutableboundingbox.y0, posInPool.getZ() - mutableboundingbox.z0, true, true);
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
                        if (mutableboundingbox.isInside(blockpos1)) {
                            voxelshapepart.setFull(blockpos1.getX() - mutableboundingbox.x0, blockpos1.getY() - mutableboundingbox.y0, blockpos1.getZ() - mutableboundingbox.z0, true, true);
                        }

                        for (Direction direction1 : Direction.values()) {
                            posInPool.set(blockpos1).move(direction1);
                            if (!set1.contains(posInPool) && !set2.contains(posInPool)) {
                                BlockState blockstate1 = worldIn.getBlockState(posInPool);
                                if (blockstate1.hasProperty(BlockStateProperties.DISTANCE)) {
                                    int currentDistance = blockstate1.getValue(BlockStateProperties.DISTANCE);
                                    int newDistance = l + 1;
                                    if (currentDistance > newDistance) {
                                        BlockState blockstate2 = blockstate1.setValue(BlockStateProperties.DISTANCE, newDistance);

                                        if (newDistance >= 7)
                                            this.setBlockStateWithoutUpdates(pos, config, worldIn, posInPool, Blocks.AIR.defaultBlockState(), 2); //If leaves distance is or exceeds 7, set air
                                        else
                                            this.setBlockStateWithoutUpdates(pos, config, worldIn, posInPool, blockstate2);

                                        if (mutableboundingbox.isInside(posInPool)) {
                                            voxelshapepart.setFull(posInPool.getX() - mutableboundingbox.x0, posInPool.getY() - mutableboundingbox.y0, posInPool.getZ() - mutableboundingbox.z0, true, true);
                                        }

                                        set2.add(posInPool.immutable());
                                    }
                                }
                            }
                        }
                    }
                }
            }

            Template.updateShapeAtEdge(worldIn, 3, voxelshapepart, mutableboundingbox.x0, mutableboundingbox.y0, mutableboundingbox.z0);
            setDisk(worldIn, rand, pos.below(), config);
            return flag;
        }
    }

    protected abstract boolean generate(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, TFC config);

    @Nullable
    public SaplingData saplingData(BlockPos pos) {
        return new SaplingData(new HashSet<>(), 0);
    }


    static {
        SPREADABLE_TO_NON_SPREADABLE.put(Blocks.GRASS_BLOCK, Blocks.DIRT);
        SPREADABLE_TO_NON_SPREADABLE.put(Blocks.MYCELIUM, Blocks.DIRT);
        SPREADABLE_TO_NON_SPREADABLE.put(Blocks.GRASS_PATH, Blocks.DIRT);
        SPREADABLE_TO_NON_SPREADABLE.put(Blocks.PODZOL, Blocks.DIRT);
        SPREADABLE_TO_NON_SPREADABLE.put(BYGBlocks.OVERGROWN_DACITE, BYGBlocks.DACITE);
        SPREADABLE_TO_NON_SPREADABLE.put(BYGBlocks.PODZOL_DACITE, BYGBlocks.DACITE);
        SPREADABLE_TO_NON_SPREADABLE.put(BYGBlocks.OVERGROWN_STONE, Blocks.STONE);
        SPREADABLE_TO_NON_SPREADABLE.put(BYGBlocks.OVERGROWN_CRIMSON_BLACKSTONE, Blocks.BLACKSTONE);
        SPREADABLE_TO_NON_SPREADABLE.put(BYGBlocks.OVERGROWN_NETHERRACK, Blocks.NETHERRACK);
        SPREADABLE_TO_NON_SPREADABLE.put(BYGBlocks.SYTHIAN_NYLIUM, Blocks.NETHERRACK);
        SPREADABLE_TO_NON_SPREADABLE.put(BYGBlocks.EMBUR_NYLIUM, BYGBlocks.BLUE_NETHERRACK);
        SPREADABLE_TO_NON_SPREADABLE.put(BYGBlocks.IVIS_PHYLIUM, Blocks.END_STONE);
        SPREADABLE_TO_NON_SPREADABLE.put(BYGBlocks.NIGHTSHADE_PHYLIUM, Blocks.END_STONE);
        SPREADABLE_TO_NON_SPREADABLE.put(BYGBlocks.SHULKREN_PHYLIUM, Blocks.END_STONE);
        SPREADABLE_TO_NON_SPREADABLE.put(BYGBlocks.VERMILION_SCULK, BYGBlocks.ETHER_STONE);
        SPREADABLE_TO_NON_SPREADABLE.put(BYGBlocks.ETHER_PHYLIUM, BYGBlocks.ETHER_SOIL);
        SPREADABLE_TO_NON_SPREADABLE.put(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.MEADOW_DIRT);
        SPREADABLE_TO_NON_SPREADABLE.put(BYGBlocks.MEADOW_GRASS_PATH, BYGBlocks.MEADOW_DIRT);
        SPREADABLE_TO_NON_SPREADABLE.put(BYGBlocks.GLOWCELIUM, Blocks.DIRT);
        SPREADABLE_TO_NON_SPREADABLE.put(BYGBlocks.MYCELIUM_NETHERRACK, Blocks.NETHERRACK);
    }

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

        public PooledMutable set(Vector3i vec3i) {
            return (PooledMutable) super.set(vec3i);
        }

        public PooledMutable setOffset(Direction direction) {
            return this.setOffset(direction, 1);
        }

        public PooledMutable setOffset(Direction direction, int distance) {
            return this.set(this.getX() + direction.getStepX() * distance, this.getY() + direction.getStepY() * distance, this.getZ() + direction.getStepZ() * distance);
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