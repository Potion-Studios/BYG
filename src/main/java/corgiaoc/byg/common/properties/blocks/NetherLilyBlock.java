package corgiaoc.byg.common.properties.blocks;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class NetherLilyBlock extends LilyPadBlock {

    protected NetherLilyBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean isValidGround(BlockState state, IBlockReader reader, BlockPos p_200014_3_) {
        FluidState fluidState = reader.getFluidState(p_200014_3_);
        return fluidState.getFluid() == Fluids.LAVA || fluidState.getFluid() == Fluids.WATER;
    }
}
