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
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class FlatVegetationBlock extends BushBlock {
    protected static final VoxelShape VOXEL_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1D, 16.0D);
    @Nullable
    private final TagKey<Block> blockTagKey;

    protected FlatVegetationBlock(Properties builder) {
        this(builder, null);
    }

    protected FlatVegetationBlock(Properties builder, @Nullable TagKey<Block> blockTagKey) {
        super(builder);
        this.blockTagKey = blockTagKey;
    }

    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter worldIn, @NotNull BlockPos blockPos, @NotNull CollisionContext context) {
        return VOXEL_SHAPE;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
        return Block.isFaceFull(state.getCollisionShape(level, pos), Direction.UP) || (blockTagKey != null && state.is(this.blockTagKey));
    }
}
