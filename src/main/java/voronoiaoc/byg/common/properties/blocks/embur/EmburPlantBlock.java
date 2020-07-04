package voronoiaoc.byg.common.properties.blocks.embur;

import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import voronoiaoc.byg.core.byglists.BYGBlockList;

public class EmburPlantBlock extends PlantBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);

    protected EmburPlantBlock(AbstractBlock.Settings builder) {
        super(builder);

    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Vec3d yes = state.getModelOffset(world, pos);
        return SHAPE.offset(yes.x, yes.y, yes.z);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        Block block = floor.getBlock();
        return block == BYGBlockList.SYTHIAN_NYLIUM || block == Blocks.NETHERRACK || block == BYGBlockList.OVERGROWN_NETHERRACK || block == BYGBlockList.EMBUR_NYLIUM || block == BYGBlockList.BLUE_NETHERRACK;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return this.canPlantOnTop(world.getBlockState(pos.down()), world, pos.down());
    }
}

