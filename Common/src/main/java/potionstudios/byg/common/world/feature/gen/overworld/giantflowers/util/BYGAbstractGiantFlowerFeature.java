package potionstudios.byg.common.world.feature.gen.overworld.giantflowers.util;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.LevelWriter;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.material.Material;
import potionstudios.byg.common.world.feature.config.GiantFlowerConfig;
import potionstudios.byg.common.world.feature.gen.FeatureGenUtil;

import java.util.Random;

public abstract class BYGAbstractGiantFlowerFeature<T extends GiantFlowerConfig> extends Feature<T> {

    public BYGAbstractGiantFlowerFeature(Codec<T> configCodec) {
        super(configCodec);
    }

    public static boolean canStemPlaceHere(LevelSimulatedReader worldReader, BlockPos blockPos) {
        return worldReader.isStateAtPosition(blockPos, BlockBehaviour.BlockStateBase::isAir) || FeatureGenUtil.isPlant(worldReader, blockPos);
    }

    public boolean isAnotherFlowerHere(LevelSimulatedReader worldReader, BlockPos blockPos) {
        return worldReader.isStateAtPosition(blockPos, (state) -> {
            return state.is(BlockTags.LOGS) || state.is(BlockTags.LEAVES);
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
            return state.is(BlockTags.LOGS) || state.is(BlockTags.LEAVES) || state.isAir() || state.getMaterial() == Material.PLANT || state.getMaterial() == Material.REPLACEABLE_PLANT || state.getMaterial() == Material.WATER_PLANT || state.getMaterial() == Material.LEAVES || state.getMaterial() == Material.DIRT;
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
                return state.is(BlockTags.DIRT) || block == block1;
            }
            return state.is(BlockTags.DIRT);
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
    public boolean place(FeaturePlaceContext<T> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }

    public boolean place(WorldGenLevel worldIn, ChunkGenerator generator, Random rand, BlockPos pos, T config) {
        return placeFlower(worldIn, rand, pos, config.isPlacementForced(), config);
    }

    protected abstract boolean placeFlower(WorldGenLevel worldIn, Random rand, BlockPos pos, boolean isFlower, T config);

}