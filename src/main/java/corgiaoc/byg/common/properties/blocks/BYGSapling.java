package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.common.world.feature.overworld.trees.util.TreeSpawner;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class BYGSapling extends SaplingBlock {
    private final ITag<Block> groundTag;
    private final TreeSpawner tree;

    public BYGSapling(Properties properties, ITag<Block> groundTag, TreeSpawner tree) {
        super(null, properties);
        this.groundTag = groundTag;
        this.tree = tree;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return this == BYGBlocks.PALM_SAPLING ? state.is(BlockTags.SAND) && state.is(this.groundTag) : state.is(this.groundTag);
    }

    @Override
    public void advanceTree(ServerWorld world, BlockPos pos, BlockState state, Random rand) {
        if (state.getValue(STAGE) == 0) {
            world.setBlock(pos, state.cycle(STAGE), 4);
        } else {
            this.tree.spawn(world, world.getChunkSource().getGenerator(), pos, state, rand);
        }
    }
}