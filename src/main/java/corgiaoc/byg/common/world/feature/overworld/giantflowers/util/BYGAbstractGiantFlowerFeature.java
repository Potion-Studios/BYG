package corgiaoc.byg.common.world.feature.overworld.giantflowers.util;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.FeatureUtil;
import corgiaoc.byg.common.world.feature.config.GiantFlowerConfig;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.util.MLBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.LevelWriter;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.material.Material;

import java.util.Random;

public abstract class BYGAbstractGiantFlowerFeature<T extends GiantFlowerConfig> extends Feature<T> {

    public BYGAbstractGiantFlowerFeature(Codec<T> configCodec) {
        super(configCodec);
    }

    public static boolean canStemPlaceHere(LevelSimulatedReader worldReader, BlockPos blockPos) {
        return worldReader.isStateAtPosition(blockPos, BlockBehaviour.BlockStateBase::isAir) || FeatureUtil.isPlant(worldReader, blockPos);
    }

    public boolean canStemPlaceHereWater(LevelSimulatedReader worldReader, BlockPos blockPos) {
        return worldReader.isStateAtPosition(blockPos, (state) -> state.isAir() || state.getMaterial() == Material.WATER) || FeatureUtil.isPlant(worldReader, blockPos);
    }

    public boolean isAnotherFlowerHere(LevelSimulatedReader worldReader, BlockPos blockPos) {
        return worldReader.isStateAtPosition(blockPos, (state) -> {
            Block block = state.getBlock();
            return block.is(BlockTags.LOGS) || block.is(BlockTags.LEAVES);
        });
    }

    public boolean isAnotherFlowerLikeThisHere(LevelSimulatedReader worldReader, BlockPos blockPos, Block logBlock, Block leafBlock) {
        return worldReader.isStateAtPosition(blockPos, (state) -> {
            Block block = state.getBlock();
            return block == logBlock || block == leafBlock;
        });
    }

    public void placeStem(BlockState stemBlockState, WorldGenLevel reader, BlockPos pos) {
        if (canStemPlaceHere(reader, pos)) {
            this.setFinalBlockState(reader, pos, stemBlockState);
        }
    }

    public void placeStemBranch(BlockState stemBlockState, WorldGenLevel reader, BlockPos pos) {
        if (canStemPlaceHere(reader, pos)) {
            this.setFinalBlockState(reader, pos, stemBlockState);
        }
    }

    public void placePetal(BlockState petalBlockState, WorldGenLevel reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, petalBlockState);
        }
    }

    public void placePetal2(BlockState petalBlockState, WorldGenLevel reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, petalBlockState);
        }
    }

    public void placePetal3(BlockState petalBlockState, WorldGenLevel reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, petalBlockState);
        }
    }


    public void placePollen(BlockState pollenBlockState, WorldGenLevel reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, pollenBlockState);
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
    public boolean canGiantFlowerGrowHere(LevelSimulatedReader reader, BlockPos pos) {
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

    public static boolean isAir(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, BlockState::isAir);
    }

    public boolean isAirOrWater(LevelSimulatedReader worldIn, BlockPos pos) {
        return worldIn.isStateAtPosition(pos, (state) -> state.isAir() || state.getBlock() == Blocks.WATER);
    }

    /**
     * @param reader             Gives us access to world.
     * @param pos                Position to check.
     * @param desiredGroundBlock Allows to add other blocks that do not have the dirt tag.
     * @return Determines if the pos is of the dirt tag or another block.
     */
    public static boolean isDesiredGroundwDirtTag(LevelSimulatedReader reader, BlockPos pos, Block... desiredGroundBlock) {
        return reader.isStateAtPosition(pos, (state) -> {
            Block block = state.getBlock();
            for (Block block1 : desiredGroundBlock) {
                return block.is(MLBlockTags.DIRT) || block == block1;
            }
            return block.is(MLBlockTags.DIRT);
        });
    }

    /**
     * @param reader             Gives us access to world.
     * @param pos                Position to check.
     * @param desiredGroundBlock Add a blacklist of blocks that we want.
     * @return Determines if the pos contains a block from our whitelist.
     */
    public boolean isDesiredGround(LevelSimulatedReader reader, BlockPos pos, Block... desiredGroundBlock) {
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

    public boolean doesFlowerHaveSpaceToGrow(LevelSimulatedReader reader, BlockPos pos, int treeHeight, int canopyStartHeight, int xDistance, int zDistance, boolean isSapling, BlockPos... trunkPositions) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        //Skip if this is not a sapling.
        if (isSapling) {
            //Check the tree trunk and determine whether or not there's a block in the way.
            for (int yOffSet = 0; yOffSet <= treeHeight; yOffSet++) {
                if (!canGiantFlowerGrowHere(reader, mutable.set(x, y + yOffSet, z))) {
                    return false;
                }
                //If the list of trunk poss(other than the center trunk) is greater than 0, we check each of these trunk poss from the bottom to the tree height.
                if (trunkPositions.length > 0) {
                    for (BlockPos trunkPos : trunkPositions) {
                        if (!canGiantFlowerGrowHere(reader, mutable.set(trunkPos.getX(), trunkPos.getY() + yOffSet, trunkPos.getZ()))) {
                            return false;
                        }
                    }
                }
            }
            //We use canopyStartHeight instead of 0 because we want to check the area only in the canopy's area and not around the trunk. This makes our saplings much smarter and easier to grow.
            for (int yOffset = canopyStartHeight; yOffset <= treeHeight + 1; ++yOffset) {
                for (int xOffset = -xDistance; xOffset <= xDistance; ++xOffset) {
                    for (int zOffset = -zDistance; zOffset <= zDistance; ++zOffset) {
                        if (!canGiantFlowerGrowHere(reader, mutable.set(x + xOffset, y + yOffset, z + zOffset))) {
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

    public boolean doesFlowerHaveSpaceToGrow(LevelSimulatedReader reader, BlockPos pos, int treeHeight, int canopyStartHeight, int xNegativeDistance, int zNegativeDistance, int xPositiveDistance, int zPositiveDistance, boolean isSapling, BlockPos... trunkPositions) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

        //Skip if tree is being called during world gen.
        if (isSapling) {

            //Check the tree trunk and determine whether or not there's a block in the way.
            for (int yOffSet = 0; yOffSet <= treeHeight; yOffSet++) {
                if (!canGiantFlowerGrowHere(reader, mutable.set(x, y + yOffSet, z))) {
                    return false;
                }

                //If the list of trunk poss(other than the center trunk) is greater than 0, we check each of these trunk poss from the bottom to the tree height.
                if (trunkPositions.length > 0) {
                    for (BlockPos trunkPos : trunkPositions) {
                        if (!canGiantFlowerGrowHere(reader, mutable.set(trunkPos.getX(), trunkPos.getY() + yOffSet, trunkPos.getZ()))) {
                            return false;
                        }
                    }
                }
            }

            //We use canopyStartHeight instead of 0 because we want to check the area only in the canopy's area and not around the trunk. This makes our saplings much smarter and easier to grow.
            for (int yOffset = canopyStartHeight; yOffset <= treeHeight + 1; ++yOffset) {
                for (int xOffset = -xNegativeDistance; xOffset <= xPositiveDistance; ++xOffset) {
                    for (int zOffset = -zNegativeDistance; zOffset <= zPositiveDistance; ++zOffset) {
                        if (!canGiantFlowerGrowHere(reader, mutable.set(x + xOffset, y + yOffset, z + zOffset))) {
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
    public boolean isAnotherFlowerNearby(LevelSimulatedReader reader, BlockPos pos, int treeHeight, int distance, boolean isSapling) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

        //Skip if tree is being spawned with a sapling.
        if (!isSapling) {
            for (int yOffset = 0; yOffset <= treeHeight + 1; ++yOffset) {
                for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
                    for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
                        if (isAnotherFlowerHere(reader, mutable.set(x + xOffset, y + yOffset, z + zOffset))) {
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

    public boolean isAnotherFlowerLikeThisNearby(LevelSimulatedReader reader, BlockPos pos, int treeHeight, int distance, Block logBlock, Block leafBlock, boolean isSapling) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

        //Skip if tree is being spawned with a sapling.
        if (!isSapling) {
            for (int yOffset = 0; yOffset <= treeHeight + 1; ++yOffset) {
                for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
                    for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
                        if (!isAnotherFlowerLikeThisHere(reader, mutable.set(x + xOffset, y + yOffset, z + zOffset), logBlock, leafBlock)) {
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
     * @param reader         Gives us access to world
     * @param fillerBlock    Typically this is the log of the tree we're trying to fill the base of.
     * @param earthBlock     The block used under logs. Typically a block found in the dirt tag
     * @param trunkPositions List of trunk poss where the base is built under the given poss.
     */

    public void buildStem(LevelSimulatedReader reader, Block fillerBlock, Block earthBlock, BlockPos... trunkPositions) {
        if (trunkPositions.length > 0) {
            BlockPos.MutableBlockPos mutableTrunk = new BlockPos.MutableBlockPos();
            for (BlockPos trunkPos : trunkPositions) {
                mutableTrunk.set(trunkPos);
                for (int fill = 1; fill <= 15; fill++) {
                    if (canStemPlaceHere(reader, mutableTrunk)) {
                        if (fill <= 7)
                            setFinalBlockState((LevelWriter) reader, mutableTrunk, fillerBlock.defaultBlockState());
                        else
                            setFinalBlockState((LevelWriter) reader, mutableTrunk, earthBlock.defaultBlockState());
                    } else {
                        if (isDesiredGround(reader, mutableTrunk, Blocks.PODZOL, Blocks.MYCELIUM, BYGBlocks.PODZOL_DACITE, BYGBlocks.OVERGROWN_STONE, BYGBlocks.GLOWCELIUM))
                            setFinalBlockState((LevelWriter) reader, mutableTrunk, earthBlock.defaultBlockState());
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
     * @param reader              Gives us access to world
     * @param earthBlockThreshold Used to specify when earthBlock starts placing.
     * @param fillerBlock         Typically this is the log of the tree we're trying to fill the base of.
     * @param earthBlock          The block used under logs. Typically a block found in the dirt tag
     * @param trunkPositions      List of trunk poss where the base is built under the given poss.
     */
    public void buildBase(LevelSimulatedReader reader, int earthBlockThreshold, Block fillerBlock, Block earthBlock, BlockPos... trunkPositions) {
        if (trunkPositions.length > 0) {
            BlockPos.MutableBlockPos mutableTrunk = new BlockPos.MutableBlockPos();
            for (BlockPos trunkPos : trunkPositions) {
                mutableTrunk.set(trunkPos);
                for (int fill = 1; fill <= 15; fill++) {
                    if (canStemPlaceHere(reader, mutableTrunk)) {
                        if (fill <= earthBlockThreshold)
                            setFinalBlockState((LevelWriter) reader, mutableTrunk, fillerBlock.defaultBlockState());
                        else
                            setFinalBlockState((LevelWriter) reader, mutableTrunk, earthBlock.defaultBlockState());
                    } else {
                        if (canStemPlaceHere(reader, mutableTrunk)) {
                            setFinalBlockState((LevelWriter) reader, mutableTrunk, fillerBlock.defaultBlockState());
                        } else {
                            if (isDesiredGround(reader, mutableTrunk, Blocks.PODZOL, Blocks.MYCELIUM, BYGBlocks.PODZOL_DACITE, BYGBlocks.OVERGROWN_STONE, BYGBlocks.GLOWCELIUM))
                                setFinalBlockState((LevelWriter) reader, mutableTrunk, earthBlock.defaultBlockState());
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

    public void setSoil(LevelSimulatedReader reader, Block soil, BlockPos... trunkPositions) {
        if (trunkPositions.length > 0) {
            BlockPos.MutableBlockPos mutableTrunk = new BlockPos.MutableBlockPos();
            for (BlockPos trunkPos : trunkPositions) {
                mutableTrunk.set(trunkPos);
                if (isDesiredGround(reader, mutableTrunk, Blocks.PODZOL, Blocks.MYCELIUM, BYGBlocks.PODZOL_DACITE, BYGBlocks.OVERGROWN_STONE, BYGBlocks.GLOWCELIUM))
                    setFinalBlockState((LevelWriter) reader, mutableTrunk.move(Direction.DOWN), soil.defaultBlockState());
            }
        }
    }

    public final void setFinalBlockState(LevelWriter worldIn, BlockPos pos, BlockState blockState) {
        this.setBlockStateWithoutUpdates(worldIn, pos, blockState);
    }

    public void setBlockStateWithoutUpdates(LevelWriter worldWriter, BlockPos blockPos, BlockState blockState) {
        worldWriter.setBlock(blockPos, blockState, 2);
    }

    @Override
    protected void setBlock(LevelWriter worldIn, BlockPos pos, BlockState state) {
        this.setBlockStateWithoutUpdates(worldIn, pos, state);
    }

    @Override
    public boolean place(WorldGenLevel worldIn, ChunkGenerator generator, Random rand, BlockPos pos, T config) {
        return placeFlower(worldIn, rand, pos, config.isPlacementForced(), config);
    }

    protected abstract boolean placeFlower(WorldGenLevel worldIn, Random rand, BlockPos pos, boolean isFlower, T config);

}