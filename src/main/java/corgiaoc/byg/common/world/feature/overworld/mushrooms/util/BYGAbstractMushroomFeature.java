package corgiaoc.byg.common.world.feature.overworld.mushrooms.util;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.FeatureUtil;
import corgiaoc.byg.common.world.feature.config.BYGMushroomConfig;
import corgiaoc.byg.util.MLBlockTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorldWriter;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public abstract class BYGAbstractMushroomFeature<T extends BYGMushroomConfig> extends Feature<T> {

    public BYGAbstractMushroomFeature(Codec<T> configCodec) {
        super(configCodec);
    }

    public static boolean canStemPlaceHere(IWorldGenerationBaseReader worldReader, BlockPos blockPos) {
        return worldReader.isStateAtPosition(blockPos, AbstractBlock.AbstractBlockState::isAir) || FeatureUtil.isPlant(worldReader, blockPos);
    }

    public boolean canStemPlaceHereWater(IWorldGenerationBaseReader worldReader, BlockPos blockPos) {
        return worldReader.isStateAtPosition(blockPos, (state) -> state.isAir() || state.getMaterial() == Material.WATER) || FeatureUtil.isPlant(worldReader, blockPos);
    }

    public boolean isAnotherMushroomHere(IWorldGenerationBaseReader worldReader, BlockPos blockPos) {
        return worldReader.isStateAtPosition(blockPos, (state) -> {
            Block block = state.getBlock();
            return block.is(BlockTags.LOGS) || block.is(BlockTags.LEAVES);
        });
    }

    public boolean isAnotherMushroomLikeThisHere(IWorldGenerationBaseReader worldReader, BlockPos blockPos, Block logBlock, Block leafBlock) {
        return worldReader.isStateAtPosition(blockPos, (state) -> {
            Block block = state.getBlock();
            return block == logBlock || block == leafBlock;
        });
    }

    public void placeStem(BlockState stemBlockState, ISeedReader reader, BlockPos pos) {
        if (canStemPlaceHere(reader, pos)) {
            this.setFinalBlockState(reader, pos, stemBlockState);
        }
    }

    public void placeStemBranch(BlockState stemBlockState, ISeedReader reader, BlockPos pos) {
        if (canStemPlaceHere(reader, pos)) {
            this.setFinalBlockState(reader, pos, stemBlockState);
        }
    }

    public void placeMushroom(BlockState mushroomBlockState, ISeedReader reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, mushroomBlockState);
        }
    }

    public void placeMushroom2(BlockState mushroomBlockState, ISeedReader reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, mushroomBlockState);
        }
    }

    public void placeMushroom3(BlockState mushroomBlockState, ISeedReader reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, mushroomBlockState);
        }
    }


    public void placePollen(BlockState pollenBlockState, ISeedReader reader, BlockPos pos) {
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
    public boolean canGiantMushroomGrowHere(IWorldGenerationBaseReader reader, BlockPos pos) {
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
     * @param reader             Gives us access to world.
     * @param pos                Position to check.
     * @param desiredGroundBlock Allows to add other blocks that do not have the dirt tag.
     * @return Determines if the pos is of the dirt tag or another block.
     */
    public static boolean isDesiredGroundwDirtTag(BYGMushroomConfig config, IWorldGenerationBaseReader reader, BlockPos pos, Block... desiredGroundBlock) {
        if (config.isPlacementForced())
            return true;

        return reader.isStateAtPosition(pos, (state) -> {
            Block block = state.getBlock();
            for (Block block1 : desiredGroundBlock) {
                return block.is(MLBlockTags.DIRT) || block == block1;
            }
            return block.is(MLBlockTags.DIRT);
        });
    }

    public static boolean isDesiredGroundwEndTags(BYGMushroomConfig config, IWorldGenerationBaseReader reader, BlockPos pos, Block... desiredGroundBlock) {
        if (config.isPlacementForced())
            return true;

        return reader.isStateAtPosition(pos, (state) -> {
            Block block = state.getBlock();
            for (Block block1 : desiredGroundBlock) {
                return block.is(MLBlockTags.END_STONES) || block == block1;
            }
            return block.is(MLBlockTags.END_STONES);
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

    public boolean doesMushroomHaveSpaceToGrow(IWorldGenerationBaseReader reader, BlockPos pos, int treeHeight, int canopyStartHeight, int xDistance, int zDistance, boolean isSapling, BlockPos... trunkPositions) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        //Skip if this is not a sapling.
        if (isSapling) {
            //Check the tree trunk and determine whether or not there's a block in the way.
            for (int yOffSet = 0; yOffSet <= treeHeight; yOffSet++) {
                if (!canGiantMushroomGrowHere(reader, mutable.set(x, y + yOffSet, z))) {
                    return false;
                }
                //If the list of trunk poss(other than the center trunk) is greater than 0, we check each of these trunk poss from the bottom to the tree height.
                if (trunkPositions.length > 0) {
                    for (BlockPos trunkPos : trunkPositions) {
                        if (!canGiantMushroomGrowHere(reader, mutable.set(trunkPos.getX(), trunkPos.getY() + yOffSet, trunkPos.getZ()))) {
                            return false;
                        }
                    }
                }
            }
            //We use canopyStartHeight instead of 0 because we want to check the area only in the canopy's area and not around the trunk. This makes our saplings much smarter and easier to grow.
            for (int yOffset = canopyStartHeight; yOffset <= treeHeight + 1; ++yOffset) {
                for (int xOffset = -xDistance; xOffset <= xDistance; ++xOffset) {
                    for (int zOffset = -zDistance; zOffset <= zDistance; ++zOffset) {
                        if (!canGiantMushroomGrowHere(reader, mutable.set(x + xOffset, y + yOffset, z + zOffset))) {
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

    public boolean doesMushroomHaveSpaceToGrow(IWorldGenerationBaseReader reader, BlockPos pos, int treeHeight, int canopyStartHeight, int xNegativeDistance, int zNegativeDistance, int xPositiveDistance, int zPositiveDistance, boolean isSapling, BlockPos... trunkPositions) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        //Skip if tree is being called during world gen.
        if (isSapling) {

            //Check the tree trunk and determine whether or not there's a block in the way.
            for (int yOffSet = 0; yOffSet <= treeHeight; yOffSet++) {
                if (!canGiantMushroomGrowHere(reader, mutable.set(x, y + yOffSet, z))) {
                    return false;
                }

                //If the list of trunk poss(other than the center trunk) is greater than 0, we check each of these trunk poss from the bottom to the tree height.
                if (trunkPositions.length > 0) {
                    for (BlockPos trunkPos : trunkPositions) {
                        if (!canGiantMushroomGrowHere(reader, mutable.set(trunkPos.getX(), trunkPos.getY() + yOffSet, trunkPos.getZ()))) {
                            return false;
                        }
                    }
                }
            }

            //We use canopyStartHeight instead of 0 because we want to check the area only in the canopy's area and not around the trunk. This makes our saplings much smarter and easier to grow.
            for (int yOffset = canopyStartHeight; yOffset <= treeHeight + 1; ++yOffset) {
                for (int xOffset = -xNegativeDistance; xOffset <= xPositiveDistance; ++xOffset) {
                    for (int zOffset = -zNegativeDistance; zOffset <= zPositiveDistance; ++zOffset) {
                        if (!canGiantMushroomGrowHere(reader, mutable.set(x + xOffset, y + yOffset, z + zOffset))) {
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
     * @param reader        Gives us access to world
     * @param pos           The given pos of either the feature during world gen or the sapling.
     * @param treeHeight    The height of the given tree.
     * @param distance      Checks the surrounding pos
     * @param stemBlock     The log block we're checking for.
     * @param mushroomBlock The leaf block we're checking for.
     * @param isMushroom    Boolean passed in to determine whether or not the tree is being generated during world gen or with a sapling.
     * @return Determines whether or not the tree we're searching for is within the given distance.
     */

    public boolean isAnotherMushroomLikeThisNearby(IWorldGenerationBaseReader reader, BlockPos pos, int treeHeight, int distance, Block stemBlock, Block mushroomBlock, boolean isMushroom) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        //Skip if mushroom is being spawned with a small mushroom/fungus.
        if (!isMushroom) {
            for (int yOffset = 0; yOffset <= treeHeight + 1; ++yOffset) {
                for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
                    for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
                        if (isAnotherMushroomLikeThisHere(reader, mutable.set(x + xOffset, y + yOffset, z + zOffset), stemBlock, mushroomBlock)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public final void setFinalBlockState(IWorldWriter worldIn, BlockPos pos, BlockState blockState) {
        this.setBlockStateWithoutUpdates(worldIn, pos, blockState);
    }

    public void setBlockStateWithoutUpdates(IWorldWriter worldWriter, BlockPos blockPos, BlockState blockState) {
        worldWriter.setBlock(blockPos, blockState, 2);
    }

    @Override
    protected void setBlock(IWorldWriter worldIn, BlockPos pos, BlockState state) {
        this.setBlockStateWithoutUpdates(worldIn, pos, state);
    }

    @Override
    public boolean place(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, T config) {
        return placeMushroom(worldIn, rand, pos, config.isPlacementForced(), config);
    }

    protected abstract boolean placeMushroom(ISeedReader worldIn, Random rand, BlockPos pos, boolean isMushroom, T config);
}

