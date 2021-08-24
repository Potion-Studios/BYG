package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.util.MLBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BYGSnowyPlants extends BushBlock {
    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);

    protected BYGSnowyPlants(Properties builder) {
        super(builder);

    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        Vec3 vector3d = state.getOffset(worldIn, pos);
        return SHAPE.move(vector3d.x, vector3d.y, vector3d.z);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
        Block block = state.getBlock();
        return block == Blocks.SNOW_BLOCK || is(MLBlockTags.DIRT);
    }
}
