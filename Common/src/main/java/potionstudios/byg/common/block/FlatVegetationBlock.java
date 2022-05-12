package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class FlatVegetationBlock extends BushBlock {
    protected static final VoxelShape VOXEL_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 1.5D, 15.0D);
    @Nullable
    private final TagKey<Block> blockTagKey;

    protected FlatVegetationBlock(Properties builder) {
        this(builder, null);
    }

    protected FlatVegetationBlock(Properties builder, @Nullable TagKey<Block> blockTagKey) {
        super(builder);
        this.blockTagKey = blockTagKey;
    }

    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos blockPos, CollisionContext context) {
        return VOXEL_SHAPE;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return Block.isFaceFull(state.getCollisionShape(level, pos), Direction.UP) || (blockTagKey != null && state.is(this.blockTagKey));
    }
}
