package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.util.MLBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BYGFairySlipperBlock extends BushBlock {
    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);

    public BYGFairySlipperBlock(Properties properties) {
        super(properties);
    }

    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
        Vec3 Vector3d = state.getOffset(reader, pos);
        return SHAPE.move(Vector3d.x, Vector3d.y, Vector3d.z);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return state.getBlock().is(BlockTags.LOGS) || state.getBlock().is(MLBlockTags.DIRT);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        BlockPos posDown = pos.below();
        return this.mayPlaceOn(worldIn.getBlockState(posDown), worldIn, posDown);
    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

}