package corgiaoc.byg.common.properties.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class BYGLeafPileBlock extends BushBlock {
    protected static final VoxelShape LEAF_PILE = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 1.5D, 15.0D);

    protected BYGLeafPileBlock(Properties p_i48297_1_) {
        super(p_i48297_1_);
    }

    public void onEntityCollision(BlockState state, World world, BlockPos blockPos, Entity entity) {
        super.onEntityCollision(state, world, blockPos, entity);
        if (world instanceof ServerWorld && entity instanceof BoatEntity) {
            world.destroyBlock(new BlockPos(blockPos), true, entity);
        }

    }

    public VoxelShape getShape(BlockState state, IBlockReader p_220053_2_, BlockPos blockPos, ISelectionContext p_220053_4_) {
        return LEAF_PILE;
    }

    @Override
    protected boolean isValidGround(BlockState state, IBlockReader p_200014_2_, BlockPos blockPos) {
        return state.getMaterial() == Material.EARTH;
    }
}
